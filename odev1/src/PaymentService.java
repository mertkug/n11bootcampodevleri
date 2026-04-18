public class PaymentService {

    public void processPayment(PaymentMethod paymentMethod, double amount) {
        boolean result = paymentMethod.pay(amount);

        if (result)
            System.out.println("Sipariş onaylandı.");
        else
            System.out.println("Ödeme başarısız.");
    }
}