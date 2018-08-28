package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class s$2 implements OnErrorListener {
    final /* synthetic */ s epU;

    s$2(s sVar) {
        this.epU = sVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if (this.epU.epT != null) {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
            this.epU.epT.zY();
        }
        if (this.epU.epl != null) {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
            this.epU.epl.onError();
        }
        try {
            x.d("MicroMsg.VoicePlayer", "OnErrorListener release");
            this.epU.epS.release();
            this.epU.status = -1;
        } catch (Exception e) {
            x.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.epU.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
        return false;
    }
}
