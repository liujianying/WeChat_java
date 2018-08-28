package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int vJH;
    int vJI;
    int vJJ;

    public an() {
        this.vJH = 22;
        this.vJI = 1;
        this.vJJ = 1536;
        this.vIl = 24;
    }

    public final byte[] U(int i, long j) {
        byte[] bArr = new byte[this.vJH];
        util.B(bArr, 0, this.vJI);
        util.C(bArr, 2, this.vJJ);
        util.C(bArr, 6, 522017402);
        util.C(bArr, 10, i);
        util.C(bArr, 14, (int) j);
        util.B(bArr, 18, 0);
        util.B(bArr, 20, 0);
        super.IE(this.vIl);
        super.Z(bArr, this.vJH);
        super.cKe();
        return super.cKa();
    }
}
