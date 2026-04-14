package week6;

public class HW3 {

	public static void main(String[] args) {
		float num = Float.parseFloat(args[0]);
		int iPart = (int)num; //정수 부분
		float fPart = num-iPart; //실수 부분
		int lastOne=0;
		
		int[] tmpiArr = new int[16]; 
		int[] iArr = new int[16];
		int[] fArr = new int[16];
		
		for(int i=0; i<16; i++) { // 임시 정수 배열에 이진 수 변환 값 넣기
			tmpiArr[i] = iPart%2;
			iPart = iPart/2;
		}
		
		for(int i=0; i<16; i++) { //정수 배열에 임시 정수 배열 값 뒤집어서 넣기
			iArr[i] = tmpiArr[15-i];
		}
		
		int c=0;
		while(c<16) { // 실수 2진수로 변환
			fPart = fPart*2;
			if(fPart>=1) { //1보다 크면 1 배열에 저장
				fArr[c] = 1;
				fPart = fPart -1;

			}
			else{ // 1보다 작으면 0 저장
				fArr[c] = 0;
			}
			c++;
			
		}
		
		
		for(int i=0; i<16; i++) {
			if(fArr[i]==1) {
				lastOne = i;
			}
		}
		
		for(int i=0; i<16; i++) {
			System.out.printf("%d", iArr[i]);
		}
		System.out.printf(".");
		for(int i=0; i<=lastOne; i++) {
			System.out.printf("%d", fArr[i]);
		}
		
		
	}

}
