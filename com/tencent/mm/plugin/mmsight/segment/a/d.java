package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

public final class d implements a {
    private MediaPlayer epS = new j();

    public final void setSurface(Surface surface) {
        this.epS.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.epS.setDataSource(str);
    }

    public final void prepareAsync() {
        this.epS.prepareAsync();
    }

    public final void start() {
        this.epS.start();
    }

    public final void stop() {
        this.epS.stop();
    }

    public final void pause() {
        this.epS.pause();
    }

    public final boolean isPlaying() {
        return this.epS.isPlaying();
    }

    public final void seekTo(int i) {
        this.epS.seekTo(i);
    }

    public final int getCurrentPosition() {
        return this.epS.getCurrentPosition();
    }

    public final int getDuration() {
        return this.epS.getDuration();
    }

    public final void release() {
        this.epS.release();
    }

    public final void setAudioStreamType(int i) {
        this.epS.setAudioStreamType(i);
    }

    public final void setLooping(boolean z) {
        this.epS.setLooping(z);
    }

    public final void setLoop(int i, int i2) {
    }

    public final void a(b bVar) {
        if (bVar == null) {
            this.epS.setOnPreparedListener(null);
        } else {
            this.epS.setOnPreparedListener(new 1(this, bVar));
        }
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.epS.setOnSeekCompleteListener(null);
        } else {
            this.epS.setOnSeekCompleteListener(new 2(this, cVar));
        }
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.d dVar) {
        if (dVar == null) {
            this.epS.setOnVideoSizeChangedListener(null);
        } else {
            this.epS.setOnVideoSizeChangedListener(new 3(this, dVar));
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            this.epS.setOnErrorListener(null);
        } else {
            this.epS.setOnErrorListener(new 4(this, aVar));
        }
    }
}
