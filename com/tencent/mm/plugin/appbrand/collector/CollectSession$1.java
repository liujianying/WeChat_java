package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class CollectSession$1 implements Creator<CollectSession> {
    CollectSession$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        CollectSession collectSession = new CollectSession();
        collectSession.groupId = parcel.readString();
        collectSession.id = parcel.readString();
        collectSession.fnY = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
        collectSession.fob = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            collectSession.bQf.putAll(readBundle);
        }
        TimePoint timePoint = collectSession.fnY;
        if (timePoint != null) {
            collectSession.foa.put(timePoint.name, timePoint);
            while (timePoint.fol.get() != null) {
                timePoint = (TimePoint) timePoint.fol.get();
                collectSession.foa.put(timePoint.name, timePoint);
            }
            collectSession.fnZ = timePoint;
        }
        return collectSession;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CollectSession[i];
    }
}
