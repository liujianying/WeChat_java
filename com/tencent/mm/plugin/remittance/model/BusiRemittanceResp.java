package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp implements Parcelable {
    public static final Creator<BusiRemittanceResp> CREATOR = new 1();
    public int mwN = 0;
    public String mwO = "";
    public String mwP = "";
    public int mwQ;
    public String mwR;
    public String mwS;
    public List<xc> mwT = new LinkedList();
    public jc mwU;
    public int mwV = 0;
    public int mwW = 0;
    public int mwX = 400;

    BusiRemittanceResp() {
    }

    BusiRemittanceResp(JSONObject jSONObject) {
        this.mwN = jSONObject.optInt("show_photo", 0);
        this.mwO = jSONObject.optString("photo_url", "");
        this.mwP = jSONObject.optString("favor_desc", "");
        this.mwQ = jSONObject.optInt("scan_scene", 0);
        this.mwR = jSONObject.optString("favor_req_sign", "");
        this.mwS = jSONObject.optString("favor_req_extend", "");
        this.mwV = jSONObject.optInt("get_favor_flag", 0);
        this.mwW = jSONObject.optInt("photo_style", 0);
        this.mwX = jSONObject.optInt("get_favor_interval", 400);
        this.mwT = b.q(jSONObject.optJSONArray("favor_list"));
        JSONObject optJSONObject = jSONObject.optJSONObject("favor_comm_resp");
        if (optJSONObject != null) {
            this.mwU = new jc();
            this.mwU.rkv = optJSONObject.optString("default_fav_compose_id");
            this.mwU.rkt = b.q(optJSONObject.optJSONArray("favor_info_list"));
            this.mwU.rkw = optJSONObject.optString("favor_resp_sign");
            this.mwU.rkx = optJSONObject.optString("no_compose_wording");
            this.mwU.rku = b.p(optJSONObject.optJSONArray("favor_compose_result_list"));
        }
    }

    protected BusiRemittanceResp(Parcel parcel) {
        int readInt;
        byte[] bArr;
        this.mwN = parcel.readInt();
        this.mwO = parcel.readString();
        this.mwP = parcel.readString();
        this.mwQ = parcel.readInt();
        this.mwR = parcel.readString();
        this.mwS = parcel.readString();
        this.mwV = parcel.readInt();
        this.mwW = parcel.readInt();
        this.mwX = parcel.readInt();
        this.mwT = new LinkedList();
        int readInt2 = parcel.readInt();
        for (int i = 0; i < readInt2; i++) {
            readInt = parcel.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                try {
                    xc xcVar = new xc();
                    xcVar.aG(bArr);
                    this.mwT.add(xcVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                }
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            this.mwU = new jc();
            try {
                this.mwU.aG(bArr);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte[] toByteArray;
        parcel.writeInt(this.mwN);
        parcel.writeString(this.mwO);
        parcel.writeString(this.mwP);
        parcel.writeInt(this.mwQ);
        parcel.writeString(this.mwR);
        parcel.writeString(this.mwS);
        parcel.writeInt(this.mwV);
        parcel.writeInt(this.mwW);
        parcel.writeInt(this.mwX);
        parcel.writeInt(this.mwT.size());
        if (this.mwT.size() > 0) {
            for (int i2 = 0; i2 < this.mwT.size(); i2++) {
                byte[] bArr = new byte[0];
                try {
                    toByteArray = ((xc) this.mwT.get(i2)).toByteArray();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                    toByteArray = bArr;
                }
                parcel.writeInt(toByteArray.length);
                if (toByteArray.length > 0) {
                    parcel.writeByteArray(toByteArray);
                }
            }
        }
        toByteArray = new byte[0];
        try {
            toByteArray = this.mwU.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
        }
        parcel.writeInt(toByteArray.length);
        if (toByteArray.length > 0) {
            parcel.writeByteArray(toByteArray);
        }
    }

    public int describeContents() {
        return 0;
    }
}
