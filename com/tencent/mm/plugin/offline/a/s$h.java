package com.tencent.mm.plugin.offline.a;

import java.util.Map;

public class s$h {
    public String ced;
    public String cee;
    public String cef;
    public String ceg;
    public String ceh;
    public boolean lKP;
    final /* synthetic */ s lKz;

    public s$h(s sVar, Map<String, String> map) {
        this.lKz = sVar;
        this.ced = (String) map.get(".sysmsg.paymsg.guide_flag");
        this.cee = (String) map.get(".sysmsg.paymsg.guide_wording");
        this.cef = (String) map.get(".sysmsg.paymsg.left_button_wording");
        this.ceg = (String) map.get(".sysmsg.paymsg.right_button_wording");
        this.ceh = (String) map.get(".sysmsg.paymsg.upload_credit_url");
        this.lKP = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
    }
}
