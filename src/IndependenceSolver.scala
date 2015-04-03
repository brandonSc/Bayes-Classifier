package probability

object IndependenceSolver
{
    /*****************
     estimate a probability vector 
     by summing the values in the 
     given vector sample spsace
     ******************/
    def estimate ( samples: Array[Array[Double]] ): Array[Double] = { 

        val probVector: Array[Double] = new Array[Double](samples(0).length)

        for ( i <- 0 until samples(0).length ) { 

            var num: Double = 0

            for ( j <- 0 until samples.length ) { 
                if ( samples(j)(i) == 1 )  
                    num += 1
            }

            probVector(i) = (num / (samples.length).toDouble);
        }

        return probVector;
    }

    /***************
     classify a vector into one of the given classes
     return the class with the highest certainty 
     ***************/
    def classify ( classes: Array[Array[Double]], x: Array[Double] ):  Array[Double] = {
        var sum: Double = 0;
        var max: Double = sum;
        var maxClass: Array[Double] = classes(0);

        classes.foreach { _class => 
            //_class.foreach { println } 
            for ( i <- 0 until _class.length ) {
                sum += (x(i) * _class(i))
            }



            max = Math.max(sum, max)

            if ( max == sum )
                maxClass = _class

            sum = 0;
        }
        return maxClass;
    }
}
