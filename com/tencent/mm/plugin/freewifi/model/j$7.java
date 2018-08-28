package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.network.n.a;

class j$7 extends a {
    private byte[] cWZ = new byte[0];
    final /* synthetic */ j jkt;

    j$7(j jVar) {
        this.jkt = jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ev(int r9) {
        /*
        r8 = this;
        r1 = r8.cWZ;
        monitor-enter(r1);
        r0 = com.tencent.mm.model.au.HX();	 Catch:{ all -> 0x00ea }
        if (r0 != 0) goto L_0x0014;
    L_0x0009:
        r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
        r2 = "account not ready";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x00ea }
        monitor-exit(r1);	 Catch:{ all -> 0x00ea }
    L_0x0013:
        return;
    L_0x0014:
        r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
        r3 = "onNetworkChange state=";
        r2.<init>(r3);	 Catch:{ all -> 0x00ea }
        r2 = r2.append(r9);	 Catch:{ all -> 0x00ea }
        r3 = ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ea }
        r2 = r2.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x00ea }
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00ea }
        r2 = "connectivity";
        r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x00ea }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ all -> 0x00ea }
        r2 = 1;
        r2 = r0.getNetworkInfo(r2);	 Catch:{ all -> 0x00ea }
        if (r2 == 0) goto L_0x0088;
    L_0x0045:
        r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
        r5 = "wifiNetwork:";
        r4.<init>(r5);	 Catch:{ all -> 0x00ea }
        r4 = r4.append(r2);	 Catch:{ all -> 0x00ea }
        r4 = r4.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);	 Catch:{ all -> 0x00ea }
        r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
        r4 = " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
        r6 = 0;
        r7 = r2.isAvailable();	 Catch:{ all -> 0x00ea }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
        r5[r6] = r7;	 Catch:{ all -> 0x00ea }
        r6 = 1;
        r7 = r2.isConnected();	 Catch:{ all -> 0x00ea }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
        r5[r6] = r7;	 Catch:{ all -> 0x00ea }
        r6 = 2;
        r7 = r2.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
        r5[r6] = r7;	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
    L_0x0088:
        r3 = 0;
        r0 = r0.getNetworkInfo(r3);	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00cb;
    L_0x008f:
        r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
        r4 = "mobileNetworkInfo";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
        r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
        r4 = " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
        r6 = 0;
        r7 = r0.isAvailable();	 Catch:{ all -> 0x00ea }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
        r5[r6] = r7;	 Catch:{ all -> 0x00ea }
        r6 = 1;
        r7 = r0.isConnected();	 Catch:{ all -> 0x00ea }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
        r5[r6] = r7;	 Catch:{ all -> 0x00ea }
        r6 = 2;
        r0 = r0.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
        r5[r6] = r0;	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
    L_0x00cb:
        r0 = 6;
        if (r0 == r9) goto L_0x00da;
    L_0x00ce:
        r0 = 4;
        if (r0 == r9) goto L_0x00da;
    L_0x00d1:
        if (r9 == 0) goto L_0x00da;
    L_0x00d3:
        r0 = -1;
        if (r0 == r9) goto L_0x00da;
    L_0x00d6:
        r0 = -9;
        if (r0 != r9) goto L_0x0115;
    L_0x00da:
        r0 = r2.isConnected();	 Catch:{ all -> 0x00ea }
        if (r0 != 0) goto L_0x00ed;
    L_0x00e0:
        r0 = com.tencent.mm.plugin.freewifi.model.f.a.aOG();	 Catch:{ all -> 0x00ea }
        r0.aOD();	 Catch:{ all -> 0x00ea }
        monitor-exit(r1);	 Catch:{ all -> 0x00ea }
        goto L_0x0013;
    L_0x00ea:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00ea }
        throw r0;
    L_0x00ed:
        r0 = com.tencent.mm.plugin.freewifi.model.f.a.aOG();	 Catch:{ all -> 0x00ea }
        r2 = com.tencent.mm.plugin.freewifi.model.d.aOA();	 Catch:{ all -> 0x00ea }
        r0 = r0.a(r2);	 Catch:{ all -> 0x00ea }
        r2 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
        r3 = "isWifiIndeedChanged=%b";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ea }
        r5 = 0;
        r6 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
        r4[r5] = r6;	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x0115;
    L_0x010e:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOP();	 Catch:{ all -> 0x00ea }
        r0.aOs();	 Catch:{ all -> 0x00ea }
    L_0x0115:
        monitor-exit(r1);	 Catch:{ all -> 0x00ea }
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j$7.ev(int):void");
    }
}
