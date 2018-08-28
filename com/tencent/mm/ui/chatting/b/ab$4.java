package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.c.a;
import java.util.LinkedList;

class ab$4 implements d {
    final /* synthetic */ ab tRg;
    final /* synthetic */ LinkedList tRi;
    final /* synthetic */ String tRj;

    ab$4(ab abVar, LinkedList linkedList, String str) {
        this.tRg = abVar;
        this.tRi = linkedList;
        this.tRj = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                ((e) this.tRg.bAG.O(e.class)).aw(this.tRi);
                return;
            case 1:
                kc kcVar = new kc();
                a aVar = this.tRg.bAG;
                Context context = this.tRg.bAG.tTq.getContext();
                this.tRg.bAG.tTq.getMMResources().getString(R.l.app_tip);
                aVar.d(context, this.tRg.bAG.tTq.getMMResources().getString(R.l.room_delete_member_canceling), new 1(this, kcVar));
                kcVar.bUs.chatroomName = this.tRg.bAG.oLT.field_username;
                kcVar.bUs.bUu = this.tRj;
                com.tencent.mm.sdk.b.a.sFg.m(kcVar);
                return;
            default:
                return;
        }
    }
}
