package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a$e;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.f;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern ums = Pattern.compile(";");
    public CharSequence eCh;
    public CharSequence eCi;
    public l fyJ;
    public CharSequence umt;
    private b umu = new b();
    a umv = new a(this);
    public String username;

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super(c.this);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (a.fi(context)) {
                inflate = LayoutInflater.from(context).inflate(f.select_ui_listcontactitem_large, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(f.select_ui_listcontactitem, viewGroup, false);
            }
            a aVar = c.this.umv;
            aVar.eCl = (ImageView) inflate.findViewById(a$e.avatar_iv);
            aVar.eCm = (TextView) inflate.findViewById(a$e.title_tv);
            aVar.eCm.setMaxWidth(a.fromDPToPix(context, 200));
            aVar.eCn = (TextView) inflate.findViewById(a$e.desc_tv);
            aVar.jxy = (TextView) inflate.findViewById(a$e.tip_tv);
            aVar.contentView = inflate.findViewById(a$e.select_item_content_layout);
            aVar.eCo = (CheckBox) inflate.findViewById(a$e.select_cb);
            if (c.this.hoR) {
                aVar.contentView.setBackgroundResource(d.comm_list_item_selector_no_divider);
            }
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.eCl.setImageResource(d.default_avatar);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, cVar.username);
            }
            m.a(cVar.eCh, aVar3.eCm);
            m.a(cVar.eCi, aVar3.eCn);
            m.a(cVar.umt, aVar3.jxy);
            if (c.this.ujX) {
                if (z) {
                    aVar3.eCo.setChecked(true);
                    aVar3.eCo.setEnabled(false);
                } else {
                    aVar3.eCo.setChecked(z2);
                    aVar3.eCo.setEnabled(true);
                }
                aVar3.eCo.setVisibility(0);
                return;
            }
            aVar3.eCo.setVisibility(8);
        }

        public final boolean Wi() {
            if (c.this.fyJ != null) {
                ((n) g.n(n.class)).updateTopHitsRank(c.this.bWm, c.this.fyJ, 1);
            }
            return false;
        }
    }

    public c(int i) {
        super(3, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ck(android.content.Context r12) {
        /*
        r11 = this;
        r10 = 2;
        r4 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r11.fyJ;
        if (r0 == 0) goto L_0x005b;
    L_0x0008:
        r0 = r11.guS;
        if (r0 != 0) goto L_0x016c;
    L_0x000c:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r3 = r11.fyJ;
        r3 = r3.jrv;
        r0 = r0.Yb(r3);
        r11.guS = r0;
        r0 = r11.guS;
        if (r0 != 0) goto L_0x016c;
    L_0x0029:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r3 = r11.fyJ;
        r3 = r3.jrv;
        r0 = r0.Yf(r3);
        r11.guS = r0;
        r0 = r1;
    L_0x0043:
        r3 = r11.guS;
        if (r3 != 0) goto L_0x005d;
    L_0x0047:
        r0 = "MicroMsg.ChatroomDataItem";
        r3 = "filling dataItem Occur Error Contact is null, position=%d";
        r1 = new java.lang.Object[r1];
        r4 = r11.position;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r1);
    L_0x005a:
        return;
    L_0x005b:
        r0 = r2;
        goto L_0x0043;
    L_0x005d:
        r3 = r11.guS;
        r3 = r3.field_username;
        r11.username = r3;
        if (r0 == 0) goto L_0x0131;
    L_0x0065:
        r3 = r11.fyJ;
        r5 = r11.guS;
        r6 = r12.getResources();
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r7 = r5.field_username;
        r7 = r0.a(r5, r7);
        r0 = r3.jru;
        switch(r0) {
            case 1: goto L_0x0168;
            case 2: goto L_0x00a5;
            case 3: goto L_0x00a4;
            case 5: goto L_0x0168;
            case 6: goto L_0x00a5;
            case 7: goto L_0x00a4;
            case 38: goto L_0x00ad;
            default: goto L_0x0080;
        };
    L_0x0080:
        r0 = r2;
        r3 = r2;
        r1 = r2;
    L_0x0083:
        if (r1 == 0) goto L_0x0123;
    L_0x0085:
        r1 = com.tencent.mm.plugin.selectcontact.a.c.HintTextSize;
        r1 = com.tencent.mm.bp.a.ad(r12, r1);
        r1 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r7, r1);
        r11.eCh = r1;
        r1 = r11.eCh;
        r2 = r11.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r1, r2, r3, r0);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r11.eCh = r0;
    L_0x00a1:
        r11.eCi = r4;
        goto L_0x005a;
    L_0x00a4:
        r2 = r1;
    L_0x00a5:
        r0 = r2;
        r3 = r1;
    L_0x00a7:
        r2 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_nickname;
        r6.getString(r2);
        goto L_0x0083;
    L_0x00ad:
        r0 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.kernel.g.Ek();
        r8 = com.tencent.mm.kernel.g.Ei();
        r8 = r8.dqq;
        r9 = new java.lang.String[r1];
        r5 = r5.field_username;
        r9[r2] = r5;
        r0 = r8.b(r0, r9, r10);
        r5 = r0.moveToFirst();
        if (r5 == 0) goto L_0x011e;
    L_0x00c9:
        r5 = r0.getString(r2);
        r0.close();
        if (r5 != 0) goto L_0x0117;
    L_0x00d2:
        r0 = r4;
    L_0x00d3:
        if (r0 == 0) goto L_0x00f2;
    L_0x00d5:
        r5 = r0.length;
        if (r5 <= 0) goto L_0x00f2;
    L_0x00d8:
        r5 = new java.lang.StringBuilder;
        r8 = "(";
        r5.<init>(r8);
        r8 = r0.length;
        r5 = r5.append(r8);
        r8 = ")";
        r5 = r5.append(r8);
        r5 = r5.toString();
        r11.umt = r5;
    L_0x00f2:
        if (r0 == 0) goto L_0x0080;
    L_0x00f4:
        r5 = r3.jsH;
        if (r5 == 0) goto L_0x0080;
    L_0x00f8:
        r3 = r3.jsH;
        r4 = r11.jrx;
        r5 = com.tencent.mm.plugin.fts.ui.b.c.jvz;
        r0 = com.tencent.mm.plugin.fts.ui.m.a(r12, r3, r0, r4, r5);
        r3 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_member;
        r3 = r6.getString(r3);
        r4 = new java.lang.CharSequence[r10];
        r4[r2] = r3;
        r4[r1] = r0;
        r4 = android.text.TextUtils.concat(r4);
        r0 = r2;
        r3 = r2;
        r1 = r2;
        goto L_0x0083;
    L_0x0117:
        r0 = ums;
        r0 = r0.split(r5);
        goto L_0x00d3;
    L_0x011e:
        r0.close();
        r0 = r4;
        goto L_0x00d3;
    L_0x0123:
        r0 = com.tencent.mm.plugin.selectcontact.a.c.HintTextSize;
        r0 = com.tencent.mm.bp.a.ad(r12, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r7, r0);
        r11.eCh = r0;
        goto L_0x00a1;
    L_0x0131:
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r1 = r11.guS;
        r2 = r11.guS;
        r2 = r2.field_username;
        r0 = r0.a(r1, r2);
        r11.eCh = r0;
        r0 = r11.fyJ;
        if (r0 == 0) goto L_0x005a;
    L_0x0149:
        r0 = new java.lang.StringBuilder;
        r1 = "(";
        r0.<init>(r1);
        r1 = r11.fyJ;
        r2 = r1.jsA;
        r0 = r0.append(r2);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.umt = r0;
        goto L_0x005a;
    L_0x0168:
        r0 = r2;
        r3 = r2;
        goto L_0x00a7;
    L_0x016c:
        r0 = r1;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.c.ck(android.content.Context):void");
    }

    public final com.tencent.mm.ui.contact.a.a.b Wg() {
        return this.umu;
    }

    protected final a.a Wh() {
        return this.umv;
    }

    public final boolean aQi() {
        return this.fyJ.jsK;
    }
}
