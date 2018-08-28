package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aa.g.b;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements b {
    final /* synthetic */ Bitmap mQt;
    final /* synthetic */ f qFr;

    f$2(f fVar, Bitmap bitmap) {
        this.qFr = fVar;
        this.mQt = bitmap;
    }

    public final int bd(int i, int i2) {
        f.a(this.qFr).Ku();
        x.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            Bitmap jU = q.Kp().jU(f.b(this.qFr));
            if (jU != null) {
                f.a(this.qFr, jU, q.Kp().c(f.b(this.qFr), true, false));
            } else {
                f.a(this.qFr, this.mQt, null);
            }
            if (f.c(this.qFr) != null) {
                f.c(this.qFr);
                f.b(this.qFr);
            }
        } else {
            f.a(this.qFr, this.mQt, null);
            if (f.c(this.qFr) != null) {
                f.c(this.qFr);
                f.b(this.qFr);
            }
        }
        return 0;
    }
}
