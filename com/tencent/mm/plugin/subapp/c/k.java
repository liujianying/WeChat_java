package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.g;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends i<g> {
    public static final String[] diD = new String[]{i.a(g.dhO, "VoiceRemindInfo")};
    private static long enX = 0;
    e diF;
    Map<String, c> orF = new HashMap();

    public k(e eVar) {
        super(eVar, g.dhO, "VoiceRemindInfo", eg.ciG);
        this.diF = eVar;
    }

    public static String nJ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.u(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = enX;
        enX = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public final boolean jy(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.diF.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            x.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final void ol(String str) {
        c cVar = (c) this.orF.get(str);
        if (cVar != null) {
            cVar.Tz();
            this.orF.remove(str);
        }
    }
}
