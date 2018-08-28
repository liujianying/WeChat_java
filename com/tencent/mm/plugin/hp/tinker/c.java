package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class c extends a {
    public c(Context context) {
        super(context);
    }

    public final void a(Throwable th, int i) {
        super.a(th, i);
        b.a(th, i);
    }

    public final void a(File file, int i) {
        super.a(file, i);
        b.rs(i);
    }

    public final void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z)});
        if (i == 4) {
            aWr();
        } else {
            cGU();
        }
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.e.a.hL(this.context).vsD;
            if (dVar.vsI != null && "00000000000000000000000000000000".equals(dVar.vsI)) {
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.ie(this.context);
            }
        }
        b.rr(i);
    }

    public final void d(int i, Throwable th) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[]{Integer.valueOf(i), th});
        switch (i) {
            case 0:
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        aWr();
        b.c(i, th);
    }

    public final void b(File file, int i) {
        super.b(file, i);
        b.j(ad.sGA, i);
    }

    public final void a(String str, String str2, File file) {
        super.a(str, str2, file);
        b.aWn();
    }

    public final void a(String str, String str2, File file, String str3) {
        super.a(str, str2, file, str3);
        b.aWo();
    }

    public final void a(File file, int i, long j) {
        super.a(file, i, j);
        switch (i) {
            case 0:
                b.m(j, com.tencent.tinker.lib.e.a.hL(this.context).ons);
                break;
        }
        if (com.tencent.tinker.lib.e.a.hL(this.context).ons) {
            String absolutePath = new File(SharePatchFileUtil.hW(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
            } else {
                a aVar = new a(this.context, new 2(this));
            }
        } else {
            com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        }
        x.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        if (i == 0) {
            d dVar = com.tencent.tinker.lib.e.a.hL(this.context).vsD;
            x.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[]{dVar.vsI});
            if (!TextUtils.isEmpty(dVar.vsI)) {
                Context context = this.context;
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", dVar.vsI).apply();
            }
        }
    }

    public final void c(File file, int i) {
        super.c(file, i);
        if (i == -26 || i == -5) {
            ShareTinkerInternals.ia(this.context);
            com.tencent.tinker.lib.e.a.hL(this.context).tinkerFlags = 0;
        }
        b.ro(i);
    }

    private void aWr() {
        a aVar = new a(this.context, new 1(this));
    }
}
