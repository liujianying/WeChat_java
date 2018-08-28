package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.game.gamewebview.a.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    private Map<String, c> fEL;
    public Handler fwr;
    protected com.tencent.mm.plugin.game.gamewebview.ui.d jGw;
    public JSONObject jGx;
    public HashSet<String> jGy = new HashSet();

    public d(com.tencent.mm.plugin.game.gamewebview.ui.d dVar) {
        this.jGw = dVar;
        this.fEL = e.aSw();
        HandlerThread handlerThread = new HandlerThread("GameWebviewAsyncJSThread");
        handlerThread.start();
        this.fwr = new Handler(handlerThread.getLooper());
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(String str, String str2, int i, long j) {
        x.i("MicroMsg.GameJsApiInterface", "api: %s, time: %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - j)});
        int CZ = b.CZ(str);
        if (CZ > 0) {
            h.mEJ.a(157, (long) CZ, 1, false);
        }
        String str3 = "";
        try {
            String w;
            boolean z = this.fEL.get(str) instanceof f;
            if (z) {
                w = w(str, str2, i);
            } else {
                this.fwr.post(new 1(this, str, str2, i));
                w = str3;
            }
            String str4 = "MicroMsg.GameJsApiInterface";
            String str5 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                CZ = 0;
            } else {
                CZ = str2.length();
            }
            objArr[1] = Integer.valueOf(CZ);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - r10);
            x.i(str4, str5, objArr);
            return w;
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", "Invoke Error: %s, %s\n%s", new Object[]{str, e.getMessage(), e.getStackTrace()});
            throw e;
        }
    }

    final String w(String str, String str2, int i) {
        if (this.jGw == null || this.jGw.getPageActivity() == null) {
            x.e("MicroMsg.GameJsApiInterface", "activity is null");
            return "";
        }
        String Df;
        c cVar = (c) this.fEL.get(str);
        boolean z = cVar instanceof f;
        JSONObject ti = ti(str2);
        if (cVar == null) {
            Df = Df("system:function_not_exist");
        } else {
            boolean z2;
            if (this.jGy.contains(cVar.getName())) {
                this.jGy.remove(cVar.getName());
                z2 = true;
            } else {
                z2 = this.jGw.bs(cVar.getName(), cVar.aSs());
            }
            if (z2) {
                try {
                    if (this.jGx != null) {
                        if (!bi.oW(this.jGx.optString("srcUsername"))) {
                            ti.put("src_username", this.jGx.optString("srcUsername"));
                        }
                        if (!bi.oW(this.jGx.optString("srcDisplayname"))) {
                            ti.put("src_displayname", this.jGx.optString("srcDisplayname"));
                        }
                        if (!bi.oW(this.jGx.optString("KTemplateId"))) {
                            ti.put("tempalate_id", this.jGx.optString("KTemplateId"));
                        }
                        ti.put("message_id", this.jGx.optLong("message_id"));
                        ti.put("message_index", this.jGx.optInt("message_index"));
                        ti.put("webview_scene", this.jGx.optInt("scene"));
                        ti.put("stastic_scene", this.jGx.optInt("stastic_scene"));
                    }
                    ti.put("current_url", this.jGw.getCurrentURL());
                    ti.put("current_appid", this.jGw.getCacheAppId());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GameJsApiInterface", e, "", new Object[0]);
                }
                if (z) {
                    Df = "";
                } else {
                    a aVar = (a) cVar;
                    if (aVar.aSu() == 2) {
                        GameJsApiActivityTask gameJsApiActivityTask = new GameJsApiActivityTask(this.jGw.getPageActivity());
                        gameJsApiActivityTask.jGq = this.jGw;
                        gameJsApiActivityTask.fFd = i;
                        gameJsApiActivityTask.jGt = aVar.getName();
                        gameJsApiActivityTask.fII = ti.toString();
                        gameJsApiActivityTask.aNI();
                        Df = null;
                    } else if (aVar.aSu() == 1) {
                        GWMainProcessTask gameJsApiMMTask = new GameJsApiMMTask();
                        gameJsApiMMTask.jGq = this.jGw;
                        gameJsApiMMTask.fFd = i;
                        gameJsApiMMTask.jGt = aVar.getName();
                        gameJsApiMMTask.fII = ti.toString();
                        gameJsApiMMTask.ahA();
                        GameWebViewMainProcessService.a(gameJsApiMMTask);
                        Df = null;
                    } else {
                        aVar.a(this.jGw, ti, i);
                        Df = null;
                    }
                }
            } else {
                Df = Df("system:access_denied");
            }
        }
        if (z) {
            return Df;
        }
        if (Df != null) {
            this.jGw.E(i, Df);
        }
        return "";
    }

    private static String Df(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        return new JSONObject(hashMap).toString();
    }

    private static JSONObject ti(String str) {
        try {
            if (bi.oW(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", e.getMessage());
            return new JSONObject();
        }
    }
}
