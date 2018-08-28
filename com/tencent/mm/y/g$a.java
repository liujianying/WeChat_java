package com.tencent.mm.y;

import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.by.c;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class g$a extends d {
    private static final f<Integer, g$a> dzj = new f(100);
    public String action;
    public String appId;
    public String appName;
    public String bGP;
    public String bJg;
    public String bRw;
    public String bSS;
    public int bYg;
    public String bZG;
    public String bZH;
    public String bZJ;
    public String bZK;
    public String bZL;
    public String bZM;
    public String bZN;
    public String cGB;
    public String canvasPageXml = "";
    public int cbu;
    public String content;
    public String desc;
    public String description;
    public String designerName;
    public String designerRediretctUrl;
    public String dwA;
    public String dwB;
    public String dwC;
    public String dwD;
    public String dwE;
    public int dwF;
    public int dwG;
    public int dwH;
    public int dwI;
    public int dwJ;
    public String dwK;
    public String dwL;
    public int dwM;
    public String dwN;
    public String dwO;
    public int dwP;
    public int dwQ;
    public int dwR;
    public String dwS;
    public String dwT;
    public int dwU;
    public String dwV;
    public String dwW;
    public int dwX;
    public String dwY;
    public String dwZ;
    public a dwl;
    public Map<String, String> dwm;
    public String dwn;
    public int dwo;
    public String dwp;
    public String dwq;
    public int dwr;
    public int dws;
    public int dwt;
    public String dwu;
    public String dwv;
    public int dww;
    public int dwx;
    public int dwy;
    public String dwz;
    public String dxA;
    public String dxB;
    public int dxC;
    public int dxD;
    public String dxE;
    public String dxF;
    public int dxG;
    public int dxH;
    public int dxI;
    public String dxJ;
    public String dxK;
    public String dxL;
    public String dxM;
    public String dxN;
    public String dxO;
    public String dxP;
    public int dxQ;
    public String dxR;
    public String dxS;
    public String dxT;
    public String dxU;
    public String dxV;
    public String dxW;
    public String dxX;
    public String dxY;
    public String dxZ;
    public int dxa;
    public String dxb;
    public String dxc;
    public String dxd;
    public String dxe;
    public String dxf;
    public String dxg;
    public String dxh;
    public String dxi;
    public String dxj;
    public String dxk;
    public String dxl;
    public String dxm;
    public String dxn;
    public String dxo;
    public String dxp;
    public int dxq;
    public int dxr;
    public int dxs;
    public String dxt;
    public String dxu;
    public String dxv;
    public String dxw;
    public String dxx;
    public int dxy;
    public String dxz;
    public String dyA;
    public String dyB;
    public String dyC;
    public String dyD;
    public String dyE;
    public String dyF;
    public int dyG;
    public String dyH;
    public String dyI;
    public String dyJ;
    public int dyK = 0;
    public String dyL = "";
    public String dyM = "";
    public String dyN = "";
    public String dyO = "";
    public String dyP = "";
    public String dyQ = "";
    public String dyR;
    public String dyS;
    public String dyT;
    public int dyU;
    public String dyV;
    public int dyW;
    public String dyX;
    public String dyY;
    public int dyZ;
    public String dya;
    public String dyb;
    public String dyc;
    public int dyd;
    public String dye;
    public String dyf;
    public String dyg;
    public int dyh;
    public boolean dyi = false;
    public int dyj = 0;
    public String dyk;
    public int dyl;
    public String dym;
    public String dyn;
    public String dyo;
    public List<String> dyp;
    public String dyq;
    public List<String> dyr;
    public String dys;
    public int dyt;
    public String dyu;
    public String dyv;
    public String dyw;
    public String dyx;
    public String dyy;
    public String dyz;
    public int dza;
    public String dzb;
    public String dzc = null;
    public int dzd = 0;
    private final HashMap<Class<? extends d>, d> dze = new HashMap();
    public Map<String, String> dzf;
    private String dzg;
    private String dzh;
    private String dzi;
    public String extInfo;
    public String filemd5;
    public String iconUrl;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int pageType;
    public int sdkVer;
    public String secondUrl;
    public int showType;
    public String thumburl;
    public int tid;
    public String title;
    public int type;
    public String url;
    public String username;

    public final <T extends d> T u(Class<T> cls) {
        return (d) this.dze.get(cls);
    }

    public final void a(d dVar) {
        if (dVar == null) {
            x.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
            return;
        }
        dVar.dwj = this;
        this.dze.put(dVar.getClass(), dVar);
    }

    public static final g$a go(String str) {
        if (bi.oW(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = ("parseImg_" + str).hashCode();
        g$a g_a = (g$a) dzj.get(Integer.valueOf(hashCode));
        if (g_a != null) {
            return g_a;
        }
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.e("MicroMsg.AppMessage", "parseImg failed");
            return null;
        }
        g$a g_a2 = new g$a();
        g_a2.type = 2;
        g_a2.appId = (String) z.get(".msg.appinfo.appid");
        g_a2.cbu = bi.getInt((String) z.get(".msg.appinfo.version"), 0);
        g_a2.appName = (String) z.get(".msg.appinfo.appname");
        g_a2.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
        g_a2.messageExt = (String) z.get(".msg.appinfo.messageext");
        g_a2.messageAction = (String) z.get(".msg.appinfo.messageaction");
        dzj.m(Integer.valueOf(hashCode), g_a2);
        return g_a2;
    }

    public static final g$a gp(String str) {
        return J(str, null);
    }

    public static final g$a J(String str, String str2) {
        if (bi.oW(str)) {
            return null;
        }
        String substring;
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            substring = str.substring(indexOf);
        } else {
            substring = str;
        }
        int hashCode = substring.hashCode();
        g$a g_a = (g$a) dzj.get(Integer.valueOf(hashCode));
        if (g_a != null) {
            return g_a;
        }
        Map map;
        Map z;
        long currentTimeMillis = System.currentTimeMillis();
        if (bi.oW(str2)) {
            map = null;
        } else {
            map = ay.WA(str2);
        }
        if (map == null) {
            z = bl.z(substring, "msg");
        } else {
            z = map;
        }
        if (z == null) {
            x.e("MicroMsg.AppMessage", "parse msg failed");
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        g$a g_a2 = new g$a();
        g_a2.dzf = z;
        g_a2.dzg = str;
        g_a2.dzh = substring;
        g_a2.dzi = str2;
        try {
            d dVar;
            g_a2.a(z, g_a2);
            Iterator it = b.FG().iterator();
            while (it.hasNext()) {
                dVar = (d) ((c) it.next()).get();
                dVar.a(z, g_a2);
                g_a2.a(dVar);
            }
            dVar = b.gQ(g_a2.type);
            if (dVar != null) {
                dVar.a(z, g_a2);
                g_a2.a(dVar);
            }
            dzj.m(Integer.valueOf(hashCode), g_a2);
            x.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bi.oV(str2).hashCode())});
            return g_a2;
        } catch (Throwable e) {
            x.e("MicroMsg.AppMessage", "parse amessage xml failed");
            x.e("MicroMsg.AppMessage", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public static String a(g$a g_a, String str, keep_SceneResult keep_sceneresult) {
        x.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[]{bi.Xf(g_a.dwK), g_a.filemd5});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msg>");
        if (g_a.dwJ == 0 || g_a.dwI == 0) {
            x.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
            stringBuilder.append(a(g_a, str, keep_sceneresult, 0, 0));
        } else {
            x.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[]{Integer.valueOf(g_a.dwJ), Integer.valueOf(g_a.dwI)});
            stringBuilder.append(a(g_a, str, keep_sceneresult, g_a.dwJ, g_a.dwI));
        }
        stringBuilder.append("</msg>");
        dzj.m(Integer.valueOf(stringBuilder.toString().hashCode()), g_a);
        return stringBuilder.toString();
    }

    public static String a(g$a g_a, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<appmsg appid=\"" + bi.WS(g_a.appId) + "\" sdkver=\"" + g_a.sdkVer + "\">");
        g_a.a(stringBuilder, g_a, str, keep_sceneresult, i, i2);
        d gQ = b.gQ(g_a.type);
        if (gQ != null) {
            gQ.a(stringBuilder, g_a, str, keep_sceneresult, i, i2);
        }
        stringBuilder.append("</appmsg>");
        if (2 == g_a.showType) {
            stringBuilder.append("<ShakePageResult>").append(g_a.dwC).append("</ShakePageResult>");
        }
        x.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static g$a a(g$a g_a) {
        if (g_a == null) {
            return new g$a();
        }
        return g_a.FF();
    }

    public final void a(Map<String, String> map, g$a g_a) {
        try {
            this.dwm = map;
            this.appId = (String) map.get(".msg.appmsg.$appid");
            this.sdkVer = bi.getInt((String) map.get(".msg.appmsg.$sdkver"), 0);
            this.title = bi.WB((String) map.get(".msg.appmsg.title"));
            this.description = (String) map.get(".msg.appmsg.des");
            this.username = (String) map.get(".msg.appmsg.username");
            this.action = (String) map.get(".msg.appmsg.action");
            this.type = bi.getInt((String) map.get(".msg.appmsg.type"), 0);
            this.content = (String) map.get(".msg.appmsg.content");
            this.url = (String) map.get(".msg.appmsg.url");
            this.dwn = (String) map.get(".msg.appmsg.lowurl");
            this.dwu = (String) map.get(".msg.appmsg.appattach.tpurl");
            this.dwv = (String) map.get(".msg.appmsg.appattach.tpthumburl");
            this.dww = bi.getInt((String) map.get(".msg.appmsg.appattach.tpthumblength"), 0);
            this.dwx = bi.getInt((String) map.get(".msg.appmsg.appattach.tpthumbheight"), 0);
            this.dwy = bi.getInt((String) map.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
            this.dwz = (String) map.get(".msg.appmsg.appattach.tpthumbmd5");
            this.dwA = (String) map.get(".msg.appmsg.appattach.tpauthkey");
            this.dwB = (String) map.get(".msg.appmsg.appattach.tpthumbaeskey");
            this.dwN = (String) map.get(".msg.appmsg.dataurl");
            this.dwO = (String) map.get(".msg.appmsg.lowdataurl");
            this.dwo = bi.getInt((String) map.get(".msg.appmsg.appattach.totallen"), 0);
            this.bGP = (String) map.get(".msg.appmsg.appattach.attachid");
            if (!bi.oW(this.dwu)) {
                this.bGP = this.dwu;
            }
            this.dwp = bi.WB((String) map.get(".msg.appmsg.appattach.fileext"));
            this.dwq = (String) map.get(".msg.appmsg.appattach.emoticonmd5");
            this.extInfo = (String) map.get(".msg.appmsg.extinfo");
            this.dwr = bi.getInt((String) map.get(".msg.appmsg.androidsource"), 0);
            this.bZG = (String) map.get(".msg.appmsg.sourceusername");
            this.bZH = (String) map.get(".msg.appmsg.sourcedisplayname");
            this.cGB = (String) map.get(".msg.commenturl");
            this.thumburl = (String) map.get(".msg.appmsg.thumburl");
            this.mediaTagName = (String) map.get(".msg.appmsg.mediatagname");
            this.messageAction = (String) map.get(".msg.appmsg.messageaction");
            this.messageExt = (String) map.get(".msg.appmsg.messageext");
            this.cbu = bi.getInt((String) map.get(".msg.appinfo.version"), 0);
            this.appName = (String) map.get(".msg.appinfo.appname");
            this.bSS = (String) map.get(".msg.fromusername");
            this.dwD = (String) map.get(".msg.appmsg.appattach.cdnattachurl");
            this.dwE = (String) map.get(".msg.appmsg.appattach.cdnthumburl");
            this.dwF = bi.getInt((String) map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
            this.dwG = bi.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
            this.dwH = bi.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
            this.dwI = bi.getInt((String) map.get(".msg.appmsg.appattach.thumbheight"), 0);
            this.dwJ = bi.getInt((String) map.get(".msg.appmsg.appattach.thumbwidth"), 0);
            this.dwK = (String) map.get(".msg.appmsg.appattach.aeskey");
            this.dwM = bi.getInt((String) map.get(".msg.appmsg.appattach.encryver"), 1);
            this.dwL = (String) map.get(".msg.appmsg.appattach.cdnthumbaeskey");
            this.dws = bi.getInt((String) map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
            if (this.dws == 0 && this.dwo > 26214400) {
                this.dws = 1;
                x.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[]{Integer.valueOf(this.dwo)});
            }
            this.dwR = bi.getInt((String) map.get(".msg.appmsg.productitem.$type"), 0);
            this.dwS = (String) map.get(".msg.appmsg.productitem.productinfo");
            this.dwU = bi.getInt((String) map.get(".msg.appmsg.emoticongift.packageflag"), 0);
            this.dwT = (String) map.get(".msg.appmsg.emoticongift.packageid");
            this.dwZ = (String) map.get(".msg.appmsg.emoticonshared.packageid");
            this.dxa = bi.getInt((String) map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
            this.dwV = (String) map.get(".msg.appmsg.tvinfo");
            this.dwW = (String) map.get(".msg.appmsg.recorditem");
            this.bZJ = (String) map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
            this.bZK = (String) map.get(".msg.appmsg.webviewshared.shareUrlOpen");
            this.bZL = (String) map.get(".msg.appmsg.webviewshared.jsAppId");
            this.bZM = (String) map.get(".msg.appmsg.webviewshared.publisherId");
            this.dyG = o.cx((String) map.get(".msg.appmsg.designershared.designeruin"));
            this.designerName = (String) map.get(".msg.appmsg.designershared.designername");
            this.designerRediretctUrl = (String) map.get(".msg.appmsg.designershared.designerrediretcturl");
            this.tid = bi.WU((String) map.get(".msg.appmsg.emotionpageshared.tid"));
            this.dyH = (String) map.get(".msg.appmsg.emotionpageshared.title");
            this.desc = (String) map.get(".msg.appmsg.emotionpageshared.desc");
            this.iconUrl = (String) map.get(".msg.appmsg.emotionpageshared.iconUrl");
            this.secondUrl = bi.aG((String) map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
            this.pageType = bi.WU((String) map.get(".msg.appmsg.emotionpageshared.pageType"));
            this.dyJ = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
            this.dyK = bi.WU((String) map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
            this.dyL = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
            this.dyM = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
            this.dyN = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
            this.dyO = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
            this.dyP = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
            this.dyQ = bi.aG((String) map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
            this.canvasPageXml = bi.aG((String) map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
            this.dyS = (String) map.get(".msg.appmsg.weappinfo.username");
            this.dyR = (String) map.get(".msg.appmsg.weappinfo.pagepath");
            this.dyT = (String) map.get(".msg.appmsg.weappinfo.appid");
            this.dza = bi.getInt((String) map.get(".msg.appmsg.weappinfo.version"), 0);
            this.dyU = bi.getInt((String) map.get(".msg.appmsg.weappinfo.type"), 0);
            this.dyZ = bi.getInt((String) map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
            this.dyV = (String) map.get(".msg.appmsg.weappinfo.pkginfo.md5");
            this.dzb = (String) map.get(".msg.appmsg.weappinfo.weappiconurl");
            this.dyX = (String) map.get(".msg.appmsg.weappinfo.shareId");
            this.dyY = (String) map.get(".msg.appmsg.weappinfo.sharekey");
            String str = "<cache";
            String str2 = "</cache>";
            int indexOf = g_a.dzg.indexOf(str);
            int indexOf2 = g_a.dzg.indexOf(str2);
            if (indexOf2 - indexOf > str.length()) {
                this.dzc = g_a.dzg.substring(indexOf, str2.length() + indexOf2);
            }
            this.dzd = bi.getInt((String) map.get(".msg.appmsg.soundtype"), 0);
            switch (this.type) {
                case 1:
                    if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                        this.dyi = true;
                        break;
                    }
                case 13:
                    this.dwX = bi.getInt((String) map.get(".msg.appmsg.mallproductitem.$type"), 0);
                    this.dwY = (String) map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                    break;
                case 16:
                    this.bRw = g_a.dzg;
                    this.dxE = "";
                    this.dxG = bi.getInt((String) map.get(".msg.appmsg.carditem.from_scene"), 2);
                    this.dxF = (String) map.get(".msg.appmsg.carditem.brand_name");
                    this.dxH = bi.getInt((String) map.get(".msg.appmsg.carditem.card_type"), -1);
                    break;
                case 34:
                    this.dxJ = bi.aG((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
                    this.dxI = o.cx((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
                    this.dxK = bi.aG((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
                    this.dxL = bi.aG((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                    this.dxM = bi.aG((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                    this.dxN = bi.aG((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                    this.dxO = bi.aG((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
                    this.dxP = bi.aG((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
                    break;
                case 2000:
                    this.dxy = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                    this.dxz = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.feedesc"));
                    this.dxA = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.transcationid"));
                    this.dxB = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.transferid"));
                    this.dxC = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                    this.dxD = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                    this.bYg = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                    this.bJg = bi.aG((String) map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                    this.dyI = bi.aG((String) map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                    break;
                case 2001:
                    String[] split;
                    this.dxU = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.iconurl"));
                    this.dxZ = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.scenetext"));
                    this.dxT = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.url"));
                    this.dxV = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                    this.dxW = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                    this.dxY = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                    this.dxX = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.senderdes"));
                    this.dya = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.templateid"));
                    this.dyb = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.sceneid"));
                    this.dyc = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                    this.dyd = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                    this.dye = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                    this.dyf = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.imageid"));
                    this.dyg = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                    this.dyh = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                    this.dyj = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                    this.dyk = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                    this.dyl = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                    this.dym = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                    this.dyn = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                    this.dyo = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                    str = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                    if (!bi.oW(str)) {
                        split = str.split("\\|");
                        if (split != null && split.length > 0) {
                            this.dyp = new ArrayList();
                            this.dyp.addAll(Arrays.asList(split));
                        }
                    }
                    this.dyq = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                    str = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                    if (!bi.oW(str)) {
                        split = str.split("\\|");
                        if (split != null && split.length > 0) {
                            this.dyr = new ArrayList();
                            this.dyr.addAll(Arrays.asList(split));
                        }
                    }
                    this.dys = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                    this.dyt = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                    this.dyu = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                    break;
                case 2002:
                    this.dyv = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.url"));
                    this.dyw = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                    this.dyx = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                    this.dyy = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                    this.dyz = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                    this.dyA = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                    this.dyB = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                    this.dyC = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                    this.dyD = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                    this.dyE = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                    this.dyF = bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                    break;
            }
            if (this.type != 21) {
                if (this.type != 2001) {
                    this.showType = bi.getInt((String) map.get(".msg.appmsg.showtype"), 0);
                    switch (this.showType) {
                        case 1:
                            if (bi.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                this.content = ay.au(map);
                                break;
                            }
                            break;
                        case 2:
                            str = g_a.dzg.toLowerCase();
                            this.dwC = g_a.dzg.substring(str.indexOf("<ShakePageResult>".toLowerCase()) + 17, str.indexOf("</ShakePageResult>".toLowerCase()));
                            break;
                    }
                }
                this.showType = bi.getInt((String) map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
            } else {
                this.showType = bi.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            }
            this.bZN = (String) map.get(".msg.appmsg.statextstr");
            this.dwP = bi.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            if (this.dwP == 5 && bi.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                this.dwP = 0;
            }
            this.dwQ = bi.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
            this.dxb = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
            this.dxc = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
            if (bi.oW(this.dxc)) {
                this.dxc = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
            }
            this.dxd = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
            this.dxe = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
            this.dxf = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
            this.dxg = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
            this.dxh = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
            this.dxi = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
            this.dxj = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
            this.dxl = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
            this.dxk = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
            this.dxn = (String) map.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
            this.dxm = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
            this.dxq = bi.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            this.dxs = bi.getInt((String) map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
            this.dxr = bi.getInt((String) map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
            this.dxo = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
            this.dxp = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
            str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
            this.dxw = str;
            this.dxu = str;
            str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
            this.dxv = str;
            this.dxt = str;
            this.dxx = bi.oV((String) map.get(".msg.appmsg.template_id"));
            this.filemd5 = (String) map.get(".msg.appmsg.md5");
            this.dxQ = bi.getInt((String) map.get(".msg.appmsg.jumpcontrol.enable"), 0);
            this.dxR = (String) map.get(".msg.appmsg.jumpcontrol.jumpurl");
            this.dxS = (String) map.get(".msg.appmsg.jumpcontrol.pushcontent");
            Map z = bl.z(g_a.dzh, "msgoperation");
            if (this != null && z != null) {
                this.dwl = new a();
                this.dwl.cGK = (String) z.get(".msgoperation.expinfo.expidstr");
                this.dwl.dzk = bi.getInt((String) z.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                this.dwl.dzl = bi.getInt((String) z.get(".msgoperation.appmsg.isupdatetitle"), 0);
                this.dwl.title = (String) z.get(".msgoperation.appmsg.title");
                this.dwl.dzm = bi.getInt((String) z.get(".msgoperation.appmsg.isupdatedesc"), 0);
                this.dwl.desc = (String) z.get(".msgoperation.appmsg.desc");
                this.dwl.dzn = bi.getInt((String) z.get(".msgoperation.appmsg.ishiddentail"), 0);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.AppMessage", "parse amessage xml failed");
            x.e("MicroMsg.AppMessage", "exception:%s", new Object[]{bi.i(e)});
            throw e;
        }
    }

    private g$a FF() {
        g$a g_a = new g$a();
        if (this == null) {
            return g_a;
        }
        x.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[]{bi.Xf(this.dwK), this.filemd5, g_a.appId});
        g_a.action = this.action;
        g_a.appId = this.appId;
        g_a.appName = this.appName;
        g_a.cbu = this.cbu;
        g_a.bGP = this.bGP;
        g_a.dwo = this.dwo;
        g_a.content = this.content;
        g_a.description = this.description;
        g_a.username = this.username;
        g_a.extInfo = this.extInfo;
        g_a.mediaTagName = this.mediaTagName;
        g_a.messageAction = this.messageAction;
        g_a.messageExt = this.messageExt;
        g_a.dwr = this.dwr;
        g_a.dwp = this.dwp;
        g_a.bSS = this.bSS;
        g_a.dwn = this.dwn;
        g_a.sdkVer = this.sdkVer;
        g_a.title = this.title;
        g_a.type = this.type;
        g_a.showType = this.showType;
        g_a.dwP = this.dwP;
        g_a.dwQ = this.dwQ;
        g_a.url = this.url;
        g_a.dwq = this.dwq;
        g_a.bZG = this.bZG;
        g_a.bZH = this.bZH;
        g_a.cGB = this.cGB;
        g_a.thumburl = this.thumburl;
        g_a.dwC = this.dwC;
        g_a.dwN = this.dwN;
        g_a.dwO = this.dwO;
        g_a.dwR = this.dwR;
        g_a.dwS = this.dwS;
        g_a.dwU = this.dwU;
        g_a.dwT = this.dwT;
        g_a.dwX = this.dwX;
        g_a.dwY = this.dwY;
        g_a.dxa = this.dxa;
        g_a.dwZ = this.dwZ;
        g_a.dwV = this.dwV;
        g_a.dwW = this.dwW;
        g_a.dxx = this.dxx;
        g_a.bRw = this.bRw;
        g_a.dxE = this.dxE;
        g_a.dxF = this.dxF;
        g_a.dxG = this.dxG;
        g_a.dxH = this.dxG;
        g_a.dxz = this.dxz;
        g_a.dxC = this.dxC;
        g_a.dxy = this.dxy;
        g_a.dxA = this.dxA;
        g_a.dxB = this.dxB;
        g_a.dxQ = this.dxQ;
        g_a.dxR = this.dxR;
        g_a.dxS = this.dxS;
        g_a.dwt = this.dwt;
        g_a.bZJ = this.bZJ;
        g_a.bZK = this.bZK;
        g_a.bZL = this.bZL;
        g_a.bZM = this.bZM;
        g_a.dyI = this.dyI;
        g_a.dyG = this.dyG;
        g_a.designerName = this.designerName;
        g_a.designerRediretctUrl = this.designerName;
        g_a.tid = this.tid;
        g_a.dyH = this.dyH;
        g_a.desc = this.desc;
        g_a.iconUrl = this.iconUrl;
        g_a.secondUrl = this.secondUrl;
        g_a.pageType = this.pageType;
        g_a.dyJ = this.dyJ;
        g_a.dyK = this.dyK;
        g_a.dyL = this.dyL;
        g_a.dyM = this.dyM;
        g_a.dyN = this.dyN;
        g_a.dyO = this.dyO;
        g_a.dyP = this.dyP;
        g_a.dyQ = this.dyQ;
        g_a.canvasPageXml = this.canvasPageXml;
        g_a.bZN = this.bZN;
        g_a.dwD = this.dwD;
        g_a.dwK = this.dwK;
        g_a.filemd5 = this.filemd5;
        g_a.dws = this.dws;
        g_a.dwl = this.dwl;
        g_a.dyR = this.dyR;
        g_a.dyS = this.dyS;
        g_a.dyU = this.dyU;
        g_a.dyV = this.dyV;
        g_a.dyZ = this.dyZ;
        g_a.dyT = this.dyT;
        g_a.dza = this.dza;
        g_a.dzb = this.dzb;
        g_a.dyX = this.dyX;
        g_a.dzh = this.dzh;
        g_a.dzi = this.dzi;
        g_a.dzg = this.dzg;
        g_a.dzf = this.dzf;
        g_a.dwu = this.dwu;
        g_a.dwv = this.dwv;
        g_a.dww = this.dww;
        g_a.dwx = this.dwx;
        g_a.dwy = this.dwy;
        g_a.dwz = this.dwz;
        g_a.dwA = this.dwA;
        g_a.dwB = this.dwB;
        for (Entry value : this.dze.entrySet()) {
            d FD = ((d) value.getValue()).FD();
            if (FD != null) {
                g_a.a(FD);
            }
        }
        return g_a;
    }

    public final void a(StringBuilder stringBuilder, g$a g_a, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        String str2;
        stringBuilder.append("<title>" + bi.WS(g_a.title) + "</title>");
        stringBuilder.append("<des>" + bi.WS(g_a.description) + "</des>");
        stringBuilder.append("<username>" + bi.WS(g_a.username) + "</username>");
        StringBuilder stringBuilder2 = new StringBuilder("<action>");
        if (bi.oW(g_a.action)) {
            str2 = "view";
        } else {
            str2 = bi.WS(g_a.action);
        }
        stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
        stringBuilder.append("<type>" + g_a.type + "</type>");
        stringBuilder.append("<showtype>").append(g_a.showType).append("</showtype>");
        stringBuilder.append("<content>" + bi.WS(g_a.content) + "</content>");
        stringBuilder.append("<url>" + bi.WS(g_a.url) + "</url>");
        stringBuilder.append("<lowurl>" + bi.WS(g_a.dwn) + "</lowurl>");
        stringBuilder.append("<dataurl>" + bi.WS(g_a.dwN) + "</dataurl>");
        stringBuilder.append("<lowdataurl>" + bi.WS(g_a.dwO) + "</lowdataurl>");
        stringBuilder.append("<contentattr>").append(g_a.dwt).append("</contentattr>");
        stringBuilder.append("<streamvideo>");
        stringBuilder.append("<streamvideourl>").append(bi.WS(g_a.dyJ)).append("</streamvideourl>");
        stringBuilder.append("<streamvideototaltime>").append(g_a.dyK).append("</streamvideototaltime>");
        stringBuilder.append("<streamvideotitle>").append(bi.WS(g_a.dyL)).append("</streamvideotitle>");
        stringBuilder.append("<streamvideowording>").append(bi.WS(g_a.dyM)).append("</streamvideowording>");
        stringBuilder.append("<streamvideoweburl>").append(bi.WS(g_a.dyN)).append("</streamvideoweburl>");
        stringBuilder.append("<streamvideothumburl>").append(bi.WS(g_a.dyO)).append("</streamvideothumburl>");
        stringBuilder.append("<streamvideoaduxinfo>").append(bi.WS(g_a.dyP)).append("</streamvideoaduxinfo>");
        stringBuilder.append("<streamvideopublishid>").append(bi.WS(g_a.dyQ)).append("</streamvideopublishid>");
        stringBuilder.append("</streamvideo>");
        stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{g_a.canvasPageXml}));
        switch (g_a.type) {
            case 10:
                stringBuilder.append("<productitem type=\"" + g_a.dwR + "\">");
                stringBuilder.append("<productinfo>" + bi.WS(g_a.dwS) + "</productinfo>");
                stringBuilder.append("</productitem>");
                break;
            case 13:
                stringBuilder.append("<mallproductitem type=\"" + g_a.dwX + "\">");
                stringBuilder.append("<mallproductinfo>" + bi.WS(g_a.dwY) + "</mallproductinfo>");
                stringBuilder.append("</mallproductitem>");
                break;
            case 16:
                stringBuilder.append("<carditem>" + g_a.dxE + "</carditem>");
                break;
            case 19:
            case 24:
                stringBuilder.append("<recorditem>" + bi.WS(g_a.dwW) + "</recorditem>");
                break;
            case 20:
                stringBuilder.append("<tvinfo>" + bi.WS(g_a.dwV) + "</tvinfo>");
                break;
            case 2000:
                stringBuilder.append("<wcpayinfo>");
                stringBuilder.append("<paysubtype>" + g_a.dxy + "</paysubtype>");
                stringBuilder.append("<feedesc>" + g_a.dxz + "</feedesc>");
                stringBuilder.append("<transcationid>" + g_a.dxA + "</transcationid>");
                stringBuilder.append("<transferid>" + g_a.dxB + "</transferid>");
                stringBuilder.append("<invalidtime>" + g_a.dxC + "</invalidtime>");
                stringBuilder.append("<pay_memo>" + g_a.dyI + "</pay_memo>");
                stringBuilder.append("</wcpayinfo>");
                break;
            case 2001:
                stringBuilder.append("<wcpayinfo>");
                stringBuilder.append("<iconurl>" + bi.WS(g_a.dxU) + "</iconurl>");
                stringBuilder.append("<scenetext>" + bi.WS(g_a.dxZ) + "</scenetext>");
                stringBuilder.append("<url>" + bi.WS(g_a.dxT) + "</url>");
                stringBuilder.append("<receivertitle>" + bi.WS(g_a.dxV) + "</receivertitle>");
                stringBuilder.append("<sendertitle>" + bi.WS(g_a.dxW) + "</sendertitle>");
                stringBuilder.append("<receiverdes>" + bi.WS(g_a.dxY) + "</receiverdes>");
                stringBuilder.append("<senderdes>" + bi.WS(g_a.dxX) + "</senderdes>");
                stringBuilder.append("<templateid>" + bi.WS(g_a.dya) + "</templateid>");
                stringBuilder.append("<sceneid>" + bi.WS(g_a.dyb) + "</sceneid>");
                stringBuilder.append("<nativeurl>" + bi.WS(g_a.dyc) + "</nativeurl>");
                stringBuilder.append("<innertype>" + bi.WS(g_a.showType) + "</innertype>");
                stringBuilder.append("<localtype>" + bi.WS(g_a.dyd) + "</localtype>");
                stringBuilder.append("<paymsgid>" + bi.WS(g_a.dye) + "</paymsgid>");
                stringBuilder.append("<imageid>" + bi.WS(g_a.dyf) + "</imageid>");
                stringBuilder.append("<imageaeskey>" + bi.WS(g_a.dyg) + "</imageaeskey>");
                stringBuilder.append("<imagelength>" + bi.WS(g_a.dyh) + "</imagelength>");
                stringBuilder.append("<droptips>" + bi.WS(g_a.dyj) + "</droptips>");
                stringBuilder.append("</wcpayinfo>");
                break;
        }
        stringBuilder.append("<appattach>");
        if (keep_sceneresult == null || (bi.oW(str) && i == 0 && i2 == 0)) {
            stringBuilder.append("<totallen>" + g_a.dwo + "</totallen>");
            stringBuilder.append("<attachid>" + bi.WS(g_a.bGP) + "</attachid>");
            stringBuilder.append("<cdnattachurl>" + bi.WS(g_a.dwD) + "</cdnattachurl>");
            stringBuilder.append("<emoticonmd5>" + bi.WS(g_a.dwq) + "</emoticonmd5>");
            stringBuilder.append("<aeskey>" + bi.WS(g_a.dwK) + "</aeskey>");
            if (!(i == 0 || i2 == 0)) {
                stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
            }
        } else {
            stringBuilder.append("<attachid>" + bi.WS(str) + "</attachid>");
            if (keep_sceneresult.field_fileLength > 0 && !bi.oW(keep_sceneresult.field_fileId)) {
                stringBuilder.append("<cdnattachurl>" + bi.WS(keep_sceneresult.field_fileId) + "</cdnattachurl>");
                if (g_a.type == 19 || g_a.type == 24 || g_a.type == 4 || g_a.type == 3 || g_a.type == 7 || g_a.type == 27 || g_a.type == 26) {
                    x.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[]{Integer.valueOf(g_a.type), Integer.valueOf(keep_sceneresult.field_fileLength)});
                } else {
                    stringBuilder.append("<totallen>" + keep_sceneresult.field_fileLength + "</totallen>");
                }
            }
            if (keep_sceneresult.field_thumbimgLength > 0) {
                stringBuilder.append("<cdnthumburl>" + bi.WS(keep_sceneresult.field_fileId) + "</cdnthumburl>");
                if (!bi.oW(keep_sceneresult.field_thumbfilemd5)) {
                    stringBuilder.append("<cdnthumbmd5>" + keep_sceneresult.field_thumbfilemd5 + "</cdnthumbmd5>");
                }
                stringBuilder.append("<cdnthumblength>" + keep_sceneresult.field_thumbimgLength + "</cdnthumblength>");
                stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                stringBuilder.append("<cdnthumbaeskey>" + keep_sceneresult.field_aesKey + "</cdnthumbaeskey>");
            }
            stringBuilder.append("<aeskey>" + bi.WS(keep_sceneresult.field_aesKey) + "</aeskey>");
            stringBuilder.append("<encryver>1</encryver>");
        }
        stringBuilder.append("<fileext>" + bi.WS(g_a.dwp) + "</fileext>");
        stringBuilder.append("<islargefilemsg>" + g_a.dws + "</islargefilemsg>");
        stringBuilder.append("</appattach>");
        stringBuilder.append("<extinfo>" + bi.WS(g_a.extInfo) + "</extinfo>");
        stringBuilder.append("<androidsource>" + g_a.dwr + "</androidsource>");
        if (!bi.oW(g_a.bZG)) {
            stringBuilder.append("<sourceusername>" + bi.WS(g_a.bZG) + "</sourceusername>");
            stringBuilder.append("<sourcedisplayname>" + bi.WS(g_a.bZH) + "</sourcedisplayname>");
            stringBuilder.append("<commenturl>" + bi.WS(g_a.cGB) + "</commenturl>");
        }
        stringBuilder.append("<thumburl>" + bi.WS(g_a.thumburl) + "</thumburl>");
        stringBuilder.append("<mediatagname>" + bi.WS(g_a.mediaTagName) + "</mediatagname>");
        stringBuilder.append("<messageaction>" + gq(bi.WS(g_a.messageAction)) + "</messageaction>");
        stringBuilder.append("<messageext>" + gq(bi.WS(g_a.messageExt)) + "</messageext>");
        stringBuilder.append("<emoticongift>");
        stringBuilder.append("<packageflag>" + g_a.dwU + "</packageflag>");
        stringBuilder.append("<packageid>" + bi.WS(g_a.dwT) + "</packageid>");
        stringBuilder.append("</emoticongift>");
        stringBuilder.append("<emoticonshared>");
        stringBuilder.append("<packageflag>" + g_a.dxa + "</packageflag>");
        stringBuilder.append("<packageid>" + bi.WS(g_a.dwZ) + "</packageid>");
        stringBuilder.append("</emoticonshared>");
        stringBuilder.append("<designershared>");
        stringBuilder.append("<designeruin>" + g_a.dyG + "</designeruin>");
        stringBuilder.append("<designername>" + g_a.designerName + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + g_a.designerRediretctUrl + "</designerrediretcturl>");
        stringBuilder.append("</designershared>");
        stringBuilder.append("<emotionpageshared>");
        stringBuilder.append("<tid>" + g_a.tid + "</tid>");
        stringBuilder.append("<title>" + g_a.dyH + "</title>");
        stringBuilder.append("<desc>" + g_a.desc + "</desc>");
        stringBuilder.append("<iconUrl>" + g_a.iconUrl + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + g_a.secondUrl + "</secondUrl>");
        stringBuilder.append("<pageType>" + g_a.pageType + "</pageType>");
        stringBuilder.append("</emotionpageshared>");
        stringBuilder.append("<webviewshared>");
        stringBuilder.append("<shareUrlOriginal>" + bi.WS(g_a.bZJ) + "</shareUrlOriginal>");
        stringBuilder.append("<shareUrlOpen>" + bi.WS(g_a.bZK) + "</shareUrlOpen>");
        stringBuilder.append("<jsAppId>" + bi.WS(g_a.bZL) + "</jsAppId>");
        stringBuilder.append("<publisherId>" + bi.WS(g_a.bZM) + "</publisherId>");
        stringBuilder.append("</webviewshared>");
        stringBuilder.append("<template_id>" + bi.WS(g_a.dxx) + "</template_id>");
        x.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[]{g_a.filemd5});
        stringBuilder.append("<md5>" + bi.WS(g_a.filemd5) + "</md5>");
        Iterator it = b.FG().iterator();
        while (it.hasNext()) {
            d dVar = (d) ((c) it.next()).get();
            d u = g_a.u(dVar.getClass());
            if (u != null) {
                dVar = u;
            }
            dVar.a(stringBuilder, g_a, str, keep_sceneresult, i, i2);
        }
    }

    public final void a(g gVar) {
        gVar.field_appId = this.appId;
        gVar.field_title = this.title;
        gVar.field_description = this.description;
        gVar.field_type = this.type;
        gVar.field_source = this.appName;
    }

    public static String gq(String str) {
        return "<![CDATA[" + str + "]]>";
    }

    public final String getTitle() {
        if (this.dwl == null || this.dwl.dzl == 0) {
            return this.title;
        }
        return this.dwl.title;
    }

    public final String getDescription() {
        if (this.dwl == null || this.dwl.dzm == 0) {
            return this.description;
        }
        return this.dwl.desc;
    }
}
