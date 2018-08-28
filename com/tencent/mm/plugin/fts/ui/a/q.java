package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.c;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.storage.ab;
import java.util.List;

public final class q extends a {
    public l fyJ;
    public ab guS;
    public CharSequence hqx;
    public CharSequence hqy;
    public CharSequence jyS;
    private b jyT = new b();
    a jyU = new a(this);
    public String username;

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super(q.this);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.fts_contact_item, viewGroup, false);
            a aVar = q.this.jyU;
            aVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
            aVar.eCm = (TextView) inflate.findViewById(d.title_tv);
            aVar.eCn = (TextView) inflate.findViewById(d.desc_tv);
            aVar.contentView = inflate.findViewById(d.search_item_content_layout);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a.a aVar, a aVar2, Object... objArr) {
            a aVar3 = (a) aVar;
            q qVar = (q) aVar2;
            m.h(aVar3.contentView, q.this.jtj);
            if (qVar.username == null || qVar.username.length() <= 0) {
                aVar3.eCl.setImageResource(c.default_avatar);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, qVar.username);
            }
            aVar3.eCm.setText(qVar.hqx);
            aVar3.eCm.setMaxWidth(com.tencent.mm.bp.a.fromDPToPix(context, 200));
            m.a(qVar.hqy, aVar3.eCn);
        }

        public final boolean a(Context context, a aVar) {
            q qVar = (q) aVar;
            a(q.this.jrx.jrV, qVar.fyJ);
            com.tencent.mm.bg.d.e(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", qVar.username).putExtra("finish_direct", true));
            return true;
        }
    }

    public q(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.a.d.a.a.a r12, java.lang.Object... r13) {
        /*
        r10 = this;
        r5 = 0;
        r9 = 2;
        r1 = 1;
        r4 = 0;
        r0 = r10.fyJ;
        r0 = r0.jrv;
        r10.username = r0;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r2 = r10.username;
        r0 = r0.Yg(r2);
        r10.guS = r0;
        r2 = r11.getResources();
        r0 = r10.guS;
        r0 = r0.field_username;
        r8 = com.tencent.mm.plugin.fts.a.d.Bc(r0);
        r0 = r10.fyJ;
        r0 = r0.jru;
        switch(r0) {
            case 1: goto L_0x010e;
            case 2: goto L_0x010b;
            case 3: goto L_0x0058;
            case 5: goto L_0x010e;
            case 6: goto L_0x010b;
            case 7: goto L_0x0058;
            case 38: goto L_0x0064;
            default: goto L_0x0031;
        };
    L_0x0031:
        r3 = r4;
        r2 = r4;
        r6 = r4;
        r7 = r5;
    L_0x0035:
        if (r6 == 0) goto L_0x00d9;
    L_0x0037:
        r0 = com.tencent.mm.plugin.fts.ui.b$c.jvw;
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r11, r8, r0);
        r10.hqx = r0;
        r0 = r10.hqx;
        r1 = r10.jrx;
        r4 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r4 = (float) r4;
        r5 = com.tencent.mm.plugin.fts.ui.b$c.jvx;
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r10.hqx = r0;
    L_0x0055:
        r10.hqy = r7;
        return;
    L_0x0058:
        r0 = r1;
    L_0x0059:
        r2 = r1;
    L_0x005a:
        r3 = r10.guS;
        r3 = r3.field_nickname;
        r10.hqy = r3;
        r3 = r0;
        r6 = r1;
        r7 = r5;
        goto L_0x0035;
    L_0x0064:
        r0 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        r3 = com.tencent.mm.kernel.g.Ei();
        r3 = r3.dqq;
        r6 = new java.lang.String[r1];
        r7 = r10.guS;
        r7 = r7.field_username;
        r6[r4] = r7;
        r3 = r3.b(r0, r6, r9);
        r0 = r3.moveToFirst();
        if (r0 == 0) goto L_0x0108;
    L_0x007f:
        r0 = r3.getString(r4);
        if (r0 != 0) goto L_0x00d2;
    L_0x0085:
        r0 = r5;
    L_0x0086:
        r3.close();
        if (r0 == 0) goto L_0x00a8;
    L_0x008b:
        r3 = r0.length;
        if (r3 <= 0) goto L_0x00a8;
    L_0x008e:
        r3 = new java.lang.StringBuilder;
        r6 = "(";
        r3.<init>(r6);
        r6 = r0.length;
        r3 = r3.append(r6);
        r6 = ")";
        r3 = r3.append(r6);
        r3 = r3.toString();
        r10.jyS = r3;
    L_0x00a8:
        if (r0 == 0) goto L_0x0031;
    L_0x00aa:
        r3 = r10.fyJ;
        r3 = r3.jsH;
        if (r3 == 0) goto L_0x0031;
    L_0x00b0:
        r3 = r10.fyJ;
        r3 = r3.jsH;
        r5 = r10.jrx;
        r6 = com.tencent.mm.plugin.fts.ui.b$c.jvz;
        r0 = com.tencent.mm.plugin.fts.ui.m.a(r11, r3, r0, r5, r6);
        r3 = com.tencent.mm.plugin.fts.ui.n.g.search_contact_tag_member;
        r2 = r2.getString(r3);
        r3 = new java.lang.CharSequence[r9];
        r3[r4] = r2;
        r3[r1] = r0;
        r5 = android.text.TextUtils.concat(r3);
        r3 = r4;
        r2 = r4;
        r6 = r4;
        r7 = r5;
        goto L_0x0035;
    L_0x00d2:
        r6 = com.tencent.mm.plugin.fts.a.c.a.jqy;
        r0 = r6.split(r0);
        goto L_0x0086;
    L_0x00d9:
        r0 = com.tencent.mm.plugin.fts.ui.b$c.jvw;
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.j.b(r11, r8, r0);
        r10.hqx = r0;
        r0 = r10.hqx;
        r2 = r10.jyS;
        r3 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r3 = (float) r3;
        r5 = com.tencent.mm.plugin.fts.ui.b$c.jvx;
        r6 = android.text.TextUtils.TruncateAt.END;
        r8 = r2.toString();
        r8 = r5.measureText(r8);
        r3 = r3 - r8;
        r8 = new java.lang.CharSequence[r9];
        r0 = android.text.TextUtils.ellipsize(r0, r5, r3, r6);
        r8[r4] = r0;
        r8[r1] = r2;
        r0 = android.text.TextUtils.concat(r8);
        r10.hqx = r0;
        goto L_0x0055;
    L_0x0108:
        r0 = r5;
        goto L_0x0086;
    L_0x010b:
        r0 = r4;
        goto L_0x0059;
    L_0x010e:
        r0 = r4;
        r2 = r4;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.a.q.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.jyT;
    }

    protected final a.a afD() {
        return this.jyU;
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }

    public final int aQh() {
        if (this.fyJ.jru == 38) {
            List list = this.fyJ.jsH;
            if (list != null && list.size() > 0) {
                return ((f) list.get(0)).jru;
            }
        }
        return super.aQh();
    }

    public final boolean aQi() {
        return this.fyJ.jsK;
    }
}
