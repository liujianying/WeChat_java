package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static int fHD = 2;
    private static Map<Long, Long> ibM = new HashMap();
    private static d ibU;
    private m ibN;
    private m ibO;
    private m ibP;
    private m ibQ;
    private m ibR;
    private m ibS;
    public b ibT;
    public boolean ibV = false;

    static /* synthetic */ PendingIntent J(String str, String str2, String str3) {
        Intent intent = new Intent();
        Context context = ad.getContext();
        intent.setClass(context, FileDownloadService.class);
        intent.putExtra(FileDownloadService.icm, 3);
        intent.putExtra(FileDownloadService.icn, str);
        intent.putExtra(FileDownloadService.ico, str2);
        intent.putExtra("appId", str3);
        return PendingIntent.getService(context, (int) System.currentTimeMillis(), intent, 0);
    }

    static /* synthetic */ void f(a aVar) {
        if (bi.oW(aVar.field_filePath)) {
            x.e("MicroMsg.FileDownloadManager", "installApk, path is null");
            return;
        }
        x.i("MicroMsg.FileDownloadManager", "APK File Path: %s", aVar.field_filePath);
        if (com.tencent.mm.plugin.downloader.e.a.yW(aVar.field_filePath)) {
            com.tencent.mm.plugin.downloader.e.a.a(aVar.field_appId, aVar.field_scene, aVar.field_downloadId, aVar.field_channelId);
        }
    }

    public static d aCU() {
        if (ibU == null) {
            ibU = new d();
        }
        return ibU;
    }

    private d() {
        aCZ();
        if (g.Eg().Dx()) {
            g.Eg();
            if (!com.tencent.mm.kernel.a.Dr()) {
                fHD = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("FileDownloaderType"), 2);
                x.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(fHD));
                this.ibT = new b();
            }
        }
        x.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.ibT = new b();
    }

    public final m aCV() {
        x.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + fHD);
        if (this.ibN != null) {
            return this.ibN;
        }
        hh hhVar = new hh();
        com.tencent.mm.sdk.b.a.sFg.m(hhVar);
        int i = hhVar.bQC.bPG;
        if (i > 0) {
            fHD = i;
        }
        if (fHD == 1) {
            this.ibN = aCW();
        } else {
            if (this.ibQ == null) {
                this.ibQ = new com.tencent.mm.plugin.downloader.d.a(this.ibT);
            }
            this.ibN = this.ibQ;
        }
        return this.ibN;
    }

    private m aCW() {
        if (this.ibP == null) {
            this.ibP = new g(this.ibT);
        }
        return this.ibP;
    }

    private m aCX() {
        if (this.ibO == null) {
            this.ibO = new i(this.ibT);
        }
        return this.ibO;
    }

    public final m aCY() {
        if (this.ibR == null) {
            this.ibR = new a(this.ibT);
        }
        return this.ibR;
    }

    public final long a(e eVar) {
        x.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(eVar.icd), eVar.mAppId);
        if (eVar.icd == 2) {
            if (this.ibS == null) {
                this.ibS = new j(this.ibT);
            }
            return this.ibS.a(eVar);
        }
        a(eVar.mAppId, eVar);
        if (g.Eg().Dx()) {
            g.Eg();
            if (!com.tencent.mm.kernel.a.Dr()) {
                return aCV().a(eVar);
            }
        }
        long a = aCW().a(eVar);
        if (a >= 0) {
            ibM.put(Long.valueOf(a), Long.valueOf(0));
            ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        aCX().a(eVar);
        return a;
    }

    public final long b(e eVar) {
        x.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", eVar.mAppId);
        a(eVar.mAppId, eVar);
        if (g.Eg().Dx()) {
            g.Eg();
            if (!com.tencent.mm.kernel.a.Dr()) {
                return aCY().a(eVar);
            }
        }
        long a = aCW().a(eVar);
        if (a >= 0) {
            ibM.put(Long.valueOf(a), Long.valueOf(0));
            ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        aCX().a(eVar);
        return a;
    }

    public final int cl(long j) {
        x.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = " + j);
        if (cu(j)) {
            return aCW().cl(j);
        }
        a cs = c.cs(j);
        if (cs == null || cs.field_downloaderType != 3) {
            return aCV().cl(j);
        }
        return aCY().cl(j);
    }

    public final FileDownloadTaskInfo cm(long j) {
        if (cu(j)) {
            return aCW().cm(j);
        }
        FileDownloadTaskInfo fileDownloadTaskInfo;
        a cs = c.cs(j);
        if (cs != null && cs.field_status == 3 && e.cn(cs.field_filePath)) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.url = cs.field_downloadUrl;
            fileDownloadTaskInfo.status = 3;
            fileDownloadTaskInfo.path = cs.field_filePath;
            fileDownloadTaskInfo.bKg = cs.field_md5;
            fileDownloadTaskInfo.icq = cs.field_downloadedSize;
            fileDownloadTaskInfo.gTK = cs.field_totalSize;
            fileDownloadTaskInfo.icr = cs.field_autoDownload;
            fileDownloadTaskInfo.bPG = cs.field_downloaderType;
        } else if (cs == null || cs.field_downloaderType != 3) {
            fileDownloadTaskInfo = aCV().cm(j);
            if (cs != null) {
                fileDownloadTaskInfo.icr = cs.field_autoDownload;
                fileDownloadTaskInfo.bPG = cs.field_downloaderType;
            }
        } else {
            fileDownloadTaskInfo = aCY().cm(j);
        }
        if (fileDownloadTaskInfo == null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
        }
        if (fileDownloadTaskInfo.status == 3 && !e.cn(fileDownloadTaskInfo.path)) {
            fileDownloadTaskInfo.status = 0;
        }
        fileDownloadTaskInfo.ics = cs != null ? cs.field_downloadInWifi : false;
        fileDownloadTaskInfo.appId = cs != null ? cs.field_appId : "";
        x.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(fileDownloadTaskInfo.id), fileDownloadTaskInfo.url, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.path, fileDownloadTaskInfo.bKg, Long.valueOf(fileDownloadTaskInfo.gTK), Boolean.valueOf(fileDownloadTaskInfo.icr), Integer.valueOf(fileDownloadTaskInfo.bPG));
        return fileDownloadTaskInfo;
    }

    public final FileDownloadTaskInfo yO(String str) {
        a yK = c.yK(str);
        if (yK != null) {
            return cm(yK.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public final FileDownloadTaskInfo yP(String str) {
        a yN = c.yN(str);
        if (yN != null) {
            return cm(yN.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public static ArrayList<FileDownloadTaskInfo> n(ArrayList<String> arrayList) {
        ArrayList arrayList2 = null;
        b FX = c.FX();
        if (FX != null) {
            Cursor rawQuery = FX.rawQuery("select * from FileDownloadInfo where " + b.o(arrayList), new String[0]);
            if (rawQuery != null) {
                arrayList2 = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    do {
                        a aVar = new a();
                        aVar.d(rawQuery);
                        arrayList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        ArrayList<FileDownloadTaskInfo> arrayList3 = new ArrayList();
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || e.cn(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.bKg = aVar2.field_md5;
                fileDownloadTaskInfo.icq = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.gTK = aVar2.field_totalSize;
                fileDownloadTaskInfo.icr = aVar2.field_autoDownload;
                fileDownloadTaskInfo.bPG = aVar2.field_downloaderType;
                arrayList3.add(fileDownloadTaskInfo);
            }
        }
        return arrayList3;
    }

    public final boolean cn(long j) {
        x.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = " + j);
        cw(j);
        if (cu(j)) {
            return aCW().cn(j);
        }
        a cs = c.cs(j);
        if (cs == null || cs.field_downloaderType != 3) {
            return aCV().cn(j);
        }
        return aCY().cn(j);
    }

    public final boolean co(long j) {
        x.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = " + j);
        cw(j);
        if (cu(j)) {
            return aCW().co(j);
        }
        a cs = c.cs(j);
        if (cs == null || cs.field_downloaderType != 3) {
            return aCV().co(j);
        }
        return aCY().co(j);
    }

    private static void aCZ() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences != null) {
            Map all = sharedPreferences.getAll();
            if (all != null && all.size() != 0) {
                ibM.clear();
                for (Entry entry : all.entrySet()) {
                    if (!(entry == null || bi.oW((String) entry.getKey()))) {
                        try {
                            long j = bi.getLong((String) entry.getKey(), 0);
                            long longValue = ((Long) entry.getValue()).longValue();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                                ibM.put(Long.valueOf(j), Long.valueOf(longValue));
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                            x.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                        }
                    }
                }
                sharedPreferences.edit().clear();
                for (Entry entry2 : ibM.entrySet()) {
                    sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
                }
                sharedPreferences.edit().commit();
            }
        }
    }

    static void a(String str, String str2, PendingIntent pendingIntent) {
        android.support.v4.app.z.d dVar = new android.support.v4.app.z.d(ad.getContext());
        dVar.b(str);
        dVar.c(str2);
        dVar.Y(17301634);
        dVar.u(true);
        if (pendingIntent != null) {
            dVar.pu = pendingIntent;
        } else {
            dVar.pu = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build());
        x.i("MicroMsg.FileDownloadManager", "show notification");
    }

    static boolean cu(long j) {
        return ibM.containsKey(Long.valueOf(j));
    }

    static void q(long j, long j2) {
        ibM.put(Long.valueOf(j), Long.valueOf(j2));
        ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
    }

    static long cv(long j) {
        Long l = (Long) ibM.get(Long.valueOf(j));
        return l == null ? -1 : l.longValue();
    }

    final void k(long j, boolean z) {
        x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), bi.cjd());
        Context context = ad.getContext();
        if (cu(j)) {
            this.ibT.c(j, cm(j).path, z);
            return;
        }
        a cs = c.cs(j);
        if (cs != null) {
            if (bi.oW(cs.field_packageName)) {
                String Td = q.Td(cs.field_filePath);
                if (!bi.oW(Td)) {
                    cs.field_packageName = Td;
                    x.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", cs.field_filePath, Td);
                    c.e(cs);
                }
            }
            x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", cs.field_packageName, cs.field_filePath, Integer.valueOf(q.Te(cs.field_filePath)));
            g.Em().H(new 1(this, cs, r4, context, j, z));
        }
    }

    private void a(String str, e eVar) {
        if (!this.ibV) {
            a yK = c.yK(str);
            if (yK != null && yK.field_autoDownload) {
                gr grVar = new gr();
                grVar.bPR.bPS = str;
                com.tencent.mm.sdk.b.a.sFg.m(grVar);
                if (eVar != null) {
                    yK.field_autoInstall = eVar.ice;
                    yK.field_showNotification = eVar.fHC;
                    yK.field_autoDownload = eVar.icg;
                } else {
                    yK.field_autoInstall = true;
                    yK.field_showNotification = true;
                    yK.field_autoDownload = false;
                }
                c.e(yK);
                x.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", str);
            }
        }
        this.ibV = false;
    }

    private void cw(long j) {
        a cs = c.cs(j);
        if (cs == null) {
            this.ibV = false;
        } else {
            a(cs.field_appId, null);
        }
    }
}
