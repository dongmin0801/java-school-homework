
public class HW2 {

	public static void main(String[] args) {
		String shiftType;
		long operand;
		int number,size=0,start,count;

		
		if(args.length==3) { //r_shift , l_shift, r_ashift
			shiftType = args[0];
			operand = Long.parseLong(args[1]);
			number = Integer.parseInt(args[2]);
			if(!isShiftType(shiftType)) {
				System.out.printf("명령어 오류 !!!");
				System.exit(0);
			}

			if(operand>= -128&&operand<=127) size = Byte.SIZE-1;
			else if(operand>= -32768&&operand<=32767) size = Short.SIZE-1;
			else if(operand>=-2147483648&&operand<=2147483647) size = Integer.SIZE-1;
			else size = Long.SIZE-1;
			
			
			switch (shiftType) {
			case "l_shift":
				if(number > size) {
					System.out.printf("시프트 횟수 오류 !!!\n");
					System.exit(0);
				}
				System.out.printf("%s << %d = %s", getBinery(operand, size),number,getBinery(operand<<number, size));
				break;
			case "r_ashift":
				if(number > size) {
					System.out.printf("시프트 횟수 오류 !!!\n");
					System.exit(0);
				}
				System.out.printf("%s >> %d = %s", getBinery(operand,size ),number,getBinery(operand>>number, size));
				break;
			case "r_shift":
				if(number > size) {
					System.out.printf("시프트 횟수 오류 !!!\n");
					System.exit(0);
				}
				System.out.printf("%s >> %d = %s", getBinery(operand, size),number,getBinery(operand>>>number, size));
				break;
			default:
				break;
			}
		}
		else if(args.length==4) { //extract, clear, set, complement
			shiftType = args[0];
			operand = Long.parseLong(args[1]);
			start = Integer.parseInt(args[2]);
			count = Integer.parseInt(args[3]);
			if(!isShiftType(shiftType)) {
				System.out.printf("명령어 오류 !!!");
				System.exit(0);
			}
			
			if(operand>= -128&&operand<=127) size = Byte.SIZE-1;
			else if(operand>= -32768&&operand<=32767) size = Short.SIZE-1;
			else if(operand>=-2147483648&&operand<=2147483647) size = Integer.SIZE-1;
			else size = Long.SIZE-1;
			
			switch (shiftType) {
			case "extract":
				System.out.printf("%s => %s",getBinery(operand, size), getExtract(operand, start, count));				
				break;
			case "clear":
				System.out.printf("%s => %s",getBinery(operand, size), getClear(operand, start, count, size));
				break;
			case "set":
				System.out.printf("%s => %s",getBinery(operand, size), getSet(operand, start, count, size));
				break;
			case "complement":
				System.out.printf("%s => %s",getBinery(operand, size), getComplement(operand, start, count, size));
				break;
			default:
				break;
			}
		}
		
		
	}
	
	static String getBinery(long n, int size) {
		String tmp = "";
		
		for(int i = size; i>=0; i-- ) {
			tmp += (n>>>i)&1;
			if(i%8==0 && i!=0) {
				tmp+='_';
			}
		}
		
		return tmp;
	}

	static boolean isShiftType(String s) {
		boolean result = false;
		
		switch (s) {
		case "r_shift": // 우측 논리 쉬프트
			result = true;
			break;
		case "r_ashift": // 우측 산술 쉬프트
			result = true;
			break;
		case "l_shift": //좌측 쉬프트
			result = true;
			break;
		case "extract":
			result = true;
			break;
		case "clear":
			result = true;
			break;
		case "set":
			result = true;
			break;
		case "complement":
			result = true;
			break;
		default:
			break;
		}
		
		return result;
	}
	
	static String getClear(Long operand, int start, int count, int size) {
		String tmp = "";
		if(start-1+count>size) {
			System.out.printf("피연산자 범위 오류 !!!\n");
			System.exit(0);
		}
		
		for(int i=size; i>=0; i--) {
			if(i>=start-1 && i<=start+count-2) {
				tmp+=0;
			}
			else {
				tmp+=(operand>>i)&1;
			}
			if(i%8==0 && i!=0) {
				tmp+= '_';
			}
		}

		
		
		return tmp;
	}
	
	static String getSet(Long operand, int start, int count, int size) {
		String tmp = "";
		if(start-1+count>size) {
			System.out.printf("피연산자 범위 오류 !!!\n");
			System.exit(0);
		}
		for(int i=size; i>=0; i--) {
			if(i>=start-1 && i<=start+count-2) {
				tmp+=1;
			}
			else {
				tmp+=(operand>>i)&1;
			}
			if(i%8==0 && i!=0) {
				tmp+= '_';
			}
		}
		return tmp;
	}
	
	static String getExtract(Long operand, int start, int count) {
		String tmp = "";
		if(start-1+count<0) {
			System.out.printf("피연산자 범위 오류 !!!\n");
			System.exit(0);
		}
		for(int i=start+count-2; i>=start-1; i--) {
			tmp += (operand>>i)&1;
		}
		
		return tmp;
		
	}
	static String getComplement(Long operand, int start, int count, int size) {
		String tmp = "";
		if(start-1+count>size) {
			System.out.printf("피연산자 범위 오류 !!!\n");
			System.exit(0);
		}
		for(int i=size; i>=0; i--) {
			if(i>=start-1 && i<=start+count-2) {
				tmp+=((operand>>i)&1)^1;
			}
			else {
				tmp+=((operand>>i)&1);
			}
			if(i%8==0 && i!=0) {
				tmp+= '_';
			}
		}
		
		return tmp;
	}
}
