package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.a$a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@a(3)
public class CardGiftVideoUI extends MMActivity implements a$a, f.a {
    private k contextMenuHelper;
    int duration = 0;
    private CardGiftInfo hDa;
    private ImageView hDb;
    private ProgressBar hDe;
    private ag hDf = new ag(Looper.getMainLooper());
    private Bundle hDg;
    private boolean hDh = false;
    private com.tencent.mm.ui.tools.f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private boolean hEj;
    private RelativeLayout hEk;
    private f hEl;
    private RelativeLayout hEm;
    private ImageView hEn;
    TextView hEo;
    private MMPinProgressBtn hEp;
    private TextView hEq;
    private al hEr = new al(new 10(this), true);
    private String videoPath;

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.hDg = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        if (com.tencent.mm.booter.a.xt() != null) {
            com.tencent.mm.booter.a.xt().xv();
        }
        this.hDa = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.videoPath = getIntent().getStringExtra("key_video_path");
        this.hEj = getIntent().getBooleanExtra("key_is_mute", false);
        String str = "MicroMsg.CardGiftVideoUI";
        String str2 = "cardGiftInfo %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hDa == null ? "null" : this.hDa.toString();
        x.d(str, str2, objArr);
        x.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[]{this.videoPath, Boolean.valueOf(this.hEj)});
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        ayJ();
        if (this.hDa == null) {
            x.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
        } else if (bi.oW(this.hDa.hvp)) {
            x.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
        } else {
            com.tencent.mm.plugin.card.d.a.g(this.hDa.hvq, this.hDa.hvt, this.hDa.hvC, 2);
            com.tencent.mm.plugin.card.d.a.g(this.hDa.hvp, this.hDa.hvs, this.hDa.hvB, 1);
        }
    }

    private void xJ(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
        } else if (e.cn(str)) {
            this.hEl.setVideoPath(str);
        } else {
            x.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[]{str});
            setResult(0);
            finish();
        }
    }

    private void ayJ() {
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new k(this.mController.tml);
        }
        if (bi.oW(this.videoPath)) {
            x.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
        } else {
            this.contextMenuHelper.a((VideoTextureView) this.hEl, new 1(this), new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            String nX = t.nX(CardGiftVideoUI.this.videoPath);
                            if (bi.oW(nX)) {
                                Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(g.video_file_save_failed), 1).show();
                                return;
                            }
                            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(g.video_file_saved, new Object[]{nX}), 1).show();
                            l.a(nX, CardGiftVideoUI.this);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final void initView() {
        this.hEk = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.video_ui_root);
        this.hEm = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.video_root);
        this.hEn = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.video_thumb);
        this.hEo = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.video_duration);
        this.hEp = (MMPinProgressBtn) findViewById(com.tencent.mm.plugin.card.a.d.video_progress);
        this.hDe = (ProgressBar) findViewById(com.tencent.mm.plugin.card.a.d.video_loading);
        this.hEq = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.video_tips);
        this.hEl = new VideoTextureView(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.hEl.setMute(this.hEj);
        this.hEl.setVideoCallback(this);
        this.hEm.addView((View) this.hEl, layoutParams);
        this.hDb = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.gallery_bg);
        this.hDb.setLayerType(2, null);
        this.hEk.setOnTouchListener(new 6(this));
        ((View) this.hEl).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CardGiftVideoUI.this.ayH();
            }
        });
        this.hDi = new com.tencent.mm.ui.tools.f(this);
    }

    public void onStart() {
        Bundle bundle = this.hDg;
        if (!this.hDh) {
            this.hDh = true;
            if (VERSION.SDK_INT < 12) {
                x.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.hDj = getIntent().getIntExtra("img_top", 0);
                this.hDk = getIntent().getIntExtra("img_left", 0);
                this.hDl = getIntent().getIntExtra("img_width", 0);
                this.hDm = getIntent().getIntExtra("img_height", 0);
                this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
                if (bundle == null) {
                    this.hEk.getViewTreeObserver().addOnPreDrawListener(new 8(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (!bi.oW(this.videoPath)) {
            xJ(this.videoPath);
        }
        super.onResume();
    }

    protected void onPause() {
        this.hEl.pause();
        super.onPause();
    }

    protected void onDestroy() {
        this.hEl.stop();
        this.hEr.SO();
        com.tencent.mm.plugin.card.d.a.b(this);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
        ayH();
        return true;
    }

    public final void ayH() {
        this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
        this.hDi.a(this.hEk, this.hDb, new 9(this), null);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_gift_video_ui;
    }

    public final void onError(int i, int i2) {
        setResult(0);
        this.hEl.stop();
        x.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void iy() {
        setResult(-1);
        this.hDf.post(new Runnable() {
            final /* synthetic */ boolean hEu = true;

            public final void run() {
                x.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[]{Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.hEu)});
                if (this.hEu) {
                    ((View) CardGiftVideoUI.this.hEl).setVisibility(0);
                    CardGiftVideoUI.this.hEn.setVisibility(8);
                    return;
                }
                ((View) CardGiftVideoUI.this.hEl).setVisibility(8);
                CardGiftVideoUI.this.hEn.setVisibility(0);
            }
        });
        this.hDf.post(new 12(this));
        this.hEl.start();
        this.duration = this.hEl.getDuration() / 1000;
        this.hEr.J(500, 500);
        x.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[]{Integer.valueOf(this.duration)});
    }

    public final void wd() {
        x.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        this.hEl.x(0.0d);
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public final void aY(String str, int i) {
        if (str.equals(this.hDa.hvp)) {
            this.hDf.post(new 2(this, i));
        }
    }

    public final void fail(String str) {
    }

    public final void cf(String str, final String str2) {
        if (str.equals(this.hDa.hvp)) {
            this.hDf.post(new Runnable() {
                public final void run() {
                    CardGiftVideoUI.this.hEn.setVisibility(8);
                    CardGiftVideoUI.this.videoPath = str2;
                    CardGiftVideoUI.this.xJ(CardGiftVideoUI.this.videoPath);
                    CardGiftVideoUI.this.ayJ();
                }
            });
        } else if (str.equals(this.hDa.hvq)) {
            this.hDf.post(new 4(this, str2));
        } else {
            x.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[]{str});
        }
    }
}
