package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.q;

public class WebViewJSSDKVoiceItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKVoiceItem> CREATOR = new Creator<WebViewJSSDKVoiceItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKVoiceItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVoiceItem[i];
        }
    };

    public WebViewJSSDKVoiceItem() {
        this.bMT = 2;
    }

    public final WebViewJSSDKFileItem bUh() {
        this.fnM = q.getFullPath(this.fileName);
        this.bNH = aj.Qt(this.fnM);
        return this;
    }

    public final String bUi() {
        return "speex";
    }

    public final String bUj() {
        return "voice";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKVoiceItem(Parcel parcel) {
        super(parcel);
    }
}
