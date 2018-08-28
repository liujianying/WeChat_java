package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements b {
    final /* synthetic */ f emq;

    f$2(f fVar) {
        this.emq = fVar;
    }

    public final void b(String str, keep_SceneResult keep_sceneresult) {
        if (keep_sceneresult == null) {
            x.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[]{Integer.valueOf(this.emq.hashCode())});
            if (this.emq.emp != null) {
                this.emq.emp.a(this.emq, false, 0, 0);
                return;
            }
            return;
        }
        int i = keep_sceneresult.field_recvedBytes;
        int i2 = keep_sceneresult.field_fileLength;
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[]{Integer.valueOf(this.emq.hashCode()), str, this.emq.emj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(keep_sceneresult.field_videoFormat)});
        if (i > 0 && i2 > 0) {
            this.emq.emm = (long) f.b(this.emq.emj, i, true);
        }
        if (this.emq.emp != null) {
            f$a f_a = this.emq.emp;
            f fVar = this.emq;
            boolean z = i > 0 && i2 > 0;
            f_a.a(fVar, z, i, i2);
        }
        this.emq.eml = bi.VE();
        this.emq.nz(keep_sceneresult.getRptIpList());
        if (this.emq.emi) {
            h.mEJ.a(354, 142, 1, false);
            if (this.emq.emn == 1) {
                h.mEJ.a(354, 123, 1, false);
            } else {
                h.mEJ.a(354, 124, 1, false);
            }
            h.mEJ.a(354, (long) (keep_sceneresult.field_videoFormat + d.CTRL_INDEX), 1, false);
            return;
        }
        h.mEJ.a(354, 143, 1, false);
    }
}
