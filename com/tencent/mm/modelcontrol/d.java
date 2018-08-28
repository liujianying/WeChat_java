package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements ar {
    private static final int dQv = c.aE("dscp");
    private e[] dQA;
    private e[] dQB;
    private e[] dQC;
    private e[] dQD;
    private a dQw = new a();
    private byte[] dQx = null;
    private b dQy;
    private e[] dQz;

    public static d NP() {
        return (d) p.v(d.class);
    }

    private static e[] lA(String str) {
        int i = 0;
        String value = ((a) g.l(a.class)).AT().getValue(str);
        if (bi.oW(value)) {
            x.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[]{str});
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[" + value;
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        x.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[]{str, value});
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            x.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[]{Integer.valueOf(length)});
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = d(jSONArray.getJSONObject(i));
                i++;
            }
            return eVarArr;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            return null;
        }
    }

    private static e d(JSONObject jSONObject) {
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = "0";
            } else {
                str = jSONObject.getString("stepbr");
            }
            x.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[]{string, string2, string3, string4, string5, str});
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            List arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
                i = i2 + 1;
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.dQJ) {
                int i3 = ((f) arrayList.get(0)).dQR;
                i = 1;
                while (true) {
                    int i4 = i;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    f fVar = (f) arrayList.get(i4);
                    fVar.dQQ = i3;
                    i3 = fVar.dQR;
                    i = i4 + 1;
                }
            }
            eVar.dQK = new f[arrayList.size()];
            arrayList.toArray(eVar.dQK);
            x.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[]{eVar});
            return eVar;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        if (bi.oW(str2) || bi.oW(str3) || bi.oW(str4)) {
            return false;
        }
        try {
            String[] split;
            if (bi.oW(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = bi.getInt(split[0], -1);
                pInt2.value = bi.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    return false;
                }
            }
            split = str2.split("x");
            pInt3.value = bi.getInt(split[0], -1);
            pInt4.value = bi.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                return false;
            }
            pInt5.value = bi.getInt(str3, -1);
            pInt6.value = bi.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                return false;
            }
            pInt6.value *= BaseReportManager.MAX_READ_COUNT;
            x.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[]{str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value)});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public static int a(VideoTransPara videoTransPara) {
        if (videoTransPara == null) {
            return 0;
        }
        switch (videoTransPara.duration) {
            case 10:
                return 1;
            default:
                return videoTransPara.duration;
        }
    }

    public final byte[] getWeixinMeta() {
        if (bi.bC(this.dQx)) {
            try {
                this.dQx = ("{\"WXVer\":" + com.tencent.mm.protocal.d.qVN + "}").getBytes("UTF-8");
                x.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[]{r0});
            } catch (Exception e) {
                x.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[]{e.toString()});
            }
        }
        return this.dQx;
    }

    public final boolean lB(String str) {
        Exception e;
        Throwable th;
        if (this.dQy == null) {
            this.dQy = new b();
        }
        b bVar = this.dQy;
        bVar.eyx = -1;
        bVar.eyz = -1;
        bVar.eyA = null;
        long VG = bi.VG();
        long oY = this.dQy.oY(str);
        if (oY <= 0) {
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(oY);
                byte[] bArr = new byte[8];
                com.tencent.mm.plugin.a.a aVar = null;
                for (com.tencent.mm.plugin.a.a a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akO); a != null; a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akO)) {
                    aVar = c.a(randomAccessFile, bArr, dQv);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.VL());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.eyw + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[]{str, e.toString()});
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(oY), Long.valueOf(bi.bI(VG)), str});
                    if (bi.oW(str2)) {
                        return str2.contains("WXVer");
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[]{str, e.toString()});
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e42) {
                }
            }
            x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(oY), Long.valueOf(bi.bI(VG)), str});
            if (bi.oW(str2)) {
                return str2.contains("WXVer");
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e52) {
                }
            }
            throw th;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(oY), Long.valueOf(bi.bI(VG)), str});
        if (bi.oW(str2)) {
            return str2.contains("WXVer");
        }
        return false;
    }

    public final VideoTransPara NQ() {
        VideoTransPara NZ;
        boolean z;
        VideoTransPara videoTransPara;
        long VG = bi.VG();
        if (this.dQz == null) {
            this.dQz = lA("C2CRecordVideoConfig");
        }
        if (this.dQz != null) {
            for (e eVar : this.dQz) {
                if (eVar != null && eVar.NY()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    NZ = eVar.NZ();
                    z = eVar.dQJ;
                    break;
                }
            }
        }
        NZ = null;
        z = true;
        if (NZ == null) {
            NZ = new VideoTransPara();
            NZ.isDefault = true;
            NZ.width = 540;
            NZ.height = 960;
            NZ.fps = 30;
            NZ.videoBitrate = 1200000;
            NZ.dQG = 10;
            NZ.dQF = 64000;
            NZ.dQH = 2;
            NZ.dQI = 1;
            videoTransPara = NZ;
        } else {
            videoTransPara = NZ;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.dQG = 10;
        videoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a) g.l(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.iHM);
        if (z) {
            h.mEJ.a(422, 12, 1, false);
        } else {
            h.mEJ.a(422, 11, 1, false);
        }
        h.mEJ.a(422, (long) bi.f((Integer) h.a(videoTransPara.videoBitrate / BaseReportManager.MAX_READ_COUNT, new int[]{350, 544, 800, 1200, 1600}, 13, 18)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[]{Long.valueOf(bi.bI(VG)), videoTransPara, Integer.valueOf(r0)});
        return videoTransPara;
    }

    public final VideoTransPara NR() {
        VideoTransPara NZ;
        boolean z;
        VideoTransPara NT;
        long VG = bi.VG();
        if (this.dQA == null) {
            this.dQA = lA("SnsRecordVideoConfig");
        }
        if (this.dQA != null) {
            for (e eVar : this.dQA) {
                if (eVar != null && eVar.NY()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    NZ = eVar.NZ();
                    z = eVar.dQJ;
                    break;
                }
            }
        }
        NZ = null;
        z = true;
        if (NZ == null) {
            NT = NT();
        } else {
            NT = NZ;
        }
        NT.audioSampleRate = 44100;
        NT.dQG = 10;
        NT.dQS = 200;
        NT.duration = ((com.tencent.mm.plugin.expt.a.a) g.l(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.iHK);
        if (z) {
            h.mEJ.a(422, 32, 1, false);
        } else {
            h.mEJ.a(422, 31, 1, false);
        }
        h.mEJ.a(422, (long) bi.f((Integer) h.a(NT.videoBitrate / BaseReportManager.MAX_READ_COUNT, new int[]{350, 544, 800, 1200, 1600}, 33, 38)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[]{Long.valueOf(bi.bI(VG)), NT, Integer.valueOf(r0)});
        return NT;
    }

    public final VideoTransPara NS() {
        VideoTransPara NZ;
        boolean z;
        VideoTransPara NT;
        long VG = bi.VG();
        if (this.dQB == null) {
            this.dQB = lA("SnsAlbumVideoConfig");
        }
        if (this.dQB != null) {
            for (e eVar : this.dQB) {
                if (eVar != null && eVar.NY()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    NZ = eVar.NZ();
                    z = eVar.dQJ;
                    break;
                }
            }
        }
        NZ = null;
        z = true;
        if (NZ == null) {
            NT = NT();
        } else {
            NT = NZ;
        }
        NT.audioSampleRate = 44100;
        NT.dQG = 10;
        NT.dQS = 200;
        NT.duration = ((com.tencent.mm.plugin.expt.a.a) g.l(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.iHL);
        if (z) {
            h.mEJ.a(422, 22, 1, false);
        } else {
            h.mEJ.a(422, 21, 1, false);
        }
        h.mEJ.a(422, (long) bi.f((Integer) h.a(NT.videoBitrate / BaseReportManager.MAX_READ_COUNT, new int[]{350, 544, 800, 1200, 1600}, 23, 28)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[]{Long.valueOf(bi.bI(VG)), NT, Integer.valueOf(r0)});
        return NT;
    }

    public final VideoTransPara b(VideoTransPara videoTransPara) {
        if (videoTransPara.duration >= 300) {
            x.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[]{Integer.valueOf(300)});
            return null;
        }
        e[] eVarArr;
        boolean z;
        int i;
        long VG = bi.VG();
        VideoTransPara hC = hC(videoTransPara.duration);
        int i2 = 1;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100157");
        if (fJ.isValid()) {
            i2 = bi.getInt((String) fJ.ckq().get("VideoEncodeStep"), 1);
        }
        x.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[]{Integer.valueOf(i2)});
        if ((i2 > 0 ? 1 : null) != null) {
            if (this.dQD == null) {
                this.dQD = lA("C2CAlbumVideoStepConfig");
            }
            eVarArr = this.dQD;
        } else {
            if (this.dQC == null) {
                this.dQC = lA("C2CAlbumVideoConfig");
            }
            eVarArr = this.dQC;
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null && eVar.NY()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a = a.a(eVar.dQK, videoTransPara, hC);
                    z = eVar.dQJ;
                    i = a;
                    break;
                }
            }
            z = true;
            i = 0;
        } else {
            x.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            z = true;
            i = a.a(null, videoTransPara, hC);
        }
        if (i <= 0) {
            hC = hC(videoTransPara.duration);
        } else {
            hC.isDefault = false;
        }
        if (z) {
            h.mEJ.a(422, 2, 1, false);
        } else {
            h.mEJ.a(422, 1, 1, false);
        }
        h.mEJ.a(422, (long) bi.f((Integer) h.a(hC.videoBitrate / BaseReportManager.MAX_READ_COUNT, new int[]{350, 544, 800, 1200, 1600}, 3, 8)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(i2), Integer.valueOf(i), hC, videoTransPara});
        return hC;
    }

    private static VideoTransPara NT() {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = 960;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1600000;
        videoTransPara.dQG = 10;
        videoTransPara.dQF = 64000;
        videoTransPara.dQH = 2;
        videoTransPara.dQI = 1;
        return videoTransPara;
    }

    private static VideoTransPara hC(int i) {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.dQG = 1;
        videoTransPara.dQF = 48000;
        videoTransPara.dQH = 2;
        videoTransPara.dQI = 1;
        if (i <= 120) {
            videoTransPara.fps = 30;
            videoTransPara.width = 540;
            videoTransPara.height = 960;
            videoTransPara.videoBitrate = 1200000;
        } else {
            videoTransPara.fps = 24;
            videoTransPara.width = 360;
            videoTransPara.height = 640;
            videoTransPara.videoBitrate = 544000;
        }
        return videoTransPara;
    }

    public static boolean NU() {
        int i;
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sUi, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100136");
        if (fJ.isValid()) {
            i = bi.getInt((String) fJ.ckq().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !NW()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i)});
        return z;
    }

    public static boolean NV() {
        int i;
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sUi, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100153");
        if (fJ.isValid()) {
            i = bi.getInt((String) fJ.ckq().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !NW()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i)});
        return z;
    }

    public static boolean NW() {
        int i;
        String str;
        String str2;
        int i2;
        boolean z;
        long VG = bi.VG();
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sUi, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100190");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            i = bi.getInt((String) ckq.get("player"), 1);
            str = (String) ckq.get("apilevel");
            str2 = (String) ckq.get("devices");
            i2 = i;
        } else {
            str2 = null;
            str = null;
            i2 = 1;
        }
        int i3 = VERSION.SDK_INT;
        String str3 = Build.BRAND + Build.MODEL;
        if (!bi.oW(str)) {
            for (String str4 : str.split(";")) {
                if (bi.getInt(str4, 0) == i3) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!bi.oW(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (com.tencent.mm.compatible.util.d.fS(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            g.Ei().DT().a(aa.a.sVF, Boolean.valueOf(true));
        }
        if (intValue == 0) {
            z = false;
        }
        if (i2 <= 0) {
            z = false;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i3), str, str3, str2, Integer.valueOf(i2), Long.valueOf(bi.bI(VG))});
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r13, com.tencent.mm.modelvideo.r r14) {
        /*
        r3 = 0;
        r6 = -1;
        r5 = 2;
        r2 = 1;
        r8 = 0;
        switch(r13) {
            case 0: goto L_0x0028;
            case 1: goto L_0x002a;
            case 2: goto L_0x002a;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r2;
    L_0x0009:
        r1 = "MicroMsg.SubCoreVideoControl";
        r3 = "check c2c video format[%d]";
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r0);
        r2[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r2);
        if (r0 != r5) goto L_0x013e;
    L_0x001c:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = r2;
        goto L_0x0009;
    L_0x002a:
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r1 = com.tencent.mm.storage.aa.a.sXp;
        r4 = java.lang.Integer.valueOf(r6);
        r0 = r0.get(r1, r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r6) goto L_0x005c;
    L_0x0044:
        r0 = com.tencent.mm.plugin.u.e.bdr();
        if (r0 == 0) goto L_0x0085;
    L_0x004a:
        r0 = r2;
    L_0x004b:
        r1 = com.tencent.mm.kernel.g.Ei();
        r1 = r1.DT();
        r4 = com.tencent.mm.storage.aa.a.sXp;
        r6 = java.lang.Integer.valueOf(r6);
        r1.a(r4, r6);
    L_0x005c:
        r1 = "MicroMsg.SubCoreVideoControl";
        r4 = "check device support hevc[%d]";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r8] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r1, r4, r6);
        if (r0 > 0) goto L_0x0087;
    L_0x006f:
        r3 = r8;
    L_0x0070:
        if (r3 == 0) goto L_0x0008;
    L_0x0072:
        com.tencent.mm.modelvideo.o.Ta();
        r0 = r14.getFileName();
        r0 = com.tencent.mm.modelvideo.s.nK(r0);
        r1 = com.tencent.mm.a.e.cn(r0);
        if (r1 != 0) goto L_0x0135;
    L_0x0083:
        r0 = r5;
        goto L_0x0009;
    L_0x0085:
        r0 = r8;
        goto L_0x004b;
    L_0x0087:
        r0 = com.tencent.mm.model.c.c.Jx();
        r1 = "100253";
        r0 = r0.fJ(r1);
        r1 = r0.isValid();
        if (r1 == 0) goto L_0x014d;
    L_0x0098:
        r1 = r0.ckq();
        r0 = "openHevc";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r8);
        r0 = "brands";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r4 = "devices";
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
        r4 = r3;
    L_0x00bc:
        r7 = android.os.Build.BRAND;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 != 0) goto L_0x014b;
    L_0x00c4:
        r3 = ";";
        r6 = r0.split(r3);
        r9 = r6.length;
        r3 = r8;
    L_0x00cd:
        if (r3 >= r9) goto L_0x014b;
    L_0x00cf:
        r10 = r6[r3];
        r10 = r10.equalsIgnoreCase(r7);
        if (r10 == 0) goto L_0x012f;
    L_0x00d7:
        r3 = r8;
    L_0x00d8:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r9 = android.os.Build.BRAND;
        r6 = r6.append(r9);
        r9 = android.os.Build.MODEL;
        r6 = r6.append(r9);
        r9 = r6.toString();
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r6 != 0) goto L_0x0107;
    L_0x00f3:
        r6 = ";";
        r10 = r1.split(r6);
        r11 = r10.length;
        r6 = r8;
    L_0x00fc:
        if (r6 >= r11) goto L_0x0107;
    L_0x00fe:
        r12 = r10[r6];
        r12 = r12.equalsIgnoreCase(r9);
        if (r12 == 0) goto L_0x0132;
    L_0x0106:
        r3 = r8;
    L_0x0107:
        if (r4 > 0) goto L_0x010a;
    L_0x0109:
        r3 = r8;
    L_0x010a:
        r6 = "MicroMsg.SubCoreVideoControl";
        r10 = "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]";
        r11 = 6;
        r11 = new java.lang.Object[r11];
        r12 = java.lang.Boolean.valueOf(r3);
        r11[r8] = r12;
        r4 = java.lang.Integer.valueOf(r4);
        r11[r2] = r4;
        r11[r5] = r7;
        r4 = 3;
        r11[r4] = r0;
        r0 = 4;
        r11[r0] = r9;
        r0 = 5;
        r11[r0] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r6, r10, r11);
        goto L_0x0070;
    L_0x012f:
        r3 = r3 + 1;
        goto L_0x00cd;
    L_0x0132:
        r6 = r6 + 1;
        goto L_0x00fc;
    L_0x0135:
        r0 = com.tencent.mm.modelvideo.q.nF(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x013b:
        r0 = r5;
        goto L_0x0009;
    L_0x013e:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        goto L_0x0027;
    L_0x014b:
        r3 = r2;
        goto L_0x00d8;
    L_0x014d:
        r1 = r3;
        r0 = r3;
        r4 = r8;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.d.a(int, com.tencent.mm.modelvideo.r):int");
    }

    public static boolean NX() {
        String str = null;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100253");
        if (fJ.isValid()) {
            str = (String) fJ.ckq().get("noCompleteRange");
        }
        if (bi.oW(str)) {
            str = "20:00-23:30";
        }
        g.Eg();
        x.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[]{Boolean.valueOf(b.M(str, com.tencent.mm.a.h.aM(com.tencent.mm.kernel.a.Df(), 30))), str, Integer.valueOf(r3)});
        return !b.M(str, com.tencent.mm.a.h.aM(com.tencent.mm.kernel.a.Df(), 30));
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        this.dQz = null;
        this.dQD = null;
        this.dQC = null;
        this.dQA = null;
        this.dQB = null;
    }
}
