package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class WebViewStubTempUI$StartActivityForResultTask implements Parcelable {
    public static final Creator<WebViewStubTempUI$StartActivityForResultTask> CREATOR = new Creator<WebViewStubTempUI$StartActivityForResultTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewStubTempUI$StartActivityForResultTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewStubTempUI$StartActivityForResultTask[i];
        }
    };
    int bRZ;
    String mOg;
    int pSV;
    String pVe;
    Intent pVf;
    boolean pVg;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOg);
        parcel.writeString(this.pVe);
        parcel.writeParcelable(this.pVf, i);
        parcel.writeInt(this.bRZ);
        parcel.writeByte(this.pVg ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.pSV);
    }

    WebViewStubTempUI$StartActivityForResultTask() {
    }

    WebViewStubTempUI$StartActivityForResultTask(Parcel parcel) {
        this.mOg = parcel.readString();
        this.pVe = parcel.readString();
        this.pVf = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.bRZ = parcel.readInt();
        this.pVg = parcel.readByte() != (byte) 0;
        this.pSV = parcel.readInt();
    }
}
