import java.util.Calendar;
import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		String name, si, gu, dong, university, major;
		int birthYear, birthMonth, birthDay, enterenceYear, age, grade, year, month, day;
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("이름 :"); name = in.next();
		System.out.println("생년 :"); birthYear = in.nextInt();
		System.out.println("생일 :"); birthMonth = in.nextInt(); birthDay = in.nextInt();
		System.out.println("시 :"); si = in.next();
		System.out.println("구 :"); gu = in.next();
		System.out.println("동 :"); dong = in.next();
		System.out.println("대학교 :"); university = in.next();
		System.out.println("학과:"); major = in.next();
		System.out.println("입학년도 :"); enterenceYear = in.nextInt();
		

		if(month<birthMonth || (month==birthMonth && day<birthDay)) {
			age = year-birthYear-1;
		}
		else {
			age = year-birthYear;
		}

		grade = year-enterenceYear+1;
		
		System.out.printf("%s(만,%d세) 학생은 %s %s에 %d학년으로 재학중이다. \"%s %s %s\"에 거주 중이다.",name, age, university, major, grade, si,gu,dong);
	}

}
