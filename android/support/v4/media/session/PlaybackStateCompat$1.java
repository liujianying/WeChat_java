package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PlaybackStateCompat$1 implements Creator<PlaybackStateCompat> {
    PlaybackStateCompat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PlaybackStateCompat[i];
    }
}
