package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.i;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.nio.ByteBuffer;

public final class h {
    private static final int[] ahj = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] ahk = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] ahl = new int[]{64, 112, MapRouteSectionWithName.kMaxRoadNameLength, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static Format a(byte[] bArr, String str, String str2) {
        i iVar = new i(bArr);
        iVar.cX(60);
        int i = ahj[iVar.cY(6)];
        int i2 = ahk[iVar.cY(4)];
        int cY = iVar.cY(5);
        cY = cY >= ahl.length ? -1 : (ahl[cY] * 1000) / 2;
        iVar.cX(10);
        return Format.a(str, "audio/vnd.dts", cY, -1, i + (iVar.cY(2) > 0 ? 1 : 0), i2, null, null, str2);
    }

    public static int g(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int d(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int h(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
