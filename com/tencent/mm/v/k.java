package com.tencent.mm.v;

import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class k implements c {
    private e dpj;

    public k() {
        this.dpj = new e();
    }

    k(e eVar) {
        if (eVar == null) {
            eVar = new e();
        }
        this.dpj = eVar;
    }

    public k(Map map) {
        this.dpj = i.o(map);
    }

    public k(String str) {
        this.dpj = a.U(str).hV();
    }

    public final int length() {
        return this.dpj.abF.size();
    }

    public final c p(String str, boolean z) {
        this.dpj.a(str, a.ac(z));
        return this;
    }

    public final c b(String str, double d) {
        this.dpj.a(str, a.l(d));
        return this;
    }

    public final c D(String str, int i) {
        this.dpj.a(str, a.bX(i));
        return this;
    }

    public final c j(String str, long j) {
        this.dpj.a(str, a.k(j));
        return this;
    }

    public final c l(String str, Object obj) {
        i.a(this.dpj, str, obj);
        return this;
    }

    public final c m(String str, Object obj) {
        i.a(this.dpj, str, obj);
        return this;
    }

    public final String fP(String str) {
        if (str != null) {
            return str;
        }
        throw new f("Names must be non-null");
    }

    public final Object remove(String str) {
        e eVar = this.dpj;
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int indexOf = eVar.indexOf(str);
        if (indexOf != -1) {
            eVar.abG.remove(indexOf);
            eVar.abF.remove(indexOf);
            eVar.abz.remove(indexOf);
        }
        if (eVar == null) {
            return null;
        }
        if (eVar.isNumber()) {
            return eVar.toString();
        }
        if (eVar.isBoolean()) {
            return Boolean.valueOf(eVar.hR());
        }
        if (eVar.isArray()) {
            return new j(eVar.hQ());
        }
        if (eVar.isObject()) {
            return new k(eVar.hV());
        }
        if (eVar.isString()) {
            return eVar.ie();
        }
        return null;
    }

    public final boolean isNull(String str) {
        return this.dpj.W(str) == null;
    }

    public final boolean has(String str) {
        return this.dpj.W(str) != null;
    }

    public final Object get(String str) {
        return opt(str);
    }

    public final Object opt(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            return null;
        }
        if (W.isNumber()) {
            return W.toString();
        }
        if (W.isBoolean()) {
            return Boolean.valueOf(W.hR());
        }
        if (W.isArray()) {
            return new j(W.hQ());
        }
        if (W.isObject()) {
            return new k(W.hV());
        }
        if (W.isString()) {
            return W.ie();
        }
        return null;
    }

    public final boolean getBoolean(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        } else if (W.isBoolean()) {
            return W.hR();
        } else {
            if (W.isString()) {
                String hVar = W.toString();
                if ("true".equals(hVar)) {
                    return true;
                }
                if ("false".equals(hVar)) {
                    return false;
                }
            }
            throw new f(String.format("getBoolean by key : %s error, value : %s", new Object[]{str, W}));
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        h W = this.dpj.W(str);
        if (W == null) {
            return z;
        }
        if (W.isBoolean()) {
            return W.hR();
        }
        if (!W.isString()) {
            return z;
        }
        String hVar = W.toString();
        if ("true".equals(hVar)) {
            return true;
        }
        if ("false".equals(hVar)) {
            return false;
        }
        return z;
    }

    public final double getDouble(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (W.isNumber()) {
                return W.hU();
            }
            if (W.isString()) {
                return Double.parseDouble(W.toString());
            }
            throw new f(String.format("getDouble by key : %s error, value : %s", new Object[]{str, W}));
        } catch (Exception e) {
        }
    }

    public final double optDouble(String str, double d) {
        h W = this.dpj.W(str);
        if (W == null) {
            return d;
        }
        try {
            if (W.isNumber()) {
                return W.hU();
            }
            if (W.isString()) {
                return Double.parseDouble(W.toString());
            }
            return d;
        } catch (Exception e) {
            return d;
        }
    }

    public final int getInt(String str) {
        Object W = this.dpj.W(str);
        if (W == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (W.isNumber()) {
                try {
                    return W.hS();
                } catch (Exception e) {
                    return (int) W.hU();
                }
            }
            if (W.isString()) {
                return (int) Double.parseDouble(W.toString());
            }
            throw new f(String.format("getInt by key : %s error, value : %s", new Object[]{str, W}));
        } catch (Exception e2) {
        }
    }

    public final int optInt(String str, int i) {
        h W = this.dpj.W(str);
        if (W == null) {
            return i;
        }
        try {
            if (W.isNumber()) {
                try {
                    return W.hS();
                } catch (Exception e) {
                    return (int) W.hU();
                }
            } else if (W.isString()) {
                return (int) Double.parseDouble(W.toString());
            } else {
                return i;
            }
        } catch (Exception e2) {
            return i;
        }
    }

    public final long getLong(String str) {
        Object W = this.dpj.W(str);
        if (W == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (W.isNumber()) {
                try {
                    return W.hT();
                } catch (Exception e) {
                    return (long) W.hU();
                }
            }
            if (W.isString()) {
                return (long) Double.parseDouble(W.toString());
            }
            throw new f(String.format("getLong by key : %s error, value : %s", new Object[]{str, W}));
        } catch (Exception e2) {
        }
    }

    public final long optLong(String str, long j) {
        h W = this.dpj.W(str);
        if (W == null) {
            return j;
        }
        try {
            if (W.isNumber()) {
                try {
                    return W.hT();
                } catch (Exception e) {
                    return (long) W.hU();
                }
            } else if (W.isString()) {
                return (long) Double.parseDouble(W.toString());
            } else {
                return j;
            }
        } catch (Exception e2) {
            return j;
        }
    }

    public final String getString(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        } else if (W.isString()) {
            return W.ie();
        } else {
            return W.toString();
        }
    }

    public final String optString(String str) {
        return optString(str, null);
    }

    public final String optString(String str, String str2) {
        h W = this.dpj.W(str);
        if (W == null) {
            return null;
        }
        if (W.isString()) {
            return W.ie();
        }
        return W.toString();
    }

    public final a fQ(String str) {
        h W = this.dpj.W(str);
        if (W != null) {
            return new j(W.hQ());
        }
        throw new f(String.format("key %s do not exist.", new Object[]{str}));
    }

    public final a fR(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            return null;
        }
        return new j(W.hQ());
    }

    public final c fS(String str) {
        h W = this.dpj.W(str);
        if (W != null) {
            return new k(W.hV());
        }
        throw new f(String.format("key %s do not exist.", new Object[]{str}));
    }

    public final c fT(String str) {
        h W = this.dpj.W(str);
        if (W == null) {
            return null;
        }
        return new k(W.hV());
    }

    public final Iterator<String> keys() {
        return Collections.unmodifiableList(this.dpj.abF).iterator();
    }

    public final String toString() {
        return this.dpj.toString();
    }
}
