package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.c.cj;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class t extends cj {
    static final a fgt;
    public transient boolean ggm;

    static {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.sKA.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "launchAction";
        aVar.sKA.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "jsapiInfo";
        aVar.sKA.put("jsapiInfo", "BLOB");
        stringBuilder.append(" jsapiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "hostInfo";
        aVar.sKA.put("hostInfo", "BLOB");
        stringBuilder.append(" hostInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionsheetInfo";
        aVar.sKA.put("actionsheetInfo", "BLOB");
        stringBuilder.append(" actionsheetInfo BLOB");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        fgt = aVar;
    }

    protected final a AX() {
        return fgt;
    }

    public final void a(aql aql) {
        this.field_launchAction = aql.rSU;
        this.field_jsapiInfo = aql.rSV;
        this.field_hostInfo = aql.rSW;
        this.field_actionsheetInfo = aql.rSY;
    }

    public final void c(AppBrandSysConfig appBrandSysConfig) {
        boolean z = this.field_actionsheetInfo != null && this.field_actionsheetInfo.rbe;
        appBrandSysConfig.frc = z;
        appBrandSysConfig.fqP = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
        appBrandSysConfig.fqQ = this.ggm;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.field_appId.equals(tVar.field_appId) && this.field_launchAction != null && i.a(this.field_launchAction, tVar.field_launchAction) && this.field_jsapiInfo != null && i.a(this.field_jsapiInfo, tVar.field_jsapiInfo) && this.field_hostInfo != null && i.a(this.field_hostInfo, tVar.field_hostInfo) && this.field_actionsheetInfo != null && i.a(this.field_actionsheetInfo, tVar.field_actionsheetInfo)) {
            return true;
        }
        return false;
    }
}
