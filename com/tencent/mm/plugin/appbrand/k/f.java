package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class f {
    private int gkB;
    SSLContext gkD;
    final String gkE;
    protected final ArrayList<String> gkF = new ArrayList();
    private final ArrayList<g> gle = new ArrayList();
    String mAppId;

    public f(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.gkB = appBrandSysConfig.fqU;
        this.gkE = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14, java.util.Map<java.lang.String, java.lang.String> r15, java.util.ArrayList<java.lang.String> r16, com.tencent.mm.plugin.appbrand.k.f.a r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        r10 = this;
        r1 = "url";
        r3 = r14.optString(r1);
        r1 = "name";
        r4 = r14.optString(r1);
        r9 = com.tencent.mm.plugin.appbrand.k.i.y(r14);
        r2 = r10.gle;
        monitor-enter(r2);
        r1 = r10.gle;	 Catch:{ all -> 0x004b }
        r1 = r1.size();	 Catch:{ all -> 0x004b }
        r5 = r10.gkB;	 Catch:{ all -> 0x004b }
        if (r1 < r5) goto L_0x0032;
    L_0x001f:
        r1 = "tasked refused max connected";
        r0 = r17;
        r0.tS(r1);	 Catch:{ all -> 0x004b }
        r1 = "MicroMsg.AppBrandNetworkUpload";
        r3 = "max connected";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);	 Catch:{ all -> 0x004b }
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
    L_0x0031:
        return;
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 == 0) goto L_0x004e;
    L_0x0039:
        r1 = "fileName error";
        r0 = r17;
        r0.tS(r1);
        r1 = "MicroMsg.AppBrandNetworkUpload";
        r2 = "fileName error";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        goto L_0x0031;
    L_0x004b:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
        throw r1;
    L_0x004e:
        r1 = new com.tencent.mm.plugin.appbrand.k.g;
        r2 = r13;
        r5 = r20;
        r6 = r11;
        r7 = r12;
        r8 = r17;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r1.gli = r9;
        r1.gkX = r15;
        r0 = r16;
        r1.gkY = r0;
        r2 = 1;
        r1.bgH = r2;
        r0 = r18;
        r1.fEl = r0;
        r0 = r19;
        r1.glc = r0;
        r2 = r10.gle;
        monitor-enter(r2);
        r3 = r10.gle;	 Catch:{ all -> 0x0082 }
        r3.add(r1);	 Catch:{ all -> 0x0082 }
        monitor-exit(r2);	 Catch:{ all -> 0x0082 }
        r2 = new com.tencent.mm.plugin.appbrand.k.f$b;
        r2.<init>(r10, r1);
        r1 = "appbrand_upload_thread";
        com.tencent.mm.sdk.f.e.post(r2, r1);
        goto L_0x0031;
    L_0x0082:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0082 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.k.f.a(int, java.lang.String, java.lang.String, org.json.JSONObject, java.util.Map, java.util.ArrayList, com.tencent.mm.plugin.appbrand.k.f$a, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final g uM(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.gle) {
            Iterator it = this.gle.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (str.equals(gVar.fEl)) {
                    return gVar;
                }
            }
            return null;
        }
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.gkF.add(gVar.fEl);
            gVar.bgH = false;
            a(gVar.fEl, gVar.glb);
        }
    }

    public final boolean uG(String str) {
        return this.gkF.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        if (str != null) {
            synchronized (this.gle) {
                Iterator it = this.gle.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (str.equals(gVar.fEl)) {
                        this.gle.remove(gVar);
                        break;
                    }
                }
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }
}
