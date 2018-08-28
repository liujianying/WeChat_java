package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.b.b;

public class r$a extends b {
    final /* synthetic */ r jyX;

    public r$a(r rVar) {
        this.jyX = rVar;
        super(rVar);
    }

    public final boolean a(Context context, a aVar) {
        r rVar = (r) aVar;
        a(this.jyX.jrx.jrV, rVar.fyJ);
        d.e(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", rVar.username).putExtra("finish_direct", true));
        return true;
    }
}
