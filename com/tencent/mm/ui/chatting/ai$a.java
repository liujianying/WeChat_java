package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

@TargetApi(14)
public class ai$a implements OnHoverListener {
    private ai$b tMD;

    public ai$a(ai$b ai_b) {
        this.tMD = ai_b;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.tMD != null) {
            return this.tMD.e(view, motionEvent);
        }
        return false;
    }
}
