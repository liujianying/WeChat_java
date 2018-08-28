package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;

public final class e extends a {
    public static final int eyO = c.aE("vide");
    public static final int eyP = c.aE("soun");
    public static final int eyQ = c.aE("hint");
    long duration = 0;
    long eyR = 0;
    long eyS = 0;
    long eyT = 0;

    public e(int i, long j, int i2) {
        super(i, j, i2, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        int read = randomAccessFile.read(bArr);
        while (true) {
            int i = read;
            if (i < 8) {
                read = z;
                break;
            }
            long j;
            int B = c.B(bArr, 0);
            read = c.B(bArr, 4);
            boolean read2;
            if (read2 == a.akf) {
                byte[] bArr2 = new byte[4];
                int read3 = randomAccessFile.read(bArr2);
                if (read3 < 4) {
                    read2 = -1;
                } else {
                    read3 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (c.a(randomAccessFile, 8)) {
                            read2 = read3 + 8;
                            read3 = randomAccessFile.read(bArr);
                            if (read3 < 8) {
                                read2 = -1;
                            } else {
                                read2 += read3;
                                this.eyR = c.C(bArr, 0);
                                this.duration = c.C(bArr, 4);
                            }
                        } else {
                            read2 = -1;
                        }
                    } else if (c.a(randomAccessFile, 16)) {
                        read3 += 16;
                        int read4 = randomAccessFile.read(bArr2);
                        if (read4 < 4) {
                            read2 = -1;
                        } else {
                            read3 += read4;
                            this.eyR = c.C(bArr2, 0);
                            read2 = randomAccessFile.read(bArr);
                            if (read2 < 8) {
                                read2 = -1;
                            } else {
                                read2 += read3;
                                this.duration = c.R(bArr);
                            }
                        }
                    } else {
                        read2 = -1;
                    }
                }
                if (read2 <= 0) {
                    x.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    return false;
                }
                obj = 1;
                j = (long) ((B - i) - read2);
                read2 = z;
            } else if (read2 == a.akg) {
                if (c.a(randomAccessFile, 8)) {
                    read2 = randomAccessFile.read(bArr, 0, 4);
                    if (read2 < 4) {
                        read2 = -1;
                    } else {
                        this.eyS = (long) c.B(bArr, 0);
                        read2 += 8;
                    }
                } else {
                    read2 = -1;
                }
                if (read2 <= 0) {
                    x.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    return false;
                }
                obj2 = 1;
                j = (long) ((B - i) - read2);
                read2 = z;
            } else if (read2 == a.ajT) {
                this.eyT = randomAccessFile.getFilePointer() - ((long) i);
                j = (long) (B - i);
                read2 = 1;
            } else {
                j = (long) (B - 8);
                read2 = z;
            }
            if (obj != null && r2 != null && r0 != 0) {
                break;
            }
            z = c.a(randomAccessFile, j);
            if (!z) {
                return false;
            }
            i = randomAccessFile.read(bArr);
        }
        return (obj == null || obj2 == null || read2 == 0) ? false : true;
    }
}
