package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.c.ae;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends ae {
    protected static com.tencent.mm.sdk.e.c.a dhO;
    public boolean hwA;
    public List<c> hwB = null;
    public String hwo = "";
    public String hwp = "";
    public String hwq;
    public String hwr;
    public String hws;
    public boolean hwt = false;
    public kv hwu;
    public kz hwv;
    public List<a> hww = null;
    public List<b> hwx = null;
    public int hwy = 0;
    public int hwz = 0;

    public class a {
        public String cardId;
        public String hwC;
        public String hwD;
        public int hwE;
        public int hwF;
        public String title;
    }

    public class c {
        public String hwJ;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_type";
        aVar.sKA.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.sKA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "description";
        aVar.sKA.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "logo_url";
        aVar.sKA.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "time";
        aVar.sKA.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "card_id";
        aVar.sKA.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "card_tp_id";
        aVar.sKA.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "msg_id";
        aVar.sKA.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msg_id";
        aVar.columns[8] = "msg_type";
        aVar.sKA.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "jump_type";
        aVar.sKA.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "url";
        aVar.sKA.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "buttonData";
        aVar.sKA.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "operData";
        aVar.sKA.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "report_scene";
        aVar.sKA.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "read_state";
        aVar.sKA.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "accept_buttons";
        aVar.sKA.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "consumed_box_id";
        aVar.sKA.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "jump_buttons";
        aVar.sKA.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "logo_color";
        aVar.sKA.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "unavailable_qr_code_list";
        aVar.sKA.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "all_unavailable";
        aVar.sKA.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public final kv awX() {
        if (this.hwu != null) {
            return this.hwu;
        }
        try {
            this.hwu = (kv) new kv().aG(this.field_buttonData);
            return this.hwu;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new kv();
        }
    }

    public final kz awY() {
        if (this.hwv != null) {
            return this.hwv;
        }
        try {
            this.hwv = (kz) new kz().aG(this.field_operData);
            return this.hwv;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new kz();
        }
    }

    public final void awZ() {
        if (this.hww == null) {
            this.hww = new ArrayList();
            if (!bi.oW(this.field_accept_buttons)) {
                Map z = bl.z(this.field_accept_buttons, "accept_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) z.get(str + ".title");
                        if (!bi.oW((String) z.get(str + ".card_id")) || !bi.oW(str2)) {
                            int i2 = bi.getInt((String) z.get(str + ".end_time"), 0);
                            if (i2 == 0 || ((long) i2) > bi.VE()) {
                                a aVar = new a();
                                aVar.title = (String) z.get(str + ".title");
                                aVar.hwC = (String) z.get(str + ".sub_title");
                                aVar.hwD = (String) z.get(str + ".card_ext");
                                aVar.cardId = (String) z.get(str + ".card_id");
                                aVar.hwF = bi.getInt((String) z.get(str + ".action_type"), 0);
                                aVar.hwE = i2;
                                this.hww.add(aVar);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void axa() {
        if (this.hwx == null) {
            this.hwx = new ArrayList();
            if (!bi.oW(this.field_jump_buttons)) {
                Map z = bl.z(this.field_jump_buttons, "jump_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < 100) {
                            String str = ".jump_buttons_list.jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                            if (!bi.oW((String) z.get(str + ".title"))) {
                                b bVar = new b(this);
                                bVar.title = (String) z.get(str + ".title");
                                bVar.description = (String) z.get(str + ".description");
                                bVar.hwH = (String) z.get(str + ".button_wording");
                                bVar.hwI = (String) z.get(str + ".jump_url");
                                this.hwx.add(bVar);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void axb() {
        if (this.hwB == null) {
            this.hwB = new ArrayList();
            if (!bi.oW(this.field_unavailable_qr_code_list)) {
                Map z = bl.z(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < 100) {
                            String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i2 > 0 ? Integer.valueOf(i2) : "");
                            if (!bi.oW((String) z.get(str + ".code_id"))) {
                                c cVar = new c();
                                cVar.hwJ = (String) z.get(str + ".code_id");
                                this.hwB.add(cVar);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}
