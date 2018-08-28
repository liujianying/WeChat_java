package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c {
    public static a cs(long j) {
        b FX = FX();
        if (FX == null) {
            return null;
        }
        return FX.cz(j);
    }

    public static a yK(String str) {
        b FX = FX();
        if (FX == null) {
            return null;
        }
        return FX.yK(str);
    }

    public static long d(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b FX = FX();
        if (FX == null) {
            return -1;
        }
        x.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + FX.b(aVar));
        return aVar.field_downloadId;
    }

    public static long e(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b FX = FX();
        if (FX == null) {
            return -1;
        }
        boolean c = FX.c(aVar, new String[0]);
        x.d("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(c), Integer.valueOf(aVar.field_status));
        return aVar.field_downloadId;
    }

    public static boolean k(long j, int i) {
        b FX = FX();
        if (FX == null) {
            return false;
        }
        return FX.fV("FileDownloadInfo", "update FileDownloadInfo set status = " + i + " where downloadId = " + j);
    }

    public static boolean yL(String str) {
        b FX = FX();
        if (FX == null) {
            return false;
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            return false;
        }
        return FX.fV("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
    }

    public static boolean yM(String str) {
        b FX = FX();
        if (FX == null) {
            return false;
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            return false;
        }
        return FX.fV("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
    }

    public static a yN(String str) {
        a aVar = null;
        b FX = FX();
        if (FX != null) {
            if (bi.oW(str)) {
                x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            } else {
                Cursor rawQuery = FX.rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
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
        }
        return aVar;
    }

    public static boolean ct(long j) {
        b FX = FX();
        if (FX == null) {
            return false;
        }
        a aVar = new a();
        aVar.field_downloadId = j;
        return FX.a(aVar, new String[0]);
    }

    public static LinkedList<a> aCS() {
        b FX = FX();
        if (FX == null) {
            return null;
        }
        String str = "select * from FileDownloadInfo where status=1 and downloadInWifi=1";
        x.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = " + str);
        Cursor rawQuery = FX.rawQuery(str, new String[0]);
        LinkedList<a> linkedList = new LinkedList();
        if (rawQuery == null) {
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.d(rawQuery);
            linkedList.add(aVar);
        }
        rawQuery.close();
        return linkedList;
    }

    public static LinkedList<a> aCT() {
        b FX = FX();
        if (FX == null) {
            return null;
        }
        String str = "select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1";
        x.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = " + str);
        Cursor rawQuery = FX.rawQuery(str, new String[0]);
        LinkedList<a> linkedList = new LinkedList();
        if (rawQuery == null) {
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.d(rawQuery);
            linkedList.add(aVar);
        }
        rawQuery.close();
        return linkedList;
    }

    public static b FX() {
        if (g.Eg().Dx()) {
            g.Eg();
            if (!com.tencent.mm.kernel.a.Dr()) {
                if (g.l(com.tencent.mm.plugin.downloader.a.c.class) != null) {
                    return ((com.tencent.mm.plugin.downloader.a.c) g.l(com.tencent.mm.plugin.downloader.a.c.class)).FX();
                }
                x.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                return null;
            }
        }
        x.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        return null;
    }
}
