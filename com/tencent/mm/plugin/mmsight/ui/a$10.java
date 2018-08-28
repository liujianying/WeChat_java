package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class a$10 implements a {
    final /* synthetic */ a lpk;

    a$10(a aVar) {
        this.lpk = aVar;
    }

    public final boolean vD() {
        if (this.lpk.lkZ != null && this.lpk.lkZ.isPlaying()) {
            if (this.lpk.loW <= 0 || this.lpk.lkZ.getCurrentPosition() < this.lpk.loW) {
                this.lpk.loS.setCurrentCursorPosition(((float) this.lpk.lkZ.getCurrentPosition()) / ((float) this.lpk.loU));
            } else {
                this.lpk.lkZ.d((double) this.lpk.loV, true);
                this.lpk.loS.setCurrentCursorPosition(((float) this.lpk.loV) / ((float) this.lpk.loU));
            }
        }
        return true;
    }
}
