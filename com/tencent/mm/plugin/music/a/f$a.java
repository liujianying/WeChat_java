package com.tencent.mm.plugin.music.a;

import com.tencent.mm.sdk.platformtools.x;

class f$a implements Runnable {
    boolean isStop;
    final /* synthetic */ f lxm;

    private f$a(f fVar) {
        this.lxm = fVar;
        this.isStop = true;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final void run() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
        while (!this.isStop) {
            try {
                if (this.lxm.lwZ != null && this.lxm.PY()) {
                    this.lxm.bhG();
                }
            } catch (Exception e) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e.getMessage());
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e2) {
            }
        }
    }
}
