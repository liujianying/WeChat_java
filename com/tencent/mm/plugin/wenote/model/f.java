package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
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

    public static float bD(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static String C(Context context, int i) {
        fz fzVar = new fz();
        fzVar.bOL.type = 21;
        fzVar.bOL.context = context;
        fzVar.bOL.bOT = i;
        a.sFg.m(fzVar);
        return fzVar.bOM.path;
    }

    public static String Sf(String str) {
        return g.u((str + 18 + System.currentTimeMillis()).getBytes());
    }

    public static String c(vx vxVar) {
        fz fzVar = new fz();
        fzVar.bOL.type = 27;
        fzVar.bOL.bON = vxVar;
        a.sFg.m(fzVar);
        return fzVar.bOM.bOX;
    }

    public static String o(vx vxVar) {
        fz fzVar = new fz();
        fzVar.bOL.type = 27;
        fzVar.bOL.bON = vxVar;
        a.sFg.m(fzVar);
        return fzVar.bOM.path;
    }

    public static com.tencent.mm.plugin.fav.a.g eo(long j) {
        return ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
    }

    public static void t(long j, String str) {
        if (j > 0) {
            fz fzVar = new fz();
            fzVar.bOL.type = 34;
            fzVar.bOL.bJA = j;
            a.sFg.m(fzVar);
            if (fzVar.bOL.bJH != null && fzVar.bOL.bJH.rBI != null && fzVar.bOL.bJH.rBI.size() > 1 && ((vx) fzVar.bOL.bJH.rBI.get(0)).rAq == null) {
                x.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
                if (!bi.oW(str) && e.cn(str)) {
                    try {
                        CharSequence Sv = c.Sv(str);
                        wl wlVar = fzVar.bOL.bJH;
                        ArrayList arrayList = new ArrayList();
                        if (!bi.oW(Sv) && Sv.length() != 0) {
                            int indexOf;
                            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(Sv);
                            String str2 = "WeNote_";
                            while (matcher.find()) {
                                String group = matcher.group();
                                int indexOf2 = group.indexOf(str2);
                                if (indexOf2 != -1) {
                                    int indexOf3 = group.indexOf("\"", indexOf2 + 1);
                                    if (indexOf3 != -1) {
                                        indexOf = group.indexOf(" ", indexOf2 + 1);
                                        if (indexOf != -1) {
                                            if (indexOf3 >= indexOf) {
                                                indexOf3 = indexOf;
                                            }
                                            arrayList.add(group.substring(indexOf2, indexOf3));
                                        }
                                    }
                                }
                            }
                            LinkedList linkedList = new LinkedList();
                            Iterator it = wlVar.rBI.iterator();
                            indexOf = 0;
                            int i = 0;
                            while (it.hasNext()) {
                                vx vxVar = (vx) it.next();
                                int i2;
                                if (i == 0) {
                                    vxVar.UY("WeNoteHtmlFile");
                                    i2 = i + 1;
                                    linkedList.add(vxVar);
                                    i = i2;
                                } else {
                                    if (vxVar.bjS == 1) {
                                        vxVar.UY("-1");
                                    } else {
                                        i2 = indexOf + 1;
                                        vxVar.UY((String) arrayList.get(indexOf));
                                        indexOf = i2;
                                    }
                                    linkedList.add(vxVar);
                                }
                            }
                            fz fzVar2 = new fz();
                            fzVar2.bOL.type = 33;
                            fzVar2.bOL.bJH = wlVar;
                            fzVar2.bOL.bJH.rBI = linkedList;
                            fzVar2.bOL.bJA = j;
                            a.sFg.m(fzVar2);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    public static void W(ArrayList<String> arrayList) {
        int i = 0;
        if (c.bZb().qnC == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            return;
        }
        wl wlVar = c.bZb().qnC.qnO;
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (wlVar == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            return;
        }
        vx vxVar;
        Iterator it = wlVar.rBI.iterator();
        while (it.hasNext()) {
            vxVar = (vx) it.next();
            if (!(bi.oW(vxVar.rAq) || vxVar.rAq.contains("WeNoteHtmlFile") || vxVar.rAq.contains("-1"))) {
                arrayList2.add(vxVar.rAq);
                hashMap.put(vxVar.rAq, vxVar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                wlVar.ar(linkedList);
                bZd();
                hashMap.clear();
                return;
            }
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() != 0) {
            List<vx> arrayList3 = new ArrayList();
            Iterator it2 = wlVar.rBI.iterator();
            while (it2.hasNext()) {
                vxVar = (vx) it2.next();
                if (arrayList2.contains(vxVar.rAq)) {
                    arrayList3.add(vxVar);
                }
            }
            for (vx vxVar2 : arrayList3) {
                wlVar.rBI.remove(vxVar2);
            }
            bZd();
        }
    }

    private static void bZd() {
        fz fzVar = new fz();
        fzVar.bOL.type = 30;
        if (c.bZb().qnC != null) {
            fzVar.bOL.bJH = c.bZb().qnC.qnO;
            a.sFg.m(fzVar);
            c.bZb().qnC.Sd(fzVar.bOM.path);
        }
    }
}
