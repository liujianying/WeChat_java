package com.tencent.mm.plugin.game.wepkg.downloader;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.utils.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader {
    private static volatile WePkgDownloader kej = null;
    private Map<String, IWepkgUpdateCallback> kek;
    private a kel = new a() {
        public final synchronized void a(g gVar) {
            String str;
            RetCode retCode;
            d.aVs().Ee(gVar.kdY.kev);
            if (gVar.mStatus == 1) {
                h.mEJ.a(859, 2, 1, false);
                str = gVar.kdY.mFilePath;
                RetCode retCode2;
                if (bi.oW(str) || !new File(str).exists()) {
                    x.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                    retCode2 = RetCode.keo;
                    h.mEJ.a(859, 4, 1, false);
                    retCode = retCode2;
                } else {
                    if (bi.oV(g.cu(str)).equalsIgnoreCase(gVar.kdY.fHy)) {
                        retCode2 = RetCode.ken;
                        h.mEJ.a(859, 5, 1, false);
                        retCode = retCode2;
                    } else {
                        x.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[]{g.cu(str), gVar.kdY.fHy});
                        e.deleteFile(str);
                        retCode2 = RetCode.kep;
                        gVar.isA = 1012;
                        h.mEJ.a(859, 3, 1, false);
                        retCode = retCode2;
                    }
                }
            } else {
                h.mEJ.a(859, 1, 1, false);
                retCode = RetCode.ker;
            }
            x.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:" + retCode);
            IWepkgUpdateCallback iWepkgUpdateCallback = (IWepkgUpdateCallback) WePkgDownloader.this.kek.remove(gVar.kdY.kev);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(gVar.kdY.kew, gVar.kdY.mFilePath, retCode);
            } else {
                x.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
                a.b("CallbackInvalid", gVar.kdY.mUrl, gVar.kdY.kew, null, -1, 0, null);
            }
            if (gVar.kdY.icd == 1) {
                str = gVar.kdY.kew;
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.nc = 3008;
                wepkgCrossProcessTask.kff.kfA = str;
                if (ad.cic()) {
                    wepkgCrossProcessTask.aai();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask);
                }
            } else {
                str = gVar.kdY.kew;
                String str2 = gVar.kdY.kex;
                WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                wepkgCrossProcessTask2.nc = 4005;
                wepkgCrossProcessTask2.kfh.kfA = str;
                wepkgCrossProcessTask2.kfh.kfk = str2;
                if (ad.cic()) {
                    wepkgCrossProcessTask2.aai();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask2);
                }
            }
            WePkgDownloader.b(gVar);
        }
    };

    static /* synthetic */ void b(g gVar) {
        f fVar = gVar.kdY;
        if (fVar != null) {
            String str = fVar.kew;
            String str2 = fVar.kez;
            int i = gVar.keG;
            int i2 = gVar.isA;
            int i3 = gVar.mRetryTimes;
            Context context = ad.getContext();
            int i4 = ao.isNetworkConnected(context) ? ao.is2G(context) ? 2 : ao.is3G(context) ? 3 : ao.is4G(context) ? 4 : ao.isWifi(context) ? 1 : 0 : -1;
            x.i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %d", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            String Eq = a.Eq(fVar.mUrl);
            Object[] objArr = new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), Eq};
            StringBuilder stringBuilder = new StringBuilder();
            for (i4 = 0; i4 < 6; i4++) {
                stringBuilder.append(String.valueOf(objArr[i4])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[6]));
            com.tencent.mm.kernel.g.DF().a(new am(14229, stringBuilder.toString()), 0);
        }
    }

    public static WePkgDownloader aVu() {
        if (kej == null) {
            synchronized (WePkgDownloader.class) {
                if (kej == null) {
                    kej = new WePkgDownloader();
                }
            }
        }
        return kej;
    }

    public WePkgDownloader() {
        if (this.kek == null) {
            this.kek = new ConcurrentHashMap();
        }
    }

    public final void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String dh;
        String str6;
        x.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[]{Integer.valueOf(i), str, str3, Long.valueOf(j), str4, str5, Integer.valueOf(i2)});
        if (i == 1) {
            dh = d.dh(str, str4);
            d.Ey(dh);
            str6 = dh + "/package";
        } else {
            dh = d.dh(str, str4) + "/preload_files";
            d.Ey(dh);
            str6 = dh + "/" + str5;
        }
        if (bi.oW(str6)) {
            x.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[]{str6});
            iWepkgUpdateCallback.a(str, "", RetCode.ker);
            return;
        }
        if (!com.tencent.mm.pluginsdk.g.a.d.a.cn(str6)) {
            dh = d.Et(str);
            if (!bi.oW(dh)) {
                File file = new File(dh);
                List<String> arrayList = new ArrayList();
                if (str6 == null || str6.length() <= 0) {
                    dh = "";
                } else {
                    dh = new File(str6).getName();
                    int lastIndexOf = dh.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        dh = lastIndexOf == 0 ? "" : dh.substring(0, lastIndexOf);
                    }
                }
                a(file, dh, arrayList);
                x.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[]{Integer.valueOf(arrayList.size())});
                for (String dh2 : arrayList) {
                    File file2 = new File(dh2);
                    if (file2.isFile() && file2.length() == j && bi.oV(g.m(file2)).equalsIgnoreCase(str5)) {
                        e.y(file2.getAbsolutePath(), str6);
                        x.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[]{file2.getAbsolutePath(), str6});
                        iWepkgUpdateCallback.a(str, str6, RetCode.ken);
                        return;
                    }
                }
            }
        } else if (bi.oV(g.cu(str6)).equals(str5)) {
            x.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[]{str4, str6});
            iWepkgUpdateCallback.a(str, str6, RetCode.ken);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        switch (i2) {
            case 1:
                if (ao.isWifi(ad.getContext())) {
                    z = true;
                    z2 = true;
                    break;
                }
                break;
            case 3:
                if (ao.fK(ad.getContext()) || ao.is3G(ad.getContext())) {
                    z = true;
                    break;
                }
            case 4:
                z = true;
                break;
            case 9:
                if (!ao.isWifi(ad.getContext())) {
                    if ((ao.fK(ad.getContext()) || ao.is3G(ad.getContext())) && d.aVC()) {
                        z = true;
                        break;
                    }
                }
                z = true;
                break;
        }
        x.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            Object obj;
            c cVar = new c(new f(g.u(str3.getBytes()), i, str, str2, str4, str3, str6, j, str5, z2, this.kel));
            d aVs = d.aVs();
            if (aVs.kei.containsKey(cVar.kdY.kev)) {
                obj = null;
            } else {
                cVar.kdZ = b.aVq().kdX.submit(cVar);
                aVs.kei.put(cVar.kdY.kev, cVar);
                obj = 1;
            }
            if (obj != null) {
                this.kek.put(g.u(str3.getBytes()), iWepkgUpdateCallback);
                h.mEJ.a(859, 0, 1, false);
                return;
            }
            iWepkgUpdateCallback.a(str, "", RetCode.kes);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
        iWepkgUpdateCallback.a(str, "", RetCode.kes);
    }

    private void a(File file, String str, List<String> list) {
        if (file != null && file.exists()) {
            if (file.isFile() && file.getName().equals(str)) {
                List list2;
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        a(a, str, list2);
                    }
                }
            }
        }
    }
}
