package com.tencent.mm.e.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.e.a.a.3.1.1;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1$1$1 implements a {
    final /* synthetic */ 1 bCZ;

    a$3$1$1$1(1 1) {
        this.bCZ = 1;
    }

    public final void wd() {
        x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
        if (!this.bCZ.bCY.bCX.bCV.isPlaying()) {
            f.yz().b(this.bCZ.bCY.bCX.bCV);
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.i(this.bCZ.bCY.bCX.bCV)));
            if (!a.i(this.bCZ.bCY.bCX.bCV)) {
                f.yz().yC();
            }
            a.j(this.bCZ.bCY.bCX.bCV);
            a.c(this.bCZ.bCY.bCX.bCV);
            f.yz().setMode(0);
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
        }
    }
}
