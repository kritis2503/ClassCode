import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class graph{
    public static class Edge{
        int v;
        int w;
        
        Edge(final int v, final int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int n = 7;
    public static ArrayList<Edge>[] graph=new ArrayList[n];

    public static void addEdge( ArrayList<Edge>[] graph, int u,  int v,  int w) {
    
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void constructor() {
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        //display();
    }

    public static void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + "--->");
            for (final Edge e : graph[i]) {
                System.out.print("(" + e.v + "," + e.w + ")  ");
            }
            System.out.println();
        }
    }
   public static boolean HasPath(int src,int dest,boolean[]vis)
   {
       if(src==dest)
        return true;

        vis[src]=true;
        boolean res =false;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
                res=res||HasPath(e.v, dest, vis);
        }
        return res;
   }
   public static int printPath(int src,int dest,boolean[]vis,String str,int wt)
   {
       
       if(src==dest)
        {
            System.out.println(str+"@"+wt);
            return 1;
        }
        vis[src]=true;
        int count=0;
        
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
                count+=printPath(e.v, dest, vis,str+e.v+" ",wt+e.w);
        }
        vis[src]=false;
        return count;
   }
   static int lw=(int) 1e7;
   static String lwp="";

   static int hw=0;
   static String hwp="";
   public static void heavisetpath(int src,int dest,boolean[]vis,String str,int wt)
   {
       
       if(src==dest)
        {
            if(wt>hw)
                {
                    hw=wt;
                    hwp=str;
                }
            return ;
        }
        vis[src]=true;
        //int count=0;
        
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                String s=str+e.v+" ";
                int w=wt+e.w;
                
                heavisetpath(e.v, dest, vis,s,w);
            }
        }
        vis[src]=false;
        return;
   }
   public static void lightestpath(int src,int dest,boolean[]vis,String str,int wt)
   {
       
       if(src==dest)
        {
            if(wt<lw)
                {
                    lw=wt;
                    lwp=str;
                }
            return ;
        }
        vis[src]=true;
        //int count=0;
        
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                String s=str+src+" ";
                int w=wt+e.w;
                
                lightestpath(e.v, dest, vis,s,w);
            }
        }
        vis[src]=false;
        return;
   }
   static class allAns
   {
       int wgt;
       String path;
       allAns(int wgt,String path)
       {
           this.wgt=wgt;
           this.path=path;
       }
   }
   public static allAns heavisetpathc(int src,int dest,boolean[]vis)
   {
       
       if(src==dest)
        {
            allAns base=new allAns(0,src+"");
            return base;
        }
        vis[src]=true;
        //int count=0;
        allAns myAns=new allAns((int)-1e8,"");
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                allAns recAns= heavisetpathc(e.v, dest, vis);
                if(recAns.wgt+e.w>myAns.wgt)
                {
                    myAns.wgt=recAns.wgt+e.w;
                    myAns.path=src+recAns.path;
                }
            }
        }
        vis[src]=false;
        return myAns;
   }

   public static allAns lightestpathc(int src,int dest,boolean[]vis)
   {
       if(src==dest)
        {
           allAns base=new allAns(0,src+"");
           return base;
        }
        vis[src]=true;
        //int count=0;
        allAns ans=new allAns((int)1e8, "");
        
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
               allAns recAns= lightestpathc(e.v, dest, vis);
                if(recAns.wgt+e.w<ans.wgt)
                {
                    ans.wgt=recAns.wgt+e.w;
                    ans.path=src+recAns.path;
                }

            }
        }
        vis[src]=false;
        return ans;
   }
   
static int d=(int)-1e8;
static int ceilwt=0;
static String ceilpath="";
public static void ceilval(int src,int dest,int ceil,boolean[]vis,int fwt,String fpath)
{
    if(src==dest)
    {
        System.out.print(fpath+" ");
        if(d<ceilwt-fwt)
        {
            ceilwt=fwt;
            ceilpath=fpath;
        }
    }
    vis[src]=true;
    for(Edge e:graph[src])
    {
        if(!vis[e.v])
        {
            ceilval(e.v, dest, ceil, vis, fwt+e.w, fpath+e.v);
        }
    }
    vis[src]=false;
    return;
}
    public static void main(String[] args) {
        //graph=new ArrayList<>(); 
        constructor();
        boolean[]visited=new boolean[n];
        // System.out.println(HasPath(0, 6, visited));
        // visited=new boolean[n];
        System.out.println(printPath(0, 6, visited, "",0));
        // visited=new boolean[n];
        //  heavisetpath(0, 6, visited,"", 0);
        //  System.out.println(hwp+"@"+hw);
        //  visited=new boolean[n];
        //  lightestpath(0, 6, visited,"", 0);
        //  System.out.println(lwp+"@"+lw);
        // allAns a=heavisetpathc(0, 6, visited);
        // System.out.println(a.path+"@"+ a.wgt);
        ceilval(0, 6, 25, visited,0,"");
        System.out.println();
        System.out.println(ceilpath+"@"+ceilwt);
    }

}

