package f.a.a.c;

import com.tencent.mm.bk.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    public final OutputStream dHY = null;
    public final byte[] vHI;
    private final f.a.a.b.b.a vHJ;

    public a(byte[] bArr) {
        this.vHI = bArr;
        this.vHJ = new f.a.a.b.b.a(bArr, bArr.length);
    }

    public final void av(int i, boolean z) {
        int i2 = 0;
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 0);
        if (z) {
            i2 = 1;
        }
        aVar.eb(i2);
    }

    public final void b(int i, b bVar) {
        f.a.a.b.b.a aVar = this.vHJ;
        if (bVar != null) {
            aVar.aI(i, 2);
            byte[] toByteArray = bVar.toByteArray();
            aVar.ed(toByteArray.length);
            aVar.p(toByteArray);
        }
    }

    public final void c(int i, double d) {
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        aVar.eb(((int) doubleToLongBits) & 255);
        aVar.eb(((int) (doubleToLongBits >> 8)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 16)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 24)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 32)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 40)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 48)) & 255);
        aVar.eb(((int) (doubleToLongBits >> 56)) & 255);
    }

    public final void l(int i, float f) {
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        aVar.eb(floatToIntBits & 255);
        aVar.eb((floatToIntBits >> 8) & 255);
        aVar.eb((floatToIntBits >> 16) & 255);
        aVar.eb((floatToIntBits >> 24) & 255);
    }

    public final void fT(int i, int i2) {
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 0);
        if (i2 >= 0) {
            aVar.ed(i2);
        } else {
            aVar.ag((long) i2);
        }
    }

    public final void fU(int i, int i2) {
        fT(i, i2);
    }

    public final void T(int i, long j) {
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 0);
        aVar.ag(j);
    }

    public final void g(int i, String str) {
        f.a.a.b.b.a aVar = this.vHJ;
        if (str != null) {
            aVar.aI(i, 2);
            byte[] bytes = str.getBytes("UTF-8");
            aVar.ed(bytes.length);
            aVar.p(bytes);
        }
    }

    public final void fV(int i, int i2) {
        f.a.a.b.b.a aVar = this.vHJ;
        aVar.aI(i, 2);
        aVar.ed(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(int r5, int r6, java.util.LinkedList<?> r7) {
        /*
        r4 = this;
        r0 = 0;
        if (r7 == 0) goto L_0x0023;
    L_0x0003:
        switch(r6) {
            case 1: goto L_0x0091;
            case 2: goto L_0x0061;
            case 3: goto L_0x0079;
            case 4: goto L_0x0031;
            case 5: goto L_0x0049;
            case 6: goto L_0x001c;
            case 7: goto L_0x00a5;
            case 8: goto L_0x00bd;
            default: goto L_0x0006;
        };
    L_0x0006:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "The data type was not found, the id used was ";
        r1.<init>(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x001c:
        r1 = r0;
    L_0x001d:
        r0 = r7.size();
        if (r1 < r0) goto L_0x0024;
    L_0x0023:
        return;
    L_0x0024:
        r0 = r7.get(r1);
        r0 = (com.tencent.mm.bk.b) r0;
        r4.b(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x001d;
    L_0x0031:
        r1 = r0;
    L_0x0032:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x0038:
        r0 = r7.get(r1);
        r0 = (java.lang.Double) r0;
        r2 = r0.doubleValue();
        r4.c(r5, r2);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0032;
    L_0x0049:
        r1 = r0;
    L_0x004a:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x0050:
        r0 = r7.get(r1);
        r0 = (java.lang.Float) r0;
        r0 = r0.floatValue();
        r4.l(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x004a;
    L_0x0061:
        r1 = r0;
    L_0x0062:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x0068:
        r0 = r7.get(r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r4.fT(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0062;
    L_0x0079:
        r1 = r0;
    L_0x007a:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x0080:
        r0 = r7.get(r1);
        r0 = (java.lang.Long) r0;
        r2 = r0.longValue();
        r4.T(r5, r2);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x007a;
    L_0x0091:
        r1 = r0;
    L_0x0092:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x0098:
        r0 = r7.get(r1);
        r0 = (java.lang.String) r0;
        r4.g(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0092;
    L_0x00a5:
        r1 = r0;
    L_0x00a6:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x00ac:
        r0 = r7.get(r1);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        r4.av(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a6;
    L_0x00bd:
        r1 = r0;
    L_0x00be:
        r0 = r7.size();
        if (r1 >= r0) goto L_0x0023;
    L_0x00c4:
        r0 = r7.get(r1);
        r0 = (com.tencent.mm.bk.a) r0;
        r2 = r0.boi();
        r4.fV(r5, r2);
        r0.a(r4);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.a.d(int, int, java.util.LinkedList):void");
    }

    public final void c(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        if (linkedList != null && linkedList.size() > 0) {
            int i3;
            this.vHJ.aI(i, 2);
            f.a.a.b.b.a aVar = this.vHJ;
            if (linkedList == null || linkedList.size() <= 0) {
                i3 = 0;
            } else {
                i3 = 0;
                int i4 = 0;
                while (i4 < linkedList.size()) {
                    i4++;
                    i3 = f.a.a.b.b.a.ee(((Integer) linkedList.get(i4)).intValue()) + i3;
                }
            }
            aVar.ed(i3);
            while (i2 < linkedList.size()) {
                this.vHJ.ed(((Integer) linkedList.get(i2)).intValue());
                i2++;
            }
        }
    }
}
