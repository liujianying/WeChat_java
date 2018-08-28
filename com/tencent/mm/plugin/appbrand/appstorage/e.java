package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Pattern;

public class e implements l {
    public final String fjY;
    public volatile long fjZ = -1;
    private final b fka = new 1(this);
    private final b fkb = new 4(this);
    private final b fkc = new 5(this);
    private final b fkd = new 6(this);
    private final a fke = new 7(this);
    private final a fkf = new 8(this);
    private final a fkg = new 9(this);
    private final b fkh = new b() {
        public final j v(File file) {
            if (file.isDirectory()) {
                return j.fkR;
            }
            if (!file.exists()) {
                return j.fkO;
            }
            int unlink = FileUnlink.unlink(file.getPath());
            if (unlink != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "unlink err %d, %s", new Object[]{Integer.valueOf(unlink), file.getPath()});
            }
            return unlink == 0 ? j.fkI : j.fkJ;
        }
    };
    private final a fki = new a() {
        public final j a(File file, Object... objArr) {
            if (!file.exists()) {
                return j.fkO;
            }
            int stat = FileStat.stat(file.getPath(), (FileStructStat) objArr[0]);
            if (stat != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "stat err %d, %s", new Object[]{Integer.valueOf(stat), file.getPath()});
            }
            return stat == 0 ? j.fkI : j.fkJ;
        }
    };
    private final a fkj = new a() {
        public final j a(File file, Object... objArr) {
            File file2 = (File) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (file.isDirectory()) {
                return j.fkN;
            }
            if (k.z(file)) {
                return j.fkS;
            }
            if (e.this.fjZ <= 0 || k.w(new File(e.this.fjY)) + file2.length() <= e.this.fjZ) {
                return booleanValue ? i.aX(file2.getAbsolutePath(), file.getAbsolutePath()) ? j.fkI : j.fkJ : j.q(file2.getAbsolutePath(), file.getAbsolutePath(), false) ? j.fkI : j.fkJ;
            } else {
                return j.fkT;
            }
        }
    };
    private final a fkk = new 3(this);

    public e(String... strArr) {
        this.fjY = m.i(strArr);
    }

    public final boolean bV(String str) {
        return bi.oV(str).startsWith("wxfile://usr");
    }

    public final void initialize() {
    }

    public final void release() {
    }

    private File acC() {
        if ("[INVALID]".equals(this.fjY)) {
            return null;
        }
        File file = new File(this.fjY);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
        try {
            new File(file.getPath() + "/.nomedia").createNewFile();
            return file;
        } catch (Exception e) {
            return file;
        }
    }

    private j a(String str, a aVar, Object... objArr) {
        if (bi.oW(str)) {
            return j.fkM;
        }
        String qB = a.qB(str.replaceFirst(Pattern.quote("wxfile://usr"), ""));
        File acC = acC();
        if (acC == null) {
            return j.fkK;
        }
        qB = org.a.a.a.a.gB(acC.getAbsolutePath(), qB);
        if (bi.oW(qB)) {
            return j.fkM;
        }
        acC = new File(qB);
        if (!m.e(acC(), acC)) {
            return j.fkM;
        }
        if (acC.getParentFile().exists()) {
            return aVar.a(acC, objArr);
        }
        return j.fkL;
    }

    public final j ra(String str) {
        return a(str, this.fka, new Object[0]);
    }

    public final j rf(String str) {
        return a(str, this.fkb, new Object[0]);
    }

    public final j rg(String str) {
        return a(str, this.fkc, new Object[0]);
    }

    public final j rh(String str) {
        return a(str, this.fkd, new Object[0]);
    }

    public final j b(String str, h<List<h>> hVar) {
        return a(str, this.fke, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return a(str, this.fkf, hVar);
    }

    public final j a(String str, InputStream inputStream, boolean z) {
        if (inputStream == null) {
            return j.fkJ;
        }
        return a(str, this.fkg, inputStream, Boolean.valueOf(z));
    }

    public final j ri(String str) {
        return a(str, this.fkh, new Object[0]);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return a(str, this.fki, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return a(str, this.fkj, file, Boolean.valueOf(z));
    }

    public final File rb(String str) {
        h hVar = new h();
        a(str, this.fkk, hVar);
        return (File) hVar.value;
    }
}
