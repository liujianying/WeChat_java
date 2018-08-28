package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.j.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d extends Thread {
    private static HashMap<String, b> qqj = new HashMap();
    private static Object qqk = new byte[0];
    private static at qql;
    public boolean isStop;
    private List<String> qpZ;
    private List<Integer> qqa;
    private List<String> qqb;
    private List<String> qqc;
    private List<Integer> qqd;
    private a qqe;
    private j qqf;
    private String qqg;
    private String qqh;
    private boolean qqi = false;

    public d(List<String> list, String str, String str2, j jVar, a aVar) {
        this.qpZ = list;
        this.qqa = new ArrayList();
        this.qqb = new ArrayList();
        this.qqd = new ArrayList();
        this.qqc = new ArrayList();
        this.qqe = aVar;
        this.qqf = jVar;
        this.qqh = str2;
        this.qqg = str;
    }

    public final void run() {
        if (this.qpZ != null && this.qpZ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.qpZ.size() && !this.isStop) {
                    String nK;
                    String str;
                    x.i("MicroMsg.NoteVideoCompress", "start to import %s", new Object[]{this.qpZ.toString()});
                    Intent intent = new Intent();
                    intent.setData(Uri.parse("file://" + ((String) this.qpZ.get(i2))));
                    Context context = ad.getContext();
                    StringBuilder stringBuilder = new StringBuilder("note_");
                    au.HU();
                    String stringBuilder2 = stringBuilder.append(s.nJ((String) c.DT().get(2, ""))).toString();
                    String nL;
                    if (bi.oW(this.qqg) || bi.oW(this.qqh)) {
                        o.Ta();
                        nL = s.nL(stringBuilder2);
                        o.Ta();
                        nK = s.nK(stringBuilder2);
                        str = nL;
                    } else {
                        nL = this.qqg;
                        stringBuilder2 = this.qqh.substring(this.qqh.lastIndexOf("/") + 1, this.qqh.length());
                        nK = this.qqh;
                        str = nL;
                    }
                    boolean is2G = ao.is2G(ad.getContext());
                    String i3 = a.i(context, intent);
                    if (bi.oW(i3)) {
                        x.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                        a(-50005, stringBuilder2, i3, 0, null, context, null);
                    } else {
                        int i4;
                        VideoTransPara videoTransPara;
                        Object obj;
                        a.a j;
                        boolean oZ = com.tencent.mm.plugin.a.c.oZ(i3);
                        int cm = e.cm(i3);
                        if (oZ) {
                            VideoTransPara videoTransPara2;
                            PInt pInt = new PInt();
                            if (com.tencent.mm.modelcontrol.d.NP().lB(i3)) {
                                x.i("MicroMsg.NoteVideoCompress", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[]{i3});
                                pInt.value = 1;
                                videoTransPara2 = null;
                            } else {
                                VideoTransPara videoTransPara3 = new VideoTransPara();
                                PInt pInt2 = new PInt();
                                PInt pInt3 = new PInt();
                                PInt pInt4 = new PInt();
                                PInt pInt5 = new PInt();
                                PInt pInt6 = new PInt();
                                com.tencent.mm.plugin.sight.base.d.a(i3, pInt2, pInt3, pInt4, pInt5, pInt6);
                                videoTransPara3.duration = pInt2.value / 1000;
                                videoTransPara3.width = pInt3.value;
                                videoTransPara3.height = pInt4.value;
                                videoTransPara3.fps = pInt5.value;
                                videoTransPara3.videoBitrate = pInt6.value;
                                x.d("MicroMsg.NoteVideoCompress", "check remuxing old para %s", new Object[]{videoTransPara3});
                                videoTransPara2 = com.tencent.mm.modelcontrol.d.NP().b(videoTransPara3);
                                if (videoTransPara2 == null) {
                                    x.i("MicroMsg.NoteVideoCompress", "get C2C album video para is null. old para %s", new Object[]{videoTransPara3});
                                    pInt.value = -5;
                                    videoTransPara2 = null;
                                } else {
                                    x.d("MicroMsg.NoteVideoCompress", "check remuxing new para %s", new Object[]{videoTransPara2});
                                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                                        x.i("MicroMsg.NoteVideoCompress", "new bitrate is bigger than old bitrate %s %s", new Object[]{videoTransPara2, videoTransPara3});
                                        pInt.value = 1;
                                        videoTransPara2 = null;
                                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                                        boolean is2G2 = ao.is2G(ad.getContext());
                                        pInt.value = SightVideoJNI.shouldRemuxing(i3, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, 1000000);
                                    } else {
                                        pInt.value = -6;
                                        videoTransPara2 = null;
                                    }
                                }
                            }
                            i4 = pInt.value;
                            videoTransPara = videoTransPara2;
                        } else {
                            if (cm > (is2G ? 10485760 : 26214400)) {
                                i4 = -5;
                                videoTransPara = null;
                            } else {
                                i4 = 1;
                                videoTransPara = null;
                            }
                        }
                        x.i("MicroMsg.NoteVideoCompress", "check remuxing, ret %d isMp4 %b length %d", new Object[]{Integer.valueOf(i4), Boolean.valueOf(oZ), Integer.valueOf(cm)});
                        switch (i4) {
                            case ErrCode.ERR_BAN /*-6*/:
                            case ErrCode.ERR_AUTH_DENIED /*-4*/:
                            case -3:
                            case -2:
                                a(-50002, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case ErrCode.ERR_UNSUPPORT /*-5*/:
                                a(-50008, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case -1:
                                a(-50007, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case 0:
                                obj = 1;
                                i4 = 0;
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                if (cm <= 26214400) {
                                    obj = null;
                                    i4 = 0;
                                    break;
                                }
                                a(-50002, stringBuilder2, i3, 0, null, context, null);
                                obj = null;
                                i4 = -50002;
                                break;
                            default:
                                x.e("MicroMsg.NoteVideoCompress", "unknown check type");
                                a(-50001, stringBuilder2, i3, 0, null, context, null);
                                continue;
                        }
                        a.a aVar = null;
                        try {
                            j = a.j(context, intent);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "", new Object[0]);
                            j = aVar;
                        }
                        if (j == null) {
                            x.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                            a(-50005, stringBuilder2, i3, 0, null, context, null);
                        } else {
                            Object obj2;
                            if (obj == null) {
                                com.tencent.mm.sdk.platformtools.j.q(i3, nK, false);
                            } else {
                                i4 = -50006;
                            }
                            int ge = bi.ge((long) j.duration);
                            if (j.bitmap != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.c.a(j.bitmap, 60, CompressFormat.JPEG, str, true);
                                    obj2 = null;
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.NoteVideoCompress", e2, "", new Object[0]);
                                }
                                if (obj2 != null) {
                                    try {
                                        com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                    } catch (Throwable e22) {
                                        x.printErrStackTrace("MicroMsg.NoteVideoCompress", e22, "", new Object[0]);
                                    }
                                }
                                if (obj == null && !e.cn(nK)) {
                                    i4 = -50003;
                                }
                                if (!e.cn(str)) {
                                    i4 = -50004;
                                }
                                a(i4, stringBuilder2, i3, ge, videoTransPara, context, str);
                            }
                            int obj22 = 1;
                            if (obj22 != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.NoteVideoCompress", e222, "", new Object[0]);
                                }
                            }
                            i4 = -50003;
                            if (e.cn(str)) {
                                i4 = -50004;
                            }
                            a(i4, stringBuilder2, i3, ge, videoTransPara, context, str);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Context context, String str3) {
        x.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
        e(i, str, str2, i2);
        if (i == -50002) {
            bc(context, context.getString(R.l.video_export_file_too_big));
        } else if (i == -50008) {
            bc(context, context.getString(R.l.video_export_duration_too_long));
        } else if (i == -50006) {
            if (bi.oW(str)) {
                x.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            } else {
                r rVar = new r();
                rVar.fileName = str;
                rVar.enM = 1;
                rVar.bWJ = null;
                au.HU();
                rVar.enF = (String) c.DT().get(2, "");
                rVar.createTime = bi.VE();
                rVar.enK = bi.VE();
                rVar.enS = null;
                rVar.elu = str2;
                if (!bi.oW(str2)) {
                    rVar.enQ = 1;
                }
                rVar.dHI = 0;
                o.Ta().a(rVar);
            }
            if (qql == null) {
                qql = new at(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            b bVar = new b((byte) 0);
            synchronized (qqk) {
                qqj.put(str, bVar);
            }
            bVar.fileName = str;
            bVar.elu = str2;
            bVar.qqo = this.qqh;
            bVar.qqq = videoTransPara;
            bVar.qqe = this.qqe;
            bVar.qqf = this.qqf;
            qql.c(bVar);
        } else if (i < 0) {
            bc(context, context.getString(R.l.video_export_file_error));
        } else {
            this.qqi = true;
        }
        if (this.qqe != null && !this.isStop) {
            ah.A(new 1(this, str3, i));
        }
    }

    private void bc(Context context, String str) {
        ah.A(new 2(this, context, str));
    }

    public static void d(String str, int[] iArr) {
        int i;
        int i2;
        Throwable e;
        int i3;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                try {
                    i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        i2 = 0;
                        iArr[0] = i;
                        iArr[1] = i2;
                        for (i3 = 0; i3 < 3; i3++) {
                            if (i % 2 != 0 || i2 % 2 != 0) {
                                return;
                            }
                            if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                                break;
                            }
                            i /= 2;
                            i2 /= 2;
                        }
                        iArr[0] = i;
                        iArr[1] = i2;
                    } catch (Throwable th) {
                        e = th;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                i = 0;
                x.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                i2 = 0;
                iArr[0] = i;
                iArr[1] = i2;
                for (i3 = 0; i3 < 3; i3++) {
                    if (i % 2 != 0 || i2 % 2 != 0) {
                        return;
                    }
                    if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                        break;
                    }
                    i /= 2;
                    i2 /= 2;
                }
                iArr[0] = i;
                iArr[1] = i2;
            }
        } catch (Exception e4) {
            e = e4;
            i = 0;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            i2 = 0;
            iArr[0] = i;
            iArr[1] = i2;
            for (i3 = 0; i3 < 3; i3++) {
                if (i % 2 != 0 || i2 % 2 != 0) {
                    return;
                }
                if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                    break;
                }
                i /= 2;
                i2 /= 2;
            }
            iArr[0] = i;
            iArr[1] = i2;
        } catch (Throwable th2) {
            e = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw e;
        }
        iArr[0] = i;
        iArr[1] = i2;
        for (i3 = 0; i3 < 3; i3++) {
            if (i % 2 != 0 || i2 % 2 != 0) {
                return;
            }
            if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                break;
            }
            i /= 2;
            i2 /= 2;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        this.qqa.add(Integer.valueOf(i));
        this.qqb.add(str);
        this.qqc.add(str2);
        this.qqd.add(Integer.valueOf(i2));
    }
}
