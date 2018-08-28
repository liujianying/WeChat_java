package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.gallery.j.1;

class j$1$2 implements Runnable {
    final /* synthetic */ 1 tXr;

    j$1$2(1 1) {
        this.tXr = 1;
    }

    public final void run() {
        if (this.tXr.tXq.tWW != null && this.tXr.tXq.tWW.getVisibility() != 0) {
            if (this.tXr.tXq.tWW.getTag() != null && (this.tXr.tXq.tWW.getTag() instanceof r)) {
                r rVar = (r) this.tXr.tXq.tWW.getTag();
                if (rVar.enV != null && !bi.oW(rVar.enV.dyJ)) {
                    this.tXr.tXq.tWW.setVisibility(8);
                    return;
                } else if (!(rVar.enV == null || bi.oW(rVar.enV.dyM) || bi.oW(rVar.enV.dyN))) {
                    this.tXr.tXq.tWW.setVisibility(8);
                    return;
                }
            }
            this.tXr.tXq.tWW.setVisibility(0);
            this.tXr.tXq.tWW.startAnimation(AnimationUtils.loadAnimation(this.tXr.tXq.tWW.getContext(), R.a.fast_faded_in));
        }
    }
}
