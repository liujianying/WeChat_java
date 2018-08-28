package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class QrcodeInvoiceUI$5 implements OnClickListener {
    final /* synthetic */ QrcodeInvoiceUI eZH;

    QrcodeInvoiceUI$5(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.eZH = qrcodeInvoiceUI;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.invoice_popup_qrcode_iv && QrcodeInvoiceUI.b(this.eZH) != null && QrcodeInvoiceUI.b(this.eZH).isShowing()) {
            QrcodeInvoiceUI.b(this.eZH).dismiss();
        }
    }
}
