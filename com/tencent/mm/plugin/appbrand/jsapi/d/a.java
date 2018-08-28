package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Color;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.c.d;
import com.tencent.mm.plugin.appbrand.widget.input.c.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a<P extends f> extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    protected boolean a(P p, JSONObject jSONObject, p pVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                p.gLB = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "width"));
                try {
                    p.gLC = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "height"));
                } catch (Exception e2) {
                }
                p.gLD = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "top"));
                p.gLE = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "left"));
            } catch (Exception e3) {
                e = e3;
                if (!aiT()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bi.i(e)});
                    pVar.E(i, f("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 == null) {
                    p.gLK = jSONObject2.optString("fontWeight", null);
                    try {
                        p.gLF = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "minHeight"));
                    } catch (Exception e4) {
                    }
                    try {
                        p.gLG = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "maxHeight"));
                    } catch (Exception e5) {
                    }
                    p.fTI = jSONObject2.optString("textAlign", null);
                    try {
                        p.gLI = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                    } catch (Exception e6) {
                    }
                    try {
                        p.gLH = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                    } catch (Exception e7) {
                    }
                    try {
                        p.gLJ = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.h(jSONObject2, "fontSize"));
                    } catch (Exception e8) {
                    }
                    try {
                        p.gLW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "marginBottom"));
                    } catch (Exception e9) {
                        p.gLW = null;
                    }
                    p.gMa = d.bu(jSONObject2.opt("lineSpace"));
                    if (p.gMa != null) {
                        p.gMa = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMa.intValue()));
                    }
                    p.gMb = d.bu(jSONObject2.opt("lineHeight"));
                    if (p.gMb != null) {
                        p.gMb = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMb.intValue()));
                    }
                } else if (!aiT()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                    pVar.E(i, f("fail:invalid data", null));
                    return false;
                }
                p.gLU = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.gLA = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
                p.gLL = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.gLM = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.gLP = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
                p.gLO = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject3, "fontSize"));
                p.gLN = jSONObject3.optString("fontWeight", "normal");
                p.gLR = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                p.gLQ = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.gLV = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.gLX = b.wj(jSONObject.optString("confirmType"));
                p.gLY = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                p.gLZ = h.bs(jSONObject.opt("adjustPosition"));
                return true;
            }
        } catch (Exception e10) {
            e = e10;
            jSONObject2 = null;
            if (aiT()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bi.i(e)});
                pVar.E(i, f("fail:invalid data", null));
                return false;
            }
            if (jSONObject2 == null) {
                p.gLK = jSONObject2.optString("fontWeight", null);
                try {
                    p.gLF = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "minHeight"));
                } catch (Exception e42) {
                }
                try {
                    p.gLG = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "maxHeight"));
                } catch (Exception e52) {
                }
                p.fTI = jSONObject2.optString("textAlign", null);
                try {
                    p.gLI = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                } catch (Exception e62) {
                }
                try {
                    p.gLH = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                } catch (Exception e72) {
                }
                try {
                    p.gLJ = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.h(jSONObject2, "fontSize"));
                } catch (Exception e82) {
                }
                try {
                    p.gLW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "marginBottom"));
                } catch (Exception e92) {
                    p.gLW = null;
                }
                p.gMa = d.bu(jSONObject2.opt("lineSpace"));
                if (p.gMa != null) {
                    p.gMa = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMa.intValue()));
                }
                p.gMb = d.bu(jSONObject2.opt("lineHeight"));
                if (p.gMb != null) {
                    p.gMb = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMb.intValue()));
                }
            } else if (!aiT()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                pVar.E(i, f("fail:invalid data", null));
                return false;
            }
            p.gLU = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
            p.gLA = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
            p.gLL = Integer.valueOf(jSONObject.getInt("maxLength"));
            p.gLM = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.gLP = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.gLO = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject3, "fontSize"));
            p.gLN = jSONObject3.optString("fontWeight", "normal");
            p.gLR = Boolean.valueOf(jSONObject.getBoolean("hidden"));
            p.gLQ = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.gLV = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.gLX = b.wj(jSONObject.optString("confirmType"));
            p.gLY = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            p.gLZ = h.bs(jSONObject.opt("adjustPosition"));
            return true;
        }
        if (jSONObject2 == null) {
            p.gLK = jSONObject2.optString("fontWeight", null);
            try {
                p.gLF = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "minHeight"));
            } catch (Exception e422) {
            }
            try {
                p.gLG = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "maxHeight"));
            } catch (Exception e522) {
            }
            p.fTI = jSONObject2.optString("textAlign", null);
            try {
                p.gLI = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
            } catch (Exception e622) {
            }
            try {
                p.gLH = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
            } catch (Exception e722) {
            }
            try {
                p.gLJ = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.h(jSONObject2, "fontSize"));
            } catch (Exception e822) {
            }
            try {
                p.gLW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject2, "marginBottom"));
            } catch (Exception e922) {
                p.gLW = null;
            }
            p.gMa = d.bu(jSONObject2.opt("lineSpace"));
            if (p.gMa != null) {
                p.gMa = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMa.intValue()));
            }
            p.gMb = d.bu(jSONObject2.opt("lineHeight"));
            if (p.gMb != null) {
                p.gMb = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lP(p.gMb.intValue()));
            }
        } else if (!aiT()) {
            x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            pVar.E(i, f("fail:invalid data", null));
            return false;
        }
        try {
            p.gLU = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception e11) {
        }
        p.gLA = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
        try {
            p.gLL = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception e12) {
        }
        p.gLM = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.gLP = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.gLO = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.f(jSONObject3, "fontSize"));
            p.gLN = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e13) {
        }
        try {
            p.gLR = Boolean.valueOf(jSONObject.getBoolean("hidden"));
        } catch (JSONException e14) {
            p.gLR = null;
        }
        try {
            p.gLQ = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e15) {
            p.gLQ = null;
        }
        try {
            p.gLV = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e16) {
            p.gLV = null;
        }
        p.gLX = b.wj(jSONObject.optString("confirmType"));
        try {
            p.gLY = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e17) {
            p.gLY = null;
        }
        p.gLZ = h.bs(jSONObject.opt("adjustPosition"));
        return true;
    }

    protected boolean aiT() {
        return false;
    }

    protected static String kJ(int i) {
        return u.Hx().v("AppBrandJsInput@" + i, true).getString("passing_data", "");
    }

    protected static void L(int i, String str) {
        u.Hx().v("AppBrandJsInput@" + i, true).O("passing_data", str);
    }

    protected static void a(int i, p pVar) {
        if (pVar != null) {
            u.Hx().v("AppBrandJsInput@" + i, true).p("webview_reference", new WeakReference(pVar));
        }
    }

    protected static p kK(int i) {
        u.b ia = u.Hx().ia("AppBrandJsInput@" + i);
        if (ia == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) ia.get("webview_reference", null);
        return weakReference == null ? null : (p) weakReference.get();
    }
}
