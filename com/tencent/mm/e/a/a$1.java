package com.tencent.mm.e.a;

import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a bCV;

    a$1(a aVar) {
        this.bCV = aVar;
    }

    public final void ex(int i) {
        x.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", new Object[]{Integer.valueOf(i)});
        if (i == -2 || i == -3) {
            if (this.bCV.isPlaying()) {
                x.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", new Object[]{a.a(this.bCV), a.bP()});
                if (a.a(this.bCV) == null || a.a(this.bCV).equals(a.bP())) {
                    this.bCV.aI(false);
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            this.bCV.vY();
        } else if (i == -1) {
            this.bCV.aJ(false);
        }
    }
}
