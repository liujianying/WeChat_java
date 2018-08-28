package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.wepkg.model.f.3;
import com.tencent.mm.plugin.game.wepkg.model.f.c;
import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

class f$3$1 implements Runnable {
    final /* synthetic */ 3 kfw;

    f$3$1(3 3) {
        this.kfw = 3;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootDir", this.kfw.kft);
            Map hashMap = new HashMap();
            f.a(this.kfw.kfu, hashMap);
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : hashMap.entrySet()) {
                if (((List) entry.getValue()).size() != 0) {
                    JSONArray jSONArray2;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("pkgId", entry.getKey());
                    WepkgVersion Em = g.Em((String) entry.getKey());
                    if (Em != null) {
                        jSONObject2.put("controlInfo", Em.aVx());
                    }
                    List<WepkgPreloadFile> Ep = g.Ep((String) entry.getKey());
                    if (!bi.cX(Ep)) {
                        jSONArray2 = new JSONArray();
                        for (WepkgPreloadFile aVx : Ep) {
                            jSONArray2.put(aVx.aVx());
                        }
                        jSONObject2.put("preloadFilesInfo", jSONArray2);
                    }
                    jSONArray2 = new JSONArray();
                    for (c cVar : (List) entry.getValue()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("version", cVar.version);
                        if (!bi.oW(cVar.kfy)) {
                            File file = new File(cVar.kfy);
                            if (file.exists() && file.isFile()) {
                                jSONObject3.put("md5", g.m(file));
                                jSONObject3.put("size", file.length());
                                cdl cdl = new d(file).kfc;
                                if (cdl != null) {
                                    jSONObject3.put("charset", cdl.syW);
                                    jSONObject3.put("desc", cdl.jOS);
                                    if (cdl.syV != null) {
                                        JSONArray jSONArray3 = new JSONArray();
                                        Iterator it = cdl.syV.iterator();
                                        while (it.hasNext()) {
                                            xg xgVar = (xg) it.next();
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("rid", xgVar.rDd);
                                            jSONObject4.put("offset", xgVar.rDe);
                                            jSONObject4.put("size", xgVar.hcy);
                                            jSONObject4.put("mimeType", xgVar.rDf);
                                            jSONArray3.put(jSONObject4);
                                        }
                                        jSONObject3.put("resList", jSONArray3);
                                    }
                                }
                            }
                        }
                        List<String> list = cVar.kfz;
                        if (!bi.cX(list)) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String put : list) {
                                jSONArray4.put(put);
                            }
                            jSONObject3.put("preloadFiles", jSONArray4);
                        }
                        jSONArray2.put(jSONObject3);
                    }
                    jSONObject2.put("versionList", jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("pkgList", jSONArray);
            if (this.kfw.kfv != null) {
                this.kfw.kfv.L(jSONObject);
            }
        } catch (Exception e) {
            if (this.kfw.kfv != null) {
                this.kfw.kfv.L(null);
            }
        }
    }
}
