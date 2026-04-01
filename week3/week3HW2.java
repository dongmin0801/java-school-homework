import java.util.Scanner;

public class HW2 {

	static float Max_Float=Float.MIN_VALUE, Max_Integer=Float.MIN_VALUE, Max_String = 0; //가장 높은 평균을 가진 최대 정수, 실수, 문자열 찾기
	static int 	Max_I_cnt =0, Max_F_cnt=0, Max_S_cnt=0, //가장 높은 평균을 가진 정수, 실수, 문자열 개수 저장
			Max_Ic=0, Max_Fc=0, Max_Sc=0; //가장 높은 평균을 가진 최대 정수, 실수, 문자열의 줄 번호 저장
	public static void main(String[] args) {
		
		int c = 1; //줄 번호
		String text;
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			int Isum =0,  Ssum=0, // 정수 합, 문자열 길이 합 
					Icnt=0, Fcnt=0, Scnt=0; //정수, 실수, 문자열의 개수

			
			float Fsum=0, //실수 합
					Iavg=0, Favg=0, Savg=0; //정수, 실수, 문자열 평균
			
			
			
			String input = in.nextLine();
			Scanner line = new Scanner(input);
			
			while(line.hasNext()) {
				text = line.next();
				if(isInteger(text)) {
					Isum += Integer.parseInt(text);
					Icnt++;
				}
				
				else if(isFloat(text)) {
					Fsum+=Float.parseFloat(text);
					Fcnt++;
				}
				else {
					Ssum += text.length();
					Scnt++;
				}
			}
			
			
			
			boolean exist = false;
			System.out.printf("%d: ", c);
			
			if(Icnt>0) {
				Iavg = (float)Isum/Icnt;
				System.out.printf("정수(%d개) %.1f",Icnt, Iavg);
				if (Iavg>Max_Integer) { // 정수 평균 최고 찾기
					Max_Integer = Iavg;
					Max_I_cnt=Icnt;
					Max_Ic=c;
				}
				
				exist = true;
			}
			if(Fcnt>0) {
				Favg = Fsum/Fcnt;
				if(exist) {
					System.out.printf(", ");
				}
				System.out.printf("실수(%d개) %f",Fcnt, Favg);
				if (Favg>Max_Float) { //실수 평균 최고 찾기
					Max_Float = Favg;
					Max_F_cnt = Fcnt;
					Max_Fc=c;
				}
				exist = true;
			}
			if(Scnt>0) {
				Savg = (float)Ssum/Scnt;
				if(exist) {
					System.out.printf(", ");
				}
				System.out.printf("문자열(%d개) %f",Scnt, Savg);
				if (Savg>Max_String) { //문자열 길이 평균 최고 찾기
					Max_String = Savg;
					Max_S_cnt = Scnt;
					Max_Sc=c;
				}
			}
			c++;
			System.out.printf("\n");
			
		}
		System.out.printf("\n");
		
		if(Max_I_cnt>0) System.out.printf("정수 평균 최고 : %d번줄 %f (%d개)\n", Max_Ic, Max_Integer, Max_I_cnt);
		if(Max_F_cnt>0) System.out.printf("실수 평균 최고 : %d번줄 %f (%d개)\n", Max_Fc, Max_Float, Max_F_cnt);
		if(Max_S_cnt>0) System.out.printf("문자열 길이 평균 최고 : %d번줄 %f (%d개)\n", Max_Sc, Max_String, Max_S_cnt);

		
	}
	
	static boolean isInteger(String text) {
		boolean result = false;
		
		Scanner in = new Scanner(text);
		
		result = in.hasNextInt();
		in.close();
		return result;
	}
	
	static boolean isFloat(String text) {
		boolean result = false;
		
		Scanner in = new Scanner(text);
		result = in.hasNextFloat();
		in.close();
		
		return result;
	}
	
	static boolean isString(String text) {
		boolean result = false;
		Scanner in = new Scanner(text);
		result = in.hasNext();
		
		return result;
	}

}
