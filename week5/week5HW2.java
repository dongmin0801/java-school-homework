package week5;

public class week5HW2 {

	public static void main(String[] args) {
		int line = Integer.parseInt(args[0]); /**/
		int Rcount = Rand.r(1, 100), overAvg=0, underAvg=0; /*랜덤숫자 개수*/
		float avg=0,sum=0; /*랜덤숫자 평균, 합*/
		int[] arr = new int[Rcount]; /*랜덤 숫자 담을 배열*/
		
		for(int i=0; i<Rcount; i++) { /*랜덤 반복으로 랜덤 숫자를 배열에 넣고 합 계산*/
			int num = Rand.r(-100,100);
			arr[i] = num;
			sum+=num;
		}
		
		avg = sum/(float)Rcount; /*배열 값 평균*/
		
		for(int i=0; i<Rcount; i++) { /*배열 출력*/
			if(arr[i]>=avg) {
				overAvg++;
			}
			else if(arr[i]<avg) {
				underAvg++;
			}
			System.out.printf("%3d ", arr[i]);

			if((i+1)%line==0) {
				System.out.printf("\n");
			}
		}
				
		
		System.out.printf("\n\n");
		System.out.printf("평균 : %.3f\n평균 이상 : %3d개\n평균 미만 : %3d개", avg, overAvg, underAvg);
	}
    public class Rand {
	public static int r(int min, int max)  {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}
}
