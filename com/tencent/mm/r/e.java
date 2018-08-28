package com.tencent.mm.r;

import android.content.ContentValues;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i<d> {
    public static final String[] diD = new String[]{i.a(d.dhO, "FunctionMsgItem")};
    private static final String[] diE = new String[]{"*", "rowid"};
    private com.tencent.mm.sdk.e.e diF;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.dhO, "FunctionMsgItem", null);
        this.diF = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.r.d fw(java.lang.String r10) {
        /*
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r10);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = "MicroMsg.FunctionMsgStorage";
        r1 = "getByFunctionMsgId, functionMsgId: %s";
        r2 = new java.lang.Object[r4];
        r2[r6] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r9.diF;
        r1 = "FunctionMsgItem";
        r2 = diE;
        r3 = "functionmsgid=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0047 }
        if (r0 == 0) goto L_0x0041;
    L_0x0032:
        r0 = new com.tencent.mm.r.d;	 Catch:{ Exception -> 0x0047 }
        r0.<init>();	 Catch:{ Exception -> 0x0047 }
        r0.d(r1);	 Catch:{ Exception -> 0x0047 }
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        r5 = r0;
        goto L_0x0009;
    L_0x0041:
        if (r1 == 0) goto L_0x0009;
    L_0x0043:
        r1.close();
        goto L_0x0009;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";
        r3 = "getByFunctionMsgId error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0061 }
        r4[r6] = r0;	 Catch:{ all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0061 }
        if (r1 == 0) goto L_0x0009;
    L_0x005d:
        r1.close();
        goto L_0x0009;
    L_0x0061:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.r.e.fw(java.lang.String):com.tencent.mm.r.d");
    }

    public final void a(String str, d dVar) {
        x.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", new Object[]{str});
        d fw = fw(str);
        if (fw != null) {
            try {
                String str2 = "MicroMsg.FunctionMsgStorage";
                String str3 = "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(dVar.field_addMsg == null);
                objArr[2] = Boolean.valueOf(fw.field_addMsg == null);
                x.i(str2, str3, objArr);
                ContentValues wH = dVar.wH();
                if (wH.get("addMsg") == null && fw.field_addMsg != null) {
                    wH.put("addMsg", fw.field_addMsg.toByteArray());
                }
                int update = this.diF.update("FunctionMsgItem", wH, "functionmsgid=?", new String[]{str});
                x.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", new Object[]{Integer.valueOf(update)});
            } catch (Exception e) {
                x.e("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.r.d> Cb() {
        /*
        r9 = this;
        r4 = 1;
        r7 = 0;
        r5 = 0;
        r0 = r9.diF;
        r1 = "FunctionMsgItem";
        r2 = diE;
        r3 = "status<?";
        r4 = new java.lang.String[r4];
        r6 = "2";
        r4[r7] = r6;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 != 0) goto L_0x001e;
    L_0x001d:
        return r5;
    L_0x001e:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0047 }
        if (r0 == 0) goto L_0x0041;
    L_0x0024:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0047 }
        r0.<init>();	 Catch:{ Exception -> 0x0047 }
    L_0x0029:
        r2 = new com.tencent.mm.r.d;	 Catch:{ Exception -> 0x0047 }
        r2.<init>();	 Catch:{ Exception -> 0x0047 }
        r2.d(r1);	 Catch:{ Exception -> 0x0047 }
        r0.add(r2);	 Catch:{ Exception -> 0x0047 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0047 }
        if (r2 != 0) goto L_0x0029;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        r5 = r0;
        goto L_0x001d;
    L_0x0041:
        if (r1 == 0) goto L_0x001d;
    L_0x0043:
        r1.close();
        goto L_0x001d;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";
        r3 = "getAllNeedFetchFunctionMsg error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0061 }
        r4[r6] = r0;	 Catch:{ all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0061 }
        if (r1 == 0) goto L_0x001d;
    L_0x005d:
        r1.close();
        goto L_0x001d;
    L_0x0061:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.r.e.Cb():java.util.List<com.tencent.mm.r.d>");
    }
}
