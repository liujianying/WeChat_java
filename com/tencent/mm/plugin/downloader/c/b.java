package com.tencent.mm.plugin.downloader.c;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dhO, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    public b(e eVar) {
        super(eVar, a.dhO, "FileDownloadInfo", null);
    }

    public final a yK(String str) {
        a aVar = null;
        if (bi.oW(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        return aVar;
    }

    public static String o(ArrayList<String> arrayList) {
        String str = "";
        if (bi.cX(arrayList)) {
            return "1=1";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size() - 1) {
                return str + "appId=\"" + ((String) arrayList.get(arrayList.size() - 1)) + "\"";
            }
            str = str + "appId=\"" + ((String) arrayList.get(i2)) + "\" or ";
            i = i2 + 1;
        }
    }

    public final a cz(long j) {
        a aVar = null;
        if (j < 0) {
            x.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=" + j, new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        return aVar;
    }

    public final boolean aDd() {
        return fV("FileDownloadInfo", "delete from FileDownloadInfo");
    }
}
