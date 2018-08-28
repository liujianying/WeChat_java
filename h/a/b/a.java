package h.a.b;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import h.a.c.b;

public final class a {
    h.a.a.a vLd = new h.a.a.a();
    b vLe = new b();
    short[] vLf = new short[192];
    short[] vLg = new short[12];
    short[] vLh = new short[12];
    short[] vLi = new short[12];
    short[] vLj = new short[12];
    short[] vLk = new short[192];
    h.a.c.a[] vLl = new h.a.c.a[4];
    short[] vLm = new short[114];
    h.a.c.a vLn = new h.a.c.a(4);
    a vLo = new a(this);
    a vLp = new a(this);
    b vLq = new b(this);
    int vLr = -1;
    int vLs = -1;
    int vLt;

    public a() {
        for (int i = 0; i < 4; i++) {
            this.vLl[i] = new h.a.c.a(6);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r20, java.io.OutputStream r21, long r22) {
        /*
        r19 = this;
        r0 = r19;
        r2 = r0.vLe;
        r0 = r20;
        r2.vLJ = r0;
        r0 = r19;
        r2 = r0.vLd;
        r2.cKG();
        r0 = r21;
        r2.vLc = r0;
        r0 = r19;
        r2 = r0.vLd;
        r3 = 0;
        r2.vLb = r3;
        r3 = 0;
        r2.vIa = r3;
        r0 = r19;
        r2 = r0.vLf;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLk;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLg;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLh;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLi;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLj;
        h.a.c.b.c(r2);
        r0 = r19;
        r2 = r0.vLm;
        h.a.c.b.c(r2);
        r0 = r19;
        r3 = r0.vLq;
        r2 = 1;
        r4 = r3.vLB;
        r5 = r3.vLC;
        r4 = r4 + r5;
        r4 = r2 << r4;
        r2 = 0;
    L_0x005b:
        if (r2 >= r4) goto L_0x0069;
    L_0x005d:
        r5 = r3.vLA;
        r5 = r5[r2];
        r5 = r5.vLE;
        h.a.c.b.c(r5);
        r2 = r2 + 1;
        goto L_0x005b;
    L_0x0069:
        r2 = 0;
    L_0x006a:
        r3 = 4;
        if (r2 >= r3) goto L_0x007b;
    L_0x006d:
        r0 = r19;
        r3 = r0.vLl;
        r3 = r3[r2];
        r3 = r3.vLG;
        h.a.c.b.c(r3);
        r2 = r2 + 1;
        goto L_0x006a;
    L_0x007b:
        r0 = r19;
        r2 = r0.vLo;
        r2.cKI();
        r0 = r19;
        r2 = r0.vLp;
        r2.cKI();
        r0 = r19;
        r2 = r0.vLn;
        r2 = r2.vLG;
        h.a.c.b.c(r2);
        r0 = r19;
        r3 = r0.vLe;
        r2 = 0;
        r3.spd = r2;
        r2 = -1;
        r3.vLI = r2;
        r2 = 0;
    L_0x009d:
        r4 = 5;
        if (r2 >= r4) goto L_0x00b0;
    L_0x00a0:
        r4 = r3.spd;
        r4 = r4 << 8;
        r5 = r3.vLJ;
        r5 = r5.read();
        r4 = r4 | r5;
        r3.spd = r4;
        r2 = r2 + 1;
        goto L_0x009d;
    L_0x00b0:
        r13 = 0;
        r11 = 0;
        r6 = 0;
        r4 = 0;
        r5 = 0;
        r2 = 0;
        r7 = 0;
        r14 = r2;
        r16 = r7;
    L_0x00bb:
        r2 = 0;
        r2 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x00c5;
    L_0x00c1:
        r2 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1));
        if (r2 >= 0) goto L_0x0339;
    L_0x00c5:
        r2 = (int) r14;
        r0 = r19;
        r3 = r0.vLt;
        r10 = r2 & r3;
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLf;
        r7 = r13 << 4;
        r7 = r7 + r10;
        r2 = r2.e(r3, r7);
        if (r2 != 0) goto L_0x0178;
    L_0x00dd:
        r0 = r19;
        r2 = r0.vLq;
        r3 = (int) r14;
        r7 = r2.vLA;
        r8 = r2.vLD;
        r3 = r3 & r8;
        r8 = r2.vLB;
        r3 = r3 << r8;
        r0 = r16;
        r8 = r0 & 255;
        r2 = r2.vLB;
        r2 = 8 - r2;
        r2 = r8 >>> r2;
        r2 = r2 + r3;
        r7 = r7[r2];
        r2 = 7;
        if (r13 >= r2) goto L_0x012f;
    L_0x00fa:
        r2 = 1;
    L_0x00fb:
        if (r2 != 0) goto L_0x015a;
    L_0x00fd:
        r0 = r19;
        r8 = r0.vLe;
        r0 = r19;
        r2 = r0.vLd;
        r3 = r2.IG(r11);
        r2 = 1;
    L_0x010a:
        r9 = r3 >> 7;
        r9 = r9 & 1;
        r3 = r3 << 1;
        r3 = (byte) r3;
        r10 = r7.vLE;
        r12 = r9 + 1;
        r12 = r12 << 8;
        r12 = r12 + r2;
        r10 = r8.e(r10, r12);
        r2 = r2 << 1;
        r2 = r2 | r10;
        if (r9 == r10) goto L_0x0131;
    L_0x0121:
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 >= r3) goto L_0x0135;
    L_0x0125:
        r3 = r2 << 1;
        r9 = r7.vLE;
        r2 = r8.e(r9, r2);
        r2 = r2 | r3;
        goto L_0x0121;
    L_0x012f:
        r2 = 0;
        goto L_0x00fb;
    L_0x0131:
        r9 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 < r9) goto L_0x010a;
    L_0x0135:
        r2 = (byte) r2;
    L_0x0136:
        r0 = r19;
        r3 = r0.vLd;
        r7 = r3.vKZ;
        r8 = r3.vIa;
        r9 = r8 + 1;
        r3.vIa = r9;
        r7[r8] = r2;
        r7 = r3.vIa;
        r8 = r3.vLa;
        if (r7 < r8) goto L_0x014d;
    L_0x014a:
        r3.cKH();
    L_0x014d:
        r3 = 4;
        if (r13 >= r3) goto L_0x016e;
    L_0x0150:
        r3 = 0;
    L_0x0151:
        r8 = 1;
        r8 = r8 + r14;
        r14 = r8;
        r16 = r2;
        r13 = r3;
        goto L_0x00bb;
    L_0x015a:
        r0 = r19;
        r3 = r0.vLe;
        r2 = 1;
    L_0x015f:
        r8 = r2 << 1;
        r9 = r7.vLE;
        r2 = r3.e(r9, r2);
        r2 = r2 | r8;
        r8 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 < r8) goto L_0x015f;
    L_0x016c:
        r2 = (byte) r2;
        goto L_0x0136;
    L_0x016e:
        r3 = 10;
        if (r13 >= r3) goto L_0x0175;
    L_0x0172:
        r3 = r13 + -3;
        goto L_0x0151;
    L_0x0175:
        r3 = r13 + -6;
        goto L_0x0151;
    L_0x0178:
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLg;
        r2 = r2.e(r3, r13);
        r3 = 1;
        if (r2 != r3) goto L_0x0206;
    L_0x0187:
        r9 = 0;
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLh;
        r2 = r2.e(r3, r13);
        if (r2 != 0) goto L_0x01d9;
    L_0x0196:
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLk;
        r7 = r13 << 4;
        r7 = r7 + r10;
        r2 = r2.e(r3, r7);
        if (r2 != 0) goto L_0x0359;
    L_0x01a7:
        r2 = 7;
        if (r13 >= r2) goto L_0x01d6;
    L_0x01aa:
        r2 = 9;
    L_0x01ac:
        r3 = 1;
        r7 = r5;
        r8 = r11;
        r13 = r2;
    L_0x01b0:
        if (r3 != 0) goto L_0x0353;
    L_0x01b2:
        r0 = r19;
        r2 = r0.vLp;
        r0 = r19;
        r3 = r0.vLe;
        r2 = r2.a(r3, r10);
        r5 = r2 + 2;
        r2 = 7;
        if (r13 >= r2) goto L_0x0203;
    L_0x01c3:
        r2 = 8;
    L_0x01c5:
        r9 = r4;
        r10 = r6;
        r12 = r8;
        r13 = r2;
    L_0x01c9:
        r2 = (long) r12;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 >= 0) goto L_0x01d4;
    L_0x01ce:
        r0 = r19;
        r2 = r0.vLs;
        if (r12 < r2) goto L_0x02f0;
    L_0x01d4:
        r2 = 0;
    L_0x01d5:
        return r2;
    L_0x01d6:
        r2 = 11;
        goto L_0x01ac;
    L_0x01d9:
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLi;
        r2 = r2.e(r3, r13);
        if (r2 != 0) goto L_0x01ed;
    L_0x01e7:
        r2 = r6;
    L_0x01e8:
        r3 = r9;
        r7 = r5;
        r6 = r11;
        r8 = r2;
        goto L_0x01b0;
    L_0x01ed:
        r0 = r19;
        r2 = r0.vLe;
        r0 = r19;
        r3 = r0.vLj;
        r2 = r2.e(r3, r13);
        if (r2 != 0) goto L_0x0200;
    L_0x01fb:
        r2 = r4;
        r3 = r5;
    L_0x01fd:
        r5 = r3;
        r4 = r6;
        goto L_0x01e8;
    L_0x0200:
        r2 = r5;
        r3 = r4;
        goto L_0x01fd;
    L_0x0203:
        r2 = 11;
        goto L_0x01c5;
    L_0x0206:
        r0 = r19;
        r2 = r0.vLo;
        r0 = r19;
        r3 = r0.vLe;
        r2 = r2.a(r3, r10);
        r8 = r2 + 2;
        r2 = 7;
        if (r13 >= r2) goto L_0x0264;
    L_0x0217:
        r2 = 7;
    L_0x0218:
        r0 = r19;
        r5 = r0.vLl;
        r3 = r8 + -2;
        r7 = 4;
        if (r3 >= r7) goto L_0x0267;
    L_0x0221:
        r3 = r5[r3];
        r0 = r19;
        r5 = r0.vLe;
        r3 = r3.a(r5);
        r5 = 4;
        if (r3 < r5) goto L_0x02e8;
    L_0x022e:
        r5 = r3 >> 1;
        r9 = r5 + -1;
        r5 = r3 & 1;
        r5 = r5 | 2;
        r10 = r5 << r9;
        r5 = 14;
        if (r3 >= r5) goto L_0x0272;
    L_0x023c:
        r0 = r19;
        r12 = r0.vLm;
        r3 = r10 - r3;
        r13 = r3 + -1;
        r0 = r19;
        r0 = r0.vLe;
        r16 = r0;
        r5 = 1;
        r3 = 0;
        r7 = 0;
    L_0x024d:
        if (r7 >= r9) goto L_0x0269;
    L_0x024f:
        r17 = r13 + r5;
        r0 = r16;
        r1 = r17;
        r17 = r0.e(r12, r1);
        r5 = r5 << 1;
        r5 = r5 + r17;
        r17 = r17 << r7;
        r3 = r3 | r17;
        r7 = r7 + 1;
        goto L_0x024d;
    L_0x0264:
        r2 = 10;
        goto L_0x0218;
    L_0x0267:
        r3 = 3;
        goto L_0x0221;
    L_0x0269:
        r3 = r3 + r10;
        r5 = r8;
        r7 = r4;
        r9 = r6;
        r10 = r11;
        r12 = r3;
        r13 = r2;
        goto L_0x01c9;
    L_0x0272:
        r0 = r19;
        r7 = r0.vLe;
        r3 = r9 + -4;
        r5 = 0;
    L_0x0279:
        if (r3 == 0) goto L_0x02b5;
    L_0x027b:
        r9 = r7.vLI;
        r9 = r9 >>> 1;
        r7.vLI = r9;
        r9 = r7.spd;
        r12 = r7.vLI;
        r9 = r9 - r12;
        r9 = r9 >>> 31;
        r12 = r7.spd;
        r13 = r7.vLI;
        r16 = r9 + -1;
        r13 = r13 & r16;
        r12 = r12 - r13;
        r7.spd = r12;
        r5 = r5 << 1;
        r9 = 1 - r9;
        r5 = r5 | r9;
        r9 = r7.vLI;
        r12 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r9 = r9 & r12;
        if (r9 != 0) goto L_0x02b2;
    L_0x029f:
        r9 = r7.spd;
        r9 = r9 << 8;
        r12 = r7.vLJ;
        r12 = r12.read();
        r9 = r9 | r12;
        r7.spd = r9;
        r9 = r7.vLI;
        r9 = r9 << 8;
        r7.vLI = r9;
    L_0x02b2:
        r3 = r3 + -1;
        goto L_0x0279;
    L_0x02b5:
        r3 = r5 << 4;
        r9 = r10 + r3;
        r0 = r19;
        r10 = r0.vLn;
        r0 = r19;
        r12 = r0.vLe;
        r7 = 1;
        r5 = 0;
        r3 = 0;
    L_0x02c4:
        r13 = r10.vLH;
        if (r3 >= r13) goto L_0x02d6;
    L_0x02c8:
        r13 = r10.vLG;
        r13 = r12.e(r13, r7);
        r7 = r7 << 1;
        r7 = r7 + r13;
        r13 = r13 << r3;
        r5 = r5 | r13;
        r3 = r3 + 1;
        goto L_0x02c4;
    L_0x02d6:
        r3 = r9 + r5;
        if (r3 >= 0) goto L_0x02e0;
    L_0x02da:
        r2 = -1;
        if (r3 == r2) goto L_0x0339;
    L_0x02dd:
        r2 = 0;
        goto L_0x01d5;
    L_0x02e0:
        r5 = r8;
        r7 = r4;
        r9 = r6;
        r10 = r11;
        r12 = r3;
        r13 = r2;
        goto L_0x01c9;
    L_0x02e8:
        r5 = r8;
        r7 = r4;
        r9 = r6;
        r10 = r11;
        r12 = r3;
        r13 = r2;
        goto L_0x01c9;
    L_0x02f0:
        r0 = r19;
        r6 = r0.vLd;
        r2 = r6.vIa;
        r2 = r2 - r12;
        r2 = r2 + -1;
        if (r2 >= 0) goto L_0x0351;
    L_0x02fb:
        r3 = r6.vLa;
        r2 = r2 + r3;
        r4 = r5;
    L_0x02ff:
        if (r4 == 0) goto L_0x0325;
    L_0x0301:
        r3 = r6.vLa;
        if (r2 < r3) goto L_0x0306;
    L_0x0305:
        r2 = 0;
    L_0x0306:
        r8 = r6.vKZ;
        r11 = r6.vIa;
        r3 = r11 + 1;
        r6.vIa = r3;
        r0 = r6.vKZ;
        r16 = r0;
        r3 = r2 + 1;
        r2 = r16[r2];
        r8[r11] = r2;
        r2 = r6.vIa;
        r8 = r6.vLa;
        if (r2 < r8) goto L_0x0321;
    L_0x031e:
        r6.cKH();
    L_0x0321:
        r4 = r4 + -1;
        r2 = r3;
        goto L_0x02ff;
    L_0x0325:
        r2 = (long) r5;
        r2 = r2 + r14;
        r0 = r19;
        r4 = r0.vLd;
        r5 = 0;
        r8 = r4.IG(r5);
        r14 = r2;
        r16 = r8;
        r5 = r7;
        r4 = r9;
        r6 = r10;
        r11 = r12;
        goto L_0x00bb;
    L_0x0339:
        r0 = r19;
        r2 = r0.vLd;
        r2.cKH();
        r0 = r19;
        r2 = r0.vLd;
        r2.cKG();
        r0 = r19;
        r2 = r0.vLe;
        r3 = 0;
        r2.vLJ = r3;
        r2 = 1;
        goto L_0x01d5;
    L_0x0351:
        r4 = r5;
        goto L_0x02ff;
    L_0x0353:
        r5 = r3;
        r9 = r4;
        r10 = r6;
        r12 = r8;
        goto L_0x01c9;
    L_0x0359:
        r3 = r9;
        r7 = r5;
        r8 = r11;
        goto L_0x01b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.b.a.a(java.io.InputStream, java.io.OutputStream, long):boolean");
    }

    public final boolean cj(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = i % 9;
        i /= 9;
        int i3 = i % 5;
        int i4 = i / 5;
        int i5 = 0;
        for (i = 0; i < 4; i++) {
            i5 += (bArr[i + 1] & 255) << (i * 8);
        }
        if (i2 > 8 || i3 > 4 || i4 > 4) {
            i = false;
        } else {
            b bVar = this.vLq;
            if (!(bVar.vLA != null && bVar.vLB == i2 && bVar.vLC == i3)) {
                bVar.vLC = i3;
                bVar.vLD = (1 << i3) - 1;
                bVar.vLB = i2;
                i2 = 1 << (bVar.vLB + bVar.vLC);
                bVar.vLA = new a$b$a[i2];
                for (i = 0; i < i2; i++) {
                    bVar.vLA[i] = new a$b$a(bVar);
                }
            }
            i = 1 << i4;
            this.vLo.IH(i);
            this.vLp.IH(i);
            this.vLt = i - 1;
            i = 1;
        }
        if (i == 0 || i5 < 0) {
            return false;
        }
        if (this.vLr != i5) {
            this.vLr = i5;
            this.vLs = Math.max(this.vLr, 1);
            h.a.a.a aVar = this.vLd;
            i5 = Math.max(this.vLs, Downloads.RECV_BUFFER_SIZE);
            if (aVar.vKZ == null || aVar.vLa != i5) {
                aVar.vKZ = new byte[i5];
            }
            aVar.vLa = i5;
            aVar.vIa = 0;
            aVar.vLb = 0;
        }
        return true;
    }
}
