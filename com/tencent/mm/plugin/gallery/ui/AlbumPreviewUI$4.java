package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$4 implements OnScrollListener {
    final /* synthetic */ AlbumPreviewUI jCE;
    private Runnable jCG = new 1(this);

    AlbumPreviewUI$4(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    private void fj(boolean z) {
        if (z) {
            AlbumPreviewUI.x(this.jCE).removeCallbacks(this.jCG);
            if (AlbumPreviewUI.x(this.jCE).getVisibility() != 0) {
                AlbumPreviewUI.x(this.jCE).setText(AlbumPreviewUI.a(this.jCE).qy(AlbumPreviewUI.y(this.jCE).getFirstVisiblePosition()));
                AlbumPreviewUI.x(this.jCE).clearAnimation();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.jCE.mController.tml, R.a.fast_faded_in);
                AlbumPreviewUI.x(this.jCE).setVisibility(0);
                AlbumPreviewUI.x(this.jCE).startAnimation(loadAnimation);
                return;
            }
            return;
        }
        AlbumPreviewUI.x(this.jCE).removeCallbacks(this.jCG);
        AlbumPreviewUI.x(this.jCE).postDelayed(this.jCG, 256);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        x.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[]{Integer.valueOf(i)});
        if (1 == i) {
            fj(true);
        } else if (i == 0) {
            fj(false);
        }
        if (2 == i) {
            try {
                AlbumPreviewUI.b(this.jCE).qv(AlbumPreviewUI.z(this.jCE));
                AlbumPreviewUI.c(this.jCE, AlbumPreviewUI.b(this.jCE).aRM());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlbumPreviewUI.x(this.jCE).setText(AlbumPreviewUI.a(this.jCE).qy(i));
    }
}
