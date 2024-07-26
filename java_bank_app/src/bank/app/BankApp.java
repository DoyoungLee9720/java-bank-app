package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("--------------------------------------------");
			
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(scanner.nextLine());
			if(selectNo == 1) {
				createAccount();
			}else if(selectNo == 2) {
				accountList();
			}else if (selectNo== 3) {
				deposit();
			}else if (selectNo == 4) {
				withdraw();
			}else if(selectNo ==5) {
				run=false;
			}
			 
		}
		System.out.println("프로그램 종료");
	}
	
	
	
	private static void createAccount() {
		System.out.println("--------------------계좌생성-------------------");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		
		System.out.print("계좌주 : ");
		String owner = scanner.nextLine();
		
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();
		
		System.out.println("결과: 계좌가 생성되었습니다.");
		Account account = new Account(ano,owner,balance);
		accounts.add(account);
		scanner.nextLine();
	}
	private static void accountList() {
		System.out.println("--------------------계좌목록-------------------");
		
		for(Account A : accounts) {
			System.out.println(A.getAno() + " " + A.getOwner() + " " + A.getBalance());
		}
	}
	
	private static void deposit() {
		System.out.println("---------------------예금---------------------");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		Account ac = findAccount(ano);
		if(ac==null) {
			System.out.println("결과: 계좌가 없습니다.");
		}
		else {
			System.out.print("예금액 : ");
			int balance = scanner.nextInt();
			System.out.println("결과: 예금이 생성되었습니다.");
			int hap = ac.getBalance()+balance;
			ac.setBalance(hap);
			
		}
		scanner.nextLine();
		
	}
	
	private static void withdraw() {
		System.out.println("---------------------출금---------------------");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		Account ac = findAccount(ano);
		if(ac==null) {
			System.out.println("결과: 계좌가 없습니다.");
		}
		else {
			System.out.print("출금액 : ");
			int balance = scanner.nextInt();
			if(ac.getBalance()<balance) {
				System.out.println("결과 : 출금할 잔액이 부족합니다");
			}
			else {
				System.out.println("결과: 출금이 성공되었습니다.");
				int hap = ac.getBalance()-balance;
				ac.setBalance(hap);
			}
			
		}
		scanner.nextLine();
	}
	
	private static Account findAccount(String ano) {
		for(Account A : accounts) {
			if(A.getAno().equals(ano)) {
				return A;
			}
		}
		return null;
		
	}
}
