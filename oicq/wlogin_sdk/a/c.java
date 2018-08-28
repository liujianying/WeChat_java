package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int vJb;
    int vJc;
    int vJd;

    public c() {
        this.vJb = 1;
        this.vJc = util.vKh;
        this.vJd = 22;
        this.vIl = 256;
    }

    public final byte[] IF(int i) {
        byte[] bArr = new byte[this.vJd];
        util.B(bArr, 0, this.vJb);
        util.C(bArr, 2, this.vJc);
        util.C(bArr, 6, 522017402);
        util.C(bArr, 10, 1);
        util.C(bArr, 14, i);
        util.C(bArr, 18, 8256);
        super.IE(this.vIl);
        super.Z(bArr, this.vJd);
        super.cKe();
        return super.cKa();
    }
}
