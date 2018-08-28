package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

public final class ag implements Closeable {
    public static final ByteOrder fgU = ByteOrder.BIG_ENDIAN;
    private volatile int aIs;
    public final File fgV;
    private volatile FileChannel fgW;
    public volatile boolean fgX;
    private volatile int fgY;
    private volatile int fgZ;
    private volatile int fha;
    public volatile Map<String, a> fhb;
    public volatile FileStructStat fhc;

    public ag(File file) {
        int i;
        boolean z = true;
        this.fgW = null;
        this.fgX = true;
        this.aIs = -1;
        this.fgY = 0;
        this.fgZ = 0;
        this.fha = -1;
        this.fhb = null;
        this.fgV = file;
        if (this.fgV == null || !this.fgV.exists()) {
            i = 0;
        } else if (this.fgV.length() <= 14) {
            i = 0;
        } else {
            boolean i2 = true;
        }
        if (i2 == 0 || !abX()) {
            z = false;
        }
        this.fgX = z;
    }

    public ag(String str) {
        this(new File(str));
    }

    public final void close() {
        if (this.fgW != null) {
            try {
                this.fgW.close();
                this.fgW = null;
            } catch (IOException e) {
            }
        }
    }

    public final a qM(String str) {
        int i = 0;
        if (this.fhb == null || bi.oW(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.fhb == null);
            if (this.fhb != null) {
                i = this.fhb.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            x.e(str2, str3, objArr);
            return null;
        }
        return (a) this.fhb.get(a.qC(str));
    }

    public final InputStream qN(String str) {
        a qM = qM(str);
        if (qM == null) {
            return null;
        }
        if (Thread.currentThread().isInterrupted()) {
            return a(qM);
        }
        try {
            ByteBuffer map = this.fgW.map(MapMode.READ_ONLY, (long) qM.fhe, (long) qM.fhf);
            map.order(fgU);
            map.limit(qM.fhf);
            return new a(map);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[]{str, Integer.valueOf(qM.fhe), Integer.valueOf(qM.fhf), bi.i(e)});
            return null;
        }
    }

    private InputStream a(a aVar) {
        Exception e;
        Throwable th;
        Closeable randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(this.fgV, "r");
            try {
                byte[] bArr = new byte[aVar.fhf];
                randomAccessFile.seek((long) aVar.fhe);
                randomAccessFile.readFully(bArr);
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                bi.d(randomAccessFile);
                return byteArrayInputStream;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", new Object[]{this.fgV.getPath(), aVar.fileName, e});
                    bi.d(randomAccessFile);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(randomAccessFile);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            x.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", new Object[]{this.fgV.getPath(), aVar.fileName, e});
            bi.d(randomAccessFile);
            return null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            bi.d(randomAccessFile);
            throw th;
        }
    }

    public final boolean abW() {
        int i = 4;
        if (!this.fgX || this.fgW == null || this.fgY <= 4) {
            x.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[]{Boolean.valueOf(this.fgX), this.fgW, Integer.valueOf(this.fgZ)});
            return false;
        } else if (this.fhb != null && this.fha >= 0 && this.fha == this.fhb.size()) {
            return true;
        } else {
            try {
                this.fgW.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.fgY);
                allocate.order(fgU);
                this.fgW.read(allocate);
                byte[] array = allocate.array();
                this.fha = a.D(array, 0);
                android.support.v4.e.a aVar = new android.support.v4.e.a();
                a aVar2 = null;
                for (int i2 = 0; i2 < this.fha; i2++) {
                    int D = a.D(array, i);
                    i += 4;
                    String str = new String(array, i, D);
                    i += D;
                    int D2 = a.D(array, i);
                    i += 4;
                    int D3 = a.D(array, i);
                    i += 4;
                    aVar2 = new a(this.fgV.getAbsolutePath(), str, D2, D3);
                    aVar.put(str, aVar2);
                }
                this.fhb = aVar;
                if (aVar2 == null || ((long) (aVar2.fhe + aVar2.fhf)) <= this.fgV.length()) {
                    return true;
                }
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[]{Integer.valueOf(aVar2.fhe), Integer.valueOf(aVar2.fhf), Long.valueOf(this.fgV.length())});
                return false;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[]{bi.i(e)});
                return false;
            }
        }
    }

    private boolean abX() {
        if (this.fgW == null) {
            try {
                this.fgW = new RandomAccessFile(this.fgV, "r").getChannel();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[]{bi.i(e)});
            }
        }
        if (this.fgW == null) {
            return false;
        }
        try {
            this.fgW.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(fgU);
            this.fgW.read(allocate);
            if ((byte) -66 != allocate.get(0) || (byte) -19 != allocate.get(13)) {
                return false;
            }
            byte[] array = allocate.array();
            this.aIs = a.D(array, 1);
            this.fgY = a.D(array, 5);
            this.fgZ = a.D(array, 9);
            return true;
        } catch (Throwable e2) {
            x.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[]{bi.i(e2)});
        }
    }
}
