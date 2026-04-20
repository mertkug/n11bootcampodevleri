@Component
public class PaymentService {
    private final PaymentFactory paymentFactory;

    public PaymentService(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    public void processPayment(String type, double amount) {
        PaymentMethod paymentMethod = paymentFactory.create(type);
        boolean result = paymentMethod.pay(amount);

        if (result)
            System.out.println("Sipariş onaylandı.");
        else
            System.out.println("Ödeme başarısız.");
    }
}
