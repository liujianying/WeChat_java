package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class i$16 implements a {
    final /* synthetic */ i tWK;

    i$16(i iVar) {
        this.tWK = iVar;
    }

    public final boolean vD() {
        j cwO = this.tWK.tTx.cwO();
        if (cwO == null) {
            return false;
        }
        if (cwO.tWX == null) {
            return false;
        }
        if (cwO.cxz().tWX.getVisibility() != 0) {
            return false;
        }
        int currentItem = this.tWK.tTx.tTy.getCurrentItem();
        if (((r) this.tWK.tWt.get(currentItem)) == null) {
            this.tWK.FH(currentItem);
            return false;
        } else if (cwO.cxz().tXa.isPlaying()) {
            i.a(this.tWK, cwO.cxz().tXa.getCurrentPosition());
            this.tWK.FI(i.n(this.tWK) / 1000);
            return true;
        } else {
            x.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
            return false;
        }
    }
}
