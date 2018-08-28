package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.an.1;
import com.tencent.mm.ui.chatting.an.2;
import com.tencent.mm.ui.chatting.b.j.5;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.k;
import java.util.List;

class j$5$2 implements d {
    final /* synthetic */ 5 tOW;

    j$5$2(5 5) {
        this.tOW = 5;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 0) {
            j.a(this.tOW.tOS, true);
            j.f(this.tOW.tOS);
        } else if (2 == menuItem.getItemId()) {
            Context context = this.tOW.tOS.bAG.tTq.getContext();
            ab e = j.e(this.tOW.tOS);
            List c = j.c(this.tOW.tOS);
            boolean d = j.d(this.tOW.tOS);
            if (!(c == null || c.size() == 0)) {
                if (j.dB(c)) {
                    x.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                    h.a(context, context.getString(R.l.contain_undownload_msg_send), "", new 1(), null);
                } else if (j.a(c, null)) {
                    an.a(context, e, c, d);
                } else {
                    x.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                    h.a(context, context.getString(R.l.invalid_friend_msg_warning), "", context.getString(R.l.retransmit), context.getString(R.l.app_cancel), new 2(context, e, c, d), null);
                }
            }
            this.tOW.tOS.cuQ();
            return;
        } else {
            j.a(this.tOW.tOS, false);
        }
        k.a(this.tOW.tOS.bAG.tTq.getContext(), j.c(this.tOW.tOS), j.d(this.tOW.tOS), j.e(this.tOW.tOS).field_username, this.tOW.tOS);
    }
}
