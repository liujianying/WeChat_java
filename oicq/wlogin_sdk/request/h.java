package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.vIl = 2064;
        this.vIm = 3;
        this.vIo = iVar;
    }

    public final int x(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        int Y = super.Y(bArr, i + 2);
        super.cKb();
        int i3 = i + 5;
        switch (Y) {
            case 2:
                int z = fVar.z(bArr, i3, this.vIa - i3);
                if (z >= 0) {
                    this.vIo.vIt = fVar;
                    z = gVar.z(bArr, i3, this.vIa - i3);
                    if (z >= 0) {
                        this.vIo.vIu = gVar;
                        return Y;
                    }
                }
                return z;
            case 5:
                super.w(bArr, i3, (this.vIa - i3) - 1);
                return Y;
            default:
                w(bArr, i3, (this.vIa - i3) - 1);
                return Y;
        }
    }
}
