package com.tencent.tencentmap.mapsdk.a;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class ft implements fs {
    private int a = 1;
    private int b = 1;
    private int c = 20000;
    private int d = 3;
    private ArrayList e = null;
    private int f = 0;
    private boolean g = false;
    private ArrayList h = null;
    private int i = 0;
    private boolean j = false;
    private String k = "dispatcher.3g.qq.com";
    private Socket l;
    private int m;
    private String n;
    private int o;
    private int p;
    private int q;
    private ep r;

    public ft() {
        int[] iArr = dy.a;
        this.l = null;
        this.m = 0;
        this.o = 0;
        this.p = -1;
        this.q = -1;
    }

    private static ArrayList a(ArrayList arrayList, int i, int i2, boolean z) {
        if (arrayList == null || arrayList.size() <= 0 || i >= arrayList.size()) {
            return arrayList;
        }
        int min = Math.min(i2, arrayList.size() - i);
        if (min <= 0) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(min);
        List subList = arrayList.subList(i, i + min);
        for (int i3 = 0; i3 < min; i3++) {
            ep epVar = (ep) subList.get(i3);
            arrayList2.add(new ep(epVar.a(), epVar.b()));
        }
        return arrayList2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = r8.e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r8.e;
        r0 = r0.size();
        if (r0 > 0) goto L_0x007f;
    L_0x000e:
        r0 = r2;
    L_0x000f:
        r8.g = r0;
        r0 = r8.h;
        if (r0 != 0) goto L_0x0081;
    L_0x0015:
        r0 = r2;
    L_0x0016:
        r8.j = r0;
        r0 = "SocketConnectorImpl";
        r3 = "doConnect...";
        com.tencent.tencentmap.mapsdk.a.fx.a(r0, r3);
    L_0x0021:
        r0 = r8.g;
        if (r0 == 0) goto L_0x0029;
    L_0x0025:
        r0 = r8.j;
        if (r0 != 0) goto L_0x007e;
    L_0x0029:
        r0 = r8.o;
        r3 = r8.d;
        if (r0 > r3) goto L_0x007e;
    L_0x002f:
        r0 = r8.o;
        r0 = r0 + 1;
        r8.o = r0;
        r0 = com.tencent.tencentmap.mapsdk.a.fw.f();
        if (r0 == 0) goto L_0x0083;
    L_0x003b:
        r0 = r8.k;
        r3 = r8.c;
        r0 = com.tencent.tencentmap.mapsdk.a.fr.a(r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0045:
        r3 = r0.c();
        r8.l = r3;
        r0 = r0.d();
        r8.n = r0;
    L_0x0051:
        r0 = r8.l;
        if (r0 == 0) goto L_0x0179;
    L_0x0055:
        r0 = r8.l;
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0179;
    L_0x005d:
        r0 = r8.l;
        r0 = r0.isClosed();
        if (r0 != 0) goto L_0x0179;
    L_0x0065:
        r0 = new com.tencent.tencentmap.mapsdk.a.ep;
        r2 = r8.l;
        r2 = r2.getInetAddress();
        r2 = r2.getHostAddress();
        r3 = r8.l;
        r3 = r3.getPort();
        r0.<init>(r2, r3);
        r8.r = r0;
        r8.m = r1;
    L_0x007e:
        return;
    L_0x007f:
        r0 = r1;
        goto L_0x000f;
    L_0x0081:
        r0 = r1;
        goto L_0x0016;
    L_0x0083:
        r0 = r8.g;
        if (r0 != 0) goto L_0x00eb;
    L_0x0087:
        r4 = java.lang.System.currentTimeMillis();
        r0 = r8.e;
        r3 = r8.f;
        r6 = r8.a;
        r0 = a(r0, r3, r6, r2);
        if (r0 == 0) goto L_0x00b0;
    L_0x0097:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x00b0;
    L_0x009d:
        r3 = r8.f;
        r6 = r0.size();
        r3 = r3 + r6;
        r8.f = r3;
        r3 = r8.f;
        r6 = r8.e;
        r6 = r6.size();
        if (r3 < r6) goto L_0x00b2;
    L_0x00b0:
        r8.g = r2;
    L_0x00b2:
        r3 = r8.c;
        r0 = com.tencent.tencentmap.mapsdk.a.fr.a(r0, r3);
        if (r0 == 0) goto L_0x00c6;
    L_0x00ba:
        r3 = r0.c();
        r8.l = r3;
        r0 = r0.d();
        r8.n = r0;
    L_0x00c6:
        r8.p = r1;
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r0 = (int) r4;
        r8.q = r0;
        r0 = "SocketConnectorImpl";
        r3 = new java.lang.StringBuilder;
        r4 = "use IpList, dnsTime: 0 ,connectTime：";
        r3.<init>(r4);
        r4 = r8.q;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.tencentmap.mapsdk.a.fx.a(r0, r3);
        goto L_0x0051;
    L_0x00eb:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r3 = r8.j;
        if (r3 != 0) goto L_0x0131;
    L_0x00f4:
        r3 = r8.h;
        if (r3 == 0) goto L_0x012f;
    L_0x00f8:
        r3 = r8.h;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x012f;
    L_0x0100:
        r3 = r8.i;
        r4 = r8.h;
        r4 = r4.size();
        if (r3 >= r4) goto L_0x012f;
    L_0x010a:
        r0 = r8.h;
        r3 = r8.i;
        r4 = r8.b;
        r0 = a(r0, r3, r4, r2);
        if (r0 == 0) goto L_0x0176;
    L_0x0116:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0176;
    L_0x011c:
        r3 = r8.i;
        r4 = r0.size();
        r3 = r3 + r4;
        r8.i = r3;
        r3 = r8.i;
        r4 = r8.h;
        r4 = r4.size();
        if (r3 < r4) goto L_0x0131;
    L_0x012f:
        r8.j = r2;
    L_0x0131:
        r3 = r8.k;
        r4 = r8.c;
        r0 = com.tencent.tencentmap.mapsdk.a.fr.a(r0, r3, r4);
        if (r0 == 0) goto L_0x0147;
    L_0x013b:
        r3 = r0.c();
        r8.l = r3;
        r0 = r0.d();
        r8.n = r0;
    L_0x0147:
        r0 = com.tencent.tencentmap.mapsdk.a.fr.a;
        r8.p = r0;
        r0 = com.tencent.tencentmap.mapsdk.a.fr.b;
        r8.q = r0;
        r0 = "SocketConnectorImpl";
        r3 = new java.lang.StringBuilder;
        r4 = "use IpList DNS parallel , dnsTime:";
        r3.<init>(r4);
        r4 = r8.p;
        r3 = r3.append(r4);
        r4 = ",connectTime：";
        r3 = r3.append(r4);
        r4 = r8.q;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.tencentmap.mapsdk.a.fx.a(r0, r3);
        goto L_0x0051;
    L_0x0176:
        r8.j = r2;
        goto L_0x0131;
    L_0x0179:
        r0 = com.tencent.tencentmap.mapsdk.a.fw.e();
        if (r0 == 0) goto L_0x018c;
    L_0x017f:
        r0 = -3;
        r8.m = r0;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x019c }
    L_0x0187:
        r0 = 0;
        r8.l = r0;
        goto L_0x0021;
    L_0x018c:
        r0 = -4;
        r8.m = r0;
        r0 = "netWork  Fail when Connect";
        r8.n = r0;
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x019a }
        goto L_0x0187;
    L_0x019a:
        r0 = move-exception;
        goto L_0x0187;
    L_0x019c:
        r0 = move-exception;
        goto L_0x0187;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ft.a():void");
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.k = str;
    }

    public final void a(ArrayList arrayList) {
        this.e = arrayList;
    }

    public final void a(ArrayList arrayList, boolean z) {
        this.h = arrayList;
    }

    public final void a(int[] iArr) {
        iArr.clone();
    }

    public final int b() {
        return this.m;
    }

    public final void b(int i) {
        if (i > 0 && i < 4) {
            this.a = i;
            this.b = i;
        }
    }

    public final Socket c() {
        return this.l;
    }

    public final String d() {
        return this.n;
    }

    public final int e() {
        return this.p;
    }

    public final int f() {
        return this.q;
    }

    public final ep g() {
        return this.r;
    }
}
