package com.tencent.mm.plugin.address.ui;

import android.text.method.NumberKeyListener;

class InvoiceEditView$1 extends NumberKeyListener {
    final /* synthetic */ InvoiceEditView eYY;

    InvoiceEditView$1(InvoiceEditView invoiceEditView) {
        this.eYY = invoiceEditView;
    }

    public final int getInputType() {
        return 2;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', '~', '`', 183, '=', '=', '+'};
    }
}
