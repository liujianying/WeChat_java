package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class v$a extends c<ConnectionResult> implements b, c.c {
    public final c aLT;
    boolean aLY;
    private ConnectionResult aLZ;

    public v$a(Context context, c cVar) {
        super(context);
        this.aLT = cVar;
    }

    private void g(ConnectionResult connectionResult) {
        this.aLZ = connectionResult;
        if (this.mg && !this.qY) {
            deliverResult(connectionResult);
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLY = true;
        g(connectionResult);
    }

    public final void dm(int i) {
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.aLT.a(str, printWriter);
    }

    public final void e(Bundle bundle) {
        this.aLY = false;
        g(ConnectionResult.aJB);
    }

    protected final void onReset() {
        this.aLZ = null;
        this.aLY = false;
        this.aLT.b(this);
        this.aLT.b(this);
        this.aLT.disconnect();
    }

    protected final void onStartLoading() {
        super.onStartLoading();
        this.aLT.a(this);
        this.aLT.a(this);
        if (this.aLZ != null) {
            deliverResult(this.aLZ);
        }
        if (!this.aLT.isConnected() && !this.aLT.isConnecting() && !this.aLY) {
            this.aLT.connect();
        }
    }

    protected final void onStopLoading() {
        this.aLT.disconnect();
    }
}
