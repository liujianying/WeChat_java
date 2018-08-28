package oicq.wlogin_sdk.a;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int vHZ = FileUtils.S_IWUSR;
    int vIT = 0;
    public int vIU = 4;
    public int vIV = 0;
    public int vIa = 0;
    public byte[] vIf = new byte[this.vHZ];
    public int vIl = 0;

    public final byte[] cKa() {
        Object obj = new byte[this.vIa];
        System.arraycopy(this.vIf, 0, obj, 0, this.vIa);
        return obj;
    }

    public final byte[] cKd() {
        Object obj = new byte[this.vIV];
        System.arraycopy(this.vIf, this.vIU, obj, 0, this.vIV);
        return obj;
    }

    public final void IE(int i) {
        util.B(this.vIf, this.vIa, i);
        this.vIa += 2;
        util.B(this.vIf, this.vIa, 0);
        this.vIa += 2;
    }

    public final void cKe() {
        util.B(this.vIf, 2, this.vIa - this.vIU);
    }

    public final void Z(byte[] bArr, int i) {
        if (i > this.vHZ - this.vIU) {
            this.vHZ = (this.vIU + i) + 64;
            Object obj = new byte[this.vHZ];
            System.arraycopy(this.vIf, 0, obj, 0, this.vIa);
            this.vIf = obj;
        }
        this.vIV = i;
        System.arraycopy(bArr, 0, this.vIf, this.vIa, i);
        this.vIa += i;
    }

    private static int y(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.ac(bArr, i3) != i2) {
                i3 += 2;
                if (i3 + 2 > length) {
                    break;
                }
                i3 += util.ac(bArr, i3) + 2;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final int z(byte[] bArr, int i, int i2) {
        int y = y(bArr, i, this.vIl);
        if (y < 0) {
            return -1;
        }
        int i3 = i2 - (y - i);
        if (this.vIU >= i3) {
            return -1;
        }
        this.vIV = util.ac(bArr, y + 2);
        if (this.vIU + this.vIV > i3) {
            return -1;
        }
        int i4 = this.vIU + this.vIV;
        if (i4 > this.vHZ) {
            this.vHZ = i4 + FileUtils.S_IWUSR;
            this.vIf = new byte[this.vHZ];
        }
        this.vIa = i4;
        System.arraycopy(bArr, y, this.vIf, 0, i4);
        this.vIl = util.ac(bArr, y);
        this.vIV = i4 - this.vIU;
        if (cKf().booleanValue()) {
            return (this.vIU + y) + this.vIV;
        }
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int y = y(bArr, i, this.vIl);
        if (y < 0) {
            return -1;
        }
        int i3 = i2 - (y - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, y, obj, 0, i3);
        if (this.vIU >= i3) {
            return -1;
        }
        this.vIV = util.ac(obj, 2);
        if (this.vIU + this.vIV > i3) {
            return -1;
        }
        Object decrypt = d.decrypt(obj, this.vIU, this.vIV, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        if (this.vIU + decrypt.length > this.vHZ) {
            this.vHZ = this.vIU + decrypt.length;
            this.vIf = new byte[this.vHZ];
        }
        this.vIa = 0;
        System.arraycopy(obj, 0, this.vIf, 0, this.vIU);
        this.vIa += this.vIU;
        System.arraycopy(decrypt, 0, this.vIf, this.vIa, decrypt.length);
        this.vIa += decrypt.length;
        this.vIV = decrypt.length;
        return !cKf().booleanValue() ? -1005 : 0;
    }

    public Boolean cKf() {
        return Boolean.valueOf(true);
    }
}
