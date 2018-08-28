package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.mm.plugin.map.a.e;

class h$1 implements OnInflateListener {
    final /* synthetic */ h kKh;

    h$1(h hVar) {
        this.kKh = hVar;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        view.findViewById(e.location_info_frame).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}
