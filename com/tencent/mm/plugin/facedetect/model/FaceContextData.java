package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import junit.framework.Assert;

public class FaceContextData implements Parcelable {
    public static final Creator<FaceContextData> CREATOR = new 1();
    private static volatile FaceContextData iNp = null;
    public long iNq = -1;

    public static void a(FaceContextData faceContextData) {
        if (faceContextData == null) {
            iNp = null;
        } else if (iNp != null) {
            b(faceContextData);
        } else {
            synchronized (FaceContextData.class) {
                if (iNp != null) {
                    b(faceContextData);
                    return;
                }
                iNp = faceContextData;
            }
        }
    }

    private static void b(FaceContextData faceContextData) {
        boolean z = (iNp == null || faceContextData == null) ? false : true;
        Assert.assertTrue(z);
        iNp.iNq = faceContextData.iNq;
    }

    public static synchronized FaceContextData aJD() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = iNp;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        this.iNq = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.iNq);
    }
}
