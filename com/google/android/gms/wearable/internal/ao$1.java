package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Callable;

class ao$1 implements Callable<Boolean> {
    final /* synthetic */ byte[] beO;
    final /* synthetic */ ParcelFileDescriptor bfd;
    final /* synthetic */ ao bfe;

    ao$1(ao aoVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        this.bfe = aoVar;
        this.bfd = parcelFileDescriptor;
        this.beO = bArr;
    }

    private Boolean rT() {
        if (Log.isLoggable("WearableClient", 3)) {
            new StringBuilder("processAssets: writing data to FD : ").append(this.bfd);
        }
        AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(this.bfd);
        try {
            autoCloseOutputStream.write(this.beO);
            autoCloseOutputStream.flush();
            if (Log.isLoggable("WearableClient", 3)) {
                new StringBuilder("processAssets: wrote data: ").append(this.bfd);
            }
            Boolean valueOf = Boolean.valueOf(true);
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    new StringBuilder("processAssets: closing: ").append(this.bfd);
                }
                autoCloseOutputStream.close();
                return valueOf;
            } catch (IOException e) {
                return valueOf;
            }
        } catch (IOException e2) {
            new StringBuilder("processAssets: writing data failed: ").append(this.bfd);
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    new StringBuilder("processAssets: closing: ").append(this.bfd);
                }
                autoCloseOutputStream.close();
            } catch (IOException e3) {
            }
            return Boolean.valueOf(false);
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    new StringBuilder("processAssets: closing: ").append(this.bfd);
                }
                autoCloseOutputStream.close();
            } catch (IOException e4) {
            }
            throw th;
        }
    }
}
