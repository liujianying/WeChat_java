package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$1 implements OnMenuItemClickListener {
    final /* synthetic */ a unz;

    BizConversationUI$a$1(a aVar) {
        this.unz = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (p.zO(0)) {
            ((i) g.l(i.class)).a(ad.getContext(), new 1(this));
        } else {
            x.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
        }
        return true;
    }
}
