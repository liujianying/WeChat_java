package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    static a leG;
    public int bYE = 0;
    public int dfc;
    JSONObject fFc = null;
    public long fileSize;
    int iNj;
    String leH = (VERSION.SDK_INT);
    int leI;
    String leJ;
    int leK;
    int leL;
    public String leM;
    public String leN;
    public String leO;
    public String leP;
    public int leQ;
    public int leR;
    public int leS;
    public int leT;
    public int leU;
    public int leV;
    public int leW;
    public int leX;
    public int leY;
    public int leZ;
    public int lfa;
    public int lfb;
    public int lfc;
    int lfd;
    public int lfe;
    public int lff;
    public int lfg;
    public long lfh;
    public int lfi;
    String model = Build.MODEL;
    public int videoBitrate;

    public static a bdH() {
        if (leG == null) {
            reset();
        }
        return leG;
    }

    public static void reset() {
        a aVar = new a();
        leG = aVar;
        aVar.iNj = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        leG.leI = d.dP(ad.getContext());
        leG.leJ = m.zk();
        Point dO = d.dO(ad.getContext());
        leG.leK = dO.x;
        leG.leL = dO.y;
    }

    public final String bdI() {
        if (this.fFc == null) {
            try {
                this.fFc = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.fFc.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.leH);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.leK), Integer.valueOf(this.leL)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.leQ), Integer.valueOf(this.leR)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.leS), Integer.valueOf(this.leT)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", new Object[]{Integer.valueOf(this.leU), Integer.valueOf(this.leV)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.bYE);
                jSONObject.put("deviceoutfps", this.leW);
                jSONObject.put("recordfps", this.leX);
                jSONObject.put("recordertype", this.leY);
                jSONObject.put("needRotateEachFrame", this.dfc);
                jSONObject.put("isNeedRealtimeScale", this.leZ);
                jSONObject.put("resolutionLimit", this.lfa);
                jSONObject.put("videoBitrate", this.videoBitrate);
                jSONObject.put("wait2playtime", this.lfh);
                jSONObject.put("useback", this.lfi);
                jSONObject.put("presetIndex", j.lgz != null ? j.lgz.lgI : -1);
                jSONObject.put("recorderOption", q.deT.dfi);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        return this.fFc.toString();
    }
}
