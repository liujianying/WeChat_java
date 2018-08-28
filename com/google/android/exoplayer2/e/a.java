package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.t;

@TargetApi(16)
public final class a {
    public final boolean agM;
    public final boolean apq;
    public final boolean apr;
    public final CodecCapabilities aps;
    public final String mimeType;
    public final String name;

    public static a a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(java.lang.String r6, java.lang.String r7, android.media.MediaCodecInfo.CodecCapabilities r8, boolean r9, boolean r10) {
        /*
        r5 = this;
        r4 = 21;
        r1 = 1;
        r2 = 0;
        r5.<init>();
        r0 = com.google.android.exoplayer2.i.a.Z(r6);
        r0 = (java.lang.String) r0;
        r5.name = r0;
        r5.mimeType = r7;
        r5.aps = r8;
        if (r9 != 0) goto L_0x005b;
    L_0x0015:
        if (r8 == 0) goto L_0x005b;
    L_0x0017:
        r0 = com.google.android.exoplayer2.i.t.SDK_INT;
        r3 = 19;
        if (r0 < r3) goto L_0x0059;
    L_0x001d:
        r0 = "adaptive-playback";
        r0 = r8.isFeatureSupported(r0);
        if (r0 == 0) goto L_0x0059;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        if (r0 == 0) goto L_0x005b;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r5.apq = r0;
        if (r8 == 0) goto L_0x005f;
    L_0x002e:
        r0 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r0 < r4) goto L_0x005d;
    L_0x0032:
        r0 = "tunneled-playback";
        r0 = r8.isFeatureSupported(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x003b:
        r0 = r1;
    L_0x003c:
        if (r0 == 0) goto L_0x005f;
    L_0x003e:
        r0 = r1;
    L_0x003f:
        r5.agM = r0;
        if (r10 != 0) goto L_0x0055;
    L_0x0043:
        if (r8 == 0) goto L_0x0056;
    L_0x0045:
        r0 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r0 < r4) goto L_0x0061;
    L_0x0049:
        r0 = "secure-playback";
        r0 = r8.isFeatureSupported(r0);
        if (r0 == 0) goto L_0x0061;
    L_0x0052:
        r0 = r1;
    L_0x0053:
        if (r0 == 0) goto L_0x0056;
    L_0x0055:
        r2 = r1;
    L_0x0056:
        r5.apr = r2;
        return;
    L_0x0059:
        r0 = r2;
        goto L_0x0027;
    L_0x005b:
        r0 = r2;
        goto L_0x002a;
    L_0x005d:
        r0 = r2;
        goto L_0x003c;
    L_0x005f:
        r0 = r2;
        goto L_0x003f;
    L_0x0061:
        r0 = r2;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final CodecProfileLevel[] kj() {
        return (this.aps == null || this.aps.profileLevels == null) ? new CodecProfileLevel[0] : this.aps.profileLevels;
    }

    @TargetApi(21)
    public final boolean a(int i, int i2, double d) {
        if (this.aps == null) {
            aj("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = this.aps.getVideoCapabilities();
        if (videoCapabilities == null) {
            aj("sizeAndRate.vCaps");
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                aj("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            new StringBuilder("AssumedSupport [").append("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aCH).append("]");
        }
        return true;
    }

    public final void aj(String str) {
        new StringBuilder("NoSupport [").append(str).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aCH).append("]");
    }

    @TargetApi(21)
    private static boolean a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
