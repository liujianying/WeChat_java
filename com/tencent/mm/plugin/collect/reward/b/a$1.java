package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.collect.reward.b.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ int hVh;
    final /* synthetic */ a hVi;
    final /* synthetic */ String sl;

    a$1(a aVar, String str, keep_SceneResult keep_sceneresult, int i) {
        this.hVi = aVar;
        this.sl = str;
        this.dPf = keep_sceneresult;
        this.hVh = i;
    }

    public final void run() {
        a aVar = (a) a.a(this.hVi).get(this.sl);
        if (aVar == null) {
            x.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
        } else if (this.dPf != null) {
            aVar.K(this.sl, this.hVh, this.dPf.field_retCode);
            a.a(this.hVi).remove(this.sl);
            if (this.dPf.field_retCode == 0) {
                h.mEJ.a(724, 8, 1, false);
            } else {
                h.mEJ.a(724, 9, 1, false);
            }
        } else {
            x.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
        }
    }
}
