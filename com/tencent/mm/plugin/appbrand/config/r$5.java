package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.ab.a.a;

class r$5 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ boolean frH;
    final /* synthetic */ r$b frI;
    final /* synthetic */ boolean frJ;

    r$5(String str, boolean z, r$b r_b, boolean z2) {
        this.dhF = str;
        this.frH = z;
        this.frI = r_b;
        this.frJ = z2;
    }

    public final void run() {
        int i = 1;
        String str = this.dhF;
        boolean z = this.frH && r.sb(this.dhF);
        Pair a = r.a(str, z, new 1(this));
        if (this.frI != null) {
            if (a.second != null) {
                if (((a) a.second).errType == 0 && ((a) a.second).errCode == 0) {
                    i = 2;
                } else {
                    i = 3;
                }
            }
            this.frI.e(i, a.first);
        }
        if (this.frJ) {
            try {
                ((HandlerThread) Looper.myLooper().getThread()).quit();
            } catch (Exception e) {
            }
        }
    }
}
