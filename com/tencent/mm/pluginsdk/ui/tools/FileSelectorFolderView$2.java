package com.tencent.mm.pluginsdk.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FileSelectorFolderView$2 implements AnimationListener {
    final /* synthetic */ FileSelectorFolderView qSn;

    FileSelectorFolderView$2(FileSelectorFolderView fileSelectorFolderView) {
        this.qSn = fileSelectorFolderView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FileSelectorFolderView.a(this.qSn, true);
        FileSelectorFolderView.b(this.qSn);
    }
}
