package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class a {
    private static final int[] afn = new int[]{1, 2, 3, 6};
    private static final int[] afo = new int[]{48000, 44100, 32000};
    private static final int[] afp = new int[]{24000, 22050, 16000};
    private static final int[] afq = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] afr = new int[]{32, 40, 48, 56, 64, 80, 96, 112, FileUtils.S_IWUSR, 160, 192, 224, 256, 320, 384, FileUtils.S_IRWXU, 512, 576, 640};
    private static final int[] afs = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static Format a(j jVar, String str, String str2, DrmInitData drmInitData) {
        int i = afo[(jVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = jVar.readUnsignedByte();
        int i2 = afq[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static Format b(j jVar, String str, String str2, DrmInitData drmInitData) {
        jVar.da(2);
        int i = afo[(jVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = jVar.readUnsignedByte();
        int i2 = afq[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.a(str, "audio/eac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static a a(i iVar) {
        int i;
        int cY;
        int i2;
        int cY2;
        String str;
        int i3 = 1;
        int i4 = iVar.aCq + (iVar.aCp * 8);
        iVar.cX(40);
        if (iVar.cY(5) == 16) {
            i = 1;
        } else {
            byte i5 = (byte) 0;
        }
        iVar.setPosition(i4);
        String str2;
        if (i5 != 0) {
            str2 = "audio/eac3";
            iVar.cX(21);
            cY = (iVar.cY(11) + 1) * 2;
            i4 = iVar.cY(2);
            if (i4 == 3) {
                i4 = afp[iVar.cY(2)];
                i5 = 6;
            } else {
                i5 = afn[iVar.cY(2)];
                i4 = afo[i4];
            }
            i2 = i5 * 256;
            cY2 = iVar.cY(3);
            str = str2;
        } else {
            str2 = "audio/ac3";
            iVar.cX(32);
            i4 = iVar.cY(2);
            i5 = iVar.cY(6);
            int i6 = i5 / 2;
            if (i4 < 0 || i4 >= afo.length || i5 < 0 || i6 >= afs.length) {
                i5 = -1;
            } else {
                cY = afo[i4];
                if (cY == 44100) {
                    i5 = ((i5 % 2) + afs[i6]) * 2;
                } else {
                    i5 = afr[i6];
                    i5 = cY == 32000 ? i5 * 6 : i5 * 4;
                }
            }
            iVar.cX(8);
            cY2 = iVar.cY(3);
            if (!((cY2 & 1) == 0 || cY2 == 1)) {
                iVar.cX(2);
            }
            if ((cY2 & 4) != 0) {
                iVar.cX(2);
            }
            if (cY2 == 2) {
                iVar.cX(2);
            }
            i4 = afo[i4];
            i2 = 1536;
            cY = i5;
            str = str2;
        }
        boolean mb = iVar.mb();
        cY2 = afq[cY2];
        if (!mb) {
            i3 = 0;
        }
        return new a(str, i3 + cY2, i4, cY, i2, (byte) 0);
    }

    public static int iX() {
        return 1536;
    }

    public static int b(ByteBuffer byteBuffer) {
        int i;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
            i = 6;
        } else {
            i = afn[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
