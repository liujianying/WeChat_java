package com.tencent.mm.plugin.address.ui;

import android.widget.PopupWindow.OnDismissListener;

class QrcodeInvoiceUI$4 implements OnDismissListener {
    final /* synthetic */ QrcodeInvoiceUI eZH;

    QrcodeInvoiceUI$4(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.eZH = qrcodeInvoiceUI;
    }

    public final void onDismiss() {
        QrcodeInvoiceUI.c(this.eZH);
    }
}
