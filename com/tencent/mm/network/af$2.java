package com.tencent.mm.network;

class af$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ af etP;
    final /* synthetic */ int etQ;
    final /* synthetic */ Object etR;

    af$2(af afVar, int i, Object obj, int i2, int i3) {
        this.etP = afVar;
        this.etQ = i;
        this.etR = obj;
        this.bFq = i2;
        this.bFr = i3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r25 = this;
        r15 = com.tencent.mm.network.aa.Va();
        r0 = r25;
        r0 = r0.etQ;
        r16 = r0;
        r0 = r25;
        r2 = r0.bFq;
        r0 = r25;
        r5 = r0.bFr;
        r4 = -1;
        r14 = 0;
        r0 = r15.etg;
        r17 = r0;
        monitor-enter(r17);
        r18 = r15.iN(r16);	 Catch:{ all -> 0x02ca }
        r3 = -1;
        r0 = r18;
        if (r3 != r0) goto L_0x0045;
    L_0x0022:
        r3 = "MicroMsg.MMNativeNetTaskAdapter";
        r4 = "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x02ca }
        r7 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02ca }
        r6[r7] = r2;	 Catch:{ all -> 0x02ca }
        r2 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02ca }
        r6[r2] = r5;	 Catch:{ all -> 0x02ca }
        r2 = 2;
        r5 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02ca }
        r6[r2] = r5;	 Catch:{ all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r6);	 Catch:{ all -> 0x02ca }
        monitor-exit(r17);	 Catch:{ all -> 0x02ca }
    L_0x0044:
        return;
    L_0x0045:
        r7 = 0;
        switch(r2) {
            case 0: goto L_0x01da;
            case 1: goto L_0x01dd;
            case 2: goto L_0x01e0;
            case 3: goto L_0x01e3;
            case 4: goto L_0x01e6;
            case 5: goto L_0x01e9;
            case 6: goto L_0x01ec;
            case 7: goto L_0x01ef;
            case 8: goto L_0x0204;
            case 9: goto L_0x0207;
            default: goto L_0x0049;
        };	 Catch:{ all -> 0x02ca }
    L_0x0049:
        r3 = "MicroMsg.MMNativeNetTaskAdapter";
        r6 = "c2JavaErrorType not exits c_errType:%d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x02ca }
        r9 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02ca }
        r8[r9] = r2;	 Catch:{ all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.x.f(r3, r6, r8);	 Catch:{ all -> 0x02ca }
    L_0x005c:
        if (r7 != 0) goto L_0x005f;
    L_0x005e:
        r5 = 0;
    L_0x005f:
        r2 = 3;
        if (r7 != r2) goto L_0x0063;
    L_0x0062:
        r5 = -1;
    L_0x0063:
        r2 = com.tencent.mm.network.aa.UV();	 Catch:{ all -> 0x02ca }
        r2 = r2.ety;	 Catch:{ all -> 0x02ca }
        if (r2 != 0) goto L_0x0079;
    L_0x006b:
        r2 = 1;
        if (r7 != r2) goto L_0x0079;
    L_0x006e:
        r2 = "MicroMsg.MMNativeNetTaskAdapter";
        r3 = "network not available";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x02ca }
        r7 = 2;
        r5 = -1;
    L_0x0079:
        r2 = r15.etg;	 Catch:{ all -> 0x02ca }
        r2 = r2[r18];	 Catch:{ all -> 0x02ca }
        r0 = r2.etk;	 Catch:{ all -> 0x02ca }
        r19 = r0;
        r2 = r15.etg;	 Catch:{ all -> 0x02ca }
        r2 = r2[r18];	 Catch:{ all -> 0x02ca }
        r2 = r2.etl;	 Catch:{ all -> 0x02ca }
        r3 = r15.etg;	 Catch:{ all -> 0x02ca }
        r3 = r3[r18];	 Catch:{ all -> 0x02ca }
        r0 = r3.startTime;	 Catch:{ all -> 0x02ca }
        r20 = r0;
        r3 = r15.etg;	 Catch:{ all -> 0x02ca }
        r6 = 0;
        r3[r18] = r6;	 Catch:{ all -> 0x02ca }
        if (r7 != 0) goto L_0x0592;
    L_0x0096:
        r3 = r19.LD();	 Catch:{ RemoteException -> 0x0585 }
        r3 = r3.LH();	 Catch:{ RemoteException -> 0x0585 }
        if (r3 == 0) goto L_0x0592;
    L_0x00a0:
        r7 = 4;
        r3 = r19.LD();	 Catch:{ RemoteException -> 0x0585 }
        r5 = r3.LH();	 Catch:{ RemoteException -> 0x0585 }
        r12 = r5;
        r13 = r7;
    L_0x00ab:
        r11 = r19.getType();	 Catch:{ RemoteException -> 0x0589 }
        r22 = com.tencent.mm.network.aa.UZ();	 Catch:{ RemoteException -> 0x022f }
        r3 = r19.LD();	 Catch:{ RemoteException -> 0x022f }
        r23 = r3.Lm();	 Catch:{ RemoteException -> 0x022f }
        r3 = "MicroMsg.AutoAuth";
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0219 }
        r5 = "summerauth onGYNetEnd threadId: 0 errType: ";
        r4.<init>(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " errCode: ";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " errMsg: ";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = 0;
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " rr: ";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r0 = r19;
        r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " type: ";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " netIdGetCertBeforeAutoAuth: ";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r0 = r22;
        r5 = r0.esp;	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.toString();	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.d(r3, r4);	 Catch:{ RemoteException -> 0x0219 }
        if (r12 == 0) goto L_0x020a;
    L_0x0115:
        r0 = r22;
        r3 = r0.esg;	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3 + 1;
        r0 = r22;
        r0.esg = r3;	 Catch:{ RemoteException -> 0x0219 }
    L_0x011f:
        r24 = r19.LD();	 Catch:{ RemoteException -> 0x0219 }
        r3 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        switch(r3) {
            case 126: goto L_0x0251;
            case 381: goto L_0x0513;
            case 701: goto L_0x0251;
            case 702: goto L_0x0251;
            default: goto L_0x012a;
        };
    L_0x012a:
        r3 = r19.Lb();	 Catch:{ RemoteException -> 0x022f }
        r6 = r11;
        r5 = r12;
        r4 = r13;
    L_0x0131:
        monitor-exit(r17);	 Catch:{ all -> 0x02ca }
        r7 = "MicroMsg.MMNativeNetTaskAdapter";
        r8 = "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]";
        r9 = 6;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r6);
        r9[r10] = r11;
        r10 = 1;
        r12 = com.tencent.mm.sdk.platformtools.bi.bH(r20);
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 2;
        r11 = java.lang.Integer.valueOf(r16);
        r9[r10] = r11;
        r10 = 3;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r10] = r3;
        r3 = 4;
        r10 = java.lang.Integer.valueOf(r4);
        r9[r3] = r10;
        r3 = 5;
        r10 = java.lang.Integer.valueOf(r5);
        r9[r3] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r7, r8, r9);
        r3 = 4;
        if (r3 != r4) goto L_0x0189;
    L_0x016f:
        r3 = -1;
        if (r3 == r5) goto L_0x017d;
    L_0x0172:
        r3 = -2;
        if (r3 == r5) goto L_0x017d;
    L_0x0175:
        r3 = -24;
        if (r3 == r5) goto L_0x017d;
    L_0x0179:
        r3 = -34;
        if (r3 != r5) goto L_0x0189;
    L_0x017d:
        r3 = com.tencent.mm.network.aa.UX();
        r7 = new com.tencent.mm.network.z$1;
        r7.<init>(r15, r6, r5);
        r3.post(r7);
    L_0x0189:
        r3 = r19.LD();	 Catch:{ Exception -> 0x01aa }
        r6 = r3.LG();	 Catch:{ Exception -> 0x01aa }
        if (r6 == 0) goto L_0x0573;
    L_0x0193:
        r3 = r6.length();	 Catch:{ Exception -> 0x01aa }
        if (r3 <= 0) goto L_0x0573;
    L_0x0199:
        r3 = r19.LD();	 Catch:{ Exception -> 0x01aa }
        r8 = r3.Lm();	 Catch:{ Exception -> 0x01aa }
        r3 = r18;
        r7 = r19;
        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01aa }
        goto L_0x0044;
    L_0x01aa:
        r2 = move-exception;
        r3 = "MicroMsg.MMNativeNetTaskAdapter";
        r4 = "onGYNetEnd cb %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r2.getMessage();
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        r3 = "MicroMsg.MMNativeNetTaskAdapter";
        r4 = "exception:%s taskid:%d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.i(r2);
        r5[r6] = r2;
        r2 = 1;
        r6 = java.lang.Integer.valueOf(r16);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        goto L_0x0044;
    L_0x01da:
        r7 = 0;
        goto L_0x005c;
    L_0x01dd:
        r7 = 2;
        goto L_0x005c;
    L_0x01e0:
        r7 = 2;
        goto L_0x005c;
    L_0x01e3:
        r7 = 1;
        goto L_0x005c;
    L_0x01e6:
        r7 = 1;
        goto L_0x005c;
    L_0x01e9:
        r7 = 1;
        goto L_0x005c;
    L_0x01ec:
        r7 = 1;
        goto L_0x005c;
    L_0x01ef:
        r2 = -3002; // 0xfffffffffffff446 float:NaN double:NaN;
        if (r2 == r5) goto L_0x01f7;
    L_0x01f3:
        r2 = -3003; // 0xfffffffffffff445 float:NaN double:NaN;
        if (r2 != r5) goto L_0x01fa;
    L_0x01f7:
        r7 = 4;
        goto L_0x005c;
    L_0x01fa:
        r2 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
        if (r2 != r5) goto L_0x0201;
    L_0x01fe:
        r7 = 6;
        goto L_0x005c;
    L_0x0201:
        r7 = 5;
        goto L_0x005c;
    L_0x0204:
        r7 = 4;
        goto L_0x005c;
    L_0x0207:
        r7 = 1;
        goto L_0x005c;
    L_0x020a:
        r3 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r4 = 10;
        if (r3 == r4) goto L_0x011f;
    L_0x0212:
        r3 = 0;
        r0 = r22;
        r0.esg = r3;	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x011f;
    L_0x0219:
        r3 = move-exception;
        r4 = "MicroMsg.AutoAuth";
        r5 = "exception:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x022f }
        r7 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);	 Catch:{ RemoteException -> 0x022f }
        r6[r7] = r3;	 Catch:{ RemoteException -> 0x022f }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ RemoteException -> 0x022f }
        goto L_0x012a;
    L_0x022f:
        r3 = move-exception;
        r6 = r11;
        r5 = r12;
        r7 = r13;
    L_0x0233:
        r4 = "MicroMsg.MMNativeNetTaskAdapter";
        r8 = "exception:%s taskid:%d";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02ca }
        r10 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);	 Catch:{ all -> 0x02ca }
        r9[r10] = r3;	 Catch:{ all -> 0x02ca }
        r3 = 1;
        r10 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02ca }
        r9[r3] = r10;	 Catch:{ all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.x.e(r4, r8, r9);	 Catch:{ all -> 0x02ca }
        r3 = r14;
        r4 = r7;
        goto L_0x0131;
    L_0x0251:
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth end type: %d, ret:[%d,%d][%s]";
        r5 = 4;
        r5 = new java.lang.Object[r5];	 Catch:{ RemoteException -> 0x0219 }
        r6 = 0;
        r7 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ RemoteException -> 0x0219 }
        r5[r6] = r7;	 Catch:{ RemoteException -> 0x0219 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r13);	 Catch:{ RemoteException -> 0x0219 }
        r5[r6] = r7;	 Catch:{ RemoteException -> 0x0219 }
        r6 = 2;
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ RemoteException -> 0x0219 }
        r5[r6] = r7;	 Catch:{ RemoteException -> 0x0219 }
        r6 = 3;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ RemoteException -> 0x0219 }
        r3 = r24.LH();	 Catch:{ RemoteException -> 0x0219 }
        if (r3 != 0) goto L_0x0284;
    L_0x0280:
        if (r13 != 0) goto L_0x0284;
    L_0x0282:
        if (r12 == 0) goto L_0x0323;
    L_0x0284:
        r3 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r3 != r4) goto L_0x02cd;
    L_0x028c:
        r3 = "MicroMsg.AutoAuth";
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0219 }
        r5 = "net.end: reg err: type=";
        r4.<init>(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " err=";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x0219 }
        r5 = ",";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x0219 }
        r5 = " errmsg=";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r5 = 0;
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.toString();	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x02ca:
        r2 = move-exception;
        monitor-exit(r17);	 Catch:{ all -> 0x02ca }
        throw r2;
    L_0x02cd:
        switch(r12) {
            case -213: goto L_0x02d2;
            case -205: goto L_0x02d2;
            case -100: goto L_0x02d2;
            default: goto L_0x02d0;
        };
    L_0x02d0:
        goto L_0x012a;
    L_0x02d2:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ RemoteException -> 0x0219 }
        r4 = "auth_hold_prefs";
        r5 = 0;
        r3 = r3.getSharedPreferences(r4, r5);	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3.edit();	 Catch:{ RemoteException -> 0x0219 }
        r4 = "auth_ishold";
        r5 = 1;
        r3 = r3.putBoolean(r4, r5);	 Catch:{ RemoteException -> 0x0219 }
        r3.commit();	 Catch:{ RemoteException -> 0x0219 }
        r3 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        if (r12 != r3) goto L_0x02ff;
    L_0x02f1:
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r6 = 31;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x02ff:
        r3 = -100;
        if (r12 != r3) goto L_0x0311;
    L_0x0303:
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r6 = 32;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x0311:
        r3 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r12 != r3) goto L_0x012a;
    L_0x0315:
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r6 = 33;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x0323:
        r3 = r19.LE();	 Catch:{ RemoteException -> 0x0219 }
        r4 = "MicroMsg.AutoAuth";
        r5 = "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x0219 }
        r7 = 0;
        r8 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x0219 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x0219 }
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ RemoteException -> 0x0219 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x0219 }
        r7 = 2;
        r0 = r22;
        r8 = r0.efP;	 Catch:{ RemoteException -> 0x0219 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x0219 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ RemoteException -> 0x0219 }
        r4 = 2;
        if (r3 != r4) goto L_0x040f;
    L_0x0353:
        r3 = r19.getType();	 Catch:{ RemoteException -> 0x0219 }
        r4 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
        if (r3 != r4) goto L_0x012a;
    L_0x035b:
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r6 = 34;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x0219 }
        r0 = r22;
        r3 = r0.efP;	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3 + 1;
        r0 = r22;
        r0.efP = r3;	 Catch:{ RemoteException -> 0x0219 }
        r0 = r22;
        r3 = r0.efP;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 1;
        if (r3 <= r4) goto L_0x03a0;
    L_0x0378:
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth loginDecodeFailedTry beyond 1 no more try!";
        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x0219 }
        r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0219 }
        r4 = "auth_decode_failed_";
        r3.<init>(r4);	 Catch:{ RemoteException -> 0x0219 }
        r4 = 0;
        r5 = "";
        r4 = com.tencent.mm.sdk.platformtools.bi.aG(r4, r5);	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3.append(r4);	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3.toString();	 Catch:{ RemoteException -> 0x0219 }
        r0 = r22;
        r0.c(r13, r12, r3);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x03a0:
        r5 = r24.Df();	 Catch:{ RemoteException -> 0x03d8 }
        r3 = r24.LI();	 Catch:{ RemoteException -> 0x03d8 }
        r4 = com.tencent.mm.sdk.platformtools.bi.bC(r3);	 Catch:{ RemoteException -> 0x03d8 }
        if (r4 == 0) goto L_0x03fa;
    L_0x03ae:
        r3 = "";
        r4 = r3;
    L_0x03b2:
        r3 = com.tencent.mm.sdk.platformtools.bi.bC(r23);	 Catch:{ RemoteException -> 0x03d8 }
        if (r3 == 0) goto L_0x0400;
    L_0x03b8:
        r3 = "";
    L_0x03bb:
        r0 = r22;
        r3 = r0.f(r4, r3, r5);	 Catch:{ RemoteException -> 0x03d8 }
        if (r3 == 0) goto L_0x0405;
    L_0x03c3:
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x03d8 }
        r0 = r23;
        r3.ccH = r0;	 Catch:{ RemoteException -> 0x03d8 }
    L_0x03cb:
        r0 = r22;
        r3 = r0.esm;	 Catch:{ RemoteException -> 0x03d8 }
        r4 = 0;
        r5 = 0;
        r0 = r19;
        r0.a(r3, r4, r5);	 Catch:{ RemoteException -> 0x03d8 }
        goto L_0x012a;
    L_0x03d8:
        r3 = move-exception;
        r4 = "MicroMsg.AutoAuth";
        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0219 }
        r6 = "summerauth save serverid aak failed 1 cookie:";
        r5.<init>(r6);	 Catch:{ RemoteException -> 0x0219 }
        r6 = com.tencent.mm.sdk.platformtools.bi.bE(r23);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r5.toString();	 Catch:{ RemoteException -> 0x0219 }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.chR();	 Catch:{ RemoteException -> 0x0219 }
        throw r3;	 Catch:{ RemoteException -> 0x0219 }
    L_0x03fa:
        r3 = com.tencent.mm.sdk.platformtools.bi.bE(r3);	 Catch:{ RemoteException -> 0x03d8 }
        r4 = r3;
        goto L_0x03b2;
    L_0x0400:
        r3 = com.tencent.mm.sdk.platformtools.bi.bE(r23);	 Catch:{ RemoteException -> 0x03d8 }
        goto L_0x03bb;
    L_0x0405:
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth save serverid aak failed 1";
        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x03d8 }
        goto L_0x03cb;
    L_0x040f:
        r3 = 0;
        r0 = r22;
        r0.efP = r3;	 Catch:{ RemoteException -> 0x0219 }
        r5 = r19.LC();	 Catch:{ RemoteException -> 0x0219 }
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d";
        r6 = 6;
        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 0;
        r8 = r19.getType();	 Catch:{ RemoteException -> 0x04f1 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 1;
        r8 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 2;
        r8 = r24.LM();	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 3;
        r8 = r24.LI();	 Catch:{ RemoteException -> 0x04f1 }
        r8 = com.tencent.mm.sdk.platformtools.bi.bB(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r8 = com.tencent.mm.sdk.platformtools.bi.Xf(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 4;
        r8 = r24.DE();	 Catch:{ RemoteException -> 0x04f1 }
        r8 = com.tencent.mm.sdk.platformtools.bi.bB(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r8 = com.tencent.mm.sdk.platformtools.bi.Xf(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        r7 = 5;
        r8 = r24.Df();	 Catch:{ RemoteException -> 0x04f1 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f1 }
        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f1 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r6);	 Catch:{ RemoteException -> 0x04f1 }
        r6 = r24.Df();	 Catch:{ RemoteException -> 0x04f1 }
        r3 = r24.LI();	 Catch:{ RemoteException -> 0x04f1 }
        r4 = com.tencent.mm.sdk.platformtools.bi.bC(r3);	 Catch:{ RemoteException -> 0x04f1 }
        if (r4 == 0) goto L_0x04d0;
    L_0x0474:
        r3 = "";
        r4 = r3;
    L_0x0478:
        r3 = com.tencent.mm.sdk.platformtools.bi.bC(r23);	 Catch:{ RemoteException -> 0x04f1 }
        if (r3 == 0) goto L_0x04d6;
    L_0x047e:
        r3 = "";
    L_0x0481:
        r0 = r22;
        r3 = r0.f(r4, r3, r6);	 Catch:{ RemoteException -> 0x04f1 }
        if (r3 == 0) goto L_0x04db;
    L_0x0489:
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x04f1 }
        r0 = r23;
        r3.ccH = r0;	 Catch:{ RemoteException -> 0x04f1 }
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x04f1 }
        r4 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f1 }
        r3.username = r4;	 Catch:{ RemoteException -> 0x04f1 }
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x04f1 }
        r4 = r24.LM();	 Catch:{ RemoteException -> 0x04f1 }
        r3.erW = r4;	 Catch:{ RemoteException -> 0x04f1 }
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x04f1 }
        r4 = r24.DE();	 Catch:{ RemoteException -> 0x04f1 }
        r5 = r24.Df();	 Catch:{ RemoteException -> 0x04f1 }
        r3.x(r4, r5);	 Catch:{ RemoteException -> 0x04f1 }
        r0 = r22;
        r3 = r0.esl;	 Catch:{ RemoteException -> 0x04f1 }
        r4 = r24.Lo();	 Catch:{ RemoteException -> 0x04f1 }
        r3.erV = r4;	 Catch:{ RemoteException -> 0x04f1 }
        r3 = r24.Df();	 Catch:{ RemoteException -> 0x04f1 }
        com.tencent.mm.a.o.getString(r3);	 Catch:{ RemoteException -> 0x04f1 }
    L_0x04c5:
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth decode and save ok!";
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x04d0:
        r3 = com.tencent.mm.sdk.platformtools.bi.bE(r3);	 Catch:{ RemoteException -> 0x04f1 }
        r4 = r3;
        goto L_0x0478;
    L_0x04d6:
        r3 = com.tencent.mm.sdk.platformtools.bi.bE(r23);	 Catch:{ RemoteException -> 0x04f1 }
        goto L_0x0481;
    L_0x04db:
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ RemoteException -> 0x04f1 }
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r6 = 35;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x04f1 }
        r3 = "MicroMsg.AutoAuth";
        r4 = "summerauth save serverid aak failed 2";
        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x04f1 }
        goto L_0x04c5;
    L_0x04f1:
        r3 = move-exception;
        r4 = "MicroMsg.AutoAuth";
        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0219 }
        r6 = "summerauth save serverid aak failed 2 cookie:";
        r5.<init>(r6);	 Catch:{ RemoteException -> 0x0219 }
        r6 = com.tencent.mm.sdk.platformtools.bi.bE(r23);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x0219 }
        r5 = r5.toString();	 Catch:{ RemoteException -> 0x0219 }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.sdk.platformtools.x.chR();	 Catch:{ RemoteException -> 0x0219 }
        throw r3;	 Catch:{ RemoteException -> 0x0219 }
    L_0x0513:
        if (r13 != 0) goto L_0x053a;
    L_0x0515:
        if (r12 != 0) goto L_0x053a;
    L_0x0517:
        r3 = r19.LD();	 Catch:{ RemoteException -> 0x0219 }
        r3 = r3.LJ();	 Catch:{ RemoteException -> 0x0219 }
        r4 = r19.LD();	 Catch:{ RemoteException -> 0x0219 }
        r4 = r4.LK();	 Catch:{ RemoteException -> 0x0219 }
        r5 = r19.LD();	 Catch:{ RemoteException -> 0x0219 }
        r5 = r5.LL();	 Catch:{ RemoteException -> 0x0219 }
        com.tencent.mm.protocal.y.J(r3, r4, r5);	 Catch:{ RemoteException -> 0x0219 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ RemoteException -> 0x0219 }
        r0 = r22;
        r0.eso = r4;	 Catch:{ RemoteException -> 0x0219 }
    L_0x053a:
        r3 = com.tencent.mm.platformtools.af.exm;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 10003; // 0x2713 float:1.4017E-41 double:4.942E-320;
        if (r3 != r4) goto L_0x058f;
    L_0x0540:
        r3 = com.tencent.mm.platformtools.af.exn;	 Catch:{ RemoteException -> 0x0219 }
        if (r3 <= 0) goto L_0x058f;
    L_0x0544:
        r3 = com.tencent.mm.platformtools.af.exn;	 Catch:{ RemoteException -> 0x0219 }
        r4 = 1;
        if (r3 > r4) goto L_0x054c;
    L_0x0549:
        r3 = 0;
        com.tencent.mm.platformtools.af.exn = r3;	 Catch:{ RemoteException -> 0x0219 }
    L_0x054c:
        r4 = 4;
        r3 = 0;
        r5 = "";
        r6 = "";
        r7 = 0;
        com.tencent.mm.protocal.y.J(r5, r6, r7);	 Catch:{ RemoteException -> 0x0219 }
    L_0x0558:
        r0 = r22;
        r5 = r0.esp;	 Catch:{ RemoteException -> 0x0219 }
        r6 = -1;
        if (r5 == r6) goto L_0x012a;
    L_0x055f:
        if (r4 != 0) goto L_0x056c;
    L_0x0561:
        if (r3 != 0) goto L_0x056c;
    L_0x0563:
        r3 = 0;
        r4 = 0;
        r0 = r22;
        r1 = r19;
        r0.a(r1, r3, r4);	 Catch:{ RemoteException -> 0x0219 }
    L_0x056c:
        r3 = -1;
        r0 = r22;
        r0.esp = r3;	 Catch:{ RemoteException -> 0x0219 }
        goto L_0x012a;
    L_0x0573:
        r6 = 0;
        r3 = r19.LD();	 Catch:{ Exception -> 0x01aa }
        r8 = r3.Lm();	 Catch:{ Exception -> 0x01aa }
        r3 = r18;
        r7 = r19;
        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01aa }
        goto L_0x0044;
    L_0x0585:
        r3 = move-exception;
        r6 = r4;
        goto L_0x0233;
    L_0x0589:
        r3 = move-exception;
        r6 = r4;
        r5 = r12;
        r7 = r13;
        goto L_0x0233;
    L_0x058f:
        r3 = r12;
        r4 = r13;
        goto L_0x0558;
    L_0x0592:
        r12 = r5;
        r13 = r7;
        goto L_0x00ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.af$2.run():void");
    }
}
