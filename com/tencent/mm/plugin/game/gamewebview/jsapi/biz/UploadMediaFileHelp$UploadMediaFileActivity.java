package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class UploadMediaFileHelp$UploadMediaFileActivity extends GameProcessActivityTask {
    public static final Creator<UploadMediaFileHelp$UploadMediaFileActivity> CREATOR = new 2();
    public String appId;
    public Runnable fFC;
    private a jHN;
    public String jHO;
    public boolean jHP;
    public String jHQ;
    public boolean jHR;
    public String mediaId;

    /* synthetic */ UploadMediaFileHelp$UploadMediaFileActivity(Parcel parcel, byte b) {
        this(parcel);
    }

    static /* synthetic */ void a(UploadMediaFileHelp$UploadMediaFileActivity uploadMediaFileHelp$UploadMediaFileActivity, GameProcessActivityTask.a aVar, String str, String str2) {
        uploadMediaFileHelp$UploadMediaFileActivity.mediaId = str;
        uploadMediaFileHelp$UploadMediaFileActivity.jHQ = str2;
        uploadMediaFileHelp$UploadMediaFileActivity.jHR = true;
        aVar.ahz();
    }

    private void a(GameProcessActivityTask.a aVar) {
        this.jHR = false;
        aVar.ahz();
    }

    public final void a(Context context, GameProcessActivityTask.a aVar) {
        x.i("MicroMsg.UploadMediaFileActivity", "runInMainProcess");
        if (this.jHN == null) {
            this.jHN = new 1(this, aVar);
        }
        WebViewJSSDKFileItem Qq = e.bUX().Qq(this.jHO);
        if (Qq == null) {
            a(aVar);
            return;
        }
        switch (Qq.bMT) {
            case 1:
                UploadMediaFileHelp.a(context, Qq, this.appId, this.jHO, b.dOq, this.jHP, this.jHN);
                return;
            case 4:
                UploadMediaFileHelp.a(context, this.appId, this.jHO, b.dOr, this.jHP, this.jHN);
                return;
            default:
                UploadMediaFileHelp.a(context, this.appId, this.jHO, b.dOr, this.jHP, this.jHN);
                return;
        }
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.jHO = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.jHP = z;
        this.mediaId = parcel.readString();
        this.jHQ = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.jHR = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.jHO);
        parcel.writeString(this.appId);
        if (this.jHP) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.jHQ);
        if (!this.jHR) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public UploadMediaFileHelp$UploadMediaFileActivity(MMActivity mMActivity) {
        super(mMActivity);
    }

    private UploadMediaFileHelp$UploadMediaFileActivity(Parcel parcel) {
        g(parcel);
    }
}
