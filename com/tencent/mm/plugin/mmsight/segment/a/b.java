package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.u.i;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    boolean Fd = false;
    boolean bTv = false;
    boolean dGv = false;
    int lnA;
    int lnB = 0;
    private int lnC = 0;
    a lnD;
    d lnE;
    com.tencent.mm.plugin.mmsight.segment.a.a.b lnF;
    c lnG;
    i lnz = new i(Looper.getMainLooper());

    public b() {
        i iVar = this.lnz;
        if (iVar.ldy != null) {
            j jVar = iVar.ldy;
            if (jVar.ldg != null) {
                jVar.ldg.lda = false;
            }
        }
        this.lnz.setNeedResetExtractor(false);
        this.lnz.ldz = new 1(this);
    }

    public final void setSurface(Surface surface) {
        this.lnz.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.lnz.setPath(str);
    }

    public final void prepareAsync() {
        this.lnz.bdz();
    }

    public final void start() {
        if (this.Fd) {
            this.lnz.start();
        }
        this.bTv = true;
    }

    public final void stop() {
        this.lnz.ldy.stop();
        this.bTv = false;
    }

    public final void pause() {
        this.lnz.pause();
    }

    public final boolean isPlaying() {
        return this.lnz.isPlaying();
    }

    public final void seekTo(int i) {
        if (this.lnz != null) {
            x.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[]{Integer.valueOf(i)});
            this.lnz.sG(i);
        }
    }

    public final int getCurrentPosition() {
        return this.lnz.bdA();
    }

    public final int getDuration() {
        return (int) this.lnz.ldy.aqC;
    }

    public final void release() {
        this.lnz.release();
    }

    public final void setAudioStreamType(int i) {
    }

    public final void setLooping(boolean z) {
        this.dGv = z;
    }

    public final void setLoop(int i, int i2) {
        this.lnB = i;
        this.lnC = i2;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.b bVar) {
        this.lnF = bVar;
    }

    public final void a(c cVar) {
        this.lnG = cVar;
    }

    public final void a(d dVar) {
        this.lnE = dVar;
    }

    public final void a(a aVar) {
        this.lnD = aVar;
    }
}
