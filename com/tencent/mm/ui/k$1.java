package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements Runnable {
    final /* synthetic */ Activity mr;
    final /* synthetic */ int tkd;
    final /* synthetic */ int tke;

    k$1(Activity activity, int i, int i2) {
        this.mr = activity;
        this.tkd = i;
        this.tke = i2;
    }

    public final void run() {
        Activity activity = this.mr;
        int i = this.tkd;
        int i2 = this.tke;
        x.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), ai.VI()});
        if (i2 >= 0) {
            String str = "MainUI";
            if (i2 == 1) {
                str = "AddressUI";
            }
            if (i2 == 2) {
                str = "FindMoreFriendUI";
            }
            if (i2 == 3) {
                str = "MoreTabUI";
            }
            d.b(i, str, ((activity.hashCode() / 16) * 16) + i2);
        }
    }
}
