package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.UUID;

public final class DrmInitData$SchemeData implements Parcelable {
    public static final Creator<DrmInitData$SchemeData> CREATOR = new 1();
    private int aeo;
    public final boolean aiv;
    public final byte[] data;
    public final String mimeType;
    public final String type;
    final UUID uuid;

    public DrmInitData$SchemeData(UUID uuid, String str, byte[] bArr) {
        this(uuid, null, str, bArr, false);
    }

    public DrmInitData$SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
        this.uuid = (UUID) a.Z(uuid);
        this.type = str;
        this.mimeType = (String) a.Z(str2);
        this.data = (byte[]) a.Z(bArr);
        this.aiv = z;
    }

    DrmInitData$SchemeData(Parcel parcel) {
        this.uuid = new UUID(parcel.readLong(), parcel.readLong());
        this.type = parcel.readString();
        this.mimeType = parcel.readString();
        this.data = parcel.createByteArray();
        this.aiv = parcel.readByte() != (byte) 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DrmInitData$SchemeData)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DrmInitData$SchemeData drmInitData$SchemeData = (DrmInitData$SchemeData) obj;
        if (this.mimeType.equals(drmInitData$SchemeData.mimeType) && t.i(this.uuid, drmInitData$SchemeData.uuid) && t.i(this.type, drmInitData$SchemeData.type) && Arrays.equals(this.data, drmInitData$SchemeData.data)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = (((((this.type == null ? 0 : this.type.hashCode()) + (this.uuid.hashCode() * 31)) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
        }
        return this.aeo;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uuid.getMostSignificantBits());
        parcel.writeLong(this.uuid.getLeastSignificantBits());
        parcel.writeString(this.type);
        parcel.writeString(this.mimeType);
        parcel.writeByteArray(this.data);
        parcel.writeByte((byte) (this.aiv ? 1 : 0));
    }
}
