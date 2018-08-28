package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new 1();
    private IBinder aMX;

    public BinderWrapper() {
        this.aMX = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.aMX = null;
        this.aMX = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.aMX = null;
        this.aMX = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.aMX);
    }
}
