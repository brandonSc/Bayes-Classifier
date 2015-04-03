import graphtheory._
import probability._
import util.Random

object DependenceTree 
{
    /*********************
               v4
              / \ 
            v3   v9
           /  \   \
         v2    v1  v10
        / \    / \
      v6  v8 v5  v7
    ************************/
    def generateDepClass: Array[Array[Double]] =  { 
        val r = new Random()
        return  Array(
            Array(r.nextDouble, r.nextDouble, 3), // v1
            Array(r.nextDouble, r.nextDouble, 3), // v2
            Array(r.nextDouble, r.nextDouble, 4), // v3
            Array(r.nextDouble, r.nextDouble, 0), // v4
            Array(r.nextDouble, r.nextDouble, 1), // v5
            Array(r.nextDouble, r.nextDouble, 2), // v6
            Array(r.nextDouble, r.nextDouble, 1), // v7
            Array(r.nextDouble, r.nextDouble, 2), // v8
            Array(r.nextDouble, r.nextDouble, 4), // v9
            Array(r.nextDouble, r.nextDouble, 9)) // v10
    }

    def generateIndepClass: Array[Double] = { 
        var a = Array.ofDim[Double](10)
        for ( i <- 0 until 10 ) 
            a(i) = new Random().nextDouble

            return a;
    }
}
