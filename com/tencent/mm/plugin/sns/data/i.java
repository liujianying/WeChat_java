package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ah;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public final class i {
    public static String gVL = "<TimelineObject>";
    public static String gVM = "</TimelineObject>";
    public static int nle = Integer.MAX_VALUE;
    public static String nlf = "/";
    private static String nlg = "snsb";
    private static int nlh = -1;
    private static int nli = -1;
    public static int nlj = 4194304;
    public static int nlk = 1048576;

    public static String aE(int i, String str) {
        return i + "-" + str;
    }

    public static String cf(List<ate> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return str;
            }
            ate ate = (ate) it.next();
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + ate.ksA;
            i = i2 + 1;
            if (i >= 4) {
                return str;
            }
        }
    }

    private static String c(ate ate) {
        if (!bi.oW(ate.rVS)) {
            return ate.rVS;
        }
        String str = "";
        try {
            return g.u(ate.toByteArray());
        } catch (Exception e) {
            return str;
        }
    }

    public static String LA(String str) {
        return "snst_" + LL(str);
    }

    public static String LB(String str) {
        return "snsu_" + LL(str);
    }

    public static String LC(String str) {
        return "snsb_" + LL(str);
    }

    public static String d(ate ate) {
        String str = "snsb_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String e(ate ate) {
        String str = "snst_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String LD(String str) {
        return "snsu_" + LL(str);
    }

    public static String f(ate ate) {
        String str = "snsu_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String g(ate ate) {
        String str = "snsblurt_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String h(ate ate) {
        String str = "snsblurs_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String i(ate ate) {
        String str = "snstblur_src_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String j(ate ate) {
        String str = "sight_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String k(ate ate) {
        String str = "sightad_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str, ate.rVR);
        }
        return str;
    }

    public static String l(ate ate) {
        String str = "snsb_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String m(ate ate) {
        String str = "sns_tmpb_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String LE(String str) {
        return "sns_tmpb_" + LL(str);
    }

    public static String n(ate ate) {
        String str = "sns_tmpt_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String LF(String str) {
        return "sns_tmpt_" + LL(str);
    }

    public static String o(ate ate) {
        String str = "sns_tmpu_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String p(ate ate) {
        String str = "sns_tmps_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String LG(String str) {
        return "sns_tmps_" + LL(str);
    }

    public static String q(ate ate) {
        String str = "sns_tmpsad_" + LL(ate.ksA);
        if (ate.rVQ == 1) {
            return f.q(str + c(ate), ate.rVR);
        }
        return str;
    }

    public static String aF(int i, String str) {
        return i + "-" + str;
    }

    public static void af(String str, long j) {
        x.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
    }

    public static boolean q(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static boolean b(n nVar) {
        if (nVar == null || nVar.isRecycled()) {
            return false;
        }
        return true;
    }

    public static Bitmap s(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        String str2;
        if (bi.oW(str)) {
            str2 = "";
        } else {
            int lastIndexOf = str.lastIndexOf(nlf);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                str2 = str.substring(lastIndexOf + 1);
                if (str2.startsWith(nlg) || str2.startsWith("sns_tmpb_")) {
                    str2 = str;
                } else if (str2.startsWith("snst_") || str2.startsWith("snsu_")) {
                    str2 = "";
                }
            }
            str2 = str;
        }
        if (bi.oW(str2)) {
            return bitmap;
        }
        int orientationInDegree;
        try {
            x.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", new Object[]{str, Long.valueOf(FileOp.mI(str))});
            Exif fromFile = Exif.fromFile(str);
            if (fromFile != null) {
                orientationInDegree = fromFile.getOrientationInDegree() % 360;
            } else {
                orientationInDegree = 0;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str2, new Object[0]);
            orientationInDegree = 0;
        }
        x.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
        return c.b(bitmap, (float) orientationInDegree);
    }

    public static n LH(String str) {
        try {
            x.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + FileOp.cn(str));
            if (FileOp.cn(str)) {
                return LJ(str);
            }
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static Bitmap LI(String str) {
        try {
            Throwable th;
            InputStream inputStream;
            if (!FileOp.cn(str)) {
                return null;
            }
            Options options = new Options();
            c.c(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                InputStream openRead;
                try {
                    openRead = FileOp.openRead(str);
                    try {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        long VG = bi.VG();
                        Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options, decodeResultLogger, 0, new int[0]);
                        long bI = bi.bI(VG);
                        if (options.inSampleSize > 1) {
                            x.w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                        }
                        if (decodeStream != null) {
                            decodeStream = s(str, decodeStream);
                            com.tencent.mm.plugin.sns.h.c.ag(str, bI);
                        } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                            h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                        }
                        if (openRead == null) {
                            return decodeStream;
                        }
                        try {
                            openRead.close();
                            return decodeStream;
                        } catch (IOException e) {
                            return decodeStream;
                        }
                    } catch (OutOfMemoryError e2) {
                        try {
                            options.inSampleSize++;
                            if (openRead != null) {
                                try {
                                    openRead.close();
                                } catch (IOException e3) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = openRead;
                        }
                    }
                } catch (OutOfMemoryError e4) {
                    openRead = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            }
            return null;
            throw th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        } catch (Throwable th32) {
            x.printErrStackTrace("MicroMsg.SnsUtil", th32, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static n LJ(String str) {
        try {
            if (!FileOp.cn(str)) {
                return null;
            }
            Options options = new Options();
            c.c(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    long VG = bi.VG();
                    n c = a.c(str, options, decodeResultLogger);
                    VG = bi.bI(VG);
                    if (c != null) {
                        com.tencent.mm.plugin.sns.h.c.ag(str, VG);
                    } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                        h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                    }
                    return c;
                } catch (OutOfMemoryError e) {
                    options.inSampleSize++;
                }
            }
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static String LK(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, "0");
        }
        return stringBuffer.toString();
    }

    public static String eF(long j) {
        return new BigInteger(Long.toBinaryString(j), 2).toString();
    }

    public static String eG(long j) {
        if (j == 0) {
            return "";
        }
        return LK(new BigInteger(Long.toBinaryString(j), 2).toString());
    }

    private static String LL(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    private static Rect G(Bitmap bitmap) {
        int width = bitmap.getWidth();
        return new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
    }

    private static Rect H(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap i(List<n> list, int i) {
        int i2 = 0;
        for (n b : list) {
            if (!b(b)) {
                return null;
            }
        }
        if (i <= 0) {
            return null;
        }
        Rect rect;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        int size = list.size();
        List linkedList = new LinkedList();
        int i3 = i >> 1;
        int i4 = i3 + 2;
        i3 -= 2;
        Rect rect2;
        Rect rect3;
        if (size == 2) {
            rect = new Rect(0, 0, i3, i);
            rect2 = new Rect(i4, 0, i, i);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            rect = new Rect(0, 0, i3, i);
            rect3 = new Rect(i4, 0, i, i3);
            rect2 = new Rect(i4, i4, i, i);
            linkedList.add(rect);
            linkedList.add(rect3);
            linkedList.add(rect2);
        } else if (size >= 4) {
            rect = new Rect(0, 0, i3, i3);
            rect3 = new Rect(0, i4, i3, i);
            Rect rect4 = new Rect(i4, 0, i, i3);
            rect2 = new Rect(i4, i4, i, i);
            linkedList.add(rect);
            linkedList.add(rect3);
            linkedList.add(rect4);
            linkedList.add(rect2);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        i3 = 0;
        while (true) {
            i4 = i2;
            if (i4 >= list.size() || i3 >= 4) {
                canvas.save(31);
                canvas.restore();
            } else {
                Rect H;
                Bitmap Fx = ((n) list.get(i4)).Fx();
                rect = (Rect) linkedList.get(i4);
                switch (list.size()) {
                    case 1:
                        H = H(Fx);
                        break;
                    case 2:
                        H = G(Fx);
                        break;
                    case 3:
                        if (i4 != 0) {
                            H = H(Fx);
                            break;
                        }
                        H = G(Fx);
                        break;
                    default:
                        H = H(Fx);
                        break;
                }
                canvas.drawBitmap(Fx, H, rect, null);
                i2 = i4 + 1;
                i3++;
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static boolean LM(String str) {
        return str.startsWith(e.bnC);
    }

    public static boolean LN(String str) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean LO(String str) {
        int i = nlj;
        try {
            Options VZ = c.VZ(str);
            int i2 = VZ.outWidth;
            int i3 = VZ.outHeight;
            if ((i3 > 0 || i2 > 0) && i3 < i2 * 2 && i2 < i3 * 2 && i3 * i2 > i) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean wl(int i) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putInt("sns_control_flag", i).commit();
        return true;
    }

    public static int bwY() {
        return ad.getContext().getSharedPreferences(ad.chY(), 0).getInt("sns_control_flag", 0);
    }

    public static boolean wm(int i) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putInt("sns_respone_count", i).commit();
        return true;
    }

    public static int bwZ() {
        return ad.getContext().getSharedPreferences(ad.chY(), 0).getInt("sns_respone_count", 20);
    }

    public static String y(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            return "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        o[] oVarArr = (o[]) spannableString.getSpans(0, spannableString.length(), o.class);
        x.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[]{Integer.valueOf(oVarArr.length)});
        while (i < oVarArr.length) {
            spannableString.removeSpan(oVarArr[i]);
            i++;
        }
        return spannableString.toString();
    }

    public static void b(View view, Context context) {
        if (view != null && ah.fe(context) > 1.0f) {
            float fe = ah.fe(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i = (int) (((float) layoutParams.width) * fe);
                int i2 = (int) (fe * ((float) layoutParams.height));
                if (i > fromDPToPix) {
                    i = fromDPToPix;
                }
                layoutParams.width = i;
                if (i2 <= fromDPToPix) {
                    fromDPToPix = i2;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static int bxa() {
        Context context = ad.getContext();
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 2;
        }
        if (ao.is4G(context)) {
            return 3;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean f(com.tencent.mm.plugin.sns.storage.n nVar) {
        if (nVar.field_type == 3 || nVar.field_type == 4 || nVar.field_type == 5 || nVar.field_type == 6 || nVar.field_type == 9 || nVar.field_type == 10 || nVar.field_type == 11 || nVar.field_type == 12 || nVar.field_type == 13 || nVar.field_type == 14 || nVar.field_type == 17 || nVar.field_type == 22 || nVar.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long NL() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        if (bi.oW(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        return new SpannableString(j.c(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
    }

    public static String g(com.tencent.mm.plugin.sns.storage.n nVar) {
        return nVar == null ? "0" : eF(nVar.field_snsId);
    }

    public static long LP(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            j = new BigInteger(str).longValue();
            x.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(j)});
            return j;
        } catch (Exception e) {
            return j;
        }
    }

    public static int LQ(String str) {
        Throwable th;
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            if (!bi.oW(str)) {
                x.i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", new Object[]{str});
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    i = bi.ge((long) bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                    mediaMetadataRetriever.release();
                } catch (Throwable th2) {
                    try {
                        x.e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", new Object[]{str});
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        return i;
    }
}
