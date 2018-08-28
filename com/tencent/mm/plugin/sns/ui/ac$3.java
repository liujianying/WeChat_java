package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.an.b;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;

class ac$3 implements Runnable {
    final /* synthetic */ ac nOP;

    ac$3(ac acVar) {
        this.nOP = acVar;
    }

    public final void run() {
        if (3 == this.nOP.nOa.getType()) {
            this.nOP.hTT = true;
            WXMusicObject wXMusicObject = (WXMusicObject) this.nOP.nOa.mediaObject;
            String aG = bi.aG(!bi.oW(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
            String aG2 = bi.aG(!bi.oW(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
            if (bi.oW(this.nOP.mediaId)) {
                this.nOP.mediaId = System.currentTimeMillis();
            }
            avq avq = new avq();
            avq.rYj = 1;
            avq.rsp = this.nOP.mediaId;
            avq.rYk = 0.0f;
            avq.rYn = "";
            avq.rYt = null;
            avq.rgC = 1;
            avq.rYs = null;
            avq.rYl = this.nOP.nOa.title;
            avq.rYm = this.nOP.nOa.description;
            avq.rYr = aG;
            avq.rYq = aG2;
            avq.rYp = aG2;
            avq.rvP = "";
            avq.rYu = af.Gq();
            avq.jQb = this.nOP.bPS;
            b.b(avq);
        }
    }
}
