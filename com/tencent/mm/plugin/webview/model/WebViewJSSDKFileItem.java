package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class WebViewJSSDKFileItem implements Parcelable {
    public String appId;
    public int bMT;
    public String bNH;
    public String fOs;
    public String fileName;
    public String fnM;
    public String fnN;
    public boolean fnP;
    public boolean fnQ = true;
    public boolean fnR = true;
    public String mediaId;
    public a pRN;

    public abstract WebViewJSSDKFileItem bUh();

    public abstract String bUi();

    public abstract String bUj();

    public static WebViewJSSDKFileItem Qn(String str) {
        WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.fnM = str;
        webViewJSSDKImageItem.bUh();
        webViewJSSDKImageItem.mediaId = d.a("jsupimg", bi.VF(), webViewJSSDKImageItem.bNH, webViewJSSDKImageItem.bNH);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem Qo(String str) {
        WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.bUh();
        webViewJSSDKVoiceItem.mediaId = d.a("jsupvoice", bi.VF(), webViewJSSDKVoiceItem.bNH, webViewJSSDKVoiceItem.bNH);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem y(int i, String str, String str2) {
        WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.jIf = str;
        webViewJSSDKUpFileItem.fnM = str2;
        webViewJSSDKUpFileItem.bUh();
        webViewJSSDKUpFileItem.mediaId = d.a("jsupfile", bi.VF(), webViewJSSDKUpFileItem.bNH, webViewJSSDKUpFileItem.bNH);
        x.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[]{Integer.valueOf(i), str2, webViewJSSDKUpFileItem.bNH});
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem Qp(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.fnM = str;
        webViewJSSDKVideoItem.bUh();
        webViewJSSDKVideoItem.mediaId = d.a("jsvideofile", bi.VF(), webViewJSSDKVideoItem.bNH, webViewJSSDKVideoItem.bNH);
        x.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[]{str, webViewJSSDKVideoItem.bNH, webViewJSSDKVideoItem.mediaId});
        return webViewJSSDKVideoItem;
    }

    public void c(keep_SceneResult keep_sceneresult) {
        if (this.pRN == null) {
            this.pRN = new a();
        }
        if (keep_sceneresult == null) {
            x.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.pRN.field_aesKey = keep_sceneresult.field_aesKey;
        this.pRN.field_fileId = keep_sceneresult.field_fileId;
        this.pRN.field_fileUrl = keep_sceneresult.field_fileUrl;
        this.pRN.field_fileLength = keep_sceneresult.field_fileLength;
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.bNH = parcel.readString();
        this.fOs = parcel.readString();
        this.fnM = parcel.readString();
        this.bMT = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.bNH);
        parcel.writeString(this.fOs);
        parcel.writeString(this.fnM);
        parcel.writeInt(this.bMT);
    }
}
