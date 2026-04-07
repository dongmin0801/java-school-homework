package week5;

public class week5HW1 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		
		for(int i=0; i<num/2; i++) {
			for(int j=0; j<i; j++) {
				System.out.print('-');
			}
			System.out.print('o');
			for(int k=0; k<num-i-i-2; k++) {
				System.out.print('-');
			}
			System.out.print('o');
			for(int l=0; l<i; l++) {
				System.out.print('-');
			}
			System.out.println();
		}
		
		if(num%2==1) { //num이 홀수일때
			for(int i=0; i<num/2; i++) {
				System.out.print('-');
			}
			System.out.print('o');
			for(int i=0; i<num/2; i++) {
				System.out.print('-');
			}
			System.out.println();
			
			for(int i=0; i<num/2; i++) {
				for(int j=0; j<num/2-i-1; j++) {
					System.out.print('-');
				}
				System.out.print('o');
				for(int k=num/2; k<=num/2+i*2; k++) {
					System.out.print('-');
				}

				System.out.print('o');
				for(int l=1; l<num/2-i; l++) {
					System.out.print('-');
				}
				System.out.println();
			}
			
		}
		if(num%2==0) {
			for(int i=0; i<num/2; i++) {
				for(int j=0; j<num/2-i-1; j++) {
					System.out.print('-');
				}
				System.out.print('o');
				for(int k=num/2; k<num/2+i*2; k++) {
					System.out.print('-');
				}

				System.out.print('o');
				for(int l=1; l<num/2-i; l++) {
					System.out.print('-');
				}
				System.out.println();
            }
		}
	}

}
