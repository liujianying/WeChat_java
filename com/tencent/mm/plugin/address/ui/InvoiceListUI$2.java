package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.sdk.platformtools.x;

class InvoiceListUI$2 implements OnItemClickListener {
    final /* synthetic */ InvoiceListUI eZh;

    InvoiceListUI$2(InvoiceListUI invoiceListUI) {
        this.eZh = invoiceListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.InvoiceListUI", "select pos " + i);
        synchronized (InvoiceListUI.b(this.eZh)) {
            if (i < InvoiceListUI.c(this.eZh).size()) {
                InvoiceListUI.a(this.eZh, (b) InvoiceListUI.c(this.eZh).get(i));
                if (!InvoiceListUI.d(this.eZh) && InvoiceListUI.e(this.eZh) != null) {
                    InvoiceListUI.a(this.eZh, InvoiceListUI.e(this.eZh).knA);
                } else if (!(InvoiceListUI.e(this.eZh) == null || InvoiceListUI.e(this.eZh).knA == 0)) {
                    Intent intent = new Intent();
                    intent.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.e(this.eZh)));
                    this.eZh.setResult(-1, intent);
                    this.eZh.finish();
                }
            }
        }
        InvoiceListUI.f(this.eZh).notifyDataSetChanged();
    }
}
