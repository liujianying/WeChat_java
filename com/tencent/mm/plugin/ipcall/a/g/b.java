package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static final String hPy = new String(Character.toChars(91));
    private static HashMap<String, c> ksx = new HashMap();

    public static ArrayList<c> aXU() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<c> arrayList = new ArrayList();
        if (a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ad.getContext().getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "display_name", "data1"}, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
            HashMap hashMap = new HashMap();
            x.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (query == null) {
                return arrayList;
            }
            try {
                x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", new Object[]{Integer.valueOf(query.getCount())});
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("contact_id");
                    int columnIndex2 = query.getColumnIndex("display_name");
                    int columnIndex3 = query.getColumnIndex("data1");
                    while (!query.isAfterLast()) {
                        c a = a(query, columnIndex, columnIndex2, columnIndex3);
                        if (!(a == null || a.ksy == null || a.ksy.size() <= 0 || bi.oW(a.field_contactId))) {
                            if (hashMap.containsKey(a.field_contactId)) {
                                c cVar = (c) hashMap.get(a.field_contactId);
                                if (a.ksy.size() > 0 && !cVar.ksy.contains(a.ksy.get(0))) {
                                    cVar.ksy.add(a.ksy.get(0));
                                }
                            } else {
                                hashMap.put(a.field_contactId, a);
                            }
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
            arrayList.addAll(hashMap.values());
            ksx = hashMap;
            long currentTimeMillis2 = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return arrayList;
    }

    public static HashMap<String, c> aXV() {
        return ksx;
    }

    public static HashMap<String, c> aXW() {
        aXU();
        return ksx;
    }

    public static ArrayList<String> EO(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ad.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return arrayList;
            }
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("data1")));
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressBookInfoExtracter", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return arrayList;
    }

    private static c a(Cursor cursor, int i, int i2, int i3) {
        String str = null;
        if (a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            c cVar = new c();
            cVar.ksy = new ArrayList();
            String string = cursor.getString(i);
            String string2 = cursor.getString(i2);
            String string3 = cursor.getString(i3);
            cVar.field_contactId = string;
            cVar.field_systemAddressBookUsername = string2;
            if (!(bi.oW(string3) || cVar.ksy.contains(string3))) {
                cVar.ksy.add(string3);
            }
            if (bi.oW(cVar.field_systemAddressBookUsername) && cVar.ksy.size() > 0) {
                cVar.field_systemAddressBookUsername = (String) cVar.ksy.get(0);
            }
            Iterator it = cVar.ksy.iterator();
            string2 = str;
            while (it.hasNext()) {
                string = com.tencent.mm.plugin.ipcall.b.a.Fk((String) it.next());
                if (bi.oW(string)) {
                    string = string2;
                } else if (!string.endsWith("@stranger")) {
                    break;
                }
                string2 = string;
            }
            string = string2;
            if (!bi.oW(string)) {
                cVar.field_wechatUsername = string;
            }
            if (bi.oW(cVar.field_systemAddressBookUsername)) {
                cVar.field_sortKey = "";
            } else {
                try {
                    str = h.oI(cVar.field_systemAddressBookUsername);
                } catch (Exception e) {
                    x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                }
                if (bi.oW(str)) {
                    cVar.field_sortKey = "";
                } else if (Character.isLetter(str.charAt(0))) {
                    cVar.field_sortKey = str.toUpperCase();
                } else {
                    cVar.field_sortKey = hPy + str.toUpperCase();
                }
            }
            return cVar;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return str;
    }
}
