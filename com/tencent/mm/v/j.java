package com.tencent.mm.v;

import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import junit.framework.Assert;

public final class j implements a {
    private b dpi;

    public j() {
        this.dpi = new b();
    }

    public j(String str) {
        this.dpi = a.U(str).hQ();
        if (this.dpi == null) {
            throw new f(String.format("JSONArray string(%s) parse error.", new Object[]{str}));
        }
    }

    j(b bVar) {
        Assert.assertNotNull(bVar);
        this.dpi = bVar;
    }

    public final int length() {
        return this.dpi.abz.size();
    }

    public final a bq(boolean z) {
        this.dpi.ad(z);
        return this;
    }

    public final a o(double d) {
        this.dpi.m(d);
        return this;
    }

    public final a gv(int i) {
        this.dpi.bY(i);
        return this;
    }

    public final a aO(long j) {
        this.dpi.l(j);
        return this;
    }

    public final a aB(Object obj) {
        i.a(this.dpi, obj);
        return this;
    }

    public final boolean isNull(int i) {
        return i < 0 || i >= length() || this.dpi.bZ(i) == null;
    }

    public final Object get(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return null;
        }
        if (bZ.isNumber()) {
            return bZ.toString();
        }
        if (bZ.isBoolean()) {
            return Boolean.valueOf(bZ.hR());
        }
        if (bZ.isArray()) {
            return new j(bZ.hQ());
        }
        if (bZ.isObject()) {
            return new k(bZ.hV());
        }
        if (bZ.isString()) {
            return bZ.ie();
        }
        return null;
    }

    public final Object opt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return null;
        }
        if (bZ.isNumber()) {
            return bZ.toString();
        }
        if (bZ.isBoolean()) {
            return Boolean.valueOf(bZ.hR());
        }
        if (bZ.isArray()) {
            return new j(bZ.hQ());
        }
        if (bZ.isObject()) {
            return new k(bZ.hV());
        }
        if (bZ.isString()) {
            return bZ.ie();
        }
        return null;
    }

    public final Object remove(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        b bVar = this.dpi;
        bVar.abz.remove(i);
        if (bVar == null) {
            return null;
        }
        if (bVar.isNumber()) {
            return bVar.toString();
        }
        if (bVar.isBoolean()) {
            return Boolean.valueOf(bVar.hR());
        }
        if (bVar.isArray()) {
            return new j(bVar.hQ());
        }
        if (bVar.isObject()) {
            return new k(bVar.hV());
        }
        if (bVar.isString()) {
            return bVar.ie();
        }
        return null;
    }

    public final boolean getBoolean(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            throw new f(String.format("getBoolean(%d) return null.", new Object[]{Integer.valueOf(i)}));
        } else if (bZ.isBoolean()) {
            return bZ.hR();
        } else {
            if (bZ.isString()) {
                String ie = bZ.ie();
                if ("true".equals(ie)) {
                    return true;
                }
                if ("false".equals(ie)) {
                    return false;
                }
            }
            throw new f(String.format("getBoolean(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bZ}));
        }
    }

    public final boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public final boolean optBoolean(int i, boolean z) {
        int length = length();
        if (i < 0 || i >= length) {
            return z;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return z;
        }
        if (bZ.isBoolean()) {
            return bZ.hR();
        }
        if (!bZ.isString()) {
            return z;
        }
        String ie = bZ.ie();
        if ("true".equals(ie)) {
            return true;
        }
        if ("false".equals(ie)) {
            return false;
        }
        return z;
    }

    public final double getDouble(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            throw new f(String.format("getDouble(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bZ.isNumber()) {
                return bZ.hU();
            }
            if (bZ.isString()) {
                return Double.parseDouble(bZ.ie());
            }
            throw new f(String.format("getDouble(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bZ}));
        } catch (Exception e) {
        }
    }

    public final double optDouble(int i) {
        return optDouble(i, 0.0d);
    }

    public final double optDouble(int i, double d) {
        int length = length();
        if (i < 0 || i >= length) {
            return d;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return d;
        }
        try {
            if (bZ.isNumber()) {
                return bZ.hU();
            }
            if (bZ.isString()) {
                return Double.parseDouble(bZ.ie());
            }
            return d;
        } catch (Exception e) {
            return d;
        }
    }

    public final int getInt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        Object bZ = this.dpi.bZ(i);
        if (bZ == null) {
            throw new f(String.format("getInteger(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bZ.isNumber()) {
                try {
                    return bZ.hS();
                } catch (Exception e) {
                    return (int) bZ.hU();
                }
            }
            if (bZ.isString()) {
                return (int) Double.parseDouble(bZ.ie());
            }
            throw new f(String.format("getInt(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bZ}));
        } catch (Exception e2) {
        }
    }

    public final int optInt(int i) {
        return optInt(i, 0);
    }

    public final int optInt(int i, int i2) {
        int length = length();
        if (i < 0 || i >= length) {
            return i2;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return i2;
        }
        try {
            if (bZ.isNumber()) {
                try {
                    return bZ.hS();
                } catch (Exception e) {
                    return (int) bZ.hU();
                }
            } else if (bZ.isString()) {
                return (int) Double.parseDouble(bZ.ie());
            } else {
                return i2;
            }
        } catch (Exception e2) {
            return i2;
        }
    }

    public final long getLong(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        Object bZ = this.dpi.bZ(i);
        if (bZ == null) {
            throw new f(String.format("getLong(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bZ.isNumber()) {
                try {
                    return bZ.hT();
                } catch (Exception e) {
                    return (long) bZ.hU();
                }
            }
            if (bZ.isString()) {
                return (long) Double.parseDouble(bZ.ie());
            }
            throw new f(String.format("getLong(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bZ}));
        } catch (Exception e2) {
        }
    }

    public final long optLong(int i) {
        return optLong(i, 0);
    }

    public final long optLong(int i, long j) {
        int length = length();
        if (i < 0 || i >= length) {
            return j;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return j;
        }
        try {
            if (bZ.isNumber()) {
                try {
                    return bZ.hT();
                } catch (Exception e) {
                    return (long) bZ.hU();
                }
            } else if (bZ.isString()) {
                return (long) Double.parseDouble(bZ.ie());
            } else {
                return j;
            }
        } catch (Exception e2) {
            return j;
        }
    }

    public final String getString(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            throw new f(String.format("getString(%d) return null.", new Object[]{Integer.valueOf(i)}));
        } else if (bZ.isString()) {
            return bZ.ie();
        } else {
            return bZ.toString();
        }
    }

    public final String optString(int i) {
        return optString(i, null);
    }

    public final String optString(int i, String str) {
        int length = length();
        if (i < 0 || i >= length) {
            return str;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ == null) {
            return str;
        }
        if (bZ.isString()) {
            return bZ.ie();
        }
        return bZ.toString();
    }

    public final a gw(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ != null) {
            return new j(bZ.hQ());
        }
        throw new f(String.format("getJSONArray(%d) return null.", new Object[]{Integer.valueOf(i)}));
    }

    public final a gx(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ != null) {
            return new j(bZ.hQ());
        }
        return null;
    }

    public final c gy(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bZ = this.dpi.bZ(i);
        if (bZ != null) {
            return new k(bZ.hV());
        }
        throw new f(String.format("getJSONObject(%d) return null.", new Object[]{Integer.valueOf(i)}));
    }

    public final c gz(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bZ = this.dpi.bZ(i);
        if (bZ != null) {
            return new k(bZ.hV());
        }
        return null;
    }

    public final String toString() {
        return this.dpi.toString();
    }
}
