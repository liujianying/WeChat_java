package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.mm.R;
import com.tencent.mm.ac.z;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.webview.c.a;
import com.tencent.mm.plugin.webview.fts.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.modelcache.q.5;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.bag.l.a.1;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.72;
import com.tencent.mm.pluginsdk.o$a;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

class WebViewStubService$1 extends d$a {
    final /* synthetic */ WebViewStubService pUR;

    WebViewStubService$1(WebViewStubService webViewStubService) {
        this.pUR = webViewStubService;
    }

    public final void r(int i, Bundle bundle) {
        a bUS = e.bUS();
        Map hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.get(str));
        }
        switch (i) {
            case 1:
                bUS.W(hashMap);
                return;
            default:
                x.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    public final void j(int i, Bundle bundle) {
        d bUU = e.bUU();
        switch (i) {
            case 1:
                bUU.pOv.remove(Integer.valueOf(bundle.getInt("webview_id")));
                d.e eVar = bUU.pOB;
                if (!(!eVar.pOV) || bi.oW(eVar.bWm)) {
                    x.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", new Object[]{eVar.bWm});
                } else {
                    x.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", new Object[]{Boolean.valueOf(eVar.pOV), eVar.bWm, Boolean.valueOf(eVar.bHx), Boolean.valueOf(eVar.ozk), Integer.valueOf(eVar.jtk)});
                    ad.a(eVar.scene, eVar.bWm, eVar.ozk, eVar.bHx, eVar.jtk);
                    eVar.pOV = true;
                }
                x.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", new Object[]{Integer.valueOf(r4)});
                return;
            case 3:
                if (bUU.jsw != null) {
                    ((n) g.n(n.class)).cancelSearchTask(bUU.jsw);
                }
                i iVar = new i();
                iVar.bWm = bundle.getString("query");
                iVar.jss = bundle.getInt("count");
                iVar.jsv = bUU.lUA;
                iVar.jst.add("notifymessage");
                bUU.jsw = ((n) g.n(n.class)).search(8, iVar);
                bUU.jsw.jrq = Integer.valueOf(bundle.getInt("webview_id"));
                j jVar = new j();
                jVar.scene = bundle.getInt("scene");
                jVar.bHt = bundle.getString("query");
                jVar.pKO = 1;
                jVar.bWo = bundle.getInt("webview_id");
                if (bUU.pOy != null) {
                    au.DF().c(bUU.pOy);
                }
                bUU.pOy = new com.tencent.mm.plugin.webview.fts.g(jVar);
                au.DF().a(1161, bUU);
                au.DF().a(bUU.pOy, 0);
                return;
            case 5:
                ((n) g.n(n.class)).deleteSOSHistory(bundle.getString("history"));
                return;
            default:
                return;
        }
    }

    public final Bundle p(int i, Bundle bundle) {
        e.bUU();
        return d.p(i, bundle);
    }

    public final String gT(String str) {
        au.HU();
        return c.FR().Yg(str).BK();
    }

    public final boolean he(String str) {
        return s.he(str);
    }

    public final boolean hO(String str) {
        return s.hO(str);
    }

    public final boolean hf(String str) {
        boolean HX = au.HX();
        x.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + HX);
        if (HX) {
            return s.hf(str);
        }
        return false;
    }

    public final boolean zZ() {
        return f.zZ();
    }

    public final boolean aSn() {
        return au.HX();
    }

    @Deprecated
    public final void a(int i, Bundle bundle, int i2) {
        x.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        WebViewStubService.f(this.pUR).post(new 1(this, i, bundle, i2));
    }

    public final b S(Bundle bundle) {
        boolean a;
        WebViewStubService$a webViewStubService$a = new WebViewStubService$a();
        long j = bundle.getLong("msg_id", Long.MIN_VALUE);
        String string = bundle.getString("sns_local_id");
        int i = bundle.getInt("news_svr_id", 0);
        String string2 = bundle.getString("news_svr_tweetid");
        ch chVar = new ch();
        if (Long.MIN_VALUE != j) {
            chVar.bJF.bJJ = bundle.getInt("message_index", 0);
            a = com.tencent.mm.pluginsdk.model.e.a(chVar, j);
        } else if (!bi.oW(string)) {
            qs qsVar = new qs();
            qsVar.cbk.cbn = string;
            qsVar.cbk.cbo = chVar;
            qsVar.cbk.url = bundle.getString("rawUrl");
            qsVar.cbk.cbm = true;
            com.tencent.mm.sdk.b.a.sFg.m(qsVar);
            a = qsVar.cbl.bJm;
        } else if (i != 0) {
            mk mkVar = new mk();
            mkVar.bXl.opType = 3;
            mkVar.bXl.bXn = chVar;
            mkVar.bXl.bXo = i;
            mkVar.bXl.bXp = string2;
            com.tencent.mm.sdk.b.a.sFg.m(mkVar);
            a = mkVar.bXm.bJm;
        } else {
            webViewStubService$a.jHV = true;
            return webViewStubService$a;
        }
        if (a) {
            string = bi.oV(bundle.getString("prePublishId"));
            String ic = u.ic(string);
            b v = u.Hx().v(ic, true);
            v.p("sendAppMsgScene", Integer.valueOf(2));
            v.p("preChatName", bundle.getString("preChatName"));
            v.p("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
            v.p("prePublishId", string);
            v.p("preUsername", bundle.getString("preUsername"));
            v.p("getA8KeyScene", bundle.getString("getA8KeyScene"));
            v.p("referUrl", bundle.getString("referUrl"));
            Bundle bundle2 = bundle.getBundle("jsapiargs");
            if (bundle2 != null) {
                v.p("adExtStr", bundle2.getString("key_snsad_statextstr"));
            }
            chVar.bJF.bJK = ic;
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
        } else {
            if (chVar.bJF.bJL == 0) {
                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
            }
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
        }
        webViewStubService$a.ret = chVar.bJG.ret;
        return webViewStubService$a;
    }

    public final String QO(String str) {
        return com.tencent.mm.aa.c.A(str, false);
    }

    public final boolean isSDCardAvailable() {
        au.HU();
        return c.isSDCardAvailable();
    }

    public final int ej(int i, int i2) {
        au.HU();
        return bi.a((Integer) c.DT().get(i, null), i2);
    }

    public final void ek(int i, int i2) {
        WebViewStubService.f(this.pUR).post(new 3(this, i, i2));
    }

    public final String aU(int i, String str) {
        au.HU();
        return bi.aG((String) c.DT().get(i, null), str);
    }

    public final boolean s(int i, Bundle bundle) {
        x.i("MicroMsg.WebViewStubService", "doScene, type = %d", new Object[]{Integer.valueOf(i)});
        String string;
        switch (i) {
            case 233:
                if (aSn()) {
                    string = bundle.getString("geta8key_data_req_url");
                    if (!bi.oW(bundle.getString("k_share_url"))) {
                        al.fn(string, bundle.getString("k_share_url"));
                    }
                    h hVar = !bi.oW(string) ? new h(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie")) : new h(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                    hVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    return au.DF().a(hVar, 0);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            case 666:
                if (aSn()) {
                    return WebViewStubService.R(bundle);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            case 673:
                if (aSn()) {
                    k kVar = new k(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                    kVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    return au.DF().a(kVar, 0);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            case 1254:
                if (aSn()) {
                    com.tencent.mm.plugin.webview.model.s sVar = new com.tencent.mm.plugin.webview.model.s(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene"));
                    sVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    return au.DF().a(sVar, 0);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            case 1295:
                if (!aSn()) {
                    x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                } else if (bundle == null) {
                    return false;
                } else {
                    x.d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", new Object[]{bundle.getString("ad_report_data_str")});
                    ((com.tencent.mm.plugin.sns.b.a) g.l(com.tencent.mm.plugin.sns.b.a.class)).g(13791, string, (int) bi.VE());
                    return true;
                }
            case 1373:
                if (aSn()) {
                    String string2 = bundle.getString("oauth_url");
                    int i2 = bundle.getInt("opt");
                    LinkedList linkedList = new LinkedList(bundle.getStringArrayList("scopes"));
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i3 = 0; i3 < linkedList.size(); i3++) {
                        stringBuilder.append((String) linkedList.get(i3)).append(",");
                    }
                    x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", new Object[]{stringBuilder.toString()});
                    t tVar = new t(string2, i2, linkedList);
                    tVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                    return au.DF().a(tVar, 0);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            case 2836:
                if (aSn()) {
                    return WebViewStubService.a(this.pUR, bundle);
                }
                x.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                return false;
            default:
                x.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", new Object[]{Integer.valueOf(i)});
                return false;
        }
    }

    public final boolean MN() {
        return com.tencent.mm.ac.f.MN();
    }

    public final List<String> MM() {
        List<String> MM = com.tencent.mm.ac.f.MM();
        List<String> linkedList = new LinkedList();
        for (String str : MM) {
            if (!com.tencent.mm.ac.f.kK(str)) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    public final void g(int i, List<String> list) {
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        com.tencent.mm.plugin.report.service.h.e(i, list);
    }

    public final boolean a(String str, boolean z, Bundle bundle) {
        return p.a.qyl.a(this.pUR, str, z, bundle);
    }

    public final String QP(String str) {
        if (o$a.qyj != null) {
            return o$a.qyj.t(this.pUR, str);
        }
        return null;
    }

    public final void cw(String str, int i) {
        new Bundle().putInt("webview_binder_id", i);
        WebViewStubService.a(this.pUR, 5, null, i);
    }

    public final void be(String str, boolean z) {
        p.a.qyl.a(this.pUR, str, z);
    }

    public final boolean Hm() {
        return q.Hm();
    }

    public final void i(String str, boolean z, int i) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
        if (!bi.oW(str)) {
            x.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", new Object[]{str});
            Bh.iKs = false;
            Bh.jGy.add(str);
            if (z) {
                Bh.qhR.add(str);
            }
        }
    }

    public final Bundle At(int i) {
        return com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).bYa();
    }

    public final boolean Au(int i) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
        boolean z = Bh.iKs;
        int i2 = (com.tencent.mm.protocal.d.qVQ || com.tencent.mm.protocal.d.qVR) ? true : 0;
        if (z) {
            x.w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", new Object[]{Integer.valueOf(i), Bh.qhW});
        } else if (i2 != 0 && Bh.qhX) {
            x.i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", new Object[]{Integer.valueOf(i)});
            return true;
        }
        return z;
    }

    public final void H(String str, String str2, int i) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).bYa().putString(str, str2);
    }

    public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
        boolean z;
        boolean QN = WebViewStubService.QN(str2);
        x.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + QN);
        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
        jsapiPermissionWrapper.fromBundle(bundle);
        if ("wcPrivacyPolicyResult".equals(str2)) {
            Bundle bundle3 = (Bundle) WebViewStubService.g(this.pUR).get(i);
            if (bundle3 != null && bundle3.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false)) {
                z = false;
                if (z) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.i iVar = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i();
                    iVar.type = str;
                    iVar.qkl = str2;
                    iVar.qkj = str3;
                    iVar.mcy = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.ac(bundle2);
                    e eVar = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
                        e eVar2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                            eVar2 = eVar;
                        } else {
                            eVar2 = webViewStubCallbackWrapper.pXx;
                        }
                        eVar = eVar2;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).bXZ();
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).a(this.pUR, eVar);
                    z = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).a(iVar, jsapiPermissionWrapper);
                    x.i("MicroMsg.WebViewStubService", "handleRet = " + z);
                    return z;
                }
                if (WebViewStubService.a(this.pUR, str, str2, str3, jsapiPermissionWrapper, bundle2, i)) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).km(true);
                }
                return true;
            }
        }
        z = QN;
        if (z) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i iVar2 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i();
            iVar2.type = str;
            iVar2.qkl = str2;
            iVar2.qkj = str3;
            iVar2.mcy = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.ac(bundle2);
            e eVar3 = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.h(this.pUR)) {
                e eVar22;
                if (webViewStubCallbackWrapper2 == null || webViewStubCallbackWrapper2.id != i) {
                    eVar22 = eVar3;
                } else {
                    eVar22 = webViewStubCallbackWrapper2.pXx;
                }
                eVar3 = eVar22;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).bXZ();
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).a(this.pUR, eVar3);
            z = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).a(iVar2, jsapiPermissionWrapper);
            x.i("MicroMsg.WebViewStubService", "handleRet = " + z);
            return z;
        }
        if (WebViewStubService.a(this.pUR, str, str2, str3, jsapiPermissionWrapper, bundle2, i)) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i).km(true);
        }
        return true;
    }

    public final void a(String str, Bundle bundle, int i) {
        Bundle bundle2 = new Bundle();
        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
        jsapiPermissionWrapper.fromBundle(bundle);
        bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
        bundle2.putString("proxyui_username_key", str);
        bundle2.putInt("webview_binder_id", i);
        WebViewStubService.a(this.pUR, 4, bundle2, i);
    }

    public final void QQ(String str) {
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, false);
        if (bl != null && bi.oW(bl.field_openId)) {
            x.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + str);
            gy gyVar = new gy();
            gyVar.bQi.appId = str;
            com.tencent.mm.sdk.b.a.sFg.m(gyVar);
        }
    }

    public final String QR(String str) {
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, false);
        return bl == null ? null : bl.field_packageName;
    }

    public final boolean da(String str) {
        return o$a.qyj.da(str);
    }

    public final void ab(int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("proxyui_expired_errtype", i);
        bundle.putInt("proxyui_expired_errcode", i2);
        WebViewStubService.a(this.pUR, 6, bundle, i3);
    }

    public final boolean QS(String str) {
        return com.tencent.mm.bg.d.QS(str);
    }

    public final void Av(int i) {
        x.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", new Object[]{Integer.valueOf(i)});
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
            if (webViewStubCallbackWrapper.id == i) {
                WebViewStubService.h(this.pUR).remove(webViewStubCallbackWrapper);
                return;
            }
        }
        WebViewStubService.g(this.pUR).remove(i);
    }

    public final void a(e eVar, int i) {
        x.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", new Object[]{Integer.valueOf(eVar.hashCode()), Integer.valueOf(i)});
        WebViewStubService.h(this.pUR).add(new WebViewStubCallbackWrapper(eVar, i));
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
    }

    public final String[] bVp() {
        String G = com.tencent.mm.k.g.AU().G("WebViewConfig", "removeJavascriptInterface");
        return bi.oW(G) ? null : G.split(";");
    }

    public final boolean T(Bundle bundle) {
        cc ccVar = new cc();
        ccVar.bJy.bJA = bundle.getLong("fav_local_id", -1);
        com.tencent.mm.sdk.b.a.sFg.m(ccVar);
        x.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(ccVar.bJy.bJA), Boolean.valueOf(ccVar.bJz.bJm)});
        return ccVar.bJz.bJm;
    }

    public final String bVq() {
        au.HU();
        return (String) c.DT().get(-1535680990, null);
    }

    public final String Dp(String str) {
        return al.Dp(str);
    }

    public final String bVr() {
        return w.d(this.pUR.getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.chY(), 0));
    }

    public final String QT(String str) {
        boolean HX = au.HX();
        x.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + HX);
        if (HX) {
            return com.tencent.mm.k.g.AT().getValue(str);
        }
        return (String) new 4(this, str).a(WebViewStubService.f(this.pUR));
    }

    public final void QU(final String str) {
        boolean HX = au.HX();
        x.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + HX);
        AnonymousClass5 anonymousClass5 = new bd<Void>() {
            protected final /* synthetic */ Object run() {
                if (au.HX()) {
                    au.HU();
                    ab Yg = c.FR().Yg(str);
                    if (Yg == null || ((int) Yg.dhP) <= 0) {
                        am.a.dBr.a(str, "", null);
                    } else {
                        x.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                    }
                }
                return null;
            }
        };
        if (HX) {
            anonymousClass5.a(null);
        } else {
            anonymousClass5.a(WebViewStubService.f(this.pUR));
        }
    }

    public final String cx(String str, int i) {
        switch (i) {
            case 1:
                return aj.Qu(str);
            case 2:
                WebViewJSSDKFileItem Qq = e.bUX().Qq(str);
                if (Qq != null) {
                    x.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[]{Qq.fOs});
                    return Qq.fnM;
                }
                x.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[]{str});
                return null;
            default:
                return null;
        }
    }

    public final int QV(String str) {
        ch chVar = new ch();
        com.tencent.mm.pluginsdk.model.e.a(chVar, 1, str);
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        return chVar.bJG.ret;
    }

    public final void favEditTag() {
        fz fzVar = new fz();
        fzVar.bOL.type = 35;
        com.tencent.mm.sdk.b.a.sFg.m(fzVar);
    }

    public final boolean s(long j, String str) {
        if (j == Long.MIN_VALUE && str == null) {
            return false;
        }
        dj djVar = new dj();
        if (j != Long.MIN_VALUE) {
            djVar.bLf.bJC = j;
        }
        if (str != null) {
            djVar.bLf.bKW = str;
        }
        com.tencent.mm.sdk.b.a.sFg.m(djVar);
        if (djVar.bLg.bKE) {
            return true;
        }
        if (au.HX() && j != Long.MIN_VALUE) {
            au.HU();
            com.tencent.mm.storage.bd dW = c.FT().dW(j);
            if (dW.getType() == 49) {
                boolean fq = s.fq(dW.field_talker);
                String str2 = dW.field_content;
                int i = dW.field_isSend;
                if (fq && str2 != null && i == 0) {
                    str2 = com.tencent.mm.model.bd.iC(str2);
                }
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str2);
                if (gp.type == 3) {
                    return com.tencent.mm.pluginsdk.model.app.g.m(com.tencent.mm.sdk.platformtools.ad.getContext(), 16);
                }
                if (gp.type == 4) {
                    return com.tencent.mm.pluginsdk.model.app.g.m(com.tencent.mm.sdk.platformtools.ad.getContext(), 8);
                }
            }
        }
        return false;
    }

    public final void QW(String str) {
        if (o.Wf(str)) {
            EmojiInfo zi;
            EmojiInfo zi2 = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(com.tencent.mm.a.g.cu(str));
            if (zi2 == null || !zi2.cnv()) {
                zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zj(str));
            } else {
                zi = zi2;
            }
            int cm = zi == null ? 0 : com.tencent.mm.a.e.cm(zi.cnF());
            if (zi != null) {
                str = zi.cnF();
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            int i;
            if ((com.tencent.mm.sdk.platformtools.c.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.k.b.Az()) && options.outWidth <= com.tencent.mm.k.b.Az()) {
                i = 0;
            } else {
                i = true;
            }
            if (cm > com.tencent.mm.k.b.AA() || i != 0) {
                com.tencent.mm.ui.base.h.a(com.tencent.mm.sdk.platformtools.ad.getContext(), this.pUR.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", this.pUR.getString(R.l.i_know_it), null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Retr_File_Name", zi == null ? "" : zi.Xh());
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_MsgImgScene", 1);
            intent.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.ezn.l(intent, this.pUR);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("Retr_File_Name", str);
        intent2.putExtra("Retr_Compress_Type", 0);
        intent2.putExtra("Retr_Msg_Type", 0);
        intent2.addFlags(268435456);
        com.tencent.mm.plugin.webview.a.a.ezn.l(intent2, this.pUR);
    }

    public final String getLanguage() {
        return w.fD(com.tencent.mm.sdk.platformtools.ad.getContext());
    }

    public final String bVs() {
        hn hnVar = new hn();
        com.tencent.mm.sdk.b.a.sFg.m(hnVar);
        return hnVar.bQT.url;
    }

    public final Map bVt() {
        com.tencent.mm.k.d AE = com.tencent.mm.k.g.AU().AE();
        return AE == null ? null : AE.dgT;
    }

    public final String fq(String str, String str2) {
        return "";
    }

    public final int bVu() {
        g.Eg();
        return com.tencent.mm.kernel.a.Df();
    }

    public final int bVv() {
        au.HU();
        return bi.f((Integer) c.DT().get(12304, null));
    }

    public final void bVw() {
        Intent intent = new Intent();
        au.HU();
        String str = (String) c.DT().get(2, null);
        intent.setFlags(268435456);
        intent.putExtra("sns_userName", str);
        intent.addFlags(67108864);
        au.HU();
        int a = bi.a((Integer) c.DT().get(68389, null), 0);
        au.HU();
        c.DT().set(68389, Integer.valueOf(a + 1));
        intent.setClassName(com.tencent.mm.sdk.platformtools.ad.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
        this.pUR.startActivity(intent);
    }

    public final void bVx() {
        if (((q.GQ() & 32768) == 0) && com.tencent.mm.bg.d.QS("sns")) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.setClassName(com.tencent.mm.sdk.platformtools.ad.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            this.pUR.startActivity(intent);
        }
    }

    public final void Ar(int i) {
        Iterator it;
        String str;
        if (WebViewStubService.h(this.pUR).size() == 0) {
            fi fiVar = new fi();
            fiVar.bNF.bNI = 2;
            com.tencent.mm.sdk.b.a.sFg.m(fiVar);
            fc fcVar = new fc();
            fcVar.bNi.op = 2;
            com.tencent.mm.sdk.b.a.sFg.m(fcVar);
            ff ffVar = new ff();
            ffVar.bNp.op = 2;
            com.tencent.mm.sdk.b.a.sFg.m(ffVar);
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
        x.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
        if (Bh.bYh()) {
            WebViewJSSDKFileItem Qq = e.bUX().Qq(Bh.qix);
            if (Qq != null) {
                ah.A(new 72(Bh, Qq));
            }
        }
        Entry entry;
        String str2;
        if ((Bh.bVC() == 8 || Bh.bVC() == -1) && Bh.aUM() != 27) {
            if (Bh.bVC() == 8) {
                if (Bh.qhU == null || Bh.qhU.isEmpty()) {
                    x.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                } else {
                    it = Bh.qhU.entrySet().iterator();
                    if (it != null) {
                        while (it.hasNext()) {
                            entry = (Entry) it.next();
                            str2 = (String) entry.getKey();
                            str = (String) entry.getValue();
                            x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                            dc dcVar = new dc();
                            dcVar.bKH.bKJ = str2;
                            dcVar.bKH.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(dcVar);
                            if (!dcVar.bKI.bKE) {
                                try {
                                    da daVar = new da();
                                    daVar.bKA.bKD = false;
                                    daVar.bKA.bKC = str2;
                                    daVar.bKA.byN = str;
                                    com.tencent.mm.sdk.b.a.sFg.m(daVar);
                                    x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                } catch (Throwable e) {
                                    x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                }
                            }
                        }
                    }
                    Bh.qhU.clear();
                }
            }
        } else if ((Bh.qhV == null || Bh.qhV.isEmpty()) && (Bh.qhU == null || Bh.qhU.isEmpty())) {
            x.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
        } else {
            if (!(Bh.qhV == null || Bh.qhV.isEmpty())) {
                for (Entry entry2 : Bh.qhV.entrySet()) {
                    x.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", new Object[]{(String) entry2.getKey(), (String) entry2.getValue()});
                    try {
                        db dbVar = new db();
                        dbVar.bKF.bKD = false;
                        dbVar.bKF.bKC = str2;
                        dbVar.bKF.byN = str;
                        com.tencent.mm.sdk.b.a.sFg.m(dbVar);
                        x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                        x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                    }
                }
                Bh.qhV.clear();
            }
            if (!(Bh.qhU == null || Bh.qhU.isEmpty())) {
                boolean z;
                Iterator it2 = Bh.qhU.entrySet().iterator();
                str = Bh.bYg();
                if (!bi.oW(str)) {
                    com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(str);
                    if (kH != null) {
                        com.tencent.mm.ac.d.b bG = kH.bG(false);
                        if (!(bG == null || bG.Ms() == null || !bG.Ms().MC())) {
                            z = true;
                            x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                            if (it2 != null) {
                                while (it2.hasNext()) {
                                    entry2 = (Entry) it2.next();
                                    str2 = (String) entry2.getKey();
                                    str = (String) entry2.getValue();
                                    x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                                    if (z) {
                                        dc dcVar2 = new dc();
                                        dcVar2.bKH.bKJ = str2;
                                        dcVar2.bKH.byN = str;
                                        com.tencent.mm.sdk.b.a.sFg.m(dcVar2);
                                        if (dcVar2.bKI.bKE) {
                                        }
                                    }
                                    try {
                                        da daVar2 = new da();
                                        daVar2.bKA.bKD = false;
                                        daVar2.bKA.bKC = str2;
                                        daVar2.bKA.byN = str;
                                        com.tencent.mm.sdk.b.a.sFg.m(daVar2);
                                        x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Throwable e22) {
                                        x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        x.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                                    }
                                }
                            }
                            Bh.qhU.clear();
                        }
                    }
                }
                z = false;
                x.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                if (it2 != null) {
                    while (it2.hasNext()) {
                        entry2 = (Entry) it2.next();
                        str2 = (String) entry2.getKey();
                        str = (String) entry2.getValue();
                        x.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                        if (z) {
                            dc dcVar22 = new dc();
                            dcVar22.bKH.bKJ = str2;
                            dcVar22.bKH.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(dcVar22);
                            if (dcVar22.bKI.bKE) {
                            }
                        }
                        try {
                            da daVar22 = new da();
                            daVar22.bKA.bKD = false;
                            daVar22.bKA.bKC = str2;
                            daVar22.bKA.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(daVar22);
                            x.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Throwable e222) {
                            x.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            x.printErrStackTrace("MicroMsg.MsgHandler", e222, "", new Object[0]);
                        }
                    }
                }
                Bh.qhU.clear();
            }
        }
        com.tencent.mm.plugin.webview.model.f bTW = com.tencent.mm.plugin.webview.model.f.a.bTW();
        if (bi.cX(bTW.pRh)) {
            x.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
        } else if (au.HX()) {
            List list;
            bTW.pRe = com.tencent.mm.k.g.AT().getInt("MMUxAdLog2GSendSize", 20480);
            bTW.pRf = com.tencent.mm.k.g.AT().getInt("MMUxAdLog3GSendSize", 30720);
            bTW.pRg = com.tencent.mm.k.g.AT().getInt("MMUxAdLogWifiSendSize", 51200);
            x.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", new Object[]{Integer.valueOf(bTW.pRe), Integer.valueOf(bTW.pRf), Integer.valueOf(bTW.pRg)});
            Collection<apz> collection = bTW.pRh;
            if (bi.cX(collection)) {
                x.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                list = null;
            } else {
                apz apz;
                int i2;
                x.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                x.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.setLength(0);
                stringBuilder.append("{ ");
                for (apz apz2 : collection) {
                    stringBuilder.append(apz2.rSt).append(", ");
                }
                stringBuilder.append(" }");
                x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                if (bi.bI(bTW.pRj) >= 100 || bTW.pRi <= 0) {
                    bTW.pRj = SystemClock.elapsedRealtime();
                    int i3;
                    if (ao.isWifi(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                        i3 = bTW.pRg;
                        bTW.pRi = i3;
                        i2 = i3;
                    } else if (ao.is3G(com.tencent.mm.sdk.platformtools.ad.getContext()) || ao.is4G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                        i3 = bTW.pRf;
                        bTW.pRi = i3;
                        i2 = i3;
                    } else {
                        ao.is2G(com.tencent.mm.sdk.platformtools.ad.getContext());
                        i3 = bTW.pRe;
                        bTW.pRi = i3;
                        i2 = i3;
                    }
                } else {
                    i2 = bTW.pRi;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(collection);
                List<List> linkedList2 = new LinkedList();
                LinkedList linkedList3 = null;
                int i4 = 0;
                while (linkedList.size() > 0) {
                    if (i4 <= 0) {
                        linkedList3 = new LinkedList();
                        apz2 = (apz) linkedList.remove();
                        i4 += apz2.rSu.lR.length;
                        linkedList3.add(apz2);
                        linkedList2.add(linkedList3);
                    } else if (((apz) linkedList.peek()).rSu.lR.length + i4 >= i2) {
                        i4 = 0;
                    } else {
                        apz2 = (apz) linkedList.remove();
                        i4 += apz2.rSu.lR.length;
                        linkedList3.add(apz2);
                    }
                }
                x.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                for (List<apz> list2 : linkedList2) {
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (apz apz22 : list2) {
                        stringBuilder.append(apz22.rSt).append(", ");
                    }
                    stringBuilder.append(" }");
                    x.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    x.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                }
                x.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                list = linkedList2;
            }
            if (bi.cX(list)) {
                x.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
            } else {
                for (List list3 : list3) {
                    if (!bi.cX(list3)) {
                        x.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                        au.DF().a(new com.tencent.mm.plugin.webview.model.q(list3), 0);
                    }
                }
                bTW.pRh.clear();
            }
        } else {
            x.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
        }
        if (Bh.qhS != null) {
            Bh.qhS.setClassLoader(Bh.getClass().getClassLoader());
        }
        if (Bh.qhS != null) {
            Parcelable parcelable = Bh.qhS.getParcelable("KSnsAdTag");
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                snsAdClick.Ry();
                nl nlVar = new nl();
                nlVar.bYw.bYx = 1;
                nlVar.bYw.bYl = snsAdClick;
                com.tencent.mm.sdk.b.a.sFg.m(nlVar);
            }
        }
        str = "";
        if (Bh.qhS != null) {
            Bh.qhS.setClassLoader(Bh.getClass().getClassLoader());
            str = Bh.qhS.getString("KoriginUrl");
        }
        tz tzVar = new tz();
        tzVar.cfG.cfD = str;
        com.tencent.mm.sdk.b.a.sFg.m(tzVar);
        if (Bh.qhS != null) {
            com.tencent.mm.modelsns.b j = com.tencent.mm.modelsns.b.j(Bh.qhS);
            if (j != null) {
                j.update();
                j.RD();
            }
        }
        for (String str3 : Bh.qiw.keySet()) {
            if (!bi.oW(str3)) {
                e.bUW();
                com.tencent.mm.plugin.webview.model.ad.rq(str3);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b bVar = (com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b) Bh.qiw.get(str3);
                if (bVar != null) {
                    if (bVar.qkf != null) {
                        e.bUW().a(bVar.qkf);
                    }
                    if (bVar.qhP != null) {
                        Bh.a(bVar.qhP, "uploadVideo:cancel", null, false);
                    }
                }
            }
        }
        Bh.qiw.clear();
        for (r.a aVar : r.cfA()) {
            x.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
            aVar.bXa();
        }
        r.clear();
        com.tencent.mm.sdk.b.a.sFg.c(Bh.nbf);
        com.tencent.mm.sdk.b.a.sFg.c(Bh.qiv);
        com.tencent.mm.sdk.b.a.sFg.c(Bh.qiG);
        if (au.HX()) {
            au.HU();
            c.DT().a(aa.a.sRP, Boolean.valueOf(false));
        }
        Editor edit = com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
        edit.putBoolean("isNewScanning", false);
        edit.commit();
        Bh.qhQ = null;
        Bh.qiu = null;
        Bh.b(Bh.qhP, new int[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.qia = null;
        if (com.tencent.mm.plugin.webview.ui.tools.jsapi.g.qib != -1) {
            Bh.qhP = Bh.Bd(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.qib).qhP;
            Bh.qhP = null;
            Bh.pRY = Bh.Bd(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.qib).pRY;
            Bh.pRY = null;
        }
        Bh.qhY = null;
        Bh.qiC.clear();
        com.tencent.mm.plugin.webview.modelcache.q bUL = a.pTz;
        List list4 = Bh.qiy;
        if (!(com.tencent.mm.compatible.e.w.zQ() == 0 || !au.HX() || bi.cX(list4))) {
            bUL.Em().H(new 5(bUL, list4));
        }
        a.pTz.Ar(Bh.bWo);
    }

    public final void cy(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("proxyui_phone", str);
        WebViewStubService.a(this.pUR, 8, bundle, i);
    }

    public final boolean bVy() {
        return q.GS();
    }

    public final void c(String str, int[] iArr) {
        if (WebViewStubService.i(this.pUR) == null) {
            WebViewStubService.a(this.pUR, new HashMap());
            com.tencent.mm.sdk.b.a.sFg.b(WebViewStubService.j(this.pUR));
        }
        ms msVar = new ms();
        msVar.bXH.filePath = str;
        if (iArr != null && iArr.length > 0) {
            msVar.bXH.bXI = new HashSet();
            for (int valueOf : iArr) {
                msVar.bXH.bXI.add(Integer.valueOf(valueOf));
            }
        }
        com.tencent.mm.sdk.b.a.sFg.m(msVar);
        WebViewStubService.i(this.pUR).put(str, Integer.valueOf(1));
    }

    public final void QX(String str) {
        if (WebViewStubService.i(this.pUR) == null || !WebViewStubService.i(this.pUR).containsKey(str)) {
            x.e("MicroMsg.WebViewStubService", "%s is not recognizing", new Object[]{str});
            return;
        }
        ak akVar = new ak();
        akVar.bHM.filePath = str;
        com.tencent.mm.sdk.b.a.sFg.m(akVar);
        WebViewStubService.i(this.pUR).remove(str);
    }

    public final void h(String str, String str2, String str3, int i, int i2) {
        if (str != null) {
            Intent intent = new Intent();
            intent.setClass(com.tencent.mm.sdk.platformtools.ad.getContext(), WebviewScanImageActivity.class);
            intent.setFlags(872415232);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", str2);
            intent.putExtra("key_string_for_image_url", str3);
            intent.putExtra("key_codetype_for_scan", i);
            intent.putExtra("key_codeversion_for_scan", i2);
            com.tencent.mm.sdk.platformtools.ad.getContext().startActivity(intent);
        }
    }

    public final String QY(String str) {
        String str2 = "";
        com.tencent.mm.pluginsdk.d.SD(str);
        return str2;
    }

    public final boolean bVz() {
        if (oH("EnableWebviewScanQRCode") == 1) {
            return true;
        }
        return false;
    }

    private static int oH(String str) {
        int i = 1;
        try {
            return bi.getInt(com.tencent.mm.k.g.AT().getValue(str), 1);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public final void Aw(int i) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
        WebViewStubService webViewStubService = this.pUR;
        for (r.a aVar : r.cfA()) {
            x.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
            aVar.ez(webViewStubService);
        }
        Bh.qid = false;
        if (Bh.qhS != null) {
            Parcelable parcelable = Bh.qhS.getParcelable("KSnsAdTag");
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                ((SnsAdClick) parcelable).Ry();
            }
        }
    }

    public final void Ax(int i) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bh = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i);
        for (r.a aVar : r.cfA()) {
            x.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
            aVar.bXb();
        }
        if (Bh.qhS != null) {
            Parcelable parcelable = Bh.qhS.getParcelable("KSnsAdTag");
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                ((SnsAdClick) parcelable).egO = bi.VG();
            }
        }
    }

    public final Bundle g(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        String oV;
        String string;
        Bundle bundle3;
        FileDownloadTaskInfo cm;
        int i2;
        Bundle bundle4;
        boolean HX;
        com.tencent.mm.storage.c cVar;
        int i3;
        String str;
        Map ckq;
        switch (i) {
            case 14:
                if (bundle == null) {
                    return null;
                }
                oV = bi.oV(bundle.getString("task_url"));
                x.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", new Object[]{oV, bundle.getString("task_name")});
                if (bi.oW(oV)) {
                    x.e("MicroMsg.WebViewStubService", "download url is null or nil");
                    return null;
                }
                com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                aVar.yQ(oV);
                aVar.yS(string);
                aVar.ef(true);
                aVar.ox(1);
                x.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", new Object[]{Long.valueOf(com.tencent.mm.plugin.downloader.model.d.aCU().a(aVar.ick))});
                bundle3 = new Bundle();
                bundle3.putLong("download_id", r2);
                return bundle3;
            case 15:
                cm = com.tencent.mm.plugin.downloader.model.d.aCU().cm(bundle.getLong("download_id", 0));
                String str2 = "MicroMsg.WebViewStubService";
                String str3 = "query download task info, info == null ? %b task state = %d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(cm == null);
                if (cm == null) {
                    i2 = 0;
                } else {
                    i2 = cm.status;
                }
                objArr[1] = Integer.valueOf(i2);
                x.i(str2, str3, objArr);
                i2 = 0;
                if (cm != null) {
                    i2 = cm.status;
                }
                x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(r2), Integer.valueOf(i2)});
                bundle4 = new Bundle();
                bundle4.putInt("download_state", i2);
                return bundle4;
            case 16:
                x.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.plugin.downloader.model.d.aCU().cl(bundle.getLong("download_id", 0)))});
                bundle4 = new Bundle();
                bundle4.putBoolean("cancel_result", com.tencent.mm.plugin.downloader.model.d.aCU().cl(bundle.getLong("download_id", 0)) > 0);
                return bundle4;
            case 17:
                cm = com.tencent.mm.plugin.downloader.model.d.aCU().cm(bundle.getLong("download_id"));
                bundle3 = new Bundle();
                if (cm == null) {
                    x.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                    bundle3.putBoolean("install_result", false);
                    return bundle3;
                } else if (cm.status != 3) {
                    x.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + cm.status);
                    bundle3.putBoolean("install_result", false);
                    return bundle3;
                } else if (com.tencent.mm.a.e.cn(cm.path)) {
                    bundle3.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.q.g(this.pUR, Uri.fromFile(new File(cm.path))));
                    return bundle3;
                } else {
                    x.e("MicroMsg.WebViewStubService", "file not exists : %s", new Object[]{cm.path});
                    bundle3.putBoolean("install_result", false);
                    return bundle3;
                }
            case 19:
                bundle3 = new Bundle();
                bundle3.putBoolean("webview_video_proxy_init", ai.bUm().hasInit);
                return bundle3;
            case 23:
                HX = au.HX();
                7 7 = new 7(this);
                if (HX) {
                    oV = (String) 7.a(null);
                } else {
                    oV = (String) 7.a(WebViewStubService.f(this.pUR));
                }
                bundle4 = new Bundle();
                bundle4.putString("config_info_username", oV);
                return bundle4;
            case 24:
                bundle4 = new Bundle();
                cVar = null;
                try {
                    cVar = com.tencent.mm.model.c.c.Jx().fJ(com.tencent.mm.plugin.webview.modeltools.b.pTG);
                } catch (AssertionFailedError e) {
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                } catch (com.tencent.mm.model.b e2) {
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                }
                if (cVar == null || !cVar.isValid()) {
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", new Object[]{cVar});
                    return bundle4;
                }
                Map ckq2 = cVar.ckq();
                long j = bi.getLong((String) ckq2.get("interval"), 0);
                long VE = bi.VE();
                au.HU();
                x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", new Object[]{Long.valueOf(bi.c((Long) c.DT().get(aa.a.sRK, null))), Long.valueOf(VE), Long.valueOf(j)});
                if (bi.c((Long) c.DT().get(aa.a.sRK, null)) >= VE) {
                    x.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                    return bundle4;
                }
                j += VE;
                au.HU();
                c.DT().a(aa.a.sRK, Long.valueOf(j));
                i3 = bi.getInt((String) ckq2.get("urlCount"), 0);
                ArrayList arrayList = new ArrayList(i3);
                for (i2 = 0; i2 < i3; i2++) {
                    arrayList.add(ckq2.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                }
                bundle4.putStringArrayList("cookies_cleanup_url_list", arrayList);
                return bundle4;
            case 26:
                bundle3 = new Bundle(1);
                bundle3.putBoolean("webview_resource_cache_inWhiteList", false);
                return bundle3;
            case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                if (!au.HX()) {
                    return null;
                }
                cVar = com.tencent.mm.model.c.c.Jx().fJ("100036");
                if (cVar.isValid()) {
                    Map ckq3 = cVar.ckq();
                    bundle4 = new Bundle();
                    i2 = bi.getInt((String) ckq3.get("controlFlag"), 0);
                    bundle4.putInt("webview_ad_intercept_control_flag", i2);
                    if (i2 == 0) {
                        x.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                        return bundle4;
                    }
                    int i4;
                    int i5 = bi.getInt((String) ckq3.get("blackListCount"), 0);
                    ArrayList arrayList2 = new ArrayList();
                    for (i4 = 0; i4 < i5; i4++) {
                        oV = (String) ckq3.get("blackList" + (i4 + 1));
                        if (!(bi.oW(oV) || arrayList2.contains(oV))) {
                            x.i("MicroMsg.WebViewStubService", "add black list domin = %s", new Object[]{oV});
                            arrayList2.add(oV);
                        }
                    }
                    i5 = bi.getInt((String) ckq3.get("whiteListCount"), 0);
                    ArrayList arrayList3 = new ArrayList();
                    for (i4 = 0; i4 < i5; i4++) {
                        oV = (String) ckq3.get("whiteList" + (i4 + 1));
                        if (!(bi.oW(oV) || arrayList3.contains(oV))) {
                            x.i("MicroMsg.WebViewStubService", "add white list domin = %s", new Object[]{oV});
                            arrayList3.add(oV);
                        }
                    }
                    bundle4.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                    bundle4.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                    return bundle4;
                }
                x.d("MicroMsg.WebViewStubService", "test is valid");
                return null;
            case 50:
                if (bundle == null) {
                    return null;
                }
                string = bundle.getString("data");
                if (string == null) {
                    return null;
                }
                bundle3 = new Bundle();
                bundle3.putInt("key_biz_type", com.tencent.mm.ac.f.kH(string).field_type);
                return bundle3;
            case 51:
                try {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    com.tencent.mm.modelgeo.c.OB().b(new com.tencent.mm.modelgeo.a.a() {
                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            x.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
                            com.tencent.mm.modelgeo.c.OB().c(this);
                            return false;
                        }
                    });
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.WebViewStubService", e3, "", new Object[0]);
                }
                return null;
            case s$l.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                if (bundle == null) {
                    return null;
                }
                oV = bundle.getString("enterprise_action");
                bundle4 = new Bundle();
                if (oV.equals("enterprise_has_connector")) {
                    str = "enterprise_has_connector";
                    z.MY();
                    bundle4.putBoolean(str, com.tencent.mm.ac.e.MF().size() > 0);
                } else if (oV.equals("enterprise_connectors")) {
                    z.MY();
                    Collection MF = com.tencent.mm.ac.e.MF();
                    if (MF != null) {
                        bundle4.putStringArrayList("enterprise_connectors", new ArrayList(MF));
                    }
                }
                return bundle4;
            case s$l.AppCompatTheme_listPopupWindowStyle /*75*/:
                ai bUm = ai.bUm();
                if (bUm.hasInit) {
                    bUm.pRY = null;
                    ai.pRX = null;
                    bUm.hasInit = false;
                }
                return null;
            case s$l.AppCompatTheme_textAppearanceListItem /*76*/:
                if (bundle == null) {
                    return Bundle.EMPTY;
                }
                bundle3 = new Bundle();
                bundle3.putString("appId", com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(bundle.getInt("webview_binder_id")).rL(bi.oV(bundle.getString("rawUrl"))));
                return bundle3;
            case s$l.AppCompatTheme_panelBackground /*78*/:
                bundle2.putBoolean("isOpenForFaceBook", q.He());
                break;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                if (bundle != null) {
                    oV = bundle.getString("KAppId");
                    string = bundle.getString("shortcut_user_name");
                    i3 = bundle.getInt("webviewui_binder_id");
                    if (!bi.oW(oV) && !bi.oW(string)) {
                        WebViewStubService.a(this.pUR, 10, bundle, i3);
                        break;
                    }
                    return null;
                }
                return null;
            case s$l.AppCompatTheme_colorPrimaryDark /*83*/:
                WebViewStubService.a(this.pUR, bundle.getInt("screen_orientation", -1));
                break;
            case s$l.AppCompatTheme_alertDialogStyle /*91*/:
                if (bundle != null) {
                    i2 = bundle.getInt("game_sourceScene");
                    gk gkVar = new gk();
                    gkVar.bPB.actionCode = 5;
                    gkVar.bPB.scene = i2;
                    com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                    break;
                }
                return null;
            case s$l.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                if (bundle != null) {
                    oV = bundle.getString("game_hv_menu_appid");
                    if (!bi.oW(oV)) {
                        gl glVar = new gl();
                        glVar.bPC.nc = 3;
                        glVar.bPC.bPE = oV;
                        com.tencent.mm.sdk.b.a.sFg.m(glVar);
                        bundle2.putString("game_hv_menu_pbcache", glVar.bPD.result);
                        break;
                    }
                    return null;
                }
                return null;
            case s$l.AppCompatTheme_alertDialogCenterButtons /*93*/:
                bundle3 = new Bundle();
                bundle3.putBoolean("is_oauth_native", false);
                if (!g.Eg().Dx()) {
                    x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                    return bundle3;
                } else if (g.Ek().dqL.drf) {
                    com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100272");
                    if (fJ.isValid()) {
                        ckq = fJ.ckq();
                        if (ckq == null) {
                            x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                            return bundle3;
                        } else if (ckq.containsKey("isUseNative") && "1".equals(ckq.get("isUseNative"))) {
                            bundle3.putBoolean("is_oauth_native", true);
                            return bundle3;
                        } else {
                            x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                            return bundle3;
                        }
                    }
                    x.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                    return bundle3;
                } else {
                    x.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
                    return bundle3;
                }
            case s$l.AppCompatTheme_alertDialogTheme /*94*/:
                return com.tencent.mm.plugin.webview.model.z.a.bUf();
            case s$l.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                if (bundle == null) {
                    return null;
                }
                Set<String> keySet = bundle.keySet();
                if (keySet == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String oV2 : keySet) {
                        jSONObject.put(oV2, bundle.get(oV2));
                    }
                    gl glVar2 = new gl();
                    glVar2.bPC.nc = 4;
                    glVar2.bPC.bPE = jSONObject.toString();
                    com.tencent.mm.sdk.b.a.sFg.m(glVar2);
                    break;
                } catch (JSONException e4) {
                    return null;
                }
            case s$l.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                cVar = com.tencent.mm.model.c.c.Jx().fJ("100376");
                if (!cVar.isValid()) {
                    x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    return null;
                } else if ("true".equals(cVar.ckq().get("enabled"))) {
                    return new Bundle();
                } else {
                    return null;
                }
            case s$l.AppCompatTheme_buttonStyle /*100*/:
                string = com.tencent.mm.k.g.AU().G("WebViewConfig", "mediaEnableAutoPlayHostPaths");
                bundle3 = new Bundle();
                bundle3.putString("enable_auto_play_host_paths", string);
                return bundle3;
            case s$l.AppCompatTheme_checkboxStyle /*102*/:
                if (bundle != null) {
                    bundle2.putBoolean("is_enterprise_username", com.tencent.mm.ac.f.kK(bundle.getString("enterprise_biz_username")));
                    break;
                }
                return null;
            case s$l.AppCompatTheme_checkedTextViewStyle /*103*/:
                i2 = bundle.getInt("key_action", -1);
                bundle4 = new Bundle();
                if (g.Eg().Dx()) {
                    x.i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", new Object[]{Integer.valueOf(i2)});
                    com.tencent.mm.plugin.webview.ui.tools.bag.j jVar;
                    switch (i2) {
                        case 5:
                        case 6:
                            jVar = com.tencent.mm.plugin.webview.ui.tools.bag.j.qcm;
                            x.i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", new Object[]{Boolean.valueOf(bundle.getBoolean("key_in_webviewui_from_bag", false))});
                            jVar.qcq = r2;
                            break;
                        case 7:
                            oV2 = bundle.getString("key_bag_id");
                            str = "key_has_bag";
                            com.tencent.mm.plugin.webview.ui.tools.bag.j jVar2 = com.tencent.mm.plugin.webview.ui.tools.bag.j.qcm;
                            x.i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s", new Object[]{oV2});
                            HX = !bi.oW(jVar2.qcr.url) && bi.oV(oV2).equals(jVar2.qco);
                            bundle4.putBoolean(str, HX);
                            break;
                        case 8:
                            jVar = com.tencent.mm.plugin.webview.ui.tools.bag.j.qcm;
                            bundle4.putParcelable("key_current_bag_pos", new Point(jVar.qcr.qcw, jVar.qcr.qcv));
                            break;
                        default:
                            ah.A(new 1(i2, bundle));
                            break;
                    }
                }
                x.w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
                return bundle4;
            case 129:
                i3 = bundle.getInt("webview_instance_id");
                e eVar = null;
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
                    e eVar2;
                    if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i3) {
                        eVar2 = eVar;
                    } else {
                        eVar2 = webViewStubCallbackWrapper.pXx;
                    }
                    eVar = eVar2;
                }
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(i3).a(this.pUR, eVar);
                Map hashMap = new HashMap();
                hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                hashMap.put("webview_instance_id", Integer.valueOf(i3));
                e.bUU().ab(hashMap);
                break;
            case 131:
                ckq = new HashMap();
                ckq.put("logString", bundle.getString("logString"));
                d bUU = e.bUU();
                Object t = com.tencent.mm.plugin.websearch.api.p.t(ckq, "logString");
                Map hashMap2 = new HashMap();
                if (!t.contains("h5version=")) {
                    hashMap2.put("h5version", Integer.valueOf(com.tencent.mm.plugin.websearch.api.p.zP(0)));
                }
                if (hashMap2.keySet().size() > 0) {
                    t = t.length() > 0 ? t + "&" + com.tencent.mm.plugin.websearch.api.p.U(hashMap2) : com.tencent.mm.plugin.websearch.api.p.U(hashMap2);
                }
                ckq.put("logString", t);
                bUU.ad(ckq);
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.f.j.CTRL_INDEX /*141*/:
                hi hiVar = new hi();
                com.tencent.mm.sdk.b.a.sFg.m(hiVar);
                GameSettingParams gameSettingParams = new GameSettingParams();
                gameSettingParams.bQE = hiVar.bQD.bQE;
                gameSettingParams.bQF = hiVar.bQD.bQF;
                bundle2.putParcelable("game_setting_params", gameSettingParams);
                break;
            case 250:
                if (bundle != null) {
                    if (bundle != null) {
                        try {
                            com.tencent.mm.sdk.f.e.post(new com.tencent.mm.modelstat.a.b.1(bundle), "web_call_rpt");
                            break;
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.WebViewStubService", e32, "webview call back mm error", new Object[0]);
                            break;
                        }
                    }
                }
                return null;
                break;
            case 251:
                if (bundle != null) {
                    com.tencent.mm.modelstat.f.RY().r(WebViewUI.class.getName(), bundle.getLong("key_activity_browse_time", 0));
                    break;
                }
                return null;
            case 4006:
                bundle3 = new Bundle();
                string = com.tencent.mm.sdk.platformtools.ad.cia().getString("nfc_open_url", null);
                x.i("MicroMsg.WebViewStubService", "nfc url=" + bi.oV(string));
                if (!(bi.oW(string) || bi.oW(string.trim()))) {
                    bundle3.putString("debugConfig", string);
                }
                au.HU();
                bundle3.putString("config", String.valueOf(c.DT().get(aa.a.sQB, null)));
                return bundle3;
            case 10001:
                StringBuilder stringBuilder = new StringBuilder("kwid_");
                g.Eg();
                com.tencent.mm.modelappbrand.b.dFx = stringBuilder.append(com.tencent.mm.kernel.a.Df()).append("_").append(bi.VF()).toString();
                x.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", new Object[]{com.tencent.mm.modelappbrand.b.dFx});
                break;
            case 100000:
                cVar = com.tencent.mm.model.c.c.Jx().fJ("100248");
                if (cVar.isValid()) {
                    if (bi.getInt((String) cVar.ckq().get("isForceSync"), 0) == 1) {
                        x.d("MicroMsg.ConfigListDecoder", "host list = %s", new Object[]{com.tencent.mm.k.g.AU().G("WebViewConfig", "forceSyncA8KeyHostPath")});
                        bundle2.putString("force_geta8key_host_path", oV2);
                        break;
                    }
                }
                x.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                return null;
                break;
            default:
                x.e("MicroMsg.WebViewStubService", "unknown action = %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return bundle2;
    }

    public final boolean bVA() {
        if (!au.HW() || au.Dr()) {
            return true;
        }
        return false;
    }

    public final void aj(Intent intent) {
        Intent intent2 = new Intent(this.pUR, WebViewStubProxyUI.class);
        intent2.putExtra("proxyui_action_code_key", 9);
        intent2.putExtra("proxyui_next_intent_key", intent);
        intent2.setFlags(268435456);
        this.pUR.startActivity(intent2);
    }

    public final void z(int i, String str, String str2) {
        WebViewJSSDKFileItem y = WebViewJSSDKFileItem.y(i, str, str2);
        y.fnR = false;
        e.bUX().b(y);
        e.bUW().b(null, y.bNH, null);
    }

    public final List<String> bVB() {
        com.tencent.mm.plugin.webview.modeltools.h bUY;
        if (g.Eg().Dx()) {
            e.bUR();
            bUY = e.bUY();
        } else {
            bUY = null;
        }
        if (bUY == null) {
            return new ArrayList();
        }
        return new ArrayList(bUY.bVd());
    }

    public final void b(Bundle bundle, int i) {
        WebViewStubService.g(this.pUR).put(i, bundle);
    }

    public final int bVC() {
        return com.tencent.mm.pluginsdk.wallet.i.bVC();
    }

    public final boolean bVD() {
        if (oH("WebViewDownLoadFileSwitch") == 1) {
            return true;
        }
        return false;
    }

    public final String[] bVE() {
        String G = com.tencent.mm.k.g.AU().G("AsyncCheckUrl", "UrlHost");
        return !bi.oW(G) ? G.split(";") : null;
    }
}
