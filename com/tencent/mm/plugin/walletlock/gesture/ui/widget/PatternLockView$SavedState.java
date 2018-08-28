package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class PatternLockView$SavedState extends BaseSavedState {
    public static final Creator<PatternLockView$SavedState> CREATOR = new Creator<PatternLockView$SavedState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PatternLockView$SavedState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PatternLockView$SavedState[i];
        }
    };
    boolean pHN;
    boolean pHO;
    boolean pHP;
    String pIh;
    int pIi;

    public PatternLockView$SavedState(Parcel parcel) {
        super(parcel);
        this.pIh = parcel.readString();
        this.pIi = parcel.readInt();
        this.pHO = ((Boolean) parcel.readValue(null)).booleanValue();
        this.pHP = ((Boolean) parcel.readValue(null)).booleanValue();
        this.pHN = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public PatternLockView$SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
        super(parcelable);
        this.pIh = str;
        this.pIi = i;
        this.pHO = z;
        this.pHP = z2;
        this.pHN = z3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.pIh);
        parcel.writeInt(this.pIi);
        parcel.writeValue(Boolean.valueOf(this.pHO));
        parcel.writeValue(Boolean.valueOf(this.pHP));
        parcel.writeValue(Boolean.valueOf(this.pHN));
    }
}
