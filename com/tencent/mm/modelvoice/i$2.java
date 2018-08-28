package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnErrorListener {
    final /* synthetic */ i epi;

    i$2(i iVar) {
        this.epi = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.SilkPlayer", "onError");
        if (i.a(this.epi) != null) {
            i.a(this.epi).zY();
        }
        if (i.e(this.epi) != null) {
            i.e(this.epi).onError();
        }
        try {
            i.a(this.epi, -1);
            if (i.b(this.epi) != null) {
                x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                i.b(this.epi).stop();
                i.b(this.epi).release();
                i.c(this.epi);
            }
        } catch (Exception e) {
            x.e("MicroMsg.SilkPlayer", "setErrorListener File[" + i.d(this.epi) + "] ErrMsg[" + e.getStackTrace() + "]");
        }
        return false;
    }
}
