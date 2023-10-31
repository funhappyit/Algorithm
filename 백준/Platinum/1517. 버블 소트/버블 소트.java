import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long ans;
	static long[] elements, sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		elements = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			elements[i] = Integer.valueOf(st.nextToken());
		}
		sorted = new long[n];
		divide(0,n-1);
		System.out.println(ans);
	}

	private static void divide(int low, int high) {
		if(low<high){
			int mid = (low+high)/2;

			divide(low,mid);
			divide(mid+1,high);

			merge(low,mid,high);
		}
	}

	private static void merge(int low, int mid, int high) {
		int index1=low;
		int index2 = mid+1;
		int k = low;

		while(index1<=mid&&index2<=high){
			if(elements[index1]<=elements[index2]){
				sorted[k] = elements[index1];
				index1++;
			}else{
				sorted[k] = elements[index2];
				index2++;
				ans += (mid+1-index1);

			}
			k++;
		}
		while(index1<=mid){
			sorted[k] = elements[index1];
			k++;
			index1++;
		}
		while(index2<= high){
			sorted[k] = elements[index2];
			k++;
			index2++;
		}

		for(int m=low; m<high+1; m++) {
			elements[m] = sorted[m];
		}
	}

}