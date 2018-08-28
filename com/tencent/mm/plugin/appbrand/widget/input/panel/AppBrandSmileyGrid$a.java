package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.y;

class AppBrandSmileyGrid$a extends BaseAdapter {
    final /* synthetic */ AppBrandSmileyGrid gKQ;

    private AppBrandSmileyGrid$a(AppBrandSmileyGrid appBrandSmileyGrid) {
        this.gKQ = appBrandSmileyGrid;
    }

    /* synthetic */ AppBrandSmileyGrid$a(AppBrandSmileyGrid appBrandSmileyGrid, byte b) {
        this(appBrandSmileyGrid);
    }

    public final int getCount() {
        return AppBrandSmileyGrid.d(this.gKQ);
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppBrandSmileyGrid$b appBrandSmileyGrid$b;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.gKQ.getContext()).inflate(h.appbrand_smiley_grid_item, null);
            view.setLayoutParams(new LayoutParams(-1, ((AppBrandSmileyGrid.b(this.gKQ).gKZ - a.ad(this.gKQ.getContext(), e.LittlePadding)) - a.ad(this.gKQ.getContext(), e.emoji_panel_tab_height)) / AppBrandSmileyGrid.f(this.gKQ)));
            appBrandSmileyGrid$b = new AppBrandSmileyGrid$b(view);
            view.setTag(appBrandSmileyGrid$b);
        } else {
            appBrandSmileyGrid$b = (AppBrandSmileyGrid$b) view.getTag();
        }
        if (i == getCount() - 1) {
            appBrandSmileyGrid$b.gmn.setImageResource(f.del_btn);
            appBrandSmileyGrid$b.gmn.setContentDescription(this.gKQ.getContext().getString(j.delete_btn));
        } else {
            int d = ((AppBrandSmileyGrid.d(this.gKQ) - 1) * AppBrandSmileyGrid.c(this.gKQ)) + i;
            if (d > AppBrandSmileyGrid.e(this.gKQ) - 1) {
                appBrandSmileyGrid$b.gmn.setImageDrawable(null);
            } else {
                appBrandSmileyGrid$b.gmn.setImageDrawable(AppBrandSmileyGrid.b(this.gKQ).apU().mg(d));
            }
        }
        return view;
    }
}
