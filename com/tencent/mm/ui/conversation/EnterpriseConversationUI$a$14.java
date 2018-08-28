package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$14 implements OnMenuItemClickListener {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$14(a aVar) {
        this.uqA = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("enterprise_biz_name", a.c(this.uqA));
        intent.addFlags(67108864);
        d.b(this.uqA.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", intent);
        return true;
    }
}
