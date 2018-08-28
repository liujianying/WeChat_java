package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String gVK = "]]>";
    public static String gVL = "<TimelineObject>";
    public static String gVM = "</TimelineObject>";

    static class a {
        StringBuffer gVP = new StringBuffer();

        a() {
        }

        public final void wA(String str) {
            this.gVP.append("<" + str + ">");
        }

        public final void wB(String str) {
            this.gVP.append("</" + str + ">");
        }

        public final void setText(String str) {
            if (!bi.oW(str)) {
                if (str.contains(j.gVK)) {
                    this.gVP.append("<![CDATA[" + bi.WS(str) + "]]>");
                } else {
                    this.gVP.append("<![CDATA[" + str + "]]>");
                }
            }
        }

        public final void wI(int i) {
            this.gVP.append(i);
        }

        public final void i(String str, Map<String, String> map) {
            this.gVP.append("<" + str);
            for (String str2 : map.keySet()) {
                this.gVP.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.gVP.append(">");
            map.clear();
        }
    }

    private static String MQ(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String MR(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return (str.matches("\\d*") ? 1 : null) == null ? "" : str;
    }

    public static String b(bsu bsu) {
        String str;
        a aVar = new a();
        Map hashMap = new HashMap();
        aVar.wA("TimelineObject");
        aVar.wA("id");
        if (bsu.ksA == null || bsu.ksA.equals("")) {
            aVar.setText("0");
        } else {
            aVar.setText(bsu.ksA);
        }
        aVar.wB("id");
        if (bsu.hbL != null) {
            aVar.wA("username");
            aVar.setText(bsu.hbL);
            aVar.wB("username");
        }
        aVar.wA("createTime");
        aVar.setText(bsu.lOH);
        aVar.wB("createTime");
        aVar.wA("contentDescShowType");
        aVar.wI(bsu.sqe);
        aVar.wB("contentDescShowType");
        aVar.wA("contentDescScene");
        aVar.wI(bsu.sqf);
        aVar.wB("contentDescScene");
        aVar.wA("private");
        aVar.setText(bsu.rVG);
        aVar.wB("private");
        if (!(bsu.sqb == null || bi.oW(bsu.sqb.ksA))) {
            aVar.wA("appInfo");
            aVar.wA("id");
            aVar.setText(MQ(bsu.sqb.ksA));
            aVar.wB("id");
            aVar.wA("version");
            aVar.setText(MQ(bsu.sqb.hcr));
            aVar.wB("version");
            aVar.wA("appName");
            aVar.setText(MQ(bsu.sqb.jSv));
            aVar.wB("appName");
            aVar.wA("installUrl");
            aVar.setText(MQ(bsu.sqb.rdf));
            aVar.wB("installUrl");
            aVar.wA("fromUrl");
            aVar.setText(MQ(bsu.sqb.rdg));
            aVar.wB("fromUrl");
            aVar.wB("appInfo");
        }
        if (!(bsu.sqh == null || bi.oW(bsu.sqh.dyJ))) {
            aVar.wA("streamvideo");
            aVar.wA("streamvideourl");
            aVar.setText(MQ(bsu.sqh.dyJ));
            aVar.wB("streamvideourl");
            aVar.wA("streamvideototaltime");
            aVar.wI(bsu.sqh.dyK);
            aVar.wB("streamvideototaltime");
            aVar.wA("streamvideotitle");
            aVar.setText(MQ(bsu.sqh.dyL));
            aVar.wB("streamvideotitle");
            aVar.wA("streamvideowording");
            aVar.setText(MQ(bsu.sqh.dyM));
            aVar.wB("streamvideowording");
            aVar.wA("streamvideoweburl");
            aVar.setText(MQ(bsu.sqh.dyN));
            aVar.wB("streamvideoweburl");
            aVar.wA("streamvideothumburl");
            aVar.setText(MQ(bsu.sqh.dyO));
            aVar.wB("streamvideothumburl");
            aVar.wA("streamvideoaduxinfo");
            aVar.setText(MQ(bsu.sqh.dyP));
            aVar.wB("streamvideoaduxinfo");
            aVar.wA("streamvideopublishid");
            aVar.setText(MQ(bsu.sqh.dyQ));
            aVar.wB("streamvideopublishid");
            aVar.wB("streamvideo");
        }
        if (!(bsu.nsD == null || bi.oW(bsu.nsD.pLr))) {
            aVar.wA("websearch");
            aVar.wA("relevant_vid");
            aVar.setText(MQ(bsu.nsD.pLr));
            aVar.wB("relevant_vid");
            aVar.wA("relevant_expand");
            aVar.setText(MQ(bsu.nsD.pLs));
            aVar.wB("relevant_expand");
            aVar.wA("relevant_pre_searchid");
            aVar.setText(MQ(bsu.nsD.pLt));
            aVar.wB("relevant_pre_searchid");
            aVar.wA("relevant_shared_openid");
            aVar.setText(MQ(bsu.nsD.pLu));
            aVar.wB("relevant_shared_openid");
            aVar.wA("rec_category");
            aVar.setText(MQ(bsu.nsD.pLv));
            aVar.wB("rec_category");
            aVar.wA("shareUrl");
            aVar.setText(MQ(bsu.nsD.ixy));
            aVar.wB("shareUrl");
            aVar.wA("shareTitle");
            aVar.setText(MQ(bsu.nsD.ixz));
            aVar.wB("shareTitle");
            aVar.wA("shareDesc");
            aVar.setText(MQ(bsu.nsD.nzH));
            aVar.wB("shareDesc");
            aVar.wA("shareImgUrl");
            aVar.setText(MQ(bsu.nsD.pLw));
            aVar.wB("shareImgUrl");
            aVar.wA("shareString");
            aVar.setText(MQ(bsu.nsD.pLx));
            aVar.wB("shareString");
            aVar.wA("shareStringUrl");
            aVar.setText(MQ(bsu.nsD.pLy));
            aVar.wB("shareStringUrl");
            aVar.wA("source");
            aVar.setText(MQ(bsu.nsD.bhd));
            aVar.wB("source");
            aVar.wA("strPlayCount");
            aVar.setText(MQ(bsu.nsD.pLz));
            aVar.wB("strPlayCount");
            aVar.wA("titleUrl");
            aVar.setText(MQ(bsu.nsD.pLA));
            aVar.wB("titleUrl");
            aVar.wA("tagList");
            aVar.setText(MQ(bsu.nsD.pLC));
            aVar.wB("tagList");
            aVar.wB("websearch");
        }
        aVar.wA("contentDesc");
        aVar.setText(MQ(bsu.spZ));
        aVar.wB("contentDesc");
        aVar.wA("contentattr");
        aVar.setText(bsu.dwt);
        aVar.wB("contentattr");
        aVar.wA("sourceUserName");
        aVar.setText(MQ(bsu.qIb));
        aVar.wB("sourceUserName");
        aVar.wA("sourceNickName");
        aVar.setText(MQ(bsu.qIc));
        aVar.wB("sourceNickName");
        aVar.wA("statisticsData");
        aVar.setText(MQ(bsu.sqg));
        aVar.wB("statisticsData");
        aVar.wA("weappInfo");
        aVar.wA("appUserName");
        aVar.setText(MQ(bsu.sqi.username));
        aVar.wB("appUserName");
        aVar.wA("pagePath");
        aVar.setText(MQ(bsu.sqi.path));
        aVar.wB("pagePath");
        aVar.wB("weappInfo");
        aVar.wA("canvasInfoXml");
        aVar.setText(MQ(bsu.ogR));
        aVar.wB("canvasInfoXml");
        if (bsu.sqa != null) {
            float f = bsu.sqa.rmr;
            float f2 = bsu.sqa.rms;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", bsu.sqa.rmr);
                hashMap.put("latitude", bsu.sqa.rms);
                hashMap.put("city", bi.WS(MQ(bsu.sqa.eJJ)));
                hashMap.put("poiName", bi.WS(MQ(bsu.sqa.kFa)));
                hashMap.put("poiAddress", bi.WS(MQ(bsu.sqa.nOz)));
                hashMap.put("poiScale", bsu.sqa.rTI);
                hashMap.put("poiClassifyId", MQ(bsu.sqa.rTG));
                hashMap.put("poiClassifyType", bsu.sqa.nOB);
                hashMap.put("poiClickableStatus", bsu.sqa.rTJ);
                aVar.i("location", hashMap);
                aVar.wB("location");
            }
        }
        aVar.wA("ContentObject");
        aVar.wA("contentStyle");
        aVar.setText(bsu.sqc.ruz);
        aVar.wB("contentStyle");
        aVar.wA("contentSubStyle");
        aVar.setText(bsu.sqc.ruB);
        aVar.wB("contentSubStyle");
        aVar.wA(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
        aVar.setText(MQ(bsu.sqc.bHD));
        aVar.wB(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
        aVar.wA("description");
        aVar.setText(MQ(bsu.sqc.jOS));
        aVar.wB("description");
        aVar.wA("contentUrl");
        aVar.setText(MQ(bsu.sqc.jPK));
        aVar.wB("contentUrl");
        if (bsu.sqc.ruA.size() > 0) {
            aVar.wA("mediaList");
            Iterator it = bsu.sqc.ruA.iterator();
            while (it.hasNext()) {
                ate ate = (ate) it.next();
                aVar.wA("media");
                aVar.wA("id");
                if (MR(ate.ksA).equals("")) {
                    aVar.setText("0");
                } else {
                    aVar.setText(MR(ate.ksA));
                }
                aVar.wB("id");
                aVar.wA("type");
                aVar.setText(ate.hcE);
                aVar.wB("type");
                aVar.wA(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                aVar.setText(MQ(ate.bHD));
                aVar.wB(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                aVar.wA("description");
                aVar.setText(MQ(ate.jOS));
                aVar.wB("description");
                aVar.wA("private");
                aVar.setText(ate.rVG);
                aVar.wB("private");
                hashMap.clear();
                hashMap.put("type", ate.rVD);
                if (!bi.oW(ate.bKg)) {
                    hashMap.put("md5", ate.bKg);
                }
                if (!bi.oW(ate.rVZ)) {
                    hashMap.put("videomd5", ate.rVZ);
                }
                aVar.i("url", hashMap);
                aVar.setText(MQ(ate.jPK));
                aVar.wB("url");
                if (!(ate.rVE == null || ate.rVE.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", ate.rVF);
                    aVar.i("thumb", hashMap);
                    aVar.setText(MQ(ate.rVE));
                    aVar.wB("thumb");
                }
                if (ate.bID > 0) {
                    aVar.wA("subType");
                    aVar.setText(ate.bID);
                    aVar.wB("subType");
                }
                if (!bi.oW(ate.nME)) {
                    aVar.wA("userData");
                    aVar.setText(ate.nME);
                    aVar.wB("userData");
                }
                if (!(ate.rVI == null || ate.rVI.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", ate.rVJ);
                    aVar.i("lowBandUrl", hashMap);
                    aVar.setText(MQ(ate.rVI));
                    aVar.wB("lowBandUrl");
                }
                if (ate.rVH != null) {
                    hashMap.clear();
                    if (ate.rVH.rWu > 0.0f) {
                        hashMap.put("width", ate.rVH.rWu);
                    }
                    if (ate.rVH.rWv > 0.0f) {
                        hashMap.put("height", ate.rVH.rWv);
                    }
                    if (ate.rVH.rWw > 0.0f) {
                        hashMap.put("totalSize", ate.rVH.rWw);
                    }
                    aVar.i("size", hashMap);
                    aVar.wB("size");
                }
                aVar.wB("media");
            }
            aVar.wB("mediaList");
        }
        aVar.gVP.append(MQ(bsu.sqc.ruC));
        aVar.wB("ContentObject");
        if (bsu.nsB != null) {
            aVar.wA("actionInfo");
            if (bsu.nsB.raS != null) {
                aVar.wA("appMsg");
                aVar.wA("mediaTagName");
                aVar.setText(bsu.nsB.raS.raM);
                aVar.wB("mediaTagName");
                aVar.wA("messageExt");
                aVar.setText(bsu.nsB.raS.raN);
                aVar.wB("messageExt");
                aVar.wA("messageAction");
                aVar.setText(bsu.nsB.raS.raO);
                aVar.wB("messageAction");
                aVar.wB("appMsg");
            }
            aVar.wB("actionInfo");
        }
        if (!(bsu.sqb == null || bi.oW(bsu.sqb.ksA))) {
            str = bsu.nNV;
            bqw bqw = new bqw();
            if (str != null) {
                try {
                    bqw.aG(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            bqw.soY = new bqu();
            bqw.soY.jLY = bsu.sqb.ksA;
            try {
                str = Base64.encodeToString(bqw.toByteArray(), 0).replace("\n", "");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TimelineConvert", e2, "", new Object[0]);
            }
            bsu.nNV = str;
        }
        if (bsu.nNV != null) {
            aVar.wA("statExtStr");
            aVar.setText(bsu.nNV);
            aVar.wB("statExtStr");
        }
        aVar.wB("TimelineObject");
        str = aVar.gVP.toString();
        x.d("MicroMsg.TimelineConvert", "xmlContent: " + str);
        if (bl.z(str, "TimelineObject") != null) {
            return str;
        }
        x.e("MicroMsg.TimelineConvert", "xml is error");
        return "";
    }
}
