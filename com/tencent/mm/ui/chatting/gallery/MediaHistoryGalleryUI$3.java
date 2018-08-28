package com.tencent.mm.ui.chatting.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$k;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.a.c;

class MediaHistoryGalleryUI$3 extends RecyclerView$k {
    private Runnable jCG = new 1(this);
    final /* synthetic */ MediaHistoryGalleryUI tXF;

    MediaHistoryGalleryUI$3(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.tXF = mediaHistoryGalleryUI;
    }

    private void fj(boolean z) {
        if (z) {
            MediaHistoryGalleryUI.b(this.tXF).removeCallbacks(this.jCG);
            if (MediaHistoryGalleryUI.b(this.tXF).getVisibility() != 0) {
                MediaHistoryGalleryUI.b(this.tXF).clearAnimation();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.tXF.mController.tml, R.a.fast_faded_in);
                MediaHistoryGalleryUI.b(this.tXF).setVisibility(0);
                MediaHistoryGalleryUI.b(this.tXF).startAnimation(loadAnimation);
                return;
            }
            return;
        }
        MediaHistoryGalleryUI.b(this.tXF).removeCallbacks(this.jCG);
        MediaHistoryGalleryUI.b(this.tXF).postDelayed(this.jCG, 256);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        a aVar = (a) MediaHistoryGalleryUI.c(this.tXF).cwv();
        c EY = aVar.EY(((LinearLayoutManager) MediaHistoryGalleryUI.c(this.tXF).cwu()).fi());
        if (EY != null) {
            MediaHistoryGalleryUI.b(this.tXF).setText(bi.aG(aVar.gy(EY.timeStamp), ""));
        }
    }

    public final void e(RecyclerView recyclerView, int i) {
        if (1 == i) {
            fj(true);
            HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.d(this.tXF));
            MediaHistoryGalleryUI.a(this.tXF, HardCoderJNI.startPerformance(HardCoderJNI.hcMediaGalleryScrollEnable, HardCoderJNI.hcMediaGalleryScrollDelay, HardCoderJNI.hcMediaGalleryScrollCPU, HardCoderJNI.hcMediaGalleryScrollIO, HardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, HardCoderJNI.hcMediaGalleryScrollTimeout, 703, HardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI"));
        } else if (i == 0) {
            fj(false);
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) recyclerView.getLayoutManager()).fi() == 0 && !MediaHistoryGalleryUI.e(this.tXF)) {
                MediaHistoryGalleryUI.c(this.tXF).x(false, -1);
            }
            MediaHistoryGalleryUI.f(this.tXF);
            o.Pj().br(i);
        }
    }
}
