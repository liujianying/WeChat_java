package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public class a extends d {
    public boolean dvC;
    public String dvD;
    public int dvE;
    public boolean dvF;
    public String dvG;
    public String dvH;
    public String dvI;
    public String dvJ;
    public String dvK;
    public int dvL;
    public int dvM;

    public final d FD() {
        a aVar = new a();
        aVar.dvC = this.dvC;
        aVar.dvD = this.dvD;
        aVar.dvE = this.dvE;
        aVar.dvF = this.dvF;
        aVar.dvG = this.dvG;
        aVar.dvH = this.dvH;
        aVar.dvI = this.dvI;
        aVar.dvJ = this.dvJ;
        aVar.dvK = this.dvK;
        aVar.dvL = this.dvL;
        aVar.dvM = this.dvM;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, g$a g_a, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        stringBuilder.append("<weappinfo>");
        if (!bi.oW(g_a.dyR)) {
            stringBuilder.append("<pagepath>" + g$a.gq(g_a.dyR) + "</pagepath>");
        }
        stringBuilder.append("<username>" + bi.WS(g_a.dyS) + "</username>");
        stringBuilder.append("<appid>" + bi.WS(g_a.dyT) + "</appid>");
        if (g_a.dza != 0) {
            stringBuilder.append("<version>" + g_a.dza + "</version>");
        }
        if (g_a.dyU != 0) {
            stringBuilder.append("<type>" + g_a.dyU + "</type>");
        }
        if (!bi.oW(g_a.dzb)) {
            stringBuilder.append("<weappiconurl>" + g$a.gq(g_a.dzb) + "</weappiconurl>");
        }
        if (!bi.oW(g_a.dyX)) {
            stringBuilder.append("<shareId>" + g$a.gq(g_a.dyX) + "</shareId>");
        }
        if (g_a.dyZ == 1 || g_a.dyZ == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(g_a.dyZ);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(g_a.dyV);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!bi.oW(g_a.dyY)) {
            stringBuilder.append("<sharekey>" + g$a.gq(g_a.dyY) + "</sharekey>");
        }
        if (this.dvC) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(g$a.gq(this.dvD));
            stringBuilder.append("</cacheKey>");
            stringBuilder.append("</wadynamicpageinfo>");
        }
        if (this.dvF) {
            stringBuilder.append("<waupdatablemsginfo>");
            stringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
            stringBuilder.append("<updatablemsgperiod>");
            stringBuilder.append(this.dvL);
            stringBuilder.append("</updatablemsgperiod>");
            stringBuilder.append("<updatablemsgstate>");
            stringBuilder.append(this.dvM);
            stringBuilder.append("</updatablemsgstate>");
            stringBuilder.append("<updatablemsgcontent>");
            stringBuilder.append(g$a.gq(this.dvG));
            stringBuilder.append("</updatablemsgcontent>");
            stringBuilder.append("<updatablemsgcontentcolor>");
            stringBuilder.append(g$a.gq(this.dvH));
            stringBuilder.append("</updatablemsgcontentcolor>");
            stringBuilder.append("<subscribeentrycontent>");
            stringBuilder.append(g$a.gq(this.dvI));
            stringBuilder.append("</subscribeentrycontent>");
            stringBuilder.append("<subscribeentrybuttonwording>");
            stringBuilder.append(g$a.gq(this.dvJ));
            stringBuilder.append("</subscribeentrybuttonwording>");
            stringBuilder.append("<subscribeconfirmedcontent>");
            stringBuilder.append(g$a.gq(this.dvK));
            stringBuilder.append("</subscribeconfirmedcontent>");
            stringBuilder.append("</waupdatablemsginfo>");
        }
        stringBuilder.append("<appservicetype>" + this.dvE + "</appservicetype>");
        stringBuilder.append("</weappinfo>");
    }

    public final void a(Map<String, String> map, g$a g_a) {
        boolean z = false;
        this.dvC = bi.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1;
        this.dvD = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.dvE = bi.getInt((String) map.get(".msg.appmsg.weappinfo.appservicetype"), this.dvE);
        if (bi.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.shoulduseupdatablemsg"), 0) == 1) {
            z = true;
        }
        this.dvF = z;
        this.dvG = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.updatablemsgcontent");
        this.dvH = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.updatablemsgcontentcolor");
        this.dvI = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.subscribeentrycontent");
        this.dvJ = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.subscribeentrybuttonwording");
        this.dvK = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.subscribeconfirmedcontent");
        this.dvM = bi.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.updatablemsgstate"), 1);
        this.dvL = bi.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfo.updatablemsgperiod"), 10);
    }
}
