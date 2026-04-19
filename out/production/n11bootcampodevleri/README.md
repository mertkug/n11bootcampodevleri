n11 bootcamp için 1.ödevin açıklama metnidir

Projede SOLID prensiplerine dikkat edilmiştir, 

örneğin interface kullanılarak her yeni payment tipi için yeni kod eklenmesinin önüne geçilmiştir (open closed principle)

Interface sayesinde yeni kod eklemek yerine o interface'i implement eden bir ödeme metodu oluşturmak yeterli olacak

main classında ödeme type ı seçerken factory eklendi (single responsibility)

Factory classının burda sorumluluğu nesne oluşturma sorumluluğunu Main üzerinden almaktır

