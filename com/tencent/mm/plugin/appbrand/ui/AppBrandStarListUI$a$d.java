package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;

final class AppBrandStarListUI$a$d extends g {
    final /* synthetic */ a gvU;

    AppBrandStarListUI$a$d(a aVar) {
        this.gvU = aVar;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.top = 0;
        rect.right = 0;
        rect.left = 0;
        if (recyclerView.aP(view).gm() >= (a.c(this.gvU).getItemCount() / a.d(this.gvU).Ov) * a.d(this.gvU).Ov) {
            rect.bottom = 0;
        } else {
            rect.bottom = this.gvU.getResources().getDimensionPixelSize(e.app_brand_star_list_vertical_divider);
        }
    }
}
