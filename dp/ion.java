import java.util.*;

public class ion {


void addNode(int []graph,int u,int v)
{
  graph[u]=v;
}
public static int GCC_(int []graph,int src, boolean []vis)
{
    vis[src] = true;
    int count=0;
    for (int e : graph)
    {
        if (!vis[e])
            {count++;
                GCC_(graph,e, vis);
            }
    }
    return count;
}

public static int  GCC(int[] graph,int N)
{
   boolean []vis=new boolean [N];
    int max = 0;
    int ans=-1;
    for (int i = 0; i < N; i++)
    {
        if (!vis[i])
        {
            int res=GCC_(graph,i, vis);
            if(res>max)
            {
                max=res;
                ans=i;
            }
            //int res=count++;
        }

    }
    return ans;
}

public static void main(String[] args) {
    

{
    
    int user,pair;
    Scanner scn=new Scanner(System.in);
    user=scn.nextInt();
    pair=scn.nextInt();
    int []graph=new int [user];
    int p1,p2;
    for(int i=0;i<pair;i++)
    {
        
        p1=scn.nextInt();
        p2=scn.nextInt();
        addNode(graph,p1,p2);
    }
    boolean []vis=new boolean [user];
    //vector<bool>vis(user,false);
    System.out.println(GCC(graph,user));
}
