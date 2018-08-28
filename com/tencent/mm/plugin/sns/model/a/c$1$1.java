package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.1;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.sdk.platformtools.x;

class c$1$1 implements Runnable {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ int hZq;
    final /* synthetic */ 1 ntj;

    c$1$1(1 1, int i, keep_SceneResult keep_sceneresult) {
        this.ntj = 1;
        this.hZq = i;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        c.bze().remove(this.ntj.nti.nsN.nob);
        x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[]{Integer.valueOf(this.hZq), this.ntj.nti.nsN.url, this.ntj.nti.nsN.mediaId, Integer.valueOf(this.dPf.field_fileLength), Integer.valueOf(c.bze().size())});
        if (this.ntj.nti.nsN.nsG && this.hZq != 2) {
            av.Mv(this.ntj.nti.nsN.mediaId);
            this.ntj.nti.bzd();
        } else if (!this.ntj.nti.nsN.nsG && (this.ntj.nti.nsN.nsI == 4 || this.ntj.nti.nsN.nsI == 6)) {
            af.byl().ex(this.ntj.nti.nsN.mediaId, this.ntj.nti.nsN.getPath() + i.j(this.ntj.nti.caK));
        }
        this.ntj.nti.nsL.a(this.hZq, this.ntj.nti.caK, this.ntj.nti.nsN.nsI, this.ntj.nti.nsN.nsG, this.ntj.nti.nsN.nob, this.dPf.field_fileLength);
    }
}
