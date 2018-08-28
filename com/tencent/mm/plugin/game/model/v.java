package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class v {
    public static s aTX() {
        s dH;
        long longValue = ((Long) g.Ei().DT().get(a.sRz, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            dH = ((c) g.l(c.class)).aSj().dH(longValue);
        } else {
            dH = null;
        }
        if (dH != null && !dH.field_isHidden && !a(dH)) {
            return dH;
        }
        an.Dy("");
        return null;
    }

    public static void aTY() {
        long longValue = ((Long) g.Ei().DT().get(a.sRz, Long.valueOf(0))).longValue();
        s sVar = null;
        if (longValue != 0) {
            sVar = ((c) g.l(c.class)).aSj().dH(longValue);
        }
        if (sVar != null && !sVar.field_isHidden) {
            g.Ei().DT().a(a.sRz, Long.valueOf(0));
        }
    }

    public static s aTZ() {
        long longValue = ((Long) g.Ei().DT().get(a.sRD, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        s dH = ((c) g.l(c.class)).aSj().dH(longValue);
        if (dH == null || dH.field_isHidden || a(dH)) {
            return null;
        }
        return dH;
    }

    public static void aUa() {
        long longValue = ((Long) g.Ei().DT().get(a.sRD, Long.valueOf(0))).longValue();
        s sVar = null;
        if (longValue != 0) {
            sVar = ((c) g.l(c.class)).aSj().dH(longValue);
        }
        if (sVar != null && !sVar.field_isHidden) {
            g.Ei().DT().a(a.sRD, Long.valueOf(0));
        }
    }

    public static s aUb() {
        long longValue = ((Long) g.Ei().DT().get(a.sRA, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        s dH = ((c) g.l(c.class)).aSj().dH(longValue);
        if (dH == null || dH.field_isHidden || a(dH)) {
            return null;
        }
        return dH;
    }

    public static void aUc() {
        long longValue = ((Long) g.Ei().DT().get(a.sRA, Long.valueOf(0))).longValue();
        s sVar = null;
        if (longValue != 0) {
            sVar = ((c) g.l(c.class)).aSj().dH(longValue);
        }
        if (sVar != null && !sVar.field_isHidden) {
            g.Ei().DT().a(a.sRA, Long.valueOf(0));
        }
    }

    private static boolean a(s sVar) {
        return sVar.field_expireTime < System.currentTimeMillis() / 1000;
    }

    public static void b(s sVar) {
        if (!bi.oW(sVar.field_mergerId)) {
            s sVar2;
            w aSj = ((c) g.l(c.class)).aSj();
            String str = "select * from GameRawMessage where msgType=" + sVar.field_msgType + " and mergerId= \"" + sVar.field_mergerId + "\" order by createTime desc limit 1";
            s sVar3 = new s();
            Cursor rawQuery = aSj.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                sVar2 = null;
            } else {
                if (rawQuery.moveToFirst()) {
                    sVar3.d(rawQuery);
                }
                rawQuery.close();
                sVar2 = sVar3;
            }
            if (sVar2 != null) {
                sVar2.aTW();
                if (!bi.cX(sVar2.jMr)) {
                    sVar.aTW();
                    Object linkedList = new LinkedList(sVar2.jMr);
                    if (!bi.cX(sVar.jMr)) {
                        String str2 = ((h) sVar.jMr.get(0)).userName;
                        if (!bi.oW(str2)) {
                            Iterator it = sVar2.jMr.iterator();
                            while (it.hasNext()) {
                                h hVar = (h) it.next();
                                if (hVar.userName.equals(str2)) {
                                    linkedList.remove(hVar);
                                    break;
                                }
                            }
                        }
                    }
                    if (!bi.cX(linkedList)) {
                        sVar.field_rawXML = ao.a(sVar.field_rawXML, linkedList, sVar2.jMw);
                    }
                    ((c) g.l(c.class)).aSj().a(sVar2, new String[0]);
                }
            }
        }
    }
}
