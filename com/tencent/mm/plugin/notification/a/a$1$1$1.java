package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.a.a.1.1;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1$1 implements Runnable {
    final /* synthetic */ boolean iIq;
    final /* synthetic */ int lHn;
    final /* synthetic */ int lHo;
    final /* synthetic */ 1 lHp;

    a$1$1$1(1 1, int i, boolean z, int i2) {
        this.lHp = 1;
        this.lHn = i;
        this.iIq = z;
        this.lHo = i2;
    }

    public final void run() {
        au.getNotification().fq(this.lHn);
        if (!this.iIq) {
            au.getNotification().v(this.lHp.lHl, this.lHo);
        }
        x.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[]{Integer.valueOf(this.lHn), Integer.valueOf(this.lHo), Boolean.valueOf(this.iIq)});
        e.post(new 1(this), "NotificationObserver");
    }
}
