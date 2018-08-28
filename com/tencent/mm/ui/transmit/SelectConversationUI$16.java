package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class SelectConversationUI$16 implements OnMenuItemClickListener {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$16(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SelectConversationUI.a(this.uEC, !SelectConversationUI.a(this.uEC));
        this.uEC.cyp().mk(SelectConversationUI.a(this.uEC));
        this.uEC.ukb.mk(SelectConversationUI.a(this.uEC));
        SelectConversationUI.k(this.uEC);
        SelectConversationUI.m(this.uEC).setText(!SelectConversationUI.a(this.uEC) ? SelectConversationUI.l(this.uEC) : R.l.select_more_contact);
        return true;
    }
}
