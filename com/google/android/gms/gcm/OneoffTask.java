package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new 1();
    private final long aQI;
    private final long aQJ;

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.aQI = parcel.readLong();
        this.aQJ = parcel.readLong();
    }

    /* synthetic */ OneoffTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public String toString() {
        return super.toString() + " windowStart=" + this.aQI + " windowEnd=" + this.aQJ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.aQI);
        parcel.writeLong(this.aQJ);
    }
}
