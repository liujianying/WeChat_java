package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.audio.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    private static final Set<String> gru = new HashSet();
    private static final String[] grv = new String[]{"addMapCircles", "addMapControls", c.NAME, "addMapMarkers", "createAudioInstance", "createRequestTask", "createSocketTask", "destroyAudioInstance", "disableScrollBounce", "drawCanvas", f.NAME, "getCurrentRoute", "getMapCenterLocation", "getStorage", "getStorageSync", "getSystemInfo", "hideToast", "moveToMapLocation", "onAccelerometerChange", "onCompassChange", "onKeyboardValueChange", "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", com.tencent.mm.plugin.appbrand.jsapi.audio.h.NAME, "operateSocketTask", "removeStorageSync", "reportIDKey", com.tencent.mm.plugin.appbrand.jsapi.l.c.NAME, "reportRealtimeAction", "setAudioState", "setStorage", "setStorageSync", "showModal", "showToast", "syncAudioEvent", "updateCanvas", "updateMap", "traceEvent"};
    private static final Set<String> grw = new HashSet(Arrays.asList(grv));
    private static final ThreadPoolExecutor grx = new 2(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new 1());
    private static final b gry = new b((byte) 0);
    private static final Pattern grz = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    private static final class a implements Runnable {
        String appId;
        String bGH;
        String bPu;
        String fII;
        String grA;
        int grB;
        long grC;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(this.appId);
            if (qb == null) {
                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
            } else if (!h.grw.contains(this.grA)) {
                String str = "";
                if (!(bi.oW(this.fII) || bi.oW(this.grA))) {
                    try {
                        com.tencent.mm.v.c fV = g.fV(this.fII);
                        if (fV.has("url") && (this.grA.equals("openLink") || this.grA.equals("redirectTo") || this.grA.equals("navigateTo") || this.grA.equals("request") || this.grA.equals("connectSocket") || this.grA.equals("uploadFile") || this.grA.equals("downloadFile"))) {
                            str = fV.optString("url");
                        } else if (this.grA.equals(d.NAME)) {
                            try {
                                com.tencent.mm.v.a fW = g.fW(fV.optString("scope"));
                                LinkedList linkedList = new LinkedList();
                                for (int i = 0; i < fW.length(); i++) {
                                    linkedList.add(fW.optString(i));
                                }
                                str = linkedList.toString();
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", new Object[]{e.getMessage()});
                                return;
                            }
                        } else if (this.grA.equals("shareAppMessage")) {
                            try {
                                str = URLEncoder.encode(bi.oV(fV.toString()), "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "", new Object[0]);
                            }
                        } else if (this.grA.equals(e.NAME)) {
                            str = fV.optString("package");
                        } else if (this.grA.equals("reportSubmitForm")) {
                            str = k.qu(this.appId).fdG;
                        } else if (this.grA.equals("makePhoneCall")) {
                            str = fV.optString("phoneNumber");
                        } else if (this.grA.equals("chooseVideo")) {
                            str = fV.optString("maxDuration");
                        } else if (this.grA.equals("updateHTMLWebView")) {
                            str = fV.optString("src");
                            try {
                                str = URLEncoder.encode(fV.optString("src"), "UTF-8");
                            } catch (Exception e3) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3.toString());
                            }
                        }
                    } catch (com.tencent.mm.v.f e4) {
                        x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e4, "get keyParam error!", new Object[0]);
                    }
                }
                String str2 = "";
                if (!bi.oW(this.bGH) && this.bGH.contains(".html")) {
                    str2 = this.bGH.substring(0, this.bGH.lastIndexOf(".html") + 5);
                }
                String str3 = "";
                try {
                    str3 = URLEncoder.encode(bi.oV(str2), "UTF-8");
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e5, "encode page path error!", new Object[0]);
                }
                String str4 = "";
                try {
                    str4 = URLEncoder.encode(bi.oV(str), "UTF-8");
                } catch (Throwable e6) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e6, "encode keyParam path error!", new Object[0]);
                }
                String oV = bi.oV(this.grA);
                int vt = h.vt(h.vs(this.bPu));
                String oV2 = bi.oV(qb.bGG);
                String cH = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
                if (qb.scene == 0) {
                    qb.scene = 1000;
                }
                AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(this.appId);
                if (qa != null) {
                    int i2 = qa.frm.fii;
                    int i3 = qa.frm.fih + 1;
                    int vn = com.tencent.mm.plugin.appbrand.report.a.vn(this.appId);
                    x.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d", new Object[]{Integer.valueOf(qb.scene), oV2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str2, cH, oV, str, Integer.valueOf(vt), Integer.valueOf(this.grB), Integer.valueOf(0), Long.valueOf(this.grC), Integer.valueOf(0), r8, Integer.valueOf(qb.gqK), Integer.valueOf(vn)});
                    Object[] objArr = new Object[]{Integer.valueOf(qb.scene), oV2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str3, cH, oV, str4, Integer.valueOf(vt), Integer.valueOf(this.grB), Integer.valueOf(0), Long.valueOf(this.grC), Integer.valueOf(0), r8, Integer.valueOf(qb.gqK), Integer.valueOf(qb.cbB), qb.cbC, Integer.valueOf(vn)};
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13542, objArr);
                    if (h.gru.contains(oV)) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15007, objArr);
                    }
                }
            }
        }
    }

    static /* synthetic */ String vs(String str) {
        if (!bi.oW(str)) {
            Matcher matcher = grz.matcher(str);
            if (matcher.matches()) {
                return bi.oV(matcher.group(1));
            }
        }
        return "";
    }

    static /* synthetic */ int vt(String str) {
        return (bi.oW(str) || str.startsWith("ok") || !str.startsWith("fail")) ? 1 : 2;
    }

    public static void amK() {
    }

    static {
        InputStream open;
        try {
            open = ad.getContext().getAssets().open("15007_api_list.txt");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "open read 15007_api_list.txt", new Object[0]);
            open = null;
        }
        if (open != null) {
            Closeable inputStreamReader = new InputStreamReader(open);
            Closeable bufferedReader = new BufferedReader(inputStreamReader);
            loop0:
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break loop0;
                    } else if (!bi.oW(readLine)) {
                        gru.add(readLine);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "readLine()", new Object[0]);
                } finally {
                    bi.d(bufferedReader);
                    bi.d(inputStreamReader);
                }
            }
        }
    }

    public static boolean adV(String str) {
        if (grw.contains(str)) {
            return true;
        }
        return false;
    }

    public static void a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        if (!bi.oW(str)) {
            Runnable amO = gry.amO();
            amO.appId = str;
            amO.bGH = str2;
            amO.grA = str3;
            amO.fII = str4;
            amO.grB = i;
            amO.grC = j;
            amO.bPu = str5;
            grx.submit(amO);
        }
    }
}
