package com.tencent.mm.plugin.monitor;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.support.design.a$i;
import com.tencent.mm.a.h;
import com.tencent.mm.ab.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements ar {
    private static final long startTime = System.currentTimeMillis();
    private a dEC = new a() {
        public final void a(String str, l lVar) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[]{bi.cjd()});
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                g.Em().h(new Runnable() {
                    public final void run() {
                        b.this.gC(true);
                        b.bfC();
                    }
                }, 100);
            }
        }
    };
    private boolean hsR = false;
    private boolean hsS = true;
    private BroadcastReceiver hsT;
    private Runnable hsU;
    private long lrI = 1024;
    private long lrJ = 10;
    private long lrK = 1800;
    private long lrL = 3000000;
    private long lrM = 15000;
    private long lrN = 100000;
    private long lrO = 10000;
    private long lrP = 1024;
    private long lrQ = 1440;
    private long lrR = 20;
    private long lrS = 1440;
    private long lrT = 0;
    private a.a lrU;
    private long lrV = 0;
    private e lrW = new 1(this);
    private Runnable lrX = new 9(this);
    private Runnable lrY = new 10(this);
    private c lrZ = new 11(this);
    private al lsa = new al(g.Em().lnJ.getLooper(), new 12(this), true);

    static /* synthetic */ void b(b bVar) {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sUe, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            g.Ek();
            g.Ei().DT().a(aa.a.sUe, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 5(bVar), "reportSDStatus");
        }
    }

    static /* synthetic */ void bfC() {
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100282");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg  abTest[%s][%b][%s]", new Object[]{fJ, Boolean.valueOf(fJ.isValid()), fJ.ckq()});
        if (fJ.isValid()) {
            boolean z;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg abTest valid!");
            Editor edit = ad.getContext().getSharedPreferences("hardcoder_setting", 0).edit();
            Map ckq = fJ.ckq();
            boolean z2 = bi.getInt((String) ckq.get("enable"), HardCoderJNI.hcEnable ? 1 : 0) > 0;
            boolean z3 = z2 && !HardCoderJNI.hcEnable;
            edit.putBoolean("KEY_HC_ENABLE", z2);
            edit.putBoolean("KEY_HC_BG_ENABLE", bi.getInt((String) ckq.get("bgenable"), HardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            edit.putBoolean("KEY_HC_DEBUG", bi.getInt((String) ckq.get("debug"), HardCoderJNI.hcDebug ? 1 : 0) > 0);
            edit.putBoolean("KEY_HC_SWITCH_ENABLE", bi.getInt((String) ckq.get("switch"), HardCoderJNI.hcSwitchEnable ? 1 : 0) > 0);
            edit.putInt("KEY_HC_KV_PER", bi.getInt((String) ckq.get("kvper"), HardCoderJNI.hcUinHash));
            edit.putInt("KEY_HC_KV_FT", bi.getInt((String) ckq.get("kvft"), HardCoderJNI.hcUinHash));
            g.Ek();
            g.Eg();
            edit.putInt("KEY_HC_UIN_HASH", h.aM(com.tencent.mm.kernel.a.Df(), 100));
            long j = bi.getLong((String) ckq.get("scene"), -1);
            for (Entry entry : HardCoderJNI.flagKeyMap.entrySet()) {
                edit.putBoolean((String) entry.getValue(), (((Long) entry.getKey()).longValue() & j) != 0);
            }
            edit.putInt("KEY_HC_TIMEOUT_MARGIN", bi.getInt((String) ckq.get("margin"), HardCoderJNI.hcTimeoutMargin));
            edit.putInt("KEY_HC_RETRY_INTERVAL", bi.getInt((String) ckq.get("retryitv"), HardCoderJNI.hcRetryInterval));
            String aG = bi.aG((String) ckq.get("model"), "");
            CharSequence charSequence = Build.MODEL;
            if (aG.length() > 0) {
                z3 = aG.contains(charSequence);
                HardCoderJNI.reportIDKey(true, z3 ? 10 : 11, 1, true);
                edit.putBoolean("KEY_HC_ENABLE", z3);
                z = z3 && !HardCoderJNI.hcEnable;
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg check model[%s] modellist[%s] enable[%b] init[%b]", new Object[]{charSequence, aG, Boolean.valueOf(z3), Boolean.valueOf(z)});
            } else {
                HardCoderJNI.reportIDKey(true, 12, 1, true);
                z = z3;
            }
            edit.apply();
            HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_ABTEST);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] switch[%b] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[]{Boolean.valueOf(HardCoderJNI.hcEnable), Boolean.valueOf(z), Boolean.valueOf(HardCoderJNI.hcBgEnable), Boolean.valueOf(HardCoderJNI.hcDebug), Integer.valueOf(r5), Boolean.valueOf(HardCoderJNI.hcSwitchEnable), Boolean.valueOf(HardCoderJNI.hcKVPerReport), Boolean.valueOf(HardCoderJNI.hcKVFtReport), Long.valueOf(j), Integer.valueOf(r1), Integer.valueOf(r8), aG});
            if (z) {
                HardCoderJNI.initHardCoder();
                HardCoderJNI.initReporter(new com.tencent.mm.hardcoder.e());
            }
        }
    }

    static /* synthetic */ void c(b bVar) {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sUN, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > bVar.lrS * 60000 || longValue > currentTimeMillis) {
            g.Ek();
            g.Ei().DT().a(aa.a.sUN, Long.valueOf(currentTimeMillis));
            b bVar2 = bVar;
            com.tencent.mm.sdk.f.e.post(new 2(bVar2, (bVar.lrK * 1024) * 1024, (bVar.lrP * 1024) * 1024, bVar.lrL, bVar.lrM, bVar.lrN, bVar.lrO), "reportDBInfo");
        }
    }

    static /* synthetic */ void d(b bVar) {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sUV, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            g.Ek();
            g.Ei().DT().a(aa.a.sUV, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 3(bVar), "reportVersion");
        }
    }

    static /* synthetic */ void e(b bVar) {
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sVY, Integer.valueOf(0))).intValue();
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sVZ, Long.valueOf(0))).longValue();
        g.Ek();
        int intValue2 = ((Integer) g.Ei().DT().get(aa.a.sWa, Integer.valueOf(0))).intValue();
        int myPid = Process.myPid();
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ad.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
        int totalPss = (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) ? -1 : processMemoryInfo[0].getTotalPss();
        if (intValue == 0) {
            g.Ek();
            g.Ei().DT().a(aa.a.sVY, Integer.valueOf(myPid));
            g.Ek();
            g.Ei().DT().a(aa.a.sVZ, Long.valueOf(System.currentTimeMillis() - startTime));
            g.Ek();
            com.tencent.mm.storage.x DT = g.Ei().DT();
            aa.a aVar = aa.a.sWa;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            DT.a(aVar, Integer.valueOf(totalPss));
        } else if (intValue != myPid) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(13778, new Object[]{Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue)});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13778, new Object[]{Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2)});
            g.Ek();
            g.Ei().DT().a(aa.a.sVY, Integer.valueOf(myPid));
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            g.Ek();
            g.Ei().DT().a(aa.a.sVZ, Long.valueOf(currentTimeMillis));
            g.Ek();
            g.Ei().DT().a(aa.a.sWa, Integer.valueOf(totalPss));
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", new Object[]{Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(totalPss), Integer.valueOf(intValue), Integer.valueOf(myPid)});
        } else {
            g.Ek();
            g.Ei().DT().a(aa.a.sVZ, Long.valueOf(System.currentTimeMillis() - startTime));
            if (totalPss > intValue2) {
                g.Ek();
                g.Ei().DT().a(aa.a.sWa, Integer.valueOf(totalPss));
            }
        }
        bVar.lsa.J(180000, 180000);
    }

    static /* synthetic */ void f(b bVar) {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sUf, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
            g.Ek();
            g.Ei().DT().a(aa.a.sUf, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 7(bVar), "reportHardCoder");
        }
    }

    static /* synthetic */ void h(b bVar) {
        if (bVar.lrV != 0) {
            g.Ek();
            long longValue = ((Long) g.Ei().DT().get(aa.a.sVP, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, 17, 1, true);
                g.Ek();
                g.Ei().DT().a(aa.a.sVP, Long.valueOf(currentTimeMillis));
                g.Ek();
                longValue = ((Long) g.Ei().DT().get(aa.a.sVO, Long.valueOf(0))).longValue();
                log_14375 log_14375 = new log_14375();
                log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue;
                String valueOf = String.valueOf(longValue);
                g.Ek();
                long longValue2 = ((Long) g.Ei().DT().get(aa.a.sVQ, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVR, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVS, Long.valueOf(0))).longValue();
                heavyDetailInfo.dbSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVT, Long.valueOf(0))).longValue();
                heavyDetailInfo.message_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVU, Long.valueOf(0))).longValue();
                heavyDetailInfo.conversation_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVV, Long.valueOf(0))).longValue();
                heavyDetailInfo.contact_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVW, Long.valueOf(0))).longValue();
                heavyDetailInfo.chatroom_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.Ek();
                longValue2 = ((Long) g.Ei().DT().get(aa.a.sVX, Long.valueOf(0))).longValue();
                heavyDetailInfo.favDbSize_ = longValue2;
                String str = valueOf + ";" + longValue2;
                ad.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong("message", heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    FileOp.l(g.Ei().cachePath + "heavyDetailInfo", new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put("message", heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_).toString().getBytes());
                } catch (JSONException e) {
                    x.e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13778, new Object[]{Integer.valueOf(4), Integer.valueOf(1), str});
                com.tencent.mm.plugin.report.service.h.mEJ.c(14375, log_14375);
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", new Object[]{str});
            }
        }
    }

    static /* synthetic */ long q(b bVar) {
        g.Ek();
        if (g.Ei().isSDCardAvailable()) {
            File file = new File(com.tencent.mm.compatible.util.e.dgr);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                    return 0;
                }
                Arrays.sort(listFiles, new 4(bVar));
                long j = 0;
                for (File name : listFiles) {
                    String name2 = name.getName();
                    if (!bi.oW(name2) && name2.endsWith(".xlog")) {
                        j = bi.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                        if (j > 0) {
                            return j;
                        }
                    }
                }
                return j;
            }
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            return 0;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
        return 0;
    }

    private boolean gC(boolean z) {
        boolean z2;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100212");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[]{Boolean.valueOf(z), fJ, Boolean.valueOf(fJ.isValid()), fJ.ckq(), Long.valueOf(1024), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440)});
        if (fJ.isValid()) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map ckq = fJ.ckq();
            long j = bi.getLong((String) ckq.get("sdsize"), 1024);
            long j2 = bi.getLong((String) ckq.get("sdratio"), 10);
            long j3 = bi.getLong((String) ckq.get("dbsize"), 1800);
            long j4 = bi.getLong((String) ckq.get("fdbsize"), 1024);
            long j5 = bi.getLong((String) ckq.get("msg"), 3000000);
            long j6 = bi.getLong((String) ckq.get("conv"), 15000);
            long j7 = bi.getLong((String) ckq.get("contact"), 100000);
            long j8 = bi.getLong((String) ckq.get("chatroom"), 10000);
            long j9 = bi.getLong((String) ckq.get("sditv"), 1440);
            long j10 = bi.getLong((String) ckq.get("sdwait"), 20);
            long j11 = bi.getLong((String) ckq.get("dbitv"), 1440);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[]{Long.valueOf(this.lrI), Long.valueOf(j), Long.valueOf(this.lrJ), Long.valueOf(j2), Long.valueOf(this.lrK), Long.valueOf(j3), Long.valueOf(this.lrP), Long.valueOf(j4), Long.valueOf(this.lrL), Long.valueOf(j5), Long.valueOf(this.lrM), Long.valueOf(j6), Long.valueOf(this.lrN), Long.valueOf(j7), Long.valueOf(this.lrO), Long.valueOf(j8), Long.valueOf(this.lrQ), Long.valueOf(j9), Long.valueOf(this.lrR), Long.valueOf(j10), Long.valueOf(this.lrS), Long.valueOf(j11)});
            if (this.lrI != j) {
                this.lrI = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.lrJ != j2) {
                this.lrJ = j2;
                z2 = true;
            }
            if (this.lrK != j3) {
                this.lrK = j3;
                z2 = true;
            }
            if (this.lrP != j4) {
                this.lrP = j4;
                z2 = true;
            }
            if (this.lrL != j5) {
                this.lrL = j5;
                z2 = true;
            }
            if (this.lrM != j6) {
                this.lrM = j6;
                z2 = true;
            }
            if (this.lrN != j7) {
                this.lrN = j7;
                z2 = true;
            }
            if (this.lrO != j8) {
                this.lrO = j8;
                z2 = true;
            }
            if (this.lrQ != j9) {
                this.lrQ = j9;
                z2 = true;
            }
            if (this.lrR != j10) {
                this.lrR = j10;
                z2 = true;
            }
            if (this.lrS != j11) {
                this.lrS = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 0, 1, true);
            if (z) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, 18, 1, true);
            }
        }
        if (this.lrI <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 30, 1, true);
            this.lrI = 1024;
        }
        if (this.lrJ <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 31, 1, true);
            this.lrJ = 10;
        }
        if (this.lrK <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 32, 1, true);
            this.lrK = 1800;
        }
        if (this.lrL <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 33, 1, true);
            this.lrL = 3000000;
        }
        if (this.lrM <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 34, 1, true);
            this.lrM = 15000;
        }
        if (this.lrN <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 35, 1, true);
            this.lrN = 100000;
        }
        if (this.lrO <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 36, 1, true);
            this.lrO = 10000;
        }
        if (this.lrQ <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 37, 1, true);
            this.lrQ = 1440;
        }
        if (this.lrR <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 38, 1, true);
            this.lrR = 20;
        }
        if (this.lrS <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 39, 1, true);
            this.lrS = 1440;
        }
        if (this.lrP <= 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(509, 40, 1, true);
            this.lrP = 1024;
        }
        return z2;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.sdk.b.a.sFg.a(this.lrZ);
        com.tencent.mm.model.c.c.Jx().c(this.dEC);
        boolean gC = gC(false);
        g.Ek();
        this.lrV = ((Long) g.Ei().DT().get(aa.a.sVO, Long.valueOf(0))).longValue();
        com.tencent.mm.plugin.report.service.e.ht(this.lrV != 0);
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[]{Long.valueOf(this.lrV), Boolean.valueOf(gC), this.dEC});
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("hardcoder_setting", 0);
        g.Ek();
        g.Eg();
        if (com.tencent.mm.kernel.a.Df() != 0) {
            g.Ek();
            g.Eg();
            int aM = h.aM(com.tencent.mm.kernel.a.Df(), 100);
            if (aM != sharedPreferences.getInt("KEY_HC_UIN_HASH", 0)) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder uin[%d, %d] reloadSPConfig", new Object[]{Integer.valueOf(r3), Integer.valueOf(aM)});
                sharedPreferences.edit().putInt("KEY_HC_UIN_HASH", aM).apply();
                HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_POST_RESET);
            }
        }
        g.Ek();
        g.Eh().dpP.a(989, this.lrW);
        g.Ek();
        g.Eh().dpP.a(988, this.lrW);
        g.Ek();
        g.Eh().dpP.a(987, this.lrW);
        g.Ek();
        g.Eh().dpP.a(986, this.lrW);
        g.Ek();
        this.lrT = ((Long) g.Ei().DT().get(aa.a.sUQ, Long.valueOf(0))).longValue();
        Context context = ad.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.hsR = z2;
        } else {
            this.hsR = false;
        }
        this.hsS = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hsT = new 13(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.hsT, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.lrU != null ? "enabled" : "disabled";
        objArr[1] = this.hsS ? "" : " not";
        objArr[2] = this.hsR ? "" : " not";
        objArr[3] = Long.valueOf(this.lrT);
        objArr[4] = Long.valueOf(this.lrQ * 60000);
        objArr[5] = Long.valueOf(this.lrR * 60000);
        x.i(str, str2, objArr);
        this.lsa.SO();
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[]{Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis())});
        if (this.hsT != null) {
            ad.getContext().unregisterReceiver(this.hsT);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[]{this.hsT});
            this.hsT = null;
        }
        if (this.hsU != null) {
            g.Em().cil().removeCallbacks(this.hsU);
            this.hsU = null;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[]{this.lrU});
        }
        if (this.lrU != null) {
            this.lrU.dZm = true;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[]{this.lrU});
            this.lrU = null;
        }
        g.Ek();
        g.Eh().dpP.b(989, this.lrW);
        g.Ek();
        g.Eh().dpP.b(988, this.lrW);
        g.Ek();
        g.Eh().dpP.b(987, this.lrW);
        g.Ek();
        g.Eh().dpP.b(986, this.lrW);
        com.tencent.mm.model.c.c.Jx().d(this.dEC);
        com.tencent.mm.sdk.b.a.sFg.c(this.lrZ);
    }

    private a.a a(File file, a.a aVar, com.tencent.mm.plugin.monitor.a.b bVar, a.c cVar, Map<String, Integer> map, boolean z, int i) {
        if (aVar.dZm) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[]{aVar, bVar});
        } else {
            if (aVar.axZ < i) {
                aVar.axZ++;
            }
            if (file.isDirectory()) {
                com.tencent.mm.plugin.monitor.a.b bVar2;
                String absolutePath = file.getAbsolutePath();
                if (bVar != null || map == null || map.size() <= 0 || map.get(absolutePath) == null) {
                    bVar2 = bVar;
                } else {
                    com.tencent.mm.plugin.monitor.a.b bVar3 = new com.tencent.mm.plugin.monitor.a.b(absolutePath, ((Integer) map.get(absolutePath)).intValue());
                    map.remove(absolutePath);
                    aVar.lrF.add(bVar3);
                    x.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[]{absolutePath, aVar, bVar3});
                    bVar2 = bVar3;
                }
                aVar.lrC++;
                if (bVar2 != null) {
                    bVar2.lrC++;
                }
                if (cVar != null) {
                    cVar.lrC++;
                }
                if (i > 15) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[]{Integer.valueOf(i), file.getAbsolutePath(), aVar});
                } else {
                    String[] list = file.list();
                    if (list != null) {
                        if (!z) {
                            long j = 1;
                            int length = list.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= length) {
                                    break;
                                }
                                a(new File(file.getAbsolutePath() + File.separator + list[i3]), aVar, bVar2, cVar, map, false, i + 1);
                                if (j == null || aVar.axZ <= 15) {
                                    i2 = j;
                                } else {
                                    j = 7;
                                    com.tencent.mm.plugin.report.service.h.mEJ.a(418, 7, 1, true);
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(2), file.getAbsolutePath() + File.separator + r18});
                                    i2 = 0;
                                }
                                i3++;
                            }
                        } else {
                            a.c cVar2 = cVar;
                            for (String str : list) {
                                if (!bi.oW(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                    cVar2 = new a.c(file.getAbsolutePath() + File.separator + str);
                                    aVar.lrG.add(cVar2);
                                }
                                a(new File(file.getAbsolutePath() + File.separator + str), aVar, bVar2, cVar2, map, false, i + 1);
                            }
                        }
                    } else {
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[]{file.getAbsolutePath()});
                    }
                }
            } else {
                aVar.lrD++;
                if (bVar != null) {
                    bVar.lrD++;
                }
                if (cVar != null) {
                    cVar.lrD++;
                }
                if (file.exists()) {
                    long length2 = file.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar != null) {
                            bVar.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.lrH++;
                        }
                    } else {
                        aVar.gTK += length2;
                        if (bVar != null) {
                            bVar.gTK += length2;
                        }
                        if (cVar != null) {
                            cVar.gTK = length2 + cVar.gTK;
                        }
                    }
                } else {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[]{file.getAbsolutePath(), Long.valueOf(aVar.lrD)});
                }
            }
        }
        return aVar;
    }

    private synchronized void i(int i, long j, long j2) {
        long j3;
        boolean z = j > j2;
        if (z) {
            j3 = this.lrV | ((long) i);
        } else {
            j3 = this.lrV & ((long) (i ^ -1));
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.lrV), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId())});
        if (j3 != this.lrV) {
            if (this.lrV == 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, 1, 1, true);
            }
            if (j3 == 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, 2, 1, true);
            }
        }
        aa.a aVar = null;
        aa.a aVar2;
        switch (i) {
            case 1:
                aVar2 = aa.a.sVQ;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                aVar2 = aa.a.sVR;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 5 : 6, 1, true);
                aVar = aVar2;
                break;
            case 4:
                aVar2 = aa.a.sVS;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 7 : 8, 1, true);
                aVar = aVar2;
                break;
            case 8:
                aVar2 = aa.a.sVT;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 9 : 10, 1, true);
                aVar = aVar2;
                break;
            case 16:
                aVar2 = aa.a.sVU;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 11 : 12, 1, true);
                aVar = aVar2;
                break;
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                aVar2 = aa.a.sVV;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 13 : 14, 1, true);
                aVar = aVar2;
                break;
            case 64:
                aVar2 = aa.a.sVW;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 15 : 16, 1, true);
                aVar = aVar2;
                break;
            case 128:
                aVar2 = aa.a.sVX;
                com.tencent.mm.plugin.report.service.h.mEJ.a(509, z ? 19 : 20, 1, true);
                aVar = aVar2;
                break;
        }
        this.lrV = j3;
        com.tencent.mm.plugin.report.service.e.ht(j3 != 0);
        final long j4 = j3;
        final long j5 = j;
        g.Em().H(new Runnable() {
            public final void run() {
                g.Ek();
                g.Ei().DT().a(aa.a.sVO, Long.valueOf(j4));
                if (aVar != null) {
                    g.Ek();
                    g.Ei().DT().a(aVar, Long.valueOf(j5));
                }
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[]{Long.valueOf(j4), Long.valueOf(b.this.lrV), aVar, Long.valueOf(j5)});
            }
        });
    }
}
