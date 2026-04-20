import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(
                PaymentFactory.class,
                PaymentService.class,
                KrediKartiOdeme.class,
                PaypalOdeme.class
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Ödeme yöntemi gir (kredi / paypal): ");
        String type = sc.nextLine();

        System.out.println("Tutar gir: ");
        double amount = sc.nextDouble();

        PaymentService service = context.getBean(PaymentService.class);
        service.processPayment(type, amount);
    }
}
