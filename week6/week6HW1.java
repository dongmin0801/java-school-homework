package week6;

public class week6HW1 {

	public static void main(String[] args) {
		int a,b,sum=0;
		float avg=0;
		
		try {
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			
			if(a<b && ((2<=a && a<=10000)&&(2<=b && b<=10000))) {
				int prime[] = new int[b-a+1];
				int c=0;
				for(int i= a; i<=b; i++) {
					if(isPrimeNumber(i)) {
						sum+=i;
						prime[c++]=i;
					}
				}
				
				avg = arrAvg(prime, c);
				System.out.printf("소수합계:%d,평균:%.3f", sum, avg);
			}
			else {
				System.out.println("범위오류");
			}	
		} catch (NumberFormatException e) {
			System.out.println("범위오류");
		}catch (Exception e) {
			System.out.println("범위오류");
		}
		
	}
	static float arrAvg(int[] arr, int size) {
		int sum =0;
		for(int i=0; i<size; i++) {
			sum+=arr[i];
		}
		
		return (float)sum/size;
	}
	
	static boolean isPrimeNumber(int n) {
		boolean result = true;
		for(int i=2; i<n; i++) {
			if(n%i==0) {
				result = false;
			}
		}
		
		return result;
	}

}
