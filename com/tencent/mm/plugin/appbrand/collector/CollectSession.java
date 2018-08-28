package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new 1();
    public final Bundle bQf = new Bundle();
    TimePoint fnY;
    TimePoint fnZ;
    final Map<String, TimePoint> foa = new HashMap();
    String fob;
    String groupId;
    String id;

    CollectSession() {
    }

    public CollectSession(String str) {
        this.id = str;
    }

    public final void rt(String str) {
        Assert.assertNull(this.fnY);
        this.fnY = new TimePoint(str, System.nanoTime());
        this.fnZ = this.fnY;
        this.fnY.foj.set(1);
        this.foa.put(str, this.fnY);
    }

    public final void ru(String str) {
        Assert.assertNotNull(this.fnZ);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.foa.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.foj.set(1);
            this.foa.put(str, timePoint);
            this.fnZ.fol.set(timePoint);
            this.fnZ = timePoint;
            return;
        }
        timePoint.fok.set((nanoTime + (timePoint.fok.get() * ((long) timePoint.foj.get()))) / ((long) (timePoint.foj.get() + 1)));
        timePoint.foj.incrementAndGet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.fnY, i);
        parcel.writeString(this.fob);
        parcel.writeBundle(this.bQf);
    }
}
