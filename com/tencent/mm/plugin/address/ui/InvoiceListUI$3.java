package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class InvoiceListUI$3 implements OnItemLongClickListener {
    final /* synthetic */ InvoiceListUI eZh;

    InvoiceListUI$3(InvoiceListUI invoiceListUI) {
        this.eZh = invoiceListUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        h.a(this.eZh.mController.tml, null, this.eZh.getResources().getStringArray(R.c.invoice_opt_list), null, new 1(this, i));
        return true;
    }
}
