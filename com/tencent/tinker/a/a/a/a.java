package com.tencent.tinker.a.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.g$b;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] voP = new short[0];
    private static final g$b[] vpM = new g$b[0];
    private static final com.tencent.tinker.a.a.g.a[] vpN = new com.tencent.tinker.a.a.g.a[0];
    public ByteBuffer aig;
    public int vpO;
    private boolean vpP;

    public a() {
        this.aig = ByteBuffer.allocate(WXMediaMessage.TITLE_LENGTH_LIMIT);
        this.aig.order(ByteOrder.LITTLE_ENDIAN);
        this.vpO = this.aig.position();
        this.aig.limit(this.aig.capacity());
        this.vpP = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.aig = byteBuffer;
        this.aig.order(ByteOrder.LITTLE_ENDIAN);
        this.vpO = byteBuffer.limit();
        this.vpP = false;
    }

    public final void Hy(int i) {
        if (this.aig.position() + i > this.aig.limit() && this.vpP) {
            Object array = this.aig.array();
            Object obj = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, obj, 0, this.aig.position());
            int position = this.aig.position();
            this.aig = ByteBuffer.wrap(obj);
            this.aig.order(ByteOrder.LITTLE_ENDIAN);
            this.aig.position(position);
            this.aig.limit(this.aig.capacity());
        }
    }

    public final byte readByte() {
        return this.aig.get();
    }

    private int readUnsignedShort() {
        return this.aig.getShort() & 65535;
    }

    public final byte[] Hz(int i) {
        byte[] bArr = new byte[i];
        this.aig.get(bArr);
        return bArr;
    }

    private short[] HA(int i) {
        if (i == 0) {
            return voP;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.aig.getShort();
        }
        return sArr;
    }

    private int cGN() {
        return o.b(this);
    }

    private int cGO() {
        return o.b(this) - 1;
    }

    private int cGP() {
        return o.a(this);
    }

    public s cGo() {
        int i = 0;
        int position = this.aig.position();
        try {
            int b = o.b(this);
            char[] cArr = new char[b];
            while (true) {
                char readByte = (char) (readByte() & WebView.NORMAL_MODE_ALPHA);
                if (readByte == 0) {
                    String str = new String(cArr, 0, i);
                    if (str.length() == b) {
                        return new s(position, str);
                    }
                    throw new j("Declared length " + b + " doesn't match decoded length of " + str.length());
                }
                cArr[i] = readByte;
                int readByte2;
                int i2;
                if (readByte < 128) {
                    i++;
                } else if ((readByte & 224) == 192) {
                    readByte2 = readByte() & WebView.NORMAL_MODE_ALPHA;
                    if ((readByte2 & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i2 = i + 1;
                    cArr[i] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                    i = i2;
                } else if ((readByte & 240) == 224) {
                    readByte2 = readByte() & WebView.NORMAL_MODE_ALPHA;
                    int readByte3 = readByte() & WebView.NORMAL_MODE_ALPHA;
                    if ((readByte2 & 192) == 128 && (readByte3 & 192) == 128) {
                        i2 = i + 1;
                        cArr[i] = (char) ((((readByte & 15) << 12) | ((readByte2 & 63) << 6)) | (readByte3 & 63));
                        i = i2;
                    }
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
            }
            throw new UTFDataFormatException("bad second or third byte");
        } catch (Throwable e) {
            throw new j(e);
        }
    }

    public u cGp() {
        return new u(this.aig.position(), HA(this.aig.getInt()));
    }

    public n cGq() {
        return new n(this.aig.position(), readUnsignedShort(), readUnsignedShort(), this.aig.getInt());
    }

    public p cGr() {
        return new p(this.aig.position(), readUnsignedShort(), readUnsignedShort(), this.aig.getInt());
    }

    public r cGs() {
        return new r(this.aig.position(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt());
    }

    public f cGt() {
        return new f(this.aig.position(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt(), this.aig.getInt());
    }

    public g cGu() {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        g$b[] g_bArr;
        int position = this.aig.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.aig.getInt();
        short[] HA = HA(this.aig.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            if ((HA.length & 1) == 1) {
                skip(2);
            }
            int position3 = this.aig.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.aig.position();
            int b = o.b(this);
            aVarArr = new com.tencent.tinker.a.a.g.a[b];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= b) {
                    break;
                }
                position2 = this.aig.position() - position4;
                a = o.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = o.b(this);
                    iArr2[i2] = o.b(this);
                }
                aVarArr[i3] = new com.tencent.tinker.a.a.g.a(iArr, iArr2, a <= 0 ? o.b(this) : -1, position2);
                i2 = i3 + 1;
            }
            position4 = this.aig.position();
            this.aig.position(position3);
            g_bArr = new g$b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.aig.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < aVarArr.length) {
                    if (aVarArr[i2].offset == a) {
                        g_bArr[position3] = new g$b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.aig.position(position4);
        } else {
            g_bArr = vpM;
            aVarArr = vpN;
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, HA, g_bArr, aVarArr);
    }

    public h cGv() {
        Throwable th;
        int position = this.aig.position();
        int b = o.b(this);
        int b2 = o.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = o.b(this) - 1;
        }
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            try {
                1 1 = new 1(this, byteArrayOutputStream);
                while (true) {
                    byte b3 = this.aig.get();
                    byteArrayOutputStream.write(b3);
                    switch (b3) {
                        case (byte) 0:
                            h hVar = new h(position, b, iArr, byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                            }
                            return hVar;
                        case (byte) 1:
                            o.a(1, cGN());
                            break;
                        case (byte) 2:
                            o.c(1, cGP());
                            break;
                        case (byte) 3:
                        case (byte) 4:
                            o.a(1, cGN());
                            o.b(1, cGO());
                            o.b(1, cGO());
                            if (b3 != (byte) 4) {
                                break;
                            }
                            o.b(1, cGO());
                            break;
                        case (byte) 5:
                        case (byte) 6:
                            o.a(1, cGN());
                            break;
                        case (byte) 9:
                            o.b(1, cGO());
                            break;
                        default:
                            break;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public e cGw() {
        return new e(this.aig.position(), HB(o.b(this)), HB(o.b(this)), HC(o.b(this)), HC(o.b(this)));
    }

    private com.tencent.tinker.a.a.e.a[] HB(int i) {
        com.tencent.tinker.a.a.e.a[] aVarArr = new com.tencent.tinker.a.a.e.a[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = o.b(this) + i3;
            aVarArr[i2] = new com.tencent.tinker.a.a.e.a(b, o.b(this));
            i2++;
            i3 = b;
        }
        return aVarArr;
    }

    private e.b[] HC(int i) {
        e.b[] bVarArr = new e.b[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int b = o.b(this) + i3;
            bVarArr[i2] = new e.b(b, o.b(this), o.b(this));
            i2++;
            i3 = b;
        }
        return bVarArr;
    }

    private byte[] HD(int i) {
        byte[] bArr = new byte[(this.aig.position() - i)];
        this.aig.position(i);
        this.aig.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a cGx() {
        int position = this.aig.position();
        byte b = this.aig.get();
        int position2 = this.aig.position();
        new m(this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b, new k(position2, HD(position2)));
    }

    public com.tencent.tinker.a.a.b cGy() {
        int position = this.aig.position();
        int i = this.aig.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aig.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c cGz() {
        int position = this.aig.position();
        int i = this.aig.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aig.getInt();
        }
        return new c(position, iArr);
    }

    public d cGA() {
        int i;
        int position = this.aig.position();
        int i2 = this.aig.getInt();
        int i3 = this.aig.getInt();
        int i4 = this.aig.getInt();
        int i5 = this.aig.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.aig.getInt();
            iArr[i][1] = this.aig.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.aig.getInt();
            iArr2[i][1] = this.aig.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.aig.getInt();
            iArr3[i][1] = this.aig.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k cGB() {
        int position = this.aig.position();
        new m(this, 28).skipValue();
        return new k(position, HD(position));
    }

    private void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.aig.position(this.aig.position() + i);
    }

    public final void writeByte(int i) {
        Hy(1);
        this.aig.put((byte) i);
        if (this.aig.position() > this.vpO) {
            this.vpO = this.aig.position();
        }
    }

    public final void writeShort(short s) {
        Hy(2);
        this.aig.putShort(s);
        if (this.aig.position() > this.vpO) {
            this.vpO = this.aig.position();
        }
    }

    private void HE(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        Hy(4);
        this.aig.putInt(i);
        if (this.aig.position() > this.vpO) {
            this.vpO = this.aig.position();
        }
    }

    public final void write(byte[] bArr) {
        Hy(bArr.length * 1);
        this.aig.put(bArr);
        if (this.aig.position() > this.vpO) {
            this.vpO = this.aig.position();
        }
    }

    public int a(s sVar) {
        int position = this.aig.position();
        try {
            o.a(this, sVar.value.length());
            String str = sVar.value;
            long j = 0;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                j = (charAt == 0 || charAt > 127) ? charAt <= 2047 ? j + 2 : j + 3 : j + 1;
                if (j > 65535) {
                    throw new UTFDataFormatException("String more than 65535 UTF bytes long");
                }
            }
            byte[] bArr = new byte[((int) j)];
            q.c(bArr, 0, str);
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(u uVar) {
        int position = this.aig.position();
        short[] sArr = uVar.vpL;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.aig.position();
        HE(nVar.vpe);
        HE(nVar.vos);
        writeInt(nVar.vpf);
        return position;
    }

    public int a(p pVar) {
        int position = this.aig.position();
        HE(pVar.vpe);
        HE(pVar.vpg);
        writeInt(pVar.vpf);
        return position;
    }

    public int a(r rVar) {
        int position = this.aig.position();
        writeInt(rVar.vph);
        writeInt(rVar.vpi);
        writeInt(rVar.vpj);
        return position;
    }

    public int a(f fVar) {
        int position = this.aig.position();
        writeInt(fVar.vos);
        writeInt(fVar.vop);
        writeInt(fVar.vot);
        writeInt(fVar.vou);
        writeInt(fVar.vov);
        writeInt(fVar.vow);
        writeInt(fVar.vox);
        writeInt(fVar.voy);
        return position;
    }

    public int a(g gVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.aig.position();
        HE(gVar.voz);
        HE(gVar.voA);
        HE(gVar.voB);
        HE(gVar.voE.length);
        writeInt(gVar.voC);
        writeInt(gVar.voD.length);
        short[] sArr = gVar.voD;
        Hy(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.aig.position() > this.vpO) {
            this.vpO = this.aig.position();
        }
        if (gVar.voE.length > 0) {
            if ((gVar.voD.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.aig.position();
            length = gVar.voE.length * 8;
            Hy(length * 1);
            skip(length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.voF;
            int position3 = this.aig.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (length = 0; length < aVarArr.length; length++) {
                iArr[length] = this.aig.position() - position3;
                com.tencent.tinker.a.a.g.a aVar = aVarArr[length];
                int i2 = aVar.voI;
                int[] iArr2 = aVar.voG;
                int[] iArr3 = aVar.voH;
                if (i2 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    o.a(this, iArr2[i3]);
                    o.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    o.a(this, i2);
                }
            }
            length = this.aig.position();
            this.aig.position(position);
            g$b[] g_bArr = gVar.voE;
            position = g_bArr.length;
            while (i < position) {
                g$b g_b = g_bArr[i];
                writeInt(g_b.voJ);
                HE(g_b.voK);
                HE(iArr[g_b.voL]);
                i++;
            }
            this.aig.position(length);
        }
        return position2;
    }

    public int a(h hVar) {
        int position = this.aig.position();
        o.a(this, hVar.voM);
        o.a(this, r2);
        for (int i : hVar.voN) {
            o.a(this, i + 1);
        }
        write(hVar.voO);
        return position;
    }

    public int a(e eVar) {
        int position = this.aig.position();
        o.a(this, eVar.vok.length);
        o.a(this, eVar.vol.length);
        o.a(this, eVar.vom.length);
        o.a(this, eVar.von.length);
        a(eVar.vok);
        a(eVar.vol);
        a(eVar.vom);
        a(eVar.von);
        return position;
    }

    private void a(com.tencent.tinker.a.a.e.a[] aVarArr) {
        int length = aVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            o.a(this, aVar.voo - i2);
            int i3 = aVar.voo;
            o.a(this, aVar.vop);
            i++;
            i2 = i3;
        }
    }

    private void a(e.b[] bVarArr) {
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            e.b bVar = bVarArr[i];
            o.a(this, bVar.voq - i2);
            int i3 = bVar.voq;
            o.a(this, bVar.vop);
            o.a(this, bVar.vor);
            i++;
            i2 = i3;
        }
    }

    public int a(com.tencent.tinker.a.a.a aVar) {
        int position = this.aig.position();
        writeByte(aVar.voc);
        a(aVar.vod);
        return position;
    }

    public int a(com.tencent.tinker.a.a.b bVar) {
        int position = this.aig.position();
        writeInt(bVar.voe.length);
        for (int writeInt : bVar.voe) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.aig.position();
        writeInt(cVar.vof.length);
        for (int writeInt : cVar.vof) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.aig.position();
        writeInt(dVar.vog);
        writeInt(dVar.voh.length);
        writeInt(dVar.voi.length);
        writeInt(dVar.voj.length);
        for (int[] iArr : dVar.voh) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : dVar.voi) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : dVar.voj) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.aig.position();
        write(kVar.data);
        return position;
    }
}
