package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class c extends k<String, Integer, Integer> {
    private static HashSet<String> ntf = new HashSet();
    protected ate caK = null;
    private long dnsCostTime = -1;
    private int erZ = -1;
    private String host = "";
    protected a nsL;
    protected n nsM = null;
    protected a nsN = null;
    int nth = 0;

    public interface a {
        void a(int i, ate ate, int i2, boolean z, String str, int i3);
    }

    public abstract boolean bza();

    protected abstract int bzb();

    public static boolean ML(String str) {
        if (ntf.contains(i.aF(1, str)) || ntf.contains(i.aF(5, str))) {
            return true;
        }
        return false;
    }

    public c(a aVar, a aVar2) {
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

    protected final void b(keep_SceneResult keep_sceneresult) {
        String str;
        int i;
        int bzb = bzb();
        String str2 = "";
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
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ(str);
        if (fJ.isValid()) {
            i = bi.getInt((String) fJ.ckq().get("needUploadData"), 1);
            str2 = fJ.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            int i2;
            if (this.nsN.nsI == 8) {
                i = 1;
            } else if (this.nsN.nsI == 6 || this.nsN.nsI == 4) {
                i = 2;
            } else if (this.nsN.nsI == 5) {
                i = 4;
            } else if (this.nsN.nsI == 2 || this.nsN.nsI == 1 || this.nsN.nsI == 3) {
                i = 0;
            } else {
                i = 5;
            }
            d dVar = new d();
            dVar.r("20ImgSize", keep_sceneresult.field_fileLength + ",");
            String str3 = "21NetType";
            StringBuilder stringBuilder = new StringBuilder();
            if (ao.isWifi(ad.getContext())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            dVar.r(str3, stringBuilder.append(i2).append(",").toString());
            dVar.r("22DelayTime", keep_sceneresult.field_delayTime + ",");
            dVar.r("23RetCode", keep_sceneresult.field_retCode + ",");
            dVar.r("24DnsCostTime", keep_sceneresult.field_dnsCostTime + ",");
            dVar.r("25ConnectCostTime", keep_sceneresult.field_connectCostTime + ",");
            dVar.r("26SendCostTime", ",");
            dVar.r("27WaitResponseCostTime", keep_sceneresult.field_waitResponseCostTime + ",");
            dVar.r("28ReceiveCostTime", keep_sceneresult.field_receiveCostTime + ",");
            dVar.r("29ClientAddrIP(uint)", keep_sceneresult.field_clientHostIP + ",");
            dVar.r("30ServerAddrIP(uint)", keep_sceneresult.field_serverHostIP + ",");
            dVar.r("31dnstype", this.erZ + ",");
            dVar.r("32signal(int)", ao.getStrength(ad.getContext()) + ",");
            dVar.r("33host(string)", this.host + ",");
            dVar.r("34MediaType", bzb + ",");
            dVar.r("35X_Errno(string)", keep_sceneresult.field_xErrorNo + ",");
            dVar.r("36MaxPackageSize", ",");
            dVar.r("37MaxPackageTimeStamp", ",");
            dVar.r("38PackageRecordList", ",");
            dVar.r("39ExpLayerId", str + ",");
            dVar.r("40ExpId", str2 + ",");
            dVar.r("41FeedId", ",");
            dVar.r("42BizType", i + ",");
            dVar.r("43CSeqCheck(uint)", keep_sceneresult.field_cSeqCheck + ",");
            dVar.r("44isPrivate(uint)", (keep_sceneresult.field_usePrivateProtocol ? 1 : 0) + ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.wF());
            h.mEJ.h(13480, new Object[]{dVar});
            if (keep_sceneresult.field_retCode != 200 && keep_sceneresult.field_retCode != 0) {
                h.mEJ.h(14071, new Object[]{dVar});
            }
        }
    }

    public boolean a(av avVar, String str, long j, String str2) {
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
            x.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    /* renamed from: bzc */
    public Integer bxI() {
        g.Ek();
        if (!g.Ei().isSDCardAvailable() || this.nsN == null) {
            return Integer.valueOf(2);
        }
        int i;
        if (byZ()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[]{this.nsN.nnX + this.nsN.byY()});
            FileOp.deleteFile(r0);
        }
        System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.nsN.mediaId + " " + this.nsN.nsG + " type " + this.nsN.nsI);
        FileOp.mL(this.nsN.getPath());
        av avVar = this.nsN.nsJ;
        String str = "";
        if (avVar == null) {
            str = "";
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
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.qVN), o.getString(af.bxV()), Integer.valueOf(ao.getNetTypeForStat(ad.getContext())), Integer.valueOf(ao.getStrength(ad.getContext())), str});
        this.nsN.url = MJ(this.nsN.url);
        this.dnsCostTime = bi.VF();
        long j = (long) com.tencent.mm.k.g.AT().getInt(this.nsN.nsH ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[]{Boolean.valueOf(this.nsN.nsH), Boolean.valueOf(this.nsN.nsG), com.tencent.mm.k.g.AT().getValue(this.nsN.nsH ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j)});
        if (j <= 0) {
            j = 259200;
        }
        boolean a = a(avVar, this.nsN.url, j, r6);
        this.dnsCostTime = bi.bH(this.dnsCostTime);
        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
        if (a(hVar, a, format)) {
            hVar.dPV = new com.tencent.mm.modelcdntran.i.a() {
                public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                    int i2 = 2;
                    if (keep_sceneresult != null) {
                        if (c.this.nsN != null) {
                            if (keep_sceneresult.field_retCode != 0) {
                                b.reportFailIp(keep_sceneresult.field_serverIP);
                            } else {
                                c.this.nth = keep_sceneresult.field_fileLength;
                                if (c.this.bza()) {
                                    i2 = c.this.nsN.nsG ? 3 : 1;
                                }
                            }
                            c.this.b(keep_sceneresult);
                            af.aRu().post(new 1(this, i2, keep_sceneresult));
                        }
                    } else if (keep_progressinfo != null) {
                        float f = ((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength);
                        if (c.this.nsN.nsK < f) {
                            c.this.nsN.nsK = f;
                            x.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[]{Integer.valueOf(c.this.nsN.nsI), str, Float.valueOf(f), c.this.nsN.url});
                        }
                    }
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] i(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (com.tencent.mm.modelcdntran.g.ND().b(hVar, -1)) {
                x.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i = 1;
                return Integer.valueOf(i);
            }
            x.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i = 2;
        return Integer.valueOf(i);
    }

    private boolean a(com.tencent.mm.modelcdntran.h hVar, boolean z, String str) {
        try {
            this.host = new URL(this.nsN.url).getHost();
            List arrayList = new ArrayList();
            this.erZ = b.a(this.host, false, arrayList);
            List arrayList2 = new ArrayList();
            int a = b.a(this.host, true, arrayList2);
            Random random = new Random();
            random.setSeed(bi.VF());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            hVar.field_mediaId = this.nsN.mediaId + "_" + this.nsN.nsI;
            hVar.url = this.nsN.url;
            hVar.host = this.host;
            hVar.referer = str;
            hVar.dPP = this.nsN.getPath() + this.nsN.byY();
            hVar.dPQ = ck(arrayList);
            hVar.dPR = ck(arrayList2);
            hVar.dPS = this.erZ;
            hVar.dPT = a;
            hVar.isColdSnsData = z;
            hVar.signalQuality = ao.getStrength(ad.getContext());
            hVar.snsScene = this.nsN.nsJ.tag;
            if (this.nsN.noc != null) {
                hVar.snsCipherKey = this.nsN.nsG ? this.nsN.noc.rVY : this.nsN.noc.rVV;
            }
            if (this.nsN.nsI == 8) {
                hVar.csS = 3;
                hVar.dPU = s$l.AppCompatTheme_seekBarStyle;
                hVar.fileType = 20204;
            } else if (this.nsN.nsI == 6 || this.nsN.nsI == 4) {
                hVar.csS = 3;
                hVar.dPU = s$l.AppCompatTheme_radioButtonStyle;
                hVar.fileType = 20210;
            } else if (this.nsN.nsI == 5) {
                hVar.csS = 3;
                hVar.dPU = 150;
                hVar.fileType = 20250;
            } else if (this.nsN.nsI == 2 || this.nsN.nsI == 1 || this.nsN.nsI == 3) {
                hVar.csS = 3;
                hVar.dPU = 100;
                hVar.fileType = 20201;
            }
            x.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d:%s", new Object[]{Integer.valueOf(this.nsN.nsI), hVar});
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            x.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:" + e);
            return false;
        }
    }

    private static String[] ck(List<String> list) {
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            strArr[i2] = (String) list.get(i2);
            i = i2 + 1;
        }
    }

    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
    }

    public void bzd() {
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
            } else if (this.nsN.nkK.nkQ == 3) {
                str = i.aE(3, this.nsN.nkK.kJG);
            }
            af.byl().LZ(str);
        }
    }

    public ag bxH() {
        return af.bxZ();
    }
}
