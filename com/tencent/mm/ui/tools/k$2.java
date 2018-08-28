package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements OnLongClickListener {
    final /* synthetic */ k uAA;
    final /* synthetic */ OnCreateContextMenuListener uAz;

    k$2(k kVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.uAA = kVar;
        this.uAz = onCreateContextMenuListener;
    }

    public final boolean onLongClick(View view) {
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        k.a(this.uAA).clear();
        this.uAz.onCreateContextMenu(k.a(this.uAA), view, null);
        this.uAA.bEo();
        if (k.a(this.uAA).size() > 0) {
            return true;
        }
        return false;
    }
}
