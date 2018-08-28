package com.tencent.mm.plugin.webview.fts;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.31;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.ui.y;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static boolean pNY = true;
    private static s pNZ = new s();
    private Context context;
    private MMWebView mhH;
    public HashMap<String, Object> pNP = new HashMap();
    private HashMap<String, Object> pNQ = new HashMap();
    private HashMap<String, Object> pNR = new HashMap();
    private Map<String, String> pNS = new HashMap();
    private int pNT = -1;
    public e pNU;
    public d pNV;
    private Map<String, c> pNW = new HashMap();
    private Map<String, b> pNX = new HashMap();

    static /* synthetic */ void a(b bVar, String str, int i, r rVar) {
        x.i("FTSSearchWidgetMgr", "onSetWidgetSize widgetId %s, height %d", new Object[]{str, Integer.valueOf(i)});
        c cVar = (c) bVar.pNW.get(str);
        Bundle bundle = new Bundle();
        if (cVar != null && (i > cVar.pOm || i < cVar.pOl)) {
            x.w("FTSSearchWidgetMgr", "invalid widget size, should in range %s", new Object[]{cVar.toString()});
            if (rVar != null) {
                bundle.putInt("errCode", -2);
                rVar.b(false, "invalid widget size, should in range " + cVar.toString(), bundle);
            }
        } else if (bVar.pNV != null) {
            d dVar = bVar.pNV;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
                Map hashMap = new HashMap();
                hashMap.put("widgetId", str);
                hashMap.put("height", Integer.valueOf(i));
                ah.A(new 31(dVar, a.a("onSearchWAWidgetAttrChanged", hashMap, dVar.qhs, dVar.qht)));
            } else {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
            }
            if (rVar != null) {
                bundle.putInt("errCode", 0);
                rVar.b(true, "", bundle);
            }
        } else if (rVar != null) {
            bundle.putInt("errCode", -1);
            rVar.b(false, "jsapi is null", bundle);
        }
    }

    public static s bTF() {
        return pNZ;
    }

    public b(Context context, MMWebView mMWebView) {
        this.context = context;
        this.mhH = mMWebView;
        this.pNU = (e) g.l(e.class);
        if (pNY && new File(com.tencent.mm.compatible.util.e.bnE, "websearch-widget-not-use-tools").exists()) {
            pNY = false;
        }
    }

    public final void M(Bundle bundle) {
        b bVar = (b) this.pNX.get((String) bundle.get("widgetId"));
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("app_id", bVar.bPS);
            bundle2.putString("msg_id", bVar.fuL);
            bundle2.putInt("pkg_type", bVar.bPh);
            bundle2.putInt("pkg_version", bVar.fii);
            ((e) g.l(e.class)).JN().d(this.context, bundle2);
        }
    }

    public final void a(Bundle bundle, int i) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        String bq = k.bq(this);
        x.i("FTSSearchWidgetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", new Object[]{string2, bq, string});
        s.i("FTSSearchWidgetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", new Object[]{string2, bq, string});
        if (string == null || string.length() == 0) {
            x.i("FTSSearchWidgetMgr", "insert args invalid");
            return;
        }
        try {
            b bVar;
            String optString;
            com.tencent.mm.plugin.webview.fts.b.a.a bTN;
            String str;
            String optString2;
            String optString3;
            int i2;
            int optInt;
            h hVar;
            Object[] objArr;
            View bH;
            View view;
            LayoutParams layoutParams;
            FrameLayout frameLayout;
            ThreeDotsLoadingView threeDotsLoadingView;
            ImageView imageView;
            String optString4;
            String str2;
            com.tencent.mm.plugin.webview.fts.b.a.a bTN2;
            String str3;
            Bundle bundle2;
            int i3;
            long currentTimeMillis;
            v vVar;
            ViewGroup topView;
            b bVar2 = (b) this.pNX.get(string2);
            if (bVar2 == null) {
                bVar2 = new b(this, (byte) 0);
                this.pNX.put(string2, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("maxHeight")) {
                if (jSONObject.has("minHeight")) {
                    c cVar = (c) this.pNW.get(string2);
                    if (cVar == null) {
                        cVar = new c(this, (byte) 0);
                        this.pNW.put(string2, cVar);
                    }
                    cVar.pOl = jSONObject.optInt("minHeight");
                    cVar.pOm = jSONObject.optInt("maxHeight");
                    x.i("FTSSearchWidgetMgr", "update widgetSize %s", new Object[]{cVar.toString()});
                    optString = jSONObject.optString("appid");
                    string = jSONObject.optString("pagePath");
                    bTN = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                    if (bTN.Qi(optString)) {
                        com.tencent.mm.plugin.webview.fts.b.a.a.a aVar = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN.pPL.get(optString);
                        if (aVar != null) {
                            str = (string.contains("widgetData") ? com.tencent.mm.plugin.webview.fts.b.a.a.a(Uri.parse(string), "widgetData", Uri.encode(aVar.pPS)).toString() : string + "&widgetData=" + Uri.encode(aVar.pPS)) + "&isTestUi=1";
                            optString2 = jSONObject.optString("searchId");
                            s.jq(optString);
                            if (str.contains("widgetData")) {
                                s.JW();
                            }
                            optString3 = jSONObject.optString("nickName");
                            i2 = jSONObject.getInt("version");
                            if (jSONObject.has("debugMode")) {
                                optInt = jSONObject.optInt("debugMode");
                            } else {
                                optInt = 0;
                            }
                            hVar = h.mEJ;
                            objArr = new Object[3];
                            objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Long.valueOf(System.currentTimeMillis());
                            hVar.h(14452, objArr);
                            bH = this.pNU.bH(this.context);
                            hVar = h.mEJ;
                            objArr = new Object[3];
                            objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(System.currentTimeMillis());
                            hVar.h(14452, objArr);
                            view = (AbsoluteLayout) y.gq(this.context).inflate(R.i.fts_widget_layout, null);
                            view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                            layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                            bH.setLayoutParams(layoutParams);
                            view.addView(bH);
                            frameLayout = (FrameLayout) view.findViewById(R.h.loading_view_layout);
                            frameLayout.setLayoutParams(layoutParams);
                            view.removeView(frameLayout);
                            view.addView(frameLayout);
                            bH.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                            bH.setTag(bq);
                            this.pNP.put(string2, bH);
                            this.pNQ.put(string2, view);
                            this.pNR.put(string2, frameLayout);
                            threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.loading_view);
                            imageView = (ImageView) view.findViewById(R.h.cover_iv);
                            optString4 = jSONObject.optString("wxaData");
                            str2 = optString + "_" + optString4.hashCode();
                            bTN2 = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                            str3 = "";
                            if (bTN2.pPL.containsKey(optString)) {
                                com.tencent.mm.plugin.webview.fts.b.a.a.a aVar2 = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN2.pPL.get(optString);
                                if (aVar2 != null) {
                                    string = Uri.encode(aVar2.pPS);
                                    if (TextUtils.isEmpty(string)) {
                                        string = jSONObject.optString("inputData");
                                    }
                                    bundle2 = new Bundle();
                                    if (pNY) {
                                        bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                                    }
                                    bundle2.putString("app_id", optString);
                                    bundle2.putString("msg_id", str2);
                                    bundle2.putString("search_id", optString2);
                                    bundle2.putString("cache_key", optString4);
                                    bundle2.putString("msg_title", optString3);
                                    bundle2.putString("msg_path", str);
                                    bundle2.putInt("pkg_version", i2);
                                    bundle2.putInt("msg_pkg_type", optInt);
                                    bundle2.putString("init_data", string);
                                    bundle2.putInt("widget_type", 1);
                                    bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                                    str3 = "scene";
                                    i3 = i != 201 ? 1006 : i == 3 ? 1005 : i == 16 ? 1042 : i == 20 ? 1053 : BaseReportManager.MAX_READ_COUNT;
                                    bundle2.putInt(str3, i3);
                                    bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                                    bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                                    bundle2.putString("query", jSONObject.optString("wxaData"));
                                    bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                                    bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                                    threeDotsLoadingView.setVisibility(0);
                                    imageView.setVisibility(4);
                                    threeDotsLoadingView.cAG();
                                    bVar.bPS = optString;
                                    bVar.bPh = optInt;
                                    bVar.fii = i2;
                                    bVar.fuL = str2;
                                    x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                                    currentTimeMillis = System.currentTimeMillis();
                                    h.mEJ.a(867, 0, 1, false);
                                    vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                                    vVar.a(new j(this.context));
                                    vVar.a(new 4(this, string2));
                                    vVar.a(new 5(this, string2));
                                    vVar.a(new 6(this, string2));
                                    vVar.a(new 7(this));
                                    vVar.a(new 8(this));
                                    vVar.a(new 9(this));
                                    this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                                    com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                                    topView = this.mhH.getTopView();
                                    if (topView == null && (topView instanceof AbsoluteLayout)) {
                                        topView.addView(view);
                                        return;
                                    } else {
                                        x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                                    }
                                }
                            }
                            string = str3;
                            if (TextUtils.isEmpty(string)) {
                                string = jSONObject.optString("inputData");
                            }
                            bundle2 = new Bundle();
                            if (pNY) {
                                bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                            }
                            bundle2.putString("app_id", optString);
                            bundle2.putString("msg_id", str2);
                            bundle2.putString("search_id", optString2);
                            bundle2.putString("cache_key", optString4);
                            bundle2.putString("msg_title", optString3);
                            bundle2.putString("msg_path", str);
                            bundle2.putInt("pkg_version", i2);
                            bundle2.putInt("msg_pkg_type", optInt);
                            bundle2.putString("init_data", string);
                            bundle2.putInt("widget_type", 1);
                            bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                            str3 = "scene";
                            if (i != 201) {
                            }
                            bundle2.putInt(str3, i3);
                            bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                            bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                            bundle2.putString("query", jSONObject.optString("wxaData"));
                            bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                            bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                            threeDotsLoadingView.setVisibility(0);
                            imageView.setVisibility(4);
                            threeDotsLoadingView.cAG();
                            bVar.bPS = optString;
                            bVar.bPh = optInt;
                            bVar.fii = i2;
                            bVar.fuL = str2;
                            x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                            currentTimeMillis = System.currentTimeMillis();
                            h.mEJ.a(867, 0, 1, false);
                            vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                            vVar.a(new j(this.context));
                            vVar.a(new 4(this, string2));
                            vVar.a(new 5(this, string2));
                            vVar.a(new 6(this, string2));
                            vVar.a(new 7(this));
                            vVar.a(new 8(this));
                            vVar.a(new 9(this));
                            this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                            com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                            topView = this.mhH.getTopView();
                            if (topView == null) {
                            }
                            x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                        }
                    }
                    str = string;
                    optString2 = jSONObject.optString("searchId");
                    s.jq(optString);
                    if (str.contains("widgetData")) {
                        s.JW();
                    }
                    optString3 = jSONObject.optString("nickName");
                    i2 = jSONObject.getInt("version");
                    if (jSONObject.has("debugMode")) {
                        optInt = jSONObject.optInt("debugMode");
                    } else {
                        optInt = 0;
                    }
                    hVar = h.mEJ;
                    objArr = new Object[3];
                    objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                    objArr[1] = Integer.valueOf(1);
                    objArr[2] = Long.valueOf(System.currentTimeMillis());
                    hVar.h(14452, objArr);
                    bH = this.pNU.bH(this.context);
                    hVar = h.mEJ;
                    objArr = new Object[3];
                    objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(System.currentTimeMillis());
                    hVar.h(14452, objArr);
                    view = (AbsoluteLayout) y.gq(this.context).inflate(R.i.fts_widget_layout, null);
                    view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                    layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                    bH.setLayoutParams(layoutParams);
                    view.addView(bH);
                    frameLayout = (FrameLayout) view.findViewById(R.h.loading_view_layout);
                    frameLayout.setLayoutParams(layoutParams);
                    view.removeView(frameLayout);
                    view.addView(frameLayout);
                    try {
                        bH.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                    } catch (Exception e) {
                        x.e("FTSSearchWidgetMgr", "the color is error : ");
                    }
                    bH.setTag(bq);
                    this.pNP.put(string2, bH);
                    this.pNQ.put(string2, view);
                    this.pNR.put(string2, frameLayout);
                    threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.loading_view);
                    imageView = (ImageView) view.findViewById(R.h.cover_iv);
                    optString4 = jSONObject.optString("wxaData");
                    str2 = optString + "_" + optString4.hashCode();
                    bTN2 = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                    str3 = "";
                    if (bTN2.pPL.containsKey(optString)) {
                        com.tencent.mm.plugin.webview.fts.b.a.a.a aVar22 = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN2.pPL.get(optString);
                        if (aVar22 != null) {
                            string = Uri.encode(aVar22.pPS);
                            if (TextUtils.isEmpty(string)) {
                                string = jSONObject.optString("inputData");
                            }
                            bundle2 = new Bundle();
                            if (pNY) {
                                bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                            }
                            bundle2.putString("app_id", optString);
                            bundle2.putString("msg_id", str2);
                            bundle2.putString("search_id", optString2);
                            bundle2.putString("cache_key", optString4);
                            bundle2.putString("msg_title", optString3);
                            bundle2.putString("msg_path", str);
                            bundle2.putInt("pkg_version", i2);
                            bundle2.putInt("msg_pkg_type", optInt);
                            bundle2.putString("init_data", string);
                            bundle2.putInt("widget_type", 1);
                            bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                            str3 = "scene";
                            i3 = i != 201 ? 1006 : i == 3 ? 1005 : i == 16 ? 1042 : i == 20 ? 1053 : BaseReportManager.MAX_READ_COUNT;
                            bundle2.putInt(str3, i3);
                            bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                            bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                            bundle2.putString("query", jSONObject.optString("wxaData"));
                            bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                            bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                            threeDotsLoadingView.setVisibility(0);
                            imageView.setVisibility(4);
                            threeDotsLoadingView.cAG();
                            bVar.bPS = optString;
                            bVar.bPh = optInt;
                            bVar.fii = i2;
                            bVar.fuL = str2;
                            x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                            currentTimeMillis = System.currentTimeMillis();
                            h.mEJ.a(867, 0, 1, false);
                            vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                            vVar.a(new j(this.context));
                            vVar.a(new 4(this, string2));
                            vVar.a(new 5(this, string2));
                            vVar.a(new 6(this, string2));
                            vVar.a(new 7(this));
                            vVar.a(new 8(this));
                            vVar.a(new 9(this));
                            this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                            com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                            topView = this.mhH.getTopView();
                            if (topView == null && (topView instanceof AbsoluteLayout)) {
                                topView.addView(view);
                                return;
                            } else {
                                x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                            }
                        }
                    }
                    string = str3;
                    if (TextUtils.isEmpty(string)) {
                        string = jSONObject.optString("inputData");
                    }
                    bundle2 = new Bundle();
                    if (pNY) {
                        bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                    }
                    bundle2.putString("app_id", optString);
                    bundle2.putString("msg_id", str2);
                    bundle2.putString("search_id", optString2);
                    bundle2.putString("cache_key", optString4);
                    bundle2.putString("msg_title", optString3);
                    bundle2.putString("msg_path", str);
                    bundle2.putInt("pkg_version", i2);
                    bundle2.putInt("msg_pkg_type", optInt);
                    bundle2.putString("init_data", string);
                    bundle2.putInt("widget_type", 1);
                    bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                    str3 = "scene";
                    if (i != 201) {
                    }
                    bundle2.putInt(str3, i3);
                    bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                    bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                    bundle2.putString("query", jSONObject.optString("wxaData"));
                    bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                    bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                    threeDotsLoadingView.setVisibility(0);
                    imageView.setVisibility(4);
                    threeDotsLoadingView.cAG();
                    bVar.bPS = optString;
                    bVar.bPh = optInt;
                    bVar.fii = i2;
                    bVar.fuL = str2;
                    x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                    currentTimeMillis = System.currentTimeMillis();
                    h.mEJ.a(867, 0, 1, false);
                    vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                    vVar.a(new j(this.context));
                    vVar.a(new 4(this, string2));
                    vVar.a(new 5(this, string2));
                    vVar.a(new 6(this, string2));
                    vVar.a(new 7(this));
                    vVar.a(new 8(this));
                    vVar.a(new 9(this));
                    this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                    com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                    topView = this.mhH.getTopView();
                    if (topView == null) {
                    }
                    x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                }
            }
            try {
                x.i("FTSSearchWidgetMgr", "removew widgetSize " + ((c) this.pNW.remove(string2)));
                optString = jSONObject.optString("appid");
                string = jSONObject.optString("pagePath");
                bTN = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                if (bTN.Qi(optString)) {
                    com.tencent.mm.plugin.webview.fts.b.a.a.a aVar3 = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN.pPL.get(optString);
                    if (aVar3 != null) {
                        str = (string.contains("widgetData") ? com.tencent.mm.plugin.webview.fts.b.a.a.a(Uri.parse(string), "widgetData", Uri.encode(aVar3.pPS)).toString() : string + "&widgetData=" + Uri.encode(aVar3.pPS)) + "&isTestUi=1";
                        optString2 = jSONObject.optString("searchId");
                        s.jq(optString);
                        if (str.contains("widgetData")) {
                            s.JW();
                        }
                        optString3 = jSONObject.optString("nickName");
                        i2 = jSONObject.getInt("version");
                        if (jSONObject.has("debugMode")) {
                            optInt = jSONObject.optInt("debugMode");
                        } else {
                            optInt = 0;
                        }
                        hVar = h.mEJ;
                        objArr = new Object[3];
                        objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Long.valueOf(System.currentTimeMillis());
                        hVar.h(14452, objArr);
                        bH = this.pNU.bH(this.context);
                        hVar = h.mEJ;
                        objArr = new Object[3];
                        objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(System.currentTimeMillis());
                        hVar.h(14452, objArr);
                        view = (AbsoluteLayout) y.gq(this.context).inflate(R.i.fts_widget_layout, null);
                        view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                        layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                        bH.setLayoutParams(layoutParams);
                        view.addView(bH);
                        frameLayout = (FrameLayout) view.findViewById(R.h.loading_view_layout);
                        frameLayout.setLayoutParams(layoutParams);
                        view.removeView(frameLayout);
                        view.addView(frameLayout);
                        bH.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        bH.setTag(bq);
                        this.pNP.put(string2, bH);
                        this.pNQ.put(string2, view);
                        this.pNR.put(string2, frameLayout);
                        threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.loading_view);
                        imageView = (ImageView) view.findViewById(R.h.cover_iv);
                        optString4 = jSONObject.optString("wxaData");
                        str2 = optString + "_" + optString4.hashCode();
                        bTN2 = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                        str3 = "";
                        if (bTN2.pPL.containsKey(optString)) {
                            com.tencent.mm.plugin.webview.fts.b.a.a.a aVar222 = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN2.pPL.get(optString);
                            if (aVar222 != null) {
                                string = Uri.encode(aVar222.pPS);
                                if (TextUtils.isEmpty(string)) {
                                    string = jSONObject.optString("inputData");
                                }
                                bundle2 = new Bundle();
                                if (pNY) {
                                    bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                                }
                                bundle2.putString("app_id", optString);
                                bundle2.putString("msg_id", str2);
                                bundle2.putString("search_id", optString2);
                                bundle2.putString("cache_key", optString4);
                                bundle2.putString("msg_title", optString3);
                                bundle2.putString("msg_path", str);
                                bundle2.putInt("pkg_version", i2);
                                bundle2.putInt("msg_pkg_type", optInt);
                                bundle2.putString("init_data", string);
                                bundle2.putInt("widget_type", 1);
                                bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                                str3 = "scene";
                                i3 = i != 201 ? 1006 : i == 3 ? 1005 : i == 16 ? 1042 : i == 20 ? 1053 : BaseReportManager.MAX_READ_COUNT;
                                bundle2.putInt(str3, i3);
                                bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                                bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                                bundle2.putString("query", jSONObject.optString("wxaData"));
                                bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                                bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                                threeDotsLoadingView.setVisibility(0);
                                imageView.setVisibility(4);
                                threeDotsLoadingView.cAG();
                                bVar.bPS = optString;
                                bVar.bPh = optInt;
                                bVar.fii = i2;
                                bVar.fuL = str2;
                                x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                                currentTimeMillis = System.currentTimeMillis();
                                h.mEJ.a(867, 0, 1, false);
                                vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                                vVar.a(new j(this.context));
                                vVar.a(new 4(this, string2));
                                vVar.a(new 5(this, string2));
                                vVar.a(new 6(this, string2));
                                vVar.a(new 7(this));
                                vVar.a(new 8(this));
                                vVar.a(new 9(this));
                                this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                                com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                                topView = this.mhH.getTopView();
                                if (topView == null && (topView instanceof AbsoluteLayout)) {
                                    topView.addView(view);
                                    return;
                                } else {
                                    x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                                }
                            }
                        }
                        string = str3;
                        if (TextUtils.isEmpty(string)) {
                            string = jSONObject.optString("inputData");
                        }
                        bundle2 = new Bundle();
                        if (pNY) {
                            bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                        }
                        bundle2.putString("app_id", optString);
                        bundle2.putString("msg_id", str2);
                        bundle2.putString("search_id", optString2);
                        bundle2.putString("cache_key", optString4);
                        bundle2.putString("msg_title", optString3);
                        bundle2.putString("msg_path", str);
                        bundle2.putInt("pkg_version", i2);
                        bundle2.putInt("msg_pkg_type", optInt);
                        bundle2.putString("init_data", string);
                        bundle2.putInt("widget_type", 1);
                        bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                        str3 = "scene";
                        if (i != 201) {
                        }
                        bundle2.putInt(str3, i3);
                        bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                        bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                        bundle2.putString("query", jSONObject.optString("wxaData"));
                        bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                        bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                        threeDotsLoadingView.setVisibility(0);
                        imageView.setVisibility(4);
                        threeDotsLoadingView.cAG();
                        bVar.bPS = optString;
                        bVar.bPh = optInt;
                        bVar.fii = i2;
                        bVar.fuL = str2;
                        x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                        currentTimeMillis = System.currentTimeMillis();
                        h.mEJ.a(867, 0, 1, false);
                        vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                        vVar.a(new j(this.context));
                        vVar.a(new 4(this, string2));
                        vVar.a(new 5(this, string2));
                        vVar.a(new 6(this, string2));
                        vVar.a(new 7(this));
                        vVar.a(new 8(this));
                        vVar.a(new 9(this));
                        this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                        com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                        topView = this.mhH.getTopView();
                        if (topView == null) {
                        }
                        x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                    }
                }
                str = string;
                optString2 = jSONObject.optString("searchId");
                s.jq(optString);
                if (str.contains("widgetData")) {
                    s.JW();
                }
                optString3 = jSONObject.optString("nickName");
                i2 = jSONObject.getInt("version");
                if (jSONObject.has("debugMode")) {
                    optInt = 0;
                } else {
                    optInt = jSONObject.optInt("debugMode");
                }
                hVar = h.mEJ;
                objArr = new Object[3];
                objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Long.valueOf(System.currentTimeMillis());
                hVar.h(14452, objArr);
                bH = this.pNU.bH(this.context);
                hVar = h.mEJ;
                objArr = new Object[3];
                objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(System.currentTimeMillis());
                hVar.h(14452, objArr);
                view = (AbsoluteLayout) y.gq(this.context).inflate(R.i.fts_widget_layout, null);
                view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                bH.setLayoutParams(layoutParams);
                view.addView(bH);
                frameLayout = (FrameLayout) view.findViewById(R.h.loading_view_layout);
                frameLayout.setLayoutParams(layoutParams);
                view.removeView(frameLayout);
                view.addView(frameLayout);
                bH.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                bH.setTag(bq);
                this.pNP.put(string2, bH);
                this.pNQ.put(string2, view);
                this.pNR.put(string2, frameLayout);
                threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.loading_view);
                imageView = (ImageView) view.findViewById(R.h.cover_iv);
                optString4 = jSONObject.optString("wxaData");
                str2 = optString + "_" + optString4.hashCode();
                bTN2 = com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                str3 = "";
                if (bTN2.pPL.containsKey(optString)) {
                    com.tencent.mm.plugin.webview.fts.b.a.a.a aVar2222 = (com.tencent.mm.plugin.webview.fts.b.a.a.a) bTN2.pPL.get(optString);
                    if (aVar2222 != null) {
                        string = Uri.encode(aVar2222.pPS);
                        if (TextUtils.isEmpty(string)) {
                            string = jSONObject.optString("inputData");
                        }
                        bundle2 = new Bundle();
                        if (pNY) {
                            bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                        }
                        bundle2.putString("app_id", optString);
                        bundle2.putString("msg_id", str2);
                        bundle2.putString("search_id", optString2);
                        bundle2.putString("cache_key", optString4);
                        bundle2.putString("msg_title", optString3);
                        bundle2.putString("msg_path", str);
                        bundle2.putInt("pkg_version", i2);
                        bundle2.putInt("msg_pkg_type", optInt);
                        bundle2.putString("init_data", string);
                        bundle2.putInt("widget_type", 1);
                        bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                        str3 = "scene";
                        i3 = i != 201 ? 1006 : i == 3 ? 1005 : i == 16 ? 1042 : i == 20 ? 1053 : BaseReportManager.MAX_READ_COUNT;
                        bundle2.putInt(str3, i3);
                        bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                        bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                        bundle2.putString("query", jSONObject.optString("wxaData"));
                        bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                        bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                        threeDotsLoadingView.setVisibility(0);
                        imageView.setVisibility(4);
                        threeDotsLoadingView.cAG();
                        bVar.bPS = optString;
                        bVar.bPh = optInt;
                        bVar.fii = i2;
                        bVar.fuL = str2;
                        x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                        currentTimeMillis = System.currentTimeMillis();
                        h.mEJ.a(867, 0, 1, false);
                        vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                        vVar.a(new j(this.context));
                        vVar.a(new 4(this, string2));
                        vVar.a(new 5(this, string2));
                        vVar.a(new 6(this, string2));
                        vVar.a(new 7(this));
                        vVar.a(new 8(this));
                        vVar.a(new 9(this));
                        this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                        com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                        topView = this.mhH.getTopView();
                        if (topView == null && (topView instanceof AbsoluteLayout)) {
                            topView.addView(view);
                            return;
                        } else {
                            x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                        }
                    }
                }
                string = str3;
                if (TextUtils.isEmpty(string)) {
                    string = jSONObject.optString("inputData");
                }
                bundle2 = new Bundle();
                if (pNY) {
                    bundle2.putString("exec_process_name", "com.tencent.mm:tools");
                }
                bundle2.putString("app_id", optString);
                bundle2.putString("msg_id", str2);
                bundle2.putString("search_id", optString2);
                bundle2.putString("cache_key", optString4);
                bundle2.putString("msg_title", optString3);
                bundle2.putString("msg_path", str);
                bundle2.putInt("pkg_version", i2);
                bundle2.putInt("msg_pkg_type", optInt);
                bundle2.putString("init_data", string);
                bundle2.putInt("widget_type", 1);
                bundle2.putInt("service_type", jSONObject.optInt("serviceType"));
                str3 = "scene";
                if (i != 201) {
                }
                bundle2.putInt(str3, i3);
                bundle2.putInt("view_init_width", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                bundle2.putInt("view_init_height", com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                bundle2.putString("query", jSONObject.optString("wxaData"));
                bundle2.putString("preload_launch_data", jSONObject.optString("launchwxawidget"));
                bundle2.putBoolean("is_testing_ui", com.tencent.mm.plugin.webview.fts.b.a.a.bTN().Qi(optString));
                threeDotsLoadingView.setVisibility(0);
                imageView.setVisibility(4);
                threeDotsLoadingView.cAG();
                bVar.bPS = optString;
                bVar.bPh = optInt;
                bVar.fii = i2;
                bVar.fuL = str2;
                x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                currentTimeMillis = System.currentTimeMillis();
                h.mEJ.a(867, 0, 1, false);
                vVar = new v(new 3(this, bq, threeDotsLoadingView, imageView, string2, optString, currentTimeMillis));
                vVar.a(new j(this.context));
                vVar.a(new 4(this, string2));
                vVar.a(new 5(this, string2));
                vVar.a(new 6(this, string2));
                vVar.a(new 7(this));
                vVar.a(new 8(this));
                vVar.a(new 9(this));
                this.pNS.put(this.pNU.a(bq, bH, bundle2, vVar), string2);
                com.tencent.mm.bu.a.post(new 10(this, optString, threeDotsLoadingView, string2, bq, bH, view, jSONObject));
                topView = this.mhH.getTopView();
                if (topView == null) {
                }
                x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
            } catch (Exception e2) {
                x.e("FTSSearchWidgetMgr", "this is has a error" + e2.toString());
            }
        } catch (JSONException e3) {
            x.e("FTSSearchWidgetMgr", "parse json and init dynamicPageService is error!");
        }
    }

    private void Qe(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private boolean a(Context context, String str, Map<String, String> map) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                if (!(context instanceof Activity)) {
                    context = this.context;
                }
                for (Entry entry : map.entrySet()) {
                    launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                }
                com.tencent.mm.bu.a.post(new 1(this, context, launchIntentForPackage));
                return true;
            }
        } catch (Throwable e) {
            x.e("FTSSearchWidgetMgr", bi.i(e));
        }
        return false;
    }

    public final void N(Bundle bundle) {
        Qf(bundle.getString("fts_key_widget_view_cache_key"));
    }

    private void Qf(String str) {
        if (str != null && str.length() > 0) {
            View view = (View) this.pNP.get(str);
            if (view == null) {
                x.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[]{str});
                return;
            }
            x.i("FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[]{view.getTag().toString()});
            if (this.pNU != null) {
                this.pNU.a((String) view.getTag(), view);
            }
            this.pNP.remove(str);
            this.pNR.remove(str);
            view = (View) this.pNQ.get(str);
            if (view != null) {
                ViewGroup topView = this.mhH.getTopView();
                if (topView != null && (topView instanceof AbsoluteLayout)) {
                    topView.removeView(view);
                }
                this.pNQ.remove(str);
            }
        }
    }

    public final void O(Bundle bundle) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        x.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", new Object[]{string2, string});
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (string2 != null && string2.length() > 0) {
                View view = (View) this.pNP.get(string2);
                View view2 = (View) this.pNQ.get(string2);
                if (view != null) {
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                    LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        View view3 = (View) this.pNR.get(string2);
                        x.i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.optInt("height"))), Integer.valueOf(layoutParams.width), Integer.valueOf(com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.optInt("width")))});
                        if (!(layoutParams.height == com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.optInt("height")) && r2 == r6)) {
                            LayoutParams layoutParams3 = view.getLayoutParams();
                            LayoutParams layoutParams4 = view3.getLayoutParams();
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{r3, r11});
                            ofInt.setDuration(300);
                            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                            ofInt.addUpdateListener(new 2(this, layoutParams3, view, layoutParams4, view3));
                            ofInt.start();
                        }
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = com.tencent.mm.bp.a.fromDPToPix(this.context, jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Throwable e) {
                            x.e("FTSSearchWidgetMgr", bi.i(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
        } catch (Exception e2) {
            x.e("FTSSearchWidgetMgr", "the error is e");
        }
    }

    public final void onResume() {
        if (this.pNU != null) {
            for (String str : this.pNP.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.l(e.class)).JM().jk((String) ((View) this.pNP.get(str)).getTag());
                }
            }
        }
    }

    public final void onPause() {
        if (this.pNU != null) {
            for (String str : this.pNP.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.l(e.class)).JM().jj((String) ((View) this.pNP.get(str)).getTag());
                }
            }
        }
    }

    public final void onDestroy() {
        try {
            if (this.pNU != null) {
                x.i("FTSSearchWidgetMgr", "remove all widget count %d", new Object[]{Integer.valueOf(this.pNP.size())});
                for (String str : new HashMap(this.pNP).keySet()) {
                    if (str != null && str.length() > 0) {
                        this.pNU.jl((String) ((View) this.pNP.get(str)).getTag());
                        if (((View) this.pNQ.get(str)) != null) {
                            Qf(str);
                            this.pNQ.remove(str);
                        }
                    }
                }
                this.pNP.clear();
                this.pNR.clear();
            }
        } catch (Throwable e) {
            x.e("FTSSearchWidgetMgr", bi.i(e));
        }
    }
}
