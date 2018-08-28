package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class UploadMediaFileHelp$UploadMediaFileTask extends GWMainProcessTask {
    public static final Creator<UploadMediaFileHelp$UploadMediaFileTask> CREATOR = new 2();
    public String appId;
    public Runnable fFC;
    private a jHN;
    public String jHO;
    public String jHQ;
    public String mediaId;
    public boolean success;

    /* synthetic */ UploadMediaFileHelp$UploadMediaFileTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.UploadMediaTask", "runInMainProcess");
        if (this.jHN == null) {
            this.jHN = new 1(this);
        }
        WebViewJSSDKFileItem Qq = e.bUX().Qq(this.jHO);
        if (Qq == null) {
            ahH();
            return;
        }
        switch (Qq.bMT) {
            case 1:
                UploadMediaFileHelp.a(ad.getContext(), Qq, this.appId, this.jHO, b.dOq, false, this.jHN);
                return;
            case 4:
                UploadMediaFileHelp.a(ad.getContext(), this.appId, this.jHO, b.dOr, false, this.jHN);
                return;
            default:
                UploadMediaFileHelp.a(ad.getContext(), this.appId, this.jHO, b.dOr, false, this.jHN);
                return;
        }
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.jHO = parcel.readString();
        this.appId = parcel.readString();
        this.mediaId = parcel.readString();
        this.jHQ = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jHO);
        parcel.writeString(this.appId);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.jHQ);
        parcel.writeByte((byte) (this.success ? 1 : 0));
    }

    private UploadMediaFileHelp$UploadMediaFileTask(Parcel parcel) {
        g(parcel);
    }
}
