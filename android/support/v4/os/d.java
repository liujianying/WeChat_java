package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T> implements ClassLoaderCreator<T> {
    private final c<T> sV;

    public d(c<T> cVar) {
        this.sV = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.sV.createFromParcel(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.sV.createFromParcel(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.sV.newArray(i);
    }
}
