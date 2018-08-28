package com.tencent.mm.ui.widget.snackbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a uME;

    a$1(a aVar) {
        this.uME = aVar;
    }

    public final void onClick(View view) {
        if (this.uME.uMB != null && this.uME.uMA.isShowing()) {
            this.uME.uMB.aMj();
        }
        this.uME.mHandler.postDelayed(new 1(this), 100);
    }
}
