package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$2 implements OnCancelListener {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$2(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
        if (VideoRecorderUI.h(this.ovr) != null) {
            VideoRecorderUI.u(this.ovr);
            VideoRecorderUI.v(this.ovr).setVisibility(0);
            VideoRecorderUI.w(this.ovr).setVisibility(0);
        }
    }
}
