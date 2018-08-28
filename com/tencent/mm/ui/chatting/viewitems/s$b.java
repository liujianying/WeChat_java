package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public class s$b {
    public String ceR;
    public String dxx;
    public String dzA;
    public String dzw;
    public String dzx;
    public String dzy;
    public String dzz;
    public long time;
    public String title;
    public int type;
    public String url;

    public static s$b az(Map<String, String> map) {
        s$b s_b = new s$b();
        s_b.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
        s_b.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
        s_b.ceR = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
        s_b.dzw = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
        s_b.dzx = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
        s_b.time = bi.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
        s_b.dzy = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
        s_b.dzz = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
        s_b.dzA = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        s_b.type = bi.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
        s_b.dxx = (String) map.get(".msg.appmsg.template_id");
        return s_b;
    }
}
