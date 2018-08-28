package com.tencent.mm.y.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import java.util.Map;

public final class a {
    public String appId;
    public String content;
    private String dzQ;
    public String dzR;
    public int dzS;
    public int dzT;
    public String path;
    public String title;
    public int type;
    public String username;

    public static a gw(String str) {
        Map z = bl.z(str, "sysmsg");
        a aVar = new a();
        if (z == null) {
            return aVar;
        }
        aVar.dzQ = (String) z.get(".sysmsg.subscribesysmsg.content_template.template");
        aVar.title = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title");
        aVar.content = aVar.dzQ.replace("$wxaapp_view$", aVar.title);
        aVar.appId = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid");
        aVar.username = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username");
        aVar.path = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path");
        aVar.type = bi.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
        aVar.dzR = (String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        aVar.dzS = bi.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
        aVar.dzT = bi.getInt((String) z.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
        return aVar;
    }
}
