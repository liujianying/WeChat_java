package com.tencent.mm.ui.widget.textview;

import android.text.Layout;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnLongClickListener;

class a$2 implements OnLongClickListener {
    final /* synthetic */ a uPp;

    a$2(a aVar) {
        this.uPp = aVar;
    }

    public final boolean onLongClick(View view) {
        a aVar = this.uPp;
        int i = this.uPp.uPf;
        int i2 = this.uPp.uPg;
        aVar.cBn();
        aVar.cBo();
        aVar.ccw = false;
        if (aVar.uOZ == null) {
            aVar.uOZ = new a$b(aVar, true);
        }
        if (aVar.uPa == null) {
            aVar.uPa = new a$b(aVar, false);
        }
        Layout layout = aVar.ih.getLayout();
        if (layout != null) {
            i2 = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), (float) i);
            i = ((int) layout.getPrimaryHorizontal(i2)) > i ? layout.getOffsetToLeftOf(i2) : i2;
        } else {
            i = -1;
        }
        int i3 = i + 1;
        if (aVar.ih.getText() instanceof Spannable) {
            aVar.uPd = (Spannable) aVar.ih.getText();
        }
        if (aVar.uPd != null && i < aVar.ih.getText().length()) {
            aVar.fp(i, i3);
            aVar.a(aVar.uOZ);
            aVar.a(aVar.uPa);
            aVar.cBp();
        }
        return true;
    }
}
