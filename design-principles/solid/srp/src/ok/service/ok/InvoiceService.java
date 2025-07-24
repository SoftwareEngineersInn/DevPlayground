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

