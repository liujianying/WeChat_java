package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;

class a$6 implements OnClickListener {
    final /* synthetic */ a uSy;

    a$6(a aVar) {
        this.uSy = aVar;
    }

    public final void onClick(View view) {
        if (this.uSy.getTextEditView().getVisibility() == 0) {
            this.uSy.getPresenter().cfP();
        } else {
            this.uSy.getPresenter().ua();
        }
    }
}
