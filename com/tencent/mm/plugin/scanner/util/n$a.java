package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;
import java.util.Map;

public class n$a {
    public String field_certification;
    public String field_certificationurl;
    public String field_detailurl;
    public String field_exposeurl;
    public String field_extinfo;
    public String field_feedbackurl;
    public int field_functionType;
    public int field_getaction;
    public String field_headerbackgroundurl;
    public String field_headermask;
    public String field_introlink;
    public String field_introtitle;
    public String field_playurl;
    public String field_productid;
    public String field_shareurl;
    public String field_source;
    public String field_subtitle;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    public String field_xml;
    public int field_xmlType;
    public LinkedList<com.tencent.mm.plugin.scanner.a.a> mNX;
    public a mNY;

    public static class a {
        public LinkedList<a> mNZ;
        public LinkedList<b> mOa;
    }

    public final void o(Map<String, String> map, String str) {
        if (map != null) {
            String str2;
            this.mNY = new a();
            this.mNY.mNZ = new LinkedList();
            String str3 = str + ".bannerlist.banner";
            int i = 0;
            while (i < TbsLog.TBSLOG_CODE_SDK_BASE) {
                str2 = (String) map.get((str3 + (i > 0 ? Integer.valueOf(i) : "")) + ".link");
                if (bi.oW(str2)) {
                    break;
                }
                a aVar = new a();
                aVar.egr = str2;
                this.mNY.mNZ.add(aVar);
                i++;
            }
            this.mNY.mOa = new LinkedList();
            str3 = str + ".detaillist.detail";
            i = 0;
            while (i < TbsLog.TBSLOG_CODE_SDK_BASE) {
                String str4 = str3 + (i > 0 ? Integer.valueOf(i) : "");
                str2 = (String) map.get(str4 + ".title");
                str4 = (String) map.get(str4 + ".desc");
                if (!bi.oW(str2) || !bi.oW(str4)) {
                    b bVar = new b();
                    bVar.title = str2;
                    bVar.desc = str4;
                    this.mNY.mOa.add(bVar);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
