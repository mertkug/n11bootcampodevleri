public class KrediKartiOdeme implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.println("Kredi kartı ile ödeme alındı: " + amount + " TL");
        return true;
    }
}
