package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InvoiceListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ InvoiceListUI eZh;

    InvoiceListUI$4(InvoiceListUI invoiceListUI) {
        this.eZh = invoiceListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eZh.setResult(0);
        this.eZh.finish();
        return true;
    }
}
