package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ag extends i<ad> implements a {
    public static final String[] diD = new String[]{i.a(ad.dhO, "ContactLabel")};
    private e diF;
    private HashMap<String, int[]> tak;
    public HashMap<Integer, ArrayList<String>> tal;

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b(true, (ad) cVar, strArr);
    }

    public ag(e eVar) {
        this(eVar, ad.dhO, "ContactLabel");
    }

    private ag(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.tak = null;
        this.tal = null;
        this.diF = eVar;
        eVar.fV("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final ArrayList<String> cld() {
        ArrayList<String> arrayList = null;
        long VF = bi.VF();
        Cursor a = this.diF.a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(arrayList.size()), bi.cjd()});
        }
        return arrayList;
    }

    public final ArrayList<ad> cle() {
        ArrayList<ad> arrayList = null;
        long VF = bi.VF();
        Cursor b = this.diF.b("select * from ContactLabel order by createTime ASC ", null, 2);
        if (b != null) {
            arrayList = new ArrayList();
            while (b.moveToNext()) {
                ad adVar = new ad();
                adVar.d(b);
                arrayList.add(adVar);
            }
            b.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(arrayList.size()), bi.cjd()});
        }
        return arrayList;
    }

    public final void aYE() {
        x.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[]{bi.cjd()});
        this.tak = null;
        this.tal = null;
    }

    public final void clf() {
        if (this.tak == null || this.tal == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long VF = bi.VF();
            Cursor b = this.diF.b("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.l.a.Bs() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (b == null) {
                this.tak = hashMap;
                this.tal = hashMap2;
                return;
            }
            while (b.moveToNext()) {
                String string = b.getString(0);
                if (!bi.oW(string)) {
                    String[] split = bi.oV(b.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        Object obj = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            obj[i] = bi.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(obj[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(obj[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(obj[i]), arrayList);
                            }
                        }
                        hashMap.put(string, obj);
                    }
                }
            }
            b.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), bi.cjd()});
            this.tak = hashMap;
            this.tal = hashMap2;
        }
    }

    public final ArrayList<String> XW(String str) {
        int i = -1;
        long VF = bi.VF();
        int i2 = bi.getInt(str, -1);
        if (i2 == -1) {
            x.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[]{str});
            return null;
        }
        clf();
        ArrayList<String> arrayList = (ArrayList) this.tal.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bi.bH(VF));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bi.cjd();
        x.i(str2, str3, objArr);
        return arrayList;
    }

    public final ArrayList<String> q(String str, List<String> list) {
        Exception e;
        Throwable th;
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC "});
        Cursor b;
        try {
            b = this.diF.b("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
            try {
                int columnIndex = b.getColumnIndex("labelName");
                if (b.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        String string = b.getString(columnIndex);
                        if (list == null || list.size() <= 0 || !list.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (b.moveToNext());
                    if (b == null) {
                        return arrayList;
                    }
                    b.close();
                    return arrayList;
                }
                if (b != null) {
                    b.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", new Object[]{e.toString()});
                    if (b != null) {
                        b.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        b.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> H(String[] strArr) {
        Exception e;
        Throwable th;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'" + strArr[i] + "'");
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor b;
        try {
            b = this.diF.b(stringBuilder.toString(), null, 2);
            try {
                length = b.getColumnIndex("labelName");
                if (b.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(b.getString(length));
                    } while (b.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", new Object[]{Integer.valueOf(arrayList.size())});
                    if (b == null) {
                        return arrayList;
                    }
                    b.close();
                    return arrayList;
                }
                if (b != null) {
                    b.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", new Object[]{e.toString()});
                    if (b != null) {
                        b.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        b.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> ab(ArrayList<String> arrayList) {
        Exception e;
        Throwable th;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i)) + "\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor b;
        try {
            b = this.diF.b(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = b.getColumnIndex("labelID");
                if (b.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(b.getString(columnIndex));
                    } while (b.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                    if (b == null) {
                        return arrayList2;
                    }
                    b.close();
                    return arrayList2;
                }
                if (b != null) {
                    b.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", new Object[]{e.toString()});
                    if (b != null) {
                        b.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        b.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    private boolean a(boolean z, ad adVar) {
        boolean b = super.b(adVar);
        if (b && z) {
            Xp(a("insert", adVar));
        }
        return b;
    }

    public final boolean jy(String str) {
        int delete;
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[]{str});
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[]{"labelID =? "});
        try {
            delete = this.diF.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[]{e.toString()});
            delete = -1;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(boolean z, ad adVar, String... strArr) {
        boolean a = super.a(adVar, strArr);
        if (a && z) {
            Xp(a("delete", adVar));
            clg();
        }
        aYE();
        return a;
    }

    public final boolean b(boolean z, ad adVar, String... strArr) {
        boolean c = super.c(adVar, strArr);
        if (c && z) {
            Xp(a("update", adVar));
        }
        aYE();
        return c;
    }

    public final boolean db(List<ad> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
        } else {
            long dO;
            h hVar = null;
            if (this.diF instanceof h) {
                h hVar2 = (h) this.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
                hVar = hVar2;
            } else {
                dO = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((ad) list.get(i));
                if (!bi.oW(c)) {
                    jy(c);
                }
            }
            if (hVar != null) {
                hVar.gp(dO);
                x.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            aYE();
        }
        return false;
    }

    public final boolean dc(List<ad> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
        } else {
            long dO;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            h hVar = null;
            if (this.diF instanceof h) {
                h hVar2 = (h) this.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
                hVar = hVar2;
            } else {
                dO = -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ad adVar = (ad) list.get(i);
                if (adVar != null) {
                    switch (1.tam[b(adVar) - 1]) {
                        case 1:
                            break;
                        case 2:
                            b(false, adVar, "labelID");
                            arrayList2.add(adVar);
                            break;
                        case 3:
                            adVar.field_createTime = System.currentTimeMillis();
                            a(false, adVar);
                            arrayList.add(adVar);
                            break;
                        default:
                            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                            break;
                    }
                }
            }
            if (hVar != null) {
                hVar.gp(dO);
                x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
            }
            if (arrayList.size() > 0) {
                Xp(r("insert", arrayList));
            }
            if (arrayList2.size() > 0) {
                Xp(r("update", arrayList2));
            }
            aYE();
        }
        return false;
    }

    public final String Fz(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.diF.a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelName"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", new Object[]{string});
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final String FA(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.diF.a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelID"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", new Object[]{string});
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final ad XX(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.diF.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ad adVar = new ad();
                        adVar.d(a);
                        if (a == null) {
                            return adVar;
                        }
                        a.close();
                        return adVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public final ad XY(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.diF.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ad adVar = new ad();
                        adVar.d(a);
                        if (a == null) {
                            return adVar;
                        }
                        a.close();
                        return adVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", new Object[]{e.toString()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private int b(ad adVar) {
        Cursor cursor = null;
        try {
            cursor = this.diF.b("select * from ContactLabel where labelID=?", new String[]{adVar.field_labelID}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return a.tap;
            }
            int i;
            if (adVar.field_labelName.equalsIgnoreCase(bi.aG(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                i = a.tan;
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            i = a.tao;
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String c(ad adVar) {
        Exception e;
        Throwable th;
        String str = null;
        Cursor b;
        try {
            b = this.diF.b("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{adVar.field_labelName, "1"}, 2);
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        boolean equalsIgnoreCase = adVar.field_labelName.equalsIgnoreCase(bi.aG(b.getString(b.getColumnIndex("labelName")), ""));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", new Object[]{adVar.field_labelName, r1});
                        if (equalsIgnoreCase) {
                            str = b.getString(b.getColumnIndex("labelID"));
                            if (b != null) {
                                b.close();
                            }
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[]{e.toString()});
                        if (b != null) {
                            b.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (b != null) {
                            b.close();
                        }
                        throw th;
                    }
                }
            }
            if (b != null) {
                b.close();
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
        return str;
    }

    private static String a(String str, ad adVar) {
        if (adVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(adVar);
        return r(str, arrayList);
    }

    private static String r(String str, List<ad> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ad adVar = (ad) list.get(i);
            if (adVar != null) {
                stringBuilder.append(adVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    private static void clg() {
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        sh shVar = new sh();
        shVar.cdd.btC = 3000;
        com.tencent.mm.sdk.b.a.sFg.m(shVar);
    }

    public final boolean dd(List<ad> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            return false;
        }
        long dO;
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            x.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
            hVar = hVar2;
        } else {
            dO = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (ad) list.get(i), "labelID");
        }
        if (hVar != null) {
            hVar.gp(dO);
            x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        Xp(r("delete", list));
        clg();
        return true;
    }

    public final ArrayList<ad> de(List<ad> list) {
        Exception e;
        Throwable th;
        if (list.size() <= 0) {
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((ad) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", new Object[]{stringBuilder.toString()});
        Cursor b;
        try {
            b = this.diF.b(stringBuilder.toString(), null, 2);
            try {
                if (b.moveToFirst()) {
                    ArrayList<ad> arrayList = new ArrayList();
                    do {
                        ad adVar = new ad();
                        adVar.d(b);
                        arrayList.add(adVar);
                    } while (b.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", new Object[]{Integer.valueOf(arrayList.size())});
                    if (b == null) {
                        return arrayList;
                    }
                    b.close();
                    return arrayList;
                }
                if (b != null) {
                    b.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", new Object[]{e.toString()});
                    if (b != null) {
                        b.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        b.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }
}
