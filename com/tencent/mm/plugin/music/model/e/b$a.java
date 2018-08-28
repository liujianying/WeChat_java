package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.sdk.platformtools.x;

class b$a implements Runnable {
    boolean isStop;
    final /* synthetic */ b lzt;

    private b$a(b bVar) {
        this.lzt = bVar;
        this.isStop = true;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final void run() {
        x.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
        while (!this.isStop) {
            try {
                if (this.lzt.epS != null && this.lzt.epS.isPlaying()) {
                    int currentPosition = this.lzt.epS.getCurrentPosition();
                    int duration = this.lzt.epS.getDuration();
                    if (currentPosition > 0 && duration > 0) {
                        this.lzt.tK((currentPosition * 100) / duration);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
            }
            try {
                Thread.sleep(200);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
            }
        }
    }
}
