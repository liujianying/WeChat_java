package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.q.a.b;
import java.util.ArrayList;
import java.util.List;

public class InvoiceListUI$a extends BaseAdapter {
    private final Context context;
    List<b> dEw = new ArrayList();
    final /* synthetic */ InvoiceListUI eZh;

    public InvoiceListUI$a(InvoiceListUI invoiceListUI, Context context) {
        this.eZh = invoiceListUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a(this);
        if (view == null) {
            view = View.inflate(this.context, R.i.wallet_addr_select_item, null);
            aVar2.eZk = (ImageView) view.findViewById(R.h.check_state);
            aVar2.eZj = (TextView) view.findViewById(R.h.address_content_tv);
            aVar2.eHU = (TextView) view.findViewById(R.h.address_name_tv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b jv = jv(i);
        if (jv.type != null && jv.type.equals("0")) {
            aVar.eZj.setText(R.l.invoice_company_type);
            aVar.eHU.setText(jv.title);
        } else if (jv.type != null && jv.type.equals("1")) {
            aVar.eZj.setText(R.l.invoice_personal_type);
            aVar.eHU.setText(jv.knB);
        }
        if (InvoiceListUI.d(this.eZh) && InvoiceListUI.e(this.eZh) != null && InvoiceListUI.e(this.eZh).knA == jv.knA) {
            aVar.eZk.setImageResource(R.k.radio_on);
        } else {
            aVar.eZk.setImageBitmap(null);
        }
        return view;
    }

    public final int getCount() {
        return this.dEw.size();
    }

    private b jv(int i) {
        return (b) this.dEw.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
