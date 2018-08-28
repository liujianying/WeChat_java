package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.a.a.3;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1 implements Runnable {
    final /* synthetic */ 3 bCX;

    a$3$1(3 3) {
        this.bCX = 3;
    }

    public final void run() {
        try {
            if (q.deN.dbH == 1) {
                Thread.sleep(300);
            }
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[]{a.e(this.bCX.bCV), Boolean.valueOf(a.f(this.bCX.bCV))});
            ah.A(new Runnable() {
                public final void run() {
                    f.yz().e(a.g(a$3$1.this.bCX.bCV), false, false);
                    if (a.f(a$3$1.this.bCX.bCV)) {
                        as$b as_b;
                        Context h = a.h(a$3$1.this.bCX.bCV);
                        int i = a.f.play_completed;
                        boolean g = a.g(a$3$1.this.bCX.bCV);
                        1 1 = new 1(this);
                        if (g) {
                            as_b = as$b.ON;
                        } else {
                            as_b = as$b.OFF;
                        }
                        as.a(h, i, as_b, 1);
                    } else {
                        x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a$3$1.this.bCX.bCV.isPlaying()) {
                            f.yz().b(a$3$1.this.bCX.bCV);
                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[]{Boolean.valueOf(a.i(a$3$1.this.bCX.bCV))});
                            if (!a.i(a$3$1.this.bCX.bCV)) {
                                f.yz().yC();
                            }
                            a.j(a$3$1.this.bCX.bCV);
                            a.c(a$3$1.this.bCX.bCV);
                            f.yz().setMode(0);
                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                    }
                    if (a.e(a$3$1.this.bCX.bCV) != null) {
                        x.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                        a.e(a$3$1.this.bCX.bCV).wd();
                        return;
                    }
                    x.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                }
            });
        } catch (Throwable e) {
            x.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[]{bi.i(e)});
        }
    }
}
