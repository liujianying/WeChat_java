package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKUpFileItem> CREATOR = new 1();
    public int fileType;
    public String jIf;

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.bMT = 3;
    }

    public final WebViewJSSDKFileItem bUh() {
        this.bNH = aj.Qt(this.fnM);
        return this;
    }

    public final void c(keep_SceneResult keep_sceneresult) {
        super.c(keep_sceneresult);
        List arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.jIf);
        arrayList.add(keep_sceneresult.field_fileId);
        arrayList.add(keep_sceneresult.field_aesKey);
        arrayList.add(keep_sceneresult.field_fileLength);
        Context context = ad.getContext();
        if (ao.isWifi(context)) {
            arrayList.add("1");
        } else if (ao.is3G(context)) {
            arrayList.add("4");
        } else if (ao.is4G(context)) {
            arrayList.add("5");
        } else if (ao.is2G(context)) {
            arrayList.add("3");
        } else if (ao.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        x.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[]{Integer.valueOf(this.fileType), this.jIf, keep_sceneresult.field_fileId});
        h hVar = h.mEJ;
        h.e(12018, arrayList);
        String str = this.fnM;
        if (!bi.oW(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final String bUi() {
        return "file";
    }

    public final String bUj() {
        return "nomal";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    private WebViewJSSDKUpFileItem(byte b) {
        this.fileType = -1;
    }
}
