package com.tencent.mm.pluginsdk.g.a.a;

import android.support.v4.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class b {
    private final d pTD;
    private final Set<b> qBK;
    private final k qBL;

    /* synthetic */ b(byte b) {
        this();
    }

    final Set<b> ccp() {
        Set<b> newSetFromMap;
        synchronized (this.qBK) {
            newSetFromMap = Collections.newSetFromMap(new a(this.qBK.size()));
            newSetFromMap.addAll(this.qBK);
        }
        return newSetFromMap;
    }

    public final void e(int i, int i2, int i3, boolean z) {
        q.a.ccH().C(new 1(this, i, i2, i3, z));
    }

    public final void ae(int i, int i2, int i3) {
        e(i, i2, i3, true);
    }

    private b() {
        this.qBK = Collections.newSetFromMap(new a(i.qCl.length));
        this.qBL = new k();
        this.pTD = new 3(this);
        q.a.ccH().a("CheckResUpdate", this.pTD);
    }

    public static void BK(int i) {
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[]{Integer.valueOf(i)});
        g.Eg();
        boolean Dw = com.tencent.mm.kernel.a.Dw();
        boolean equals = at.dBv.I("login_user_name", "").equals("");
        if (Dw || !equals) {
            g.Eh().dpP.a(new m(i), 0);
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
    }

    public static String ew(int i, int i2) {
        s Tn = q.a.ccH().Tn(i.ex(i, i2));
        if (Tn == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return null;
        }
        x.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[]{Boolean.valueOf(Tn.field_deleted), Tn.field_filePath, Tn.field_md5, Boolean.valueOf(Tn.field_fileCompress), Boolean.valueOf(Tn.field_fileEncrypt), Tn.field_originalMd5});
        if (Tn.field_fileCompress || Tn.field_fileEncrypt) {
            String str;
            if (Tn.field_fileCompress) {
                str = Tn.field_filePath + ".decompressed";
            } else if (Tn.field_fileEncrypt) {
                str = Tn.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (bi.oW(str)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return null;
            } else if (bi.oW(Tn.field_originalMd5) || !bi.oV(com.tencent.mm.a.g.cu(str)).equals(Tn.field_originalMd5)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return null;
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                return str;
            }
        } else if (Tn.field_deleted || bi.oW(Tn.field_filePath) || !bi.oV(com.tencent.mm.a.g.cu(Tn.field_filePath)).equals(Tn.field_md5)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return null;
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Tn.field_filePath});
            return Tn.field_filePath;
        }
    }

    final void b(s sVar) {
        x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + sVar.field_urlKey);
        k kVar = this.qBL;
        if (kVar.Tl(sVar.field_urlKey)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
        } else {
            kVar.a(a.a(sVar));
        }
    }

    final void a(int i, bhi bhi, boolean z) {
        String ex = i.ex(i, bhi.sdX);
        if (bhi.sih == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bhi.sdX), Integer.valueOf(bhi.sih.sir)});
        j.n((long) bhi.sij, 3);
        int i2 = bhi.sih.sir;
        q.a.ccH().C(new 4(this, ex, i, bhi.sdX, i2, bhi.sij, bhi.sik, z));
    }

    final void b(int i, bhi bhi, boolean z) {
        String ex = i.ex(i, bhi.sdX);
        if (bhi.sih == null) {
            x.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[]{ex});
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bhi.sdX);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(bhi.sih.sir);
        if (bhi.sih.sit == null) {
            str = "null";
        } else {
            str = String.valueOf(bhi.sih.sit.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(bhi.sij);
        objArr[6] = bhi.sik;
        objArr[7] = bhi.sih.jPK;
        objArr[8] = bhi.sih.rwb;
        x.i(str2, str3, objArr);
        if (bhi.sih.sit != null) {
            Iterator it = bhi.sih.sit.iterator();
            while (it.hasNext()) {
                bns bns = (bns) it.next();
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[]{Integer.valueOf(bns.hcD), bns.slN.cfV()});
            }
        }
        j.fN((long) bhi.sij);
        if (!z) {
            j.n((long) bhi.sij, 1);
        }
        if (bhi.rlY != 0 && ((long) bhi.rlY) <= bi.VE()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[]{ex, Integer.valueOf(bhi.rlY), Integer.valueOf(bhi.sih.sir)});
            j.n((long) bhi.sij, 14);
            j.n((long) bhi.sij, 44);
            j.a(i, bhi.sdX, bhi.sih.jPK, bhi.sih.sir, j.a.qCB, false, z, false, bhi.sik);
        } else if (bi.oW(bhi.sih.jPK) && bhi.sih.rwb == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
        } else {
            g.a aVar = new g.a(bhi.sih.jPK);
            aVar.qBy = ex;
            aVar.bIC = i;
            aVar.bID = bhi.sdX;
            aVar.eiD = (long) bhi.rlY;
            aVar.bIE = bhi.sih.sir;
            aVar.bKg = bhi.sih.rwt;
            aVar.qCf = i.a.BM(bhi.sih.sis);
            aVar.qCg = i.a.BL(bhi.sih.sis);
            aVar.qBG = (long) bhi.sij;
            aVar.qBH = bhi.sik;
            aVar.qBI = bhi.sil > 0 ? bhi.sil : 3;
            aVar.qCh = bhi.qCh;
            aVar.networkType = bhi.sim;
            aVar.bIJ = z;
            if (!bi.cX(bhi.sih.sit)) {
                aVar.qBD = ((bns) bhi.sih.sit.get(0)).slN.lR;
            }
            if (!(bhi.sii == null || bi.oW(bhi.sii.siq))) {
                aVar.qBB = bhi.sii.siq;
                aVar.qBC = bhi.sii.sip;
            }
            if (bhi.sih.rwb != null && bhi.sih.rwb.lR.length > 0) {
                aVar.qCe = bhi.sih.rwb.toByteArray();
            }
            aVar.qBE = bhi.sih.siu;
            aVar.fileSize = (long) bhi.sih.ruE;
            aVar.priority = bhi.rPB;
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[]{new g(aVar.url, aVar.qBy, aVar.bIE, aVar.networkType, aVar.qBI, aVar.eiD, aVar.bKg, aVar.bIC, aVar.bID, aVar.qBG, aVar.qBH, aVar.qBD, aVar.qBE, aVar.qCf, aVar.qCg, aVar.qBB, aVar.qBC, aVar.qCh, aVar.qCe, aVar.fileSize, aVar.bIJ, aVar.bIF, aVar.priority).toString()});
            q.a.ccH().C(new 5(this, ex, r2));
        }
    }

    final void a(int i, bhi bhi, boolean z, boolean z2) {
        String ex = i.ex(i, bhi.sdX);
        if (bhi.sii == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
        } else if (bi.oW(bhi.sii.siq)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bhi.sdX), Integer.valueOf(bhi.sii.sip)});
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[]{bhi.sii.siq});
            j.n((long) bhi.sij, 4);
            q.a.ccH().C(new 6(this, ex, bhi.sih.siu, bhi.sii.siq, bhi.sii.sip, bhi.sij, bhi.sik, false));
        }
    }

    final void d(int i, int i2, String str, int i3) {
        q.a.ccH().C(new 7(this, i, i2, str, i3));
    }

    final void f(int i, int i2, int i3, boolean z) {
        if (q.a.ccH().handler == null) {
            x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
        } else {
            q.a.ccH().handler.post(new 2(this, i3, i, i2, z));
        }
    }
}
