package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class m$a extends BroadcastReceiver {
    private m$a() {
    }

    /* synthetic */ m$a(byte b) {
        this();
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            x.i("MicroMsg.GameInstallationReceiver", action);
            if (bi.oW(action)) {
                x.e("MicroMsg.GameInstallationReceiver", "action is null or nill, ignore");
            } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                action = "";
                try {
                    action = intent.getDataString();
                } catch (Throwable e) {
                    x.e("MicroMsg.GameInstallationReceiver", "%s", new Object[]{bi.i(e)});
                }
                x.i("MicroMsg.GameInstallationReceiver", "get added package name : %s", new Object[]{action});
                if (bi.oW(action)) {
                    x.e("MicroMsg.GameInstallationReceiver", "get installed broadcast, while the package name is null or nil");
                    return;
                }
                String substring;
                if (action.startsWith("package:")) {
                    substring = action.substring(8);
                } else {
                    substring = action;
                }
                if (!g.Eg().Dx() || a.Dr()) {
                    x.e("MicroMsg.GameInstallationReceiver", "no user login");
                    return;
                }
                com.tencent.mm.plugin.downloader.c.a aVar;
                b FX = ((c) g.l(c.class)).FX();
                if (bi.oW(substring)) {
                    x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                    aVar = null;
                } else {
                    Cursor rawQuery = FX.rawQuery("select * from FileDownloadInfo where packageName='" + substring + "' order by downloadId desc limit 1", new String[0]);
                    if (rawQuery == null) {
                        aVar = null;
                    } else {
                        com.tencent.mm.plugin.downloader.c.a aVar2 = null;
                        if (rawQuery.moveToFirst()) {
                            aVar2 = new com.tencent.mm.plugin.downloader.c.a();
                            aVar2.d(rawQuery);
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        aVar = aVar2;
                    }
                }
                if (aVar == null) {
                    x.e("MicroMsg.GameInstallationReceiver", "No AppInfo found for package: %s", new Object[]{substring});
                } else if (aVar.field_status == 3) {
                    if (e.cn(aVar.field_filePath)) {
                        e.deleteFile(aVar.field_filePath);
                    }
                    com.tencent.mm.plugin.downloader.model.c.yM(aVar.field_appId);
                    if (!bi.oW(aVar.field_appId)) {
                        an.a(aVar.field_appId, aVar.field_scene, 5, aVar.field_startSize, aVar.field_downloadedSize - aVar.field_startSize, aVar.field_totalSize, aVar.field_downloadUrl, 0, aVar.field_downloaderType, aVar.field_channelId, (System.currentTimeMillis() - aVar.field_startTime) / 1000, aVar.field_startState, aVar.field_downloadId, aVar.field_extInfo);
                    }
                    h.mEJ.a(860, 8, 1, false);
                    m.c cVar = (m.c) m.aTS().get(aVar.field_downloadUrl);
                    if (cVar == null) {
                        an.a(aVar.field_appId, aVar.field_scene, 5, aVar.field_md5, aVar.field_downloadUrl, "", aVar.field_extInfo);
                        return;
                    }
                    if (bi.oW(cVar.bJv)) {
                        cVar.bJv = m.b(cVar);
                    }
                    an.a(cVar.appId, cVar.scene, 5, cVar.bKg, aVar.field_downloadUrl, cVar.jLY, cVar.bJv);
                }
            }
        }
    }
}
