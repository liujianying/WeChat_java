package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class c {
    public long sKx = -1;

    public static class a {
        public String[] columns;
        public Map<String, String> sKA = new HashMap();
        public Field[] sKy;
        public String sKz;
        public String sql;
    }

    public abstract a AX();

    public abstract void d(Cursor cursor);

    public abstract ContentValues wH();

    public static a I(Class<?> cls) {
        a aVar = new a();
        List linkedList = new LinkedList();
        for (Field field : cls.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (!(name == null || !Modifier.isPublic(modifiers) || Modifier.isFinal(modifiers))) {
                String substring;
                if (name.startsWith("field_")) {
                    substring = name.substring(6);
                } else {
                    substring = name;
                }
                if (field.isAnnotationPresent(h.class)) {
                    if (((h) field.getAnnotation(h.class)).cjt() == 1) {
                        aVar.sKz = substring;
                    }
                } else if (!name.startsWith("field_")) {
                }
                if (!bi.oW(substring)) {
                    if (substring.equals("rowid")) {
                        Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                    }
                    linkedList.add(field);
                }
            }
        }
        aVar.sKy = (Field[]) linkedList.toArray(new Field[0]);
        aVar.columns = a(aVar.sKy);
        aVar.sKA = b(aVar.sKy);
        aVar.sql = c(aVar.sKy);
        return aVar;
    }

    private static String[] a(Field[] fieldArr) {
        String[] strArr = new String[(fieldArr.length + 1)];
        for (int i = 0; i < fieldArr.length; i++) {
            boolean z;
            strArr[i] = a(fieldArr[i]);
            String str = "getFullColumns failed:" + fieldArr[i].getName();
            if (bi.oW(strArr[i])) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(str, z);
        }
        strArr[fieldArr.length] = "rowid";
        return strArr;
    }

    private static Map<String, String> b(Field[] fieldArr) {
        Map<String, String> hashMap = new HashMap();
        for (Field field : fieldArr) {
            String H = b.H(field.getType());
            if (H == null) {
                x.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String a = a(field);
                if (!bi.oW(a)) {
                    hashMap.put(a, H);
                }
            }
        }
        return hashMap;
    }

    private static String c(Field[] fieldArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < fieldArr.length) {
            Field field = fieldArr[i];
            String H = b.H(field.getType());
            if (H == null) {
                x.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String a = a(field);
                if (!bi.oW(a)) {
                    int cjt;
                    String str = "";
                    if (field.isAnnotationPresent(h.class)) {
                        str = " default '" + ((h) field.getAnnotation(h.class)).cjs() + "' ";
                        cjt = ((h) field.getAnnotation(h.class)).cjt();
                    } else {
                        cjt = 0;
                    }
                    stringBuilder.append(a + " " + H + str + (cjt == 1 ? " PRIMARY KEY " : ""));
                    stringBuilder.append(i == fieldArr.length + -1 ? "" : ", ");
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String a(Field field) {
        if (field == null) {
            return null;
        }
        String name = field.getName();
        if (name == null || name.length() <= 0) {
            return null;
        }
        return name.startsWith("field_") ? name.substring(6) : name;
    }

    public static boolean a(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            if (cursor == null) {
                return true;
            }
            return false;
        } else if (cursor == null || cursor.getCount() != 1) {
            return false;
        } else {
            cursor.moveToFirst();
            int columnCount = cursor.getColumnCount();
            int size = contentValues.size();
            if (contentValues.containsKey("rowid")) {
                size--;
            }
            if (cursor.getColumnIndex("rowid") != -1) {
                columnCount--;
            }
            if (size != columnCount) {
                return false;
            }
            try {
                for (Entry key : contentValues.valueSet()) {
                    String str = (String) key.getKey();
                    if (!str.equals("rowid")) {
                        columnCount = cursor.getColumnIndex(str);
                        if (columnCount == -1) {
                            return false;
                        }
                        if (contentValues.get(str) instanceof byte[]) {
                            byte[] bArr = (byte[]) contentValues.get(str);
                            byte[] blob = cursor.getBlob(columnCount);
                            if (!(bArr == null && blob == null)) {
                                if (bArr == null && blob != null) {
                                    size = 0;
                                    if (size != 0) {
                                        return false;
                                    }
                                } else if (bArr == null || blob != null) {
                                    if (bArr.length != blob.length) {
                                        size = 0;
                                    } else {
                                        for (columnCount = 0; columnCount < bArr.length; columnCount++) {
                                            if (bArr[columnCount] != blob[columnCount]) {
                                                size = 0;
                                                break;
                                            }
                                        }
                                    }
                                    if (size != 0) {
                                        return false;
                                    }
                                } else {
                                    size = 0;
                                    if (size != 0) {
                                        return false;
                                    }
                                }
                            }
                            size = 1;
                            if (size != 0) {
                                return false;
                            }
                        } else if (cursor.getString(columnCount) == null && contentValues.get(str) != null) {
                            return false;
                        } else {
                            if (contentValues.get(str) == null) {
                                return false;
                            }
                            if (!contentValues.get(str).toString().equals(cursor.getString(columnCount))) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SDK.IAutoDBItem", e, "", new Object[0]);
                return false;
            }
        }
    }
}
