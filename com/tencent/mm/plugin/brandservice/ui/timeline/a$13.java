package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.ClipboardManager;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.n$d;

class a$13 implements n$d {
    final /* synthetic */ a hqX;

    a$13(a aVar) {
        this.hqX = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (a.i(this.hqX) == null) {
            x.w("MicroMsg.BizTimeLineAdapter", "onMMMenuItemSelected mInfo == null");
            return;
        }
        q i2 = a.i(this.hqX);
        a.a(this.hqX, bi.VE());
        a aVar;
        Intent intent;
        bd dW;
        switch (menuItem.getItemId()) {
            case 1:
                ab Yg = ((i) g.l(i.class)).FR().Yg(i2.field_talker);
                if (Yg == null) {
                    x.e("MicroMsg.BizTimeLineAdapter", "changed biz stick status failed, contact is null, talker = " + i2.field_talker);
                    return;
                } else if (Yg.BG()) {
                    h.mEJ.h(13307, new Object[]{Yg.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
                    s.u(i2.field_talker, true);
                    com.tencent.mm.ui.base.h.bA(a.b(this.hqX), a.b(this.hqX).getString(b.h.biz_time_line_unplacedtop_tips));
                    a.h(this.hqX).a(a.i(this.hqX), false);
                    return;
                } else {
                    h.mEJ.h(13307, new Object[]{Yg.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3)});
                    s.t(i2.field_talker, true);
                    com.tencent.mm.ui.base.h.bA(a.b(this.hqX), a.b(this.hqX).getString(b.h.biz_time_line_placedtop_tips));
                    a.h(this.hqX).a(a.i(this.hqX), true);
                    return;
                }
            case 2:
                ab Yg2 = ((i) g.l(i.class)).FR().Yg(i2.field_talker);
                ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).b(z.MY().kA(i2.field_talker), a.b(this.hqX), Yg2);
                aVar = (a) a.h(this.hqX).hsb.get(Long.valueOf(a.i(this.hqX).field_msgId));
                if (aVar != null) {
                    aVar.cancel = 1;
                    return;
                }
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("Contact_User", i2.field_talker);
                d.b(a.b(this.hqX), "profile", ".ui.ContactInfoUI", intent);
                aVar = (a) a.h(this.hqX).hsb.get(Long.valueOf(a.i(this.hqX).field_msgId));
                if (aVar != null) {
                    aVar.rjw = 1;
                    return;
                }
                return;
            case 4:
                if (a.j(this.hqX)) {
                    ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(a.k(this.hqX), a.b(this.hqX), i2.field_content, i2.field_talker, i2.field_msgId, i2.field_msgSvrId);
                    return;
                }
                String a = com.tencent.mm.y.i.a(a.b(this.hqX), a.k(this.hqX), i2.field_content, i2.field_talker);
                if (!bi.oW(a)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", a.k(this.hqX));
                    intent2.putExtra("Retr_Msg_Id", i2.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    a = i2.field_talker;
                    String ic = u.ic(i2.field_msgSvrId);
                    intent2.putExtra("reportSessionId", ic);
                    u.b v = u.Hx().v(ic, true);
                    v.p("prePublishId", "msg_" + i2.field_msgSvrId);
                    v.p("preUsername", a);
                    v.p("preChatName", a);
                    v.p("preMsgIndex", Integer.valueOf(a.k(this.hqX)));
                    v.p("sendAppMsgScene", Integer.valueOf(1));
                    d.e(a.b(this.hqX), ".ui.transmit.MsgRetransmitUI", intent2);
                    return;
                }
                return;
            case 5:
                bd dW2 = ((i) g.l(i.class)).bcY().dW(i2.field_msgId);
                if (dW2.field_msgId == 0) {
                    x.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
                    return;
                } else {
                    ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(a.l(this.hqX), a.k(this.hqX), a.b(this.hqX), a.b(this.hqX), dW2);
                    return;
                }
            case 6:
                dW = ((i) g.l(i.class)).bcY().dW(i2.field_msgId);
                if (dW.field_msgId == 0) {
                    x.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
                    return;
                } else {
                    ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(dW, a.b(this.hqX));
                    return;
                }
            case 7:
                dW = ((i) g.l(i.class)).bcY().dW(i2.field_msgId);
                if (dW.field_msgId == 0) {
                    x.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
                    return;
                } else {
                    ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(dW, a.b(this.hqX));
                    return;
                }
            case 8:
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", a.i(this.hqX).field_content);
                intent.putExtra("Retr_Msg_Type", 4);
                d.e(a.b(this.hqX), ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 9:
                try {
                    ((ClipboardManager) a.b(this.hqX).getSystemService("clipboard")).setText(a.i(this.hqX).field_content);
                } catch (Exception e) {
                    x.e("MicroMsg.BizTimeLineAdapter", "clip.setText error ");
                }
                com.tencent.mm.ui.base.h.bA(a.b(this.hqX), a.b(this.hqX).getString(b.h.app_copy_ok));
                int i3 = com.tencent.mm.plugin.secinforeport.a.a.mOt;
                com.tencent.mm.plugin.secinforeport.a.a.f(1, a.i(this.hqX).field_msgSvrId, bi.WK(a.i(this.hqX).field_content));
                return;
            default:
                return;
        }
    }
}
