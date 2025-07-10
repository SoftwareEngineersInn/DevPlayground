package ok.service.wrong;

import ok.InvoiceCalculator;
import ok.InvoicePrinter;

/**
 * 🚫 Example of a bad practice regarding SRP and how to instance every class using several direct class instances
 **/
public class InvoiceService {
    public void processInvoice() {
        InvoiceCalculator calc = new InvoiceCalculator(); // 👈 Direct Instance
        calc.calculateBillTotal();

        InvoicePrinter printer = new InvoicePrinter(); // 👈 Other direct instance
        printer.printBill();
    }
}
/**
 *
 * This works, and it's valid for small and simple projects that not pretend to get
 * more complexity in the near future.
 *
 * There exists to potential problems if this application grows:
 *
 * - High Coupling
 *      If InvoicePrinter changes its constructor method or a new dependency is required. We will need to update our
 *      Invoice service class as well
 *
 * - Testing difficulty
 *      This approach will add extra difficulty to create mock for testing because it creates its own dependencies.
 *
 **/