package com.tencent.mm.plugin.fav.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$4 implements OnScrollListener {
    final /* synthetic */ FavBaseUI iYp;

    FavBaseUI$4(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            return;
        }
        if (((ae) g.n(ae.class)).getFavItemInfoStorage().r(this.iYp.aMc().aMB(), this.iYp.aMc().getType())) {
            x.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
        } else if (FavBaseUI.a(this.iYp)) {
            x.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(this.iYp);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
