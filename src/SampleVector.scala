package probability

import util.Random

object SampleVector
{
    def generateDep ( vector: Array[Array[Double]] ): Array[Double] = {
        val sample: Array[Double] = new Array[Double](vector.length)
        for ( i <- 0 until vector.length ) sample(i) = -1;
        
        // set the root value first
        for ( i <- 0 until vector.length ) { 
            val x: Int = vector(i)(2).toInt;
            if ( x == 0 ) { 
                val r: Double = new Random().nextDouble
                if ( r < vector(i)(0) ) 
                    sample(i) = 1
                else 
                    sample(i) = 0
            }
        }

        def noneLeft ( list: Array[Double] ): Boolean = { 
            for ( i <- 0 until list.length ) {
                if ( list(i) == -1 ) 
                    return false;
            }
            return true;
        }

        while ( !noneLeft(sample) ) { 

            for ( i <- 0 until vector.length ) { 
                var x: Int = vector(i)(2).toInt
                if ( x > 0 ) {
                    if ( sample(x-1) != -1 ) { 
                        val r: Double = new Random().nextDouble
                        if ( sample(x-1) == 0 ) { 
                            if ( r < vector(i)(0) ) 
                                sample(i) = 1
                            else 
                                sample(i) = 0
                        } else {
                            // sample(x) == 1
                            if ( r < vector(i)(1) ) 
                                sample(i) = 1
                            else 
                                sample(i) = 0
                        }
                    }
                }
            }
        }

        return sample;
    }
    
    def printVector ( vec: Array[Double] ) { 
        print("[ ")
        for ( i <- 0 until vec.length ) 
            print(vec(i)+" ")
        println("]")
    }

    def generateIndep ( _class: Array[Double] ): Array[Double] = {
        var sample = Array.ofDim[Double](10)
        
        for ( i <- 0 until 10 ) {

            val r: Double = new Random().nextDouble
            if ( r < _class(i) ) 
                sample(i) = 1
            else 
                sample(i) = 0
        }
        return sample
    }
}
