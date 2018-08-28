package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.ZipUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class n {
    private String a;
    private WeakReference<m> b;

    public void a(String str, int i, m mVar) {
        if (!StringUtil.isEmpty(str) && mVar != null) {
            this.a = str;
            this.b = new WeakReference(mVar);
            a(a(a(str, i)));
        }
    }

    public void a(String str, jr jrVar, m mVar) {
        if (jrVar != null && mVar != null) {
            this.b = new WeakReference(mVar);
            List<jv> a = a(jrVar);
            if (a != null && a.size() != 0) {
                for (jv a2 : a) {
                    a(a2, str);
                }
            }
        }
    }

    private List<jv> a(jr jrVar) {
        try {
            po a = pn.a().a("http://sdksso.map.qq.com", "androidsdk", lw.a(jrVar, 8, "CMD_FILE_UPDATE_CHECK").toByteArray("UTF-8"));
            if (a == null || a.a == null) {
                a(1, null);
                return null;
            }
            md mdVar = new md(lw.a(a.a).a());
            mdVar.a("UTF-8");
            jx jxVar = new jx();
            jxVar.readFrom(mdVar);
            if (jxVar.a == 0) {
                return jxVar.b;
            }
            a(2, null);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private jq a(String str, int i) {
        jq jqVar = new jq(new ArrayList());
        jqVar.a.add(new js(str, i, 1));
        return jqVar;
    }

    private jt a(jq jqVar) {
        try {
            po a = pn.a().a("http://sdksso.map.qq.com", "androidsdk", lw.a(jqVar, 29, "CMD_ConfCheck").toByteArray("UTF-8"));
            if (a == null || a.a == null) {
                return null;
            }
            md mdVar = new md(lw.a(a.a).a());
            mdVar.a("UTF-8");
            jw jwVar = new jw();
            jwVar.readFrom(mdVar);
            if (!(jwVar.b == null || jwVar.b.isEmpty())) {
                return (jt) jwVar.b.get(0);
            }
            return null;
        } catch (Exception e) {
        }
    }

    private void a(jv jvVar, String str) {
        Closeable closeable;
        Throwable th;
        a aVar = new a();
        if (jvVar.b == 0) {
            aVar.a = jvVar.a;
            aVar.c = jvVar.c;
            if (jvVar.d == 1) {
                Closeable inputStream;
                Closeable fileOutputStream;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(jvVar.e).openConnection();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        File file = new File(str + File.separator + jvVar.a);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file, false);
                        try {
                            q.a(inputStream, fileOutputStream);
                            httpURLConnection.disconnect();
                            aVar.b = true;
                            aVar.e = jvVar.f;
                            a(0, aVar);
                            q.a(inputStream);
                            q.a(fileOutputStream);
                            return;
                        } catch (Exception e) {
                            closeable = fileOutputStream;
                            q.a(inputStream);
                            q.a(closeable);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            q.a(inputStream);
                            q.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        closeable = null;
                        q.a(inputStream);
                        q.a(closeable);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        q.a(inputStream);
                        q.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    closeable = null;
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    inputStream = null;
                    q.a(inputStream);
                    q.a(fileOutputStream);
                    throw th;
                }
            }
            aVar.b = false;
            a(0, aVar);
            return;
        }
        a(2, null);
    }

    private void a(jt jtVar) {
        if (jtVar == null) {
            a(1, null);
        } else if (jtVar.b == 0 && this.a.equals(jtVar.a)) {
            a aVar = new a();
            aVar.a = jtVar.a;
            aVar.c = jtVar.d;
            if (jtVar.c == 1) {
                aVar.b = true;
                aVar.e = jtVar.g;
                if (jtVar.e == 1) {
                    aVar.d = ZipUtil.inflate(jtVar.f);
                    a(0, aVar);
                    return;
                }
                aVar.d = jtVar.f;
                a(0, aVar);
                return;
            }
            aVar.b = false;
            a(0, aVar);
        } else {
            a(2, null);
        }
    }

    private void a(int i, a aVar) {
        if (this.b != null && this.b.get() != null) {
            ((m) this.b.get()).a(i, aVar);
        }
    }
}
