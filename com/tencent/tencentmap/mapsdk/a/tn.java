package com.tencent.tencentmap.mapsdk.a;

import java.util.Locale;

public final class tn {
    private static String a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.net.URL r8) {
        /*
        r1 = 0;
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r1;
    L_0x0004:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        if (r0 == 0) goto L_0x0142;
    L_0x000a:
        r0 = new java.net.Proxy;	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r3 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r4 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r5 = android.net.Proxy.getDefaultPort();	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
    L_0x001e:
        if (r0 == 0) goto L_0x00a6;
    L_0x0020:
        r0 = r8.openConnection(r0);	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r5 = r0;
    L_0x0027:
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5.setConnectTimeout(r0);	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r5.setReadTimeout(r0);	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = "Accept-Encoding";
        r2 = "gzip, deflate";
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = "User-Agent";
        r2 = "QmapSdk/1.3.1.e70cce6 Android";
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = "Accept-Language";
        r2 = a;	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r5.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = r5.getResponseCode();	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r2) goto L_0x013c;
    L_0x0053:
        r4 = r5.getInputStream();	 Catch:{ Exception -> 0x0123, all -> 0x010f }
        r0 = r5.getContentType();	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r2 = "text";
        r0 = r0.contains(r2);	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        if (r0 == 0) goto L_0x00af;
    L_0x006c:
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x012c, all -> 0x0118 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x012c, all -> 0x0118 }
        r0 = r2.readLine();	 Catch:{ Exception -> 0x012f, all -> 0x011b }
        r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x012f, all -> 0x011b }
        r0 = r0.trim();	 Catch:{ Exception -> 0x012f, all -> 0x011b }
        if (r0 == 0) goto L_0x0139;
    L_0x0084:
        r6 = "0";
        r0 = r0.equals(r6);	 Catch:{ Exception -> 0x012f, all -> 0x011b }
        if (r0 == 0) goto L_0x0139;
    L_0x008d:
        r0 = 1;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x012f, all -> 0x011b }
        r6 = 0;
        r7 = -1;
        r0[r6] = r7;	 Catch:{ Exception -> 0x012f, all -> 0x011b }
    L_0x0094:
        r6 = r2;
    L_0x0095:
        if (r5 == 0) goto L_0x009a;
    L_0x0097:
        r5.disconnect();
    L_0x009a:
        com.tencent.tencentmap.mapsdk.a.rv.a(r6);
        com.tencent.tencentmap.mapsdk.a.rv.a(r3);
        com.tencent.tencentmap.mapsdk.a.rv.a(r4);
        r1 = r0;
        goto L_0x0003;
    L_0x00a6:
        r0 = r8.openConnection();	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00e6, all -> 0x00fb }
        r5 = r0;
        goto L_0x0027;
    L_0x00af:
        r0 = "gzip";
        r2 = "Content-Encoding";
        r2 = r5.getHeaderField(r2);	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        if (r0 == 0) goto L_0x0137;
    L_0x00bf:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0128, all -> 0x0114 }
    L_0x00c4:
        r0 = com.tencent.tencentmap.mapsdk.a.rv.a(r2);	 Catch:{ Exception -> 0x0132, all -> 0x011e }
        r3 = 0;
        r4 = r0.length;	 Catch:{ Exception -> 0x00d1, all -> 0x011e }
        android.graphics.BitmapFactory.decodeByteArray(r0, r3, r4);	 Catch:{ Exception -> 0x00d1, all -> 0x011e }
        r6 = r1;
        r3 = r1;
        r4 = r2;
        goto L_0x0095;
    L_0x00d1:
        r0 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0132, all -> 0x011e }
        r4 = "decoder bitmap error:";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0132, all -> 0x011e }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0132, all -> 0x011e }
        r3.append(r0);	 Catch:{ Exception -> 0x0132, all -> 0x011e }
        r6 = r1;
        r3 = r1;
        r4 = r2;
        r0 = r1;
        goto L_0x0095;
    L_0x00e6:
        r0 = move-exception;
        r0 = r1;
        r3 = r1;
        r4 = r1;
        r5 = r1;
    L_0x00eb:
        if (r5 == 0) goto L_0x00f0;
    L_0x00ed:
        r5.disconnect();
    L_0x00f0:
        com.tencent.tencentmap.mapsdk.a.rv.a(r0);
        com.tencent.tencentmap.mapsdk.a.rv.a(r3);
        com.tencent.tencentmap.mapsdk.a.rv.a(r4);
        goto L_0x0003;
    L_0x00fb:
        r0 = move-exception;
        r6 = r1;
        r3 = r1;
        r4 = r1;
        r5 = r1;
    L_0x0100:
        if (r5 == 0) goto L_0x0105;
    L_0x0102:
        r5.disconnect();
    L_0x0105:
        com.tencent.tencentmap.mapsdk.a.rv.a(r6);
        com.tencent.tencentmap.mapsdk.a.rv.a(r3);
        com.tencent.tencentmap.mapsdk.a.rv.a(r4);
        throw r0;
    L_0x010f:
        r0 = move-exception;
        r6 = r1;
        r3 = r1;
        r4 = r1;
        goto L_0x0100;
    L_0x0114:
        r0 = move-exception;
        r6 = r1;
        r3 = r1;
        goto L_0x0100;
    L_0x0118:
        r0 = move-exception;
        r6 = r1;
        goto L_0x0100;
    L_0x011b:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0100;
    L_0x011e:
        r0 = move-exception;
        r6 = r1;
        r3 = r1;
        r4 = r2;
        goto L_0x0100;
    L_0x0123:
        r0 = move-exception;
        r0 = r1;
        r3 = r1;
        r4 = r1;
        goto L_0x00eb;
    L_0x0128:
        r0 = move-exception;
        r0 = r1;
        r3 = r1;
        goto L_0x00eb;
    L_0x012c:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00eb;
    L_0x012f:
        r0 = move-exception;
        r0 = r2;
        goto L_0x00eb;
    L_0x0132:
        r0 = move-exception;
        r0 = r1;
        r3 = r1;
        r4 = r2;
        goto L_0x00eb;
    L_0x0137:
        r2 = r4;
        goto L_0x00c4;
    L_0x0139:
        r0 = r1;
        goto L_0x0094;
    L_0x013c:
        r6 = r1;
        r3 = r1;
        r4 = r1;
        r0 = r1;
        goto L_0x0095;
    L_0x0142:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.tn.a(java.net.URL):byte[]");
    }
}
