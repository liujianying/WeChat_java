package com.tencent.mm.plugin.boots.c.a;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends i<com.tencent.mm.plugin.boots.a.a> implements com.tencent.mm.bt.g.a {
    public static final String[] diD = new String[]{i.a(com.tencent.mm.plugin.boots.a.a.dhO, "ActiveInfo")};
    private e diF;

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.boots.a.a.dhO, "ActiveInfo", null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "ActiveInfo";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ne(int r15) {
        /*
        r14 = this;
        r12 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r9 = 0;
        r10 = 0;
        r8 = 1;
        r3 = "key=?";
        r4 = new java.lang.String[r8];
        r0 = java.lang.String.valueOf(r15);
        r4[r9] = r0;
        r11 = new com.tencent.mm.plugin.boots.a.a;
        r11.<init>();
        r0 = r14.diF;	 Catch:{ Exception -> 0x0088, all -> 0x0091 }
        r1 = "ActiveInfo";
        r2 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0088, all -> 0x0091 }
        if (r1 == 0) goto L_0x0084;
    L_0x0025:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00c0, all -> 0x00be }
        if (r0 == 0) goto L_0x0084;
    L_0x002b:
        r11.d(r1);	 Catch:{ Exception -> 0x00c0, all -> 0x00be }
        r0 = r9;
    L_0x002f:
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        r2 = r11.field_useTime;
        r4 = com.tencent.mm.sdk.platformtools.bi.ciZ();
        r4 = r4 - r12;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x0099;
    L_0x003f:
        r2 = r11.field_useTime;
        r4 = com.tencent.mm.sdk.platformtools.bi.ciZ();
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 > 0) goto L_0x0099;
    L_0x0049:
        r1 = r11.field_dau;
        r1 = r1 + 1;
    L_0x004d:
        r2 = java.lang.System.currentTimeMillis();
        r11.field_useTime = r2;
        r11.field_dau = r1;
        r11.field_mau = r8;
        r2 = "key=?";
        r3 = new java.lang.String[r8];
        r4 = java.lang.String.valueOf(r15);
        r3[r9] = r4;
        if (r0 == 0) goto L_0x00af;
    L_0x0064:
        r0 = r14.diF;
        r2 = "ActiveInfo";
        r3 = "key";
        r4 = r11.wH();
        r2 = r0.insert(r2, r3, r4);
    L_0x0074:
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x0083;
    L_0x007a:
        r0 = "MicroMsg.Tinker.ActiveInfoStorage";
        r2 = "update tinker info failed";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);
    L_0x0083:
        return r1;
    L_0x0084:
        r11.field_key = r15;	 Catch:{ Exception -> 0x00c3, all -> 0x00be }
        r0 = r8;
        goto L_0x002f;
    L_0x0088:
        r0 = move-exception;
        r0 = r9;
        r1 = r10;
    L_0x008b:
        if (r1 == 0) goto L_0x0034;
    L_0x008d:
        r1.close();
        goto L_0x0034;
    L_0x0091:
        r0 = move-exception;
        r1 = r10;
    L_0x0093:
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();
    L_0x0098:
        throw r0;
    L_0x0099:
        r2 = r11.field_useTime;
        r4 = com.tencent.mm.sdk.platformtools.bi.ciZ();
        r4 = r4 - r12;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x00ad;
    L_0x00a4:
        r1 = r11.field_dau;
        if (r1 <= 0) goto L_0x00ab;
    L_0x00a8:
        r1 = r11.field_dau;
        goto L_0x004d;
    L_0x00ab:
        r1 = r8;
        goto L_0x004d;
    L_0x00ad:
        r1 = r8;
        goto L_0x004d;
    L_0x00af:
        r0 = r14.diF;
        r4 = "ActiveInfo";
        r5 = r11.wH();
        r0 = r0.update(r4, r5, r2, r3);
        r2 = (long) r0;
        goto L_0x0074;
    L_0x00be:
        r0 = move-exception;
        goto L_0x0093;
    L_0x00c0:
        r0 = move-exception;
        r0 = r9;
        goto L_0x008b;
    L_0x00c3:
        r0 = move-exception;
        r0 = r8;
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.boots.c.a.a.ne(int):int");
    }

    public final com.tencent.mm.plugin.boots.a.a nf(int i) {
        Throwable e;
        com.tencent.mm.plugin.boots.a.a aVar = new com.tencent.mm.plugin.boots.a.a();
        Cursor query;
        try {
            query = this.diF.query("ActiveInfo", null, "key =?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar.d(query);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getActiveInfoByKey %s failed.", new Object[]{Integer.toHexString(i)});
                        if (query != null) {
                            query.close();
                        }
                        return aVar;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return aVar;
    }

    public final List<com.tencent.mm.plugin.boots.a.a> aua() {
        List<com.tencent.mm.plugin.boots.a.a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select * from ActiveInfo where useTime >= ?", new String[]{String.valueOf(bi.ciZ() - 86400000)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.boots.a.a aVar = new com.tencent.mm.plugin.boots.a.a();
                aVar.d(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getDayActiveFeature failed.", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
