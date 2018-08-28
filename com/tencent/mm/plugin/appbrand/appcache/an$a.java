package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.protocal.c.byl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

final class an$a implements an$c {
    private an$a() {
    }

    /* synthetic */ an$a(byte b) {
        this();
    }

    public final void u(Map<String, String> map) {
        if (map.get(".sysmsg.mmbizwxaconfig") != null) {
            int i = bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
            int i2 = bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
            String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
            x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0)));
            LinkedList linkedList = new LinkedList();
            byl byl = new byl();
            byl.version = r1;
            byl.type = i2;
            linkedList.add(byl);
            m.a(str, linkedList, false);
            m.a(str, i2, i, new 1(this, str, i2), true);
        }
    }
}
