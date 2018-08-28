package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

class g$3 implements OnTouchListener {
    final /* synthetic */ g uqa;

    g$3(g gVar) {
        this.uqa = gVar;
    }

    @TargetApi(21)
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.findViewById(R.h.conversation_item_ll).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
        return false;
    }
}
