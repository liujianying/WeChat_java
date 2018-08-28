package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class g$a$4 implements OnCompletionListener {
    final /* synthetic */ String dat;
    final /* synthetic */ MediaPlayer hUb;
    final /* synthetic */ OnCompletionListener hUd;

    g$a$4(String str, MediaPlayer mediaPlayer, OnCompletionListener onCompletionListener) {
        this.dat = str;
        this.hUb = mediaPlayer;
        this.hUd = onCompletionListener;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        String str = "MicroMsg.F2fRcvVoiceListener";
        String str2 = "play completion mp:%d  path:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
        objArr[1] = this.dat;
        x.i(str, str2, objArr);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.hUb != null) {
            this.hUb.release();
        }
        if (this.hUd != null) {
            this.hUd.onCompletion(mediaPlayer);
        }
    }
}
