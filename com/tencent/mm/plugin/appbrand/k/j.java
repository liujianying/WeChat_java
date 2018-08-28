package com.tencent.mm.plugin.appbrand.k;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private SSLSocketFactory ftE;
    private int gkB;
    private final String gkE;
    protected final ArrayList<a> glp = new ArrayList();
    private String mAppId;

    public j(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        SSLContext uP = i.uP(str);
        if (uP != null) {
            this.ftE = uP.getSocketFactory();
        }
        this.gkE = str2;
        this.gkB = appBrandSysConfig.fqW;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, int r11, org.json.JSONObject r12, java.util.Map<java.lang.String, java.lang.String> r13, final com.tencent.mm.plugin.appbrand.k.j.a r14) {
        /*
        r9 = this;
        r1 = r9.glp;
        monitor-enter(r1);
        r0 = r9.glp;	 Catch:{ all -> 0x0111 }
        r0 = r0.size();	 Catch:{ all -> 0x0111 }
        r2 = r9.gkB;	 Catch:{ all -> 0x0111 }
        if (r0 < r2) goto L_0x001e;
    L_0x000d:
        r0 = "max connected";
        r14.sn(r0);	 Catch:{ all -> 0x0111 }
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "max connected";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0111 }
        monitor-exit(r1);	 Catch:{ all -> 0x0111 }
    L_0x001d:
        return;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0111 }
        r0 = "url";
        r6 = r12.optString(r0);
        r2 = new java.net.URI;	 Catch:{ Exception -> 0x0114 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0114 }
        r0 = "tcpNoDelay";
        r1 = 0;
        r8 = r12.optBoolean(r0, r1);
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r1 = "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r6;
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r11);
        r3[r4] = r5;
        r4 = 2;
        r5 = java.lang.Boolean.valueOf(r8);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r0 = "User-Agent";
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = r9.gkE;
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.aV(r1, r3);
        r13.put(r0, r1);
        r0 = z(r12);
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x007f;
    L_0x006a:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r3 = "protocols %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = "Sec-WebSocket-Protocol";
        r13.put(r1, r0);
    L_0x007f:
        r0 = r2.getScheme();
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x0130;
    L_0x0089:
        r0 = 0;
    L_0x008a:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x00a5;
    L_0x0090:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r3 = "Origin %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = "Origin";
        r13.put(r1, r0);
    L_0x00a5:
        r0 = new com.tencent.mm.plugin.appbrand.k.j$1;	 Catch:{ Exception -> 0x00f1 }
        r3 = new com.tencent.mm.plugin.appbrand.s.b.d;	 Catch:{ Exception -> 0x00f1 }
        r3.<init>();	 Catch:{ Exception -> 0x00f1 }
        r1 = r9;
        r4 = r13;
        r5 = r11;
        r7 = r14;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00f1 }
        r0.fEl = r10;	 Catch:{ Exception -> 0x00f1 }
        r0.gCI = r8;	 Catch:{ Exception -> 0x00f1 }
        r1 = "ws://";
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.fj(r6, r1);	 Catch:{ Exception -> 0x00f1 }
        if (r1 == 0) goto L_0x0194;
    L_0x00c0:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url is %s ,user ws connect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00f1 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00f1 }
        r1 = new java.net.Socket;	 Catch:{ Exception -> 0x00f1 }
        r2 = java.net.Proxy.NO_PROXY;	 Catch:{ Exception -> 0x00f1 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00f1 }
        r0.a(r1);	 Catch:{ Exception -> 0x00f1 }
        r0.connect();	 Catch:{ Exception -> 0x00f1 }
        r9.a(r0);	 Catch:{ Exception -> 0x00f1 }
        r1 = new java.util.Timer;	 Catch:{ Exception -> 0x00f1 }
        r1.<init>();	 Catch:{ Exception -> 0x00f1 }
        r2 = new com.tencent.mm.plugin.appbrand.k.j$2;	 Catch:{ Exception -> 0x00f1 }
        r2.<init>(r9, r14, r0, r1);	 Catch:{ Exception -> 0x00f1 }
        r0.bno = r1;	 Catch:{ Exception -> 0x00f1 }
        r4 = (long) r11;	 Catch:{ Exception -> 0x00f1 }
        r1.schedule(r2, r4);	 Catch:{ Exception -> 0x00f1 }
        goto L_0x001d;
    L_0x00f1:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url %s exception %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r6;
        r4 = 1;
        r5 = r0.toString();
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        r0 = r0.getMessage();
        r14.sl(r0);
        goto L_0x001d;
    L_0x0111:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0111 }
        throw r0;
    L_0x0114:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "connect fail : %s ";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r0.toString();
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        r0 = "url not well format";
        r14.sn(r0);
        goto L_0x001d;
    L_0x0130:
        r1 = "wss";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0185;
    L_0x0139:
        r0 = "https";
    L_0x013c:
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r3 = "://";
        r1.append(r3);
        r3 = r2.getHost();
        r1.append(r3);
        r3 = r2.getPort();
        r4 = -1;
        if (r3 == r4) goto L_0x016f;
    L_0x0155:
        r4 = "http";
        r4 = r0.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0162;
    L_0x015e:
        r4 = 80;
        if (r3 == r4) goto L_0x016f;
    L_0x0162:
        r4 = "https";
        r0 = r0.equalsIgnoreCase(r4);
        if (r0 == 0) goto L_0x0192;
    L_0x016b:
        r0 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        if (r3 != r0) goto L_0x0192;
    L_0x016f:
        r0 = 1;
    L_0x0170:
        if (r0 != 0) goto L_0x017f;
    L_0x0172:
        r0 = ":";
        r1.append(r0);
        r0 = r2.getPort();
        r1.append(r0);
    L_0x017f:
        r0 = r1.toString();
        goto L_0x008a;
    L_0x0185:
        r1 = "ws";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x013c;
    L_0x018e:
        r0 = "http";
        goto L_0x013c;
    L_0x0192:
        r0 = 0;
        goto L_0x0170;
    L_0x0194:
        r1 = "wss://";
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.fj(r6, r1);	 Catch:{ Exception -> 0x00f1 }
        if (r1 == 0) goto L_0x01d8;
    L_0x019d:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url is %s ,user wss connect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00f1 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00f1 }
        r1 = r9.ftE;	 Catch:{ Exception -> 0x00f1 }
        if (r1 == 0) goto L_0x01d1;
    L_0x01b0:
        r1 = r9.ftE;	 Catch:{ Exception -> 0x00f1 }
    L_0x01b2:
        r1 = r1.createSocket();	 Catch:{ Exception -> 0x00f1 }
        r0.a(r1);	 Catch:{ Exception -> 0x00f1 }
        r0.connect();	 Catch:{ Exception -> 0x00f1 }
        r9.a(r0);	 Catch:{ Exception -> 0x00f1 }
        r1 = new java.util.Timer;	 Catch:{ Exception -> 0x00f1 }
        r1.<init>();	 Catch:{ Exception -> 0x00f1 }
        r2 = new com.tencent.mm.plugin.appbrand.k.j$3;	 Catch:{ Exception -> 0x00f1 }
        r2.<init>(r14, r0, r1);	 Catch:{ Exception -> 0x00f1 }
        r0.bno = r1;	 Catch:{ Exception -> 0x00f1 }
        r4 = (long) r11;	 Catch:{ Exception -> 0x00f1 }
        r1.schedule(r2, r4);	 Catch:{ Exception -> 0x00f1 }
        goto L_0x001d;
    L_0x01d1:
        r1 = javax.net.ssl.SSLSocketFactory.getDefault();	 Catch:{ Exception -> 0x00f1 }
        r1 = (javax.net.ssl.SSLSocketFactory) r1;	 Catch:{ Exception -> 0x00f1 }
        goto L_0x01b2;
    L_0x01d8:
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r1 = "url error: %s not ws:// or wss://";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00f1 }
        r3 = 0;
        r2[r3] = r6;	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x00f1 }
        r0 = "url not ws or wss";
        r14.sn(r0);	 Catch:{ Exception -> 0x00f1 }
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.k.j.a(java.lang.String, int, org.json.JSONObject, java.util.Map, com.tencent.mm.plugin.appbrand.k.j$a):void");
    }

    private void a(a aVar) {
        synchronized (this.glp) {
            if ("0".equals(aVar.fEl)) {
                this.glp.clear();
            }
            this.glp.add(aVar);
        }
    }

    public final synchronized void b(a aVar) {
        if (aVar != null) {
            synchronized (this.glp) {
                this.glp.remove(aVar);
            }
        }
    }

    public static void c(a aVar) {
        if (aVar != null) {
            Timer timer = aVar.bno;
            x.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
            if (timer != null) {
                timer.cancel();
                aVar.bno = null;
            }
        }
    }

    private static String z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterable linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        return !bi.cX(linkedList) ? TextUtils.join(", ", linkedList) : null;
    }

    public final a uS(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.glp) {
            Iterator it = this.glp.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.fEl)) {
                    return aVar;
                }
            }
            return null;
        }
    }
}
