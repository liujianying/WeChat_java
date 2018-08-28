package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.g.c.ed;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class CardInfo extends ed implements Parcelable, b {
    public static final Creator<CardInfo> CREATOR = new Creator<CardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardInfo[i];
        }
    };
    protected static a dhO;
    public String huZ;
    public lf hvZ;
    public kx hwa;
    public bng hwb;
    public la hwc;
    public boolean hwd;

    static {
        a aVar = new a();
        aVar.sKy = new Field[22];
        aVar.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.sKA.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "card_id";
        aVar.columns[1] = "card_tp_id";
        aVar.sKA.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "from_username";
        aVar.sKA.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "delete_state_flag";
        aVar.sKA.put("delete_state_flag", "INTEGER");
        stringBuilder.append(" delete_state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "local_updateTime";
        aVar.sKA.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateSeq";
        aVar.sKA.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "create_time";
        aVar.sKA.put("create_time", "LONG");
        stringBuilder.append(" create_time LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "begin_time";
        aVar.sKA.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "end_time";
        aVar.sKA.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "block_mask";
        aVar.sKA.put("block_mask", "TEXT");
        stringBuilder.append(" block_mask TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "dataInfoData";
        aVar.sKA.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "cardTpInfoData";
        aVar.sKA.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "shareInfoData";
        aVar.sKA.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "shopInfoData";
        aVar.sKA.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "stickyIndex";
        aVar.sKA.put("stickyIndex", "INTEGER");
        stringBuilder.append(" stickyIndex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "stickyEndTime";
        aVar.sKA.put("stickyEndTime", "INTEGER");
        stringBuilder.append(" stickyEndTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "stickyAnnouncement";
        aVar.sKA.put("stickyAnnouncement", "TEXT");
        stringBuilder.append(" stickyAnnouncement TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "card_type";
        aVar.sKA.put("card_type", "INTEGER default '-1' ");
        stringBuilder.append(" card_type INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "label_wording";
        aVar.sKA.put("label_wording", "TEXT");
        stringBuilder.append(" label_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "is_dynamic";
        aVar.sKA.put("is_dynamic", "INTEGER");
        stringBuilder.append(" is_dynamic INTEGER");
        aVar.columns[22] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public CardInfo() {
        this.hwd = true;
        this.huZ = "";
        this.field_card_type = -1;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean avT() {
        return awm() != null && awm().huV == 10;
    }

    public final boolean avU() {
        return awm() != null && awm().huV == 0;
    }

    public final boolean avV() {
        return awm() != null && awm().huV == 20;
    }

    public final boolean avW() {
        return awm() != null && awm().huV == 11;
    }

    public final boolean avX() {
        return awm() != null && awm().huV == 30;
    }

    public final boolean avY() {
        return l.nI(awm().huV);
    }

    public final boolean avZ() {
        return (awm().rnN & 2) == 0;
    }

    public final boolean awa() {
        return (awm().rnN & 1) == 0;
    }

    public final boolean awb() {
        return (awm().rnQ & 1) == 0;
    }

    public final boolean awc() {
        return (awm().rnQ & 16) == 0;
    }

    public final boolean awd() {
        return (awm().rnQ & 2) > 0;
    }

    public final boolean awe() {
        return (awm().rnQ & 32) > 0;
    }

    public final boolean awf() {
        return (awm().rnQ & 4) > 0;
    }

    public final boolean awg() {
        return (awm().rnQ & 8) > 0;
    }

    public final boolean awi() {
        return this.hwa != null && this.hwa.status == 0;
    }

    public final boolean isAcceptable() {
        if (!awi()) {
            return false;
        }
        if (this.hvZ != null) {
            x.i("MicroMsg.CardInfo", "is_acceptable:" + this.hvZ.rod);
        }
        x.i("MicroMsg.CardInfo", "stock_num:" + this.hwa.rne + " limit_num:" + this.hwa.rnf);
        if (this.hvZ == null || this.hvZ.rod != 1) {
            return ((this.hvZ == null || this.hvZ.rod != 0) && this.hwa.rne != 0 && this.hwa.rnf == 0) ? false : false;
        } else {
            return true;
        }
    }

    public final boolean awj() {
        if (!awi()) {
            return false;
        }
        if (this.hvZ != null) {
            x.i("MicroMsg.CardInfo", "is_acceptable:" + this.hvZ.rod);
        }
        x.i("MicroMsg.CardInfo", "avail_num:" + this.hwa.rnb);
        if (this.hvZ != null && this.hvZ.rod == 1) {
            return true;
        }
        if (this.hwa.rnb > 0) {
            return true;
        }
        return ((this.hvZ == null || this.hvZ.rod != 0) && this.hwa.rnb == 0) ? false : false;
    }

    public final boolean awk() {
        if (this.hvZ == null || this.hvZ.rnU == null || TextUtils.isEmpty(this.hvZ.rnU.text)) {
            return false;
        }
        kz kzVar = this.hvZ.rnU;
        int currentTimeMillis = kzVar.mXw - ((int) (System.currentTimeMillis() / 1000));
        if (kzVar.mXw <= 0 || currentTimeMillis <= 0) {
            return false;
        }
        return true;
    }

    public final boolean awl() {
        return this.hvZ != null && this.hvZ.roh == 1;
    }

    public final lf awm() {
        if (this.hvZ != null) {
            return this.hvZ;
        }
        try {
            this.hvZ = (lf) new lf().aG(this.field_cardTpInfoData);
            return this.hvZ;
        } catch (Throwable e) {
            x.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new lf();
        }
    }

    public final kx awn() {
        if (this.hwa != null) {
            return this.hwa;
        }
        try {
            this.hwa = (kx) new kx().aG(this.field_dataInfoData);
            return this.hwa;
        } catch (Throwable e) {
            x.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new kx();
        }
    }

    public final void a(kx kxVar) {
        this.hwa = kxVar;
        if (this.hwa != null) {
            this.field_status = this.hwa.status;
            try {
                this.field_dataInfoData = kxVar.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            }
        }
    }

    public final bng awo() {
        if (this.hwb != null) {
            return this.hwb;
        }
        try {
            this.hwb = (bng) new bng().aG(this.field_shareInfoData);
            return this.hwb;
        } catch (Throwable e) {
            x.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new bng();
        }
    }

    public final la awp() {
        if (this.hwc != null) {
            return this.hwc;
        }
        try {
            this.hwc = (la) new la().aG(this.field_shopInfoData);
            return this.hwc;
        } catch (Throwable e) {
            x.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(la laVar) {
        this.hwc = laVar;
        try {
            this.field_shopInfoData = laVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
        }
    }

    public CardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        this.hwd = true;
        this.huZ = "";
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_delete_state_flag = parcel.readInt();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_create_time = parcel.readLong();
        this.field_begin_time = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_block_mask = parcel.readString();
        this.field_stickyIndex = parcel.readInt();
        this.field_stickyEndTime = parcel.readInt();
        this.field_stickyAnnouncement = parcel.readString();
        this.field_card_type = parcel.readInt();
        this.field_label_wording = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_dataInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_cardTpInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_cardTpInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_shareInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_shareInfoData[i] = parcel.readByte();
            }
        }
        i = parcel.readInt();
        if (i > 0) {
            this.field_shopInfoData = new byte[i];
            while (i2 < i) {
                this.field_shopInfoData[i2] = parcel.readByte();
                i2++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_delete_state_flag);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_create_time);
        parcel.writeLong(this.field_begin_time);
        parcel.writeLong(this.field_end_time);
        parcel.writeString(this.field_block_mask);
        parcel.writeInt(this.field_stickyIndex);
        parcel.writeInt(this.field_stickyEndTime);
        parcel.writeString(this.field_stickyAnnouncement);
        parcel.writeInt(this.field_card_type);
        parcel.writeString(this.field_label_wording);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
            return;
        }
        parcel.writeInt(0);
    }

    public final long getEndTime() {
        return this.field_end_time;
    }

    public final String awq() {
        return this.field_card_id;
    }

    public final String awr() {
        return this.field_card_tp_id;
    }

    public final String aws() {
        return this.field_from_username;
    }

    public final void xa(String str) {
        this.field_from_username = str;
    }

    public final long awt() {
        return this.field_local_updateTime;
    }

    public final boolean avR() {
        return awm() != null && awm().rnX == 0;
    }

    public final boolean avS() {
        return awm() != null && awm().rnX == 1;
    }

    public final String nF(int i) {
        return null;
    }

    public final String awu() {
        return null;
    }

    public final int awv() {
        return 0;
    }

    public final String aww() {
        x.d("MicroMsg.CardInfo", "encrypt_code:" + this.huZ);
        return this.huZ;
    }

    public final boolean awh() {
        return awm() != null && awm().roc == 1;
    }
}
