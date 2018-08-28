package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.ui.d.3;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    bte ccA;
    private b oCA;
    TopStoryWebView oCB;
    private boolean oCC = true;
    public a oCq;

    public d(TopStoryWebView topStoryWebView, bte bte, b bVar) {
        this.oCB = topStoryWebView;
        this.ccA = bte;
        this.oCA = bVar;
    }

    @JavascriptInterface
    public final String getSearchData(String str) {
        String str2 = null;
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[]{str});
        com.tencent.mm.plugin.topstory.ui.d.c(this.ccA, "getSearchData", System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject(str);
            bte bte = new bte();
            bte.sqA = this.ccA.sqA;
            bte.bHt = jSONObject.optString("query", "");
            bte.offset = jSONObject.optInt("offset", 0);
            bte.scene = jSONObject.optInt("scene", 21);
            bte.bJK = jSONObject.optString("sessionId", "");
            bte.bWr = jSONObject.optString("subSessionId", "");
            bte.fuu = jSONObject.optString("searchId", "");
            bte.kJG = jSONObject.optString("requestId", "");
            bte.bxk = jSONObject.optInt("tagId", 0);
            bte.pLi = jSONObject.optString("navigationId", "");
            String optString = jSONObject.optString("extReqParams", "");
            if (!bi.oW(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    ps psVar = new ps();
                    psVar.aAL = jSONObject2.optString("key", "");
                    psVar.rtU = (long) jSONObject2.optInt("uintValue", 0);
                    psVar.rtV = jSONObject2.optString("textValue", "");
                    bte.pKZ.add(psVar);
                }
            }
            b bVar = this.oCA;
            if (bVar.oCs != null) {
                if (bVar.oCs.oCz.bJK.equals(bte.bJK) && System.currentTimeMillis() - bVar.oCs.hnN <= 60000) {
                    str2 = bVar.oCs.oCy;
                }
                bVar.oCs = null;
                if (bi.oW(str2)) {
                    x.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
                } else {
                    x.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[]{Integer.valueOf(str2.length())});
                }
            }
            if (bi.oW(str2)) {
                this.oCA.a(bte, true);
            } else {
                Ot(str2);
            }
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "getSearchData", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String reportSearchStatistics(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchStatistics %s", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("logId", 0);
            if (optInt != 14904) {
                f.mDy.k(optInt, jSONObject.optString("logString", ""));
            }
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchStatistics", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String reportSearchRealTimeStatistics(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchRealTimeStatistics %s", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            bgx bgx = new bgx();
            bgx.shQ = jSONObject.optString("logString", "");
            g.DF().a(new n(bgx), 0);
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeStatistics", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String stage(String str) {
        try {
            x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", new Object[]{str});
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.keys() != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    com.tencent.mm.plugin.topstory.ui.d.c(this.ccA, str2, jSONObject.optLong(str2));
                }
            }
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "stage", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String startSearchItemDetailPage(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("jumpUrl", "");
            String optString2 = jSONObject.optString("publishId", "");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            intent.putExtra("KPublisherId", optString2);
            x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[]{optString, optString2});
            com.tencent.mm.bg.d.b(this.oCq.baA(), "webview", ".ui.tools.WebViewUI", intent);
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeReport", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String log(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "log: %s", new Object[]{str});
        return bIG().toString();
    }

    @JavascriptInterface
    public final String getNetworkType(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getNetworkType %s", new Object[]{str});
        try {
            JSONObject bIG = bIG();
            String bjC = p.bjC();
            bIG.put("subtype", bjC);
            if (bjC.equals("wifi")) {
                bIG.put("err_msg", "network_type:wifi");
            } else if (bjC.equals("fail")) {
                bIG.put("err_msg", "network_type:fail");
            } else {
                bIG.put("err_msg", "network_type:wwan");
            }
            return bIG.toString();
        } catch (Exception e) {
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String updateReddotTimeStamps(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", new Object[]{str});
        try {
            ((b) g.n(b.class)).getRedDotMgr().fu(new JSONObject(str).optLong("reddotTimeStamps", 0));
            return bIG().toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "updateReddotTimeStamps", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String doGoToRecVideoList(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[]{str});
        try {
            bth ab = com.tencent.mm.plugin.topstory.a.g.ab(new JSONObject(str));
            Intent intent = new Intent();
            try {
                intent.putExtra("key_context", ab.toByteArray());
            } catch (IOException e) {
            }
            if (this.oCq != null) {
                p.c(this.oCq.baA(), ".ui.video.TopStoryVideoStreamUI", intent);
            }
            return bIG().toString();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "doGoToRecVideoList", new Object[0]);
            return bIH().toString();
        }
    }

    @JavascriptInterface
    public final String webViewUIReady(String str) {
        int i = 1;
        try {
            if (this.oCC) {
                this.oCC = false;
                if (this.oCq != null) {
                    this.oCq.bHG();
                }
                com.tencent.mm.plugin.topstory.ui.d.c(this.ccA, "webViewUIReady", System.currentTimeMillis());
                bte bte = this.ccA;
                Collections.sort(bte.sqB, new 3());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i2 = i;
                    if (i2 >= bte.sqB.size()) {
                        break;
                    }
                    stringBuffer.append(((btg) bte.sqB.get(i2 - 1)).name);
                    stringBuffer.append("->");
                    stringBuffer.append(((btg) bte.sqB.get(i2)).name);
                    stringBuffer.append(":");
                    stringBuffer.append(((btg) bte.sqB.get(i2)).timestamp - ((btg) bte.sqB.get(i2 - 1)).timestamp);
                    stringBuffer.append("\n");
                    i = i2 + 1;
                }
                if (bte.sqB.size() > 2) {
                    stringBuffer.append("TotalUseTime:");
                    stringBuffer.append(((btg) bte.sqB.get(bte.sqB.size() - 1)).timestamp - ((btg) bte.sqB.get(0)).timestamp);
                    stringBuffer.append("\n");
                }
                bte.sqB.clear();
                stringBuffer.append("============");
                stringBuffer.append("\n");
                if (com.tencent.mm.plugin.topstory.a.g.bHC()) {
                    e.post(new com.tencent.mm.plugin.topstory.ui.d.a(stringBuffer.toString()), "TopStory.SaveTraceTask");
                }
                String stringBuffer2 = stringBuffer.toString();
                x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", new Object[]{stringBuffer2});
            }
            return bIG().toString();
        } catch (Exception e) {
            return bIH().toString();
        }
    }

    public final void Ot(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("json", str);
            jSONObject.put("newQuery", this.oCC);
            jSONObject.put("isCache", false);
            ah.A(new 1(this, jSONObject));
        } catch (Exception e) {
        }
    }

    public final void Ox(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", str);
            jSONObject.put("sessionId", this.ccA.bJK);
            jSONObject.put("subSessionId", this.ccA.bWr);
            jSONObject.put("scene", this.ccA.scene);
            ah.A(new 2(this, jSONObject));
        } catch (Exception e) {
        }
    }

    private static JSONObject bIG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private static JSONObject bIH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @JavascriptInterface
    public final String openSearchWebView(String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("actionType");
            String optString = jSONObject.optString("extParams", "");
            String optString2 = jSONObject.optString("publishId", "");
            String str2;
            switch (optInt) {
                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", jSONObject.optString("jumpUrl", ""));
                    intent.putExtra("KPublisherId", optString2);
                    x.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[]{str2, optString2});
                    com.tencent.mm.bg.d.b(this.oCq.baA(), "webview", ".ui.tools.WebViewUI", intent);
                    break;
                case 3:
                    optString2 = jSONObject.optString("query", "");
                    int optInt2 = jSONObject.optInt("scene", 0);
                    String optString3 = jSONObject.optString("sessionId", "");
                    String zK = p.zK(optInt2);
                    int optInt3 = jSONObject.optInt("tagId", 0);
                    Object optString4 = jSONObject.optString("nativeConfig", "");
                    str2 = null;
                    if (!TextUtils.isEmpty(optString4)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString4);
                            if (jSONObject2.has(FFmpegMetadataRetriever.METADATA_KEY_TITLE)) {
                                str2 = jSONObject2.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "", new Object[0]);
                        }
                    }
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", String.valueOf(optInt2));
                    hashMap.put("query", optString2);
                    hashMap.put("sessionId", optString3);
                    hashMap.put("extParams", optString);
                    hashMap.put("subSessionId", zK);
                    hashMap.put("requestId", valueOf);
                    hashMap.put("pRequestId", valueOf);
                    hashMap.put("seq", valueOf);
                    bte bte = new bte();
                    bte.sqA = com.tencent.mm.plugin.topstory.ui.d.bHF();
                    bte.scene = optInt2;
                    bte.fuu = "";
                    bte.bHt = optString2;
                    bte.bJK = optString3;
                    bte.bWr = optString3;
                    bte.sqC = 2;
                    bte.url = com.tencent.mm.plugin.topstory.a.g.n(hashMap);
                    bte.sqD = str2;
                    bte.bxk = optInt3;
                    bte.kJG = valueOf;
                    ps psVar = new ps();
                    psVar.aAL = "rec_category";
                    psVar.rtU = (long) optInt3;
                    psVar.rtV = String.valueOf(optInt3);
                    bte.pKZ.add(psVar);
                    com.tencent.mm.plugin.topstory.ui.d.a(ad.getContext(), bte, valueOf);
                    break;
            }
            return bIG().toString();
        } catch (Exception e2) {
            return bIH().toString();
        }
    }
}
