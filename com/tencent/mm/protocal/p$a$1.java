package com.tencent.mm.protocal;

import com.tencent.mm.ab.s;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;

class p$a$1 implements a {
    final /* synthetic */ d qWP;
    final /* synthetic */ p.a qWQ;

    p$a$1(p.a aVar, d dVar) {
        this.qWQ = aVar;
        this.qWP = dVar;
    }

    public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
        long j;
        b bVar = (b) this.qWP;
        long j2 = (long) this.qWP.qWs;
        if (com.tencent.mm.sdk.a.b.chp() && j2 == 0) {
            j = d.qVM;
        } else {
            j = j2;
        }
        y yVar = this.qWP.qWA;
        if (i == 722) {
            x.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            tu tuVar = ((p.a) this.qWP).qWO;
            byte[][] a = s.a(j, tuVar.rxD, tuVar.rxE);
            if (a == null) {
                return false;
            }
            byte[] bArr3 = a[0];
            byte[] bArr4 = a[1];
            if (MMProtocalJni.packHybrid(pByteArray, bArr, this.qWP.qWv, (int) j, bVar.If(), yVar.ver, bArr3, bArr4, yVar.qXe.getBytes(), yVar.qXf.getBytes(), this.qWP.qWz, i2)) {
                x.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                return true;
            }
        }
        return false;
    }
}
