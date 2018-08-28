package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.aj.a;
import com.tencent.mm.pluginsdk.model.app.al.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class al$1$3 implements a {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ 1 qAE;

    al$1$3(1 1, keep_SceneResult keep_sceneresult) {
        this.qAE = 1;
        this.dPf = keep_sceneresult;
    }

    public final void bp(int i, int i2) {
        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 4 && i2 == s$l.AppCompatTheme_checkboxStyle) {
            au.Em().H(new 1(this));
            return;
        }
        h.mEJ.h(10421, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.qAE.qAD.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(this.dPf.field_fileLength), this.dPf.field_transInfo, "", "", "", "", "", "", "", this.dPf.report_Part2});
        if (i == 0 && i2 == 0) {
            this.qAE.qAD.d(this.dPf);
        }
        this.qAE.qAD.diJ.a(i, i2, "", this.qAE.qAD);
    }
}
