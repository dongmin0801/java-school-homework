package week5;

import java.util.Scanner;

public class week5HW3 {

	public static void main(String[] args) {
		int[] lowAlpha = new int[26];
		int[] upAlpha = new int[26];
		int[] special = new int[6];
		int space = 0 , n=0;;
		int lineCount = 0;
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) { //EOF 까지 입력
			String line = in.nextLine();
			int length = line.length();
			
			for(int i=0; i<length; i++) {
				char ch = line.charAt(i);

				if(('a'<=ch) && (ch<='z')) { //소문자 확인
					lowAlpha[ch-'a']++;
				}
				if (('A' <= ch) && (ch <= 'Z')) { //대문자 확인
					upAlpha[ch-'A']++;
				}
				if(ch==' ') { // 공백 화인
					space++;
				}
				//소괄호 확인
				if(ch == '(') special[0]++;
				if(ch == ')') special[1]++;
				//중괄호 확인
				if(ch == '{') special[2]++;
				if(ch == '}') special[3]++;
				//대괄호 확인
				if(ch == '[') special[4]++;
				if(ch == ']') special[5]++;
			}
			lineCount++;
		}
		
		lineCount--;
		
		for(int i=0; i<26; i++) { // 소문자 개수 출력
			if(lowAlpha[i]>=1) {
				System.out.printf("%c:%d ", 'a'+i, lowAlpha[i]);
				n++;
				if(n%5 == 0) {System.out.println();}
			}
		}

		for(int i=0; i<26; i++) { // 대문자 개수 출력
			if(upAlpha[i]>=1) {
				System.out.printf("%c:%d ", 'A'+i, upAlpha[i]);
				n++;
				if(n%5==0) {
					System.out.println();
				}
			}
		}
		
		if(special[0]>=1) { // '(' 개수 출력
			System.out.printf("(:%d ", special[0]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(special[1]>=1) { // ')' 개수 출력
			System.out.printf("):%d ", special[1]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(special[2]>=1) { // '{' 개수 출력
			System.out.printf("{:%d ", special[2]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(special[3]>=1) { // '}' 개수 출력
			System.out.printf("}:%d ", special[3]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(special[4]>=1) { // '[' 개수 출력
			System.out.printf("[:%d ", special[4]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(special[5]>=1) { // '(' 개수 출력
			System.out.printf("]:%d ", special[5]);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		
		if(space>=1) { // 공백 개수 출력
			System.out.printf("공백:%d ", space);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
		if(lineCount>=1) { // 줄바꿈 개수 출력
			System.out.printf("줄바꿈:%d", lineCount);
			n++;
			if(n%5==0) {
				System.out.println();
			}
		}
        in.close();
	}

}
