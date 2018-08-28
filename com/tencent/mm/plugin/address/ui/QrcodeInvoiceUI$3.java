package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;

class QrcodeInvoiceUI$3 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI eZH;

    QrcodeInvoiceUI$3(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.eZH = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (QrcodeInvoiceUI.b(this.eZH) != null && QrcodeInvoiceUI.b(this.eZH).isShowing()) {
            QrcodeInvoiceUI.b(this.eZH).dismiss();
        }
    }
}
