package examples

object IrisDataset 
{
    val setosa = Array( 
            Array(4.9, 3,   1.4, 0.2),
            Array(4.7, 3.2, 1.3, 0.2),
            Array(4.6, 3.1, 1.5, 0.2),
            Array(5,   3.6, 1.4, 0.2),
            Array(5.4, 3.9, 1.7, 0.4),
            Array(4.6, 3.4, 1.4, 0.3),
            Array(5,   3.4, 1.5, 0.2),
            Array(4.4, 2.9, 1.4, 0.2),
            Array(4.9, 3.1, 1.5, 0.1),
            Array(5.4, 3.7, 1.5, 0.2),
            Array(4.8, 3.4, 1.6, 0.2),
            Array(4.8, 3,   1.4, 0.1),
            Array(4.3, 3,   1.1, 0.1),
            Array(5.8, 4,   1.2, 0.2),
            Array(5.7, 4.4, 1.5, 0.4),
            Array(5.4, 3.9, 1.3, 0.4),
            Array(5.1, 3.5, 1.4, 0.3),
            Array(5.7, 3.8, 1.7, 0.3),
            Array(5.1, 3.8, 1.5, 0.3),
            Array(5.4, 3.4, 1.7, 0.2),
            Array(5.1, 3.7, 1.5, 0.4),
            Array(4.6, 3.6, 1,   0.2),
            Array(5.1, 3.3, 1.7, 0.5),
            Array(4.8, 3.4, 1.9, 0.2),
            Array(5,   3,   1.6, 0.2),
            Array(5,   3.4, 1.6, 0.4),
            Array(5.2, 3.5, 1.5, 0.2),
            Array(5.2, 3.4, 1.4, 0.2),
            Array(4.7, 3.2, 1.6, 0.2),
            Array(4.8, 3.1, 1.6, 0.2),
            Array(5.4, 3.4, 1.5, 0.4),
            Array(5.2, 4.1, 1.5, 0.1),
            Array(5.5, 4.2, 1.4, 0.2),
            Array(4.9, 3.1, 1.5, 0.1),
            Array(5,   3.2, 1.2, 0.2),
            Array(5.5, 3.5, 1.3, 0.2),
            Array(4.9, 3.1, 1.5, 0.1),
            Array(4.4, 3,   1.3, 0.2),
            Array(5.1, 3.4, 1.5, 0.2),
            Array(5,   3.5, 1.3, 0.3),
            Array(4.5, 2.3, 1.3, 0.3),
            Array(4.4, 3.2, 1.3, 0.2),
            Array(5,   3.5, 1.6, 0.6),
            Array(5.1, 3.8, 1.9, 0.4),
            Array(4.8, 3,   1.4, 0.3),
            Array(5.1, 3.8, 1.6, 0.2),
            Array(4.6, 3.2, 1.4, 0.2),
            Array(5.3, 3.7, 1.5, 0.2),
            Array(5,   3.3, 1.4, 0.2))

    val versiColor = Array( 
        Array(7,    3.2,    4.7,    1.4),
        Array(6.4,  3.2,    4.5,    1.5),
        Array(6.9,  3.1,    4.9,    1.5),
        Array(5.5,  2.3,    4,  1.3),
        Array(6.5,  2.8,    4.6,    1.5),
        Array(5.7,  2.8,    4.5,    1.3),
        Array(6.3,  3.3,    4.7,    1.6),
        Array(4.9,  2.4,    3.3,    1),
        Array(6.6,  2.9,    4.6,    1.3),
        Array(5.2,  2.7,    3.9,    1.4),
        Array(5,    2,  3.5,    1),
        Array(5.9,  3,  4.2,    1.5),
        Array(6,    2.2,    4,  1),
        Array(6.1,  2.9,    4.7,    1.4),
        Array(5.6,  2.9,    3.6,    1.3),
        Array(6.7,  3.1,    4.4,    1.4),
        Array(5.6,  3,  4.5,    1.5),
        Array(5.8,  2.7,    4.1,    1),
        Array(6.2,  2.2,    4.5,    1.5),
        Array(5.6,  2.5,    3.9,    1.1),
        Array(5.9,  3.2,    4.8,    1.8),
        Array(6.1,  2.8,    4,  1.3),
        Array(6.3,  2.5,    4.9,    1.5),
        Array(6.1,  2.8,    4.7,    1.2),
        Array(6.4,  2.9,    4.3,    1.3),
        Array(6.6,  3,  4.4,    1.4),
        Array(6.8,  2.8,    4.8,    1.4),
        Array(6.7,  3,  5,  1.7),
        Array(6,    2.9,    4.5,    1.5),
        Array(5.7,  2.6,    3.5,    1),
        Array(5.5,  2.4,    3.8,    1.1),
        Array(5.5,  2.4,    3.7,    1),
        Array(5.8,  2.7,    3.9,    1.2),
        Array(6,    2.7,    5.1,    1.6),
        Array(5.4,  3,  4.5,    1.5),
        Array(6,    3.4,    4.5,    1.6),
        Array(6.7,  3.1,    4.7,    1.5),
        Array(6.3,  2.3,    4.4,    1.3),
        Array(5.6,  3,  4.1,    1.3),
        Array(5.5,  2.5,    4,  1.3),
        Array(5.5,  2.6,    4.4,    1.2),
        Array(6.1,  3,  4.6,    1.4),
        Array(5.8,  2.6,    4,  1.2),
        Array(5,    2.3,    3.3,    1),
        Array(5.6,  2.7,    4.2,    1.3),
        Array(5.7,  3,  4.2,    1.2),
        Array(5.7,  2.9,    4.2,    1.3),
        Array(6.2,  2.9,    4.3,    1.3),
        Array(5.1,  2.5,    3,  1.1),
        Array(5.7,  2.8,    4.1,    1.3))


    val virginica = Array(
        Array(6.3,  3.3,    6,  2.5),
        Array(5.8,  2.7,    5.1,    1.9),
        Array(7.1,  3,  5.9,    2.1),
        Array(6.3,  2.9,    5.6,    1.8),
        Array(6.5,  3,  5.8,    2.2),
        Array(7.6,  3,  6.6,    2.1),
        Array(4.9,  2.5,    4.5,    1.7),
        Array(7.3,  2.9,    6.3,    1.8),
        Array(6.7,  2.5,    5.8,    1.8),
        Array(7.2,  3.6,    6.1,    2.5),
        Array(6.5,  3.2,    5.1,    2),
        Array(6.4,  2.7,    5.3,    1.9),
        Array(6.8,  3,  5.5,    2.1),
        Array(5.7,  2.5,    5,  2),
        Array(5.8,  2.8,    5.1,    2.4),
        Array(6.4,  3.2,    5.3,    2.3),
        Array(6.5,  3,  5.5,    1.8),
        Array(7.7,  3.8,    6.7,    2.2),
        Array(7.7,  2.6,    6.9,    2.3),
        Array(6,    2.2,    5,  1.5),
        Array(6.9,  3.2,    5.7,    2.3),
        Array(5.6,  2.8,    4.9,    2),
        Array(7.7,  2.8,    6.7,    2),
        Array(6.3,  2.7,    4.9,    1.8),
        Array(6.7,  3.3,    5.7,    2.1),
        Array(7.2,  3.2,    6,  1.8),
        Array(6.2,  2.8,    4.8,    1.8),
        Array(6.1,  3,  4.9,    1.8),
        Array(6.4,  2.8,    5.6,    2.1),
        Array(7.2,  3,  5.8,    1.6),
        Array(7.4,  2.8,    6.1,    1.9),
        Array(7.9,  3.8,    6.4,    2),
        Array(6.4,  2.8,    5.6,    2.2),
        Array(6.3,  2.8,    5.1,    1.5),
        Array(6.1,  2.6,    5.6,    1.4),
        Array(7.7,  3,  6.1,    2.3),
        Array(6.3,  3.4,    5.6,    2.4),
        Array(6.4,  3.1,    5.5,    1.8),
        Array(6,    3,  4.8,    1.8),
        Array(6.9,  3.1,    5.4,    2.1),
        Array(6.7,  3.1,    5.6,    2.4),
        Array(6.9,  3.1,    5.1,    2.3),
        Array(5.8,  2.7,    5.1,    1.9),
        Array(6.8,  3.2,    5.9,    2.3),
        Array(6.7,  3.3,    5.7,    2.5),
        Array(6.7,  3,  5.2,    2.3),
        Array(6.3,  2.5,    5,  1.9),
        Array(6.5,  3,  5.2,    2),
        Array(6.2,  3.4,    5.4,    2.3),
        Array(5.9,  3,  5.1,    1.8))

    def mean( clazz: Array[Array[Double]], i: Int ): Double = { 
        var sum: Double = 0;

        for ( c <- clazz ) 
            sum += c(i)
        
        return sum / (clazz.length.toDouble)
    }

    def toBinary ( clazz: Array[Array[Double]] ): Array[Array[Double]] = {
        var bin: Array[Array[Double]] = Array.ofDim(clazz.length, clazz(0).length)

        for ( i <- 0 until clazz(0).length ) { 
            var m: Double = mean(clazz,i)
            
            for ( j <- 0 until clazz.length ) { 
                
                if ( clazz(j)(i) < clazz(0)(i) ) 
                    bin(j)(i) = 0
                else 
                    bin(j)(i) = 1
            }
        }

        return bin
    }

    def probVector ( samples: Array[Array[Double]] ): Array[Double] = {
        val vec = Array.ofDim[Double](samples(0).length)

        for ( i <- 0 until samples(0).length ) {
            var sum: Double = 0;

            for ( j <- 0 until samples.length ) { 
                if ( samples(j)(i) == 1 ) 
                    sum += 1;
            }

            vec(i) = sum / (samples.length.toDouble)
        }
        vec.foreach { println } 
        return vec;
    }
}
