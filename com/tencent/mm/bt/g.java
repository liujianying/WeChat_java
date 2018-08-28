package com.tencent.mm.bt;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g implements e {
    public static String tdI = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean qAy;
    public h tdH;
    public Map<String, i> tdJ;
    public Queue<a> tdK;
    public f tdk;

    public interface a {
        int a(g gVar);

        String getTableName();
    }

    public final boolean cjr() {
        if (this.tdk != null && this.tdk.isOpen()) {
            return false;
        }
        x.e("MicroMsg.MemoryStorage", "memory db is close [%s]", tdI);
        return true;
    }

    public final int ZK(String str) {
        String str2 = null;
        if (!this.qAy) {
            return -4;
        }
        if (this.tdH == null || this.tdH.inTransaction()) {
            x.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            return -3;
        }
        try {
            if (f.a(this.tdk, str)) {
                this.tdk.execSQL("drop table " + str);
                x.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
            }
            Cursor b = this.tdH.b(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
            if (b != null) {
                if (b.getCount() == 1) {
                    b.moveToFirst();
                    str2 = b.getString(0);
                }
                b.close();
            }
            if (str2 == null) {
                x.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                return -1;
            }
            this.tdk.execSQL(str2);
            this.tdk.execSQL("insert into " + str + " select * from old." + str);
            x.d("MicroMsg.MemoryStorage", "copy table %s success", str);
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.tdJ.containsKey(str));
        if (this.tdk == null || !this.tdk.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, tdI);
            if (this.tdH == null || !this.tdH.isOpen()) {
                return -1;
            }
            return this.tdH.delete(str, str2, strArr);
        }
        i iVar = (i) this.tdJ.get(str);
        com.tencent.mm.bt.i.a aVar = new com.tencent.mm.bt.i.a();
        aVar.sIz = 5;
        aVar.ted = str2;
        aVar.J(strArr);
        iVar.a(aVar);
        return this.tdk.delete(str, str2, strArr);
    }

    public final boolean fV(String str, String str2) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.tdJ.containsKey(str));
        if (this.tdk == null || !this.tdk.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, tdI);
            if (this.tdH == null || !this.tdH.isOpen()) {
                return false;
            }
            this.tdH.fV(str2, str);
            return true;
        }
        i iVar = (i) this.tdJ.get(str);
        com.tencent.mm.bt.i.a aVar = new com.tencent.mm.bt.i.a();
        aVar.sIz = 1;
        aVar.sql = str2;
        iVar.a(aVar);
        this.tdk.execSQL(str2);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.tdJ.containsKey(str));
        if (this.tdk == null || !this.tdk.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, tdI);
            if (this.tdH == null || !this.tdH.isOpen()) {
                return -1;
            }
            return this.tdH.insert(str, str2, contentValues);
        }
        i iVar = (i) this.tdJ.get(str);
        com.tencent.mm.bt.i.a aVar = new com.tencent.mm.bt.i.a();
        aVar.sIz = 2;
        aVar.sKz = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.tdk.insert(str, str2, contentValues);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.tdJ.containsKey(str));
        if (this.tdk == null || !this.tdk.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, tdI);
            if (this.tdH == null || !this.tdH.isOpen()) {
                return -1;
            }
            return this.tdH.replace(str, str2, contentValues);
        }
        i iVar = (i) this.tdJ.get(str);
        com.tencent.mm.bt.i.a aVar = new com.tencent.mm.bt.i.a();
        aVar.sIz = 4;
        aVar.sKz = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.tdk.replace(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.tdJ.containsKey(str));
        if (this.tdk == null || !this.tdk.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, tdI);
            if (this.tdH == null || !this.tdH.isOpen()) {
                return -1;
            }
            return this.tdH.update(str, contentValues, str2, strArr);
        }
        i iVar = (i) this.tdJ.get(str);
        com.tencent.mm.bt.i.a aVar = new com.tencent.mm.bt.i.a();
        aVar.sIz = 3;
        aVar.ted = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.J(strArr);
        iVar.a(aVar);
        return this.tdk.update(str, contentValues, str2, strArr);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.tdk != null && this.tdk.isOpen()) {
            return this.tdk.a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, tdI);
        return d.cnR();
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        return query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.tdk != null && this.tdk.isOpen()) {
            return this.tdk.b(str, strArr, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, tdI);
        return d.cnR();
    }

    public final Cursor b(String str, String[] strArr, int i) {
        return rawQuery(str, strArr);
    }
}
