package Recursion;
//string to integer
//remove whitespaces
public class Atoi {
    public static void main(String[] args) {
        String s1= "11";
        String s2= " String 2 ";
        String s3="-3 - 1 String";
        // System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s3));
        // System.out.println(myAtoi(s3));
    }
public static int myAtoi(String s){
    
     return isInteger(s, 0, s.length()-1, 0);
          
    }

static int isInteger(String str, int s, int e, long result){
char[] ch = str.toCharArray();
 

if(s>e){
    return (int) result;
}


//positive or whitespace
if(ch[s]=='+' || ch[s]==' '){
    s++;
   }
int count=0;
int sign=1;
//negative 
if(ch[s]=='-' && ch[s-1]==' '){
    count++;
    if(count==1){
        sign= -1;
        s++;
    }else{
        s++;
    }
}

int num=ch[s]-'0';//removing ascii value of 0 to get int val of num

if(num>=0 && num<=9 ){
 result= (int)(result+ (num*10))*sign;
}else{
    return -1;
}

isInteger(str, s+1, e, result); 

}

}
