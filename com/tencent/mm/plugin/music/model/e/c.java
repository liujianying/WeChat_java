package com.tencent.mm.plugin.music.model.e;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.plugin.music.b.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public final class c extends b {
    AudioTrack aga;
    MediaCodec apD;
    int channels = 0;
    int dAa = 0;
    long duration = 0;
    String ldm = null;
    MediaExtractor ldo;
    private boolean lhj = true;
    String lzu;
    boolean lzv = false;
    private Runnable lzw = new 1(this);
    long presentationTimeUs = 0;
    int sampleRate = 0;

    static /* synthetic */ void a(c cVar) {
        try {
            if (cVar.ldo != null) {
                cVar.ldo.release();
                cVar.ldo = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaExtractor", new Object[0]);
        }
    }

    static /* synthetic */ void b(c cVar) {
        try {
            if (cVar.apD != null) {
                cVar.apD.stop();
                cVar.apD.release();
                cVar.apD = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaCodec", new Object[0]);
        }
    }

    static /* synthetic */ void c(c cVar) {
        try {
            if (cVar.aga != null) {
                cVar.aga.flush();
                cVar.aga.release();
                cVar.aga = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseAudioTrack", new Object[0]);
        }
    }

    public final void IA(String str) {
        this.lzu = str;
    }

    final boolean createAudioTrack() {
        x.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        this.aga = new d(3, this.sampleRate, i, AudioTrack.getMinBufferSize(this.sampleRate, i, 2));
        if (this.aga != null && this.aga.getState() == 1) {
            return true;
        }
        x.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.aga != null) {
            try {
                this.aga.release();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public final int biu() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    public final void play() {
        x.i("MicroMsg.Music.MMPlayer", "play");
        if (!bit()) {
            this.lhj = false;
            e.post(this.lzw, "music_player");
        } else if (bit() && this.lAa.biA()) {
            this.lAa.lAe = 3;
            biw();
        }
    }

    private synchronized void biw() {
        x.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "syncNotify", new Object[0]);
        }
        return;
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMPlayer", "stop");
        this.lhj = true;
        if (this.lAa.biA()) {
            biw();
        }
    }

    public final void pause() {
        x.i("MicroMsg.Music.MMPlayer", "pause");
        if (bit()) {
            this.lAa.lAe = 2;
        }
    }

    public final void seek(long j) {
        this.ldo.seekTo(1000 * j, 2);
    }

    public final synchronized void bix() {
        while (bit() && this.lAa.biA()) {
            try {
                x.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "waitPlay", new Object[0]);
            }
        }
    }

    public final boolean isPlaying() {
        return this.lAa.isPlaying();
    }

    public final boolean bit() {
        return !this.lhj;
    }

    protected final void gP(boolean z) {
        this.lzv = false;
        this.lAa.lAe = 4;
        this.lhj = true;
        super.gP(z);
    }

    protected final void gQ(boolean z) {
        this.lAa.lAe = 4;
        this.lhj = true;
        super.gQ(z);
    }

    public final String biv() {
        return this.ldm;
    }
}
