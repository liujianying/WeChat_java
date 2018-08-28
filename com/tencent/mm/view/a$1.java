package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a uSy;

    a$1(a aVar) {
        this.uSy = aVar;
    }

    public final void onClick(View view) {
        if (this.uSy.getTextEditView().getVisibility() == 0) {
            this.uSy.getPresenter().a(a.b(this.uSy).getText(), a.b(this.uSy).getCurrentTextColor(), a.c(this.uSy).isChecked() ? ((Integer) a.c(this.uSy).getTag()).intValue() : 0);
        } else {
            this.uSy.getPresenter().onFinish();
        }
    }
}
