import probability._
import graphtheory._

object IndepTest 
{
    var SIZE = 2000;

    def main ( args: Array[String] ) {

        var samples = Array.ofDim[Double](4, SIZE, 10)
        var classes = Array.ofDim[Double](4, 10)

        /********************
         generate 2000 samples for 4 classes
         ********************/
        for ( i <- 0 until 4 ) { 
            val vector = DependenceTree.generateIndepClass;
            classes(i) = vector;

            for ( j <- 0 until SIZE ) { 
                //val vector = SampleVector.generate(
                //    DependenceTree.getClass(i));
                //SampleVector.printVector(vector)

                samples(i)(j) = SampleVector.generateIndep(vector);
            }
        }

        /*********************
         TRAINING PHASE:
         get the prob vector for each class
         *********************/
        var probVectors = Array.ofDim[Double](4, 10);
        for ( i <- 0 until 4 ) { 
            var sample = Array.ofDim[Double]((SIZE - (SIZE/8)), 10)
            
            for ( j <- 0 until (SIZE - (SIZE/8)) ) 
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

            for ( j <- (SIZE - (SIZE/8)) until SIZE ) { 

                var estClass = IndependenceSolver.classify(
                    probVectors, samples(i)(j));

                if ( probVectors(i).deep == estClass.deep ) 
                    count += 1
            }
            println("Classification accuracy for class "+(i+1)
                + " = " + (count / (SIZE/8)));
        }
    }
}
