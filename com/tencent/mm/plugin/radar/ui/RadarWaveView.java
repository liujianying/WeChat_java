package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarWaveView extends RelativeLayout {
    static final String TAG = TAG;
    public static final a mnj = new a((byte) 0);
    MediaPlayer mng;
    View mnh;
    Animation mni;

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public final void bpO() {
        x.d(TAG, "start wave animation");
        setVisibility(0);
        View view = this.mnh;
        if (view == null) {
            e.cJM();
        }
        view.startAnimation(this.mni);
    }

    public final void bpP() {
        x.d(TAG, "stop wave animation. forces, %d, %d", new Object[]{Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth())});
        setVisibility(4);
        View view = this.mnh;
        if (view == null) {
            e.cJM();
        }
        view.clearAnimation();
    }
}
