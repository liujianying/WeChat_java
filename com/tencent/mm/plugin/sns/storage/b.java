package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    public String bVv = "";
    public int egL;
    public String nickname;
    public String nxZ;
    public String nyD;
    public int nyE = 0;
    public int nyF = 0;
    public String nyG = "";
    public String nyH = "";
    public String nyI = "";
    public String nyJ = "";
    public String nyK = "";
    public int nyL = 0;
    public String nyM = "";
    public String nyN = "";
    public int nyO = 0;
    public String nyP = "";
    public int nyQ = 0;
    public String nyR = "";
    public String nyS = "";
    public String nyT = "";
    public String nyU = "";
    public String nyV = "";
    public String nyW = "";
    public int nyX;
    public int nyY;
    public int nyZ;
    boolean nyi;
    public long nza;
    public Map<String, String> nzb = new HashMap();
    boolean nzc;
    public int nzd;
    public int nze;
    public float nzf;
    public float nzg;
    public int nzh;
    public int nzi;
    public int nzj;
    public String nzk;
    public float nzl;
    public float nzm;
    public float nzn;
    public float nzo;
    public int nzp;
    public String nzq;
    public String nzr;
    public String nzs;
    public String nzt;
    public List<String> nzu = new ArrayList();
    public d nzv;
    public a nzw;
    private c nzx;
    public e nzy;

    public b(String str) {
        if (bi.oW(str) || !str.trim().startsWith("<RecXml")) {
            ac(str, "", "adxml");
            return;
        }
        Map ac = ac(str, ".RecXml", "RecXml");
        if (ac != null && !ac.isEmpty()) {
            this.nyX = bi.WU((String) ac.get(".RecXml.$type"));
            this.nyY = bi.WU((String) ac.get(".RecXml.$source"));
            this.nyZ = bi.WU((String) ac.get(".RecXml.$expId"));
            this.nza = i.LP((String) ac.get(".RecXml.$expOriginSnsId"));
        }
    }

    private Map<String, String> ac(String str, String str2, String str3) {
        int i = 0;
        if (bi.oW(str) || bi.oW(str3)) {
            return null;
        }
        this.bVv = str;
        x.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[]{str, str2, str3});
        Map<String, String> z = f.z(str, str3);
        if (z == null) {
            return null;
        }
        String str4;
        String str5;
        this.egL = bi.WU((String) z.get(str2 + ".adxml.adType"));
        this.nyD = bi.aG((String) z.get(str2 + ".adxml.adActionTitle"), "");
        this.nxZ = bi.aG((String) z.get(str2 + ".adxml.adActionLink"), "");
        this.nickname = bi.aG((String) z.get(str2 + ".adxml.nickname"), "");
        this.nyE = bi.WU((String) z.get(str2 + ".adxml.webviewRightBarShow"));
        this.nyF = bi.WU((String) z.get(str2 + ".adxml.adActionLinkHidden"));
        this.nyG = bi.aG((String) z.get(str2 + ".adxml.adActionLinkName"), "");
        this.nyH = bi.aG((String) z.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.nyI = bi.aG((String) z.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.nyK = bi.aG((String) z.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.nyJ = bi.aG((String) z.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.nyM = bi.aG((String) z.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.nyN = bi.aG((String) z.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.nyL = bi.WU((String) z.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (bi.oW(this.nyM) || bi.oW(this.nyN)) {
            this.nyL = 1;
        }
        this.nyR = bi.aG((String) z.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.nyT = bi.aG((String) z.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.nyS = bi.aG((String) z.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.nyU = bi.aG((String) z.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.nyW = bi.aG((String) z.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.nyV = bi.aG((String) z.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.nyO = bi.WU((String) z.get(str2 + ".adxml.headClickType"));
        this.nyP = bi.aG((String) z.get(str2 + ".adxml.headClickParam"), "");
        this.nyQ = bi.WU((String) z.get(str2 + ".adxml.headClickRightBarShow"));
        int i2 = 0;
        while (true) {
            String str6 = str2 + ".adxml.adArgs.arg" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".key";
            String str7 = (String) z.get(str6);
            if (str7 == null) {
                break;
            }
            String str8 = str2 + ".adxml.adArgs.arg" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".value";
            str4 = (String) z.get(str8);
            x.i("MicroMsg.ADXml", "newKey " + str6 + " " + str7 + " newValue : " + str8 + " " + str4);
            this.nzb.put(str7, str4);
            i2++;
        }
        this.nyi = z.containsKey(str2 + ".adxml.adCanvasInfo");
        this.nzd = bi.WU((String) z.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.nze = bi.WU((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.nzf = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.nzg = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.nzj = bi.WU((String) z.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.nzk = bi.aG((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.nzh = bi.WU((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.nzi = bi.WU((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.nzl = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.nzm = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.nzn = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.nzo = (float) bi.WW((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.nzp = bi.WU((String) z.get(str2 + ".adxml.adContentStyle"));
        this.nzq = bi.aG((String) z.get(str2 + ".adxml.adCardInfo.title"), "");
        this.nzr = bi.aG((String) z.get(str2 + ".adxml.adCardInfo.description"), "");
        int i3 = 0;
        while (true) {
            str5 = str2 + ".adxml.adCardInfo.adRatingCardInfo.tagList.tag" + (i3 == 0 ? "" : Integer.valueOf(i3));
            if (!z.containsKey(str5)) {
                break;
            }
            x.i("MicroMsg.ADXml", "card ad tag %s", new Object[]{z.get(str5)});
            if (!bi.oW((String) z.get(str5))) {
                this.nzu.add(z.get(str5));
            }
            i3++;
        }
        this.nzs = bi.oV((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
        this.nzt = bi.oV((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
        Object aG = bi.aG((String) z.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        Object aG2 = bi.aG((String) z.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(aG) || TextUtils.isEmpty(aG2))) {
            this.nzx = new c(this);
            this.nzx.nzB = aG;
            this.nzx.nzC = aG2;
        }
        aG2 = bi.aG((String) z.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(aG2)) {
            this.nzy = new e(this);
            this.nzy.nzF = aG2;
            str5 = str2 + ".adxml.adVoteInfo.optionList.option";
            while (true) {
                if (i != 0) {
                    str4 = str5 + i;
                } else {
                    str4 = str5;
                }
                if (TextUtils.isEmpty(bi.aG((String) z.get(str4 + ".title"), ""))) {
                    break;
                }
                f fVar = new f(this);
                fVar.title = bi.aG((String) z.get(str4 + ".title"), "");
                fVar.ixz = bi.aG((String) z.get(str4 + ".shareTitle"), "");
                fVar.nzH = bi.aG((String) z.get(str4 + ".shareDesc"), "");
                fVar.nzI = bi.aG((String) z.get(str4 + ".shareThumb"), "");
                fVar.nzJ = bi.aG((String) z.get(str4 + ".selectedTitle"), "");
                this.nzy.nzG.add(fVar);
                i++;
            }
        }
        this.nzc = z.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.nzv = new d();
        this.nzv.s(z, str2);
        this.nzw = new a().r(z, str2);
        return z;
    }

    public final boolean bzm() {
        return this.nyi || this.nzc;
    }

    public final String bzn() {
        if (bzs()) {
            return this.nzx.nzB;
        }
        if (bzt()) {
            return ((f) this.nzy.nzG.get(0)).title;
        }
        return "";
    }

    public final String bzo() {
        if (bzs()) {
            return this.nzx.nzC;
        }
        if (bzt()) {
            return ((f) this.nzy.nzG.get(1)).title;
        }
        return "";
    }

    public final String bzp() {
        if (bzt()) {
            return this.nzy.nzF;
        }
        return "";
    }

    public final boolean bzq() {
        return this.nzp == 2;
    }

    public final boolean bzr() {
        return this.nzp == 1;
    }

    public final boolean bzs() {
        return this.nzx != null;
    }

    public final boolean bzt() {
        return this.nzy != null && this.nzy.nzG.size() > 1;
    }

    public final String bzu() {
        String str = this.bVv;
        if (str.contains("<adCanvasInfoLeft>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        return str;
    }

    public final String bzv() {
        String str = this.bVv;
        if (str.contains("<adCanvasInfoRight>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        return str;
    }

    public final String bzw() {
        String str = this.bVv;
        if (str.contains("<adTurnCanvasInfo>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        return str;
    }

    public final boolean bzx() {
        return this.nyY == 2;
    }
}
