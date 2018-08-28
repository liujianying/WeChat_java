package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.f.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";
    private f fPg;

    static /* synthetic */ void a(a aVar, Intent intent, MMActivity mMActivity, String str) {
        ContentValues contentValues;
        intent.setFlags(268435456);
        ArrayList arrayList = new ArrayList();
        b bVar = aVar.fPg.fkp;
        StringBuilder stringBuilder = new StringBuilder();
        if (bi.WC(bVar.fkF) || bi.WC(bVar.fkG) || bi.WC(bVar.fkH)) {
            if (bVar.fkH.trim().length() > 0) {
                stringBuilder.append(bVar.fkH);
            }
            if (bVar.fkG.trim().length() > 0) {
                stringBuilder.append(bVar.fkG);
            }
            if (bVar.fkF.trim().length() > 0) {
                stringBuilder.append(bVar.fkF);
            }
        } else {
            if (bVar.fkF.trim().length() > 0) {
                stringBuilder.append(bVar.fkF);
            }
            if (bVar.fkG.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.fkG);
            }
            if (bVar.fkH.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.fkH);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (bi.oW(stringBuilder2)) {
            x.e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        } else {
            intent.putExtra("name", stringBuilder2);
        }
        if (!bi.oW(aVar.fPg.bgn)) {
            stringBuilder2 = aVar.fPg.bgn;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bi.oW(aVar.fPg.fky)) {
            stringBuilder2 = aVar.fPg.fky;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", stringBuilder2);
            arrayList.add(contentValues);
        }
        if (!(bi.oW(aVar.fPg.fkz) && bi.oW(aVar.fPg.title))) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
            if (!bi.oW(aVar.fPg.fkz)) {
                contentValues2.put("data1", aVar.fPg.fkz);
            }
            if (!bi.oW(aVar.fPg.title)) {
                contentValues2.put("data4", aVar.fPg.title);
            }
            contentValues2.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues2);
        }
        if (!bi.oW(aVar.fPg.url)) {
            stringBuilder2 = aVar.fPg.url;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bi.oW(aVar.fPg.csD)) {
            intent.putExtra("email", aVar.fPg.csD);
        }
        if (!bi.oW(aVar.fPg.fku)) {
            b(arrayList, aVar.fPg.fku, 2);
        }
        if (!bi.oW(aVar.fPg.fkv)) {
            b(arrayList, aVar.fPg.fkv, 1);
        }
        if (!bi.oW(aVar.fPg.fkx)) {
            b(arrayList, aVar.fPg.fkx, 3);
        }
        if (!bi.oW(aVar.fPg.fkw)) {
            b(arrayList, aVar.fPg.fkw, 10);
        }
        if (!bi.oW(aVar.fPg.fkB)) {
            b(arrayList, aVar.fPg.fkB, 5);
        }
        if (!bi.oW(aVar.fPg.fkA)) {
            b(arrayList, aVar.fPg.fkA, 4);
        }
        a(arrayList, aVar.fPg.fkt, 3);
        a(arrayList, aVar.fPg.fks, 2);
        a(arrayList, aVar.fPg.fkr, 1);
        if (!bi.oW(aVar.fPg.fkC)) {
            stringBuilder2 = aVar.fPg.fkC;
            String string = mMActivity.getString(j.app_name);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/im");
            contentValues3.put("data1", stringBuilder2);
            contentValues3.put("data5", Integer.valueOf(-1));
            contentValues3.put("data6", string);
            arrayList.add(contentValues3);
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, aVar.fPg.fkq);
        if (!(itemByLocalId == null || bi.oW(itemByLocalId.dDG))) {
            stringBuilder2 = itemByLocalId.dDG;
            if (!stringBuilder2.startsWith("file://")) {
                stringBuilder2 = "file://" + stringBuilder2;
            }
            Bitmap a = com.tencent.mm.modelappbrand.b.b.Ka().a(stringBuilder2, null);
            if (a != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues4.put("data15", toByteArray);
                arrayList.add(contentValues4);
                a.recycle();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", e, "", new Object[0]);
                }
            }
        }
        intent.putParcelableArrayListExtra("data", arrayList);
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiAddPhoneContact", "data is null");
        } else if (bi.oW(jSONObject.optString("firstName"))) {
            lVar.E(i, f("fail:firstName is null", null));
            x.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
        } else {
            Context c = c(lVar);
            if (c == null) {
                lVar.E(i, f("fail", null));
                x.e("MicroMsg.JsApiAddPhoneContact", "mmActivity is null, invoke fail!");
                return;
            }
            this.fPg = new f();
            this.fPg.fkq = jSONObject.optString("photoFilePath");
            this.fPg.bgn = jSONObject.optString("nickName");
            this.fPg.fkp = new b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            this.fPg.fky = jSONObject.optString("remark");
            this.fPg.fku = jSONObject.optString("mobilePhoneNumber");
            this.fPg.fkC = jSONObject.optString("weChatNumber");
            this.fPg.fkt = d(jSONObject, "address");
            this.fPg.fkz = jSONObject.optString("organization");
            this.fPg.title = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
            this.fPg.fkA = jSONObject.optString("workFaxNumber");
            this.fPg.fkx = jSONObject.optString("workPhoneNumber");
            this.fPg.fkw = jSONObject.optString("hostNumber");
            this.fPg.csD = jSONObject.optString("email");
            this.fPg.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.fPg.fks = d(jSONObject, "workAddress");
            this.fPg.fkB = jSONObject.optString("homeFaxNumber");
            this.fPg.fkv = jSONObject.optString("homePhoneNumber");
            this.fPg.fkr = d(jSONObject, "homeAddress");
            c.geJ = new 2(this, lVar, i);
            String[] strArr = new String[]{c.getString(j.app_brand_phone_contact_add_new_contact), c.getString(j.app_brand_phone_contact_add_exist_contact)};
            h.a(c, "", strArr, "", new 1(this, c, lVar.mAppId));
        }
    }

    private static com.tencent.mm.plugin.appbrand.appstorage.f.a d(JSONObject jSONObject, String str) {
        return new com.tencent.mm.plugin.appbrand.appstorage.f.a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
    }

    private static void a(ArrayList<ContentValues> arrayList, com.tencent.mm.plugin.appbrand.appstorage.f.a aVar, int i) {
        if (aVar != null && aVar.acD().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", aVar.acD());
            contentValues.put("data9", aVar.fkE);
            contentValues.put("data2", Integer.valueOf(i));
            arrayList.add(contentValues);
        }
    }

    private static void b(ArrayList<ContentValues> arrayList, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i));
        arrayList.add(contentValues);
    }
}
