package com.tencent.mm.ui.tools;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.m;

class k$1 implements OnItemLongClickListener {
    final /* synthetic */ k uAA;
    final /* synthetic */ OnCreateContextMenuListener uAz;

    k$1(k kVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.uAA = kVar;
        this.uAz = onCreateContextMenuListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        k.a(this.uAA).clear();
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        this.uAz.onCreateContextMenu(k.a(this.uAA), view, adapterContextMenuInfo);
        for (MenuItem menuItem : k.a(this.uAA).twb) {
            ((m) menuItem).twe = adapterContextMenuInfo;
        }
        this.uAA.bEo();
        return true;
    }
}
