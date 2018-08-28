package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class VideoRecorderUI$10 implements OnClickListener {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$10(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.ovr, VideoRecorderPreviewUI.class);
        intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(this.ovr).filename);
        intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(this.ovr).ngs.enM);
        intent.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(this.ovr).fileSize);
        intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(this.ovr));
        intent.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(this.ovr));
        this.ovr.startActivityForResult(intent, 0);
        this.ovr.overridePendingTransition(0, 0);
    }
}
