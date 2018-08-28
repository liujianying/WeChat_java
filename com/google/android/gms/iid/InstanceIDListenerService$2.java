package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class InstanceIDListenerService$2 extends BroadcastReceiver {
    final /* synthetic */ InstanceIDListenerService aRe;

    InstanceIDListenerService$2(InstanceIDListenerService instanceIDListenerService) {
        this.aRe = instanceIDListenerService;
    }

    public final void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("InstanceID", 3)) {
            intent.getStringExtra("registration_id");
            new StringBuilder("Received GSF callback using dynamic receiver: ").append(intent.getExtras());
        }
        this.aRe.e(intent);
        this.aRe.stop();
    }
}
