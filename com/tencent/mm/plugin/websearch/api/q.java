package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.d;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class q extends d {
    public String bhd;
    public String ixy;
    public String ixz;
    public String lRt;
    public String nzH;
    public String pLA;
    public String pLB;
    public String pLC;
    public String pLr;
    public String pLs;
    public String pLt;
    public String pLu;
    public long pLv;
    public String pLw;
    public String pLx;
    public String pLy;
    public String pLz;

    public final /* synthetic */ d FD() {
        q qVar = new q();
        qVar.pLr = this.pLr;
        qVar.pLs = this.pLs;
        qVar.pLt = this.pLt;
        qVar.pLu = this.pLu;
        qVar.pLv = this.pLv;
        qVar.ixy = this.ixy;
        qVar.ixz = this.ixz;
        qVar.nzH = this.nzH;
        qVar.pLw = this.pLw;
        qVar.pLx = this.pLx;
        qVar.pLy = this.pLy;
        qVar.bhd = this.bhd;
        qVar.lRt = this.lRt;
        qVar.pLz = this.pLz;
        qVar.pLA = this.pLA;
        qVar.pLB = this.pLB;
        qVar.pLC = this.pLC;
        return qVar;
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        stringBuilder.append("<websearch>");
        if (!bi.oW(this.pLr)) {
            stringBuilder.append("<relevant_vid>");
            stringBuilder.append(a.gq(this.pLr));
            stringBuilder.append("</relevant_vid>");
        }
        if (!bi.oW(this.pLs)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(a.gq(this.pLs));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bi.oW(this.pLs)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(a.gq(this.pLs));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bi.oW(this.pLt)) {
            stringBuilder.append("<relevant_pre_searchid>");
            stringBuilder.append(a.gq(this.pLt));
            stringBuilder.append("</relevant_pre_searchid>");
        }
        if (!bi.oW(this.pLu)) {
            stringBuilder.append("<relevant_shared_openid>");
            stringBuilder.append(a.gq(this.pLu));
            stringBuilder.append("</relevant_shared_openid>");
        }
        if (this.pLv >= 0) {
            stringBuilder.append("<rec_category>");
            stringBuilder.append(this.pLv);
            stringBuilder.append("</rec_category>");
        }
        if (!bi.oW(this.ixy)) {
            stringBuilder.append("<shareUrl>");
            stringBuilder.append(a.gq(this.ixy));
            stringBuilder.append("</shareUrl>");
        }
        if (!bi.oW(this.ixz)) {
            stringBuilder.append("<shareTitle>");
            stringBuilder.append(a.gq(this.ixz));
            stringBuilder.append("</shareTitle>");
        }
        if (!bi.oW(this.nzH)) {
            stringBuilder.append("<shareDesc>");
            stringBuilder.append(a.gq(this.nzH));
            stringBuilder.append("</shareDesc>");
        }
        if (!bi.oW(this.pLw)) {
            stringBuilder.append("<shareImgUrl>");
            stringBuilder.append(a.gq(this.pLw));
            stringBuilder.append("</shareImgUrl>");
        }
        if (!bi.oW(this.pLx)) {
            stringBuilder.append("<shareString>");
            stringBuilder.append(a.gq(this.pLx));
            stringBuilder.append("</shareString>");
        }
        if (!bi.oW(this.pLy)) {
            stringBuilder.append("<shareStringUrl>");
            stringBuilder.append(a.gq(this.pLy));
            stringBuilder.append("</shareStringUrl>");
        }
        if (!bi.oW(this.bhd)) {
            stringBuilder.append("<source>");
            stringBuilder.append(a.gq(this.bhd));
            stringBuilder.append("</source>");
        }
        if (!bi.oW(this.lRt)) {
            stringBuilder.append("<sourceUrl>");
            stringBuilder.append(a.gq(this.lRt));
            stringBuilder.append("</sourceUrl>");
        }
        if (!bi.oW(this.pLz)) {
            stringBuilder.append("<strPlayCount>");
            stringBuilder.append(a.gq(this.pLz));
            stringBuilder.append("</strPlayCount>");
        }
        if (!bi.oW(this.pLA)) {
            stringBuilder.append("<titleUrl>");
            stringBuilder.append(a.gq(this.pLA));
            stringBuilder.append("</titleUrl>");
        }
        if (!bi.oW(this.pLB)) {
            stringBuilder.append("<extReqParams>");
            stringBuilder.append(a.gq(this.pLB));
            stringBuilder.append("</extReqParams>");
        }
        if (!bi.oW(this.pLC)) {
            stringBuilder.append("<tagList>");
            stringBuilder.append(a.gq(this.pLC));
            stringBuilder.append("</tagList>");
        }
        stringBuilder.append("</websearch>");
    }

    public final void a(Map<String, String> map, a aVar) {
        this.pLr = (String) map.get(".msg.appmsg.websearch.relevant_vid");
        this.pLs = (String) map.get(".msg.appmsg.websearch.relevant_expand");
        this.pLt = (String) map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.pLu = (String) map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.pLv = (long) bi.getInt((String) map.get(".msg.appmsg.websearch.rec_category"), -1);
        this.ixy = (String) map.get(".msg.appmsg.websearch.shareUrl");
        this.ixz = (String) map.get(".msg.appmsg.websearch.shareTitle");
        this.nzH = (String) map.get(".msg.appmsg.websearch.shareDesc");
        this.pLw = (String) map.get(".msg.appmsg.websearch.shareImgUrl");
        this.pLx = (String) map.get(".msg.appmsg.websearch.shareString");
        this.pLy = (String) map.get(".msg.appmsg.websearch.shareStringUrl");
        this.bhd = (String) map.get(".msg.appmsg.websearch.source");
        this.lRt = (String) map.get(".msg.appmsg.websearch.sourceUrl");
        this.pLz = (String) map.get(".msg.appmsg.websearch.strPlayCount");
        this.pLA = (String) map.get(".msg.appmsg.websearch.titleUrl");
        this.pLB = (String) map.get(".msg.appmsg.websearch.extReqParams");
        this.pLC = (String) map.get(".msg.appmsg.websearch.tagList");
    }
}
