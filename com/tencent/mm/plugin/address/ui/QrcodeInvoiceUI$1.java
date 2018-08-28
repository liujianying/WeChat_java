package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QrcodeInvoiceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QrcodeInvoiceUI eZH;

    QrcodeInvoiceUI$1(QrcodeInvoiceUI qrcodeInvoiceUI) {
        this.eZH = qrcodeInvoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eZH.setResult(0);
        this.eZH.finish();
        return true;
    }
}
