package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.7;

class VideoRecorderUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 ovs;

    VideoRecorderUI$7$1(7 7) {
        this.ovs = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        VideoRecorderUI.m(this.ovs.ovr).setImageResource(R.g.video_recorder_stop_btn);
        VideoRecorderUI.n(this.ovs.ovr);
    }
}
