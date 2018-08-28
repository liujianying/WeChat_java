package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.WearableListenerService.a;

class WearableListenerService$a$1 implements Runnable {
    final /* synthetic */ DataHolder bdJ;
    final /* synthetic */ a bdK;

    WearableListenerService$a$1(a aVar, DataHolder dataHolder) {
        this.bdK = aVar;
        this.bdJ = dataHolder;
    }

    public final void run() {
        e eVar = new e(this.bdJ);
        try {
            this.bdK.bdI.a(eVar);
        } finally {
            eVar.release();
        }
    }
}
