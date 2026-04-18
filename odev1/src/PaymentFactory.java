public class PaymentFactory {

    public static PaymentMethod create(String type) {
        switch (type.toLowerCase()) {
            case "kredi":
                return new KrediKartiOdeme();
            case "paypal":
                return new PaypalOdeme();
            default:
                throw new IllegalArgumentException("Geçersiz ödeme yöntemi");
        }
    }
}