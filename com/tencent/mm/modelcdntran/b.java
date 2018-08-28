package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic$C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic$C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.ICallback;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements ICallback {
    public static int MediaType_FAVORITE_FILE = 10001;
    public static int MediaType_FAVORITE_VIDEO = 10002;
    public static int MediaType_FILE = 5;
    public static int MediaType_FRIENDS = 20201;
    public static int MediaType_FULLSIZEIMAGE = 1;
    public static int MediaType_IMAGE = 2;
    public static int MediaType_THUMBIMAGE = 3;
    public static int MediaType_TinyVideo = 6;
    public static int MediaType_VIDEO = 4;
    public static int dOA = 30005;
    public static int dOB = 30006;
    public static int dOC = 100;
    public static int dOD = 101;
    public static int dOE = 102;
    public static int dOF = 103;
    public static int dOG = WXMediaMessage.THUMB_LENGTH_LIMIT;
    public static int dOH = 7340033;
    public static int dOj = 1;
    public static int dOk = 2;
    public static int dOl = 3;
    public static int dOm = 7;
    public static int dOn = 10;
    public static int dOo = 10011;
    public static int dOp = 20202;
    public static int dOq = 20301;
    public static int dOr = 20302;
    public static int dOs = 20304;
    public static int dOt = 20303;
    public static int dOu = 20321;
    public static int dOv = 20322;
    public static int dOw = 30001;
    public static int dOx = 30002;
    public static int dOy = 30003;
    public static int dOz = 30004;
    private kg dOI = null;
    b dOJ = null;
    private int dOK = 0;
    private int dOL = 0;
    private String dOM = "";
    private al dON = null;
    public a dOO;

    class c {
        public int field_AckSlice = 8192;
        public String field_ApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
        public int field_C2COverloadDelaySeconds = 10;
        public int field_EnableCDNVerifyConnect = 1;
        public int field_EnableCDNVideoRedirectOC = 1;
        public int field_EnableSafeCDN = 0;
        public int field_EnableSnsImageDownload = 0;
        public int field_EnableSnsStreamDownload = 0;
        public int field_EnableStreamUploadVideo = 1;
        public int field_Ptl = 35;
        public int field_SNSOverloadDelaySeconds = 60;
        public int field_UseDynamicETL = 0;
        public int field_UseStreamCDN = 1;
        public int field_WifiEtl = 90;
        public int field_noWifiEtl = 70;
        public boolean field_onlyrecvPtl = false;
        public boolean field_onlysendETL = false;

        c() {
        }

        public final String toString() {
            return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d, snsimage:%d, videohosts:\n%s", new Object[]{Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload), Integer.valueOf(this.field_EnableSnsImageDownload), this.field_ApprovedVideoHosts});
        }
    }

    public b(String str, b bVar) {
        if (ad.cic()) {
            this.dON = new al(g.Em().lnJ.getLooper(), new 1(this), true);
        }
        this.dOJ = bVar;
        CdnLogic.setCallBack(this);
        CdnLogic.onCreate(str);
        CdnLogic.setRSAPublicKeyParams("1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001");
        CdnLogic.setToUserCiper("cdnwx2013usrname");
        x.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[]{Integer.valueOf(hashCode()), str, bi.cjd()});
    }

    public static int keep_callFromJni(int i, int i2, byte[] bArr) {
        if (i == dOC) {
            d.b(bArr, "MicroMsg.CdnEngine", i2);
        }
        return 0;
    }

    public static C2CDownloadRequest a(i iVar) {
        boolean z = true;
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileid = iVar.field_fileId;
        c2CDownloadRequest.aeskey = iVar.field_aesKey;
        c2CDownloadRequest.fileType = iVar.field_fileType;
        c2CDownloadRequest.fileKey = iVar.field_mediaId;
        c2CDownloadRequest.fileSize = iVar.field_totalLen;
        c2CDownloadRequest.savePath = iVar.field_fullpath;
        c2CDownloadRequest.isStorageMode = iVar.field_needStorage;
        c2CDownloadRequest.isSmallVideo = iVar.field_smallVideoFlag == 1;
        if (iVar.field_largesvideo <= 0) {
            z = false;
        }
        c2CDownloadRequest.isLargeSVideo = z;
        c2CDownloadRequest.limitRate = iVar.field_limitrate;
        c2CDownloadRequest.isAutoStart = iVar.field_autostart;
        c2CDownloadRequest.chatType = iVar.field_chattype;
        c2CDownloadRequest.isSilentTask = iVar.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = iVar.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = iVar.field_isColdSnsData;
        c2CDownloadRequest.signalQuality = iVar.field_signalQuality;
        c2CDownloadRequest.snsScene = iVar.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = iVar.field_requestVideoFormat;
        c2CDownloadRequest.videofileid = iVar.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = iVar.field_svr_signature;
        if (bi.oW(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = iVar.field_fake_bigfile_signature;
        if (bi.oW(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = iVar.field_fake_bigfile_signature_aeskey;
        if (bi.oW(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = iVar.field_wxmsgparam;
        if (bi.oW(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = 0;
        c2CDownloadRequest.transforTimeoutSeconds = 0;
        c2CDownloadRequest.initialDownloadLength = iVar.initialDownloadLength;
        c2CDownloadRequest.initialDownloadOffset = iVar.initialDownloadOffset;
        c2CDownloadRequest.preloadRatio = iVar.field_preloadRatio;
        return c2CDownloadRequest;
    }

    public static int b(i iVar) {
        boolean z = true;
        CdnLogic$C2CUploadRequest cdnLogic$C2CUploadRequest = new CdnLogic$C2CUploadRequest();
        cdnLogic$C2CUploadRequest.fileKey = iVar.field_mediaId;
        cdnLogic$C2CUploadRequest.filePath = iVar.field_fullpath;
        cdnLogic$C2CUploadRequest.thumbfilePath = iVar.field_thumbpath;
        cdnLogic$C2CUploadRequest.fileSize = iVar.field_totalLen;
        cdnLogic$C2CUploadRequest.fileType = iVar.field_fileType;
        cdnLogic$C2CUploadRequest.forwardAeskey = iVar.field_aesKey;
        cdnLogic$C2CUploadRequest.forwardFileid = iVar.field_fileId;
        cdnLogic$C2CUploadRequest.midfileSize = iVar.field_midFileLength;
        cdnLogic$C2CUploadRequest.queueTimeoutSeconds = 0;
        cdnLogic$C2CUploadRequest.transforTimeoutSeconds = 0;
        cdnLogic$C2CUploadRequest.toUser = iVar.field_talker;
        cdnLogic$C2CUploadRequest.sendmsgFromCDN = iVar.field_sendmsg_viacdn;
        cdnLogic$C2CUploadRequest.needCompressImage = iVar.field_needCompressImage;
        cdnLogic$C2CUploadRequest.chatType = iVar.field_chattype;
        cdnLogic$C2CUploadRequest.apptype = iVar.field_appType;
        cdnLogic$C2CUploadRequest.bizscene = iVar.field_bzScene;
        cdnLogic$C2CUploadRequest.checkExistOnly = iVar.field_onlycheckexist;
        cdnLogic$C2CUploadRequest.isSmallVideo = iVar.field_smallVideoFlag == 1;
        cdnLogic$C2CUploadRequest.isLargeSVideo = iVar.field_largesvideo;
        cdnLogic$C2CUploadRequest.videoSource = iVar.field_videosource;
        if (iVar.field_advideoflag != 1) {
            z = false;
        }
        cdnLogic$C2CUploadRequest.isSnsAdVideo = z;
        cdnLogic$C2CUploadRequest.isStorageMode = iVar.field_needStorage;
        cdnLogic$C2CUploadRequest.isStreamMedia = iVar.field_isStreamMedia;
        cdnLogic$C2CUploadRequest.enableHitCheck = iVar.field_enable_hitcheck;
        cdnLogic$C2CUploadRequest.forceNoSafeCdn = iVar.field_force_aeskeycdn;
        cdnLogic$C2CUploadRequest.trySafeCdn = iVar.field_trysafecdn;
        cdnLogic$C2CUploadRequest.midimgPath = iVar.field_midimgpath;
        cdnLogic$C2CUploadRequest.bigfileSignature = iVar.field_svr_signature;
        if (bi.oW(cdnLogic$C2CUploadRequest.bigfileSignature)) {
            cdnLogic$C2CUploadRequest.bigfileSignature = "";
        }
        cdnLogic$C2CUploadRequest.fakeBigfileSignature = iVar.field_fake_bigfile_signature;
        if (bi.oW(cdnLogic$C2CUploadRequest.fakeBigfileSignature)) {
            cdnLogic$C2CUploadRequest.fakeBigfileSignature = "";
        }
        cdnLogic$C2CUploadRequest.fakeBigfileSignatureAeskey = iVar.field_fake_bigfile_signature_aeskey;
        if (bi.oW(cdnLogic$C2CUploadRequest.fakeBigfileSignatureAeskey)) {
            cdnLogic$C2CUploadRequest.fakeBigfileSignatureAeskey = "";
        }
        return CdnLogic.startC2CUpload(cdnLogic$C2CUploadRequest);
    }

    public static int lo(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int lp(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static String lq(String str) {
        return CdnLogic.getFileMD5(str);
    }

    public static String Nw() {
        return CdnLogic.createAeskey();
    }

    public static int lr(String str) {
        return CdnLogic.getFileCrc32(str);
    }

    public static String ls(String str) {
        return CdnLogic.getMP4IdentifyMD5(str);
    }

    public static int a(String str, String str2, String str3, int i, String str4, String str5) {
        x.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", new Object[]{str, str3});
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.aeskey = str4;
        c2CDownloadRequest.customHttpHeader = "authkey: " + str5 + "\r\n";
        c2CDownloadRequest.fileType = i;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, 0);
    }

    public static int a(String str, String str2, String str3, int i, int i2, int i3, String[] strArr, boolean z) {
        int i4 = 0;
        String str4 = "MicroMsg.CdnTransportEngine";
        String str5 = "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str3;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        if (strArr != null) {
            i4 = strArr.length;
        }
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = Boolean.valueOf(z);
        x.i(str4, str5, objArr);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.queueTimeoutSeconds = i2;
        c2CDownloadRequest.transforTimeoutSeconds = i3;
        c2CDownloadRequest.ocIpList = strArr;
        if (!z) {
            c2CDownloadRequest.customHttpHeader = "Accept-Encoding:  ";
        }
        c2CDownloadRequest.fileType = i;
        if (dOw == c2CDownloadRequest.fileType) {
            return CdnLogic.startHttpsDownload(c2CDownloadRequest);
        }
        return CdnLogic.startURLDownload(c2CDownloadRequest);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, boolean z, String str5, String str6, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20202;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i, int i2, boolean z, String str5, String str6, String str7, int i3, int i4, int i5) {
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str4)) {
            x.e("MicroMsg.CdnTransportEngine", "invalid param.");
            return -1;
        }
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.ocIpList = strArr != null ? (String[]) strArr.clone() : null;
        c2CDownloadRequest.ocIpListSource = i;
        c2CDownloadRequest.dcIpList = strArr2 != null ? (String[]) strArr2.clone() : null;
        c2CDownloadRequest.dcIpListSource = i2;
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.snsCipherKey = str7;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = i3;
        c2CDownloadRequest.marscdnAppType = i4;
        c2CDownloadRequest.fileType = i5;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, 0);
    }

    public static int lt(String str) {
        x.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i, int i2, boolean z2, boolean z3, String[] strArr) {
        x.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:" + str);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.bakup_url = str4;
        c2CDownloadRequest.savePath = str2;
        c2CDownloadRequest.queueTimeoutSeconds = i;
        c2CDownloadRequest.transforTimeoutSeconds = i2;
        c2CDownloadRequest.ocIpList = strArr;
        c2CDownloadRequest.is_resume_task = z2;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getKey());
                c2CDownloadRequest.serialized_verify_headers += ":";
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getValue());
                c2CDownloadRequest.serialized_verify_headers += ";";
            }
        }
        c2CDownloadRequest.allow_mobile_net_download = z;
        c2CDownloadRequest.wifiAutoStart = z3;
        return CdnLogic.startHttpMultiSocketDownloadTask(c2CDownloadRequest);
    }

    public static int lu(String str) {
        x.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(i iVar, int i) {
        return CdnLogic.startVideoStreamingDownload(a(iVar), i);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 90;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.preloadRatio = i2;
        c2CDownloadRequest.concurrentCount = i3;
        c2CDownloadRequest.maxHttpRedirectCount = 100;
        return CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, keep_SceneResult keep_sceneresult) {
        CdnLogic$C2CDownloadResult cdnLogic$C2CDownloadResult = new CdnLogic$C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, cdnLogic$C2CDownloadResult);
        a(cdnLogic$C2CDownloadResult, keep_sceneresult);
        return cancelDownloadTaskWithResult;
    }

    public static int g(String str, int i, int i2) {
        return CdnLogic.requestVideoData(str, i, i2, 0);
    }

    public static boolean isVideoDataAvailable(String str, int i, int i2) {
        return CdnLogic.isVideoDataAvailable(str, i, i2);
    }

    public final boolean Nx() {
        return this.dOI == null;
    }

    private static CdnInfo a(kg kgVar) {
        CdnInfo cdnInfo = new CdnInfo();
        if (kgVar == null) {
            return cdnInfo;
        }
        int i;
        int i2;
        cdnInfo.ver = kgVar.rlX;
        cdnInfo.uin = kgVar.iwE;
        cdnInfo.frontid = kgVar.rlZ;
        cdnInfo.zoneid = kgVar.rme;
        cdnInfo.nettype = d.bK(ad.getContext());
        cdnInfo.authkey = ab.a(kgVar.rmd);
        if (kgVar.rma >= 2) {
            cdnInfo.frontip1 = ab.a((bhz) kgVar.rmb.get(0));
            cdnInfo.frontip2 = ab.a((bhz) kgVar.rmb.get(1));
            x.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[]{cdnInfo.frontip1, cdnInfo.frontip2});
        }
        if (kgVar.rmf >= 2) {
            cdnInfo.zoneip1 = ab.a((bhz) kgVar.rmg.get(0));
            cdnInfo.zoneip2 = ab.a((bhz) kgVar.rmg.get(1));
            x.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[]{cdnInfo.frontip1, cdnInfo.frontip2});
        }
        if (kgVar.rmj > 0) {
            i = ((kh) kgVar.rmh.get(0)).rml;
            cdnInfo.frontports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.frontports[i2] = ((Integer) ((kh) kgVar.rmh.get(0)).rmm.get(i2)).intValue();
            }
        }
        if (kgVar.rmk > 0) {
            i = ((kh) kgVar.rmi.get(0)).rml;
            cdnInfo.zoneports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.zoneports[i2] = ((Integer) ((kh) kgVar.rmi.get(0)).rmm.get(i2)).intValue();
            }
        }
        return cdnInfo;
    }

    public final boolean a(kg kgVar, kg kgVar2, kg kgVar3, byte[] bArr, byte[] bArr2, kg kgVar4) {
        x.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[]{this.dOI, kgVar, kgVar4, bi.cjd()});
        if (kgVar == null && bArr == null) {
            return false;
        }
        this.dOI = kgVar;
        try {
            CdnLogic.setLegacyCdnInfo(a(kgVar), a(kgVar2), a(kgVar3), a(kgVar4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            if (af.exF && af.exw != null && af.exw.length() >= 7) {
                x.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", new Object[]{af.exw});
                CdnLogic.setDebugIP(af.exw);
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e.getLocalizedMessage());
            return false;
        }
    }

    public static void a(c cVar) {
        x.i("MicroMsg.CdnTransportEngine", "set WXConfig:" + cVar);
        Config config = new Config();
        config.AckSlice = cVar.field_AckSlice;
        config.UseDynamicETL = cVar.field_UseDynamicETL;
        config.UseStreamCDN = cVar.field_UseStreamCDN;
        config.C2COverloadDelaySeconds = cVar.field_C2COverloadDelaySeconds;
        config.SNSOverloadDelaySeconds = cVar.field_SNSOverloadDelaySeconds;
        config.EnableCDNVerifyConnect = cVar.field_EnableCDNVerifyConnect;
        config.EnableCDNVideoRedirectOC = cVar.field_EnableCDNVideoRedirectOC;
        config.EnableStreamUploadVideo = cVar.field_EnableStreamUploadVideo;
        config.EnableSafeCDN = cVar.field_EnableSafeCDN;
        config.EnableSnsStreamDownload = cVar.field_EnableSnsStreamDownload;
        config.EnableSnsImageDownload = cVar.field_EnableSnsImageDownload;
        if (!bi.oW(cVar.field_ApprovedVideoHosts)) {
            config.ApprovedVideoHosts = cVar.field_ApprovedVideoHosts;
        }
        config.WifiEtl = cVar.field_WifiEtl;
        config.MobileEtl = cVar.field_noWifiEtl;
        config.onlyrecvPtl = cVar.field_onlyrecvPtl;
        config.onlysendETL = cVar.field_onlysendETL;
        config.Ptl = cVar.field_Ptl;
        CdnLogic.setConfig(config);
    }

    public final int keep_onUploadProgress(String str, keep_ProgressInfo keep_progressinfo) {
        keep_progressinfo.field_isUploadTask = true;
        if (this.dOJ != null) {
            x.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[]{str, Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength)});
            this.dOJ.a(str, keep_progressinfo, null);
        }
        return 0;
    }

    public final int keep_onUploadError(String str, keep_SceneResult keep_sceneresult) {
        if (this.dOJ != null) {
            a(keep_sceneresult);
            this.dOJ.a(str, null, keep_sceneresult);
        }
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, keep_SceneResult keep_sceneresult) {
        if (this.dOJ != null) {
            x.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[]{str});
            a(keep_sceneresult);
            this.dOJ.a(str, null, keep_sceneresult);
        }
        return 0;
    }

    public final int keep_onDownloadProgress(String str, keep_ProgressInfo keep_progressinfo) {
        int a;
        keep_progressinfo.field_isUploadTask = false;
        if (this.dOO != null) {
            a = this.dOO.a(str, keep_progressinfo, null);
        } else {
            a = 0;
        }
        if (a == 0 && this.dOJ != null) {
            x.v("MicroMsg.CdnTransportEngine", "klem keep_onDownloadProgress mediaId:%s", new Object[]{str});
            this.dOJ.a(str, keep_progressinfo, null);
        }
        return 0;
    }

    public final int keep_onDownloadError(String str, keep_SceneResult keep_sceneresult) {
        int a;
        if (this.dOO != null) {
            a = this.dOO.a(str, null, keep_sceneresult);
        } else {
            a = 0;
        }
        if (a == 0 && this.dOJ != null) {
            a(keep_sceneresult);
            this.dOJ.a(str, null, keep_sceneresult);
        }
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, keep_SceneResult keep_sceneresult) {
        int a;
        if (this.dOO != null) {
            a = this.dOO.a(str, null, keep_sceneresult);
        } else {
            a = 0;
        }
        if (a == 0 && this.dOJ != null) {
            a(keep_sceneresult);
            this.dOJ.a(str, null, keep_sceneresult);
        }
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (this.dOJ != null) {
            this.dOJ.a(str, byteArrayOutputStream);
        }
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        if (this.dOJ != null) {
            return this.dOJ.i(str, bArr);
        }
        return null;
    }

    public final void keep_onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.dOO != null) {
            this.dOO.onMoovReady(str, i, i2);
        }
    }

    public final void keep_onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.dOO != null) {
            this.dOO.onDataAvailable(str, i, i2);
        }
    }

    public final void keep_onDownloadToEnd(String str, int i, int i2) {
        x.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.dOO != null) {
            this.dOO.onDownloadToEnd(str, i, i2);
        }
    }

    private static void a(keep_SceneResult keep_sceneresult) {
        if (keep_sceneresult != null && !bi.oW(keep_sceneresult.field_transInfo)) {
            int indexOf = keep_sceneresult.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                keep_sceneresult.report_Part2 = keep_sceneresult.field_transInfo.substring(indexOf + 2);
                keep_sceneresult.field_transInfo = keep_sceneresult.field_transInfo.substring(0, indexOf);
            }
            x.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[]{keep_sceneresult.field_transInfo, keep_sceneresult.report_Part2});
        }
    }

    public final void keep_cdnSendAndRecvData(String str, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            this.dOK += i;
            this.dOL += i2;
            if (!bi.oW(str)) {
                this.dOM = str;
            }
            if (this.dOK + this.dOL > 51200 && this.dON != null) {
                this.dON.J(500, 500);
            }
        }
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i) {
        g.Eg();
        if (a.Dw()) {
            g.NA().hB(i + 1000);
        }
    }

    public final void onProgressChanged(String str, int i, int i2, boolean z) {
        keep_ProgressInfo keep_progressinfo = new keep_ProgressInfo();
        keep_progressinfo.field_finishedLength = i;
        keep_progressinfo.field_toltalLength = i2;
        keep_progressinfo.field_status = 0;
        keep_progressinfo.field_mtlnotify = z;
        keep_onDownloadProgress(str, keep_progressinfo);
        keep_onUploadProgress(str, keep_progressinfo);
    }

    public final void onRecvedData(String str, int i, byte[] bArr) {
    }

    public final void RequestGetCDN(int i) {
        x.i("MicroMsg.CdnTransportEngine", "requestgetcdn %d", new Object[]{Integer.valueOf(i)});
        keep_OnRequestDoGetCdnDnsInfo(i);
    }

    public final void ReportFlow(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3)});
        keep_cdnSendAndRecvData("dummy clientmsgid", i2 + i4, i + i3);
    }

    public final String[] resolveHost(String str, boolean z, int[] iArr) {
        x.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", new Object[]{str, Boolean.valueOf(z)});
        Object arrayList = new ArrayList();
        iArr[0] = com.tencent.mm.network.b.a(str, z, arrayList);
        x.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", new Object[]{Integer.valueOf(iArr[0]), Arrays.toString((String[]) arrayList.toArray(new String[0]))});
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static int lv(String str) {
        x.i("MicroMsg.CdnTransportEngine", "ipFromString %s", new Object[]{str});
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            int i = 0;
            int i2 = 0;
            while (i < address.length) {
                try {
                    i2 = (i2 << 8) | (address[i] & WebView.NORMAL_MODE_ALPHA);
                    i++;
                } catch (UnknownHostException e) {
                    return i2;
                }
            }
            return i2;
        } catch (UnknownHostException e2) {
            return 0;
        }
    }

    private static keep_SceneResult a(CdnLogic$C2CDownloadResult cdnLogic$C2CDownloadResult, keep_SceneResult keep_sceneresult) {
        if (keep_sceneresult == null) {
            keep_sceneresult = new keep_SceneResult();
        }
        keep_sceneresult.field_retCode = cdnLogic$C2CDownloadResult.errorCode;
        keep_sceneresult.field_argInfo = cdnLogic$C2CDownloadResult.argInfo;
        keep_sceneresult.field_fileLength = cdnLogic$C2CDownloadResult.fileSize;
        keep_sceneresult.field_fileId = cdnLogic$C2CDownloadResult.fileid;
        keep_sceneresult.field_transInfo = cdnLogic$C2CDownloadResult.transforMsg;
        keep_sceneresult.field_convert2baseline = false;
        keep_sceneresult.field_recvedBytes = cdnLogic$C2CDownloadResult.recvedBytes;
        keep_sceneresult.field_videoFormat = cdnLogic$C2CDownloadResult.videoFormat;
        keep_sceneresult.field_enQueueTime = cdnLogic$C2CDownloadResult.enQueueTime;
        keep_sceneresult.field_startTime = cdnLogic$C2CDownloadResult.startTime;
        keep_sceneresult.field_endTime = cdnLogic$C2CDownloadResult.endTime;
        keep_sceneresult.field_firstRequestCost = cdnLogic$C2CDownloadResult.firstRequestCost;
        keep_sceneresult.field_firstRequestSize = cdnLogic$C2CDownloadResult.firstRequestSize;
        keep_sceneresult.field_firstRequestDownloadSize = cdnLogic$C2CDownloadResult.firstRequestDownloadSize;
        keep_sceneresult.field_firstRequestCompleted = cdnLogic$C2CDownloadResult.firstRequestCompleted;
        keep_sceneresult.field_averageSpeed = cdnLogic$C2CDownloadResult.averageSpeed;
        keep_sceneresult.field_averageConnectCost = cdnLogic$C2CDownloadResult.averageConnectCost;
        keep_sceneresult.field_firstConnectCost = cdnLogic$C2CDownloadResult.firstConnectCost;
        keep_sceneresult.field_netConnectTimes = cdnLogic$C2CDownloadResult.netConnectTimes;
        keep_sceneresult.field_moovRequestTimes = cdnLogic$C2CDownloadResult.moovRequestTimes;
        keep_sceneresult.field_moovCost = cdnLogic$C2CDownloadResult.moovCost;
        keep_sceneresult.field_moovSize = cdnLogic$C2CDownloadResult.moovSize;
        keep_sceneresult.field_moovCompleted = cdnLogic$C2CDownloadResult.moovCompleted;
        keep_sceneresult.field_moovFailReason = cdnLogic$C2CDownloadResult.moovFailReason;
        keep_sceneresult.field_httpStatusCode = cdnLogic$C2CDownloadResult.httpStatusCode;
        keep_sceneresult.field_httpResponseHeader = cdnLogic$C2CDownloadResult.httpResponseHeader;
        keep_sceneresult.field_delayTime = cdnLogic$C2CDownloadResult.delayTime;
        keep_sceneresult.field_dnsCostTime = cdnLogic$C2CDownloadResult.dnsCostTime;
        keep_sceneresult.field_connectCostTime = cdnLogic$C2CDownloadResult.connectCostTime;
        keep_sceneresult.field_waitResponseCostTime = cdnLogic$C2CDownloadResult.waitResponseCostTime;
        keep_sceneresult.field_receiveCostTime = cdnLogic$C2CDownloadResult.receiveCostTime;
        keep_sceneresult.field_clientIP = cdnLogic$C2CDownloadResult.clientIP;
        keep_sceneresult.field_serverIP = cdnLogic$C2CDownloadResult.serverIP;
        keep_sceneresult.field_clientHostIP = lv(cdnLogic$C2CDownloadResult.clientIP);
        keep_sceneresult.field_serverHostIP = lv(cdnLogic$C2CDownloadResult.serverIP);
        keep_sceneresult.field_xErrorNo = cdnLogic$C2CDownloadResult.xErrorNo;
        keep_sceneresult.field_cSeqCheck = cdnLogic$C2CDownloadResult.cSeqCheck;
        keep_sceneresult.field_usePrivateProtocol = cdnLogic$C2CDownloadResult.usePrivateProtocol;
        keep_sceneresult.field_isCrossNet = cdnLogic$C2CDownloadResult.crossNet;
        keep_sceneresult.field_clientIP = cdnLogic$C2CDownloadResult.clientIP;
        if (cdnLogic$C2CDownloadResult.usedSvrIps != null) {
            keep_sceneresult.field_usedSvrIps = (String[]) cdnLogic$C2CDownloadResult.usedSvrIps.clone();
        }
        keep_sceneresult.field_isResume = cdnLogic$C2CDownloadResult.isResume;
        return keep_sceneresult;
    }

    public final void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        keep_SceneResult keep_sceneresult = new keep_SceneResult();
        keep_sceneresult.field_retCode = c2CUploadResult.errorCode;
        keep_sceneresult.field_toUser = c2CUploadResult.touser;
        keep_sceneresult.field_UploadHitCacheType = c2CUploadResult.hitCache;
        keep_sceneresult.field_fileId = c2CUploadResult.fileid;
        keep_sceneresult.field_aesKey = c2CUploadResult.aeskey;
        keep_sceneresult.field_filemd5 = c2CUploadResult.filemd5;
        keep_sceneresult.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        keep_sceneresult.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        keep_sceneresult.field_transInfo = c2CUploadResult.transforMsg;
        keep_sceneresult.field_fileLength = c2CUploadResult.fileSize;
        keep_sceneresult.field_midimgLength = c2CUploadResult.midfileSize;
        keep_sceneresult.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        keep_sceneresult.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        keep_sceneresult.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            keep_sceneresult.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        keep_sceneresult.field_videoFileId = c2CUploadResult.videofileid;
        keep_sceneresult.field_filecrc = c2CUploadResult.fileCrc32;
        keep_sceneresult.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        keep_sceneresult.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            keep_sceneresult.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        keep_sceneresult.field_fileUrl = c2CUploadResult.fileUrl;
        keep_sceneresult.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        keep_sceneresult.field_isResume = c2CUploadResult.isResume;
        keep_sceneresult.field_delayTime = c2CUploadResult.delayTime;
        keep_sceneresult.field_connectCostTime = c2CUploadResult.connectCostTime;
        keep_sceneresult.field_waitResponseCostTime = c2CUploadResult.waitResponseCostTime;
        keep_sceneresult.field_receiveCostTime = c2CUploadResult.receiveCostTime;
        keep_sceneresult.field_clientIP = c2CUploadResult.clientIP;
        keep_sceneresult.field_serverIP = c2CUploadResult.serverIP;
        keep_sceneresult.field_clientHostIP = lv(c2CUploadResult.clientIP);
        keep_sceneresult.field_serverHostIP = lv(c2CUploadResult.serverIP);
        if (keep_sceneresult.field_retCode != 0) {
            keep_onUploadError(str, keep_sceneresult);
        } else {
            keep_onUploadSuccessed(str, keep_sceneresult);
        }
    }

    public final void onC2CDownloadCompleted(String str, CdnLogic$C2CDownloadResult cdnLogic$C2CDownloadResult) {
        keep_SceneResult a = a(cdnLogic$C2CDownloadResult, null);
        if (a.field_retCode != 0) {
            keep_onDownloadError(str, a);
        } else {
            keep_onDownloadSuccessed(str, a);
        }
    }

    public final void onCheckFileidCompleted(String str, CheckFileIDResult checkFileIDResult) {
    }

    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        return keep_cdnDecodePrepareResponse(str, bArr);
    }

    public final void onMoovReady(String str, int i, int i2) {
        keep_onMoovReady(str, i, i2);
    }

    public final void onDataAvailable(String str, int i, int i2) {
        keep_onDataAvailable(str, i, i2);
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        keep_onDownloadToEnd(str, i, i2);
    }

    public final void onPreloadCompleted(String str, int i, int i2) {
    }

    public final void onPreloadCompletedWithResult(String str, int i, int i2, CdnLogic$C2CDownloadResult cdnLogic$C2CDownloadResult) {
        if (this.dOJ != null) {
            this.dOJ.b(str, a(cdnLogic$C2CDownloadResult, null));
        }
    }
}
