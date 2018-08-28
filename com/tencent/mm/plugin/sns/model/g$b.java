package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$b extends h<String, Integer, Boolean> {
    String aAL = "";
    private ate caK;
    private n dvu = null;
    private String elx;
    private int nnD = 0;
    final /* synthetic */ g nnr;
    private String path;

    public final /* synthetic */ Object bxI() {
        g.a(this.nnr, true);
        System.currentTimeMillis();
        if (!g.h(this.nnr)) {
            x.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
            return Boolean.valueOf(false);
        } else if (g.f(this.nnr).bb(this.aAL)) {
            x.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
            return Boolean.valueOf(false);
        } else {
            FileOp.mN(this.elx);
            long currentTimeMillis = System.currentTimeMillis();
            if (FileOp.cn(this.path)) {
                x.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[]{this.path});
            } else {
                X(i.e(this.caK), i.l(this.caK), i.f(this.caK));
            }
            long VG = bi.VG();
            if (this.nnD == 5) {
                if (!FileOp.cn(this.path)) {
                    X(i.e(this.caK), i.l(this.caK), i.f(this.caK));
                }
                boolean cn = FileOp.cn(this.elx + i.e(this.caK));
                boolean cn2 = FileOp.cn(this.elx + i.l(this.caK));
                boolean cn3 = FileOp.cn(this.elx + i.f(this.caK));
                this.dvu = i.LH(this.path);
                if (this.dvu == null) {
                    x.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                    this.dvu = a.ev(this.elx + i.f(this.caK), this.path);
                    x.i("MicroMsg.ImageLoader", "abc a" + cn + " b" + cn2 + " c" + cn3 + " d" + FileOp.cn(this.path));
                }
            } else if (this.nnD == 4) {
                this.dvu = i.LH(this.path);
                if (this.dvu == null) {
                    x.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                    this.dvu = a.ev(this.elx + i.e(this.caK), this.path);
                }
            } else {
                this.dvu = i.LJ(this.path);
            }
            long bI = bi.bI(VG);
            int mI = (int) FileOp.mI(this.path);
            if (bi.bI(g.i(this.nnr)) > 60000) {
                h.mEJ.h(11696, new Object[]{Integer.valueOf(4), Long.valueOf(bI), Integer.valueOf(mI), Thread.currentThread().getName(), af.byB(), e.bnC});
                g.b(this.nnr, bi.VG());
            }
            if (this.dvu == null) {
                x.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[]{this.caK.ksA});
                FileOp.deleteFile(this.elx + i.f(this.caK));
                FileOp.deleteFile(this.path);
                h.mEJ.a(150, 2, 1, true);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            h.mEJ.a(150, 0, 1, true);
            h.mEJ.a(150, 1, currentTimeMillis, true);
            x.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.dvu == null) + " " + this.dvu + " %d ", new Object[]{this.path, Long.valueOf(System.currentTimeMillis() - VG)});
            return Boolean.valueOf(true);
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        g.bxG();
        this.nnr.nnp.remove(this.aAL);
        this.nnr.b(this.aAL, this.dvu);
        g.a(this.nnr, false);
        g.g(this.nnr);
    }

    public g$b(g gVar, String str, String str2, String str3, ate ate, int i) {
        this.nnr = gVar;
        gVar.nnp.add(str);
        this.aAL = str;
        this.path = str2;
        this.elx = str3;
        this.caK = ate;
        this.nnD = i;
        g.bxE();
        x.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[]{Integer.valueOf(g.bxF())});
    }

    private void X(String str, String str2, String str3) {
        FileOp.cn(this.elx + str3);
        if (!FileOp.cn(this.elx + str)) {
            if (!FileOp.cn(this.elx + str2)) {
                str2 = i.m(this.caK);
            }
            if (!s.a(this.elx, str2, str, (float) af.byx())) {
                x.i("MicroMsg.ImageLoader", "delete %s", new Object[]{str2});
                FileOp.deleteFile(this.elx + str2);
            }
            x.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[]{this.elx + str2, this.elx + str, Boolean.valueOf(r0)});
        }
        s.b(this.elx, str, str3, (float) af.byw());
    }

    public final ag bxH() {
        return af.aRs();
    }
}
