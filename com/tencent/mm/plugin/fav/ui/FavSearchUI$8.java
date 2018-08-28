package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavSearchUI$8 implements a {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$8(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final void WX() {
        x.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
        FavSearchUI.c(this.iZQ);
    }

    public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
        x.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[]{list, list2, list3});
        FavSearchUI.b(this.iZQ, list2);
        FavSearchUI.c(this.iZQ, list3);
        FavSearchUI.d(this.iZQ, list);
        FavSearchUI.d(this.iZQ).bf(list3);
        if (z) {
            FavSearchUI.c(this.iZQ);
            FavSearchUI.a(this.iZQ, list, list2, list3);
            return;
        }
        FavSearchUI.e(this.iZQ).b(list, list2, list3);
        FavSearchUI.a(this.iZQ, true);
        FavSearchUI.a(this.iZQ, list, list2, list3);
    }

    public final void a(String str, List<Integer> list, List<String> list2, List<String> list3) {
        FavSearchUI.a(this.iZQ).post(new 1(this, list, list2, list3));
        if (str != null) {
            FavSearchUI.a(this.iZQ, str);
        } else {
            FavSearchUI.a(this.iZQ, "");
        }
        if (FavSearchUI.e(this.iZQ) != null) {
            b e = FavSearchUI.e(this.iZQ);
            String f = FavSearchUI.f(this.iZQ);
            if (f != null) {
                e.bWm = f;
            } else {
                e.bWm = "";
            }
        }
    }
}
