package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    static boolean vzP = false;
    static String vzQ = "";
    static Map<String, String> vzR;
    static Map<String, String> vzS;
    static Map<String, String> vzT;

    private static void init() {
        if (!vzP) {
            vzP = true;
            SharedPreferences cIh = cIh();
            String string = cIh.getString("setwebtype", WebView$d.WV_KIND_NONE.toString());
            String string2 = cIh.getString("setjscore", com.tencent.xweb.g.a.vAc.toString());
            a(adB(string), adB(string2), cIh.getString("cStrTAGConfigVer", ""), adB(cIh.getString("setfullscreenvideo", com.tencent.xweb.WebView.a.vAM.toString())));
        }
    }

    public static String getAbstractInfo() {
        init();
        if ((vzR == null || vzR.size() == 0) && ((vzS == null || vzS.size() == 0) && (vzT == null || vzT.size() == 0))) {
            return "";
        }
        return "configver : " + vzQ + "\n webtype : " + aD(vzR) + "\n jscore type :" + aD(vzS) + "\n fullscreenVideo :" + aD(vzT);
    }

    public static WebView$d adv(String str) {
        init();
        if (vzR == null || str == null) {
            return WebView$d.WV_KIND_NONE;
        }
        return ady((String) vzR.get(str));
    }

    public static com.tencent.xweb.g.a adw(String str) {
        init();
        if (vzS == null || str == null) {
            return com.tencent.xweb.g.a.vAc;
        }
        return adz((String) vzS.get(str));
    }

    public static com.tencent.xweb.WebView.a adx(String str) {
        init();
        if (vzT == null || str == null) {
            return com.tencent.xweb.WebView.a.vAM;
        }
        return adA((String) vzT.get(str));
    }

    public static void a(com.tencent.xweb.c.a.a[] aVarArr, String str) {
        init();
        if (str != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            Map hashMap3 = new HashMap();
            if (aVarArr == null || aVarArr.length == 0) {
                b(hashMap, hashMap2, str, hashMap3);
                return;
            }
            XWalkEnvironment.getAvailableVersion();
            int i = VERSION.SDK_INT;
            new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL);
            i = 0;
            while (i < aVarArr.length) {
                if (!(aVarArr[i] == null || !aVarArr[i].vCo.cID() || aVarArr[i].vCr == null || aVarArr[i].vCr.isEmpty() || aVarArr[i].vCq == null)) {
                    String[] split = aVarArr[i].vCr.split(",");
                    String trim;
                    if (aVarArr[i].vCp.equals("setwebtype")) {
                        for (String trim2 : split) {
                            trim2 = trim2.trim();
                            if (!(trim2 == null || trim2.isEmpty() || hashMap.containsKey(trim2))) {
                                hashMap.put(trim2, aVarArr[i].vCq);
                            }
                        }
                    } else if (aVarArr[i].vCp.equals("setjscore")) {
                        for (String trim22 : split) {
                            trim22 = trim22.trim();
                            if (!(trim22 == null || trim22.isEmpty() || hashMap2.containsKey(trim22))) {
                                hashMap2.put(trim22, aVarArr[i].vCq);
                            }
                        }
                    } else if (aVarArr[i].vCp.equals("setfullscreenvideo")) {
                        for (String trim222 : split) {
                            trim222 = trim222.trim();
                            if (!(trim222 == null || trim222.isEmpty() || hashMap3.containsKey(trim222))) {
                                hashMap3.put(trim222, aVarArr[i].vCq);
                            }
                        }
                    }
                }
                i++;
            }
            b(hashMap, hashMap2, str, hashMap3);
        }
    }

    private static WebView$d ady(String str) {
        if (str == null || str.isEmpty()) {
            return WebView$d.WV_KIND_NONE;
        }
        WebView$d webView$d = WebView$d.WV_KIND_NONE;
        try {
            return WebView$d.valueOf(str);
        } catch (Exception e) {
            return webView$d;
        }
    }

    private static com.tencent.xweb.g.a adz(String str) {
        if (str == null || str.isEmpty()) {
            return com.tencent.xweb.g.a.vAc;
        }
        com.tencent.xweb.g.a aVar = com.tencent.xweb.g.a.vAc;
        try {
            return com.tencent.xweb.g.a.valueOf(str);
        } catch (Exception e) {
            return aVar;
        }
    }

    private static com.tencent.xweb.WebView.a adA(String str) {
        if (str == null || str.isEmpty()) {
            return com.tencent.xweb.WebView.a.vAM;
        }
        com.tencent.xweb.WebView.a aVar = com.tencent.xweb.WebView.a.vAM;
        try {
            return com.tencent.xweb.WebView.a.valueOf(str);
        } catch (Exception e) {
            return aVar;
        }
    }

    private static String aD(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(":");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static Map<String, String> adB(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.isEmpty())) {
            for (String str2 : str.split(";")) {
                if (!(str2 == null || str2.isEmpty())) {
                    String[] split = str2.split(":");
                    if (!(split.length != 2 || split[0] == null || split[1] == null)) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            }
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, Map<String, String> map2, String str, Map<String, String> map3) {
        vzR = map;
        vzS = map2;
        vzQ = str;
        vzT = map3;
    }

    private static void b(Map<String, String> map, Map<String, String> map2, String str, Map<String, String> map3) {
        a(map, map2, str, map3);
        String aD = aD(vzR);
        String aD2 = aD(vzS);
        String aD3 = aD(vzT);
        XWalkEnvironment.addXWalkInitializeLog("CommandCfg", "save cmds to : webtype = " + aD + "jstype = " + aD2 + "configver = " + vzQ + "strFullscreenVideoCmds = " + aD3);
        Editor edit = cIh().edit();
        edit.putString("setwebtype", aD);
        edit.putString("setjscore", aD2);
        edit.putString("cStrTAGConfigVer", vzQ);
        edit.putString("setfullscreenvideo", aD3);
        edit.commit();
    }

    private static SharedPreferences cIh() {
        return XWalkEnvironment.getApplicationContext().getSharedPreferences("XWEB.CMDCFG", 0);
    }
}
