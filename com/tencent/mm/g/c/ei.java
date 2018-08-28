package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ei extends c {
    private static final int cGm = "tips".hashCode();
    private static final int cQI = "bindSerial".hashCode();
    private static final int cQJ = "cardType".hashCode();
    private static final int cQK = "bankcardState".hashCode();
    private static final int cQL = "forbidWord".hashCode();
    private static final int cQM = "bankName".hashCode();
    private static final int cQN = "bankcardType".hashCode();
    private static final int cQO = "bankcardTypeName".hashCode();
    private static final int cQP = "bankcardTag".hashCode();
    private static final int cQQ = "bankcardTail".hashCode();
    private static final int cQR = "supportTag".hashCode();
    private static final int cQS = "mobile".hashCode();
    private static final int cQT = "trueName".hashCode();
    private static final int cQU = "bankPhone".hashCode();
    private static final int cQV = "bizUsername".hashCode();
    private static final int cQW = "onceQuotaKind".hashCode();
    private static final int cQX = "onceQuotaVirtual".hashCode();
    private static final int cQY = "dayQuotaKind".hashCode();
    private static final int cQZ = "dayQuotaVirtual".hashCode();
    private static final int cRa = "fetchArriveTime".hashCode();
    private static final int cRb = "fetchArriveTimeWording".hashCode();
    private static final int cRc = "repay_url".hashCode();
    private static final int cRd = "wxcreditState".hashCode();
    private static final int cRe = "bankcardClientType".hashCode();
    private static final int cRf = "ext_msg".hashCode();
    private static final int cRg = "support_micropay".hashCode();
    private static final int cRh = "arrive_type".hashCode();
    private static final int cRi = "avail_save_wording".hashCode();
    private static final int cRj = "fetch_charge_rate".hashCode();
    private static final int cRk = "full_fetch_charge_fee".hashCode();
    private static final int cRl = "fetch_charge_info".hashCode();
    private static final int cRm = "forbid_title".hashCode();
    private static final int cRn = "forbid_url".hashCode();
    private static final int cRo = "no_micro_word".hashCode();
    private static final int cRp = "card_bottom_wording".hashCode();
    private static final int cRq = "support_lqt_turn_in".hashCode();
    private static final int cRr = "support_lqt_turn_out".hashCode();
    private static final int cRs = "is_hightlight_pre_arrive_time_wording".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cws = "desc".hashCode();
    private boolean cGg = true;
    private boolean cPX = true;
    private boolean cPY = true;
    private boolean cPZ = true;
    private boolean cQA = true;
    private boolean cQB = true;
    private boolean cQC = true;
    private boolean cQD = true;
    private boolean cQE = true;
    private boolean cQF = true;
    private boolean cQG = true;
    private boolean cQH = true;
    private boolean cQa = true;
    private boolean cQb = true;
    private boolean cQc = true;
    private boolean cQd = true;
    private boolean cQe = true;
    private boolean cQf = true;
    private boolean cQg = true;
    private boolean cQh = true;
    private boolean cQi = true;
    private boolean cQj = true;
    private boolean cQk = true;
    private boolean cQl = true;
    private boolean cQm = true;
    private boolean cQn = true;
    private boolean cQo = true;
    private boolean cQp = true;
    private boolean cQq = true;
    private boolean cQr = true;
    private boolean cQs = true;
    private boolean cQt = true;
    private boolean cQu = true;
    private boolean cQv = true;
    private boolean cQw = true;
    private boolean cQx = true;
    private boolean cQy = true;
    private boolean cQz = true;
    private boolean cwo = true;
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public int field_is_hightlight_pre_arrive_time_wording;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public int field_support_lqt_turn_in;
    public int field_support_lqt_turn_out;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cQI == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.cPX = true;
                } else if (cQJ == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (cQK == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (cQL == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (cQM == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (cQN == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (cQO == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (cQP == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (cQQ == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (cQR == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (cQS == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (cQT == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (cws == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (cQU == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (cQV == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (cQW == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (cQX == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (cQY == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (cQZ == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (cRa == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (cRb == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (cRc == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (cRd == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (cRe == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (cRf == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (cRg == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (cRh == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (cRi == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (cRj == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (cRk == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (cRl == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (cGm == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (cRm == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (cRn == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (cRo == hashCode) {
                    this.field_no_micro_word = cursor.getString(i);
                } else if (cRp == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i);
                } else if (cRq == hashCode) {
                    this.field_support_lqt_turn_in = cursor.getInt(i);
                } else if (cRr == hashCode) {
                    this.field_support_lqt_turn_out = cursor.getInt(i);
                } else if (cRs == hashCode) {
                    this.field_is_hightlight_pre_arrive_time_wording = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cPX) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.cPY) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.cPZ) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.cQa) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.cQb) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.cQc) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.cQd) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.cQe) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.cQf) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.cQg) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.cQh) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.cQi) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.cwo) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.cQj) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.cQk) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.cQl) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.cQm) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.cQn) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.cQo) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.cQp) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.cQq) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.cQr) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.cQs) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.cQt) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.cQu) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.cQv) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.cQw) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.cQx) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.cQy) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.cQz) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.cQA) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.cGg) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.cQB) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.cQC) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.cQD) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.cQE) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.cQF) {
            contentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
        }
        if (this.cQG) {
            contentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
        }
        if (this.cQH) {
            contentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
