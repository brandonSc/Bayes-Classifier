import probability._
import graphtheory._
import examples._

object IndepTestHeart
{
    def main ( args: Array[String] ) {

        var samples1 = HeartDataset.toBinary(HeartDataset.class1)
        var samples2 = HeartDataset.toBinary(HeartDataset.class2)
        var samples3 = HeartDataset.toBinary(HeartDataset.class3)
        var samples4 = HeartDataset.toBinary(HeartDataset.class4)
        var samples = Array(samples1, samples2, samples3, samples4)


        /*********************
         TRAINING PHASE:
         get the prob vector for each class
         *********************/
        var probVectors = Array.ofDim[Double](4, 10);
        for ( i <- 0 until 4 ) { 
            var sample = Array.ofDim[Double]((samples(i).length-(samples(i).length/8)), 10)
            
            for ( j <- 0 until (samples(i).length-(samples(i).length/8)) ) 
                sample(j) = samples(i)(j);
            //sample(i).foreach { println } 
            probVectors(i) = IndependenceSolver.estimate(sample);
       }

        /***********************
         TESTING PHASE:
         record the classification accuracy
         for each sample of each class
         ***********************/
        for ( i <- 0 until 4 ) { 
            var count: Double = 0;

            for ( j <- (samples(i).length-(samples(i).length/8)) until samples(i).length ) { 

                var estClass = IndependenceSolver.classify(
                    probVectors, samples(i)(j));

                if ( probVectors(i).deep == estClass.deep ) 
                    count += 1
            }
            println("Classification accuracy for class "+(i+1)
                + " = " + (count / (samples(i).length)));
        }
    }
}
