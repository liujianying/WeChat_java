package com.tencent.mm.plugin.emoji.model;

class d$1 implements Runnable {
    final /* synthetic */ String igj;
    final /* synthetic */ d ihl;

    d$1(d dVar, String str) {
        this.ihl = dVar;
        this.igj = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r0 = 1;
        r1 = 0;
        r2 = com.tencent.mm.plugin.emoji.model.i.aEA();
        r2 = r2.igz;
        r3 = r12.igj;
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x0070;
    L_0x0010:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.mm.storage.emotion.EmojiGroupInfo.tcy;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r4 = r3.equals(r4);
        if (r4 != 0) goto L_0x0070;
    L_0x0025:
        r4 = r2.tcX;
        r5 = new java.lang.StringBuilder;
        r6 = "274544";
        r5.<init>(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r6 = 0;
        r4 = r4.getLong(r5, r6);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r6 - r4;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 < 0) goto L_0x0061;
    L_0x004a:
        if (r0 == 0) goto L_0x0060;
    L_0x004c:
        com.tencent.mm.plugin.emoji.model.i.aEw();
        r0 = r12.igj;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 == 0) goto L_0x0072;
    L_0x0057:
        r0 = "MicroMsg.emoji.EmojiMgrImpl";
        r1 = "doSceneGetEmotionDesc get emotion desc faild.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x0060:
        return;
    L_0x0061:
        r2 = r2.Zx(r3);
        if (r2 != 0) goto L_0x0070;
    L_0x0067:
        r2 = r6 - r4;
        r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x004a;
    L_0x0070:
        r0 = r1;
        goto L_0x004a;
    L_0x0072:
        r2 = new com.tencent.mm.plugin.emoji.f.k;
        r2.<init>(r0);
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r2, r1);
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.d$1.run():void");
    }
}
