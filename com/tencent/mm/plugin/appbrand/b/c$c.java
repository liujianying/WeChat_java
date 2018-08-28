package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

final class c$c extends g {
    final /* synthetic */ c fjx;

    c$c(c cVar, h hVar) {
        this.fjx = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.fjx.mName + "|BackgroundTemporary";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.fjx, this.fjx.fjo);
                return true;
            case 4:
                RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                x.i(this.fjx.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", new Object[]{Integer.valueOf(runningAppProcessInfo.importance)});
                if (runningAppProcessInfo.importance == 100) {
                    c.a(this.fjx, this.fjx.fjs);
                    return true;
                }
                c.a(this.fjx, this.fjx.fjq);
                return true;
            case 10:
                x.i(this.fjx.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                c.a(this.fjx, this.fjx.fjs);
                return true;
            default:
                return super.j(message);
        }
    }

    public final void enter() {
        super.enter();
        this.fjx.sJQ.sendEmptyMessageDelayed(4, ((long) this.fjx.fdO.fcu.fri) * 1000);
    }

    public final void exit() {
        super.exit();
        this.fjx.sJQ.removeMessages(4);
    }
}
