package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d extends a<l> {
    public boolean bHx;
    private List<l> jsx;
    private List<String> pNe;

    public d(String str, List<String> list) {
        super(str);
        this.pNe = list;
    }

    public final void cL(List<l> list) {
        this.jsx = list;
        if (this.jsx != null) {
            List arrayList = new ArrayList(this.pNe.size());
            Iterator it = this.jsx.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                int indexOf = this.pNe.indexOf(((i) g.l(i.class)).FR().Yg(lVar.jrv).field_username);
                if (indexOf >= 0) {
                    if (indexOf < arrayList.size()) {
                        arrayList.add(indexOf, lVar);
                    } else {
                        arrayList.add(lVar);
                    }
                    it.remove();
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.jsx.add(0, arrayList.get(size));
            }
        }
        this.bHx = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject eg(int r15, int r16) {
        /*
        r14 = this;
        r3 = new org.json.JSONObject;
        r3.<init>();
        r1 = r14.bHx;
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        r1 = r3;
    L_0x000a:
        return r1;
    L_0x000b:
        if (r15 < 0) goto L_0x000f;
    L_0x000d:
        if (r16 > 0) goto L_0x0011;
    L_0x000f:
        r1 = r3;
        goto L_0x000a;
    L_0x0011:
        r1 = r15 + r16;
        r1 = r1 + -1;
        r2 = r14.jsx;
        r2 = r2.size();
        r2 = r2 + -1;
        if (r1 <= r2) goto L_0x002c;
    L_0x001f:
        r1 = r14.jsx;
        r1 = r1.size();
        r1 = r1 + -1;
        r5 = r1;
    L_0x0028:
        if (r5 >= r15) goto L_0x002e;
    L_0x002a:
        r1 = r3;
        goto L_0x000a;
    L_0x002c:
        r5 = r1;
        goto L_0x0028;
    L_0x002e:
        r2 = "continueFlag";
        r1 = r14.jsx;	 Catch:{ JSONException -> 0x012e }
        r1 = r1.size();	 Catch:{ JSONException -> 0x012e }
        r1 = r1 + -1;
        if (r5 != r1) goto L_0x0105;
    L_0x003b:
        r1 = 0;
    L_0x003c:
        r3.put(r2, r1);	 Catch:{ JSONException -> 0x012e }
        r1 = "offset";
        r2 = r5 + 1;
        r3.put(r1, r2);	 Catch:{ JSONException -> 0x012e }
        r1 = "query";
        r2 = r14.bWm;	 Catch:{ JSONException -> 0x012e }
        r3.put(r1, r2);	 Catch:{ JSONException -> 0x012e }
        r1 = "ret";
        r2 = 0;
        r3.put(r1, r2);	 Catch:{ JSONException -> 0x012e }
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x012e }
        r6.<init>();	 Catch:{ JSONException -> 0x012e }
        r1 = "count";
        r2 = r5 - r15;
        r2 = r2 + 1;
        r6.put(r1, r2);	 Catch:{ JSONException -> 0x012e }
        r1 = "totalCount";
        r2 = com.tencent.mm.model.s.Hw();	 Catch:{ JSONException -> 0x012e }
        r6.put(r1, r2);	 Catch:{ JSONException -> 0x012e }
        r7 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x012e }
        r7.<init>();	 Catch:{ JSONException -> 0x012e }
    L_0x0074:
        if (r15 > r5) goto L_0x013e;
    L_0x0076:
        r1 = r14.jsx;	 Catch:{ JSONException -> 0x012e }
        r1 = r1.get(r15);	 Catch:{ JSONException -> 0x012e }
        r0 = r1;
        r0 = (com.tencent.mm.plugin.fts.a.a.l) r0;	 Catch:{ JSONException -> 0x012e }
        r2 = r0;
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x012e }
        r8.<init>();	 Catch:{ JSONException -> 0x012e }
        r1 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r1 = com.tencent.mm.kernel.g.l(r1);	 Catch:{ JSONException -> 0x012e }
        r1 = (com.tencent.mm.plugin.messenger.foundation.a.i) r1;	 Catch:{ JSONException -> 0x012e }
        r1 = r1.FR();	 Catch:{ JSONException -> 0x012e }
        r4 = r2.jrv;	 Catch:{ JSONException -> 0x012e }
        r9 = r1.Yg(r4);	 Catch:{ JSONException -> 0x012e }
        r1 = "userName";
        r4 = r9.field_username;	 Catch:{ JSONException -> 0x012e }
        r8.put(r1, r4);	 Catch:{ JSONException -> 0x012e }
        r1 = "nickName";
        r4 = r9.field_nickname;	 Catch:{ JSONException -> 0x012e }
        r8.put(r1, r4);	 Catch:{ JSONException -> 0x012e }
        r1 = r2.content;	 Catch:{ JSONException -> 0x012e }
        r10 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ JSONException -> 0x012e }
        r4 = "";
        r11 = r14.bWm;	 Catch:{ JSONException -> 0x012e }
        r12 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x012e }
        r13 = "<em class=\\\"highlight\\\">";
        r12.<init>(r13);	 Catch:{ JSONException -> 0x012e }
        r13 = r14.bWm;	 Catch:{ JSONException -> 0x012e }
        r12 = r12.append(r13);	 Catch:{ JSONException -> 0x012e }
        r13 = "</em>";
        r12 = r12.append(r13);	 Catch:{ JSONException -> 0x012e }
        r12 = r12.toString();	 Catch:{ JSONException -> 0x012e }
        r1 = r1.replaceFirst(r11, r12);	 Catch:{ JSONException -> 0x012e }
        r2 = r2.jru;	 Catch:{ JSONException -> 0x012e }
        switch(r2) {
            case 1: goto L_0x00d5;
            case 4: goto L_0x00d5;
            case 5: goto L_0x00d5;
            case 15: goto L_0x0108;
            default: goto L_0x00d4;
        };
    L_0x00d4:
        r1 = r4;
    L_0x00d5:
        r2 = "displayText";
        r8.put(r2, r1);	 Catch:{ JSONException -> 0x0120 }
    L_0x00db:
        r1 = "";
        r2 = com.tencent.mm.aa.q.KH();	 Catch:{ JSONException -> 0x012e }
        r4 = r9.field_username;	 Catch:{ JSONException -> 0x012e }
        r2 = r2.kc(r4);	 Catch:{ JSONException -> 0x012e }
        if (r2 == 0) goto L_0x00f8;
    L_0x00ea:
        r1 = r2.Ky();	 Catch:{ JSONException -> 0x012e }
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);	 Catch:{ JSONException -> 0x012e }
        if (r4 == 0) goto L_0x00f8;
    L_0x00f4:
        r1 = r2.Kx();	 Catch:{ JSONException -> 0x012e }
    L_0x00f8:
        r2 = "thumbUrl";
        r8.put(r2, r1);	 Catch:{ JSONException -> 0x012e }
        r7.put(r8);	 Catch:{ JSONException -> 0x012e }
        r15 = r15 + 1;
        goto L_0x0074;
    L_0x0105:
        r1 = 1;
        goto L_0x003c;
    L_0x0108:
        r2 = com.tencent.mm.plugin.websearch.a.a.search_contact_tag_wxid;	 Catch:{ JSONException -> 0x012e }
        r2 = r10.getString(r2);	 Catch:{ JSONException -> 0x012e }
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x012e }
        r4.<init>();	 Catch:{ JSONException -> 0x012e }
        r2 = r4.append(r2);	 Catch:{ JSONException -> 0x012e }
        r1 = r2.append(r1);	 Catch:{ JSONException -> 0x012e }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x012e }
        goto L_0x00d5;
    L_0x0120:
        r1 = move-exception;
        r2 = "JsapiFtsMatchContact";
        r4 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ JSONException -> 0x012e }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r4, r10);	 Catch:{ JSONException -> 0x012e }
        goto L_0x00db;
    L_0x012e:
        r1 = move-exception;
        r2 = "JsapiFtsMatchContact";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r4, r5);
    L_0x013b:
        r1 = r3;
        goto L_0x000a;
    L_0x013e:
        r1 = "items";
        r6.put(r1, r7);	 Catch:{ JSONException -> 0x012e }
        r1 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x012e }
        r1.<init>();	 Catch:{ JSONException -> 0x012e }
        r1.put(r6);	 Catch:{ JSONException -> 0x012e }
        r2 = "data";
        r3.put(r2, r1);	 Catch:{ JSONException -> 0x012e }
        goto L_0x013b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.c.a.d.eg(int, int):org.json.JSONObject");
    }
}
