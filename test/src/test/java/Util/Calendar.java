package Util;
public class Calendar {
	private String name;
	private int day;
	private int month;
	private int year;
	private int [] month_code = {1,4,4,0,2,5,0,3,6,1,4,6};
	private String[] dayofWeek = {"Sun","Mon","Tues","Wed","Thru","Fri","Sat"};
	
	public Calendar(String n, int d,int m, int y) {
		name = n;
		day=d;
		month=m;
		year=y;
	}
	private int getMonthCode() {
		int mc = month_code[month-1];
		return mc;
	}
	private int getYearCode() {
		int ycode=0;
		if (year > 1500 && year < 1599) {
			ycode = 0;
		}else if(year > 1600 && year < 1699) {
			ycode = 6;
		}else if(year > 1700 && year < 1799) {
			ycode = 4;
		}else if(year > 1800 && year < 1899) {
			ycode = 2;
		}else if(year > 1900 && year < 1999) {
			ycode = 0;
		}else if(year > 2000 && year < 2099) {
			ycode = 6;
		}
		return ycode;
	}
	
	private int getYear() {
		int yr = (int) Math.floorMod(year,100);
		return yr;
	}
	
	private int getFactor() {
		int factor = (int) Math.floorDiv(getYear(),4);
		return factor;
	}
	
	public void birthDayofWeek() {
		int total = day+getMonthCode()+getYearCode()+getYear()+getFactor();
		int dow = total%7;
		System.out.println(name+" was born on: "+dayofWeek[dow-1]);
	}
		
	public static void main(String[] args) {
		Calendar Papa = new Calendar("Papa",24,8, 1949);
		Papa.birthDayofWeek();
		Calendar Mummy = new Calendar("Mummy",3,10, 1954);
		Mummy.birthDayofWeek();
		Calendar Richi = new Calendar("Richi",24,1,1975);
		Richi.birthDayofWeek();
		Calendar Mahendra = new Calendar("Mahendra",06,12,1972);
		Mahendra.birthDayofWeek();
		Calendar Rahul = new Calendar("Rahul",9,8, 1976);
		Rahul.birthDayofWeek();
		Calendar Preeti = new Calendar("Preeti",14,9,1977);
		Preeti.birthDayofWeek();
		Calendar Vishi = new Calendar("Vishi",4,5,2006);
		Vishi.birthDayofWeek();
		Calendar Yashi = new Calendar("Yashi",8,7,2010);
		Yashi.birthDayofWeek();
		Calendar India = new Calendar("India",15,8,1947);
		India.birthDayofWeek();
	}

}
