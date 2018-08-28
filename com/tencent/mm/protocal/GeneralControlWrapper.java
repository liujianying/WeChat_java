package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.x;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new Creator<GeneralControlWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeneralControlWrapper(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }
    };
    public static final GeneralControlWrapper qVX = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper qVY = new GeneralControlWrapper(1);
    public int qVZ;

    /* synthetic */ GeneralControlWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public GeneralControlWrapper(yl ylVar) {
        this.qVZ = ylVar.rEl;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public GeneralControlWrapper(int i) {
        this.qVZ = i;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public final boolean cgf() {
        boolean z = (this.qVZ & 8192) != 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + z);
        return z;
    }

    public final boolean cgg() {
        boolean z = (this.qVZ & 2) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + z);
        return z;
    }

    public final boolean cgh() {
        boolean z = (this.qVZ & 64) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + z);
        return z;
    }

    public final boolean cgi() {
        boolean z = (this.qVZ & 2048) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean cgj() {
        boolean z = (this.qVZ & 16384) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean cgk() {
        boolean z = (this.qVZ & 32768) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = " + z);
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.qVZ));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.qVZ);
    }

    private GeneralControlWrapper(Parcel parcel) {
        this.qVZ = parcel.readInt();
    }
}
