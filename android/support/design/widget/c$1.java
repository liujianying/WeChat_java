package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class c$1 implements OnClickListener {
    final /* synthetic */ c cM;

    c$1(c cVar) {
        this.cM = cVar;
    }

    public final void onClick(View view) {
        if (this.cM.isShowing()) {
            this.cM.cancel();
        }
    }
}
