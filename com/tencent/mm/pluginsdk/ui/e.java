package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    public int qER = -7829368;
    public boolean qES = false;
    public int qET = -1593835521;
    public boolean qEU = false;
    public boolean qEV = false;
    public int qEW = -16777216;
    public boolean qEX = false;
    public int qEY = 0;
    public boolean qEZ = false;
    private int version = 0;

    public e(String str) {
        String str2 = "chatbg";
        Map z = bl.z(str, str2);
        if (z == null) {
            x.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
            return;
        }
        String str3 = "." + str2;
        try {
            this.version = bi.f(Integer.valueOf((String) z.get(str3 + ".$version")));
            this.qER = (int) bi.a(Long.valueOf(Long.parseLong((String) z.get(str3 + ".$time_color"), 16)), -7829368);
            this.qES = bi.d(Boolean.valueOf((String) z.get(str3 + ".$time_show_shadow_color")));
            this.qET = (int) bi.a(Long.valueOf(Long.parseLong((String) z.get(str3 + ".$time_shadow_color"), 16)), 0);
            this.qEU = bi.d(Boolean.valueOf((String) z.get(str3 + ".$time_show_background")));
            this.qEV = bi.d(Boolean.valueOf((String) z.get(str3 + ".$time_light_background")));
            this.qEW = (int) bi.a(Long.valueOf(Long.parseLong((String) z.get(str3 + ".$voice_second_color"), 16)), -16777216);
            this.qEX = bi.d(Boolean.valueOf((String) z.get(str3 + ".$voice_second_show_shadow_color")));
            this.qEY = (int) bi.a(Long.valueOf(Long.parseLong((String) z.get(str3 + ".$voice_second_shadow_color"), 16)), 0);
            this.qEZ = bi.d(Boolean.valueOf((String) z.get(str3 + ".$voice_second_show_background")));
        } catch (Throwable e) {
            x.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            x.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
        }
    }
}
