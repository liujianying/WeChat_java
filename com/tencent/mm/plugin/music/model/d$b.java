package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import com.tencent.mm.an.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.c;

class d$b implements Runnable {
    a bTF;
    final /* synthetic */ d lxX;

    public d$b(d dVar, a aVar) {
        this.lxX = dVar;
        this.bTF = aVar;
    }

    public final void run() {
        ate ate = new ate();
        ate.ksA = this.bTF.field_songMediaId;
        ate.rVE = this.bTF.field_songAlbumUrl;
        ate.rVF = this.bTF.field_songAlbumType;
        ate.jPK = ate.rVE;
        Bitmap b = n.nkx.b(ate);
        if (b != null) {
            b = c.e(b, 10);
            this.lxX.a(this.bTF, b);
            int[] s = com.tencent.mm.an.c.s(b);
            if (!this.bTF.f(s)) {
                this.bTF = h.bid().Z(this.bTF.field_musicId, s[0], s[1]);
            }
            if (this.lxX.lxU != null && this.bTF != null) {
                this.lxX.lxU.a(this.bTF, s);
            }
        }
    }
}
