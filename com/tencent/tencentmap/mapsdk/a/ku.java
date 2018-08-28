package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.lib.d;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.map.lib.util.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ku implements m {
    private static ku d;
    private static volatile boolean f = false;
    private int a = 0;
    private r b;
    private o c;
    private List<WeakReference<f>> e;

    public static synchronized ku a(Context context, f fVar) {
        ku kuVar;
        synchronized (ku.class) {
            if (d == null) {
                d = new ku(context, fVar);
            }
            d.e.add(new WeakReference(fVar));
            kuVar = d;
        }
        return kuVar;
    }

    private ku(Context context, f fVar) {
        this.b = r.a(context);
        this.c = o.a(context);
        this.e = new ArrayList();
    }

    public void a() {
        if (!f) {
            f = true;
            new a(this).start();
        }
    }

    private int b() {
        if (this.b != null) {
            return this.b.d();
        }
        return 0;
    }

    private int c() {
        if (this.b != null) {
            return this.b.u();
        }
        return 0;
    }

    private int d() {
        if (this.b != null) {
            return this.b.v();
        }
        return 0;
    }

    private int e() {
        if (this.b != null) {
            return this.b.p();
        }
        return 0;
    }

    private int f() {
        if (this.b != null) {
            return this.b.q();
        }
        return 0;
    }

    public void a(int i, Object obj) {
        if (i != 0) {
            a(false, null);
        } else if (obj instanceof n$a) {
            a(true, (n$a) obj);
        }
    }

    private void a(String str, int i) {
        new n().a(str, i, this);
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ju("mapconfig", this.b.a(), this.b.r()));
        arrayList.add(new ju("poi_icon", this.b.b(), this.b.s()));
        arrayList.add(new ju("map_icon", this.b.c(), this.b.t()));
        jr jrVar = new jr(arrayList, kh.a, this.b.e(), null);
        new n().a(this.c.j(), jrVar, this);
    }

    private void a(boolean z, n$a n_a) {
        b(z, n_a);
        this.a++;
        if (this.a == 8) {
            this.b.a(System.currentTimeMillis());
        }
    }

    private void b(boolean z, n$a n_a) {
        if (z && n_a != null && n_a.b) {
            String h = this.c.h();
            String i = this.c.i();
            q.a(this.c.j());
            String str = this.c.j() + n_a.a;
            String str2 = n_a.a;
            boolean z2 = true;
            switch (str2.hashCode()) {
                case -1105972063:
                    if (str2.equals("indoorpoi_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -810824476:
                    if (str2.equals("closedroadstyle_normalmode")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -752505210:
                    if (str2.equals("closedroadstyle_trafficmode")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 178735484:
                    if (str2.equals("map_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 451944782:
                    if (str2.equals("poi_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1221876167:
                    if (str2.equals("rtt_config.json")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1366209438:
                    if (str2.equals("mapconfig")) {
                        z2 = false;
                        break;
                    }
                    break;
                case 1590879768:
                    if (str2.equals("indoormap_config")) {
                        z2 = true;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                    if (a(str, h, n_a.e, false)) {
                        this.b.a(n_a.c);
                        this.b.f(n_a.e);
                        break;
                    }
                    break;
                case true:
                    if (a(str, h, n_a.e, true)) {
                        this.b.b(n_a.c);
                        this.b.g(n_a.e);
                        break;
                    }
                    break;
                case true:
                    if (a(str, i, n_a.e, true)) {
                        this.b.c(n_a.c);
                        this.b.h(n_a.e);
                        break;
                    }
                    break;
                case true:
                    if (a("rtt_config.json", n_a.d, n_a.e)) {
                        this.b.d(n_a.c);
                        break;
                    }
                    break;
                case true:
                    if (a("style_normalmode.xml", n_a.d, n_a.e)) {
                        this.b.k(n_a.c);
                        break;
                    }
                    break;
                case true:
                    if (a("style_trafficmode.xml", n_a.d, n_a.e)) {
                        this.b.l(n_a.c);
                        break;
                    }
                    break;
                case true:
                    if (a("indoormap_config.dat", n_a.d, n_a.e)) {
                        this.b.i(n_a.c);
                        break;
                    }
                    break;
                case true:
                    if (a("poi_icon_file_indoor.png", n_a.d, n_a.e)) {
                        this.b.j(n_a.c);
                        break;
                    }
                    break;
            }
            q.c(this.c.j());
        }
    }

    private boolean a(String str, byte[] bArr, String str2) {
        if (StringUtil.isEmpty(str) || this.e.size() == 0) {
            return false;
        }
        f fVar = (f) ((WeakReference) this.e.get(0)).get();
        if (bArr == null || StringUtil.isEmpty(str2) || fVar == null) {
            return false;
        }
        if (!TextUtils.equals(a.a(bArr), str2)) {
            return false;
        }
        boolean a = fVar.a(str, bArr);
        if (a) {
            fVar.o();
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, boolean z) {
        Throwable th;
        File file = new File(str);
        if (!file.exists() || str3 == null) {
            return false;
        }
        try {
            if (!str3.equals(a.a(file))) {
                return false;
            }
        } catch (FileNotFoundException e) {
            d.b(e.getMessage());
        }
        if (z) {
            try {
                ZipUtil.upZipFile(file, this.c.j());
                file.delete();
            } catch (IOException e2) {
                d.b(e2.getMessage());
            }
        }
        File file2 = new File(this.c.j());
        if (file2.exists() && file2.isDirectory()) {
            f fVar;
            f fVar2;
            f fVar3 = null;
            int i = 0;
            while (i < this.e.size()) {
                fVar = (f) ((WeakReference) this.e.get(i)).get();
                if (fVar != null) {
                    fVar2 = fVar;
                    break;
                }
                this.e.remove(i);
                i++;
                fVar3 = fVar;
            }
            fVar2 = fVar3;
            if (fVar2 == null) {
                return false;
            }
            boolean z2 = true;
            File[] listFiles = file2.listFiles();
            if (this.e.get(0) == null) {
                return false;
            }
            for (File file3 : listFiles) {
                String a = a(file3.getName());
                if (a == null) {
                    file3.delete();
                } else {
                    Closeable closeable = null;
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            boolean b;
                            byte[] bArr = new byte[((int) file3.length())];
                            fileInputStream.read(bArr, 0, bArr.length);
                            if (fVar2 == null || !str2.equals(this.c.h())) {
                                if (fVar2 != null) {
                                    if (str2.equals(this.c.i())) {
                                        b = fVar2.b(a, bArr) & z2;
                                    }
                                }
                                b = z2;
                            } else {
                                b = fVar2.a(a, bArr) & z2;
                            }
                            q.a(fileInputStream);
                            z2 = b;
                        } catch (FileNotFoundException e3) {
                            closeable = fileInputStream;
                            q.a(closeable);
                        } catch (IOException e4) {
                            q.a(fileInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            q.a(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        q.a(closeable);
                    } catch (IOException e6) {
                        fileInputStream = null;
                        q.a(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.e.size()) {
                    return z2;
                }
                fVar = (f) ((WeakReference) this.e.get(i3)).get();
                if (fVar != null) {
                    fVar.o();
                    fVar.a();
                }
                i2 = i3 + 1;
            }
        } else {
            d.b("Config temp dir not exists:" + this.c.j());
            return false;
        }
    }

    private String a(String str) {
        if (str.contains("@2x")) {
            str = str.replace("@2x", "");
        }
        if (str.equals("mapconfig")) {
            return "mapconfig.dat";
        }
        if (str.equals("poi_icon.png")) {
            return "poi_icon_file.png";
        }
        if (str.equals("poi_icon_navi.png")) {
            return "poi_icon_file_nav.png";
        }
        if (str.equals("poi_icon_sat.png")) {
            return "poi_icon_file_sat.png";
        }
        if (str.equals("poi_icon_dark.png")) {
            return "poi_icon_file_dark.png";
        }
        if (str.contains("@3x")) {
            return null;
        }
        if (str.contains(".")) {
            return str;
        }
        return null;
    }
}
