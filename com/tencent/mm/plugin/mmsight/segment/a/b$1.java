package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.mm.plugin.u.c;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements c {
    final /* synthetic */ b lnH;

    b$1(b bVar) {
        this.lnH = bVar;
    }

    public final void iy() {
        if (this.lnH.lnF != null) {
            this.lnH.lnF.bG(this.lnH.lnz);
        }
        if (this.lnH.bTv) {
            this.lnH.lnz.start();
        }
        this.lnH.Fd = true;
    }

    public final void wd() {
        if (this.lnH.dGv) {
            this.lnH.lnz.sG(this.lnH.lnB);
        }
    }

    public final void onError(int i, int i2) {
        if (this.lnH.lnD != null) {
            this.lnH.lnD.cS(i, i2);
        }
    }

    public final void bdq() {
        x.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[]{this.lnH.lnG});
        if (this.lnH.lnG != null) {
            this.lnH.lnG.bH(this.lnH.lnz);
        } else if (this.lnH.bTv) {
            this.lnH.lnz.start();
        }
    }

    public final void N(int i, int i2, int i3) {
        this.lnH.lnA = i3;
        if (this.lnH.lnE != null) {
            this.lnH.lnE.P(i, i2, i3);
        }
    }
}
