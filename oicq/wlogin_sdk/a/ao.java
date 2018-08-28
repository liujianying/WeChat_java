package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int vJK;
    int vJL;

    public ao() {
        this.vJK = 0;
        this.vJL = 0;
        this.vIl = 2;
    }

    public final byte[] n(byte[] bArr, byte[] bArr2) {
        this.vJK = (bArr.length + 6) + bArr2.length;
        Object obj = new byte[this.vJK];
        util.B(obj, 0, this.vJL);
        util.B(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        int length = bArr.length + 4;
        util.B(obj, length, bArr2.length);
        System.arraycopy(bArr2, 0, obj, length + 2, bArr2.length);
        super.IE(this.vIl);
        super.Z(obj, this.vJK);
        super.cKe();
        return super.cKa();
    }
}
