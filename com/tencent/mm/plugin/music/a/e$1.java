package com.tencent.mm.plugin.music.a;

import com.tencent.mm.sdk.platformtools.ar.a;

class e$1 implements a {
    final /* synthetic */ e lwY;

    e$1(e eVar) {
        this.lwY = eVar;
    }

    public final void fn(int i) {
        switch (i) {
            case 0:
                if (this.lwY.lwW) {
                    this.lwY.lwW = false;
                    this.lwY.resume();
                    return;
                }
                return;
            case 1:
            case 2:
                if (this.lwY.PY()) {
                    this.lwY.lwW = true;
                    this.lwY.pause();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
