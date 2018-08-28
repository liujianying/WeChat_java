package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

class dg$a extends Handler {
    private long a = 0;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private /* synthetic */ dg e;

    dg$a(dg dgVar, Looper looper) {
        this.e = dgVar;
        super(looper);
    }

    public final void a() {
        this.d = 0;
        removeCallbacksAndMessages(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r14) {
        /*
        r13 = this;
        r12 = 2;
        r10 = 0;
        r7 = 1;
        r8 = 0;
        r0 = r13.e;
        r1 = c.t.m.g.dg.b(r0);
        monitor-enter(r1);
        r0 = r13.e;	 Catch:{ all -> 0x007b }
        r0 = c.t.m.g.dg.c(r0);	 Catch:{ all -> 0x007b }
        r0 = c.t.m.g.j.a(r0);	 Catch:{ all -> 0x007b }
        if (r0 != 0) goto L_0x0024;
    L_0x0018:
        r0 = r13.e;	 Catch:{ all -> 0x007b }
        r0 = c.t.m.g.dg.d(r0);	 Catch:{ all -> 0x007b }
        r2 = c.t.m.g.dg$b.Normal;	 Catch:{ all -> 0x007b }
        if (r0 != r2) goto L_0x0024;
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
    L_0x0023:
        return;
    L_0x0024:
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
        r0 = r13.e;
        r9 = c.t.m.g.dg.e(r0);
        r1 = r9.getRequestLevel();
        r0 = r13.e;
        r2 = c.t.m.g.dg.f(r0);
        r0 = r14.what;	 Catch:{ Throwable -> 0x00c3 }
        switch(r0) {
            case 554: goto L_0x003b;
            case 555: goto L_0x0486;
            case 3997: goto L_0x0244;
            case 3999: goto L_0x012b;
            case 4998: goto L_0x0463;
            case 4999: goto L_0x027e;
            case 7999: goto L_0x00fa;
            case 11998: goto L_0x00c6;
            case 11999: goto L_0x007e;
            default: goto L_0x003a;
        };	 Catch:{ Throwable -> 0x00c3 }
    L_0x003a:
        goto L_0x0023;
    L_0x003b:
        r0 = r14.getData();	 Catch:{ Throwable -> 0x00c3 }
        if (r0 == 0) goto L_0x0023;
    L_0x0041:
        r1 = "WIFIS";
        r0 = r0.getString(r1);	 Catch:{ Throwable -> 0x00c3 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r1 != 0) goto L_0x0023;
    L_0x004e:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.p(r1);	 Catch:{ Throwable -> 0x00c3 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0079 }
        if (r2 != 0) goto L_0x0023;
    L_0x005a:
        r2 = "UTF-8";
        r2 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x0079 }
        r2 = c.t.m.g.ei.a(r2);	 Catch:{ Throwable -> 0x0079 }
        r3 = 2;
        com.tencent.tencentmap.lbssdk.service.e.o(r2, r3);	 Catch:{ Throwable -> 0x0079 }
        r3 = new c.t.m.g.dk$a;	 Catch:{ Throwable -> 0x0079 }
        r4 = 3;
        r5 = "http://ue.indoorloc.map.qq.com/?wl";
        r6 = 0;
        r3.<init>(r4, r2, r5, r6);	 Catch:{ Throwable -> 0x0079 }
        r3.b = r0;	 Catch:{ Throwable -> 0x0079 }
        r1.a(r3);	 Catch:{ Throwable -> 0x0079 }
        goto L_0x0023;
    L_0x0079:
        r0 = move-exception;
        goto L_0x0023;
    L_0x007b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
        throw r0;
    L_0x007e:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.g(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r0 == 0) goto L_0x00b8;
    L_0x0086:
        r0 = r9.getInterval();	 Catch:{ Throwable -> 0x00c3 }
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b8;
    L_0x008e:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.g(r1);	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.a(r0, r1);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.g(r1);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r4 = c.t.m.g.dg.h(r4);	 Catch:{ Throwable -> 0x00c3 }
        r5 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
        c.t.m.g.dg.a(r0, r1, r4, r5);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.g(r0);	 Catch:{ Throwable -> 0x00c3 }
        r1 = "timed";
        a(r0, r1);	 Catch:{ Throwable -> 0x00c3 }
    L_0x00b8:
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0023;
    L_0x00bc:
        r0 = 11999; // 0x2edf float:1.6814E-41 double:5.9283E-320;
        r13.sendEmptyMessageDelayed(r0, r2);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x00c3:
        r0 = move-exception;
        goto L_0x0023;
    L_0x00c6:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.g(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r0 == 0) goto L_0x0023;
    L_0x00ce:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.g(r1);	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.a(r0, r1);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.g(r1);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.h(r2);	 Catch:{ Throwable -> 0x00c3 }
        r3 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
        c.t.m.g.dg.a(r0, r1, r2, r3);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.g(r0);	 Catch:{ Throwable -> 0x00c3 }
        r1 = "direct";
        a(r0, r1);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x00fa:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.i(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r0 != 0) goto L_0x0023;
    L_0x0102:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.e(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r0.getInterval();	 Catch:{ Throwable -> 0x00c3 }
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r2 = java.lang.Math.max(r2, r4);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r4 = c.t.m.g.dg.j(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r0 == 0) goto L_0x0023;
    L_0x011c:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r10 = c.t.m.g.dg.j(r0);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r4 - r10;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0023;
    L_0x012b:
        r0 = 3999; // 0xf9f float:5.604E-42 double:1.976E-320;
        r13.removeMessages(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.d(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg$b.Daemon;	 Catch:{ Throwable -> 0x00c3 }
        if (r0 == r2) goto L_0x0196;
    L_0x013a:
        c.t.m.g.dg.b();	 Catch:{ Throwable -> 0x00c3 }
    L_0x013d:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r10 = c.t.m.g.dg.l(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.m(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r0.a();	 Catch:{ Throwable -> 0x00c3 }
        if (r2 == 0) goto L_0x01f0;
    L_0x014f:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r4 = r13.a;	 Catch:{ Throwable -> 0x00c3 }
        r2 = r2 - r4;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x01f0;
    L_0x015d:
        r2 = 1;
        r13.b = r2;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 0;
        r13.c = r2;	 Catch:{ Throwable -> 0x00c3 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r13.a = r2;	 Catch:{ Throwable -> 0x00c3 }
    L_0x0169:
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.n(r2);	 Catch:{ Throwable -> 0x00c3 }
        r3 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r3 = c.t.m.g.dg.o(r3);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r13.b;	 Catch:{ Throwable -> 0x00c3 }
        r5 = r13.c;	 Catch:{ Throwable -> 0x00c3 }
        r6 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r6 = c.t.m.g.dg.d(r6);	 Catch:{ Throwable -> 0x00c3 }
        r11 = c.t.m.g.dg$b.Daemon;	 Catch:{ Throwable -> 0x00c3 }
        if (r6 != r11) goto L_0x01f5;
    L_0x0183:
        r6 = r7;
    L_0x0184:
        r2 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00c3 }
        r3 = c.t.m.g.ei.a(r2);	 Catch:{ Throwable -> 0x00c3 }
        if (r3 != 0) goto L_0x01f7;
    L_0x018e:
        if (r7 == 0) goto L_0x01f9;
    L_0x0190:
        r0 = 2;
        r13.b(r0);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0196:
        r0 = c.t.m.g.cn.a();	 Catch:{ Throwable -> 0x00c3 }
        r2 = "up_daemon_delay";
        r2 = r0.c(r2);	 Catch:{ Throwable -> 0x00c3 }
        r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x01ab;
    L_0x01a8:
        r2 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
    L_0x01ab:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c3 }
        r4 = "the daemonLocation,so we delay long time upload:";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x00c3 }
        r4 = ",";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00c3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00c3 }
        r4 = ",";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r4 = c.t.m.g.dg.k(r4);	 Catch:{ Throwable -> 0x00c3 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00c3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r10 = c.t.m.g.dg.k(r0);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r4 - r10;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0023;
    L_0x01e5:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.a(r0, r2);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x013d;
    L_0x01f0:
        r2 = 0;
        r13.b = r2;	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0169;
    L_0x01f5:
        r6 = r8;
        goto L_0x0184;
    L_0x01f7:
        r7 = r8;
        goto L_0x018e;
    L_0x01f9:
        r3 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r3 = c.t.m.g.dg.d(r3);	 Catch:{ Throwable -> 0x00c3 }
        r4 = c.t.m.g.dg$b.Normal;	 Catch:{ Throwable -> 0x00c3 }
        if (r3 != r4) goto L_0x022d;
    L_0x0203:
        r3 = com.tencent.map.geolocation.internal.TencentExtraKeys.isRequestRawData(r9);	 Catch:{ Throwable -> 0x00c3 }
        if (r3 == 0) goto L_0x022d;
    L_0x0209:
        r0 = new c.t.m.g.eb$a;	 Catch:{ Throwable -> 0x00c3 }
        r0.<init>();	 Catch:{ Throwable -> 0x00c3 }
        r3 = 0;
        r0.b = r3;	 Catch:{ Throwable -> 0x00c3 }
        r0.c = r1;	 Catch:{ Throwable -> 0x00c3 }
        r0 = r0.a();	 Catch:{ Throwable -> 0x00c3 }
        r1 = r2.getBytes();	 Catch:{ Throwable -> 0x00c3 }
        com.tencent.map.geolocation.internal.TencentExtraKeys.setRawData(r0, r1);	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.a(r1, r0);	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 0;
        r3 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
        c.t.m.g.dg.a(r1, r0, r2, r3);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x022d:
        r1 = com.tencent.map.geolocation.internal.TencentExtraKeys.MOCK_LOCATION_FILTER;	 Catch:{ Throwable -> 0x00c3 }
        if (r1 == 0) goto L_0x0023;
    L_0x0231:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.p(r1);	 Catch:{ Throwable -> 0x00c3 }
        r1.a(r2, r0, r10);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.q(r0);	 Catch:{ Throwable -> 0x00c3 }
        java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0244:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.m(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.n(r2);	 Catch:{ Throwable -> 0x00c3 }
        r3 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r3 = c.t.m.g.dg.o(r3);	 Catch:{ Throwable -> 0x00c3 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.ei.a(r1);	 Catch:{ Throwable -> 0x00c3 }
        if (r2 != 0) goto L_0x026b;
    L_0x0263:
        if (r7 == 0) goto L_0x026d;
    L_0x0265:
        r0 = 2;
        r13.b(r0);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x026b:
        r7 = r8;
        goto L_0x0263;
    L_0x026d:
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.p(r2);	 Catch:{ Throwable -> 0x00c3 }
        r3 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r3 = c.t.m.g.dg.l(r3);	 Catch:{ Throwable -> 0x00c3 }
        r2.a(r1, r0, r3);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x027e:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.t(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r0.n;	 Catch:{ Throwable -> 0x00c3 }
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x029f;
    L_0x028a:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.t(r0);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r0.m;	 Catch:{ Throwable -> 0x00c3 }
        r2 = r2 - r4;
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.t(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0.n = r2;	 Catch:{ Throwable -> 0x00c3 }
    L_0x029f:
        r0 = 4998; // 0x1386 float:7.004E-42 double:2.4693E-320;
        r13.removeMessages(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r14.obj;	 Catch:{ Throwable -> 0x00c3 }
        r0 = (android.util.Pair) r0;	 Catch:{ Throwable -> 0x00c3 }
        r2 = r0.first;	 Catch:{ Throwable -> 0x00c3 }
        r4 = r2.toString();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r0.second;	 Catch:{ Throwable -> 0x00c3 }
        r0 = (c.t.m.g.dk.a) r0;	 Catch:{ Throwable -> 0x00c3 }
        r2 = r0.a;	 Catch:{ Throwable -> 0x00c3 }
        r2 = (c.t.m.g.dr) r2;	 Catch:{ Throwable -> 0x00c3 }
        r3 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r5 = r2.b;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.a(r3, r5);	 Catch:{ Throwable -> 0x00c3 }
        r5 = r0.b;	 Catch:{ Throwable -> 0x00c3 }
        r3 = r2.a();	 Catch:{ Throwable -> 0x00c3 }
        if (r3 == 0) goto L_0x0443;
    L_0x02c5:
        r3 = "gps";
    L_0x02c8:
        r6 = new c.t.m.g.eb$a;	 Catch:{ JSONException -> 0x0448 }
        r6.<init>();	 Catch:{ JSONException -> 0x0448 }
        r6.a = r4;	 Catch:{ JSONException -> 0x0448 }
        r6.c = r1;	 Catch:{ JSONException -> 0x0448 }
        r6.d = r3;	 Catch:{ JSONException -> 0x0448 }
        r3 = r6.a();	 Catch:{ JSONException -> 0x0448 }
        r1 = r3.getExtra();	 Catch:{ JSONException -> 0x0448 }
        r6 = "resp_json";
        r1.putString(r6, r4);	 Catch:{ JSONException -> 0x0448 }
        r1 = r3.isMockGps();	 Catch:{ JSONException -> 0x0448 }
        if (r1 != r7) goto L_0x02ea;
    L_0x02e7:
        r1 = 1;
        r13.c = r1;	 Catch:{ JSONException -> 0x0448 }
    L_0x02ea:
        c.t.m.g.eb.a(r3);	 Catch:{ JSONException -> 0x0448 }
        com.tencent.map.geolocation.internal.TencentExtraKeys.setRawQuery(r3, r5);	 Catch:{ Throwable -> 0x0450 }
        r1 = r2.c;	 Catch:{ Throwable -> 0x0450 }
        if (r1 == 0) goto L_0x0492;
    L_0x02f4:
        r1 = r2.c;	 Catch:{ Throwable -> 0x0450 }
        r1 = r1.c;	 Catch:{ Throwable -> 0x0450 }
    L_0x02f8:
        r2 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r4 = "sat_num";
        r2.putInt(r4, r1);	 Catch:{ Throwable -> 0x0450 }
        r1 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r2 = "req_cost";
        r4 = r14.arg1;	 Catch:{ Throwable -> 0x0450 }
        r4 = (long) r4;	 Catch:{ Throwable -> 0x0450 }
        r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x0450 }
        r1 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r2 = "req_start";
        r4 = r0.c;	 Catch:{ Throwable -> 0x0450 }
        r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x0450 }
        r1 = c.t.m.g.cn.a();	 Catch:{ Throwable -> 0x0450 }
        r2 = "callback_wifis";
        r1 = r1.d(r2);	 Catch:{ Throwable -> 0x0450 }
        if (r1 == 0) goto L_0x035a;
    L_0x0328:
        r1 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r2 = "wifi_collect_time";
        r4 = r0.c;	 Catch:{ Throwable -> 0x0450 }
        r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x0450 }
        r0 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r1 = "wlan";
        r2 = r13.e;	 Catch:{ Throwable -> 0x0450 }
        r2 = c.t.m.g.dg.o(r2);	 Catch:{ Throwable -> 0x0450 }
        r2 = c.t.m.g.ej.c(r2);	 Catch:{ Throwable -> 0x0450 }
        r0.putString(r1, r2);	 Catch:{ Throwable -> 0x0450 }
        r0 = r3.getExtra();	 Catch:{ Throwable -> 0x0450 }
        r1 = "wifis";
        r2 = r13.e;	 Catch:{ Throwable -> 0x0450 }
        r2 = c.t.m.g.dg.r(r2);	 Catch:{ Throwable -> 0x0450 }
        r2 = r2.i;	 Catch:{ Throwable -> 0x0450 }
        r0.putString(r1, r2);	 Catch:{ Throwable -> 0x0450 }
    L_0x035a:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.b(r0, r4);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r3.getIndoorBuildingId();	 Catch:{ Throwable -> 0x00c3 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r0 != 0) goto L_0x0456;
    L_0x036d:
        r0 = r7;
    L_0x036e:
        if (r0 == 0) goto L_0x03ad;
    L_0x0370:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.s(r1);	 Catch:{ Throwable -> 0x00c3 }
        if (r1 != r7) goto L_0x03ad;
    L_0x0378:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.r(r1);	 Catch:{ Throwable -> 0x00c3 }
        r4 = 0;
        r1.a(r4);	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.r(r1);	 Catch:{ Throwable -> 0x00c3 }
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r1.j = r4;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.e(r1);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r1.getInterval();	 Catch:{ Throwable -> 0x00c3 }
        r6 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x03a4;
    L_0x039d:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        c.t.m.g.dg.c(r1, r4);	 Catch:{ Throwable -> 0x00c3 }
    L_0x03a4:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 2;
        c.t.m.g.dg.a(r1, r2);	 Catch:{ Throwable -> 0x00c3 }
        r1 = 0;
        r13.d = r1;	 Catch:{ Throwable -> 0x00c3 }
    L_0x03ad:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.s(r1);	 Catch:{ Throwable -> 0x00c3 }
        if (r1 != r12) goto L_0x03ff;
    L_0x03b5:
        if (r0 != 0) goto L_0x0459;
    L_0x03b7:
        r1 = r13.d;	 Catch:{ Throwable -> 0x00c3 }
        r1 = r1 + 1;
        r13.d = r1;	 Catch:{ Throwable -> 0x00c3 }
    L_0x03bd:
        r1 = r13.d;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 5;
        if (r1 < r2) goto L_0x03ff;
    L_0x03c2:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.r(r1);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.t(r2);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r2.l;	 Catch:{ Throwable -> 0x00c3 }
        r1.j = r4;	 Catch:{ Throwable -> 0x00c3 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c3 }
        r2 = "indoor stop,";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00c3 }
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.e(r2);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r2.getInterval();	 Catch:{ Throwable -> 0x00c3 }
        r1.append(r4);	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = c.t.m.g.dg.e(r2);	 Catch:{ Throwable -> 0x00c3 }
        r4 = r2.getInterval();	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.c(r1, r4);	 Catch:{ Throwable -> 0x00c3 }
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 1;
        c.t.m.g.dg.a(r1, r2);	 Catch:{ Throwable -> 0x00c3 }
        r1 = 0;
        r13.d = r1;	 Catch:{ Throwable -> 0x00c3 }
    L_0x03ff:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.u(r1);	 Catch:{ Throwable -> 0x00c3 }
        if (r1 == 0) goto L_0x0411;
    L_0x0407:
        if (r0 == 0) goto L_0x041a;
    L_0x0409:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg.s(r1);	 Catch:{ Throwable -> 0x00c3 }
        if (r1 <= 0) goto L_0x041a;
    L_0x0411:
        c.t.m.g.eb.a(r3, r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r1 = 0;
        c.t.m.g.dg.a(r0, r1, r3);	 Catch:{ Throwable -> 0x00c3 }
    L_0x041a:
        r0 = 0;
        r13.a(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.b(r0, r3);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.d(r0);	 Catch:{ Throwable -> 0x00c3 }
        r1 = c.t.m.g.dg$b.Normal;	 Catch:{ Throwable -> 0x00c3 }
        if (r0 != r1) goto L_0x0023;
    L_0x042d:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.v(r0);	 Catch:{ Throwable -> 0x00c3 }
        if (r0 != 0) goto L_0x0023;
    L_0x0435:
        r0 = c.t.m.g.cm.a();	 Catch:{ Throwable -> 0x00c3 }
        r0.b();	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.w(r0);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0443:
        r3 = "network";
        goto L_0x02c8;
    L_0x0448:
        r0 = move-exception;
        r0 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        r13.b(r0);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0450:
        r0 = move-exception;
        r0.toString();	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x035a;
    L_0x0456:
        r0 = r8;
        goto L_0x036e;
    L_0x0459:
        r1 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = 0;
        r4 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
        c.t.m.g.dg.a(r1, r3, r2, r4);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x03bd;
    L_0x0463:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.t(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r0.n;	 Catch:{ Throwable -> 0x00c3 }
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x0479;
    L_0x046f:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r0 = c.t.m.g.dg.t(r0);	 Catch:{ Throwable -> 0x00c3 }
        r2 = -1;
        r0.n = r2;	 Catch:{ Throwable -> 0x00c3 }
    L_0x0479:
        r0 = 1;
        r13.b(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        r2 = -1;
        c.t.m.g.dg.b(r0, r2);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0486:
        r0 = r13.e;	 Catch:{ Throwable -> 0x00c3 }
        c.t.m.g.dg.x(r0);	 Catch:{ Throwable -> 0x00c3 }
        r0 = 3999; // 0xf9f float:5.604E-42 double:1.976E-320;
        r13.sendEmptyMessage(r0);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x0023;
    L_0x0492:
        r1 = r8;
        goto L_0x02f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.dg$a.handleMessage(android.os.Message):void");
    }

    private void a(int i) {
        if (dg.y(this.e) != null) {
            if (dg.h(this.e) == 0) {
                dg.a(this.e, dg.g(this.e), dg.h(this.e), 3103);
            } else {
                dg.a(this.e, eb.a, i, 3103);
            }
            dg.z(this.e);
            if (dg.d(this.e) == dg$b.Single) {
                this.e.a();
            }
        }
    }

    private void b(int i) {
        Location a = dg.A(this.e).a();
        if (a != dd.a && dg.j(this.e) == 0 && System.currentTimeMillis() - a.getTime() <= 120000) {
            double d;
            double d2;
            Location location = new Location(a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                double d3 = extras.getDouble("lat");
                d = extras.getDouble("lng");
                d2 = d3;
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            eb$a eb_a = new eb$a();
            eb_a.d = "network";
            eb a2 = eb_a.a(a).a();
            if (dg.l(this.e) == 1) {
                location.setLatitude(d2);
                location.setLongitude(d);
                a2.a(location);
            }
            if (!dg.u(this.e)) {
                dg.a(this.e, 0, a2);
            }
            a(0);
        } else if (dg.h(this.e) != 0 || dg.g(this.e) == null || System.currentTimeMillis() - dg.g(this.e).getTime() >= 60000) {
            dg.a(this.e, i, eb.a);
            a(i);
        } else {
            a(0);
        }
    }

    private static void a(eb ebVar, String str) {
        String.format("%s,%.6f,%.6f,%.1f", new Object[]{str, Double.valueOf(ebVar.getLatitude()), Double.valueOf(ebVar.getLongitude()), Float.valueOf(ebVar.getAccuracy())});
    }
}
