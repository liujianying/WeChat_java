package com.tencent.mm.plugin.fts.ui.a;

import android.util.Pair;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

public final class r extends b {
    private a jyW = new a(this);

    public r(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.a.d.a.a.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
        r5 = 0;
        r7 = 0;
        r6 = 1;
        r0 = r12.fyJ;
        r0 = r0.jrv;
        r12.username = r0;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r1 = r12.username;
        r0 = r0.Yg(r1);
        r12.guS = r0;
        r0 = r12.username;
        r11 = com.tencent.mm.plugin.fts.a.d.Bc(r0);
        r0 = r12.fyJ;
        r0 = r0.jru;
        switch(r0) {
            case 1: goto L_0x0201;
            case 2: goto L_0x01fe;
            case 3: goto L_0x00a8;
            case 4: goto L_0x00c4;
            case 5: goto L_0x0208;
            case 6: goto L_0x0205;
            case 7: goto L_0x00b1;
            case 11: goto L_0x014b;
            case 15: goto L_0x00d6;
            case 16: goto L_0x00f4;
            case 17: goto L_0x0139;
            case 18: goto L_0x0127;
            case 51: goto L_0x01bb;
            default: goto L_0x002a;
        };
    L_0x002a:
        r3 = r7;
        r2 = r7;
        r8 = r7;
        r4 = r7;
        r9 = r5;
        r10 = r5;
    L_0x0030:
        if (r4 == 0) goto L_0x01e5;
    L_0x0032:
        r0 = com.tencent.mm.plugin.fts.ui.n.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r11, r0);
        r12.hqx = r0;
        r0 = r12.hqx;
        r1 = r12.jrx;
        r4 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r4 = (float) r4;
        r5 = com.tencent.mm.plugin.fts.ui.b$c.jvx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r12.hqx = r0;
    L_0x0054:
        if (r8 == 0) goto L_0x0087;
    L_0x0056:
        r0 = com.tencent.mm.plugin.fts.ui.n.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r9, r0);
        r12.hqy = r0;
        r0 = r12.hqy;
        r1 = r12.jrx;
        r4 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r4 = (float) r4;
        r5 = com.tencent.mm.plugin.fts.ui.b$c.jvz;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r12.hqy = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r7] = r10;
        r1 = r12.hqy;
        r0[r6] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r12.hqy = r0;
    L_0x0087:
        r0 = r12.guS;
        r0 = r0.field_username;
        r0 = com.tencent.mm.storage.ab.XR(r0);
        if (r0 == 0) goto L_0x01f4;
    L_0x0091:
        r0 = com.tencent.mm.openim.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.openim.a.b) r0;
        r1 = r12.guS;
        r1 = r1.field_openImAppid;
        r2 = r12.guS;
        r2 = r2.field_descWordingId;
        r0 = r0.aE(r1, r2);
        r12.jxA = r0;
    L_0x00a7:
        return;
    L_0x00a8:
        r0 = r6;
    L_0x00a9:
        r1 = r6;
    L_0x00aa:
        r3 = r0;
        r2 = r1;
        r8 = r7;
        r4 = r6;
        r9 = r5;
        r10 = r5;
        goto L_0x0030;
    L_0x00b1:
        r0 = r6;
    L_0x00b2:
        r1 = r6;
    L_0x00b3:
        r2 = r12.guS;
        r5 = r2.field_nickname;
        r2 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_nickname;
        r10 = r13.getString(r2);
        r3 = r0;
        r2 = r1;
        r8 = r6;
        r4 = r7;
        r9 = r5;
        goto L_0x0030;
    L_0x00c4:
        r0 = r12.guS;
        r0 = r0.csT;
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_description;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x00d6:
        r0 = r12.guS;
        r0 = r0.wM();
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x00e6;
    L_0x00e2:
        r0 = r12.guS;
        r0 = r0.field_username;
    L_0x00e6:
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_wxid;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x00f4:
        r0 = r12.fyJ;
        r1 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 != 0) goto L_0x01fb;
    L_0x00fe:
        r0 = "​";
        r3 = r1.split(r0);
        r4 = r3.length;
        r2 = r7;
    L_0x0107:
        if (r2 >= r4) goto L_0x01fb;
    L_0x0109:
        r0 = r3[r2];
        r5 = r12.jrx;
        r5 = r5.jrV;
        r5 = r0.startsWith(r5);
        if (r5 == 0) goto L_0x0123;
    L_0x0115:
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_mobile;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x0123:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0107;
    L_0x0127:
        r0 = r12.fyJ;
        r0 = r0.content;
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_province;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x0139:
        r0 = r12.fyJ;
        r0 = r0.content;
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_city;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x014b:
        r0 = com.tencent.mm.plugin.fts.a.n.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fts.a.n) r0;
        r0 = r0.getFTSMainDB();
        r1 = r12.guS;
        r1 = r1.field_contactLabelIds;
        r2 = r0.Cr(r1);
        r3 = new java.lang.StringBuffer;
        r3.<init>();
        r0 = r12.jrx;
        r4 = r0.jrX;
        r5 = r4.length;
        r1 = r7;
    L_0x016a:
        if (r1 >= r5) goto L_0x0196;
    L_0x016c:
        r8 = r4[r1];
        r9 = r2.iterator();
    L_0x0172:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0192;
    L_0x0178:
        r0 = r9.next();
        r0 = (java.lang.String) r0;
        r10 = com.tencent.mm.plugin.fts.a.d.Cv(r0);
        r10 = r10.contains(r8);
        if (r10 == 0) goto L_0x0172;
    L_0x0188:
        r3.append(r0);
        r0 = ",";
        r3.append(r0);
        goto L_0x0172;
    L_0x0192:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x016a;
    L_0x0196:
        r3.trimToSize();
        r0 = r3.length();
        if (r0 != 0) goto L_0x01b0;
    L_0x019f:
        r0 = "";
    L_0x01a2:
        r1 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_tag;
        r5 = r13.getString(r1);
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x01b0:
        r0 = r3.length();
        r0 = r0 + -1;
        r0 = r3.substring(r7, r0);
        goto L_0x01a2;
    L_0x01bb:
        r0 = r12.guS;
        r1 = r12.H(r0);
        r0 = r1.second;
        r0 = (java.lang.String) r0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r1.first;
        r1 = (java.lang.String) r1;
        r1 = r2.append(r1);
        r2 = "：";
        r1 = r1.append(r2);
        r5 = r1.toString();
        r3 = r7;
        r2 = r7;
        r8 = r6;
        r4 = r7;
        r9 = r0;
        r10 = r5;
        goto L_0x0030;
    L_0x01e5:
        r0 = com.tencent.mm.plugin.fts.ui.n.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r11, r0);
        r12.hqx = r0;
        goto L_0x0054;
    L_0x01f4:
        r0 = "";
        r12.jxA = r0;
        goto L_0x00a7;
    L_0x01fb:
        r0 = r1;
        goto L_0x0115;
    L_0x01fe:
        r0 = r7;
        goto L_0x00a9;
    L_0x0201:
        r0 = r7;
        r1 = r7;
        goto L_0x00aa;
    L_0x0205:
        r0 = r7;
        goto L_0x00b2;
    L_0x0208:
        r0 = r7;
        r1 = r7;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.a.r.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    private Pair<String, String> H(ab abVar) {
        c cVar = new c();
        cVar.oE(abVar.cte);
        for (int i = 0; i < cVar.eul.size(); i++) {
            a aVar = (a) cVar.eul.get(i);
            for (b oF : aVar.eum) {
                String oF2 = oF.oF(abVar.field_openImAppid);
                if (!bi.oW(oF2)) {
                    for (CharSequence contains : this.jrx.jrX) {
                        if (oF2.contains(contains)) {
                            return new Pair(aVar.title, oF2);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.jyW;
    }

    public final String afE() {
        if (this.guS == null || !ab.XR(this.guS.field_username)) {
            return "";
        }
        return "openim:" + this.guS.field_openImAppid;
    }
}
