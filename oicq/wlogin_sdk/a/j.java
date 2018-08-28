package oicq.wlogin_sdk.a;

public final class j extends a {
    int vJn;

    public j() {
        this.vJn = 0;
        this.vIl = 264;
    }

    public final byte[] bZ(byte[] bArr) {
        this.vJn = bArr.length;
        Object obj = new byte[this.vJn];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.IE(this.vIl);
        super.Z(obj, this.vJn);
        super.cKe();
        return super.cKa();
    }
}
