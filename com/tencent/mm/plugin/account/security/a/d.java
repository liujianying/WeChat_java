package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.g.c.dm;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends dm {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "uid";
        aVar.sKA.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "uid";
        aVar.columns[1] = "name";
        aVar.sKA.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "devicetype";
        aVar.sKA.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.sKA.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public d() {
        this.field_uid = "0";
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public d(arp arp) {
        this.field_uid = arp.fMk;
        this.field_devicetype = arp.devicetype;
        this.field_name = arp.devicename;
        this.field_createtime = (long) arp.rTQ;
    }
}
