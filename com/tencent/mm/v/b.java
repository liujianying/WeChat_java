package com.tencent.mm.v;

import android.annotation.TargetApi;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    private JSONArray dpc;

    public b() {
        this.dpc = new JSONArray();
    }

    public b(String str) {
        try {
            this.dpc = new JSONArray(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    b(JSONArray jSONArray) {
        Assert.assertNotNull(jSONArray);
        this.dpc = jSONArray;
    }

    public final int length() {
        return this.dpc.length();
    }

    public final a bq(boolean z) {
        this.dpc.put(z);
        return this;
    }

    public final a o(double d) {
        try {
            this.dpc.put(d);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a gv(int i) {
        this.dpc.put(i);
        return this;
    }

    public final a aO(long j) {
        this.dpc.put(j);
        return this;
    }

    public final a aB(Object obj) {
        this.dpc.put(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.dpc.isNull(i);
    }

    public final Object get(int i) {
        try {
            Object obj = this.dpc.get(i);
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

    public final Object opt(int i) {
        Object opt = this.dpc.opt(i);
        if (opt instanceof JSONObject) {
            return new d((JSONObject) opt);
        }
        if (opt instanceof JSONArray) {
            return new b((JSONArray) opt);
        }
        return opt;
    }

    @TargetApi(19)
    public final Object remove(int i) {
        Object remove = this.dpc.remove(i);
        if (remove instanceof JSONObject) {
            return new d((JSONObject) remove);
        }
        if (remove instanceof JSONArray) {
            return new b((JSONArray) remove);
        }
        return remove;
    }

    public final boolean getBoolean(int i) {
        try {
            return this.dpc.getBoolean(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final boolean optBoolean(int i) {
        return this.dpc.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.dpc.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        try {
            return this.dpc.getDouble(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final double optDouble(int i) {
        return this.dpc.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.dpc.optDouble(i, d);
    }

    public final int getInt(int i) {
        try {
            return this.dpc.getInt(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final int optInt(int i) {
        return this.dpc.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.dpc.optInt(i, i2);
    }

    public final long getLong(int i) {
        try {
            return this.dpc.getLong(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final long optLong(int i) {
        return this.dpc.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.dpc.optLong(i, j);
    }

    public final String getString(int i) {
        try {
            return this.dpc.getString(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String optString(int i) {
        return this.dpc.optString(i);
    }

    public final String optString(int i, String str) {
        return this.dpc.optString(i, str);
    }

    public final a gw(int i) {
        try {
            JSONArray jSONArray = this.dpc.getJSONArray(i);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a gx(int i) {
        JSONArray optJSONArray = this.dpc.optJSONArray(i);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    public final c gy(int i) {
        try {
            JSONObject jSONObject = this.dpc.getJSONObject(i);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c gz(int i) {
        JSONObject optJSONObject = this.dpc.optJSONObject(i);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }
}
