package com.google.android.exoplayer2.c;

import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;

public final class i {
    private static final String[] aiJ = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] aiK = new int[]{44100, 48000, 32000};
    private static final int[] aiL = new int[]{32, 64, 96, 128, 160, 192, TbsListener$ErrorCode.EXCEED_INCR_UPDATE, 256, 288, 320, 352, 384, TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER, 448};
    private static final int[] aiM = new int[]{32, 48, 56, 64, 80, 96, TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW, 128, e.CTRL_INDEX, 160, 176, 192, TbsListener$ErrorCode.EXCEED_INCR_UPDATE, 256};
    private static final int[] aiN = new int[]{32, 48, 56, 64, 80, 96, TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW, 128, 160, 192, TbsListener$ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384};
    private static final int[] aiO = new int[]{32, 40, 48, 56, 64, 80, 96, TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW, 128, 160, 192, TbsListener$ErrorCode.EXCEED_INCR_UPDATE, 256, 320};
    private static final int[] aiP = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW, 128, e.CTRL_INDEX, 160};
    public int aft;
    public int aiQ;
    public int bitrate;
    public int channels;
    public String mimeType;
    public int sampleRate;
    public int version;

    public static int cq(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = aiK[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? aiL[i4 - 1] : aiM[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? aiN[i4 - 1] : aiO[i4 - 1];
        } else {
            i4 = aiP[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    public static boolean a(int i, i iVar) {
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return false;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return false;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return false;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return false;
        }
        int i6;
        int i7;
        int i8 = aiK[i5];
        if (i2 == 2) {
            i6 = i8 / 2;
        } else if (i2 == 0) {
            i6 = i8 / 4;
        } else {
            i6 = i8;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            i8 = i2 == 3 ? aiL[i4 - 1] : aiM[i4 - 1];
            i4 = (((i8 * 12000) / i6) + i9) * 4;
            i7 = 384;
            i5 = i8;
        } else {
            int i10;
            if (i2 == 3) {
                i8 = i3 == 2 ? aiN[i4 - 1] : aiO[i4 - 1];
                i4 = 1152;
                i5 = i8;
            } else {
                i5 = aiP[i4 - 1];
                i8 = i3 == 1 ? 576 : 1152;
                if (i3 == 1) {
                    i10 = 72000;
                    i7 = i8;
                    i4 = ((i10 * i5) / i6) + i9;
                } else {
                    i4 = i8;
                }
            }
            i10 = 144000;
            i7 = i4;
            i4 = ((i10 * i5) / i6) + i9;
        }
        String str = aiJ[3 - i3];
        if (((i >> 6) & 3) == 3) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        i5 *= TbsLog.TBSLOG_CODE_SDK_BASE;
        iVar.version = i2;
        iVar.mimeType = str;
        iVar.aft = i4;
        iVar.sampleRate = i6;
        iVar.channels = i8;
        iVar.bitrate = i5;
        iVar.aiQ = i7;
        return true;
    }
}
