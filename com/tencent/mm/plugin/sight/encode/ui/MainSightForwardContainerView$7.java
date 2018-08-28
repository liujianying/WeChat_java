package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class MainSightForwardContainerView$7 implements OnCompletionListener {
    final /* synthetic */ MainSightForwardContainerView nfL;

    MainSightForwardContainerView$7(MainSightForwardContainerView mainSightForwardContainerView) {
        this.nfL = mainSightForwardContainerView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
