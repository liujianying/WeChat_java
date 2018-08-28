package oicq.wlogin_sdk.a;

public final class f extends a {
    int vJe;

    public f() {
        this.vJe = 0;
        this.vIl = 260;
    }

    public final byte[] bY(byte[] bArr) {
        this.vJe = bArr.length;
        Object obj = new byte[this.vJe];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.IE(this.vIl);
        super.Z(obj, this.vJe);
        super.cKe();
        return super.cKa();
    }
}
