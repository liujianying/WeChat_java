package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends l implements k {
    public q dJM = new a();
    private e diJ;

    public a(LinkedList<pw> linkedList, String str, String str2) {
        final com.tencent.mm.protocal.j.a aVar = (com.tencent.mm.protocal.j.a) this.dJM.KV();
        aVar.qWq = d.aqT();
        aVar.qWp.rfh = linkedList.size();
        aVar.qWp.rfi = linkedList;
        aVar.qWp.rfj = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
        aVar.qWp.rfk = com.tencent.mm.model.q.GF();
        aVar.qWp.otY = 2;
        aVar.qWp.hbZ = 0;
        aVar.qWp.rfl = str;
        aVar.qWp.rfm = str2;
        aVar.qWz = aVar.qWq;
        aVar.qWy = new com.tencent.mm.protocal.k.a() {
            public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                long j;
                long j2 = (long) aVar.qWs;
                if (b.chp() && j2 == 0) {
                    j = com.tencent.mm.protocal.d.qVM;
                } else {
                    j = j2;
                }
                y yVar = aVar.qWA;
                if (i == 1000) {
                    byte[] bArr3 = aVar.qWz;
                    x.d("MicroMsg.BackupCreateQRCodeOfflineScene", "BakMove key:" + bArr3);
                    if (!yVar.cgu()) {
                        bArr3 = new byte[0];
                    }
                    if (bi.bC(bArr3)) {
                        x.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[]{Integer.valueOf(i)});
                        return false;
                    }
                    if (MMProtocalJni.pack(aVar.Ie(), pByteArray, bArr3, bArr, aVar.qWv, (int) j, 1000, yVar.ver, yVar.qXe.getBytes(), yVar.qXf.getBytes(), bArr2, i2)) {
                        x.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[]{Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2)});
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((j.b) qVar.Id()).qWr.rfp});
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1000;
    }
}
