package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$12 implements Runnable {
    final /* synthetic */ HomeUI tjS;

    HomeUI$12(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void run() {
        HomeUI.a(this.tjS);
        au.HU();
        c.DT().setInt(327947, HomeUI.b(this.tjS).getHeight());
        x.i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", new Object[]{Integer.valueOf(HomeUI.c(this.tjS).getPaddingTop())});
        e.a(HomeUI.d(this.tjS), HomeUI.c(this.tjS));
    }

    public final String toString() {
        return super.toString() + "|updateTitle";
    }
}
