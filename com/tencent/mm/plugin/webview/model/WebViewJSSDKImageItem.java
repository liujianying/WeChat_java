package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new 1();

    public WebViewJSSDKImageItem() {
        this.bMT = 1;
    }

    public final void bUl() {
        if (new File(this.fnM).exists()) {
            this.fOs = aj.Qr(System.currentTimeMillis());
            Bitmap a = c.a(this.fnM, 640, 640, false, null, 0);
            if (a != null) {
                x.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                a = c.b(a, (float) ExifHelper.VX(this.fnM));
                if (a != null) {
                    try {
                        c.a(a, 100, CompressFormat.JPEG, this.fOs, true);
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[]{e.getMessage()});
                    }
                }
            }
            x.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[]{this.fOs});
            return;
        }
        x.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
    }

    public final WebViewJSSDKFileItem bUh() {
        this.bNH = aj.Qt(this.fnM);
        bUl();
        return this;
    }

    public final String bUi() {
        return "jpeg";
    }

    public final String bUj() {
        return "image";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }
}
