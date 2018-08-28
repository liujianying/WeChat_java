package com.tencent.mm.plugin.brandservice.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.storage.ab;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    public l fyJ;
    public ab guS;
    a hqA = new a();
    public CharSequence hqx;
    public CharSequence hqy;
    private b hqz = new b(this);
    public String iconUrl;
    public String username;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView eCl;
        public TextView eCm;
        public TextView eCn;

        public a() {
            super(a.this);
        }
    }

    public a(int i) {
        super(4, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.a.d.a.a.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
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
        r1 = com.tencent.mm.ac.f.kH(r0);
        if (r1 != 0) goto L_0x0096;
    L_0x0022:
        r0 = "";
    L_0x0025:
        r12.iconUrl = r0;
        r0 = r12.username;
        r8 = com.tencent.mm.model.r.gT(r0);
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        if (r1 == 0) goto L_0x003b;
    L_0x0035:
        r0 = r1.Me();
        if (r0 == 0) goto L_0x0099;
    L_0x003b:
        r0 = 1;
        r1 = r0;
    L_0x003d:
        r0 = r12.fyJ;
        r0 = r0.jru;
        switch(r0) {
            case 1: goto L_0x0138;
            case 2: goto L_0x0135;
            case 3: goto L_0x009c;
            case 15: goto L_0x00a2;
            case 19: goto L_0x00bd;
            case 20: goto L_0x00bc;
            case 21: goto L_0x00bb;
            default: goto L_0x0044;
        };
    L_0x0044:
        if (r5 == 0) goto L_0x0126;
    L_0x0046:
        r0 = com.tencent.mm.plugin.brandservice.b.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r8, r0);
        r12.hqx = r0;
        r0 = r12.hqx;
        r5 = r12.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r5, r3, r2);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r12.hqx = r0;
    L_0x0063:
        if (r4 == 0) goto L_0x0095;
    L_0x0065:
        if (r1 == 0) goto L_0x0095;
    L_0x0067:
        r0 = com.tencent.mm.plugin.brandservice.b.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r7, r0);
        r12.hqy = r0;
        r0 = r12.hqy;
        r1 = r12.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r3, r2);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r12.hqy = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r0[r1] = r6;
        r1 = 1;
        r2 = r12.hqy;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r12.hqy = r0;
    L_0x0095:
        return;
    L_0x0096:
        r0 = r1.field_brandIconURL;
        goto L_0x0025;
    L_0x0099:
        r0 = 0;
        r1 = r0;
        goto L_0x003d;
    L_0x009c:
        r0 = 1;
    L_0x009d:
        r2 = 1;
        r3 = r2;
    L_0x009f:
        r5 = 1;
        r2 = r0;
        goto L_0x0044;
    L_0x00a2:
        r4 = 1;
        r0 = r12.guS;
        r0 = r0.wM();
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r6 == 0) goto L_0x00b3;
    L_0x00af:
        r0 = r12.guS;
        r0 = r0.field_username;
    L_0x00b3:
        r6 = com.tencent.mm.plugin.brandservice.b.h.search_contact_tag_wxid;
        r6 = r13.getString(r6);
        r7 = r0;
        goto L_0x0044;
    L_0x00bb:
        r2 = 1;
    L_0x00bc:
        r3 = 1;
    L_0x00bd:
        r0 = com.tencent.mm.api.h.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.api.h) r0;
        r9 = r12.username;
        r0 = r0.cC(r9);
        r9 = r0.iterator();
    L_0x00cf:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x00fc;
    L_0x00d5:
        r0 = r9.next();
        r0 = (java.lang.String) r0;
        r10 = com.tencent.mm.plugin.brandservice.b.b.NormalTextSize;
        r10 = com.tencent.mm.bp.a.ad(r13, r10);
        r10 = (float) r10;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r0, r10);
        r12.hqy = r0;
        r0 = r12.hqy;
        r10 = r12.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r10, r3, r2);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r10 = r0.bjW;
        if (r10 != 0) goto L_0x00cf;
    L_0x00f8:
        r0 = r0.jrO;
        r12.hqy = r0;
    L_0x00fc:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r9 = 0;
        r10 = r12.hqy;
        r0[r9] = r10;
        r9 = 1;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = com.tencent.mm.plugin.brandservice.b.h.search_biz_tran_info;
        r11 = r13.getString(r11);
        r10 = r10.append(r11);
        r10 = r10.append(r8);
        r10 = r10.toString();
        r0[r9] = r10;
        r0 = android.text.TextUtils.concat(r0);
        r12.hqy = r0;
        goto L_0x0044;
    L_0x0126:
        r0 = com.tencent.mm.plugin.brandservice.b.b.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r13, r8, r0);
        r12.hqx = r0;
        goto L_0x0063;
    L_0x0135:
        r0 = r2;
        goto L_0x009d;
    L_0x0138:
        r0 = r2;
        goto L_0x009f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.a.a.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    public final a$b BV() {
        return this.hqz;
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a.a afD() {
        return this.hqA;
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }

    public final String afE() {
        if (this.hqx != null) {
            return this.hqx.toString();
        }
        return "";
    }
}
