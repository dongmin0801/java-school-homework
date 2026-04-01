import java.util.Scanner;

public class HW3 {

	public static void main(String[] args) {
		int a,b,c, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, mid = 0;
		
		Scanner in = new Scanner(System.in);
		
		

		System.out.printf("세 정수 입력 : ");
		
		while(in.hasNextInt()) {
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			
			if(a<=b && a<=c) {
				min = a;
				if(b<=c) {
					max = c;
					mid = b;
				}
				else {
					max = b;
					mid = c;
				}
				
			}
			
			else if(b<=a && b<=c) {
				min = b;
				if(a<=c) {
					max = c;
					mid = a;
				}
				else {
					max = a;
					mid = c;					
				}

			}
			
			else if(c<=a && c<=b) {
				min = c;
				if(a<=b) {
					max = b;
					mid = a;
				}
				else {
					max = a;
					mid = b;					
				}

			}
			
			
			if(min == mid && mid == max) {
				System.out.printf("결과 : %d = %d = %d\n", min, mid, max);
			}
			else if(min < mid && mid < max) {
				System.out.printf("결과 : %d < %d < %d\n", min, mid, max);
			}
			else if(min < mid && mid == max) {
				System.out.printf("결과 : %d < %d = %d\n", min, mid, max);
			}
			else if(min == mid && mid < max) {
				System.out.printf("결과 : %d = %d < %d\n", min, mid, max);
			}
			
			System.out.printf("세 정수 입력 : ");

		}
		

		
		
	}
}