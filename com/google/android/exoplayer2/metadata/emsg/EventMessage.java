package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Creator<EventMessage> CREATOR = new 1();
    private int aeo;
    public final String aqB;
    public final long aqC;
    public final byte[] aqD;
    public final long id;
    public final String value;

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.aqB = str;
        this.value = str2;
        this.aqC = j;
        this.id = j2;
        this.aqD = bArr;
    }

    EventMessage(Parcel parcel) {
        this.aqB = parcel.readString();
        this.value = parcel.readString();
        this.aqC = parcel.readLong();
        this.id = parcel.readLong();
        this.aqD = parcel.createByteArray();
    }

    public final int hashCode() {
        int i = 0;
        if (this.aeo == 0) {
            int hashCode = ((this.aqB != null ? this.aqB.hashCode() : 0) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            this.aeo = ((((((hashCode + i) * 31) + ((int) (this.aqC ^ (this.aqC >>> 32)))) * 31) + ((int) (this.id ^ (this.id >>> 32)))) * 31) + Arrays.hashCode(this.aqD);
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
        EventMessage eventMessage = (EventMessage) obj;
        if (this.aqC == eventMessage.aqC && this.id == eventMessage.id && t.i(this.aqB, eventMessage.aqB) && t.i(this.value, eventMessage.value) && Arrays.equals(this.aqD, eventMessage.aqD)) {
            return true;
        }
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqB);
        parcel.writeString(this.value);
        parcel.writeLong(this.aqC);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.aqD);
    }
}
