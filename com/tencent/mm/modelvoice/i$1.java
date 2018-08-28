package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements OnCompletionListener {
    final /* synthetic */ i epi;

    i$1(i iVar) {
        this.epi = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (i.a(this.epi) != null) {
            x.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
            i.a(this.epi).zY();
        }
        try {
            i.a(this.epi, 0);
            if (i.b(this.epi) != null) {
                x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                i.b(this.epi).stop();
                i.b(this.epi).release();
                i.c(this.epi);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.SilkPlayer", "setCompletion File[" + i.d(this.epi) + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
