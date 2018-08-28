package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$19 implements Runnable {
    final /* synthetic */ HomeUI tjS;

    HomeUI$19(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void run() {
        x.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
        HomeUI.d(this.tjS).sendBroadcast(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    }

    public final String toString() {
        return super.toString() + "|sendBroadcast";
    }
}
