package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int vJs;

    public y() {
        this.vJs = 0;
        this.vIl = 292;
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

    public final byte[] a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int aa = aa(bArr, 16);
        int aa2 = aa(bArr2, 16);
        int aa3 = aa(bArr3, 16);
        int aa4 = aa(bArr4, 32);
        int aa5 = aa(bArr5, 16);
        this.vJs = (((((((((aa + 2) + 2) + aa2) + 2) + 2) + aa3) + 2) + aa4) + 2) + aa5;
        Object obj = new byte[this.vJs];
        util.B(obj, 0, aa);
        System.arraycopy(bArr, 0, obj, 2, aa);
        aa += 2;
        util.B(obj, aa, aa2);
        aa += 2;
        System.arraycopy(bArr2, 0, obj, aa, aa2);
        aa += aa2;
        util.B(obj, aa, i);
        aa += 2;
        util.B(obj, aa, aa3);
        aa += 2;
        System.arraycopy(bArr3, 0, obj, aa, aa3);
        aa += aa3;
        util.B(obj, aa, aa4);
        aa += 2;
        System.arraycopy(bArr4, 0, obj, aa, aa4);
        aa += aa4;
        util.B(obj, aa, aa5);
        System.arraycopy(bArr5, 0, obj, aa + 2, aa5);
        super.IE(this.vIl);
        super.Z(obj, this.vJs);
        super.cKe();
        return super.cKa();
    }
}
