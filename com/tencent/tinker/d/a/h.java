package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h extends FilterOutputStream {
    public static final byte[] vwm = new byte[0];
    private static final byte[] vwn = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private long mb;
    private final HashSet<String> vwo;
    private final boolean vwp;
    public byte[] vwq;
    private int vwr;
    private ByteArrayOutputStream vws;
    private f vwt;
    private byte[] vwu;
    private byte[] vwv;
    private boolean vww;

    public h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.vwo = new HashSet();
        this.vwq = vwm;
        this.vwr = 8;
        this.vws = new ByteArrayOutputStream();
        this.mb = 0;
        this.vwp = false;
    }

    private static long c(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int d(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.vws != null) {
            if (this.vwo.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.vwt != null) {
                closeEntry();
            }
            int size = this.vws.size();
            c(this.vws, 101010256);
            d(this.vws, 0);
            d(this.vws, 0);
            if (this.vww) {
                d(this.vws, 65535);
                d(this.vws, 65535);
                c(this.vws, -1);
                c(this.vws, -1);
            } else {
                d(this.vws, this.vwo.size());
                d(this.vws, this.vwo.size());
                c(this.vws, (long) size);
                c(this.vws, this.mb);
            }
            d(this.vws, this.vwq.length);
            if (this.vwq.length > 0) {
                this.vws.write(this.vwq);
            }
            this.vws.writeTo(this.out);
            this.vws = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        cHm();
        if (this.vwt != null) {
            long j = 30;
            if (this.vwt.vwc != 0) {
                j = 46;
                c(this.out, 134695760);
                c(this.out, this.vwt.vvR);
                c(this.out, this.vwt.vwb);
                c(this.out, this.vwt.size);
            }
            int i = (this.vwt.vwc == 0 ? 0 : 8) | 2048;
            c(this.vws, 33639248);
            d(this.vws, 20);
            d(this.vws, 20);
            d(this.vws, i);
            d(this.vws, this.vwt.vwc);
            d(this.vws, this.vwt.time);
            d(this.vws, this.vwt.vwd);
            c(this.vws, this.vwt.vvR);
            if (this.vwt.vwc == 8) {
                j += this.vwt.vwb;
            } else {
                j += this.vwt.size;
            }
            c(this.vws, this.vwt.vwb);
            c(this.vws, this.vwt.size);
            j += (long) d(this.vws, this.vwu.length);
            if (this.vwt.vwe != null) {
                j += (long) d(this.vws, this.vwt.vwe.length);
            } else {
                d(this.vws, 0);
            }
            d(this.vws, this.vwv.length);
            d(this.vws, 0);
            d(this.vws, 0);
            c(this.vws, 0);
            c(this.vws, this.vwt.vwf);
            this.vws.write(this.vwu);
            this.vwu = null;
            if (this.vwt.vwe != null) {
                this.vws.write(this.vwt.vwe);
            }
            this.mb = j + this.mb;
            if (this.vwv.length > 0) {
                this.vws.write(this.vwv);
                this.vwv = vwm;
            }
            this.vwt = null;
        }
    }

    public final void b(f fVar) {
        int i;
        if (this.vwt != null) {
            closeEntry();
        }
        int i2 = fVar.vwc;
        if (i2 == -1) {
            i = this.vwr;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.vwb == -1) {
                fVar.vwb = fVar.size;
            } else if (fVar.size == -1) {
                fVar.setSize(fVar.vwb);
            }
            if (fVar.vvR == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.size != fVar.vwb) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        cHm();
        fVar.sla = null;
        fVar.vwe = null;
        fVar.time = 40691;
        fVar.vwd = 18698;
        this.vwu = fVar.name.getBytes(d.UTF_8);
        y("Name", this.vwu);
        this.vwv = vwm;
        if (fVar.sla != null) {
            this.vwv = fVar.sla.getBytes(d.UTF_8);
            y("Comment", this.vwv);
        }
        fVar.setMethod(i);
        this.vwt = fVar;
        this.vwt.vwf = this.mb;
        this.vwo.add(this.vwt.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        c(this.out, 67324752);
        d(this.out, 20);
        d(this.out, i2);
        d(this.out, i);
        d(this.out, this.vwt.time);
        d(this.out, this.vwt.vwd);
        if (i == 0) {
            c(this.out, this.vwt.vvR);
            c(this.out, this.vwt.size);
            c(this.out, this.vwt.size);
        } else {
            c(this.out, 0);
            c(this.out, 0);
            c(this.out, 0);
        }
        d(this.out, this.vwu.length);
        if (this.vwt.vwe != null) {
            d(this.out, this.vwt.vwe.length);
        } else {
            d(this.out, 0);
        }
        this.out.write(this.vwu);
        if (this.vwt.vwe != null) {
            this.out.write(this.vwt.vwe);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        a.at(bArr.length, i, i2);
        if (this.vwt == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void cHm() {
        if (this.vws == null) {
            throw new IOException("Stream is closed");
        }
    }

    public static void y(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
