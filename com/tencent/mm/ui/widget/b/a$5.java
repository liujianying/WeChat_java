package com.tencent.mm.ui.widget.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.WebView;

class a$5 implements OnTouchListener {
    final /* synthetic */ a uKZ;

    a$5(a aVar) {
        this.uKZ = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                a.Gz((int) motionEvent.getRawX());
                a.GA((int) motionEvent.getRawY());
                a.b(this.uKZ, a.e(this.uKZ));
                a.cAN();
                ao.t("popmenu view set , x_down=" + a.bMR() + "y_down=" + a.cAO(), new Object[0]);
                break;
        }
        return false;
    }
}
