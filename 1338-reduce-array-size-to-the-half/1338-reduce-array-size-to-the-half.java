// class Solution {
//     public int minSetSize(int[] arr) {
//         int half=arr.length/2;
//         int n=arr.length;
//         PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
//         Map<Integer,Integer> mp=new HashMap<>();
//         for(int i=0;i<arr.length;i++) mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
//         pq.addAll(mp.entrySet());
//         int ans=0;
//         while(!pq.isEmpty())
//         {
//             Map.Entry e=pq.poll();
//             int key=(int)e.getKey();
//             int val=(int)e.getValue();
//             if(n-val<=half)
//             {
//                 ans++;
//                 break;
//             }
//             else
//             {
//                 n-=val;
//                 ans++;
//             }
//         }

//         return ans;
//     }
// }
class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq=0;
        for(int num : arr ){
            map.put(num, map.getOrDefault(num, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        int[] freqArr = new int[maxFreq+1];
        for(int freq : map.values()){
            freqArr[freq]++;
        }
        int res=0, half=len/2, removed=0, curFreq=maxFreq;
        while(removed<half){
            while(freqArr[curFreq]==0) curFreq--;
            freqArr[curFreq]--;
            removed+=curFreq;
            res++;
        }
        return res;
    }
} 