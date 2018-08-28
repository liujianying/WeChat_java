package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.j.a$a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bj;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class j extends Thread {
    private static int dYK;
    private static HashMap<String, b> qqj = new HashMap();
    private static Object qqk = new byte[0];
    private static at qql;
    private Context context;
    private Intent intent;
    private boolean isStop;
    private List<String> qpZ;
    private List<Integer> qqa = new ArrayList();
    private List<String> qqb = new ArrayList();
    private List<String> qqc = new ArrayList();
    private List<Integer> qqd = new ArrayList();
    private int qyT;
    private a qyU;
    private String talker;

    public interface a {
        void cbw();
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.at.a {
        String elu;
        String fileName;
        private int ljU;
        private int ljV;
        String qqo;
        int qqp;
        VideoTransPara qqq;
        private boolean qqr;
        private int qqs;
        int qyT;
        String toUser;

        private b() {
            this.qqs = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final boolean Kr() {
            Object obj;
            synchronized (j.qqk) {
                obj = !j.qqj.containsKey(this.fileName) ? 1 : null;
            }
            if (obj == null) {
                obj = t.nW(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                x.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[]{this.fileName});
                return true;
            }
            j.dYK = HardCoderJNI.startPerformance(HardCoderJNI.hcEncodeVideoEnable, HardCoderJNI.hcEncodeVideoDelay, HardCoderJNI.hcEncodeVideoCPU, HardCoderJNI.hcEncodeVideoIO, HardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, HardCoderJNI.hcEncodeVideoTimeout, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_UNKNOWN_HOST, HardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[]{Integer.valueOf(j.dYK)});
            if (this.qqq == null || this.qqq.isDefault) {
                int[] iArr = new int[2];
                j.d(this.elu, iArr);
                this.ljU = iArr[0];
                this.ljV = iArr[1];
            } else {
                this.ljU = this.qqq.width;
                this.ljV = this.qqq.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (((com.tencent.mm.plugin.t.a.a) g.l(com.tencent.mm.plugin.t.a.a.class)).FY().a(this.elu, pString, pInt) && com.tencent.mm.sdk.platformtools.j.fN(pString.value, this.qqo)) {
                x.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
                this.qqp = pInt.value;
                this.qqr = true;
                return true;
            }
            long VG = bi.VG();
            if (this.qqq != null) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[]{this.qqq});
                if (com.tencent.mm.plugin.sight.base.b.nbU) {
                    this.qqq.videoBitrate = (int) (((double) this.qqq.videoBitrate) * 0.915d);
                }
                this.qqp = SightVideoJNI.remuxing(this.elu, this.qqo, this.ljU, this.ljV, this.qqq.videoBitrate, this.qqq.dQI, 8, this.qqq.dQH, 25.0f, (float) this.qqq.fps, null, 0, com.tencent.mm.plugin.sight.base.b.nbU);
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[]{this.fileName});
                if (com.tencent.mm.plugin.sight.base.b.nbU) {
                    com.tencent.mm.plugin.sight.base.b.nbW = (int) (((double) com.tencent.mm.plugin.sight.base.b.nbW) * 0.915d);
                }
                this.qqp = SightVideoJNI.remuxing(this.elu, this.qqo, this.ljU, this.ljV, com.tencent.mm.plugin.sight.base.b.nbW, com.tencent.mm.plugin.sight.base.b.nbV, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.nbX, null, 0, com.tencent.mm.plugin.sight.base.b.nbU);
            }
            this.qqs = (int) bi.bI(VG);
            x.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{this.elu, this.qqo, Integer.valueOf(this.qqp), Integer.valueOf(this.ljU), Integer.valueOf(this.ljV)});
            this.qqr = this.qqp >= 0;
            PInt pInt2 = new PInt();
            if (t.a(this.qqo, pInt2, new PInt())) {
                this.qqp = pInt2.value;
            }
            if (this.qqr) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                try {
                    String name = new File(this.qqo).getName();
                    String str = this.qqo + ".tmp";
                    PInt pInt3 = new PInt(0);
                    if (d.b(this.qqo, str, pInt3)) {
                        boolean deleteFile = e.deleteFile(this.qqo);
                        File file = new File(str);
                        boolean i = e.i(file.getParent() + File.separator, file.getName(), name);
                        x.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(i), file.getAbsolutePath(), this.qqo});
                        h.mEJ.a(354, 30, 1, false);
                    } else {
                        if (pInt3.value != 1) {
                            h.mEJ.a(354, 31, 1, false);
                        } else {
                            h.mEJ.a(354, 32, 1, false);
                            h.mEJ.h(13836, new Object[]{Integer.valueOf(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED), Long.valueOf(bi.VE()), this.qqo});
                        }
                        x.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[]{Integer.valueOf(pInt3.value), this.elu, this.qqo});
                    }
                    ((com.tencent.mm.plugin.t.a.a) g.l(com.tencent.mm.plugin.t.a.a.class)).FY().K(this.elu, this.qqo, this.qqp);
                } catch (Exception e) {
                    x.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[]{e.toString()});
                }
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                e.deleteFile(this.qqo);
                com.tencent.mm.sdk.platformtools.j.q(this.elu, this.qqo, false);
            }
            if (j.dYK != 0) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcEncodeVideoEnable, j.dYK);
                x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformace %s", new Object[]{Integer.valueOf(j.dYK)});
                j.dYK = 0;
            }
            return true;
        }

        public final boolean Ks() {
            int i;
            int i2;
            synchronized (j.qqk) {
                j.qqj.remove(this.fileName);
            }
            if (this.qqr) {
                j.cM(this.qqo, this.qyT);
            } else {
                j.cL(this.qqo, this.qyT);
            }
            j.d(this.qqr, this.elu, this.qqo);
            if (com.tencent.mm.plugin.sight.base.b.nbU) {
                i = 1;
            } else {
                i = 0;
            }
            j.a(i, this.qqs, this.elu, this.qqo, this.qqp);
            if (this.qyT == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            n.SY().a(this.elu, this.qqo, this.toUser, "", "", i2, this.qqr ? 1 : 3);
            t.l(this.fileName, this.qqp, 43);
            t.nR(this.fileName);
            return false;
        }
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        long cm = (long) e.cm(str);
        if (cm > 0) {
            int cm2 = (int) ((100 * ((long) e.cm(str2))) / cm);
            x.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(cm), Long.valueOf((long) e.cm(str2)), Integer.valueOf(cm2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
            h.mEJ.h(13432, new Object[]{Integer.valueOf(i), Long.valueOf(cm), Long.valueOf(r2), Integer.valueOf(cm2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
            return;
        }
        x.e("MicroMsg.ImportMultiVideo", "file canot be empty");
    }

    static /* synthetic */ void cM(String str, int i) {
        if (i == 2) {
            long cm = (long) e.cm(str);
            int f = bi.f((Integer) h.a((int) (cm / ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, 247, 255));
            h.mEJ.a(106, (long) f, 1, false);
            h.mEJ.a(106, 246, 1, false);
            x.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + f + " file len : " + (cm / ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "K");
        }
    }

    public j(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        this.context = context;
        this.qpZ = list;
        this.intent = intent;
        this.qyU = aVar;
        this.talker = str;
        this.qyT = i;
    }

    public final void run() {
        if (this.qpZ == null || this.qpZ.size() <= 0) {
            y(this.context, this.intent);
        } else {
            for (int i = 0; i < this.qpZ.size() && !this.isStop; i++) {
                x.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[]{this.qpZ.get(i)});
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.qpZ.get(i))));
                y(this.context, intent);
            }
        }
        if (this.qyU != null && !this.isStop) {
            ah.A(new Runnable() {
                public final void run() {
                    a e = j.this.qyU;
                    j.this.qqa;
                    j.this.qqb;
                    j.this.qqc;
                    j.this.qqd;
                    e.cbw();
                }
            });
        }
    }

    private void y(Context context, Intent intent) {
        String nJ = s.nJ((String) g.Ei().DT().get(2, ""));
        o.Ta();
        String nL = s.nL(nJ);
        o.Ta();
        String nK = s.nK(nJ);
        boolean is2G = ao.is2G(ad.getContext());
        String i = com.tencent.mm.compatible.j.a.i(context, intent);
        if (bi.oW(i)) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, nJ, i, 0, null, intent);
            return;
        }
        int i2;
        VideoTransPara videoTransPara;
        Object obj;
        a$a j;
        boolean oZ = c.oZ(i);
        int cm = e.cm(i);
        if (oZ) {
            VideoTransPara videoTransPara2;
            PInt pInt = new PInt();
            if (com.tencent.mm.modelcontrol.d.NP().lB(i)) {
                x.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[]{i});
                pInt.value = 1;
                h.mEJ.a(422, 51, 1, false);
                videoTransPara2 = null;
            } else {
                VideoTransPara videoTransPara3 = new VideoTransPara();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                PInt pInt6 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(i, pInt2, pInt3, pInt4, pInt5, pInt6);
                videoTransPara3.duration = pInt2.value / BaseReportManager.MAX_READ_COUNT;
                videoTransPara3.width = pInt3.value;
                videoTransPara3.height = pInt4.value;
                videoTransPara3.fps = pInt5.value;
                videoTransPara3.videoBitrate = pInt6.value;
                x.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[]{videoTransPara3});
                videoTransPara2 = com.tencent.mm.modelcontrol.d.NP().b(videoTransPara3);
                if (videoTransPara2 == null) {
                    x.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[]{videoTransPara3});
                    pInt.value = -5;
                    videoTransPara2 = null;
                } else {
                    x.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[]{videoTransPara2});
                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                        x.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[]{videoTransPara2, videoTransPara3});
                        pInt.value = 1;
                        videoTransPara2 = null;
                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * BaseReportManager.MAX_READ_COUNT < 180000) {
                        boolean is2G2 = ao.is2G(ad.getContext());
                        pInt.value = SightVideoJNI.shouldRemuxing(i, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, 1000000);
                    } else {
                        pInt.value = -6;
                        videoTransPara2 = null;
                    }
                }
            }
            i2 = pInt.value;
            videoTransPara = videoTransPara2;
        } else {
            if (cm > (is2G ? 10485760 : 26214400)) {
                i2 = -5;
                videoTransPara = null;
            } else {
                i2 = 1;
                videoTransPara = null;
            }
        }
        x.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[]{Integer.valueOf(i2), Boolean.valueOf(oZ), Integer.valueOf(cm)});
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, nJ, i, 0, null, intent);
                return;
            case -5:
                a(-50008, nJ, i, 0, null, intent);
                return;
            case -1:
                a(-50007, nJ, i, 0, null, intent);
                return;
            case 0:
                obj = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (cm <= 26214400) {
                    obj = null;
                    i2 = 0;
                    break;
                }
                a(-50002, nJ, i, 0, null, intent);
                obj = null;
                i2 = -50002;
                break;
            default:
                x.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, nJ, i, 0, null, intent);
                return;
        }
        a$a a_a = null;
        try {
            j = com.tencent.mm.compatible.j.a.j(context, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            j = a_a;
        }
        if (j == null) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, nJ, i, 0, null, intent);
            return;
        }
        if (obj == null) {
            com.tencent.mm.sdk.platformtools.j.q(i, nK, false);
            cL(nK, this.qyT);
            d(false, i, nK);
        } else {
            i2 = -50006;
        }
        int ge = bi.ge((long) j.duration);
        Object obj2 = 1;
        if (j.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.c.a(j.bitmap, 60, CompressFormat.JPEG, nL, true);
                obj2 = null;
                kA(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                kA(false);
                com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, CompressFormat.JPEG, nL, true);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !e.cn(nK)) {
            i2 = -50003;
        }
        if (!e.cn(nL)) {
            i2 = -50004;
        }
        a(i2, nJ, i, ge, videoTransPara, intent);
    }

    public final void cbu() {
        this.isStop = true;
        interrupt();
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        x.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
        e(i, str, str2, i2);
        int i3;
        if (i == -50002) {
            i3 = this.qyT == 1 ? 230 : 245;
            x.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i3 + " importType : " + this.qyT);
            h.mEJ.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, 141);
        } else if (i == -50008) {
            h.mEJ.a(106, 210, 1, false);
            a(this.talker, str, str2, intent, i2, (int) com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX);
        } else if (i == -50006) {
            if (t.a(str, this.talker, str2, 43) < 0) {
                a(this.talker, str, str2, intent, i2, 142);
                x.e("MicroMsg.ImportMultiVideo", "prepare");
                return;
            }
            if (qql == null) {
                qql = new at(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            b bVar = new b();
            synchronized (qqk) {
                qqj.put(str, bVar);
            }
            bVar.fileName = str;
            bVar.elu = str2;
            o.Ta();
            bVar.qqo = s.nK(str);
            bVar.qyT = this.qyT;
            bVar.toUser = this.talker;
            bVar.qqq = videoTransPara;
            qql.c(bVar);
        } else if (i < 0) {
            i3 = this.qyT == 1 ? bj.CTRL_INDEX : 244;
            x.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i3 + " importType : " + this.qyT);
            h.mEJ.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, 142);
        } else {
            t.b(str, i2, this.talker, str2);
            t.nR(str);
            int i4 = this.qyT == 1 ? 8 : 1;
            o.Ta();
            n.SY().a(str2, s.nK(str), this.talker, "", "", i4, 2);
        }
    }

    private void a(String str, String str2, String str3, Intent intent, int i, int i2) {
        bd bdVar = new bd();
        bdVar.setStatus(5);
        bdVar.ep(str);
        bdVar.ay(com.tencent.mm.model.bd.iD(str));
        bdVar.eX(1);
        bdVar.eq(str2);
        bdVar.setType(43);
        long T = ((i) g.l(i.class)).bcY().T(bdVar);
        x.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_talker, Integer.valueOf(bdVar.getType()), Integer.valueOf(bdVar.field_isSend), bdVar.field_imgPath, Integer.valueOf(bdVar.field_status), Long.valueOf(bdVar.field_createTime)});
        if (-1 == T) {
            x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[]{str});
        } else if (t.nW(str2) == null) {
            o.Ta();
            String nL = s.nL(str2);
            try {
                a$a j = com.tencent.mm.compatible.j.a.j(this.context, intent);
                int nM;
                int nM2;
                r rVar;
                if (j == null || j.bitmap == null) {
                    com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, CompressFormat.JPEG, nL, true);
                    nM = s.nM(nL);
                    o.Ta();
                    nM2 = s.nM(s.nK(str2));
                    rVar = new r();
                    rVar.fileName = str2;
                    if (nM2 <= 0) {
                        nM2 = 0;
                    }
                    rVar.dHI = nM2;
                    rVar.enJ = nM;
                    rVar.enM = i;
                    rVar.bWJ = str;
                    rVar.enF = (String) g.Ei().DT().get(2, "");
                    rVar.createTime = bi.VE();
                    rVar.enK = bi.VE();
                    rVar.enS = null;
                    rVar.elu = str3;
                    if (!bi.oW(str3)) {
                        rVar.enQ = 1;
                    }
                    rVar.enT = -1;
                    rVar.status = i2;
                    rVar.enN = (int) T;
                    if (!o.Ta().a(rVar)) {
                        x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[]{Long.valueOf(T)});
                    }
                }
                i = bi.ge((long) j.duration);
                com.tencent.mm.sdk.platformtools.c.a(j.bitmap, 60, CompressFormat.JPEG, nL, true);
                nM = s.nM(nL);
                o.Ta();
                nM2 = s.nM(s.nK(str2));
                rVar = new r();
                rVar.fileName = str2;
                if (nM2 <= 0) {
                    nM2 = 0;
                }
                rVar.dHI = nM2;
                rVar.enJ = nM;
                rVar.enM = i;
                rVar.bWJ = str;
                rVar.enF = (String) g.Ei().DT().get(2, "");
                rVar.createTime = bi.VE();
                rVar.enK = bi.VE();
                rVar.enS = null;
                rVar.elu = str3;
                if (bi.oW(str3)) {
                    rVar.enQ = 1;
                }
                rVar.enT = -1;
                rVar.status = i2;
                rVar.enN = (int) T;
                if (!o.Ta().a(rVar)) {
                    x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[]{Long.valueOf(T)});
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
    }

    public static void d(String str, int[] iArr) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i;
                iArr[1] = i2;
                for (int i3 = 0; i3 < 3; i3++) {
                    if (i % 2 != 0) {
                        i--;
                    }
                    if (i2 % 2 != 0) {
                        i2--;
                    }
                    if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                        break;
                    }
                    i /= 2;
                    i2 /= 2;
                }
                iArr[0] = i;
                iArr[1] = i2;
                mediaMetadataRetriever.release();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        this.qqa.add(Integer.valueOf(i));
        this.qqb.add(str);
        this.qqc.add(str2);
        this.qqd.add(Integer.valueOf(i2));
    }

    public static void cbv() {
        int size;
        synchronized (qqk) {
            size = qqj.size();
            qqj.clear();
        }
        if (qql == null) {
            x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[]{Integer.valueOf(size)});
            return;
        }
        x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[]{Integer.valueOf(size), Integer.valueOf(qql.sIl.size())});
        qql.sIl.clear();
        qql = null;
    }

    public static boolean SN(String str) {
        boolean containsKey;
        synchronized (qqk) {
            containsKey = qqj.containsKey(str);
        }
        x.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[]{str, Boolean.valueOf(containsKey)});
        return containsKey;
    }

    public static void SO(String str) {
        boolean z = true;
        synchronized (qqk) {
            if (qqj.remove(str) == null) {
                z = false;
            }
            x.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[]{str, Boolean.valueOf(z)});
        }
    }

    private void kA(boolean z) {
        int i;
        if (this.qyT == 1) {
            if (z) {
                i = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        x.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.qyT);
        h.mEJ.a(106, (long) i, 1, false);
    }

    private static void cL(String str, int i) {
        int i2;
        int i3;
        int i4;
        if (i == 1) {
            i2 = 220;
            i3 = 228;
            i4 = 219;
        } else {
            i2 = 234;
            i3 = 242;
            i4 = 233;
        }
        long cm = (long) e.cm(str);
        int f = bi.f((Integer) h.a((int) (cm / ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, i2, i3));
        h.mEJ.a(106, (long) f, 1, false);
        h.mEJ.a(106, (long) i4, 1, false);
        x.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + f + " file len : " + (cm / ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "K");
    }

    private static void d(boolean z, String str, String str2) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            return;
        }
        try {
            long cm = (long) e.cm(str);
            long cm2 = (long) e.cm(str2);
            int i2 = (int) ((100 * cm2) / cm);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(cm).append(";");
            stringBuilder.append(cm2).append(";").append(i2);
            x.d("MicroMsg.AtomStatUtil", "report video remuxing : " + stringBuilder.toString());
            h.mEJ.h(11098, new Object[]{Integer.valueOf(8001), r0});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            x.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
        }
    }
}
