public class PaymentFactory {

    public static PaymentMethod create(String type) {
        try {
            String className = "com.myapp.payments." + type + "Odeme";

            Class<?> clazz = Class.forName(className);
            return (PaymentMethod) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi", e);
        }
    }
}