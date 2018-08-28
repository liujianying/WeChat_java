package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$31 implements OnTouchListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$31(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.odw.bCa();
            if (SnsTimeLineUI.h(this.odw).kww != null && SnsTimeLineUI.h(this.odw).kww.getFirstVisiblePosition() == 0) {
                x.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                SnsTimeLineUI.m(this.odw).setVisibility(0);
            }
            SnsTimeLineUI.D(this.odw).bEk();
        }
        if (motionEvent.getAction() == 0) {
            if (SnsTimeLineUI.h(this.odw).kww != null && SnsTimeLineUI.h(this.odw).kww.getFirstVisiblePosition() == 0) {
                SnsTimeLineUI.m(this.odw).setVisibility(0);
            }
            SnsTimeLineUI.g(this.odw).bBQ();
            SnsTimeLineUI.g(this.odw).nLO.bEG();
        }
        if (this.odw.nUq != null) {
            this.odw.nUq.bwM();
        }
        return false;
    }
}
