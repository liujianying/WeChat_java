package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class t$f implements OnTouchListener {
    private int[] tKG = new int[2];

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                this.tKG[0] = (int) motionEvent.getRawX();
                this.tKG[1] = (int) motionEvent.getRawY();
                view.setTag(R.h.touch_loc, this.tKG);
                break;
        }
        return false;
    }
}
