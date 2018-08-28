package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.xweb.b.a {
    private static a hKu = null;
    private com.tencent.mm.modelcdntran.i.a hKs = new 1(this);
    private Map<String, a> hKv = new ConcurrentHashMap();

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        x.i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(aVar.hKv.containsKey(str))});
        if (aVar.hKv.containsKey(str)) {
            b bVar = ((a) aVar.hKv.get(str)).hKx;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else if (i == 3) {
                bVar.u(str, ((a) aVar.hKv.get(str)).hKy, z);
            } else {
                bVar.s(str, i2, z);
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, long j, long j2) {
        x.d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(aVar.hKv.containsKey(str))});
        if (aVar.hKv.containsKey(str)) {
            b bVar = ((a) aVar.hKv.get(str)).hKx;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else {
                bVar.y(str, j, j2);
            }
        }
    }

    public static synchronized a aAr() {
        a aVar;
        synchronized (a.class) {
            if (hKu == null) {
                hKu = new a();
            }
            com.tencent.mm.plugin.cdndownloader.b.a.aAj();
            aVar = hKu;
        }
        return aVar;
    }

    public final int a(String str, String str2, b bVar) {
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", new Object[]{str, str2});
        i iVar = new i();
        iVar.field_mediaId = str;
        iVar.field_fullpath = str2;
        iVar.dPW = str;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOz;
        iVar.dPV = this.hKs;
        iVar.dPX = 60;
        iVar.dPY = 600;
        iVar.dQa = false;
        a aVar = new a(this, (byte) 0);
        aVar.hKx = bVar;
        aVar.hKy = str2;
        this.hKv.put(str, aVar);
        int d = com.tencent.mm.plugin.cdndownloader.b.a.aAj().d(iVar);
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: " + d);
        return d;
    }
}
