package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class InvoiceListUI$6 implements OnClickListener {
    final /* synthetic */ InvoiceListUI eZh;

    InvoiceListUI$6(InvoiceListUI invoiceListUI) {
        this.eZh = invoiceListUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
        dialogInterface.dismiss();
    }
}
