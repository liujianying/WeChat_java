package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class e$2 implements e {
    final /* synthetic */ e gUP;

    e$2(e eVar) {
        this.gUP = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        b.b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_PARSER_CONTENT_FAILED, this.gUP.gUN);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.backup.d.b bVar = (com.tencent.mm.plugin.backup.d.b) lVar;
            ex exVar = (ex) bVar.diG.dIE.dIL;
            b.arv().gRu = "";
            b.arv().gRv = exVar.rfr;
            b.arv().gRw = exVar.rfs;
            b.arv().gTH = exVar.rfm;
            exVar = (ex) bVar.diG.dIE.dIL;
            byte[] bArr = exVar == null ? null : exVar.rfo == null ? null : exVar.rfo.siK.lR;
            if (bArr != null) {
                this.gUP.gRx.gRC = 51;
                this.gUP.gUL.l(51, bArr);
                return;
            }
            return;
        }
        x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:" + str);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i2 == -100) {
            au.DF().a(BaseReportManager.MAX_READ_COUNT, this.gUP.gUO);
            au.DF().a(new a(this.gUP.gUH, this.gUP.gUI, b.arv().gTH), 0);
            return;
        }
        this.gUP.gRx.gRC = -11;
        this.gUP.gUL.l(-11, null);
    }
}
