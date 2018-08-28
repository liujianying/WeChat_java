package com.tencent.mm.view;

import com.tencent.mm.view.footer.SelectColorBar.a;

class a$8 implements a {
    final /* synthetic */ a uSy;

    a$8(a aVar) {
        this.uSy = aVar;
    }

    public final void GO(int i) {
        if (a.c(this.uSy).isChecked()) {
            a.c(this.uSy).setTag(Integer.valueOf(i));
            a.b(this.uSy).setTextBackground(i);
            return;
        }
        a.b(this.uSy).setTextColor(i);
    }
}
