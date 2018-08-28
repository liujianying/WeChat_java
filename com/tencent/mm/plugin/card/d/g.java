package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bl;
import java.util.Map;

public final class g {
    public static d xQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        Map z = bl.z(str, "msg");
        dVar.hwf = (String) z.get(".msg.appmsg.carditem.from_username");
        dVar.cac = (String) z.get(".msg.appmsg.carditem.card_id");
        dVar.huV = xS((String) z.get(".msg.appmsg.carditem.card_type"));
        dVar.cae = xS((String) z.get(".msg.appmsg.carditem.from_scene"));
        dVar.dxh = (String) z.get(".msg.appmsg.carditem.color");
        dVar.hwg = (String) z.get(".msg.appmsg.carditem.card_type_name");
        dVar.hwh = (String) z.get(".msg.appmsg.carditem.brand_name");
        dVar.cad = (String) z.get(".msg.appmsg.carditem.card_ext");
        dVar.hwi = xS((String) z.get(".msg.appmsg.carditem.is_recommend"));
        dVar.hwj = (String) z.get(".msg.appmsg.carditem.recommend_card_id");
        return dVar;
    }

    public static String xR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) bl.z(str, "msg").get(".msg.appmsg.fromusername");
    }

    private static int xS(String str) {
        if (TextUtils.isEmpty(str) || !l.xW(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static String a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.hwf).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.cac).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.huV).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.cae).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.dxh).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.hwg).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.hwh).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.cad)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.cad).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.hwi).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.hwj).append("</recommend_card_id>");
        return stringBuilder.toString();
    }
}
