package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

public final class g extends h {
    private HttpClient mcs = null;
    private HttpRequestBase mct = null;
    private HttpResponse mcu = null;
    private boolean mcv = false;
    private int result = 0;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.qqmail.b.h$c a(java.lang.String r13, java.lang.String r14, com.tencent.mm.plugin.qqmail.b.h.b r15, com.tencent.mm.plugin.qqmail.b.h.a r16) {
        /*
        r12 = this;
        r2 = "MicroMsg.URLConnectionUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "uri=";
        r3.<init>(r4);
        r3 = r3.append(r14);
        r4 = ", ";
        r3 = r3.append(r4);
        r3 = r3.append(r15);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = 0;
        r12.mcv = r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r12.mcs = r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r15.mcx;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 != 0) goto L_0x0158;
    L_0x002f:
        r3 = new org.apache.http.client.methods.HttpGet;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r15.mcx;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 != 0) goto L_0x0155;
    L_0x0035:
        r2 = r15.mcy;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x0037:
        r2 = b(r13, r14, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r12.mct = r3;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x0040:
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "User-Agent";
        r4 = aBr;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Host";
        r4 = host;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = "http.keepAlive";
        r3 = "false";
        java.lang.System.setProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Accept-Charset";
        r4 = "utf-8";
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Accept-Encoding";
        r4 = "compress;q=0.5, gzip;q=1.0";
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Content-Type";
        r4 = "text/html";
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Cookie";
        r4 = r15.mcz;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r4 = J(r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2.addHeader(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r15.mcx;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = 1;
        if (r2 != r3) goto L_0x0096;
    L_0x0091:
        r2 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        a(r15, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x0096:
        r2 = r12.mcs;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r12.mct;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r2.execute(r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r12.mcu = r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r2.getStatusLine();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r2.getStatusCode();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r12.result = r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r6 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7 = "set-cookie";
        r6 = r6.getFirstHeader(r7);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r6 == 0) goto L_0x034b;
    L_0x00bb:
        r5 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r6 = "set-cookie";
        r5 = r5.getFirstHeader(r6);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r6 = r5;
    L_0x00c9:
        r5 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7 = "Content-Encoding";
        r5 = r5.getFirstHeader(r7);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r5 == 0) goto L_0x00e1;
    L_0x00d4:
        r4 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = "Content-Encoding";
        r4 = r4.getFirstHeader(r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r4 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x00e1:
        r5 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7 = "Content-Disposition";
        r5 = r5.getFirstHeader(r7);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r5 == 0) goto L_0x00f9;
    L_0x00ec:
        r3 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = "Content-Disposition";
        r3 = r3.getFirstHeader(r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x00f9:
        if (r3 == 0) goto L_0x0187;
    L_0x00fb:
        r5 = "attachment;";
        r3 = r3.contains(r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r3 == 0) goto L_0x0187;
    L_0x0104:
        r3 = "download";
        r3 = r14.contains(r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r3 == 0) goto L_0x0187;
    L_0x010d:
        r3 = 1;
        r5 = r3;
    L_0x010f:
        if (r5 != 0) goto L_0x018a;
    L_0x0111:
        r3 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7 = "Content-Length";
        r3 = r3.getFirstHeader(r7);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r3 == 0) goto L_0x0129;
    L_0x011c:
        r2 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = "Content-Length";
        r2 = r2.getFirstHeader(r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x0129:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r3 != 0) goto L_0x018a;
    L_0x012f:
        r3 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r8 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x018a;
    L_0x013c:
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = -10000; // 0xffffffffffffd8f0 float:NaN double:NaN;
        r4 = 0;
        r5 = "mail content to large";
        r2.<init>(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x014b:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
    L_0x0154:
        return r2;
    L_0x0155:
        r2 = 0;
        goto L_0x0037;
    L_0x0158:
        r3 = new org.apache.http.client.methods.HttpPost;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r15.mcx;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 != 0) goto L_0x0185;
    L_0x015e:
        r2 = r15.mcy;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x0160:
        r2 = b(r13, r14, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r12.mct = r3;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        goto L_0x0040;
    L_0x016b:
        r2 = move-exception;
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
        r4 = 0;
        r5 = "unsupported ecoding";
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x017b:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x0185:
        r2 = 0;
        goto L_0x0160;
    L_0x0187:
        r3 = 0;
        r5 = r3;
        goto L_0x010f;
    L_0x018a:
        r2 = r12.mcu;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7 = r2.getEntity();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r7.getContent();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r4 == 0) goto L_0x0348;
    L_0x0199:
        r2 = "gzip";
        r2 = r4.contains(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 == 0) goto L_0x0348;
    L_0x01a2:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r4 = r2;
    L_0x01a8:
        if (r5 == 0) goto L_0x0217;
    L_0x01aa:
        r8 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = mcw;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r15.mcy;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r10 = "default_attach_name";
        r2 = r2.get(r10);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 != 0) goto L_0x020b;
    L_0x01be:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x01c6:
        r2 = r9.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r8.<init>(r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = new java.io.FileOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = 1;
        r3.<init>(r8, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x01d7:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
    L_0x01db:
        r8 = r12.mcv;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r8 != 0) goto L_0x0238;
    L_0x01df:
        r8 = r4.read(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r8 <= 0) goto L_0x0238;
    L_0x01e5:
        r9 = 0;
        r3.write(r2, r9, r8);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r16.bol();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        goto L_0x01db;
    L_0x01f0:
        r2 = move-exception;
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = -10005; // 0xffffffffffffd8eb float:NaN double:NaN;
        r4 = 0;
        r5 = "unknow host";
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x0200:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x020b:
        r2 = r15.mcy;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r10 = "default_attach_name";
        r2 = r2.get(r10);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = (java.io.Serializable) r2;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        goto L_0x01c6;
    L_0x0217:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        goto L_0x01d7;
    L_0x021d:
        r2 = move-exception;
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = -10002; // 0xffffffffffffd8ee float:NaN double:NaN;
        r4 = 0;
        r5 = "client protocol error";
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x022d:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x0238:
        r2 = r12.mcv;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r2 == 0) goto L_0x0252;
    L_0x023c:
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mcs;
        if (r2 == 0) goto L_0x024f;
    L_0x0246:
        r2 = r12.mcs;
        r2 = r2.getConnectionManager();
        r2.shutdown();
    L_0x024f:
        r2 = 0;
        goto L_0x0154;
    L_0x0252:
        r4 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r8 = r12.result;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r6 = JR(r6);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        if (r5 == 0) goto L_0x029c;
    L_0x025c:
        r2 = "";
    L_0x025f:
        r4.<init>(r8, r6, r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r7.consumeContent();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = "MicroMsg.URLConnectionUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = "uri=";
        r3.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r3.append(r14);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5 = ", ";
        r3 = r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r12.mcs;
        if (r2 == 0) goto L_0x0299;
    L_0x0290:
        r2 = r12.mcs;
        r2 = r2.getConnectionManager();
        r2.shutdown();
    L_0x0299:
        r2 = r4;
        goto L_0x0154;
    L_0x029c:
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r0 = r3;
        r0 = (java.io.ByteArrayOutputStream) r0;	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r0;
        r2 = r2.toByteArray();	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r5.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x016b, UnknownHostException -> 0x01f0, ClientProtocolException -> 0x021d, IllegalStateException -> 0x02ab, FileNotFoundException -> 0x02c6, Exception -> 0x02e1, OutOfMemoryError -> 0x030d }
        r2 = r5;
        goto L_0x025f;
    L_0x02ab:
        r2 = move-exception;
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4 = 0;
        r5 = "illegal state";
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x02bb:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x02c6:
        r2 = move-exception;
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = -10004; // 0xffffffffffffd8ec float:NaN double:NaN;
        r4 = 0;
        r5 = "output file not found";
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x02d6:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x02e1:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r4 = "http unavailable";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0339 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0339 }
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = r12.result;	 Catch:{ all -> 0x0339 }
        if (r3 != 0) goto L_0x030a;
    L_0x02f4:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x02f6:
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x02ff:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x030a:
        r3 = r12.result;	 Catch:{ all -> 0x0339 }
        goto L_0x02f6;
    L_0x030d:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r4 = "http unavailable";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0339 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x0339 }
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0339 }
        r3 = r12.result;	 Catch:{ all -> 0x0339 }
        if (r3 != 0) goto L_0x0336;
    L_0x0320:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x0322:
        r4 = 0;
        r5 = 0;
        r2.<init>(r3, r4, r5);	 Catch:{ all -> 0x0339 }
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0154;
    L_0x032b:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
        goto L_0x0154;
    L_0x0336:
        r3 = r12.result;	 Catch:{ all -> 0x0339 }
        goto L_0x0322;
    L_0x0339:
        r2 = move-exception;
        r3 = r12.mcs;
        if (r3 == 0) goto L_0x0347;
    L_0x033e:
        r3 = r12.mcs;
        r3 = r3.getConnectionManager();
        r3.shutdown();
    L_0x0347:
        throw r2;
    L_0x0348:
        r4 = r3;
        goto L_0x01a8;
    L_0x034b:
        r6 = r5;
        goto L_0x00c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.g.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.qqmail.b.h$b, com.tencent.mm.plugin.qqmail.b.h$a):com.tencent.mm.plugin.qqmail.b.h$c");
    }

    public final void cancel() {
        x.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        this.mcv = true;
        if (!(this.mct == null || this.mct.isAborted())) {
            this.mct.abort();
        }
        if (this.mcs != null) {
            this.mcs.getConnectionManager().shutdown();
        }
    }

    private static void a(b bVar, HttpRequestBase httpRequestBase) {
        if (bVar.mcy != null) {
            List arrayList = new ArrayList();
            for (String str : bVar.mcy.keySet()) {
                arrayList.add(new BasicNameValuePair(str, (String) bVar.mcy.get(str)));
            }
            ((HttpPost) httpRequestBase).setEntity(new UrlEncodedFormEntity(arrayList, ProtocolPackage.ServerEncoding));
        }
    }
}
