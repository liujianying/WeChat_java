package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class ao$2 implements Runnable {
    final /* synthetic */ Uri beo;
    final /* synthetic */ boolean bep;
    final /* synthetic */ ao bfe;
    final /* synthetic */ b bff;
    final /* synthetic */ String bfg;

    ao$2(ao aoVar, Uri uri, b bVar, boolean z, String str) {
        this.bfe = aoVar;
        this.beo = uri;
        this.bff = bVar;
        this.bep = z;
        this.bfg = str;
    }

    public final void run() {
        Log.isLoggable("WearableClient", 2);
        if ("file".equals(this.beo.getScheme())) {
            Object file = new File(this.beo.getPath());
            try {
                ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (this.bep ? 33554432 : 0) | 536870912);
                try {
                    ((x) this.bfe.pi()).a(new an$i(this.bff), this.bfg, open);
                    try {
                        open.close();
                        return;
                    } catch (IOException e) {
                        return;
                    }
                } catch (RemoteException e2) {
                    this.bff.c(new Status(8));
                    try {
                        open.close();
                        return;
                    } catch (IOException e3) {
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        open.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                new StringBuilder("File couldn't be opened for Channel.receiveFile: ").append(file);
                this.bff.c(new Status(13));
                return;
            }
        }
        this.bff.c(new Status(10, "Channel.receiveFile used with non-file URI"));
    }
}
