package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteSightDetailUI$2 implements a {
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$2(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.jdp = favoriteSightDetailUI;
    }

    public final void iy() {
        x.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
        FavoriteSightDetailUI.d(this.jdp).setLoop(true);
        FavoriteSightDetailUI.b(this.jdp, FavoriteSightDetailUI.d(this.jdp).start());
        ah.A(new 1(this));
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == -1) {
            FavoriteSightDetailUI.d(this.jdp).stop();
            if (e.cn(b.b(FavoriteSightDetailUI.b(this.jdp)))) {
                FavoriteSightDetailUI.f(this.jdp);
            } else if (e.cn(b.c(FavoriteSightDetailUI.b(this.jdp)))) {
                FavoriteSightDetailUI.e(this.jdp).setVisibility(0);
            }
        } else if (FavoriteSightDetailUI.g(this.jdp)) {
            wd();
        } else {
            FavoriteSightDetailUI.d(this.jdp).stop();
            if (!FavoriteSightDetailUI.h(this.jdp)) {
                FavoriteSightDetailUI.i(this.jdp);
                ah.A(new 2(this));
            }
        }
    }

    public final void wd() {
        FavoriteSightDetailUI.d(this.jdp).x(0.0d);
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
