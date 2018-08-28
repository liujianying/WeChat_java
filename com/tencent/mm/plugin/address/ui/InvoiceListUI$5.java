package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InvoiceListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ InvoiceListUI eZh;

    InvoiceListUI$5(InvoiceListUI invoiceListUI) {
        this.eZh = invoiceListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        InvoiceListUI.a(this.eZh);
        return true;
    }
}
