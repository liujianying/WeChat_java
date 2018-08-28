package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

class VideoRecorderUI$7 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$7(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final void onClick(View view) {
        au.HU();
        if (!c.isSDCardAvailable()) {
            s.gH(this.ovr);
        } else if (VideoRecorderUI.k(this.ovr)) {
            VideoRecorderUI.d(this.ovr);
        } else if (VideoRecorderUI.l(this.ovr)) {
            h.a(this.ovr, this.ovr.getString(R.l.video_recorder_restart), this.ovr.getString(R.l.app_tip), new 1(this), new 2(this));
        } else {
            VideoRecorderUI.m(this.ovr).setImageResource(R.g.video_recorder_stop_btn);
            VideoRecorderUI.n(this.ovr);
        }
    }
}
