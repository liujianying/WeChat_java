package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public List<j> huM = new ArrayList();
    private List<a> lNF = new ArrayList();

    public c() {
        loadFromDB();
        bmt();
        bms();
        bmu();
    }

    public final void a(j jVar, String str, String str2) {
        if (jVar != null && !TextUtils.isEmpty(str)) {
            a aVar = new a();
            aVar.field_msgId = jVar.bWQ;
            aVar.field_msgContentXml = str;
            aVar.field_isRead = str2;
            b.bmn();
            if (!b.bmp().a(aVar)) {
                x.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.bWQ);
            }
            this.lNF.add(aVar);
        }
    }

    private void loadFromDB() {
        b.bmn();
        Cursor axc = b.bmp().axc();
        if (axc != null && axc.getCount() > 0) {
            axc.moveToFirst();
            int columnIndex = axc.getColumnIndex("msgId");
            int columnIndex2 = axc.getColumnIndex("msgContentXml");
            int columnIndex3 = axc.getColumnIndex("isRead");
            while (!axc.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = axc.getString(columnIndex);
                aVar.field_msgContentXml = axc.getString(columnIndex2);
                aVar.field_isRead = axc.getString(columnIndex3);
                axc.moveToNext();
                this.lNF.add(aVar);
            }
        }
        if (axc != null) {
            axc.close();
        }
    }

    private void bms() {
        if (this.huM != null && this.huM.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.huM);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    j jVar = (j) arrayList.get(i2);
                    if (jVar.lOY != null && com.tencent.mm.plugin.order.c.c.xW(jVar.lOY)) {
                        int intValue = Integer.valueOf(jVar.lOY).intValue();
                        if (!(intValue == 2 || intValue == 1)) {
                            Jr(jVar.bWQ);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static j Jq(String str) {
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            return null;
        }
        Object obj;
        String str2;
        String obj2;
        j jVar = new j();
        jVar.lOY = (String) z.get(".sysmsg.paymsg.PayMsgType");
        jVar.lOZ = (String) z.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.lPa = (String) z.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.lPb = (String) z.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.lPc = (String) z.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.bWW = (String) z.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.lPd = (String) z.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.lPe = (String) z.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.lOO = (String) z.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.lPf = (String) z.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i = 0;
        while (true) {
            if (i == 0) {
                obj2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                obj2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
                str2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj2)) {
                break;
            }
            j.a aVar = new j.a();
            aVar.name = obj2;
            aVar.jumpUrl = str2;
            if (jVar.lPg == null) {
                jVar.lPg = new ArrayList();
            }
            jVar.lPg.add(aVar);
            i++;
        }
        i = 0;
        while (true) {
            String str3;
            if (i == 0) {
                obj2 = (String) z.get(".sysmsg.paymsg.NormalSection.Name");
                str2 = (String) z.get(".sysmsg.paymsg.NormalSection.Value");
                str3 = (String) z.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                obj2 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
                str2 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
                str3 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj2)) {
                return jVar;
            }
            j.b bVar = new j.b();
            bVar.name = obj2;
            bVar.value = str2;
            bVar.jumpUrl = str3;
            if (jVar.lPh == null) {
                jVar.lPh = new ArrayList();
            }
            jVar.lPh.add(bVar);
            i++;
        }
    }

    public final boolean Jr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        j Jt = Jt(str);
        if (Jt == null) {
            return false;
        }
        this.huM.remove(Jt);
        if (Jt != null) {
            for (int i = 0; i < this.lNF.size(); i++) {
                a aVar = (a) this.lNF.get(i);
                if (Jt.bWQ.equals(aVar.field_msgId)) {
                    this.lNF.remove(aVar);
                    b.bmn();
                    b.bmp().a(aVar, new String[0]);
                    break;
                }
            }
        }
        return true;
    }

    private void bmt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lNF.size()) {
                a aVar = (a) this.lNF.get(i2);
                String str = aVar.field_msgContentXml;
                j Jq = Jq(str);
                Jq.bWQ = aVar.field_msgId;
                this.huM.add(Jq);
                x.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:" + str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final boolean Js(String str) {
        if (this.huM == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.huM.size(); i++) {
            j jVar = (j) this.huM.get(i);
            if (jVar != null && jVar.bWQ.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final j Jt(String str) {
        if (this.huM == null || TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.huM.size()) {
                return null;
            }
            j jVar = (j) this.huM.get(i2);
            if (str.equals(jVar.bWQ)) {
                return jVar;
            }
            i = i2 + 1;
        }
    }

    public final a Ju(String str) {
        if (this.lNF == null || TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.lNF.size()) {
                return null;
            }
            a aVar = (a) this.lNF.get(i2);
            if (str.equals(aVar.field_msgId)) {
                return aVar;
            }
            i = i2 + 1;
        }
    }

    public final void bmu() {
        int bmv = bmv();
        g.Ek();
        g.Ei().DT().set(204820, Integer.valueOf(bmv));
        x.v("MicroMsg.MallPayMsgManager", "save unread msg is :" + bmv);
    }

    public final int bmv() {
        int i = 0;
        if (this.lNF == null || this.lNF.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.lNF.size()) {
                a aVar = (a) this.lNF.get(i2);
                if (aVar != null && "0".equals(aVar.field_isRead)) {
                    i3++;
                }
                i = i2 + 1;
            } else {
                x.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:" + i3);
                return i3;
            }
        }
    }

    public static MallOrderDetailObject a(j jVar) {
        if (jVar == null) {
            return null;
        }
        int i;
        MallOrderDetailObject.a aVar;
        MallOrderDetailObject mallOrderDetailObject = new MallOrderDetailObject();
        MallOrderDetailObject.b bVar = new MallOrderDetailObject.b();
        bVar.lNA = jVar.lPc;
        if (TextUtils.isEmpty(jVar.lPa) || !com.tencent.mm.plugin.order.c.c.xW(jVar.lPa)) {
            bVar.time = (int) (System.currentTimeMillis() / 1000);
        } else {
            bVar.time = Integer.valueOf(jVar.lPa).intValue();
        }
        bVar.thumbUrl = jVar.lPb;
        bVar.jOU = jVar.lPd;
        bVar.lNB = jVar.bWW;
        mallOrderDetailObject.lNs = bVar;
        List list = jVar.lPg;
        if (list != null && list.size() > 0) {
            mallOrderDetailObject.lNu = new ArrayList();
            for (i = 0; i < list.size(); i++) {
                j.a aVar2 = (j.a) list.get(i);
                aVar = new MallOrderDetailObject.a();
                aVar.name = aVar2.name;
                aVar.value = "";
                aVar.jumpUrl = aVar2.jumpUrl;
                aVar.hvi = false;
                mallOrderDetailObject.lNu.add(aVar);
            }
        }
        list = jVar.lPh;
        if (list != null && list.size() > 0) {
            if (mallOrderDetailObject.lNu == null) {
                mallOrderDetailObject.lNu = new ArrayList();
            }
            for (i = 0; i < list.size(); i++) {
                j.b bVar2 = (j.b) list.get(i);
                aVar = new MallOrderDetailObject.a();
                aVar.name = bVar2.name;
                aVar.value = bVar2.value;
                aVar.jumpUrl = bVar2.jumpUrl;
                aVar.hvi = false;
                if (i == 0) {
                    aVar.hvi = true;
                }
                mallOrderDetailObject.lNu.add(aVar);
            }
        }
        mallOrderDetailObject.lNy = jVar.lPf;
        mallOrderDetailObject.bPg = jVar.lPe;
        if (TextUtils.isEmpty(jVar.lPa) || !com.tencent.mm.plugin.order.c.c.xW(jVar.lPa)) {
            mallOrderDetailObject.lNz = (int) (System.currentTimeMillis() / 1000);
        } else {
            mallOrderDetailObject.lNz = Integer.valueOf(jVar.lPa).intValue();
        }
        return mallOrderDetailObject;
    }
}
