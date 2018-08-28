package com.tencent.mm.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class MMPinProgressBtn$SavedState extends BaseSavedState {
    public static final Creator<MMPinProgressBtn$SavedState> CREATOR = new 1();
    private int pF;
    private int uGt;

    /* synthetic */ MMPinProgressBtn$SavedState(Parcel parcel, byte b) {
        this(parcel);
    }

    public MMPinProgressBtn$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private MMPinProgressBtn$SavedState(Parcel parcel) {
        super(parcel);
        this.pF = parcel.readInt();
        this.uGt = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.pF);
        parcel.writeInt(this.uGt);
    }
}
