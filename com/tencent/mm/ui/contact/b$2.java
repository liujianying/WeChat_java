package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class b$2 implements OnTouchListener {
    final /* synthetic */ b uhG;

    b$2(b bVar) {
        this.uhG = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (b.a(this.uhG) instanceof MMActivity) {
            ((MMActivity) b.a(this.uhG)).YC();
        }
        return false;
    }
}
