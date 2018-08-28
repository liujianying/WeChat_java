package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.protocal.j$b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class e$3 implements e {
    final /* synthetic */ e gUP;

    e$3(e eVar) {
        this.gUP = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        b.b(BaseReportManager.MAX_READ_COUNT, this.gUP.gUO);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            ew ewVar = ((j$b) ((a) lVar).dJM.Id()).qWr;
            String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
            String str3 = "onGYNetEnd QRCodeUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = ewVar == null ? "null" : ewVar.rfp;
            x.i(str2, str3, objArr);
            byte[] bArr = ewVar == null ? null : ewVar.rfo == null ? null : ewVar.rfo.siK.lR;
            if (bArr != null) {
                this.gUP.gRx.gRC = 51;
                this.gUP.gUL.l(51, bArr);
                return;
            }
            return;
        }
        x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:" + str);
        this.gUP.gRx.gRC = -11;
        this.gUP.gUL.l(-11, null);
    }
}
