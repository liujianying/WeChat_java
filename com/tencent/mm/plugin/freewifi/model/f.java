package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.sdk.platformtools.x;

public final class f {
    private b jjN;

    private static class a {
        private static f jjO = new f();
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
    }

    public final synchronized void aOD() {
        if (this.jjN != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.jjN.jjP, this.jjN.jjQ});
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.jjN = null;
        x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(android.net.wifi.WifiInfo r9) {
        /*
        r8 = this;
        r7 = 1;
        r0 = 0;
        monitor-enter(r8);
        if (r9 == 0) goto L_0x0017;
    L_0x0005:
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0017;
    L_0x000b:
        r1 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0017;
    L_0x0011:
        r1 = r9.getMacAddress();	 Catch:{ all -> 0x00b8 }
        if (r1 != 0) goto L_0x0022;
    L_0x0017:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "WifiInfo got Currently is null. Cannot compared with last WifiInfo.";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);	 Catch:{ all -> 0x00b8 }
    L_0x0020:
        monitor-exit(r8);
        return r0;
    L_0x0022:
        r1 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x00ae;
    L_0x0026:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "last WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b8 }
        r4 = 0;
        r5 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r5 = r5.jjP;	 Catch:{ all -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b8 }
        r4 = 1;
        r5 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r5 = r5.jjQ;	 Catch:{ all -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ all -> 0x00b8 }
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        r1 = com.tencent.mm.plugin.freewifi.m.BQ(r1);	 Catch:{ all -> 0x00b8 }
        r2 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r2 = r2.jjP;	 Catch:{ all -> 0x00b8 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0060;
    L_0x0052:
        r1 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        r2 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r2 = r2.jjQ;	 Catch:{ all -> 0x00b8 }
        r1 = r1.equalsIgnoreCase(r2);	 Catch:{ all -> 0x00b8 }
        if (r1 != 0) goto L_0x0020;
    L_0x0060:
        r3 = r9.getMacAddress();	 Catch:{ all -> 0x00b8 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00b8 }
        r1 = 22;
        if (r0 <= r1) goto L_0x0079;
    L_0x006a:
        if (r3 == 0) goto L_0x0075;
    L_0x006c:
        r0 = "02:00:00:00:00:00";
        r0 = r3.equals(r0);	 Catch:{ all -> 0x00b8 }
        if (r0 == 0) goto L_0x0079;
    L_0x0075:
        r3 = com.tencent.mm.plugin.freewifi.m.aOf();	 Catch:{ all -> 0x00b8 }
    L_0x0079:
        r0 = new com.tencent.mm.plugin.freewifi.model.f$b;	 Catch:{ all -> 0x00b8 }
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        r1 = com.tencent.mm.plugin.freewifi.m.BQ(r1);	 Catch:{ all -> 0x00b8 }
        r2 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00b8 }
        r6 = 0;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x00b8 }
        r8.jjN = r0;	 Catch:{ all -> 0x00b8 }
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "new WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b8 }
        r3 = 0;
        r4 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r4 = r4.jjP;	 Catch:{ all -> 0x00b8 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b8 }
        r3 = 1;
        r4 = r8.jjN;	 Catch:{ all -> 0x00b8 }
        r4 = r4.jjQ;	 Catch:{ all -> 0x00b8 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ all -> 0x00b8 }
        r0 = r7;
        goto L_0x0020;
    L_0x00ae:
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "last WifiInfo stored in memmory is null.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x00b8 }
        goto L_0x0060;
    L_0x00b8:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.f.a(android.net.wifi.WifiInfo):boolean");
    }

    public final synchronized b aOE() {
        return this.jjN;
    }

    public final synchronized void aOF() {
        if (this.jjN != null) {
            b bVar;
            b bVar2 = this.jjN;
            if (bVar2.jjS) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.jjP, bVar2.jjQ, bVar2.jjR, bVar2.jjF);
                bVar.jjS = true;
            }
            this.jjN = bVar;
        }
    }
}
