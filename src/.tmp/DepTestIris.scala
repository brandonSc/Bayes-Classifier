import probability._
import graphtheory._
import examples._

object DepTestIris 
{
    var SIZE: Int = 2000;

    def main ( args: Array[String] ) {

        var samples1 = IrisDataset.toBinary(IrisDataset.setosa)
        var samples2 = IrisDataset.toBinary(IrisDataset.versiColor)
        var samples3 = IrisDataset.toBinary(IrisDataset.virginica)
        var samples = Array(samples1, samples2, samples3)

        
        /*********************
         TRAINING PHASE:
         estimate the dependence trees
         and probability vector
         *********************/
        val estGraphs = Array.ofDim[Graph](4);
        for ( i <- 0 until 3 ) {
            var sample = Array.ofDim[Double](samples(i).length-(samples(i).length/8),
                samples(i).length)
            for ( j <- 0 until (samples(i).length-(samples(i).length/8)) ) 
                sample(j) = samples(i)(j)
            estGraphs(i) = dependenceSolver.estimateGraph(sample);
        }
        val msts = new Array[Graph](3)
        for ( i <- 0 until 3 ) { 
            println("Estimated Dependence Tree for Class"+(i+1)+":")
            msts(i) = estGraphs(i).findMST
            msts(i).E.foreach { println } 
        }
        println
        val probVectors = Array.ofDim[Double](4, 10, 3);
        for ( i <- 0 until 3 ) { 
            var sample = Array.ofDim[Double](samples(i).length-(samples(i).length/8),
                samples(i).length)
            for ( j <- 0 until (samples(i).length-(samples(i).length/8)) ) 
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
        for ( i <- 0 until 3 ) { 
            var count: Double = 0;

            for ( j <- (samples(i).length-(samples(i).length/8)) until samples(0).length ) { 

                var estClass = dependenceSolver.classify(
                    probVectors, samples(i)(j));

                if ( probVectors(i).deep == estClass.deep ) 
                    count += 1
            }
            println("Classification accuracy for class "+(i+1)
                + " = " + (count / samples(0).length.toDouble));
        }  
    }
}
