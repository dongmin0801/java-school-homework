package week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) throws FileNotFoundException {
		int c=0, c2=0;
		
		char type = args[0].charAt(4); //파일 종류
		String a=""; 
		if(type=='1') { // 파일 정하기
			a = "HW2_1.txt";
		}
		if(type=='2') {
			a = "HW2_2.txt";
		}
		if(type=='3') {
			a = "HW2_3.txt";
		}
		
		File in_f = new File(a);
		Scanner in = new Scanner(in_f);
		while(in.hasNext()) { //배열 길이 구하기
			in.nextLine();
			c++;
		}
		in.close();
		String[] name = new String[c]; //성 담을 배열
		
		in = new Scanner(in_f);
		while(in.hasNext()) { // 배열에 성 담기
			String line = in.nextLine();
			
			name[c2]=line;
			c2++;
		}
		
		name = sort(name, true); //배열 정렬
		
		
		
		
		
		char prev = name[0].charAt(0); //이전 성
		int cnt = 1;
		int max = 0;
		int min = name.length;
		int k =0;
		int l =0;
		
		char[] maxSurname = new char[name.length];
		char[] minSurname = new char[name.length];
		
		for(int i=1; i<name.length; i++) {// 성 개수 더하기
			char next = name[i].charAt(0);
			
			if(prev==next) { // 공통 성이면 ++
				cnt++;
			}
			else {
				System.out.printf("%c : %d\n", prev, cnt);
				if(cnt> max) { //가장 많은 성 찾기
					max = cnt;
					k=0;
					maxSurname[k++] = prev;
				}else if(cnt==max) {
					maxSurname[k++] = prev;
				}
				if(min>cnt) { //가장 적은 성 찾기
					min = cnt;
					l = 0;
					minSurname[l++] = prev;
				}else if(cnt==min) {
					minSurname[l++] = prev;
				}
				
				prev = next; // 다음 이름으로 넘어가기
				cnt = 1;
			}	
		}
		//가장 많은 이름..
		
		System.out.printf("%c : %d\n", prev, cnt);
		
		System.out.printf("가장 많은 성 : %s", maxSurname[0]);
		for(int i=1; i<k; i++) {
			System.out.printf(", %c", maxSurname[i]);
		}
		System.out.println();
		
		System.out.printf("가장 적은 성 : %s", minSurname[0]);
		for(int i=1; i<l; i++) {
			System.out.printf(", %c", minSurname[i]);
		}
		
		System.out.println();
		
		System.out.printf("가장 많은 이름 : ");
		
	}
	
	
	public static String[] sort(String[] s, boolean asc) {
		String[] S2 = Arrays.copyOf(s, s.length);
		for(int i=S2.length; i>0 && MaxLast(S2, i, asc); i--);
		
		return S2;
	}
	
	
	public static boolean MaxLast(String[] s, int size, boolean asc) {
		boolean sorted = false;
		for(int i=0; i<size-1; i++) {
			if((s[i].compareTo(s[i+1]) > 0 && asc) || (s[i].compareTo(s[i+1]) < 0 && !asc)) {
				swap(s, i, i+1);
				sorted = true;
			}
		}
		return sorted;
	}
	
	public static void swap(String[] s, int i, int j) {
		String tmp = "";
		tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}

}
