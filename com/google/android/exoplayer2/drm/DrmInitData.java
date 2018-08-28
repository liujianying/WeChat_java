package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new Creator<DrmInitData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }
    };
    private int aeo;
    public final SchemeData[] ait;
    public final int aiu;

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (b.aco.equals(SchemeData.a(schemeData))) {
            return b.aco.equals(SchemeData.a(schemeData2)) ? 0 : 1;
        } else {
            return SchemeData.a(schemeData).compareTo(SchemeData.a(schemeData2));
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2;
        if (z) {
            schemeDataArr2 = (SchemeData[]) schemeDataArr.clone();
        } else {
            schemeDataArr2 = schemeDataArr;
        }
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (SchemeData.a(schemeDataArr2[i - 1]).equals(SchemeData.a(schemeDataArr2[i]))) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + SchemeData.a(schemeDataArr2[i]));
            }
        }
        this.ait = schemeDataArr2;
        this.aiu = schemeDataArr2.length;
    }

    DrmInitData(Parcel parcel) {
        this.ait = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.aiu = this.ait.length;
    }

    public final DrmInitData ai(String str) {
        int i;
        int i2 = 0;
        for (SchemeData schemeData : this.ait) {
            if (!t.i(schemeData.type, (Object) str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return this;
        }
        SchemeData[] schemeDataArr = new SchemeData[this.ait.length];
        while (true) {
            int i3 = i2;
            if (i3 >= schemeDataArr.length) {
                return new DrmInitData(schemeDataArr);
            }
            SchemeData schemeData2;
            SchemeData schemeData3 = this.ait[i3];
            if (t.i(schemeData3.type, (Object) str)) {
                schemeData2 = schemeData3;
            } else {
                schemeData2 = new SchemeData(schemeData3.uuid, str, schemeData3.mimeType, schemeData3.data, schemeData3.aiv);
            }
            schemeDataArr[i3] = schemeData2;
            i2 = i3 + 1;
        }
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = Arrays.hashCode(this.ait);
        }
        return this.aeo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.ait, ((DrmInitData) obj).ait);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.ait, 0);
    }
}
