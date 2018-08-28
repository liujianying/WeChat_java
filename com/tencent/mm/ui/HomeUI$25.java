package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$25 implements OnClickListener {
    final /* synthetic */ HomeUI tjS;

    HomeUI$25(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void onClick(View view) {
        h.mEJ.k(10919, "0");
        HomeUI.f(this.tjS);
        if (HomeUI.tjy.booleanValue()) {
            HomeUI.a(this.tjS, Boolean.valueOf(true), Boolean.valueOf(true));
        }
        if (HomeUI.tjz.booleanValue()) {
            HomeUI.a(this.tjS, Boolean.valueOf(true), Boolean.valueOf(false));
        }
        if (!bj.chn()) {
            long VF = ai.VF();
            if (VF - HomeUI.g(this.tjS) > 10000) {
                HomeUI.a(this.tjS, VF);
                HomeUI.h(this.tjS);
                return;
            }
            HomeUI.i(this.tjS);
            if (HomeUI.j(this.tjS) >= 5) {
                x.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
                bj.lj(true);
            }
        }
    }
}
