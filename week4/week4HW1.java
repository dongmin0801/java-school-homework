import java.util.Scanner;

public class week4HW1 {

	public static void main(String[] args) {
		int count=0;
		double dollarEx, euroEx, yenEx, sum=0;
		String currencyType;
		
		dollarEx = Double.parseDouble(args[0]); //달러 환율
		euroEx = Double.parseDouble(args[1]); //유로 환율
		yenEx = Double.parseDouble(args[2]); //엔 환율
		currencyType = args[3]; //환산 할 돈 종류
		
		if(!currencyCheck(currencyType)) {
			System.out.printf("올바른 통화명을 적어주십시오\n");
			System.exit(0);
		}
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int total; //환전할 돈 총액
			String currency; //환전할 돈 종류
						
			total = in.nextInt();
			currency = in.next();
			
			if(!currencyCheck(currency)) {
				System.out.printf("올바른 통화명을 적어주십시오\n");
				continue;
			}
			switch (currencyType) { //args[3]의 돈 종류에 따라 환전 방식 변경
			case "dollar":
				System.out.printf("%d %s -> %.3f %s\n", total, currency, exchangeDollar(total, dollarEx, yenEx, euroEx, currency), currencyType);
				count++;
				sum+=exchangeDollar(total, dollarEx, yenEx, euroEx, currency);
				break;
			case "euro":
				System.out.printf("%d %s -> %.3f %s\n", total, currency, exchangeEuro(total, dollarEx, yenEx, euroEx, currency), currencyType);
				count++;
				sum+=exchangeEuro(total, dollarEx, yenEx, euroEx, currency);
				break;
			case "yen":
				System.out.printf("%d %s -> %.3f %s\n", total, currency, exchangeYen(total, dollarEx, yenEx, euroEx, currency), currencyType);
				count++;
				sum+=exchangeYen(total, dollarEx, yenEx, euroEx, currency);
				break;
			case "won":
				System.out.printf("%d %s -> %.3f %s\n", total, currency, exchangeWon(total, dollarEx, yenEx, euroEx, currency), currencyType);
				count++;
				sum+=exchangeWon(total, dollarEx, yenEx, euroEx, currency);
				break;				
			default:
				break;
			}
		}
		
		if(count>0) {
			System.out.printf("합계 : %.3f %s\n", sum, currencyType);
			System.out.printf("평균 : %.3f %s\n", sum/count, currencyType);	
		}
		
		
	}
	
	public static double exchangeDollar(int total ,double dollarEx, double yenEx, double euroEx, String currency) { /*달러로 변환 total == 환전 할 돈 총액, currency == 환전 할 돈 종류
																								, dollarEx == 달러 환율 yenEx == 엔 환율, euroEx == 유로 환율 */ 
		
		switch (currency) {
		case "dollar":
			return (double)total;
		case "won":
			return total/dollarEx;
		case "yen":
			return total*(yenEx/100)/dollarEx;
		case "euro":
			return total*euroEx/dollarEx;
		default:
			System.out.printf("알맞는 단위를 적으시오");
			return 0;
		}
	}

	public static double exchangeWon(int total, double dollarEx, double yenEx, double euroEx,String currency) { /*달러로 변환 total == 환전 할 돈 총액, currency == 환전 할 돈 종류
	 																							, dollarEx == 달러 환율 yenEx == 엔 환율, euroEx == 유로 환율*/

		switch (currency) {
		case "dollar":
			return dollarEx * total;
		case "won":
			return (double)total;
		case "yen":
			return total * (yenEx / 100);
		case "euro":
			return total * euroEx;
		default:
			System.out.printf("알맞는 단위를 적으시오");
			return 0;
		}
	}

	public static double exchangeEuro(int total, double dollarEx, double yenEx, double euroEx,String currency) { /*달러로 변환 total == 환전 할 돈 총액, currency == 환전 할 돈 종류
	 																							, dollarEx == 달러 환율 yenEx ==엔 환율, euroEx == 유로 환율*/

		switch (currency) {
		case "dollar":
			return total * dollarEx / euroEx;
		case "won":
			return total / euroEx;
		case "yen":
			return total * (yenEx / 100) / euroEx;
		case "euro":
			return (double)total;
		default:
			System.out.printf("알맞는 단위를 적으시오");
			return 0;
		}
	}

	public static double exchangeYen(int total, double dollarEx, double yenEx, double euroEx,String currency) { /*달러로 변환 total == 환전 할 돈 총액, currency == 환전 할 돈 종류
	 																					, dollarEx == 달러 환율 yenEx==엔 환율, euroEx == 유로 환율*/

		switch (currency) {
		case "dollar":
			return total * dollarEx / (yenEx/100);
		case "won":
			return total / (yenEx/100);
		case "yen":
			return (double)total;
		case "euro":
			return total * euroEx / (yenEx/100);
		default:
			System.out.printf("알맞는 단위를 적으시오");
			return 0;
		}
	}
	static boolean currencyCheck(String s) { // 통화명 확인
		boolean result = false;
		
		switch (s) {
		case "dollar":
			result = true;
			break;
		case "euro":
			result = true;
			break;
		case "yen":
			result = true;
			break;
		case "won":
			result = true;
			break;
		default:
			result = false;
			break;
		}
		return result;
	}
}
