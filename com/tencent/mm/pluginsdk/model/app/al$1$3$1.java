package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.pluginsdk.model.app.al.1.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class al$1$3$1 implements Runnable {
    final /* synthetic */ 3 qAG;

    al$1$3$1(3 3) {
        this.qAG = 3;
    }

    public final void run() {
        this.qAG.qAE.qAD.dVC = false;
        this.qAG.qAE.qAD.qAe.field_createTime = bi.VF();
        this.qAG.qAE.qAD.qAe.field_lastModifyTime = bi.VE();
        this.qAG.qAE.qAD.qAe.field_offset = 0;
        this.qAG.qAE.qAD.qAe.field_status = 101;
        boolean c = ao.asF().c(this.qAG.qAE.qAD.qAe, new String[0]);
        x.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[]{Boolean.valueOf(this.qAG.qAE.qAD.dVC), Boolean.valueOf(c), Long.valueOf(this.qAG.qAE.qAD.qAe.field_createTime)});
        this.qAG.qAE.qAD.a(this.qAG.qAE.qAD.dIX, this.qAG.qAE.qAD.diJ);
    }
}
