package com.tencent.mm.plugin.fts.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;

public class f extends k {
    public String jso;
    protected CharSequence jxS;
    protected String jxT;
    protected CharSequence jxU;
    protected String jxV;
    public l jxW;
    private a jxX = new a(this);
    b jxY = new b();
    public int showType;

    public class b extends a {
        public View contentView;
        public View jxR;
        public TextView jya;
        public ImageView jyb;
        public TextView jyc;
        public ImageView jyd;
        public TextView jye;

        public b() {
            super(f.this);
        }
    }

    public f(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r12, com.tencent.mm.plugin.fts.a.d.a.a.a r13, java.lang.Object... r14) {
        /*
        r11 = this;
        r0 = r11.jxW;
        r6 = r0.jrv;
        r1 = 0;
        r2 = 0;
        r0 = 0;
        r4 = 0;
        r3 = r11.jxW;
        r3 = r3.jru;
        switch(r3) {
            case 1: goto L_0x0162;
            case 2: goto L_0x015f;
            case 3: goto L_0x0091;
            case 4: goto L_0x000f;
            case 5: goto L_0x009e;
            case 6: goto L_0x009d;
            case 7: goto L_0x009c;
            default: goto L_0x000f;
        };
    L_0x000f:
        r5 = r4;
        r3 = r1;
    L_0x0011:
        r1 = r11.showType;
        r4 = 2;
        if (r1 != r4) goto L_0x00ce;
    L_0x0016:
        r11.jxT = r6;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r1 != 0) goto L_0x00b8;
    L_0x001e:
        r1 = r11.jxW;
        r1 = r1.jrx;
        r4 = com.tencent.mm.plugin.fts.ui.b.c.jvv;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = "(";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = ")";
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.jxS = r0;
    L_0x0047:
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r11.jxS;
        r0[r1] = r2;
        r1 = 2;
        r2 = "\"";
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r11.jxS = r0;
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r11.jso;
        r2 = com.tencent.mm.plugin.fts.a.d.Bc(r2);
        r3 = com.tencent.mm.plugin.fts.ui.b.c.jvx;
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r5 = android.text.TextUtils.TruncateAt.END;
        r2 = android.text.TextUtils.ellipsize(r2, r3, r4, r5);
        r0[r1] = r2;
        r1 = 2;
        r2 = com.tencent.mm.plugin.fts.ui.n.g.search_talker_message_info_3;
        r2 = r12.getString(r2);
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r11.jxU = r0;
        r0 = r11.jso;
        r11.jxV = r0;
    L_0x0090:
        return;
    L_0x0091:
        r0 = 1;
    L_0x0092:
        r1 = 1;
        r2 = r1;
        r3 = r0;
    L_0x0095:
        r0 = com.tencent.mm.plugin.fts.a.d.Bc(r6);
        r5 = r4;
        goto L_0x0011;
    L_0x009c:
        r1 = 1;
    L_0x009d:
        r2 = 1;
    L_0x009e:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r0 = r0.Yg(r6);
        r0 = r0.field_nickname;
        r4 = com.tencent.mm.plugin.fts.a.d.Bc(r6);
        r5 = r4;
        r3 = r1;
        goto L_0x0011;
    L_0x00b8:
        r1 = r11.jxW;
        r1 = r1.jrx;
        r4 = 1137180672; // 0x43c80000 float:400.0 double:5.61841903E-315;
        r5 = com.tencent.mm.plugin.fts.ui.b.c.jvv;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.jxS = r0;
        goto L_0x0047;
    L_0x00ce:
        r1 = 3;
        r1 = new java.lang.CharSequence[r1];
        r4 = 0;
        r7 = "\"";
        r1[r4] = r7;
        r4 = 1;
        r7 = r11.jso;
        r7 = com.tencent.mm.plugin.fts.a.d.Bc(r7);
        r8 = com.tencent.mm.plugin.fts.ui.b.c.jvx;
        r9 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r10 = android.text.TextUtils.TruncateAt.END;
        r7 = android.text.TextUtils.ellipsize(r7, r8, r9, r10);
        r1[r4] = r7;
        r4 = 2;
        r7 = "\"";
        r1[r4] = r7;
        r1 = android.text.TextUtils.concat(r1);
        r11.jxS = r1;
        r1 = r11.jso;
        r11.jxT = r1;
        r11.jxV = r6;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r1 != 0) goto L_0x014a;
    L_0x0102:
        r1 = r11.jxW;
        r1 = r1.jrx;
        r4 = com.tencent.mm.plugin.fts.ui.b.c.jvv;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = "(";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = ")";
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.jxU = r0;
    L_0x012b:
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r11.jxU;
        r0[r1] = r2;
        r1 = 2;
        r2 = com.tencent.mm.plugin.fts.ui.n.g.search_talker_message_info_3;
        r2 = r12.getString(r2);
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r11.jxU = r0;
        goto L_0x0090;
    L_0x014a:
        r1 = r11.jxW;
        r1 = r1.jrx;
        r4 = 1137180672; // 0x43c80000 float:400.0 double:5.61841903E-315;
        r5 = com.tencent.mm.plugin.fts.ui.b.c.jvv;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.jxU = r0;
        goto L_0x012b;
    L_0x015f:
        r0 = r1;
        goto L_0x0092;
    L_0x0162:
        r3 = r1;
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.a.f.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.jxX;
    }

    protected final a afD() {
        return this.jxY;
    }
}
