package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.sns.model.b.6;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.c;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdLandingPagesProxy extends a {
    private static AdLandingPagesProxy nml;
    public static b nmp = new b();
    private e dKj = new 1(this);
    private Map<Long, a> nmm = new HashMap();
    private Map<l, Long> nmn = new HashMap();
    private d nmo;
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> nmq = new HashMap();
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> nmr = new HashMap();
    private Map<String, d> nms = new HashMap();
    private b nmt = new 3(this);

    static /* synthetic */ void LT(String str) {
        long WU;
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                WU = (long) bi.WU(str.substring(indexOf + 10, indexOf2));
                if (WU > 0) {
                    x.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(WU)});
                    i.bAE().p(WU, str);
                }
            }
        }
        WU = 0;
        if (WU > 0) {
            x.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(WU)});
            i.bAE().p(WU, str);
        }
    }

    public static void create(d dVar) {
        nml = new AdLandingPagesProxy(dVar);
    }

    public AdLandingPagesProxy(d dVar) {
        super(dVar);
        if (dVar == null) {
            g.Ek();
            g.Eh().dpP.a(1337, this.dKj);
            g.Ek();
            g.Eh().dpP.a(1210, this.dKj);
            g.Ek();
            g.Eh().dpP.a(2874, this.dKj);
            g.Ek();
            g.Eh().dpP.a(2721, this.dKj);
            g.Ek();
            g.Eh().dpP.a(1802, this.dKj);
            af.byj().a(this.nmt);
        }
        this.nmo = dVar;
    }

    public static AdLandingPagesProxy getInstance() {
        if (nml != null) {
            return nml;
        }
        throw new IllegalStateException("init first");
    }

    public boolean isConnected() {
        return this.nmo == null ? false : this.nmo.isConnected();
    }

    public void onRelease() {
        g.Ek();
        g.Eh().dpP.b(1337, this.dKj);
        g.Ek();
        g.Eh().dpP.b(1210, this.dKj);
        g.Ek();
        g.Eh().dpP.b(2874, this.dKj);
        g.Ek();
        g.Eh().dpP.b(2721, this.dKj);
        g.Ek();
        g.Eh().dpP.b(1802, this.dKj);
        af.byj().b(this.nmt);
    }

    public Object getCfg(int i, Object obj) {
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", new Object[]{Integer.valueOf(i), obj});
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    @f
    public Object getCfgMM(int i, Object obj) {
        g.Ek();
        return g.Ei().DT().get(i, obj);
    }

    public int contactGetTypeTextFromUserName(String str) {
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", new Object[]{str});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int contactGetTypeTextFromUserNameMM(String str) {
        return s.hQ(str);
    }

    public String getSnsStatExtBySnsId(long j) {
        return (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", new Object[]{Long.valueOf(j)});
    }

    @f
    public String getSnsStatExtBySnsIdMM(long j) {
        com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(j);
        if (eZ != null) {
            return com.tencent.mm.plugin.sns.a.b.f.a(eZ.bAJ());
        }
        x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{Long.valueOf(j)});
        return "";
    }

    public String getAccSnsPath() {
        return (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    }

    @f
    public String getAccSnsPathMM() {
        return af.getAccSnsPath();
    }

    public String getSnsAid(String str) {
        return (String) REMOTE_CALL("getSnsAidMM", new Object[]{str});
    }

    @f
    public String getSnsAidMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            return Nk.bBj();
        }
        return "";
    }

    public int getSnsAdType(String str) {
        return ((Integer) REMOTE_CALL("getSnsAdTypeMM", new Object[]{str})).intValue();
    }

    @f
    public int getSnsAdTypeMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            return Nk.bBr();
        }
        return 0;
    }

    public void doOpenAppBrand(String str, String str2, String str3) {
        REMOTE_CALL("doOpenAppBrandMM", new Object[]{str, str2, str3});
    }

    @f
    public void doOpenAppBrandMM(String str, String str2, String str3) {
        qu quVar = new qu();
        quVar.cbq.userName = str;
        quVar.cbq.cbs = str2;
        quVar.cbq.scene = 1084;
        quVar.cbq.bGG = str3;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(ad.getContext(), SnsTransparentUI.class);
            intent.putExtra("phoneNum", str);
            intent.putExtra("op", 4);
            activity.startActivity(intent);
        }
    }

    public String getSnsTraceid(String str) {
        return (String) REMOTE_CALL("getSnsTraceidMM", new Object[]{str});
    }

    @f
    public String getSnsTraceidMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            return Nk.bBk();
        }
        return "";
    }

    public boolean isRecExpAd(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isRecExpAdMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk == null) {
            return false;
        }
        return Nk.bzx();
    }

    public n getSnsInfo(String str) {
        Bundle bundle = null;
        try {
            Bundle bundle2 = (Bundle) REMOTE_CALL("getSnsInfoMM", new Object[]{str});
            if (bundle2 == null) {
                return null;
            }
            bundle = bundle2;
            n nVar = new n();
            if (bundle != null) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
                nVar.field_snsId = contentValues.getAsLong("snsId").longValue();
                nVar.field_userName = contentValues.getAsString("userName");
                nVar.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
                nVar.field_createTime = contentValues.getAsInteger("createTime").intValue();
                nVar.field_head = contentValues.getAsInteger("head").intValue();
                nVar.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
                nVar.field_type = contentValues.getAsInteger("type").intValue();
                nVar.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
                nVar.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
                nVar.field_pravited = contentValues.getAsInteger("pravited").intValue();
                nVar.field_stringSeq = contentValues.getAsString("stringSeq");
                nVar.field_content = contentValues.getAsByteArray("content");
                nVar.field_attrBuf = contentValues.getAsByteArray("attrBuf");
                nVar.field_postBuf = contentValues.getAsByteArray("postBuf");
                nVar.field_subType = contentValues.getAsInteger("subType").intValue();
                if (contentValues.containsKey("rowid")) {
                    nVar.sKx = contentValues.getAsLong("rowid").longValue();
                }
                nVar.nJc = bundle.getInt("localid");
                bundle2 = bundle.getBundle("adValues");
                if (bundle2 != null) {
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.F(bundle2);
                    nVar.nJm = eVar;
                }
            }
            return nVar;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingPagesProxy", e, "", new Object[0]);
        }
    }

    @f
    public Bundle getSnsInfoMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk == null) {
            return null;
        }
        return Nk.bAM();
    }

    public String getUin() {
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        return REMOTE_CALL == null ? "" : (String) REMOTE_CALL;
    }

    @f
    public String getUinMM() {
        g.Eg();
        return com.tencent.mm.kernel.a.Dg();
    }

    public boolean useOnlineStreamPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean useOnlineStreamPlayerMM() {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100208");
        if (!fJ.isValid()) {
            return false;
        }
        int i = bi.getInt((String) fJ.ckq().get("useOnlineVideoPlayer"), 0);
        x.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @f
    public int getExpValueByKeyMM(String str, int i) {
        return com.tencent.mm.model.c.c.Jy().da(str, i);
    }

    public int getExpValueByKey(String str, int i) {
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", new Object[]{str, Integer.valueOf(i)});
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public String getExpIdByKeyMM(String str) {
        return com.tencent.mm.model.c.c.Jy().getExpIdByKey(str);
    }

    public String getExpIdByKey(String str) {
        return (String) REMOTE_CALL("getExpIdByKeyMM", new Object[]{str});
    }

    public int isAutoAdDownload() {
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    public void favEditTag() {
        REMOTE_CALL("favEditTagMM", new Object[0]);
    }

    @f
    public void favEditTagMM() {
        fz fzVar = new fz();
        fzVar.bOL.type = 35;
        com.tencent.mm.sdk.b.a.sFg.m(fzVar);
    }

    @f
    public int isAutoAdDownloadMM() {
        return af.byl().b(null, null);
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", new Object[]{Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7, str8});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) {
        ch chVar = new ch();
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) {
            bi.oW(str);
        }
        ((com.tencent.mm.plugin.fav.a.ad) g.l(com.tencent.mm.plugin.fav.a.ad.class)).a(chVar, str6.hashCode(), q.GF(), str4, str5, str6, str7, str2);
        chVar.bJF.bJK = u.ic(str3);
        chVar.bJF.title = str4;
        chVar.bJF.desc = str5;
        wl wlVar = chVar.bJF.bJH;
        if (!(wlVar == null || wlVar.rBI == null || wlVar.rBI.size() <= 0 || wlVar.rBI.get(0) == null)) {
            ((vx) wlVar.rBI.get(0)).Va(str6);
            ((vx) wlVar.rBI.get(0)).UB(str4);
            ((vx) wlVar.rBI.get(0)).UC(str5);
            ((vx) wlVar.rBI.get(0)).UZ(str8);
        }
        if (wlVar != null) {
            wlVar.Vu(str4);
            wlVar.Vv(str5);
        }
        chVar.bJF.bJM = i2;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        return chVar.bJF.bJL;
    }

    public int doFav(Intent intent, int i) {
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", new Object[]{intent, Integer.valueOf(i)});
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavMM(Intent intent, int i) {
        ch chVar = new ch();
        ((com.tencent.mm.plugin.fav.a.ad) g.l(com.tencent.mm.plugin.fav.a.ad.class)).a(chVar, intent);
        chVar.bJF.bJM = i;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        return chVar.bJF.bJL;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(ad.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
    }

    @f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, a aVar) {
        this.nmm.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", new Object[]{Long.valueOf(r0), str, str2, str3});
    }

    @f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str, str2, str3);
        this.nmn.put(cVar, Long.valueOf(j));
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j, String str) {
        a aVar = (a) this.nmm.remove(Long.valueOf(j));
        if (aVar != null && !bi.oW(str)) {
            aVar.at(str);
        }
    }

    public void doSearchDynamicUpdateScene(String str, a aVar) {
        this.nmm.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[]{Long.valueOf(r0), str});
    }

    @f
    public void doSearchDynamicUpdateSceneMM(long j, String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str);
        this.nmn.put(cVar, Long.valueOf(j));
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        a aVar = (a) this.nmm.remove(Long.valueOf(j));
        if (aVar != null) {
            aVar.e(i, i2, obj);
        }
    }

    public void doAdChannelScene(String str, String str2, a aVar) {
        this.nmm.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doAdChannelSceneMM", new Object[]{Long.valueOf(r0), str, str2});
    }

    @f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2);
        this.nmn.put(aVar, Long.valueOf(j));
        g.Ek();
        g.Eh().dpP.a(aVar, 0);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            x.e("AdLandingPagesProxy", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isApkExistMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        return (yO == null || TextUtils.isEmpty(yO.path) || !new File(yO.path).exists()) ? false : true;
    }

    @f
    public boolean isDownloadingMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        return yO != null && yO.status == 1;
    }

    public boolean isDownloading(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPkgInstalledMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        Context context = ad.getContext();
        return (context == null || TextUtils.isEmpty(str)) ? false : p.r(context, str);
    }

    public boolean isPkgInstalled(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPausedMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        return yO != null && yO.status == 2;
    }

    public boolean isPaused(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.start();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j, int i) {
        x.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.wo(i);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bxj();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bxk();
            this.nmr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bxl();
            this.nmr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bxm();
            this.nmr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.nmr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bxn();
        }
    }

    @f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        c cVar = new c(this, (byte) 0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        com.tencent.mm.plugin.downloader.model.e.a aVar2 = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar2.setAppId(str);
        aVar2.cQ(str2);
        aVar2.yT(str3);
        aVar2.yQ(str4);
        aVar2.yS(str5);
        aVar2.ef(z);
        long a = com.tencent.mm.plugin.downloader.model.d.aCU().a(aVar2.ick);
        aVar.nzL.put(Long.valueOf(a), new WeakReference(cVar));
        aVar.nzM.put(str, new a$b(str6, str7));
        this.nmq.put(Long.valueOf(a), cVar);
        x.v("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[]{Long.valueOf(a)});
        cVar.id = a;
        return a;
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str6, String str7) {
        x.v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7});
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.nmr.put(Long.valueOf(longValue), aVar);
        return longValue;
    }

    @f
    public void stopTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        if (yO != null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(yO.id);
        }
    }

    public void stopTask(String str) {
        REMOTE_CALL("stopTaskMM", new Object[]{str});
    }

    public void stopTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(j);
    }

    public void stopTask(long j) {
        REMOTE_CALL("stopTaskMM", new Object[]{Long.valueOf(j)});
    }

    @f
    public long queryIdByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        return com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
    }

    public long queryIdByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", new Object[]{str});
        return REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
    }

    @f
    public boolean pauseTaskByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        return com.tencent.mm.plugin.downloader.model.d.aCU().cn(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTaskByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskByAppidMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        return com.tencent.mm.plugin.downloader.model.d.aCU().cn(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTask(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        return com.tencent.mm.plugin.downloader.model.d.aCU().cn(j);
    }

    public boolean pauseTask(long j) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", new Object[]{Long.valueOf(j)});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public int getTaskProgressMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        return yO.gTK != 0 ? (int) ((yO.icq * 100) / yO.gTK) : 0;
    }

    public int getTaskProgress(String str) {
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", new Object[]{str});
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        c cVar = new c(this, (byte) 0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        this.nmq.put(Long.valueOf(queryIdByAppid), cVar);
        cVar.id = queryIdByAppid;
        aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        if (yO == null) {
            return false;
        }
        aVar.nzL.put(Long.valueOf(yO.id), new WeakReference(cVar));
        aVar.nzM.put(str, new a$b(str2, str3));
        return com.tencent.mm.plugin.downloader.model.d.aCU().co(yO.id);
    }

    public boolean resumeTask(String str, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str2, String str3) {
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", new Object[]{str, str2, str3});
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.nmr.put(Long.valueOf(queryIdByAppid(str)), aVar);
        }
        return booleanValue;
    }

    @f
    public boolean installAppMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        Context context = ad.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        if (yO == null || yO.status != 3 || TextUtils.isEmpty(yO.path)) {
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(yO.path));
        aVar.I(4, yO.id);
        return com.tencent.mm.pluginsdk.model.app.q.g(context, fromFile);
    }

    public boolean installApp(Context context, String str) {
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", new Object[]{str});
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public void reportDownloadInfoMM(int i, String str, String str2, String str3, String str4) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO.d(i, str, str2, str4);
    }

    public void reportDownloadInfo(int i, String str, String str2, String str3, String str4) {
        REMOTE_CALL("reportDownloadInfoMM", new Object[]{Integer.valueOf(i), str, str2, str3, str4});
    }

    @f
    public void addReportInfoMM(String str, String str2, String str3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c.nzO;
        if (str != null && str.length() != 0) {
            aVar.nzM.put(str, new a$b(str2, str3));
        }
    }

    public void addReportInfo(String str, String str2, String str3) {
        REMOTE_CALL("addReportInfoMM", new Object[]{str, str2, str3});
    }

    public void writeDeferredDeepLink(String str, String str2) {
        REMOTE_CALL("writeDeferredDeepLinkMM", new Object[]{str, str2});
    }

    @f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        bxh().edit().putString(str, str2).commit();
    }

    public void deleteDeferredDeepLink(String str) {
        REMOTE_CALL("deleteDeferredDeepLinkMM", new Object[]{str});
    }

    @f
    public void deleteDeferredDeepLinkMM(String str) {
        bxh().edit().remove(str).commit();
    }

    private static SharedPreferences bxh() {
        return ad.getContext().getSharedPreferences(ad.getPackageName() + "_comm_preferences", 0);
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j, String str) {
        REMOTE_CALL("addCanvasCacheMM", new Object[]{Long.valueOf(j), str});
    }

    @f
    public void addCanvasCacheMM(long j, String str) {
        i.bAE().p(j, str);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        REMOTE_CALL("asyncCacheXmlMM", new Object[]{str});
    }

    @f
    public void asyncCacheXmlMM(String str) {
        g.Ek();
        g.Em().h(new 2(this, str), 5000);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        return ((Integer) REMOTE_CALL("getAdVoteIndexMM", new Object[]{str, str2, str3})).intValue();
    }

    @f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        return v.ae(str, str2, str3);
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        return (String) REMOTE_CALL("getAdVoteInfoMM", new Object[]{str, str2, str3});
    }

    @f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        return v.af(str, str2, str3);
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i, int i2) {
        REMOTE_CALL("saveAdVoteInfoMM", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i, int i2) {
        v.g(str, str2, str3, i, i2);
    }

    public void doFavOfficialItemScene(String str, a aVar) {
        if (bi.oW(str)) {
            x.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            return;
        }
        this.nmm.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doFavOfficialItemSceneMM", new Object[]{Long.valueOf(r0), str});
    }

    @f
    public void doFavOfficialItemSceneMM(long j, String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str);
        this.nmn.put(bVar, Long.valueOf(j));
        g.Ek();
        g.Eh().dpP.a(bVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onFavOfficialItemEnd(long j, String str, int i, int i2) {
        a aVar = (a) this.nmm.remove(Long.valueOf(j));
        if (i == 0 && i2 == 0) {
            x.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[]{str});
        } else {
            x.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        if (aVar != null) {
            aVar.e(i, i2, null);
        }
    }

    public String getSnsAdCanvasExtXml(String str) {
        return (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", new Object[]{str});
    }

    @f
    public String getSnsAdCanvasExtXmlMM(String str) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            return Nk.bAH().nyl;
        }
        return "";
    }

    public void doCgiReportCanvasBrowseInfo(int i, String str) {
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", new Object[]{Integer.valueOf(i), str});
    }

    @f
    public void doCgiReportCanvasBrowseInfoMM(int i, String str) {
        apz apz = new apz();
        apz.rSt = i;
        apz.rSB = (int) (System.currentTimeMillis() / 1000);
        apz.hbF = 1;
        apz.rSu = new com.tencent.mm.bk.b(str.getBytes());
        List arrayList = new ArrayList();
        arrayList.add(apz);
        com.tencent.mm.plugin.sns.a.b.e eVar = new com.tencent.mm.plugin.sns.a.b.e(arrayList);
        g.Ek();
        g.Eh().dpP.a(eVar, 0);
    }

    public void downloadLandingPagesImage(String str, String str2, String str3, d dVar) {
        if (!bi.oW(str) && !bi.oW(str2) && !bi.oW(str3)) {
            if (dVar != null) {
                this.nms.put(str2, dVar);
            }
            REMOTE_CALL("downloadLandingPagesImageMM", new Object[]{str, str2, str3});
        } else if (dVar != null) {
            dVar.bxo();
        }
    }

    @f
    public void downloadLandingPagesImageMM(String str, String str2, String str3) {
        downloadLandingPagesImageMMImpl(str, str2, str3);
    }

    public static void downloadLandingPagesImageMMImpl(String str, String str2, String str3) {
        ate a = com.tencent.mm.modelsns.e.a(str2, 2, str3, str3, 1, 1, "");
        com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(a);
        eVar.nkQ = 3;
        eVar.kJG = a.ksA;
        b byj = af.byj();
        av clT = av.clT();
        clT.time = (int) (System.currentTimeMillis() / 1000);
        af.aRu().post(new 6(byj, a, eVar, clT, str, str2));
    }

    @com.tencent.mm.remoteservice.e
    public void onImgDownloadCallback(String str, boolean z) {
        if (!bi.oW(str)) {
            d dVar = (d) this.nms.remove(str);
            if (dVar == null) {
                return;
            }
            if (z) {
                dVar.bxp();
            } else {
                dVar.bxo();
            }
        }
    }

    public boolean isUseSnsDownloadImage() {
        Object REMOTE_CALL = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isUseSnsDownloadImageMM() {
        nmp.update();
        return nmp.nmv;
    }
}
