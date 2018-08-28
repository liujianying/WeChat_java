package com.tencent.mm.v;

import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c {
    private JSONObject dpd;

    public d() {
        this.dpd = new JSONObject();
    }

    public d(Map map) {
        this.dpd = new JSONObject(map);
    }

    public d(String str) {
        try {
            this.dpd = new JSONObject(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    d(JSONObject jSONObject) {
        Assert.assertNotNull(jSONObject);
        this.dpd = jSONObject;
    }

    public final int length() {
        return this.dpd.length();
    }

    public final c p(String str, boolean z) {
        try {
            this.dpd.put(str, z);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c b(String str, double d) {
        try {
            this.dpd.put(str, d);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c D(String str, int i) {
        try {
            this.dpd.put(str, i);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c j(String str, long j) {
        try {
            this.dpd.put(str, j);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c l(String str, Object obj) {
        try {
            this.dpd.put(str, obj);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c m(String str, Object obj) {
        try {
            this.dpd.put(str, obj);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String fP(String str) {
        if (str != null) {
            return str;
        }
        throw new f("Names must be non-null");
    }

    public final Object remove(String str) {
        return this.dpd.remove(str);
    }

    public final boolean isNull(String str) {
        return this.dpd.isNull(str);
    }

    public final boolean has(String str) {
        return this.dpd.has(str);
    }

    public final Object get(String str) {
        try {
            Object obj = this.dpd.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final Object opt(String str) {
        try {
            Object obj = this.dpd.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        try {
            return this.dpd.getBoolean(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        return this.dpd.optBoolean(str, z);
    }

    public final double getDouble(String str) {
        try {
            return this.dpd.getDouble(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final double optDouble(String str, double d) {
        return this.dpd.optDouble(str, d);
    }

    public final int getInt(String str) {
        try {
            return this.dpd.getInt(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final int optInt(String str, int i) {
        return this.dpd.optInt(str, i);
    }

    public final long getLong(String str) {
        try {
            return this.dpd.getLong(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final long optLong(String str, long j) {
        return this.dpd.optLong(str, j);
    }

    public final String getString(String str) {
        try {
            return this.dpd.getString(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String optString(String str) {
        return this.dpd.optString(str);
    }

    public final String optString(String str, String str2) {
        return this.dpd.optString(str, str2);
    }

    public final a fQ(String str) {
        try {
            JSONArray jSONArray = this.dpd.getJSONArray(str);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a fR(String str) {
        JSONArray optJSONArray = this.dpd.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    public final c fS(String str) {
        try {
            JSONObject jSONObject = this.dpd.getJSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c fT(String str) {
        JSONObject optJSONObject = this.dpd.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }

    public final Iterator<String> keys() {
        return this.dpd.keys();
    }

    public final String toString() {
        return this.dpd.toString();
    }
}
