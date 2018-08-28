package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.al.b.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter {
    private Context context;
    private String eIQ;
    private List<a> kuM = new ArrayList();
    int[] kuO;
    boolean kuP = false;
    private List<a> list;

    public c(Context context, List<a> list) {
        this.context = context;
        this.list = list;
        aYg();
        aYh();
    }

    private void aYg() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.kuM.add(this.list.get(i));
        }
    }

    private void aYh() {
        this.kuO = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.kuO[i] = ((a) this.list.get(i)).dYA;
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
                if (((a) this.kuM.get(i)).dYy.toUpperCase().contains(this.eIQ.toUpperCase()) || ((a) this.kuM.get(i)).dYz.toUpperCase().contains(this.eIQ.toUpperCase()) || ((a) this.kuM.get(i)).dYx.contains(this.eIQ)) {
                    this.list.add(this.kuM.get(i));
                }
                i++;
            }
            aYh();
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            if (w.chN()) {
                inflate = View.inflate(this.context, R.i.country_code_item_big5, null);
            } else {
                inflate = View.inflate(this.context, R.i.country_code_item, null);
            }
            aVar = new a();
            aVar.kuR = (TextView) inflate.findViewById(R.h.contactitem_catalog);
            aVar.eMf = (TextView) inflate.findViewById(R.h.contactitem_nick);
            aVar.kuS = (TextView) inflate.findViewById(R.h.contactitem_signature);
            inflate.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        int i2 = i > 0 ? this.kuO[i - 1] : -1;
        if (i == 0) {
            aVar.kuR.setVisibility(0);
            aVar.kuR.setText(rB(this.kuO[i]));
        } else if (i <= 0 || this.kuO[i] == i2) {
            aVar.kuR.setVisibility(8);
        } else {
            aVar.kuR.setVisibility(0);
            aVar.kuR.setText(rB(this.kuO[i]));
        }
        aVar.eMf.setText(aVar2.dYy);
        aVar.kuS.setText(aVar2.dYx);
        if (this.kuP) {
            aVar.kuS.setVisibility(0);
        } else {
            aVar.kuS.setVisibility(4);
        }
        return inflate;
    }

    private static String rB(int i) {
        if (w.chN()) {
            return Integer.toString(i) + "劃";
        }
        return String.valueOf((char) i);
    }
}
