package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class m implements l {
    private static m jLS = null;
    private static BroadcastReceiver jLT = null;
    private static Set<b> jLU = Collections.synchronizedSet(new HashSet());
    private static HashMap<String, c> jLV = new HashMap();

    private m() {
    }

    public static m aTQ() {
        if (jLS == null) {
            jLS = new m();
        }
        return jLS;
    }

    public static void a(b bVar) {
        synchronized (jLU) {
            jLU.add(bVar);
        }
    }

    public static void b(b bVar) {
        synchronized (jLU) {
            jLU.remove(bVar);
            x.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[]{Integer.valueOf(jLU.size()), bVar});
        }
    }

    public static void aDb() {
        if (jLS == null) {
            jLS = new m();
        }
        if (jLT == null) {
            jLT = new a((byte) 0);
        }
        d.aCU();
        b.a(jLS);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        ad.getContext().registerReceiver(jLT, intentFilter);
    }

    public static void aDc() {
        d.aCU();
        b.b(jLS);
        ad.getContext().unregisterReceiver(jLT);
        jLS = null;
        jLU.clear();
        jLV.clear();
    }

    private void w(long j, int i) {
        a cs = c.cs(j);
        if (cs != null) {
            c cVar = (c) jLV.get(cs.field_downloadUrl);
            int i2 = 0;
            switch (i) {
                case 1:
                    h.mEJ.a(860, 0, 1, false);
                    if (cVar != null) {
                        if (!cVar.jLZ) {
                            h.mEJ.a(860, 2, 1, false);
                            i2 = 1;
                            break;
                        }
                        h.mEJ.a(860, 1, 1, false);
                        i2 = 1;
                        break;
                    }
                    i2 = 1;
                    break;
                case 2:
                    h.mEJ.a(860, 3, 1, false);
                    i2 = 6;
                    break;
                case 3:
                    h.mEJ.a(860, 6, 1, false);
                    i2 = 3;
                    break;
                case 4:
                    h.mEJ.a(860, 5, 1, false);
                    i2 = 2;
                    break;
                case 5:
                    h.mEJ.a(860, 7, 1, false);
                    i2 = 8;
                    break;
                case 6:
                    break;
                case 7:
                    h.mEJ.a(860, 4, 1, false);
                    i2 = 7;
                    break;
            }
            if (!bi.oW(cs.field_appId)) {
                an.a(cs.field_appId, cs.field_scene, i2, cs.field_startSize, cs.field_downloadedSize - cs.field_startSize, cs.field_totalSize, cs.field_downloadUrl, cs.field_errCode, cs.field_downloaderType, cs.field_channelId, (System.currentTimeMillis() - cs.field_startTime) / 1000, cs.field_startState, cs.field_downloadId, cs.field_extInfo);
                if (cs.field_status == 2 || cs.field_status == 5 || cs.field_status == 4 || cs.field_status == 3 || cs.field_status == 0) {
                    long j2 = cs.field_downloadId;
                    x.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
                    SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("download_pref", 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().remove(String.valueOf(j2)).apply();
                    }
                }
            }
            if (cVar == null) {
                an.a(cs.field_appId, cs.field_scene, i2, cs.field_md5, cs.field_downloadUrl, "", cs.field_extInfo);
            } else {
                if (bi.oW(cVar.bJv)) {
                    cVar.bJv = a(cVar);
                }
                an.a(cVar.appId, cVar.scene, i2, cVar.bKg, cs.field_downloadUrl, cVar.jLY, cVar.bJv);
            }
            ah.A(new 1(this, i, cs.field_appId));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        if (!bi.oW(str)) {
            c cVar = new c(str2, i, str3, "", str4);
            cVar.jLZ = true;
            jLV.put(str, cVar);
        }
    }

    public static void j(String str, String str2, String str3, String str4) {
        if (!bi.oW(str)) {
            jLV.put(str, new c(str2, 1002, str3, "", str4));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        if (!bi.oW(str)) {
            jLV.put(str, new c(str2, i, str3, str4, str5));
        }
    }

    public final void onTaskStarted(long j, String str) {
        w(j, 1);
    }

    public final void b(long j, String str, boolean z) {
        x.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[]{str, Boolean.valueOf(e.cn(str))});
        if (bi.oW(str) || !e.cn(str)) {
            c.k(j, 4);
            b(j, com.tencent.mm.plugin.downloader.a.a.ibp, z);
            h.mEJ.a(860, 9, 1, false);
            return;
        }
        w(j, 3);
        if (z) {
            a cs = c.cs(j);
            if (cs != null) {
                String str2 = cs.field_appId;
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSh();
                y.b(str2, 5, 0, null, null);
            }
        }
        dG(j);
    }

    public final void b(long j, int i, boolean z) {
        a cs = c.cs(j);
        if (cs == null || !cs.field_downloadInWifi || ao.isWifi(ad.getContext())) {
            w(j, 5);
            a cs2 = c.cs(j);
            if (cs2 != null) {
                String str = null;
                if (i == com.tencent.mm.plugin.downloader.a.a.ibm) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ChannelId", cs2.field_channelId);
                        jSONObject.put("DownloadSize", cs2.field_downloadedSize);
                        str = an.Dx(jSONObject.toString());
                        x.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                    } catch (Exception e) {
                        x.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                    }
                }
                a(cs2.field_appId, i, z, str);
            }
            dG(j);
            return;
        }
        x.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
        an.a(cs.field_appId, cs.field_scene, 12, cs.field_startSize, cs.field_downloadedSize - cs.field_startSize, cs.field_totalSize, cs.field_downloadUrl, cs.field_errCode, cs.field_downloaderType, cs.field_channelId, (System.currentTimeMillis() - cs.field_startTime) / 1000, cs.field_startState, cs.field_downloadId, cs.field_extInfo);
    }

    public final void onTaskRemoved(long j) {
        w(j, 4);
        a cs = c.cs(j);
        if (cs != null) {
            f.aj(ad.getContext(), cs.field_appId);
        }
    }

    public final void onTaskPaused(long j) {
        w(j, 2);
    }

    public final void bP(long j) {
        w(j, 6);
    }

    public final void h(long j, String str) {
        w(j, 7);
    }

    private static String a(c cVar) {
        a yK = c.yK(cVar.appId);
        if (yK == null) {
            return null;
        }
        if (yK.field_downloaderType == 1) {
            return "downloader_type_system";
        }
        return "downloader_type_tmassistant";
    }

    public static void a(String str, int i, boolean z, String str2) {
        if (i == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_NO_ENOUGH_SPACE || i == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_SDCARD_EXCEPTION) {
            i = com.tencent.mm.plugin.downloader.a.a.ibo;
        }
        x.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[]{str, Integer.valueOf(i)});
        if (z) {
            ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSh();
            y.b(str, 4, i, null, str2);
            return;
        }
        ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSh();
        y.b(str, 2, i, null, str2);
    }

    public static void cZ(String str, String str2) {
        ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSh();
        y.b(str, 6, 0, null, str2);
    }

    private static void dG(long j) {
        a cs = c.cs(j);
        if (cs == null) {
            x.i("MicroMsg.ReportDownloadAppState", "report, info is null");
        } else if (!cs.field_fromWeApp) {
            x.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
        } else if (cs.field_status != 3 || e.cn(cs.field_filePath)) {
            bgh bgh = new bgh();
            bgh.jQb = cs.field_appId;
            if (cs.field_status == 3) {
                bgh.hcd = a$a.jFZ;
            } else if (cs.field_status == 4) {
                bgh.hcd = a$a.DOWNLOAD_STATUS_FAILED;
            }
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIF = 2683;
            aVar.uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
            aVar.dIG = bgh;
            aVar.dIH = new bgi();
            aVar.dII = 0;
            aVar.dIJ = 0;
            v.a(aVar.KT(), new a$1());
        } else {
            x.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
        }
    }
}
