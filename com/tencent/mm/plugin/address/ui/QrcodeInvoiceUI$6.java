package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class QrcodeInvoiceUI$6 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI eZH;

    QrcodeInvoiceUI$6(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.eZH = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.invoice_qrcode_bar_area && QrcodeInvoiceUI.b(this.eZH) != null) {
            this.eZH.showPopupWindow(view);
            QrcodeInvoiceUI.d(this.eZH);
        }
    }
}
