package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import com.tencent.mm.g.c.l;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

final class p$a extends l {
    static final a dzU;
    static final String[] fgs = new String[]{"brandId", "versionType", "scene"};

    p$a() {
    }

    protected final a AX() {
        return dzU;
    }

    public final ContentValues wH() {
        this.sKx = 0;
        ContentValues wH = super.wH();
        int y = p.y(this.field_brandId, this.field_versionType, this.field_scene);
        this.field_recordId = y;
        wH.put("recordId", Integer.valueOf(y));
        return wH;
    }

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.sKA.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "recordId";
        aVar.columns[1] = "brandId";
        aVar.sKA.put("brandId", "TEXT");
        stringBuilder.append(" brandId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionType";
        aVar.sKA.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.sKA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }
}
