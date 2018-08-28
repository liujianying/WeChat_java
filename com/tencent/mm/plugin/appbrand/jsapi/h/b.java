package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.k.a.1;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b extends a {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    static /* synthetic */ AppBrandLocalMediaObject D(String str, String str2, String str3) {
        String Tu = s.Tu(str3);
        if (bi.oW(Tu) && "audio/mp4".equals(str3)) {
            Tu = "mp4";
        }
        return AppBrandLocalMediaObjectManager.attach(str, str2, Tu, false);
    }

    static /* synthetic */ boolean a(l lVar, String str) {
        a uI = com.tencent.mm.plugin.appbrand.k.b.alr().uI(lVar.mAppId);
        if (uI == null || !uI.uG(str)) {
            return false;
        }
        x.i("MicroMsg.JsApiCreateDownloadTask", "download abort %s", new Object[]{str});
        return true;
    }

    protected final String ajr() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.appbrand.k.b.alr();
        return stringBuilder.append(com.tencent.mm.plugin.appbrand.k.b.alq()).toString();
    }

    protected final String ajs() {
        return "downloadTaskId";
    }

    public final void a(l lVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
        1 1 = new 1(this, jSONObject.optString("filePath"), lVar, str, lVar.mAppId);
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        com.tencent.mm.plugin.appbrand.config.a aVar = lVar.fdO.fcv;
        Map a = i.a(jSONObject, appBrandSysConfig);
        String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(optString)) {
            x.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
            a(lVar, str, "url is null or nil");
            return;
        }
        boolean z;
        boolean a2;
        int optInt;
        a uI;
        a aVar2;
        if (i.c(lVar.fdO.fct)) {
            if (jSONObject.optBoolean("__skipDomainCheck__")) {
                z = true;
                a2 = i.a(appBrandSysConfig, z);
                if (a2 || i.b(appBrandSysConfig.frg, optString)) {
                    int i;
                    if (appBrandSysConfig.fqV <= 0) {
                        x.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
                    }
                    optInt = jSONObject.optInt("timeout", 0);
                    if (optInt <= 0) {
                        optInt = i.a(appBrandSysConfig, aVar, 3);
                    }
                    if (optInt <= 0) {
                        i = optInt;
                    } else {
                        i = 60000;
                    }
                    uI = com.tencent.mm.plugin.appbrand.k.b.alr().uI(lVar.mAppId);
                    if (uI != null) {
                        p d = d(lVar);
                        String str2 = null;
                        if (!(d == null || d.gns == null)) {
                            str2 = d.gns.getUserAgentString();
                        }
                        a aVar3 = new a(lVar.mAppId, str2, lVar.fdO.fcu);
                        com.tencent.mm.plugin.appbrand.k.b alr = com.tencent.mm.plugin.appbrand.k.b.alr();
                        String str3 = lVar.mAppId;
                        if (!alr.fNX.containsKey(str3)) {
                            alr.fNX.put(str3, aVar3);
                        }
                        aVar2 = aVar3;
                    } else {
                        aVar2 = uI;
                    }
                    if (aVar2 != null) {
                        int i2;
                        x.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(i)});
                        if (lVar.fdO.aaq()) {
                            i2 = lVar.fdO.fcu.frn.fpU;
                        } else {
                            i2 = lVar.fdO.fcu.frn.fpH;
                        }
                        ArrayList arrayList = a2 ? appBrandSysConfig.frg : null;
                        String str4 = NAME;
                        optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                        synchronized (aVar2.gkG) {
                            if (aVar2.gkG.size() >= aVar2.gkB) {
                                1.tQ("max_connected");
                                x.i("MicroMsg.AppBrandNetworkDownload", "max connected");
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.k.a.b bVar = new com.tencent.mm.plugin.appbrand.k.a.b(aVar2.mAppId, optString, aVar2.gkC + ac.ce(optString) + "temp", aVar2.gkE, new 1(aVar2, str, 1));
                            bVar.glA = a;
                            bVar.dkb = i;
                            bVar.bgH = true;
                            bVar.gkY = arrayList;
                            bVar.glB = i2;
                            bVar.gkD = aVar2.gkD;
                            bVar.fEl = str;
                            bVar.glc = str4;
                            synchronized (aVar2.gkG) {
                                aVar2.gkG.add(bVar);
                            }
                            e.post(bVar, "appbrand_download_thread");
                        }
                    }
                }
                x.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", new Object[]{optString});
                a(lVar, str, "url not in domain list");
                return;
            }
        }
        z = false;
        a2 = i.a(appBrandSysConfig, z);
        if (a2) {
        }
        if (appBrandSysConfig.fqV <= 0) {
            x.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
        }
        optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 3);
        }
        if (optInt <= 0) {
            i = 60000;
        } else {
            i = optInt;
        }
        uI = com.tencent.mm.plugin.appbrand.k.b.alr().uI(lVar.mAppId);
        if (uI != null) {
            aVar2 = uI;
        } else {
            p d2 = d(lVar);
            String str22 = null;
            if (!(d2 == null || d2.gns == null)) {
                str22 = d2.gns.getUserAgentString();
            }
            a aVar32 = new a(lVar.mAppId, str22, lVar.fdO.fcu);
            com.tencent.mm.plugin.appbrand.k.b alr2 = com.tencent.mm.plugin.appbrand.k.b.alr();
            String str32 = lVar.mAppId;
            if (!alr2.fNX.containsKey(str32)) {
                alr2.fNX.put(str32, aVar32);
            }
            aVar2 = aVar32;
        }
        if (aVar2 != null) {
            int i22;
            x.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(i)});
            if (lVar.fdO.aaq()) {
                i22 = lVar.fdO.fcu.frn.fpU;
            } else {
                i22 = lVar.fdO.fcu.frn.fpH;
            }
            ArrayList arrayList2 = a2 ? appBrandSysConfig.frg : null;
            String str42 = NAME;
            optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            synchronized (aVar2.gkG) {
                if (aVar2.gkG.size() >= aVar2.gkB) {
                    1.tQ("max_connected");
                    x.i("MicroMsg.AppBrandNetworkDownload", "max connected");
                    return;
                }
                com.tencent.mm.plugin.appbrand.k.a.b bVar2 = new com.tencent.mm.plugin.appbrand.k.a.b(aVar2.mAppId, optString, aVar2.gkC + ac.ce(optString) + "temp", aVar2.gkE, new 1(aVar2, str, 1));
                bVar2.glA = a;
                bVar2.dkb = i;
                bVar2.bgH = true;
                bVar2.gkY = arrayList2;
                bVar2.glB = i22;
                bVar2.gkD = aVar2.gkD;
                bVar2.fEl = str;
                bVar2.glc = str42;
                synchronized (aVar2.gkG) {
                    aVar2.gkG.add(bVar2);
                }
                e.post(bVar2, "appbrand_download_thread");
            }
        }
    }

    private static void a(l lVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new a().a(lVar);
        a.mData = jSONObject;
        a.ahM();
    }
}
