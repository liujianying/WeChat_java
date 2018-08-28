package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.b;
import android.view.View.BaseSavedState;

protected class AppBarLayout$Behavior$SavedState extends BaseSavedState {
    public static final Creator<AppBarLayout$Behavior$SavedState> CREATOR = b.a(new 1());
    int cl;
    float cm;
    boolean cn;

    public AppBarLayout$Behavior$SavedState(Parcel parcel) {
        super(parcel);
        this.cl = parcel.readInt();
        this.cm = parcel.readFloat();
        this.cn = parcel.readByte() != (byte) 0;
    }

    public AppBarLayout$Behavior$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.cl);
        parcel.writeFloat(this.cm);
        parcel.writeByte((byte) (this.cn ? 1 : 0));
    }
}
