import probability._
import graphtheory._

object DepTest 
{
    var SIZE: Int = 2000;

    def main ( args: Array[String] ) {

        var samples = Array.ofDim[Double](4, SIZE, 10)
        var classes = Array.ofDim[Double](4, 10, 3)

        /********************
         generate 2000 samples for 4 classes
         ********************/
        for ( i <- 0 until 4 ) { 
            val vector = DependenceTree.generateDepClass;
            classes(i) = vector;

            println("\nclass: "+(i+1));
            classes(i).foreach { c =>  
                println("[ "+c(0)+"\t"+c(1)+"\t"+c(2)+" ]")
            } 
            for ( j <- 0 until SIZE ) { 
                samples(i)(j) = SampleVector.generateDep(vector);
            }
        }
        
        /*********************
         TRAINING PHASE:
         estimate the dependence trees
         and probability vector
         *********************/
        val estGraphs = Array.ofDim[Graph](4);
        for ( i <- 0 until 4 ) {
            var sample = Array.ofDim[Double](SIZE - (SIZE/8), 10)
            for ( j <- 0 until (SIZE - (SIZE/8)) ) 
                sample(j) = samples(i)(j)
            estGraphs(i) = dependenceSolver.estimateGraph(sample);
        }
        val msts = new Array[Graph](4)
        for ( i <- 0 until 4 ) { 
            println("Estimated Dependence Tree for Class"+(i+1)+":")
            msts(i) = estGraphs(i).findMST
            msts(i).E.foreach { println } 
        }
        println
        val probVectors = Array.ofDim[Double](4, 10, 3);
        for ( i <- 0 until 4 ) { 
            var sample = Array.ofDim[Double](SIZE - (SIZE/8), 10)
            for ( j <- 0 until (SIZE - (SIZE/8)) ) 
                sample(j) = samples(i)(j)
            probVectors(i) = dependenceSolver.estimateProbVector(msts(i), sample)
            println("\nEstimated probabilities for class"+(i+1)
                +" in vector form:")
            probVectors(i).foreach { v => 
                println("[ "+v(0)+"\t"+v(1)+"\t"+v(2)+" ]") 
            } 
        }
        println

        /***********************
         TESTING PHASE:
         record the classification accuracy
         for each sample of each class
         ***********************/
        for ( i <- 0 until 4 ) { 
            var count: Double = 0;

            for ( j <- (SIZE - (SIZE/8)) until SIZE ) { 

                var estClass = dependenceSolver.classify(
                    probVectors, samples(i)(j));

                if ( probVectors(i).deep == estClass.deep ) 
                    count += 1
            }
            println("Classification accuracy for class "+(i+1)
                + " = " + (count / (SIZE/8)));
        }  
    }
}
