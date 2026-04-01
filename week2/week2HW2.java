
public class HW4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b;
		char op;
		
		if(args.length==1) {
			System.out.printf("%s = 수식 오류", args[0]);
			System.exit(0);
		}
		 
		if(args.length==2) {
			if ((48 <= (int)args[0].charAt(0) && (int)args[0].charAt(0) <= 57) && (48 <= (int)args[1].charAt(0) && (int)args[1].charAt(0) <= 57)) {
				System.out.printf("%s %s = 연산자 없음", args[0], args[1]);
				System.exit(0);
			}
			else if (((int)args[0].charAt(0)<48 || (int)args[0].charAt(0) > 57) && 48 <= (int)args[1].charAt(0) && (int)args[1].charAt(0) <= 57) {
				System.out.printf("%s%s = 피연산자 부족", args[0], args[1]);
				System.exit(0);
			}
			else if (((int)args[1].charAt(0)<48 || (int)args[1].charAt(0) > 57) && 48 <= (int)args[0].charAt(0) && (int)args[0].charAt(0) <= 57) {
				System.out.printf("%s%s = 피연산자 부족", args[0], args[1]);
				System.exit(0);
			}
		}
		 
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[2]);
		op = args[1].charAt(0);
		

		if(args[1].length()!=1) {
			System.out.printf("%d%s%d = 연산자 오류",a,args[1],b);
			System.exit(0);
		}


		switch (op) {
			case '+':
				System.out.printf("%d%c%d = %d",a,op,b,a+b);
				break;
			
			case '-':
				System.out.printf("%d%c%d = %d",a,op,b,a-b);
				break;
			
			case 'X':
			case 'x':
				System.out.printf("%d%c%d = %d",a,op,b,a*b);
				break;
				
			case '/':
				if(b==0) {
					System.out.printf("%d%c%d = 분모가 0인 오류",a,op,b);
					System.exit(0);
				}
				System.out.printf("%d%c%d = %.3f",a,op,b,(double)a/b);
				break;
				
			case '%':
				if(b==0) {
					System.out.printf("%d%c%d = 분모가 0인 오류",a,op,b);
					System.exit(0);
				}
				System.out.printf("%d%c%d = %d",a,op,b,a%b);
				break;
			default:
				System.out.printf("%d%c%d = 연산자 오류",a,op,b);
			}
			


		
		
		
	}
}
