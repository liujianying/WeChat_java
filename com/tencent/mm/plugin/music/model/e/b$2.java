package com.tencent.mm.plugin.music.model.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements OnSeekCompleteListener {
    final /* synthetic */ b lzt;

    b$2(b bVar) {
        this.lzt = bVar;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.lzt.epS != null && this.lzt.epS.isPlaying()) {
            x.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try {
                this.lzt.epS.start();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
            }
        }
    }
}
