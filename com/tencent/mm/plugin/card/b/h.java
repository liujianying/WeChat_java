package com.tencent.mm.plugin.card.b;

import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class h {
    public int dxI;
    public String dxJ;
    public String dxK;
    public String dxL;
    public String dxM;
    public String dxN;
    public String dxO;
    public String dxP;
    public int ver;

    public static h b(a aVar) {
        Map map = aVar.dzf;
        h hVar = new h();
        hVar.dxJ = bi.aG((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.dxI = o.cx((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.dxK = bi.aG((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.dxL = bi.aG((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.dxM = bi.aG((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.dxN = bi.aG((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.dxO = bi.aG((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.dxP = bi.aG((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = o.cx((String) map.get(".msg.appmsg.giftcard_info.ver"));
        return hVar;
    }
}
