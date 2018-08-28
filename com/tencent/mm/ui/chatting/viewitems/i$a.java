package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t$d;

public class i$a extends t$d {
    i$a(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        au.HU();
        if (c.isSDCardAvailable()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.tKy.tTq.getContext(), auVar.bXQ);
            h.mEJ.h(11592, new Object[]{Integer.valueOf(0)});
        }
    }
}
