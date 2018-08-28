package com.tencent.mm.plugin.music.model.e;

import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.music.b.a.b {
    MediaPlayer epS = new j();
    boolean lhj = true;
    a lzs;

    public b() {
        this.epS.setAudioStreamType(3);
        this.epS.setOnCompletionListener(new 1(this));
        this.epS.setOnSeekCompleteListener(new 2(this));
        this.epS.setOnPreparedListener(new 3(this));
        this.epS.setOnErrorListener(new 4(this));
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            return this.epS.isPlaying();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
            return z;
        }
    }

    public final boolean bit() {
        return !this.lhj;
    }

    public final void IA(String str) {
        x.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[]{str});
        try {
            this.epS.setDataSource(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
        }
    }

    public final int biu() {
        return this.epS.getCurrentPosition();
    }

    public final int getDuration() {
        return this.epS.getDuration();
    }

    public final void play() {
        x.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (bit()) {
            try {
                if (!this.epS.isPlaying()) {
                    this.epS.start();
                    return;
                }
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                return;
            }
        }
        try {
            this.epS.prepareAsync();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.lhj = true;
        try {
            if (this.epS != null) {
                this.epS.stop();
                this.epS.release();
            }
            if (this.lzs != null) {
                this.lzs.isStop = true;
                this.lzs = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        gQ(false);
    }

    public final void pause() {
        x.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (bit()) {
            this.epS.pause();
        }
    }

    public final void seek(long j) {
        x.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[]{Long.valueOf(j)});
        this.epS.seekTo((int) j);
    }

    public final String biv() {
        return null;
    }
}
