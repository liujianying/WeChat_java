package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint implements Parcelable {
    public static final Creator<TimePoint> CREATOR = new 1();
    final AtomicInteger foj;
    final AtomicLong fok;
    final AtomicReference<TimePoint> fol;
    String name;

    TimePoint() {
        this.foj = new AtomicInteger();
        this.fok = new AtomicLong();
        this.fol = new AtomicReference();
        this.name = "";
    }

    public TimePoint(String str, long j) {
        this.foj = new AtomicInteger();
        this.fok = new AtomicLong();
        this.fol = new AtomicReference();
        this.name = str;
        this.fok.set(j);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.fok.get());
        parcel.writeInt(this.foj.get());
        parcel.writeParcelable((Parcelable) this.fol.get(), i);
    }
}
