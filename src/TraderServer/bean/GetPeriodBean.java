package TraderServer.bean;

public class GetPeriodBean {
	public static String[] months={"Jan", "Fab", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public static String getPeriod(int month){
		String rs = "";
		rs += months[month-1];
		rs += "14";
		return rs;
	}
}
