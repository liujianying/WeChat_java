package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.x;

public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new 1();
    public boolean leb = false;
    public boolean lec = false;
    public boolean led = true;
    public String lee = "";
    public String lef = "";
    public String leg = "";
    public String leh = "";
    public int lei = 0;
    public aso lej = new aso();
    public String lek = "";

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, aso aso) {
        this.led = z;
        this.lee = str;
        this.lef = str2;
        this.leg = str3;
        this.lei = i;
        this.lej = aso;
        this.leh = str4;
        this.leb = true;
        this.lec = false;
    }

    public SightCaptureResult(boolean z, String str) {
        this.led = z;
        this.lek = str;
        this.leb = false;
        this.lec = true;
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        this.leb = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.lec = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.led = z;
        this.lee = parcel.readString();
        this.lef = parcel.readString();
        this.leg = parcel.readString();
        this.leh = parcel.readString();
        this.lei = parcel.readInt();
        this.lek = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.lej = new aso();
            this.lej.aG(bArr);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[]{e.getMessage()});
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.leb ? 1 : 0));
        if (this.lec) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.led) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.lee);
        parcel.writeString(this.lef);
        parcel.writeString(this.leg);
        parcel.writeString(this.leh);
        parcel.writeInt(this.lei);
        parcel.writeString(this.lek);
        try {
            byte[] toByteArray = this.lej.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "write ext info error");
        }
    }
}
