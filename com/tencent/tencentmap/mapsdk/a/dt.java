package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public final class dt implements ds {
    private static dt a = null;
    private SparseArray<dr> b = new SparseArray(5);
    private List<dm> c = new ArrayList(5);
    private dq d;
    private Context e = null;
    private boolean f = true;
    private boolean g = true;

    public static synchronized dt a(Context context) {
        dt dtVar;
        synchronized (dt.class) {
            if (a == null) {
                a = new dt(context, true);
                ct.h(" create uphandler up:true", new Object[0]);
            }
            dtVar = a;
        }
        return dtVar;
    }

    public static synchronized dt a(Context context, boolean z) {
        dt dtVar;
        synchronized (dt.class) {
            if (a == null) {
                a = new dt(context, z);
                ct.h(" create uphandler up: %b", Boolean.valueOf(z));
            }
            if (a.f != z) {
                a.f = z;
                ct.h(" change uphandler up: %b", Boolean.valueOf(z));
            }
            dtVar = a;
        }
        return dtVar;
    }

    private dt(Context context, boolean z) {
        Context context2 = null;
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 != null) {
            this.e = context2;
        } else {
            this.e = context;
        }
        this.f = z;
        this.d = dq.a(this.e);
    }

    public final synchronized boolean a(dr drVar) {
        boolean z;
        if (drVar == null) {
            z = false;
        } else {
            this.b.append(101, drVar);
            z = true;
        }
        return z;
    }

    public final synchronized boolean a(dm dmVar) {
        boolean z;
        if (dmVar == null) {
            z = false;
        } else {
            if (!this.c.contains(dmVar)) {
                this.c.add(dmVar);
            }
            z = true;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.tencentmap.mapsdk.a.dn r12) {
        /*
        r11 = this;
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r2 = -1;
        r9 = 2;
        r4 = 1;
        r3 = 0;
        r0 = r11.f;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r11.b();
        if (r0 != 0) goto L_0x0040;
    L_0x0010:
        r0 = r12.c();
        if (r0 != r9) goto L_0x0021;
    L_0x0016:
        r0 = "  Not UpProc real event sync 2 DB done false";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r1);
        r12.b(r3);
    L_0x0021:
        r0 = r12.b;
        if (r0 == 0) goto L_0x0038;
    L_0x0025:
        r0 = "  Not UpProc not req: %d";
        r1 = new java.lang.Object[r4];
        r2 = r12.c();
        r2 = java.lang.Integer.valueOf(r2);
        r1[r3] = r2;
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r1);
    L_0x0037:
        return;
    L_0x0038:
        r0 = "  NotUpProc com req start ";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r1);
    L_0x0040:
        r0 = r11.e;
        r0 = com.tencent.tencentmap.mapsdk.a.e.m(r0);
        if (r0 != 0) goto L_0x005a;
    L_0x0048:
        r0 = " doUpload network is disabled!";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r1);
        r0 = r12.c();
        if (r0 != r9) goto L_0x0037;
    L_0x0056:
        r12.b(r3);
        goto L_0x0037;
    L_0x005a:
        if (r12 != 0) goto L_0x0065;
    L_0x005c:
        r0 = " upData == null ";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.d(r0, r1);
        goto L_0x0037;
    L_0x0065:
        r5 = r12.c();
        r1 = r12.e();
        if (r1 == 0) goto L_0x007c;
    L_0x006f:
        r0 = "";
        r6 = r1.trim();
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0094;
    L_0x007c:
        r0 = " url error";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.d(r0, r1);
        r0 = r12.c();
        if (r0 != r9) goto L_0x008d;
    L_0x008a:
        r12.b(r3);
    L_0x008d:
        r0 = "url error";
        r11.a(r5, r2, r3, r0);
        goto L_0x0037;
    L_0x0094:
        r6 = b(r12);
        r7 = r12.d();
        r0 = 0;
        if (r7 == 0) goto L_0x00af;
    L_0x009f:
        r0 = new java.lang.StringBuilder;
        r8 = "?rid=";
        r0.<init>(r8);
        r0 = r0.append(r7);
        r0 = r0.toString();
    L_0x00af:
        r7 = com.tencent.tencentmap.mapsdk.a.ch.a();
        if (r7 == 0) goto L_0x00d6;
    L_0x00b5:
        r7 = r7.l();
        if (r7 == 0) goto L_0x00d6;
    L_0x00bb:
        r8 = "";
        r8 = r8.equals(r7);
        if (r8 != 0) goto L_0x00d6;
    L_0x00c4:
        if (r0 != 0) goto L_0x0116;
    L_0x00c6:
        r0 = new java.lang.StringBuilder;
        r8 = "?sid=";
        r0.<init>(r8);
        r0 = r0.append(r7);
        r0 = r0.toString();
    L_0x00d6:
        if (r0 == 0) goto L_0x02dd;
    L_0x00d8:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r1 = r7.append(r1);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x00e9:
        r1 = " start upload cmd: %d  url:%s  datas:%s";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r8 = java.lang.Integer.valueOf(r5);
        r7[r3] = r8;
        r7[r4] = r0;
        r8 = r12.getClass();
        r8 = r8.toString();
        r7[r9] = r8;
        com.tencent.tencentmap.mapsdk.a.ct.h(r1, r7);
        if (r6 != 0) goto L_0x012f;
    L_0x0106:
        r0 = " sendData is null";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r1);
        r0 = "sendData error";
        r11.a(r5, r2, r3, r0);
        goto L_0x0037;
    L_0x0116:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r8.append(r0);
        r8 = "&sid=";
        r0 = r0.append(r8);
        r0 = r0.append(r7);
        r0 = r0.toString();
        goto L_0x00d6;
    L_0x012f:
        r7 = r11.d();
        if (r7 != 0) goto L_0x0145;
    L_0x0135:
        r0 = " reqH error";
        r1 = new java.lang.Object[r3];
        com.tencent.tencentmap.mapsdk.a.ct.d(r0, r1);
        r0 = "reqHandler error";
        r11.a(r5, r2, r3, r0);
        goto L_0x0037;
    L_0x0145:
        r1 = r11.e;
        com.tencent.tencentmap.mapsdk.a.e.f(r1);
        r1 = com.tencent.tencentmap.mapsdk.a.c.m();
        r1.h();
        r1 = new java.util.Date;
        r1.<init>();
        r1.getTime();
        r1 = r7.a(r0, r6, r12);	 Catch:{ Throwable -> 0x02cf }
        if (r1 != 0) goto L_0x02da;
    L_0x015f:
        r8 = 100;
        if (r5 != r8) goto L_0x02da;
    L_0x0163:
        r8 = "http://strategy.beacon.qq.com/analytics/upload?mType=beacon";
        r0 = r8.equals(r0);	 Catch:{ Throwable -> 0x02cf }
        if (r0 != 0) goto L_0x02da;
    L_0x016c:
        r0 = "http://strategy.beacon.qq.com/analytics/upload?mType=beacon";
        r0 = r7.a(r0, r6, r12);	 Catch:{ Throwable -> 0x02cf }
    L_0x0173:
        r0 = a(r0);	 Catch:{ Throwable -> 0x02cf }
        if (r0 == 0) goto L_0x02d7;
    L_0x0179:
        r1 = r0.b;	 Catch:{ Throwable -> 0x02cf }
        r2 = r0.a;	 Catch:{ Throwable -> 0x020f }
        if (r2 != 0) goto L_0x01a9;
    L_0x017f:
        r2 = r4;
    L_0x0180:
        r3 = "response.cmd:%d response.result:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r6 = 0;
        r7 = r0.b;	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r4[r6] = r7;	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r6 = 1;
        r7 = r0.a;	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r7 = java.lang.Byte.valueOf(r7);	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r4[r6] = r7;	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r4);	 Catch:{ Throwable -> 0x02d3, all -> 0x02cb }
        r3 = r2;
    L_0x019c:
        if (r12 == 0) goto L_0x01a0;
    L_0x019e:
        if (r0 != 0) goto L_0x01ab;
    L_0x01a0:
        r0 = 0;
        r11.a(r5, r1, r3, r0);	 Catch:{ Throwable -> 0x020f }
        r12.b(r3);
        goto L_0x0037;
    L_0x01a9:
        r2 = r3;
        goto L_0x0180;
    L_0x01ab:
        r2 = com.tencent.tencentmap.mapsdk.a.c.m();	 Catch:{ Throwable -> 0x020f }
        if (r2 == 0) goto L_0x01e8;
    L_0x01b1:
        r4 = r0.d;	 Catch:{ Throwable -> 0x020f }
        if (r4 == 0) goto L_0x01be;
    L_0x01b5:
        r4 = r0.d;	 Catch:{ Throwable -> 0x020f }
        r4 = r4.trim();	 Catch:{ Throwable -> 0x020f }
        r2.b(r4);	 Catch:{ Throwable -> 0x020f }
    L_0x01be:
        r4 = new java.util.Date;	 Catch:{ Throwable -> 0x020f }
        r4.<init>();	 Catch:{ Throwable -> 0x020f }
        r6 = r0.e;	 Catch:{ Throwable -> 0x020f }
        r8 = r4.getTime();	 Catch:{ Throwable -> 0x020f }
        r6 = r6 - r8;
        r2.a(r6);	 Catch:{ Throwable -> 0x020f }
        r4 = " fix ip:%s  tmgap: %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x020f }
        r7 = 0;
        r8 = r2.g();	 Catch:{ Throwable -> 0x020f }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x020f }
        r7 = 1;
        r8 = r2.h();	 Catch:{ Throwable -> 0x020f }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x020f }
        r6[r7] = r2;	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.h(r4, r6);	 Catch:{ Throwable -> 0x020f }
    L_0x01e8:
        r2 = r0.b;	 Catch:{ Throwable -> 0x020f }
        if (r2 == r10) goto L_0x01f8;
    L_0x01ec:
        r2 = r0.b;	 Catch:{ Throwable -> 0x020f }
        r4 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r2 == r4) goto L_0x01f8;
    L_0x01f2:
        r2 = r0.b;	 Catch:{ Throwable -> 0x020f }
        r4 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r2 != r4) goto L_0x0201;
    L_0x01f8:
        r2 = r11.e;	 Catch:{ Throwable -> 0x020f }
        r2 = com.tencent.tencentmap.mapsdk.a.cf.a(r2);	 Catch:{ Throwable -> 0x020f }
        r2.e();	 Catch:{ Throwable -> 0x020f }
    L_0x0201:
        r2 = r0.c;	 Catch:{ Throwable -> 0x020f }
        if (r2 != 0) goto L_0x022d;
    L_0x0205:
        r0 = " no response! ";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r2);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x020f:
        r0 = move-exception;
    L_0x0210:
        r2 = 0;
        r4 = r0.toString();	 Catch:{ all -> 0x0244 }
        r11.a(r5, r1, r2, r4);	 Catch:{ all -> 0x0244 }
        r1 = " req error  %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0244 }
        r4 = 0;
        r0 = r0.toString();	 Catch:{ all -> 0x0244 }
        r2[r4] = r0;	 Catch:{ all -> 0x0244 }
        com.tencent.tencentmap.mapsdk.a.ct.d(r1, r2);	 Catch:{ all -> 0x0244 }
        r12.b(r3);
        goto L_0x0037;
    L_0x022d:
        r4 = r11.e();	 Catch:{ Throwable -> 0x020f }
        if (r4 == 0) goto L_0x0239;
    L_0x0233:
        r6 = r4.size();	 Catch:{ Throwable -> 0x020f }
        if (r6 > 0) goto L_0x0249;
    L_0x0239:
        r0 = " no handler! ";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r2);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x0244:
        r0 = move-exception;
    L_0x0245:
        r12.b(r3);
        throw r0;
    L_0x0249:
        r6 = r12.c();	 Catch:{ Throwable -> 0x020f }
        r0 = r0.b;	 Catch:{ Throwable -> 0x020f }
        if (r0 != 0) goto L_0x025c;
    L_0x0251:
        r0 = " response no datas ";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.h(r0, r2);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x025c:
        switch(r6) {
            case 4: goto L_0x028c;
            case 100: goto L_0x0271;
            case 102: goto L_0x02a9;
            default: goto L_0x025f;
        };	 Catch:{ Throwable -> 0x020f }
    L_0x025f:
        r0 = " unknown req: %d ";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x020f }
        r4 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x020f }
        r2[r4] = r6;	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r2);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x0271:
        if (r0 == r10) goto L_0x02c6;
    L_0x0273:
        r2 = " UNMATCH req: %d , rep: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x020f }
        r7 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x020f }
        r4[r7] = r6;	 Catch:{ Throwable -> 0x020f }
        r6 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x020f }
        r4[r6] = r0;	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.c(r2, r4);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x028c:
        r7 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r0 == r7) goto L_0x02c6;
    L_0x0290:
        r2 = " UNMATCH req: %d , rep: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x020f }
        r7 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x020f }
        r4[r7] = r6;	 Catch:{ Throwable -> 0x020f }
        r6 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x020f }
        r4[r6] = r0;	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.c(r2, r4);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x02a9:
        r7 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r0 == r7) goto L_0x02c6;
    L_0x02ad:
        r2 = " UNMATCH req: %d  , rep: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x020f }
        r7 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x020f }
        r4[r7] = r6;	 Catch:{ Throwable -> 0x020f }
        r6 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x020f }
        r4[r6] = r0;	 Catch:{ Throwable -> 0x020f }
        com.tencent.tencentmap.mapsdk.a.ct.c(r2, r4);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x02c6:
        a(r4, r0, r2);	 Catch:{ Throwable -> 0x020f }
        goto L_0x01a0;
    L_0x02cb:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0245;
    L_0x02cf:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0210;
    L_0x02d3:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0210;
    L_0x02d7:
        r1 = r2;
        goto L_0x019c;
    L_0x02da:
        r0 = r1;
        goto L_0x0173;
    L_0x02dd:
        r0 = r1;
        goto L_0x00e9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.dt.a(com.tencent.tencentmap.mapsdk.a.dn):void");
    }

    private static byte[] b(dn dnVar) {
        if (dnVar != null) {
            try {
                cn a = dnVar.a();
                if (a != null) {
                    ct.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", a.b, a.d, a.c, Integer.valueOf(a.f));
                    cy cyVar = new cy();
                    cyVar.a();
                    cyVar.b("test");
                    cyVar.a("test");
                    cyVar.a("detail", a);
                    byte[] b = cyVar.b();
                    ch a2 = ch.a();
                    if (a2 != null) {
                        return e.a(b, a2.i(), a2.h(), a2.k());
                    }
                }
            } catch (Throwable th) {
                ct.d(" parseSendDatas error", new Object[0]);
                ct.a(th);
                dnVar.b();
            }
        }
        return null;
    }

    private static co a(byte[] bArr) {
        if (bArr != null) {
            try {
                byte[] b;
                ch a = ch.a();
                if (a != null) {
                    b = e.b(bArr, a.i(), a.h(), a.k());
                } else {
                    b = null;
                }
                if (b != null) {
                    cy cyVar = new cy();
                    cyVar.a(b);
                    co coVar = new co();
                    ct.b(" covert to ResponsePackage ", new Object[0]);
                    return (co) cyVar.b("detail", coVar);
                }
            } catch (Throwable th) {
                ct.a(th);
            }
        }
        return null;
    }

    private void a(int i, int i2, boolean z, String str) {
        dm[] c = c();
        if (c != null) {
            for (dm a : c) {
                a.a(i, i2, 0, 0, z, str);
            }
        }
    }

    private synchronized dm[] c() {
        dm[] dmVarArr;
        if (this.c == null || this.c.size() <= 0) {
            dmVarArr = null;
        } else {
            dmVarArr = (dm[]) this.c.toArray(new dm[0]);
        }
        return dmVarArr;
    }

    private synchronized dq d() {
        return this.d;
    }

    private synchronized SparseArray<dr> e() {
        SparseArray<dr> sparseArray;
        if (this.b == null || this.b.size() <= 0) {
            sparseArray = null;
        } else {
            cu cuVar = new cu();
            sparseArray = cu.a(this.b);
        }
        return sparseArray;
    }

    private static boolean a(SparseArray<dr> sparseArray, int i, byte[] bArr) {
        if (sparseArray == null || bArr == null) {
            return true;
        }
        switch (i) {
            case 103:
                return true;
            default:
                dr drVar = (dr) sparseArray.get(i);
                if (drVar == null) {
                    ct.c(" no handler key:%d", Integer.valueOf(i));
                    return false;
                }
                try {
                    ct.b(" key:%d  handler: %s", Integer.valueOf(i), drVar.getClass().toString());
                    drVar.a(i, bArr, true);
                    return true;
                } catch (Throwable th) {
                    ct.a(th);
                    ct.d(" handle error key:%d", Integer.valueOf(i));
                    return false;
                }
        }
    }

    public final boolean a() {
        return this.f;
    }

    public final synchronized boolean b() {
        boolean z;
        if (e.l(this.e)) {
            z = true;
        } else {
            z = this.g;
        }
        return z;
    }
}
