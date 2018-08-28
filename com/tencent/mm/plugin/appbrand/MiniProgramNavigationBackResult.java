package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult implements Parcelable {
    public static final Creator<MiniProgramNavigationBackResult> CREATOR = new 1();
    public JSONObject fei;
    public JSONObject fej;

    /* synthetic */ MiniProgramNavigationBackResult(Parcel parcel, byte b) {
        this(parcel);
    }

    public static MiniProgramNavigationBackResult a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return null;
        }
        MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            jSONObject3 = jSONObject;
        }
        miniProgramNavigationBackResult.fei = jSONObject3;
        jSONObject3 = new JSONObject();
        if (jSONObject2 != null) {
            jSONObject3 = jSONObject2;
        }
        miniProgramNavigationBackResult.fej = jSONObject3;
        return miniProgramNavigationBackResult;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        parcel.writeString(this.fei == null ? null : this.fei.toString());
        if (this.fej != null) {
            str = this.fej.toString();
        }
        parcel.writeString(str);
    }

    private MiniProgramNavigationBackResult(Parcel parcel) {
        try {
            this.fei = new JSONObject(bi.aG(parcel.readString(), "{}"));
            this.fej = new JSONObject(bi.aG(parcel.readString(), "{}"));
        } catch (JSONException e) {
            x.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[]{e});
        }
    }
}
