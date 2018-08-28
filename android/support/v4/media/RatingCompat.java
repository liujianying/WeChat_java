package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new 1();
    private final float sA;
    private final int sz;

    /* synthetic */ RatingCompat(int i, float f, byte b) {
        this(i, f);
    }

    private RatingCompat(int i, float f) {
        this.sz = i;
        this.sA = f;
    }

    public final String toString() {
        return "Rating:style=" + this.sz + " rating=" + (this.sA < 0.0f ? "unrated" : String.valueOf(this.sA));
    }

    public final int describeContents() {
        return this.sz;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sz);
        parcel.writeFloat(this.sA);
    }
}
