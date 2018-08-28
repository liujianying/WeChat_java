package com.tencent.mm.plugin.appbrand.k.a;

import com.tencent.mm.plugin.appbrand.b.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.SSLContext;

public final class b implements Runnable {
    private String appId;
    public volatile boolean bgH = false;
    public int dkb = 60000;
    public String fEl;
    private String filename;
    public SSLContext gkD;
    private final String gkE;
    public ArrayList<String> gkY;
    private int gkZ = 15;
    public Map<String, String> glA;
    public volatile int glB;
    private long glC;
    private HttpURLConnection glD;
    public String glc;
    private final a glz;
    private long startTime;
    private String uri;

    /* renamed from: com.tencent.mm.plugin.appbrand.k.a.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fjn = new int[a.values().length];

        static {
            try {
                fjn[a.fjg.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fjn[a.fjh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(String str, String str2, String str3, String str4, a aVar) {
        this.appId = str;
        this.uri = str2;
        this.filename = str3;
        this.glz = aVar;
        this.startTime = System.currentTimeMillis();
        this.gkE = str4;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r27 = this;
        r0 = r27;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpsUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x000a:
        r0 = r27;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x0014:
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "downloadFile protocol must be http or https";
        r2.G(r3, r4, r5);
    L_0x0026:
        return;
    L_0x0027:
        r0 = r27;
        r2 = r0.gkY;
        if (r2 == 0) goto L_0x0061;
    L_0x002d:
        r0 = r27;
        r2 = r0.gkY;
        r0 = r27;
        r3 = r0.uri;
        r2 = com.tencent.mm.plugin.appbrand.k.i.b(r2, r3);
        if (r2 != 0) goto L_0x0061;
    L_0x003b:
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "url not in domain list";
        r2.G(r3, r4, r5);
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r27;
        r6 = r0.uri;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        goto L_0x0026;
    L_0x0061:
        r25 = 0;
        r11 = 0;
        r22 = 0;
        r0 = r27;
        r2 = r0.bgH;
        if (r2 != 0) goto L_0x009b;
    L_0x006c:
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "force stop";
        r2.G(r3, r4, r5);
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r27.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0026;
    L_0x009b:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r0.glC = r2;
        r20 = 0;
        r19 = 0;
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r2.bG(r3, r4);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r5 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r5.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "url is %s ,filename is %s , start download";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = r5.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r0.glD = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r2 == 0) goto L_0x0119;
    L_0x00f7:
        r0 = r27;
        r2 = r0.gkD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r2 == 0) goto L_0x0119;
    L_0x00fd:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r3 = r0.gkD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r3 = r0.gkY;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        com.tencent.mm.plugin.appbrand.k.i.a(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
    L_0x0119:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r3 = r0.dkb;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r3 = r0.dkb;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = 0;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = "Accept-Encoding";
        r4 = "gzip";
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glA;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r2 == 0) goto L_0x024e;
    L_0x0152:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "url %s : set header ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glA;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = r2.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r6 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
    L_0x016d:
        r2 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r2 == 0) goto L_0x024e;
    L_0x0173:
        r2 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r7 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r7.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "filename %s : key:%s ,value %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r8 = 0;
        r0 = r27;
        r9 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r8 = 1;
        r9 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r8 = 2;
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r7[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        goto L_0x016d;
    L_0x01ae:
        r2 = move-exception;
        r13 = r19;
        r14 = r20;
        r16 = r22;
        r15 = r11;
        r12 = r25;
    L_0x01b8:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x1224 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x1224 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x1224 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x1224 }
        r5[r6] = r7;	 Catch:{ all -> 0x1224 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x1224 }
        r5[r6] = r7;	 Catch:{ all -> 0x1224 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x1224 }
        r5[r6] = r7;	 Catch:{ all -> 0x1224 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x1224 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ all -> 0x1224 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ all -> 0x1224 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ all -> 0x1224 }
        r5 = "unsupport encoding error";
        r2.G(r3, r4, r5);	 Catch:{ all -> 0x1224 }
        if (r12 == 0) goto L_0x0b38;
    L_0x01f9:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0234:
        if (r13 == 0) goto L_0x0239;
    L_0x0236:
        r13.close();	 Catch:{ IOException -> 0x0b75 }
    L_0x0239:
        if (r14 == 0) goto L_0x023e;
    L_0x023b:
        r14.close();	 Catch:{ IOException -> 0x0b84, ArrayIndexOutOfBoundsException -> 0x0b93, Throwable -> 0x0ba2 }
    L_0x023e:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x024e:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = "User-Agent";
        r4 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r6 = r0.gkE;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.aV(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.f(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r3 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3.t(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r8 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = "Content-Type";
        r2 = r2.getHeaderField(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.a.Uj(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r4 != 0) goto L_0x03af;
    L_0x0291:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.Ui(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r26 = r2;
    L_0x0297:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r24 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x02af;
    L_0x02a5:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 16;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
    L_0x02af:
        r2 = 28;
        r3 = 100;
        r0 = r24;
        if (r0 < r3) goto L_0x03ce;
    L_0x02b7:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r0 >= r3) goto L_0x03ce;
    L_0x02bd:
        r2 = 20;
    L_0x02bf:
        r11 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r12 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r14 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r16 = 1;
        r18 = 0;
        r11.a(r12, r14, r16, r18);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "reportStatusCode:%d, key:%d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r24);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.e(r2);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r3 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r3.t(r2);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r0 == r2) goto L_0x049a;
    L_0x02fa:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "statusCode %s, url is %s ,filename is %s ";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r24);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5 = 1;
        r0 = r27;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5 = 2;
        r0 = r27;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.lm(r24);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        if (r2 == 0) goto L_0x049a;
    L_0x0321:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r2 = com.tencent.mm.plugin.appbrand.k.i.d(r2);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        if (r3 != 0) goto L_0x049a;
    L_0x032f:
        r0 = r27;
        r3 = r0.gkZ;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4 = r3 + -1;
        r0 = r27;
        r0.gkZ = r4;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        if (r3 > 0) goto L_0x0426;
    L_0x033b:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "reach the max redirect count(%d)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5 = 0;
        r6 = 15;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r26;
        r1 = r24;
        r2.b(r3, r0, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 1;
        r12 = r27.alt();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x03af:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r5 = "application/octet-stream";
        r2 = r2.contains(r5);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r2 == 0) goto L_0x03c8;
    L_0x03ba:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.Ui(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        if (r3 != 0) goto L_0x03c8;
    L_0x03c4:
        r26 = r2;
        goto L_0x0297;
    L_0x03c8:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0bb1, SSLHandshakeException -> 0x0cc3, SocketTimeoutException -> 0x0dd5, SSLProtocolException -> 0x0ee7, Exception -> 0x0ff9, all -> 0x1119 }
        r26 = r2;
        goto L_0x0297;
    L_0x03ce:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r3 != r0) goto L_0x03d8;
    L_0x03d4:
        r2 = 21;
        goto L_0x02bf;
    L_0x03d8:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r0 <= r3) goto L_0x03e8;
    L_0x03de:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x03e8;
    L_0x03e4:
        r2 = 22;
        goto L_0x02bf;
    L_0x03e8:
        r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r0 = r24;
        if (r3 != r0) goto L_0x03f2;
    L_0x03ee:
        r2 = 23;
        goto L_0x02bf;
    L_0x03f2:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x0402;
    L_0x03f8:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x0402;
    L_0x03fe:
        r2 = 24;
        goto L_0x02bf;
    L_0x0402:
        r3 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        r0 = r24;
        if (r3 != r0) goto L_0x040c;
    L_0x0408:
        r2 = 25;
        goto L_0x02bf;
    L_0x040c:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x041c;
    L_0x0412:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x041c;
    L_0x0418:
        r2 = 26;
        goto L_0x02bf;
    L_0x041c:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x02bf;
    L_0x0422:
        r2 = 27;
        goto L_0x02bf;
    L_0x0426:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "redirect(%d) URL(%s) to URL(%s)";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 0;
        r0 = r27;
        r7 = r0.gkZ;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 1;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 2;
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r0.uri = r2;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r27.run();	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.alt();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x049a:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r4 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        if (r4 <= 0) goto L_0x0524;
    L_0x04a4:
        r0 = r27;
        r2 = r0.glB;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        if (r2 <= 0) goto L_0x0524;
    L_0x04aa:
        r0 = r27;
        r2 = r0.glB;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r3 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r2 = r2 * r3;
        if (r4 < r2) goto L_0x0524;
    L_0x04b3:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "before actually read stream, contentLength %d exceed limit";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r6 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5[r6] = r4;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r5 = "exceed max file size";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.alt();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0524:
        r2 = "gzip";
        r0 = r27;
        r3 = r0.glD;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        if (r2 == 0) goto L_0x05e2;
    L_0x0535:
        r21 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r21;
        r0.<init>(r2);	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
    L_0x0544:
        r10 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r2 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r10.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = r10.exists();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r2 == 0) goto L_0x0695;
    L_0x0553:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "exists temp file ,filename is %s ";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r6 = 0;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = r10.delete();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r2 != 0) goto L_0x0695;
    L_0x056c:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "exists temp file delete failed, filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5 = 0;
        r0 = r27;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5 = "exists temp file delete failed";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.alt();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        if (r21 == 0) goto L_0x05d2;
    L_0x05cf:
        r21.close();	 Catch:{ IOException -> 0x0668, ArrayIndexOutOfBoundsException -> 0x0677, Throwable -> 0x0686 }
    L_0x05d2:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x05e2:
        r2 = "deflate";
        r0 = r27;
        r3 = r0.glD;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        if (r2 == 0) goto L_0x0654;
    L_0x05f3:
        r21 = new java.util.zip.InflaterInputStream;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r3 = new java.util.zip.Inflater;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r5 = 1;
        r3.<init>(r5);	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r21;
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        goto L_0x0544;
    L_0x060a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "getInputStream error : %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r7 = 0;
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r3 = "gzip";
        r0 = r27;
        r5 = r0.glD;	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r5 = r5.getContentEncoding();	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r3 = r3.equals(r5);	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        if (r3 == 0) goto L_0x065e;
    L_0x062b:
        r21 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r27;
        r3 = r0.glD;	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r3 = r3.getErrorStream();	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r0 = r21;
        r0.<init>(r3);	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        goto L_0x0544;
    L_0x063c:
        r3 = move-exception;
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r6 = "read err stream failed : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r10 = 0;
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r7[r10] = r3;	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r2, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, Exception -> 0x1232, all -> 0x11e5 }
        r21 = r20;
        goto L_0x0544;
    L_0x0654:
        r0 = r27;
        r2 = r0.glD;	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r21 = r2.getInputStream();	 Catch:{ Exception -> 0x060a, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        goto L_0x0544;
    L_0x065e:
        r0 = r27;
        r3 = r0.glD;	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        r21 = r3.getErrorStream();	 Catch:{ Exception -> 0x063c, UnsupportedEncodingException -> 0x12d2, FileNotFoundException -> 0x12b2, SSLHandshakeException -> 0x1292, SocketTimeoutException -> 0x1272, SSLProtocolException -> 0x1252, all -> 0x11e5 }
        goto L_0x0544;
    L_0x0668:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05d2;
    L_0x0677:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05d2;
    L_0x0686:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05d2;
    L_0x0695:
        r2 = r10.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = r2.exists();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r2 != 0) goto L_0x075c;
    L_0x069f:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "create file ,filename is %s ";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r6 = 0;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = r10.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = r2.mkdirs();	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r2 != 0) goto L_0x075c;
    L_0x06bc:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "create file  getParentFile failed, filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5 = 0;
        r0 = r27;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5 = "getParentFile failed";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.alt();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        if (r21 == 0) goto L_0x0722;
    L_0x071f:
        r21.close();	 Catch:{ IOException -> 0x0732, ArrayIndexOutOfBoundsException -> 0x0740, Throwable -> 0x074e }
    L_0x0722:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0732:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0722;
    L_0x0740:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0722;
    L_0x074e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0722;
    L_0x075c:
        if (r21 == 0) goto L_0x0963;
    L_0x075e:
        r20 = new java.io.FileOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r20;
        r0.<init>(r10);	 Catch:{ UnsupportedEncodingException -> 0x12df, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = (long) r4;
        r2 = com.tencent.mm.plugin.appbrand.k.i.bR(r2);	 Catch:{ UnsupportedEncodingException -> 0x12ec, FileNotFoundException -> 0x12ba, SSLHandshakeException -> 0x129a, SocketTimeoutException -> 0x127a, SSLProtocolException -> 0x125a, Exception -> 0x123a, all -> 0x11f9 }
        r11 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x12ec, FileNotFoundException -> 0x12ba, SSLHandshakeException -> 0x129a, SocketTimeoutException -> 0x127a, SSLProtocolException -> 0x125a, Exception -> 0x123a, all -> 0x11f9 }
        r2 = -1;
        r16 = r22;
    L_0x076f:
        r0 = r21;
        r4 = r0.read(r11);	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = -1;
        if (r4 == r3) goto L_0x095c;
    L_0x0778:
        r0 = r27;
        r3 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        if (r3 == 0) goto L_0x095c;
    L_0x077e:
        r0 = r27;
        r3 = r0.appId;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = com.tencent.mm.plugin.appbrand.a.pY(r3);	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        if (r3 != 0) goto L_0x07f1;
    L_0x0788:
        r3 = 1;
    L_0x0789:
        if (r3 == 0) goto L_0x0840;
    L_0x078b:
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r5 = "interrupted";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r16;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r20.close();	 Catch:{ IOException -> 0x0808 }
    L_0x07dc:
        if (r21 == 0) goto L_0x07e1;
    L_0x07de:
        r21.close();	 Catch:{ IOException -> 0x0816, ArrayIndexOutOfBoundsException -> 0x0824, Throwable -> 0x0832 }
    L_0x07e1:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x07f1:
        r5 = com.tencent.mm.plugin.appbrand.k.a.b.AnonymousClass1.fjn;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = r3.fcL;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = r3.fjj;	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = r3.acv();	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = r3.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r3 = r5[r3];	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        switch(r3) {
            case 1: goto L_0x0806;
            case 2: goto L_0x0806;
            default: goto L_0x0804;
        };
    L_0x0804:
        r3 = 0;
        goto L_0x0789;
    L_0x0806:
        r3 = 1;
        goto L_0x0789;
    L_0x0808:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07dc;
    L_0x0816:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e1;
    L_0x0824:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e1;
    L_0x0832:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07e1;
    L_0x0840:
        r3 = 0;
        r0 = r20;
        r0.write(r11, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r4 = (long) r4;
        r6 = r16 + r4;
        r4 = 0;
        r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x0885;
    L_0x084f:
        r0 = r27;
        r3 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        if (r3 == 0) goto L_0x0885;
    L_0x0855:
        r4 = 100;
        r4 = r4 * r6;
        r4 = r4 / r8;
        r5 = (int) r4;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        if (r2 == r5) goto L_0x0864;
    L_0x085c:
        r0 = r27;
        r4 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r4.f(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r2 = r5;
    L_0x0864:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "download size %d, totalSize %d, percent = %d";
        r12 = 3;
        r12 = new java.lang.Object[r12];	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r13 = 0;
        r14 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r12[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r13 = 1;
        r14 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r12[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r13 = 2;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r12[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        com.tencent.mm.sdk.platformtools.x.v(r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
    L_0x0885:
        r4 = 0;
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x131d;
    L_0x088b:
        r0 = r27;
        r3 = r0.glB;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        if (r3 <= 0) goto L_0x131d;
    L_0x0891:
        r0 = r27;
        r3 = r0.glB;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r4 = (long) r3;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r12 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r4 = r4 * r12;
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 < 0) goto L_0x131d;
    L_0x089e:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "after read stream, downloadSize %d exceed limit";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r5 = 0;
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r5 = "exceed max file size";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        com.tencent.mm.sdk.platformtools.bi.d(r20);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        com.tencent.mm.sdk.platformtools.bi.d(r21);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r2 = r10.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        com.tencent.mm.a.e.deleteFile(r2);	 Catch:{ UnsupportedEncodingException -> 0x1304, FileNotFoundException -> 0x12c6, SSLHandshakeException -> 0x12a6, SocketTimeoutException -> 0x1286, SSLProtocolException -> 0x1266, Exception -> 0x1246, all -> 0x120f }
        r0 = r27;
        r8 = r0.appId;
        r0 = r27;
        r9 = r0.glc;
        r10 = "GET";
        r0 = r27;
        r11 = r0.uri;
        r12 = 0;
        r17 = 2;
        r18 = r27.alt();
        r14 = r6;
        r16 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r8, r9, r10, r11, r12, r14, r16, r17, r18);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r20.close();	 Catch:{ IOException -> 0x0924 }
    L_0x090f:
        if (r21 == 0) goto L_0x0914;
    L_0x0911:
        r21.close();	 Catch:{ IOException -> 0x0932, ArrayIndexOutOfBoundsException -> 0x0940, Throwable -> 0x094e }
    L_0x0914:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0924:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x090f;
    L_0x0932:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0914;
    L_0x0940:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0914;
    L_0x094e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0914;
    L_0x095c:
        r20.flush();	 Catch:{ UnsupportedEncodingException -> 0x12f9, FileNotFoundException -> 0x12bf, SSLHandshakeException -> 0x129f, SocketTimeoutException -> 0x127f, SSLProtocolException -> 0x125f, Exception -> 0x123f, all -> 0x1204 }
        r19 = r20;
        r22 = r16;
    L_0x0963:
        r0 = r27;
        r2 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r2 == 0) goto L_0x0aa8;
    L_0x0969:
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r26;
        r1 = r24;
        r2.b(r3, r0, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r4 = r0.glC;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r4 = r2 - r4;
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0992;
    L_0x098c:
        r2 = 0;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0a26;
    L_0x0992:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "reportSpeed len:%d, time:%d return";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r7 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
    L_0x09ac:
        r3 = 1;
    L_0x09ad:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "finished filename = %s , url = %s ";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r6 = 0;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r6 = 1;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        com.tencent.mm.sdk.platformtools.x.v(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r0 = r27;
        r2 = r0.glD;	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        r2.disconnect();	 Catch:{ UnsupportedEncodingException -> 0x1311, FileNotFoundException -> 0x12cd, SSLHandshakeException -> 0x12ad, SocketTimeoutException -> 0x128d, SSLProtocolException -> 0x126d, Exception -> 0x124d, all -> 0x1219 }
        if (r3 == 0) goto L_0x0abe;
    L_0x09d0:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0a0c:
        if (r19 == 0) goto L_0x0a11;
    L_0x0a0e:
        r19.close();	 Catch:{ IOException -> 0x0afc }
    L_0x0a11:
        if (r21 == 0) goto L_0x0a16;
    L_0x0a13:
        r21.close();	 Catch:{ IOException -> 0x0b0b, ArrayIndexOutOfBoundsException -> 0x0b1a, Throwable -> 0x0b29 }
    L_0x0a16:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0a26:
        r2 = 34;
        r6 = (double) r8;
        r10 = (double) r4;
        r6 = r6 / r10;
        r10 = 4606971312567484416; // 0x3fef400000000000 float:0.0 double:0.9765625;
        r6 = r6 * r10;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = com.tencent.mm.sdk.platformtools.ao.is2G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r3 == 0) goto L_0x0a81;
    L_0x0a3b:
        r2 = 30;
    L_0x0a3d:
        r11 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r12 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r14 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = (long) r6;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r16 = r0;
        r18 = 0;
        r11.a(r12, r14, r16, r18);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r10 = "reportSpeed len:%d, time:%d, speed:%f, key:%d";
        r11 = 4;
        r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r12 = 0;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r11[r12] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r8 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r11[r8] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r4 = 2;
        r5 = java.lang.Double.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r11[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r4 = 3;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r11[r4] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        goto L_0x09ac;
    L_0x0a74:
        r2 = move-exception;
        r13 = r19;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x0a81:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = com.tencent.mm.sdk.platformtools.ao.is3G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r3 == 0) goto L_0x0a8e;
    L_0x0a8b:
        r2 = 31;
        goto L_0x0a3d;
    L_0x0a8e:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = com.tencent.mm.sdk.platformtools.ao.is4G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r3 == 0) goto L_0x0a9b;
    L_0x0a98:
        r2 = 32;
        goto L_0x0a3d;
    L_0x0a9b:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = com.tencent.mm.sdk.platformtools.ao.isWifi(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        if (r3 == 0) goto L_0x0a3d;
    L_0x0aa5:
        r2 = 33;
        goto L_0x0a3d;
    L_0x0aa8:
        r0 = r27;
        r2 = r0.glz;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r5 = "force stop";
        r2.G(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0a74, FileNotFoundException -> 0x12b7, SSLHandshakeException -> 0x1297, SocketTimeoutException -> 0x1277, SSLProtocolException -> 0x1257, Exception -> 0x1237 }
        r3 = r25;
        goto L_0x09ad;
    L_0x0abe:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0a0c;
    L_0x0afc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a11;
    L_0x0b0b:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a16;
    L_0x0b1a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a16;
    L_0x0b29:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a16;
    L_0x0b38:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0234;
    L_0x0b75:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0239;
    L_0x0b84:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0b93:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0ba2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0bb1:
        r2 = move-exception;
        r21 = r20;
        r24 = r11;
    L_0x0bb6:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x11f0 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x11f0 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x11f0 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5 = "file not found error";
        r2.G(r3, r4, r5);	 Catch:{ all -> 0x11f0 }
        if (r25 == 0) goto L_0x0c4d;
    L_0x0bf7:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0c33:
        if (r19 == 0) goto L_0x0c38;
    L_0x0c35:
        r19.close();	 Catch:{ IOException -> 0x0c8a }
    L_0x0c38:
        if (r21 == 0) goto L_0x0c3d;
    L_0x0c3a:
        r21.close();	 Catch:{ IOException -> 0x0c98, ArrayIndexOutOfBoundsException -> 0x0ca6, Throwable -> 0x0cb4 }
    L_0x0c3d:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0c4d:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0c33;
    L_0x0c8a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c38;
    L_0x0c98:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c3d;
    L_0x0ca6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c3d;
    L_0x0cb4:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c3d;
    L_0x0cc3:
        r2 = move-exception;
        r21 = r20;
        r24 = r11;
    L_0x0cc8:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x11f0 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x11f0 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x11f0 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5 = "ssl handshake error";
        r2.G(r3, r4, r5);	 Catch:{ all -> 0x11f0 }
        if (r25 == 0) goto L_0x0d5f;
    L_0x0d09:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0d45:
        if (r19 == 0) goto L_0x0d4a;
    L_0x0d47:
        r19.close();	 Catch:{ IOException -> 0x0d9c }
    L_0x0d4a:
        if (r21 == 0) goto L_0x0d4f;
    L_0x0d4c:
        r21.close();	 Catch:{ IOException -> 0x0daa, ArrayIndexOutOfBoundsException -> 0x0db8, Throwable -> 0x0dc6 }
    L_0x0d4f:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0d5f:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0d45;
    L_0x0d9c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d4a;
    L_0x0daa:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d4f;
    L_0x0db8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d4f;
    L_0x0dc6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d4f;
    L_0x0dd5:
        r2 = move-exception;
        r21 = r20;
        r24 = r11;
    L_0x0dda:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x11f0 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x11f0 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x11f0 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5 = "socket timeout";
        r2.G(r3, r4, r5);	 Catch:{ all -> 0x11f0 }
        if (r25 == 0) goto L_0x0e71;
    L_0x0e1b:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0e57:
        if (r19 == 0) goto L_0x0e5c;
    L_0x0e59:
        r19.close();	 Catch:{ IOException -> 0x0eae }
    L_0x0e5c:
        if (r21 == 0) goto L_0x0e61;
    L_0x0e5e:
        r21.close();	 Catch:{ IOException -> 0x0ebc, ArrayIndexOutOfBoundsException -> 0x0eca, Throwable -> 0x0ed8 }
    L_0x0e61:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0e71:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0e57;
    L_0x0eae:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e5c;
    L_0x0ebc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e61;
    L_0x0eca:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e61;
    L_0x0ed8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e61;
    L_0x0ee7:
        r2 = move-exception;
        r21 = r20;
        r24 = r11;
    L_0x0eec:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x11f0 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 6;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x11f0 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x11f0 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r2 = r0.glz;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r3 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r4 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5 = "ssl protocol error";
        r2.G(r3, r4, r5);	 Catch:{ all -> 0x11f0 }
        if (r25 == 0) goto L_0x0f83;
    L_0x0f2d:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0f69:
        if (r19 == 0) goto L_0x0f6e;
    L_0x0f6b:
        r19.close();	 Catch:{ IOException -> 0x0fc0 }
    L_0x0f6e:
        if (r21 == 0) goto L_0x0f73;
    L_0x0f70:
        r21.close();	 Catch:{ IOException -> 0x0fce, ArrayIndexOutOfBoundsException -> 0x0fdc, Throwable -> 0x0fea }
    L_0x0f73:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x0f83:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0f69;
    L_0x0fc0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f6e;
    L_0x0fce:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f73;
    L_0x0fdc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f73;
    L_0x0fea:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f73;
    L_0x0ff9:
        r2 = move-exception;
        r21 = r20;
        r24 = r11;
    L_0x0ffe:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x11f0 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x11f0 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x11f0 }
        r6 = 0;
        r0 = r27;
        r7 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 1;
        r0 = r27;
        r7 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        r6 = 2;
        r7 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r5[r6] = r7;	 Catch:{ all -> 0x11f0 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r3 = r0.glz;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r4 = r0.filename;	 Catch:{ all -> 0x11f0 }
        r0 = r27;
        r5 = r0.uri;	 Catch:{ all -> 0x11f0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x11f0 }
        r6.<init>();	 Catch:{ all -> 0x11f0 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x11f0 }
        r2 = r6.append(r2);	 Catch:{ all -> 0x11f0 }
        r2 = r2.toString();	 Catch:{ all -> 0x11f0 }
        r3.G(r4, r5, r2);	 Catch:{ all -> 0x11f0 }
        if (r25 == 0) goto L_0x10a3;
    L_0x104d:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x1089:
        if (r19 == 0) goto L_0x108e;
    L_0x108b:
        r19.close();	 Catch:{ IOException -> 0x10e0 }
    L_0x108e:
        if (r21 == 0) goto L_0x1093;
    L_0x1090:
        r21.close();	 Catch:{ IOException -> 0x10ee, ArrayIndexOutOfBoundsException -> 0x10fc, Throwable -> 0x110a }
    L_0x1093:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        goto L_0x0026;
    L_0x10a3:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x1089;
    L_0x10e0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x108e;
    L_0x10ee:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1093;
    L_0x10fc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1093;
    L_0x110a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1093;
    L_0x1119:
        r2 = move-exception;
        r18 = r2;
        r21 = r20;
        r8 = r22;
        r10 = r11;
    L_0x1121:
        if (r25 == 0) goto L_0x1174;
    L_0x1123:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x115b:
        if (r19 == 0) goto L_0x1160;
    L_0x115d:
        r19.close();	 Catch:{ IOException -> 0x11ad }
    L_0x1160:
        if (r21 == 0) goto L_0x1165;
    L_0x1162:
        r21.close();	 Catch:{ IOException -> 0x11bb, ArrayIndexOutOfBoundsException -> 0x11c9, Throwable -> 0x11d7 }
    L_0x1165:
        r27.alC();
        r0 = r27;
        r2 = r0.glz;
        r0 = r27;
        r3 = r0.fEl;
        r2.uH(r3);
        throw r18;
    L_0x1174:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.glc;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.alt();
        com.tencent.mm.plugin.appbrand.report.a.l.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.glC;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x115b;
    L_0x11ad:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1160;
    L_0x11bb:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "IOException ";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1165;
    L_0x11c9:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "ArrayIndexOutOfBoundsException";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1165;
    L_0x11d7:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "Throwable";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1165;
    L_0x11e5:
        r2 = move-exception;
        r18 = r2;
        r21 = r20;
        r8 = r22;
        r10 = r24;
        goto L_0x1121;
    L_0x11f0:
        r2 = move-exception;
        r18 = r2;
        r8 = r22;
        r10 = r24;
        goto L_0x1121;
    L_0x11f9:
        r2 = move-exception;
        r18 = r2;
        r19 = r20;
        r8 = r22;
        r10 = r24;
        goto L_0x1121;
    L_0x1204:
        r2 = move-exception;
        r18 = r2;
        r19 = r20;
        r8 = r16;
        r10 = r24;
        goto L_0x1121;
    L_0x120f:
        r2 = move-exception;
        r18 = r2;
        r19 = r20;
        r8 = r6;
        r10 = r24;
        goto L_0x1121;
    L_0x1219:
        r2 = move-exception;
        r18 = r2;
        r8 = r22;
        r10 = r24;
        r25 = r3;
        goto L_0x1121;
    L_0x1224:
        r2 = move-exception;
        r18 = r2;
        r19 = r13;
        r21 = r14;
        r8 = r16;
        r10 = r15;
        r25 = r12;
        goto L_0x1121;
    L_0x1232:
        r2 = move-exception;
        r21 = r20;
        goto L_0x0ffe;
    L_0x1237:
        r2 = move-exception;
        goto L_0x0ffe;
    L_0x123a:
        r2 = move-exception;
        r19 = r20;
        goto L_0x0ffe;
    L_0x123f:
        r2 = move-exception;
        r19 = r20;
        r22 = r16;
        goto L_0x0ffe;
    L_0x1246:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        goto L_0x0ffe;
    L_0x124d:
        r2 = move-exception;
        r25 = r3;
        goto L_0x0ffe;
    L_0x1252:
        r2 = move-exception;
        r21 = r20;
        goto L_0x0eec;
    L_0x1257:
        r2 = move-exception;
        goto L_0x0eec;
    L_0x125a:
        r2 = move-exception;
        r19 = r20;
        goto L_0x0eec;
    L_0x125f:
        r2 = move-exception;
        r19 = r20;
        r22 = r16;
        goto L_0x0eec;
    L_0x1266:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        goto L_0x0eec;
    L_0x126d:
        r2 = move-exception;
        r25 = r3;
        goto L_0x0eec;
    L_0x1272:
        r2 = move-exception;
        r21 = r20;
        goto L_0x0dda;
    L_0x1277:
        r2 = move-exception;
        goto L_0x0dda;
    L_0x127a:
        r2 = move-exception;
        r19 = r20;
        goto L_0x0dda;
    L_0x127f:
        r2 = move-exception;
        r19 = r20;
        r22 = r16;
        goto L_0x0dda;
    L_0x1286:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        goto L_0x0dda;
    L_0x128d:
        r2 = move-exception;
        r25 = r3;
        goto L_0x0dda;
    L_0x1292:
        r2 = move-exception;
        r21 = r20;
        goto L_0x0cc8;
    L_0x1297:
        r2 = move-exception;
        goto L_0x0cc8;
    L_0x129a:
        r2 = move-exception;
        r19 = r20;
        goto L_0x0cc8;
    L_0x129f:
        r2 = move-exception;
        r19 = r20;
        r22 = r16;
        goto L_0x0cc8;
    L_0x12a6:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        goto L_0x0cc8;
    L_0x12ad:
        r2 = move-exception;
        r25 = r3;
        goto L_0x0cc8;
    L_0x12b2:
        r2 = move-exception;
        r21 = r20;
        goto L_0x0bb6;
    L_0x12b7:
        r2 = move-exception;
        goto L_0x0bb6;
    L_0x12ba:
        r2 = move-exception;
        r19 = r20;
        goto L_0x0bb6;
    L_0x12bf:
        r2 = move-exception;
        r19 = r20;
        r22 = r16;
        goto L_0x0bb6;
    L_0x12c6:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        goto L_0x0bb6;
    L_0x12cd:
        r2 = move-exception;
        r25 = r3;
        goto L_0x0bb6;
    L_0x12d2:
        r2 = move-exception;
        r13 = r19;
        r14 = r20;
        r16 = r22;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x12df:
        r2 = move-exception;
        r13 = r19;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x12ec:
        r2 = move-exception;
        r13 = r20;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x12f9:
        r2 = move-exception;
        r13 = r20;
        r14 = r21;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x1304:
        r2 = move-exception;
        r13 = r20;
        r14 = r21;
        r16 = r6;
        r15 = r24;
        r12 = r25;
        goto L_0x01b8;
    L_0x1311:
        r2 = move-exception;
        r13 = r19;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r12 = r3;
        goto L_0x01b8;
    L_0x131d:
        r16 = r6;
        goto L_0x076f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.k.a.b.run():void");
    }

    public final void alC() {
        this.bgH = false;
        if (this.glD != null) {
            try {
                this.glD.disconnect();
            } catch (Exception e) {
            }
        }
    }

    private int alt() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
