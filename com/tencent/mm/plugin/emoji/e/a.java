package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.emotion.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class a {
    String ieK;
    int ieL = 2;
    int ieM = 32;
    HashMap<String, String> ieN = new HashMap();
    HashMap<String, ArrayList<String>> ieO = new HashMap();
    HashMap<String, String> ieP = new HashMap();
    HashMap<String, ArrayList<a>> ieQ = new HashMap();
    Comparator ieR = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.index == aVar2.index) {
                    return 0;
                }
                if (aVar.index > aVar2.index) {
                    return 1;
                }
            }
            return -1;
        }
    };
    boolean mInit = false;

    public final void clear() {
        if (this.ieN != null) {
            this.ieN.clear();
        }
        if (this.ieO != null) {
            this.ieO.clear();
        }
        if (this.ieP != null) {
            this.ieP.clear();
        }
        if (this.ieQ != null) {
            this.ieQ.clear();
        }
    }

    public final void aDI() {
        au.Em().H(new 2(this));
    }

    public final String zf(String str) {
        if (this.ieN != null && this.ieN.containsKey(str)) {
            return (String) this.ieN.get(str);
        }
        c cVar = i.aEA().igz;
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor b = cVar.diF.b(format, new String[]{str + w.chP().toLowerCase()}, 2);
        if (b.moveToFirst()) {
            str2 = b.getString(b.getColumnIndex("desc"));
        }
        b.close();
        if (!bi.oW(str2)) {
            return str2;
        }
        Cursor b2 = cVar.diF.b(format, new String[]{str + "default"}, 2);
        if (b2.moveToFirst()) {
            str2 = b2.getString(b2.getColumnIndex("desc"));
        }
        b2.close();
        return str2;
    }
}
