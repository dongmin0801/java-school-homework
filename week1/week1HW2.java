import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int c = 0, num = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		float avg;
		
		while(in.hasNext()) {
			num = in.nextInt();
			sum+=num;
			c++;
			
			if(num>max) {
				max = num;
			}
			if(num<min) {
				min = num;
			}
			
		}
		
		avg = (float)sum/c;
		
		System.out.printf("총 입력 정수 : %d\n",c);
		System.out.printf("총합 : %d, 평균 : %.3f\n",sum, avg);
		System.out.printf("가장 큰 수 : %d \n",max);
		System.out.printf("가장 작은 수 : %d",min);
	}

}
