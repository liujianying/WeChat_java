package com.tencent.mm.modelvoiceaddr.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VoiceSearchLayout$2 implements OnCompletionListener {
    final /* synthetic */ VoiceSearchLayout erE;
    final /* synthetic */ a erF = null;

    VoiceSearchLayout$2(VoiceSearchLayout voiceSearchLayout) {
        this.erE = voiceSearchLayout;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
