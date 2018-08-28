package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.vIl = 2064;
        this.vIm = 2;
        this.vIo = iVar;
    }

    public final byte[] bX(byte[] bArr) {
        int length;
        int i;
        int i2 = this.vIo.vIy;
        byte[] cKd = this.vIo.vIt.cKd();
        oicq.wlogin_sdk.a.g gVar = this.vIo.vIu;
        Object obj = new byte[gVar.vJg];
        if (gVar.vJg > 0) {
            System.arraycopy(gVar.vIf, gVar.vJi, obj, 0, gVar.vJg);
        }
        f fVar = new f();
        ao aoVar = new ao();
        Object bY = fVar.bY(cKd);
        Object n = aoVar.n(bArr, obj);
        Object obj2 = new byte[(bY.length + n.length)];
        if (cKd.length > 0) {
            System.arraycopy(bY, 0, obj2, 0, bY.length);
            length = bY.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(n, 0, obj2, length, n.length);
        a(this.vIg, this.vIl, this.vIo._uin, this.vIi, this.vIj, i2, this.vIk, super.v(obj2, this.vIm, i + 1));
        return super.cKa();
    }
}
