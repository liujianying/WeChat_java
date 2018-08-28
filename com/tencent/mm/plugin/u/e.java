package com.tencent.mm.plugin.u;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    private static long lcO = 0;

    @TargetApi(21)
    public static boolean bdr() {
        if (!d.fR(21)) {
            return false;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        int length = codecInfos.length;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < length; i++) {
            String a = a(codecInfos[i]);
            if (!bi.oW(a)) {
                arrayList.add(Integer.valueOf(i));
                arrayList2.add(a);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean bds() {
        if (bi.bH(lcO) > 86400000) {
            return true;
        }
        return false;
    }

    public static String bdt() {
        x.d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", new Object[]{Long.valueOf(lcO)});
        try {
            lcO = bi.VF();
            if (!d.fR(21)) {
                return bdu();
            }
            int i;
            long VG = bi.VG();
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            int length = codecInfos.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (i = 0; i < length; i++) {
                String a = a(codecInfos[i]);
                if (!bi.oW(a)) {
                    arrayList.add(Integer.valueOf(i));
                    arrayList2.add(a);
                }
            }
            if (arrayList.isEmpty()) {
                return "";
            }
            Object obj;
            Object obj2 = null;
            String str = null;
            Object obj3 = null;
            Object obj4 = null;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            length = 0;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            i = 0;
            while (true) {
                int i9 = i;
                obj = obj2;
                if (i9 >= arrayList.size()) {
                    break;
                }
                int intValue = ((Integer) arrayList.get(i9)).intValue();
                String str2 = (String) arrayList2.get(i9);
                boolean isEncoder = codecInfos[intValue].isEncoder();
                obj2 = !codecInfos[intValue].isEncoder() ? 1 : null;
                CodecCapabilities capabilitiesForType = codecInfos[intValue].getCapabilitiesForType(str2);
                if (capabilitiesForType != null) {
                    obj3 = 1;
                    VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                    if (videoCapabilities != null) {
                        i2 = Math.max(((Integer) videoCapabilities.getBitrateRange().getLower()).intValue(), i2);
                        i3 = Math.max(((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue(), i3);
                        i4 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getLower()).intValue(), i4);
                        i5 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getUpper()).intValue(), i5);
                        i6 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getLower()).intValue(), i6);
                        i7 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue(), i7);
                        i8 = Math.max(((Integer) videoCapabilities.getSupportedHeights().getLower()).intValue(), i8);
                        i = Math.max(((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue(), length);
                    } else {
                        i = length;
                    }
                    length = stringBuilder.append(codecInfos[intValue].getName());
                    str = "|";
                    length.append(str);
                } else {
                    obj4 = 1;
                    str = "|";
                    stringBuilder2.append(codecInfos[intValue].getName()).append(str);
                    i = length;
                }
                i9++;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(1).append(",");
            if (str != null && obj != null) {
                stringBuilder3.append(3).append(",");
            } else if (obj != null) {
                stringBuilder3.append(2).append(",");
            } else {
                stringBuilder3.append(1).append(",");
            }
            if (obj3 != null && obj4 != null) {
                stringBuilder3.append(3).append(",");
            } else if (obj4 != null) {
                stringBuilder3.append(2).append(",");
            } else {
                stringBuilder3.append(1).append(",");
            }
            stringBuilder3.append(stringBuilder.toString()).append(",");
            stringBuilder3.append(stringBuilder2.toString()).append(",");
            stringBuilder3.append(i2).append(",").append(i3).append(",");
            stringBuilder3.append(i4).append(",").append(i5).append(",");
            stringBuilder3.append(i6).append(",").append(i7).append(",");
            stringBuilder3.append(i8).append(",").append(length);
            x.i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", new Object[]{Long.valueOf(bi.bI(VG)), stringBuilder3.toString()});
            return stringBuilder3.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MediaCodecUtil", e, "report hevc info error %s", new Object[]{e.toString()});
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "report hevc info error %s", new Object[]{e2.toString()});
        }
        return "";
    }

    private static String bdu() {
        int i;
        long VG = bi.VG();
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (i = 0; i < codecCount; i++) {
            String a = a(MediaCodecList.getCodecInfoAt(i));
            if (!bi.oW(a)) {
                arrayList.add(Integer.valueOf(i));
                arrayList2.add(a);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        boolean z = false;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        i = 0;
        while (true) {
            codecCount = i;
            if (codecCount >= arrayList.size()) {
                break;
            }
            String str = (String) arrayList2.get(codecCount);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(((Integer) arrayList.get(codecCount)).intValue());
            z = codecInfoAt.isEncoder();
            obj = !codecInfoAt.isEncoder() ? 1 : null;
            if (codecInfoAt.getCapabilitiesForType(str) != null) {
                obj2 = 1;
                stringBuilder.append(codecInfoAt.getName()).append("|");
            } else {
                obj3 = 1;
                stringBuilder2.append(codecInfoAt.getName()).append("|");
            }
            i = codecCount + 1;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(1).append(",");
        if (obj != null && z) {
            stringBuilder3.append(3).append(",");
        } else if (z) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        if (obj2 != null && obj3 != null) {
            stringBuilder3.append(3).append(",");
        } else if (obj3 != null) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        stringBuilder3.append(stringBuilder.toString()).append(",");
        stringBuilder3.append(stringBuilder2.toString());
        x.i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", new Object[]{Long.valueOf(bi.bI(VG)), stringBuilder3.toString()});
        return stringBuilder3.toString();
    }

    private static String a(MediaCodecInfo mediaCodecInfo) {
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        for (String str : supportedTypes) {
            if (!bi.oW(str) && str.contains("hevc")) {
                return str;
            }
        }
        return "";
    }
}
