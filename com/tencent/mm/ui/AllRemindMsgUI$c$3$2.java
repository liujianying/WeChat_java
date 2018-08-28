package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.AllRemindMsgUI.c.3;
import com.tencent.mm.ui.base.n.d;

class AllRemindMsgUI$c$3$2 implements d {
    final /* synthetic */ View gvo;
    final /* synthetic */ 3 tgl;

    AllRemindMsgUI$c$3$2(3 3, View view) {
        this.tgl = 3;
        this.gvo = view;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[]{(AllRemindMsgUI.d) this.gvo.getTag()});
        au.DF().a(new com.tencent.mm.modelsimple.x(2, r0.tgm), 0);
    }
}
