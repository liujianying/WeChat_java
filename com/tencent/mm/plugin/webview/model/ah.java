package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ah {
    private int pRQ = -1;
    public ArrayList<String> pRR = new ArrayList();
    public ArrayList<String> pRS = new ArrayList();
    public List<Integer> pRT = new ArrayList();
    public final Map<String, Boolean> pRU = new HashMap();
    public final Set<String> pRV = new HashSet();
    public String pRW = null;

    public final m a(String str, boolean z, d dVar) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (str.startsWith("weixin://bridge.js")) {
            return b(dVar);
        } else {
            if (str.startsWith("weixin://resourceid/")) {
                x.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
                try {
                    return new m("image/*", "utf-8", aj.Qw(dVar.cx(str, 1)));
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                    return null;
                }
            }
            if (z) {
                int intValue;
                if (!bi.oW(str) && p.vN(str)) {
                    String toLowerCase = str.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains("::1") || toLowerCase.contains(s.cfB())) {
                        if (this.pRT != null && this.pRT.size() > 0) {
                            for (Integer intValue2 : this.pRT) {
                                intValue = intValue2.intValue();
                                if (!toLowerCase.contains("localhost:" + intValue)) {
                                    if (toLowerCase.contains("127.0.0.1:" + intValue)) {
                                    }
                                }
                                x.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[]{toLowerCase, Integer.valueOf(intValue)});
                            }
                        }
                        x.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[]{toLowerCase});
                        intValue = 1;
                    }
                    intValue = 0;
                    break;
                }
                intValue = 0;
                if (intValue != 0) {
                    x.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[]{str});
                    return new m("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
                }
            }
            if (!c(str, dVar)) {
                return null;
            }
            x.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[]{str});
            return new m("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        }
    }

    private boolean c(String str, d dVar) {
        Iterator it;
        if (this.pRQ == -1) {
            try {
                Bundle g = dVar.g(31, null);
                if (g != null) {
                    this.pRQ = g.getInt("webview_ad_intercept_control_flag");
                    this.pRR = g.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.pRS = g.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.pRR.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.pRS.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    x.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[]{e.getMessage()});
                this.pRQ = 0;
            }
        }
        if (this.pRQ == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        x.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[]{host, this.pRU.get(host)});
        if (bi.oW(host)) {
            return false;
        }
        if (this.pRU.containsKey(host)) {
            return ((Boolean) this.pRU.get(host)).booleanValue();
        }
        if (this.pRR != null && this.pRR.size() > 0) {
            it = this.pRR.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    this.pRU.put(host, Boolean.valueOf(false));
                    x.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                    return false;
                }
            }
        }
        if (this.pRS != null && this.pRS.size() > 0) {
            it = this.pRS.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bi.oW(str2) && host.contains(str2)) {
                    if (this.pRQ == 1) {
                        this.pRU.put(host, Boolean.valueOf(true));
                        x.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[]{str2, str});
                        return true;
                    } else if (this.pRQ == 2) {
                        x.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[]{str2, str});
                        this.pRV.add(host);
                        this.pRU.put(host, Boolean.valueOf(false));
                        return false;
                    }
                }
            }
        }
        this.pRU.put(host, Boolean.valueOf(false));
        return false;
    }

    private m b(d dVar) {
        try {
            if (dVar.g(98, null) == null) {
                return null;
            }
            try {
                String convertStreamToString = bi.convertStreamToString(ad.getContext().getAssets().open("jsapi/wxjs.js"));
                if (!TextUtils.isEmpty(this.pRW)) {
                    convertStreamToString = convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.pRW).replace("__wx._isDgtVerifyEnabled()", "true");
                }
                m mVar = new m("application/javascript", "utf-8", new ByteArrayInputStream(convertStreamToString.getBytes("UTF-8")));
                Map hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
                hashMap.put("Pragma", "no-cache");
                hashMap.put("Expires", "0");
                mVar.mResponseHeaders = hashMap;
                return mVar;
            } catch (Exception e) {
                x.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", new Object[]{e});
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
