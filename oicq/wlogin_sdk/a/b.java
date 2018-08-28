package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int vIW;
    int vIX;
    int vIY;
    int vIZ;
    byte[] vJa;

    public b() {
        this.vIW = 4;
        this.vIX = 14;
        this.vIY = 1;
        this.vIZ = 20;
        this.vJa = new byte[2];
        this.vIl = 1;
    }

    public final Boolean cKf() {
        if (this.vIV < 20) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final byte[] g(long j, byte[] bArr) {
        Object obj = new byte[this.vIZ];
        util.B(obj, 0, this.vIY);
        util.C(obj, 2, util.cKl());
        util.C(obj, 6, (int) j);
        util.d(obj, 10, util.cKn());
        System.arraycopy(bArr, 0, obj, 14, bArr.length);
        util.B(obj, bArr.length + 14, 0);
        super.IE(this.vIl);
        super.Z(obj, this.vIZ);
        super.cKe();
        return super.cKa();
    }
}
