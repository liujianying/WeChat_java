package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    public static int fIS = 0;
    private String fPn;
    private String fPo;
    private String fPp;
    private String fPq;
    private boolean fPr;
    private String fPs;
    private boolean fPt;
    private String sessionFrom;

    private interface a {
        void a(boolean z, String str, Intent intent);
    }

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        a(pVar, jSONObject, new a() {
            public final void a(boolean z, String str, Intent intent) {
                x.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    Map hashMap = new HashMap();
                    Object obj = "";
                    Object hashMap2 = new HashMap();
                    if (intent != null) {
                        String aG = bi.aG(intent.getStringExtra("keyOutPagePath"), "");
                        obj = l.vP(aG);
                        hashMap2 = l.vQ(aG);
                    }
                    hashMap.put("path", obj);
                    hashMap.put("query", hashMap2);
                    x.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[]{obj, hashMap2.toString()});
                    pVar.E(i, c.this.f("ok", hashMap));
                    return;
                }
                pVar.E(i, c.this.f(str, null));
            }
        });
    }

    public final void a(com.tencent.mm.plugin.appbrand.l lVar, JSONObject jSONObject, int i) {
        p d = e.d(lVar);
        if (d == null) {
            x.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
            lVar.E(i, f("fail:current page do not exist", null));
            return;
        }
        a(d, jSONObject, new 2(this, lVar, i));
    }

    private void a(p pVar, JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
            return;
        }
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig == null) {
            x.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
            aVar.a(false, "fail:config is null", null);
            return;
        }
        this.sessionFrom = jSONObject.optString("sessionFrom");
        if (this.sessionFrom.length() > 1024) {
            this.sessionFrom = this.sessionFrom.substring(0, 1024);
            x.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        this.fPn = jSONObject.optString("businessId");
        this.fPo = jSONObject.optString("sendMessageTitle");
        this.fPp = jSONObject.optString("sendMessagePath");
        this.fPq = jSONObject.optString("sendMessageImg");
        this.fPr = jSONObject.optBoolean("showMessageCard", false);
        this.fPt = k.tY(this.fPq);
        this.fPs = k.a(pVar, this.fPq, true);
        if (bi.oW(this.fPn)) {
            x.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            a(pVar, appBrandSysConfig, "", aVar);
            return;
        }
        x.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        if (appBrandSysConfig == null || bi.oW(appBrandSysConfig.bGy)) {
            x.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
            aVar.a(false, "fail", null);
            return;
        }
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIG = new aic();
        aVar2.dIH = new aid();
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar2.dIF = 1303;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        b KT = aVar2.KT();
        aic aic = (aic) KT.dID.dIL;
        aic.username = appBrandSysConfig.bGy;
        aic.rKT = this.fPn;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 3(this, aVar, pVar, appBrandSysConfig));
    }

    private void a(p pVar, AppBrandSysConfig appBrandSysConfig, String str, a aVar) {
        JsApiChattingTask jsApiChattingTask = new JsApiChattingTask();
        com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar2 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
        aVar2.appId = pVar.mAppId;
        aVar2.username = appBrandSysConfig.bGy;
        aVar2.nickname = appBrandSysConfig.bKC;
        aVar2.iconUrl = appBrandSysConfig.fqJ;
        aVar2.fih = appBrandSysConfig.frm.fih;
        aVar2.fii = appBrandSysConfig.frm.fii;
        aVar2.fso = appBrandSysConfig.frm.bKg;
        aVar2.bJu = 5;
        String str2 = "";
        if (pVar != null) {
            str2 = pVar.getURL();
        }
        x.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[]{str2});
        aVar2.bVs = str2;
        aVar2.fsp = n.qz(pVar.mAppId);
        str2 = appBrandSysConfig.bGy;
        if (!bi.oW(str)) {
            str2 = str;
        } else if (bi.oW(str2)) {
            x.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str2 = "";
        }
        jsApiChattingTask.username = str2;
        str2 = appBrandSysConfig.bKC;
        if (!bi.oW(str)) {
            str2 = "";
        } else if (bi.oW(str2)) {
            x.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str2 = "";
        }
        jsApiChattingTask.nickname = str2;
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.fFC = new 4(this, jsApiChattingTask, aVar2, pVar, aVar);
        jsApiChattingTask.ahA();
        AppBrandMainProcessService.a(jsApiChattingTask);
    }
}
