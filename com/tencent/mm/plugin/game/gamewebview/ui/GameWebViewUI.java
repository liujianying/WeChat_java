package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.a;
import com.tencent.mm.plugin.game.model.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.model.GameWebViewLaunchParams;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class GameWebViewUI extends MMActivity {
    protected c jIE;
    protected int jKA = -1;
    private boolean jKB;
    private boolean jKC;
    GameSettingParams jKD;

    static /* synthetic */ void a(GameWebViewUI gameWebViewUI) {
        b bVar = (b) gameWebViewUI.jIE.jII.peek();
        if (bVar != null) {
            bVar.jGU.aSR();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameWebViewUI", "onCreate");
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        final CommonLogicTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 10;
        commonLogicTask.jGe = new Runnable() {
            public final void run() {
                commonLogicTask.ahB();
                commonLogicTask.jfZ.setClassLoader(GameSettingParams.class.getClassLoader());
                GameWebViewUI.this.jKD = (GameSettingParams) commonLogicTask.jfZ.getParcelable("game_setting_params");
                GameWebViewUI.a(GameWebViewUI.this);
            }
        };
        commonLogicTask.ahA();
        GameWebViewMainProcessService.a(commonLogicTask);
        this.jKB = getIntent().getBooleanExtra("disable_swipe_back", false);
        initView();
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.GameWebViewUI", "onNewIntent: " + System.currentTimeMillis());
        d(intent, false);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.GameWebViewUI", "onResume");
        if (getSwipeBackLayout() != null) {
            if (this.jKB) {
                getSwipeBackLayout().setEnableGesture(false);
            } else {
                getSwipeBackLayout().setEnableGesture(this.jKC);
            }
        }
        ahy();
        b bVar = (b) this.jIE.jII.peek();
        if (bVar != null) {
            bVar.agE();
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.GameWebViewUI", "onPause");
        b bVar = (b) this.jIE.jII.peek();
        if (bVar != null) {
            bVar.fo(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.GameWebViewUI", "onDestroy");
        a.cleanup();
        this.jIE.cleanup();
        System.gc();
    }

    protected void initView() {
        View frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(17170443);
        frameLayout.setId(R.h.game_btn_container);
        setContentView(frameLayout);
        this.jIE = new c(this);
        this.jIE.setBackgroundResource(17170443);
        this.jIE.setId(R.h.game_container);
        frameLayout.addView(this.jIE);
        d(getIntent(), true);
    }

    private void d(Intent intent, boolean z) {
        x.d("MicroMsg.GameWebViewUI", "loadIntent: " + System.currentTimeMillis());
        setIntent(intent);
        this.jIE.c(intent, z);
        this.jKA = intent.getIntExtra("screen_orientation", -1);
        intent.setExtrasClassLoader(GameWebViewLaunchParams.class.getClassLoader());
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) intent.getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            final GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.jOv;
            if (gameFloatLayerInfo != null) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", gameFloatLayerInfo.url);
                        intent.putExtra("show_full_screen", gameFloatLayerInfo.jMc);
                        intent.putExtra("screen_orientation", gameFloatLayerInfo.orientation);
                        intent.putExtra("transparent_page", true);
                        intent.putExtra("needAnimation", false);
                        GameWebViewUI.this.d(intent, false);
                    }
                }, 200);
            }
        }
        if (aTt()) {
            d.do(this.mController.tml);
        } else {
            d.dp(this.mController.tml);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        this.jIE.fp(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jIE.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jIE != null) {
            Object obj;
            b bVar = (b) this.jIE.jII.peek();
            if (bVar != null) {
                d pageView = bVar.getPageView();
                if (pageView.jJr == null || !pageView.jJr.b(pageView.jIJ, i, i2, intent)) {
                    if (pageView.jIU != null) {
                        e eVar = pageView.jIU;
                        if (eVar.jKe != null ? eVar.jKe.onActivityResult(i, i2, intent) : false) {
                            int obj2 = 1;
                        }
                    }
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
            }
        }
    }

    public final void L(final Intent intent) {
        runOnUiThread(new Runnable() {
            public final void run() {
                GameWebViewUI.this.d(intent, false);
            }
        });
    }

    public final void qO(int i) {
        if (!this.jKB && getSwipeBackLayout() != null) {
            if (aTt() || i > 1) {
                this.jKC = false;
                getSwipeBackLayout().setEnableGesture(false);
                return;
            }
            this.jKC = true;
            getSwipeBackLayout().setEnableGesture(true);
        }
    }

    private boolean aTt() {
        return getIntent().getBooleanExtra("from_shortcut", false);
    }

    protected final void ahy() {
        if (this.jKA != -1) {
            setRequestedOrientation(this.jKA);
            return;
        }
        this.tlM = getSharedPreferences(ad.chY(), 4).getBoolean("settings_landscape_mode", false);
        if (this.tlM) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    public final void qP(int i) {
        this.jKA = i;
        ahy();
    }
}
