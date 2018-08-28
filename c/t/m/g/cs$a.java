package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;

public class cs$a extends Handler {
    private byte[] a = new byte[0];
    private File b;
    private BufferedOutputStream c;
    private StringBuffer d;
    private /* synthetic */ cs e;

    public cs$a(cs csVar, Looper looper) {
        this.e = csVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        List list = null;
        try {
            switch (message.what) {
                case 1001:
                case 1002:
                case 1010:
                    synchronized (this.a) {
                        int i = message.what;
                        b();
                        String str = "";
                        if (i == 1002) {
                            str = cq.a(this.e.a, this.e.h.a, null, this.e.f);
                        } else if (i == 1001) {
                            if (this.e.g != null) {
                                list = Collections.unmodifiableList(this.e.g.b);
                            }
                            if (list != null && list.size() > 0) {
                                str = cq.a(this.e.a, this.e.h.a, list, this.e.f);
                                dt dtVar = this.e.g;
                            }
                        }
                        if (!(this.c == null || TextUtils.isEmpty(str))) {
                            if (this.d == null) {
                                this.d = new StringBuffer(20480);
                            }
                            if (this.d.length() + str.length() > 20480) {
                                a();
                                if (!(this.b == null || this.b.length() <= 102400 || this.e.d == null)) {
                                    sendEmptyMessage(1007);
                                }
                            }
                            this.d.append(str).append("\n");
                            new StringBuilder("write: ").append(str.substring(0, 60)).append("***");
                        }
                    }
                    return;
                case 1003:
                    if (this.e.a()) {
                        File[] listFiles = this.e.b.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            for (File file : listFiles) {
                                if (file.isFile() && file.exists() && file.getName().startsWith("dc3_")) {
                                    new StringBuilder("upload:").append(file.getName()).append(",len=").append(file.length());
                                    cp cpVar = new cp(this.e.a, file.getAbsolutePath());
                                    if (!cpVar.b) {
                                        cpVar.b = true;
                                        new Thread(new Runnable() {
                                            public final void run() {
                                                try {
                                                    File file = new File(cp.this.a);
                                                    if (file.exists() && file.isFile()) {
                                                        byte[] a = j.a(file);
                                                        if (a != null && a.length > 0) {
                                                            Bundle a2 = cp.this.c.a("http://analytics.map.qq.com/?sf3", a);
                                                            if (a2 != null && !a2.isEmpty()) {
                                                                file.delete();
                                                                new StringBuilder("upload ").append(file.getName()).append(" succeed and deleted.");
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                }
                                            }
                                        }, "th_upload_dc").start();
                                    }
                                    this.e.i = System.currentTimeMillis();
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1004:
                    this.e.a(false);
                    return;
                case 1005:
                    try {
                        if (this.c != null) {
                            this.c.flush();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        this.b = null;
                        j.a(this.c);
                        return;
                    }
                case 1006:
                    a();
                    if (this.d != null) {
                        this.d.setLength(0);
                    }
                    this.b = null;
                    j.a(this.c);
                    return;
                case 1007:
                    b();
                    if (this.e.b != null && this.b != null && this.b.exists()) {
                        a();
                        if (this.b.length() > 102400 || System.currentTimeMillis() - c() > 259200000) {
                            try {
                                if (this.b != null && this.b.length() >= 1024) {
                                    File file2 = new File(this.e.b, "dc3_" + System.currentTimeMillis());
                                    this.b.renameTo(file2);
                                    new StringBuilder("rename:").append(this.b.getName()).append(" to ").append(file2.getName());
                                    j.a(this.c);
                                    this.b = null;
                                    this.c = null;
                                    d();
                                    a(0);
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th3) {
            new StringBuilder("handle msg:").append(message.what).append(" error.");
        }
        new StringBuilder("handle msg:").append(message.what).append(" error.");
    }

    private void a() {
        if (this.d != null && this.d.length() != 0 && this.c != null) {
            byte[] a = ei.a(this.d.toString(), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
            new StringBuilder("write buf to file: buf size:").append(this.d.length()).append(",enc size:").append(a.length);
            this.d.setLength(0);
            if (a != null && a.length != 0) {
                try {
                    this.c.write(a);
                } catch (Throwable th) {
                    this.b = null;
                    j.a(this.c);
                }
            }
        }
    }

    private void b() {
        if (this.b == null || !this.b.exists() || this.c == null || !"dc3".equals(this.b.getName())) {
            File file = this.e.b;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = new File(file, "dc3");
            try {
                boolean exists = this.b.exists();
                this.c = new BufferedOutputStream(new FileOutputStream(this.b, true), 1024);
                if (!exists) {
                    a(System.currentTimeMillis());
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(long j) {
        try {
            this.e.a.a.getSharedPreferences("LocationSDK", 0).edit().putLong("dc_create", j).apply();
        } catch (Throwable th) {
        }
    }

    private long c() {
        long j = 0;
        try {
            return this.e.a.a.getSharedPreferences("LocationSDK", 0).getLong("dc_create", 0);
        } catch (Throwable th) {
            return j;
        }
    }

    private void d() {
        File[] listFiles = this.e.b.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (File file : listFiles) {
                if (file.isFile() && file.exists() && !"dc3".equals(file.getName()) && (currentTimeMillis - file.lastModified() > 2592000000L || file.length() == 0)) {
                    new StringBuilder("delete expired file:").append(file.getName());
                    file.delete();
                }
            }
        }
    }
}
