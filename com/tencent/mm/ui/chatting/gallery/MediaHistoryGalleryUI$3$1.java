package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.3;

class MediaHistoryGalleryUI$3$1 implements Runnable {
    final /* synthetic */ 3 tXG;

    MediaHistoryGalleryUI$3$1(3 3) {
        this.tXG = 3;
    }

    public final void run() {
        MediaHistoryGalleryUI.b(this.tXG.tXF).startAnimation(AnimationUtils.loadAnimation(this.tXG.tXF.mController.tml, R.a.fast_faded_out));
        MediaHistoryGalleryUI.b(this.tXG.tXF).setVisibility(8);
    }
}
