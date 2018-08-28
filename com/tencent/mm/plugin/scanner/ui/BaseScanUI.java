package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.i.2;
import com.tencent.mm.plugin.scanner.ui.i.3;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.1;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, b {
    private int bJM = 0;
    private final Object dMd = new Object();
    private boolean eLU = true;
    private int[] eRw = new int[8];
    private boolean iTc = false;
    private boolean lAO = false;
    private final long mGX = 150;
    private final int mGY = 2;
    private MMTextureView mGZ;
    private TranslateAnimation mHA;
    private ImageView mHB;
    private i mHC;
    private int mHD = 0;
    private boolean mHE = false;
    private long mHF;
    private long mHG;
    private int mHH;
    private n mHI = new 1(this);
    protected ag mHJ = new 2(this);
    private final int mHK = 2600;
    protected ag mHL = new 6(this);
    protected ag mHM = new 7(this);
    private c mHN = new 8(this);
    protected ag mHO = new 9(this);
    protected final int mHP = 0;
    protected final int mHQ = 1;
    protected final int mHR = 2;
    private SurfaceTexture mHa;
    private LinearLayout mHb;
    private TextView mHc;
    private FrameLayout mHd;
    private h mHe;
    private Point mHf;
    private SelectScanModePanel mHg;
    private ScanMaskView mHh = null;
    private ScannerFlashSwitcher mHi;
    private boolean mHj = false;
    private boolean mHk = false;
    private boolean mHl = true;
    private i.a mHm;
    private int mHn;
    private int mHo;
    private int mHp;
    private int mHq;
    private boolean mHr = true;
    private Rect mHs = new Rect();
    private TextView mHt;
    private View mHu;
    private boolean mHv = false;
    private boolean mHw = true;
    private boolean mHx = false;
    private boolean mHy = false;
    private e mHz = null;
    private WakeLock wakeLock = null;

    public final /* bridge */ /* synthetic */ Activity getContext() {
        return this.mController.tml;
    }

    static /* synthetic */ void i(BaseScanUI baseScanUI) {
        x.d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.mHk = true;
        baseScanUI.bsC();
        baseScanUI.overridePendingTransition(0, 0);
    }

    static /* synthetic */ void q(BaseScanUI baseScanUI) {
        if (baseScanUI.mHC != null) {
            baseScanUI.mHd.removeAllViews();
            View.inflate(baseScanUI, baseScanUI.mHC.bsl(), baseScanUI.mHd);
            baseScanUI.mHC.cv(baseScanUI.mHd.getChildAt(0));
            baseScanUI.mHC.bsn();
            i iVar = baseScanUI.mHC;
            View view = baseScanUI.mHd;
            iVar.iEv = new GestureDetector(new 2(iVar));
            view.setOnTouchListener(new 3(iVar));
            baseScanUI.bsw();
        }
    }

    protected final int getLayoutId() {
        if (zf()) {
            x.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            return R.i.scan_base_land;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        return R.i.scan_base;
    }

    protected final int getForceOrientation() {
        if (zf()) {
            x.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            return 0;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        return 1;
    }

    public void onCreate(Bundle bundle) {
        this.mHD = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        super.onCreate(bundle);
        s.initLanguage(this);
        getWindow().addFlags(2097280);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
            this.mHl = true;
        } else {
            this.mHl = false;
        }
        if (7 == this.mHD || 11 == this.mHD) {
            this.mHw = false;
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.mHN);
        initView();
        this.mHF = System.currentTimeMillis();
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.mNw;
        try {
            scanCameraLightDetector.mNB = com.tencent.mm.sdk.f.e.Xs("ScanCameraLightDetector_detectThread");
            scanCameraLightDetector.mNB.start();
            scanCameraLightDetector.handler = new 1(scanCameraLightDetector, scanCameraLightDetector.mNB.getLooper());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "start error: %s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", new Object[]{scanCameraLightDetector.ejl, scanCameraLightDetector.mNy, Boolean.valueOf(scanCameraLightDetector.mNz)});
        this.mHF = System.currentTimeMillis();
    }

    protected final void initView() {
        Button button;
        if (zf()) {
            getWindow().setFlags(1024, 1024);
            this.mController.hideTitleView();
            x.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.mHu = findViewById(R.h.scan_no_data_mask);
        this.mHt = (TextView) findViewById(R.h.scan_no_network_tips);
        this.mHb = (LinearLayout) findViewById(R.h.scan_title_btn);
        this.mHc = (TextView) findViewById(R.h.scan_title_btn_bg);
        this.mHd = (FrameLayout) findViewById(R.h.scan_body_fl);
        this.mHi = (ScannerFlashSwitcher) findViewById(R.h.scanner_flash_switcher);
        this.mGZ = (MMTextureView) findViewById(R.h.preview_view);
        this.mGZ.setOpaque(false);
        this.mGZ.setSurfaceTextureListener(this);
        if (7 == this.mHD || 9 == this.mHD || 10 == this.mHD || 11 == this.mHD) {
            button = (Button) findViewById(R.h.scan_bank_ret_btn);
            button.setVisibility(0);
            findViewById(R.h.scan_bottom_ll).setVisibility(8);
            findViewById(R.h.scan_top_ll).setVisibility(8);
            if (9 == this.mHD || 10 == this.mHD) {
                LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(R.h.scan_back_btn);
        }
        if (button != null) {
            button.setOnClickListener(new 12(this));
        } else {
            setBackBtn(new 13(this));
        }
        this.mHB = (ImageView) findViewById(R.h.scan_line);
        this.bJM = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.mHg = (SelectScanModePanel) findViewById(R.h.scan_select_scan_mode_panel);
        this.mHd.setVisibility(0);
        if (!(7 == this.mHD || 9 == this.mHD || 10 == this.mHD || 11 == this.mHD || !zf())) {
            this.mHD = 1;
            this.mHv = true;
        }
        int[] intArrayExtra = getIntent().getIntArrayExtra("key_support_scan_code_type");
        Set hashSet = new HashSet();
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                hashSet.add(Integer.valueOf(valueOf));
            }
        }
        bsx();
        setMMSubTitle(null);
        DisplayMetrics displayMetrics;
        if (this.mHD == 2) {
            this.mHC = new k(this, this.mHf);
            setMMTitle(p.et(p.mOb, getString(R.l.scan_img_title)));
        } else if (this.mHD == 5) {
            this.mHC = new q(this, this.mHf);
            setMMTitle(R.l.scan_entry_street);
            x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), bi.cjd()});
        } else if (this.mHD == 3) {
            this.mHC = new o(this, this.mHf);
            setMMTitle(R.l.scan_entry_ocr);
        } else if (this.mHD == 4 && !zf()) {
            if (hashSet.isEmpty()) {
                this.mHC = new p(this, this.mHf, this.bJM, 2);
            } else {
                this.mHC = new p(this, this.mHf, this.bJM, hashSet);
            }
            ((p) this.mHC).mLp = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.mHg.setVisibility(8);
            setMMTitle(R.l.scan_entry_zbar);
        } else if (this.mHD == 8) {
            if (hashSet.isEmpty()) {
                this.mHC = new p(this, this.mHf, this.bJM, 1);
            } else {
                this.mHC = new p(this, this.mHf, this.bJM, hashSet);
            }
            ((p) this.mHC).mLp = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            this.mHg.setVisibility(8);
            setMMTitle(R.l.scan_entry_qrcode);
        } else if (7 == this.mHD) {
            boolean z;
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mHC = new j(this, this.mHf, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            j jVar = (j) this.mHC;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            jVar.mKx = z;
            setMMTitle(R.l.scan_entry_bankcard);
            this.mHg.setVisibility(8);
        } else if (9 == this.mHD) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mHC = new m(this, this.mHf, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.scan_entry_id_card);
            this.mHg.setVisibility(8);
        } else if (10 == this.mHD) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mHC = new l(this, this.mHf, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.scan_entry_driving_licence);
            this.mHg.setVisibility(8);
        } else if (11 == this.mHD) {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mHC = new n(this, this.mHf, displayMetrics, getWindowManager().getDefaultDisplay().getRotation());
            setMMTitle(R.l.scan_entry_id_card_for_pay_auth);
            this.mHg.setVisibility(8);
        } else {
            this.mHD = 1;
            if (hashSet.isEmpty()) {
                this.mHC = new p(this, this.mHf, this.bJM, zf() ? 1 : 0);
            } else {
                this.mHC = new p(this, this.mHf, this.bJM, hashSet);
            }
            ((p) this.mHC).mLp = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            if (com.tencent.mm.al.b.PC()) {
                this.mHv = true;
                this.mHg.setVisibility(8);
            } else if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false)) {
                this.mHv = false;
                this.mHg.setVisibility(8);
            }
            if (this.mHv) {
                setMMTitle(R.l.scan_entry_qrcode);
            } else {
                setMMTitle(R.l.scan_entry_qrcode_zbar);
            }
        }
        this.mHr = this.mHC.bso();
        this.mHB.setBackgroundResource(this.mHr ? R.g.qrcode_scan_line : R.g.qrcode_scan_line_hor);
        int i = this.mHD;
        if (!(7 == this.mHD || 9 == this.mHD || 10 == this.mHD || 11 == this.mHD)) {
            this.mHg.setOnGridItemClickCallback(new 14(this));
            this.mHg.setSelectedMode(i);
        }
        if (this.mHe != null) {
            this.mHe.vF(this.mHD);
        }
        lF(getResources().getColor(R.e.transparent));
        x.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[]{Integer.valueOf(this.bJM), Integer.valueOf(this.mHD)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        x.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
        this.mHk = true;
        bsC();
        overridePendingTransition(0, 0);
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (!this.mHE) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            this.mHE = true;
        }
        if (this.eLU) {
            x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, null, null))});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, null, null)) {
                bpD();
            } else {
                return;
            }
        }
        if (!this.mHk && (this.mHD == 1 || this.mHD == 8 || this.mHD == 4)) {
            l.mFT.reset();
            l.mFT.vy(l.mFQ);
        }
        m mVar = m.mNW;
        x.i("MicroMsg.ScanStableDetector", "start detect scan stable");
        if (mVar.bgR != null) {
            mVar.mNU = 0;
            mVar.mNT[0] = 0.0f;
            mVar.mNT[1] = 0.0f;
            mVar.mNT[2] = 0.0f;
            x.i("MicroMsg.ScanStableDetector", "register accelerate listener");
            mVar.bgR.registerListener(mVar, mVar.mNS, 50000);
        }
    }

    private void bpD() {
        boolean z = true;
        if (com.tencent.mm.compatible.f.b.zV()) {
            if (!this.mHw || this.mHl) {
                this.mHk = false;
                d(false, 0);
            } else {
                this.mHk = true;
                bsr();
            }
            this.mHy = false;
            synchronized (this.dMd) {
                x.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                int i = this.mHD;
                if (!(7 == this.mHD || 9 == this.mHD || 10 == this.mHD || 11 == this.mHD)) {
                    z = false;
                }
                this.mHe = new h(this, i, z);
                bst();
            }
            if (this.mHC != null) {
                if (this.mHC.bsk() != null) {
                    this.mHC.bsk().bsU();
                }
                this.mHC.onResume();
            }
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
                this.wakeLock.acquire();
            }
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
            if (this.mHw) {
                au.a(this.mHI);
            }
            if (this.mHz != null) {
                this.mHz.onResume();
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(R.l.app_special_no_open_camera_permission), getString(R.l.app_need_camera_title), getString(R.l.app_need_show_settings_button), true, new 15(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.scanner.BaseScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    this.eLU = false;
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 16(this), new 17(this));
                    return;
                }
                bpD();
                return;
            case i$l.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BaseScanUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        x.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[]{this.mHC, this.mHz});
        this.mHk = true;
        m.mNW.stop();
        if (this.mHC != null) {
            this.mHC.onPause();
            if (this.mHC.bsk() != null) {
                this.mHC.bsk().ll();
            }
        }
        if (this.mHe != null) {
            String focusMode = this.mHe.getFocusMode();
            if (bi.oW(focusMode) || !focusMode.equals("continuous-video")) {
                this.eRw[2] = 0;
            } else {
                this.eRw[2] = 1;
            }
        }
        bsu();
        if (this.mHi != null) {
            this.mHi.bsS();
            this.mHi.hide();
        }
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        if (this.mHw) {
            au.b(this.mHI);
        }
        if (this.mHz != null) {
            this.mHz.onPause();
        }
        if (this.mHD == 1 || this.mHD == 8 || this.mHD == 4) {
            l.mFT.aXS();
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mHF);
            x.i("MicroMsg.scanner.BaseScanUI", "scan cost time:" + currentTimeMillis);
            if (l.mFT.mFV) {
                this.eRw[0] = 1;
            } else {
                this.eRw[0] = 0;
            }
            this.eRw[1] = currentTimeMillis;
            this.eRw[3] = l.mFT.mFW;
            if (m.mNW.btn() > 0) {
                this.eRw[6] = (int) (m.mNW.btn() - this.mHF);
            }
            this.eRw[7] = this.mHD;
            com.tencent.mm.plugin.report.service.h.mEJ.h(14176, new Object[]{Integer.valueOf(this.eRw[0]), Integer.valueOf(this.eRw[1]), Integer.valueOf(this.eRw[2]), Integer.valueOf(this.eRw[3]), Integer.valueOf(this.eRw[4]), Integer.valueOf(this.eRw[5]), Integer.valueOf(this.eRw[6]), Integer.valueOf(this.eRw[7])});
        }
        super.onPause();
    }

    protected void onDestroy() {
        x.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.mHC != null) {
            this.mHC.onDestroy();
        }
        if (this.mHh != null) {
            this.mHh.bsL();
        }
        if (this.mGZ != null) {
            this.mGZ.setSurfaceTextureListener(null);
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.mHN);
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.mNw;
        x.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", new Object[]{Boolean.valueOf(scanCameraLightDetector.mNz), scanCameraLightDetector.ejl, scanCameraLightDetector.mNy});
        try {
            scanCameraLightDetector.mNx = -1;
            if (scanCameraLightDetector.mNB != null) {
                scanCameraLightDetector.mNB.quit();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "stop error: %s", new Object[]{e.getMessage()});
        }
        super.onDestroy();
    }

    private void d(boolean z, long j) {
        if (this.mHp >= 0 && this.mHq > 0) {
            if (this.mHC == null || this.mHC.bsp()) {
                if (z) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mHB.getLayoutParams();
                    if (this.mHr) {
                        layoutParams.width = this.mHn;
                        layoutParams.gravity = 1;
                    } else {
                        layoutParams.height = this.mHo;
                        layoutParams.gravity = 48;
                        layoutParams.topMargin = this.mHs.top;
                    }
                    this.mHB.setLayoutParams(layoutParams);
                    this.mHB.invalidate();
                    this.mHB.setVisibility(0);
                    if (this.mHr) {
                        this.mHA = new TranslateAnimation(0.0f, 0.0f, (float) this.mHp, (float) this.mHq);
                    } else {
                        this.mHA = new TranslateAnimation((float) this.mHp, (float) this.mHq, 0.0f, 0.0f);
                    }
                }
                this.mHJ.removeMessages(1);
                if (j <= 0) {
                    this.mHJ.sendEmptyMessage(1);
                    return;
                }
                bsr();
                this.mHJ.sendEmptyMessageDelayed(1, j);
            }
        }
    }

    public final void bsr() {
        if (this.mHB != null && this.mHA != null) {
            this.mHB.setVisibility(8);
            this.mHB.clearAnimation();
            this.mHB.setAnimation(null);
        }
    }

    public final void bss() {
        if (!this.mHk) {
            as.I(this, R.l.qrcode_completed);
        }
    }

    private void bst() {
        ah.i(new 3(this), 25);
    }

    private void startPreview() {
        try {
            if (this.mHe == null) {
                x.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
            } else if (!this.mHe.isOpen()) {
                x.w("MicroMsg.scanner.BaseScanUI", "camera not open");
            } else if (this.mHa == null) {
                x.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
            } else if (this.mHe.iOl) {
                x.w("MicroMsg.scanner.BaseScanUI", "camera is previewing");
            } else {
                x.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                synchronized (this.dMd) {
                    h hVar = this.mHe;
                    SurfaceTexture surfaceTexture = this.mHa;
                    long VG = bi.VG();
                    if (!(hVar.ddt == null || hVar.iOl)) {
                        if (surfaceTexture != null) {
                            hVar.ddt.setPreviewTexture(surfaceTexture);
                        }
                        hVar.ddt.startPreview();
                        hVar.iOl = true;
                        x.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[]{Long.valueOf(bi.bI(VG))});
                    }
                    x.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                    this.eRw[5] = (int) (System.currentTimeMillis() - this.mHF);
                    if (bi.oW(this.mHe.getFocusMode()) || !this.mHe.getFocusMode().equals("continuous-video")) {
                        if (q.deM.ddi > 0) {
                            eu((long) ((int) (((float) q.deM.ddi) * af.exW)));
                        }
                        ev(0);
                    } else {
                        hVar = this.mHe;
                        if (hVar.ddt != null) {
                            hVar.ddt.cancelAutoFocus();
                        }
                        eu(0);
                    }
                }
            }
        } catch (Throwable e) {
            x.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.startPreview(), [%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            bsv();
        }
    }

    private void bsu() {
        this.iTc = true;
        com.tencent.mm.sdk.f.e.post(new 4(this), "BaseScanUI_closeCamera");
    }

    private void bsv() {
        if (!this.mHj) {
            this.mHj = true;
            hu(true);
            lr lrVar = new lr();
            lrVar.bWf.type = 2;
            com.tencent.mm.sdk.b.a.sFg.m(lrVar);
            if (lrVar.bWg.bWe) {
                x.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
                this.mHk = true;
                bsu();
                bsC();
                overridePendingTransition(0, 0);
                return;
            }
            com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a(this, getString(R.l.scan_open_camera_fail), getString(R.l.app_tip), new 5(this));
            if (a == null) {
                x.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
                return;
            }
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bsw() {
        try {
            bsx();
            if (this.mHC == null) {
                x.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
            } else if (this.mHe != null && this.mHe.isOpen()) {
                this.mHC.g(this.mHf);
                this.mHe.iOo = new Point(this.mHf);
                x.d("MicroMsg.scanner.ScanCamera", "set visible resolution:%s", new Object[]{r0.iOo});
                this.mHC.h(this.mHe.iOm);
                h hVar = this.mHe;
                Rect B = this.mHC.B(true, zf());
                int i = this.mHD;
                hVar.iOr = false;
                hVar.mNo = hVar.c(B, i);
                hVar.btf();
                x.i("MicroMsg.scanner.ScanCamera", "scanDisplayRect:" + hVar.mNo);
                Rect rect = hVar.mNo;
                x.d("MicroMsg.scanner.BaseScanUI", "CameraScreenHeightRate() = [%s], CameraScreenWidthRate() = [%s], rect = [%s]", new Object[]{Float.valueOf(this.mHe.btc()), Float.valueOf(this.mHe.btb()), rect});
                if (zf()) {
                    x.d("MicroMsg.scanner.BaseScanUI", "landscape needRotate:" + this.mHe.iOp);
                    this.mHn = (int) (((float) rect.width()) * this.mHe.btb());
                    this.mHo = (int) (((float) rect.height()) * this.mHe.btc());
                } else {
                    x.d("MicroMsg.scanner.BaseScanUI", "portrait needRotate:" + this.mHe.iOp);
                    if (this.mHe.iOp) {
                        this.mHn = (int) (((float) rect.height()) * this.mHe.btb());
                        this.mHo = (int) (((float) rect.width()) * this.mHe.btc());
                    } else {
                        this.mHn = (int) (((float) rect.width()) * this.mHe.btb());
                        this.mHo = (int) (((float) rect.height()) * this.mHe.btc());
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mHn, this.mHo, 3);
                if (!this.mHe.iOp || zf()) {
                    layoutParams.leftMargin = (int) (((float) rect.left) * this.mHe.btb());
                    layoutParams.topMargin = (int) (((float) rect.top) * this.mHe.btc());
                } else {
                    layoutParams.leftMargin = (int) (((float) rect.top) * this.mHe.btb());
                    layoutParams.topMargin = (int) (((float) rect.left) * this.mHe.btc());
                }
                x.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s], needRotate=[%s]", new Object[]{Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(this.mHn), Integer.valueOf(this.mHo), Boolean.valueOf(this.mHe.iOp)});
                rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + this.mHn, layoutParams.topMargin + this.mHo);
                if (this.mHf.x - rect.right < rect.left) {
                    x.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
                    if (this.mHf.x - rect.left > rect.left) {
                        rect.right = this.mHf.x - rect.left;
                    }
                }
                this.mHn = rect.width();
                if (this.mHh != null) {
                    B = this.mHh.getMaskRect();
                    this.mHh.bsL();
                    this.mHh = new ScanMaskView(this, B);
                } else {
                    this.mHh = new ScanMaskView(this, rect);
                }
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                this.mHh.setLayoutParams(layoutParams2);
                this.mHd.removeAllViews();
                View.inflate(this, this.mHC.bsl(), this.mHd);
                this.mHC.cv(this.mHd.getChildAt(0));
                this.mHd.addView(this.mHh, 0, layoutParams2);
                ScanMaskView scanMaskView = this.mHh;
                if (!(rect.left == scanMaskView.mJT.left && rect.right == scanMaskView.mJT.right && rect.top == scanMaskView.mJT.top && rect.bottom == scanMaskView.mJT.bottom)) {
                    scanMaskView.mKa = (float) (rect.left - scanMaskView.mJT.left);
                    scanMaskView.mKb = (float) (rect.right - scanMaskView.mJT.right);
                    scanMaskView.mKc = (float) (rect.top - scanMaskView.mJT.top);
                    scanMaskView.mKd = (float) (rect.bottom - scanMaskView.mJT.bottom);
                    scanMaskView.mJY = new Rect(scanMaskView.mJT.left, scanMaskView.mJT.top, scanMaskView.mJT.right, scanMaskView.mJT.bottom);
                    scanMaskView.mJX = true;
                    scanMaskView.mKf = new ValueAnimator();
                    scanMaskView.mKf.setFloatValues(new float[]{0.0f, 1.0f});
                    scanMaskView.mKf.setDuration(200);
                    scanMaskView.mKf.addUpdateListener(new ScanMaskView$1(scanMaskView));
                    scanMaskView.mKf.start();
                }
                this.mHC.j(rect);
                this.mHh.setBackgroundColor(0);
                x.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[]{rect});
                if (this.mHr) {
                    this.mHp = rect.top;
                    this.mHq = rect.bottom - BackwardSupportUtil.b.b(this, 8.0f);
                    this.mHs = rect;
                } else {
                    this.mHp = rect.left;
                    this.mHq = rect.right - BackwardSupportUtil.b.b(this, 8.0f);
                    this.mHs = rect;
                }
                if (this.mHi != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mHi.getLayoutParams();
                    if (this.mHD == 3) {
                        layoutParams3.topMargin = this.mHg.getTop() - com.tencent.mm.bp.a.fromDPToPix(this, 70);
                    } else {
                        layoutParams3.topMargin = this.mHs.top + (this.mHs.height() - com.tencent.mm.bp.a.fromDPToPix(this, 70));
                    }
                    x.l("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", new Object[]{this.mHs, Integer.valueOf(this.mHp), Integer.valueOf(this.mHq)});
                    this.mHi.setLayoutParams(layoutParams3);
                    this.mHi.setOnClickListener(new 19(this));
                    if (this.mHe == null || !this.mHe.lfJ) {
                        this.mHi.setVisibility(8);
                    } else {
                        this.mHi.setVisibility(0);
                    }
                }
                if (!this.mHw || this.mHl) {
                    d(true, this.mHh.getMaskAnimDuration() + 150);
                    if (this.mHe != null && this.mHe.iOl) {
                        ev(0);
                    }
                    if (this.mHt != null && this.mHu != null) {
                        this.mHt.setVisibility(8);
                        this.mHu.setVisibility(8);
                    }
                } else if (this.mHt != null && this.mHu != null) {
                    this.mHt.setText(R.l.scan_no_network);
                    this.mHu.setVisibility(0);
                    this.mHt.setVisibility(0);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
        }
    }

    public void onStart() {
        super.onStart();
    }

    private void bsx() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.mHf = new Point(rect.width(), rect.height());
        x.d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", new Object[]{this.mHf});
    }

    public final void vA(int i) {
        this.mHL.removeMessages(0);
        this.mHL.sendEmptyMessageDelayed(i, 50);
    }

    public final void eu(long j) {
        x.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[]{Long.valueOf(j)});
        this.mHM.removeMessages(0);
        if (this.mHk) {
            x.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
        } else {
            this.mHM.sendEmptyMessageDelayed(0, j);
        }
    }

    public final void ev(long j) {
        if (this.mHe != null && !this.mHk && this.mHe.iOl) {
            x.d("MicroMsg.scanner.BaseScanUI", "focus delay:" + j);
            String focusMode = this.mHe.getFocusMode();
            if (bi.oW(focusMode) || !focusMode.equals("continuous-video")) {
                this.mHO.removeMessages(0);
                this.mHO.sendEmptyMessageDelayed(0, j);
                return;
            }
            eu(0);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z = true;
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        x.i(str, str2, objArr);
        if (this.mHk || this.mHC == null || this.mHC.bsk() == null || this.mHC.B(false, zf()) == null) {
            x.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[]{Boolean.valueOf(this.mHk)});
        } else if (bArr == null || bArr.length <= 0) {
            String str3 = "MicroMsg.scanner.BaseScanUI";
            str = "onPreviewFrame, wrong data, data is null [%s]";
            Object[] objArr2 = new Object[1];
            if (bArr != null) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            x.e(str3, str, objArr2);
            bsv();
        } else if (this.mHe == null) {
            x.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
        } else {
            h hVar;
            if (this.mHe != null) {
                hVar = this.mHe;
                if (hVar.mNr < 0) {
                    hVar.mNr = hVar.bti() ? 1 : 0;
                }
                if (hVar.mNr != 1) {
                    z = false;
                }
                if (z && !this.mHe.lfJ && this.mHl) {
                    ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.mNw;
                    int i = this.mHe.iOm.x;
                    int i2 = this.mHe.iOm.y;
                    if (scanCameraLightDetector.mNx < 0 || (bi.bI(scanCameraLightDetector.mNx) >= 1000 && scanCameraLightDetector.handler != null && scanCameraLightDetector.mNB != null && scanCameraLightDetector.mNB.isAlive())) {
                        ScanCameraLightDetector.a aVar = new ScanCameraLightDetector.a(scanCameraLightDetector, (byte) 0);
                        aVar.lho = bArr;
                        aVar.width = i;
                        aVar.height = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 233;
                        obtain.obj = aVar;
                        scanCameraLightDetector.handler.sendMessage(obtain);
                        scanCameraLightDetector.mNx = bi.VG();
                    }
                }
            }
            if (this.mHe != null && !this.mHk) {
                i iVar = this.mHC;
                Point point = this.mHe.iOm;
                int i3 = this.mHe.iOq;
                hVar = this.mHe;
                hVar.iKQ = hVar.c(this.mHC.hx(zf()), this.mHD);
                x.i("MicroMsg.scanner.ScanCamera", "scanRect:" + hVar.iKQ);
                iVar.a(bArr, point, i3, hVar.iKQ);
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        x.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[]{Boolean.valueOf(z), camera});
        this.eRw[4] = (int) (System.currentTimeMillis() - this.mHG);
        q.deM.ddi = (long) this.eRw[4];
        if (!this.mHk && this.mHC != null) {
            if (this.mHe != null && this.mHe.iOl && z) {
                eu(0);
            }
            if (this.mHC.mKh > 0) {
                ev(this.mHC.mKh);
            }
        }
    }

    public final void a(i.a aVar) {
        this.mHm = aVar;
    }

    public final void bsy() {
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", R.l.scan_select_local_img);
        com.tencent.mm.pluginsdk.ui.tools.l.a(this, 4660, intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.mHm != null) {
            this.mHm.b(this, i, i2, intent);
        }
    }

    public final void hu(boolean z) {
        this.mHk = z;
        if (z) {
            bsr();
            if (this.mHu != null) {
                this.mHu.setVisibility(0);
                return;
            }
            return;
        }
        ev(0);
        d(false, 0);
        if (this.mHu != null) {
            this.mHu.setVisibility(8);
        }
    }

    public final void b(int i, View.OnClickListener onClickListener) {
        if (this.mHb != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.mHb.setVisibility(8);
            } else if (onClickListener != null) {
                this.mHb.setVisibility(i);
                this.mHb.setOnClickListener(onClickListener);
                this.mHc.setBackgroundDrawable(null);
                this.mHc.setText(getString(R.l.self_qrcode_gallery_land));
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new 10(this, onClickListener));
            } else {
                removeOptionMenu(0);
            }
        }
    }

    public final boolean bsz() {
        if (this.mHe != null) {
            return this.mHe.iOp;
        }
        x.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null, cameraNeedRotate return false");
        return false;
    }

    public final void bsA() {
        bsC();
    }

    public final void bsB() {
        super.finish();
    }

    private void bsC() {
        oq oqVar = new oq();
        oqVar.bZB.bWA = 1;
        com.tencent.mm.sdk.b.a.sFg.m(oqVar);
        setResult(0);
        finish();
    }

    private boolean zf() {
        return 7 == this.mHD || 9 == this.mHD || 10 == this.mHD || 11 == this.mHD || d.zf();
    }

    public final void a(String str, int i, int i2, int i3, e.a aVar) {
        x.i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.mHz != null) {
            this.mHz.bsY();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
        this.mHz = new e();
        this.mHz.a(this, str, i, i2, i3, aVar, bundleExtra);
        if (this.mHD == 1 || this.mHD == 8 || this.mHD == 4) {
            int i4 = l.mFT.mxT;
            i4 = l.mFQ;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.scanner.BaseScanUI", "screen orientation %d", new Object[]{Integer.valueOf(configuration.orientation)});
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            ah.i(new 11(this), 200);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.mGZ.crS();
        this.mHa = surfaceTexture;
        this.mHx = true;
        if (this.mHy) {
            bst();
            this.mHy = false;
        }
        startPreview();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.mHa = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.mHx = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V(int r13, int r14, int r15) {
        /*
        r12 = this;
        r8 = 6;
        r10 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r7 = 2;
        r6 = 1;
        r1 = r12.dMd;
        monitor-enter(r1);
        r0 = r12.iTc;	 Catch:{ all -> 0x00b1 }
        if (r0 != 0) goto L_0x00af;
    L_0x000c:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x00af;
    L_0x0010:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0 = r0.iOl;	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x00af;
    L_0x0016:
        r0 = "MicroMsg.scanner.BaseScanUI";
        r2 = "zoom camera,action:%d,type:%d,scale:%d";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b1 }
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        r4 = 2;
        r5 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x00b1 }
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r2 = r0.bth();	 Catch:{ all -> 0x00b1 }
        r0 = r12.mHD;	 Catch:{ all -> 0x00b1 }
        if (r0 == r6) goto L_0x004c;
    L_0x0041:
        r0 = r12.mHD;	 Catch:{ all -> 0x00b1 }
        r3 = 8;
        if (r0 == r3) goto L_0x004c;
    L_0x0047:
        r0 = r12.mHD;	 Catch:{ all -> 0x00b1 }
        r3 = 4;
        if (r0 != r3) goto L_0x00ba;
    L_0x004c:
        if (r14 != r6) goto L_0x0063;
    L_0x004e:
        r0 = r12.mHC;	 Catch:{ all -> 0x00b1 }
        r0 = (com.tencent.mm.plugin.scanner.ui.p) r0;	 Catch:{ all -> 0x00b1 }
        r0 = r0.bsQ();	 Catch:{ all -> 0x00b1 }
        if (r0 != 0) goto L_0x0063;
    L_0x0058:
        r0 = "MicroMsg.scanner.BaseScanUI";
        r2 = "auto zoom is disable";
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x00b1 }
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
    L_0x0062:
        return;
    L_0x0063:
        if (r13 != r8) goto L_0x00b4;
    L_0x0065:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0.vG(r15);	 Catch:{ all -> 0x00b1 }
    L_0x006a:
        if (r14 != r7) goto L_0x0073;
    L_0x006c:
        r0 = r12.mHC;	 Catch:{ all -> 0x00b1 }
        r0 = (com.tencent.mm.plugin.scanner.ui.p) r0;	 Catch:{ all -> 0x00b1 }
        r0.bsP();	 Catch:{ all -> 0x00b1 }
    L_0x0073:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0 = r0.bth();	 Catch:{ all -> 0x00b1 }
        if (r0 == r2) goto L_0x00af;
    L_0x007b:
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ all -> 0x00b1 }
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r3 = r0.bth();	 Catch:{ all -> 0x00b1 }
        r0 = "";
        if (r14 != r6) goto L_0x00c8;
    L_0x0088:
        r0 = "(0@%.2f)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00b1 }
        r5 = 0;
        r6 = (double) r3;	 Catch:{ all -> 0x00b1 }
        r6 = r6 / r10;
        r3 = java.lang.Double.valueOf(r6);	 Catch:{ all -> 0x00b1 }
        r4[r5] = r3;	 Catch:{ all -> 0x00b1 }
        r0 = java.lang.String.format(r0, r4);	 Catch:{ all -> 0x00b1 }
    L_0x009b:
        r3 = r2.mGf;	 Catch:{ all -> 0x00b1 }
        r3 = r3.length();	 Catch:{ all -> 0x00b1 }
        r4 = r0.length();	 Catch:{ all -> 0x00b1 }
        r3 = r3 + r4;
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r3 >= r4) goto L_0x00af;
    L_0x00aa:
        r2 = r2.mGf;	 Catch:{ all -> 0x00b1 }
        r2.append(r0);	 Catch:{ all -> 0x00b1 }
    L_0x00af:
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
        goto L_0x0062;
    L_0x00b1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
        throw r0;
    L_0x00b4:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0.vH(r13);	 Catch:{ all -> 0x00b1 }
        goto L_0x006a;
    L_0x00ba:
        if (r13 != r8) goto L_0x00c2;
    L_0x00bc:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0.vG(r15);	 Catch:{ all -> 0x00b1 }
        goto L_0x0073;
    L_0x00c2:
        r0 = r12.mHe;	 Catch:{ all -> 0x00b1 }
        r0.vH(r13);	 Catch:{ all -> 0x00b1 }
        goto L_0x0073;
    L_0x00c8:
        if (r14 != r7) goto L_0x009b;
    L_0x00ca:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
        r4.<init>();	 Catch:{ all -> 0x00b1 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x00b1 }
        r4 = "(1@%.2f)";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b1 }
        r6 = 0;
        r8 = (double) r3;	 Catch:{ all -> 0x00b1 }
        r8 = r8 / r10;
        r3 = java.lang.Double.valueOf(r8);	 Catch:{ all -> 0x00b1 }
        r5[r6] = r3;	 Catch:{ all -> 0x00b1 }
        r3 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x00b1 }
        r0 = r0.append(r3);	 Catch:{ all -> 0x00b1 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b1 }
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.BaseScanUI.V(int, int, int):void");
    }

    public final void bsD() {
        if (this.mHe != null && !this.mHk) {
            String focusMode = this.mHe.getFocusMode();
            if (!bi.oW(focusMode) && !focusMode.equals("auto")) {
                h hVar = this.mHe;
                if (hVar.ddt != null && hVar.iOl) {
                    Parameters parameters = hVar.ddt.getParameters();
                    List supportedFocusModes = parameters.getSupportedFocusModes();
                    if (!(supportedFocusModes == null || !supportedFocusModes.contains("auto") || bi.oW(parameters.getFocusMode()) || parameters.getFocusMode().equals("auto"))) {
                        parameters.setFocusMode("auto");
                        hVar.ddt.setParameters(parameters);
                    }
                }
                ev(0);
            }
        }
    }
}
