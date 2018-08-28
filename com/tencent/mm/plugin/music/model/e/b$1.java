package com.tencent.mm.plugin.music.model.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnCompletionListener {
    final /* synthetic */ b lzt;

    b$1(b bVar) {
        this.lzt = bVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
        this.lzt.gQ(true);
    }
}
