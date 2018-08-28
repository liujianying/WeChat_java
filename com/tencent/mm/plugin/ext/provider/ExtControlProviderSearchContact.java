package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.aa.q;
import com.tencent.mm.bt.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> gRN = new ArrayList();
    private static final String[] iKv = new String[]{"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor iKz = null;

    static {
        int i = 0;
        String[] strArr = s.dAV;
        int length = strArr.length;
        while (i < length) {
            gRN.add(strArr[i]);
            i++;
        }
        gRN.add("officialaccounts");
        gRN.add("helper_entry");
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            pr(3);
            return null;
        } else if (bi.oW(this.iJN) || bi.oW(aIW())) {
            pr(3);
            return null;
        } else if (!atA()) {
            pr(1);
            return this.hdQ;
        } else if (!df(getContext())) {
            x.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            pr(2);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            x.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            pr(3);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (bi.oW(trim)) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                pr(3);
                return null;
            }
            Cursor a = au.HU().dAc.a(trim, "@micromsg.no.verify.biz.qq.com", gRN, false, 1, null);
            if (a == null) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                pr(3);
                return null;
            }
            b bVar = new b();
            bVar.b(4000, new 1(this, a, bVar));
            if (this.iKz != null) {
                pr(0);
            } else {
                pr(4);
            }
            return this.iKz;
        }
    }

    public static Cursor h(Cursor cursor) {
        e eVar = new e(iKv, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ab abVar = new ab();
                    abVar.d(cursor);
                    if (!s.fq(abVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = q.KJ().b(abVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        au.HU();
                        bd[] bH = c.FT().bH(abVar.field_username, 1);
                        byte[] bArr;
                        if (bH == null || bH.length != 1) {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = a.dc((long) ((int) abVar.dhP));
                            objArr[1] = abVar.BL();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = "0";
                            objArr[5] = Integer.valueOf(0);
                            eVar.addRow(objArr);
                        } else {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = a.dc((long) ((int) abVar.dhP));
                            objArr2[1] = abVar.BL();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            objArr2[3] = bH[0].getType() == 1 ? bH[0].field_content : "";
                            objArr2[4] = a.dc(bH[0].field_msgId);
                            objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.ext.b.b.P(bH[0]));
                            eVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            return eVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            eVar.close();
            return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
