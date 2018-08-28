package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public abstract class ep extends c {
    private static final int cSN = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int cSO = "is_reg".hashCode();
    private static final int cSP = "true_name".hashCode();
    private static final int cSQ = "card_num".hashCode();
    private static final int cSR = "isDomesticUser".hashCode();
    private static final int cSS = "cre_type".hashCode();
    private static final int cST = "main_card_bind_serialno".hashCode();
    private static final int cSU = "ftf_pay_url".hashCode();
    private static final int cSV = "switchConfig".hashCode();
    private static final int cSW = "reset_passwd_flag".hashCode();
    private static final int cSX = "find_passwd_url".hashCode();
    private static final int cSY = "is_open_touch".hashCode();
    private static final int cSZ = "lct_wording".hashCode();
    private static final int cTa = "lct_url".hashCode();
    private static final int cTb = "cre_name".hashCode();
    private static final int cTc = "lqt_state".hashCode();
    private static final int cTd = "paymenu_use_new".hashCode();
    private static final int cTe = "is_show_lqb".hashCode();
    private static final int cTf = "is_open_lqb".hashCode();
    private static final int cTg = "lqb_open_url".hashCode();
    private static final int cTh = "lqt_cell_is_show".hashCode();
    private static final int cTi = "lqt_cell_icon".hashCode();
    private static final int cTj = "lqt_cell_is_open_lqt".hashCode();
    private static final int cTk = "lqt_cell_lqt_open_url".hashCode();
    private static final int cTl = "lqt_cell_lqt_title".hashCode();
    private static final int cTm = "lqt_cell_lqt_wording".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cSA = true;
    private boolean cSB = true;
    private boolean cSC = true;
    private boolean cSD = true;
    private boolean cSE = true;
    private boolean cSF = true;
    private boolean cSG = true;
    private boolean cSH = true;
    private boolean cSI = true;
    private boolean cSJ = true;
    private boolean cSK = true;
    private boolean cSL = true;
    private boolean cSM = true;
    private boolean cSn = true;
    private boolean cSo = true;
    private boolean cSp = true;
    private boolean cSq = true;
    private boolean cSr = true;
    private boolean cSs = true;
    private boolean cSt = true;
    private boolean cSu = true;
    private boolean cSv = true;
    private boolean cSw = true;
    private boolean cSx = true;
    private boolean cSy = true;
    private boolean cSz = true;
    public int field_card_num;
    public String field_cre_name;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_lqb;
    public int field_is_open_touch;
    public int field_is_reg;
    public int field_is_show_lqb;
    public String field_lct_url;
    public String field_lct_wording;
    public String field_lqb_open_url;
    public String field_lqt_cell_icon;
    public int field_lqt_cell_is_open_lqt;
    public int field_lqt_cell_is_show;
    public String field_lqt_cell_lqt_open_url;
    public String field_lqt_cell_lqt_title;
    public String field_lqt_cell_lqt_wording;
    public int field_lqt_state;
    public String field_main_card_bind_serialno;
    public int field_paymenu_use_new;
    public String field_reset_passwd_flag;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cSN == hashCode) {
                    this.field_uin = cursor.getString(i);
                    this.cSn = true;
                } else if (cSO == hashCode) {
                    this.field_is_reg = cursor.getInt(i);
                } else if (cSP == hashCode) {
                    this.field_true_name = cursor.getString(i);
                } else if (cSQ == hashCode) {
                    this.field_card_num = cursor.getInt(i);
                } else if (cSR == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i) != 0;
                } else if (cSS == hashCode) {
                    this.field_cre_type = cursor.getInt(i);
                } else if (cST == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i);
                } else if (cSU == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i);
                } else if (cSV == hashCode) {
                    this.field_switchConfig = cursor.getInt(i);
                } else if (cSW == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i);
                } else if (cSX == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i);
                } else if (cSY == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i);
                } else if (cSZ == hashCode) {
                    this.field_lct_wording = cursor.getString(i);
                } else if (cTa == hashCode) {
                    this.field_lct_url = cursor.getString(i);
                } else if (cTb == hashCode) {
                    this.field_cre_name = cursor.getString(i);
                } else if (cTc == hashCode) {
                    this.field_lqt_state = cursor.getInt(i);
                } else if (cTd == hashCode) {
                    this.field_paymenu_use_new = cursor.getInt(i);
                } else if (cTe == hashCode) {
                    this.field_is_show_lqb = cursor.getInt(i);
                } else if (cTf == hashCode) {
                    this.field_is_open_lqb = cursor.getInt(i);
                } else if (cTg == hashCode) {
                    this.field_lqb_open_url = cursor.getString(i);
                } else if (cTh == hashCode) {
                    this.field_lqt_cell_is_show = cursor.getInt(i);
                } else if (cTi == hashCode) {
                    this.field_lqt_cell_icon = cursor.getString(i);
                } else if (cTj == hashCode) {
                    this.field_lqt_cell_is_open_lqt = cursor.getInt(i);
                } else if (cTk == hashCode) {
                    this.field_lqt_cell_lqt_open_url = cursor.getString(i);
                } else if (cTl == hashCode) {
                    this.field_lqt_cell_lqt_title = cursor.getString(i);
                } else if (cTm == hashCode) {
                    this.field_lqt_cell_lqt_wording = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cSn) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.cSo) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.cSp) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.cSq) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.cSr) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.cSs) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.cSt) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.cSu) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.cSv) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.cSw) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.cSx) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.cSy) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.cSz) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.cSA) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.cSB) {
            contentValues.put("cre_name", this.field_cre_name);
        }
        if (this.cSC) {
            contentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
        }
        if (this.cSD) {
            contentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
        }
        if (this.cSE) {
            contentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
        }
        if (this.cSF) {
            contentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
        }
        if (this.cSG) {
            contentValues.put("lqb_open_url", this.field_lqb_open_url);
        }
        if (this.cSH) {
            contentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
        }
        if (this.cSI) {
            contentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
        }
        if (this.cSJ) {
            contentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
        }
        if (this.cSK) {
            contentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
        }
        if (this.cSL) {
            contentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
        }
        if (this.cSM) {
            contentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
