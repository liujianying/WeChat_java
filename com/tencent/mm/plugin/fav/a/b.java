package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ac$b;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b {
    private static HashMap<Long, ArrayList<String>> iVq = new HashMap();
    private static long iVr = 0;

    public static String a(vx vxVar) {
        vy vyVar = vxVar.rAi;
        String str = "";
        switch (vxVar.bjS) {
            case 1:
                return cI(str, vxVar.desc);
            case 4:
                if (vyVar.rAR != null) {
                    return cI(str, vyVar.rAR.title);
                }
                return str;
            case 5:
                if (vyVar.rAN != null) {
                    return cI(str, vyVar.rAN.title);
                }
                return str;
            case 6:
                str = cI(str, vyVar.fky);
                if (vyVar.rAL != null) {
                    return cI(cI(str, vyVar.rAL.bWB), vyVar.rAL.label);
                }
                return str;
            case 8:
                return cI(str, vyVar.title);
            case 10:
            case 11:
                if (vyVar.rAP != null) {
                    return cI(cI(str, vyVar.rAP.title), vyVar.rAP.desc);
                }
                return str;
            default:
                return cI(cI(str, vyVar.title), vyVar.desc);
        }
    }

    private static String cI(String str, String str2) {
        if (bi.oW(str)) {
            return str2;
        }
        if (bi.oW(str2)) {
            return str;
        }
        return str + "​" + str2;
    }

    public static String bm(String str, int i) {
        return g.u((str + i + System.currentTimeMillis()).getBytes());
    }

    public static long a(g gVar) {
        long j = 0;
        for (int i : a.iVo) {
            if (i == gVar.field_type) {
                long j2;
                if (gVar.field_favProto != null) {
                    Iterator it = gVar.field_favProto.rBI.iterator();
                    while (true) {
                        j2 = j;
                        if (!it.hasNext()) {
                            break;
                        }
                        j = ((vx) it.next()).rzJ + j2;
                    }
                } else {
                    j2 = 0;
                }
                gVar.field_datatotalsize = j2;
                x.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(j2)});
                return j2;
            }
        }
        return 0;
    }

    public static wc a(int i, wl wlVar, wy wyVar) {
        if (wlVar == null) {
            x.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
            return null;
        }
        wc wcVar = new wc();
        wr wrVar = wlVar.rBG;
        if (wrVar != null) {
            wcVar.bSS = wrVar.bSS;
            wcVar.rBs = wrVar.rBh;
            wcVar.appId = wrVar.appId;
            wcVar.bGy = wrVar.bGy;
        }
        if (wyVar != null) {
            if (wyVar.rBW != null) {
                wcVar.rBt.addAll(wyVar.rBW);
            }
            if (wyVar.rBX != null) {
                wcVar.rBt.addAll(wyVar.rBX);
            }
        }
        wcVar.bXO = wlVar;
        wcVar.type = i;
        switch (i) {
            case 1:
                wcVar.title = "";
                wcVar.desc = wlVar.desc;
                return wcVar;
            case 2:
                if (wlVar.rBI != null && wlVar.rBI.size() > 0) {
                    wcVar.title = ((vx) wlVar.rBI.get(0)).title;
                }
                return wcVar;
            case 4:
                if (!(wlVar.rBI == null || wlVar.rBI.isEmpty())) {
                    wcVar.title = ((vx) wlVar.rBI.get(0)).title;
                }
                return wcVar;
            case 5:
                if (wlVar.rAN != null) {
                    wcVar.title = wlVar.rAN.title;
                    wcVar.desc = wlVar.rAN.rCn;
                }
                if (!(!bi.oW(wcVar.title) || wlVar.rBI == null || wlVar.rBI.isEmpty())) {
                    wcVar.title = ((vx) wlVar.rBI.get(0)).title;
                }
                if (bi.oW(wcVar.desc) && wrVar != null) {
                    wcVar.desc = wrVar.egr;
                }
                return wcVar;
            case 6:
                wcVar.title = wlVar.fky;
                if (bi.oW(wcVar.title)) {
                    if (wlVar.rAL != null) {
                        wcVar.title = wlVar.rAL.bWB;
                        wcVar.desc = wlVar.rAL.label;
                    }
                } else if (wlVar.rAL != null) {
                    wcVar.desc = wlVar.rAL.bWB;
                }
                return wcVar;
            case 7:
                if (!(wlVar.rBI == null || wlVar.rBI.isEmpty())) {
                    wcVar.title = ((vx) wlVar.rBI.get(0)).title;
                    wcVar.desc = ((vx) wlVar.rBI.get(0)).desc;
                }
                return wcVar;
            case 8:
                wcVar.title = wlVar.title;
                if (!(!bi.oW(wcVar.title) || wlVar.rBI == null || wlVar.rBI.isEmpty())) {
                    wcVar.title = ((vx) wlVar.rBI.get(0)).title;
                }
                return wcVar;
            case 10:
            case 11:
                if (wlVar.rAP != null) {
                    wcVar.title = wlVar.rAP.title;
                    wcVar.desc = wlVar.rAP.desc;
                }
                return wcVar;
            case 12:
            case 15:
                if (wlVar.rAR != null) {
                    wcVar.title = wlVar.rAR.title;
                    wcVar.desc = wlVar.rAR.desc;
                }
                return wcVar;
            case 14:
            case 18:
                List<vx> list = wlVar.rBI;
                if (list == null) {
                    return null;
                }
                for (vx vxVar : list) {
                    if (1 == vxVar.bjS) {
                        wcVar.title = vxVar.desc;
                        return wcVar;
                    }
                }
                return wcVar;
            default:
                x.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[]{Integer.valueOf(i)});
                return wcVar;
        }
    }

    public static long b(g gVar) {
        if (gVar == null) {
            return 0;
        }
        int i = 0;
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (long) i2;
            }
            i = (int) (((vx) it.next()).rzJ + ((long) i2));
        }
    }

    public static vx c(g gVar) {
        if (gVar == null) {
            return new vx();
        }
        if (gVar.field_favProto.rBI.size() == 0) {
            return new vx();
        }
        return (vx) gVar.field_favProto.rBI.get(0);
    }

    public static void dh(long j) {
        x.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", new Object[]{Long.valueOf(j)});
        com.tencent.mm.kernel.g.Ei().DT().a(a.sRq, Long.valueOf(j));
    }

    public static void di(long j) {
        x.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", new Object[]{Long.valueOf(j)});
        com.tencent.mm.kernel.g.Ei().DT().a(a.sRr, Long.valueOf(j));
    }

    private static String dj(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
        if (dy == null || dy.field_favProto == null || dy.field_favProto.rBI.size() <= 1) {
            return "";
        }
        wf wfVar = dy.field_favProto.qYa;
        String str = "";
        String str2 = "";
        if (wfVar != null) {
            str = wfVar.rBA;
            str2 = wfVar.rBz;
        }
        stringBuilder.append("<noteinfo>");
        stringBuilder.append("<noteauthor>").append(str2).append("</noteauthor>");
        stringBuilder.append("<noteeditor>").append(str).append("</noteeditor>");
        stringBuilder.append("<edittime>").append(dy.field_favProto.qYb).append("</edittime>");
        stringBuilder.append("<favlocalid>").append(dy.field_localId).append("</favlocalid>");
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bc(dy.field_favProto.rBI).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        stringBuilder.append("</noteinfo>");
        return stringBuilder.toString();
    }

    private static void a(fz fzVar) {
        if (bi.oW(fzVar.bOL.desc)) {
            fzVar.bOM.ret = -1;
            return;
        }
        g Bg = Bg(fzVar.bOL.desc);
        if (Bg == null || Bg.field_localId <= 0) {
            fzVar.bOM.ret = -1;
            return;
        }
        boolean e = e(Bg);
        String str = fzVar.bOL.bOR;
        ArrayList arrayList;
        if (e) {
            fzVar.bOM.ret = 1;
            arrayList = (ArrayList) iVq.get(Long.valueOf(Bg.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    iVq.remove(Long.valueOf(Bg.field_localId));
                }
            }
        } else if (bi.oW(str)) {
            fzVar.bOM.ret = -1;
        } else {
            long j = Bg.field_localId;
            if (iVq.get(Long.valueOf(j)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) iVq.get(Long.valueOf(j));
            }
            arrayList.add(str);
            iVq.put(Long.valueOf(j), arrayList);
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
            if (dy == null || dy.field_localId <= 0) {
                fzVar.bOM.ret = -1;
            } else if (e(dy) || dy.field_itemStatus == 10) {
                fzVar.bOM.ret = -1;
                com.tencent.mm.kernel.g.Em().h(new 1(dy), 500);
            } else {
                fzVar.bOM.ret = -1;
            }
        }
    }

    public static synchronized void d(g gVar) {
        synchronized (b.class) {
            if (gVar != null) {
                if (gVar.field_type == 18) {
                    if (!(!iVq.containsKey(Long.valueOf(gVar.field_localId)) || iVq.get(Long.valueOf(gVar.field_localId)) == null || ((ArrayList) iVq.get(Long.valueOf(gVar.field_localId))).size() == 0)) {
                        x.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[]{Long.valueOf(gVar.field_localId), dj(gVar.field_localId)});
                        nu nuVar = new nu();
                        nuVar.bYN.bYO = (ArrayList) iVq.get(Long.valueOf(gVar.field_localId));
                        nuVar.bYN.bYP = r2;
                        com.tencent.mm.sdk.b.a.sFg.m(nuVar);
                        iVq.remove(Long.valueOf(gVar.field_localId));
                    }
                }
            }
        }
    }

    private static boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        boolean z;
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if ((vxVar.bjS == 8 || vxVar.bjS == 4 || vxVar.bjS == 2 || vxVar.bjS == 3) && (bi.oW(vxVar.rzo) || bi.oW(vxVar.rzq))) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public static void ba(List<Integer> list) {
        if (list.size() == 0) {
            x.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
            return;
        }
        Set aKN = aKN();
        x.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", new Object[]{aKN.toString()});
        for (Integer num : list) {
            boolean remove = aKN.remove(num.toString());
            x.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", new Object[]{num, Boolean.valueOf(remove)});
        }
        x.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", new Object[]{aKN.toString()});
        e(aKN);
    }

    private static void e(Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        x.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", new Object[]{obj});
        com.tencent.mm.kernel.g.Ei().DT().set(225282, obj);
    }

    private static Set<String> aKN() {
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(225282, "");
        x.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", new Object[]{str});
        Set<String> hashSet = new HashSet();
        if (bi.oW(str)) {
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static void dk(long j) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
    }

    public static void dl(long j) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
    }

    public static void dm(long j) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putLong("fav_mx_file_size", j).commit();
    }

    public static String aKO() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Ek();
        return stringBuilder.append(com.tencent.mm.kernel.g.Ei().dqp).append("favorite/web/").toString();
    }

    public static String b(vx vxVar) {
        if (vxVar == null) {
            return "";
        }
        String str = vxVar.jdM;
        if (bi.oW(str) || !com.tencent.mm.kernel.g.Eg().Dx()) {
            return "";
        }
        com.tencent.mm.vfs.b AZ = AZ(str);
        Object obj = null;
        if (vxVar.bjS == 8 && !bi.oW(vxVar.title)) {
            str = vxVar.title;
            AZ = AZ(vxVar.jdM);
            obj = 1;
        }
        if (vxVar.rzD != null && vxVar.rzD.trim().length() > 0 && obj == null) {
            str = str + "." + vxVar.rzD;
        }
        return new com.tencent.mm.vfs.b(AZ, str).cBX().toString();
    }

    private static com.tencent.mm.vfs.b AZ(String str) {
        int hashCode = str.hashCode() & 255;
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(String.format("%s/%s/%d/", new Object[]{com.tencent.mm.kernel.g.Ei().dqp, "favorite", Integer.valueOf(hashCode)}));
        if (!(bVar.exists() && bVar.isDirectory())) {
            bVar.mkdirs();
        }
        return bVar;
    }

    public static boolean f(g gVar) {
        if (gVar.field_favProto == null) {
            return false;
        }
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.rAw == 2) {
                return true;
            }
            if (vxVar.rAw == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10 || gVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static void aKP() {
        Set<String> aKN = aKN();
        if (aKN.size() == 0) {
            x.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
            return;
        }
        x.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", new Object[]{aKN.toString()});
        LinkedList linkedList = new LinkedList();
        for (String str : aKN) {
            try {
                linkedList.add(Integer.valueOf(bi.getInt(str, 0)));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
                x.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", new Object[]{e.getMessage()});
            }
        }
        x.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", new Object[]{Integer.valueOf(linkedList.size())});
        if (linkedList.size() > 0) {
            com.tencent.mm.kernel.g.DF().a(new ag(linkedList), 0);
        }
    }

    private static void h(g gVar) {
        Set set = an.iXj;
        List list = gVar.field_favProto.rBI;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String c = c((vx) list.get(i2));
                if (set == null || !set.contains(c)) {
                    d.deleteFile(c);
                }
                c = b((vx) list.get(i2));
                if (set == null || !set.contains(c)) {
                    d.deleteFile(c);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static String c(vx vxVar) {
        if (vxVar == null || bi.oW(vxVar.jdM)) {
            return "";
        }
        String Ba = Ba(vxVar.jdM);
        return new com.tencent.mm.vfs.b(AZ(Ba), Ba).cBX().toString();
    }

    public static String Ba(String str) {
        return str + "_t";
    }

    public static boolean bb(List<g> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            return false;
        }
        Set aKN = aKN();
        for (g gVar : list) {
            h(gVar);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().dA(gVar.field_localId);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().z(gVar);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dw(gVar.field_localId);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().v(gVar);
            aKN.add(gVar.field_id);
            x.d("MicroMsg.Fav.FavApiLogic", "delete id %d", new Object[]{Integer.valueOf(gVar.field_id)});
        }
        e(aKN);
        aKP();
        return true;
    }

    public static void a(g gVar, boolean z) {
        h(gVar);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().dA(gVar.field_localId);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().z(gVar);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dw(gVar.field_localId);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().v(gVar);
        if (z) {
            Set aKN = aKN();
            aKN.add(gVar.field_id);
            e(aKN);
            aKP();
        }
    }

    public static boolean a(g gVar, boolean z, Runnable runnable) {
        if (gVar == null) {
            x.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            ah.A(runnable);
            return false;
        }
        if (Looper.myLooper() == com.tencent.mm.kernel.g.Em().lnJ.getLooper()) {
            x.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z)});
            a(gVar, z);
            ah.A(runnable);
        } else {
            x.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z)});
            com.tencent.mm.kernel.g.Em().H(new 2(gVar, z, runnable));
        }
        return true;
    }

    public static boolean i(g gVar) {
        return a(gVar, true, null);
    }

    public static void j(g gVar) {
        int i;
        j jVar;
        j dB = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().dB(gVar.field_localId);
        if (dB == null) {
            dB = new j();
            dB.field_localId = gVar.field_localId;
            i = 1;
            jVar = dB;
        } else {
            i = 0;
            jVar = dB;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (gVar.field_favProto.title != null) {
            stringBuffer.append(gVar.field_favProto.title);
        }
        if (gVar.field_favProto.desc != null) {
            stringBuffer.append(gVar.field_favProto.desc);
        }
        if (gVar.field_favProto.rBG != null) {
            wr wrVar = gVar.field_favProto.rBG;
            if (!bi.oW(wrVar.bSS)) {
                stringBuffer.append(wrVar.bSS);
                ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(wrVar.bSS);
                if (Yg != null) {
                    stringBuffer.append(Yg.field_nickname).append(Yg.field_conRemark);
                }
                Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(wrVar.toUser);
                if (Yg != null) {
                    stringBuffer.append(Yg.field_nickname).append(Yg.field_conRemark);
                }
                stringBuffer.append(wrVar.rBh);
            }
        }
        LinkedList linkedList = gVar.field_favProto.rBI;
        jVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.desc != null) {
                stringBuffer.append(vxVar.desc);
            }
            if (vxVar.title != null) {
                stringBuffer.append(vxVar.title);
            }
            int i2 = vxVar.bjS;
            jVar.field_subtype = j.pJ(i2) | jVar.field_subtype;
        }
        if (gVar.field_favProto.rAN != null) {
            if (gVar.field_favProto.rAN.desc != null) {
                stringBuffer.append(gVar.field_favProto.rAN.desc);
            }
            if (gVar.field_favProto.rAN.title != null) {
                stringBuffer.append(gVar.field_favProto.rAN.title);
            }
        }
        if (gVar.field_favProto.rAP != null) {
            if (gVar.field_favProto.rAP.desc != null) {
                stringBuffer.append(gVar.field_favProto.rAP.desc);
            }
            if (gVar.field_favProto.rAP.title != null) {
                stringBuffer.append(gVar.field_favProto.rAP.title);
            }
        }
        jVar.field_tagContent = "";
        for (String str : gVar.field_tagProto.rBW) {
            jVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : gVar.field_tagProto.rBX) {
            jVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().Bm(str2);
        }
        jVar.field_content = stringBuffer.toString();
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (i != 0) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().a(jVar);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().a(jVar, new String[]{"localId"});
    }

    public static boolean Bb(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return str.endsWith("_t");
    }

    public static vx a(g gVar, String str) {
        if (bi.oW(str) || gVar == null || gVar.field_favProto.rBI.size() == 0) {
            return null;
        }
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.jdM.equals(str)) {
                return vxVar;
            }
        }
        return null;
    }

    public static void a(c cVar) {
        int p = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().p(cVar.field_favLocalId, 0);
        x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(p), Long.valueOf(cVar.field_favLocalId)});
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(cVar.field_favLocalId);
        if (dy == null) {
            x.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
        } else if (dy.aLj()) {
            x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
        } else if (cVar.field_status == 3 && p != cVar.field_status && dy.field_type == 18 && ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(cVar.field_dataId).field_status == 3) {
            a(cVar, dy);
        } else {
            switch (p) {
                case 1:
                    if (dy.aLi()) {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(15, cVar.field_favLocalId);
                    } else {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(4, cVar.field_favLocalId);
                    }
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                    return;
                case 2:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(6, cVar.field_favLocalId);
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                    return;
                case 3:
                    if (dy.field_type == 18) {
                        a(cVar, dy);
                        return;
                    } else if (dy.aLi()) {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(17, cVar.field_favLocalId);
                        x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getModService().run();
                        return;
                    } else {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(9, cVar.field_favLocalId);
                        x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
                        return;
                    }
                case 4:
                    if (dy.aLi()) {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(16, cVar.field_favLocalId);
                    } else {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(6, cVar.field_favLocalId);
                    }
                    h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(dy.field_type), Integer.valueOf(-5), Long.valueOf(b(dy)), Long.valueOf(h.dr(dy.field_localId))});
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                    return;
                default:
                    return;
            }
        }
    }

    public static void b(c cVar) {
        x.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().p(cVar.field_favLocalId, 1)), Long.valueOf(cVar.field_favLocalId)});
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(cVar.field_favLocalId);
        if (dy == null) {
            x.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
        } else if (dy.aLj() || dy.aLf() || dy.aLg()) {
            x.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[]{Boolean.valueOf(dy.aLj()), Boolean.valueOf(dy.aLf()), Boolean.valueOf(dy.aLg())});
        } else {
            switch (r1) {
                case 0:
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id)});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(10, cVar.field_favLocalId);
                    return;
                case 1:
                    h.ds(dy.field_localId);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(7, cVar.field_favLocalId);
                    return;
                case 2:
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id)});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(8, cVar.field_favLocalId);
                    return;
                case 3:
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id)});
                    h.mEJ.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(dy.field_type), Integer.valueOf(0), Long.valueOf(b(dy)), Long.valueOf(h.dr(dy.field_localId))});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(10, cVar.field_favLocalId);
                    return;
                case 4:
                    x.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(dy.field_id), Integer.valueOf(dy.field_itemStatus)});
                    h.mEJ.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(dy.field_type), Integer.valueOf(-5), Long.valueOf(b(dy)), Long.valueOf(h.dr(dy.field_localId))});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(8, cVar.field_favLocalId);
                    return;
                default:
                    return;
            }
        }
    }

    private static void a(c cVar, g gVar) {
        Iterator it = gVar.field_favProto.rBI.iterator();
        int i = 0;
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (!(vxVar.bjS == 1 || vxVar.bjS == 6)) {
                int i2;
                if (bi.oW(vxVar.rzo)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i != 0) {
            return;
        }
        if (gVar.field_id > 0) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(17, cVar.field_favLocalId);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getModService().run();
            return;
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(9, cVar.field_favLocalId);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
    }

    public static void a(vx vxVar, g gVar, int i) {
        if (i == 1 && (vxVar.rzU <= 0 || bi.oW(vxVar.rzk) || bi.oW(vxVar.dwE))) {
            x.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bi.oW(c(vxVar))) {
            x.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
        } else {
            String Ba = Ba(vxVar.jdM);
            if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(Ba) != null) {
                x.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[]{Ba});
                return;
            }
            x.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
            c cVar = new c();
            cVar.field_cdnKey = vxVar.rzk;
            cVar.field_cdnUrl = vxVar.dwE;
            cVar.field_dataId = Ba;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_totalLen = (int) vxVar.rzU;
            cVar.field_type = i;
            cVar.field_status = 1;
            cVar.field_path = c(vxVar);
            cVar.field_modifyTime = bi.VF();
            cVar.field_attrFlag |= 1;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().e(cVar);
            if (i == 1) {
                b(cVar);
            } else {
                a(cVar);
            }
        }
    }

    public static void a(vx vxVar, g gVar, int i, boolean z) {
        if (i == 1 && (bi.oW(vxVar.rzq) || bi.oW(vxVar.rzo))) {
            x.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bi.oW(b(vxVar))) {
            x.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
        } else if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM) != null) {
            x.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", new Object[]{vxVar.jdM});
        } else {
            int i2;
            x.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
            c cVar = new c();
            cVar.field_dataId = vxVar.jdM;
            cVar.field_totalLen = (int) vxVar.rzJ;
            cVar.field_type = i;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_cdnKey = vxVar.rzq;
            cVar.field_cdnUrl = vxVar.rzo;
            cVar.field_path = b(vxVar);
            if (vxVar.bjS == 3) {
                String str = vxVar.rzD;
                i2 = (bi.oW(str) || !str.equals("speex")) ? (bi.oW(str) || !str.equals("silk")) ? -2 : -4 : -3;
                cVar.field_dataType = i2;
            } else {
                cVar.field_dataType = vxVar.bjS;
            }
            cVar.field_modifyTime = bi.VF();
            boolean isWifi = ao.isWifi(ad.getContext());
            if (i == 0) {
                x.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j = ad.getContext().getSharedPreferences(ad.chY(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j == 0) {
                        j = 26214400;
                    }
                    if (((long) cVar.field_totalLen) <= j) {
                        x.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", new Object[]{Long.valueOf(j)});
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                x.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    if (((long) cVar.field_totalLen) <= ad.getContext().getSharedPreferences(ad.chY(), 0).getLong("fav_mx_auto_download_size", 26214400)) {
                        x.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", new Object[]{Long.valueOf(ad.getContext().getSharedPreferences(ad.chY(), 0).getLong("fav_mx_auto_download_size", 26214400))});
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
                }
            }
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().e(cVar);
            if (i == 1) {
                b(cVar);
            } else {
                a(cVar);
            }
        }
    }

    public static boolean pG(int i) {
        for (int i2 : a.iVo) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(g gVar) {
        if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId) != null) {
            return true;
        }
        return false;
    }

    public static void aKQ() {
        if (0 >= iVr) {
            x.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            return;
        }
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(iVr);
        iVr = 0;
        if (dy == null) {
            x.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            return;
        }
        x.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", dy.field_localId);
        a(ad.getContext(), ".ui.FavTagEditUI", intent, null);
    }

    public static void dn(long j) {
        iVr = j;
    }

    public static long aKR() {
        long aKS = aKS() - aKT();
        if (aKS < 0) {
            return 1024;
        }
        return aKS;
    }

    public static long aKS() {
        return ((Long) com.tencent.mm.kernel.g.Ei().DT().get(a.sRr, Long.valueOf(0))).longValue();
    }

    public static long aKT() {
        return ((Long) com.tencent.mm.kernel.g.Ei().DT().get(a.sRq, Long.valueOf(0))).longValue();
    }

    public static String Bc(String str) {
        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            return str;
        }
        if (!bi.oW(Yg.field_conRemark)) {
            return Yg.field_conRemark;
        }
        if (bi.oW(Yg.field_nickname)) {
            return Yg.field_username;
        }
        return Yg.field_nickname;
    }

    public static String gU(String str) {
        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            x.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String BL = Yg.BL();
        if (!s.fq(BL)) {
            return BL;
        }
        List gI = m.gI(str);
        String GF = q.GF();
        if (gI == null || gI.isEmpty()) {
            x.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
            return BL;
        }
        gI.remove(GF);
        gI.add(0, GF);
        return m.c(gI, 3);
    }

    public static void l(g gVar) {
        if (gVar.aLg()) {
            switch (gVar.field_itemStatus) {
                case 3:
                    gVar.field_itemStatus = 1;
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getCheckCdnService().run();
                    return;
                case 6:
                    if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dt(gVar.field_localId).size() == 0) {
                        gVar.field_itemStatus = 9;
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                        com.tencent.mm.kernel.g.DF().a(new af(gVar), 0);
                        return;
                    }
                    gVar.field_itemStatus = 4;
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().x(gVar);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                    for (c cVar : ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dt(gVar.field_localId)) {
                        x.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar.field_dataId, Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(cVar.field_dataId);
                    }
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    return;
                case 11:
                    gVar.field_itemStatus = 9;
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
                    return;
                case 14:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(12, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
                    return;
                case 16:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(15, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().x(gVar);
                    for (c cVar2 : ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dt(gVar.field_localId)) {
                        x.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar2.field_dataId, Integer.valueOf(cVar2.field_dataType), Integer.valueOf(cVar2.field_totalLen)});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(cVar2.field_dataId);
                    }
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    return;
                case 18:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(17, gVar.field_localId);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getModService().run();
                    return;
                default:
                    return;
            }
        }
        x.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
    }

    public static void m(g gVar) {
        if (gVar != null) {
            if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10) {
                gVar.field_itemStatus = 7;
                List<vx> list = gVar.field_favProto.rBI;
                if (list.size() != 0) {
                    for (vx vxVar : list) {
                        a(gVar, vxVar, true);
                        a(gVar, vxVar);
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
        }
    }

    public static void a(g gVar, vx vxVar, boolean z) {
        if (gVar != null && !bi.oW(vxVar.jdM)) {
            x.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), vxVar.jdM});
            c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM);
            if (Br != null && Br.field_status == 3) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                Br = null;
            }
            if (Br != null && (bi.oW(Br.field_cdnUrl) || bi.oW(Br.field_cdnKey) || bi.oW(Br.field_dataId) || !Br.field_cdnUrl.equals(vxVar.rzo) || !Br.field_cdnKey.equals(vxVar.rzq) || !Br.field_dataId.equals(vxVar.jdM))) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                Br = null;
            }
            if (Br == null || Br.field_type != 1) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b(vxVar));
                if (!bi.oW(vxVar.rzq) && !bi.oW(vxVar.rzo) && !bVar.exists()) {
                    x.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    a(vxVar, gVar, 1, true);
                    if (z) {
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(vxVar.jdM);
                        if (!bi.oW(vxVar.rAq) && vxVar.rAq.equals("WeNoteHtmlFile")) {
                            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().c(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM));
                        }
                    }
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    x.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            x.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
            Br.field_status = 1;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            if (z) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(vxVar.jdM);
                if (!bi.oW(vxVar.rAq) && vxVar.rAq.equals("WeNoteHtmlFile")) {
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().c(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM));
                }
            }
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
        }
    }

    public static void a(g gVar, vx vxVar) {
        if (!bi.oW(vxVar.jdM)) {
            String Ba = Ba(vxVar.jdM);
            c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(Ba);
            if (Br != null && Br.field_status == 3) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                Br = null;
            }
            if (Br == null || Br.field_type != 1) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(c(vxVar));
                if (!bi.oW(vxVar.rzk) && !bi.oW(vxVar.dwE) && !bVar.exists()) {
                    a(vxVar, gVar, 1);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(Ba);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    return;
                }
                return;
            }
            Br.field_status = 1;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(Ba);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
        }
    }

    public static void d(vx vxVar) {
        c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM);
        if (!(Br == null || Br.field_status == 3)) {
            Br.field_status = 2;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().pauseDownload(vxVar.jdM);
        }
        Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(Ba(vxVar.jdM));
        if (Br != null && Br.field_status != 3) {
            Br.field_status = 2;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().pauseDownload(Ba(vxVar.jdM));
        }
    }

    public static void n(g gVar) {
        if (gVar.aLf()) {
            x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", new Object[]{Integer.valueOf(gVar.field_itemStatus)});
            Iterator it = gVar.field_favProto.rBI.iterator();
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM);
                if (!(Br == null || Br.field_status == 3)) {
                    Br.field_status = 2;
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bq(vxVar.jdM);
                }
                Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(Ba(vxVar.jdM));
                if (!(Br == null || Br.field_status == 3)) {
                    Br.field_status = 2;
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bq(Ba(vxVar.jdM));
                }
            }
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId);
            x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[]{Integer.valueOf(dy.field_itemStatus)});
            switch (dy.field_itemStatus) {
                case 1:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(3, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(3)});
                    return;
                case 4:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(6, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(6)});
                    return;
                case 9:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(11, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(11)});
                    return;
                case 12:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(14, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(14)});
                    return;
                case 15:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(16, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(16)});
                    return;
                case 17:
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(18, dy.field_localId);
                    x.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(18)});
                    return;
                default:
                    return;
            }
        }
        x.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
    }

    public static boolean aKU() {
        if (aKS() != 0 && aKR() < 52428800) {
            return true;
        }
        return false;
    }

    public static float bD(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static float do(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static String dp(long j) {
        if (j == 0) {
            return "0KB";
        }
        if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            return String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
        } else if ((((double) j) * 1.0d) / 1024.0d < 1.0d) {
            return "1KB";
        } else {
            return String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
        }
    }

    public static String aj(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static boolean e(vx vxVar) {
        avq Qa = com.tencent.mm.an.b.Qa();
        return Qa != null && Qa.rYj == 6 && bi.aG(vxVar.jdM, "").equals(Qa.rsp) && com.tencent.mm.an.b.PY();
    }

    public static String aKV() {
        return com.tencent.mm.kernel.g.Ei().dqp + "favorite/music/";
    }

    public static String getAppName(Context context, String str) {
        ac$b ac_b = ac.a.dBp;
        if (ac_b != null) {
            return ac_b.q(context, str);
        }
        return "";
    }

    public static boolean o(g gVar) {
        if (gVar == null) {
            return false;
        }
        vx c = c(gVar);
        if (c == null) {
            return false;
        }
        int bvB;
        int i;
        boolean a;
        long VG = bi.VG();
        com.tencent.mm.plugin.sight.base.a Lo = com.tencent.mm.plugin.sight.base.d.Lo(b(c));
        if (Lo != null) {
            bvB = Lo.bvB();
            i = c.duration;
            if (i <= 0 || Math.abs(i - bvB) >= 2) {
                c.CE(bvB);
                a = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            bvB = 0;
        }
        x.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bvB), Boolean.valueOf(a), Long.valueOf(bi.bI(VG))});
        return a;
    }

    public static String aKW() {
        return com.tencent.mm.kernel.g.Ei().dqp + "favorite/";
    }

    public static String aKX() {
        return com.tencent.mm.kernel.g.Ei().dqp + "favorite/voice/";
    }

    public static List<g> a(long j, int i, Set<Integer> set, w wVar) {
        if (j == 0) {
            return ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(i, set, wVar);
        }
        return ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().b(j, i, set, wVar);
    }

    public static long o(long j, int i) {
        x.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
        long u = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().u(j, i);
        long s = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().s(j, i);
        x.v("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(u), Long.valueOf(s), Long.valueOf(j)});
        if (u == 0) {
            return s;
        }
        LinkedList t = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(u, i);
        if (t.size() > 0) {
            x.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(u), Long.valueOf(s), Long.valueOf(j)});
            x.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[]{Integer.valueOf(t.size())});
            if (!com.tencent.mm.kernel.g.DF().a(new ah(t), 0)) {
                x.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
                ah.aLM();
            }
        }
        if (s == 0) {
            return u;
        }
        return u < s ? u : s;
    }

    public static void startSync() {
        com.tencent.mm.kernel.g.DF().a(new aj(), 0);
    }

    public static String Bd(String str) {
        if (bi.oW(str)) {
            return null;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(aKO() + g.u(str.getBytes()));
        if (bVar.exists()) {
            return bVar.cBX().toString();
        }
        return null;
    }

    public static boolean f(vx vxVar) {
        return new com.tencent.mm.vfs.b(b(vxVar)).exists();
    }

    public static boolean g(vx vxVar) {
        return o.Wf(b(vxVar));
    }

    public static boolean aKY() {
        return ah.aLN() > 0;
    }

    public static void a(vx vxVar, int i) {
        if (!bi.oW(vxVar.jdM) && !bi.oW(vxVar.rzk) && !bi.oW(vxVar.dwE)) {
            String Ba = Ba(vxVar.jdM);
            c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(Ba);
            if (Br != null && (Br.field_status == 3 || Br.field_status == 4)) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                Br = null;
            }
            if (Br == null || Br.field_type != 1) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(c(vxVar));
                if (!bi.oW(vxVar.rzk) && !bi.oW(vxVar.dwE) && !bVar.exists()) {
                    g gVar = new g();
                    gVar.field_localId = -1;
                    gVar.field_id = -1;
                    gVar.field_type = i;
                    a(vxVar, gVar, 1);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(Ba);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    return;
                }
                return;
            }
            Br.field_status = 1;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(Ba);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
        }
    }

    public static void b(vx vxVar, int i) {
        if (!bi.oW(vxVar.jdM)) {
            x.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", new Object[]{vxVar.jdM});
            c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(vxVar.jdM);
            if (Br != null && (Br.field_status == 3 || Br.field_status == 4)) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                Br = null;
            }
            if (Br == null || Br.field_type != 1) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b(vxVar));
                if (!bi.oW(vxVar.rzq) && !bi.oW(vxVar.rzo) && !bVar.exists()) {
                    x.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    g gVar = new g();
                    gVar.field_localId = -1;
                    gVar.field_id = -1;
                    gVar.field_type = i;
                    a(vxVar, gVar, 1, true);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(vxVar.jdM);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                    x.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            x.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
            Br.field_status = 1;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(Br, new String[]{"dataId"});
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().Bp(vxVar.jdM);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
        }
    }

    public static boolean a(long j, Runnable runnable) {
        return a(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j), true, runnable);
    }

    public static void p(g gVar) {
        int i;
        j jVar;
        j dB = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().dB(gVar.field_localId);
        if (dB == null) {
            dB = new j();
            dB.field_localId = gVar.field_localId;
            i = 1;
            jVar = dB;
        } else {
            i = 0;
            jVar = dB;
        }
        jVar.field_tagContent = "";
        for (String str : gVar.field_tagProto.rBW) {
            jVar.field_tagContent += " " + str;
        }
        for (String str2 : gVar.field_tagProto.rBX) {
            jVar.field_tagContent += " " + str2;
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().Bm(str2);
        }
        jVar.field_content = "";
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (i != 0) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().a(jVar);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().a(jVar, new String[]{"localId"});
    }

    public static ArrayList<g> a(List<String> list, List<String> list2, List<Integer> list3, List<g> list4, Set<Integer> set, w wVar) {
        List a = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavSearchStorage().a(list, list2, list3);
        ArrayList<g> arrayList = new ArrayList();
        if (a.size() == 0) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < a.size() ? i + 20 : a.size();
            x.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(a.size())});
            Collection a2 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(a.subList(i, size), list4, set, wVar);
            if (a2 != null && a2.size() > 0) {
                arrayList.addAll(a2);
            }
            if (size >= a.size()) {
                return arrayList;
            }
            i = size;
        }
    }

    public static int Be(String str) {
        if (!bi.oW(str) && str.equals("speex")) {
            return 1;
        }
        if (bi.oW(str) || !str.equals("silk")) {
            return 0;
        }
        return 2;
    }

    public static boolean aKZ() {
        if (aKS() != 0 && aKR() < 10485760) {
            return true;
        }
        return false;
    }

    public static g Bf(String str) {
        g gVar = new g();
        gVar.field_localId = -1;
        gVar.field_id = -1;
        gVar.field_xml = str;
        gVar.field_type = 18;
        gVar.Bh(str);
        return gVar;
    }

    private static g Bg(String str) {
        if (str == null || str.equals("")) {
            x.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
            return null;
        }
        String str2;
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (replace.startsWith("<noteinfo>")) {
            str2 = replace;
        } else {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        }
        Map z = bl.z(str2, "noteinfo");
        if (z == null) {
            x.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            return null;
        }
        g gVar = new g();
        try {
            gVar.field_favProto = new wl();
            gVar.field_type = 18;
            gVar.field_favProto.fT(bi.getLong((String) z.get(".noteinfo.edittime"), 0));
            wf wfVar = new wf();
            wfVar.rBA = (String) z.get(".noteinfo.noteeditor");
            wfVar.rBz = (String) z.get(".noteinfo.noteauthor");
            gVar.field_favProto.a(wfVar);
            gVar.field_localId = bi.getLong((String) z.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            com.tencent.mm.plugin.fav.a.a.b.a(str2, gVar.field_favProto);
            return gVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e, "", new Object[0]);
            x.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void g(Context context, String str, String str2, String str3) {
        g Bg = Bg(str);
        if (Bg != null) {
            kp kpVar = new kp();
            kpVar.bUP.type = 2;
            kpVar.bUP.field_localId = -1;
            kpVar.bUP.context = context;
            kpVar.bUP.bUW = 4;
            kpVar.bUP.bUY = true;
            Bundle bundle = new Bundle();
            bundle.putString("noteauthor", Bg.field_favProto.qYa.rBz);
            bundle.putString("noteeditor", Bg.field_favProto.qYa.rBA);
            bundle.putLong("edittime", Bg.field_favProto.qYb);
            bundle.putString("notexml", g.s(Bg));
            bundle.putString("snslocalid", str2);
            bundle.putString("snsthumbpath", str3);
            bundle.putString("snsnotelinkxml", str);
            kpVar.bUP.bUU = bundle;
            kpVar.bUP.field_favProto = Bg.field_favProto;
            com.tencent.mm.sdk.b.a.sFg.m(kpVar);
        }
    }

    public static g a(wl wlVar) {
        g gVar = new g();
        gVar.field_favProto = new wl();
        gVar.field_type = 18;
        gVar.field_favProto = wlVar;
        return gVar;
    }

    private static void b(g gVar, boolean z) {
        wf wfVar = new wf();
        if (!z) {
            wfVar.rBz = q.GF();
        }
        wfVar.rBA = q.GF();
        gVar.field_favProto.fT(bi.VE());
        gVar.field_favProto.a(wfVar);
    }

    public static void q(g gVar) {
        if (gVar != null) {
            wf wfVar = gVar.field_favProto.qYa;
            if ((wfVar == null || bi.oW(wfVar.rBA)) && gVar.field_type == 18) {
                if (gVar.field_favProto.rBG.bJt == 6) {
                    b(gVar, false);
                } else {
                    b(gVar, true);
                }
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
            }
        }
    }

    public static void b(fz fzVar) {
        g gVar;
        if (fzVar.bOL.bOS == 1) {
            String str;
            fzVar.bOM.path = dj(fzVar.bOL.bJA);
            com.tencent.mm.g.a.fz.b bVar = fzVar.bOM;
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
            if (dy == null || dy.field_favProto == null) {
                str = "";
            } else {
                if (dy.field_type != 18 || dy.field_favProto.rBI.size() > 1) {
                    Iterator it = dy.field_favProto.rBI.iterator();
                    while (it.hasNext()) {
                        vx vxVar = (vx) it.next();
                        switch (vxVar.bjS) {
                            case 2:
                                str = c(vxVar);
                                if (!d.cn(str)) {
                                    String b = b(vxVar);
                                    if (!d.cn(b)) {
                                        if (!vxVar.rzj) {
                                            if (!vxVar.rzp) {
                                                str = "";
                                                break;
                                            }
                                            a(dy, vxVar, true);
                                            str = b;
                                            break;
                                        }
                                        a(dy, vxVar);
                                        break;
                                    }
                                    c.c(b, 150, 150, CompressFormat.JPEG, 90, str);
                                    str = c(vxVar);
                                    break;
                                }
                                break;
                            default:
                        }
                    }
                }
                str = "";
            }
            bVar.bOX = str;
        } else if (fzVar.bOL.bOS == 2) {
            gVar = new g();
            gVar.field_type = 2;
            vx vxVar2 = new vx();
            vxVar2.UO(bm(vxVar2.toString(), 2));
            String b2 = b(vxVar2);
            vxVar2.UP(b2);
            vxVar2.CF(2);
            gVar.field_favProto.rBI.add(vxVar2);
            fzVar.bOM.path = g.s(gVar);
            fzVar.bOM.bOX = b2;
        } else if (fzVar.bOL.bOS == 3) {
            gVar = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
            if (gVar != null) {
                fzVar.bOM.path = q.GF() + ";" + gVar.field_fromUser + ";" + gVar.field_updateTime;
            }
        } else if (fzVar.bOL.bOS == 4) {
            gVar = Bg(fzVar.bOL.desc);
            if (gVar != null) {
                fzVar.bOL.bJH = gVar.field_favProto;
            }
        } else if (fzVar.bOL.bOS == 5) {
            a(fzVar);
        } else if (fzVar.bOL.bOS == 6) {
            gVar = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
            if (gVar == null) {
                fzVar.bOM.ret = 0;
                return;
            }
            fzVar.bOM.ret = gVar.field_id > 0 ? 1 : 0;
        } else {
            gVar = new g();
            gVar.field_type = 18;
            gVar.field_favProto = fzVar.bOL.bJH;
            fzVar.bOM.path = g.s(gVar);
        }
    }

    public static void a(g gVar, int i) {
        if (gVar == null) {
            x.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
            return;
        }
        LinkedList linkedList = new LinkedList();
        auj auj = new auj();
        auj.rXA = 4;
        auj.rXB = 0;
        linkedList.add(auj);
        LinkedList linkedList2 = new LinkedList();
        aum aum = new aum();
        aum.jSt = "favitem.taglist";
        aum.hcE = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = gVar.field_tagProto.rBX.size();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bi.WS((String) gVar.field_tagProto.rBX.get(i2))).append("</tag>");
        }
        aum.mEl = stringBuffer.toString();
        x.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", new Object[]{Integer.valueOf(gVar.field_id), aum.mEl});
        linkedList2.add(aum);
        if (gVar.field_id > 0) {
            com.tencent.mm.kernel.g.DF().a(new al(gVar.field_id, linkedList, linkedList2), 0);
            h.g((long) gVar.field_id, size, i);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getEditService().a(gVar.field_localId, linkedList, linkedList2, i);
    }

    public static void a(Context context, String str, Intent intent) {
        a(context, str, intent, null);
    }

    public static void a(Context context, String str, Intent intent, Bundle bundle) {
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                x.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
                return;
            }
        }
        String str2 = ad.chX() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ad.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
    }

    public static void a(Context context, String str, Intent intent, int i) {
        a(context, str, intent, i, null);
    }

    public static void a(Context context, String str, Intent intent, int i, Bundle bundle) {
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                x.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
                return;
            }
        }
        String str2 = ad.chX() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ad.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i, bundle);
        }
    }

    public static void c(String str, Context context) {
        if (bi.oW(str)) {
            x.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.bg.d.e(context, ".ui.transmit.MsgRetransmitUI", intent);
    }

    public static void d(String str, Context context) {
        if (bi.oW(str)) {
            x.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + q.GF() + "_0";
        String ic = u.ic(str2);
        u.Hx().v(ic, true).p("prePublishId", str2);
        intent.putExtra("reportSessionId", ic);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsUploadUI", intent);
    }

    public static void w(Intent intent, Context context) {
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 1);
            com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
    }

    public static void e(String str, Context context) {
        if (bi.oW(str)) {
            x.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", str);
        intent.putExtra("Retr_Msg_Type", 4);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.bg.d.e(context, ".ui.transmit.MsgRetransmitUI", intent);
    }

    public static void a(long j, we weVar, String str, String str2, ArrayList<String> arrayList, Context context) {
        if (weVar != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("KFavLocSigleView", true);
            intent.putExtra("map_view_type", 2);
            intent.putExtra("kFavInfoLocalId", j);
            intent.putExtra("kwebmap_slat", weVar.lat);
            intent.putExtra("kwebmap_lng", weVar.lng);
            intent.putExtra("kPoiName", weVar.bWB);
            intent.putExtra("Kwebmap_locaion", weVar.label);
            if (weVar.bSz >= 0) {
                intent.putExtra("kwebmap_scale", weVar.bSz);
            }
            intent.putExtra("kisUsername", str);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kRemark", str2);
            intent.putExtra("kTags", arrayList);
            intent.putExtra("kFavCanDel", true);
            intent.putExtra("kFavCanRemark", true);
            com.tencent.mm.bg.d.b(context, "location", ".ui.RedirectUI", intent);
        }
    }

    public static String[] a(g gVar, ag agVar) {
        String str = null;
        if (gVar == null) {
            x.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            return null;
        }
        vx c = c(gVar);
        String[] strArr = new String[2];
        3 3 = new 3(gVar, c);
        wk wkVar;
        switch (gVar.field_type) {
            case 5:
                xa xaVar = gVar.field_favProto.rAN;
                if (c == null) {
                    if (xaVar != null) {
                        strArr[1] = xaVar.thumbUrl;
                        break;
                    }
                }
                String str2 = xaVar == null ? null : xaVar.thumbUrl;
                if (bi.oW(str2)) {
                    str2 = c.bJv;
                }
                strArr[0] = c(c);
                strArr[1] = str2;
                agVar.post(3);
                break;
                break;
            case 10:
                wkVar = gVar.field_favProto.rAP;
                if (wkVar != null) {
                    strArr[1] = wkVar.thumbUrl;
                    break;
                }
                break;
            case 11:
                wkVar = gVar.field_favProto.rAP;
                if (wkVar != null) {
                    strArr[1] = wkVar.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (gVar.field_favProto.rBI != null) {
                    Iterator it = gVar.field_favProto.rBI.iterator();
                    while (it.hasNext()) {
                        vx vxVar = (vx) it.next();
                        if (vxVar.bjS == 2) {
                            str = b(vxVar);
                            agVar.post(3);
                        } else if (vxVar.bjS == 15) {
                            str = c(vxVar);
                            agVar.post(3);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = c.bJv;
                break;
            case 15:
                wu wuVar = gVar.field_favProto.rAR;
                if (wuVar != null) {
                    strArr[1] = wuVar.thumbUrl;
                    break;
                }
                break;
            default:
                if (c != null) {
                    strArr[0] = c(c);
                    strArr[1] = c.bJv;
                    agVar.post(3);
                    break;
                }
                break;
        }
        x.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[]{strArr[0], strArr[1], Integer.valueOf(gVar.field_type)});
        return strArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String r(com.tencent.mm.plugin.fav.a.g r8) {
        /*
        r2 = 0;
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r0 = r8.field_type;
        switch(r0) {
            case -2: goto L_0x000b;
            case -1: goto L_0x000b;
            case 0: goto L_0x000b;
            case 1: goto L_0x0032;
            case 2: goto L_0x0010;
            case 3: goto L_0x0049;
            case 4: goto L_0x0049;
            case 5: goto L_0x0053;
            case 6: goto L_0x000b;
            case 7: goto L_0x000b;
            case 8: goto L_0x0010;
            case 9: goto L_0x000b;
            case 10: goto L_0x000b;
            case 11: goto L_0x000b;
            case 12: goto L_0x000b;
            case 13: goto L_0x000b;
            case 14: goto L_0x0060;
            case 15: goto L_0x000b;
            case 16: goto L_0x0049;
            case 17: goto L_0x000b;
            case 18: goto L_0x0060;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r4.toString();
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = 0;
        r2 = r8.field_favProto;
        r2 = r2.rBI;
        r5 = r2.iterator();
        r2 = r0;
    L_0x001b:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.next();
        r0 = (com.tencent.mm.protocal.c.vx) r0;
        if (r0 == 0) goto L_0x00c8;
    L_0x0029:
        r0 = r0.rzJ;
        r0 = r0 + r2;
    L_0x002c:
        r2 = r0;
        goto L_0x001b;
    L_0x002e:
        r4.append(r2);
        goto L_0x000b;
    L_0x0032:
        r0 = r8.field_favProto;
        r0 = r0.desc;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x003c:
        r0 = r8.field_favProto;
        r0 = r0.desc;
        r0 = r0.getBytes();
        r0 = r0.length;
        r4.append(r0);
        goto L_0x000b;
    L_0x0049:
        r0 = c(r8);
        r0 = r0.duration;
        r4.append(r0);
        goto L_0x000b;
    L_0x0053:
        r0 = "";
        r1 = r8.field_favProto;	 Catch:{ Exception -> 0x00c4 }
        r1 = r1.rAN;	 Catch:{ Exception -> 0x00c4 }
        r0 = r1.rCn;	 Catch:{ Exception -> 0x00c4 }
    L_0x005c:
        r4.append(r0);
        goto L_0x000b;
    L_0x0060:
        if (r8 == 0) goto L_0x000b;
    L_0x0062:
        r0 = r8.field_favProto;
        r0 = r0.rBI;
        r6 = r0.iterator();
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
    L_0x006e:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x009d;
    L_0x0074:
        r0 = r6.next();
        r0 = (com.tencent.mm.protocal.c.vx) r0;
        r7 = r0.bjS;
        switch(r7) {
            case 1: goto L_0x0083;
            case 2: goto L_0x0095;
            case 3: goto L_0x007f;
            case 4: goto L_0x0099;
            default: goto L_0x007f;
        };
    L_0x007f:
        r0 = r4 + 1;
    L_0x0081:
        r4 = r0;
        goto L_0x006e;
    L_0x0083:
        r7 = r0.desc;
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r7 != 0) goto L_0x00c6;
    L_0x008b:
        r0 = r0.desc;
        r0 = r0.getBytes();
        r0 = r0.length;
        r0 = r0 + r3;
        r3 = r0;
        goto L_0x006e;
    L_0x0095:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x006e;
    L_0x0099:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x006e;
    L_0x009d:
        r0 = "%d:%d:%d:%d";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r3 = java.lang.Integer.valueOf(r3);
        r6[r2] = r3;
        r2 = 1;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r2] = r1;
        r1 = 2;
        r2 = java.lang.Integer.valueOf(r5);
        r6[r1] = r2;
        r1 = 3;
        r2 = java.lang.Integer.valueOf(r4);
        r6[r1] = r2;
        r0 = java.lang.String.format(r0, r6);
        goto L_0x000f;
    L_0x00c4:
        r1 = move-exception;
        goto L_0x005c;
    L_0x00c6:
        r0 = r4;
        goto L_0x0081;
    L_0x00c8:
        r0 = r2;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.a.b.r(com.tencent.mm.plugin.fav.a.g):java.lang.String");
    }
}
