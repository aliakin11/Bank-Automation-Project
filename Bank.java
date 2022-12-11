
package bankaprojesi1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class Bank {
    public AccountUser[] hesaplarim;
    private int currentIndex = 0;
    private Scanner scan;
    

    public Bank(){
        
        scan = new Scanner(System.in);
        hesaplarim = new AccountUser[4];
        AccountUser hesap = hesapac("Ana Hesap",Account.generateRandom(9));
        hesaplarim[currentIndex++] = hesap;
        
    }

    public void Create_S_ID_balance(){


        System.out.println("Ana Hesap Bakiyeniz: " + hesaplarim[0].getBalance());

        if(hesaplarim[0].getBalance()>=1000)
        {
            hesaplarim[1] = new AccountUser("Kısa Vadeli Hesap",Account.generateRandom(9));
            System.out.println(" Kısa vadeli hesabınız açılıyor..." );
            try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
            System.out.println("Hesabınız Oluşturuldu");
            System.out.println("Hesap numaranız: "+  hesaplarim[1].getId());
            hesaplarim[1].Benefit(17,hesaplarim[1]);
        }
        else
            System.out.println(" 1000 TL'nin altında hesap açamazsınız . Lütfen yeterli parayı yatırınız.");

    }

    public void Create_L_ID_balance(){
        System.out.println("Ana Hesap Bakiyeniz: "+ hesaplarim[0].getBalance());

        if(hesaplarim[0].getBalance() >= 1500)
        {
            hesaplarim[2] = new AccountUser("Uzun Vadeli Hesap",Account.generateRandom(9));
            System.out.println("Uzun vadeli hesabınız açılıyor...");
            try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
            System.out.println("Hesabınız Oluşturuldu");
            System.out.println("Hesap Numaranız: "+hesaplarim[2].getId());
            hesaplarim[2].Benefit(24,hesaplarim[2]);
        }
        else{

            System.out.println("1500 TL'nin altında hesap açamazsınız. Lütfen yeterli parayı yatırınız.");
        }
    }

    public void Create_O_ID_balance(){
        
        hesaplarim[3] = new AccountUser("Ozel Hesap",Account.generateRandom(9));
        System.out.println("Özel hesabınız açılıyor");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        System.out.println("Hesap numaranız:"+hesaplarim[3].getId());
        hesaplarim[3].Benefit(12,hesaplarim[3]);

    }

    public void Increase_ID_cash(AccountUser accountUser,double cash){
        if(cash >= 0)
        accountUser.deposit();
        else{
            System.out.println("Lütfen geçerli bir tutar giriniz."); 
        }
    }

    public void Decrease_ID_cash(AccountUser accountUser,double cash){
        // çekmek istenilen tutar hesapta varmı eğer yok ise çekilme işlemi olmayacak eğer var ise çekilecek
        if(cash > hesaplarim[currentIndex].getBalance())
        accountUser.withdraw();
        else{
            System.out.println("Bu hesap türünüzde çekilecek yeterli bakiye bulunmamaktadır."); 
        }
    }

    public void Set_dd_mm_yy(){
        System.out.println("\t\t\t\t\t\t  Tarih güncellemeleri yapıldı");
  Date objDate = new Date(); 
  String strDateFormat = "hh:mm:ss a dd-MMM-yyyy"; 
  SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
  System.out.println(objSDF.format(objDate)); //Tarih biçimlendirme geçerli tarihe uygulanır
  
        
    }

    public void ShowAccount(){
        for (int i = 0; hesaplarim[i] != null ; i++){
            System.out.println("Hesap Turu: " + hesaplarim[i].GetAccountType());
            System.out.println("Hesap Numarasi: " + hesaplarim[i].getId());
            System.out.println("Hesap Bakiyesi: " + hesaplarim[i].getBalance());
            System.out.println("----------------");
        }
    }

    public void ShowIDs(){
        for (int i = 0; i < hesaplarim.length ; i++){
            System.out.println("Hesap Numarasi: " + hesaplarim[i].getId());
            System.out.println("----------------");
        }
    }

    public void login(){

        int password;
        System.out.println("Merhaba Bankamıza Hoşgeldiniz");
        System.out.println("Bankamızın size özel tekliflerini öğrenmek için lütfen 0212 544 20 85 numaralı müşteri hizmetlerimizden yardım alınız");
        System.out.println("Lütfen şifrenizi giriniz:");
        password = scan.nextInt();
        System.out.println("Lütfen bekleyiniz...");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        for (int i = 1; i <4; i++) {
            if (password==123321){
                try {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (Exception e) {
                    System.out.println("Oops! Something went wrong!");
                }
                System.out.println("Sifreniz doğru,başarılı bir şekilde giriiş yaptınız!");
                break;
            }
            else if (i==3) {
                System.out.println("Cok Sayıda Hatalı Sifre Girdiniz Sistemden Cıkılıyor...");
                System.exit(0);
            }
            else {
                System.err.println("Hatalı Sifre Girdiniz!");
                System.err.println("Lütfen sifrenizi giriniz:");
                password=scan.nextInt();

            }
        }        
        while(true)
            switch(menu()) {
                case 1:
                    AccountTypeSelection(1);
                    break;
                case 2:
                    AccountTypeSelection(2);
                    break;
                case 3:
                    Create_S_ID_balance();
                    break;
                case 4:
                    Create_L_ID_balance();
                    break;
                case 5:
                    Create_O_ID_balance();
                    break;
                case 6:
                    ShowAccount();
                    break;
                default:
                    System.out.println("Çıkış yapılıyor  \n");
                    break;

            }}

    public int menu(){

        System.out.println("1.Para yatırma");
        System.out.println("2.Para çekme");
        System.out.println("3.Kısa vadeli hesap açma---------->Bu hesap türü yıllık %24 faiz verir fakat hesabınızda en az 1000 TL bakiye olması gerekiyor");
        System.out.println("4.Uzun vadeli hesap açma---------->Bu hesap türü yıllık %24 faiz verir fakat hesabınızda en az 1500 TL bakiye olması gerekiyor.");
        System.out.println("5.Özel hesap açma ---------------->Bu hesap türü yıllık %12 faiz verir fakat hesap açıldığında mevcut olan bakiyeniz kadar bakiyeniz bulunması gerekiyor.");
        System.out.println("6.Hesaplarımı Görüntüle");
        System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
        int value=scan.nextInt();
        if(value < 0 || value > 6){

            System.out.println("Lütfen geçerli bir işlem seçiniz.");
            value=scan.nextInt();
        }
        return value;
    }

    public AccountUser hesapac(String hesapturu,Object accountid){

        AccountUser hesap = new AccountUser(hesapturu,accountid);
        return hesap;
    }

    public void AccountTypeSelection(int number){

        if (number == 1){
            System.out.println("İslemler:  ");
            System.out.println("Ana hesaba para yatirmak icin 0 tuslayin");
            System.out.println("Kısa Vadeli hesaba para yatirmak icin 1 tuslayin");
            System.out.println("Uzun Vadeli hesaba para yatirmak icin 2 tuslayin");
            System.out.println("Ozel hesaba para yatirmak icin 3 tuslayin");
            int index = scan.nextInt();
            if (AccountControl(index)){
                SelectedAccountDeposit(index);
            }
            else{
                System.out.println("Para yatırmak istediginiz hesap turune ait bir hesabınız bulunmamaktadır..");
            }

        }

        if (number == 2){
            System.out.println("İslemler:  ");
            System.out.println("Ana hesaptan para cekmek icin 0 tuslayin");
            System.out.println("Kısa Vadeli hesaptan para cekmek icin 1 tuslayin");
            System.out.println("Uzun Vadeli hesaptan para cekmek icin 2 tuslayin");
            System.out.println("Ozel hesaptan para cekmek icin 3 tuslayin");
            int index = scan.nextInt();

            if (AccountControl(index)){
                SelectedAccountwithdraw(index);
            }
            else{
                System.out.println("Para cekmek istediginiz hesap turune ait bir hesabınız bulunmamaktadır..");
            }
            
        }

    }

    public boolean AccountControl(int index){
        return hesaplarim[index] != null ? true : false;
    }

    public void SelectedAccountwithdraw(int selectAccountIndex){
        hesaplarim[selectAccountIndex].withdraw();
    }

    public void SelectedAccountDeposit(int selectAccountIndex){
        hesaplarim[selectAccountIndex].deposit();
    }

}
