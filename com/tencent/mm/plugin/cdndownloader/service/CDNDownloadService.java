package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class CDNDownloadService extends Service implements a {
    private static b hKg;
    private static i.a hKs = new 2();
    private final com.tencent.mm.plugin.cdndownloader.a.a.a hKr = new 1(this);

    static /* synthetic */ void J(String str, int i, int i2) {
        x.i("MicroMsg.CDNDownloadService", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null});
        try {
            hKg.e(str, i, i2, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.CDNDownloadService", "updateDownloadState: " + e);
        }
    }

    static /* synthetic */ void a(i iVar, String str) {
        if (!bi.oW(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                iVar.dQe = new HashMap();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    iVar.dQe.put(str2, jSONObject.optString(str2));
                }
            } catch (JSONException e) {
                x.e("MicroMsg.CDNDownloadService", "addVerifyHeaders: " + e.getMessage());
            }
        }
    }

    static /* synthetic */ void m(String str, long j, long j2) {
        try {
            hKg.k(str, j, j2);
        } catch (RemoteException e) {
            x.e("MicroMsg.CDNDownloadService", "updateProgressChange: " + e);
        }
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.CDNDownloadService", "onBind");
        return this.hKr;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.CDNDownloadService", "onUnbind");
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.CDNDownloadService", "onCreate");
    }

    public void onDestroy() {
        Entry entry;
        String str;
        super.onDestroy();
        x.i("MicroMsg.CDNDownloadService", "onDestroy");
        com.tencent.mm.ipcinvoker.wx_extension.b.b.a.CE().b(this);
        com.tencent.mm.plugin.cdndownloader.b.a aAj = com.tencent.mm.plugin.cdndownloader.b.a.aAj();
        Iterator it = aAj.dOV.entrySet().iterator();
        while (it.hasNext()) {
            entry = (Entry) it.next();
            str = (String) entry.getKey();
            if (((i) entry.getValue()).dQc) {
                aAj.dOV.remove(str);
                aAj.dOX.remove(str);
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra mapWaitTask cancelAllGamePacketDownloadTask mediaid:%s", new Object[]{str});
                it.remove();
            }
        }
        Iterator it2 = aAj.dOW.entrySet().iterator();
        while (it2.hasNext()) {
            entry = (Entry) it2.next();
            str = (String) entry.getKey();
            if (((i) entry.getValue()).dQc) {
                com.tencent.mm.modelcdntran.b.lu(str);
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra mapTaskInJni cancelAllGamePacketDownloadTask mediaid:%s  ret:%d", new Object[]{str, Integer.valueOf(0)});
                it2.remove();
            }
        }
        h.mEJ.a(710, 1, 1, false);
    }
}
