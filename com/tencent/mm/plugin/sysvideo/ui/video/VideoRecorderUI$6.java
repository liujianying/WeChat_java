package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoRecorderUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$6(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VideoRecorderUI.j(this.ovr);
        return true;
    }
}
