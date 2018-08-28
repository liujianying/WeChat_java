package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.viewitems.s.a;

class s$a$1 implements c {
    final /* synthetic */ View gvo;
    final /* synthetic */ a ucG;

    s$a$1(a aVar, View view) {
        this.ucG = aVar;
        this.gvo = view;
    }

    public final void a(l lVar) {
        lVar.add(0, 1, 0, this.gvo.getResources().getString(R.l.notify_message_settings_complain));
    }
}
