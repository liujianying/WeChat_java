package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;

class BizTimeLineUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$12(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("biz_from_scene", 2);
        d.e(this.hst, ".ui.conversation.BizConversationUI", intent);
        return true;
    }
}
