package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class FavSearchActionView$1 implements a {
    final /* synthetic */ FavSearchActionView jfB;

    FavSearchActionView$1(FavSearchActionView favSearchActionView) {
        this.jfB = favSearchActionView;
    }

    public final void zO(String str) {
        x.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[]{str});
        FavSearchActionView.a(this.jfB).removeTag(str);
        zQ(str);
    }

    public final void zP(String str) {
    }

    public final void zQ(String str) {
        FavSearchActionView.a(this.jfB, FavSearchActionView.a(this.jfB).getEditText());
        FavSearchActionView.b(this.jfB).remove(str);
        FavSearchActionView.c(this.jfB);
        if (FavSearchActionView.d(this.jfB) != null) {
            FavSearchActionView.d(this.jfB).a(FavSearchActionView.e(this.jfB), FavSearchActionView.f(this.jfB), FavSearchActionView.b(this.jfB), true);
        }
    }

    public final void zR(String str) {
        FavSearchActionView.a(this.jfB, FavSearchActionView.a(this.jfB).getEditText());
        FavSearchActionView.c(this.jfB);
        if (FavSearchActionView.d(this.jfB) != null) {
            FavSearchActionView.d(this.jfB).a(str, FavSearchActionView.e(this.jfB), FavSearchActionView.f(this.jfB), FavSearchActionView.b(this.jfB));
        }
    }

    public final void zS(String str) {
        FavSearchActionView.a(this.jfB, str);
        FavSearchActionView.d(this.jfB).a(FavSearchActionView.e(this.jfB), FavSearchActionView.f(this.jfB), FavSearchActionView.b(this.jfB), false);
    }

    public final void aGt() {
        if (FavSearchActionView.d(this.jfB) != null) {
            FavSearchActionView.d(this.jfB).WX();
        }
    }

    public final void BH(String str) {
        FavSearchActionView.a(this.jfB, FavSearchActionView.a(this.jfB).getEditText());
        FavSearchActionView.e(this.jfB).remove(FavSearchActionView.af(this.jfB.getContext(), str));
        FavSearchActionView.c(this.jfB);
        if (FavSearchActionView.d(this.jfB) != null) {
            FavSearchActionView.d(this.jfB).a(FavSearchActionView.e(this.jfB), FavSearchActionView.f(this.jfB), FavSearchActionView.b(this.jfB), true);
        }
    }

    public final void BI(String str) {
        x.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[]{str});
        FavSearchActionView.a(this.jfB).BJ(str);
        BH(str);
    }

    public final void i(boolean z, int i) {
    }
}
