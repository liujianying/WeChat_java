package com.google.android.gms.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;

class d$1 extends Handler {
    final /* synthetic */ d aRu;

    d$1(d dVar, Looper looper) {
        this.aRu = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        d dVar = this.aRu;
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    dVar.aRo = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    dVar.aRn = (Messenger) parcelableExtra;
                }
            }
            dVar.h((Intent) message.obj);
        }
    }
}
