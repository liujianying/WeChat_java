package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.h;

class HomeUI$7 implements Runnable {
    final /* synthetic */ HomeUI tjS;

    HomeUI$7(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void run() {
        if (!a.bx(HomeUI.d(this.tjS)) || a.bw(HomeUI.d(this.tjS))) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            h.mEJ.h(11409, new Object[0]);
            d.b(HomeUI.d(this.tjS), "scanner", ".ui.BaseScanUI", intent);
        }
    }
}
