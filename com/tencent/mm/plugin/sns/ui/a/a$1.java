package com.tencent.mm.plugin.sns.ui.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i.f;

class a$1 implements OnTouchListener {
    final /* synthetic */ a oiE;

    a$1(a aVar) {
        this.oiE = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setTag(f.touch_loc, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        }
        return false;
    }
}
