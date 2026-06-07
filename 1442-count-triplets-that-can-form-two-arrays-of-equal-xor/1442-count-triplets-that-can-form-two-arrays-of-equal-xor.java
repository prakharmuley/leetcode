// class Solution {
//     public int countTriplets(int[] arr) {
//         int ans=0;
//         int n=arr.length;
//         int xor=0;
//         for(int i=0;i<n;i++)
//         {
//             xor=arr[i];
//             for(int j=i+1;j<n;j++)
//             {
//                 xor^=arr[j];
//                 if(xor==0)
//                 {
//                     ans+=(j-i);
//                 }
//             }
            
//         }
//         return ans;
//     }
// }

class Solution {
    public int countTriplets(int[] arr) {
     int ans=0;
     int xor=0;
     final int n=arr.length;
     Map<Integer,Integer> count=new HashMap<>();
     Map<Integer,Integer> sum=new HashMap<>();
     count.put(0,1);
     sum.put(0,0);
     for(int i=0;i<n;i++)
     {
        xor^=arr[i];
        if(count.containsKey(xor))
        {
            ans+=count.get(xor)*i-sum.get(xor);
        }
        count.put(xor,count.getOrDefault(xor,0)+1);
        sum.put(xor,sum.getOrDefault(xor,0)+i+1);

     }
     return ans;
}
}
/*
2 3 1 6 7
2 
2^3 = 1
2^3^1= 0
2^3^1^6 = 6
2^3^1^6^7 =1 



*/