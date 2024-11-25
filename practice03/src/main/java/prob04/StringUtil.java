package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		int cnt = strArr.length;
		
		String result = "";
		
		for (int i = 0; i < cnt; i++) {
			result += strArr[i];
		}
		
		return result;
	}
}
