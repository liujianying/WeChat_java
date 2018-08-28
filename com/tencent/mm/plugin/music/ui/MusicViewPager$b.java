package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MusicViewPager$b extends SimpleOnGestureListener {
    final /* synthetic */ MusicViewPager lBi;

    private MusicViewPager$b(MusicViewPager musicViewPager) {
        this.lBi = musicViewPager;
    }

    /* synthetic */ MusicViewPager$b(MusicViewPager musicViewPager, byte b) {
        this(musicViewPager);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f2) < Math.abs(f)) {
            return true;
        }
        return false;
    }
}
