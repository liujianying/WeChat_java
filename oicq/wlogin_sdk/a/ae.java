package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int vJy;
    int vJz;

    public ae() {
        this.vJy = 0;
        this.vJz = 0;
        this.vIl = 322;
    }

    public final byte[] cb(byte[] bArr) {
        this.vJz = bArr.length + 4;
        Object obj = new byte[this.vJz];
        util.B(obj, 0, this.vJy);
        util.B(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        super.IE(this.vIl);
        super.Z(obj, obj.length);
        super.cKe();
        return super.cKa();
    }
}
