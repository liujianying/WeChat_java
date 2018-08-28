package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class x extends m implements c<Object, Object> {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private h dCZ;
    private long eky;
    private av<Object, Object> sOm;
    private av<Object, Object> sOn;
    private BlockingQueue<Integer> sOo = new LinkedBlockingQueue();
    private BlockingQueue<String> sOp = new LinkedBlockingQueue();

    static class a {
        public String dDi = null;
        public int type = -1;

        a() {
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.dDi != null) {
                return this.dDi.equals(aVar.dDi);
            }
            if (aVar.dDi == null) {
                return true;
            }
            return false;
        }
    }

    public x(h hVar) {
        this.dCZ = hVar;
        this.sOm = new av(this, g.Em().lnJ.getLooper(), 100, 20, 60000, 100);
        this.sOm.setTag(Integer.valueOf(1));
        this.sOn = new av(this, g.Em().lnJ.getLooper(), 100, 20, 60000, 100);
        this.sOn.setTag(Integer.valueOf(3));
    }

    public final Object get(int i, Object obj) {
        Assert.assertTrue("db is null", this.dCZ != null);
        Object obj2 = this.sOm.get(Integer.valueOf(i));
        if (obj2 == null && !this.sOo.contains(Integer.valueOf(i))) {
            a aVar = new a();
            Cursor a = this.dCZ.a("userinfo", null, "id=" + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar.type = a.getInt(1);
                aVar.dDi = a.getString(2);
            }
            a.close();
            obj2 = m(aVar.type, aVar.dDi);
            this.sOm.s(Integer.valueOf(i), aVar);
            if (obj2 == null) {
                return obj;
            }
        } else if (obj2 instanceof a) {
            a aVar2 = (a) obj2;
            obj2 = m(aVar2.type, aVar2.dDi);
            if (obj2 == null) {
                return obj;
            }
        }
        return obj2;
    }

    public final Object get(com.tencent.mm.storage.aa.a aVar, Object obj) {
        if (aVar == null) {
            return obj;
        }
        String name = aVar.name();
        if (bi.oW(name)) {
            return obj;
        }
        String str;
        String[] split = name.split("_");
        String str2 = split[split.length - 1];
        if (str2.equals("SYNC")) {
            str = split[split.length - 2];
        } else {
            str = str2;
        }
        String substring = name.substring(0, name.lastIndexOf(str) + str.length());
        Assert.assertTrue("db is null", this.dCZ != null);
        Object obj2 = this.sOn.get(substring);
        if (obj2 == null && !this.sOp.contains(substring)) {
            a aVar2 = new a();
            Cursor a = this.dCZ.a("userinfo2", null, "sid=?", new String[]{substring}, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar2.type = a.getInt(1);
                aVar2.dDi = a.getString(2);
            }
            a.close();
            obj2 = m(aVar2.type, aVar2.dDi);
            this.sOn.s(substring, aVar2);
            if (obj2 == null) {
                obj2 = obj;
            }
        } else if (obj2 instanceof a) {
            a aVar3 = (a) obj2;
            obj2 = m(aVar3.type, aVar3.dDi);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
        if (a(str, obj2, false)) {
            return obj2;
        }
        return obj;
    }

    public final boolean getBoolean(com.tencent.mm.storage.aa.a aVar, boolean z) {
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            return z;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final long i(com.tencent.mm.storage.aa.a aVar) {
        Object obj = get(aVar, Long.valueOf(0));
        if (obj == null || !(obj instanceof Long)) {
            return 0;
        }
        return ((Long) obj).longValue();
    }

    public final void set(int i, Object obj) {
        boolean s;
        Assert.assertTrue("db is null", this.dCZ != null);
        if (obj == null) {
            s = this.sOm.s(Integer.valueOf(i), null);
            if (s && !this.sOo.contains(Integer.valueOf(i))) {
                this.sOo.add(Integer.valueOf(i));
            }
        } else {
            a aVar = new a();
            aVar.type = ck(obj);
            if (aVar.type != -1) {
                aVar.dDi = obj.toString();
                s = this.sOm.s(Integer.valueOf(i), aVar);
                if (s && this.sOo.contains(Integer.valueOf(i))) {
                    this.sOo.remove(Integer.valueOf(i));
                }
            } else {
                return;
            }
        }
        if (s) {
            b(obj == null ? 5 : 4, this, Integer.valueOf(i));
        }
    }

    public final void a(com.tencent.mm.storage.aa.a aVar, Object obj) {
        if (aVar != null) {
            String name = aVar.name();
            if (!bi.oW(name)) {
                boolean z;
                String[] split = name.split("_");
                String str = split[split.length - 1];
                if (str.equals("SYNC")) {
                    str = split[split.length - 2];
                    z = true;
                } else {
                    z = false;
                }
                if (a(str, obj, true)) {
                    boolean s;
                    String substring = name.substring(0, str.length() + name.lastIndexOf(str));
                    if (obj == null) {
                        s = this.sOn.s(substring, null);
                        if (s && !this.sOp.contains(substring)) {
                            this.sOp.add(substring);
                        }
                    } else {
                        a aVar2 = new a();
                        aVar2.type = ck(obj);
                        if (aVar2.type != -1) {
                            aVar2.dDi = obj.toString();
                            s = this.sOn.s(substring, aVar2);
                            if (s && this.sOp.contains(substring)) {
                                this.sOp.remove(substring);
                            }
                        } else {
                            return;
                        }
                    }
                    if (s) {
                        b(obj == null ? 5 : 4, this, aVar);
                    }
                    if (z) {
                        lm(true);
                    }
                }
            }
        }
    }

    private static boolean a(String str, Object obj, boolean z) {
        if (obj == null && z) {
            return true;
        }
        if (str.equals("INT") && (obj instanceof Integer)) {
            return true;
        }
        if (str.equals("LONG") && (obj instanceof Long)) {
            return true;
        }
        if (str.equals("STRING") && (obj instanceof String)) {
            return true;
        }
        if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            return true;
        }
        if (str.equals("FLOAT") && (obj instanceof Float)) {
            return true;
        }
        if (str.equals("DOUBLE") && (obj instanceof Double)) {
            return true;
        }
        if (obj != null && b.chp()) {
            Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
        }
        if (z) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
        }
        return false;
    }

    private static int ck(Object obj) {
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof String) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 5;
        }
        if (obj instanceof Double) {
            return 6;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
        return -1;
    }

    private static Object m(int i, String str) {
        switch (i) {
            case 1:
                try {
                    return Integer.valueOf(str);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConfigStorage", "exception:%s", bi.i(e));
                    break;
                }
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                return Double.valueOf(str);
        }
        return null;
    }

    protected final boolean Xu() {
        if (this.dCZ != null && !this.dCZ.cjr()) {
            return true;
        }
        String str = "MicroMsg.ConfigStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.dCZ == null ? "null" : Boolean.valueOf(this.dCZ.cjr());
        com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
        return false;
    }

    public final boolean Sc() {
        if (this.dCZ.inTransaction()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
            return false;
        }
        this.eky = this.dCZ.dO(Thread.currentThread().getId());
        if (this.eky > 0) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.eky + " return false");
        return false;
    }

    public final void a(av<Object, Object> avVar, av.b<Object, Object> bVar) {
        Object obj = bVar.qSV;
        Object obj2 = bVar.values;
        int i = bVar.sIz;
        ContentValues contentValues;
        switch (((Integer) avVar.getTag()).intValue()) {
            case 1:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar = (a) obj2;
                        if (aVar.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("id", (Integer) bVar.qSV);
                            contentValues.put("type", Integer.valueOf(aVar.type));
                            contentValues.put("value", aVar.dDi.toString());
                            this.dCZ.replace("userinfo", "id", contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.dCZ.delete("userinfo", "id=" + obj, null);
                    return;
                } else {
                    return;
                }
            case 3:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar2 = (a) obj2;
                        if (aVar2.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("sid", (String) bVar.qSV);
                            contentValues.put("type", Integer.valueOf(aVar2.type));
                            contentValues.put("value", aVar2.dDi.toString());
                            this.dCZ.replace("userinfo2", "id", contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.dCZ.delete("userinfo2", "sid= ?", new String[]{obj.toString()});
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void Sd() {
        if (this.eky > 0) {
            this.dCZ.gp(this.eky);
        }
    }

    public final void lm(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.sOm.li(z);
        this.sOn.li(z);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk force[%b] end takes[%d]ms ", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final int getInt(int i, int i2) {
        Integer num = (Integer) get(i, null);
        return num == null ? i2 : num.intValue();
    }

    public final void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public final long Dj(int i) {
        Long l = (Long) get(i, null);
        return l == null ? 0 : l.longValue();
    }
}
