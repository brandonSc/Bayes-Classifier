package probability

import graphtheory._
import scala.collection.mutable.ArrayBuffer;

object dependenceSolver
{
    def estimateGraph ( samples: Array[Array[Double]] ): Graph =  {

        var edgeset: ArrayBuffer[Edge] = new ArrayBuffer[Edge]()

        /* estimate probabilities of each feature */
       for ( i <- 0 until samples(0).length ) { 
           for ( j <- i+1 until samples(0).length ) { 

               var infogain: Double = 0;

               for ( x <- 0 to 1 ) { 
                   for ( y <- 0 to 1 ) { 

                       val probVi = propEqualTo(x,i,samples)
                       val probVj = propEqualTo(y,j,samples)
                       val probViVj = propEqualTo(x,i,y,j,samples)

                       try { 
                           val d:Double = samples.length.toDouble; 

                           var gain: Double 
                           = (probViVj) / (probVi * probVj);

                           gain = Math.log(gain);
                           gain = gain * probViVj;

                           infogain += gain;

                       } catch {
                           case e: Exception => println(e);
                       } 
                   }
               }   

               if ( infogain.isNaN ) infogain = 0

               edgeset += (new Edge(
                   new String(""+(i+1)), 
                   new String(""+(j+1)), 
                   infogain))
           }
       }

       return new Graph(edgeset)
    }

    def propEqualTo( x: Int, i: Int, samples: Array[Array[Double]] ):
    Double = {
        var count: Double = 0;
        for ( j <- 0 until samples.length ) { 
            if ( samples(j)(i) == x ) 
                count += 1;
        }
        return (count / samples.length.toDouble)
    }

    def propEqualTo ( x:Int, i:Int, y:Int, j:Int, samples:Array[Array[Double]] ): Double = {
        var count: Double = 0 ;
        for ( k <- 0 until samples.length ) { 
            if ( samples(k)(i) == x 
                && samples(k)(j) == y ) { 
                    count += 1;
                }
        }
        return (count / samples.length.toDouble)
    }

    def estimateProbVector ( tree: Graph, samples: Array[Array[Double]] ):
    Array[Array[Double]] = {

        def noneLeft ( list: Array[Array[Double]] ): Boolean = { 
            for ( i <- 0 until list.length ) {
                if ( list(i)(2) == -1 ) 
                    return false;
            }
            return true;
        }

        var probVector = Array.ofDim[Double](samples(0).length, 3);
        probVector.foreach { _(2) = -1 } 

        var edgeset = tree.E ;

        var edge: Edge = edgeset(0);
        var root: Int = (edge.v1.toInt)-1
        probVector(root)(0) = propEqualTo(1,root,samples)
        probVector(root)(1) = 1 - probVector(root)(0)
        probVector(root)(2) = 0;

        while ( !noneLeft(probVector) ) {
            for ( i <- 0 until edgeset.length ) { 
                var va: Int = edgeset(i).v1.toInt-1
                var vb: Int = edgeset(i).v2.toInt-1
                if ( probVector(va)(2) == -1 ) {
                    if ( probVector(vb)(2) != -1 ) {
                        //probVector(va)(0) = propEqualTo(0, va, samples)
                        //probVector(va)(1) = propEqualTo(1, va, samples)
                        var prB: Double = propEqualTo(1,vb,samples)
                        probVector(va)(0) = (propEqualTo(
                            1, va,
                            1, vb,
                            samples) / prB)
                        prB = 1 - prB
                        probVector(va)(1) = (propEqualTo(
                            1,va,
                            0,vb,
                            samples) / prB)
                        probVector(va)(2) = vb+1;
                    }
                }
                if ( probVector(vb)(2) == -1 ) {
                    if ( probVector(va)(2) != -1 ) {
                       // probVector(vb)(0) = propEqualTo(0, vb, samples)
                       // probVector(vb)(1) = propEqualTo(1, vb, samples)
                        var prB: Double = propEqualTo(1,vb,samples)
                        probVector(vb)(0) = (propEqualTo(
                            1, vb, 
                            1, va,
                            samples) / prB)
                        prB = 1 - prB;
                        probVector(vb)(1) = (propEqualTo(
                            1, vb,
                            0, va,
                            samples) / prB)
                        probVector(vb)(2) = va+1;
                    }
                }
            }
        }
        return probVector
    }

    def classify ( classes: Array[Array[Array[Double]]], x: Array[Double] ):
    Array[Array[Double]] = { 
        var sum: Double = 1;
        var max: Double = 0;
        var maxClass: Array[Array[Double]] = classes(0)

        classes.foreach { _class =>
            
            for ( i <- 0 until Math.min(_class.length,x.length) ) { 
                
                if ( _class(i)(2) == 0 ) {
                    if ( x(i) == 1 ) 
                        sum *= _class(i)(x(i).toInt); 
                } else {
                    var p: Int = x(_class(i)(2).toInt - 1).toInt // 1 or 0
                    if ( x(i) == 1 ) 
                        sum *= _class(i)(x(p).toInt)
                }
            }

            max = Math.max(sum, max)

            if ( max == sum ) 
                maxClass = _class

            sum = 1;
        }
        return maxClass;
    }
}
