package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f implements Cloneable {
    public String name;
    long size = -1;
    String sla;
    int time = -1;
    public long vvR = -1;
    long vwb = -1;
    int vwc = -1;
    int vwd = -1;
    byte[] vwe;
    long vwf = -1;
    long vwg = -1;

    public f(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        String str2 = "Name";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length > 65535) {
            throw new IllegalArgumentException(str2 + " too long: " + bytes.length);
        }
        this.name = str;
    }

    public f(f fVar) {
        this.name = fVar.name;
        this.sla = fVar.sla;
        this.time = fVar.time;
        this.size = fVar.size;
        this.vwb = fVar.vwb;
        this.vvR = fVar.vvR;
        this.vwc = fVar.vwc;
        this.vwd = fVar.vwd;
        this.vwe = fVar.vwe;
        this.vwf = fVar.vwf;
        this.vwg = fVar.vwg;
    }

    public f(f fVar, String str) {
        this.name = str;
        this.sla = fVar.sla;
        this.time = fVar.time;
        this.size = fVar.size;
        this.vwb = fVar.vwb;
        this.vvR = fVar.vvR;
        this.vwc = fVar.vwc;
        this.vwd = fVar.vwd;
        this.vwe = fVar.vwe;
        this.vwf = fVar.vwf;
        this.vwg = fVar.vwg;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) {
        e.b(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            g.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a.seek(8);
        int readShort = a.readShort() & 65535;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + readShort);
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.vwc = a.readShort() & 65535;
        this.time = a.readShort() & 65535;
        this.vwd = a.readShort() & 65535;
        this.vvR = ((long) a.readInt()) & 4294967295L;
        this.vwb = ((long) a.readInt()) & 4294967295L;
        this.size = ((long) a.readInt()) & 4294967295L;
        readShort = a.readShort() & 65535;
        int readShort2 = a.readShort() & 65535;
        int readShort3 = a.readShort() & 65535;
        a.seek(42);
        this.vwf = ((long) a.readInt()) & 4294967295L;
        byte[] bArr2 = new byte[readShort];
        e.b(inputStream, bArr2, 0, bArr2.length);
        if (bS(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.vwe = new byte[readShort2];
            e.b(inputStream, this.vwe, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            e.b(inputStream, bArr2, 0, readShort3);
            this.sla = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean bS(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.vwc = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    public final void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.size = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.sla);
        stringBuffer.append("\ntime:" + this.time);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.vwb);
        stringBuffer.append("\ncrc:" + this.vvR);
        stringBuffer.append("\ncompressionMethod:" + this.vwc);
        stringBuffer.append("\nmodDate:" + this.vwd);
        stringBuffer.append("\nextra length:" + this.vwe.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.vwf);
        stringBuffer.append("\ndataOffset:" + this.vwg);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.vwe = this.vwe != null ? (byte[]) this.vwe.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
