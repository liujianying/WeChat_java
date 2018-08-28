package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        int i2 = 0;
        final MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", new Object[]{lVar.mAppId});
            lVar.E(i, f("fail", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 2(this, lVar, jSONObject, i));
        MMActivity c2 = c(lVar);
        if (c2 == null) {
            lVar.E(i, f("fail", null));
        } else {
            i2 = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.READ_CONTACTS", 48, "", "");
            if (i2 != 0) {
                com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
            }
        }
        if (i2 == 0) {
            x.i("MicroMsg.JsApiChooseContact", "check permission");
            return;
        }
        c.geJ = new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (100 != i) {
                    x.e("MicroMsg.JsApiChooseContact", "requestcode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    lVar.E(i, b.this.f("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    lVar.E(i, b.this.f("cancel", null));
                } else if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        x.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                        lVar.E(i, b.this.f("fail", null));
                    } else if (com.tencent.mm.pluginsdk.permission.a.bj(c, "android.permission.READ_CONTACTS")) {
                        try {
                            String str;
                            Object obj;
                            Cursor query = c.getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    String string = query.getString(query.getColumnIndex("_id"));
                                    Cursor query2 = c.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                    x.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", new Object[]{query});
                                    if (query2 == null) {
                                        lVar.E(i, b.this.f("fail", null));
                                        return;
                                    }
                                    if (query2.moveToFirst()) {
                                        string = null;
                                        str = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex("display_name");
                                            String string2 = query2.getString(columnIndex);
                                            string = query2.getString(columnIndex2);
                                            x.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : " + string);
                                            if (string2 != null) {
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (string2 == null) {
                                                    string2 = null;
                                                } else {
                                                    string2 = string2.replaceAll("\\D", "");
                                                    if (string2.startsWith("86")) {
                                                        string2 = string2.substring(2);
                                                    }
                                                }
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                    string2 = str;
                                                }
                                                x.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : " + string2);
                                            } else {
                                                string2 = str;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                        }
                                        obj = string;
                                    } else {
                                        Map obj2 = null;
                                        str = null;
                                    }
                                    try {
                                        query2.close();
                                    } catch (Exception e) {
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (bi.oW(str)) {
                                        Map hashMap = new HashMap(1);
                                        hashMap.put("phoneNumber", str);
                                        str = "displayName";
                                        if (obj2 == null) {
                                            obj2 = "";
                                        }
                                        hashMap.put(str, obj2);
                                        lVar.E(i, b.this.f("ok", hashMap));
                                    }
                                    lVar.E(i, b.this.f("fail", null));
                                    Toast.makeText(c, j.app_brand_pick_contact_error, 0).show();
                                    return;
                                }
                            }
                            obj2 = null;
                            str = null;
                            query.close();
                            if (bi.oW(str)) {
                                lVar.E(i, b.this.f("fail", null));
                                Toast.makeText(c, j.app_brand_pick_contact_error, 0).show();
                                return;
                            }
                            Map hashMap2 = new HashMap(1);
                            hashMap2.put("phoneNumber", str);
                            str = "displayName";
                            if (obj2 == null) {
                                obj2 = "";
                            }
                            hashMap2.put(str, obj2);
                            lVar.E(i, b.this.f("ok", hashMap2));
                        } catch (SecurityException e2) {
                            x.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", new Object[]{e2.toString()});
                            h.b(c, ad.getResources().getString(j.app_brand_read_contact_error), "", true);
                            lVar.E(i, b.this.f("fail:system permission denied", null));
                        }
                    } else {
                        x.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                        lVar.E(i, b.this.f("fail:system permission denied", null));
                    }
                }
            }
        };
        c.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 100);
    }
}
