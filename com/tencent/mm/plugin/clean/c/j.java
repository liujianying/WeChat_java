package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.j.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements ar {
    private static j hRq;
    public long hQC;
    public long hQD;
    public long hQE;
    public HashSet<String> hRd;
    public HashMap<String, Long> hRp;

    public static j aBt() {
        if (hRq == null) {
            hRq = new j();
        }
        return hRq;
    }

    private j() {
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
        d.aBn();
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[]{Boolean.valueOf(z)});
        b.avr().onAccountInitialized(null);
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[]{Boolean.valueOf(z)});
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.hQC = 0;
        this.hQD = 0;
        this.hQE = 0;
        if (this.hRp != null) {
            this.hRp.clear();
        }
        if (this.hRd != null) {
            this.hRd.clear();
        }
        d.aBn();
        b.avr().onAccountRelease();
    }

    public static long aBa() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnC);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long aBb() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnC);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }
}
