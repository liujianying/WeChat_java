package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int vJp;
    int vJq;

    public r() {
        this.vJp = 0;
        this.vJq = 0;
        this.vIl = 278;
    }

    public final byte[] fW(int i, int i2) {
        this.vJp = 10;
        byte[] bArr = new byte[this.vJp];
        util.A(bArr, 0, this.vJq);
        util.C(bArr, 1, i);
        util.C(bArr, 5, i2);
        util.A(bArr, 9, 0);
        super.IE(this.vIl);
        super.Z(bArr, this.vJp);
        super.cKe();
        return super.cKa();
    }
}
