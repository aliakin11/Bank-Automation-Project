
package bankaprojesi1;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Account {

    private String AccountType;
    private double balance;
    private int amount;
    private int id;
    

    Scanner scan = new Scanner(System.in);

    public String GetAccountType(){
        return AccountType;
    }

    public void SetAccountType(String AccountType){
        this.AccountType = AccountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double deposit(){
        System.out.print("Yatırmak İstediğiniz Tutarı Giriniz: ");
        amount = scan.nextInt();
        do {

            if (amount < 0) {

                System.out.println("Geçersiz İşlem Tekrar Deneyiniz. ");
                System.out.print("Yatırmak İstediğiniz Tutarı Giriniz: ");
                amount = scan.nextInt();
            }

        }
        while(amount < 0);
        balance = balance + amount;
        System.out.println("İşlem başarılı!");
        System.out.println("Yeni bakiyeniz:"+ getBalance());
        return balance;
    }

    public void withdraw(){

        System.out.print("Çekmek İstediğiniz Tutarı Giriniz: ");
        int tutar = scan.nextInt();
        if(getBalance() >= tutar && tutar >= 0) {
            balance = balance - tutar;
            System.out.println("Kalan Hesap Bakiyeniz: " + getBalance());

        }

        else if(tutar < 0)

        {

            System.out.println("Lütfen geçerli bir sayı giriniz ");

        }
        else  {

            System.out.println(" Hesap Bakiyenizde "+ tutar +" TL Tutarında Para Mevcut Değildir. ");

        }
    }

    public void Benefit(double interestrate, AccountUser accountUser){
        double dailybenefit;
        double annualbenefit;
        double newamount;
        final double daysofyear = 365.0;


        String date = "2022-02-14";
        LocalDate time = LocalDate.parse(date);
        LocalDate fat = LocalDate.now();
        System.out.println("Yatırmak istediğiniz tutarı giriniz:  ");
        newamount = scan.nextDouble();
        accountUser.setBalance(newamount);
        newamount = newamount + accountUser.getBalance();
        dailybenefit = (newamount/100)*(interestrate/daysofyear);
        System.out.println("Günlük getiri: " + dailybenefit + "TL");
        annualbenefit=dailybenefit*daysofyear;
        System.out.println("Yıllık getiri: " + annualbenefit + "TL");
        System.out.println("Bugüne kadar elde edilen kâr: " + (dailybenefit*(fat.getDayOfYear()-time.getDayOfYear())) + "TL");

    }

    public static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}
