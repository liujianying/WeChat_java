package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends OrientationEventListener {
    private int lfl = -1;
    private int lfm = -1;
    private long lfn = 0;
    private long lfo = 0;
    private int orientation = -1;
    a ozK;

    public b(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i) {
        if (bi.bI(this.lfo) < 2000) {
            x.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            return;
        }
        x.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", new Object[]{Integer.valueOf(i)});
        if (Math.abs(this.lfl - i) >= 60 && bi.bI(this.lfn) >= 1000) {
            this.lfl = i;
            this.lfn = bi.VG();
            if (i <= 60 || i >= 300) {
                if (i <= 30 || i >= 330) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > 150) {
                if (i < 120 || i > 240) {
                    if (i >= 210 && i <= 330 && i >= 240 && i <= 300) {
                        this.orientation = 270;
                    }
                } else if (i >= 150 && i <= 210) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= 120) {
                this.orientation = 90;
            }
            if (this.ozK != null) {
                this.ozK.sO(this.orientation);
            }
        }
    }

    public final void enable() {
        super.enable();
        this.lfo = bi.VG();
    }
}
