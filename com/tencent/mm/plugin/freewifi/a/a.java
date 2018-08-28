package com.tencent.mm.plugin.freewifi.a;

public final class a {
    private static final int jiZ = com.tencent.mm.plugin.freewifi.h.b.aNY().aNT();
    private static final int jja = com.tencent.mm.plugin.freewifi.h.b.aNY().aNU();

    private static class b {
        private static a jjb = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    public static a aOj() {
        return b.jjb;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, com.tencent.mm.plugin.freewifi.a.a.a r5) {
        /*
        r3 = 0;
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=request, desc=it starts a http GET request. url=%s.";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.isEmpty(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x006d }
        r0.<init>(r4);	 Catch:{ Exception -> 0x006d }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x006d }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x0047;
    L_0x0024:
        r1 = jiZ;	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r1 = jja;	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r1 = "User-Agent";
        r2 = com.tencent.mm.plugin.freewifi.h.b.aNY();	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r2 = r2.getUserAgent();	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r1 = 0;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        r5.g(r0);	 Catch:{ IOException -> 0x004d, Exception -> 0x005d, all -> 0x0062 }
    L_0x0047:
        if (r0 == 0) goto L_0x0015;
    L_0x0049:
        r0.disconnect();
        goto L_0x0015;
    L_0x004d:
        r1 = move-exception;
        r5.j(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        goto L_0x0047;
    L_0x0052:
        r1 = move-exception;
        r2 = r0;
    L_0x0054:
        r5.j(r1);	 Catch:{ all -> 0x006a }
        if (r2 == 0) goto L_0x0015;
    L_0x0059:
        r2.disconnect();
        goto L_0x0015;
    L_0x005d:
        r1 = move-exception;
        r5.j(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0062 }
        goto L_0x0047;
    L_0x0062:
        r1 = move-exception;
        r2 = r0;
    L_0x0064:
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.disconnect();
    L_0x0069:
        throw r1;
    L_0x006a:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0064;
    L_0x006d:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r12, java.lang.String r13, com.tencent.mm.plugin.freewifi.a.a.a r14) {
        /*
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=requestPost, desc=it starts a http POST request. url=%s, postParams=%s.";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r12;
        r3 = 1;
        r2[r3] = r13;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.isEmpty(r12);
        if (r0 != 0) goto L_0x001e;
    L_0x0018:
        r0 = com.tencent.mm.plugin.freewifi.m.isEmpty(r13);
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        if (r13 == 0) goto L_0x002a;
    L_0x0021:
        r0 = "";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x00bc;
    L_0x002a:
        r0 = "";
        r1 = r0;
    L_0x002e:
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r2 = "method=requestPost, desc=it extracts PostParams. url=%s, postParams=%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r12;
        r4 = 1;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x01a1 }
        r0.<init>(r12);	 Catch:{ Exception -> 0x01a1 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x01a1 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x01a1 }
        if (r0 == 0) goto L_0x00b5;
    L_0x004e:
        r2 = jiZ;	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = jja;	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "User-Agent";
        r3 = com.tencent.mm.plugin.freewifi.h.b.aNY();	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r3 = r3.getUserAgent();	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = 0;
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "charset";
        r3 = "utf-8";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = 0;
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "UTF-8";
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = "Content-Length";
        r3 = r1.length;	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2.write(r1);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2.flush();	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r2.close();	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        r14.g(r0);	 Catch:{ IOException -> 0x017e, Exception -> 0x0190, all -> 0x0196 }
    L_0x00b5:
        if (r0 == 0) goto L_0x001e;
    L_0x00b7:
        r0.disconnect();
        goto L_0x001e;
    L_0x00bc:
        r2 = "";
        r0 = "&";
        r5 = r13.split(r0);
        r0 = 1;
        r4 = r0;
    L_0x00c8:
        r0 = 10;
        if (r4 > r0) goto L_0x017b;
    L_0x00cc:
        r0 = new java.lang.StringBuilder;
        r1 = "key";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r6 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r1 = "value";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r7 = r0.toString();
        r1 = 0;
        r0 = 0;
        r8 = r5.length;
        r3 = 0;
    L_0x00f0:
        if (r3 >= r8) goto L_0x012e;
    L_0x00f2:
        r9 = r5[r3];
        r10 = r9.indexOf(r6);
        if (r10 < 0) goto L_0x0112;
    L_0x00fa:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x0112;
    L_0x0105:
        r1 = "=";
        r1 = r9.split(r1);
        r9 = 1;
        r1 = r1[r9];
    L_0x010f:
        r3 = r3 + 1;
        goto L_0x00f0;
    L_0x0112:
        r10 = r9.indexOf(r7);
        if (r10 < 0) goto L_0x010f;
    L_0x0118:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x010f;
    L_0x0123:
        r0 = "=";
        r0 = r9.split(r0);
        r9 = 1;
        r0 = r0[r9];
        goto L_0x010f;
    L_0x012e:
        if (r1 == 0) goto L_0x017b;
    L_0x0130:
        if (r0 == 0) goto L_0x017b;
    L_0x0132:
        r3 = 1;
        if (r4 != r3) goto L_0x0157;
    L_0x0135:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0151:
        r1 = r4 + 1;
        r4 = r1;
        r2 = r0;
        goto L_0x00c8;
    L_0x0157:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "&";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0151;
    L_0x017b:
        r1 = r2;
        goto L_0x002e;
    L_0x017e:
        r1 = move-exception;
        r14.j(r1);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        goto L_0x00b5;
    L_0x0184:
        r1 = move-exception;
        r2 = r0;
    L_0x0186:
        r14.j(r1);	 Catch:{ all -> 0x019e }
        if (r2 == 0) goto L_0x001e;
    L_0x018b:
        r2.disconnect();
        goto L_0x001e;
    L_0x0190:
        r1 = move-exception;
        r14.j(r1);	 Catch:{ Exception -> 0x0184, all -> 0x0196 }
        goto L_0x00b5;
    L_0x0196:
        r1 = move-exception;
        r2 = r0;
    L_0x0198:
        if (r2 == 0) goto L_0x019d;
    L_0x019a:
        r2.disconnect();
    L_0x019d:
        throw r1;
    L_0x019e:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0198;
    L_0x01a1:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0186;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }
}
