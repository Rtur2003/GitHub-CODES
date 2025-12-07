## Continuous CLI Calculator

Basit, sürekli çalışan bir komut satırı hesap makinesi. Toplama, çıkarma, çarpma ve bölme yapar; hatalı girişleri yakalar ve Türkçe mesajlarla kullanıcıyı yönlendirir.

## Gereksinimler
- Java 17+
- Maven 3.9+

## Çalıştırma
```bash
mvn clean package
mvn -q exec:java
# veya
java -cp target/classes app.App
```

Örnek oturum:
```
=== Sürekli Hesap Makinesi ===
Başlangıç sayısını girin:
10
İşlem girin (+, -, *, /). Bitirmek için '=' veya 'q' yazın:
+ 
Bir sonraki sayıyı girin:
5
Ara sonuç: 15.0
...
Nihai sonuç: 30.0
```

Çıkmak için `=` veya `q/quit/exit` yazabilirsiniz. Geçersiz girişlerde uygulama hata mesajı verip ilerlemeye devam eder.

## Testler
```bash
mvn test
```

## Yapı
- Maven standart dizinleri (`src/main/java`, `src/test/java`)
- Uygulama paketi: `app`
- Başlangıç sınıfı: `app.App`
