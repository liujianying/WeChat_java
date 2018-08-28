package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$10 extends c<mu> {
    final /* synthetic */ t nNL;

    t$10(t tVar) {
        this.nNL = tVar;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        if (this.nNL.nNF == null || this.nNL.nMT == null) {
            x.e("MicroMsg.GalleryTitleManager", "not in recoging");
        } else if (muVar == null || !(muVar instanceof mu)) {
            x.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
        } else if (muVar.bXK.filePath.equals(this.nNL.nMT)) {
            x.i("MicroMsg.GalleryTitleManager", "recog result: " + muVar.bXK.result);
            if (!bi.oW(muVar.bXK.result)) {
                this.nNL.nMW = muVar.bXK.result;
                this.nNL.bJr = muVar.bXK.bJr;
                this.nNL.bJs = muVar.bXK.bJs;
                if (!(this.nNL.nMW == null || this.nNL.nNF == null)) {
                    this.nNL.nMX = true;
                }
                this.nNL.a(this.nNL.nNG, this.nNL.nhc, this.nNL.nNH, false, 0);
            }
            this.nNL.nMT = null;
        } else {
            x.e("MicroMsg.GalleryTitleManager", "not same filepath");
        }
        return false;
    }
}
