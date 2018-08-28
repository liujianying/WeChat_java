package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiManager;
import java.util.TimerTask;

class s$6 extends TimerTask {
    final /* synthetic */ s oNG;

    s$6(s sVar) {
        this.oNG = sVar;
    }

    public final void run() {
        int i = 10;
        if (s.g(this.oNG) != null) {
            s.a(this.oNG, s.g(this.oNG).getConnectionInfo());
        }
        if (s.h(this.oNG) == null || s.h(this.oNG).getBSSID() == null || s.g(this.oNG) == null) {
            s.yM(-1);
        } else {
            s.yM(WifiManager.calculateSignalLevel(s.h(this.oNG).getRssi(), 10));
            if (s.TE() <= 10) {
                i = s.TE();
            }
            s.yM(i);
            s.yM(s.TE() < 0 ? 0 : s.TE());
            s.yM(s.TE() * 10);
        }
        if (s.TE() == -1) {
            if (s.i(this.oNG) <= 1) {
                s.yL(-1);
            }
            this.oNG.setNetSignalValue(1, s.asg());
            return;
        }
        this.oNG.setNetSignalValue(2, s.TE());
    }
}
