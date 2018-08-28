package com.tencent.mm.q.a;

import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.fts.ui.a.b;

public final class c extends b {
    public a dir;
    public boolean dis;
    private a dit = new a(this);

    public c(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r12, com.tencent.mm.plugin.fts.a.d.a.a$a r13, java.lang.Object... r14) {
        /*
        r11 = this;
        r10 = 2;
        r7 = 0;
        r2 = 0;
        r1 = 1;
        r0 = r11.fyJ;
        r0 = r0.jrv;
        r11.username = r0;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r3 = r11.username;
        r0 = r0.Yg(r3);
        r11.guS = r0;
        r0 = com.tencent.mm.plugin.account.a.a.a.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.account.a.a.a) r0;
        r0 = r0.getAddrUploadStg();
        r0 = (com.tencent.mm.plugin.account.friend.a.b) r0;
        r3 = r11.fyJ;
        r4 = r3.jsA;
        r3 = new com.tencent.mm.plugin.account.friend.a.a;
        r3.<init>();
        r6 = new java.lang.StringBuilder;
        r8 = "select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=";
        r6.<init>(r8);
        r4 = java.lang.Long.toString(r4);
        r4 = r6.append(r4);
        r5 = 59;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r0.dCZ;
        r0 = r0.b(r4, r7, r10);
        r4 = r0.moveToFirst();
        if (r4 == 0) goto L_0x005e;
    L_0x005b:
        r3.d(r0);
    L_0x005e:
        r0.close();
        r11.dir = r3;
        r0 = r11.dir;
        r9 = r0.Xj();
        r0 = r11.fyJ;
        r0 = r0.jru;
        switch(r0) {
            case 5: goto L_0x010b;
            case 6: goto L_0x0109;
            case 7: goto L_0x00e5;
            case 8: goto L_0x0070;
            case 9: goto L_0x0070;
            case 10: goto L_0x0070;
            case 11: goto L_0x0070;
            case 12: goto L_0x0106;
            case 13: goto L_0x0104;
            case 14: goto L_0x00c1;
            case 15: goto L_0x0070;
            case 16: goto L_0x00d3;
            default: goto L_0x0070;
        };
    L_0x0070:
        r0 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r7;
        r8 = r7;
    L_0x0076:
        if (r5 == 0) goto L_0x00f7;
    L_0x0078:
        r5 = com.tencent.mm.plugin.account.ui.q.a.NormalTextSize;
        r5 = com.tencent.mm.bp.a.ad(r12, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r9, r5);
        r11.hqx = r5;
        r5 = r11.hqx;
        r7 = r11.jrx;
        r5 = com.tencent.mm.plugin.fts.a.a.d.a(r5, r7, r3, r0);
        r5 = com.tencent.mm.plugin.fts.a.f.a(r5);
        r5 = r5.jrO;
        r11.hqx = r5;
    L_0x0094:
        if (r4 == 0) goto L_0x00c0;
    L_0x0096:
        r4 = com.tencent.mm.plugin.account.ui.q.a.NormalTextSize;
        r4 = com.tencent.mm.bp.a.ad(r12, r4);
        r4 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r6, r4);
        r11.hqy = r4;
        r4 = r11.hqy;
        r5 = r11.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r4, r5, r3, r0);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.hqy = r0;
        r0 = new java.lang.CharSequence[r10];
        r0[r2] = r8;
        r2 = r11.hqy;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r11.hqy = r0;
    L_0x00c0:
        return;
    L_0x00c1:
        r0 = r1;
    L_0x00c2:
        r3 = r1;
    L_0x00c3:
        r4 = r11.dir;
        r6 = r4.Xp();
        r4 = com.tencent.mm.plugin.account.ui.q.e.search_contact_tag_mobile;
        r7 = r12.getString(r4);
        r4 = r2;
        r5 = r1;
        r8 = r7;
        goto L_0x0076;
    L_0x00d3:
        r0 = r11.dir;
        r6 = r0.Xp();
        r0 = com.tencent.mm.plugin.account.ui.q.e.search_contact_tag_mobile;
        r7 = r12.getString(r0);
        r0 = r2;
        r3 = r2;
        r4 = r1;
        r5 = r2;
        r8 = r7;
        goto L_0x0076;
    L_0x00e5:
        r0 = r1;
    L_0x00e6:
        r3 = r1;
    L_0x00e7:
        r4 = r11.dir;
        r6 = r4.Xm();
        r4 = com.tencent.mm.plugin.account.ui.q.e.search_contact_tag_wxnick;
        r7 = r12.getString(r4);
        r4 = r1;
        r5 = r2;
        r8 = r7;
        goto L_0x0076;
    L_0x00f7:
        r5 = com.tencent.mm.plugin.account.ui.q.a.NormalTextSize;
        r5 = com.tencent.mm.bp.a.ad(r12, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r9, r5);
        r11.hqx = r5;
        goto L_0x0094;
    L_0x0104:
        r0 = r2;
        goto L_0x00c2;
    L_0x0106:
        r0 = r2;
        r3 = r2;
        goto L_0x00c3;
    L_0x0109:
        r0 = r2;
        goto L_0x00e6;
    L_0x010b:
        r0 = r2;
        r3 = r2;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.q.a.c.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.dit;
    }
}
