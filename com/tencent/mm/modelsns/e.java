package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.bp.a;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cdo;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    private static float ne(String str) {
        if (str == null) {
            return 0.0f;
        }
        return bi.getFloat(str, 0.0f);
    }

    private static String nf(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static bsu RF() {
        bsu bsu = new bsu();
        qc qcVar = new qc();
        bsu.sqb = new dc();
        bsu.sqc = qcVar;
        bsu.rVG = 0;
        bsu.lOH = 0;
        bsu.ksA = "";
        arj arj = new arj();
        arj.rms = 0.0f;
        arj.rmr = 0.0f;
        bsu.sqa = arj;
        bsu.ogR = "";
        bsu.sqi = new cdo();
        return bsu;
    }

    public static ate RG() {
        ate ate = new ate();
        ate.jOS = "";
        ate.rVG = 0;
        return ate;
    }

    public static ate a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        ate ate = new ate();
        ate.ksA = str;
        ate.hcE = i;
        ate.jPK = str2;
        ate.rVE = str3;
        ate.rVD = i2;
        ate.rVF = i3;
        ate.jOS = str4;
        atg atg = new atg();
        atg.rWv = 0.0f;
        atg.rWu = 0.0f;
        atg.rWw = 0.0f;
        ate.rVH = atg;
        ate.rVS = g.u(str2 == null ? "".getBytes() : str2.getBytes());
        return ate;
    }

    public static ate a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, atg atg) {
        ate ate = new ate();
        ate.ksA = nf(str);
        ate.hcE = i;
        ate.jOS = nf(str4);
        ate.jPK = nf(str2);
        ate.rVD = i2;
        ate.rVE = nf(str3);
        ate.rVF = i3;
        ate.rVG = i4;
        ate.rVH = atg;
        ate.rVS = g.u(str2 == null ? "".getBytes() : str2.getBytes());
        return ate;
    }

    public static bsu ng(String str) {
        Map z = bl.z(str, "TimelineObject");
        bsu RF = RF();
        if (z == null) {
            return RF;
        }
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int indexOf;
        int indexOf2;
        bsu bsu;
        RF.ksA = nf((String) z.get(".TimelineObject.id"));
        RF.hbL = nf((String) z.get(".TimelineObject.username"));
        RF.rVG = bi.getInt((String) z.get(".TimelineObject.private"), 0);
        RF.lOH = bi.getInt((String) z.get(".TimelineObject.createTime"), 0);
        RF.spZ = nf((String) z.get(".TimelineObject.contentDesc"));
        RF.sqe = bi.getInt((String) z.get(".TimelineObject.contentDescShowType"), 0);
        RF.sqf = bi.getInt((String) z.get(".TimelineObject.contentDescScene"), 0);
        RF.nNV = nf((String) z.get(".TimelineObject.statExtStr"));
        RF.sqj = bi.getInt((String) z.get(".TimelineObject.sightFolded"), 0);
        RF.csE = bi.getInt((String) z.get(".TimelineObject.showFlag"), 0);
        arj arj = new arj();
        arj.rmr = ne((String) z.get(".TimelineObject.location.$longitude"));
        arj.rms = ne((String) z.get(".TimelineObject.location.$latitude"));
        arj.eJJ = nf((String) z.get(".TimelineObject.location.$city"));
        arj.rTI = bi.getInt((String) z.get(".TimelineObject.location.$poiScale"), 0);
        arj.rTG = nf((String) z.get(".TimelineObject.location.$poiClassifyId"));
        arj.nOB = bi.getInt((String) z.get(".TimelineObject.location.$poiClassifyType"), 0);
        arj.nOz = nf((String) z.get(".TimelineObject.location.$poiAddress"));
        arj.kFa = nf((String) z.get(".TimelineObject.location.$poiName"));
        arj.rTJ = bi.getInt((String) z.get(".TimelineObject.location.$poiClickableStatus"), 0);
        arj.rTL = nf((String) z.get(".TimelineObject.location.$poiAddressName"));
        arj.country = nf((String) z.get(".TimelineObject.location.$country"));
        RF.sqa = arj;
        String str7 = ".TimelineObject.ContentObject.description";
        String str8 = ".TimelineObject.ContentObject.contentStyle";
        String str9 = ".TimelineObject.ContentObject.contentSubStyle";
        String str10 = ".TimelineObject.ContentObject.title";
        String str11 = ".TimelineObject.ContentObject.contentUrl";
        if (RF.sqc == null) {
            RF.sqc = new qc();
        }
        RF.sqc.jOS = nf((String) z.get(str7));
        RF.sqc.ruz = bi.getInt((String) z.get(str8), 0);
        RF.sqc.ruB = bi.getInt((String) z.get(str9), 0);
        RF.sqc.bHD = nf((String) z.get(str10));
        RF.sqc.jPK = nf((String) z.get(str11));
        int i = 0;
        while (true) {
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            String str33;
            String str34;
            String str35;
            String str36;
            String str37;
            String str38;
            String str39;
            String str40;
            String str41;
            String str42;
            String str43;
            String str44;
            if (i != 0) {
                str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".id";
                str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".type";
                str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".title";
                str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".description";
                str16 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url";
                str17 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$videomd5";
                str18 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb";
                str19 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$type";
                str21 = ".TimelineObject.ContentObject.mediaList.media" + i + ".private";
                str22 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
                str24 = ".TimelineObject.ContentObject.mediaList.media" + i;
                str25 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
                str26 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
                str27 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
                str28 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
                str29 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
                str30 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
                str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
                str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
                str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
                str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
                str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
                str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
                str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
                str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
                str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
                str31 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
                str32 = str8;
                str33 = str9;
                str34 = str10;
                str35 = str11;
                str36 = str6;
                str37 = str5;
                str38 = str4;
                str39 = str3;
                str40 = str2;
                str41 = str30;
                str42 = str29;
                str43 = str28;
                str44 = str27;
            } else {
                str12 = ".TimelineObject.ContentObject.mediaList.media.id";
                str13 = ".TimelineObject.ContentObject.mediaList.media.type";
                str14 = ".TimelineObject.ContentObject.mediaList.media.title";
                str15 = ".TimelineObject.ContentObject.mediaList.media.description";
                str16 = ".TimelineObject.ContentObject.mediaList.media.url";
                str17 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                str18 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                str19 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                str21 = ".TimelineObject.ContentObject.mediaList.media.private";
                str22 = ".TimelineObject.ContentObject.mediaList.media.subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media.userData";
                str24 = ".TimelineObject.ContentObject.mediaList.media";
                str25 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                str26 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                str31 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                str32 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                str33 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                str34 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                str35 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                str36 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                str37 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                str38 = ".TimelineObject.ContentObject.mediaList.media.enc";
                str39 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                str40 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                str41 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                str42 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                str43 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                str44 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
            }
            str7 = str24 + ".size.$width";
            str7 = (String) z.get(str7);
            str8 = (String) z.get(str24 + ".size.$height");
            str9 = (String) z.get(str24 + ".size.$totalSize");
            atg atg = new atg();
            atg.rWv = 0.0f;
            atg.rWu = 0.0f;
            atg.rWw = 0.0f;
            if (str7 != null) {
                atg.rWu = ne(str7);
            }
            if (str8 != null) {
                atg.rWv = ne(str8);
            }
            if (str9 != null) {
                atg.rWw = ne(str9);
            }
            str7 = (String) z.get(str12);
            str8 = (String) z.get(str13);
            str9 = (String) z.get(str14);
            str10 = (String) z.get(str15);
            str11 = (String) z.get(str16);
            str6 = (String) z.get(str21);
            str5 = (String) z.get(str18);
            str4 = (String) z.get(str17);
            str3 = (String) z.get(str19);
            str2 = (String) z.get(str20);
            str30 = (String) z.get(str25);
            str29 = (String) z.get(str26);
            str28 = (String) z.get(str22);
            str27 = (String) z.get(str23);
            str44 = (String) z.get(str44);
            str43 = (String) z.get(str43);
            str42 = (String) z.get(str42);
            str41 = (String) z.get(str41);
            str40 = (String) z.get(str40);
            str39 = (String) z.get(str39);
            str38 = (String) z.get(str38);
            str37 = (String) z.get(str37);
            str36 = (String) z.get(str36);
            str35 = (String) z.get(str35);
            str34 = (String) z.get(str34);
            str33 = (String) z.get(str33);
            str32 = (String) z.get(str32);
            str31 = (String) z.get(str31);
            if (str8 == null || str7 == null) {
                indexOf = str.indexOf("<noteinfo>");
                indexOf2 = str.indexOf("</noteinfo>");
            } else {
                ate ate = new ate();
                ate.ksA = nf(str7);
                ate.hcE = bi.getInt(str8, 0);
                ate.bHD = nf(str9);
                ate.jOS = nf(str10);
                ate.jPK = nf(str11);
                ate.rVD = bi.getInt(str3, 0);
                ate.rVE = nf(str5);
                ate.rVF = bi.getInt(str2, 0);
                ate.rVG = bi.getInt(str6, 0);
                ate.rVH = atg;
                ate.rVI = nf(str30);
                ate.rVJ = bi.getInt(str29, 0);
                ate.nME = nf(str27);
                ate.bID = bi.getInt(str28, 0);
                ate.rVL = nf(str44);
                ate.rVN = nf(str43);
                ate.rVM = nf(str42);
                ate.rVZ = nf(str4);
                ate.oig = bi.getInt(str41, 0);
                ate.rVO = nf(str40);
                ate.rVP = nf(str39);
                ate.rVQ = bi.getInt(str38, 0);
                ate.rVR = bi.getLong(str37, 0);
                ate.rVS = g.u(ate.jPK == null ? "".getBytes() : ate.jPK.getBytes());
                ate.rVT = str36;
                ate.rVU = bi.getInt(str35, 0);
                ate.rVV = str34;
                ate.rVW = str33;
                ate.rVX = bi.getInt(str32, 0);
                ate.rVY = str31;
                RF.sqc.ruA.add(ate);
                i++;
            }
        }
        indexOf = str.indexOf("<noteinfo>");
        indexOf2 = str.indexOf("</noteinfo>");
        if (indexOf < 0 || indexOf2 < 0) {
            bsu = RF;
        } else {
            RF.sqc.ruC = str.substring(indexOf, indexOf2 + 11);
            bsu = RF;
        }
        dc dcVar = new dc();
        str10 = nf((String) z.get(".TimelineObject.appInfo.id"));
        str11 = nf((String) z.get(".TimelineObject.appInfo.version"));
        str6 = nf((String) z.get(".TimelineObject.appInfo.appName"));
        str5 = nf((String) z.get(".TimelineObject.appInfo.installUrl "));
        str7 = nf((String) z.get(".TimelineObject.appInfo.fromUrl "));
        dcVar.ksA = str10;
        dcVar.jSv = str6;
        dcVar.rdf = str5;
        dcVar.rdg = str7;
        dcVar.hcr = str11;
        dcVar.rdh = bi.getInt((String) z.get(".TimelineObject.appInfo.clickable"), 0);
        bsu.sqb = dcVar;
        cdo cdo = new cdo();
        str10 = nf((String) z.get(".TimelineObject.weappInfo.appUserName"));
        str7 = nf((String) z.get(".TimelineObject.weappInfo.pagePath"));
        cdo.username = str10;
        cdo.path = str7;
        bsu.sqi = cdo;
        brh brh = new brh();
        str10 = nf((String) z.get(".TimelineObject.streamvideo.streamvideotitle"));
        str11 = nf((String) z.get(".TimelineObject.streamvideo.streamvideototaltime"));
        str6 = nf((String) z.get(".TimelineObject.streamvideo.streamvideourl"));
        str5 = nf((String) z.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str4 = nf((String) z.get(".TimelineObject.streamvideo.streamvideowording"));
        str3 = nf((String) z.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str2 = nf((String) z.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str7 = nf((String) z.get(".TimelineObject.streamvideo.streamvideopublishid"));
        brh.dyL = str10;
        brh.dyK = bi.WU(str11);
        brh.dyJ = str6;
        brh.dyN = str5;
        brh.dyM = str4;
        brh.dyO = str3;
        brh.dyP = str2;
        brh.dyQ = str7;
        bsu.sqh = brh;
        bov bov = new bov();
        str10 = nf((String) z.get(".TimelineObject.redEnvelopesInfo.sendId"));
        str7 = nf((String) z.get(".TimelineObject.redEnvelopesInfo.ticket"));
        bov.kLZ = str10;
        bov.bLe = str7;
        av avVar = new av();
        int i2 = bi.getInt((String) z.get(".TimelineObject.actionInfo.scene"), 0);
        str11 = nf((String) z.get(".TimelineObject.actionInfo.appid"));
        int i3 = bi.getInt((String) z.get(".TimelineObject.actionInfo.type"), 0);
        str5 = nf((String) z.get(".TimelineObject.actionInfo.url"));
        str4 = nf((String) z.get(".TimelineObject.actionInfo.mediaTagName"));
        str7 = nf((String) z.get(".TimelineObject.actionInfo.wordingKey"));
        avVar.raP = str11;
        avVar.otY = i2;
        avVar.hcE = i3;
        avVar.jPK = str5;
        avVar.raQ = str4;
        avVar.raR = str7;
        at atVar = new at();
        str11 = nf((String) z.get(".TimelineObject.actionInfo.appMsg.appid"));
        str6 = nf((String) z.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        str5 = nf((String) z.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str7 = nf((String) z.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        atVar.jQb = str11;
        atVar.raM = str6;
        atVar.raN = str5;
        atVar.raO = str7;
        avVar.raS = atVar;
        i2 = bi.getInt((String) z.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        int i4 = bi.getInt((String) z.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        str6 = nf((String) z.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        str5 = nf((String) z.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        avVar.raT = nf((String) z.get(".TimelineObject.actionInfo.newWordingKey"));
        ct ctVar = new ct();
        ctVar.rcR = i2;
        ctVar.rcS = i4;
        de deVar = new de();
        deVar.rdl = str6;
        deVar.rdm = str5;
        avVar.raU = ctVar;
        avVar.raV = deVar;
        avVar.raW = nh((String) z.get(".TimelineObject.actionInfo.installedWording"));
        avVar.raX = nh((String) z.get(".TimelineObject.actionInfo.uninstalledWording"));
        bsu.nsB = avVar;
        bsu.qIb = nf((String) z.get(".TimelineObject.sourceUserName"));
        bsu.qIc = nf((String) z.get(".TimelineObject.sourceNickName"));
        bsu.sqd = nf((String) z.get(".TimelineObject.publicUserName"));
        bsu.sqg = nf((String) z.get(".TimelineObject.statisticsData"));
        bsu.ogR = nf((String) z.get(".TimelineObject.canvasInfoXml"));
        bsu.dwt = bi.getInt((String) z.get(".TimelineObject.contentattr"), 0);
        cfn cfn = new cfn();
        cfn.pLr = nf((String) z.get(".TimelineObject.websearch.relevant_vid"));
        cfn.pLs = nf((String) z.get(".TimelineObject.websearch.relevant_expand"));
        cfn.pLt = nf((String) z.get(".TimelineObject.websearch.relevant_pre_searchid"));
        cfn.pLu = nf((String) z.get(".TimelineObject.websearch.relevant_shared_openid"));
        cfn.pLv = bi.getLong((String) z.get(".TimelineObject.websearch.rec_category"), 0);
        cfn.ixy = nf((String) z.get(".TimelineObject.websearch.shareUrl"));
        cfn.ixz = nf((String) z.get(".TimelineObject.websearch.shareTitle"));
        cfn.nzH = nf((String) z.get(".TimelineObject.websearch.shareDesc"));
        cfn.pLw = nf((String) z.get(".TimelineObject.websearch.shareImgUrl"));
        cfn.pLx = nf((String) z.get(".TimelineObject.websearch.shareString"));
        cfn.pLy = nf((String) z.get(".TimelineObject.websearch.shareStringUrl"));
        cfn.bhd = nf((String) z.get(".TimelineObject.websearch.source"));
        cfn.lRt = nf((String) z.get(".TimelineObject.websearch.sourceUrl"));
        cfn.pLz = nf((String) z.get(".TimelineObject.websearch.strPlayCount"));
        cfn.pLA = nf((String) z.get(".TimelineObject.websearch.titleUrl"));
        cfn.pLB = nf((String) z.get(".TimelineObject.websearch.extReqParams"));
        cfn.pLC = nf((String) z.get(".TimelineObject.websearch.tagList"));
        bsu.nsD = cfn;
        return bsu;
    }

    private static dd nh(String str) {
        if (bi.oW(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        Map z = bl.z("<root>" + stringBuilder.toString() + "</root>", "root");
        dd ddVar = new dd();
        ddVar.rdi = nf((String) z.get(".root.en"));
        ddVar.rdj = nf((String) z.get(".root.zh-CN"));
        ddVar.rdk = nf((String) z.get(".root.zh-TW"));
        return ddVar;
    }

    public static Pair<Integer, Integer> a(bsu bsu, Context context, boolean z) {
        int i;
        int i2;
        int i3;
        if (!(bsu == null || bsu.sqc == null || bsu.sqc.ruA == null || bsu.sqc.ruA.size() <= 0)) {
            ate ate = (ate) bsu.sqc.ruA.get(0);
            if (ate != null && ate.rVH != null && ate.rVH.rWu > 0.0f && ate.rVH.rWv > 0.0f) {
                i = (int) ate.rVH.rWu;
                i2 = (int) ate.rVH.rWv;
                if (i <= 0) {
                    i = 320;
                }
                if (i2 > 0) {
                    i3 = 240;
                } else {
                    i3 = i2;
                }
                if (context != null) {
                    x.e("MicroMsg.TimeLineHelper", "the context is null");
                    return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
                } else {
                    i2 = i;
                }
                int i4 = (i2 >> 5) << 5;
                if (i < i3 && context != null) {
                    i4 = Math.min(b.b(context, 160.0f), i4);
                }
                i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
                if (!z) {
                    int fromDPToPix = a.fromDPToPix(context, 200);
                    int fromDPToPix2 = a.fromDPToPix(context, 44);
                    if (i2 >= i4) {
                        if (i2 > fromDPToPix) {
                            i2 = fromDPToPix;
                        }
                        i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                        if (i4 < fromDPToPix2) {
                            i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                            i4 = fromDPToPix2;
                        }
                    } else {
                        if (i4 > fromDPToPix) {
                            i4 = fromDPToPix;
                        }
                        i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                        if (i2 < fromDPToPix2) {
                            i4 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                            i2 = fromDPToPix2;
                        }
                    }
                }
                x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Boolean.valueOf(z)});
                return Pair.create(Integer.valueOf(i4), Integer.valueOf(i2));
            }
        }
        i2 = 0;
        i = 0;
        if (i <= 0) {
            i = 320;
        }
        if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = 240;
        }
        if (context != null) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            if (displayMetrics2 != null) {
                i2 = (int) Math.min(((float) displayMetrics2.widthPixels) * 0.63f, ((float) displayMetrics2.heightPixels) * 0.63f);
            } else {
                i2 = i;
            }
            int i42 = (i2 >> 5) << 5;
            if (i < i3 && context != null) {
                i42 = Math.min(b.b(context, 160.0f), i42);
            }
            i2 = (int) (((((double) i42) * 1.0d) * ((double) i3)) / ((double) i));
            if (!z) {
                int fromDPToPix3 = a.fromDPToPix(context, 200);
                int fromDPToPix22 = a.fromDPToPix(context, 44);
                if (i2 >= i42) {
                    if (i2 > fromDPToPix3) {
                        i2 = fromDPToPix3;
                    }
                    i42 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                    if (i42 < fromDPToPix22) {
                        i2 = (int) (((((double) fromDPToPix22) * 1.0d) * ((double) i3)) / ((double) i));
                        i42 = fromDPToPix22;
                    }
                } else {
                    if (i42 > fromDPToPix3) {
                        i42 = fromDPToPix3;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i42));
                    if (i2 < fromDPToPix22) {
                        i42 = (int) (((((double) fromDPToPix22) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = fromDPToPix22;
                    }
                }
            }
            x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i42), Integer.valueOf(i2), Boolean.valueOf(z)});
            return Pair.create(Integer.valueOf(i42), Integer.valueOf(i2));
        }
        x.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
    }
}
