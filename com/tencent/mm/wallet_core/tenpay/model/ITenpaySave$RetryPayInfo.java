package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class ITenpaySave$RetryPayInfo implements Parcelable {
    public static final Creator<ITenpaySave$RetryPayInfo> CREATOR = new 1();
    public int uXS;
    public int uXT;
    public String uXU;

    public ITenpaySave$RetryPayInfo() {
        this.uXS = -1;
        this.uXT = -1;
        this.uXU = "";
    }

    protected ITenpaySave$RetryPayInfo(Parcel parcel) {
        this.uXS = parcel.readInt();
        this.uXT = parcel.readInt();
        this.uXU = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uXS);
        parcel.writeInt(this.uXT);
        parcel.writeString(this.uXU);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean cDx() {
        if (this.uXS == -1 || this.uXT == -1) {
            return false;
        }
        return true;
    }

    public final void ag(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
            if (optJSONObject != null) {
                this.uXS = optJSONObject.optInt("retry_interval", -1);
                this.uXT = optJSONObject.optInt("max_retry_count", -1);
                this.uXU = optJSONObject.optString("retry_fail_wording", "");
            }
        }
    }
}
