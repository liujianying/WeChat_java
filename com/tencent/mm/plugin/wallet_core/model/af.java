package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.c.ep;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class af extends ep {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[26];
        aVar.columns = new String[27];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.sKA.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.columns[1] = "is_reg";
        aVar.sKA.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "true_name";
        aVar.sKA.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "card_num";
        aVar.sKA.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isDomesticUser";
        aVar.sKA.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "cre_type";
        aVar.sKA.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "main_card_bind_serialno";
        aVar.sKA.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "ftf_pay_url";
        aVar.sKA.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "switchConfig";
        aVar.sKA.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reset_passwd_flag";
        aVar.sKA.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "find_passwd_url";
        aVar.sKA.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "is_open_touch";
        aVar.sKA.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "lct_wording";
        aVar.sKA.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lct_url";
        aVar.sKA.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "cre_name";
        aVar.sKA.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "lqt_state";
        aVar.sKA.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "paymenu_use_new";
        aVar.sKA.put("paymenu_use_new", "INTEGER");
        stringBuilder.append(" paymenu_use_new INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "is_show_lqb";
        aVar.sKA.put("is_show_lqb", "INTEGER");
        stringBuilder.append(" is_show_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "is_open_lqb";
        aVar.sKA.put("is_open_lqb", "INTEGER");
        stringBuilder.append(" is_open_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "lqb_open_url";
        aVar.sKA.put("lqb_open_url", "TEXT");
        stringBuilder.append(" lqb_open_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "lqt_cell_is_show";
        aVar.sKA.put("lqt_cell_is_show", "INTEGER");
        stringBuilder.append(" lqt_cell_is_show INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "lqt_cell_icon";
        aVar.sKA.put("lqt_cell_icon", "TEXT");
        stringBuilder.append(" lqt_cell_icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "lqt_cell_is_open_lqt";
        aVar.sKA.put("lqt_cell_is_open_lqt", "INTEGER");
        stringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "lqt_cell_lqt_open_url";
        aVar.sKA.put("lqt_cell_lqt_open_url", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_open_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "lqt_cell_lqt_title";
        aVar.sKA.put("lqt_cell_lqt_title", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "lqt_cell_lqt_wording";
        aVar.sKA.put("lqt_cell_lqt_wording", "TEXT");
        stringBuilder.append(" lqt_cell_lqt_wording TEXT");
        aVar.columns[26] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean bPp() {
        return this.field_is_reg == 0;
    }

    public final boolean bPq() {
        return this.field_is_reg == -1;
    }
}
