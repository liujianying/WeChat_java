package com.tencent.mm.plugin.music.model.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements OnErrorListener {
    final /* synthetic */ b lzt;

    b$4(b bVar) {
        this.lzt = bVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.lzt.gP(false);
        return false;
    }
}
