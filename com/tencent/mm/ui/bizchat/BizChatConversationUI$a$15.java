package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.mm.ac.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$15 implements d {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$15(a aVar) {
        this.tEC = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.ac.a.a bd;
        switch (menuItem.getItemId()) {
            case 0:
                a.a(this.tEC, a.e(this.tEC));
                return;
            case 1:
                bd = z.Nb().bd(a.e(this.tEC));
                bd.field_unReadCount = 1;
                bd.field_atCount = 0;
                z.Nb().b(bd);
                b.ehL.K(bd.field_brandUserName, true);
                return;
            case 2:
                z.Nb().bf(a.e(this.tEC));
                b.ehL.K(z.Nb().bd(a.e(this.tEC)).field_brandUserName, false);
                return;
            case 3:
                bd = z.Nb().bd(a.e(this.tEC));
                if (z.Nb().bg(a.e(this.tEC))) {
                    z.Nb().bi(a.e(this.tEC));
                    b.ehL.c(true, bd.field_brandUserName, false);
                    return;
                }
                z.Nb().bh(a.e(this.tEC));
                b.ehL.c(true, bd.field_brandUserName, true);
                return;
            default:
                return;
        }
    }
}
