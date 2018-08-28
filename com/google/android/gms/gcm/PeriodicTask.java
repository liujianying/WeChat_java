package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new 1();
    protected long aQK;
    protected long aQL;

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.aQK = -1;
        this.aQL = -1;
        this.aQK = parcel.readLong();
        this.aQL = parcel.readLong();
    }

    /* synthetic */ PeriodicTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public String toString() {
        return super.toString() + " period=" + this.aQK + " flex=" + this.aQL;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.aQK);
        parcel.writeLong(this.aQL);
    }
}
