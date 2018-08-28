package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.c;

final class k$b extends Handler {
    final /* synthetic */ k aOj;

    public k$b(k kVar, Looper looper) {
        this.aOj = kVar;
        super(looper);
    }

    private static void e(Message message) {
        ((c) message.obj).unregister();
    }

    private static boolean f(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
    }

    public final void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.aOj.aOg.get() != message.arg1) {
            if (f(message)) {
                e(message);
            }
        } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.aOj.isConnecting()) {
            e(message);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            k.a(this.aOj).b(new ConnectionResult(message.arg2, pendingIntent));
            k.pf();
        } else if (message.what == 4) {
            k.a(this.aOj, 4);
            if (k.b(this.aOj) != null) {
                k.b(this.aOj).dm(message.arg2);
            }
            int i = message.arg2;
            k.pe();
            k.a(this.aOj, 4, 1, null);
        } else if (message.what == 2 && !this.aOj.isConnected()) {
            e(message);
        } else if (f(message)) {
            ((c) message.obj).pk();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
        }
    }
}
