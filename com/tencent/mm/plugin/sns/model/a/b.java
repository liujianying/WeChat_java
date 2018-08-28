package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b extends c {
    private static HashSet<String> ntf = new HashSet();
    protected ate caK = null;
    private long dnsCostTime = -1;
    private int erZ = -1;
    private String host = "";
    protected a nsL;
    protected n nsM = null;
    protected a nsN = null;
    private String nsO = "";
    private String nsP = "";
    private String nsQ = "";
    private int nsR = 0;
    protected int nsS = 0;
    private long nsT = -1;
    protected long nsU = -1;
    protected long nsV = -1;
    protected long nsW = -1;
    protected String nsX = "";
    protected PString nsY = new PString();
    protected int nsZ;
    protected long nta;
    protected long ntb;
    protected long ntc;
    private int ntd = 0;
    protected int nte = 0;
    private Map<String, List<String>> ntg;
    int nth = 0;
    private int retCode = -1;

    public abstract boolean bza();

    protected abstract int bzb();

    public abstract boolean u(InputStream inputStream);

    public b(a aVar, a aVar2) {
        super(aVar, aVar2);
        this.nsL = aVar;
        this.nsN = aVar2;
        if (aVar2 != null) {
            this.caK = aVar2.noc;
            ntf.add(aVar2.nob);
            aVar2.init();
        }
    }

    public boolean byZ() {
        return true;
    }

    public String MJ(String str) {
        return str;
    }

    public u b(u uVar) {
        return uVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    public final boolean a(av avVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (avVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || avVar.time == 0 || bi.bG((long) avVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    /* renamed from: bzc */
    public final Integer bxI() {
        g.Ek();
        if (!g.Ei().isSDCardAvailable() || this.nsN == null) {
            hR(false);
            return Integer.valueOf(2);
        }
        if (byZ()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.nsN.nnX + this.nsN.byY());
            FileOp.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.nsW = System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.nsN.mediaId + " " + this.nsN.nsG + " type " + this.nsN.nsI);
        FileOp.mL(this.nsN.getPath());
        av avVar = this.nsN.nsJ;
        String str = "";
        if (avVar == null) {
            str = "";
            avVar = av.tbu;
        } else if (avVar.equals(av.tbn)) {
            str = "album_friend";
        } else if (avVar.equals(av.tbo)) {
            str = "album_self";
        } else if (avVar.equals(av.tbp)) {
            str = "album_stranger";
        } else if (avVar.equals(av.tbq)) {
            str = "profile_friend";
        } else if (avVar.equals(av.tbr)) {
            str = "profile_stranger";
        } else if (avVar.equals(av.tbs)) {
            str = "comment";
        } else if (avVar.equals(av.tbm)) {
            str = "timeline";
        }
        if (!bi.oW(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(d.qVN), o.getString(af.bxV()), Integer.valueOf(ao.getNetTypeForStat(ad.getContext())), Integer.valueOf(ao.getStrength(ad.getContext())), str});
        this.nsN.url = MJ(this.nsN.url);
        this.dnsCostTime = bi.VF();
        long j = (long) com.tencent.mm.k.g.AT().getInt(this.nsN.nsH ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.nsN.nsH), Boolean.valueOf(this.nsN.nsG), com.tencent.mm.k.g.AT().getValue(this.nsN.nsH ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(this.nsN.url, a(avVar, this.nsN.url, j, r6));
        this.dnsCostTime = bi.bH(this.dnsCostTime);
        try {
            str = bi.oW(bVar.ip) ? InetAddress.getByName(bVar.host).getHostAddress() : bVar.ip;
        } catch (Exception e) {
            str = "-";
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.nsN.url, this.nsN.mediaId, Integer.valueOf(bVar.erZ), str, this.nsN.url, Integer.valueOf(this.nsN.nsI), Boolean.valueOf(r1), avVar.toString());
        this.nsS = 1;
        u a = a(bVar, format);
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
        Object[] objArr = new Object[5];
        objArr[0] = bVar.ip;
        objArr[1] = Boolean.valueOf(a != null);
        objArr[2] = Integer.valueOf(this.nsS);
        objArr[3] = Boolean.valueOf(bVar.esc);
        objArr[4] = bVar.esb;
        x.i(str2, str3, objArr);
        int i = 2;
        if (a != null) {
            i = c(a);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(bi.bH(currentTimeMillis)), Long.valueOf(this.nsT), this.nsN.mediaId, this.nsN.url, Integer.valueOf(this.nth));
        return Integer.valueOf(i);
    }

    private u a(com.tencent.mm.network.b.b bVar, String str) {
        String message;
        try {
            this.nsQ = bVar.ip;
            this.erZ = bVar.erZ;
            this.nsU = bi.VF();
            u a = com.tencent.mm.network.b.a(this.nsN.url, bVar);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                x.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            u b = b(a);
            this.ntg = b.getHeaderFields();
            List list = (List) this.ntg.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.nsP = (String) list.get(0);
            }
            list = (List) this.ntg.get("X-ServerIp");
            if (list != null && list.size() > 0) {
                this.nsO = (String) list.get(0);
            }
            list = (List) this.ntg.get("X-ErrNo");
            if (list != null && list.size() > 0) {
                this.nsR = bi.WU((String) list.get(0));
            }
            list = (List) this.ntg.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.nsS = bi.WU((String) list.get(0));
            }
            try {
                this.retCode = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.retCode == HardCoderJNI.sHCDBDELAY_WRITE || this.retCode == 206) {
                    M(b.getHeaderFields());
                    if (d(b)) {
                        this.nsU = bi.bH(this.nsU);
                        list = (List) this.ntg.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.nte = bi.WU((String) list.get(0));
                        }
                        x.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.nsN.url, this.nsP, this.nsO, Integer.valueOf(this.nte), Integer.valueOf(this.nsR));
                        return b;
                    }
                    h.mEJ.a(22, 62, 1, true);
                    x.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.nsN.mediaId);
                    hR(false);
                    return null;
                }
                M(b.getHeaderFields());
                if (this.nsN.nsH) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        h.mEJ.a(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        h.mEJ.a(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    h.mEJ.a(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    h.mEJ.a(22, 57, 1, true);
                }
                if (this.nsN.nsG) {
                    h.mEJ.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.nsN.mediaId + " " + this.nsN.url + " " + this.retCode);
                hR(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.retCode = 1;
                hR(false);
                message = e.getMessage();
                if (this.nsN.nsH) {
                    h.mEJ.a(22, 77, 1, true);
                } else {
                    h.mEJ.a(22, 55, 1, true);
                }
                if (this.nsN.nsG) {
                    h.mEJ.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.nsN.mediaId + " " + this.nsN.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                hR(false);
                message = e2.getMessage();
                if (this.nsN.nsG) {
                    h.mEJ.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.nsN.mediaId + " " + this.nsN.url + " msg:" + message);
                return null;
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "connect fail : " + e3.getMessage(), new Object[0]);
            this.retCode = 2;
            hR(false);
            return null;
        }
    }

    private int c(u uVar) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.ntc = bi.VF();
            InputStream inputStream3 = uVar.getInputStream();
            try {
                this.nsV = bi.VF();
                boolean u = u(inputStream3);
                inputStream3.close();
                x.i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : " + u);
                if (u) {
                    this.nsV = bi.bH(this.nsV);
                    this.nsT = bi.bH(this.nsW);
                    boolean bza = bza();
                    x.i("MicroMsg.SnsCdnDownloadBase", "processData ret : " + bza);
                    if (bza) {
                        if (uVar != null) {
                            uVar.aBv.disconnect();
                        }
                        hR(true);
                        if (this.nsN.nsG) {
                            return 3;
                        }
                        return 1;
                    }
                    this.retCode = 3;
                    hR(false);
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.aBv.disconnect();
                    return 2;
                }
                hR(false);
                if (uVar == null) {
                    return 2;
                }
                uVar.aBv.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.retCode = 4;
                    hR(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.aBv.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (uVar != null) {
                        uVar.aBv.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e322) {
                        x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e322, "", new Object[0]);
                    }
                }
                if (uVar != null) {
                    uVar.aBv.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e322 = e4;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e3222) {
                    x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3222, "", new Object[0]);
                }
            }
            if (uVar != null) {
                uVar.aBv.disconnect();
            }
            throw th;
        }
    }

    private static void M(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                x.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e) {
            }
        }
    }

    private static boolean d(u uVar) {
        try {
            List list = (List) uVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (bi.oW(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long MK(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return bi.getLong(split[3], 0) + (((16777216 * bi.getLong(split[0], 0)) + (65536 * bi.getLong(split[1], 0))) + (256 * bi.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void hR(boolean z) {
        long j;
        String str;
        if (this.nsN == null || !this.nsN.nsH) {
            if (z) {
                h.mEJ.a(22, 53, this.nsT, true);
            } else {
                h.mEJ.a(22, 52, 1, true);
            }
            h.mEJ.a(22, 51, 1, true);
        } else {
            if (z) {
                h.mEJ.a(22, 75, this.nsT, true);
            } else {
                h.mEJ.a(22, 74, 1, true);
            }
            h.mEJ.a(22, 73, 1, true);
        }
        if (!(this.nsN == null || !this.nsN.nsG || z || i.b(this.nsM))) {
            h.mEJ.a(150, 66, 1, true);
        }
        this.ntd = this.nth;
        int i = ao.isWifi(ad.getContext()) ? 1 : 0;
        int strength = ao.getStrength(ad.getContext());
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.erZ);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.nsU);
        objArr[5] = Long.valueOf(this.nsV);
        objArr[6] = Long.valueOf(this.nsT);
        objArr[7] = this.nsO;
        objArr[8] = this.nsQ;
        objArr[9] = this.nsP;
        objArr[10] = this.nsN == null ? "" : this.nsN.url;
        x.v(str2, str3, objArr);
        int netType = ao.getNetType(ad.getContext());
        int i2 = 0;
        if (this.nsN != null) {
            i2 = this.nsN.nsI == 4 ? 1 : 0;
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.ntd), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.nsR));
        h hVar = h.mEJ;
        Object[] objArr2 = new Object[19];
        if (this.nsN == null) {
            str2 = "";
        } else {
            str2 = this.nsN.url;
        }
        objArr2[0] = str2;
        objArr2[1] = Long.valueOf(MK(this.nsQ));
        if (z) {
            j = this.nsT;
        } else {
            j = 0;
        }
        objArr2[2] = Long.valueOf(j);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.nsU);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.nsV);
        objArr2[10] = Long.valueOf(MK(this.nsP));
        objArr2[11] = Long.valueOf(MK(this.nsO));
        objArr2[12] = Integer.valueOf(this.erZ);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.ntd);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.nsR);
        hVar.h(10736, objArr2);
        boolean isConnected = ao.isConnected(ad.getContext());
        x.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.nsX);
        if (!(z || bi.oW(this.nsX) || !isConnected)) {
            com.tencent.mm.network.b.reportFailIp(this.nsX);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.nsY.value);
        int bzb = bzb();
        str2 = "";
        switch (bzb) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ(str);
        i = 0;
        if (fJ.isValid()) {
            i = bi.getInt((String) fJ.ckq().get("needUploadData"), 1);
            str2 = fJ.field_expId;
        }
        if (i != 0) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.r("20ImgSize", this.nth + ",");
            dVar.r("21NetType", (ao.isWifi(ad.getContext()) ? 1 : 0) + ",");
            dVar.r("22DelayTime", (this.nsT - this.nsU) + ",");
            dVar.r("23RetCode", this.retCode + ",");
            dVar.r("24DnsCostTime", this.dnsCostTime + ",");
            dVar.r("25ConnectCostTime", this.nsU + ",");
            dVar.r("26SendCostTime", ",");
            dVar.r("27WaitResponseCostTime", this.ntb + ",");
            dVar.r("28ReceiveCostTime", this.nsV + ",");
            dVar.r("29ClientAddrIP", this.nsP + ",");
            dVar.r("30ServerAddrIP", this.nsQ + ",");
            dVar.r("31dnstype", this.erZ + ",");
            dVar.r("32signal", ao.getStrength(ad.getContext()) + ",");
            dVar.r("33host", this.host + ",");
            dVar.r("34MediaType", bzb + ",");
            dVar.r("35X_Errno", this.nsR + ",");
            dVar.r("36MaxPackageSize", this.nsZ + ",");
            dVar.r("37MaxPackageTimeStamp", this.nta + ",");
            dVar.r("38PackageRecordList", this.nsY.value + ",");
            dVar.r("39ExpLayerId", str + ",");
            dVar.r("40ExpId", str2 + ",");
            dVar.r("41FeedId", ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.wF());
            h.mEJ.h(13480, dVar);
            if (this.retCode != HardCoderJNI.sHCDBDELAY_WRITE) {
                h.mEJ.h(14071, dVar);
            }
        }
    }

    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.nsN != null) {
            x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.nsN.url, this.nsN.mediaId, Integer.valueOf(this.ntd), Integer.valueOf(ntf.size()));
            ntf.remove(this.nsN.nob);
            if (this.nsN.nsG && num.intValue() != 2) {
                com.tencent.mm.plugin.sns.model.av.Mv(this.nsN.mediaId);
                bzd();
            } else if (!this.nsN.nsG && this.nsN.nsI == 4) {
                af.byl().ex(this.nsN.mediaId, this.nsN.getPath() + i.j(this.caK));
            }
            this.nsL.a(num.intValue(), this.caK, this.nsN.nsI, this.nsN.nsG, this.nsN.nob, this.ntd);
        }
    }

    public final void bzd() {
        int i = 0;
        if (!af.bxX()) {
            System.currentTimeMillis();
            if (this.nsN.nkK.nkQ == 4) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.nsM = com.tencent.mm.plugin.sns.lucky.a.a.ev(this.nsN.getPath() + i.e(this.caK), this.nsN.getPath() + i.g(this.caK));
                af.byl().a(this.nsN.mediaId, this.nsM, this.nsN.nkK.nkQ);
            } else if (this.nsN.nkK.nkQ == 5) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.nsM = com.tencent.mm.plugin.sns.lucky.a.a.ev(this.nsN.getPath() + i.e(this.caK), this.nsN.getPath() + i.h(this.caK));
                af.byl().a(this.nsN.mediaId, this.nsM, this.nsN.nkK.nkQ);
            } else if (this.nsN.nkK.list.size() <= 1) {
                af.byl().a(this.nsN.mediaId, this.nsM, this.nsN.nkK.nkQ);
            } else {
                af.byl().a(this.nsN.mediaId, this.nsM, 0);
                List linkedList = new LinkedList();
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nsN.nkK.list.size() || i2 >= 4) {
                        this.nsM = n.m(i.i(linkedList, af.byw()));
                        x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.nsN.nkK.kJG + " " + this.nsM);
                        af.byl().a(this.nsN.nkK.kJG, this.nsM, this.nsN.nkK.nkQ);
                    } else {
                        ate ate = (ate) this.nsN.nkK.list.get(i2);
                        n Ma = af.byl().Ma(ate.ksA);
                        if (i.b(Ma)) {
                            linkedList.add(Ma);
                            x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + Ma + " " + ate.ksA);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
                this.nsM = n.m(i.i(linkedList, af.byw()));
                x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.nsN.nkK.kJG + " " + this.nsM);
                af.byl().a(this.nsN.nkK.kJG, this.nsM, this.nsN.nkK.nkQ);
            }
            String str = null;
            if (this.nsN.nkK.nkQ == 0) {
                str = "0-" + this.nsN.nkK.kJG;
            } else if (this.nsN.nkK.nkQ == 1) {
                str = "1-" + this.nsN.nkK.kJG;
            } else if (this.nsN.nkK.nkQ == 4) {
                str = "4-" + this.nsN.nkK.kJG;
            } else if (this.nsN.nkK.nkQ == 5) {
                str = "5-" + this.nsN.nkK.kJG;
            }
            af.byl().LZ(str);
        }
    }

    public final ag bxH() {
        return af.bxZ();
    }
}
