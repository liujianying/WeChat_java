package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.cfq;
import com.tencent.mm.protocal.c.cfs;
import com.tencent.mm.protocal.c.cft;
import com.tencent.mm.protocal.c.cfu;
import com.tencent.mm.protocal.c.cfv;
import com.tencent.mm.protocal.c.cfw;
import com.tencent.mm.protocal.c.cfx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g {
    public static WepkgVersion Em(String str) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 3001;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.kff == null) {
            return null;
        }
        return wepkgCrossProcessTask.kff;
    }

    public static WepkgVersion En(String str) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 3002;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.kff == null) {
            return null;
        }
        return wepkgCrossProcessTask.kff;
    }

    public static void a(String str, String str2, boolean z, final a aVar) {
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 3005;
        wepkgCrossProcessTask.kff.kfA = str;
        wepkgCrossProcessTask.kff.ffK = str2;
        wepkgCrossProcessTask.kff.kfX = z;
        if (ad.cic()) {
            d.Em().H(new 8(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.fFC = new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.ahB();
            }
        };
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, a aVar) {
        WepkgDownloadProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i;
        wepkgDownloadProcessTask.cfX = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.kfl = j;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.bKg = str5;
        wepkgDownloadProcessTask.kfm = i2;
        if (ad.cic()) {
            d.Em().H(new 12(i, str, str2, str3, j, str4, str5, i2, wepkgDownloadProcessTask, aVar));
            return;
        }
        wepkgDownloadProcessTask.fFC = new 1(aVar, wepkgDownloadProcessTask);
        wepkgDownloadProcessTask.ahA();
        WepkgMainProcessService.a(wepkgDownloadProcessTask);
    }

    public static void a(baw baw, int i) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 2002;
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.kff;
        if (baw != null) {
            wepkgVersion.kfA = baw.rtC;
            cfv cfv = baw.sdh;
            cfx cfx = baw.sdi;
            if (cfv != null) {
                wepkgVersion.appId = cfv.jQb;
                cfs cfs = cfv.sAq;
                if (cfs != null) {
                    wepkgVersion.version = cfs.sAk;
                    wepkgVersion.kfR = cfs.sAl;
                    wepkgVersion.kfS = (long) cfs.sAm;
                    wepkgVersion.kfT = (long) cfs.sAn;
                }
            }
            if (cfx != null) {
                wepkgVersion.cfx = cfx.sAt;
                wepkgVersion.charset = cfx.syW;
                cfq cfq = cfx.sAu;
                if (cfq == null || cfq.sAh == null || bi.oW(cfq.sAh.rcY)) {
                    wepkgVersion.kfX = true;
                } else {
                    wepkgVersion.bKg = cfq.sAh.rwk;
                    wepkgVersion.downloadUrl = cfq.sAh.rcY;
                    wepkgVersion.kfV = cfq.sAh.sAp;
                    wepkgVersion.kfm = cfq.sAh.sAo;
                    wepkgVersion.kfX = false;
                }
                cfw cfw = cfx.sAv;
                if (cfw != null) {
                    wepkgVersion.kfZ = cfw.sAs;
                }
                if (cfw == null || bi.cX(cfw.sAr) || !cfw.sAs) {
                    wepkgVersion.kfY = true;
                } else {
                    wepkgVersion.kfY = false;
                }
                wepkgVersion.kga = 0;
            }
            wepkgVersion.cga = i;
        }
        cfw cfw2 = baw.sdi.sAv;
        if (!(cfw2 == null || bi.cX(cfw2.sAr))) {
            List arrayList = new ArrayList();
            Iterator it = cfw2.sAr.iterator();
            while (it.hasNext()) {
                cfu cfu = (cfu) it.next();
                WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                String str = baw.rtC;
                String str2 = baw.sdh.sAq.sAk;
                if (cfu != null) {
                    wepkgPreloadFile.aAL = d.di(str, cfu.rDd);
                    wepkgPreloadFile.kfA = str;
                    wepkgPreloadFile.version = str2;
                    wepkgPreloadFile.kfk = cfu.rDd;
                    wepkgPreloadFile.mimeType = cfu.rDf;
                    cft cft = cfu.sAh;
                    if (cft != null) {
                        wepkgPreloadFile.bKg = cft.rwk;
                        wepkgPreloadFile.downloadUrl = cft.rcY;
                        wepkgPreloadFile.size = cft.sAp;
                        wepkgPreloadFile.kfm = cft.sAo;
                    }
                    wepkgPreloadFile.kfB = false;
                }
                arrayList.add(wepkgPreloadFile);
            }
            wepkgCrossProcessTask.kfi = arrayList;
        }
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
    }

    public static List<WepkgPreloadFile> Eo(String str) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 4001;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.kfi;
    }

    public static void a(String str, String str2, String str3, a aVar) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 4002;
        wepkgCrossProcessTask.kfh.kfA = str;
        wepkgCrossProcessTask.kfh.kfk = str2;
        wepkgCrossProcessTask.kfh.filePath = str3;
        wepkgCrossProcessTask.kfh.kfB = false;
        if (ad.cic()) {
            d.Em().H(new 4(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.fFC = new 5(aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static List<WepkgPreloadFile> Ep(String str) {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 4003;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.kfi;
    }

    public static boolean aVy() {
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 1002;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.bGZ;
    }
}
