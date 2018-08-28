package com.tencent.mm.plugin.qqmail.b;

import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private static SparseArray<String> mde = null;
    public j mcZ;
    private Map<String, String> mcz = new HashMap();
    public c mda;
    private e mdb;
    private Map<Long, d> mdc = new HashMap();
    private Map<Long, b> mdd = new HashMap();

    static /* synthetic */ void a(p pVar, Map map) {
        if (pVar.mcz != null && map != null) {
            for (String str : map.keySet()) {
                pVar.mcz.put(str, map.get(str));
            }
        }
    }

    public p(int i, String str) {
        x.setHost("qqmail.weixin.qq.com:443");
        x.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
    }

    public final long a(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 1, map, null, cVar, aVar);
    }

    public final long b(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 0, map, null, cVar, aVar);
    }

    public static String bor() {
        return "https://qqmail.weixin.qq.com:443";
    }

    public final long a(String str, int i, Map<String, String> map, d dVar, c cVar, a aVar) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        map2.put("appname", "qqmail_weixin");
        map2.put("f", "xml");
        map2.put("charset", ProtocolPackage.ServerEncoding);
        map2.put("clientip", getLocalIp());
        d dVar2 = new d(this, str, new b(i, map2, getCookie(), dVar), aVar);
        dVar2.mdn = cVar;
        ah.A(new 1(this, dVar2));
        return dVar2.id;
    }

    public final void cancel(long j) {
        b bVar = (b) this.mdd.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.onCancelled();
            bVar.cancel(true);
        }
        this.mdd.remove(Long.valueOf(j));
        this.mdc.remove(Long.valueOf(j));
    }

    public final void reset() {
        x.JQ(getDownloadPath());
        for (b cancel : this.mdd.values()) {
            cancel.cancel(true);
        }
        this.mdd.clear();
        this.mdc.clear();
        this.mcz.clear();
        au.HU();
        String Gh = c.Gh();
        this.mcZ = new j(Gh + "addr/");
        this.mda = new c(Gh + "draft/");
        this.mdb = new e(Gh + "http/", 0);
    }

    public static String getDownloadPath() {
        String str = e.dgj;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static String getLocalIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        au.HU();
        String str = (String) c.DT().get(-1535680990, null);
        Map map = this.mcz;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String obj2 = str;
        }
        map.put(str2, obj2);
        au.HU();
        this.mcz.put("uin", "o" + new o(bi.p(c.DT().get(9, null), 0)));
        x.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[]{Boolean.valueOf(bi.oW(str)), Integer.valueOf(r1)});
        return this.mcz;
    }

    private static String uU(int i) {
        if (mde == null) {
            mde = new SparseArray();
            for (Field field : HttpURLConnection.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        modifiers = field.getInt(Integer.valueOf(0));
                        StringBuilder stringBuilder = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i2 = 1; i2 < split.length; i2++) {
                                stringBuilder.append(split[i2]).append(' ');
                            }
                            stringBuilder.append("error");
                        }
                        mde.put(modifiers, stringBuilder.toString().toLowerCase());
                    } catch (Exception e) {
                    }
                }
            }
        }
        String str = (String) mde.get(i);
        return str == null ? az(i, "request error") : str;
    }

    private static String az(int i, String str) {
        int i2 = 0;
        switch (i) {
            case -105:
            case ErrCode.ERR_BAN /*-6*/:
                i2 = R.l.plugin_qqmail_svr_error_desc_6;
                break;
            case -104:
                i2 = R.l.plugin_qqmail_svr_error_desc_104;
                break;
            case -103:
                i2 = R.l.plugin_qqmail_svr_error_desc_103;
                break;
            case -102:
                i2 = R.l.plugin_qqmail_svr_error_desc_102;
                break;
            case -7:
                i2 = R.l.plugin_qqmail_svr_error_desc_7;
                break;
            case ErrCode.ERR_AUTH_DENIED /*-4*/:
            case -3:
                i2 = R.l.plugin_qqmail_svr_error_desc_3;
                break;
            case -1:
                i2 = R.l.plugin_qqmail_svr_error_desc_1;
                break;
        }
        if (i2 == 0) {
            return str;
        }
        return a.af(ad.getContext(), i2);
    }
}
