package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m dhW;
    private j iXo;
    a iXp;
    com.tencent.mm.sdk.e.e iXq;
    private a iXr = new 1(this);

    private class c {
        String bSS;
        wl bXO;
        long dTK;
        long dlj;
        wy iXy;
        int type;

        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void d(Cursor cursor) {
            this.dTK = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.dlj = cursor.getLong(2);
            this.bSS = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.bXO = new wl();
            } else {
                this.bXO = (wl) new wl().aG(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.iXy = null;
            } else {
                this.iXy = (wy) new wy().aG(blob);
            }
        }
    }

    private class e extends h {
        e(i iVar) {
            super(iVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            jVar.jrx = g.ax(this.jsj.bWm, true);
            HashMap hashMap = new HashMap();
            Cursor a = b.this.iXp.a(jVar.jrx, com.tencent.mm.plugin.fts.a.c.jqd, null, false, false);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(a);
                l lVar = (l) hashMap.get(Long.valueOf(k.jsA));
                if (lVar == null || d.c(com.tencent.mm.plugin.fts.a.c.jqw, k.jru, lVar.jru) < 0) {
                    hashMap.put(Long.valueOf(k.jsA), k);
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            jVar.jsx = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.m add : hashMap.values()) {
                jVar.jsx.add(add);
            }
            if (this.jsj.jsu != null) {
                Collections.sort(jVar.jsx, this.jsj.jsu);
            }
        }

        public final String getName() {
            return "SearchFavoriteTask";
        }
    }

    static /* synthetic */ int a(b bVar, c cVar) {
        long j = cVar.dTK;
        int i = cVar.type;
        long j2 = cVar.dlj;
        String str = cVar.bSS;
        wl wlVar = cVar.bXO;
        wc a = com.tencent.mm.plugin.fav.a.b.a(i, wlVar, cVar.iXy);
        if (a == null) {
            x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            return 0;
        }
        String str2;
        String str3;
        int a2;
        ab Co;
        int a3;
        ab Co2;
        int a4;
        List<String> list;
        StringBuilder stringBuilder;
        String str4 = a.rBs;
        String str5 = a.bSS;
        if (str4 == null || str4.length() == 0 || str4.equals(str5)) {
            str2 = null;
            str3 = a.bSS;
        } else {
            str2 = str5;
            str3 = str4;
        }
        String str6 = a.bGy;
        String[] strArr = new String[3];
        int[] iArr = new int[3];
        if (str3 != null && str3.length() > 0) {
            ab Co3 = bVar.iXo.Co(str3);
            if (Co3 != null) {
                String str7;
                String str8;
                String str9;
                String str10 = Co3.field_nickname;
                str3 = d.av(str10, false);
                String av = d.av(str10, true);
                String str11 = Co3.field_conRemark;
                str5 = d.av(str11, false);
                String av2 = d.av(str11, true);
                if (str11 == null || str11.length() == 0) {
                    str7 = null;
                    str8 = null;
                    str9 = null;
                    str5 = str3;
                    str11 = str10;
                    av2 = av;
                } else {
                    str9 = av;
                    str8 = str3;
                    str7 = str10;
                }
                strArr[0] = str11;
                strArr[1] = str5;
                strArr[2] = av2;
                iArr[0] = 9;
                iArr[1] = 10;
                iArr[2] = 11;
                a2 = bVar.a(strArr, iArr, j, i, j2, str) + 0;
                strArr[0] = str7;
                strArr[1] = str8;
                strArr[2] = str9;
                iArr[0] = 12;
                iArr[1] = 13;
                iArr[2] = 14;
                a2 += bVar.a(strArr, iArr, j, i, j2, str);
                if (str2 != null && str2.length() > 0) {
                    Co = bVar.iXo.Co(str2);
                    if (Co != null) {
                        str5 = Co.field_conRemark;
                        if (str5 == null || str5.length() == 0) {
                            str5 = Co.field_nickname;
                        }
                        str2 = d.av(str5, false);
                        str9 = d.av(str5, true);
                        strArr[0] = str5;
                        strArr[1] = str2;
                        strArr[2] = str9;
                        iArr[0] = 16;
                        iArr[1] = 17;
                        iArr[2] = 18;
                        a3 = a2 + bVar.a(strArr, iArr, j, i, j2, str);
                        if (str6 != null && str6.length() > 0) {
                            Co2 = bVar.iXo.Co(str6);
                            if (Co2 != null) {
                                str5 = Co2.field_conRemark;
                                if (str5 == null || str5.length() == 0) {
                                    str5 = Co2.field_nickname;
                                }
                                str3 = d.av(str5, false);
                                str9 = d.av(str5, true);
                                strArr[0] = str5;
                                strArr[1] = str3;
                                strArr[2] = str9;
                                iArr[0] = 20;
                                iArr[1] = 21;
                                iArr[2] = 22;
                                a4 = bVar.a(strArr, iArr, j, i, j2, str) + a3;
                                list = a.rBt;
                                stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
                                for (String str52 : list) {
                                    if (str52 != null && str52.length() > 0) {
                                        stringBuilder.append(str52).append("​");
                                    }
                                }
                                if (stringBuilder.length() > 0) {
                                    bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                                    a4++;
                                }
                                switch (i) {
                                    case 2:
                                        av2 = a.title;
                                        if (bi.oW(av2)) {
                                            return a4;
                                        }
                                        bVar.iXp.a(23, j, str, j2, av2, i);
                                        return a4 + 1;
                                    case 5:
                                        av2 = a.title;
                                        if (bi.oW(av2)) {
                                            return a4;
                                        }
                                        bVar.iXp.a(1, j, str, j2, av2, i);
                                        return a4 + 1;
                                    case 6:
                                        int i2;
                                        av2 = wlVar.fky;
                                        if (bi.oW(av2)) {
                                            i2 = a4;
                                        } else {
                                            bVar.iXp.a(4, j, str, j2, av2, i);
                                            i2 = a4 + 1;
                                        }
                                        av2 = wlVar.rAL.bWB;
                                        if (!bi.oW(av2)) {
                                            bVar.iXp.a(5, j, str, j2, av2, i);
                                            i2++;
                                        }
                                        av2 = wlVar.rAL.label;
                                        if (bi.oW(av2)) {
                                            return i2;
                                        }
                                        bVar.iXp.a(6, j, str, j2, av2, i);
                                        return i2 + 1;
                                    case 7:
                                        av2 = a.title;
                                        if (!bi.oW(av2)) {
                                            bVar.iXp.a(1, j, str, j2, av2, i);
                                            a4++;
                                        }
                                        av2 = a.desc;
                                        if (bi.oW(av2)) {
                                            return a4;
                                        }
                                        bVar.iXp.a(3, j, str, j2, av2, i);
                                        return a4 + 1;
                                    case 14:
                                        if (wlVar.rBI == null) {
                                            return a4;
                                        }
                                        StringBuffer stringBuffer = new StringBuffer();
                                        Iterator it = wlVar.rBI.iterator();
                                        while (it.hasNext()) {
                                            str52 = com.tencent.mm.plugin.fav.a.b.a((vx) it.next());
                                            if (!bi.oW(str52)) {
                                                stringBuilder.append(str52);
                                                stringBuilder.append("​");
                                            }
                                        }
                                        av2 = stringBuffer.toString();
                                        if (bi.oW(av2)) {
                                            return a4;
                                        }
                                        bVar.iXp.a(1, j, str, j2, av2, i);
                                        return a4 + 1;
                                    default:
                                        av2 = a.title;
                                        if (!bi.oW(av2)) {
                                            bVar.iXp.a(1, j, str, j2, av2, i);
                                            a4++;
                                        }
                                        av2 = a.desc;
                                        if (bi.oW(av2)) {
                                            return a4;
                                        }
                                        bVar.iXp.a(2, j, str, j2, av2, i);
                                        return a4 + 1;
                                }
                            }
                        }
                        a4 = a3;
                        list = a.rBt;
                        stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
                        for (String str522 : list) {
                            if (str522 != null && str522.length() > 0) {
                                stringBuilder.append(str522).append("​");
                            }
                        }
                        if (stringBuilder.length() > 0) {
                            bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                            a4++;
                        }
                        switch (i) {
                            case 2:
                                av2 = a.title;
                                if (bi.oW(av2)) {
                                    return a4;
                                }
                                bVar.iXp.a(23, j, str, j2, av2, i);
                                return a4 + 1;
                            case 5:
                                av2 = a.title;
                                if (bi.oW(av2)) {
                                    return a4;
                                }
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                return a4 + 1;
                            case 6:
                                int i22;
                                av2 = wlVar.fky;
                                if (bi.oW(av2)) {
                                    i22 = a4;
                                } else {
                                    bVar.iXp.a(4, j, str, j2, av2, i);
                                    i22 = a4 + 1;
                                }
                                av2 = wlVar.rAL.bWB;
                                if (!bi.oW(av2)) {
                                    bVar.iXp.a(5, j, str, j2, av2, i);
                                    i22++;
                                }
                                av2 = wlVar.rAL.label;
                                if (bi.oW(av2)) {
                                    return i22;
                                }
                                bVar.iXp.a(6, j, str, j2, av2, i);
                                return i22 + 1;
                            case 7:
                                av2 = a.title;
                                if (!bi.oW(av2)) {
                                    bVar.iXp.a(1, j, str, j2, av2, i);
                                    a4++;
                                }
                                av2 = a.desc;
                                if (bi.oW(av2)) {
                                    return a4;
                                }
                                bVar.iXp.a(3, j, str, j2, av2, i);
                                return a4 + 1;
                            case 14:
                                if (wlVar.rBI == null) {
                                    return a4;
                                }
                                StringBuffer stringBuffer2 = new StringBuffer();
                                Iterator it2 = wlVar.rBI.iterator();
                                while (it2.hasNext()) {
                                    str522 = com.tencent.mm.plugin.fav.a.b.a((vx) it2.next());
                                    if (!bi.oW(str522)) {
                                        stringBuilder.append(str522);
                                        stringBuilder.append("​");
                                    }
                                }
                                av2 = stringBuffer2.toString();
                                if (bi.oW(av2)) {
                                    return a4;
                                }
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                return a4 + 1;
                            default:
                                av2 = a.title;
                                if (!bi.oW(av2)) {
                                    bVar.iXp.a(1, j, str, j2, av2, i);
                                    a4++;
                                }
                                av2 = a.desc;
                                if (bi.oW(av2)) {
                                    return a4;
                                }
                                bVar.iXp.a(2, j, str, j2, av2, i);
                                return a4 + 1;
                        }
                    }
                }
                a3 = a2;
                Co2 = bVar.iXo.Co(str6);
                if (Co2 != null) {
                    str522 = Co2.field_conRemark;
                    if (str522 == null || str522.length() == 0) {
                        str522 = Co2.field_nickname;
                    }
                    str3 = d.av(str522, false);
                    str9 = d.av(str522, true);
                    strArr[0] = str522;
                    strArr[1] = str3;
                    strArr[2] = str9;
                    iArr[0] = 20;
                    iArr[1] = 21;
                    iArr[2] = 22;
                    a4 = bVar.a(strArr, iArr, j, i, j2, str) + a3;
                    list = a.rBt;
                    stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
                    for (String str5222 : list) {
                        if (str5222 != null && str5222.length() > 0) {
                            stringBuilder.append(str5222).append("​");
                        }
                    }
                    if (stringBuilder.length() > 0) {
                        bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                        a4++;
                    }
                    switch (i) {
                        case 2:
                            av2 = a.title;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(23, j, str, j2, av2, i);
                            return a4 + 1;
                        case 5:
                            av2 = a.title;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            return a4 + 1;
                        case 6:
                            int i222;
                            av2 = wlVar.fky;
                            if (bi.oW(av2)) {
                                i222 = a4;
                            } else {
                                bVar.iXp.a(4, j, str, j2, av2, i);
                                i222 = a4 + 1;
                            }
                            av2 = wlVar.rAL.bWB;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(5, j, str, j2, av2, i);
                                i222++;
                            }
                            av2 = wlVar.rAL.label;
                            if (bi.oW(av2)) {
                                return i222;
                            }
                            bVar.iXp.a(6, j, str, j2, av2, i);
                            return i222 + 1;
                        case 7:
                            av2 = a.title;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                a4++;
                            }
                            av2 = a.desc;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(3, j, str, j2, av2, i);
                            return a4 + 1;
                        case 14:
                            if (wlVar.rBI == null) {
                                return a4;
                            }
                            StringBuffer stringBuffer22 = new StringBuffer();
                            Iterator it22 = wlVar.rBI.iterator();
                            while (it22.hasNext()) {
                                str5222 = com.tencent.mm.plugin.fav.a.b.a((vx) it22.next());
                                if (!bi.oW(str5222)) {
                                    stringBuilder.append(str5222);
                                    stringBuilder.append("​");
                                }
                            }
                            av2 = stringBuffer22.toString();
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            return a4 + 1;
                        default:
                            av2 = a.title;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                a4++;
                            }
                            av2 = a.desc;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(2, j, str, j2, av2, i);
                            return a4 + 1;
                    }
                }
                a4 = a3;
                list = a.rBt;
                stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
                for (String str52222 : list) {
                    if (str52222 != null && str52222.length() > 0) {
                        stringBuilder.append(str52222).append("​");
                    }
                }
                if (stringBuilder.length() > 0) {
                    bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                    a4++;
                }
                switch (i) {
                    case 2:
                        av2 = a.title;
                        if (bi.oW(av2)) {
                            return a4;
                        }
                        bVar.iXp.a(23, j, str, j2, av2, i);
                        return a4 + 1;
                    case 5:
                        av2 = a.title;
                        if (bi.oW(av2)) {
                            return a4;
                        }
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        return a4 + 1;
                    case 6:
                        int i2222;
                        av2 = wlVar.fky;
                        if (bi.oW(av2)) {
                            i2222 = a4;
                        } else {
                            bVar.iXp.a(4, j, str, j2, av2, i);
                            i2222 = a4 + 1;
                        }
                        av2 = wlVar.rAL.bWB;
                        if (!bi.oW(av2)) {
                            bVar.iXp.a(5, j, str, j2, av2, i);
                            i2222++;
                        }
                        av2 = wlVar.rAL.label;
                        if (bi.oW(av2)) {
                            return i2222;
                        }
                        bVar.iXp.a(6, j, str, j2, av2, i);
                        return i2222 + 1;
                    case 7:
                        av2 = a.title;
                        if (!bi.oW(av2)) {
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            a4++;
                        }
                        av2 = a.desc;
                        if (bi.oW(av2)) {
                            return a4;
                        }
                        bVar.iXp.a(3, j, str, j2, av2, i);
                        return a4 + 1;
                    case 14:
                        if (wlVar.rBI == null) {
                            return a4;
                        }
                        StringBuffer stringBuffer222 = new StringBuffer();
                        Iterator it222 = wlVar.rBI.iterator();
                        while (it222.hasNext()) {
                            str52222 = com.tencent.mm.plugin.fav.a.b.a((vx) it222.next());
                            if (!bi.oW(str52222)) {
                                stringBuilder.append(str52222);
                                stringBuilder.append("​");
                            }
                        }
                        av2 = stringBuffer222.toString();
                        if (bi.oW(av2)) {
                            return a4;
                        }
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        return a4 + 1;
                    default:
                        av2 = a.title;
                        if (!bi.oW(av2)) {
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            a4++;
                        }
                        av2 = a.desc;
                        if (bi.oW(av2)) {
                            return a4;
                        }
                        bVar.iXp.a(2, j, str, j2, av2, i);
                        return a4 + 1;
                }
            }
        }
        a2 = 0;
        Co = bVar.iXo.Co(str2);
        if (Co != null) {
            str52222 = Co.field_conRemark;
            if (str52222 == null || str52222.length() == 0) {
                str52222 = Co.field_nickname;
            }
            str2 = d.av(str52222, false);
            str9 = d.av(str52222, true);
            strArr[0] = str52222;
            strArr[1] = str2;
            strArr[2] = str9;
            iArr[0] = 16;
            iArr[1] = 17;
            iArr[2] = 18;
            a3 = a2 + bVar.a(strArr, iArr, j, i, j2, str);
            if (str6 != null && str6.length() > 0) {
                Co2 = bVar.iXo.Co(str6);
                if (Co2 != null) {
                    str52222 = Co2.field_conRemark;
                    if (str52222 == null || str52222.length() == 0) {
                        str52222 = Co2.field_nickname;
                    }
                    str3 = d.av(str52222, false);
                    str9 = d.av(str52222, true);
                    strArr[0] = str52222;
                    strArr[1] = str3;
                    strArr[2] = str9;
                    iArr[0] = 20;
                    iArr[1] = 21;
                    iArr[2] = 22;
                    a4 = bVar.a(strArr, iArr, j, i, j2, str) + a3;
                    list = a.rBt;
                    stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
                    for (String str522222 : list) {
                        if (str522222 != null && str522222.length() > 0) {
                            stringBuilder.append(str522222).append("​");
                        }
                    }
                    if (stringBuilder.length() > 0) {
                        bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                        a4++;
                    }
                    switch (i) {
                        case 2:
                            av2 = a.title;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(23, j, str, j2, av2, i);
                            return a4 + 1;
                        case 5:
                            av2 = a.title;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            return a4 + 1;
                        case 6:
                            int i22222;
                            av2 = wlVar.fky;
                            if (bi.oW(av2)) {
                                i22222 = a4;
                            } else {
                                bVar.iXp.a(4, j, str, j2, av2, i);
                                i22222 = a4 + 1;
                            }
                            av2 = wlVar.rAL.bWB;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(5, j, str, j2, av2, i);
                                i22222++;
                            }
                            av2 = wlVar.rAL.label;
                            if (bi.oW(av2)) {
                                return i22222;
                            }
                            bVar.iXp.a(6, j, str, j2, av2, i);
                            return i22222 + 1;
                        case 7:
                            av2 = a.title;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                a4++;
                            }
                            av2 = a.desc;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(3, j, str, j2, av2, i);
                            return a4 + 1;
                        case 14:
                            if (wlVar.rBI == null) {
                                return a4;
                            }
                            StringBuffer stringBuffer2222 = new StringBuffer();
                            Iterator it2222 = wlVar.rBI.iterator();
                            while (it2222.hasNext()) {
                                str522222 = com.tencent.mm.plugin.fav.a.b.a((vx) it2222.next());
                                if (!bi.oW(str522222)) {
                                    stringBuilder.append(str522222);
                                    stringBuilder.append("​");
                                }
                            }
                            av2 = stringBuffer2222.toString();
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(1, j, str, j2, av2, i);
                            return a4 + 1;
                        default:
                            av2 = a.title;
                            if (!bi.oW(av2)) {
                                bVar.iXp.a(1, j, str, j2, av2, i);
                                a4++;
                            }
                            av2 = a.desc;
                            if (bi.oW(av2)) {
                                return a4;
                            }
                            bVar.iXp.a(2, j, str, j2, av2, i);
                            return a4 + 1;
                    }
                }
            }
            a4 = a3;
            list = a.rBt;
            stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
            for (String str5222222 : list) {
                if (str5222222 != null && str5222222.length() > 0) {
                    stringBuilder.append(str5222222).append("​");
                }
            }
            if (stringBuilder.length() > 0) {
                bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                a4++;
            }
            switch (i) {
                case 2:
                    av2 = a.title;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(23, j, str, j2, av2, i);
                    return a4 + 1;
                case 5:
                    av2 = a.title;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    return a4 + 1;
                case 6:
                    int i222222;
                    av2 = wlVar.fky;
                    if (bi.oW(av2)) {
                        i222222 = a4;
                    } else {
                        bVar.iXp.a(4, j, str, j2, av2, i);
                        i222222 = a4 + 1;
                    }
                    av2 = wlVar.rAL.bWB;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(5, j, str, j2, av2, i);
                        i222222++;
                    }
                    av2 = wlVar.rAL.label;
                    if (bi.oW(av2)) {
                        return i222222;
                    }
                    bVar.iXp.a(6, j, str, j2, av2, i);
                    return i222222 + 1;
                case 7:
                    av2 = a.title;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        a4++;
                    }
                    av2 = a.desc;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(3, j, str, j2, av2, i);
                    return a4 + 1;
                case 14:
                    if (wlVar.rBI == null) {
                        return a4;
                    }
                    StringBuffer stringBuffer22222 = new StringBuffer();
                    Iterator it22222 = wlVar.rBI.iterator();
                    while (it22222.hasNext()) {
                        str5222222 = com.tencent.mm.plugin.fav.a.b.a((vx) it22222.next());
                        if (!bi.oW(str5222222)) {
                            stringBuilder.append(str5222222);
                            stringBuilder.append("​");
                        }
                    }
                    av2 = stringBuffer22222.toString();
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    return a4 + 1;
                default:
                    av2 = a.title;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        a4++;
                    }
                    av2 = a.desc;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(2, j, str, j2, av2, i);
                    return a4 + 1;
            }
        }
        a3 = a2;
        Co2 = bVar.iXo.Co(str6);
        if (Co2 != null) {
            str5222222 = Co2.field_conRemark;
            if (str5222222 == null || str5222222.length() == 0) {
                str5222222 = Co2.field_nickname;
            }
            str3 = d.av(str5222222, false);
            str9 = d.av(str5222222, true);
            strArr[0] = str5222222;
            strArr[1] = str3;
            strArr[2] = str9;
            iArr[0] = 20;
            iArr[1] = 21;
            iArr[2] = 22;
            a4 = bVar.a(strArr, iArr, j, i, j2, str) + a3;
            list = a.rBt;
            stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
            for (String str52222222 : list) {
                if (str52222222 != null && str52222222.length() > 0) {
                    stringBuilder.append(str52222222).append("​");
                }
            }
            if (stringBuilder.length() > 0) {
                bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
                a4++;
            }
            switch (i) {
                case 2:
                    av2 = a.title;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(23, j, str, j2, av2, i);
                    return a4 + 1;
                case 5:
                    av2 = a.title;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    return a4 + 1;
                case 6:
                    int i2222222;
                    av2 = wlVar.fky;
                    if (bi.oW(av2)) {
                        i2222222 = a4;
                    } else {
                        bVar.iXp.a(4, j, str, j2, av2, i);
                        i2222222 = a4 + 1;
                    }
                    av2 = wlVar.rAL.bWB;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(5, j, str, j2, av2, i);
                        i2222222++;
                    }
                    av2 = wlVar.rAL.label;
                    if (bi.oW(av2)) {
                        return i2222222;
                    }
                    bVar.iXp.a(6, j, str, j2, av2, i);
                    return i2222222 + 1;
                case 7:
                    av2 = a.title;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        a4++;
                    }
                    av2 = a.desc;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(3, j, str, j2, av2, i);
                    return a4 + 1;
                case 14:
                    if (wlVar.rBI == null) {
                        return a4;
                    }
                    StringBuffer stringBuffer222222 = new StringBuffer();
                    Iterator it222222 = wlVar.rBI.iterator();
                    while (it222222.hasNext()) {
                        str52222222 = com.tencent.mm.plugin.fav.a.b.a((vx) it222222.next());
                        if (!bi.oW(str52222222)) {
                            stringBuilder.append(str52222222);
                            stringBuilder.append("​");
                        }
                    }
                    av2 = stringBuffer222222.toString();
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    return a4 + 1;
                default:
                    av2 = a.title;
                    if (!bi.oW(av2)) {
                        bVar.iXp.a(1, j, str, j2, av2, i);
                        a4++;
                    }
                    av2 = a.desc;
                    if (bi.oW(av2)) {
                        return a4;
                    }
                    bVar.iXp.a(2, j, str, j2, av2, i);
                    return a4 + 1;
            }
        }
        a4 = a3;
        list = a.rBt;
        stringBuilder = new StringBuilder(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
        for (String str522222222 : list) {
            if (str522222222 != null && str522222222.length() > 0) {
                stringBuilder.append(str522222222).append("​");
            }
        }
        if (stringBuilder.length() > 0) {
            bVar.iXp.a(7, j, str, j2, stringBuilder.toString(), i);
            a4++;
        }
        switch (i) {
            case 2:
                av2 = a.title;
                if (bi.oW(av2)) {
                    return a4;
                }
                bVar.iXp.a(23, j, str, j2, av2, i);
                return a4 + 1;
            case 5:
                av2 = a.title;
                if (bi.oW(av2)) {
                    return a4;
                }
                bVar.iXp.a(1, j, str, j2, av2, i);
                return a4 + 1;
            case 6:
                int i22222222;
                av2 = wlVar.fky;
                if (bi.oW(av2)) {
                    i22222222 = a4;
                } else {
                    bVar.iXp.a(4, j, str, j2, av2, i);
                    i22222222 = a4 + 1;
                }
                av2 = wlVar.rAL.bWB;
                if (!bi.oW(av2)) {
                    bVar.iXp.a(5, j, str, j2, av2, i);
                    i22222222++;
                }
                av2 = wlVar.rAL.label;
                if (bi.oW(av2)) {
                    return i22222222;
                }
                bVar.iXp.a(6, j, str, j2, av2, i);
                return i22222222 + 1;
            case 7:
                av2 = a.title;
                if (!bi.oW(av2)) {
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    a4++;
                }
                av2 = a.desc;
                if (bi.oW(av2)) {
                    return a4;
                }
                bVar.iXp.a(3, j, str, j2, av2, i);
                return a4 + 1;
            case 14:
                if (wlVar.rBI == null) {
                    return a4;
                }
                StringBuffer stringBuffer2222222 = new StringBuffer();
                Iterator it2222222 = wlVar.rBI.iterator();
                while (it2222222.hasNext()) {
                    str522222222 = com.tencent.mm.plugin.fav.a.b.a((vx) it2222222.next());
                    if (!bi.oW(str522222222)) {
                        stringBuilder.append(str522222222);
                        stringBuilder.append("​");
                    }
                }
                av2 = stringBuffer2222222.toString();
                if (bi.oW(av2)) {
                    return a4;
                }
                bVar.iXp.a(1, j, str, j2, av2, i);
                return a4 + 1;
            default:
                av2 = a.title;
                if (!bi.oW(av2)) {
                    bVar.iXp.a(1, j, str, j2, av2, i);
                    a4++;
                }
                av2 = a.desc;
                if (bi.oW(av2)) {
                    return a4;
                }
                bVar.iXp.a(2, j, str, j2, av2, i);
                return a4 + 1;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        com.tencent.mm.plugin.fts.a.a.a fVar;
        if (iVar.jsn == 1) {
            fVar = new f(this, iVar);
        } else {
            fVar = new e(iVar);
        }
        return this.dhW.a(-65536, fVar);
    }

    protected final boolean onCreate() {
        if (((n) com.tencent.mm.kernel.g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
            this.dhW = ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSTaskDaemon();
            this.iXp = (a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE);
            this.iXo = ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSMainDB();
            this.iXq = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLz();
            this.dhW.a(131122, new a(this, (byte) 0));
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.iXr);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.iXr);
        this.iXp = null;
        this.dhW = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    private int a(String[] strArr, int[] iArr, long j, int i, long j2, String str) {
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        if (str2 == null || str2.length() <= 0) {
            return 0;
        }
        String str5;
        String str6;
        String str7;
        if (str2.equalsIgnoreCase(str3)) {
            str5 = null;
            str6 = null;
        } else {
            str5 = str3;
            str6 = str4;
        }
        if (str5 == null || !str5.equalsIgnoreCase(str6)) {
            str7 = str6;
        } else {
            str7 = null;
        }
        this.iXp.a(iArr[0], j, str, j2, str2, i);
        int i2 = 1;
        if (str5 != null && str5.length() > 0) {
            this.iXp.a(iArr[1], j, str, j2, str5, i);
            i2 = 2;
        }
        if (str7 == null || str7.length() <= 0) {
            return i2;
        }
        this.iXp.a(iArr[2], j, str, j2, str7, i);
        return i2 + 1;
    }
}
