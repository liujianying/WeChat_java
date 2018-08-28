package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class k$3 implements OnTouchListener {
    final /* synthetic */ k ujC;

    k$3(k kVar) {
        this.ujC = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (k.d(this.ujC) instanceof MMActivity) {
            ((MMActivity) k.d(this.ujC)).YC();
        }
        return false;
    }
}
