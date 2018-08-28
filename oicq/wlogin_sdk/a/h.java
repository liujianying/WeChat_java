package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int vJj;
    int vJk;
    int vJl;

    public h() {
        this.vJj = 1;
        this.vJk = 1;
        this.vJl = 69;
        this.vIl = 262;
        this.vJk = util.vKh;
        if (util.vKh <= 2) {
            this.vJj = 1;
            this.vJl = 69;
            return;
        }
        this.vJj = 2;
        this.vJl = 90;
    }

    public final byte[] a(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        Object obj;
        int length;
        Object obj2;
        byte[] b;
        if (util.vKh <= 2) {
            obj = new byte[this.vJl];
            util.B(obj, 0, this.vJj);
            util.C(obj, 2, util.cKl());
            util.C(obj, 6, this.vJk);
            util.C(obj, 10, 522017402);
            util.C(obj, 14, i);
            util.c(obj, 18, j);
            System.arraycopy(bArr, 0, obj, 26, bArr.length);
            length = bArr.length + 26;
            System.arraycopy(bArr2, 0, obj, length, bArr2.length);
            length += bArr2.length;
            util.A(obj, length, 1);
            length++;
            System.arraycopy(bArr3, 0, obj, length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, length + bArr3.length, bArr4.length);
            obj2 = new byte[24];
            System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
            util.c(obj2, 16, j);
            b = d.b(obj, obj.length, c.ce(obj2));
            this.vJl = b.length;
            super.IE(this.vIl);
            super.Z(b, this.vJl);
            super.cKe();
            return super.cKa();
        }
        obj = new byte[this.vJl];
        util.B(obj, 0, this.vJj);
        util.C(obj, 2, util.cKl());
        util.C(obj, 6, this.vJk);
        util.C(obj, 10, 522017402);
        util.C(obj, 14, i);
        util.c(obj, 18, j);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, obj, length, bArr2.length);
        length += bArr2.length;
        util.A(obj, length, 1);
        length++;
        System.arraycopy(bArr3, 0, obj, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, obj, length, bArr4.length);
        length += bArr4.length;
        util.C(obj, length, 0);
        length += 4;
        util.A(obj, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr6 = new byte[16];
            util.C(bArr6, 0, util.cKl());
            util.C(bArr6, 4, util.cKl());
            util.C(bArr6, 8, util.cKl());
            util.C(bArr6, 12, util.cKl());
        } else {
            System.arraycopy(bArr5, 0, obj, length, bArr5.length);
        }
        obj2 = new byte[24];
        System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
        util.c(obj2, 16, j);
        b = d.b(obj, obj.length, c.ce(obj2));
        this.vJl = b.length;
        super.IE(this.vIl);
        super.Z(b, this.vJl);
        super.cKe();
        return cKa();
    }
}
