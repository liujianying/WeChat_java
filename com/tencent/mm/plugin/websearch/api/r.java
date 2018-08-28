package com.tencent.mm.plugin.websearch.api;

import android.content.res.AssetManager;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {
    private static e dKj = new 1();
    private static HashMap<String, a> pLD = new HashMap();
    private static Map<String, JSONObject> pLE = new HashMap();
    private static l pLF;
    private static HashMap<String, Long> pLG;
    private static String pLH = "";

    static {
        pLD.put("zh_CN", a.sWu);
        pLD.put("zh_HK", a.sWw);
        pLD.put("zh_TW", a.sWv);
        pLD.put("en", a.sWx);
        pLD.put("ar", a.sWy);
        pLD.put("de", a.sWz);
        pLD.put("de_DE", a.sWA);
        pLD.put("es", a.sWB);
        pLD.put("fr", a.sWC);
        pLD.put("he", a.sWD);
        pLD.put("hi", a.sWE);
        pLD.put("id", a.sWF);
        pLD.put("in", a.sWG);
        pLD.put("it", a.sWH);
        pLD.put("iw", a.sWI);
        pLD.put("ja", a.sWJ);
        pLD.put("ko", a.sWK);
        pLD.put("lo", a.sWL);
        pLD.put("ms", a.sWM);
        pLD.put("my", a.sWN);
        pLD.put("pl", a.sWO);
        pLD.put("pt", a.sWP);
        pLD.put("ru", a.sWQ);
        pLD.put("th", a.sWR);
        pLD.put("tr", a.sWS);
        pLD.put("vi", a.sWT);
    }

    public static boolean zZ(int i) {
        if (pLG == null) {
            pLG = new HashMap();
        }
        String fD = w.fD(ad.getContext());
        if (pLH == null || pLH.equalsIgnoreCase(fD)) {
            Long l = (Long) pLG.get(fD);
            if (l == null) {
                l = Long.valueOf(0);
            }
            if (System.currentTimeMillis() - l.longValue() < 600000) {
                return false;
            }
            JSONObject PV;
            int i2;
            pLG.put(fD, Long.valueOf(System.currentTimeMillis()));
            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[]{fD, Integer.valueOf(i), Long.valueOf(0)});
            String str = (String) g.Ei().DT().get(PW(fD), null);
            try {
                if (!bi.oW(str)) {
                    PV = PV(str);
                    i2 = PV != null ? a.pLK : PV.optLong("updateTime") + (PV.optLong("timevalSec") * 1000) < System.currentTimeMillis() ? a.pLJ : a.pLI;
                    if (i2 == a.pLI) {
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            PV = null;
            if (PV != null) {
            }
            if (i2 == a.pLI) {
                return false;
            }
        }
        pLH = fD;
        if (pLF != null) {
            g.DF().c(pLF);
            pLF = null;
        }
        pLF = new l(i);
        g.DF().a(1948, dKj);
        g.DF().a(pLF, 0);
        return true;
    }

    private static JSONObject PV(String str) {
        if (pLE.containsKey(str) && pLE.get(str) != null) {
            return (JSONObject) pLE.get(str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            pLE.put(str, jSONObject);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
            return null;
        }
    }

    private static a PW(String str) {
        a aVar = (a) pLD.get(str);
        if (aVar == null) {
            return a.sWx;
        }
        return aVar;
    }

    private static int fh(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("updateTime", System.currentTimeMillis());
            String jSONObject2 = jSONObject.toString();
            g.Ei().DT().a(PW(str), jSONObject2);
            try {
                pLE.put(jSONObject2, new JSONObject(jSONObject2));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
            }
            return a.pLI;
        } catch (JSONException e2) {
            return a.pLK;
        }
    }

    public static JSONObject PX(String str) {
        String str2;
        JSONObject optJSONObject;
        Object obj;
        String obj2;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        String str3 = "";
        try {
            str2 = (String) g.Ei().DT().get(PW(w.fD(ad.getContext())), null);
            if (!bi.oW(str2)) {
                jSONObject2 = PV(str2).optJSONObject("data").optJSONObject(str);
                str2 = "Config Storage";
                if (jSONObject2 == null) {
                    try {
                        str3 = bSW();
                        if (str3 != null) {
                            optJSONObject = new JSONObject(str3).optJSONObject("data").optJSONObject(str);
                            try {
                                str2 = "Asset";
                                obj2 = str2;
                            } catch (Exception e) {
                                jSONObject2 = optJSONObject;
                                obj2 = str2;
                                optJSONObject = jSONObject2;
                                if (optJSONObject == null) {
                                    jSONObject = new JSONObject();
                                } else {
                                    jSONObject = optJSONObject;
                                }
                                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                                return jSONObject;
                            }
                            if (optJSONObject == null) {
                                jSONObject = new JSONObject();
                            } else {
                                jSONObject = optJSONObject;
                            }
                            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                            return jSONObject;
                        }
                    } catch (Exception e2) {
                        obj2 = str2;
                        optJSONObject = jSONObject2;
                        if (optJSONObject == null) {
                            jSONObject = optJSONObject;
                        } else {
                            jSONObject = new JSONObject();
                        }
                        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                        return jSONObject;
                    }
                }
                optJSONObject = jSONObject2;
                obj2 = str2;
                if (optJSONObject == null) {
                    jSONObject = optJSONObject;
                } else {
                    jSONObject = new JSONObject();
                }
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                return jSONObject;
            }
        } catch (Exception e3) {
        }
        str2 = str3;
        if (jSONObject2 == null) {
            try {
                str3 = bSW();
                if (str3 != null) {
                    optJSONObject = new JSONObject(str3).optJSONObject("data").optJSONObject(str);
                    try {
                        str2 = "Asset";
                        obj2 = str2;
                    } catch (Exception e4) {
                        jSONObject2 = optJSONObject;
                        obj2 = str2;
                        optJSONObject = jSONObject2;
                        if (optJSONObject == null) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = optJSONObject;
                        }
                        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                        return jSONObject;
                    }
                    if (optJSONObject == null) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = optJSONObject;
                    }
                    x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                    return jSONObject;
                }
            } catch (Exception e22) {
                obj2 = str2;
                optJSONObject = jSONObject2;
                if (optJSONObject == null) {
                    jSONObject = optJSONObject;
                } else {
                    jSONObject = new JSONObject();
                }
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
                return jSONObject;
            }
        }
        optJSONObject = jSONObject2;
        obj2 = str2;
        if (optJSONObject == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = optJSONObject;
        }
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r4, str, obj2});
        return jSONObject;
    }

    public static String PY(String str) {
        String str2;
        JSONObject jSONObject;
        Object obj;
        JSONObject jSONObject2;
        Object opt;
        JSONObject jSONObject3 = null;
        String str3 = "";
        try {
            str2 = (String) g.Ei().DT().get(PW(w.fD(ad.getContext())), null);
            if (!bi.oW(str2)) {
                jSONObject3 = PV(str2);
                str2 = "Config Storage";
                if (jSONObject3 == null) {
                    String bSW;
                    try {
                        bSW = bSW();
                        if (bSW != null) {
                            jSONObject = new JSONObject(bSW);
                            try {
                                str2 = "Asset";
                                obj = str2;
                            } catch (Exception e) {
                                jSONObject3 = jSONObject;
                                bSW = str2;
                                jSONObject = jSONObject3;
                                if (jSONObject == null) {
                                    jSONObject2 = jSONObject;
                                } else {
                                    jSONObject2 = new JSONObject();
                                }
                                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                                opt = jSONObject2.opt(str);
                                return opt == null ? opt.toString() : "";
                            }
                            if (jSONObject == null) {
                                jSONObject2 = new JSONObject();
                            } else {
                                jSONObject2 = jSONObject;
                            }
                            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                            opt = jSONObject2.opt(str);
                            if (opt == null) {
                            }
                        }
                    } catch (Exception e2) {
                        bSW = str2;
                        jSONObject = jSONObject3;
                        if (jSONObject == null) {
                            jSONObject2 = new JSONObject();
                        } else {
                            jSONObject2 = jSONObject;
                        }
                        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                        opt = jSONObject2.opt(str);
                        if (opt == null) {
                        }
                    }
                }
                jSONObject = jSONObject3;
                obj = str2;
                if (jSONObject == null) {
                    jSONObject2 = jSONObject;
                } else {
                    jSONObject2 = new JSONObject();
                }
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                opt = jSONObject2.opt(str);
                if (opt == null) {
                }
            }
        } catch (Exception e3) {
        }
        str2 = str3;
        if (jSONObject3 == null) {
            String bSW2;
            try {
                bSW2 = bSW();
                if (bSW2 != null) {
                    jSONObject = new JSONObject(bSW2);
                    try {
                        str2 = "Asset";
                        obj = str2;
                    } catch (Exception e4) {
                        jSONObject3 = jSONObject;
                        bSW2 = str2;
                        jSONObject = jSONObject3;
                        if (jSONObject == null) {
                            jSONObject2 = jSONObject;
                        } else {
                            jSONObject2 = new JSONObject();
                        }
                        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                        opt = jSONObject2.opt(str);
                        return opt == null ? opt.toString() : "";
                    }
                    if (jSONObject == null) {
                        jSONObject2 = new JSONObject();
                    } else {
                        jSONObject2 = jSONObject;
                    }
                    x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                    opt = jSONObject2.opt(str);
                    if (opt == null) {
                    }
                }
            } catch (Exception e22) {
                bSW2 = str2;
                jSONObject = jSONObject3;
                if (jSONObject == null) {
                    jSONObject2 = new JSONObject();
                } else {
                    jSONObject2 = jSONObject;
                }
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                opt = jSONObject2.opt(str);
                if (opt == null) {
                }
            }
        }
        jSONObject = jSONObject3;
        obj = str2;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        } else {
            jSONObject2 = jSONObject;
        }
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
        opt = jSONObject2.opt(str);
        if (opt == null) {
        }
    }

    private static String bSW() {
        Throwable e;
        InputStream inputStream = null;
        AssetManager assets = ad.getContext().getAssets();
        InputStream open;
        try {
            open = assets.open("webconfig/default." + w.fD(ad.getContext()));
            try {
                String str = new String(com.tencent.mm.a.e.g(open));
                com.tencent.mm.a.e.f(open);
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.f(open);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    inputStream = open;
                    com.tencent.mm.a.e.f(inputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            open = null;
        } catch (Throwable th2) {
            e = th2;
            com.tencent.mm.a.e.f(inputStream);
            throw e;
        }
    }
}
