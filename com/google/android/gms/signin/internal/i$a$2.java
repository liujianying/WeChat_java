package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.signin.internal.i.a;

class i$a$2 implements Runnable {
    final /* synthetic */ String baO;
    final /* synthetic */ f baP;
    final /* synthetic */ a baQ;
    final /* synthetic */ String baR;

    i$a$2(a aVar, String str, String str2, f fVar) {
        this.baQ = aVar;
        this.baO = str;
        this.baR = str2;
        this.baP = fVar;
    }

    public final void run() {
        try {
            this.baP.ax(a.a(this.baQ).oD());
        } catch (RemoteException e) {
        }
    }
}
