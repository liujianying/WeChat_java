package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;

class g$2 implements e {
    final /* synthetic */ g tYD;

    g$2(g gVar) {
        this.tYD = gVar;
    }

    public final void a(int i, b bVar) {
        Context context = this.tYD.mContext;
        String str = this.tYD.gBf;
        long j = bVar.bJC;
        if (str == null) {
            x.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        au.HU();
        x.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[]{Long.valueOf(c.FT().dW(j).field_msgId)});
        if (s.fq(str)) {
            au.HU();
            if (c.Ga().ih(str) == null) {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[]{str});
                h.a(context, context.getString(R.l.remind_not_found_room), context.getString(R.l.tip_title), null);
                return;
            }
        }
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null || !a.gd(Yg.field_type)) {
            if (Yg == null) {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[]{str});
            } else {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[]{str});
            }
            h.a(context, context.getString(R.l.remind_not_found_room), context.getString(R.l.tip_title), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ezn.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), context);
    }

    public final void a(View view, int i, b bVar) {
    }
}
