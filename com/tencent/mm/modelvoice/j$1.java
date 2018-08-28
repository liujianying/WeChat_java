package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements OnCompletionListener {
    final /* synthetic */ j epy;

    j$1(j jVar) {
        this.epy = jVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.epy.bFu != null) {
            this.epy.bFu.zY();
        }
        try {
            this.epy.status = 0;
            this.epy.TG();
            try {
                j.a(this.epy);
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e2)});
            x.e("MicroMsg.SpeexPlayer", "setCompletion File[" + this.epy.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
        }
    }
}
