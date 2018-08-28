package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebViewJSSDKVideoItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKVideoItem> CREATOR = new 1();
    public int duration;
    public int height;
    public int size;
    public int width;

    public WebViewJSSDKVideoItem() {
        this.bMT = 4;
    }

    public final WebViewJSSDKFileItem bUh() {
        this.bNH = aj.Qt(this.fnM);
        return this;
    }

    public final String bUi() {
        return "mp4";
    }

    public final String bUj() {
        return "video";
    }

    protected WebViewJSSDKVideoItem(Parcel parcel) {
        super(parcel);
        this.bMT = parcel.readInt();
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.bMT);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
