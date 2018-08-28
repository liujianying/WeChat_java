package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import java.util.List;

class VideoSegmentUI$8 implements Runnable {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$8(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void run() {
        List<FileEntry> H = FileOp.H(CaptureMMProxy.getInstance().getAccVideoPath(), false);
        if (H != null && H.size() != 0) {
            for (FileEntry fileEntry : H) {
                if (fileEntry.name != null && ((fileEntry.name.contains("vsg_output_") && !fileEntry.name.contains(VideoSegmentUI.g(this.lnn))) || (fileEntry.name.contains("vsg_thumb_") && !fileEntry.name.contains(VideoSegmentUI.l(this.lnn))))) {
                    e.deleteFile(fileEntry.name);
                }
            }
        }
    }
}
