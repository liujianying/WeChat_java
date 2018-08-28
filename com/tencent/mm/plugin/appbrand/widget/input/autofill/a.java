package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.input.c.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

final class a extends ArrayAdapter<b> implements g {
    private final LayoutInflater Bc;
    private b gJM;
    h gJN;
    private boolean gJO = false;

    a(Context context, List<b> list) {
        super(context, h.app_brand_input_autofill_item, list);
        this.Bc = LayoutInflater.from(context);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void a(b bVar) {
        this.gJM = bVar;
        this.gJM.setOnDismissListener(new 1(this));
    }

    public final void apX() {
        this.gJM.setOnDismissListener(null);
        this.gJM = null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int i3 = 8;
        if (view == null) {
            view = this.Bc.inflate(h.app_brand_input_autofill_item, viewGroup, false);
        }
        a aVar2 = (a) view.getTag();
        if (aVar2 == null) {
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        b bVar = (b) getItem(i);
        aVar.gJT = bVar;
        aVar.gJQ.setText(bVar.title);
        aVar.gJR.setText(bVar.content);
        TextView textView = aVar.gJR;
        if (bi.oW(bVar.content)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView.setVisibility(i2);
        View view2 = aVar.eCO;
        if (i != getCount() - 1) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        return view;
    }

    public final Filter getFilter() {
        return super.getFilter();
    }
}
