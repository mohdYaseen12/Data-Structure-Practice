import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }


    public static int[] switchesAfterNDays(int[] states, int n){
        int[] newstates = states.clone();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    if (states[j+1] == 1) {
                        newstates[j] = 1;
                    } else {
                        newstates[j] = 0;
                    }
                } else if (j == 7) {
                    if (states[j-1] == 1) {
                        newstates[j] = 1;
                    } else {
                        newstates[j] = 0;
                    }
                } else {
                    if (states[j-1] == states[j+1]) {
                        newstates[j] = 0;
                    } else {
                        newstates[j] = 1;
                    }
                }
            }
            states = newstates.clone();
        }
        return states;

    }

    public int maxRemoval(int n, int[][] trains){
        List<Integer> graph[] = new ArrayList<>();
        
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();

        for(int arr[] : trains){
            int u = arr[0];
            int v = arr[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int res = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++){
            int ce = 0;
            int cn = 0;
            if(!vis[i]){
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    ce++;
                    if(vis[curr]) continue;

                    cn++;
                    vis[curr] = true;
                    for(int nbr : graph[curr]){
                        if(!vis[nbr]) q.add(nbr);
                        
                    }
                }
                if(ce > cn-1){
                    res += ce-(cn);
                }
            }
        }
        return res;
    }

class Solution {
    List<Integer> ans = new ArrayList<>();
    public void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
         ans.add(root.val);
        inorder(root.right);  
    }

    int BobsChallenge(Node root, int k){
        inorder(root);
        
        return ans.get(ans.size()-k);
    }

 }






 public static int[] switchesAfterNDays(int[] states, int n){
    int[] newstates
 }







}
