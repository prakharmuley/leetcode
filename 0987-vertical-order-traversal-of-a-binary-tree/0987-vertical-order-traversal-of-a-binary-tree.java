/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(int x, int y, TreeNode root,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp)
    {
        if(root==null)
          return;
        if(mp.containsKey(x))
        {
           TreeMap<Integer,PriorityQueue<Integer>> mpp=mp.get(x);
           if(mpp.containsKey(y))
           {
            PriorityQueue<Integer> pq=mpp.get(y);
            pq.offer(root.val);
            mpp.put(y,pq);
           }
           else
           {
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            pq.offer(root.val);
            mpp.put(y,pq);
           }
           mp.put(x,mpp);
        }
        else
        {
            TreeMap<Integer,PriorityQueue<Integer>> mpp=new TreeMap<>();
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            pq.offer(root.val);
            mpp.put(y,pq);
            mp.put(x,mpp);
        }
        dfs(x-1,y+1,root.left,mp);
        dfs(x+1,y+1,root.right,mp);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
        List<List<Integer>> list=new ArrayList<>();
        dfs(0,0,root,mp);
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> e: mp.entrySet())
        {
            List<Integer> l=new ArrayList<>();
            int row=e.getKey();
            TreeMap<Integer,PriorityQueue<Integer>> rem=e.getValue();
            for(Map.Entry<Integer,PriorityQueue<Integer>> ee: rem.entrySet())
            {
                int col=ee.getKey();
                PriorityQueue<Integer> pq=ee.getValue();
                while(!pq.isEmpty())
                {
                    l.add(pq.poll());
                }

            }
            list.add(l);

        }
        return list;
    }
}