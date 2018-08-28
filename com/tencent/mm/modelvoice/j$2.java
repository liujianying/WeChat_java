package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements OnErrorListener {
    final /* synthetic */ j epy;

    j$2(j jVar) {
        this.epy = jVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.SpeexPlayer", "onError");
        if (this.epy.bFu != null) {
            this.epy.bFu.zY();
        }
        if (this.epy.epl != null) {
            this.epy.epl.onError();
        }
        try {
            this.epy.status = -1;
            this.epy.TG();
            try {
                j.a(this.epy);
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.epy.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
        }
        return false;
    }
}
