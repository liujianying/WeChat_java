package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoRecorderUI$4 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$4(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        VideoRecorderUI.h(this.ovr).ccP();
        this.ovr.finish();
    }
}
