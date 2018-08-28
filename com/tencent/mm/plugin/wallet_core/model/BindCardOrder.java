package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.n.a;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class BindCardOrder implements Parcelable {
    public static final Creator<BindCardOrder> CREATOR = new 1();
    public static int pmB = 1;
    public static int pmC = 2;
    public static int pmD = 6;
    public int jumpType;
    public String lMV;
    private String pmA = "";
    public int pmE;
    public String pmF = "";
    public String pmG = "";
    public String pmH = "";
    public String pmI = "";
    public String pmJ = "";
    public int pmK;
    public int pmL;
    public n pmM;
    public a pmN;
    public b pmO;

    protected BindCardOrder(Parcel parcel) {
        this.pmA = parcel.readString();
        try {
            af(new JSONObject(this.pmA));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pmA);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean bOy() {
        return this.jumpType == pmB && this.pmN != null;
    }

    public final boolean bOz() {
        return this.jumpType == pmD && this.pmN != null;
    }

    public final void af(JSONObject jSONObject) {
        this.pmA = jSONObject == null ? "" : jSONObject.toString();
        x.i("MicroMsg.BindCardOrder", "feed json %s", new Object[]{this.pmA});
        try {
            this.pmE = jSONObject.optInt("show_bind_succ_page", 0);
            this.pmF = jSONObject.optString("bind_succ_btn_wording", "");
            this.pmG = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.pmJ = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.pmM = new n();
            if (optJSONObject != null) {
                n nVar = this.pmM;
                nVar.pji = optJSONObject.optLong("activity_id");
                nVar.poB = optJSONObject.optLong("activity_type", 0);
                nVar.poC = optJSONObject.optLong("award_id");
                nVar.poD = optJSONObject.optInt("send_record_id");
                nVar.poE = optJSONObject.optInt("user_record_id");
                nVar.poF = optJSONObject.optLong("activity_mch_id", 0);
            }
            optJSONObject = jSONObject.optJSONObject("h5_info");
            if (optJSONObject != null) {
                this.pmN = new a();
                this.pmN.ag(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("native_info");
            if (optJSONObject != null) {
                this.pmN = new a();
                this.pmN.ag(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject != null) {
                this.pmO = new b();
                b bVar = this.pmO;
                bVar.poI = optJSONObject.optString("tinyapp_name");
                bVar.poJ = optJSONObject.optString("tinyapp_logo");
                bVar.poK = optJSONObject.optString("tinyapp_desc");
                bVar.paD = optJSONObject.optString("tinyapp_username");
                bVar.paE = optJSONObject.optString("tinyapp_path");
                bVar.poL = optJSONObject.optString("activity_tinyapp_btn_text");
                bVar.poM = optJSONObject.optInt("tinyapp_version", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }
}
