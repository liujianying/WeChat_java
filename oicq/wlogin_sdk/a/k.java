package oicq.wlogin_sdk.a;

public final class k extends a {
    int vJo;

    public k() {
        this.vJo = 0;
        this.vIl = 265;
    }

    public final byte[] ca(byte[] bArr) {
        this.vJo = bArr.length;
        Object obj = new byte[this.vJo];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.IE(this.vIl);
        super.Z(obj, this.vJo);
        super.cKe();
        return super.cKa();
    }
}
