package com.c.a;

import android.os.IBinder.DeathRecipient;

class a$1 implements DeathRecipient {
    final /* synthetic */ a bge;

    a$1(a aVar) {
        this.bge = aVar;
    }

    public final void binderDied() {
        if (this.bge.bgb != null) {
            this.bge.bgb.aK(2101, -1);
        }
    }
}
