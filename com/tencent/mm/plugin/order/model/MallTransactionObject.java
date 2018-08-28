package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new Creator<MallTransactionObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallTransactionObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }
    };
    public int bCK;
    public int bID;
    public String bOe;
    public int dTR;
    public String desc;
    public String fqJ;
    public double hUL = 0.0d;
    public int lNG;
    public String lNH;
    public String lNI;
    public String lNJ;
    public String lNK;
    public String lNL;
    public String lNM;
    public String lNN;
    public String lNO;
    public String lNP;
    public String lNQ;
    public int lNR;
    public String lNS;
    public String lNT;
    public String lNU;
    public String lNV;
    public String lNW;
    public String lNX;
    public String lNY;
    public String lNZ;
    public List<HelpCenter> lNv = new LinkedList();
    public int lNw = -1;
    public String lNy;
    public String lOa;
    public double lOb;
    public String lOc;
    public String lOd;
    public String lOe;
    public String lOf;
    public String lOg;
    public int lOh;
    public int lOi;
    public double lOj;
    public String lOk;
    public int lOl;
    public String lOm;
    public int lOn;
    public int lOo;
    public int lOp;
    public String lOq;
    public String lOr;
    public String lOs;
    public String lOt;
    public String lOu;
    public String lOv;
    public double lOw;
    public String lOx;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject(Parcel parcel) {
        this.bID = parcel.readInt();
        this.lNG = parcel.readInt();
        this.bCK = parcel.readInt();
        this.lNH = parcel.readString();
        this.lNI = parcel.readString();
        this.lNJ = parcel.readString();
        this.lNK = parcel.readString();
        this.desc = parcel.readString();
        this.lNL = parcel.readString();
        this.lNM = parcel.readString();
        this.hUL = parcel.readDouble();
        this.lNN = parcel.readString();
        this.lNO = parcel.readString();
        this.lNP = parcel.readString();
        this.lNQ = parcel.readString();
        this.dTR = parcel.readInt();
        this.lNR = parcel.readInt();
        this.bOe = parcel.readString();
        this.lNS = parcel.readString();
        this.lNT = parcel.readString();
        this.lNV = parcel.readString();
        this.lNW = parcel.readString();
        this.lNy = parcel.readString();
        this.lNX = parcel.readString();
        this.fqJ = parcel.readString();
        this.lNY = parcel.readString();
        this.lNZ = parcel.readString();
        this.lOa = parcel.readString();
        this.lOb = parcel.readDouble();
        this.lOc = parcel.readString();
        this.lOd = parcel.readString();
        this.lOe = parcel.readString();
        this.lOf = parcel.readString();
        this.lOh = parcel.readInt();
        this.lOn = parcel.readInt();
        this.lOj = parcel.readDouble();
        this.lOk = parcel.readString();
        this.lOl = parcel.readInt();
        this.lOm = parcel.readString();
        this.lOn = parcel.readInt();
        this.lOo = parcel.readInt();
        this.lOp = parcel.readInt();
        this.lOq = parcel.readString();
        this.lOr = parcel.readString();
        this.lOs = parcel.readString();
        this.lOt = parcel.readString();
        this.lOu = parcel.readString();
        this.lOv = parcel.readString();
        this.lOw = parcel.readDouble();
        this.lOx = parcel.readString();
        this.lOg = parcel.readString();
        this.lNw = parcel.readInt();
        int readInt = parcel.readInt();
        this.lNv = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.lNv.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bID);
        parcel.writeInt(this.lNG);
        parcel.writeInt(this.bCK);
        parcel.writeString(this.lNH);
        parcel.writeString(this.lNI);
        parcel.writeString(this.lNJ);
        parcel.writeString(this.lNK);
        parcel.writeString(this.desc);
        parcel.writeString(this.lNL);
        parcel.writeString(this.lNM);
        parcel.writeDouble(this.hUL);
        parcel.writeString(this.lNN);
        parcel.writeString(this.lNO);
        parcel.writeString(this.lNP);
        parcel.writeString(this.lNQ);
        parcel.writeInt(this.dTR);
        parcel.writeInt(this.lNR);
        parcel.writeString(this.bOe);
        parcel.writeString(this.lNS);
        parcel.writeString(this.lNT);
        parcel.writeString(this.lNV);
        parcel.writeString(this.lNW);
        parcel.writeString(this.lNy);
        parcel.writeString(this.lNX);
        parcel.writeString(this.fqJ);
        parcel.writeString(this.lNY);
        parcel.writeString(this.lNZ);
        parcel.writeString(this.lOa);
        parcel.writeDouble(this.lOb);
        parcel.writeString(this.lOc);
        parcel.writeString(this.lOd);
        parcel.writeString(this.lOe);
        parcel.writeString(this.lOf);
        parcel.writeInt(this.lOh);
        parcel.writeInt(this.lOn);
        parcel.writeDouble(this.lOj);
        parcel.writeString(this.lOk);
        parcel.writeInt(this.lOl);
        parcel.writeString(this.lOm);
        parcel.writeInt(this.lOn);
        parcel.writeInt(this.lOo);
        parcel.writeInt(this.lOp);
        parcel.writeString(this.lOq);
        parcel.writeString(this.lOr);
        parcel.writeString(this.lOs);
        parcel.writeString(this.lOt);
        parcel.writeString(this.lOu);
        parcel.writeString(this.lOv);
        parcel.writeDouble(this.lOw);
        parcel.writeString(this.lOx);
        parcel.writeString(this.lOg);
        parcel.writeInt(this.lNw);
        parcel.writeInt(this.lNv.size());
        for (HelpCenter writeParcelable : this.lNv) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public static MallTransactionObject U(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MallTransactionObject mallTransactionObject = new MallTransactionObject();
        mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
        mallTransactionObject.bID = jSONObject.optInt("sub_pay_type", 0);
        mallTransactionObject.lNG = jSONObject.optInt("pay_scene");
        mallTransactionObject.bCK = jSONObject.optInt("user_type");
        mallTransactionObject.lNH = jSONObject.optString("buy_uin");
        mallTransactionObject.lNI = jSONObject.optString("buy_name");
        mallTransactionObject.lNJ = jSONObject.optString("sale_uin");
        mallTransactionObject.lNK = jSONObject.optString("sale_name");
        mallTransactionObject.bOe = jSONObject.optString("trans_id");
        mallTransactionObject.lNS = jSONObject.optString("sp_billno");
        mallTransactionObject.desc = jSONObject.optString("goods_name");
        mallTransactionObject.lNL = jSONObject.optString("goods_detail");
        mallTransactionObject.hUL = jSONObject.optDouble("fee") / 100.0d;
        mallTransactionObject.lNN = jSONObject.optString("fee_color");
        mallTransactionObject.lNO = jSONObject.optString("trade_state");
        mallTransactionObject.lNP = jSONObject.optString("trade_state_name");
        mallTransactionObject.lNQ = jSONObject.optString("trade_state_color");
        mallTransactionObject.lNT = jSONObject.optString("buy_bank_name");
        mallTransactionObject.lNU = jSONObject.optString("card_tail");
        mallTransactionObject.dTR = jSONObject.optInt("create_timestamp");
        mallTransactionObject.lNR = jSONObject.optInt("modify_timestamp");
        mallTransactionObject.lNV = jSONObject.optString("fee_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
        if (optJSONObject != null) {
            mallTransactionObject.lNW = optJSONObject.optString("app_username");
            mallTransactionObject.lNy = optJSONObject.optString("app_telephone");
            mallTransactionObject.lNX = optJSONObject.optString("app_nickname");
            mallTransactionObject.fqJ = optJSONObject.optString("app_icon_url");
            mallTransactionObject.lOf = optJSONObject.optString("safeguard_url");
            mallTransactionObject.lOg = optJSONObject.optString("display_name");
        }
        mallTransactionObject.lNY = jSONObject.optString("deliver_price");
        mallTransactionObject.lNZ = jSONObject.optString("preferential_price");
        mallTransactionObject.lOa = jSONObject.optString("discount");
        mallTransactionObject.lOb = jSONObject.optDouble("original_total_fee") / 100.0d;
        mallTransactionObject.lOc = jSONObject.optString("total_price");
        mallTransactionObject.lOd = jSONObject.optString("receipt_company");
        mallTransactionObject.lOe = jSONObject.optString("biz_pledge");
        mallTransactionObject.lOh = jSONObject.optInt("pre_fetch_timestamp");
        mallTransactionObject.lOi = jSONObject.optInt("arrived_timestamp");
        mallTransactionObject.lOj = jSONObject.optDouble("transfer_fee") / 100.0d;
        mallTransactionObject.lOk = jSONObject.optString("receiver_name");
        mallTransactionObject.lOl = jSONObject.optInt("allow_resend_msg");
        mallTransactionObject.lOm = jSONObject.optString("charge_fee");
        mallTransactionObject.lOn = jSONObject.optInt("receive_timestamp");
        mallTransactionObject.lOo = jSONObject.optInt("refund_timestamp");
        mallTransactionObject.lOp = jSONObject.optInt("create_timestamp");
        mallTransactionObject.lOq = jSONObject.optString("buy_bank_type");
        mallTransactionObject.lOr = jSONObject.optString("payer_name");
        mallTransactionObject.lOs = jSONObject.optString("true_name");
        mallTransactionObject.lOt = jSONObject.optString("refund_bank_type");
        mallTransactionObject.lOu = jSONObject.optString("rateinfo");
        mallTransactionObject.lOv = jSONObject.optString("original_feeinfo");
        mallTransactionObject.lOw = jSONObject.optDouble("fetch_total_fee") / 100.0d;
        mallTransactionObject.lOx = jSONObject.optString("fetch_total_fee_color");
        mallTransactionObject.lNw = jSONObject.optInt("userroll_type");
        mallTransactionObject.lNv = V(jSONObject);
        return mallTransactionObject;
    }

    private static List<HelpCenter> V(JSONObject jSONObject) {
        List<HelpCenter> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.bIq = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                linkedList.add(helpCenter);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            x.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[]{e.getMessage()});
        }
        return linkedList;
    }
}
