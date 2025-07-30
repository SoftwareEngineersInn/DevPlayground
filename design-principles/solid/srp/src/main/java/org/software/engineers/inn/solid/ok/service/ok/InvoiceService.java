package org.software.engineers.inn.solid.ok.service.ok;

import org.software.engineers.inn.solid.ok.InvoiceCalculator;
import org.software.engineers.inn.solid.ok.InvoicePrinter;

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

