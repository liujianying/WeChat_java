package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    List<h> hWN = new ArrayList();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hWN.size();
    }

    /* renamed from: ot */
    public final h getItem(int i) {
        return (h) this.hWN.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = y.gq(this.mContext).inflate(g.collect_bill_list_item, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        h ot = getItem(i);
        aVar.hWO.setText(e.a(this.mContext, ot.hUf, ot.type));
        aVar.hWP.setText(e.os(ot.hUh));
        aVar.hVS.setText(this.mContext.getString(i.collect_bill_total_num_text, new Object[]{Integer.valueOf(ot.hUg)}));
        return view;
    }

    public final void aK(List<h> list) {
        this.hWN.clear();
        this.hWN.addAll(list);
        notifyDataSetChanged();
    }

    public final void aL(List<h> list) {
        this.hWN.addAll(list);
        notifyDataSetChanged();
    }
}
