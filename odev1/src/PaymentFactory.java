import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentFactory {
    private final Map<String, PaymentMethod> paymentMethods;

    public PaymentFactory(KrediKartiOdeme krediKartiOdeme, PaypalOdeme paypalOdeme) {
        this.paymentMethods = new HashMap<>();
        this.paymentMethods.put("kredi", krediKartiOdeme);
        this.paymentMethods.put("paypal", paypalOdeme);
    }

    public PaymentMethod create(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi");
        }

        PaymentMethod paymentMethod = paymentMethods.get(type.trim().toLowerCase());

        if (paymentMethod == null) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi");
        }

        return paymentMethod;
    }
}
