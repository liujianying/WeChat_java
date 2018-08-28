package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nl {
    private Context a = null;
    private b b;
    private lo c;

    public nl(Context context, lo loVar, a aVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = new b(this, aVar);
        this.c = loVar;
    }

    public void a() {
        this.b.execute(new String[0]);
    }

    private String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://overseactrl.map.qq.com/?");
        stringBuffer.append("apikey=");
        stringBuffer.append(kh.a);
        stringBuffer.append("&frontier=");
        stringBuffer.append(r.a(this.a).m());
        return stringBuffer.toString();
    }

    private c a(String str) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (this.c == null) {
            return null;
        }
        r a = r.a(this.a);
        c cVar;
        HttpURLConnection httpURLConnection2;
        InputStream gZIPInputStream;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("info");
            JSONObject optJSONObject = jSONObject.optJSONObject("world");
            if (optJSONObject == null) {
                a.a(false);
                this.c.a(false);
                return null;
            }
            cVar = new c(this);
            int optInt = optJSONObject.optInt("style", cVar.a());
            a.e(optInt);
            cVar.a = optInt;
            optInt = optJSONObject.optInt("scene", cVar.c());
            a.g(optInt);
            cVar.c = optInt;
            String optString = optJSONObject.optString("name");
            String k = a.k();
            if (!(k == null || k.equals(optString))) {
                lo.b = true;
            }
            a.b(optString);
            cVar.d = optString;
            int optInt2 = optJSONObject.optInt("version");
            int i = a.i();
            if (!(optInt2 == i && (optString == null || optString.equals(k)))) {
                po a2 = pn.a().a(optJSONObject.getString("logo"));
                byte[] bArr = new byte[0];
                if (a2 != null) {
                    bArr = a2.a;
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray != null) {
                    cVar.f = decodeByteArray;
                    kh.a(this.a, bArr, "world_map_logo_" + optString + ".png");
                }
            }
            if (optInt2 != i) {
                ll.a(this.a).a(0);
            }
            a.f(optInt2);
            cVar.b = optInt2;
            k = a(optJSONObject);
            cVar.g = k;
            a.d(k);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("otherDistrict");
            if (optJSONObject2 == null) {
                a.b(false);
                lo.b(false);
            } else {
                a.b(true);
                lo.b(true);
                cVar.h = a(optJSONObject2);
                cVar.e = optJSONObject2.getString("name");
                a.c(cVar.e);
                a.e(cVar.h);
            }
            optJSONObject2 = jSONObject.optJSONObject("frontier");
            if (optJSONObject2 != null) {
                int m = a.m();
                k = optJSONObject2.getString("path");
                if (k != null && k.length() > 0) {
                    httpURLConnection2 = (HttpURLConnection) new URL(k).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setConnectTimeout(5000);
                        if (httpURLConnection2.getResponseCode() == 200) {
                            gZIPInputStream = new GZIPInputStream(httpURLConnection2.getInputStream());
                            try {
                                byte[] bArr2;
                                int i2;
                                byte[] a3 = q.a(gZIPInputStream);
                                if (a3 == null) {
                                    bArr2 = new byte[0];
                                } else {
                                    bArr2 = a3;
                                }
                                String[] d = kh.d(new String(bArr2, "utf-8"));
                                if (StringUtil.isEmpty(d[0])) {
                                    i2 = m;
                                } else {
                                    i2 = Integer.parseInt(d[0]);
                                }
                                if (i2 != m) {
                                    a.h(i2);
                                    if (!StringUtil.isEmpty(d[1])) {
                                        ln.a(d[1]);
                                    }
                                    if (!StringUtil.isEmpty(d[2])) {
                                        ln.b(d[2]);
                                    }
                                    kh.a(this.a, bArr2, "frontier.dat");
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = httpURLConnection2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                throw th;
                            }
                        }
                        gZIPInputStream = null;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPInputStream = null;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        throw th;
                    }
                }
            }
            a.a(true);
            this.c.a(true);
            return cVar;
        } catch (Throwable th4) {
            a.a(false);
            this.c.a(false);
            return null;
        }
    }

    private String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            CharSequence string = jSONObject.getString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            Matcher matcher = Pattern.compile("\\{.*?\\}").matcher(string);
            HashMap hashMap = new HashMap();
            while (matcher.find()) {
                Object obj;
                String group = matcher.group();
                try {
                    String substring = group.substring(1, group.length() - 1);
                    if (substring.equals("ch")) {
                        obj = "en";
                    } else {
                        Object obj2 = jSONObject.get(substring);
                        if (obj2 instanceof JSONArray) {
                            int length = ((JSONArray) obj2).length();
                            if (length > 0) {
                                obj = ((JSONArray) obj2).getString(new Random(System.currentTimeMillis()).nextInt(length));
                            }
                            obj = null;
                        } else {
                            obj = obj2.toString();
                        }
                    }
                } catch (JSONException e) {
                }
                if (!(group == null || obj == null)) {
                    hashMap.put(group, obj);
                }
            }
            String str = string;
            for (Entry entry : hashMap.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
            return str;
        } catch (JSONException e2) {
            return "";
        }
    }
}
