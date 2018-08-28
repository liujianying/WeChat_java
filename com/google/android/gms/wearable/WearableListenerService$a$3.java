package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.NodeParcelable;

class WearableListenerService$a$3 implements Runnable {
    final /* synthetic */ a bdK;
    final /* synthetic */ NodeParcelable bdM;

    WearableListenerService$a$3(a aVar, NodeParcelable nodeParcelable) {
        this.bdK = aVar;
        this.bdM = nodeParcelable;
    }

    public final void run() {
        this.bdK.bdI.a(this.bdM);
    }
}
