package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private String eIQ;
    private List<a> kuM = new ArrayList();
    private IPCallCountryCodeSelectUI kuN;
    int[] kuO;
    boolean kuP = false;
    boolean kuQ = false;
    private List<a> list;

    static class a {
        TextView eMf;
        TextView kuR;
        TextView kuS;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        this.kuN = iPCallCountryCodeSelectUI;
        this.list = list;
        aYg();
        aYh();
    }

    private void aYg() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.kuM.add(this.list.get(i));
        }
        this.kuN.kuE.setVisibility(8);
    }

    private void aYh() {
        this.kuO = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.kuO[i] = ((a) this.list.get(i)).aXZ();
        }
    }

    public final int getCount() {
        return this.list.size();
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void pi(String str) {
        if (str != null) {
            this.eIQ = str.trim();
            this.list.clear();
            int size = this.kuM.size();
            int i = 0;
            while (i < size) {
                if (((a) this.kuM.get(i)).dYy.toUpperCase().contains(this.eIQ.toUpperCase()) || ((a) this.kuM.get(i)).dYz.toUpperCase().contains(this.eIQ.toUpperCase()) || ((a) this.kuM.get(i)).countryCode.contains(this.eIQ)) {
                    this.list.add(this.kuM.get(i));
                }
                i++;
            }
            aYh();
            if (this.list.size() == 0) {
                this.kuN.kuE.setVisibility(0);
            } else {
                this.kuN.kuE.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.kuN, R.i.ip_call_country_list_item, null);
            aVar = new a();
            aVar.kuR = (TextView) view.findViewById(R.h.contactitem_catalog);
            aVar.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
            aVar.kuS = (TextView) view.findViewById(R.h.contactitem_signature);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.kuO[i - 1] : -1;
        if (i == 0) {
            aVar.kuR.setVisibility(0);
            if (this.kuQ) {
                aVar.kuR.setText(R.l.popular_country_header);
            } else {
                aVar.kuR.setText(rB(this.kuO[i]));
            }
        } else if (i <= 0 || this.kuO[i] == i2) {
            aVar.kuR.setVisibility(8);
        } else {
            aVar.kuR.setVisibility(0);
            aVar.kuR.setText(rB(this.kuO[i]));
        }
        if (bi.oW(this.eIQ)) {
            aVar.eMf.setText(aVar2.dYy);
            aVar.kuS.setText(" (+" + aVar2.countryCode + ")");
        } else {
            aVar.eMf.setText(com.tencent.mm.plugin.fts.a.f.a(aVar2.dYy, this.eIQ));
            aVar.kuS.setText(com.tencent.mm.plugin.fts.a.f.a(" (+" + aVar2.countryCode + ")", this.eIQ));
        }
        if (this.kuP) {
            aVar.kuS.setVisibility(0);
        } else {
            aVar.kuS.setVisibility(4);
        }
        return view;
    }

    private static String rB(int i) {
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.kuT) {
            if (equals.equals(String.valueOf((char) i))) {
                return valueOf;
            }
        }
        return "#";
    }
}
