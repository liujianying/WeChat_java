package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vfs.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class h$a {
    public String bOX;
    public String desc;
    public String jap;
    public String title;

    private static boolean BB(String str) {
        return new b(str).exists();
    }

    public static h$a a(Context context, g gVar) {
        int i;
        String str;
        String c;
        int i2;
        StringBuilder append;
        Iterator it;
        if (gVar.field_type == 18) {
            h$a h_a = new h$a();
            SparseIntArray sparseIntArray = new SparseIntArray();
            if (gVar.field_type == 18) {
                h_a.title = gVar.field_favProto.title;
            }
            List linkedList = new LinkedList();
            i = 0;
            int i3 = 0;
            for (vx vxVar : gVar.field_favProto.rBI) {
                if (gVar.field_type != 18 || bi.oW(vxVar.rzD) || !vxVar.rzD.equals(".htm")) {
                    sparseIntArray.put(vxVar.bjS, sparseIntArray.get(vxVar.bjS) + 1);
                    switch (vxVar.bjS) {
                        case 1:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            str = vxVar.desc;
                            if (!bi.oW(str)) {
                                linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + "\n");
                                break;
                            }
                            break;
                        case 2:
                            if (i != 0) {
                                break;
                            }
                            c = com.tencent.mm.plugin.fav.a.b.c(vxVar);
                            if (!BB(c)) {
                                h_a.bOX = com.tencent.mm.plugin.fav.a.b.b(vxVar);
                                i = 1;
                                break;
                            }
                            h_a.bOX = c;
                            i = 1;
                            break;
                        case 3:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            i2 = (int) com.tencent.mm.plugin.fav.a.b.do((long) vxVar.duration);
                            linkedList.add(context.getString(i.app_voice) + context.getString(i.fav_fmt_time_length, new Object[]{Integer.valueOf(i2)}) + "\n");
                            break;
                        case 4:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            linkedList.add(context.getString(i.app_video) + "\n");
                            break;
                        case 6:
                            if (linkedList.size() < 4) {
                                we weVar = vxVar.rAi.rAL;
                                append = new StringBuilder().append(context.getString(i.app_location));
                                str = (bi.oW(weVar.bWB) || weVar.bWB.equals(context.getString(i.location_sub_title_location_with_bracket))) ? weVar.label : weVar.bWB;
                                linkedList.add(append.append(str).append("\n").toString());
                            }
                            if (i3 != 0) {
                                break;
                            }
                            i3 = 1;
                            break;
                            break;
                        case 8:
                            if (linkedList.size() < 4) {
                                linkedList.add(context.getString(i.app_file) + vxVar.title + "\n");
                            }
                            if (i3 != 0) {
                                break;
                            }
                            i3 = 1;
                            break;
                        case 17:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            linkedList.add(context.getString(i.app_record) + "\n");
                            break;
                        case 19:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            linkedList.add(context.getString(i.app_app_brand) + vxVar.title + "\n");
                            break;
                        default:
                            break;
                    }
                }
            }
            str = "";
            h_a.desc = "";
            it = linkedList.iterator();
            while (true) {
                c = str;
                if (it.hasNext()) {
                    str = c + ((String) it.next());
                } else {
                    str = c.trim();
                    if (linkedList.size() >= 4) {
                        str = str + "...";
                    }
                    h_a.desc = str;
                    h_a.title = ad.getContext().getString(i.favorite_wenote);
                    return h_a;
                }
            }
        }
        h$a h_a2 = new h$a();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        if (gVar.field_type == 14) {
            h_a2.title = gVar.field_favProto.title;
        }
        List linkedList2 = new LinkedList();
        i = 0;
        for (vx vxVar2 : gVar.field_favProto.rBI) {
            sparseIntArray2.put(vxVar2.bjS, sparseIntArray2.get(vxVar2.bjS) + 1);
            switch (vxVar2.bjS) {
                case 1:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    linkedList2.add(vxVar2.rAk + ":" + vxVar2.desc + "\n");
                    break;
                case 2:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_pic) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str = com.tencent.mm.plugin.fav.a.b.c(vxVar2);
                    if (BB(str)) {
                        h_a2.bOX = str;
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                    break;
                case 3:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    int bD = (int) com.tencent.mm.plugin.fav.a.b.bD((long) vxVar2.duration);
                    linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_voice) + context.getString(i.fav_fmt_time_length, new Object[]{Integer.valueOf(bD)}) + "\n");
                    break;
                case 4:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_video) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str = com.tencent.mm.plugin.fav.a.b.c(vxVar2);
                    if (BB(str)) {
                        h_a2.bOX = str;
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                    break;
                case 5:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_url) + vxVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    c = com.tencent.mm.plugin.fav.a.b.c(vxVar2);
                    if (BB(c)) {
                        h_a2.bOX = c;
                    } else {
                        xa xaVar = vxVar2.rAi.rAN;
                        c = xaVar == null ? "" : xaVar.thumbUrl;
                        if (bi.oW(c)) {
                            c = bi.aG(vxVar2.bJv, "");
                        }
                        a(h_a2, c);
                    }
                    i = 1;
                    break;
                case 6:
                    if (linkedList2.size() < 4) {
                        we weVar2 = vxVar2.rAi.rAL;
                        append = new StringBuilder().append(vxVar2.rAk).append(":").append(context.getString(i.app_location));
                        str = (bi.oW(weVar2.bWB) || weVar2.bWB.equals(context.getString(i.location_sub_title_location_with_bracket))) ? weVar2.label : weVar2.bWB;
                        linkedList2.add(append.append(str).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_music) + vxVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(h_a2, vxVar2.bJv);
                    i = 1;
                    break;
                case 8:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_file) + vxVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_product) + vxVar2.rAi.rAP.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    wk wkVar = vxVar2.rAi.rAP;
                    if (wkVar != null) {
                        a(h_a2, wkVar.thumbUrl);
                    }
                    i = 1;
                    break;
                case 14:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_app) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    wu wuVar = vxVar2.rAi.rAR;
                    if (wuVar != null) {
                        a(h_a2, wuVar.thumbUrl);
                    }
                    i = 1;
                    break;
                case 15:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_shortvideo) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str = com.tencent.mm.plugin.fav.a.b.c(vxVar2);
                    if (BB(str)) {
                        h_a2.bOX = str;
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                    break;
                case 16:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_friend_card) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    h_a2.jap = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GR(vxVar2.desc).otZ;
                    i = 1;
                    break;
                case 17:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_record) + "\n");
                    break;
                case 19:
                    if (linkedList2.size() < 4) {
                        if (vxVar2.rAi.rBa != null && vxVar2.rAi.rBa.type == 3) {
                            linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_not_show) + "\n");
                            break;
                        }
                        linkedList2.add(vxVar2.rAk + ":" + context.getString(i.app_app_brand) + vxVar2.title + "\n");
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        str = "";
        h_a2.desc = "";
        it = linkedList2.iterator();
        while (true) {
            c = str;
            if (it.hasNext()) {
                str = c + ((String) it.next());
            } else {
                str = c.trim();
                if (linkedList2.size() >= 4) {
                    str = str + "...";
                }
                h_a2.desc = str;
                return h_a2;
            }
        }
    }

    private static void a(h$a h_a, String str) {
        String str2 = com.tencent.mm.plugin.fav.a.b.aKO() + com.tencent.mm.a.g.u(bi.aG(str, "").getBytes());
        if (BB(str2)) {
            h_a.bOX = str2;
        }
    }
}
