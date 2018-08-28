package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.au;

public abstract class t$d implements OnClickListener {
    public a tKy;

    public abstract void a(View view, a aVar, bd bdVar);

    public t$d(a aVar) {
        this.tKy = aVar;
    }

    public final void onClick(View view) {
        bd bdVar = ((au) view.getTag()).bXQ;
        if (bdVar != null) {
            a(view, this.tKy, bdVar);
        }
    }
}
