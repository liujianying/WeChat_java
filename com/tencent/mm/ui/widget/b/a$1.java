package com.tencent.mm.ui.widget.b;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;

class a$1 implements OnItemLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener uKY;
    final /* synthetic */ a uKZ;

    a$1(a aVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.uKZ = aVar;
        this.uKY = onCreateContextMenuListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.a(this.uKZ).clear();
        ao.r("registerForPopupMenu AbsListView long click", new Object[0]);
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        this.uKY.onCreateContextMenu(a.a(this.uKZ), view, adapterContextMenuInfo);
        for (MenuItem menuItem : a.a(this.uKZ).twb) {
            ((m) menuItem).twe = adapterContextMenuInfo;
        }
        this.uKZ.bU(0, 0);
        return true;
    }
}
