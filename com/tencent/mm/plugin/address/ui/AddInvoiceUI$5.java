package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AddInvoiceUI$5 implements OnClickListener {
    final /* synthetic */ AddInvoiceUI eYy;

    AddInvoiceUI$5(AddInvoiceUI addInvoiceUI) {
        this.eYy = addInvoiceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eYy.setResult(0);
        this.eYy.finish();
    }
}
