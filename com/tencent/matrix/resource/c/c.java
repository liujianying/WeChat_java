package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.b.a;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class c {
    private int brK = 0;
    private final InputStream brT;

    public c(InputStream inputStream) {
        this.brT = inputStream;
    }

    public final void a(d dVar) {
        InputStream inputStream = this.brT;
        StringBuilder stringBuilder = new StringBuilder();
        for (int read = inputStream.read(); read != 0; read = inputStream.read()) {
            stringBuilder.append((char) read);
        }
        String stringBuilder2 = stringBuilder.toString();
        int d = a.d(this.brT);
        long e = a.e(this.brT);
        this.brK = d;
        dVar.a(stringBuilder2, d, e);
        b(dVar);
        dVar.tz();
    }

    private void b(d dVar) {
        while (true) {
            try {
                int read = this.brT.read();
                int d = a.d(this.brT);
                long d2 = 4294967295L & ((long) a.d(this.brT));
                switch (read) {
                    case 1:
                        b a = a.a(this.brT, this.brK);
                        long j = d2 - ((long) this.brK);
                        byte[] bArr = new byte[((int) j)];
                        a.a(this.brT, bArr, j);
                        dVar.a(a, new String(bArr, Charset.forName("UTF-8")), d, d2);
                        break;
                    case 2:
                        dVar.a(a.d(this.brT), a.a(this.brT, this.brK), a.d(this.brT), a.a(this.brT, this.brK), d, d2);
                        break;
                    case 4:
                        dVar.a(a.a(this.brT, this.brK), a.a(this.brT, this.brK), a.a(this.brT, this.brK), a.a(this.brT, this.brK), a.d(this.brT), a.d(this.brT), d, d2);
                        break;
                    case 5:
                        a(d, d2, dVar);
                        break;
                    case 12:
                    case 28:
                        a(read, d, d2, dVar);
                        break;
                    default:
                        byte[] bArr2 = new byte[((int) d2)];
                        a.a(this.brT, bArr2, d2);
                        dVar.a(read, d, d2, bArr2);
                        break;
                }
            } catch (EOFException e) {
                return;
            }
        }
    }

    private void a(int i, long j, d dVar) {
        int d = a.d(this.brT);
        int d2 = a.d(this.brT);
        int d3 = a.d(this.brT);
        b[] bVarArr = new b[d3];
        for (int i2 = 0; i2 < d3; i2++) {
            bVarArr[i2] = a.a(this.brT, this.brK);
        }
        dVar.a(d, d2, bVarArr, i, j);
    }

    private void a(int i, int i2, long j, d dVar) {
        b a = dVar.a(i, i2, j);
        if (a == null) {
            a.b(this.brT, j);
            return;
        }
        while (j > 0) {
            int read = this.brT.read();
            long j2 = j - 1;
            b a2;
            int d;
            b a3;
            b a4;
            int i3;
            byte[] bArr;
            switch (read) {
                case 1:
                    a.b(read, a.a(this.brT, this.brK));
                    a.b(this.brT, (long) this.brK);
                    j = j2 - ((long) (this.brK << 1));
                    break;
                case 2:
                    a.a(a.a(this.brT, this.brK), a.d(this.brT), a.d(this.brT));
                    j = j2 - ((long) ((this.brK + 4) + 4));
                    break;
                case 3:
                    a.b(a.a(this.brT, this.brK), a.d(this.brT), a.d(this.brT));
                    j = j2 - ((long) ((this.brK + 4) + 4));
                    break;
                case 4:
                    a.a(a.a(this.brT, this.brK), a.d(this.brT));
                    j = j2 - ((long) (this.brK + 4));
                    break;
                case 5:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 6:
                    a.b(a.a(this.brT, this.brK), a.d(this.brT));
                    j = j2 - ((long) (this.brK + 4));
                    break;
                case 7:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 8:
                    a.c(a.a(this.brT, this.brK), a.d(this.brT), a.d(this.brT));
                    j = j2 - ((long) ((this.brK + 4) + 4));
                    break;
                case 32:
                    int size;
                    a2 = a.a(this.brT, this.brK);
                    d = a.d(this.brT);
                    a3 = a.a(this.brT, this.brK);
                    a4 = a.a(this.brT, this.brK);
                    a.b(this.brT, (long) (this.brK << 2));
                    int d2 = a.d(this.brT);
                    i3 = ((this.brK * 7) + 4) + 4;
                    short c = a.c(this.brT);
                    int i4 = i3 + 2;
                    for (short s = (short) 0; s < c; s++) {
                        a.b(this.brT, 2);
                        size = com.tencent.matrix.resource.c.a.c.en(this.brT.read()).getSize(this.brK);
                        a.b(this.brT, (long) size);
                        i4 += (size + 1) + 2;
                    }
                    short c2 = a.c(this.brT);
                    com.tencent.matrix.resource.c.a.a[] aVarArr = new com.tencent.matrix.resource.c.a.a[c2];
                    int i5 = i4 + 2;
                    for (short s2 = (short) 0; s2 < c2; s2++) {
                        b a5 = a.a(this.brT, this.brK);
                        int read2 = this.brT.read();
                        aVarArr[s2] = new com.tencent.matrix.resource.c.a.a(read2, a5, a.a(this.brT, com.tencent.matrix.resource.c.a.c.en(read2), this.brK));
                        i5 += (this.brK + 1) + com.tencent.matrix.resource.c.a.c.en(read2).getSize(this.brK);
                    }
                    short c3 = a.c(this.brT);
                    com.tencent.matrix.resource.c.a.a[] aVarArr2 = new com.tencent.matrix.resource.c.a.a[c3];
                    size = i5 + 2;
                    for (c = (short) 0; c < c3; c++) {
                        aVarArr2[c] = new com.tencent.matrix.resource.c.a.a(this.brT.read(), a.a(this.brT, this.brK), null);
                        size += this.brK + 1;
                    }
                    a.a(a2, d, a3, a4, d2, aVarArr, aVarArr2);
                    j = j2 - ((long) size);
                    break;
                case 33:
                    a2 = a.a(this.brT, this.brK);
                    d = a.d(this.brT);
                    a3 = a.a(this.brT, this.brK);
                    int d3 = a.d(this.brT);
                    bArr = new byte[d3];
                    a.a(this.brT, bArr, (long) d3);
                    a.a(a2, d, a3, bArr);
                    j = j2 - ((long) ((((this.brK + 4) + this.brK) + 4) + d3));
                    break;
                case 34:
                    a2 = a.a(this.brT, this.brK);
                    d = a.d(this.brT);
                    int d4 = a.d(this.brT);
                    a4 = a.a(this.brT, this.brK);
                    i3 = d4 * this.brK;
                    bArr = new byte[i3];
                    a.a(this.brT, bArr, (long) i3);
                    a.a(a2, d, d4, a4, bArr);
                    j = j2 - ((long) ((((this.brK + 4) + 4) + this.brK) + i3));
                    break;
                case 35:
                    j = j2 - ((long) a(read, a));
                    break;
                case 137:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 138:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 139:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 140:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 141:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 142:
                    a.d(a.a(this.brT, this.brK), a.d(this.brT), a.d(this.brT));
                    j = j2 - ((long) ((this.brK + 4) + 4));
                    break;
                case 144:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                case 195:
                    j = j2 - ((long) a(read, a));
                    break;
                case 254:
                    a.a(a.d(this.brT), a.a(this.brT, this.brK));
                    j = j2 - ((long) (this.brK + 4));
                    break;
                case 255:
                    a.b(read, a.a(this.brT, this.brK));
                    j = j2 - ((long) this.brK);
                    break;
                default:
                    throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + read + " with " + this.brT.available() + " bytes possibly remaining");
            }
        }
        a.tz();
    }

    private int a(int i, b bVar) {
        b a = a.a(this.brT, this.brK);
        int d = a.d(this.brT);
        int d2 = a.d(this.brT);
        int read = this.brT.read();
        int size = d2 * com.tencent.matrix.resource.c.a.c.en(read).getSize(this.brK);
        byte[] bArr = new byte[size];
        a.a(this.brT, bArr, (long) size);
        bVar.a(i, a, d, d2, read, bArr);
        return (((this.brK + 4) + 4) + 1) + size;
    }
}
