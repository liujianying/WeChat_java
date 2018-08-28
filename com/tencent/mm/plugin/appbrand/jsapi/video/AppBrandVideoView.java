package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private int fRD;
    private boolean gaA;
    private f gaB;
    private a gaC;
    private boolean gaD;
    private boolean gaE;
    private int gaF;
    private String gaG;
    private boolean gaH;
    private boolean gaI;
    private boolean gaJ;
    private boolean gaK;
    private boolean gaL;
    private int gaj = -1;
    AppBrandVideoWrapper gak;
    private TextView gal;
    private DanmuView gam;
    AppBrandVideoViewControlBar gan;
    private View gao;
    private View gap;
    private TextView gaq;
    private LinearLayout gar;
    private AppBrandDotPercentIndicator gas;
    private TextView gat;
    private ImageView gau;
    private ImageView gav;
    private String gaw;
    private int gax;
    private boolean gay;
    e gaz;
    private String mAppId;
    private boolean mAutoPlay;
    private int mDuration;

    static /* synthetic */ boolean h(AppBrandVideoView appBrandVideoView) {
        return appBrandVideoView.gaI && !appBrandVideoView.gak.ajG();
    }

    public AppBrandVideoView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(h.app_brand_video_container, this);
        this.gak = (AppBrandVideoWrapper) findViewById(g.video_view);
        this.gal = (TextView) findViewById(g.progress);
        this.gao = findViewById(g.cover_area);
        this.gap = findViewById(g.cover_play_btn_area);
        this.gaq = (TextView) findViewById(g.cover_total_time);
        this.gar = (LinearLayout) findViewById(g.adjust_info_layout);
        this.gas = (AppBrandDotPercentIndicator) findViewById(g.adjust_percent_indicator);
        this.gat = (TextView) findViewById(g.adjust_content);
        this.gau = (ImageView) findViewById(g.adjust_icon);
        this.gav = (ImageView) findViewById(g.cover);
        this.gas.setDotsNum(8);
        ((ImageView) findViewById(g.cover_play_btn)).setOnClickListener(new 1(this));
        this.gaB = new f(getContext(), this, new 5(this));
        this.gak.setIMMVideoViewCallback(new 6(this));
        this.gan = new AppBrandVideoViewControlBar(getContext());
        this.gan.setVisibility(8);
        this.gan.setFullScreenBtnOnClickListener(new 8(this));
        this.gan.setIplaySeekCallback(new b() {
            public final void ajO() {
                x.i("MicroMsg.AppBrandVideoView", "onSeekPre");
            }

            public final void kV(int i) {
                AppBrandVideoView.this.C(i, false);
            }
        });
        this.gan.setOnPlayButtonClickListener(new 10(this));
        this.gan.setStatePorter(new 2(this));
        this.gak.setVideoFooterView(this.gan);
    }

    public void setAppId(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setAppId appid=%s", new Object[]{str});
        this.mAppId = str;
    }

    public void setIsGame(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setIsGame game=%s", new Object[]{Boolean.valueOf(z)});
        this.gaH = z;
    }

    public void setVideoPlayerId(int i) {
        this.gax = i;
    }

    public void setAutoPlay(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(z)});
        this.mAutoPlay = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            x.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i)});
            return;
        }
        this.gaq.setText(kS(i));
        this.mDuration = i;
    }

    public int getDuration() {
        return this.mDuration > 0 ? this.mDuration : this.gak.getVideoDurationSec();
    }

    public void setLoop(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", new Object[]{Boolean.valueOf(z)});
        this.gaE = z;
    }

    public final void start() {
        x.i("MicroMsg.AppBrandVideoView", "start");
        if (!this.gak.isPlaying()) {
            if (this.gay) {
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
                if (appBrandVideoViewControlBar.gaX == null) {
                    appBrandVideoViewControlBar.gaX = new al(new 3(appBrandVideoViewControlBar), true);
                }
                appBrandVideoViewControlBar.ajU();
                appBrandVideoViewControlBar.gaX.SO();
                appBrandVideoViewControlBar.gaX.J(500, 500);
            }
            this.gao.setVisibility(8);
            this.gak.start();
            if (this.gam != null && this.gan.gaZ) {
                this.gam.show();
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.AppBrandVideoView", "pause");
        if (this.gak.isPlaying()) {
            this.gak.pause();
            if (this.gam != null && this.gan.gaZ) {
                this.gam.pause();
            }
        }
    }

    public final void stop() {
        x.i("MicroMsg.AppBrandVideoView", "stop");
        if (this.gak.isPlaying()) {
            this.gak.stop();
            AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
            if (appBrandVideoViewControlBar.gaX != null) {
                appBrandVideoViewControlBar.gaX.SO();
            }
            if (this.gam != null) {
                this.gam.hide();
            }
        }
    }

    public final void clean() {
        x.i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.gak.ajZ();
        if (this.gam != null) {
            DanmuView danmuView = this.gam;
            danmuView.status = 3;
            danmuView.akk();
            danmuView.gcf.clear();
            danmuView.invalidate();
        }
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
        if (appBrandVideoViewControlBar.gaX != null) {
            appBrandVideoViewControlBar.gaX.SO();
        }
        if (appBrandVideoViewControlBar.gaW != null) {
            appBrandVideoViewControlBar.gaW.SO();
        }
    }

    public final void e(String str, boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[]{str, Boolean.valueOf(z)});
        if (bi.oW(str)) {
            x.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            return;
        }
        String str2;
        stop();
        this.gaD = z;
        AppBrandVideoWrapper appBrandVideoWrapper = this.gak;
        if (bi.oW(str)) {
            str2 = str;
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            x.i("MicroMsg.AppBrandVideoView", "convertPath appid=%s path=%s", new Object[]{this.mAppId, str});
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
            if (itemByLocalId == null) {
                x.e("MicroMsg.AppBrandVideoView", "convertPath AppBrandLocalMediaObject null");
                str2 = str;
            } else {
                if (bi.oW(itemByLocalId.dDG)) {
                    x.e("MicroMsg.AppBrandVideoView", "convertPath fileFullPath null");
                    str2 = str;
                } else {
                    str2 = String.format("%s%s", new Object[]{AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX, itemByLocalId.dDG});
                    x.i("MicroMsg.AppBrandVideoView", "convertPath convertedPath=%s", new Object[]{str2});
                }
            }
        } else {
            str2 = str;
        }
        appBrandVideoWrapper.c(z, str2, i);
        if (this.gaF > 0) {
            this.gak.kW(this.gaF);
        }
        if (this.mAutoPlay) {
            x.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
        if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            setCover(str);
        }
    }

    public final void C(int i, boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "seek to position=%d current=%d isLive=%b", new Object[]{Integer.valueOf(i), Integer.valueOf(this.gak.getCurrPosSec()), Boolean.valueOf(this.gaD)});
        if (!ajG()) {
            this.gao.setVisibility(8);
            if (z) {
                this.gak.x(i, z);
            } else {
                this.gak.kW(i);
            }
            if (this.gam != null && r0 > i) {
                DanmuView danmuView = this.gam;
                x.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[]{Integer.valueOf(i)});
                danmuView.aki();
                danmuView.akk();
                danmuView.prepare();
                e.post(new 5(danmuView, i), "DanmuView-seekToPlayTime");
            }
        }
    }

    public void setIsShowBasicControls(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[]{Boolean.valueOf(z)});
        this.gay = z;
    }

    public final void setCover$16da05f7(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", new Object[]{str});
        if (!bi.oW(str)) {
            this.gaG = str;
            com.tencent.mm.modelappbrand.b.b.Ka().a(this.gav, str, null, null);
        }
    }

    private void setCover(String str) {
        if (!bi.oW(str)) {
            if (bi.oW(this.gaG)) {
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
                if (itemByLocalId == null) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover AppBrandLocalMediaObject null");
                    return;
                }
                String str2 = itemByLocalId.dDG;
                if (bi.oW(str2)) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover fileFullPath null");
                    return;
                } else {
                    c.Em().H(new 3(this, str2));
                    return;
                }
            }
            x.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
        }
    }

    public void setShowLiveBtn(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowLiveBtn %b", new Object[]{Boolean.valueOf(z)});
        this.gaK = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
        if (!(z && ajG())) {
            z2 = false;
        }
        appBrandVideoViewControlBar.setShowLiveBtn(z2);
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", new Object[]{Boolean.valueOf(z)});
        this.gaJ = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
        if (!z || ajG()) {
            z2 = false;
        }
        appBrandVideoViewControlBar.setShowProgress(z2);
    }

    public void setShowFullScreenBtn(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[]{Boolean.valueOf(z)});
        this.gan.setShowFullScreenBtn(z);
    }

    public void setShowPlayBtn(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", new Object[]{Boolean.valueOf(z)});
        this.gan.setShowPlayBtn(z);
    }

    public final void cU(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", new Object[]{Boolean.valueOf(z)});
        this.gaI = z;
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[]{Boolean.valueOf(z)});
        this.gaL = z;
        View view = this.gap;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void setDanmakuEnable(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", new Object[]{Boolean.valueOf(z)});
        this.gan.setDanmakuBtnOpen(z);
    }

    public void setShowDanmakuBtn(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.gam == null) {
                ajF();
            }
            this.gan.setDanmakuBtnOnClickListener(new 4(this));
        }
        this.gan.setShowDanmakuBtn(z);
    }

    public void setObjectFit(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", new Object[]{str});
        if ("fill".equalsIgnoreCase(str)) {
            this.gak.setScaleType(d.qFz);
            this.gav.setScaleType(ScaleType.FIT_XY);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.gak.setScaleType(d.qFB);
            this.gav.setScaleType(ScaleType.CENTER_CROP);
        } else {
            this.gak.setScaleType(d.qFA);
            this.gav.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public void setMute(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.gak.setMute(z);
    }

    public void setCookieData(String str) {
        this.gaw = str;
    }

    public String getCookieData() {
        return this.gaw;
    }

    public int getCurrPosSec() {
        return this.gak.getCurrPosSec();
    }

    public int getCurrPosMs() {
        return this.gak.getCurrPosMs();
    }

    public void setFullScreenDirection(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", new Object[]{Integer.valueOf(i)});
        this.gaj = i;
    }

    public void setPageGesture(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", new Object[]{Boolean.valueOf(z)});
        this.gaA = z;
    }

    public void setInitialTime(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%d", new Object[]{Integer.valueOf(i)});
        this.gaF = i;
    }

    public void setCallback(e eVar) {
        this.gaz = eVar;
    }

    public void setDanmakuItemList(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            String str = "MicroMsg.AppBrandVideoView";
            String str2 = "setDanmakuItemList length=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
            x.i(str, str2, objArr);
            if (this.gam == null) {
                x.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
                ajF();
            }
            List arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d v = v(jSONArray.optJSONObject(i));
                if (v != null) {
                    arrayList.add(v);
                }
                i++;
            }
            DanmuView danmuView = this.gam;
            danmuView.aki();
            danmuView.akk();
            danmuView.gcf.clear();
            danmuView.prepare();
            if (arrayList.isEmpty()) {
                danmuView.akj();
                return;
            }
            new 4(danmuView, arrayList).start();
            danmuView.akj();
        }
    }

    public final boolean bt(String str, String str2) {
        int parseColor;
        if (this.gam == null) {
            x.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            ajF();
        }
        try {
            parseColor = Color.parseColor(str2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{str2, e});
            parseColor = getResources().getColor(s.d.white);
        }
        a aVar = new a(getContext(), new SpannableString(str), parseColor, this.gak.getCurrPosSec());
        DanmuView danmuView = this.gam;
        synchronized (danmuView.gce) {
            danmuView.gce.offerFirst(aVar);
            e.post(new DanmuView$3(danmuView, aVar), "DanmuView-addItemToWaitingHead");
        }
        return true;
    }

    private com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int parseColor;
        int optInt = jSONObject.optInt("time", 0);
        CharSequence optString = jSONObject.optString("text", "");
        Object optString2 = jSONObject.optString("color", "");
        try {
            parseColor = Color.parseColor(optString2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{optString2, e});
            parseColor = getResources().getColor(s.d.white);
        }
        return new a(getContext(), new SpannableString(optString), parseColor, optInt);
    }

    public void setFullScreenDelegate(a aVar) {
        this.gaC = aVar;
    }

    public e getCallback() {
        return this.gaz;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gaA || ajE()) {
            if (this.gaB != null) {
                f fVar = this.gaB;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    fVar.gbz = motionEvent.getRawX();
                    fVar.gby = ((AudioManager) fVar.mContext.getSystemService("audio")).getStreamVolume(3);
                    fVar.fHh = g.cA(fVar.mContext);
                }
                fVar.gbw.onTouchEvent(motionEvent);
                if (actionMasked == 1 || actionMasked == 3) {
                    if (fVar.gbv == f$a.gbH) {
                        fVar.gbx.f(fVar.gbB, motionEvent.getRawX() - fVar.gbz);
                        fVar.gbA = -1;
                        fVar.gbB = 0;
                        fVar.gbz = 0.0f;
                    } else if (fVar.gbv == f$a.gbF) {
                        ((AudioManager) fVar.mContext.getSystemService("audio")).getStreamMaxVolume(3);
                        fVar.gbx.ajM();
                    } else if (fVar.gbv == f$a.gbG) {
                        fVar.gbx.ajN();
                    }
                    fVar.gbv = f$a.gbE;
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && this.gay && this.gao.getVisibility() != 0) {
            this.gan.ajS();
        }
        if (this.gaH) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void f(boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (this.gaC == null) {
            x.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == ajE()) {
            x.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
        } else {
            int i2;
            if (i == -1) {
                i2 = this.gaj == -1 ? 90 : this.gaj;
                x.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[]{Integer.valueOf(i2)});
            } else {
                i2 = i;
            }
            if (z) {
                this.fRD = i2;
                this.gaC.kM(i2);
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.gan;
                appBrandVideoViewControlBar.gaY = true;
                appBrandVideoViewControlBar.ajT();
                cV(true);
                return;
            }
            this.gaC.ajc();
            this.gan.ajc();
        }
    }

    public final boolean ajE() {
        if (this.gaC != null) {
            return this.gaC.isFullScreen();
        }
        x.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    private void ajF() {
        this.gam = (DanmuView) findViewById(g.danmaku_view);
        this.gam.setDanmuViewCallBack(new 7(this));
        DanmuView danmuView = this.gam;
        danmuView.gbY = 0.0f;
        danmuView.gbZ = 0.8f;
        this.gam.setMaxRunningPerRow(5);
        this.gam.setPickItemInterval(200);
        this.gam.hide();
        if (this.gak != null && this.gak.getHeight() > 0) {
            int yOffset = (int) (this.gam.getYOffset() * ((float) this.gak.getHeight()));
            this.gam.setMaxRow((int) (((float) yOffset) / com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.cB(getContext())));
        }
    }

    private static String kS(int i) {
        return kT(i / 60) + ":" + kT(i % 60);
    }

    private static String kT(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    final void cV(boolean z) {
        if (this.gaz != null) {
            e eVar = this.gaz;
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[]{Integer.valueOf(this.gax), Boolean.valueOf(z), Integer.valueOf(this.fRD)});
                JSONObject aka = eVar.aka();
                aka.put("fullScreen", z);
                aka.put("videoPlayerId", r1);
                aka.put("direction", r2);
                eVar.a(new d(), aka);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[]{e});
            }
        }
    }

    private boolean ajG() {
        x.i("MicroMsg.AppBrandVideoView", "isLive %b %b", new Object[]{Boolean.valueOf(this.gaD), Boolean.valueOf(this.gak.ajG())});
        if (this.gaD || this.gak.ajG()) {
            return true;
        }
        return false;
    }
}
