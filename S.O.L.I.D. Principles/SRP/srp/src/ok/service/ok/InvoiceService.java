package ok.service.ok;

import ok.InvoiceCalculator;
import ok.InvoicePrinter;

/**
 * ✅ Example of a good practice regarding SRP and how to apply dependency injection
 **/
public class InvoiceService {
    /**
     * Responsibilities declaration
     **/
    private final InvoiceCalculator calculator;
    private final InvoicePrinter printer;

    /**
     * Constructor dependency injection, responsibilities initialization
     **/
    public InvoiceService(InvoiceCalculator calculator, InvoicePrinter printer) {
        this.calculator = calculator;
        this.printer = printer;
    }

    /**
     * Using responsibilities example
     **/
    public void processInvoice() {
        calculator.calculateBillTotal();
        printer.printBill();
    }
}
/**
 * This works, and it's valid for small and simple projects that not pretend to get
 * more complexity in the near future.
 * <p>
 * There exists to potential problems if this application grows:
 * <p>
 * - High Coupling
 * If InvoicePrinter changes its constructor method or a new dependency is required. We will need to update our
 * Invoice service class as well
 * <p>
 * - Testing difficulty
 * This approach will add extra difficulty to create mock for testing because it creates its own dependencies.
 **/

