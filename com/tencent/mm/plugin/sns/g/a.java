package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int MO(String str) {
        int i = 0;
        try {
            return bi.getInt(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.AlbumBgHelper", "parserInt error " + str);
            return i;
        }
    }

    private static float ne(String str) {
        float f = 0.0f;
        if (str == null) {
            return f;
        }
        try {
            return bi.getFloat(str, 0.0f);
        } catch (Exception e) {
            x.e("MicroMsg.AlbumBgHelper", "parseFloat error " + str);
            return f;
        }
    }

    private static String nf(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static cj MP(String str) {
        Map z = bl.z(str, "albumList");
        cj cjVar = new cj();
        if (z == null) {
            return cjVar;
        }
        cjVar.jRj = nf((String) z.get(".albumList.$lang"));
        dx dxVar = new dx();
        dxVar.jPe = nf((String) z.get(".albumList.album.author.name"));
        dxVar.bHD = nf((String) z.get(".albumList.album.author.title"));
        dxVar.rej = nf((String) z.get(".albumList.album.author.description"));
        dxVar.rei = nf((String) z.get(".albumList.album.author.quote"));
        dy dyVar = new dy();
        atg p = p(z, ".albumList.album.author.icon.media");
        String str2 = (String) z.get(".albumList.album.author.icon.media.id");
        String str3 = (String) z.get(".albumList.album.author.icon.media.type");
        String str4 = (String) z.get(".albumList.album.author.icon.media.title");
        String str5 = (String) z.get(".albumList.album.author.icon.media.desc");
        String str6 = (String) z.get(".albumList.album.author.icon.media.url");
        String str7 = (String) z.get(".albumList.album.author.icon.media.private");
        String str8 = (String) z.get(".albumList.album.author.icon.media.thumb");
        String str9 = (String) z.get(".albumList.album.author.icon.media.url.$type");
        String str10 = (String) z.get(".albumList.album.author.icon.media.thumb.$type");
        ate ate = new ate();
        ate.ksA = nf(str2);
        ate.hcE = MO(str3);
        ate.bHD = nf(str4);
        ate.jOS = nf(str5);
        ate.jPK = nf(str6);
        ate.rVD = MO(str9);
        ate.rVE = nf(str8);
        ate.rVF = MO(str10);
        ate.rVG = MO(str7);
        ate.rVH = p;
        dyVar.rel = ate;
        dxVar.rek = dyVar;
        cjVar.rcL = dxVar;
        int i = 0;
        while (true) {
            Object obj;
            int i2 = i;
            alh alh = new alh();
            if (i2 == 0) {
                obj = ".albumList.album.groupList.group.name";
                str4 = ".albumList.album.groupList.group.mediaList";
            } else {
                obj = ".albumList.album.groupList.group" + i2 + ".name";
                str4 = ".albumList.album.groupList.group" + i2 + ".mediaList";
            }
            str2 = (String) z.get(obj);
            if (str2 == null) {
                return cjVar;
            }
            alh.jPe = nf(str2);
            alh.ruA = q(z, str4);
            cjVar.rcM.add(alh);
            i = i2 + 1;
        }
    }

    private static atg p(Map<String, String> map, String str) {
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        atg atg = new atg();
        atg.rWv = 0.0f;
        atg.rWu = 0.0f;
        atg.rWw = 0.0f;
        if (str2 != null) {
            atg.rWu = ne(str2);
        }
        if (str3 != null) {
            atg.rWv = ne(str3);
        }
        if (str4 != null) {
            atg.rWw = ne(str4);
        }
        return atg;
    }

    private static LinkedList<ate> q(Map<String, String> map, String str) {
        LinkedList<ate> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            String obj62;
            String obj72;
            String obj82;
            String obj92;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                obj2 = str + ".media" + i + ".type";
                obj3 = str + ".media" + i + ".title";
                obj4 = str + ".media" + i + ".desc";
                obj5 = str + ".media" + i + ".url";
                str2 = str + ".media" + i + ".thumb";
                str3 = str + ".media" + i + ".url.$type";
                str4 = str + ".media" + i + ".thumb.$type";
                str5 = str + ".media" + i + ".private";
                str6 = str + ".media" + i;
                obj62 = str5;
                obj72 = str4;
                obj82 = str3;
                obj92 = str2;
            } else {
                obj = str + ".media.id";
                obj2 = str + ".media.type";
                obj3 = str + ".media.title";
                obj4 = str + ".media.desc";
                obj5 = str + ".media.url";
                str2 = str + ".media.thumb";
                str3 = str + ".media.url.$type";
                str4 = str + ".media.thumb.$type";
                str5 = str + ".media.private";
                str6 = str + ".media";
                obj62 = str5;
                obj72 = str4;
                obj82 = str3;
                obj92 = str2;
            }
            if (obj != null && obj2 != null) {
                atg p = p(map, str6);
                str6 = (String) map.get(obj);
                str5 = (String) map.get(obj2);
                str4 = (String) map.get(obj3);
                str3 = (String) map.get(obj4);
                str2 = (String) map.get(obj5);
                obj62 = (String) map.get(obj62);
                obj92 = (String) map.get(obj92);
                obj82 = (String) map.get(obj82);
                obj72 = (String) map.get(obj72);
                if (str6 == null || str5 == null) {
                    break;
                }
                ate ate = new ate();
                ate.ksA = nf(str6);
                ate.hcE = MO(str5);
                ate.bHD = nf(str4);
                ate.jOS = nf(str3);
                ate.jPK = nf(str2);
                ate.rVD = MO(obj82);
                ate.rVE = nf(obj92);
                ate.rVF = MO(obj72);
                ate.rVG = MO(obj62);
                ate.rVH = p;
                linkedList.add(ate);
                i++;
            } else {
                break;
            }
        }
        return linkedList;
    }
}
