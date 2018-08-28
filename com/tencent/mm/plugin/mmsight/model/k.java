package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static void bdT() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        h.mEJ.a(440, 0, 1, false);
        int i = 36;
        if (j.lgz.dfb == 1) {
            i = 39;
        }
        if (j.lgz.lfa == 720) {
            i++;
        } else if (j.lgz.beb()) {
            i += 2;
        }
        h.mEJ.a(440, (long) i, 1, false);
    }

    public static void bdU() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        h.mEJ.a(440, 7, 1, false);
    }

    public static void bdV() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        h.mEJ.a(440, 8, 1, false);
    }

    public static void bdW() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        h.mEJ.a(440, 16, 1, false);
    }

    public static void bdX() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
        h.mEJ.a(440, 21, 1, false);
    }

    public static void c(boolean z, long j) {
        int intExtra;
        int i;
        x.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        a.bdH().lfh = j;
        a bdH = a.bdH();
        d dVar = new d();
        d dVar2 = new d();
        dVar.q("model", bdH.model + ",");
        dVar.q("apiLevel", bdH.leH + ",");
        dVar.q("memoryClass", bdH.iNj + ",");
        dVar.q("totalMemory", bdH.leI + ",");
        dVar.q("maxCpu", bdH.leJ + ",");
        dVar.q("screenW", bdH.leK + ",");
        dVar.q("screenH", bdH.leL + ",");
        dVar2.q("model", bdH.model + ",");
        dVar2.q("apiLevel", bdH.leH + ",");
        dVar2.q("memoryClass", bdH.iNj + ",");
        dVar2.q("totalMemory", bdH.leI + ",");
        dVar2.q("maxCpu", bdH.leJ + ",");
        dVar2.q("screenW", bdH.leK + ",");
        dVar2.q("screenH", bdH.leL + ",");
        dVar.q("cropx", bdH.leQ + ",");
        dVar.q("cropy", bdH.leR + ",");
        dVar.q("previewx", bdH.leS + ",");
        dVar.q("previewy", bdH.leT + ",");
        dVar.q("encoderx", bdH.leU + ",");
        dVar.q("encodery", bdH.leV + ",");
        dVar.q("rotate", bdH.bYE + ",");
        dVar.q("deviceoutfps", bdH.leW + ",");
        dVar.q("recordfps", bdH.leX + ",");
        dVar.q("recordertype", bdH.leY + ",");
        dVar.q("videoBitrate", bdH.videoBitrate + ",");
        dVar.q("needRotateEachFrame", bdH.dfc + ",");
        dVar.q("isNeedRealtimeScale", bdH.leZ + ",");
        dVar.q("resolutionLimit", bdH.lfa + ",");
        dVar.q("outfps", bdH.lfb + ",");
        dVar.q("recordTime", bdH.lfc + ",");
        dVar.q("avgcpu", bdH.lfd + ",");
        dVar.q("outx", bdH.lfe + ",");
        dVar.q("outy", bdH.lff + ",");
        dVar.q("outbitrate", bdH.lfg + ",");
        dVar.q("fileSize", bdH.fileSize + ",");
        dVar.q("wait2playtime", bdH.lfh + ",");
        dVar.q("useback", bdH.lfi + ",");
        int i2 = 0;
        Intent registerReceiver = ad.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            intExtra2 = (intExtra2 == 2 || intExtra2 == 5) ? 1 : 0;
            i2 = registerReceiver.getIntExtra("level", -1);
            intExtra = registerReceiver.getIntExtra("scale", -1);
            i = intExtra2;
        } else {
            i = 0;
            intExtra = 0;
        }
        x.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(intExtra)});
        dVar.q("mIsCharging", i + ",");
        dVar.q("level", i2 + ",");
        dVar.q("scale", intExtra + ",");
        dVar.q("createTime", System.currentTimeMillis() + ",");
        dVar2.q("prewViewlist1", bdH.leM + ",");
        dVar2.q("pictureSize1", bdH.leN + ",");
        dVar2.q("prewViewlist2", bdH.leO + ",");
        dVar2.q("pictureSize2", bdH.leP + ",");
        x.i("MicroMsg.CaptureStatistics", "report " + dVar.wF());
        x.v("MicroMsg.CaptureStatistics", "report " + dVar2.wF());
        h.mEJ.k(13947, dVar.toString());
        h.mEJ.k(13949, dVar2.toString());
        if (z) {
            h.mEJ.a(440, 119, 1, false);
            h.mEJ.a(440, 120, j, false);
            if (j.lgz.lfa == 720) {
                h.mEJ.a(440, 122, j, false);
                return;
            } else if (j.lgz.beb()) {
                h.mEJ.a(440, 123, j, false);
                return;
            } else {
                h.mEJ.a(440, 121, j, false);
                return;
            }
        }
        h.mEJ.a(440, 124, 1, false);
        h.mEJ.a(440, 125, j, false);
        if (j.lgz.dfb == 1) {
            h.mEJ.a(440, 127, j, false);
            h.mEJ.a(440, 131, j, false);
            return;
        }
        h.mEJ.a(440, 126, j, false);
        h.mEJ.a(440, 130, j, false);
    }
}
