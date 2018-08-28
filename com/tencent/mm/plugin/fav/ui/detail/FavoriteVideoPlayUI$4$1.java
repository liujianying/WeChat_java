package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.4;
import com.tencent.mm.ui.tools.f.b;

class FavoriteVideoPlayUI$4$1 implements b {
    final /* synthetic */ 4 jdP;

    FavoriteVideoPlayUI$4$1(4 4) {
        this.jdP = 4;
    }

    public final void onAnimationStart() {
        if (this.jdP.jdN.jdH != null) {
            this.jdP.jdN.jdH.onResume();
        }
    }

    public final void onAnimationEnd() {
    }
}
