package com.tencent.mm.network;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b {
    static a erY;

    public interface a {
        e DJ();
    }

    public static class b {
        public int erZ = 0;
        private ArrayList<String> esa = new ArrayList();
        public String esb;
        public boolean esc = false;
        private boolean esd = false;
        public String host = null;
        public String ip = "";
        URL url = null;

        public b(String str) {
            this.esb = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.erY == null || b.erY.DJ() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.erY == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.erY.DJ();
                    }
                    objArr[0] = str2;
                    objArr[1] = bi.cjd();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.erZ = b.erY.DJ().getHostByName(this.host, arrayList);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.erZ), this.host, str);
                if (arrayList.size() <= 0) {
                    this.erZ = 0;
                } else if (1 == this.erZ) {
                    str2 = (String) arrayList.get((int) (bi.VF() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            }
        }

        public b(String str, boolean z) {
            this.esc = z;
            this.esb = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (b.erY == null || b.erY.DJ() == null) {
                    String str2;
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.erY == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.erY.DJ();
                    }
                    objArr[0] = str2;
                    objArr[1] = bi.cjd();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.erZ = b.erY.DJ().a(this.host, z, this.esa);
                Random random = new Random();
                random.setSeed(bi.VF());
                Collections.shuffle(this.esa, random);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.erZ), this.host, str, this.esa);
                if (this.esa.size() <= 0) {
                    this.erZ = 0;
                } else if (1 == this.erZ) {
                    this.ip = (String) this.esa.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            }
        }
    }

    public static void a(a aVar) {
        x.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.valueOf(false), bi.cjd());
        erY = aVar;
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        if (erY == null) {
            return i;
        }
        try {
            return erY.DJ().a(str, z, list);
        } catch (Throwable e) {
            x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            return i;
        }
    }

    public static int a(String str, boolean z, List<String> list) {
        if (erY == null || erY.DJ() == null) {
            return -1;
        }
        return erY.DJ().a(str, z, list);
    }

    public static void reportFailIp(String str) {
        if (erY != null && erY.DJ() != null) {
            erY.DJ().reportFailIp(str);
        }
    }

    public static InputStream n(String str, int i, int i2) {
        u a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            return null;
        }
        return a.getInputStream();
    }

    public static u a(String str, b bVar) {
        if (bVar == null) {
            bVar = new b(str);
        }
        x.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.erZ));
        u uVar = new u(bVar.url, bVar.erZ);
        uVar.esW = bVar.ip;
        if (1 == bVar.erZ) {
            uVar.setRequestProperty("Host", bVar.host);
            uVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        return uVar;
    }

    public static int a(u uVar) {
        try {
            if (uVar.getResponseCode() != HardCoderJNI.sHCDBDELAY_WRITE) {
                return -1;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            return -3;
        }
    }

    public static v oy(String str) {
        return new v(str);
    }
}
