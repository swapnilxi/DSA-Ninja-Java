class Solution {
    public String reverseWords(String s) {
        String[] wordArr= s.split(" ");
        StringBuilder str= new StringBuilder();
        for(String word: wordArr){
            StringBuilder rev = new StringBuilder(word).reverse();
            str.append(rev + " ");
        }
       str.setLength(str.length()-1);
        return str.toString();
        
    }
}
