package android.support.design.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.b;
import android.view.View.BaseSavedState;

public class NavigationView$SavedState extends BaseSavedState {
    public static final Creator<NavigationView$SavedState> CREATOR = b.a(new 1());
    public Bundle gj;

    public NavigationView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        this.gj = parcel.readBundle(classLoader);
    }

    public NavigationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.gj);
    }
}
