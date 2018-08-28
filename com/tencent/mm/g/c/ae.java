package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cng = "description".hashCode();
    private static final int cqA = "logo_url".hashCode();
    private static final int cqB = "time".hashCode();
    private static final int cqC = "card_id".hashCode();
    private static final int cqD = "card_tp_id".hashCode();
    private static final int cqE = "msg_id".hashCode();
    private static final int cqF = "msg_type".hashCode();
    private static final int cqG = "jump_type".hashCode();
    private static final int cqH = "url".hashCode();
    private static final int cqI = "buttonData".hashCode();
    private static final int cqJ = "operData".hashCode();
    private static final int cqK = "report_scene".hashCode();
    private static final int cqL = "read_state".hashCode();
    private static final int cqM = "accept_buttons".hashCode();
    private static final int cqN = "consumed_box_id".hashCode();
    private static final int cqO = "jump_buttons".hashCode();
    private static final int cqP = "logo_color".hashCode();
    private static final int cqQ = "unavailable_qr_code_list".hashCode();
    private static final int cqR = "all_unavailable".hashCode();
    private static final int cqz = "card_type".hashCode();
    private boolean cnb = true;
    private boolean cnc = true;
    private boolean cqg = true;
    private boolean cqh = true;
    private boolean cqi = true;
    private boolean cqj = true;
    private boolean cqk = true;
    private boolean cql = true;
    private boolean cqm = true;
    private boolean cqn = true;
    private boolean cqo = true;
    private boolean cqp = true;
    private boolean cqq = true;
    private boolean cqr = true;
    private boolean cqs = true;
    private boolean cqt = true;
    private boolean cqu = true;
    private boolean cqv = true;
    private boolean cqw = true;
    private boolean cqx = true;
    private boolean cqy = true;
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cqz == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cng == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (cqA == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (cqB == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (cqC == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (cqD == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (cqE == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.cql = true;
                } else if (cqF == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (cqG == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (cqI == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (cqJ == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (cqK == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (cqL == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (cqM == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (cqN == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (cqO == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (cqP == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (cqQ == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i);
                } else if (cqR == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cqg) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.cqh) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.cqi) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.cqj) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.cqk) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.cql) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.cqm) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.cqn) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.cqo) {
            contentValues.put("url", this.field_url);
        }
        if (this.cqp) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.cqq) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.cqr) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.cqs) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.cqt) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.cqu) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.cqv) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.cqw) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.cqx) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.cqy) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
