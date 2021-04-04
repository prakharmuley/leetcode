import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
	 
    public static void main(String[] args) {
    	
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }
 
    static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    static void sieveOfEratosthenes(int n, int factors[]) 
    { 
       n=1000000001;
    	factors[1]=1;
        for(int p = 2; p*p <=n; p++) 
        { 
            if(factors[p] == 0) 
            { 
                factors[p]=p;
                for(int i = p*p; i <= n; i += p) 
                    factors[i] = p; 
            } 
        } 
    }

    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static void sort1(long ar[]) {
        int n = ar.length;
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }
    public static int convert(String a, String b)
    {
    	int T=0;
    	if(b.charAt(0)=='P')
    	{
    		if(a.charAt(0)=='1'&&a.charAt(1)=='2') T=12;
    		else
    			T=(a.charAt(0)-'0')*10+(a.charAt(1)-'0')+12;
    	}
    	else if(b.charAt(0)=='A')
    	{
    		if(a.charAt(0)=='1'&&a.charAt(1)=='2') T=0;
    		else
    			T=(a.charAt(0)-'0')*10+(a.charAt(1)-'0');
    	}
    		
    	T=T*100+(a.charAt(3)-'0')*10+(a.charAt(4)-'0');
    	return T;
    	
    }
    static boolean areBracketsBalanced(String expr) 
    { 
        // Using ArrayDeque is faster than using Stack class 
        Deque<Character> stack 
            = new ArrayDeque<Character>(); 
  
        // Traversing the Expression 
        for (int i = 0; i < expr.length(); i++)  
        { 
            char x = expr.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{')  
            { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } 
  
            // IF current current character is not opening 
            // bracket, then it must be closing. So stack 
            // cannot be empty at this point. 
            if (stack.isEmpty()) 
                return false; 
            char check; 
            switch (x) { 
            case ')': 
                check = stack.pop(); 
                if (check == '{' || check == '[') 
                    return false; 
                break; 
  
            case '}': 
                check = stack.pop(); 
                if (check == '(' || check == '[') 
                    return false; 
                break; 
  
            case ']': 
                check = stack.pop(); 
                if (check == '(' || check == '{') 
                    return false; 
                break; 
            } 
        } 
  
        // Check Empty Stack 
        return (stack.isEmpty()); 
    } 
    public static int hr(String s)
    {
    	int hh=0;
    	hh=(s.charAt(0)-'0')*10+(s.charAt(1)-'0');
    	return hh;
    }
    public static int mn(String s)
    {
    	int mm=0;
    	mm=(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
    	return mm;
    }
	
	/*
	 * public static void countNumberOfPrimeFactors(){ boolean flag[]=new
	 * boolean[N]; Arrays.fill(flag,true); for(int i=2;i<N;i++){ if(flag[i]){
	 * for(int j=i;j<N;j+=i) { prime[j]++; flag[j]=false; } } } // prime[1]=1; }
	 */	 

   
	public static long fun(long n)
	{
		long s=0;
		while(n!=0)
		{
			s+=n%10;
			n/=10;
		}
		return s;
	}
	public static int fun(String s, String t)
	{
		int ans=0;
		
		 return ans;
		
	}
	public static String rev(String s)
	{
		char[] temp=s.toCharArray();
		for(int i=0;i<s.length()/2;i++)
		{
			char tmp=temp[i];
			temp[i]=temp[s.length()-1-i];
			temp[s.length()-1-i]=tmp;
			
		}
		String str="";
		for(char ch: temp)
		{
			str+=ch;
		}
		return str;
	}
	static boolean isP(String str)
    {
 
        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;
 
        // While there are characters to compare
        while (i < j) {
 
            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;
 
            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
 
        // Given string is a palindrome
        return true;
    }
  
    public static void solve(InputReader sc, PrintWriter pw) {
  
    int t=sc.nextInt();
     
  	
  	     
		
		 for(int k=1;k<=t;k++) 
	  {
			 int n=sc.nextInt();
			 String a=sc.next();
			 String b=sc.next();
			 int z=0,o=0;
			 boolean ch=false;
	    for(int i=0;i<n;i++)
	  {
	    	if(a.charAt(i)=='0') z++;
	    	else o++;
	  }
	  int f=1;
	  for(int i=n-1;i>=0&&f==1;i--)
	  {
		  if((a.charAt(i)==b.charAt(i)&&ch)||(a.charAt(i)!=b.charAt(i)&&!ch)) {
		 
			  if(z==o)
			  {
				  ch=!ch;
			  }
			  else
			  {
				  f=0;
				  break;
			  }
		  }
		  if(a.charAt(i)=='0') z--;
		  else o--;
	  }
	  if(f==0) pw.print("no"+"\n");
	  else pw.print("yes"+"\n");
		  
  		    
	  }     
  		     
				
  			  
    }
    static class Pair1 {
        long a;
        long b;
        
        Pair1(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;
        
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
 
        public int compareTo(Pair p) {
            if(a!=p.a)
                return p.a-a;
            return b-p.b;
        }
    }

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }
    public static int LowerBound(int a[], int x) 
	   {
			  int l=-1,r=a.length;
			  while(l+1<r) {
			    int m=(l+r)>>>1;
			    if(a[m]>=x) r=m;
			    else l=m;
			  }
			  return r;
		}
	
	   
	public static int UpperBound(int a[], int x) 
		{
		    int l=-1, r=a.length;
		    while(l+1<r) {
		       int m=(l+r)>>>1;
		       if(a[m]<=x) l=m;
		       else r=m;
		    }
		    return l+1;
		}

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}


