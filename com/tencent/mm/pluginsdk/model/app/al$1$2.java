package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.al.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

class al$1$2 implements aa$a {
    final /* synthetic */ int hVh;
    final /* synthetic */ 1 qAE;

    al$1$2(1 1, int i) {
        this.qAE = 1;
        this.hVh = i;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        String str6 = "MicroMsg.NetSceneUploadAppAttach";
        String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = bi.Xf(str2);
        objArr[2] = bi.Xf(str3);
        objArr[3] = bi.Xf(str4);
        objArr[4] = bi.Xf(str5);
        objArr[5] = Boolean.valueOf(this.qAE.qAD.bGT == null);
        objArr[6] = Boolean.valueOf(this.qAE.qAD.dVC);
        x.i(str6, str7, objArr);
        if (!bi.oW(str3)) {
            this.qAE.qAD.qAe.field_signature = str3;
            this.qAE.qAD.qAe.field_fakeAeskey = str4;
            this.qAE.qAD.qAe.field_fakeSignature = str5;
            this.qAE.qAD.qAe.field_lastModifyTime = bi.VF();
            if (this.qAE.qAD.bGT != null) {
                this.qAE.qAD.bGT.filemd5 = str;
                this.qAE.qAD.bGT.dwK = str2;
                this.qAE.qAD.bGT.dwo = (int) j;
                au.HU();
                bd dW = c.FT().dW(this.qAE.qAD.qAe.field_msgInfoId);
                dW.setContent(a.a(this.qAE.qAD.bGT, null, null));
                au.HU();
                c.FT().a(dW.field_msgId, dW);
            }
        }
        this.qAE.qAD.dVC = false;
        boolean c = ao.asF().c(this.qAE.qAD.qAe, new String[0]);
        if (c) {
            au.Em().H(new 1(this));
            return;
        }
        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
        this.qAE.qAD.retCode = -10000 - g.getLine();
        this.qAE.qAD.diJ.a(3, this.hVh, "", this.qAE.qAD);
    }
}
