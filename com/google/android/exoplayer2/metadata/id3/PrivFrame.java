package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new 1();
    public final String aqU;
    public final byte[] aqV;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.aqU = str;
        this.aqV = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.aqU = parcel.readString();
        this.aqV = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (t.i(this.aqU, privFrame.aqU) && Arrays.equals(this.aqV, privFrame.aqV)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.aqU != null ? this.aqU.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.aqV);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqU);
        parcel.writeByteArray(this.aqV);
    }
}
