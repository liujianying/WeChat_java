package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction implements Parcelable {
    public static final Creator<PlaybackStateCompat$CustomAction> CREATOR = new 1();
    private final Bundle mExtras;
    private final String sS;
    private final CharSequence sT;
    private final int sU;

    /* synthetic */ PlaybackStateCompat$CustomAction(Parcel parcel, byte b) {
        this(parcel);
    }

    private PlaybackStateCompat$CustomAction(Parcel parcel) {
        this.sS = parcel.readString();
        this.sT = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.sU = parcel.readInt();
        this.mExtras = parcel.readBundle();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sS);
        TextUtils.writeToParcel(this.sT, parcel, i);
        parcel.writeInt(this.sU);
        parcel.writeBundle(this.mExtras);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Action:mName='" + this.sT + ", mIcon=" + this.sU + ", mExtras=" + this.mExtras;
    }
}
