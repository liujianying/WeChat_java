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
import com.tencent.mm.plugin.selectcontact.a$d;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.storage.ab;
import java.util.regex.Pattern;

public class d extends a {
    private static final Pattern eCg = Pattern.compile(",");
    public CharSequence eCh;
    public CharSequence eCi;
    public l fyJ;
    public String umx;
    private b umy = new b();
    private a umz = new a(this);
    public String username;

    public class b extends a$b {
        public b() {
            super(d.this);
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (a.fi(context)) {
                inflate = LayoutInflater.from(context).inflate(a$f.select_ui_listcontactitem_large, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(a$f.select_ui_listcontactitem, viewGroup, false);
            }
            a aVar = (a) d.this.Wh();
            aVar.eCl = (ImageView) inflate.findViewById(e.avatar_iv);
            aVar.eCm = (TextView) inflate.findViewById(e.title_tv);
            aVar.eCn = (TextView) inflate.findViewById(e.desc_tv);
            aVar.contentView = inflate.findViewById(e.select_item_content_layout);
            aVar.eCo = (CheckBox) inflate.findViewById(e.select_cb);
            aVar.umA = (CheckBox) inflate.findViewById(e.select_single_mark);
            aVar.uhd = (TextView) inflate.findViewById(e.openim_contact_desc);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.eCl.setImageResource(a$d.default_avatar);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, dVar.username);
            }
            m.a(dVar.eCh, aVar3.eCm);
            m.a(dVar.eCi, aVar3.eCn);
            if (d.this.ujX) {
                aVar3.eCo.setBackgroundResource(a$d.mm_checkbox_btn);
                if (z) {
                    aVar3.eCo.setChecked(true);
                    aVar3.eCo.setEnabled(false);
                } else {
                    aVar3.eCo.setChecked(z2);
                    aVar3.eCo.setEnabled(true);
                }
                aVar3.eCo.setVisibility(0);
            } else if (d.this.umo) {
                aVar3.eCo.setBackgroundResource(a$d.round_selector);
                if (z) {
                    aVar3.eCo.setChecked(true);
                    aVar3.eCo.setEnabled(false);
                } else {
                    aVar3.eCo.setChecked(z2);
                    aVar3.eCo.setEnabled(true);
                }
                aVar3.eCo.setVisibility(0);
            } else if (d.this.ujY) {
                aVar3.eCo.setVisibility(8);
                aVar3.umA.setChecked(z2);
                aVar3.umA.setEnabled(true);
                aVar3.umA.setVisibility(0);
            } else {
                aVar3.eCo.setVisibility(8);
            }
            if (d.this.hoR) {
                aVar3.contentView.setBackgroundResource(a$d.comm_list_item_selector_no_divider);
            } else {
                aVar3.contentView.setBackgroundResource(a$d.comm_list_item_selector);
            }
            if (dVar.guS.field_deleteFlag == 1) {
                aVar3.eCn.setVisibility(0);
                aVar3.eCn.setText(context.getString(h.select_contact_account_deleted));
            }
            if (aVar3.uhd == null) {
                return;
            }
            if (ab.XR(dVar.username)) {
                aVar3.uhd.setText(dVar.umx);
                aVar3.uhd.setVisibility(0);
                return;
            }
            aVar3.uhd.setVisibility(8);
        }

        public final boolean Wi() {
            if (d.this.fyJ != null) {
                ((n) g.n(n.class)).updateTopHitsRank(d.this.bWm, d.this.fyJ, 1);
            }
            return false;
        }
    }

    public d(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ck(android.content.Context r14) {
        /*
        r13 = this;
        r8 = 0;
        r3 = 0;
        r2 = 1;
        r0 = r13.fyJ;
        if (r0 == 0) goto L_0x005a;
    L_0x0007:
        r0 = r13.guS;
        if (r0 != 0) goto L_0x0261;
    L_0x000b:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r1 = r13.fyJ;
        r1 = r1.jrv;
        r0 = r0.Yb(r1);
        r13.guS = r0;
        r0 = r13.guS;
        if (r0 != 0) goto L_0x0261;
    L_0x0028:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r1 = r13.fyJ;
        r1 = r1.jrv;
        r0 = r0.Yf(r1);
        r13.guS = r0;
        r1 = r2;
    L_0x0042:
        r0 = r13.guS;
        if (r0 != 0) goto L_0x005c;
    L_0x0046:
        r0 = "MicroMsg.ContactDataItem";
        r1 = "filling dataItem Occur Error Contact is null, position=%d";
        r2 = new java.lang.Object[r2];
        r4 = r13.position;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
    L_0x0059:
        return;
    L_0x005a:
        r1 = r3;
        goto L_0x0042;
    L_0x005c:
        r0 = r13.guS;
        r0 = r0.field_username;
        r13.username = r0;
        r0 = com.tencent.mm.openim.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.openim.a.b) r0;
        r4 = r13.guS;
        r4 = r4.field_openImAppid;
        r5 = r13.guS;
        r5 = r5.field_descWordingId;
        r0 = r0.aE(r4, r5);
        r13.umx = r0;
        if (r1 == 0) goto L_0x0210;
    L_0x007a:
        r1 = r13.fyJ;
        r4 = r13.guS;
        r5 = r14.getResources();
        if (r4 == 0) goto L_0x0258;
    L_0x0084:
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r6 = r4.field_username;
        r10 = r0.a(r4, r6);
        r0 = r1.jru;
        switch(r0) {
            case 1: goto L_0x024d;
            case 2: goto L_0x024a;
            case 3: goto L_0x0106;
            case 4: goto L_0x011d;
            case 5: goto L_0x0254;
            case 6: goto L_0x0251;
            case 7: goto L_0x010e;
            case 8: goto L_0x0097;
            case 9: goto L_0x0097;
            case 10: goto L_0x0097;
            case 11: goto L_0x0186;
            case 12: goto L_0x0097;
            case 13: goto L_0x0097;
            case 14: goto L_0x0097;
            case 15: goto L_0x012d;
            case 16: goto L_0x0147;
            case 17: goto L_0x0176;
            case 18: goto L_0x0176;
            default: goto L_0x0097;
        };
    L_0x0097:
        r4 = r3;
        r1 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r8;
        r9 = r8;
    L_0x009d:
        if (r6 == 0) goto L_0x01f4;
    L_0x009f:
        r0 = "MicroMsg.ContactDataItem";
        r6 = "highlight first line";
        com.tencent.mm.sdk.platformtools.x.d(r0, r6);
        r0 = com.tencent.mm.plugin.selectcontact.a.c.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r14, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r14, r10, r0);
        r13.eCh = r0;
        r0 = r13.eCh;
        r6 = r13.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r6, r1, r4);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r13.eCh = r0;
    L_0x00c4:
        if (r5 == 0) goto L_0x0202;
    L_0x00c6:
        r0 = "MicroMsg.ContactDataItem";
        r5 = "highlight second line";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = com.tencent.mm.plugin.selectcontact.a.c.HintTextSize;
        r0 = com.tencent.mm.bp.a.ad(r14, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r14, r7, r0);
        r13.eCi = r0;
        r0 = r13.eCi;
        r5 = r13.jrx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r5, r1, r4);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r13.eCi = r0;
    L_0x00eb:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r0 != 0) goto L_0x0059;
    L_0x00f1:
        r0 = r13.eCi;
        if (r0 == 0) goto L_0x0059;
    L_0x00f5:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r3] = r9;
        r1 = r13.eCi;
        r0[r2] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r13.eCi = r0;
        goto L_0x0059;
    L_0x0106:
        r0 = r2;
    L_0x0107:
        r1 = r2;
    L_0x0108:
        r4 = r0;
        r5 = r3;
        r6 = r2;
        r7 = r8;
        r9 = r8;
        goto L_0x009d;
    L_0x010e:
        r0 = r2;
    L_0x010f:
        r1 = r2;
    L_0x0110:
        r7 = r4.field_nickname;
        r4 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_nickname;
        r8 = r5.getString(r4);
        r4 = r0;
        r5 = r2;
        r6 = r3;
        r9 = r8;
        goto L_0x009d;
    L_0x011d:
        r0 = r4.csT;
        r1 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_description;
        r8 = r5.getString(r1);
        r4 = r3;
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r9 = r8;
        goto L_0x009d;
    L_0x012d:
        r0 = r4.wM();
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x0139;
    L_0x0137:
        r0 = r4.field_username;
    L_0x0139:
        r1 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_wxid;
        r8 = r5.getString(r1);
        r4 = r3;
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r9 = r8;
        goto L_0x009d;
    L_0x0147:
        r1 = r1.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 != 0) goto L_0x0247;
    L_0x014f:
        r0 = "​";
        r6 = r1.split(r0);
        r7 = r6.length;
        r4 = r3;
    L_0x0158:
        if (r4 >= r7) goto L_0x0247;
    L_0x015a:
        r0 = r6[r4];
        r8 = r13.bWm;
        r8 = r0.startsWith(r8);
        if (r8 == 0) goto L_0x0172;
    L_0x0164:
        r1 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_mobile;
        r8 = r5.getString(r1);
        r4 = r3;
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r9 = r8;
        goto L_0x009d;
    L_0x0172:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0158;
    L_0x0176:
        r0 = r1.content;
        r1 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_location;
        r8 = r5.getString(r1);
        r4 = r3;
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r9 = r8;
        goto L_0x009d;
    L_0x0186:
        r0 = com.tencent.mm.plugin.fts.a.n.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fts.a.n) r0;
        r0 = r0.getFTSMainDB();
        r1 = r4.field_contactLabelIds;
        r4 = r0.Cr(r1);
        r6 = new java.lang.StringBuffer;
        r6.<init>();
        r0 = r13.jrx;
        r7 = r0.jrX;
        r8 = r7.length;
        r1 = r3;
    L_0x01a3:
        if (r1 >= r8) goto L_0x01cf;
    L_0x01a5:
        r9 = r7[r1];
        r11 = r4.iterator();
    L_0x01ab:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x01cb;
    L_0x01b1:
        r0 = r11.next();
        r0 = (java.lang.String) r0;
        r12 = com.tencent.mm.plugin.fts.a.d.Cv(r0);
        r12 = r12.contains(r9);
        if (r12 == 0) goto L_0x01ab;
    L_0x01c1:
        r6.append(r0);
        r0 = ",";
        r6.append(r0);
        goto L_0x01ab;
    L_0x01cb:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x01a3;
    L_0x01cf:
        r6.trimToSize();
        r0 = r6.length();
        if (r0 != 0) goto L_0x01e9;
    L_0x01d8:
        r0 = "";
    L_0x01db:
        r1 = com.tencent.mm.plugin.selectcontact.a.h.search_contact_tag_tag;
        r8 = r5.getString(r1);
        r4 = r3;
        r1 = r3;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r9 = r8;
        goto L_0x009d;
    L_0x01e9:
        r0 = r6.length();
        r0 = r0 + -1;
        r0 = r6.substring(r3, r0);
        goto L_0x01db;
    L_0x01f4:
        r0 = com.tencent.mm.plugin.selectcontact.a.c.NormalTextSize;
        r0 = com.tencent.mm.bp.a.ad(r14, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r14, r10, r0);
        r13.eCh = r0;
        goto L_0x00c4;
    L_0x0202:
        r0 = com.tencent.mm.plugin.selectcontact.a.c.HintTextSize;
        r0 = com.tencent.mm.bp.a.ad(r14, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r14, r7, r0);
        r13.eCi = r0;
        goto L_0x00eb;
    L_0x0210:
        r0 = r13.bIY;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0234;
    L_0x0218:
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r1 = r13.guS;
        r0 = r0.c(r1);
    L_0x0226:
        r1 = com.tencent.mm.plugin.selectcontact.a.c.NormalTextSize;
        r1 = com.tencent.mm.bp.a.ad(r14, r1);
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r14, r0, r1);
        r13.eCh = r0;
        goto L_0x0059;
    L_0x0234:
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r1 = r13.guS;
        r1 = r1.field_username;
        r2 = r13.bIY;
        r0 = r0.getDisplayName(r1, r2);
        goto L_0x0226;
    L_0x0247:
        r0 = r1;
        goto L_0x0164;
    L_0x024a:
        r0 = r3;
        goto L_0x0107;
    L_0x024d:
        r0 = r3;
        r1 = r3;
        goto L_0x0108;
    L_0x0251:
        r0 = r3;
        goto L_0x010f;
    L_0x0254:
        r0 = r3;
        r1 = r3;
        goto L_0x0110;
    L_0x0258:
        r4 = r3;
        r1 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r8;
        r9 = r8;
        r10 = r8;
        goto L_0x009d;
    L_0x0261:
        r1 = r2;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.d.ck(android.content.Context):void");
    }

    public a$b Wg() {
        return this.umy;
    }

    public a.a Wh() {
        return this.umz;
    }
}
