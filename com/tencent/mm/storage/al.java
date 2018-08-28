package com.tencent.mm.storage;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.List;

final class al {
    protected final long taQ = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private ak taR = new ak();

    public al() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        byte[] f = e.f(stringBuilder.append(g.Ei().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!bi.bC(f)) {
            try {
                this.taR.aG(f);
                if (clM()) {
                    clL();
                }
            } catch (Throwable e) {
                x.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                x.e("MicroMsg.DelSvrIdMgr", "exception:%s", bi.i(e));
            }
        }
    }

    private void clL() {
        x.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.taR.taN.size()), Integer.valueOf(this.taR.taO.size()), Integer.valueOf(this.taR.taP.size()), bi.cjd());
        try {
            this.taR.taM.clear();
            this.taR.taL.clear();
            this.taR.taK.clear();
            ak akVar = new ak();
            akVar.taN.addAll(this.taR.taN);
            akVar.taO.addAll(this.taR.taO);
            akVar.taP.addAll(this.taR.taP);
            byte[] toByteArray = akVar.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            e.b(stringBuilder.append(g.Ei().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
            String str = "MicroMsg.DelSvrIdMgr";
            String str2 = "summerdel toFile done [%d, %d, %d] data len[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(akVar.taN.size());
            objArr[1] = Integer.valueOf(akVar.taO.size());
            objArr[2] = Integer.valueOf(akVar.taP.size());
            objArr[3] = Integer.valueOf(toByteArray == null ? -1 : toByteArray.length);
            x.i(str, str2, objArr);
        } catch (Throwable e) {
            f.mDy.a(111, 168, 1, false);
            x.printErrStackTrace("MicroMsg.DelSvrIdMgr", e, "summerdel ", new Object[0]);
        }
    }

    protected final boolean gm(long j) {
        if (clM()) {
            clL();
        }
        return this.taR.taN.contains(Long.valueOf(j)) || this.taR.taO.contains(Long.valueOf(j)) || this.taR.taP.contains(Long.valueOf(j));
    }

    protected final void j(int i, long j, long j2) {
        a(i, j, j2, true);
    }

    protected final void a(int i, long j, long j2, boolean z) {
        if (j != 0) {
            if (z) {
                clM();
            }
            switch (i - ((int) (j2 / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC))) {
                case 0:
                    this.taR.taN.add(Long.valueOf(j));
                    break;
                case 1:
                    this.taR.taO.add(Long.valueOf(j));
                    break;
                case 2:
                    this.taR.taP.add(Long.valueOf(j));
                    break;
                default:
                    x.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC))));
                    break;
            }
            if (z) {
                clL();
            }
        }
    }

    protected final void h(List<Integer> list, List<Long> list2) {
        x.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        clM();
        int VE = (int) (bi.VE() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        for (int i = 0; i < list.size(); i++) {
            a(VE, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        clL();
    }

    private boolean clM() {
        x.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.taR.taJ), Integer.valueOf(this.taR.taN.size()), Integer.valueOf(this.taR.taO.size()), Integer.valueOf(this.taR.taP.size()));
        int VE = (int) (bi.VE() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        int i = VE - this.taR.taJ;
        this.taR.taJ = VE;
        switch (i) {
            case 0:
                return false;
            case 1:
                this.taR.taP = this.taR.taO;
                this.taR.taO = this.taR.taN;
                this.taR.taN.clear();
                return true;
            case 2:
                this.taR.taP = this.taR.taN;
                this.taR.taO.clear();
                this.taR.taN.clear();
                return true;
            default:
                this.taR.taP.clear();
                this.taR.taO.clear();
                this.taR.taN.clear();
                return true;
        }
    }
}
