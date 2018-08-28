package com.tencent.mm.plugin.voip.model;

import java.io.InputStream;
import java.io.OutputStream;

final class h {
    protected e oJg;
    int oJh;
    private InputStream oJi;
    private int oJj;
    private int oJk;
    private final OutputStream oJl;
    private int[] oJm;
    int oJn;

    public h(InputStream inputStream) {
        this.oJg = new e();
        this.oJm = new int[8];
        this.oJi = inputStream;
        this.oJl = null;
        this.oJj = inputStream.read();
        this.oJk = inputStream.read();
    }

    public h(InputStream inputStream, OutputStream outputStream) {
        this.oJg = new e();
        this.oJm = new int[8];
        this.oJi = inputStream;
        this.oJl = outputStream;
        this.oJj = inputStream.read();
        this.oJk = inputStream.read();
    }

    public final boolean iL(boolean z) {
        return iM(z) == 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int iM(boolean r4) {
        /*
        r3 = this;
        r0 = -1;
        r1 = r3.oJh;
        r2 = 8;
        if (r1 != r2) goto L_0x001b;
    L_0x0007:
        r1 = r3.oJk;
        r3.oJj = r1;
        r1 = r3.oJi;
        r1 = r1.read();
        r3.oJk = r1;
        r1 = 0;
        r3.oJh = r1;
        r1 = r3.oJj;
        if (r1 != r0) goto L_0x001b;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r3.oJj;
        r1 = r3.oJh;
        r1 = 7 - r1;
        r0 = r0 >> r1;
        r0 = r0 & 1;
        r1 = r3.oJh;
        r1 = r1 + 1;
        r3.oJh = r1;
        if (r4 == 0) goto L_0x001a;
    L_0x002c:
        r1 = r3.oJl;
        if (r1 == 0) goto L_0x001a;
    L_0x0030:
        r3.ys(r0);
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.h.iM(boolean):int");
    }

    private long yo(int i) {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | ((long) iM(true));
        }
        return j;
    }

    public final void yp(int i) {
        if (i > 64) {
            throw new IllegalArgumentException("Can not skip more then 64 bit");
        }
        for (int i2 = 0; i2 < i; i2++) {
            iM(true);
        }
    }

    public final long bJC() {
        long yo = yo(8);
        String.valueOf(yo);
        return yo;
    }

    public final void yq(int i) {
        yp(i);
    }

    private int bJD() {
        int i = 0;
        while (iM(true) == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + yo(i));
    }

    public final int bJE() {
        int bJD = bJD();
        String.valueOf(bJD);
        return bJD;
    }

    public final void bJF() {
        int i = 0;
        while (iM(true) == 0) {
            i++;
        }
        if (i > 0) {
            yp(i);
        }
    }

    public final void yr(int i) {
        int[] iArr = new int[i];
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = bJD();
                i2 = ((i2 & 1) + (i2 >> 1)) * (((i2 & 1) << 1) - 1);
                String.valueOf(i2);
                i2 = ((i2 + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = iArr[i4];
        }
    }

    public final void flush() {
        for (int i = this.oJn; i < 8; i++) {
            this.oJm[i] = 0;
        }
        this.oJn = 0;
        bJG();
    }

    private void bJG() {
        this.oJl.write((((((((this.oJm[0] << 7) | (this.oJm[1] << 6)) | (this.oJm[2] << 5)) | (this.oJm[3] << 4)) | (this.oJm[4] << 3)) | (this.oJm[5] << 2)) | (this.oJm[6] << 1)) | this.oJm[7]);
    }

    public final void ys(int i) {
        if (this.oJn == 8) {
            this.oJn = 0;
            bJG();
        }
        int[] iArr = this.oJm;
        int i2 = this.oJn;
        this.oJn = i2 + 1;
        iArr[i2] = i;
    }

    public final void A(long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ys(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    public final void yt(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 15) {
            if (i < (1 << i2) + i3) {
                break;
            }
            i3 += 1 << i2;
            i2++;
        }
        i2 = 0;
        A(0, i2);
        ys(1);
        A((long) (i - i3), i2);
    }

    public final void iN(boolean z) {
        ys(z ? 1 : 0);
    }
}
