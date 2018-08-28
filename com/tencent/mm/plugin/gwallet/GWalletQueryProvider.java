package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class GWalletQueryProvider extends ContentProvider {
    public static final String[] qP = new String[]{"_id", "product_id", "full_price", "product_state", "price_currency", "price_amount"};
    private final String TAG = "MicroMsg.GWalletQueryProvider";
    private b kiB = null;
    private boolean kiC;
    private boolean kiD;
    private ArrayList<String> kiE;
    private ArrayList<String> kiF;
    private int kiG;
    private Context mContext = null;

    static /* synthetic */ void d(GWalletQueryProvider gWalletQueryProvider) {
        if (gWalletQueryProvider.kiB != null) {
            gWalletQueryProvider.kiB.a(gWalletQueryProvider.kiF, new c() {
                public final void a(com.tencent.mm.plugin.gwallet.a.c cVar, Intent intent) {
                    x.d("MicroMsg.GWalletQueryProvider", "query detail done! Result " + cVar);
                    GWalletQueryProvider.this.kiD = true;
                    GWalletQueryProvider.this.kiE = intent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO");
                    GWalletQueryProvider.this.kiG = intent.getIntExtra("RESPONSE_CODE", 0);
                }
            });
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        x.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19) {
        /*
        r14 = this;
        r6 = com.tencent.mm.plugin.gwallet.GWalletQueryProvider.class;
        monitor-enter(r6);
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "Creating IAB helper.";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        if (r18 == 0) goto L_0x0013;
    L_0x000e:
        r0 = r18;
        r2 = r0.length;	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x0028;
    L_0x0013:
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "no product id selected or size is 0";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0025 }
        r3 = "no product id selected or size is 0";
        r2.<init>(r3);	 Catch:{ all -> 0x0025 }
        throw r2;	 Catch:{ all -> 0x0025 }
    L_0x0025:
        r2 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0025 }
        throw r2;
    L_0x0028:
        r2 = r14.getContext();	 Catch:{ all -> 0x0025 }
        r14.mContext = r2;	 Catch:{ all -> 0x0025 }
        r2 = new com.tencent.mm.plugin.gwallet.a.b;	 Catch:{ all -> 0x0025 }
        r3 = r14.mContext;	 Catch:{ all -> 0x0025 }
        r2.<init>(r3);	 Catch:{ all -> 0x0025 }
        r14.kiB = r2;	 Catch:{ all -> 0x0025 }
        r2 = 1;
        r14.kiC = r2;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r14.kiD = r2;	 Catch:{ all -> 0x0025 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0025 }
        r2.<init>();	 Catch:{ all -> 0x0025 }
        r14.kiF = r2;	 Catch:{ all -> 0x0025 }
        r0 = r18;
        r3 = r0.length;	 Catch:{ all -> 0x0025 }
        r2 = 0;
    L_0x0048:
        if (r2 >= r3) goto L_0x0054;
    L_0x004a:
        r4 = r18[r2];	 Catch:{ all -> 0x0025 }
        r5 = r14.kiF;	 Catch:{ all -> 0x0025 }
        r5.add(r4);	 Catch:{ all -> 0x0025 }
        r2 = r2 + 1;
        goto L_0x0048;
    L_0x0054:
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "Starting setup.";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        r2 = r14.kiB;	 Catch:{ all -> 0x0025 }
        r3 = new com.tencent.mm.plugin.gwallet.GWalletQueryProvider$1;	 Catch:{ all -> 0x0025 }
        r3.<init>(r14);	 Catch:{ all -> 0x0025 }
        r2.a(r3);	 Catch:{ all -> 0x0025 }
        r2 = 0;
    L_0x0069:
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x008c;
    L_0x006f:
        r4 = r14.kiC;	 Catch:{ all -> 0x0025 }
        if (r4 == 0) goto L_0x008c;
    L_0x0073:
        r4 = r14.kiD;	 Catch:{ all -> 0x0025 }
        if (r4 != 0) goto L_0x008c;
    L_0x0077:
        r4 = 100;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0080 }
        r4 = 100;
        r2 = r2 + r4;
        goto L_0x0069;
    L_0x0080:
        r4 = move-exception;
        r5 = "MicroMsg.GWalletQueryProvider";
        r4 = r4.toString();	 Catch:{ all -> 0x0025 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r4);	 Catch:{ all -> 0x0025 }
        goto L_0x0069;
    L_0x008c:
        r4 = r14.kiC;	 Catch:{ all -> 0x0025 }
        if (r4 != 0) goto L_0x00e2;
    L_0x0090:
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "unable to setup";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        r3 = new android.database.MatrixCursor;	 Catch:{ all -> 0x0025 }
        r2 = qP;	 Catch:{ all -> 0x0025 }
        r3.<init>(r2);	 Catch:{ all -> 0x0025 }
        r2 = r14.kiF;	 Catch:{ all -> 0x0025 }
        r4 = r2.iterator();	 Catch:{ all -> 0x0025 }
    L_0x00a6:
        r2 = r4.hasNext();	 Catch:{ all -> 0x0025 }
        if (r2 == 0) goto L_0x00df;
    L_0x00ac:
        r2 = r4.next();	 Catch:{ all -> 0x0025 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0025 }
        r5 = 6;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0025 }
        r7 = 0;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0025 }
        r5[r7] = r8;	 Catch:{ all -> 0x0025 }
        r7 = 1;
        r5[r7] = r2;	 Catch:{ all -> 0x0025 }
        r2 = 2;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 3;
        r7 = 10234; // 0x27fa float:1.4341E-41 double:5.0563E-320;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0025 }
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 4;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 5;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r3.addRow(r5);	 Catch:{ all -> 0x0025 }
        goto L_0x00a6;
    L_0x00df:
        monitor-exit(r6);	 Catch:{ all -> 0x0025 }
        r2 = r3;
    L_0x00e1:
        return r2;
    L_0x00e2:
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x013a;
    L_0x00e8:
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "time's out";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        r3 = new android.database.MatrixCursor;	 Catch:{ all -> 0x0025 }
        r2 = qP;	 Catch:{ all -> 0x0025 }
        r3.<init>(r2);	 Catch:{ all -> 0x0025 }
        r2 = r14.kiF;	 Catch:{ all -> 0x0025 }
        r4 = r2.iterator();	 Catch:{ all -> 0x0025 }
    L_0x00fe:
        r2 = r4.hasNext();	 Catch:{ all -> 0x0025 }
        if (r2 == 0) goto L_0x0137;
    L_0x0104:
        r2 = r4.next();	 Catch:{ all -> 0x0025 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0025 }
        r5 = 6;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0025 }
        r7 = 0;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0025 }
        r5[r7] = r8;	 Catch:{ all -> 0x0025 }
        r7 = 1;
        r5[r7] = r2;	 Catch:{ all -> 0x0025 }
        r2 = 2;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 3;
        r7 = 10235; // 0x27fb float:1.4342E-41 double:5.057E-320;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0025 }
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 4;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 5;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r3.addRow(r5);	 Catch:{ all -> 0x0025 }
        goto L_0x00fe;
    L_0x0137:
        monitor-exit(r6);	 Catch:{ all -> 0x0025 }
        r2 = r3;
        goto L_0x00e1;
    L_0x013a:
        r2 = "MicroMsg.GWalletQueryProvider";
        r3 = "successfully queried!";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0025 }
        r4 = new android.database.MatrixCursor;	 Catch:{ all -> 0x0025 }
        r2 = qP;	 Catch:{ all -> 0x0025 }
        r4.<init>(r2);	 Catch:{ all -> 0x0025 }
        r2 = r14.kiG;	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x0209;
    L_0x014e:
        r2 = 0;
        r3 = r14.kiE;	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x01c7;
    L_0x0153:
        r3 = r14.kiE;	 Catch:{ all -> 0x0025 }
        r7 = r3.iterator();	 Catch:{ all -> 0x0025 }
        r3 = r2;
    L_0x015a:
        r2 = r7.hasNext();	 Catch:{ all -> 0x0025 }
        if (r2 == 0) goto L_0x01c6;
    L_0x0160:
        r2 = r7.next();	 Catch:{ all -> 0x0025 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0025 }
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ all -> 0x0025 }
        if (r5 != 0) goto L_0x0250;
    L_0x016c:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01b8 }
        r5.<init>(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = "productId";
        r8 = r5.getString(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = "price";
        r9 = r5.getString(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = "price_currency_code";
        r10 = r5.getString(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = "price_amount_micros";
        r5 = r5.getString(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = 10232; // 0x27f8 float:1.4338E-41 double:5.0553E-320;
        r11 = java.lang.Integer.valueOf(r2);	 Catch:{ JSONException -> 0x01b8 }
        r2 = 6;
        r12 = new java.lang.Object[r2];	 Catch:{ JSONException -> 0x01b8 }
        r13 = 0;
        r2 = r3 + 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ JSONException -> 0x024c }
        r12[r13] = r3;	 Catch:{ JSONException -> 0x024c }
        r3 = 1;
        r12[r3] = r8;	 Catch:{ JSONException -> 0x024c }
        r3 = 2;
        r12[r3] = r9;	 Catch:{ JSONException -> 0x024c }
        r3 = 3;
        r12[r3] = r11;	 Catch:{ JSONException -> 0x024c }
        r3 = 4;
        r12[r3] = r10;	 Catch:{ JSONException -> 0x024c }
        r3 = 5;
        r12[r3] = r5;	 Catch:{ JSONException -> 0x024c }
        r4.addRow(r12);	 Catch:{ JSONException -> 0x024c }
        r3 = r14.kiF;	 Catch:{ JSONException -> 0x024c }
        r3.remove(r8);	 Catch:{ JSONException -> 0x024c }
        r3 = r2;
        goto L_0x015a;
    L_0x01b8:
        r5 = move-exception;
        r2 = r3;
    L_0x01ba:
        r3 = "MicroMsg.GWalletQueryProvider";
        r5 = r5.toString();	 Catch:{ all -> 0x0025 }
        com.tencent.mm.sdk.platformtools.x.d(r3, r5);	 Catch:{ all -> 0x0025 }
    L_0x01c4:
        r3 = r2;
        goto L_0x015a;
    L_0x01c6:
        r2 = r3;
    L_0x01c7:
        r3 = r14.kiF;	 Catch:{ all -> 0x0025 }
        r7 = r3.iterator();	 Catch:{ all -> 0x0025 }
        r3 = r2;
    L_0x01ce:
        r2 = r7.hasNext();	 Catch:{ all -> 0x0025 }
        if (r2 == 0) goto L_0x0248;
    L_0x01d4:
        r2 = r7.next();	 Catch:{ all -> 0x0025 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0025 }
        r5 = 6;
        r8 = new java.lang.Object[r5];	 Catch:{ all -> 0x0025 }
        r9 = 0;
        r5 = r3 + 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0025 }
        r8[r9] = r3;	 Catch:{ all -> 0x0025 }
        r3 = 1;
        r8[r3] = r2;	 Catch:{ all -> 0x0025 }
        r2 = 2;
        r3 = "";
        r8[r2] = r3;	 Catch:{ all -> 0x0025 }
        r2 = 3;
        r3 = 10233; // 0x27f9 float:1.434E-41 double:5.056E-320;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0025 }
        r8[r2] = r3;	 Catch:{ all -> 0x0025 }
        r2 = 4;
        r3 = "";
        r8[r2] = r3;	 Catch:{ all -> 0x0025 }
        r2 = 5;
        r3 = "";
        r8[r2] = r3;	 Catch:{ all -> 0x0025 }
        r4.addRow(r8);	 Catch:{ all -> 0x0025 }
        r3 = r5;
        goto L_0x01ce;
    L_0x0209:
        r2 = r14.kiF;	 Catch:{ all -> 0x0025 }
        r3 = r2.iterator();	 Catch:{ all -> 0x0025 }
    L_0x020f:
        r2 = r3.hasNext();	 Catch:{ all -> 0x0025 }
        if (r2 == 0) goto L_0x0248;
    L_0x0215:
        r2 = r3.next();	 Catch:{ all -> 0x0025 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0025 }
        r5 = 6;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0025 }
        r7 = 0;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0025 }
        r5[r7] = r8;	 Catch:{ all -> 0x0025 }
        r7 = 1;
        r5[r7] = r2;	 Catch:{ all -> 0x0025 }
        r2 = 2;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 3;
        r7 = 10236; // 0x27fc float:1.4344E-41 double:5.0573E-320;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0025 }
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 4;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r2 = 5;
        r7 = "";
        r5[r2] = r7;	 Catch:{ all -> 0x0025 }
        r4.addRow(r5);	 Catch:{ all -> 0x0025 }
        goto L_0x020f;
    L_0x0248:
        monitor-exit(r6);	 Catch:{ all -> 0x0025 }
        r2 = r4;
        goto L_0x00e1;
    L_0x024c:
        r3 = move-exception;
        r5 = r3;
        goto L_0x01ba;
    L_0x0250:
        r2 = r3;
        goto L_0x01c4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.GWalletQueryProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
