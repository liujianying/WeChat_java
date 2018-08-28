package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static int nxQ = 0;
    public static int nxR = 1;
    public String bVv;
    public String fvT;
    public String ntU;
    public int nxS;
    public long nxT;
    public long nxU;
    public int nxV;
    public String nxW;
    public String nxX;
    public String nxY;
    public String nxZ;
    public int nya;
    public String nyb;
    public String nyc;
    public String nyd;
    public int nye;
    public String nyf;
    public String nyg;
    public LinkedList<String> nyh;
    boolean nyi;
    public String nyj;
    public String nyk;
    public String nyl;
    public HashMap<String, String> nym;
    public a nyn;
    public b nyo;
    public String nyp;
    public String nyq;
    public String nyr;
    public boolean nys;
    public String nyt;
    public boolean nyu;

    public final boolean bzk() {
        return this.nxV == 4 && this.nyn != null;
    }

    public a() {
        this.bVv = "";
        this.ntU = "";
        this.nxV = 0;
        this.nxW = "";
        this.nxX = "";
        this.nxY = "";
        this.nxZ = "";
        this.nya = 0;
        this.nyb = "";
        this.nyc = "";
        this.nyd = "";
        this.nye = nxQ;
        this.nyf = "";
        this.nyg = "";
        this.nyh = new LinkedList();
        this.nyl = "";
        this.nyo = new b();
        this.nyp = "";
        this.nyq = "";
        this.nyr = "";
        this.nys = false;
        this.nyt = "";
        this.nyu = false;
    }

    public a(String str) {
        this.bVv = "";
        this.ntU = "";
        this.nxV = 0;
        this.nxW = "";
        this.nxX = "";
        this.nxY = "";
        this.nxZ = "";
        this.nya = 0;
        this.nyb = "";
        this.nyc = "";
        this.nyd = "";
        this.nye = nxQ;
        this.nyf = "";
        this.nyg = "";
        this.nyh = new LinkedList();
        this.nyl = "";
        this.nyo = new b();
        this.nyp = "";
        this.nyq = "";
        this.nyr = "";
        this.nys = false;
        this.nyt = "";
        this.nyu = false;
        this.nyi = false;
        MU(str);
    }

    private void MU(String str) {
        boolean z = true;
        if (!bi.oW(str)) {
            x.i("MicroMsg.ADInfo", "feed xml %s", new Object[]{str});
            Map z2 = bl.z(str, "ADInfo");
            if (z2 != null) {
                this.fvT = bi.aG((String) z2.get(".ADInfo.viewid"), "");
                if (z2.get(".ADInfo.ad_sns_pos") != null) {
                    String aG;
                    boolean z3;
                    this.nxS = bi.WU((String) z2.get(".ADInfo.ad_sns_pos"));
                    this.nxT = bi.WV((String) z2.get(".ADInfo.noExposureExpireTime"));
                    this.nxU = bi.WV((String) z2.get(".ADInfo.exposureNoActionExpireTime"));
                    this.ntU = bi.aG((String) z2.get(".ADInfo.uxInfo"), "");
                    this.nxV = bi.WU((String) z2.get(".ADInfo.adActionType"));
                    this.nxW = bi.aG((String) z2.get(".ADInfo.adActionCardTitle"), "");
                    this.nxX = bi.aG((String) z2.get(".ADInfo.adActionCardTpId"), "");
                    this.nxY = bi.aG((String) z2.get(".ADInfo.adActionCardExt"), "");
                    this.nxZ = bi.aG((String) z2.get(".ADInfo.adActionLink"), "");
                    this.nya = bi.WU((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
                    this.nyb = bi.aG((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
                    this.nyc = bi.aG((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
                    this.nyd = bi.aG((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
                    String aG2 = bi.aG((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
                    this.nye = bi.WU((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
                    this.nyg = bi.aG((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
                    if (this.nye == nxR) {
                        String aG3 = bi.aG((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
                        String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
                        this.nyh.clear();
                        int i = 0;
                        while (true) {
                            if (i == 0) {
                                aG = bi.aG((String) z2.get(str2), "");
                            } else {
                                aG = bi.aG((String) z2.get(str2 + i), "");
                            }
                            if (bi.oW(aG)) {
                                break;
                            }
                            this.nyh.add(aG);
                            i++;
                        }
                        z3 = aG3.indexOf("%s") >= 0;
                        i = aG3.indexOf("%");
                        int lastIndexOf = aG3.lastIndexOf("%");
                        if (!bi.oW(aG3) && z3 && i == lastIndexOf) {
                            this.nyf = aG3;
                        } else {
                            this.nyf = aG2;
                            this.nye = nxQ;
                        }
                    } else {
                        this.nyf = aG2;
                        this.nye = nxQ;
                    }
                    this.nyi = z2.containsKey(".ADInfo.adCanvasInfo");
                    this.nyk = (String) z2.get(".ADInfo.session_data.aid");
                    this.nyj = (String) z2.get(".ADInfo.session_data.trace_id");
                    this.nym = new HashMap();
                    aG2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
                    int i2 = 0;
                    while (true) {
                        String str3;
                        if (i2 == 0) {
                            str3 = aG2;
                        } else {
                            str3 = aG2 + i2;
                        }
                        aG = (String) z2.get(str3 + ".cardTpId");
                        str3 = (String) z2.get(str3 + ".cardExt");
                        if (bi.oW(aG)) {
                            break;
                        }
                        this.nym.put(aG, str3);
                        i2++;
                    }
                    Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
                    if (matcher.find()) {
                        aG = matcher.group();
                        if (!bi.oW(aG)) {
                            this.nyl = aG.replaceAll("</?adCanvasExt>", "");
                        }
                    }
                    aG = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
                    if (!TextUtils.isEmpty(aG)) {
                        this.nyn = new a();
                        this.nyn.bPg = aG;
                        this.nyn.bvk = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
                        this.nyn.bGH = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
                    }
                    this.nyo = new b(z2, ".ADInfo");
                    this.nyp = bi.aG((String) z2.get(".ADInfo.dislikeInfo.Title.zh"), "");
                    this.nyr = bi.aG((String) z2.get(".ADInfo.dislikeInfo.Title.tw"), "");
                    this.nyq = bi.aG((String) z2.get(".ADInfo.dislikeInfo.Title.en"), "");
                    if (bi.WU((String) z2.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.nys = z3;
                    this.nyt = bi.aG((String) z2.get(".ADInfo.adInfoSyncBuffer"), "");
                    if (bi.WU((String) z2.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
                        z = false;
                    }
                    this.nyu = z;
                }
            }
        }
    }
}
