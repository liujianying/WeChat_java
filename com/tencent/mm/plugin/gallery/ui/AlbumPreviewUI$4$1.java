package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.4;

class AlbumPreviewUI$4$1 implements Runnable {
    final /* synthetic */ 4 jCH;

    AlbumPreviewUI$4$1(4 4) {
        this.jCH = 4;
    }

    public final void run() {
        AlbumPreviewUI.x(this.jCH.jCE).startAnimation(AnimationUtils.loadAnimation(this.jCH.jCE.mController.tml, R.a.fast_faded_out));
        AlbumPreviewUI.x(this.jCH.jCE).setVisibility(8);
    }
}
