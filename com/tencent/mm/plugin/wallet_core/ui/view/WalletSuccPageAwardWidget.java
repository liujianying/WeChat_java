package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.2;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.3;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.1;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import d.a.a.a;
import d.a.a.c;
import d.a.a.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget extends FrameLayout {
    private static final String pAL = (e.bnE + "wallet/images/");
    private TextView eHU;
    private TextView fAK;
    private String hTI;
    private Button hlf;
    private c mAh;
    private boolean mLL = true;
    private ImageView pAB;
    private ImageView pAC;
    private WalletScratchShakeView pAD;
    private WalletAwardShakeAnimView pAE;
    private g pAF;
    private WalletBaseUI pAG;
    private boolean pAH = false;
    private boolean pAI = false;
    private boolean pAJ = false;
    private a pAK = null;
    private ViewGroup pAx;
    private boolean pjf;
    private CdnImageView pwW;

    static /* synthetic */ byte[] M(Bitmap bitmap) {
        int i = 0;
        int[] iArr = new int[]{(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
        int[] iArr2 = new int[]{(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        return order.array();
    }

    static /* synthetic */ void a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i, boolean z) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", new Object[]{Integer.valueOf(walletSuccPageAwardWidget.mAh.vGZ)});
        if (walletSuccPageAwardWidget.mAh.vGZ != 0) {
            walletSuccPageAwardWidget.pAG.a(new com.tencent.mm.plugin.wallet_core.c.g(walletSuccPageAwardWidget.mAh.rvZ, i, walletSuccPageAwardWidget.pjf), z, false);
        }
    }

    static /* synthetic */ void bQV() {
    }

    static /* synthetic */ void c(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z = walletSuccPageAwardWidget.mAh.vHa == 1 || walletSuccPageAwardWidget.mAh.vHa == 3;
        boolean z2 = walletSuccPageAwardWidget.mAh.vHa == 2 || walletSuccPageAwardWidget.mAh.vHa == 3;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.pAD;
        float f = (float) fromDPToPix;
        fromDPToPix /= 2;
        x.i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z)});
        walletScratchShakeView.pAb = z;
        walletScratchShakeView.pAa = z2;
        if (walletScratchShakeView.pzZ != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.pzZ);
            walletScratchShakeView.pzZ = null;
        }
        walletScratchShakeView.pzZ = new b(walletScratchShakeView, walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.pzZ, new LayoutParams(-1, -1));
        b bVar = walletScratchShakeView.pzZ;
        x.i("MicroMsg.WalletScratchShakeView", "init inner view");
        bVar.aar = new Paint();
        bVar.aar.setAntiAlias(true);
        bVar.aar.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(bVar.getResources(), com.tencent.mm.plugin.wxpay.a.e.wallet_shake_award_bg);
        bVar.pAe = new NinePatchDrawable(bVar.getResources(), new NinePatch(decodeResource, b.L(decodeResource), "shake_bg"));
        bVar.pAf = new Paint();
        bVar.pAf.setAntiAlias(true);
        bVar.pAf.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.pAf.setStyle(Style.STROKE);
        bVar.pAf.setStrokeCap(Cap.ROUND);
        bVar.pAf.setStrokeWidth(f);
        bVar.pAg = new Paint();
        bVar.pAg.setAntiAlias(true);
        bVar.pAg.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.pAg.setStyle(Style.FILL);
        bVar.pAg.setStrokeCap(Cap.ROUND);
        bVar.pAh = new Path();
        bVar.pAi = new Path();
        bVar.pAq = 0.0f;
        bVar.pAp = 0.0f;
        bVar.jVn = ViewConfiguration.get(bVar.getContext()).getScaledTouchSlop();
        bVar.pAn = false;
        bVar.pAo = false;
        bVar.pAr = fromDPToPix;
        if (bVar.pAv.pAa) {
            bVar.lAY = new com.tencent.mm.pluginsdk.i.c(bVar.getContext());
            bVar.lAY.a(new 1(bVar));
            bVar.hmb = bi.VG();
        }
        bVar.invalidate();
        walletScratchShakeView.setClipChildren(false);
        walletSuccPageAwardWidget.pAD.setScratchShakeCallback(new WalletScratchShakeView.a() {
            public final void jF(boolean z) {
                int i = 2;
                x.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", new Object[]{Boolean.valueOf(z)});
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, z ? 1 : 2, false);
                h hVar;
                Object[] objArr;
                if (z) {
                    hVar = h.mEJ;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(5);
                    if (!WalletSuccPageAwardWidget.this.pAH) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    hVar.h(15225, objArr);
                } else {
                    hVar = h.mEJ;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4);
                    if (!WalletSuccPageAwardWidget.this.pAH) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    hVar.h(15225, objArr);
                }
                WalletSuccPageAwardWidget.this.pAI = true;
            }

            public final void bQP() {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
                if (WalletSuccPageAwardWidget.this.mAh.vHb != 0) {
                    WalletSuccPageAwardWidget.bQV();
                }
            }
        });
    }

    public static boolean a(c cVar) {
        return cVar != null && ((cVar.rxS != null && cVar.rxS.size() > 0) || cVar.vHe != null);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        y.gq(context).inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_succ_page_award_widget, this, true);
        this.pAx = (ViewGroup) findViewById(f.content_layout);
        this.pwW = (CdnImageView) findViewById(f.logo_iv);
        this.eHU = (TextView) findViewById(f.name_tv);
        this.fAK = (TextView) findViewById(f.desc_tv);
        this.hlf = (Button) findViewById(f.button);
        this.pAD = (WalletScratchShakeView) findViewById(f.scratch_shake_view);
        this.pAB = (ImageView) findViewById(f.background);
        this.pAE = (WalletAwardShakeAnimView) findViewById(f.shake_view);
        this.pwW.setRoundCorner(true);
        this.pwW.setUseSdcardCache(true);
    }

    public final void a(WalletBaseUI walletBaseUI, c cVar, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        String str2 = "MicroMsg.WalletSuccPageAwardWidget";
        String str3 = "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s";
        Object[] objArr = new Object[5];
        objArr[0] = b(cVar);
        boolean z3 = cVar == null || cVar.vHc == null;
        objArr[1] = Boolean.valueOf(z3);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.pAH);
        objArr[4] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        this.pAG = walletBaseUI;
        this.mAh = cVar;
        this.pjf = z;
        this.hTI = str;
        this.pAC = imageView;
        bQS();
    }

    private void bQS() {
        int i = 2;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[]{b(this.mAh), Boolean.valueOf(this.mLL)});
        if (this.mAh == null) {
            x.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            return;
        }
        x.l("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[]{Integer.valueOf(this.mAh.vHa), Integer.valueOf(this.mAh.rxS.size()), Boolean.valueOf(this.pAH)});
        if (this.mAh.vHa > 0 && this.mAh.vHa <= 5 && a(this.mAh)) {
            if (this.mAh.vHa == 4) {
                bQU();
                if (this.pAD.getVisibility() != 8) {
                    this.pAD.setVisibility(8);
                    this.pAD.onDestroy();
                }
                if (this.pAE.getVisibility() != 8) {
                    this.pAE.setVisibility(8);
                    this.pAE.destroy();
                }
            } else if (this.mAh.vHa == 1 || this.mAh.vHa == 2 || this.mAh.vHa == 3) {
                bQU();
                if (this.pAE.getVisibility() != 8) {
                    this.pAE.setVisibility(8);
                    this.pAE.destroy();
                }
                if (this.pAD.getVisibility() != 0) {
                    this.pAD.setVisibility(0);
                    this.pAD.post(new 1(this));
                }
            } else if (this.mAh.vHa == 5) {
                bQU();
                if (this.pAD.getVisibility() != 8) {
                    this.pAD.setVisibility(8);
                    this.pAD.onDestroy();
                }
                if (this.mAh.vHe != null) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", new Object[]{Integer.valueOf(this.mAh.vHe.srY)});
                    switch (this.mAh.vHe.srY) {
                        case 1:
                            if (this.pAE.getVisibility() != 0) {
                                this.pAE.setVisibility(0);
                                this.pAE.post(new 2(this));
                            }
                            this.pAE.destroy();
                            if (!bi.oW(this.mAh.vHe.vGV)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", new Object[]{this.mAh.vHe.vGV});
                                this.pAE.setShakeHintWording(this.mAh.vHe.vGV);
                            }
                            if (!bi.oW(this.mAh.vHe.vGW)) {
                                try {
                                    x.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", new Object[]{this.mAh.vHe.vGW});
                                    this.pAE.setShakeHintWordingColor(Color.parseColor(this.mAh.vHe.vGW));
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse animation_wording_color %s error %s", new Object[]{this.mAh.vHe.vGW, e.getMessage()});
                                }
                            }
                            if (!bi.oW(this.mAh.vHe.vGX)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", new Object[]{this.mAh.vHe.vGX});
                                this.pAE.setAfterHintWording(this.mAh.vHe.vGX);
                            }
                            if (!bi.oW(this.mAh.vHe.vGY)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", new Object[]{this.mAh.vHe.vGY});
                                try {
                                    this.pAE.setAfterHintWordingColor(Color.parseColor(this.mAh.vHe.vGY));
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse after_animation_wording_color %s error %s", new Object[]{this.mAh.vHe.vGY, e2.getMessage()});
                                }
                            }
                            this.pAE.setShakeOrClickCallback(new 3(this));
                            WalletAwardShakeAnimView walletAwardShakeAnimView = this.pAE;
                            x.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
                            walletAwardShakeAnimView.lAY = new com.tencent.mm.pluginsdk.i.c(walletAwardShakeAnimView.getContext());
                            walletAwardShakeAnimView.lAY.a(new 2(walletAwardShakeAnimView));
                            walletAwardShakeAnimView.hmb = bi.VG();
                            walletAwardShakeAnimView.setOnClickListener(new 3(walletAwardShakeAnimView));
                            ah.M(walletAwardShakeAnimView.pzO);
                            ah.i(walletAwardShakeAnimView.pzO, 3000);
                            break;
                        case 2:
                            d.a.a.f fVar = this.mAh.vHe.vGU;
                            if (fVar != null) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", new Object[]{fVar.sbY, fVar.sbZ, Integer.valueOf(fVar.sca)});
                                qu quVar = new qu();
                                quVar.cbq.userName = fVar.sbY;
                                quVar.cbq.cbs = bi.aG(fVar.sbZ, "");
                                quVar.cbq.scene = 1060;
                                quVar.cbq.bGG = this.hTI;
                                quVar.cbq.cbt = 0;
                                if (fVar.sca > 0) {
                                    quVar.cbq.cbu = fVar.sca;
                                }
                                quVar.cbq.context = this.pAG;
                                com.tencent.mm.sdk.b.a.sFg.m(quVar);
                                this.pAH = true;
                                break;
                            }
                            break;
                        case 3:
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", new Object[]{this.mAh.vHe.url});
                            com.tencent.mm.wallet_core.ui.e.l(this.pAG, this.mAh.vHe.url, false);
                            this.pAH = true;
                            break;
                        case 4:
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
                            this.pAD.setVisibility(8);
                            this.pAD.onDestroy();
                            break;
                        default:
                            this.pAE.setVisibility(8);
                            this.pAE.destroy();
                            break;
                    }
                }
                this.pAE.setVisibility(8);
                this.pAE.destroy();
            }
            if (this.mLL || this.pAH) {
                h hVar = h.mEJ;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(3);
                if (!this.pAH) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                hVar.h(15225, objArr);
            }
            this.mLL = false;
        }
    }

    private void bQT() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHU.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAK.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.eHU.setLayoutParams(layoutParams);
        this.fAK.setLayoutParams(layoutParams2);
        this.eHU.setVisibility(0);
        this.fAK.setVisibility(8);
        this.eHU.setText(i.wallet_shake_award_net_failed);
        this.eHU.setTextColor(Color.parseColor("#353535"));
        this.fAK.setTextColor(Color.parseColor("#B2B2B2"));
        this.pAB.setVisibility(8);
        findViewById(f.order_info_tinyapp_splitter_1).setVisibility(0);
        findViewById(f.order_info_tinyapp_splitter_2).setVisibility(0);
        this.hlf.setVisibility(8);
        this.pwW.setVisibility(0);
        this.pwW.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_pay_shake_award_net_failed_logo);
        this.pAD.setVisibility(8);
        this.pAD.onDestroy();
        this.pAE.setVisibility(8);
        this.pAE.destroy();
    }

    public final void init() {
        if (this.pAG != null) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "init");
            this.pAG.jr(1859);
            this.pAG.jr(2547);
            this.pAG.jr(2803);
            this.pAG.jr(2508);
            this.pAG.jr(2529);
            this.pAG.jr(2888);
        }
    }

    public final void onDestroy() {
        int i = 2;
        if (this.pAG != null) {
            this.pAG.js(1859);
            this.pAG.js(2547);
            this.pAG.js(2803);
            this.pAG.js(2508);
            this.pAG.js(2529);
            this.pAG.js(2888);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[]{Boolean.valueOf(this.pAI), Boolean.valueOf(this.pAJ)});
            if (!(this.pAI || this.pAJ)) {
                h hVar = h.mEJ;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(6);
                if (!this.pAH) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                hVar.h(15225, objArr);
                x.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.pAG.a(new com.tencent.mm.plugin.wallet_core.c.g(this.mAh.rvZ, 4, this.pjf), false, false);
            }
        }
        if (this.pAD != null) {
            this.pAD.onDestroy();
        }
        if (this.pAE != null) {
            this.pAE.destroy();
        }
    }

    public final void onResume() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s", new Object[]{Boolean.valueOf(this.pAH), b(this.mAh)});
        if (!(this.mAh.vHe == null || this.mAh.vHe.srY == 1)) {
            this.pAD.setVisibility(8);
            this.pAD.onDestroy();
            this.pAE.setVisibility(8);
            this.pAE.destroy();
        }
        x.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[]{Boolean.valueOf(this.pAH)});
        if (this.pAH) {
            this.pAG.a(new j(this.mAh.rxR, this.pjf), false, false);
        }
    }

    private static String Pz(String str) {
        if (bi.G(new String[0])) {
            return null;
        }
        FileOp.mL(pAL);
        x.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[]{str, pAL + com.tencent.xweb.util.c.u(str.getBytes())});
        return pAL + com.tencent.xweb.util.c.u(str.getBytes());
    }

    private void bQU() {
        com.tencent.mm.ak.a.a.c.a aVar;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
        List list = this.mAh.rxS;
        String str = "MicroMsg.WalletSuccPageAwardWidget";
        String str2 = "singleExposureInfoList %s, size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = list;
        objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
        x.i(str, str2, objArr);
        if (list != null && list.size() > 0) {
            boolean z;
            this.pAF = (g) list.get(0);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[]{Integer.valueOf(0), this.pAF.vHo, this.pAF.vHp, this.pAF.lRX});
            this.pwW.setUrl(this.pAF.lRX);
            if (!bi.oW(this.pAF.lRX)) {
                this.pwW.setVisibility(0);
            }
            if (bi.oW(this.pAF.vHo)) {
                z = false;
            } else {
                this.eHU.setText(this.pAF.vHo);
                this.eHU.setVisibility(0);
                try {
                    if (!bi.oW(this.pAF.vHr)) {
                        this.eHU.setTextColor(Color.parseColor(this.pAF.vHr));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse award_name_color error: %s", new Object[]{e.getMessage()});
                }
                z = true;
            }
            if (!bi.oW(this.pAF.vHp)) {
                this.fAK.setText(this.pAF.vHp);
                this.fAK.setVisibility(0);
                try {
                    if (!bi.oW(this.pAF.vHs)) {
                        this.fAK.setTextColor(Color.parseColor(this.pAF.vHs));
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_description_color error: %s", new Object[]{e2.getMessage()});
                }
                z = true;
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHU.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAK.getLayoutParams();
                if (!bi.oW(this.pAF.vHo) && bi.oW(this.pAF.vHp)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.eHU.setLayoutParams(layoutParams);
                    this.fAK.setLayoutParams(layoutParams2);
                    this.eHU.setVisibility(0);
                    this.fAK.setVisibility(8);
                } else if (!bi.oW(this.pAF.vHo) || bi.oW(this.pAF.vHp)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.eHU.setLayoutParams(layoutParams);
                    this.fAK.setLayoutParams(layoutParams2);
                    this.eHU.setVisibility(0);
                    this.fAK.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.eHU.setLayoutParams(layoutParams);
                    this.fAK.setLayoutParams(layoutParams2);
                    this.eHU.setVisibility(8);
                    this.fAK.setVisibility(0);
                }
            }
            if (bi.oW(this.pAF.vHq)) {
                this.pAB.setVisibility(8);
                findViewById(f.order_info_tinyapp_splitter_1).setVisibility(0);
                findViewById(f.order_info_tinyapp_splitter_2).setVisibility(0);
            } else {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[]{this.pAF.vHq});
                aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXy = true;
                aVar.dXx = true;
                aVar.dXA = Pz(this.pAF.vHq);
                o.Pj().a(this.pAF.vHq, null, aVar.Pt(), new 4(this));
            }
        }
        String str3 = "MicroMsg.WalletSuccPageAwardWidget";
        str = "is_show_btn: %s, btn_info: %s, btn_words: %s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.mAh.rxT);
        objArr2[1] = this.mAh.rxU;
        objArr2[2] = this.mAh.rxU != null ? this.mAh.rxU.vGR : "";
        x.i(str3, str, objArr2);
        if (this.mAh.rxT == 0 || this.mAh.rxU == null || bi.oW(this.mAh.rxU.vGR)) {
            this.hlf.setVisibility(8);
        } else {
            a aVar2 = this.mAh.rxU;
            if (aVar2 != null) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[]{aVar2.vGR, Integer.valueOf(aVar2.vGT), aVar2.vGS, aVar2.url});
                this.hlf.setText(aVar2.vGR);
                if (!bi.oW(aVar2.vGS)) {
                    Drawable drawable = getContext().getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.btn_solid_green);
                    drawable.setColorFilter(Color.parseColor(aVar2.vGS), Mode.SRC);
                    this.hlf.setBackground(drawable);
                }
                this.hlf.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int i = 2;
                        if (WalletSuccPageAwardWidget.this.mAh != null && WalletSuccPageAwardWidget.this.mAh.rxU != null) {
                            WalletSuccPageAwardWidget.this.pAK = WalletSuccPageAwardWidget.this.mAh.rxU;
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.this.pAK.vGT)});
                            if (WalletSuccPageAwardWidget.this.pAK.vGT == 1) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.this.pAK.vGT), WalletSuccPageAwardWidget.this.pAK.url});
                                com.tencent.mm.wallet_core.ui.e.l(WalletSuccPageAwardWidget.this.pAG, WalletSuccPageAwardWidget.this.pAK.url, false);
                                WalletSuccPageAwardWidget.this.pAH = true;
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 2) {
                                d.a.a.f fVar = WalletSuccPageAwardWidget.this.pAK.vGU;
                                if (fVar != null) {
                                    x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[]{fVar.sbY, fVar.sbZ, Integer.valueOf(fVar.sca)});
                                    qu quVar = new qu();
                                    quVar.cbq.userName = fVar.sbY;
                                    quVar.cbq.cbs = bi.aG(fVar.sbZ, "");
                                    quVar.cbq.scene = 1060;
                                    quVar.cbq.bGG = WalletSuccPageAwardWidget.this.hTI;
                                    quVar.cbq.cbt = 0;
                                    if (fVar.sca > 0) {
                                        quVar.cbq.cbu = fVar.sca;
                                    }
                                    quVar.cbq.context = WalletSuccPageAwardWidget.this.pAG;
                                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                                    WalletSuccPageAwardWidget.this.pAH = true;
                                }
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 3) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                                WalletSuccPageAwardWidget.this.pAG.a(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.mAh.rxU.rJm, WalletSuccPageAwardWidget.this.pjf), true, true);
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 5) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 6) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 7) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 8) {
                                WalletSuccPageAwardWidget.this.pAG.a(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.mAh.rxU.rJm, WalletSuccPageAwardWidget.this.pjf), true, true);
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.this.pAK.vGT), WalletSuccPageAwardWidget.this.pAK.url});
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            } else if (WalletSuccPageAwardWidget.this.pAK.vGT == 9) {
                                WalletSuccPageAwardWidget.this.pAG.a(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.mAh.rxU.rJm, WalletSuccPageAwardWidget.this.pjf), true, true);
                                WalletSuccPageAwardWidget.this.pAJ = true;
                            }
                            h hVar = h.mEJ;
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(2);
                            if (!WalletSuccPageAwardWidget.this.pAH) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            hVar.h(15225, objArr);
                        }
                    }
                });
                this.hlf.setVisibility(0);
                if (this.mLL || this.pAH) {
                    h hVar = h.mEJ;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(1);
                    objArr2[1] = Integer.valueOf(this.pAH ? 2 : 1);
                    hVar.h(15225, objArr2);
                }
            }
        }
        if (this.eHU.getVisibility() == 0) {
            this.eHU.setSingleLine();
            this.eHU.post(new 6(this));
        }
        if (this.hlf.getVisibility() != 0) {
            this.eHU.setEllipsize(TruncateAt.END);
        }
        if (this.mAh.vHb != 0) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[]{Integer.valueOf(this.mAh.vHb)});
        }
        if (!bi.oW(this.mAh.vHd)) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[]{this.mAh.vHd});
            if (this.pAC != null) {
                this.pAC.setVisibility(0);
                aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXy = true;
                aVar.dXx = true;
                aVar.dXA = Pz(this.mAh.vHd);
                o.Pj().a(this.mAh.vHd, null, aVar.Pt(), new 7(this));
            }
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        int i3 = 0;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        int i4;
        String str2;
        String str3;
        Object[] objArr;
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.i) {
            com.tencent.mm.plugin.wallet_core.c.i iVar = (com.tencent.mm.plugin.wallet_core.c.i) lVar;
            if (i == 0 && i2 == 0) {
                afe afe = iVar.pjk;
                if (afe == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    return true;
                }
                x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[]{Integer.valueOf(afe.hwV), afe.hwW, afe.rFx, afe.pqb});
                if (afe.hwV != 0) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (bi.oW(afe.rFx)) {
                    if (afe.pqb != null) {
                        i4 = this.mAh.rxU != null ? this.mAh.rxU.vGT : 0;
                        this.mAh = afe.pqb;
                        if (!(afe.pqb.rxU == null || this.mAh.rxU == null)) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[]{Integer.valueOf(afe.pqb.rxU.vGT)});
                            if (afe.pqb.rxU.vGT == 4) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.mAh.rxU.vGT = i4;
                            }
                        }
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        bQS();
                    }
                    if (this.pAK != null && this.pAJ) {
                        if (this.pAK.vGT == 8) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            com.tencent.mm.wallet_core.ui.e.l(this.pAG, this.pAK.url, false);
                            this.pAH = true;
                        } else if (this.pAK.vGT == 9) {
                            d.a.a.f fVar = this.pAK.vGU;
                            if (fVar != null) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[]{fVar.sbY, fVar.sbZ, Integer.valueOf(fVar.sca)});
                                qu quVar = new qu();
                                quVar.cbq.userName = fVar.sbY;
                                quVar.cbq.cbs = bi.aG(fVar.sbZ, "");
                                quVar.cbq.scene = 1060;
                                quVar.cbq.bGG = this.hTI;
                                quVar.cbq.cbt = 0;
                                if (fVar.sca > 0) {
                                    quVar.cbq.cbu = fVar.sca;
                                }
                                quVar.cbq.context = this.pAG;
                                com.tencent.mm.sdk.b.a.sFg.m(quVar);
                                this.pAH = true;
                            }
                        }
                    }
                    this.pAK = null;
                    return true;
                } else {
                    Toast.makeText(getContext(), afe.rFx, 1).show();
                    return true;
                }
            }
            bQT();
            return true;
        } else if (lVar instanceof j) {
            j jVar = (j) lVar;
            if (i == 0 && i2 == 0) {
                ul ulVar = jVar.pjm;
                if (ulVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s";
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(ulVar.hwV);
                objArr[1] = ulVar.hwW;
                objArr[2] = ulVar.rxS;
                objArr[3] = Integer.valueOf(ulVar.rxT);
                objArr[4] = ulVar.rxU;
                objArr[5] = Integer.valueOf(ulVar.rxU != null ? ulVar.rxU.vGT : 0);
                x.i(str2, str3, objArr);
                if (ulVar.hwV == 0) {
                    this.mAh.rxS = ulVar.rxS;
                    this.mAh.rxT = ulVar.rxT;
                    if (this.mAh.rxU != null) {
                        i4 = this.mAh.rxU.vGT;
                    } else {
                        i4 = 0;
                    }
                    if (ulVar.rxU != null) {
                        this.mAh.rxU = ulVar.rxU;
                        if (this.mAh.rxU != null && ulVar.rxU.vGT == 4) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.mAh.rxU.vGT = i4;
                        }
                    }
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[]{b(this.mAh)});
                    bQU();
                }
            }
            this.pAH = false;
            return true;
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.g)) {
            return false;
        } else {
            com.tencent.mm.plugin.wallet_core.c.g gVar = (com.tencent.mm.plugin.wallet_core.c.g) lVar;
            if (i == 0 && i2 == 0) {
                st stVar = gVar.pje;
                if (stVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(stVar.hwV);
                objArr[1] = stVar.hwW;
                objArr[2] = stVar.pqb;
                objArr[3] = stVar.pqb != null ? stVar.pqb.rxS : "";
                x.i(str2, str3, objArr);
                if (stVar.pqb == null || stVar.pqb.rxS == null || stVar.pqb.rxS.size() <= 0) {
                    bQT();
                } else {
                    str2 = "MicroMsg.WalletSuccPageAwardWidget";
                    str3 = "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s";
                    objArr = new Object[3];
                    objArr[0] = stVar.pqb;
                    objArr[1] = stVar.pqb.rxU;
                    if (stVar.pqb.rxU != null) {
                        i4 = stVar.pqb.rxU.vGT;
                    } else {
                        i4 = 0;
                    }
                    objArr[2] = Integer.valueOf(i4);
                    x.i(str2, str3, objArr);
                    if (this.mAh.rxU != null) {
                        i3 = this.mAh.rxU.vGT;
                    }
                    this.mAh = stVar.pqb;
                    if (!(this.mAh.rxU == null || stVar.pqb.rxU == null || stVar.pqb.rxU.vGT != 4)) {
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.mAh.rxU.vGT = i3;
                    }
                    bQS();
                }
            } else {
                bQT();
            }
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.pAD != null && this.pAD.getVisibility() == 0) {
            if (this.pAD != null) {
                WalletScratchShakeView walletScratchShakeView = this.pAD;
                if (walletScratchShakeView.pzZ != null ? walletScratchShakeView.pzZ.F(motionEvent) : false) {
                    walletScratchShakeView = this.pAD;
                } else {
                    walletScratchShakeView = this.pAD;
                }
                if (!(walletScratchShakeView.pzZ != null ? walletScratchShakeView.pzZ.pAt : true)) {
                    z = this.pAD.dispatchTouchEvent(motionEvent);
                }
            }
            if (!(this.pAx == null || z)) {
                return this.pAx.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private static String b(c cVar) {
        if (cVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (cVar.rxS != null && cVar.rxS.size() > 0) {
                Iterator it = cVar.rxS.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("logo", gVar.lRX);
                    jSONObject3.put("award_name", gVar.vHo);
                    jSONObject3.put("award_description", gVar.vHp);
                    jSONObject3.put("background_img", gVar.vHq);
                    jSONObject3.put("award_name_color", gVar.vHr);
                    jSONObject3.put("award_description_color", gVar.vHs);
                    jSONArray.put(jSONObject3);
                }
            }
            jSONObject2.put("single_exposure_info_list", jSONArray);
            jSONObject2.put("is_query_others", cVar.vGZ);
            jSONObject2.put("draw_lottery_params", cVar.rvZ);
            jSONObject2.put("is_show_btn", cVar.rxT);
            JSONObject jSONObject4 = new JSONObject();
            if (cVar.rxU != null) {
                jSONObject4.put("btn_words", cVar.rxU.vGR);
                jSONObject4.put("btn_color", cVar.rxU.vGS);
                jSONObject4.put("btn_op_type", cVar.rxU.vGT);
                jSONObject4.put("url", cVar.rxU.url);
                jSONObject = new JSONObject();
                if (cVar.rxU.vGU != null) {
                    jSONObject.put("activity_tinyapp_username", cVar.rxU.vGU.sbY);
                    jSONObject.put("activity_tinyapp_path", cVar.rxU.vGU.sbZ);
                    jSONObject.put("activity_tinyapp_version", cVar.rxU.vGU.sca);
                }
                jSONObject4.put("mini_app_info", jSONObject);
                jSONObject4.put("get_lottery_params", cVar.rxU.rJm);
            }
            jSONObject2.put("btn_info", jSONObject4);
            jSONObject2.put("exposure_info_modify_params", cVar.rxR);
            jSONObject2.put("user_opertaion_type", cVar.vHa);
            jSONObject2.put("is_show_layer", cVar.vHb);
            jSONObject2.put("background_img_whole", cVar.vHd);
            if (cVar.vHe != null) {
                jSONObject4 = new JSONObject();
                jSONObject4.put("animation_wording", cVar.vHe.vGV);
                jSONObject4.put("animation_wording_color", cVar.vHe.vGW);
                jSONObject4.put("url", cVar.vHe.url);
                jSONObject4.put("op_type", cVar.vHe.srY);
                jSONObject4.put("after_animation_wording", cVar.vHe.vGX);
                jSONObject4.put("after_animation_wording_color", cVar.vHe.vGY);
                jSONObject = new JSONObject();
                if (cVar.vHe.vGU != null) {
                    jSONObject.put("activity_tinyapp_username", cVar.vHe.vGU.sbY);
                    jSONObject.put("activity_tinyapp_path", cVar.vHe.vGU.sbZ);
                    jSONObject.put("activity_tinyapp_version", cVar.vHe.vGU.sca);
                }
                jSONObject4.put("mini_app_info", jSONObject);
                jSONObject2.put("draw_lottery_info", jSONObject4);
            }
            return jSONObject2.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
