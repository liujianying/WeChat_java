package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.b.a;
import com.tencent.mm.pluginsdk.g.a.b.b;
import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.pluginsdk.g.a.b.f;
import com.tencent.mm.pluginsdk.g.a.b.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import javax.net.ssl.SSLContext;

public final class j {
    private static final Class[] qDe = new Class[]{InterruptedException.class};
    private static final Class[] qDf = new Class[]{UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, a.class, d.class, g.class};
    private static final Class[] qDg = new Class[]{SocketException.class, SocketTimeoutException.class};
    private boolean qDd = false;

    j() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.tencent.mm.pluginsdk.g.a.c.m a(com.tencent.mm.pluginsdk.g.a.c.e r14) {
        /*
        r4 = 0;
        r8 = 1;
        r7 = 0;
        if (r14 != 0) goto L_0x0010;
    L_0x0005:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r3 = "get null task, just skip";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = r4;
    L_0x000f:
        return r2;
    L_0x0010:
        r2 = r14.getFilePath();
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x0032;
    L_0x001a:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r3 = "%s: filePath is null or nil, just return null";
        r5 = new java.lang.Object[r8];
        r6 = r14.cco();
        r5[r7] = r6;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r5);
        r2 = r4;
        goto L_0x000f;
    L_0x002d:
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        r5.disconnect();	 Catch:{ Exception -> 0x0257 }
    L_0x0032:
        r2 = r14.acc();	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        if (r2 != 0) goto L_0x003f;
    L_0x0038:
        r2 = r14.getFilePath();	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(r2);	 Catch:{ Exception -> 0x0263, all -> 0x025c }
    L_0x003f:
        ccF();	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r2 = r14.getURL();	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r3 = new java.net.URL;	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r2 = r3.openConnection();	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0263, all -> 0x025c }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: connection opened, url = %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 0;
        r11 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 1;
        r11 = r14.getURL();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        ccF();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        a(r14, r2);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        ccF();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = r14.getFilePath();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = com.tencent.mm.pluginsdk.g.a.d.a.Io(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: RangeOffset = %d";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 0;
        r13 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r12] = r13;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 1;
        r13 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r12] = r13;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 0;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 != 0) goto L_0x015a;
    L_0x009c:
        r6 = r7;
    L_0x009d:
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: hasRangerHeader=%b";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 1;
        r12 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        ccF();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "https";
        r3 = r3.getProtocol();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r5.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 == 0) goto L_0x00f4;
    L_0x00c7:
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r0;
        r5 = "TLSv1.2";
        r5 = Eb(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r5 != 0) goto L_0x00e1;
    L_0x00d4:
        r5 = "TLSv1";
        r5 = Eb(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r5 != 0) goto L_0x00e1;
    L_0x00dd:
        r5 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ Exception -> 0x0251, all -> 0x01f5 }
    L_0x00e1:
        if (r5 == 0) goto L_0x017b;
    L_0x00e3:
        r9 = 0;
        r10 = 0;
        r11 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r11.<init>();	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r5.init(r9, r10, r11);	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r5 = r5.getSocketFactory();	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r3.setSSLSocketFactory(r5);	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
    L_0x00f4:
        ccF();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r5 = "%s: HttpMethod = %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 0;
        r11 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 1;
        r11 = r14.ccB();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.d(r3, r5, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "POST";
        r5 = r14.ccB();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r3.equals(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 == 0) goto L_0x0148;
    L_0x011e:
        r3 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.bC(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 != 0) goto L_0x0148;
    L_0x0125:
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "Content-Type";
        r5 = r14.ccE();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = 0;
        r3 = r3.length;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.setFixedLengthStreamingMode(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x01fd, all -> 0x0268 }
        r3 = r2.getOutputStream();	 Catch:{ IOException -> 0x01fd, all -> 0x0268 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x01fd, all -> 0x0268 }
        r3 = 0;
        r5.write(r3);	 Catch:{ IOException -> 0x026b }
        r5.close();	 Catch:{ IOException -> 0x01d3 }
    L_0x0148:
        ccF();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = a(r14, r2, r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.disconnect();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r2 == 0) goto L_0x0157;
    L_0x0154:
        r2.disconnect();	 Catch:{ Exception -> 0x0254 }
    L_0x0157:
        r2 = r3;
        goto L_0x000f;
    L_0x015a:
        r5 = "Range";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = "bytes=";
        r6.<init>(r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r6.append(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = "-";
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.addRequestProperty(r5, r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r8;
        goto L_0x009d;
    L_0x017a:
        r5 = move-exception;
    L_0x017b:
        r5 = r14.ccD();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = new android.net.SSLSessionCache;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = android.net.SSLCertificateSocketFactory.getDefault(r5, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3.setSSLSocketFactory(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x00f4;
    L_0x0191:
        r3 = move-exception;
        r5 = r2;
    L_0x0193:
        r2 = b(r14, r3);	 Catch:{ all -> 0x0260 }
        if (r2 != 0) goto L_0x0247;
    L_0x0199:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: get null response in catch-block, may retry";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0260 }
        r10 = 0;
        r11 = r14.cco();	 Catch:{ all -> 0x0260 }
        r9[r10] = r11;	 Catch:{ all -> 0x0260 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r6, r9);	 Catch:{ all -> 0x0260 }
        r2 = r14.acg();	 Catch:{ all -> 0x0260 }
        if (r2 != 0) goto L_0x002d;
    L_0x01b2:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: retry times out";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0260 }
        r7 = 0;
        r8 = r14.cco();	 Catch:{ all -> 0x0260 }
        r6[r7] = r8;	 Catch:{ all -> 0x0260 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r6);	 Catch:{ all -> 0x0260 }
        r2 = a(r14, r3);	 Catch:{ all -> 0x0260 }
        if (r5 == 0) goto L_0x000f;
    L_0x01cb:
        r5.disconnect();	 Catch:{ Exception -> 0x01d0 }
        goto L_0x000f;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x000f;
    L_0x01d3:
        r3 = move-exception;
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, close IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x0148;
    L_0x01f5:
        r3 = move-exception;
        r5 = r2;
    L_0x01f7:
        if (r5 == 0) goto L_0x01fc;
    L_0x01f9:
        r5.disconnect();	 Catch:{ Exception -> 0x025a }
    L_0x01fc:
        throw r3;
    L_0x01fd:
        r3 = move-exception;
        r5 = r4;
    L_0x01ff:
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, write IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x021f }
        r11 = 0;
        r12 = r14.cco();	 Catch:{ all -> 0x021f }
        r10[r11] = r12;	 Catch:{ all -> 0x021f }
        com.tencent.mm.sdk.platformtools.x.e(r6, r9, r10);	 Catch:{ all -> 0x021f }
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x021f }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r3, r9, r10);	 Catch:{ all -> 0x021f }
        throw r3;	 Catch:{ all -> 0x021f }
    L_0x021f:
        r3 = move-exception;
    L_0x0220:
        if (r5 == 0) goto L_0x0225;
    L_0x0222:
        r5.close();	 Catch:{ IOException -> 0x0226 }
    L_0x0225:
        throw r3;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
    L_0x0226:
        r5 = move-exception;
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, close IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r14.cco();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.e(r6, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x0225;
    L_0x0247:
        if (r5 == 0) goto L_0x000f;
    L_0x0249:
        r5.disconnect();	 Catch:{ Exception -> 0x024e }
        goto L_0x000f;
    L_0x024e:
        r3 = move-exception;
        goto L_0x000f;
    L_0x0251:
        r9 = move-exception;
        goto L_0x00e1;
    L_0x0254:
        r2 = move-exception;
        goto L_0x0157;
    L_0x0257:
        r2 = move-exception;
        goto L_0x0032;
    L_0x025a:
        r2 = move-exception;
        goto L_0x01fc;
    L_0x025c:
        r2 = move-exception;
        r3 = r2;
        r5 = r4;
        goto L_0x01f7;
    L_0x0260:
        r2 = move-exception;
        r3 = r2;
        goto L_0x01f7;
    L_0x0263:
        r2 = move-exception;
        r3 = r2;
        r5 = r4;
        goto L_0x0193;
    L_0x0268:
        r3 = move-exception;
        r5 = r4;
        goto L_0x0220;
    L_0x026b:
        r3 = move-exception;
        goto L_0x01ff;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.g.a.c.j.a(com.tencent.mm.pluginsdk.g.a.c.e):com.tencent.mm.pluginsdk.g.a.c.m");
    }

    private static void ccF() {
        if (Thread.interrupted()) {
            throw new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
        }
    }

    private static void a(e eVar, HttpURLConnection httpURLConnection) {
        x.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", new Object[]{eVar.cco()});
        Collection<b> ccC = eVar.ccC();
        if (ccC != null && ccC.size() > 0) {
            for (b bVar : ccC) {
                httpURLConnection.addRequestProperty(bVar.name, bVar.value);
            }
        }
        httpURLConnection.setRequestMethod(eVar.ccB());
        if ("GET".equalsIgnoreCase(eVar.ccB())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(eVar.getConnectTimeout());
        httpURLConnection.setReadTimeout(eVar.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (eVar.acb()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!bi.oW(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        if (eVar.acf()) {
            httpURLConnection.setInstanceFollowRedirects(true);
        } else {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
    }

    private static SSLContext Eb(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.pluginsdk.g.a.c.m a(com.tencent.mm.pluginsdk.g.a.c.e r14, java.net.HttpURLConnection r15, boolean r16) {
        /*
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r1 = "%s: step4, start to read response";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r14.cco();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r3 = 0;
        r2 = 0;
        r1 = -1;
        r4 = -1;
        r5 = r15.getResponseCode();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x0293, all -> 0x02b9 }
        r7 = r15.getContentLength();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r8 = r15.getContentEncoding();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r9 = r15.getContentType();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = "bytes";
        r4 = "Accept-Ranges";
        r4 = r15.getHeaderField(r4);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = r0.equals(r4);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 == 0) goto L_0x00a7;
    L_0x0037:
        r0 = 1;
        r6 = r0;
    L_0x0039:
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: received status code = %d, content-length = %d, content-encoding = %s, content-type = %s, isSupportRange = %b, \nresponseHeaders = %s";
        r10 = 7;
        r10 = new java.lang.Object[r10];	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 0;
        r12 = r14.cco();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10[r11] = r12;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 1;
        r12 = java.lang.Integer.valueOf(r5);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10[r11] = r12;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 2;
        r12 = java.lang.Integer.valueOf(r7);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10[r11] = r12;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 3;
        r10[r11] = r8;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 4;
        r10[r11] = r9;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 5;
        r12 = java.lang.Boolean.valueOf(r6);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10[r11] = r12;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r11 = 6;
        r12 = r15.getHeaderFields();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r12 = com.tencent.mm.pluginsdk.g.a.d.b.ar(r12);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10[r11] = r12;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r10);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = r14.getFilePath();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r10 = com.tencent.mm.pluginsdk.g.a.d.a.Io(r0);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r7 != 0) goto L_0x00c1;
    L_0x007c:
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r0 != r5) goto L_0x00c1;
    L_0x0080:
        r12 = 0;
        r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c1;
    L_0x0086:
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: file exists, return";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r7 = 0;
        r8 = r14.cco();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r6[r7] = r8;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r6);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = new com.tencent.mm.pluginsdk.g.a.c.m;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>(r14, r10, r9);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r1 = 0;
        com.tencent.mm.pluginsdk.g.a.d.a.g(r1);
        r1 = 0;
        com.tencent.mm.pluginsdk.g.a.d.a.g(r1);
    L_0x00a6:
        return r0;
    L_0x00a7:
        r0 = "Content-Range";
        r0 = r15.getHeaderField(r0);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00b0:
        r4 = "bytes";
        r0 = r0.startsWith(r4);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00b9:
        r0 = 1;
        r6 = r0;
        goto L_0x0039;
    L_0x00bd:
        r0 = 0;
        r6 = r0;
        goto L_0x0039;
    L_0x00c1:
        r0 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r0 == r5) goto L_0x00c9;
    L_0x00c5:
        r0 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r0 != r5) goto L_0x00ff;
    L_0x00c9:
        r0 = r14.acf();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 != 0) goto L_0x00ff;
    L_0x00cf:
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: task redirects not allowed, return";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r7 = 0;
        r8 = r14.cco();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r6[r7] = r8;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r6);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = new com.tencent.mm.pluginsdk.g.a.b.d;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        throw r0;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
    L_0x00e8:
        r0 = move-exception;
        r4 = r3;
    L_0x00ea:
        throw r0;	 Catch:{ all -> 0x00eb }
    L_0x00eb:
        r0 = move-exception;
    L_0x00ec:
        com.tencent.mm.pluginsdk.g.a.d.a.g(r4);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r2);
        if (r1 <= 0) goto L_0x00fe;
    L_0x00f4:
        r2 = com.tencent.mm.model.am.a.dBs;
        if (r2 == 0) goto L_0x00fe;
    L_0x00f8:
        r2 = com.tencent.mm.model.am.a.dBs;
        r3 = 0;
        r2.aY(r1, r3);
    L_0x00fe:
        throw r0;
    L_0x00ff:
        if (r7 != 0) goto L_0x010a;
    L_0x0101:
        r0 = new com.tencent.mm.pluginsdk.g.a.b.g;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        throw r0;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
    L_0x0107:
        r0 = move-exception;
        r4 = r3;
    L_0x0109:
        throw r0;	 Catch:{ all -> 0x00eb }
    L_0x010a:
        r0 = r14.acd();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 != 0) goto L_0x013a;
    L_0x0110:
        if (r7 >= 0) goto L_0x013a;
    L_0x0112:
        r0 = new java.net.SocketException;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        throw r0;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
    L_0x0118:
        r0 = move-exception;
        r4 = r3;
    L_0x011a:
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r5 = "%s: HttpUrlConnection SSLHandshakeException!";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00eb }
        r7 = 0;
        r8 = r14.cco();	 Catch:{ all -> 0x00eb }
        r6[r7] = r8;	 Catch:{ all -> 0x00eb }
        com.tencent.mm.sdk.platformtools.x.e(r3, r5, r6);	 Catch:{ all -> 0x00eb }
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00eb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r5, r6);	 Catch:{ all -> 0x00eb }
        throw r0;	 Catch:{ all -> 0x00eb }
    L_0x013a:
        if (r7 <= 0) goto L_0x0172;
    L_0x013c:
        r12 = (long) r7;
        r0 = r14.bM(r12);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        if (r0 != 0) goto L_0x0172;
    L_0x0143:
        r0 = new com.tencent.mm.pluginsdk.g.a.b.a;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        throw r0;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
    L_0x0149:
        r0 = move-exception;
        r4 = r3;
    L_0x014b:
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r5.<init>();	 Catch:{ all -> 0x00eb }
        r6 = r14.cco();	 Catch:{ all -> 0x00eb }
        r5 = r5.append(r6);	 Catch:{ all -> 0x00eb }
        r6 = ": ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00eb }
        r6 = r0.getMessage();	 Catch:{ all -> 0x00eb }
        r5 = r5.append(r6);	 Catch:{ all -> 0x00eb }
        r5 = r5.toString();	 Catch:{ all -> 0x00eb }
        com.tencent.mm.sdk.platformtools.x.e(r3, r5);	 Catch:{ all -> 0x00eb }
        throw r0;	 Catch:{ all -> 0x00eb }
    L_0x0172:
        r0 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r0 != r5) goto L_0x0180;
    L_0x0176:
        r0 = new com.tencent.mm.pluginsdk.g.a.b.b;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r6 = (long) r7;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0.<init>(r6, r10);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        throw r0;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
    L_0x017d:
        r0 = move-exception;
        r4 = r3;
    L_0x017f:
        throw r0;	 Catch:{ all -> 0x00eb }
    L_0x0180:
        r0 = r15.getInputStream();	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r4 = new java.io.BufferedInputStream;	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r4.<init>(r0);	 Catch:{ InterruptedException -> 0x00e8, UnknownHostException -> 0x0107, SSLHandshakeException -> 0x0118, SocketException -> 0x0149, SocketTimeoutException -> 0x017d, IOException -> 0x02c5, all -> 0x02b9 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r8);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02c8 }
        if (r0 != 0) goto L_0x019e;
    L_0x018f:
        r0 = "gzip";
        r0 = r8.equalsIgnoreCase(r0);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02c8 }
        if (r0 == 0) goto L_0x019e;
    L_0x0198:
        r0 = new java.util.zip.GZIPInputStream;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02c8 }
        r0.<init>(r4);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02c8 }
        r4 = r0;
    L_0x019e:
        r8 = r14.getFilePath();	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r3 = r14.cco();	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        if (r16 == 0) goto L_0x01d9;
    L_0x01a8:
        if (r6 == 0) goto L_0x01d9;
    L_0x01aa:
        r0 = 1;
    L_0x01ab:
        r10 = "MicroMsg.ResDownloader.NetworkPerformer";
        r11 = "%s: getOutputStream, filePath %s";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r13 = 0;
        r12[r13] = r3;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r13 = 1;
        r12[r13] = r8;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        com.tencent.mm.sdk.platformtools.x.d(r10, r11, r12);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r10 = com.tencent.mm.sdk.platformtools.bi.oW(r8);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        if (r10 == 0) goto L_0x01db;
    L_0x01c3:
        r0 = new java.io.FileNotFoundException;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r6 = "%s filePath is null or nil";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r3 = java.lang.String.format(r6, r7);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r0.<init>(r3);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        throw r0;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
    L_0x01d6:
        r0 = move-exception;
        goto L_0x00ea;
    L_0x01d9:
        r0 = 0;
        goto L_0x01ab;
    L_0x01db:
        r3 = new java.io.BufferedOutputStream;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r10 = new java.io.FileOutputStream;	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r10.<init>(r8, r0);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r3.<init>(r10);	 Catch:{ InterruptedException -> 0x01d6, UnknownHostException -> 0x02e7, SSLHandshakeException -> 0x02e0, SocketException -> 0x02d9, SocketTimeoutException -> 0x02d2, IOException -> 0x02cb }
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r2 = "%s: append = %b, isSupportRange = %s";
        r8 = 3;
        r8 = new java.lang.Object[r8];	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r10 = 0;
        r11 = r14.cco();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8[r10] = r11;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r10 = 1;
        r11 = java.lang.Boolean.valueOf(r16);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8[r10] = r11;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r10 = 2;
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8[r10] = r6;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r8);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r0 = new byte[r0];	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r1 = 0;
    L_0x020b:
        r2 = 0;
        r6 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r2 = r4.read(r0, r2, r6);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6 = -1;
        if (r2 == r6) goto L_0x0222;
    L_0x0215:
        r6 = 0;
        r3.write(r0, r6, r2);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r1 = r1 + r2;
        ccF();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        goto L_0x020b;
    L_0x021e:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00ea;
    L_0x0222:
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r2 = "%s: read count = %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8 = 0;
        r10 = r14.cco();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6[r8] = r10;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8 = 1;
        r10 = java.lang.Integer.valueOf(r1);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6[r8] = r10;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r3.flush();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r0 = "MicroMsg.ResDownloader.NetworkPerformer";
        r2 = "%s: download complete, flush and send complete status";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r8 = 0;
        r10 = r14.cco();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6[r8] = r10;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r0 = r14.acd();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        if (r0 == 0) goto L_0x0279;
    L_0x0258:
        r0 = new com.tencent.mm.pluginsdk.g.a.c.m;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r2 = r14.getFilePath();	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6 = com.tencent.mm.pluginsdk.g.a.d.a.Io(r2);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r0.<init>(r14, r6, r9);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        com.tencent.mm.pluginsdk.g.a.d.a.g(r4);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r3);
        if (r1 <= 0) goto L_0x00a6;
    L_0x026d:
        r2 = com.tencent.mm.model.am.a.dBs;
        if (r2 == 0) goto L_0x00a6;
    L_0x0271:
        r2 = com.tencent.mm.model.am.a.dBs;
        r3 = 0;
        r2.aY(r1, r3);
        goto L_0x00a6;
    L_0x0279:
        r0 = new com.tencent.mm.pluginsdk.g.a.c.m;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r6 = (long) r7;	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        r0.<init>(r14, r6, r9);	 Catch:{ InterruptedException -> 0x021e, UnknownHostException -> 0x02ea, SSLHandshakeException -> 0x02e3, SocketException -> 0x02dc, SocketTimeoutException -> 0x02d5, IOException -> 0x02ce, all -> 0x02bd }
        com.tencent.mm.pluginsdk.g.a.d.a.g(r4);
        com.tencent.mm.pluginsdk.g.a.d.a.g(r3);
        if (r1 <= 0) goto L_0x00a6;
    L_0x0287:
        r2 = com.tencent.mm.model.am.a.dBs;
        if (r2 == 0) goto L_0x00a6;
    L_0x028b:
        r2 = com.tencent.mm.model.am.a.dBs;
        r3 = 0;
        r2.aY(r1, r3);
        goto L_0x00a6;
    L_0x0293:
        r0 = move-exception;
        r5 = r4;
        r6 = r3;
    L_0x0296:
        com.tencent.mm.pluginsdk.g.a.d.a.g(r6);	 Catch:{ all -> 0x02c1 }
        r4 = r15.getErrorStream();	 Catch:{ all -> 0x02c1 }
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: HttpUrlConnection getInputStream failed! %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00eb }
        r8 = 0;
        r9 = r14.cco();	 Catch:{ all -> 0x00eb }
        r7[r8] = r9;	 Catch:{ all -> 0x00eb }
        r8 = 1;
        r7[r8] = r0;	 Catch:{ all -> 0x00eb }
        com.tencent.mm.sdk.platformtools.x.e(r3, r6, r7);	 Catch:{ all -> 0x00eb }
        r3 = new com.tencent.mm.pluginsdk.g.a.b.f;	 Catch:{ all -> 0x00eb }
        r3.<init>(r5, r0);	 Catch:{ all -> 0x00eb }
        throw r3;	 Catch:{ all -> 0x00eb }
    L_0x02b9:
        r0 = move-exception;
        r4 = r3;
        goto L_0x00ec;
    L_0x02bd:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00ec;
    L_0x02c1:
        r0 = move-exception;
        r4 = r6;
        goto L_0x00ec;
    L_0x02c5:
        r0 = move-exception;
        r6 = r3;
        goto L_0x0296;
    L_0x02c8:
        r0 = move-exception;
        r6 = r4;
        goto L_0x0296;
    L_0x02cb:
        r0 = move-exception;
        r6 = r4;
        goto L_0x0296;
    L_0x02ce:
        r0 = move-exception;
        r2 = r3;
        r6 = r4;
        goto L_0x0296;
    L_0x02d2:
        r0 = move-exception;
        goto L_0x017f;
    L_0x02d5:
        r0 = move-exception;
        r2 = r3;
        goto L_0x017f;
    L_0x02d9:
        r0 = move-exception;
        goto L_0x014b;
    L_0x02dc:
        r0 = move-exception;
        r2 = r3;
        goto L_0x014b;
    L_0x02e0:
        r0 = move-exception;
        goto L_0x011a;
    L_0x02e3:
        r0 = move-exception;
        r2 = r3;
        goto L_0x011a;
    L_0x02e7:
        r0 = move-exception;
        goto L_0x0109;
    L_0x02ea:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0109;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.g.a.c.j.a(com.tencent.mm.pluginsdk.g.a.c.e, java.net.HttpURLConnection, boolean):com.tencent.mm.pluginsdk.g.a.c.m");
    }

    private static m a(e eVar, Exception exception) {
        int i = -1;
        if (exception instanceof f) {
            i = ((f) exception).httpStatusCode;
            exception = ((f) exception).qCQ;
        }
        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", new Object[]{eVar.cco(), exception});
        return new m(eVar, exception, i, 3);
    }

    private static m b(e eVar, Exception exception) {
        if (exception instanceof ProtocolException) {
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", new Object[]{eVar.cco(), eVar.ccB()});
            return a(eVar, exception);
        } else if (exception instanceof b) {
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", new Object[]{eVar.cco(), exception.getClass().getSimpleName(), exception.getMessage()});
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(eVar.getFilePath());
            return null;
        } else {
            for (Object equals : qDe) {
                if (equals.equals(exception.getClass())) {
                    x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", new Object[]{eVar.cco(), exception});
                    return new m(eVar, exception, 4);
                }
            }
            for (Object equals2 : qDg) {
                if (equals2.equals(exception.getClass())) {
                    return null;
                }
            }
            for (Object equals3 : qDf) {
                if (equals3.equals(exception.getClass())) {
                    return a(eVar, exception);
                }
            }
            return a(eVar, exception);
        }
    }
}
