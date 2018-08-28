package com.tencent.mm.view;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.SmileySubGrid.d;

class SmileySubGrid$a extends d implements Runnable {
    final /* synthetic */ SmileySubGrid uTE;

    private SmileySubGrid$a(SmileySubGrid smileySubGrid) {
        this.uTE = smileySubGrid;
        super(smileySubGrid, (byte) 0);
    }

    /* synthetic */ SmileySubGrid$a(SmileySubGrid smileySubGrid, byte b) {
        this(smileySubGrid);
    }

    public final void run() {
        int i = this.uTE.QC;
        View childAt = this.uTE.getChildAt(i - this.uTE.getFirstVisiblePosition());
        if (childAt != null) {
            int i2 = this.uTE.QC;
            long itemId = this.uTE.getAdapter().getItemId(this.uTE.QC);
            if (czo()) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(itemId)});
                SmileySubGrid.a(this.uTE, childAt, i);
                this.uTE.VS = -1;
                this.uTE.ttn = 5;
                this.uTE.setScrollEnable(false);
            }
        }
    }
}
