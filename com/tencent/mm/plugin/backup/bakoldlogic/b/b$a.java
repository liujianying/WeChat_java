package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class b$a {
    public static String gVK = "]]>";
    public static String gVL = "<msg>";
    public static String gVM = "</msg>";

    public static String wz(String str) {
        l wS = ((a) g.l(a.class)).wS(str);
        a aVar = new a(str);
        if (aVar.gVO) {
            String str2;
            String str3;
            String str4;
            String str5;
            b bVar = new b();
            List list = wS.dzs;
            Map hashMap = new HashMap();
            bVar.wA("msg");
            hashMap.put("appid", (String) aVar.gVN.get(".msg.appmsg.$appid"));
            hashMap.put("sdkver", (String) aVar.gVN.get(".msg.appmsg.$sdkver"));
            bVar.i("appmsg", hashMap);
            if (list == null) {
                list = new LinkedList();
            }
            if (list.size() == 0) {
                str2 = "";
                str3 = "";
                str4 = "";
            } else {
                str2 = ((m) list.get(0)).title;
                str3 = ((m) list.get(0)).url;
                str5 = ((m) list.get(0)).dzy;
                str4 = ((m) list.get(0)).dzA;
            }
            bVar.bR(FFmpegMetadataRetriever.METADATA_KEY_TITLE, str2);
            bVar.bR("des", (String) aVar.gVN.get(".msg.appmsg.des"));
            bVar.bR("action", (String) aVar.gVN.get(".msg.appmsg.action"));
            bVar.aT("type", aVar.getInt(".msg.appmsg.type"));
            bVar.aT("showtype", aVar.getInt(".msg.appmsg.showtype"));
            bVar.bR("content", (String) aVar.gVN.get(".msg.appmsg.content"));
            bVar.bR("url", str3);
            bVar.bR("lowurl", (String) aVar.gVN.get(".msg.appmsg.lowurl"));
            bVar.wA("appattach");
            bVar.aT("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
            bVar.bR("attachid", (String) aVar.gVN.get(".msg.appmsg.appattach.attachid"));
            bVar.bR("fileext", (String) aVar.gVN.get(".msg.appmsg.appattach.fileext"));
            bVar.wB("appattach");
            bVar.wA("mmreader");
            hashMap.put("type", wS.type);
            hashMap.put("convMsgCount", list.size());
            bVar.i("category", hashMap);
            bVar.bR("name", wS.bZH);
            bVar.wA("topnew");
            bVar.bR("cover", (String) aVar.gVN.get(".msg.appmsg.mmreader.category.topnew.cover"));
            bVar.bR("width", (String) aVar.gVN.get(".msg.appmsg.mmreader.category.topnew.width"));
            bVar.bR("height", (String) aVar.gVN.get(".msg.appmsg.mmreader.category.topnew.height"));
            bVar.bR("digest", str4);
            bVar.wB("topnew");
            int i = 0;
            while (i < list.size()) {
                bVar.wA("item");
                if (list.get(i) != null) {
                    str3 = ((m) list.get(i)).title;
                    str2 = ((m) list.get(i)).url;
                    String str6 = ((m) list.get(i)).dzw;
                    String str7 = ((m) list.get(i)).dzx;
                    String str8 = ((m) list.get(i)).time;
                    String str9 = ((m) list.get(i)).dzy;
                    String str10 = ((m) list.get(i)).dzz;
                    str5 = ((m) list.get(i)).dzA;
                    bVar.bR(FFmpegMetadataRetriever.METADATA_KEY_TITLE, str3);
                    bVar.bR("url", str2);
                    bVar.bR("shorturl", str6);
                    bVar.bR("longurl", str7);
                    bVar.bR("pub_time", str8);
                    bVar.bR("cover", str9);
                    bVar.bR("tweetid", str10);
                    bVar.bR("digest", str5);
                    bVar.bR("fileid", (String) aVar.gVN.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                    bVar.wA("source");
                    bVar.wA("source");
                    bVar.bR("name", wS.bZH);
                    bVar.wB("source");
                    bVar.wB("source");
                    bVar.wB("item");
                }
                i++;
            }
            bVar.wB("category");
            bVar.wA(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.bR("convName", wS.bZG);
            bVar.bR("nickname", wS.bZH);
            bVar.wB(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.wB("mmreader");
            bVar.wB("appmsg");
            bVar.bR("fromusername", wS.bZG);
            bVar.aT("scene", aVar.getInt(".msg.scene"));
            bVar.wA("appinfo");
            bVar.bR("version", (String) aVar.gVN.get(".msg.appinfo.appname"));
            bVar.bR("appname", (String) aVar.gVN.get(".msg.appinfo.version"));
            bVar.wB("appinfo");
            bVar.bR("commenturl", wS.cGB);
            bVar.wB("msg");
            x.d("MicroMsg.AppmsgConvert", "xml " + bVar.gVP.toString());
            return bVar.gVP.toString();
        }
        x.e("MicroMsg.AppmsgConvert", "buffer error");
        return "";
    }
}
