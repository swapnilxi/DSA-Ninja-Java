public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c=0;
        String st=Integer.toBinaryString(n);
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='1')
                c++;
        }
        return c;
    }
}