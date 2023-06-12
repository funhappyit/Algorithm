import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String timeStr1 = br.readLine();
		String[] timeList = timeStr1.split(" ");
		String time = timeList[0]+":"+timeList[1];
		
		int C = Integer.parseInt(br.readLine());
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		// 문자열 -> Date
		Date date = formatter.parse(time);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.MINUTE,C);
		String today = formatter.format(cal.getTime());
		String[] list = today.split(":");
		String strHour = list[0].replaceFirst("^0+(?!$)", "");
		String strMinute = list[1].replaceFirst("^0+(?!$)", "");

		br.close();

		System.out.println(strHour+" "+strMinute);
	}
}
