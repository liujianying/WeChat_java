package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.i.a;

class i$5 implements Runnable {
    final /* synthetic */ String nnz;
    final /* synthetic */ i tWK;
    final /* synthetic */ boolean tWO;

    i$5(i iVar, String str, boolean z) {
        this.tWK = iVar;
        this.nnz = str;
        this.tWO = z;
    }

    public final void run() {
        x.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[]{this.nnz, Boolean.valueOf(this.tWO)});
        if (i.l(this.tWK) == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
            return;
        }
        a aVar = (a) i.l(this.tWK).get(this.nnz);
        if (aVar != null && aVar.bGS != null) {
            r bA = i.bA(aVar.bGS);
            if (this.tWK.tTx.tTy.getCurrentItem() == aVar.pos) {
                i.a(this.tWK, aVar.bGS, bA, aVar.pos, this.tWO);
                this.tWK.aaz(this.nnz);
                return;
            }
            x.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[]{Integer.valueOf(this.tWK.tTx.tTy.getCurrentItem()), Integer.valueOf(aVar.pos)});
        }
    }
}
