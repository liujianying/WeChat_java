package com.tencent.mm.plugin.ext;

class b$2 implements Runnable {
    final /* synthetic */ b iJo;

    b$2(b bVar) {
        this.iJo = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r13 = this;
        r7 = 0;
        r12 = 1;
        r0 = com.tencent.mm.k.g.AT();	 Catch:{ Exception -> 0x00e5 }
        r1 = "VoiceRecognizeSprSoMD5";
        r1 = r0.getValue(r1);	 Catch:{ Exception -> 0x00e5 }
        r0 = com.tencent.mm.k.g.AT();	 Catch:{ Exception -> 0x00e5 }
        r2 = "VoiceRecognizeSprDataMD5";
        r2 = r0.getValue(r2);	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x001c;
    L_0x001a:
        if (r2 != 0) goto L_0x0034;
    L_0x001c:
        r0 = "MicroMsg.SubCoreExt";
        r3 = "error mMd5So:%s,  mMd5Data:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00e5 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ Exception -> 0x00e5 }
        r1 = 1;
        r4[r1] = r2;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);	 Catch:{ Exception -> 0x00e5 }
        r0 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.e(r0);	 Catch:{ Exception -> 0x00e5 }
    L_0x0033:
        return;
    L_0x0034:
        r0 = "/system/lib/";
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x00e5 }
        r4 = 24;
        if (r3 < r4) goto L_0x0040;
    L_0x003d:
        r0 = "/vendor/lib/";
    L_0x0040:
        r3 = "MicroMsg.SubCoreExt";
        r4 = "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
        r6 = 0;
        r5[r6] = r1;	 Catch:{ Exception -> 0x00e5 }
        r6 = 1;
        r5[r6] = r2;	 Catch:{ Exception -> 0x00e5 }
        r6 = 2;
        r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r3 = com.qq.wx.voice.embed.recognizer.b.a.bgm;	 Catch:{ Exception -> 0x00e5 }
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00e5 }
        r3 = r3.bgl;	 Catch:{ Exception -> 0x00e5 }
        r8 = r3.d;	 Catch:{ Exception -> 0x00e5 }
        if (r8 == 0) goto L_0x00f9;
    L_0x0065:
        r0 = r7;
    L_0x0066:
        r8 = com.tencent.mm.sdk.platformtools.ad.chZ();	 Catch:{ Exception -> 0x00e5 }
        r1 = "MicroMsg.SubCoreExt";
        r2 = "checkFiles ret:%s,use time:%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
        r6 = 0;
        r9 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
        r3[r6] = r9;	 Catch:{ Exception -> 0x00e5 }
        r6 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        if (r0 != 0) goto L_0x01d5;
    L_0x008c:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r3 = new java.util.LinkedList;	 Catch:{ Exception -> 0x00e5 }
        r3.<init>();	 Catch:{ Exception -> 0x00e5 }
        r0 = "tmessage";
        r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
        r0 = "officialaccounts";
        r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
        r0 = "helper_entry";
        r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.model.au.HU();	 Catch:{ Exception -> 0x00e5 }
        r0 = com.tencent.mm.model.c.FZ();	 Catch:{ Exception -> 0x00e5 }
        r1 = "@t.qq.com";
        r0 = r0.Hg(r1);	 Catch:{ Exception -> 0x00e5 }
        if (r0 == 0) goto L_0x00bc;
    L_0x00b7:
        r0 = r0.name;	 Catch:{ Exception -> 0x00e5 }
        r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
    L_0x00bc:
        r9 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e5 }
        r9.<init>();	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.model.au.HU();	 Catch:{ Exception -> 0x00e5 }
        r0 = com.tencent.mm.model.c.FR();	 Catch:{ Exception -> 0x00e5 }
        r1 = "@all.contact.android";
        r2 = 0;
        r4 = 0;
        r5 = 1;
        r6 = 1;
        r0 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00e5 }
        if (r0 != 0) goto L_0x0107;
    L_0x00d5:
        r0 = "MicroMsg.SubCoreExt";
        r1 = "initLocalVoiceControl cu is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x00e5 }
        r0 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.e(r0);	 Catch:{ Exception -> 0x00e5 }
        goto L_0x0033;
    L_0x00e5:
        r0 = move-exception;
        r1 = "MicroMsg.SubCoreExt";
        r2 = "initLocalVoiceControl Exception:%s";
        r3 = new java.lang.Object[r12];
        r0 = r0.getMessage();
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x0033;
    L_0x00f9:
        r8 = r3.bgs;	 Catch:{ Exception -> 0x00e5 }
        r0 = r8.checkFiles(r6, r0, r1, r2);	 Catch:{ Exception -> 0x00e5 }
        if (r0 < 0) goto L_0x0066;
    L_0x0101:
        r0 = 1;
        r3.d = r0;	 Catch:{ Exception -> 0x00e5 }
        r0 = r7;
        goto L_0x0066;
    L_0x0107:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x012d;
    L_0x010d:
        r1 = r0.isAfterLast();	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x012d;
    L_0x0113:
        r1 = new com.tencent.mm.storage.f;	 Catch:{ Exception -> 0x00e5 }
        r1.<init>();	 Catch:{ Exception -> 0x00e5 }
        r1.d(r0);	 Catch:{ Exception -> 0x00e5 }
        r2 = new com.qq.wx.voice.embed.recognizer.d;	 Catch:{ Exception -> 0x00e5 }
        r3 = r1.field_username;	 Catch:{ Exception -> 0x00e5 }
        r4 = r1.field_nickname;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.field_conRemark;	 Catch:{ Exception -> 0x00e5 }
        r2.<init>(r3, r4, r1);	 Catch:{ Exception -> 0x00e5 }
        r9.add(r2);	 Catch:{ Exception -> 0x00e5 }
        r0.moveToNext();	 Catch:{ Exception -> 0x00e5 }
        goto L_0x010d;
    L_0x012d:
        r0.close();	 Catch:{ Exception -> 0x00e5 }
        r1 = "MicroMsg.SubCoreExt";
        r2 = "init cusor,count:%s,use time:%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
        r4 = 0;
        r0 = r0.getCount();	 Catch:{ Exception -> 0x00e5 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
        r3[r4] = r0;	 Catch:{ Exception -> 0x00e5 }
        r0 = 1;
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r4 = r4 - r10;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
        r3[r0] = r4;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r0 = com.qq.wx.voice.embed.recognizer.b.a.bgm;	 Catch:{ Exception -> 0x00e5 }
        r1 = r0.bgl;	 Catch:{ Exception -> 0x00e5 }
        r0 = r1.d;	 Catch:{ Exception -> 0x00e5 }
        if (r0 != 0) goto L_0x01ab;
    L_0x015f:
        r0 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
    L_0x0161:
        if (r0 != 0) goto L_0x01c5;
    L_0x0163:
        r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
        r4 = "hasInitVoiceControlData";
        r5 = 1;
        r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r4 = "hasTryToInitVoiceControlData";
        r5 = 1;
        r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r1.commit();	 Catch:{ Exception -> 0x00e5 }
        r1 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.f(r1);	 Catch:{ Exception -> 0x00e5 }
    L_0x017f:
        r1 = "MicroMsg.SubCoreExt";
        r4 = "init ret:%s,use time:%s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
        r6 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
        r0 = 1;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
        r2 = r8 - r2;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00e5 }
        r5[r0] = r2;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r0 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.e(r0);	 Catch:{ Exception -> 0x00e5 }
    L_0x01a4:
        r0 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.e(r0);	 Catch:{ Exception -> 0x00e5 }
        goto L_0x0033;
    L_0x01ab:
        r0 = r1.e;	 Catch:{ Exception -> 0x00e5 }
        if (r0 == 0) goto L_0x01b9;
    L_0x01af:
        r0 = r1.bgs;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.update(r9);	 Catch:{ Exception -> 0x00e5 }
        if (r0 < 0) goto L_0x0161;
    L_0x01b7:
        r0 = r7;
        goto L_0x0161;
    L_0x01b9:
        r0 = r1.bgs;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.init(r9);	 Catch:{ Exception -> 0x00e5 }
        if (r0 < 0) goto L_0x0161;
    L_0x01c1:
        r0 = 1;
        r1.e = r0;	 Catch:{ Exception -> 0x00e5 }
        goto L_0x01b7;
    L_0x01c5:
        r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
        r4 = "hasInitVoiceControlData";
        r5 = 0;
        r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r1.commit();	 Catch:{ Exception -> 0x00e5 }
        goto L_0x017f;
    L_0x01d5:
        r0 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
        r1 = "hasInitVoiceControlData";
        r2 = 0;
        r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
        r1 = "hasTryToInitVoiceControlData";
        r2 = 1;
        r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
        r0.commit();	 Catch:{ Exception -> 0x00e5 }
        r0 = r13.iJo;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.plugin.ext.b.f(r0);	 Catch:{ Exception -> 0x00e5 }
        goto L_0x01a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b$2.run():void");
    }
}
