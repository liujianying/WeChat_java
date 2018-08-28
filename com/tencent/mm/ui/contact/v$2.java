package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class v$2 implements OnTouchListener {
    final /* synthetic */ v uli;

    v$2(v vVar) {
        this.uli = vVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (v.b(this.uli) instanceof MMActivity) {
            ((MMActivity) v.b(this.uli)).YC();
        }
        return false;
    }
}
