package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUI$4 implements Runnable {
    long btC = 2000;
    final /* synthetic */ LauncherUI tkA;

    LauncherUI$4(LauncherUI launcherUI) {
        this.tkA = launcherUI;
    }

    @TargetApi(17)
    public final void run() {
        x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[]{Long.valueOf(Thread.currentThread().getId())});
        ah.M(this);
        if (au.HW()) {
            Object[] objArr = new Object[1];
            g.Eg();
            objArr[0] = Integer.valueOf(a.Df());
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", objArr);
        } else if (d.RU() || b.foreground) {
            this.btC += 2000;
            if (this.btC > 10000) {
                this.btC = 2000;
            }
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[]{Boolean.valueOf(d.RU()), Boolean.valueOf(b.foreground), Long.valueOf(this.btC)});
            ah.i(this, this.btC);
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
            if (HardCoderJNI.checkEnv) {
                HardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        }
    }
}
