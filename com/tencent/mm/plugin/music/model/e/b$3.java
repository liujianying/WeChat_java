package com.tencent.mm.plugin.music.model.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.plugin.music.model.e.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements OnPreparedListener {
    final /* synthetic */ b lzt;

    b$3(b bVar) {
        this.lzt = bVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (this.lzt.epS != null) {
            x.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
            try {
                this.lzt.epS.start();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
            }
            this.lzt.lhj = false;
            this.lzt.onStart();
            if (this.lzt.lzs != null) {
                this.lzt.lzs.isStop = true;
            }
            this.lzt.lzs = new a(this.lzt, (byte) 0);
            a aVar = this.lzt.lzs;
            aVar.isStop = false;
            e.post(aVar, "music_play_progress_runnable");
        }
    }
}
