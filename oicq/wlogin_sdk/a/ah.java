package oicq.wlogin_sdk.a;

public final class ah extends a {
    public int vJC;

    public ah() {
        this.vJC = 0;
        this.vIl = 325;
    }

    public final byte[] cc(byte[] bArr) {
        int length;
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        Object obj = new byte[length];
        if (obj.length > 0) {
            System.arraycopy(bArr, 0, obj, 0, length);
        }
        this.vJC = obj.length;
        super.IE(this.vIl);
        super.Z(obj, obj.length);
        super.cKe();
        return super.cKa();
    }
}
