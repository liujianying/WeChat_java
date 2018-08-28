package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class i$a implements Runnable {
    ag handler;
    final /* synthetic */ i orB;

    public i$a(final i iVar) {
        this.orB = iVar;
        this.handler = new ag() {
            public final void handleMessage(Message message) {
                if (i.c(i$a.this.orB) > 0) {
                    x.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (i$a.this.orB.oru == null));
                    i.d(i$a.this.orB);
                    if (i$a.this.orB.oru != null) {
                        i$a.this.orB.oru.KU();
                    }
                }
            }
        };
    }

    public final void run() {
        if (i.e(this.orB) == null) {
            x.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
            return;
        }
        synchronized (this.orB) {
            if (!i.e(this.orB).dc(h.aY(i.a(this.orB), true))) {
                i.Om(i.a(this.orB));
                i.f(this.orB);
                x.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.a(this.orB) + "]");
                i.g(this.orB);
            }
            i.a(this.orB, bi.VG());
            x.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.a(this.orB) + "] time:" + bi.bI(i.h(this.orB)));
        }
        this.handler.sendEmptyMessageDelayed(0, 1);
    }
}
