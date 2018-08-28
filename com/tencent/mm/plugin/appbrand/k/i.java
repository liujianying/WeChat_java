package com.tencent.mm.plugin.appbrand.k;

import android.net.Uri;
import android.util.Log;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public enum i {
    ;
    
    private static Boolean gll;

    private static HashMap<String, String> uO(String str) {
        Object obj = "";
        Object obj2 = "";
        Object obj3 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            obj2 = parse.getScheme();
            obj3 = String.valueOf(parse.getPort());
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
        }
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", obj2);
        hashMap.put("port", obj3);
        return hashMap;
    }

    private static Map<String, String> x(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "get header error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static Map<String, String> y(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "get form error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static boolean b(ArrayList<String> arrayList, String str) {
        return a((ArrayList) arrayList, str, false);
    }

    public static boolean a(ArrayList<String> arrayList, String str, boolean z) {
        if (bi.oW(str)) {
            return false;
        }
        x.i("MicroMsg.AppBrandNetworkUtil", "url " + str);
        x.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
        HashMap uO = uO(str);
        String str2 = (String) uO.get("host");
        String str3 = (String) uO.get("scheme");
        String str4 = (String) uO.get("port");
        if (bi.oW(str2) || bi.oW(str3)) {
            return false;
        }
        x.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", new Object[]{str2, str3, str4, Boolean.valueOf(z)});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            x.i("MicroMsg.AppBrandNetworkUtil", "configUrl " + str5);
            HashMap uO2 = uO(str5);
            x.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[]{(String) uO2.get("host"), (String) uO2.get("scheme"), (String) uO2.get("port")});
            if (str2.equalsIgnoreCase((String) uO2.get("host")) && str3.equalsIgnoreCase(r4)) {
                if (z || str4.equalsIgnoreCase(r5)) {
                    x.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> a(JSONObject jSONObject, AppBrandSysConfig appBrandSysConfig) {
        String str;
        Map<String, String> x = x(jSONObject);
        if (appBrandSysConfig.frn != null) {
            HttpSetting httpSetting = appBrandSysConfig.frn.fpK;
            if (httpSetting != null) {
                Map<String, String> map;
                ArrayList arrayList;
                if (httpSetting.mode == 1) {
                    if (httpSetting.fqc != null) {
                        arrayList = httpSetting.fqc;
                        if (arrayList == null || arrayList.isEmpty()) {
                            x.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                if (str != null) {
                                    if (((String) x.remove(str.toLowerCase())) != null) {
                                        x.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[]{str.toLowerCase(), (String) x.remove(str.toLowerCase())});
                                    }
                                }
                            }
                        }
                        map = x;
                    }
                } else if (httpSetting.mode == 2 && httpSetting.fqd != null) {
                    arrayList = httpSetting.fqd;
                    if (arrayList == null) {
                        x.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
                        map = x;
                    } else {
                        Map<String, String> hashMap = new HashMap();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            str = (String) it2.next();
                            if (str != null) {
                                String toLowerCase = str.toLowerCase();
                                str = (String) x.get(toLowerCase);
                                if (str != null) {
                                    x.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[]{toLowerCase, str});
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        map = hashMap;
                    }
                }
                x = map;
            }
        }
        x.remove("referer");
        String str2 = "referer";
        str = "";
        if (!(appBrandSysConfig.frn == null || appBrandSysConfig.frn.fpK == null)) {
            str = appBrandSysConfig.frn.fpK.fqi;
        }
        if (bi.oW(str)) {
            str = "servicewechat.com";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.appId);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.frm.fii);
        stringBuilder.append("/page-frame.html");
        x.put(str2, stringBuilder.toString());
        return x;
    }

    public static int a(AppBrandSysConfig appBrandSysConfig, a aVar, int i) {
        int i2;
        int i3;
        switch (i) {
            case 0:
                i2 = aVar.foQ.cez;
                if (appBrandSysConfig.frn == null || appBrandSysConfig.frn.fpK == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.frn.fpK.fqe;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "request apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                break;
            case 1:
                i2 = aVar.foQ.foX;
                if (appBrandSysConfig.frn == null || appBrandSysConfig.frn.fpK == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.frn.fpK.fqe;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "socket apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                break;
            case 2:
                i2 = aVar.foQ.foY;
                if (appBrandSysConfig.frn == null || appBrandSysConfig.frn.fpK == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.frn.fpK.fqf;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "upload apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                break;
            case 3:
                i2 = aVar.foQ.foZ;
                if (appBrandSysConfig.frn == null || appBrandSysConfig.frn.fpK == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.frn.fpK.fqg;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "download apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                break;
            default:
                i3 = 0;
                i2 = 0;
                break;
        }
        if (i2 > 0 && i3 <= 0) {
            return i2;
        }
        if (i2 <= 0 && i3 > 0) {
            return i3;
        }
        if (i2 <= 0 || i3 <= 0) {
            return 0;
        }
        return Math.min(i2, i3);
    }

    public static boolean lm(int i) {
        return i == 302 || i == 301;
    }

    public static String d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return "";
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (headerField == null) {
            return null;
        }
        try {
            return url.toURI().resolve(headerField).toString();
        } catch (URISyntaxException e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "resolve url error %s", new Object[]{e.getMessage()});
            return headerField;
        }
    }

    public static boolean a(AppBrandSysConfig appBrandSysConfig, boolean z) {
        if (z) {
            x.v("MicroMsg.AppBrandNetworkUtil", "skipCheck Domains");
            return false;
        }
        boolean z2;
        if (appBrandSysConfig.frm.fih == 1 || appBrandSysConfig.frm.fih == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appBrandSysConfig.fqw) {
            if (z2 && appBrandSysConfig.fqO) {
                return false;
            }
            return true;
        } else if (z2 && appBrandSysConfig.fqL) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean c(AppBrandInitConfig appBrandInitConfig) {
        boolean booleanValue;
        if (gll != null) {
            booleanValue = gll.booleanValue();
        } else {
            com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.dnp;
            c fJ = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100386");
            if (fJ == null) {
                Boolean valueOf = Boolean.valueOf(false);
                gll = valueOf;
                booleanValue = valueOf.booleanValue();
            } else {
                booleanValue = fJ.isValid() && "1".equals(fJ.ckq().get("openSkipDomainCheck"));
                gll = Boolean.valueOf(booleanValue);
                x.i("MicroMsg.AppBrandNetworkUtil", "openSkipDomainCheck %b", new Object[]{gll});
                booleanValue = gll.booleanValue();
            }
        }
        if (booleanValue || appBrandInitConfig.aeb() || appBrandInitConfig.aaq()) {
            return true;
        }
        return false;
    }

    public static void a(HttpURLConnection httpURLConnection, ArrayList<String> arrayList) {
        if (httpURLConnection != null) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new 1(HttpsURLConnection.getDefaultHostnameVerifier(), arrayList));
        }
    }

    public static SSLContext uP(String str) {
        if (uQ(str) == null) {
            return null;
        }
        TrustManager[] trustManagerArr = new TrustManager[]{uQ(str)};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            return instance;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "SSLContext init error: " + e);
            return null;
        }
    }

    public static l uQ(String str) {
        LinkedList uR = uR(str);
        if (uR.isEmpty()) {
            return null;
        }
        l lVar = new l();
        Iterator it = uR.iterator();
        while (it.hasNext()) {
            InputStream inputStream = (InputStream) it.next();
            if (lVar.glx == null) {
                x.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            } else {
                try {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                    inputStream.close();
                    lVar.glx.setCertificateEntry(((X509Certificate) generateCertificate).getSubjectDN(), generateCertificate);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandX509TrustManager", "initLocalSelfSignedCertificate:" + e);
                } catch (Throwable th) {
                    inputStream.close();
                }
            }
        }
        lVar.init();
        return lVar;
    }

    private static LinkedList<InputStream> uR(String str) {
        LinkedList<InputStream> linkedList = new LinkedList();
        byte[] e = ao.e(com.tencent.mm.plugin.appbrand.a.pY(str), "cer");
        if (e == null) {
            return linkedList;
        }
        try {
            asn asn = new asn();
            asn.aG(e);
            if (asn.rUN == null) {
                return linkedList;
            }
            Iterator it = asn.rUN.iterator();
            while (it.hasNext()) {
                linkedList.add(new ByteArrayInputStream(((com.tencent.mm.bk.b) it.next()).lR));
            }
            return linkedList;
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrandNetworkUtil", "parse error: " + e2);
        }
    }

    public static JSONObject e(HttpURLConnection httpURLConnection) {
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bi.oW(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (Throwable e) {
                    x.e("MicroMsg.AppBrandNetworkUtil", "put header error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject f(HttpURLConnection httpURLConnection) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
        } catch (JSONException e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "put header error");
        }
        if (httpURLConnection == null) {
            return jSONObject;
        }
        Map requestProperties = httpURLConnection.getRequestProperties();
        if (requestProperties == null) {
            return jSONObject;
        }
        for (Entry entry : requestProperties.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bi.oW(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (Throwable e2) {
                    x.e("MicroMsg.AppBrandNetworkUtil", "put header error : %s", new Object[]{Log.getStackTraceString(e2)});
                }
            }
        }
        return jSONObject;
    }

    public static int bR(long j) {
        return g(j, -1);
    }

    public static int g(long j, int i) {
        x.i("MicroMsg.AppBrandNetworkUtil", "hy: total size is %d, expectMaxRounds is %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (j <= 0) {
            return 8192;
        }
        if (i <= 0) {
            i = 3;
        }
        int i2 = (int) (j / ((long) i));
        if (i2 <= 524288 && i2 >= 1024) {
            return i2;
        }
        if (i2 < 1024) {
            return 1024;
        }
        return 524288;
    }
}
