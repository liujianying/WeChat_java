package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7;
import com.tencent.mm.plugin.mmsight.segment.k.f;

class VideoSegmentUI$7$1 implements Runnable {
    final /* synthetic */ 7 lnp;

    VideoSegmentUI$7$1(7 7) {
        this.lnp = 7;
    }

    public final void run() {
        if (this.lnp.lnn.eHw != null) {
            this.lnp.lnn.eHw.dismiss();
        }
        if (this.lnp.lnn.lne != null) {
            this.lnp.lnn.lne.gv(false);
        }
        Toast.makeText(this.lnp.lnn, f.mmsight_clip_failed, 1).show();
    }
}
