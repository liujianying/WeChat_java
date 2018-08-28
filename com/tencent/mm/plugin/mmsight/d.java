package com.tencent.mm.plugin.mmsight;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d {
    private static float ldU = 0.01f;
    private static boolean ldV = false;
    private static int ldW = 0;
    private static int ldX = 0;
    private static ConcurrentHashMap<String, Long> ldY = new ConcurrentHashMap();

    private static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public static void a(com.tencent.mm.plugin.mmsight.model.a.d dVar, SightParams sightParams) {
        String str = sightParams.lep;
        String str2 = sightParams.len;
        String str3 = sightParams.leo;
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            int i = ldW;
            ldW = i + 1;
            objArr[1] = Integer.valueOf(i);
            File file = new File(String.format("%s/tempvideo%s.mp4", objArr));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(file.getAbsolutePath() + ".remux");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".thumb");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".soundmp4");
            if (file2.exists()) {
                file2.delete();
            }
            i.C(new 1(ldW - 3, str));
            str = file.getAbsolutePath();
            x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", new Object[]{str, bi.aG(str, "") + ".thumb"});
            dVar.setFilePath(str);
            dVar.Hr(str2);
        } else {
            x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", new Object[]{str, str2, str3});
            dVar.setFilePath(str2);
            dVar.Hr(str3);
        }
        x.i("MicroMsg.MMSightUtil", "captureImagePath %s", new Object[]{CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis())});
        dVar.Hs(str);
    }

    public static String Hn(String str) {
        File file = new File(String.format("%s/%s.mp4", new Object[]{str, Long.valueOf(System.currentTimeMillis())}));
        if (file.exists()) {
            file.delete();
        }
        return file.getAbsolutePath();
    }

    public static void gs(boolean z) {
        ldV = z;
    }

    public static Point dO(Context context) {
        Point gu = ak.gu(context);
        if (!ldV && ak.gt(context)) {
            gu.y -= ak.gs(context);
        }
        return gu;
    }

    public static Point bdF() {
        return ak.gu(ad.getContext());
    }

    public static boolean a(Context context, Point point, boolean z) {
        Point dO = dO(context);
        x.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", new Object[]{point, dO, Float.valueOf(((float) dO.y) / ((float) dO.x)), Float.valueOf(z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)), Float.valueOf(Math.abs((((float) dO.y) / ((float) dO.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x))))});
        if (Math.abs((((float) dO.y) / ((float) dO.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x))) > ldU) {
            return true;
        }
        return false;
    }

    public static Point a(Point point, Point point2, boolean z) {
        return a(point, point2, z, false);
    }

    public static Point a(Point point, Point point2, boolean z, boolean z2) {
        int i = point2.x;
        int i2 = point2.y;
        int i3 = z ? point.y : point.x;
        int i4 = z ? point.x : point.y;
        int i5 = (int) (((float) i) * (((float) i4) / ((float) i3)));
        if (i5 % 2 != 0) {
            i5--;
        }
        i3 = (int) ((((float) i3) / ((float) i4)) * ((float) i2));
        if (z2) {
            i4 = cP(i5, point2.y);
        } else {
            i4 = i5;
        }
        x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", new Object[]{point2, point, Integer.valueOf(i), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z)});
        if (i4 <= point2.y && i <= point2.x) {
            return new Point(i, i4);
        }
        x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        return null;
    }

    public static Point b(Point point, Point point2, boolean z) {
        return b(point, point2, z, false);
    }

    public static Point b(Point point, Point point2, boolean z, boolean z2) {
        int i = point2.x;
        int i2 = point2.y;
        int i3 = (int) ((((float) (z ? point.y : point.x)) / ((float) (z ? point.x : point.y))) * ((float) i2));
        if (i3 % 2 != 0) {
            i3++;
        }
        if (z2) {
            i3 = cP(i3, point2.y);
        }
        x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", new Object[]{point2, point, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z)});
        if (i3 <= point2.x) {
            return new Point(i3, i2);
        }
        x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        return null;
    }

    public static String bz(List<Size> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + ";");
        }
        return stringBuffer.toString();
    }

    public static String bA(List<Size> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + " " + ((((double) size.height) * 1.0d) / ((double) size.width)) + "||");
        }
        return stringBuffer.toString();
    }

    public static ArrayList<Size> a(Parameters parameters) {
        Object arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static String Ho(String str) {
        try {
            return com.tencent.mm.plugin.sight.base.d.Ho(str);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String oN(String str) {
        return e.dgl + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static void Hp(String str) {
        x.i("MicroMsg.MMSightUtil", "setTime key %s %s", new Object[]{str, bi.cjd().toString()});
        ldY.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static long Hq(String str) {
        if (!ldY.containsKey(str)) {
            return 0;
        }
        return System.currentTimeMillis() - ((Long) ldY.get(str)).longValue();
    }

    public static int dP(Context context) {
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return (int) (((double) memoryInfo.totalMem) / 1024.0d);
        }
        double a;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            a = (double) a("MemTotal", fileInputStream);
            if (a > 0.0d) {
                a /= 1024.0d;
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            a = 0.0d;
        } catch (Throwable th) {
            fileInputStream.close();
        }
        return (int) a;
    }

    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < 1024 && bArr[i2] != (byte) 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    i = i2 + 1;
                                    while (i < 1024 && Character.isDigit(bArr[i])) {
                                        i++;
                                    }
                                    return bi.WU(new String(bArr, 0, i2, i - i2));
                                }
                                i2++;
                            }
                            return 0;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return 0;
    }

    public static Bitmap mZ(String str) {
        if (bi.oW(str) || !FileOp.cn(str)) {
            x.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", new Object[]{str});
            return null;
        }
        x.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", new Object[]{str});
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            x.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mp4Rotate)});
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0, 2);
            mediaMetadataRetriever.release();
            if (frameAtTime != null) {
                return frameAtTime;
            }
            int i3;
            x.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            if (i <= 0 || i2 <= 0) {
                x.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", new Object[]{SightVideoJNI.getSimpleMp4Info(str)});
                JSONObject jSONObject = new JSONObject(r0);
                i2 = jSONObject.getInt("videoWidth");
                i3 = jSONObject.getInt("videoHeight");
                i = i2;
            } else {
                i3 = i2;
            }
            byte[] videoThumb = MP4MuxerJNI.getVideoThumb(str, i, i3);
            if (videoThumb == null) {
                x.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
                return null;
            }
            Buffer wrap = ByteBuffer.wrap(videoThumb);
            frameAtTime = Bitmap.createBitmap(i, i3, Config.ARGB_8888);
            frameAtTime.copyPixelsFromBuffer(wrap);
            if (mp4Rotate > 0) {
                return c.b(frameAtTime, (float) mp4Rotate);
            }
            return frameAtTime;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightUtil", e, "get video thumb error! %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        byte[] i4 = j.lin.i(Integer.valueOf(bArr.length));
        int i5 = i * i2;
        Object obj = i3 % 180 != 0 ? 1 : null;
        Object obj2 = i3 % 270 != 0 ? 1 : null;
        Object obj3 = i3 >= 180 ? 1 : null;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8;
                int i9;
                int i10;
                int i11;
                int i12 = (i6 * i) + i7;
                int i13 = (((i6 >> 1) * i) + i5) + (i7 & -2);
                int i14 = i13 + 1;
                if (obj != null) {
                    i8 = i2;
                } else {
                    i8 = i;
                }
                if (obj != null) {
                    i9 = i;
                } else {
                    i9 = i2;
                }
                if (obj != null) {
                    i10 = i6;
                } else {
                    i10 = i7;
                }
                if (obj != null) {
                    i11 = i7;
                } else {
                    i11 = i6;
                }
                if (obj2 != null) {
                    i10 = (i8 - i10) - 1;
                }
                if (obj3 != null) {
                    i11 = (i9 - i11) - 1;
                }
                i9 = (i11 * i8) + i10;
                i11 = (((i11 >> 1) * i8) + i5) + (i10 & -2);
                i10 = i11 + 1;
                i4[i9] = (byte) (bArr[i12] & 255);
                i4[i11] = (byte) (bArr[i13] & 255);
                i4[i10] = (byte) (bArr[i14] & 255);
            }
        }
        j.lin.F(bArr);
        return i4;
    }

    public static boolean a(int i, int i2, int i3, PInt pInt, PInt pInt2) {
        int i4;
        int i5;
        boolean z;
        if (i3 <= 0 || Math.min(i, i2) <= i3) {
            i4 = i2;
            i5 = i;
            z = false;
        } else {
            if (i < i2) {
                i4 = (int) (((float) i2) / ((((float) i) * 1.0f) / ((float) i3)));
                i5 = i3;
            } else {
                i5 = (int) (((float) i) / ((((float) i2) * 1.0f) / ((float) i3)));
                i4 = i3;
            }
            z = true;
        }
        pInt.value = i5;
        pInt2.value = i4;
        x.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
        return z;
    }

    public static boolean sL(int i) {
        return i % 16 == 0;
    }

    public static int sM(int i) {
        return cP(i, Integer.MAX_VALUE);
    }

    public static int cP(int i, int i2) {
        int i3 = i % 16;
        if (i3 == 0) {
            return i;
        }
        int i4 = (16 - i3) + i;
        if (i4 < i2) {
            return i4;
        }
        return i - i3;
    }

    public static int sN(int i) {
        int i2 = i % 32;
        if (i2 == 0) {
            return i;
        }
        int i3 = i - (32 - i2);
        if (i3 < Integer.MAX_VALUE) {
            return i3;
        }
        return i - i2;
    }
}
