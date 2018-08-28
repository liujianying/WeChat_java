package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.pluginsdk.model.app.al.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class al$1$1 implements a {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ int hVh;
    final /* synthetic */ 1 qAE;

    al$1$1(1 1, int i, keep_SceneResult keep_sceneresult) {
        this.qAE = 1;
        this.hVh = i;
        this.dPf = keep_sceneresult;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        boolean z = true;
        String str6 = "MicroMsg.NetSceneUploadAppAttach";
        String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = bi.Xf(str2);
        objArr[2] = bi.Xf(str3);
        objArr[3] = bi.Xf(str4);
        objArr[4] = bi.Xf(str5);
        if (this.qAE.qAD.bGT != null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(this.qAE.qAD.dVC);
        x.i(str6, str7, objArr);
        if (!bi.oW(str3)) {
            this.qAE.qAD.qAe.field_signature = str3;
            this.qAE.qAD.qAe.field_fakeAeskey = str4;
            this.qAE.qAD.qAe.field_fakeSignature = str5;
        }
        this.qAE.a(this.hVh, this.dPf);
    }
}
