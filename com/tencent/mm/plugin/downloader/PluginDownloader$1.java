package com.tencent.mm.plugin.downloader;

import android.database.Cursor;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class PluginDownloader$1 implements Runnable {
    final /* synthetic */ PluginDownloader ibb;

    PluginDownloader$1(PluginDownloader pluginDownloader) {
        this.ibb = pluginDownloader;
    }

    public final void run() {
        Object obj = null;
        b FX = c.FX();
        if (FX != null) {
            x.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
            Cursor rawQuery = FX.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
            if (rawQuery == null) {
                x.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
            } else {
                obj = new LinkedList();
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.d(rawQuery);
                    obj.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (!bi.cX(obj)) {
            Iterator it = obj.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                x.i("MicroMsg.PluginDownloader", "download fail, appId: " + aVar2.field_appId);
                aVar2.field_status = 4;
                aVar2.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibk;
                c.e(aVar2);
                d aCU = d.aCU();
                long j = aVar2.field_downloadId;
                int i = aVar2.field_errCode;
                if (aCU.ibT != null) {
                    aCU.ibT.c(j, i, false);
                }
            }
        }
    }
}
