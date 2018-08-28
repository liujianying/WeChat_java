package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;

public class b$d extends d {
    private b tZx;

    public b$d(a aVar, b bVar) {
        super(aVar);
        this.tZx = bVar;
    }

    public void a(View view, a aVar, bd bdVar) {
        view.getTag();
        this.tZx.b(view, aVar, bdVar);
    }
}
