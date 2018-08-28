package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.product.a.a;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private List<String> lRd = null;
    private List<String> lST = null;
    Filter lSU = new 1(this);
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
        this.lST = a.bmF().bmH().lRd;
    }

    public final int getCount() {
        return this.lRd != null ? this.lRd.size() : 0;
    }

    private String jl(int i) {
        return (String) this.lRd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.lSz = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lSz.setText(jl(i));
        return view;
    }

    public final Filter getFilter() {
        return this.lSU;
    }
}
