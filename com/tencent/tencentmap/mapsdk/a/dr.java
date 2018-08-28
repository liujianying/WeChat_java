package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class dr {
    private Context a = null;

    public dr(Context context) {
        this.a = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r16, byte[] r17, boolean r18) {
        /*
        r15 = this;
        r1 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r0 = r16;
        if (r0 == r1) goto L_0x0017;
    L_0x0006:
        r1 = "com strategy unmatch key: %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r16);
        r2[r3] = r4;
        com.tencent.tencentmap.mapsdk.a.ct.c(r1, r2);
    L_0x0016:
        return;
    L_0x0017:
        if (r17 == 0) goto L_0x0016;
    L_0x0019:
        r0 = r17;
        r1 = r0.length;
        if (r1 <= 0) goto L_0x0016;
    L_0x001e:
        r1 = r15.a;
        r1 = com.tencent.tencentmap.mapsdk.a.cf.a(r1);
        r7 = r1.e();
        if (r7 != 0) goto L_0x0034;
    L_0x002a:
        r1 = "imposible! common strategy null!";
        r2 = 0;
        r2 = new java.lang.Object[r2];
        com.tencent.tencentmap.mapsdk.a.ct.c(r1, r2);
        goto L_0x0016;
    L_0x0034:
        r8 = new com.tencent.tencentmap.mapsdk.a.cr;	 Catch:{ Throwable -> 0x0081 }
        r8.<init>();	 Catch:{ Throwable -> 0x0081 }
        r1 = new com.tencent.tencentmap.mapsdk.a.cv;	 Catch:{ Throwable -> 0x0081 }
        r0 = r17;
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0081 }
        r8.a(r1);	 Catch:{ Throwable -> 0x0081 }
        if (r7 != 0) goto L_0x008f;
    L_0x0045:
        r1 = 0;
    L_0x0046:
        if (r1 == 0) goto L_0x0016;
    L_0x0048:
        if (r18 == 0) goto L_0x0069;
    L_0x004a:
        r1 = "update common strategy should save ";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.e(r1, r2);	 Catch:{ Throwable -> 0x0081 }
        r1 = r15.a;	 Catch:{ Throwable -> 0x0081 }
        if (r17 == 0) goto L_0x0069;
    L_0x0057:
        r2 = new com.tencent.tencentmap.mapsdk.a.cl;	 Catch:{ Throwable -> 0x0081 }
        r2.<init>();	 Catch:{ Throwable -> 0x0081 }
        r0 = r16;
        r2.a(r0);	 Catch:{ Throwable -> 0x0081 }
        r0 = r17;
        r2.a(r0);	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.e.a(r1, r2);	 Catch:{ Throwable -> 0x0081 }
    L_0x0069:
        r1 = "com strategy changed notify! ";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.e(r1, r2);	 Catch:{ Throwable -> 0x0081 }
        r1 = r15.a;	 Catch:{ Throwable -> 0x0081 }
        r1 = com.tencent.tencentmap.mapsdk.a.cf.a(r1);	 Catch:{ Throwable -> 0x0081 }
        r1.a(r7);	 Catch:{ Throwable -> 0x0081 }
        if (r18 == 0) goto L_0x0016;
    L_0x007d:
        r1.b();	 Catch:{ Throwable -> 0x0081 }
        goto L_0x0016;
    L_0x0081:
        r1 = move-exception;
        com.tencent.tencentmap.mapsdk.a.ct.a(r1);
        r1 = "error to common strategy!";
        r2 = 0;
        r2 = new java.lang.Object[r2];
        com.tencent.tencentmap.mapsdk.a.ct.d(r1, r2);
        goto L_0x0016;
    L_0x008f:
        r4 = 0;
        r1 = r8.c;	 Catch:{ Throwable -> 0x0081 }
        r2 = r7.b();	 Catch:{ Throwable -> 0x0081 }
        r1 = r1.equals(r2);	 Catch:{ Throwable -> 0x0081 }
        if (r1 != 0) goto L_0x00b0;
    L_0x009c:
        r1 = "strategy url changed to: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0081 }
        r3 = 0;
        r4 = r8.c;	 Catch:{ Throwable -> 0x0081 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r1, r2);	 Catch:{ Throwable -> 0x0081 }
        r4 = 1;
        r1 = r8.c;	 Catch:{ Throwable -> 0x0081 }
        r7.a(r1);	 Catch:{ Throwable -> 0x0081 }
    L_0x00b0:
        r1 = r8.b;	 Catch:{ Throwable -> 0x0081 }
        r2 = r7.c();	 Catch:{ Throwable -> 0x0081 }
        if (r1 == r2) goto L_0x00d0;
    L_0x00b8:
        r1 = "QueryPeriod changed to: %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0081 }
        r3 = 0;
        r4 = r8.b;	 Catch:{ Throwable -> 0x0081 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0081 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r1, r2);	 Catch:{ Throwable -> 0x0081 }
        r4 = 1;
        r1 = r8.b;	 Catch:{ Throwable -> 0x0081 }
        r7.a(r1);	 Catch:{ Throwable -> 0x0081 }
    L_0x00d0:
        r9 = r8.a;	 Catch:{ Throwable -> 0x0081 }
        if (r7 != 0) goto L_0x00e2;
    L_0x00d4:
        r1 = 0;
    L_0x00d5:
        if (r1 == 0) goto L_0x02dc;
    L_0x00d7:
        r2 = 1;
    L_0x00d8:
        r3 = r8.d;	 Catch:{ Throwable -> 0x0081 }
        if (r7 != 0) goto L_0x02b2;
    L_0x00dc:
        r1 = 0;
    L_0x00dd:
        if (r1 == 0) goto L_0x02d9;
    L_0x00df:
        r1 = 1;
        goto L_0x0046;
    L_0x00e2:
        r1 = 0;
        if (r9 == 0) goto L_0x027a;
    L_0x00e5:
        r10 = r7.e();	 Catch:{ Throwable -> 0x0081 }
        if (r10 == 0) goto L_0x00d5;
    L_0x00eb:
        r3 = 0;
        r6 = r3;
        r2 = r1;
    L_0x00ee:
        r1 = r10.size();	 Catch:{ Throwable -> 0x0081 }
        if (r6 >= r1) goto L_0x02df;
    L_0x00f4:
        r1 = r10.valueAt(r6);	 Catch:{ Throwable -> 0x0081 }
        r1 = (com.tencent.tencentmap.mapsdk.a.ch.a) r1;	 Catch:{ Throwable -> 0x0081 }
        r11 = r9.iterator();	 Catch:{ Throwable -> 0x0081 }
        r3 = r2;
    L_0x00ff:
        r2 = r11.hasNext();	 Catch:{ Throwable -> 0x0081 }
        if (r2 == 0) goto L_0x0274;
    L_0x0105:
        r2 = r11.next();	 Catch:{ Throwable -> 0x0081 }
        r2 = (com.tencent.tencentmap.mapsdk.a.cs) r2;	 Catch:{ Throwable -> 0x0081 }
        r5 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r12 = r1.e();	 Catch:{ Throwable -> 0x0081 }
        if (r5 != r12) goto L_0x0225;
    L_0x0113:
        r5 = "server module strategy mid: %d";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0081 }
        r13 = 0;
        r14 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r14 = java.lang.Byte.valueOf(r14);	 Catch:{ Throwable -> 0x0081 }
        r12[r13] = r14;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.a(r5, r12);	 Catch:{ Throwable -> 0x0081 }
        r5 = r2.b;	 Catch:{ Throwable -> 0x0081 }
        r12 = 1;
        if (r5 != r12) goto L_0x0229;
    L_0x012a:
        r5 = 1;
    L_0x012b:
        r12 = r1.a();	 Catch:{ Throwable -> 0x0081 }
        if (r12 == r5) goto L_0x014e;
    L_0x0131:
        r3 = "mid: %d , isUsable changed: %b ";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0081 }
        r13 = 0;
        r14 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r14 = java.lang.Byte.valueOf(r14);	 Catch:{ Throwable -> 0x0081 }
        r12[r13] = r14;	 Catch:{ Throwable -> 0x0081 }
        r13 = 1;
        r14 = java.lang.Boolean.valueOf(r5);	 Catch:{ Throwable -> 0x0081 }
        r12[r13] = r14;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r12);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r1.a(r5);	 Catch:{ Throwable -> 0x0081 }
    L_0x014e:
        r5 = r1.b();	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.c;	 Catch:{ Throwable -> 0x0081 }
        r5 = r5.equals(r12);	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x0177;
    L_0x015a:
        r3 = "mid: %d , url changed: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0081 }
        r12 = 0;
        r13 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = java.lang.Byte.valueOf(r13);	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        r12 = 1;
        r13 = r2.c;	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r5);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r5 = r2.c;	 Catch:{ Throwable -> 0x0081 }
        r1.a(r5);	 Catch:{ Throwable -> 0x0081 }
    L_0x0177:
        r5 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r12 = 1;
        if (r5 == r12) goto L_0x0181;
    L_0x017c:
        r5 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r12 = 2;
        if (r5 != r12) goto L_0x01bc;
    L_0x0181:
        r5 = r1.c();	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x022c;
    L_0x0187:
        r5 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x022c;
    L_0x018b:
        r5 = r1.c();	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        r5 = r5.equals(r12);	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x01bc;
    L_0x0197:
        r3 = "mid: %d , detail changed...";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0081 }
        r12 = 0;
        r13 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = java.lang.Byte.valueOf(r13);	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r5);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r5 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        r1.a(r5);	 Catch:{ Throwable -> 0x0081 }
        r5 = r15.a;	 Catch:{ Throwable -> 0x0081 }
        r5 = com.tencent.tencentmap.mapsdk.a.cf.a(r5);	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        r5.a(r12, r13);	 Catch:{ Throwable -> 0x0081 }
    L_0x01bc:
        r5 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r12 = 1;
        if (r5 != r12) goto L_0x0225;
    L_0x01c1:
        r5 = r1.d();	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x025d;
    L_0x01c7:
        r5 = r2.e;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x025d;
    L_0x01cb:
        r5 = r1.d();	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.e;	 Catch:{ Throwable -> 0x0081 }
        r5 = r5.equals(r12);	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x01f3;
    L_0x01d7:
        r3 = "mid: %d , PreventEventCode changed...";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0081 }
        r12 = 0;
        r13 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = java.lang.Byte.valueOf(r13);	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r5);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r5 = r2.e;	 Catch:{ Throwable -> 0x0081 }
        r5 = com.tencent.tencentmap.mapsdk.a.e.a(r5);	 Catch:{ Throwable -> 0x0081 }
        r1.a(r5);	 Catch:{ Throwable -> 0x0081 }
    L_0x01f3:
        r5 = r1.f();	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x0269;
    L_0x01f9:
        r5 = r2.f;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x0269;
    L_0x01fd:
        r5 = r1.f();	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.f;	 Catch:{ Throwable -> 0x0081 }
        r5 = r5.equals(r12);	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x0225;
    L_0x0209:
        r3 = "mid: %d , SampleEventSet changed...";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0081 }
        r12 = 0;
        r13 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = java.lang.Byte.valueOf(r13);	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r5);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r2 = r2.f;	 Catch:{ Throwable -> 0x0081 }
        r2 = com.tencent.tencentmap.mapsdk.a.e.a(r2);	 Catch:{ Throwable -> 0x0081 }
        r1.b(r2);	 Catch:{ Throwable -> 0x0081 }
    L_0x0225:
        r2 = r3;
        r3 = r2;
        goto L_0x00ff;
    L_0x0229:
        r5 = 0;
        goto L_0x012b;
    L_0x022c:
        r5 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x01bc;
    L_0x0230:
        r5 = r1.c();	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x01bc;
    L_0x0236:
        r3 = "mid: %d , detail changed...";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0081 }
        r12 = 0;
        r13 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = java.lang.Byte.valueOf(r13);	 Catch:{ Throwable -> 0x0081 }
        r5[r12] = r13;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r3, r5);	 Catch:{ Throwable -> 0x0081 }
        r3 = 1;
        r5 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        r1.a(r5);	 Catch:{ Throwable -> 0x0081 }
        r5 = r15.a;	 Catch:{ Throwable -> 0x0081 }
        r5 = com.tencent.tencentmap.mapsdk.a.cf.a(r5);	 Catch:{ Throwable -> 0x0081 }
        r12 = r2.a;	 Catch:{ Throwable -> 0x0081 }
        r13 = r2.d;	 Catch:{ Throwable -> 0x0081 }
        r5.a(r12, r13);	 Catch:{ Throwable -> 0x0081 }
        goto L_0x01bc;
    L_0x025d:
        r5 = r1.d();	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x01d7;
    L_0x0263:
        r5 = r2.e;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x01f3;
    L_0x0267:
        goto L_0x01d7;
    L_0x0269:
        r5 = r1.f();	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x0209;
    L_0x026f:
        r5 = r2.f;	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x00ff;
    L_0x0273:
        goto L_0x0209;
    L_0x0274:
        r1 = r6 + 1;
        r6 = r1;
        r2 = r3;
        goto L_0x00ee;
    L_0x027a:
        r5 = r7.e();	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x00d5;
    L_0x0280:
        r6 = r5.size();	 Catch:{ Throwable -> 0x0081 }
        r3 = 0;
        r2 = r1;
    L_0x0286:
        if (r3 >= r6) goto L_0x02df;
    L_0x0288:
        r1 = r5.valueAt(r3);	 Catch:{ Throwable -> 0x0081 }
        r1 = (com.tencent.tencentmap.mapsdk.a.ch.a) r1;	 Catch:{ Throwable -> 0x0081 }
        r9 = r1.a();	 Catch:{ Throwable -> 0x0081 }
        if (r9 == 0) goto L_0x02ad;
    L_0x0294:
        r2 = "mid: %d , server not response strategy, sdk local close it!";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x0081 }
        r10 = 0;
        r11 = r1.e();	 Catch:{ Throwable -> 0x0081 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Throwable -> 0x0081 }
        r9[r10] = r11;	 Catch:{ Throwable -> 0x0081 }
        com.tencent.tencentmap.mapsdk.a.ct.b(r2, r9);	 Catch:{ Throwable -> 0x0081 }
        r2 = 1;
        r9 = 0;
        r1.a(r9);	 Catch:{ Throwable -> 0x0081 }
    L_0x02ad:
        r1 = r2;
        r3 = r3 + 1;
        r2 = r1;
        goto L_0x0286;
    L_0x02b2:
        r1 = 0;
        if (r3 == 0) goto L_0x02cb;
    L_0x02b5:
        r4 = r7.d();	 Catch:{ Throwable -> 0x0081 }
        if (r4 == 0) goto L_0x02cb;
    L_0x02bb:
        r4 = r7.d();	 Catch:{ Throwable -> 0x0081 }
        r4 = r3.equals(r4);	 Catch:{ Throwable -> 0x0081 }
        if (r4 != 0) goto L_0x00dd;
    L_0x02c5:
        r7.a(r3);	 Catch:{ Throwable -> 0x0081 }
        r1 = 1;
        goto L_0x00dd;
    L_0x02cb:
        if (r3 == 0) goto L_0x00dd;
    L_0x02cd:
        r4 = r7.d();	 Catch:{ Throwable -> 0x0081 }
        if (r4 != 0) goto L_0x00dd;
    L_0x02d3:
        r7.a(r3);	 Catch:{ Throwable -> 0x0081 }
        r1 = 1;
        goto L_0x00dd;
    L_0x02d9:
        r1 = r2;
        goto L_0x0046;
    L_0x02dc:
        r2 = r4;
        goto L_0x00d8;
    L_0x02df:
        r1 = r2;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.dr.a(int, byte[], boolean):void");
    }
}
