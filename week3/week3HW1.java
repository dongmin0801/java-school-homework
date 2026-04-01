
public class HW5 {
	
	public static void main(String[] args) {
		
		int total,
		won50000 =0, won10000 =0, won5000 =0, won1000 =0, won500 =0, won100 =0, won50 =0, won10 =0, won5 =0, won1 = 0;
		
		total = Integer.parseInt(args[0]);
		
		won50000 = total/50000;
		total-=50000*won50000;
						
		won10000 = total/10000;
		total-=10000*won10000;
			
		won5000 = total/5000;
		total-=5000*won5000;
			
		won1000 = total/1000;
		total-=1000*won1000;
			
		won500 = total/500;
		total-=500*won500;
			
		won100 = total/100;
		total-=100*won100;
		
		won50 = total/50;
		total-=50*won50;
			
		won10 = total/10;
		total-=10*won10;

		won5 = total/5;
		total-=5*won5;
		
		won1 = total/1;
		total-=1*won1;
			
		
		boolean exist = false;

		System.out.printf("%s원은 ", args[0]);
		if(won50000>0) {
			System.out.printf("오만원 %d장", won50000);
			exist = true;
			
		}
		if(won10000>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("만원 %d장", won10000);
			exist = true;
		}
		if(won5000>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("오천원 %d장", won5000);
			exist = true;
		}
		if(won1000>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("천원 %d장", won1000);
			exist = true;
		}
		if(won500>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("오백원 동전 %d개", won500);
			exist = true;
		}
		if(won100>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("백원 동전 %d개", won100);
			exist = true;
		}
		if(won50>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("오십원 동전 %d개", won50);
			exist = true;
		}
		if(won10>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("십원 동전 %d개", won10);
			exist = true;
		}
		if(won5>0){
			if(exist){
				System.out.printf(" , ");
			}
			System.out.printf("오원 동전 %d개", won5);
			exist = true;
		}
		if(won1>0){
			if(exist) {
				System.out.printf(" , ");
			}
			System.out.printf("일원 동전 %d개", won1);
			exist = true;
		}
		
		System.out.printf("이다.");
	}

}
