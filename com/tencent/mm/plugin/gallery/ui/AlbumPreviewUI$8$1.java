package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.8;

class AlbumPreviewUI$8$1 implements Runnable {
    final /* synthetic */ 8 jCK;

    AlbumPreviewUI$8$1(8 8) {
        this.jCK = 8;
    }

    public final void run() {
        AlbumPreviewUI.G(this.jCK.jCE).startAnimation(AnimationUtils.loadAnimation(this.jCK.jCE.mController.tml, R.a.fast_faded_out));
        AlbumPreviewUI.G(this.jCK.jCE).setVisibility(8);
    }
}
