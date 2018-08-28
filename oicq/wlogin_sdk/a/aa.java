package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int vJv;

    public aa() {
        this.vJv = 0;
        this.vIl = 296;
    }

    private static int aa(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int aa = aa(bArr, 32);
        int aa2 = aa(bArr2, 16);
        this.vJv = (((aa + 11) + 2) + aa2) + 2;
        Object obj = new byte[this.vJv];
        util.B(obj, 0, 0);
        util.A(obj, 2, i);
        util.A(obj, 3, i2);
        util.A(obj, 4, i3);
        util.C(obj, 5, 0);
        util.B(obj, 9, aa);
        System.arraycopy(bArr, 0, obj, 11, aa);
        aa += 11;
        util.B(obj, aa, aa2);
        aa += 2;
        System.arraycopy(bArr2, 0, obj, aa, aa2);
        util.B(obj, aa + aa2, 0);
        super.IE(this.vIl);
        super.Z(obj, this.vJv);
        super.cKe();
        return super.cKa();
    }
}
