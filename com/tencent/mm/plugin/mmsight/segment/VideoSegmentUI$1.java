package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$1 implements Runnable {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$1(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void run() {
        x.i("MicroMsg.VideoSegmentUI", "has connect");
        if (CaptureMMProxy.getInstance() != null) {
            q.fd(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        VideoSegmentUI.a(this.lnn);
    }
}
