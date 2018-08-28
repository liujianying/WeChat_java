package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;
import java.util.List;

final class AppBrandStarListUI$a$e extends a<f> {
    final /* synthetic */ AppBrandStarListUI.a gvU;

    AppBrandStarListUI$a$e(AppBrandStarListUI.a aVar) {
        this.gvU = aVar;
    }

    public final /* synthetic */ void a(t tVar, int i, List list) {
        f fVar = (f) tVar;
        if (list == null || list.size() != 1 || (!"enter_delete_mode_tag".equals(list.get(0)) && !"exit_delete_mode_tag".equals(list.get(0)))) {
            super.a(fVar, i, list);
        }
    }

    public final int getItemCount() {
        return AppBrandStarListUI.a.f(this.gvU).size();
    }
}
