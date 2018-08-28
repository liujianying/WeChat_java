package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.MessageEventParcelable;

class WearableListenerService$a$2 implements Runnable {
    final /* synthetic */ a bdK;
    final /* synthetic */ MessageEventParcelable bdL;

    WearableListenerService$a$2(a aVar, MessageEventParcelable messageEventParcelable) {
        this.bdK = aVar;
        this.bdL = messageEventParcelable;
    }

    public final void run() {
        this.bdK.bdI.a(this.bdL);
    }
}
