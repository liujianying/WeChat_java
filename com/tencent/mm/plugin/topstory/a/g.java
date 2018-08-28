package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    public static final String cz(List<String> list) {
        for (String str : list) {
            if (!bi.oW(str)) {
                return str;
            }
        }
        return null;
    }

    public static final bth a(cfn cfn, int i, String str) {
        int i2 = 0;
        bth bth = new bth();
        bth.sqA = p.zK(i);
        bth.sqM = new bti();
        bth.sqM.title = cfn.ixz;
        bth.sqM.sqZ = "video-" + cfn.pLr;
        bth.sqM.sqS = cfn.pLr;
        bth.sqM.sqQ = "http://shp.qpic.cn/qqvideo_ori/0/" + cfn.pLr + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
        bth.sqM.pLz = cfn.pLz;
        bth.sqM.bhd = cfn.bhd;
        bth.sqM.lRt = cfn.lRt;
        bth.sqM.sqV = cfn.pLs;
        bth.sqM.sqX = cfn.pLs;
        bth.sqM.pLx = cfn.pLx;
        bth.sqM.dwJ = 496;
        bth.sqM.dwI = 280;
        bth.sqM.timestamp = System.currentTimeMillis();
        if (!bi.oW(cfn.pLC)) {
            try {
                JSONArray jSONArray = new JSONArray(cfn.pLC);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    bnq bnq = new bnq();
                    bnq.id = jSONObject.optString("id");
                    bnq.bSc = jSONObject.optString("wording");
                    bnq.slJ = jSONObject.optLong("category");
                    bnq.actionType = jSONObject.optInt("actionType");
                    bnq.url = jSONObject.optString("url");
                    bnq.title = jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                    bnq.hwC = jSONObject.optString("subTitle");
                    bth.sqM.rBV.add(bnq);
                }
            } catch (Exception e) {
            }
        }
        bth.sqH = cfn.pLr;
        bth.sqI = cfn.pLs;
        bth.sqJ = cfn.pLt;
        bth.sqK = cfn.pLu;
        bth.sqL = cfn.pLv;
        bth.sqO = cfn.pLv;
        bth.sqP = false;
        if (!bi.oW(cfn.pLB)) {
            try {
                JSONArray jSONArray2 = new JSONArray(cfn.pLB);
                while (i2 < jSONArray2.length()) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    ps psVar = new ps();
                    psVar.aAL = jSONObject2.optString("key", "");
                    psVar.rtU = (long) jSONObject2.optInt("uintValue", 0);
                    psVar.rtV = jSONObject2.optString("textValue", "");
                    bth.pKZ.add(psVar);
                    i2++;
                }
            } catch (Exception e2) {
            }
        }
        bth.fuu = "";
        bth.scene = i;
        bth.bHt = str;
        return bth;
    }

    public static final bth ab(JSONObject jSONObject) {
        int i;
        int i2 = 0;
        bth bth = new bth();
        bth.bHt = jSONObject.optString("query", "");
        bth.scene = jSONObject.optInt("scene", 21);
        bth.sqA = p.zK(bth.scene);
        bth.fuu = jSONObject.optString("searchId", "");
        bth.sqP = true;
        String optString = jSONObject.optString("videoId", "");
        Object arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("videoUrls", ""));
            if (jSONArray.length() > 0) {
                for (i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
        }
        if (!bi.oW(optString)) {
            JSONObject jSONObject2;
            JSONArray jSONArray2;
            String str = "http://shp.qpic.cn/qqvideo_ori/0/" + optString + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
            bth.sqM = new bti();
            bth.sqM.title = jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE, "");
            bth.sqM.sqQ = str;
            bth.sqM.sqR = jSONObject.optInt("mediaDuration", 0);
            bth.sqM.sqS = optString;
            bth.sqM.dwJ = 496;
            bth.sqM.dwI = 280;
            bth.sqM.pLz = jSONObject.optString("strPlayCount", "");
            bth.sqM.ixy = jSONObject.optString("shareUrl", "");
            bth.sqM.ixz = jSONObject.optString("shareTitle", "");
            bth.sqM.pLA = jSONObject.optString("titleUrl", "");
            bth.sqM.nzH = jSONObject.optString("shareDesc", "");
            bth.sqM.pLw = jSONObject.optString("shareImgUrl", "");
            bth.sqM.pLx = jSONObject.optString("shareString", "");
            bth.sqM.pLy = jSONObject.optString("shareStringUrl", "");
            bth.sqM.bhd = jSONObject.optString("source", "");
            bth.sqM.lRt = jSONObject.optString("sourceUrl", "");
            bth.sqM.sqT = (long) jSONObject.optInt("relevant_category", -1);
            bth.sqM.sqU = jSONObject.optString("shareOpenId", "");
            bth.sqM.sqZ = jSONObject.optString("docID", "");
            bth.sqM.srb = (long) jSONObject.optInt("videoSize", 0);
            bth.sqM.timestamp = bi.VG();
            bth.sqM.sqW = jSONObject.optInt("itemType", 0);
            try {
                jSONObject2 = new JSONObject(jSONObject.optString("block", ""));
                bth.sqM.sra = jSONObject2.optLong("resultType");
                bth.sqM.bHu = jSONObject2.optLong("type");
            } catch (JSONException e2) {
            }
            bth.sqM.sqV = jSONObject.optString("expand", "");
            bth.sqM.srd.addAll(arrayList);
            bth.sqM.videoUrl = cz(arrayList);
            str = jSONObject.optString("tagList", "");
            if (!bi.oW(str)) {
                try {
                    jSONArray2 = new JSONArray(str);
                    for (i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        bnq bnq = new bnq();
                        bnq.id = jSONObject3.optString("id");
                        bnq.bSc = jSONObject3.optString("wording");
                        bnq.slJ = jSONObject3.optLong("category");
                        bnq.actionType = jSONObject3.optInt("actionType");
                        bnq.url = jSONObject3.optString("url");
                        bnq.title = jSONObject3.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                        bnq.hwC = jSONObject3.optString("subTitle");
                        bth.sqM.rBV.add(bnq);
                    }
                } catch (Exception e3) {
                }
            }
            str = jSONObject.optString("feedback", "");
            if (!bi.oW(str)) {
                try {
                    jSONArray2 = new JSONArray(str);
                    for (i = 0; i < jSONArray2.length(); i++) {
                        xe xeVar = new xe();
                        xeVar.id = jSONArray2.optJSONObject(i).optString("id", "");
                        xeVar.bSc = jSONArray2.optJSONObject(i).optString("wording", "");
                        bth.sqM.sre.add(xeVar);
                    }
                } catch (JSONException e4) {
                }
            }
            bth.sqL = bth.sqM.sqT;
            bth.sqO = bth.sqM.sqT;
            bth.sqI = jSONObject.optString("expand", "");
            bth.sqJ = bth.fuu;
            bth.sqH = bth.sqM.sqS;
            str = jSONObject.optString("extReqParams", "");
            if (!bi.oW(str)) {
                try {
                    jSONArray2 = new JSONArray(str);
                    while (i2 < jSONArray2.length()) {
                        jSONObject2 = jSONArray2.getJSONObject(i2);
                        ps psVar = new ps();
                        psVar.aAL = jSONObject2.optString("key", "");
                        psVar.rtU = (long) jSONObject2.optInt("uintValue", 0);
                        psVar.rtV = jSONObject2.optString("textValue", "");
                        bth.pKZ.add(psVar);
                        i2++;
                    }
                } catch (Exception e5) {
                }
            }
        }
        return bth;
    }

    public static final bth O(Map<String, Object> map) {
        int i;
        int i2 = 0;
        bth bth = new bth();
        bth.bHt = p.t(map, "query");
        bth.scene = p.c(map, "scene", 21);
        bth.sqA = p.zK(bth.scene);
        bth.fuu = p.t(map, "searchId");
        bth.sqP = true;
        String t = p.t(map, "videoId");
        Object arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(p.t(map, "videoUrls"));
            if (jSONArray.length() > 0) {
                for (i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
        }
        if (!bi.oW(t)) {
            JSONObject jSONObject;
            JSONArray jSONArray2;
            String str = "http://shp.qpic.cn/qqvideo_ori/0/" + t + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
            bth.sqM = new bti();
            bth.sqM.title = p.t(map, FFmpegMetadataRetriever.METADATA_KEY_TITLE);
            bth.sqM.sqQ = str;
            bth.sqM.sqR = p.c(map, "mediaDuration", 0);
            bth.sqM.sqS = t;
            bth.sqM.dwJ = 496;
            bth.sqM.dwI = 280;
            bth.sqM.pLz = p.t(map, "strPlayCount");
            bth.sqM.ixy = p.t(map, "shareUrl");
            bth.sqM.ixz = p.t(map, "shareTitle");
            bth.sqM.pLA = p.t(map, "titleUrl");
            bth.sqM.nzH = p.t(map, "shareDesc");
            bth.sqM.pLw = p.t(map, "shareImgUrl");
            bth.sqM.pLx = p.t(map, "shareString");
            bth.sqM.pLy = p.t(map, "shareStringUrl");
            bth.sqM.bhd = p.t(map, "source");
            bth.sqM.lRt = p.t(map, "sourceUrl");
            bth.sqM.sqT = p.a(map, "relevant_category", -1);
            bth.sqM.sqU = p.t(map, "shareOpenId");
            bth.sqM.sqZ = p.t(map, "docID");
            bth.sqM.srb = p.a(map, "videoSize", 0);
            bth.sqM.timestamp = bi.VG();
            bth.sqM.sqW = p.c(map, "itemType", 0);
            try {
                jSONObject = new JSONObject(p.t(map, "block"));
                bth.sqM.sra = jSONObject.optLong("resultType");
                bth.sqM.bHu = jSONObject.optLong("type");
            } catch (JSONException e2) {
            }
            bth.sqM.sqV = p.t(map, "expand");
            bth.sqM.srd.addAll(arrayList);
            bth.sqM.videoUrl = cz(arrayList);
            str = p.t(map, "tagList");
            if (!bi.oW(str)) {
                try {
                    jSONArray2 = new JSONArray(str);
                    for (i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                        bnq bnq = new bnq();
                        bnq.id = jSONObject2.optString("id");
                        bnq.bSc = jSONObject2.optString("wording");
                        bnq.slJ = jSONObject2.optLong("category");
                        bnq.actionType = jSONObject2.optInt("actionType");
                        bnq.url = jSONObject2.optString("url");
                        bnq.title = jSONObject2.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                        bnq.hwC = jSONObject2.optString("subTitle");
                        bth.sqM.rBV.add(bnq);
                    }
                } catch (Exception e3) {
                }
            }
            bth.sqL = bth.sqM.sqT;
            bth.sqO = bth.sqM.sqT;
            bth.sqI = p.t(map, "expand");
            bth.sqJ = bth.fuu;
            bth.sqH = bth.sqM.sqS;
            str = p.t(map, "extReqParams");
            if (!bi.oW(str)) {
                try {
                    jSONArray2 = new JSONArray(str);
                    while (i2 < jSONArray2.length()) {
                        jSONObject = jSONArray2.getJSONObject(i2);
                        ps psVar = new ps();
                        psVar.aAL = jSONObject.optString("key", "");
                        psVar.rtU = (long) jSONObject.optInt("uintValue", 0);
                        psVar.rtV = jSONObject.optString("textValue", "");
                        bth.pKZ.add(psVar);
                        i2++;
                    }
                } catch (Exception e4) {
                }
            }
        }
        return bth;
    }

    public static final bth a(bth bth) {
        bth bth2 = new bth();
        bth2.sqA = bth.sqA;
        bth2.scene = bth.scene;
        bth2.bHt = bth.bHt;
        bth2.fuu = bth.fuu;
        bth2.sqM = bth.sqM;
        bth2.sqL = bth.sqL;
        bth2.sqI = bth.sqI;
        bth2.sqJ = bth.sqJ;
        bth2.sqK = bth.sqK;
        bth2.sqH = bth.sqH;
        bth2.sqO = bth.sqO;
        return bth2;
    }

    public static String bHB() {
        return ad.getContext().getCacheDir() + "topstory/";
    }

    public static String Os(String str) {
        return ad.getContext().getCacheDir() + "topstory/" + str + "/";
    }

    public static boolean bHC() {
        return 1 >= x.getLogLevel();
    }

    public static JSONArray cA(List<bnq> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return jSONArray;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                bnq bnq = (bnq) list.get(i2);
                jSONObject.put("id", bnq.id);
                jSONObject.put("wording", bnq.bSc);
                jSONObject.put("category", bnq.slJ);
                jSONObject.put("actionType", bnq.actionType);
                jSONObject.put("url", bnq.url);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, bnq.title);
                jSONObject.put("subTitle", bnq.hwC);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }

    public static String n(HashMap<String, String> hashMap) {
        hashMap.put("lang", w.fD(ad.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(p.zL(1).Oe()));
        hashMap.put("netType", p.bjC());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", d.CLIENT_VERSION);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(p.zL(1).adP());
        stringBuffer.append("/");
        stringBuffer.append("app.html");
        stringBuffer.append("?");
        stringBuffer.append(p.U(hashMap));
        return stringBuffer.toString();
    }
}
