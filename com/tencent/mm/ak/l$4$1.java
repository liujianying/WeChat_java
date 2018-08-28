package com.tencent.mm.ak;

import com.tencent.mm.ak.l.4;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.sdk.platformtools.x;

class l$4$1 implements Runnable {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ 4 dVO;

    l$4$1(4 4, keep_SceneResult keep_sceneresult) {
        this.dVO = 4;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        this.dVO.dVN.dVC = false;
        this.dVO.dVN.startTime = 0;
        this.dVO.dVN.startOffset = 0;
        e d = this.dVO.dVN.OT();
        d.hJ(0);
        this.dVO.dVN.bGS.ay(bd.iD(this.dVO.dVN.bGS.field_talker));
        this.dVO.dVN.dVk = d.a("upimg", this.dVO.dVN.bGS.field_createTime, this.dVO.dVN.bGS.field_talker, this.dVO.dVN.bGS.field_msgId + "_" + this.dVO.dVN.dlN + "_" + this.dVO.dVN.dTO);
        boolean a = this.dVO.dVN.a(d, 0, 0, 0, this.dPf);
        bwi bwi = (bwi) this.dVO.dVN.diG.dID.dIL;
        if (bwi == null) {
            x.w(this.dVO.dVN.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
        } else {
            bwi.ssC = new bhz().VO(this.dVO.dVN.dVk);
        }
        x.i(this.dVO.dVN.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[]{Boolean.valueOf(this.dVO.dVN.dVC), Boolean.valueOf(a), this.dVO.dVN.dVk, Long.valueOf(this.dVO.dVN.bGS.field_createTime)});
        this.dVO.dVN.a(this.dVO.dVN.dIX, this.dVO.dVN.diJ);
    }
}
