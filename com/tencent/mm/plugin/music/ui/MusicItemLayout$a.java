package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.plugin.music.ui.b.a;

class MusicItemLayout$a extends SimpleOnGestureListener {
    final /* synthetic */ MusicItemLayout lAy;

    private MusicItemLayout$a(MusicItemLayout musicItemLayout) {
        this.lAy = musicItemLayout;
    }

    /* synthetic */ MusicItemLayout$a(MusicItemLayout musicItemLayout, byte b) {
        this(musicItemLayout);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f2) > Math.abs(f)) {
            a aVar = (a) this.lAy.getTag();
            if (f2 > 0.0f) {
                aVar.biG();
            } else {
                aVar.biF();
            }
        }
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        a aVar = (a) this.lAy.getTag();
        if (aVar.biE()) {
            if (motionEvent.getY() <= ((float) aVar.lAK.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                aVar.biH();
            }
        } else if (motionEvent.getY() >= aVar.lAN.getY() - 100.0f && motionEvent.getY() < ((float) aVar.lAN.getMeasuredHeight()) + aVar.lAN.getY()) {
            aVar.biH();
        }
        return false;
    }
}
