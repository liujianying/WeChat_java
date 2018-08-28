package com.tencent.mm.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.view.footer.SelectColorBar;

class a$7 implements OnCheckedChangeListener {
    final /* synthetic */ a uSy;
    final /* synthetic */ SelectColorBar uSz;

    a$7(a aVar, SelectColorBar selectColorBar) {
        this.uSy = aVar;
        this.uSz = selectColorBar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.uSz.setSelectColor(((Integer) a.c(this.uSy).getTag()).intValue());
            a.b(this.uSy).setTextBackground(((Integer) a.c(this.uSy).getTag()).intValue());
            return;
        }
        a.c(this.uSy).setTag(Integer.valueOf(this.uSz.getCurColor()));
        a.b(this.uSy).setTextBackground(0);
    }
}
