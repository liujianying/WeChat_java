package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService.a;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;

class WearableListenerService$a$9 implements Runnable {
    final /* synthetic */ a bdK;
    final /* synthetic */ ChannelEventParcelable bdS;

    WearableListenerService$a$9(a aVar, ChannelEventParcelable channelEventParcelable) {
        this.bdK = aVar;
        this.bdS = channelEventParcelable;
    }

    public final void run() {
        this.bdS.a(this.bdK.bdI);
    }
}
