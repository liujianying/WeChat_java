package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.x;

class SmileySubGrid$b extends SmileySubGrid$d implements Runnable {
    final /* synthetic */ SmileySubGrid uTE;
    View uTF;
    int uux;

    private SmileySubGrid$b(SmileySubGrid smileySubGrid) {
        this.uTE = smileySubGrid;
        super(smileySubGrid, (byte) 0);
    }

    /* synthetic */ SmileySubGrid$b(SmileySubGrid smileySubGrid, byte b) {
        this(smileySubGrid);
    }

    public final void run() {
        ListAdapter adapter = this.uTE.getAdapter();
        int i = this.uux;
        if (adapter != null && this.uTE.getCount() > 0 && i != -1 && i < adapter.getCount() && czo()) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[]{Integer.valueOf(i), Long.valueOf(adapter.getItemId(i))});
            this.uTE.performItemClick(this.uTF, i, adapter.getItemId(i));
        }
    }
}
