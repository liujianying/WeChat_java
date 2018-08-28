package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class c implements a {
    private al eaF;
    int lnB;
    int lnC;
    private a lnI;
    private HandlerThread lnJ = e.cZ("check auto job", 10);
    com.tencent.mm.plugin.mmsight.segment.a.a.c lnK = null;
    private com.tencent.mm.plugin.mmsight.segment.a.a.c lnL = new 1(this);
    private a lnM = new 2(this);
    public a lnl;
    boolean released;

    public c() {
        int i = CaptureMMProxy.getInstance().getInt(aa.a.sUK, -1);
        if (i == 1) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.lnI = new d();
        } else if (i == 2) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.lnI = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.lnI = new b();
        } else {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.lnI = new d();
        }
        this.lnJ.start();
        this.eaF = new al(this.lnJ.getLooper(), this.lnM, true);
    }

    public final void setLoop(int i, int i2) {
        this.lnB = i;
        this.lnC = i2;
        if (this.lnI != null) {
            this.lnI.setLoop(this.lnB, this.lnC);
        }
    }

    public final void setDataSource(String str) {
        this.lnI.setDataSource(str);
    }

    public final void release() {
        this.released = true;
        this.lnI.release();
        if (this.eaF != null) {
            this.eaF.SO();
        }
        if (this.lnJ != null) {
            this.lnJ.quit();
        }
    }

    public final void start() {
        this.lnI.start();
        this.eaF.J(30, 30);
    }

    public final void pause() {
        this.lnI.pause();
        this.eaF.SO();
    }

    public final void stop() {
        this.lnI.stop();
        this.eaF.SO();
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.c cVar) {
        this.lnI.a(cVar);
    }

    public final void setAudioStreamType(int i) {
        this.lnI.setAudioStreamType(i);
    }

    public final int getCurrentPosition() {
        return this.lnI.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.lnI != null) {
            return this.lnI.getDuration();
        }
        return 0;
    }

    public final void setSurface(Surface surface) {
        this.lnI.setSurface(surface);
    }

    public final boolean isPlaying() {
        return this.lnI.isPlaying();
    }

    public final void seekTo(int i) {
        this.lnI.seekTo(i);
    }

    public final void prepareAsync() {
        this.lnI.prepareAsync();
    }

    public final void setLooping(boolean z) {
        this.lnI.setLooping(z);
    }

    public final void a(a.a aVar) {
        this.lnI.a(aVar);
    }

    public final void a(d dVar) {
        this.lnI.a(dVar);
    }

    public final void a(b bVar) {
        this.lnI.a(bVar);
    }
}
