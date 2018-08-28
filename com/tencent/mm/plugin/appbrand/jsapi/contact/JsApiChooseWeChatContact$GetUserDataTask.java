package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.aa.j;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bi;

class JsApiChooseWeChatContact$GetUserDataTask extends MainProcessTask {
    public static final Creator<JsApiChooseWeChatContact$GetUserDataTask> CREATOR = new 1();
    String bgn;
    String bgo;
    String eTp = "";
    public String fPm;
    public String userName;

    public JsApiChooseWeChatContact$GetUserDataTask(String str) {
        this.userName = str;
    }

    public JsApiChooseWeChatContact$GetUserDataTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        this.fPm = q.GF();
        if (!TextUtils.isEmpty(this.userName)) {
            this.bgn = r.gS(this.userName);
            this.bgo = r.gU(this.userName);
            j kc = com.tencent.mm.aa.q.KH().kc(this.userName);
            if (kc != null) {
                this.eTp = kc.Kx();
                if (bi.oW(this.eTp)) {
                    this.eTp = kc.Ky();
                }
            }
        }
    }

    public final void g(Parcel parcel) {
        this.fPm = parcel.readString();
        this.userName = parcel.readString();
        this.bgn = parcel.readString();
        this.bgo = parcel.readString();
        this.eTp = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fPm);
        parcel.writeString(this.userName);
        parcel.writeString(this.bgn);
        parcel.writeString(this.bgo);
        parcel.writeString(this.eTp);
    }
}
