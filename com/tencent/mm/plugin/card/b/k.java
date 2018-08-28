package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k {
    private List<WeakReference<a>> htB = new ArrayList();
    public List<g> huM = new ArrayList();
    public int huN = 0;

    public k() {
        loadFromDB();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(139268, null);
        this.huN = obj == null ? 0 : ((Integer) obj).intValue();
    }

    public final void a(g gVar) {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.a(gVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void auM() {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.auM();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.htB == null) {
            this.htB = new ArrayList();
        }
        if (aVar != null) {
            this.htB.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.htB != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.htB.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void c(g gVar) {
        if (!am.axk().b(gVar)) {
            x.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
    }

    private void loadFromDB() {
        Cursor axc = am.axk().axc();
        if (axc != null && axc.getCount() > 0) {
            axc.moveToFirst();
            int columnIndex = axc.getColumnIndex("card_type");
            int columnIndex2 = axc.getColumnIndex("title");
            int columnIndex3 = axc.getColumnIndex("description");
            int columnIndex4 = axc.getColumnIndex("logo_url");
            int columnIndex5 = axc.getColumnIndex("time");
            int columnIndex6 = axc.getColumnIndex("card_id");
            int columnIndex7 = axc.getColumnIndex("card_tp_id");
            int columnIndex8 = axc.getColumnIndex("msg_id");
            int columnIndex9 = axc.getColumnIndex("msg_type");
            int columnIndex10 = axc.getColumnIndex("jump_type");
            int columnIndex11 = axc.getColumnIndex("url");
            int columnIndex12 = axc.getColumnIndex("buttonData");
            int columnIndex13 = axc.getColumnIndex("operData");
            int columnIndex14 = axc.getColumnIndex("report_scene");
            int columnIndex15 = axc.getColumnIndex("read_state");
            while (!axc.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = axc.getInt(columnIndex);
                gVar.field_title = axc.getString(columnIndex2);
                gVar.field_description = axc.getString(columnIndex3);
                gVar.field_logo_url = axc.getString(columnIndex4);
                gVar.field_time = axc.getInt(columnIndex5);
                gVar.field_card_id = axc.getString(columnIndex6);
                gVar.field_card_tp_id = axc.getString(columnIndex7);
                gVar.field_msg_id = axc.getString(columnIndex8);
                gVar.field_msg_type = axc.getInt(columnIndex9);
                gVar.field_jump_type = axc.getInt(columnIndex10);
                gVar.field_url = axc.getString(columnIndex11);
                gVar.field_buttonData = axc.getBlob(columnIndex12);
                gVar.field_operData = axc.getBlob(columnIndex13);
                gVar.field_report_scene = axc.getInt(columnIndex14);
                gVar.field_read_state = axc.getInt(columnIndex15);
                axc.moveToNext();
                this.huM.add(gVar);
            }
        }
        if (axc != null) {
            axc.close();
        }
    }

    public static String i(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bi.oW((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + bi.WS(bi.oV((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + bi.WS(bi.oV((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + bi.WS(bi.oV((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + bi.WS(bi.oV((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oW(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String j(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (bi.oW((String) map.get(str2 + ".card_id")) && bi.oW(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + bi.WS(bi.oV((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + bi.WS(bi.oV((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + bi.WS(bi.oV((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + bi.WS(bi.oV((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + bi.WS(bi.oV((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + bi.WS(bi.oV((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oW(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String k(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".unavailable_qr_code_list" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bi.oW((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + bi.WS(bi.oV((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oW(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        return stringBuilder2.toString();
    }

    public final boolean xi(String str) {
        if (this.huM == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.huM.size(); i++) {
            g gVar = (g) this.huM.get(i);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g gVar;
        if (this.huM == null || TextUtils.isEmpty(str)) {
            gVar = null;
        } else {
            for (int i = 0; i < this.huM.size(); i++) {
                gVar = (g) this.huM.get(i);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
            }
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        this.huM.remove(gVar);
        d(gVar);
        return true;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        if (gVar != null) {
            z = am.axk().a(gVar, new String[0]);
            if (!z) {
                x.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
        }
        return z;
    }

    public final void awU() {
        this.huN = 0;
        com.tencent.mm.kernel.g.Ei().DT().set(139268, Integer.valueOf(this.huN));
    }

    public static void awV() {
        x.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        e.post(new 1(), "clearRedDotAndWording");
    }
}
