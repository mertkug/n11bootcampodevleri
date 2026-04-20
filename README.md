# odev-1

n11 bootcamp için 1.ödevin açıklama metnidir

Projede SOLID prensiplerine dikkat edilmiştir

örneğin interface kullanılarak her yeni payment tipi için mevcut kodu bozmanın önüne geçilmiştir, burada open closed principle'a dikkat edilmeye çalışılmıştır

bu yapı sayesinde yeni kod eklemek yerine o interface'i implement eden yeni bir ödeme metodu oluşturmak yeterli oluyor

main classında ödeme type'ını seçme ve nesne oluşturma işini direkt bırakmak yerine factory yapısı kullanıldı, burada da single responsibility tarafı korunmaya çalışıldı

PaymentFactory classının sorumluluğu ilgili ödeme nesnesini üretmektir, Main ise sadece akışı başlatır ve kullanıcıdan veriyi alır

projede ek olarak spring mantığına benzer çok küçük bir ApplicationContext yapısı kuruldu

buradaki amaç bean oluşturma ve dependency yönetimi mantığını basit bir şekilde göstermektir

ApplicationContext reflection kullanarak @Component ile işaretlenen classları oluşturur

PaymentService nesnesi de kendi dependency'sini constructor üzerinden alır, böylece nesne üretimi sınıfların içinden çıkıp daha merkezi bir yapıya taşınmış olur

PaymentFactory içinde kredi ve paypal payment methodları map'e eklenir, kullanıcı hangi type'ı girdiyse ilgili nesne buradan alınır

bu sayede hem yeni payment methodu eklemek daha kolay hale gelir hem de kodun sorumlulukları daha net ayrılmış olur

çalıştırmak için proje klasöründe aşağıdaki komutlar kullanılabilir

`javac odev1\src\*.java`

`java -cp odev1\src Main`
