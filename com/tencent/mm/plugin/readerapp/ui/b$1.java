package com.tencent.mm.plugin.readerapp.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.readerapp.a;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.ui.base.h;

class b$1 implements OnClickListener {
    final /* synthetic */ b mnz;

    b$1(b bVar) {
        this.mnz = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(new 1(this, h.a(this.mnz.context, this.mnz.context.getString(a.g.readerapp_delete_news_ing), false, null)));
    }
}
