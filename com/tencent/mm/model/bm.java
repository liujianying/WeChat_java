package com.tencent.mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bm {
    private ay dDg;
    private e diF;

    public bm(e eVar, ay ayVar) {
        this.diF = eVar;
        this.dDg = ayVar;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z) {
        return a(str, str2, list, z, 1, null);
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2) {
        return a(str, str2, list, true, 2, list2);
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2) {
        return a(str, str2, list, true, 2, list2);
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, int i, List<String> list2) {
        String str3 = "select * ,rowid from rcontact ";
        if (i == 2) {
            str3 = "select 2, *,rowid from rcontact ";
        }
        str3 = str3 + this.dDg.e(str2, null, list) + this.dDg.Yn(str) + this.dDg.MD();
        x.v("Micro.SimpleSearchConversationModel", str3);
        Cursor rawQuery = this.diF.rawQuery(str3, null);
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                str3 = rawQuery.getString(rawQuery.getColumnIndex("username"));
                if (str3.endsWith("@chatroom")) {
                    arrayList2.add(str3);
                } else {
                    arrayList.add(str3);
                }
            }
            if (!(list2 == null || list2.size() == 0)) {
                arrayList.addAll(list2);
            }
            if (arrayList.size() != 0) {
                Cursor a = a(str, arrayList, arrayList2, null, list);
                return new MergeCursor(new Cursor[]{rawQuery, a});
            }
        }
        return rawQuery;
    }

    public final Cursor a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + this.dDg.e("@all.contact.android", "", list) + a(str, (ArrayList) arrayList, (ArrayList) arrayList2, (ArrayList) arrayList3) + this.dDg.MD();
        x.v("Micro.SimpleSearchConversationModel", "roomsSql " + str2);
        return this.diF.rawQuery(str2, null);
    }

    private static String a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Iterator it;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" and (username in (");
        stringBuffer.append("select chatroomname from chatroom where ");
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                stringBuffer.append("chatroomname != '" + ((String) it.next()) + "' and ");
            }
        }
        stringBuffer.append("(memberlist like '%" + str + "%'");
        it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(" or memberlist like '%" + ((String) it.next()) + "%'");
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" or chatroomname = '" + ((String) it.next()) + "'");
            }
        }
        stringBuffer.append(")))");
        return stringBuffer.toString();
    }
}
