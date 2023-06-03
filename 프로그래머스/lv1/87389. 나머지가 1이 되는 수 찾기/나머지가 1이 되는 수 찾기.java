class Solution {
    public int solution(int n) {
       int answer = 0;
        while (answer >= 0){
            answer += 1;
            if(n%answer == 1){
                break;
            }
        }
        return answer;
    }
}