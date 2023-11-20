import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str,"-");
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<Integer> resultArr =  new ArrayList<>();
		while(st.hasMoreTokens()){
			arr.add(st.nextToken());
		}
		int temp = 0;
		for(int i=0;i<arr.size() ;i++){
			String arrStr = arr.get(i);
			if(arrStr.contains("+")) {
				temp=sum(arrStr);
				resultArr.add(temp);
			}else{
				resultArr.add(Integer.valueOf(arrStr));
			}
		}
		int result = 0;
		if(resultArr.size()!=0){
			result = resultArr.get(0);
		}else{
			result = temp;
		}
		for(int i=0;i<resultArr.size()-1;i++){
			result = result - resultArr.get(i+1);
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	static int sum(String str){
		int sum =0;
		String temp[] = str.split("[+]");
		for(int i=0;i< temp.length;i++){
			sum+=Integer.valueOf(temp[i]);
		}
		return sum;
	}
}