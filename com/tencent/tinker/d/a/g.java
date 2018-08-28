package com.tencent.tinker.d.a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class g implements Closeable {
    private final String filename;
    public String sla;
    private final LinkedHashMap<String, f> vwh;
    private File vwi;
    private RandomAccessFile vwj;

    public static class a extends InputStream {
        private long aqK;
        private long mb;
        private final RandomAccessFile vwl;

        private a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.vwl = randomAccessFile;
            this.mb = j;
            this.aqK = j2;
        }

        public a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.mb < this.aqK ? 1 : 0;
        }

        public final int read() {
            return e.C(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.vwl) {
                long j = this.aqK - this.mb;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.vwl.seek(this.mb);
                read = this.vwl.read(bArr, i, i2);
                if (read > 0) {
                    this.mb += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.aqK - this.mb) {
                j = this.aqK - this.mb;
            }
            this.mb += j;
            return j;
        }
    }

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.vwh = new LinkedHashMap();
        this.filename = file.getPath();
        this.vwi = null;
        this.vwj = new RandomAccessFile(this.filename, "r");
        cHl();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.vwj;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.vwj = null;
                randomAccessFile.close();
            }
            if (this.vwi != null) {
                this.vwi.delete();
                this.vwi = null;
            }
        }
    }

    /* renamed from: cHk */
    public final void a() {
        if (this.vwj == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final Enumeration<? extends f> entries() {
        a();
        final Iterator it = this.vwh.values().iterator();
        return new Enumeration<f>() {
            public final /* synthetic */ Object nextElement() {
                g.this.a();
                return (f) it.next();
            }

            public final boolean hasMoreElements() {
                g.this.a();
                return it.hasNext();
            }
        };
    }

    public final f adb(String str) {
        a();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.vwh.get(str);
        if (fVar == null) {
            return (f) this.vwh.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f adb = adb(fVar.name);
        if (adb == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.vwj;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, adb.vwf);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), adb.name, adb.vwf, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (adb.vwc == 0) {
                aVar.aqK = aVar.mb + adb.size;
            } else {
                aVar.aqK = aVar.mb + adb.vwb;
            }
        }
        return aVar;
    }

    private void cHl() {
        long j = 0;
        long length = this.vwj.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.vwj.length());
        }
        this.vwj.seek(0);
        if (((long) Integer.reverseBytes(this.vwj.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        while (true) {
            this.vwj.seek(length);
            if (((long) Integer.reverseBytes(this.vwj.readInt())) != 101010256) {
                j2 = length - 1;
                if (j2 < j) {
                    throw new ZipException("End Of Central Directory signature not found");
                }
                length = j2;
            } else {
                byte[] bArr = new byte[18];
                this.vwj.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & 65535;
                int readShort2 = a.readShort() & 65535;
                int readShort3 = a.readShort() & 65535;
                int readShort4 = a.readShort() & 65535;
                a.cHj();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & 65535;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.vwj.readFully(bArr);
                        this.sla = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new a(this.vwj, readInt), 4096);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.vwf >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.vwh.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        }
    }
}
