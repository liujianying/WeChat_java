package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.su;
import com.tencent.mm.sdk.b.a;

class s$8 implements OnMenuItemClickListener {
    final /* synthetic */ s tQv;

    s$8(s sVar) {
        this.tQv = sVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        su suVar = new su();
        suVar.cdE.bOh = 5;
        suVar.cdE.talker = this.tQv.bAG.oLT.field_username;
        suVar.cdE.context = this.tQv.bAG.tTq.getContext();
        if (menuItem.getItemId() == 1) {
            suVar.cdE.cdz = 4;
        } else if (menuItem.getItemId() == 2) {
            suVar.cdE.cdz = 2;
        }
        a.sFg.m(suVar);
        return true;
    }
}
