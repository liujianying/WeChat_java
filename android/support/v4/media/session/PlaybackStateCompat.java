package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new 1();
    private final Bundle mExtras;
    private final int mState;
    private final long sK;
    private final long sL;
    private final float sM;
    private final long sN;
    private final CharSequence sO;
    private final long sP;
    private List<CustomAction> sQ;
    private final long sR;

    /* synthetic */ PlaybackStateCompat(Parcel parcel, byte b) {
        this(parcel);
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.sK = parcel.readLong();
        this.sM = parcel.readFloat();
        this.sP = parcel.readLong();
        this.sL = parcel.readLong();
        this.sN = parcel.readLong();
        this.sO = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.sQ = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.sR = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.sK);
        stringBuilder.append(", buffered position=").append(this.sL);
        stringBuilder.append(", speed=").append(this.sM);
        stringBuilder.append(", updated=").append(this.sP);
        stringBuilder.append(", actions=").append(this.sN);
        stringBuilder.append(", error=").append(this.sO);
        stringBuilder.append(", custom actions=").append(this.sQ);
        stringBuilder.append(", active item id=").append(this.sR);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.sK);
        parcel.writeFloat(this.sM);
        parcel.writeLong(this.sP);
        parcel.writeLong(this.sL);
        parcel.writeLong(this.sN);
        TextUtils.writeToParcel(this.sO, parcel, i);
        parcel.writeTypedList(this.sQ);
        parcel.writeLong(this.sR);
        parcel.writeBundle(this.mExtras);
    }
}
