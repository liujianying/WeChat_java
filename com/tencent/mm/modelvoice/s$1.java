package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class s$1 implements OnCompletionListener {
    final /* synthetic */ s epU;

    s$1(s sVar) {
        this.epU = sVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if (this.epU.epT != null) {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
            this.epU.epT.zY();
        }
        if (this.epU.epk != null) {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
            this.epU.epk.wd();
        }
        try {
            x.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
            this.epU.epS.release();
            this.epU.status = 0;
        } catch (Exception e) {
            x.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.epU.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
