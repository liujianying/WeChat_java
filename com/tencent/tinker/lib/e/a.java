package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class a {
    private static a vsu;
    public static boolean vsv = false;
    public final Context context;
    public final boolean ons;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;
    public final File vsA;
    public final File vsB;
    public final boolean vsC;
    public d vsD;
    public boolean vsE;
    public final File vsw;
    final b vsx;
    public final c vsy;
    public final d vsz;

    public static class a {
        private final Context context;
        public int status = -1;
        private File vsA;
        private File vsB;
        private final boolean vsF;
        private final boolean vsG;
        public Boolean vsH;
        private File vsw;
        public b vsx;
        public c vsy;
        public d vsz;

        public a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.vsF = com.tencent.tinker.lib.f.b.ic(context);
            this.vsG = com.tencent.tinker.lib.f.b.hP(context);
            this.vsw = SharePatchFileUtil.hV(context);
            if (this.vsw == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.vsA = SharePatchFileUtil.acT(this.vsw.getAbsolutePath());
            this.vsB = SharePatchFileUtil.acU(this.vsw.getAbsolutePath());
            com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[]{this.vsw});
        }

        public final a cGX() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.vsy == null) {
                this.vsy = new com.tencent.tinker.lib.d.a(this.context);
            }
            if (this.vsz == null) {
                this.vsz = new com.tencent.tinker.lib.d.b(this.context);
            }
            if (this.vsx == null) {
                this.vsx = new com.tencent.tinker.lib.b.a(this.context);
            }
            if (this.vsH == null) {
                this.vsH = Boolean.valueOf(false);
            }
            return new a(this.context, this.status, this.vsy, this.vsz, this.vsx, this.vsw, this.vsA, this.vsB, this.vsF, this.vsG, this.vsH.booleanValue(), (byte) 0);
        }
    }

    /* synthetic */ a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3, byte b) {
        this(context, i, cVar, dVar, bVar, file, file2, file3, z, z2, z3);
    }

    private a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.vsE = false;
        this.context = context;
        this.vsx = bVar;
        this.vsy = cVar;
        this.vsz = dVar;
        this.tinkerFlags = i;
        this.vsw = file;
        this.vsA = file2;
        this.vsB = file3;
        this.ons = z;
        this.tinkerLoadVerifyFlag = z3;
        this.vsC = z2;
    }

    public static a hL(Context context) {
        if (vsv) {
            synchronized (a.class) {
                if (vsu == null) {
                    vsu = new a(context).cGX();
                }
            }
            return vsu;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void a(a aVar) {
        if (vsu != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        vsu = aVar;
    }

    public final void aWt() {
        if (this.vsw != null) {
            if (this.vsE) {
                com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
            }
            SharePatchFileUtil.k(this.vsw);
        }
    }

    public final void ac(File file) {
        if (this.vsw != null && file != null && file.exists()) {
            String acV = SharePatchFileUtil.acV(SharePatchFileUtil.ak(file));
            if (this.vsw != null && acV != null) {
                SharePatchFileUtil.co(this.vsw.getAbsolutePath() + "/" + acV);
            }
        }
    }
}
