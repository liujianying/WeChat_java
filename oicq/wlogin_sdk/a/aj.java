package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.vIl = 327;
    }

    private static int cd(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] m(byte[] bArr, byte[] bArr2) {
        int cd = cd(bArr);
        int cd2 = cd(bArr2);
        Object obj = new byte[(((cd + 6) + 2) + cd2)];
        util.d(obj, 0, 522017402);
        util.B(obj, 4, cd);
        System.arraycopy(bArr, 0, obj, 6, cd);
        cd += 6;
        util.B(obj, cd, cd2);
        System.arraycopy(bArr2, 0, obj, cd + 2, cd2);
        super.IE(this.vIl);
        super.Z(obj, obj.length);
        super.cKe();
        return super.cKa();
    }
}
