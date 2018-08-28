package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class Bankcard extends ei implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Bankcard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }
    };
    public static a dhO;
    public static int plI = 1;
    public static int plJ = 2;
    public static int plK = 4;
    public static int plL = 8;
    public static int plM = 16;
    public static int plN = 32;
    public static int plO = 64;
    public static int plP = 128;
    public boolean btA;
    public String plQ;
    public String plR;
    public String plS;
    public String plT;
    public String plU;
    public double plV;
    public String plW;
    public double plX;
    public String plY;
    public String plZ;
    public int pll;
    public String pln;
    public String pma;
    public String pmb;
    public e pmc;
    public long pmd;
    public long pme;
    public long pmf;
    public String pmg;
    public int pmh;
    public int pmi;
    public String pmj;
    public String pmk;
    public int pml;

    static {
        a aVar = new a();
        aVar.sKy = new Field[39];
        aVar.columns = new String[40];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bindSerial";
        aVar.sKA.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "bindSerial";
        aVar.columns[1] = "cardType";
        aVar.sKA.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "bankcardState";
        aVar.sKA.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "forbidWord";
        aVar.sKA.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bankName";
        aVar.sKA.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "bankcardType";
        aVar.sKA.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bankcardTypeName";
        aVar.sKA.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bankcardTag";
        aVar.sKA.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "bankcardTail";
        aVar.sKA.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "supportTag";
        aVar.sKA.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "mobile";
        aVar.sKA.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "trueName";
        aVar.sKA.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "desc";
        aVar.sKA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bankPhone";
        aVar.sKA.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bizUsername";
        aVar.sKA.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "onceQuotaKind";
        aVar.sKA.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[16] = "onceQuotaVirtual";
        aVar.sKA.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[17] = "dayQuotaKind";
        aVar.sKA.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[18] = "dayQuotaVirtual";
        aVar.sKA.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[19] = "fetchArriveTime";
        aVar.sKA.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[20] = "fetchArriveTimeWording";
        aVar.sKA.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "repay_url";
        aVar.sKA.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "wxcreditState";
        aVar.sKA.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "bankcardClientType";
        aVar.sKA.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "ext_msg";
        aVar.sKA.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "support_micropay";
        aVar.sKA.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "arrive_type";
        aVar.sKA.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "avail_save_wording";
        aVar.sKA.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[28] = "fetch_charge_rate";
        aVar.sKA.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[29] = "full_fetch_charge_fee";
        aVar.sKA.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[30] = "fetch_charge_info";
        aVar.sKA.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tips";
        aVar.sKA.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "forbid_title";
        aVar.sKA.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "forbid_url";
        aVar.sKA.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "no_micro_word";
        aVar.sKA.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "card_bottom_wording";
        aVar.sKA.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "support_lqt_turn_in";
        aVar.sKA.put("support_lqt_turn_in", "INTEGER");
        stringBuilder.append(" support_lqt_turn_in INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "support_lqt_turn_out";
        aVar.sKA.put("support_lqt_turn_out", "INTEGER");
        stringBuilder.append(" support_lqt_turn_out INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "is_hightlight_pre_arrive_time_wording";
        aVar.sKA.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        stringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        aVar.columns[39] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public Bankcard() {
        this.plU = null;
        this.pmb = null;
        this.btA = false;
    }

    public Bankcard(byte b) {
        this.plU = null;
        this.pmb = null;
        this.btA = false;
        this.field_bankcardTag = 1;
    }

    public static boolean dY(int i, int i2) {
        x.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        return (i & i2) > 0;
    }

    public static boolean zj(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        if (this.field_bankcardState != 0) {
            x.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            return this.field_bankcardState;
        } else if (orders != null && orders.bOd.equals(this.plU)) {
            return 4;
        } else {
            int i2;
            if ((this.field_bankcardTag & i) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (bOv()) {
                    return 5;
                }
                return 6;
            } else if (orders == null || orders.ppc.isEmpty() || orders.ppc.contains(this.field_bankcardType)) {
                return 0;
            } else {
                return 7;
            }
        }
    }

    public static String P(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(i.wallet_pay_bankcard_expired_tips);
            case 2:
                return context.getString(i.wallet_pay_bankcard_maintenance_tips);
            case 3:
                return context.getString(i.wallet_pay_bankcard_quota_tips);
            case 4:
                return context.getString(i.wallet_pay_bankcard_insufficient_balance_tips);
            case 5:
                return context.getString(i.wallet_pay_bankcard_domestic_tips);
            case 6:
                return context.getString(i.wallet_pay_bankcard_international_tips);
            case 7:
                return context.getString(i.wallet_pay_bankcard_not_support_bankcard_tips);
            default:
                return context.getString(i.wallet_pay_bankcard_not_exist_tips);
        }
    }

    public final boolean bOr() {
        boolean z = (this.field_cardType & plK) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bOs() {
        boolean z = (this.field_cardType & plL) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bOt() {
        boolean z = (this.field_cardType & plO) > 0;
        x.d("MicroMsg.Bankcard", "isLqtCard, ret = " + z);
        return z;
    }

    public final boolean bOu() {
        boolean z = (this.field_cardType & plJ) > 0;
        x.d("MicroMsg.Bankcard", "isCredit, ret = " + z);
        return z;
    }

    public final boolean bOv() {
        boolean z = (this.field_cardType & plI) <= 0;
        x.d("MicroMsg.Bankcard", "isDomestic, ret = " + z);
        return z;
    }

    public final boolean bOw() {
        return (this.field_cardType & plP) > 0;
    }

    protected final a AX() {
        return dhO;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        this.plU = null;
        this.pmb = null;
        this.btA = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.btA = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.plU = parcel.readString();
        this.pll = parcel.readInt();
        this.pmb = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
        this.pmg = parcel.readString();
        this.pmd = parcel.readLong();
        this.pmf = parcel.readLong();
        this.pme = parcel.readLong();
        this.pmh = parcel.readInt();
        this.pml = parcel.readInt();
        this.pmi = parcel.readInt();
        this.pmj = parcel.readString();
        this.pmk = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.btA ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.plU);
        parcel.writeInt(this.pll);
        parcel.writeString(this.pmb);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
        parcel.writeString(this.pmg);
        parcel.writeLong(this.pmd);
        parcel.writeLong(this.pmf);
        parcel.writeLong(this.pme);
        parcel.writeInt(this.pmh);
        parcel.writeInt(this.pml);
        parcel.writeInt(this.pmi);
        parcel.writeString(this.pmj);
        parcel.writeString(this.pmk);
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
    }
}
