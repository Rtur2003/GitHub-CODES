import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("--Sürekli Hesap Makinesi (Çıkış için '=' basınız)-- ");
        System.out.println("Başlangıç sayısını giriniz: ");

        double sonuc ;
        try {
            sonuc = scan.nextDouble(); 
        }catch (java.util.InputMismatchException e) {
            System.out.println("hata: Geçersiz sayı girdiniz lütfen düzeltin.");
            scan.close();
            return;
        }
        
        while (true) { 
            System.out.println("İşlem giriniz (+,-,*,/,=): ");
            String girdi = scan.next();

            if(girdi.equals("=")) {
                break;
            }

            char islem = girdi.charAt(0);
            
           if (islem != '+' && islem != '-' && islem != '*' && islem != '/') {
                System.out.println("Hata: Geçersiz işlem girilmiştir. Lütfen belirtilen operatörlerden birini seçiniz.");
                continue;
        }

        System.out.println("Bir sonraki sayıyı girin: ");
            double yeniSayi;

            try {
                yeniSayi = scan.nextDouble(); 
            } catch (java.util.InputMismatchException e) {
                System.out.println("Hata: Geçersiz sayı girdiniz. Lütfen düzeltin.");
                scan.next(); // Hatalı girdiyi tüket
                continue; // Döngünün başına dön
            }

        switch (islem) {
            case '+':
                sonuc += yeniSayi;
                break;
            case '-':
                sonuc -= yeniSayi;
                break;
            case '*':
                sonuc *= yeniSayi;
                break;
            case '/':
                if(yeniSayi == 0) {
                     System.out.println("hata: Geçersiz sayı girdiniz lütfen düzeltin.");
                  continue;
                }
                sonuc /= yeniSayi;
                break;

        }
       
    }

        System.out.println("-----------------------");
        System.out.println("Nihai sonuç : " + sonuc);

        scan.close();


    }
    
}
