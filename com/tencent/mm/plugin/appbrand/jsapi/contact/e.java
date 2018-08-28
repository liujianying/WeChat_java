package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";
    private List<String[]> fPD;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSearchContacts", "data is null, err");
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        x.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        x.d("MicroMsg.JsApiSearchContacts", "data:%s", new Object[]{jSONObject});
        MMActivity c = com.tencent.mm.plugin.appbrand.jsapi.e.c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", new Object[]{lVar.mAppId});
            lVar.E(i, f("fail", null));
            return;
        }
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 1(this, lVar, jSONObject, i));
        MMActivity c2 = com.tencent.mm.plugin.appbrand.jsapi.e.c(lVar);
        if (c2 == null) {
            lVar.E(i, f("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.READ_CONTACTS", 48, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
            }
        }
        if (z) {
            String optString = jSONObject.optString("phoneNumber");
            Map hashMap;
            if (optString.length() < 8) {
                x.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
                hashMap = new HashMap();
                hashMap.put("result", "");
                lVar.E(i, f("ok", hashMap));
                return;
            }
            if (this.fPD == null) {
                this.fPD = cz(c);
            }
            if (this.fPD == null) {
                x.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
                lVar.E(i, f("fail", null));
                return;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(this.fPD == null || this.fPD.isEmpty())) {
                for (String[] strArr : this.fPD) {
                    String str = strArr[2];
                    if (str == null) {
                        str = null;
                    } else {
                        str = str.replaceAll("\\D", "");
                        if (str.startsWith("86")) {
                            str = str.substring(2);
                        }
                    }
                    String aG = bi.aG(strArr[1], "");
                    if (!bi.oW(str) && bo(optString, str)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("phoneNumber", str);
                            jSONObject2.put("name", aG);
                            jSONArray.put(jSONObject2);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                        }
                    }
                }
            }
            x.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[]{jSONArray.toString()});
            hashMap = new HashMap();
            hashMap.put("result", jSONArray.toString());
            lVar.E(i, f("ok", hashMap));
            return;
        }
        x.i("MicroMsg.JsApiSearchContacts", "check permission");
    }

    private static boolean bo(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length < 8) {
            x.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", new Object[]{Integer.valueOf(str.length())});
            return false;
        } else if (length > length2) {
            x.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", new Object[]{Integer.valueOf(length), Integer.valueOf(length2)});
            return false;
        } else {
            length2 = 0;
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) != str2.charAt(i)) {
                    length2++;
                    if (length2 > 3) {
                        break;
                    }
                }
            }
            return length2 <= 3;
        }
    }

    private static List<String[]> cz(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, "sort_key_alt");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                x.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", new Object[]{e.getMessage()});
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            }
            if (query == null) {
                x.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
                return linkedList;
            }
            try {
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                    return linkedList;
                }
                do {
                    String string = query.getString(query.getColumnIndex("display_name"));
                    String string2 = query.getString(query.getColumnIndex("contact_id"));
                    String string3 = query.getString(query.getColumnIndex("data1"));
                    String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                    linkedList.add(new String[]{string2, string, string3, string4});
                } while (query.moveToNext());
                query.close();
                return linkedList;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiSearchContacts", e2, "", new Object[0]);
                x.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", new Object[]{e2.getMessage()});
                query.close();
            } catch (Throwable e22) {
                query.close();
                throw e22;
            }
        }
        x.e("MicroMsg.JsApiSearchContacts", "no contact permission");
        return linkedList;
    }
}
