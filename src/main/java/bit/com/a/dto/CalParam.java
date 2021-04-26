package bit.com.a.dto;

public class CalParam {
	
	private String id;
	private String yyyyMMdd;
	private String yyyyMM;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String min;
	
	
	public CalParam() {
		// TODO Auto-generated constructor stub
	}

	
	public CalParam(String id, String yyyyMMdd, String yyyyMM, String year, String month, String day, String hour,
			String min) {
		super();
		this.id = id;
		this.yyyyMMdd = yyyyMMdd;
		this.yyyyMM = yyyyMM;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}



	public CalParam(String id, String yyyyMM, String year, String month, String day, String hour, String min) {
		super();
		this.id = id;
		this.yyyyMM = yyyyMM;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}




	public CalParam(String id, String yyyyMM, String year, String month, String day) {
		this.id = id;
		this.yyyyMM = yyyyMM;
		this.year = year;
		this.month = month;
		this.day = day;
	}



	public CalParam(String id, String yyyyMMdd, String yyyyMM) {
		this.id = id;
		this.yyyyMMdd = yyyyMMdd;
		this.yyyyMM = yyyyMM;
	}


	public CalParam(String id, String yyyyMM) {
		this.id = id;
		this.yyyyMM = yyyyMM;
	}

	
	
	
	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getYyyyMM() {
		return yyyyMM;
	}


	public void setYyyyMM(String yyyyMM) {
		this.yyyyMM = yyyyMM;
	}



	
	
	public String getHour() {
		return hour;
	}




	public void setHour(String hour) {
		this.hour = hour;
	}




	public String getMin() {
		return min;
	}




	public void setMin(String min) {
		this.min = min;
	}



	public String getYyyyMMdd() {
		return yyyyMMdd;
	}


	public void setYyyyMMdd(String yyyyMMdd) {
		this.yyyyMMdd = yyyyMMdd;
	}


	@Override
	public String toString() {
		return "CalParam [id=" + id + ", yyyyMMdd=" + yyyyMMdd + ", yyyyMM=" + yyyyMM + ", year=" + year + ", month="
				+ month + ", day=" + day + ", hour=" + hour + ", min=" + min + "]";
	}





	
}
