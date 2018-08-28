package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.c.d;
import java.io.IOException;
import java.io.InputStream;

public class bg$c implements d {
    private final Status bcQ;
    private volatile ParcelFileDescriptor bfy;
    private volatile InputStream bfz;
    private volatile boolean mClosed = false;

    public bg$c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.bcQ = status;
        this.bfy = parcelFileDescriptor;
    }

    public final InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Cannot access the input stream after release().");
        } else if (this.bfy == null) {
            return null;
        } else {
            if (this.bfz == null) {
                this.bfz = new AutoCloseInputStream(this.bfy);
            }
            return this.bfz;
        }
    }

    public final Status oF() {
        return this.bcQ;
    }

    public final void release() {
        if (this.bfy != null) {
            if (this.mClosed) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.bfz != null) {
                    this.bfz.close();
                } else {
                    this.bfy.close();
                }
                this.mClosed = true;
                this.bfy = null;
                this.bfz = null;
            } catch (IOException e) {
            }
        }
    }
}
