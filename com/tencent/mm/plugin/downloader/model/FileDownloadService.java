package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.b$c;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class FileDownloadService extends IntentService {
    public static final String EXTRA_ID = (icl + "id");
    public static final String EXTRA_PACKAGE_NAME = (icl + "package_name");
    private static final String icl = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String icm = (icl + "action_type");
    public static final String icn = (icl + "file_path");
    public static final String ico = (icl + "md5");
    public static final String icp = (icl + "change_url");

    public FileDownloadService() {
        super("FileDownloadService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[]{Integer.valueOf(intent.getIntExtra(icm, 0))});
            String str;
            String str2;
            String str3;
            a cs;
            switch (intent.getIntExtra(icm, 0)) {
                case 1:
                    long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                    boolean booleanExtra = intent.getBooleanExtra(icp, false);
                    if (longExtra < 0) {
                        x.e("MicroMsg.FileDownloadService", "Invalid id");
                        return;
                    }
                    if (g.Eg().Dx()) {
                        g.Eg();
                        if (!com.tencent.mm.kernel.a.Dr()) {
                            a cs2 = c.cs(longExtra);
                            if (cs2 != null) {
                                x.i("MicroMsg.FileDownloadService", "filePath = " + cs2.field_filePath);
                                d aCU;
                                if (bi.oW(cs2.field_filePath) || !e.cn(cs2.field_filePath)) {
                                    h.mEJ.a(710, 5, 1, false);
                                    cs2.field_status = 4;
                                    cs2.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibq;
                                    c.e(cs2);
                                    aCU = d.aCU();
                                    x.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[]{Long.valueOf(longExtra), Integer.valueOf(com.tencent.mm.plugin.downloader.a.a.ibq)});
                                    if (aCU.ibT != null) {
                                        aCU.ibT.c(longExtra, r1, booleanExtra);
                                    }
                                    x.i("MicroMsg.FileDownloadService", "file not exists, appid = " + cs2.field_appId);
                                    return;
                                } else if (bi.oW(cs2.field_md5)) {
                                    x.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                    cs2.field_status = 3;
                                    c.e(cs2);
                                    d.aCU().k(longExtra, booleanExtra);
                                    return;
                                } else {
                                    str = "";
                                    try {
                                        str = k.E(new File(cs2.field_filePath));
                                    } catch (Exception e) {
                                        x.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                    }
                                    if (co(cs2.field_filePath, cs2.field_md5)) {
                                        cs2.field_status = 3;
                                        cs2.field_channelId = str;
                                        c.e(cs2);
                                        d.aCU().k(longExtra, booleanExtra);
                                        return;
                                    }
                                    if (cs2.field_downloaderType == 3) {
                                        if (cs2.field_downloadUrl.startsWith("https")) {
                                            h.mEJ.a(710, 10, 1, false);
                                        } else {
                                            h.mEJ.a(710, 9, 1, false);
                                        }
                                    } else if (cs2.field_downloadUrl.startsWith("https")) {
                                        h.mEJ.a(710, 7, 1, false);
                                    } else {
                                        h.mEJ.a(710, 6, 1, false);
                                    }
                                    cs2.field_status = 4;
                                    cs2.field_channelId = str;
                                    cs2.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibm;
                                    cs2.field_downloadedSize = (long) e.cm(cs2.field_filePath);
                                    c.e(cs2);
                                    x.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[]{str, Long.valueOf(cs2.field_downloadedSize), Integer.valueOf(e.cm(cs2.field_filePath))});
                                    e.deleteFile(cs2.field_filePath);
                                    str2 = "MicroMsg.FileDownloadService";
                                    str3 = "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(ao.isWifi(this));
                                    objArr[1] = Boolean.valueOf(booleanExtra);
                                    objArr[2] = Boolean.valueOf(!bi.oW(cs2.field_secondaryUrl));
                                    x.i(str2, str3, objArr);
                                    if (!ao.isWifi(this) || booleanExtra || bi.oW(cs2.field_secondaryUrl)) {
                                        aCU = d.aCU();
                                        cs = c.cs(longExtra);
                                        if (cs != null) {
                                            Context context = ad.getContext();
                                            if (cs.field_showNotification && bi.oW(cs.field_fileName)) {
                                                str2 = cs.field_downloadUrl;
                                                d.a(context.getString(b$c.file_downloader_md5check_failed), "", null);
                                            } else if (cs.field_showNotification && !bi.oW(cs.field_fileName)) {
                                                String str4 = cs.field_downloadUrl;
                                                d.a(cs.field_fileName, context.getString(b$c.file_downloader_md5check_failed), null);
                                            }
                                            aCU.ibT.c(longExtra, com.tencent.mm.plugin.downloader.a.a.ibm, booleanExtra);
                                            return;
                                        }
                                        return;
                                    }
                                    long j;
                                    e.a aVar = new e.a();
                                    aVar.yQ(cs2.field_secondaryUrl);
                                    aVar.cx(cs2.field_fileSize);
                                    aVar.yS(cs2.field_fileName);
                                    aVar.setAppId(cs2.field_appId);
                                    aVar.yT(cs2.field_md5);
                                    aVar.ick.ici = true;
                                    aVar.ef(true);
                                    aVar.ox(1);
                                    aVar.cQ(cs2.field_packageName);
                                    if (cs2.field_downloaderType != 3) {
                                        longExtra = d.aCU().a(aVar.ick);
                                        h.mEJ.a(710, 8, 1, false);
                                        j = longExtra;
                                    } else {
                                        longExtra = d.aCU().b(aVar.ick);
                                        h.mEJ.a(710, 11, 1, false);
                                        j = longExtra;
                                    }
                                    x.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + j);
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    x.d("MicroMsg.FileDownloadService", "no user login");
                    return;
                case 3:
                    str = intent.getStringExtra(icn);
                    str2 = intent.getStringExtra(ico);
                    str3 = intent.getStringExtra("appId");
                    if (bi.oW(str) || !e.cn(str)) {
                        x.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                        return;
                    } else if (bi.oW(str2) || co(str, str2)) {
                        cs = c.yK(str3);
                        if (cs == null) {
                            com.tencent.mm.plugin.downloader.e.a.yW(str);
                            return;
                        } else if (com.tencent.mm.plugin.downloader.e.a.yW(str)) {
                            com.tencent.mm.plugin.downloader.e.a.a(str3, cs.field_scene, cs.field_downloadId, cs.field_channelId);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private static boolean co(String str, String str2) {
        File file = new File(str);
        x.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", new Object[]{str, Boolean.valueOf(file.exists())});
        long currentTimeMillis = System.currentTimeMillis();
        String m = com.tencent.mm.a.g.m(file);
        x.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        x.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", new Object[]{str2, m});
        if (bi.oW(str2)) {
            return file.exists();
        }
        if (!bi.oW(m)) {
            return str2.equalsIgnoreCase(m);
        }
        x.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
        return file.exists();
    }
}
