import java.util.Arrays;
import java.util.stream.Stream;
class Solution {
    public String solution(String s) {
       String answer = "";
        int[] str = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(str).max().getAsInt();
        int min = Arrays.stream(str).min().getAsInt();
        answer = Integer.toString(min) +" "+ Integer.toString(max);
        return answer;
    }
}