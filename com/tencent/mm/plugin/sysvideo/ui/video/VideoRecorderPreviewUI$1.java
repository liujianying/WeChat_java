package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoRecorderPreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ VideoRecorderPreviewUI ouS;

    VideoRecorderPreviewUI$1(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.ouS = videoRecorderPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ouS.finish();
        this.ouS.overridePendingTransition(0, 0);
        return true;
    }
}
