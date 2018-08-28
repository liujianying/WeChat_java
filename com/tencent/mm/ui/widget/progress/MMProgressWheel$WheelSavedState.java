package com.tencent.mm.ui.widget.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class MMProgressWheel$WheelSavedState extends BaseSavedState {
    public static final Creator<MMProgressWheel$WheelSavedState> CREATOR = new 1();
    float tua;
    int uMa;
    int uMb;
    int uMc;
    boolean uMd;
    int uMj;
    int uMk;
    float uMo;
    boolean uMq;
    float uMr;
    boolean uMs;

    /* synthetic */ MMProgressWheel$WheelSavedState(Parcel parcel, byte b) {
        this(parcel);
    }

    MMProgressWheel$WheelSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private MMProgressWheel$WheelSavedState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        this.tua = parcel.readFloat();
        this.uMr = parcel.readFloat();
        this.uMs = parcel.readByte() != (byte) 0;
        this.uMo = parcel.readFloat();
        this.uMb = parcel.readInt();
        this.uMj = parcel.readInt();
        this.uMc = parcel.readInt();
        this.uMk = parcel.readInt();
        this.uMa = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.uMq = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.uMd = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.tua);
        parcel.writeFloat(this.uMr);
        parcel.writeByte((byte) (this.uMs ? 1 : 0));
        parcel.writeFloat(this.uMo);
        parcel.writeInt(this.uMb);
        parcel.writeInt(this.uMj);
        parcel.writeInt(this.uMc);
        parcel.writeInt(this.uMk);
        parcel.writeInt(this.uMa);
        if (this.uMq) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.uMd) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
