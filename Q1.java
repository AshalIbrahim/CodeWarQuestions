package CodeWarsQuestions;

public class Q1 {

    public static String add(String a, String b) {
        int carryValue=0;
        int num=0;
        if(a.length()>=b.length()){
            int[]array=new int[a.length()];

            int k=b.length()-1;

            int arrayCounter=0;

            for(int i=a.length()-1; i >= 0 ; i--){
                if(k<0){
                    num=carryValue+Character.getNumericValue(a.charAt(i));
                }
                else {
                    num=carryValue+Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(k));
                }

                if(num>9){
                    carryValue=1;
                }else carryValue=0;

                num=num%10;
                array[arrayCounter]=num;
                arrayCounter++;
                k--;
            }
            return removeInitialZeroes(arraytoString(array,carryValue));

        }
        else{
            int[]array=new int[b.length()];

            int k=a.length()-1;

            int arrayCounter=0;

            for(int i=b.length()-1; i >= 0 ; i--){
                if(k<0){
                    num=carryValue+Character.getNumericValue(b.charAt(i));
                }
                else {
                    num=carryValue+Character.getNumericValue(b.charAt(i))+Character.getNumericValue(a.charAt(k));
                }

                if(num>9){
                    carryValue=1;
                }else carryValue=0;

                num=num%10;
                array[arrayCounter]=num;
                arrayCounter++;
                k--;
            }
            String temp=arraytoString(array,carryValue);
            return removeInitialZeroes(temp);
        }

    }

    public static String arraytoString(int array[],int carry){
        if(carry==1){
            String ret="";
            for(int i=0;i<array.length;i++){
                ret=array[i]+ret;
            }
            return carry+ret;
        }
        else{
            String ret="";
            for(int i=0;i<array.length;i++){
                ret=array[i]+ret;
            }
            return ret;
        }
    }

    public static String removeInitialZeroes(String word){
        String newWord="";
        for(int i=0;i<word.length();i++){
            if(Character.getNumericValue(word.charAt(i))!=0){
                newWord=newWord+word.substring(i,word.length());
                break;
            }
        }
        return newWord;
    }


    public static void main(String[] args) {
        System.out.println(add("0531510502","37942776"));
        String s=add("0531510502","37942776");
        System.out.println(removeInitialZeroes(s));
    }

}
