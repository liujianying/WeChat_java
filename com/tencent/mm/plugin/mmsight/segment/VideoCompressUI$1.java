package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class VideoCompressUI$1 implements Runnable {
    final /* synthetic */ VideoCompressUI lmY;

    VideoCompressUI$1(VideoCompressUI videoCompressUI) {
        this.lmY = videoCompressUI;
    }

    public final void run() {
        VideoCompressUI.a(this.lmY, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
        if (VideoCompressUI.a(this.lmY) == null) {
            x.e("VideoCompressUI", "VideoSendPreprocessTask para is null");
            this.lmY.setResult(0);
            this.lmY.finish();
            return;
        }
        e.post(VideoCompressUI.b(this.lmY), "video_remuxing_if_needed");
    }
}
