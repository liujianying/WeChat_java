package com.tencent.mm.plugin.biz;

import android.text.TextUtils;
import com.tencent.mm.ac.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.Map;

public final class a implements com.tencent.mm.plugin.biz.a.a {
    public final String bV(String str, String str2) {
        String str3;
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
            str3 = null;
        } else {
            str3 = (String) z.get(".msg.fromusername");
        }
        if (!bi.oW(str3) || s.hE(str2)) {
            str2 = str3;
        }
        if (bi.oW(str2)) {
            return "";
        }
        if (i.gr(str2)) {
            WxaAttributes rR = ((c) g.l(c.class)).rR(str2);
            if (!(rR == null || TextUtils.isEmpty(rR.field_nickname))) {
                return rR.field_nickname;
            }
        }
        return ((b) g.l(b.class)).gT(str2);
    }

    public final boolean gr(String str) {
        return i.gr(str);
    }

    public final String wR(String str) {
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            return " ";
        }
        int i = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        String aG = bi.aG((String) z.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        String str2 = null;
        if (aG.equals("wx_f2f") || aG.equals("wx_md")) {
            str2 = bi.oV((String) z.get(".msg.appmsg.title"));
        } else if (i != 0) {
            str2 = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.title"));
        }
        if (bi.oW(str2)) {
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
        }
        return bi.oW(str2) ? " " : str2;
    }

    public final String gs(String str) {
        return i.gs(str);
    }

    public final l wS(String str) {
        Map WA = ay.WA(str);
        if (WA == null) {
            return i.gt(str);
        }
        int i = bi.getInt((String) WA.get(".msg.appmsg.mmreader.category.$type"), 0);
        String oV = bi.oV((String) WA.get(".msg.appmsg.mmreader.name"));
        int i2 = bi.getInt((String) WA.get(".msg.appmsg.mmreader.forbid_forward"), 0);
        int i3 = bi.getInt((String) WA.get(".msg.appmsg.mmreader.category.$count"), 0);
        String str2 = (String) WA.get(".msg.commenturl");
        l lVar = new l();
        lVar.type = i;
        lVar.name = oV;
        lVar.cGB = str2;
        lVar.dzt = i2;
        i = 0;
        while (i < i3) {
            m mVar = new m();
            String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i));
            mVar.title = (String) WA.get(str3 + ".title");
            mVar.url = (String) WA.get(str3 + ".url");
            mVar.dzw = (String) WA.get(str3 + ".shorturl");
            mVar.dzx = (String) WA.get(str3 + ".longurl");
            mVar.time = bi.getLong((String) WA.get(str3 + ".pub_time"), 0);
            mVar.dzz = (String) WA.get(str3 + ".tweetid");
            mVar.dzA = (String) WA.get(str3 + ".digest");
            mVar.type = bi.getInt((String) WA.get(str3 + ".itemshowtype"), 0);
            mVar.dzC = bi.getInt((String) WA.get(str3 + ".play_length"), 0);
            mVar.dzy = (String) WA.get(str3 + ".cover");
            mVar.dzB = bi.getInt((String) WA.get(str3 + ".del_flag"), 0);
            mVar.dzD = (String) WA.get(str3 + ".weapp_username");
            mVar.dzE = (String) WA.get(str3 + ".weapp_path");
            mVar.dzF = bi.getInt((String) WA.get(str3 + ".weapp_version"), 0);
            mVar.dzG = bi.getInt((String) WA.get(str3 + ".weapp_state"), 0);
            mVar.dzH = (String) WA.get(str3 + ".weapp_appid");
            mVar.dzI = (String) WA.get(str3 + ".weapp_image_url");
            mVar.dzJ = (String) WA.get(str3 + ".weapp_icon");
            mVar.dzK = (String) WA.get(str3 + ".weapp_nickname");
            mVar.dzL = (String) WA.get(str3 + ".play_url");
            mVar.dzM = (String) WA.get(str3 + ".player");
            mVar.dzN = bi.getInt((String) WA.get(str3 + ".music_source"), 1);
            mVar.dzO = bi.getInt((String) WA.get(str3 + ".pic_num"), 1);
            lVar.dzs.add(mVar);
            i++;
        }
        lVar.dwk = j.s(WA);
        String oV2 = bi.oV((String) WA.get(".msg.fromusername"));
        if (!bi.oW(oV2)) {
            str2 = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(oV2).BK();
            lVar.bZG = oV2;
            lVar.bZH = str2;
        }
        return lVar;
    }
}
