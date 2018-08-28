package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class c$4 implements OnTouchListener {
    final /* synthetic */ c fTi;
    final /* synthetic */ boolean fTl;
    final /* synthetic */ ImageView fTm;

    c$4(c cVar, boolean z, ImageView imageView) {
        this.fTi = cVar;
        this.fTl = z;
        this.fTm = imageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fTl) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.fTm.setColorFilter(Color.parseColor("#88888888"));
            } else if (action == 3 || action == 1) {
                this.fTm.clearColorFilter();
            }
        }
        return false;
    }
}
