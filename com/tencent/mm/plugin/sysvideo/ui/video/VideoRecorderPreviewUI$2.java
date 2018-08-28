package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class VideoRecorderPreviewUI$2 extends ag {
    final /* synthetic */ VideoRecorderPreviewUI ouS;

    VideoRecorderPreviewUI$2(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.ouS = videoRecorderPreviewUI;
    }

    public final void handleMessage(Message message) {
        this.ouS.getWindow().setFlags(1024, 1024);
        this.ouS.mController.hideTitleView();
    }
}
