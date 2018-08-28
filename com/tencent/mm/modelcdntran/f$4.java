package com.tencent.mm.modelcdntran;

import com.tencent.mm.sdk.platformtools.x;

class f$4 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ Object[] dPE;
    final /* synthetic */ String sl;

    f$4(f fVar, String str, Object[] objArr) {
        this.dPC = fVar;
        this.sl = str;
        this.dPE = objArr;
    }

    public final void run() {
        j jVar = (j) this.dPC.dOW.remove(this.sl);
        keep_SceneResult keep_sceneresult;
        if (jVar != null) {
            keep_sceneresult = new keep_SceneResult();
            g.NE();
            if (b.a(jVar.field_mediaId, keep_sceneresult) == 0) {
                f.a(this.dPE, keep_sceneresult, jVar, false);
            } else {
                x.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[]{Integer.valueOf(b.a(jVar.field_mediaId, keep_sceneresult)), jVar.field_mediaId});
            }
        } else {
            jVar = (j) this.dPC.dPA.remove(this.sl);
            keep_sceneresult = (keep_SceneResult) this.dPC.dPB.remove(this.sl);
            if (!(jVar == null || keep_sceneresult == null)) {
                f.a(this.dPE, keep_sceneresult, jVar, true);
            }
        }
        this.dPC.dOV.remove(this.sl);
    }
}
