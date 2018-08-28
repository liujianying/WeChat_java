package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int vJm;

    public i() {
        this.vJm = 6;
        this.vIl = 263;
    }

    public final byte[] cKg() {
        byte[] bArr = new byte[this.vJm];
        util.B(bArr, 0, 0);
        util.A(bArr, 2, 1);
        util.B(bArr, 3, 102400);
        util.A(bArr, 5, 1);
        super.IE(this.vIl);
        super.Z(bArr, this.vJm);
        super.cKe();
        return super.cKa();
    }
}
