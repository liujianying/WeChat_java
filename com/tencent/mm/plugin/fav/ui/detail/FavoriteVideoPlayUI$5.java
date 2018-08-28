package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.tools.f.b;

class FavoriteVideoPlayUI$5 implements b {
    final /* synthetic */ FavoriteVideoPlayUI jdN;

    FavoriteVideoPlayUI$5(FavoriteVideoPlayUI favoriteVideoPlayUI) {
        this.jdN = favoriteVideoPlayUI;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
