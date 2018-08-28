package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.e;
import java.util.ArrayList;

class a$2 implements Runnable {
    final /* synthetic */ a ieS;

    a$2(a aVar) {
        this.ieS = aVar;
    }

    public final void run() {
        int i;
        String str;
        ArrayList arrayList;
        String string;
        int i2;
        String string2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.ieS;
        aVar.clear();
        Cursor cursor = null;
        try {
            cursor = i.aEA().igH.axc();
            if (cursor != null && cursor.moveToFirst()) {
                int count = cursor.getCount();
                for (i = 0; i < count; i++) {
                    e eVar = new e();
                    eVar.d(cursor);
                    str = eVar.field_desc;
                    if (!bi.oW(str)) {
                        aVar.ieP.put(str.toLowerCase(), eVar.field_groupID);
                        arrayList = (ArrayList) aVar.ieO.get(eVar.field_groupID);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(eVar.field_desc);
                        aVar.ieO.put(eVar.field_groupID, arrayList);
                    }
                    cursor.moveToNext();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiDescNewMgr", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            arrayList = new ArrayList();
            arrayList.add(new a$a(aVar, string, i2));
            aVar.ieQ.put(string2, arrayList);
        }
        String toLowerCase = w.chP().toLowerCase();
        String str2 = "default";
        aVar.ieK = toLowerCase;
        cursor = null;
        str = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            cursor = i.aEA().igz.rawQuery(str, new String[0]);
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis2)});
            if (cursor != null && cursor.moveToFirst()) {
                cursor.moveToFirst();
                int count2 = cursor.getCount();
                for (i = 0; i < count2; i++) {
                    str = cursor.getString(cursor.getColumnIndex("desc"));
                    string = cursor.getString(cursor.getColumnIndex("md5"));
                    string2 = cursor.getString(cursor.getColumnIndex("lang"));
                    i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                    if (!(bi.oW(str) || bi.oW(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                        string2 = str.toLowerCase();
                        if (aVar.ieQ.containsKey(string2)) {
                            arrayList = (ArrayList) aVar.ieQ.get(string2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(new a$a(aVar, string, i2));
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new a$a(aVar, string, i2));
                            aVar.ieQ.put(string2, arrayList);
                        }
                        aVar.ieN.put(string, string2);
                    }
                    cursor.moveToNext();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e2) {
            x.w("MicroMsg.emoji.EmojiDescNewMgr", bi.i(e2));
            this.ieS.mInit = true;
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        this.ieS.mInit = true;
        x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final String toString() {
        return super.toString() + "|newinit";
    }
}
