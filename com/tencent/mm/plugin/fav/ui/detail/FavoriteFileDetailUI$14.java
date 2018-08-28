package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteFileDetailUI$14 implements a {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$14(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final void iy() {
        x.d("MicroMsg.FavoriteFileDetailUI", g.Ab() + " onPrepared");
        FavoriteFileDetailUI.l(this.jcx).setLoop(true);
        FavoriteFileDetailUI.l(this.jcx).start();
    }

    public final void onError(int i, int i2) {
        FavoriteFileDetailUI.l(this.jcx).stop();
        if (!FavoriteFileDetailUI.m(this.jcx)) {
            FavoriteFileDetailUI.n(this.jcx);
            ah.A(new 1(this));
        }
    }

    public final void wd() {
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
