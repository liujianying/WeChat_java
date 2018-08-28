package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class s {
    private static at ewg = null;
    private static final Pattern pLQ = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    private static final Map<String, String> pLR;
    private static final Map<String, String> pLS;

    public interface b {
        void uf(String str);
    }

    public static String aV(Context context, String str) {
        return n.aV(context, str);
    }

    public static boolean Uc(String str) {
        return str == null ? false : str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    }

    public static boolean fj(String str, String str2) {
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0 || str2.length() > str.length() || !str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            return false;
        }
        return true;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        return n.getPackageInfo(context, str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpg"));
        arrayList.add(new Pair("json", "application/json"));
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put(pair.first, pair.second);
            hashMap2.put(pair.second, pair.first);
        }
        pLR = Collections.unmodifiableMap(hashMap);
        pLS = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (ewg == null) {
            ewg = new at(1, "webview-save-image", 1);
        }
        ewg.c(new c(context, str, str2, z));
    }

    public static void a(Context context, String str, String str2, boolean z, b bVar) {
        if (ewg == null) {
            ewg = new at(1, "webview-save-image", 1);
        }
        ewg.c(new c(context, str, str2, z, 1, bVar));
    }

    public static void a(WebView webView) {
        x.d("MicroMsg.WebViewUtil", "initIFrame");
        ah.A(new 1(webView));
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, str, str2, true);
    }

    public static void a(WebView webView, String str, String str2, boolean z) {
        if (webView == null || bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[]{str, str2});
            return;
        }
        x.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[]{str, str2});
        a(webView);
        ah.A(new 2(z, webView, str, str2));
    }

    public static String fH(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[]{str, str2});
            return null;
        }
        x.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[]{str, str2});
        return "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
    }

    public static final String as(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(bi.oW(str) || obj == null)) {
                if (!(obj instanceof String) || !bi.oW((String) obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("=");
                    stringBuilder.append(obj);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final String Ud(String str) {
        if (bi.oW(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[]{e.getMessage()});
            return str;
        }
    }

    public static final String Ue(String str) {
        if (bi.oW(str)) {
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            x.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[]{unsupportedEncodingException.getMessage()});
        }
        return Base64.encodeToString(bytes, 2);
    }

    private static String fc(Context context) {
        WifiInfo connectionInfo;
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return "127.0.0.1";
        }
        int ipAddress = connectionInfo.getIpAddress();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
    }

    public static String cfB() {
        int i = 0;
        try {
            i = w.zQ();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[]{e});
        }
        if (i == 0) {
            return "127.0.0.1";
        }
        if (i == 1) {
            return fc(ad.getContext());
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return bi.oW(inetAddress.getHostAddress()) ? "127.0.0.1" : inetAddress.getHostAddress();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e2) {
        }
        return "127.0.0.1";
    }

    public static String Uf(String str) {
        if (!bi.oW(str) && pLQ.matcher(str).matches()) {
            return str.substring(str.indexOf("base64,") + 7).trim();
        }
        return null;
    }

    public static String bUq() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ad.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        x.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public static String Ug(String str) {
        String str2 = "";
        if (str == null || !str.startsWith("Refused to frame")) {
            return str2;
        }
        String[] split = str.split("'");
        if (split.length > 2) {
            return split[1];
        }
        return str2;
    }

    public static String Uh(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = (String) pLR.get(str.toLowerCase());
        if (!bi.oW(str2) || bi.oW(str)) {
            return str2;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static String Ui(String str) {
        String str2 = null;
        if (!bi.oW(str)) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                str2 = str.substring(lastIndexOf + 1);
            }
        }
        return Uh(str2);
    }

    public static String Tu(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = (String) pLS.get(str.toLowerCase());
        if (bi.oW(str2)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return str2;
    }
}
