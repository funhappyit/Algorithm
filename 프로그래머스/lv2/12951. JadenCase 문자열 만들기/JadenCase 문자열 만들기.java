class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strList = s.split("");
        boolean flag = true;
        for(int i=0;i<strList.length;i++){
            String str = strList[i];
            if(" ".equals(str)){
                answer += " ";
                flag = true;
            }else{
                boolean isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
                if(isNumeric){
                    answer += str;
                     flag = false;
                }else{
                    if(flag){
                        answer += str.toUpperCase();
                        flag = false;
                    }else{
                        answer += str.toLowerCase();
                    }
                }
            }
        }
        return answer;
    }
}