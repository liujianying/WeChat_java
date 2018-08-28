package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class AdVideoPlayerLoadingBar$1 implements OnTouchListener {
    final /* synthetic */ AdVideoPlayerLoadingBar ndw;

    AdVideoPlayerLoadingBar$1(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar) {
        this.ndw = adVideoPlayerLoadingBar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
            this.ndw.fTW = false;
            this.ndw.ndr = motionEvent.getX();
            if (this.ndw.ndh != null) {
                this.ndw.ndh.ajO();
            }
        } else if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            LayoutParams layoutParams = (LayoutParams) this.ndw.ndk.getLayoutParams();
            layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(this.ndw, ((int) (x - this.ndw.ndr)) + layoutParams.leftMargin);
            this.ndw.ndk.setLayoutParams(layoutParams);
            int currentTimeByBarPoint = this.ndw.getCurrentTimeByBarPoint();
            if (this.ndw.ndo > 0) {
                layoutParams = (LayoutParams) this.ndw.ndi.getLayoutParams();
                layoutParams.width = (int) (((((double) currentTimeByBarPoint) * 1.0d) / ((double) this.ndw.ndo)) * ((double) this.ndw.getBarLen()));
                this.ndw.ndi.setLayoutParams(layoutParams);
            }
            this.ndw.ndm.setText(AdVideoPlayerLoadingBar.kT(currentTimeByBarPoint / 60) + ":" + AdVideoPlayerLoadingBar.kT(currentTimeByBarPoint % 60));
            this.ndw.fTW = true;
        } else if (this.ndw.fTW) {
            int currentTimeByBarPoint2 = this.ndw.getCurrentTimeByBarPoint();
            if (this.ndw.ndh != null) {
                x.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + currentTimeByBarPoint2);
                this.ndw.ndh.kV(currentTimeByBarPoint2);
            }
            this.ndw.fTW = false;
        }
        return true;
    }
}
