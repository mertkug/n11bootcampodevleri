import java.util.Map;

public class PaymentFactory {
    private static final Map<String, String> PAYMENT_CLASSES = Map.of(
            "kredi", "KrediKartiOdeme",
            "paypal", "PaypalOdeme"
    );

    public static PaymentMethod create(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi");
        }

        String className = PAYMENT_CLASSES.get(type.trim().toLowerCase());

        if (className == null) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi");
        }

        try {
            Class<?> clazz = Class.forName(className);
            return (PaymentMethod) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi", e);
        }
    }
}
