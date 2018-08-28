package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Creator<MediaBrowserCompat$MediaItem> CREATOR = new 1();
    private final int rJ;
    private final MediaDescriptionCompat rK;

    /* synthetic */ MediaBrowserCompat$MediaItem(Parcel parcel, byte b) {
        this(parcel);
    }

    private MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.rJ = parcel.readInt();
        this.rK = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rJ);
        this.rK.writeToParcel(parcel, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaItem{");
        stringBuilder.append("mFlags=").append(this.rJ);
        stringBuilder.append(", mDescription=").append(this.rK);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
