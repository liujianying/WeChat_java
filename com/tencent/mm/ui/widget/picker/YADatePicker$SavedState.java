package com.tencent.mm.ui.widget.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class YADatePicker$SavedState extends BaseSavedState {
    public static final Creator<YADatePicker$SavedState> CREATOR = new Creator<YADatePicker$SavedState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new YADatePicker$SavedState(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new YADatePicker$SavedState[i];
        }
    };
    private final int hhF;
    private final int hhG;
    private final int hhH;

    /* synthetic */ YADatePicker$SavedState(Parcel parcel, byte b) {
        this(parcel);
    }

    /* synthetic */ YADatePicker$SavedState(Parcelable parcelable, int i, int i2, int i3, byte b) {
        this(parcelable, i, i2, i3);
    }

    private YADatePicker$SavedState(Parcelable parcelable, int i, int i2, int i3) {
        super(parcelable);
        this.hhF = i;
        this.hhG = i2;
        this.hhH = i3;
    }

    private YADatePicker$SavedState(Parcel parcel) {
        super(parcel);
        this.hhF = parcel.readInt();
        this.hhG = parcel.readInt();
        this.hhH = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.hhF);
        parcel.writeInt(this.hhG);
        parcel.writeInt(this.hhH);
    }
}
