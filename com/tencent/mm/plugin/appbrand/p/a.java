package com.tencent.mm.plugin.appbrand.p;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public final class a extends i<a> {
    public static final String[] dzV = new String[]{i.a(a.fgt, "AppBrandCommonKVBinaryData")};

    static final class a extends c {
        static final com.tencent.mm.sdk.e.c.a fgt = I(a.class);
        @h(cjs = "$$invalid", cjt = 1)
        public String field_key;
        public byte[] field_value;

        a() {
        }

        protected final com.tencent.mm.sdk.e.c.a AX() {
            return fgt;
        }

        public final void d(Cursor cursor) {
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
        }

        public final ContentValues wH() {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
            return contentValues;
        }
    }

    public a(e eVar) {
        super(eVar, a.fgt, "AppBrandCommonKVBinaryData", null);
    }

    public final void m(String str, byte[] bArr) {
        if (!bi.oW(str)) {
            a aVar = new a();
            aVar.field_key = str;
            aVar.field_value = bArr;
            super.a(aVar);
        }
    }

    public final <T extends com.tencent.mm.bk.a> T g(String str, Class<T> cls) {
        byte[] bArr;
        if (!bi.oW(str)) {
            a aVar = new a();
            aVar.field_key = str;
            if (super.b(aVar, new String[0])) {
                bArr = aVar.field_value;
                if (bi.bC(bArr)) {
                    return null;
                }
                try {
                    T t = (com.tencent.mm.bk.a) cls.newInstance();
                    t.aG(bArr);
                    return t;
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[]{cls.getSimpleName(), e});
                    return null;
                }
            }
        }
        bArr = null;
        if (bi.bC(bArr)) {
            return null;
        }
        try {
            T t2 = (com.tencent.mm.bk.a) cls.newInstance();
            t2.aG(bArr);
            return t2;
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[]{cls.getSimpleName(), e2});
            return null;
        }
    }
}
