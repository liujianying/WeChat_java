package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.platformtools.ai;

class SelectConversationUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$17(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SelectConversationUI.n(this.uEC)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_User", ai.c(SelectConversationUI.o(this.uEC), ","));
        Intent intent2 = (Intent) this.uEC.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (intent2 != null) {
            SelectConversationUI.a(this.uEC, intent, intent2);
        } else if (SelectConversationUI.p(this.uEC)) {
            SelectConversationUI.a(this.uEC, intent);
            this.uEC.finish();
        } else {
            SelectConversationUI.b(this.uEC, intent);
        }
        return true;
    }
}
