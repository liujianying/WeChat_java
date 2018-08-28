package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bt.e;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static final UriMatcher iJT;
    private static boolean iKs = false;
    private static al iKt = new al(new 1(), false);
    private static final String[] iKv = new String[]{"feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private boolean bNt = false;
    private boolean bNu = false;
    private int bNv = 0;
    private String iKw = "";

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        iJT = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    }

    private static void cz(boolean z) {
        if (z) {
            iKs = true;
            iKt.J(15000, 15000);
            return;
        }
        iKt.J(0, 0);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderSNS", "query() " + uri);
        a(uri, getContext(), iJT);
        if (uri == null) {
            pr(3);
            return null;
        } else if (bi.oW(this.iJN) || bi.oW(aIW())) {
            pr(3);
            return null;
        } else if (iKs) {
            x.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            pr(5);
            return null;
        } else {
            cz(true);
            if (!atA()) {
                cz(false);
                pr(1);
                return this.hdQ;
            } else if (!df(getContext())) {
                x.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                cz(false);
                pr(2);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                cz(false);
                pr(3);
                return null;
            } else {
                String str3 = strArr2[0];
                if (bi.oW(str3)) {
                    x.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    cz(false);
                    pr(3);
                    return null;
                }
                try {
                    long j;
                    Cursor dd;
                    if ("0".equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = Long.valueOf(a.AG(str3.trim())).longValue();
                    }
                    switch (iJT.match(uri)) {
                        case 17:
                            dd = dd(j);
                            break;
                        default:
                            dd = null;
                            break;
                    }
                    if (dd != null) {
                        pr(0);
                    } else {
                        pr(4);
                    }
                    cz(false);
                    return dd;
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    cz(false);
                    pr(4);
                    return null;
                }
            }
        }
    }

    private Cursor dd(long j) {
        int i = 1;
        x.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + j);
        try {
            com.tencent.mm.l.a Ye;
            x.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", new Object[]{Long.valueOf(j)});
            if (j == 0) {
                au.HU();
                Ye = c.FR().Ye(q.GF());
            } else {
                au.HU();
                Ye = c.FR().gl(j);
            }
            if (Ye == null || ((int) Ye.dhP) <= 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.bNt = com.tencent.mm.l.a.gd(Ye.field_type);
                this.bNu = q.gQ(Ye.field_username);
                x.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", new Object[]{Ye.field_username, Boolean.valueOf(this.bNt), Boolean.valueOf(this.bNu)});
                b bVar = new b();
                bVar.b(10000, new 2(this, Ye, bVar));
            }
            if (i == 0) {
                x.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                return null;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        return aJb();
    }

    private Cursor aJb() {
        x.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
        e eVar = new e(iKv, (byte) 0);
        ex exVar = new ex();
        exVar.bMJ.bML = this.iKw;
        if (com.tencent.mm.sdk.b.a.sFg.m(exVar)) {
            Cursor cursor = exVar.bMK.bMC;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + count);
                    if (count <= 0 || !cursor.moveToFirst()) {
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                ey eyVar = new ey();
                                eyVar.bMM.bMO = cursor;
                                if (com.tencent.mm.sdk.b.a.sFg.m(eyVar)) {
                                    au.HU();
                                    ab Ye = c.FR().Ye(eyVar.bMN.bMP);
                                    if (Ye != null && ((int) Ye.dhP) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (eyVar.bMN.bMT) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(eyVar.bMN.bMV == null || eyVar.bMN.bMV.size() <= 0 || getContext() == null)) {
                                            x.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[]{Integer.valueOf(eyVar.bMN.bMV.size())});
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) eyVar.bMN.bMV.get(0);
                                                if (!(eyVar.bMN.bMW == null || eyVar.bMN.bMW.size() <= 0 || getContext() == null)) {
                                                    x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[]{Integer.valueOf(eyVar.bMN.bMW.size()), Integer.valueOf(eyVar.bMN.bMX), Integer.valueOf(eyVar.bMN.bMY)});
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) eyVar.bMN.bMW.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.aa.c.A(eyVar.bMN.bMP, false);
                                                objArr = new Object[11];
                                                objArr[0] = a.dc((long) eyVar.bMN.bMQ);
                                                objArr[1] = eyVar.bMN.bMR;
                                                objArr[2] = obj;
                                                objArr[3] = Ye.BL();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(eyVar.bMN.bMS);
                                                objArr[6] = Integer.valueOf(eyVar.bMN.bMU);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(eyVar.bMN.bMX);
                                                objArr[10] = Integer.valueOf(eyVar.bMN.bMY);
                                                eVar.addRow(objArr);
                                            }
                                        }
                                        String obj2 = str;
                                        x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[]{Integer.valueOf(eyVar.bMN.bMW.size()), Integer.valueOf(eyVar.bMN.bMX), Integer.valueOf(eyVar.bMN.bMY)});
                                        str2 = (String) eyVar.bMN.bMW.get(0);
                                        str = com.tencent.mm.aa.c.A(eyVar.bMN.bMP, false);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = a.dc((long) eyVar.bMN.bMQ);
                                            objArr[1] = eyVar.bMN.bMR;
                                            objArr[2] = obj2;
                                            objArr[3] = Ye.BL();
                                            if (str == null) {
                                                str = "";
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(eyVar.bMN.bMS);
                                            objArr[6] = Integer.valueOf(eyVar.bMN.bMU);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(eyVar.bMN.bMX);
                                            objArr[10] = Integer.valueOf(eyVar.bMN.bMY);
                                            eVar.addRow(objArr);
                                        } catch (Throwable e) {
                                            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    eVar.close();
                    return null;
                }
            }
            return eVar;
        }
        eVar.close();
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
