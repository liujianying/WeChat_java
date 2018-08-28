package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.ui.ao;

class a$2 implements OnLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener uKY;
    final /* synthetic */ a uKZ;

    a$2(a aVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.uKZ = aVar;
        this.uKY = onCreateContextMenuListener;
    }

    public final boolean onLongClick(View view) {
        ao.r("registerForPopupMenu normal view long click", new Object[0]);
        a.a(this.uKZ).clear();
        a.a(this.uKZ, view);
        this.uKY.onCreateContextMenu(a.a(this.uKZ), view, null);
        if (view.getTag(f.touch_loc) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(f.touch_loc);
            if (iArr == null) {
                this.uKZ.bU(0, 0);
            } else {
                this.uKZ.bU(iArr[0], iArr[1]);
            }
        } else {
            this.uKZ.bU(0, 0);
        }
        return true;
    }
}
