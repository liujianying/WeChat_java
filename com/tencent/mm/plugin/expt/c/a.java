package com.tencent.mm.plugin.expt.c;

import android.util.Base64;
import com.tencent.mm.g.c.az;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends az {
    protected static com.tencent.mm.sdk.e.c.a dhO;
    private HashMap<String, String> iII = null;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "exptId";
        aVar.sKA.put("exptId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" exptId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "exptId";
        aVar.columns[1] = "groupId";
        aVar.sKA.put("groupId", "INTEGER");
        stringBuilder.append(" groupId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "exptSeq";
        aVar.sKA.put("exptSeq", "INTEGER");
        stringBuilder.append(" exptSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "exptContent";
        aVar.sKA.put("exptContent", "TEXT");
        stringBuilder.append(" exptContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "startTime";
        aVar.sKA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endTime";
        aVar.sKA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public final boolean AC(String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String aVar = toString();
            this.field_exptContent = str;
            this.field_exptId = jSONObject.optInt("ExptId");
            this.field_groupId = jSONObject.optInt("GroupId");
            this.field_exptSeq = jSONObject.optInt("ExptSequence");
            this.field_startTime = jSONObject.optLong("StartTime");
            this.field_endTime = jSONObject.optLong("EndTime");
            x.v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", new Object[]{toString(), aVar, str});
            return true;
        } catch (Exception e) {
            Exception exception = e;
            h.mEJ.a(863, 5, 1, false);
            x.e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", new Object[]{Integer.valueOf(hashCode()), str, exception.toString()});
            return false;
        }
    }

    public final String toString() {
        return "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " }";
    }

    public final HashMap<String, String> aIF() {
        HashMap hashMap;
        Exception exception;
        if (this.iII != null) {
            return this.iII;
        }
        if (bi.oW(this.field_exptContent)) {
            hashMap = null;
        } else {
            try {
                Object obj = new JSONObject(this.field_exptContent).get("Args");
                if (obj == null) {
                    return null;
                }
                HashMap hashMap2 = new HashMap();
                try {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                a(hashMap2, jSONArray.getJSONObject(i));
                            }
                        }
                        hashMap = hashMap2;
                    } else {
                        if (obj instanceof JSONObject) {
                            a(hashMap2, (JSONObject) obj);
                        }
                        hashMap = hashMap2;
                    }
                } catch (Exception e) {
                    exception = e;
                    hashMap = hashMap2;
                    x.e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", new Object[]{exception.toString(), Integer.valueOf(this.field_exptId)});
                    this.iII = hashMap;
                    return this.iII;
                }
            } catch (Exception e2) {
                exception = e2;
                hashMap = null;
                x.e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", new Object[]{exception.toString(), Integer.valueOf(this.field_exptId)});
                this.iII = hashMap;
                return this.iII;
            }
        }
        this.iII = hashMap;
        return this.iII;
    }

    private static void a(HashMap<String, String> hashMap, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("Key");
            String optString2 = jSONObject.optString("Val");
            if (!bi.oW(optString) && !bi.oW(optString2)) {
                hashMap.put(optString, new String(Base64.decode(optString2, 0)));
            }
        }
    }
}
