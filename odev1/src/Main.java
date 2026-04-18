import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ödeme yöntemi gir (kredi / paypal): ");
        String type = sc.nextLine();

        System.out.println("Tutar gir: ");
        double amount = sc.nextDouble();

        PaymentMethod method = PaymentFactory.create(type);

        PaymentService service = new PaymentService();
        service.processPayment(method, amount);
    }
}
