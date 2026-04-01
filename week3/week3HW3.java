import java.util.Scanner;

public class HW3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1, str2;
		long l1,l2;
		double d1=0,d2=0;
		char op;
		
		if(args.length==0) { // 프로그램 인자가 없을 때
			System.out.printf("프로그램 인자가 없습니다.");
			System.exit(0);
		}
		if(args.length==1) { // 프로그램 인자 값이 한개밖에 없을 떄
			System.out.printf("%s = 수식 오류", args[0]);
			System.exit(0);
		}
		if(args.length==2) {
			if(((int)args[0].charAt(0)<48) || ((int)args[0].charAt(0)>57) && (48<=(int)args[1].charAt(0) && (int)args[1].charAt(0)<=57)) {
				System.out.printf("%s %s = 피연산자 부족", args[0],args[1]);
				System.exit(0);
			}
			if(((int)args[1].charAt(0)<48) || ((int)args[1].charAt(0)>57) && (48<=(int)args[0].charAt(0) && (int)args[0].charAt(0)<=57)) {
				System.out.printf("%s %s = 피연산자 부족", args[0],args[1]);
				System.exit(0);
			}
			if ((48 <= (int)args[0].charAt(0) && (int)args[0].charAt(0) <= 57) && (48 <= (int)args[1].charAt(0) && (int)args[1].charAt(0) <= 57)) {
				System.out.printf("%s %s = 연산자 없음", args[0], args[1]);
				System.exit(0);
			}
		}
		
		op = args[1].charAt(0);
		str1 = args[0];
		str2 = args[2];
		
		if(!isOperator(op)) { // 정해진 연산자가 아닐 떄
			System.out.printf("%s %s %s = 연산자 오류", str1, args[1], str2);
			System.exit(0);
		}
		
		if(args[1].length()!=1) { // 연산자 길이가 1이 아닐 때
			System.out.printf("%s %s %s = 연산자 오류", str1, args[1], str2);
			System.exit(0);
		}
		
		boolean firstIsLong = isLong(str1); //args[0]이 long이다
		boolean secondIsLong = isLong(str2); //args[2]이 long이다
		boolean firstIsDouble = !firstIsLong && isDouble(str1); // args[0]이 double이다
		boolean secondIsDouble = !secondIsLong && isDouble(str2); // args[2]이 double이다
		
		l1 = firstIsLong ? Long.parseLong(str1) : 0;  //args[0]이 long이다
		l2 = secondIsLong ? Long.parseLong(str2) : 0; //args[2]이 long이다
		d1 = firstIsDouble ? Double.parseDouble(str1) : 0; // args[0]이 double이다
		d2 = secondIsDouble ? Double.parseDouble(str2) : 0; // args[2]이 double이다

		if(op=='%' && (firstIsDouble || secondIsDouble)) {
			System.out.printf("%.3f %c %.3f = %%는 실수에 적용 불가!",firstIsDouble ? d1 : (double)l1 ,op, secondIsDouble ? d2 : (double)l2);
			System.exit(0);
		}
		
		if(firstIsDouble||secondIsDouble) {
			double x = firstIsDouble ? d1 : (double)l1;
			double y = secondIsDouble ? d2 : (double)l2;
			if(op=='/' && y==0) {
				System.out.printf("%.3f %c %.0f = 분모가 0인 오류", x,op,y);
				System.exit(0);
			}
			System.out.printf("%.3f %c %.3f = %.3f", x,op,y,calculateDouble(x, op, y));
		}
		else {
			if((op=='/' || op=='%') && l2==0) {
				System.out.printf("%d %c %d = 분모가 0인 오류", l1, op, l2);
				System.exit(0);
			}
			if(op=='/') {
				System.out.printf("%d %c %d = %.3f", l1,op,l2,(double)l1/l2);
				System.exit(0);
			}
			System.out.printf("%d %c %d = %d", l1,op,l2,calculateLong(l1, op, l2));
		}
	}
	
	
	static double calculateDouble(double d1, char c, double d2) {
		double a,b,result=0;
		a = d1;
		b = d2;
		
		switch (c) {
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case 'x':
		case 'X':
			result = a*b;
			break;
		case '/':
			result = a/b;
			break;
		}
		return result;
	}
	
	static long calculateLong(long l1, char c, long l2) {
		long a,b,result = 0;
		a = l1;
		b = l2;
		
		switch (c) {
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case 'x':
		case 'X':
			result = a*b;
			break;
		case '/':
			result = a/b;
			break;
		case '%':
			result = a%b;
			break;
		}
		return result;
	}
	
	 static boolean isOperator(char c) {
		 boolean result = false;
		 
		 switch (c) {
		case '+':
		case '-':
		case 'x':
		case 'X':
		case '/':
		case '%':
			result = true;
		}
		 return result;
	 }
	 
	 static boolean isLong(String n) {
		 boolean result = false;
		 Scanner in = new Scanner(n);
		 if(in.hasNextLong()) {
			 result = true;
		 }
		 in.close();
		 
		 return result;
	 }
	 
	 static boolean isDouble(String n) {
		 boolean result = false;
		 Scanner in = new Scanner(n);
		 
		 if(in.hasNextDouble()) {
			 result = true;
		 }
		 in.close();
		 
		 return result;
	 }
}
