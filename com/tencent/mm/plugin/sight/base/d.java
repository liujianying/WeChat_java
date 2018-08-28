package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    private static int ldW = 0;
    private static int ldX = 0;

    public static boolean bvC() {
        if (q.deO.dfx == 0) {
            return false;
        }
        return com.tencent.mm.compatible.util.d.fR(14);
    }

    public static String Ll(String str) {
        return bi.aG(str, "") + ".thumb";
    }

    public static String Lm(String str) {
        return bi.aG(str, "") + ".soundmp4";
    }

    public static Bitmap ad(String str, int i, int i2) {
        if (bi.oW(str)) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail != null) {
            return c.a(createVideoThumbnail, i2, i, true, true);
        }
        x.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[]{str});
        return createVideoThumbnail;
    }

    public static boolean Ln(String str) {
        if (bi.oW(str) || !e.cn(str)) {
            return false;
        }
        long VG = bi.VG();
        c cVar = new c();
        int isSightOk = SightVideoJNI.isSightOk(str, cVar.ncd, cVar.nce, cVar.ncf, cVar.nch, cVar.ncg, cVar.ncg.length);
        x.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
        return isSightOk == 0;
    }

    public static String bvD() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ad.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.d.REV);
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.d.TIME + ":" + com.tencent.mm.sdk.platformtools.d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bxk);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.sFc);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.qVH);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.qVI);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.qVJ);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.qVK);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.qVL);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.bnC);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public static String Ho(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n" + a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()));
        stringBuffer.append("size: " + bi.bF(FileOp.mI(str)) + ":" + str + "\n");
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!bi.oW(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(com.tencent.mm.modelvideo.q.nF(str));
        return stringBuffer.toString();
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            x.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[]{SightVideoJNI.getSimpleMp4Info(str)});
            JSONObject jSONObject = new JSONObject(r0);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append("\n");
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", new Object[]{Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value))})).append("\n");
            stringBuffer.append("videoDuration: ").append(pInt.value).append("\n");
            stringBuffer.append("videoFPS: ").append(pInt4.value).append("\n");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static a Lo(String str) {
        a aVar = null;
        if (!bi.oW(str) && e.cn(str)) {
            aVar = new a();
            try {
                x.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[]{SightVideoJNI.getSimpleMp4Info(str)});
                JSONObject jSONObject = new JSONObject(r1);
                aVar.jdD = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.ljG = (int) jSONObject.getDouble("videoFPS");
                aVar.videoBitrate = jSONObject.getInt("videoBitrate");
                aVar.dQF = jSONObject.getInt("audioBitrate");
                aVar.nbS = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                x.e("MicroMsg.SightUtil", "get media info error %s", new Object[]{e.toString()});
            }
            x.i("MicroMsg.SightUtil", "get media %s", new Object[]{aVar});
        }
        return aVar;
    }
}
