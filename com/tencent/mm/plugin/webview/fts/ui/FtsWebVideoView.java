package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView extends RelativeLayout {
    private boolean acT;
    private boolean gaA;
    private boolean gaD;
    private boolean gaE;
    private int gaF;
    private String gaG;
    private TextView gal;
    private LinearLayout gar;
    private TextView gat;
    private ImageView gau;
    private ImageView gav;
    private String gaw;
    private int gax;
    private boolean gay;
    public boolean hEj;
    private String mAppId;
    private boolean mAutoPlay;
    private ImageView oBq;
    private ImageView pNm;
    private b pQe = b.AUTO;
    public FtsVideoWrapper pQf;
    public WebSearchWebVideoViewControlBar pQg;
    private View pQh;
    private View pQi;
    private WebSearchDotPercentIndicator pQj;
    private View pQk;
    private Button pQl;
    private TextView pQm;
    private TextView pQn;
    private boolean pQo;
    private a pQp;
    private a pQq;
    private d pQr;
    private a pQs;
    private int pQt;
    private boolean pQu;
    private long pQv;
    private View pQw;
    private View pQx;
    private int pQy = c.pQF;
    public BroadcastReceiver pQz = new 10(this);
    private String url;

    private enum b {
        AUTO,
        LANDSCAPE,
        PORTRAIT
    }

    static /* synthetic */ void q(FtsWebVideoView ftsWebVideoView) {
        ftsWebVideoView.pQh.setVisibility(0);
        ftsWebVideoView.pQi.setVisibility(8);
        ftsWebVideoView.pQk.setVisibility(0);
        ftsWebVideoView.bTO();
    }

    static /* synthetic */ void v(FtsWebVideoView ftsWebVideoView) {
        ftsWebVideoView.hEj = !ftsWebVideoView.hEj;
        ftsWebVideoView.pQf.setMute(ftsWebVideoView.hEj);
        if (ftsWebVideoView.hEj) {
            ftsWebVideoView.pQg.Bo();
        } else {
            ftsWebVideoView.pQg.bTu();
        }
    }

    public FtsWebVideoView(Context context, boolean z) {
        super(context);
        setAutoPlay(z);
        init(context);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.i.fts_web_video_container, this);
        this.pQf = (FtsVideoWrapper) findViewById(R.h.video_view);
        this.gal = (TextView) findViewById(R.h.progress);
        this.pQh = findViewById(R.h.tip_cover_area);
        this.pQi = findViewById(R.h.tips_container);
        this.gar = (LinearLayout) findViewById(R.h.adjust_info_layout);
        this.pQj = (WebSearchDotPercentIndicator) findViewById(R.h.adjust_percent_indicator);
        this.gat = (TextView) findViewById(R.h.adjust_content);
        this.gau = (ImageView) findViewById(R.h.adjust_icon);
        this.gav = (ImageView) findViewById(R.h.cover);
        this.pQw = findViewById(R.h.video_loading);
        this.pQx = findViewById(R.h.tips_container_op);
        this.pQj.setDotsNum(8);
        this.oBq = (ImageView) findViewById(R.h.cover_area_play_btn);
        this.pQk = findViewById(R.h.cover_replay);
        this.pQm = (TextView) findViewById(R.h.tip_cover_cancel);
        this.pQl = (Button) findViewById(R.h.tip_cover_paly);
        this.pQn = (TextView) findViewById(R.h.tip_cover_warning);
        this.pNm = (ImageView) findViewById(R.h.exit_fullscreen_btn);
        this.pQm.setOnClickListener(new 1(this));
        this.pNm.setOnClickListener(new 7(this));
        this.pQl.setOnClickListener(new 8(this));
        this.pQk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FtsWebVideoView.this.jS(true);
                FtsWebVideoView.this.pQg.bTw();
            }
        });
        this.pQp = new a(getContext(), this, new 12(this));
        this.pQf.setIMMVideoViewCallback(new 13(this));
        this.pQg = new WebSearchWebVideoViewControlBar(getContext());
        this.pQg.setVisibility(8);
        this.pQg.setEnterFullScreenBtnClickListener(new 14(this));
        this.pQg.setExitFullScreenBtnClickListener(new 2(this));
        this.pQg.setMuteBtnOnClickListener(new 3(this));
        this.pQg.setIplaySeekCallback(new 4(this));
        this.pQg.setOnPlayButtonClickListener(new 5(this));
        this.pQg.setStatePorter(new WebSearchWebVideoViewControlBar.a() {
            public final int ajH() {
                return FtsWebVideoView.this.pQf.getCacheTimeSec();
            }

            public final int ajI() {
                return FtsWebVideoView.this.pQf.getVideoDurationSec();
            }

            public final int bIw() {
                return FtsWebVideoView.this.pQf.getCurrPosMs();
            }
        });
        this.pQf.setVideoFooterView(this.pQg);
        context.registerReceiver(this.pQz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        bTP();
    }

    private boolean ew(Context context) {
        int i = this.pQy;
        if (ao.isConnected(context)) {
            if (this.pQu || ao.isWifi(context)) {
                return true;
            }
            pause();
            this.pQy = c.pQG;
            this.pQg.setVisibility(8);
            String netUnavailableTip = getNetUnavailableTip();
            String string = context.getString(R.l.video_continue_play);
            context.getString(R.l.video_cancel);
            fm(netUnavailableTip, string);
            return false;
        } else if (i == c.pQH) {
            this.pQw.setVisibility(0);
            this.pQx.setVisibility(8);
            this.pQh.setVisibility(0);
            postDelayed(new 11(this, context), 200);
            return false;
        } else {
            ex(context);
            return false;
        }
    }

    private void ex(Context context) {
        this.pQy = c.pQH;
        pause();
        fm(context.getString(R.l.video_net_disable_warnning), context.getString(R.l.video_retry_play));
    }

    private String getNetUnavailableTip() {
        if (this.pQt == 0) {
            return getContext().getString(R.l.video_net_warnning_no_size);
        }
        String str;
        Context context = getContext();
        int i = R.l.video_net_warnning;
        Object[] objArr = new Object[1];
        long j = (long) this.pQt;
        if (j < 0) {
            str = "";
        } else {
            BigDecimal bigDecimal = new BigDecimal(j);
            float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
            if (floatValue > 1.0f) {
                str = ((int) floatValue) + "M";
            } else {
                str = ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
            }
        }
        objArr[0] = str;
        return context.getString(i, objArr);
    }

    private void fm(String str, String str2) {
        bTP();
        this.pQw.setVisibility(8);
        this.pQx.setVisibility(0);
        this.pQg.setVisibility(8);
        this.pQh.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.pQn.setVisibility(8);
        } else {
            this.pQn.setText(str);
            this.pQn.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.pQl.setVisibility(8);
        } else {
            this.pQl.setText(str2);
            this.pQl.setVisibility(0);
        }
        this.pQi.setVisibility(0);
        this.pQk.setVisibility(8);
        this.pQm.setVisibility(8);
        bTO();
    }

    private void bTO() {
        if (ajE()) {
            this.pNm.setVisibility(0);
        } else {
            this.pNm.setVisibility(8);
        }
    }

    public void setAppId(String str) {
        x.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[]{str});
        this.mAppId = str;
    }

    public void setVideoPlayerId(int i) {
        this.gax = i;
    }

    public int getmVideoPlayerId() {
        return this.gax;
    }

    public void setAutoPlay(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(z)});
        this.mAutoPlay = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            x.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public void setLoop(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[]{Boolean.valueOf(z)});
        this.gaE = z;
    }

    public final void jS(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "start");
        bTP();
        if (!z || ew(getContext())) {
            this.pQy = c.pQF;
            if (!this.pQf.isPlaying()) {
                if (this.gay) {
                    this.pQg.bTx();
                }
                this.pQf.start();
                if (this.pQv == 0) {
                    this.pQv = System.currentTimeMillis();
                    return;
                } else {
                    this.pQv = Long.MAX_VALUE;
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
    }

    private void bTP() {
        this.pQh.setVisibility(8);
    }

    public final void pause() {
        x.i("MicroMsg.FtsWebVideoView", "pause");
        bTP();
        if (this.pQf.isPlaying()) {
            this.pQf.pause();
        }
    }

    public final void stop() {
        x.i("MicroMsg.FtsWebVideoView", "stop");
        if (this.pQf.isPlaying()) {
            this.pQf.stop();
            this.pQg.bTy();
        }
    }

    public final void cv(String str, int i) {
        x.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[]{str, Boolean.valueOf(false)});
        this.url = str;
        if (bi.oW(str)) {
            x.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
            return;
        }
        stop();
        this.gaD = false;
        this.pQf.c(false, str, i);
        if (this.pQg != null) {
            this.pQg.setVideoTotalTime(i);
        }
        if (this.gaF > 0) {
            this.pQf.kW(this.gaF);
        }
        if (this.mAutoPlay) {
            x.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
            jS(false);
        }
        if (str.startsWith("wxfile://")) {
            setCover(str);
        }
    }

    public final void C(int i, boolean z) {
        int currPosSec = this.pQf.getCurrPosSec();
        x.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[]{Integer.valueOf(i), Integer.valueOf(currPosSec), Boolean.valueOf(this.gaD)});
        if (!ajG()) {
            if (z) {
                this.pQf.x(i, z);
            } else {
                this.pQf.kW(i);
            }
        }
    }

    public void setIsShowBasicControls(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[]{Boolean.valueOf(z)});
        this.gay = z;
    }

    public final void setCover$16da05f7(String str) {
        x.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[]{str});
        if (!bi.oW(str)) {
            this.gaG = str;
            com.tencent.mm.modelappbrand.b.b.Ka().a(this.gav, str, null, null);
        }
    }

    private void setCover(String str) {
        if (!bi.oW(str) && !bi.oW(this.gaG)) {
            x.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
        }
    }

    public void setObjectFit(String str) {
        x.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[]{str});
        if ("fill".equalsIgnoreCase(str)) {
            this.pQf.setScaleType(h.d.qFz);
            this.gav.setScaleType(ScaleType.FIT_XY);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.pQf.setScaleType(h.d.qFB);
            this.gav.setScaleType(ScaleType.CENTER_CROP);
        } else {
            this.pQf.setScaleType(h.d.qFA);
            this.gav.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public void setMute(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.hEj = z;
        this.pQf.setMute(z);
        if (z) {
            this.pQg.Bo();
        } else {
            this.pQg.bTu();
        }
    }

    public void setCookieData(String str) {
        this.gaw = str;
    }

    public String getCookieData() {
        return this.gaw;
    }

    public int getCurrPosSec() {
        return this.pQf.getCurrPosSec();
    }

    public int getCurrPosMs() {
        return this.pQf.getCurrPosMs();
    }

    public void setFullScreenDirection(String str) {
        x.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[]{str});
        if ("horizontal".equalsIgnoreCase(str)) {
            this.pQe = b.LANDSCAPE;
        } else if ("vertical".equalsIgnoreCase(str)) {
            this.pQe = b.PORTRAIT;
        } else {
            this.pQe = b.AUTO;
        }
    }

    public void setDisableScroll(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[]{Boolean.valueOf(z)});
        this.pQo = z;
    }

    public void setPageGesture(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[]{Boolean.valueOf(z)});
        this.gaA = z;
    }

    public void setInitialTime(int i) {
        x.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[]{Integer.valueOf(i)});
        this.gaF = i;
    }

    public void setCallback(d dVar) {
        this.pQr = dVar;
    }

    public void setFullScreenDelegate(a aVar) {
        this.pQq = aVar;
    }

    public d getCallback() {
        return this.pQr;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gaA || ajE()) {
            if (this.pQp != null) {
                a aVar = this.pQp;
                if (aVar.pPX.bHY()) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        aVar.gbz = motionEvent.getRawX();
                        aVar.gby = ((AudioManager) aVar.mContext.getSystemService("audio")).getStreamVolume(3);
                        aVar.fHh = c.cA(aVar.mContext);
                    }
                    aVar.gbw.onTouchEvent(motionEvent);
                    if (actionMasked == 1 || actionMasked == 3) {
                        if (aVar.pPW == a.a.pQc) {
                            aVar.pPX.f(aVar.gbB, motionEvent.getRawX() - aVar.gbz);
                            aVar.gbA = -1;
                            aVar.gbB = 0;
                            aVar.gbz = 0.0f;
                        } else if (aVar.pPW == a.a.pQa) {
                            ((AudioManager) aVar.mContext.getSystemService("audio")).getStreamMaxVolume(3);
                            aVar.pPX.ajM();
                        } else if (aVar.pPW == a.a.pQb) {
                            aVar.pPX.ajN();
                        }
                    }
                }
                aVar.pPW = a.a.pPZ;
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && bTQ()) {
            this.pQg.jR(this.acT);
        }
        return super.onTouchEvent(motionEvent);
    }

    public int getSystemVolume() {
        return ((AudioManager) getContext().getSystemService("audio")).getStreamVolume(3);
    }

    private boolean bTQ() {
        return this.gay && !bTR();
    }

    private boolean bTR() {
        return this.pQh.getVisibility() == 0;
    }

    public final void jT(boolean z) {
        boolean z2 = false;
        x.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[]{Boolean.valueOf(z)});
        if (this.pQq == null) {
            x.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == ajE()) {
            x.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
        } else if (z) {
            a aVar = this.pQq;
            if (this.pQe != b.PORTRAIT) {
                z2 = true;
            }
            aVar.jU(z2);
            this.pQg.bIz();
            cV(true);
        } else {
            this.pQq.ajc();
            this.pQg.ajc();
        }
    }

    public void setAllowMobileNetPlay(boolean z) {
        this.pQu = z;
    }

    public final boolean ajE() {
        if (this.pQq != null) {
            return this.pQq.isFullScreen();
        }
        x.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    public final void cV(boolean z) {
        if (this.pQr != null) {
            Object obj = this.pQe == b.PORTRAIT ? "vertical" : "horizontal";
            d dVar = this.pQr;
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[]{Integer.valueOf(this.gax), Boolean.valueOf(z), obj});
                JSONObject aka = dVar.aka();
                aka.put("fullScreen", z);
                aka.put("direction", obj);
                dVar.ao(dVar.a(5, aka));
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[]{e});
            }
            bTO();
        }
    }

    private boolean ajG() {
        x.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[]{Boolean.valueOf(this.gaD), Boolean.valueOf(this.pQf.ajG())});
        if (this.gaD || this.pQf.ajG()) {
            return true;
        }
        return false;
    }

    public a getUiLifecycleListener() {
        return this.pQs;
    }

    public void setUiLifecycleListener(a aVar) {
        this.pQs = aVar;
    }

    public int getVideoSizeByte() {
        return this.pQt;
    }

    public void setVideoSizeByte(int i) {
        this.pQt = i;
    }
}
