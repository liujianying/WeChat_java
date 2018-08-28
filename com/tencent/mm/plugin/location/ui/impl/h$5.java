package com.tencent.mm.plugin.location.ui.impl;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.sdk.platformtools.x;

class h$5 implements Runnable {
    final /* synthetic */ h kKh;

    h$5(h hVar) {
        this.kKh = hVar;
    }

    public final void run() {
        FrameLayout frameLayout = (FrameLayout) this.kKh.findViewById(e.mapview_content);
        RelativeLayout relativeLayout = (RelativeLayout) this.kKh.kKc.findViewById(e.location_info_frame);
        if (frameLayout == null) {
            x.w("MicroMsg.TrackMapUI", "mapcontent is null!");
            return;
        }
        LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams.height = frameLayout.getHeight() - relativeLayout.getHeight();
        frameLayout.setLayoutParams(layoutParams);
    }
}
