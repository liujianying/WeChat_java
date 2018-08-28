package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static boolean Sx(String str) {
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String pK(String str) {
        CharSequence trim = str.trim();
        boolean startsWith = trim.startsWith("+");
        if (startsWith && trim.length() > 1) {
            trim = trim.substring(1, trim.length());
        }
        Matcher matcher = Pattern.compile("[^0-9]").matcher(trim);
        if (startsWith) {
            return "+" + matcher.replaceAll("").trim();
        }
        return matcher.replaceAll("").trim();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] d(android.content.Context r11, android.net.Uri r12) {
        /*
        r10 = 2;
        r9 = 0;
        r6 = 0;
        if (r12 != 0) goto L_0x0010;
    L_0x0005:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "uri == null";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r6;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.permission.a.bj(r11, r0);
        if (r0 != 0) goto L_0x0024;
    L_0x0019:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x000f;
    L_0x0024:
        r0 = r11.getContentResolver();	 Catch:{ Exception -> 0x0154, all -> 0x0170 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r12;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0154, all -> 0x0170 }
        if (r7 == 0) goto L_0x0199;
    L_0x0033:
        r0 = r7.getCount();	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        if (r0 <= 0) goto L_0x0199;
    L_0x0039:
        r7.moveToFirst();	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        r0 = "has_phone_number";
        r0 = r7.getColumnIndex(r0);	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        if (r0 <= 0) goto L_0x004b;
    L_0x0045:
        r0 = r7.getInt(r0);	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        if (r0 <= 0) goto L_0x0199;
    L_0x004b:
        r0 = "_id";
        r0 = r7.getColumnIndex(r0);	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        r3 = r7.getString(r0);	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        r0 = r11.getContentResolver();	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r2 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r5 = "contact_id = ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r3 = r4.append(r3);	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r4 = 0;
        r5 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0104, all -> 0x0188 }
        r2 = r0;
    L_0x0074:
        if (r2 == 0) goto L_0x012d;
    L_0x0076:
        r0 = r2.moveToFirst();	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        if (r0 == 0) goto L_0x012d;
    L_0x007c:
        r0 = r6;
        r1 = r6;
    L_0x007e:
        r3 = r2.isAfterLast();	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        if (r3 != 0) goto L_0x012f;
    L_0x0084:
        r3 = "data1";
        r3 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        r4 = "display_name";
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        r3 = r2.getString(r3);	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        r0 = "MicroMsg.AddressBookUtil";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r8 = "username : ";
        r5.<init>(r8);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.append(r4);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        if (r3 == 0) goto L_0x00fe;
    L_0x00b2:
        r0 = "MicroMsg.AddressBookUtil";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r8 = "phoneNumber : ";
        r5.<init>(r8);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.append(r3);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        if (r3 != 0) goto L_0x0114;
    L_0x00ca:
        r0 = r6;
    L_0x00cb:
        r3 = "MicroMsg.AddressBookUtil";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r8 = "phoneNumber : ";
        r5.<init>(r8);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        com.tencent.mm.sdk.platformtools.x.d(r3, r5);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r3 = android.telephony.PhoneNumberUtils.isGlobalPhoneNumber(r0);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        if (r3 == 0) goto L_0x00e8;
    L_0x00e7:
        r1 = r0;
    L_0x00e8:
        r0 = "MicroMsg.AddressBookUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r5 = "phoneResult : ";
        r3.<init>(r5);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
    L_0x00fe:
        r2.moveToNext();	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r0 = r4;
        goto L_0x007e;
    L_0x0104:
        r0 = move-exception;
        r1 = "MicroMsg.AddressBookUtil";
        r2 = "getContactsInfo2:";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ Exception -> 0x018d, all -> 0x0188 }
        r2 = r6;
        goto L_0x0074;
    L_0x0114:
        r0 = "\\D";
        r5 = "";
        r0 = r3.replaceAll(r0, r5);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        r3 = "86";
        r3 = r0.startsWith(r3);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        if (r3 == 0) goto L_0x00cb;
    L_0x0127:
        r3 = 2;
        r0 = r0.substring(r3);	 Catch:{ Exception -> 0x0192, all -> 0x0188 }
        goto L_0x00cb;
    L_0x012d:
        r0 = r6;
        r1 = r6;
    L_0x012f:
        if (r2 == 0) goto L_0x013a;
    L_0x0131:
        r3 = r2.isClosed();	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
        if (r3 != 0) goto L_0x013a;
    L_0x0137:
        r2.close();	 Catch:{ Exception -> 0x0196, all -> 0x0188 }
    L_0x013a:
        if (r7 == 0) goto L_0x0145;
    L_0x013c:
        r2 = r7.isClosed();
        if (r2 != 0) goto L_0x0145;
    L_0x0142:
        r7.close();
    L_0x0145:
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 == 0) goto L_0x017e;
    L_0x014b:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x017e;
    L_0x0151:
        r0 = r6;
        goto L_0x000f;
    L_0x0154:
        r2 = move-exception;
        r3 = r6;
        r0 = r6;
        r1 = r6;
    L_0x0158:
        r4 = "MicroMsg.AddressBookUtil";
        r5 = "getContactsInfo1:";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x018a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r2, r5, r7);	 Catch:{ all -> 0x018a }
        if (r3 == 0) goto L_0x0145;
    L_0x0166:
        r2 = r3.isClosed();
        if (r2 != 0) goto L_0x0145;
    L_0x016c:
        r3.close();
        goto L_0x0145;
    L_0x0170:
        r0 = move-exception;
        r7 = r6;
    L_0x0172:
        if (r7 == 0) goto L_0x017d;
    L_0x0174:
        r1 = r7.isClosed();
        if (r1 != 0) goto L_0x017d;
    L_0x017a:
        r7.close();
    L_0x017d:
        throw r0;
    L_0x017e:
        r2 = new java.lang.String[r10];
        r2[r9] = r0;
        r0 = 1;
        r2[r0] = r1;
        r0 = r2;
        goto L_0x000f;
    L_0x0188:
        r0 = move-exception;
        goto L_0x0172;
    L_0x018a:
        r0 = move-exception;
        r7 = r3;
        goto L_0x0172;
    L_0x018d:
        r2 = move-exception;
        r3 = r7;
        r0 = r6;
        r1 = r6;
        goto L_0x0158;
    L_0x0192:
        r2 = move-exception;
        r3 = r7;
        r0 = r4;
        goto L_0x0158;
    L_0x0196:
        r2 = move-exception;
        r3 = r7;
        goto L_0x0158;
    L_0x0199:
        r0 = r6;
        r1 = r6;
        goto L_0x013a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.a.d(android.content.Context, android.net.Uri):java.lang.String[]");
    }

    public static List<String[]> eG(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            } catch (Throwable e) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                query = null;
            }
            if (query == null) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
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
                    Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("photo_id")));
                    linkedList.add(new String[]{string2, string, string3, string4, String.valueOf(valueOf)});
                } while (query.moveToNext());
                query.close();
                return linkedList;
            } catch (Throwable e2) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
                query.close();
            } catch (Throwable e22) {
                query.close();
                throw e22;
            }
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return linkedList;
    }

    public static List<String[]> cz(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, "sort_key_alt");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                x.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[]{e.getMessage()});
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            }
            if (query == null) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
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
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
                x.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[]{e2.getMessage()});
                query.close();
            } catch (Throwable e22) {
                query.close();
                throw e22;
            }
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return linkedList;
    }

    public static List<String[]> eH(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            try {
                Cursor query = contentResolver.query(Email.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    return linkedList;
                }
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("data1"));
                        String string2 = query.getString(query.getColumnIndex("contact_id"));
                        String string3 = query.getString(query.getColumnIndex("data4"));
                        String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                        String string5 = query.getString(query.getColumnIndex("photo_id"));
                        linkedList.add(new String[]{string2, string3, string, string4, string5});
                    } while (query.moveToNext());
                }
                query.close();
                return linkedList;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getEmailInfo", new Object[0]);
            }
        } else {
            x.e("MicroMsg.AddressBookUtil", "no contact permission");
            return linkedList;
        }
    }

    public static List<String> eI(Context context) {
        Throwable e;
        List<String> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    try {
                        x.e("MicroMsg.AddressBookUtil", "getPhonesCursor: cursor is null.");
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.AddressBookUtil", "exception in getMobileList, [%s]", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            return linkedList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                }
                if (query.moveToFirst()) {
                    do {
                        linkedList.add(query.getString(query.getColumnIndex("data1")));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
                return linkedList;
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
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return linkedList;
    }

    public static String h(String str, Context context) {
        String str2 = "";
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = context.getContentResolver().query(Contacts.CONTENT_URI, new String[]{"display_name"}, "_id = ?", new String[]{str}, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getContactNameById:", new Object[0]);
                query = null;
            }
            if (query == null) {
                return str2;
            }
            String string;
            if (query.moveToFirst()) {
                string = query.getString(0);
            } else {
                string = str2;
            }
            query.close();
            return string;
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return str2;
    }

    public static Uri cbh() {
        try {
            return Contacts.CONTENT_URI;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap a(String str, Context context, boolean z) {
        if (str == null || str.equals("")) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            InputStream openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(Contacts.CONTENT_URI, bi.WV(str)), z);
            if (openContactPhotoInputStream == null) {
                return null;
            }
            Bitmap decodeStream = c.decodeStream(openContactPhotoInputStream);
            if (decodeStream != null) {
                return c.a(decodeStream, true, 4.0f);
            }
            return decodeStream;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getAvatar, contactId:%s", new Object[]{str});
            return null;
        }
    }

    public static boolean b(String str, Context context, byte[] bArr) {
        Throwable e;
        if (str == null || str.equals("")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                ContentResolver contentResolver = context.getContentResolver();
                long WV = bi.WV(str);
                ContentValues contentValues = new ContentValues();
                x.d("MicroMsg.AddressBookUtil", "where is %s", new Object[]{String.format("%s=%d and %s='%s'", new Object[]{"raw_contact_id", Long.valueOf(WV), "mimetype", "vnd.android.cursor.item/photo"})});
                query = contentResolver.query(Data.CONTENT_URI, null, r3, null, null);
                if (query != null) {
                    try {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                        if (query.moveToFirst()) {
                            columnIndexOrThrow = query.getInt(columnIndexOrThrow);
                        } else {
                            columnIndexOrThrow = -1;
                        }
                        contentValues.put("raw_contact_id", Long.valueOf(WV));
                        contentValues.put("is_super_primary", Integer.valueOf(1));
                        contentValues.put("data15", bArr);
                        contentValues.put("mimetype", "vnd.android.cursor.item/photo");
                        if (columnIndexOrThrow >= 0) {
                            boolean z;
                            if (contentResolver.update(Data.CONTENT_URI, contentValues, "_id = " + columnIndexOrThrow, null) > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (query != null) {
                                query.close();
                            }
                            return z;
                        }
                        contentResolver.insert(Data.CONTENT_URI, contentValues);
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                            if (!(query == null || query.isClosed())) {
                                query.close();
                            }
                            if (query == null) {
                                return false;
                            }
                            query.close();
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                } else if (query == null) {
                    return false;
                } else {
                    query.close();
                    return false;
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
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return false;
    }
}
