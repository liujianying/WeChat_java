package com.tencent.mm.ak;

import com.tencent.mm.ak.l.4;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class l$4$2 implements m$a {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ 4 dVO;
    final /* synthetic */ e dVz;

    l$4$2(4 4, keep_SceneResult keep_sceneresult, e eVar) {
        this.dVO = 4;
        this.dPf = keep_sceneresult;
        this.dVz = eVar;
    }

    public final void a(long j, int i, int i2, int i3) {
        h.mEJ.h(10421, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.dVO.dVN.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVO.dVN.dVl), Integer.valueOf(this.dPf.field_fileLength), this.dPf.field_transInfo, "", "", "", "", "", "", "", l.lO(this.dPf.report_Part2)});
        x.i(this.dVO.dVN.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[]{this.dVO.dVN.dVk, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.dVO.dVN.a(this.dVz, this.dVz.dHI, j, i, this.dPf);
            return;
        }
        i.hU((int) this.dVO.dVN.dVh);
        i.hT((int) this.dVO.dVN.dVh);
        this.dVO.dVN.diJ.a(i2, i3, "", this.dVO.dVN);
        if (this.dVO.dVN.dVF != null) {
            this.dVO.dVN.dVF.OS();
        }
    }
}
