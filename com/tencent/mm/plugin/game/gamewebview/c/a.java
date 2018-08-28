package com.tencent.mm.plugin.game.gamewebview.c;

import android.net.Uri;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public static String aAL;
    public static List<amu> jIh;
    public static String jIi = "";
    public static String jIj;
    public static Map<Integer, String> jIk = new HashMap();
    public static String uin;

    public static String b(String str, String str2, JSONObject jSONObject) {
        if (jIk.containsKey(Integer.valueOf(str.hashCode()))) {
            return (String) jIk.remove(Integer.valueOf(str.hashCode()));
        }
        if (str2.equalsIgnoreCase("POST")) {
            return b(str, jSONObject);
        }
        if (str2.equalsIgnoreCase("GET")) {
            return a(str, jSONObject);
        }
        return null;
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        jIk.put(Integer.valueOf(str.hashCode()), b(str, str2, jSONObject));
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Dk(c(str, jSONObject))).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            h(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "GET, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String s = s(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", s);
                return s;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String b(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            h(httpURLConnection);
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2 != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
                    bufferedWriter.write(jSONObject2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "POST, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String s = s(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", s);
                return s;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String c(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            Iterator keys = jSONObject.keys();
            if (bi.oW(query)) {
                query = "";
            } else {
                query = query + "&";
            }
            while (true) {
                str2 = query;
                if (!keys.hasNext()) {
                    break;
                }
                query = (String) keys.next();
                query = str2 + query + "=" + jSONObject.optString(query) + "&";
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2.substring(0, str2.lastIndexOf("&")), parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static String Dk(String str) {
        if (!(bi.oW(uin) || bi.oW(aAL) || bi.oW(jIj))) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            if (bi.oW(query)) {
                query = "";
            } else {
                query = query + "&";
            }
            if (!bi.oW(uin)) {
                query = query + "uin=" + uin + "&";
            }
            if (!bi.oW(aAL)) {
                query = query + "key=" + aAL + "&";
            }
            if (bi.oW(jIj)) {
                str2 = query;
            } else {
                str2 = query + "pass_ticket=" + jIj;
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static void h(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("User-agent", jIi);
        for (amu amu : jIh) {
            httpURLConnection.setRequestProperty(amu.riD, amu.mEl);
        }
    }

    private static String s(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "utf-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                x.e("MicroMsg.GameWebViewRequest", "inputStream2Str: " + e.getMessage());
                return "";
            }
        }
    }

    public static void k(String str, List<amu> list) {
        if (!bi.oW(str)) {
            Uri parse = Uri.parse(str);
            uin = parse.getQueryParameter("uin");
            aAL = parse.getQueryParameter("key");
            jIj = parse.getQueryParameter("pass_ticket");
        }
        jIh = list;
    }
}
