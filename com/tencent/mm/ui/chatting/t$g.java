package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.viewitems.au;

public class t$g extends d {
    public t$g(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        Intent intent = new Intent();
        intent.putExtra("geta8key_username", aVar.getTalkerUserName());
        intent.putExtra("rawUrl", auVar.cGB);
        com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
