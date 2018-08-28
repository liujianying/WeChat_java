package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.d;
import com.tencent.tinker.a.a.t.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.Adler32;

public final class i {
    static final short[] voP = new short[0];
    public ByteBuffer aig;
    private byte[] kMN = null;
    public final t voQ = new t();
    private final f voR = new f(this, (byte) 0);
    private final g voS = new g(this, (byte) 0);
    private final h voT = new h(this, (byte) 0);
    private final d voU = new d(this, (byte) 0);
    private final b voV = new b(this, (byte) 0);
    private final c voW = new c(this, (byte) 0);
    private final a voX = new a(this, (byte) 0);
    private int voY = 0;

    public i(int i) {
        this.aig = ByteBuffer.wrap(new byte[i]);
        this.aig.order(ByteOrder.LITTLE_ENDIAN);
        this.voQ.fileSize = i;
    }

    public i(InputStream inputStream) {
        int i;
        Object i2 = -1;
        this.aig = ByteBuffer.wrap(d.c(inputStream, 0));
        this.aig.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.voQ;
        e a = a(tVar.vpk);
        byte[] Hz = a.Hz(8);
        if (Hz.length == 8 && Hz[0] == (byte) 100 && Hz[1] == (byte) 101 && Hz[2] == (byte) 120 && Hz[3] == (byte) 10 && Hz[7] == (byte) 0) {
            String str = ((char) Hz[4]) + ((char) Hz[5]) + ((char) Hz[6]);
            if (str.equals("036")) {
                i2 = 14;
            } else if (str.equals("035")) {
                i2 = 13;
            }
        }
        if (i2 != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(Hz));
        }
        tVar.epK = a.aig.getInt();
        tVar.kMN = a.Hz(20);
        tVar.fileSize = a.aig.getInt();
        i2 = a.aig.getInt();
        if (i2 != 112) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        i2 = a.aig.getInt();
        if (i2 != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i2));
        }
        tVar.vpD = a.aig.getInt();
        tVar.vpE = a.aig.getInt();
        tVar.vpr.off = a.aig.getInt();
        if (tVar.vpr.off == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.vpl.size = a.aig.getInt();
        tVar.vpl.off = a.aig.getInt();
        tVar.vpm.size = a.aig.getInt();
        tVar.vpm.off = a.aig.getInt();
        tVar.vpn.size = a.aig.getInt();
        tVar.vpn.off = a.aig.getInt();
        tVar.vpo.size = a.aig.getInt();
        tVar.vpo.off = a.aig.getInt();
        tVar.vpp.size = a.aig.getInt();
        tVar.vpp.off = a.aig.getInt();
        tVar.vpq.size = a.aig.getInt();
        tVar.vpq.off = a.aig.getInt();
        tVar.vpF = a.aig.getInt();
        tVar.vpG = a.aig.getInt();
        tVar.a(Hu(tVar.vpr.off));
        tVar.cGM();
    }

    private static void fG(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e Hu(int i) {
        if (i < 0 || i >= this.aig.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aig.capacity());
        }
        ByteBuffer duplicate = this.aig.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.aig.capacity());
        return new e(this, "temp-section", duplicate, (byte) 0);
    }

    public final e a(a aVar) {
        int i = aVar.off;
        if (i < 0 || i >= this.aig.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aig.capacity());
        }
        ByteBuffer duplicate = this.aig.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.vpJ);
        return new e(this, "section", duplicate, (byte) 0);
    }

    public final byte[] mS(boolean z) {
        if (this.kMN != null && !z) {
            return this.kMN;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.aig.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.kMN = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void cGn() {
        Hu(12).write(mS(true));
        e Hu = Hu(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.aig.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        Hu.writeInt((int) adler32.getValue());
    }

    public final int Hv(int i) {
        fG(i, this.voQ.vpm.size);
        return this.aig.getInt(this.voQ.vpm.off + (i * 4));
    }
}
