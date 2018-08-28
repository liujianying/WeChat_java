package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$g;
import com.tencent.mm.plugin.appbrand.s.h;
import java.util.ArrayList;

final class b$a extends BaseAdapter {
    private final ArrayList<String> fXG;
    private final int fXH;

    public b$a(ArrayList<String> arrayList, int i) {
        this.fXG = arrayList;
        this.fXH = i;
    }

    public final int getCount() {
        return this.fXG.size();
    }

    private String jl(int i) {
        return (String) this.fXG.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), h.app_brand_show_action_sheet_item, null);
            a aVar2 = new a((byte) 0);
            aVar2.eGX = (TextView) view.findViewById(s$g.title);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eGX.setText(jl(i));
        aVar.eGX.setTextColor(this.fXH);
        return view;
    }
}
