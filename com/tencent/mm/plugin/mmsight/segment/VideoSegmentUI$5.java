package com.tencent.mm.plugin.mmsight.segment;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoSegmentUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$5(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lnn.finish();
        VideoSegmentUI.b(this.lnn);
        return true;
    }
}
