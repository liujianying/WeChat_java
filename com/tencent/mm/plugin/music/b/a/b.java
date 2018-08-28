package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.an.a;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class b {
    protected a bTF;
    public f lAa = new f();
    protected e lzZ;

    public abstract void IA(String str);

    public abstract boolean bit();

    public abstract int biu();

    public abstract String biv();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public final void a(e eVar) {
        this.lzZ = eVar;
    }

    public final void o(a aVar) {
        this.bTF = aVar;
    }

    public void gP(boolean z) {
        if (this.lzZ != null) {
            ah.A(new 1(this, z));
        }
    }

    public final void onStart() {
        if (this.lzZ != null) {
            ah.A(new 2(this));
        }
    }

    public final void tK(int i) {
        if (this.lzZ != null) {
            ah.A(new 3(this, i));
        }
    }

    public void gQ(boolean z) {
        if (this.lzZ != null) {
            ah.A(new 4(this, z));
        }
    }
}
