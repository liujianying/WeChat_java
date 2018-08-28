package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i {
    public static final i oYM = new i();
    private static final String oYN = (b.bnE + "wallet/lqt");
    private static final String oYO = (oYN + "/save/");
    private static final String oYP = (oYN + "/fetch/");
    public arq oYG;
    public arq oYH;
    private long oYI;
    private long oYJ;
    private List<Bankcard> oYK;
    private List<Bankcard> oYL;

    public final void a(arq arq, boolean z) {
        if (arq != null) {
            if (z) {
                this.oYG = arq;
                this.oYK = null;
                this.oYI = System.currentTimeMillis();
            } else {
                this.oYH = arq;
                this.oYL = null;
                this.oYJ = System.currentTimeMillis();
            }
            x.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[]{arq, Boolean.valueOf(z)});
            try {
                e.post(new 1(this, arq.toByteArray(), z), "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final Bankcard jb(boolean z) {
        jf(z);
        arq arq = z ? this.oYG : this.oYH;
        if (!(arq == null || bi.oW(arq.rTR))) {
            List<Bankcard> je = je(z);
            if (je != null && je.size() > 0) {
                String str = arq.rTR;
                if (!bi.oW(str)) {
                    for (Bankcard bankcard : je) {
                        if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                            return bankcard;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final List<Bankcard> jc(boolean z) {
        jf(z);
        if ((z ? this.oYG : this.oYH) != null) {
            return je(z);
        }
        return null;
    }

    public final String jd(boolean z) {
        jf(z);
        arq arq = z ? this.oYG : this.oYH;
        if (arq != null) {
            return arq.rTU;
        }
        return null;
    }

    private List<Bankcard> je(boolean z) {
        if ((z ? this.oYG : this.oYH) != null) {
            if (z) {
                if (this.oYK != null && this.oYK.size() > 0) {
                    return this.oYK;
                }
            } else if (this.oYL != null && this.oYL.size() > 0) {
                return this.oYL;
            }
            Bankcard a;
            Iterator it;
            if (z) {
                this.oYK = new ArrayList();
                if (this.oYG.rTT != null) {
                    a = ab.a(this.oYG.rTT);
                    if (a != null) {
                        this.oYK.add(a);
                    }
                }
                if (this.oYG.rFB != null && this.oYG.rFB.size() > 0) {
                    it = this.oYG.rFB.iterator();
                    while (it.hasNext()) {
                        a = d.a((ll) it.next());
                        if (a != null) {
                            this.oYK.add(a);
                        }
                    }
                }
                return this.oYK;
            }
            this.oYL = new ArrayList();
            if (this.oYH.rTT != null) {
                a = ab.a(this.oYH.rTT);
                if (a != null) {
                    this.oYL.add(a);
                }
            }
            if (this.oYH.rFB != null && this.oYH.rFB.size() > 0) {
                it = this.oYH.rFB.iterator();
                while (it.hasNext()) {
                    a = d.a((ll) it.next());
                    if (a != null) {
                        this.oYL.add(a);
                    }
                }
            }
            return this.oYL;
        } else if (z) {
            this.oYK = null;
            return null;
        } else {
            this.oYL = null;
            return null;
        }
    }

    public final void jf(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        arq arq = z ? this.oYG : this.oYH;
        long j = z ? this.oYI : this.oYJ;
        if (arq != null) {
            if (currentTimeMillis - j > 3600000) {
                x.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
                this.oYG = null;
                if (z) {
                    this.oYI = 0;
                } else {
                    this.oYJ = 0;
                }
            } else {
                return;
            }
        }
        String str = z ? oYO : oYP;
        List<FileEntry> H = FileOp.H(str, false);
        if (H != null && H.size() != 0) {
            x.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[]{H, Boolean.valueOf(z)});
            long currentTimeMillis2 = System.currentTimeMillis();
            for (FileEntry fileEntry : H) {
                String name = new File(fileEntry.name).getName();
                String str2 = str + name;
                long j2 = bi.getLong(name, 0);
                x.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[]{Long.valueOf(j2)});
                if (j2 <= 0) {
                    FileOp.deleteFile(str2);
                } else if (currentTimeMillis2 - j2 < 3600000) {
                    byte[] e = FileOp.e(str2, 0, (int) FileOp.mI(str2));
                    arq arq2 = new arq();
                    try {
                        arq2.aG(e);
                    } catch (Throwable e2) {
                        arq2 = null;
                        x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "parse bindquery from cache error: %s", new Object[]{e2.getMessage()});
                    }
                    if (arq2 != null) {
                        if (z) {
                            this.oYG = arq2;
                            this.oYK = null;
                            this.oYI = j2;
                        } else {
                            this.oYH = arq2;
                            this.oYL = null;
                            this.oYJ = j2;
                        }
                        x.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[]{arq2, Long.valueOf(j2)});
                        return;
                    }
                } else {
                    FileOp.deleteFile(str2);
                }
            }
        }
    }
}
