package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new 1();
    public int sF;
    public int sG;
    public int sH;
    public int sI;
    public int sJ;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.sF = parcel.readInt();
        this.sH = parcel.readInt();
        this.sI = parcel.readInt();
        this.sJ = parcel.readInt();
        this.sG = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sF);
        parcel.writeInt(this.sH);
        parcel.writeInt(this.sI);
        parcel.writeInt(this.sJ);
        parcel.writeInt(this.sG);
    }
}
