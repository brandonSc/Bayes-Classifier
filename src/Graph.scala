package graphtheory

import scala.math.BigDecimal
import scala.collection.mutable.ArrayBuffer

class Graph ( val E: ArrayBuffer[Edge] ) 
{
    def getVertexSet: ArrayBuffer[String] = {
        var V = new ArrayBuffer[String]()
        for ( e <- E ) {
            if ( !V.contains(e.v1) )
                V += e.v1
            if ( !V.contains(e.v2) ) 
                V += e.v2
        }
        return V
    }

    case class Node ( var rank: Int, var v: String, var parent: Node ) 

    /**********************************
     calculate and return a Maximum Spanning Tree
     using Kruskal's algorithm 
     **********************************/
    def findMST: Graph = {

        // the set of all vertices
        var V = getVertexSet

        // kruskall makeset function
        def makeSet: ArrayBuffer[Node] = { 
            var set = new ArrayBuffer[Node]()
            for ( v <- V ) { 
                var n: Node = new Node(0, v, null)
                n.parent = n;
                set += n;
            }
            return set
        }
        
        // a set of all nodes for reference
        var nSet: ArrayBuffer[Node] = makeSet

        // kruskall find
        def find ( n: Node ): Node = { 
            var m: Node = n;
            while ( m != m.parent ) { m = m.parent }

            for ( l <- nSet ) { 
                if ( l.v == m.v ) {
                    nSet -= l;
                    nSet += m
                }
            }
            
            return m
        }

        // kruskall union
        def union ( n: Node, m: Node ) = {
            var rn: Node = find(n)
            var rm: Node = find(m)
            if ( rn.v != rm.v ) {
                if ( rn.rank > rm.rank )
                    rm.parent = rn;
                else {
                    rn.parent = rm;
                    if ( rn.rank == rm.rank ) 
                        rm.rank += 1
                }
            }
        }
        
        // get the node matching the vertex id
        def lookup ( v: String ): Node = {
            for ( n <- nSet ) {
                if ( n.v == v )
                    return n
            }
            return null
        }

        var mst: ArrayBuffer[Edge] = new ArrayBuffer[Edge]()

        // edges sorted in increasing order for MAX spanning tree
        var sorted = E.sortWith(_.w > _.w)
        
        var count: Int = 0;

        // begin kruskalls algorithm
        for ( i <- 0 until sorted.length  ) {
            if ( count < V.size-1 ) {
                var e: Edge = sorted(i)
                var n: Node = lookup(e.v1)
                var m: Node = lookup(e.v2)
                if ( find(n) != find(m) ) {
                    mst += e
                    union(n,m)
                }
            }
        }

        return new Graph(mst);
    }
}

class Edge ( val v1: String, val v2: String, val w: Double ) 
{
    override def toString: String = {
        //val d:Double = BigDecimal(w).setScale(4, BigDecimal.RoundingMode.HALF_UP).toDouble

        return "[ ("+v1+","+v2+") : "+w+" ]";
    }
}
