package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.viewitems.s.1;

class s$1$1 implements c {
    final /* synthetic */ View gvo;
    final /* synthetic */ 1 uco;

    s$1$1(1 1, View view) {
        this.uco = 1;
        this.gvo = view;
    }

    public final void a(l lVar) {
        lVar.add(0, 2, 0, this.gvo.getResources().getString(R.l.notify_message_settings_complain));
    }
}
