package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class a implements o {
    private Queue<c> bFd = new LinkedList();
    private Map<String, com.tencent.mm.compatible.util.g.a> bFf = new HashMap();
    boolean bFh = false;
    boolean bFi = false;
    public int bFj = 0;
    long bFk = 0;
    public al bFo = new al(g.Em().lnJ.getLooper(), new 5(this), false);
    public n dOT = new 1(this);
    private i$a dVu = new 6(this);
    Map<String, a> iXA = new HashMap();
    Set<String> iXB = new HashSet();
    boolean iXC = ao.isWifi(ad.getContext());
    int iXD = 0;
    boolean iXE = true;
    private Runnable iXF = new 4(this);

    public a() {
        g.Ek();
        g.Eh().a(this.dOT);
    }

    public final void eN(final boolean z) {
        g.Em().H(new Runnable() {
            public final void run() {
                a.this.iXE = z;
                a.this.iXD = 0;
            }
        });
    }

    public final void Bp(String str) {
        x.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[]{str});
        g.Em().H(new 3(this, str));
    }

    public final void run() {
        x.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
        g.Em().cil().removeCallbacks(this.iXF);
        g.Em().H(this.iXF);
    }

    final void OI() {
        this.bFk = System.currentTimeMillis();
        if (!this.bFh && this.bFd.size() == 0) {
            if (f.zZ()) {
                List<c> aLu = ((ae) g.n(ae.class)).getFavCdnStorage().aLu();
                if (!(aLu == null || aLu.size() == 0)) {
                    for (c cVar : aLu) {
                        if (this.bFf.containsKey(cVar.field_dataId)) {
                            x.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + cVar.field_dataId);
                        } else {
                            this.bFd.add(cVar);
                            this.bFf.put(cVar.field_dataId, null);
                        }
                    }
                    x.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.bFf.size() + ",send:" + this.bFd.size() + "]");
                    this.bFd.size();
                }
            } else {
                x.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
                wx();
            }
        }
        if (!this.bFh && this.bFd.size() <= 0) {
            wx();
            x.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
        } else if (!this.bFh && this.bFd.size() > 0) {
            c cVar2;
            try {
                cVar2 = (c) this.bFd.poll();
            } catch (Throwable th) {
                cVar2 = null;
            }
            if (cVar2 != null && !bi.oW(cVar2.field_dataId)) {
                boolean z;
                a aVar = (a) this.iXA.get(cVar2.field_dataId);
                if (aVar == null) {
                    aVar = new a(this, (byte) 0);
                    aVar.ewn = 1;
                    aVar.iXJ = bi.VF();
                    this.iXA.put(cVar2.field_dataId, aVar);
                } else if (bi.VF() - aVar.iXJ > 180000 && aVar.errCode != -6101) {
                    aVar.ewn = 1;
                    aVar.iXJ = bi.VF();
                    this.iXA.put(cVar2.field_dataId, aVar);
                } else if (aVar.ewn <= 3) {
                    aVar.ewn++;
                    this.iXA.put(cVar2.field_dataId, aVar);
                } else {
                    x.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                    f(cVar2);
                    z = false;
                    if (!z) {
                        this.bFh = true;
                        if (cVar2 != null) {
                            x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                            i iVar = new i();
                            iVar.dPV = this.dVu;
                            iVar.field_mediaId = cVar2.field_dataId;
                            if (cVar2.field_type == 0) {
                                iVar.ceW = true;
                                iVar.field_priority = b.dOj;
                                iVar.field_needStorage = true;
                                iVar.field_totalLen = cVar2.field_totalLen;
                                iVar.field_aesKey = cVar2.field_cdnKey;
                                iVar.field_fileId = cVar2.field_cdnUrl;
                                iVar.field_isStreamMedia = cVar2.aLa();
                                iVar.field_fullpath = cVar2.field_path;
                                if (!FileOp.cn(iVar.field_fullpath)) {
                                    x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                                }
                                if (cVar2.aLa()) {
                                    iVar.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                                } else {
                                    iVar.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                                }
                                iVar.field_force_aeskeycdn = true;
                                iVar.field_trysafecdn = false;
                                x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                                com.tencent.mm.modelcdntran.g.ND().c(iVar);
                                return;
                            }
                            iVar.ceW = false;
                            iVar.field_totalLen = cVar2.field_totalLen;
                            iVar.field_aesKey = cVar2.field_cdnKey;
                            iVar.field_fileId = cVar2.field_cdnUrl;
                            iVar.field_priority = b.dOk;
                            iVar.dPV = this.dVu;
                            iVar.field_fullpath = cVar2.field_path + ".temp";
                            iVar.field_needStorage = true;
                            iVar.field_isStreamMedia = cVar2.aLa();
                            if (cVar2.aLa()) {
                                iVar.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                            } else {
                                iVar.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                            }
                            com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
                            g(cVar2);
                        }
                    } else if (this.iXD >= 10) {
                        wx();
                    } else {
                        this.bFo.J(500, 500);
                    }
                }
                if (cVar2.field_type == 0) {
                    x.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                } else if (this.iXB.contains(cVar2.field_dataId) || com.tencent.mm.plugin.fav.a.b.Bb(cVar2.field_dataId)) {
                    x.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                } else {
                    if (!ao.isWifi(ad.getContext())) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        f(cVar2);
                        z = false;
                    } else if (cVar2.field_type == 0) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                    } else if (!this.iXE) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        this.iXD = 0;
                    } else if (this.iXD < 10) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[]{Integer.valueOf(10), Integer.valueOf(this.iXD), Integer.valueOf(aVar.ewn), Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        if (aVar.ewn == 1) {
                            this.iXD++;
                        }
                    } else {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[]{Integer.valueOf(10)});
                        z = false;
                    }
                    if (!z) {
                        this.bFh = true;
                        if (cVar2 != null) {
                            x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                            i iVar2 = new i();
                            iVar2.dPV = this.dVu;
                            iVar2.field_mediaId = cVar2.field_dataId;
                            if (cVar2.field_type == 0) {
                                iVar2.ceW = true;
                                iVar2.field_priority = b.dOj;
                                iVar2.field_needStorage = true;
                                iVar2.field_totalLen = cVar2.field_totalLen;
                                iVar2.field_aesKey = cVar2.field_cdnKey;
                                iVar2.field_fileId = cVar2.field_cdnUrl;
                                iVar2.field_isStreamMedia = cVar2.aLa();
                                iVar2.field_fullpath = cVar2.field_path;
                                if (!FileOp.cn(iVar2.field_fullpath)) {
                                    x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                                }
                                if (cVar2.aLa()) {
                                    iVar2.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                                } else {
                                    iVar2.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                                }
                                iVar2.field_force_aeskeycdn = true;
                                iVar2.field_trysafecdn = false;
                                x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar2.field_force_aeskeycdn), Boolean.valueOf(iVar2.field_trysafecdn)});
                                com.tencent.mm.modelcdntran.g.ND().c(iVar2);
                                return;
                            }
                            iVar2.ceW = false;
                            iVar2.field_totalLen = cVar2.field_totalLen;
                            iVar2.field_aesKey = cVar2.field_cdnKey;
                            iVar2.field_fileId = cVar2.field_cdnUrl;
                            iVar2.field_priority = b.dOk;
                            iVar2.dPV = this.dVu;
                            iVar2.field_fullpath = cVar2.field_path + ".temp";
                            iVar2.field_needStorage = true;
                            iVar2.field_isStreamMedia = cVar2.aLa();
                            if (cVar2.aLa()) {
                                iVar2.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                            } else {
                                iVar2.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                            }
                            com.tencent.mm.modelcdntran.g.ND().b(iVar2, -1);
                            g(cVar2);
                        }
                    } else if (this.iXD >= 10) {
                        wx();
                    } else {
                        this.bFo.J(500, 500);
                    }
                }
                z = true;
                if (!z) {
                    this.bFh = true;
                    if (cVar2 != null) {
                        x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                        i iVar22 = new i();
                        iVar22.dPV = this.dVu;
                        iVar22.field_mediaId = cVar2.field_dataId;
                        if (cVar2.field_type == 0) {
                            iVar22.ceW = true;
                            iVar22.field_priority = b.dOj;
                            iVar22.field_needStorage = true;
                            iVar22.field_totalLen = cVar2.field_totalLen;
                            iVar22.field_aesKey = cVar2.field_cdnKey;
                            iVar22.field_fileId = cVar2.field_cdnUrl;
                            iVar22.field_isStreamMedia = cVar2.aLa();
                            iVar22.field_fullpath = cVar2.field_path;
                            if (!FileOp.cn(iVar22.field_fullpath)) {
                                x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                            }
                            if (cVar2.aLa()) {
                                iVar22.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                            } else {
                                iVar22.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                            }
                            iVar22.field_force_aeskeycdn = true;
                            iVar22.field_trysafecdn = false;
                            x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar22.field_force_aeskeycdn), Boolean.valueOf(iVar22.field_trysafecdn)});
                            com.tencent.mm.modelcdntran.g.ND().c(iVar22);
                            return;
                        }
                        iVar22.ceW = false;
                        iVar22.field_totalLen = cVar2.field_totalLen;
                        iVar22.field_aesKey = cVar2.field_cdnKey;
                        iVar22.field_fileId = cVar2.field_cdnUrl;
                        iVar22.field_priority = b.dOk;
                        iVar22.dPV = this.dVu;
                        iVar22.field_fullpath = cVar2.field_path + ".temp";
                        iVar22.field_needStorage = true;
                        iVar22.field_isStreamMedia = cVar2.aLa();
                        if (cVar2.aLa()) {
                            iVar22.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_VIDEO);
                        } else {
                            iVar22.field_fileType = cB(cVar2.field_extFlag, b.MediaType_FAVORITE_FILE);
                        }
                        com.tencent.mm.modelcdntran.g.ND().b(iVar22, -1);
                        g(cVar2);
                    }
                } else if (this.iXD >= 10) {
                    wx();
                } else {
                    this.bFo.J(500, 500);
                }
            }
        }
    }

    private static void f(c cVar) {
        if (1 == cVar.field_type) {
            cVar.field_status = 2;
        } else {
            cVar.field_status = 4;
        }
        ((ae) g.n(ae.class)).getFavCdnStorage().a(cVar, new String[]{"dataId"});
        g(cVar);
    }

    public final void pauseDownload(String str) {
        if (!bi.oW(str) && this.bFf.containsKey(str)) {
            com.tencent.mm.modelcdntran.g.ND().lx(str);
            x.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[]{str});
            g(((ae) g.n(ae.class)).getFavCdnStorage().Br(str));
            a(str);
        }
    }

    public final void Bq(String str) {
        if (!bi.oW(str)) {
            com.tencent.mm.modelcdntran.g.ND().lw(str);
            x.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[]{str});
            g(((ae) g.n(ae.class)).getFavCdnStorage().Br(str));
            a(str);
        }
    }

    public final void wx() {
        this.bFd.clear();
        this.bFf.clear();
        this.bFi = false;
        this.bFh = false;
    }

    private static int cB(int i, int i2) {
        if ((i & 1) == 0) {
            return i2;
        }
        x.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[]{Integer.valueOf(i2)});
        if (b.MediaType_FAVORITE_VIDEO == i2) {
            return b.MediaType_FAVORITE_FILE;
        }
        return b.MediaType_FAVORITE_VIDEO;
    }

    static boolean cL(String str, String str2) {
        Throwable e;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[16384];
                    fileOutputStream.write("#!AMR\n".getBytes());
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    boolean z = true;
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                        z = false;
                    }
                    try {
                        fileOutputStream.close();
                        return z;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e222, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e4, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e5, "", new Object[0]);
                            }
                        }
                        throw e2222;
                    }
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22222) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22222, "", new Object[0]);
                    }
                }
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Throwable e222222) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e222222, "", new Object[0]);
                    return false;
                }
            } catch (Throwable th2) {
                e222222 = th2;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e42, "", new Object[0]);
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e52) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e52, "", new Object[0]);
                    }
                }
                throw e222222;
            }
        } catch (Exception e7) {
            e222222 = e7;
            fileOutputStream = null;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e222222, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222222, "", new Object[0]);
                }
            }
            if (fileOutputStream != null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (Throwable e22222222) {
                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22222222, "", new Object[0]);
                return false;
            }
        } catch (Throwable th3) {
            e22222222 = th3;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e422, "", new Object[0]);
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e522) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e522, "", new Object[0]);
                }
            }
            throw e22222222;
        }
    }

    static boolean Bv(String str) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                        return false;
                    }
                }
                String str2 = new String(bArr);
                x.i("MicroMsg.Fav.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                }
                return endsWith;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            e2 = e5;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                if (randomAccessFile == null) {
                    return false;
                }
                try {
                    randomAccessFile.close();
                    return false;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                    return false;
                }
            } catch (Throwable th) {
                e22 = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable e322) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e322, "", new Object[0]);
                }
            }
            throw e22;
        }
    }

    /* renamed from: Bw */
    final void a(String str) {
        this.bFh = false;
        this.bFf.remove(str);
        pauseDownload(str);
        if (this.bFj > 0) {
            OI();
            return;
        }
        x.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        wx();
    }

    static void g(c cVar) {
        if (cVar.field_type == 0) {
            com.tencent.mm.plugin.fav.a.b.a(cVar);
        } else if (cVar.field_type == 1) {
            com.tencent.mm.plugin.fav.a.b.b(cVar);
        }
    }

    public final void c(c cVar) {
        if (cVar != null) {
            this.bFd.add(cVar);
        }
    }
}
