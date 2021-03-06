package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;

public class WebViewStubCallbackWrapper implements Parcelable {
    public static final Creator<WebViewStubCallbackWrapper> CREATOR = new 1();
    public int id;
    public e pXx;

    public WebViewStubCallbackWrapper(e eVar, int i) {
        this.pXx = eVar;
        this.id = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.pXx.asBinder());
    }

    private WebViewStubCallbackWrapper(IBinder iBinder) {
        this.pXx = a.Z(iBinder);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WebViewStubCallbackWrapper) && ((WebViewStubCallbackWrapper) obj).id == this.id) {
            return true;
        }
        return false;
    }
}
