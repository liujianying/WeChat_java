package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.c;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.qbar.QbarNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

@a(1)
public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements aw.a {
    private View Iq;
    private SensorManager bgR;
    private int[] eRw;
    private d eSg;
    private al eVk;
    private DisplayMetrics ewi;
    private n.d hXz = new 9(this);
    private String ixy;
    private String kLZ;
    private Button kMi;
    private View kND;
    private View kNE;
    private ImageView kNF;
    private TextView kNG;
    private TextView kNH;
    private ImageView kNI;
    private TextView kNJ;
    private TextView kNK;
    private HorizontalListViewV2 kNL;
    private List<String> kNM;
    private Map<String, String> kNN;
    private Queue<Pair<String, Integer>> kNO;
    private a kNP;
    private TextView kNQ;
    private ShuffleView kNR;
    private c kNS;
    private List<View> kNT;
    private ViewGroup kNU;
    private ViewGroup kNV;
    private View kNW;
    private com.tencent.mm.plugin.luckymoney.f2f.a kNX;
    private long kNY;
    private String kNZ;
    private String kNr;
    private int kNs;
    private ValueAnimator kOa;
    private float kOb;
    private float kOc;
    private float kOd;
    private bv.a kOe = new 1(this);
    private n.c kOf = new 8(this);
    private Bitmap kOg;
    private Bitmap kOh;
    private Bitmap kOi;
    private Bitmap kOj;
    private Bitmap kOk;
    private Bitmap kOl;
    private Bitmap kOm;
    private Bitmap kOn;
    private Bitmap kOo;
    private Bitmap kOp;
    private Bitmap kOq;
    private Bitmap kOr;
    private b kOs = new 10(this);
    private b kOt = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 10) {
                if (LuckyMoneyF2FQRCodeUI.this.kOp == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_1), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOp);
            } else if (nextInt < 20) {
                if (LuckyMoneyF2FQRCodeUI.this.kOq == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOq = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_2), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOq);
            } else if (nextInt < 30) {
                if (LuckyMoneyF2FQRCodeUI.this.kOr == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOr = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_3), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOr);
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.kOm == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOm = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_1), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOm);
            } else if (nextInt < 75) {
                if (LuckyMoneyF2FQRCodeUI.this.kOn == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_2), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOn);
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.kOo == null) {
                    LuckyMoneyF2FQRCodeUI.this.kOo = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_3), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.kOo);
            }
        }
    };
    final SensorEventListener kOu = new 7(this);
    private Bitmap mBitmap;

    static /* synthetic */ void G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        luckyMoneyF2FQRCodeUI.kNF = (ImageView) luckyMoneyF2FQRCodeUI.kNE.findViewById(f.lucky_money_receive_sender_avatar);
        luckyMoneyF2FQRCodeUI.kNG = (TextView) luckyMoneyF2FQRCodeUI.kNE.findViewById(f.lucky_money_receive_sender_nickname);
        luckyMoneyF2FQRCodeUI.kNH = (TextView) luckyMoneyF2FQRCodeUI.kNE.findViewById(f.lucky_money_receive_amount);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.kNO.poll();
        if (pair != null) {
            o.a(luckyMoneyF2FQRCodeUI.kNF, null, (String) pair.first);
            o.a(luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.kNG, o.gS((String) pair.first));
            luckyMoneyF2FQRCodeUI.kNH.setText(com.tencent.mm.wallet_core.ui.e.A(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!bi.oW(luckyMoneyF2FQRCodeUI.kNZ) && luckyMoneyF2FQRCodeUI.kNZ.equals(pair.first)) {
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.kNU, luckyMoneyF2FQRCodeUI.kOs).z(800, 100);
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.kNV, luckyMoneyF2FQRCodeUI.kOt).z(800, 100);
                luckyMoneyF2FQRCodeUI.kNX.eR("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.kNX.eR("whistle.m4a");
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ewi = getResources().getDisplayMetrics();
        this.kNM = new ArrayList();
        this.kNN = new HashMap();
        this.kNO = new LinkedList();
        this.kNT = new ArrayList();
        this.eRw = new int[6];
        int[] iArr = this.eRw;
        iArr[0] = iArr[0] + 1;
        this.eVk = new al(new al.a() {
            public final boolean vD() {
                LuckyMoneyF2FQRCodeUI.this.b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), false);
                return true;
            }
        }, true);
        this.Iq = findViewById(f.lucky_money_f2f_recv_header);
        this.kND = findViewById(f.white_block);
        this.kNK = (TextView) findViewById(f.lucky_money_f2f_qrcode_bottom_tip);
        this.kNJ = (TextView) findViewById(f.lucky_money_f2f_qrcode_top_tip);
        this.kOd = this.kNK.getAlpha();
        this.kNI = (ImageView) this.Iq.findViewById(f.lucky_money_f2f_qrcode);
        this.kNL = (HorizontalListViewV2) findViewById(f.lucky_money_f2f_recv_avatar_list);
        this.kNP = new a(this, (byte) 0);
        this.kNL.setAdapter(this.kNP);
        this.kNL.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyDetailUI.class);
                intent.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.this.kLZ);
                LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
            }
        });
        this.kNL.setOnScrollStateChangedListener(new HorizontalListViewV2.d() {
            public final void sa(int i) {
                if (i == HorizontalListViewV2.d.a.ttj && LuckyMoneyF2FQRCodeUI.this.kNM.size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.this.kNM.size()) < LuckyMoneyF2FQRCodeUI.this.kNY && LuckyMoneyF2FQRCodeUI.this.kNL.getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.this.kNM.size() - 1 && !bi.oW(LuckyMoneyF2FQRCodeUI.this.kLZ)) {
                    LuckyMoneyF2FQRCodeUI.this.l(new w(LuckyMoneyF2FQRCodeUI.this.kLZ, 5, LuckyMoneyF2FQRCodeUI.this.kNM.size(), null, "v1.0"));
                }
            }
        });
        this.kMi = (Button) findViewById(f.lucky_money_f2f_prepare_btn);
        this.kMi.setOnClickListener(new 15(this));
        this.kNQ = (TextView) findViewById(f.lucky_money_f2f_remain_text);
        this.kNE = findViewById(f.lucky_money_f2f_recv_packet);
        setBackBtn(new 2(this));
        setMMTitle(getString(i.lucky_money_f2f_title));
        addIconOptionMenu(0, h.actionbar_icon_dark_more, new 3(this));
        lF(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_actionbar_bg_color));
        cqh();
        this.kNU = (ViewGroup) findViewById(f.lucky_money_f2f_firework_layer_top);
        this.kNV = (ViewGroup) findViewById(f.lucky_money_f2f_firework_layer_bottom);
        this.kNW = findViewById(f.lucky_money_f2f_layer_mask);
        this.kNW.setAlpha(0.0f);
        this.bgR = (SensorManager) getSystemService("sensor");
        this.bgR.registerListener(this.kOu, this.bgR.getDefaultSensor(1), 3);
        this.kNX = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.kNR = (ShuffleView) findViewById(f.lucky_money_f2f_shuffle_view);
        this.kNS = new c();
        this.kNS.kPt = 4;
        this.kNS.kPr = 2;
        this.kNS.kPs = 4;
        this.kNS.kPu = 300;
        this.kNS.scaleY = 0.0f;
        this.kNR.setShuffleSetting(this.kNS);
        ShuffleView.ewi = this.ewi;
        this.kNR.setExitAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300));
        this.kNR.setExitAnimatorListener(new 4(this));
        this.kNR.setCardListener(new 5(this));
        baL();
        this.kOa = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.kOa.setDuration(300);
        this.kOa.setStartDelay(3000);
        this.kOa.addUpdateListener(new 6(this));
        baK();
        getWindow().addFlags(128);
    }

    private void baK() {
        if (!bi.oW(this.ixy)) {
            Bitmap bitmap;
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            int a = QbarNative.a(bArr, iArr, this.ixy, 0, 1, "UTF-8");
            QbarNative.nativeRelease();
            if (a > 0) {
                int i;
                int i2;
                int i3;
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (i4 >= i5) {
                    i4 = i5;
                }
                int i6 = (int) (((double) iArr[0]) * 0.1d);
                i4 = ((int) (((double) i4) * 0.8d)) / (iArr[0] + (i6 * 2));
                if (i4 == 0) {
                    i = 1;
                } else {
                    i = i4;
                }
                int i7 = i6 * i;
                i5 = i * (iArr[0] + (i6 * 2));
                int i8 = (iArr[1] * i) + ((i * 2) * i6);
                Bitmap createBitmap = Bitmap.createBitmap(i5, i8, Config.ARGB_8888);
                int[] iArr2 = new int[(i5 * i8)];
                int i9 = (i * 2) + (i / 2);
                int i10 = (i * 3) + (i / 2);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                Arrays.fill(iArr2, -1);
                int[] iArr3 = new int[]{(i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[0] - 1) - 3) * i) + (i / 2), (i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[1] - 1) - 3) * i) + (i / 2)};
                i4 = 0;
                while (i4 < iArr[1]) {
                    int i11 = 0;
                    while (i11 < iArr[0]) {
                        if (bArr[(iArr[0] * i4) + i11] == (byte) 1) {
                            int i12;
                            if ((i4 < 0 || i4 > 6 || i11 < 0 || i11 > 6) && ((i4 < 0 || i4 > 6 || i11 < iArr[0] - 7 || i11 > iArr[0] - 1) && (i4 < iArr[1] - 7 || i4 > iArr[1] - 1 || i11 < 0 || i11 > 6))) {
                                boolean[] zArr = new boolean[10];
                                zArr[5] = true;
                                if (zArr[(int) (Math.random() * 10.0d)]) {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -3041484;
                                        }
                                    }
                                } else {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -2598591;
                                        }
                                    }
                                }
                            } else {
                                for (i2 = 0; i2 < i; i2++) {
                                    for (i12 = 0; i12 < i; i12++) {
                                        iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -1;
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    i4++;
                }
                createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i8);
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-2598591);
                    paint.setStyle(Style.FILL);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i10, paint);
                    paint.setColor(-1);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i9, paint);
                }
                i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= 3) {
                        break;
                    }
                    paint.setColor(-3041484);
                    paint.setStyle(Style.FILL);
                    Canvas canvas2 = canvas;
                    canvas2.drawRect((float) ((((i * i6) + iArr3[i2 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i2 * 2) + 1]) - i) - ((i * 1) / 4)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[i2 * 2]) + i)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[(i2 * 2) + 1]) + i)), paint);
                    i3 = i2 + 1;
                }
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-1);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    Path path = new Path();
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) - i), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) - i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) + i), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) + i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                }
                if (createBitmap == null) {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), bi.cjd().toString()});
                } else {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
                }
                bitmap = createBitmap;
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), bi.cjd().toString()});
                bitmap = null;
            }
            this.mBitmap = bitmap;
            this.kNI.setImageBitmap(this.mBitmap);
        }
        if (this.kNs <= 0) {
            this.kNI.setPadding(com.tencent.mm.bp.a.fromDPToPix(this, 5), com.tencent.mm.bp.a.fromDPToPix(this, 5), com.tencent.mm.bp.a.fromDPToPix(this, 5), com.tencent.mm.bp.a.fromDPToPix(this, 5));
            this.kNI.setImageResource(e.lucky_money_f2f_empty_qrcode);
            this.kNQ.setVisibility(8);
            this.kMi.setVisibility(0);
            this.kNJ.setVisibility(4);
            this.kND.setPadding(this.kND.getPaddingLeft(), com.tencent.mm.pluginsdk.e.cM(this), this.kND.getPaddingRight(), this.kND.getPaddingBottom());
            if (this.kNM.size() > 0) {
                this.kNK.setText(getString(i.lucky_money_f2f_no_remain_tips));
                return;
            } else {
                this.kNK.setText(getString(i.lucky_money_f2f_not_prepare_tips));
                return;
            }
        }
        this.kNI.setPadding(0, 0, 0, 0);
        this.kNJ.setText(getString(i.lucky_money_f2f_scan_qrcode_tips));
        this.kNJ.setVisibility(0);
        this.kNK.setText(getString(i.lucky_money_f2f_scan_qrcode_tips));
        this.kNQ.setText(getString(i.lucky_money_f2f_remain_tip, new Object[]{Integer.valueOf(this.kNs)}));
        this.kNQ.setVisibility(0);
        this.kMi.setVisibility(8);
    }

    private void baL() {
        Set hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + ".m4a");
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.kNX;
        g.Em().H(new 1(aVar, hashSet, new WeakReference(this)));
        aVar.kMT.setOnLoadCompleteListener(new 2(aVar));
    }

    private void baM() {
        int width = this.kNL.getWidth() - (this.kNM.size() * getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.BigAvatarSize));
        if (width > 0) {
            this.kNL.setPadding(width / 2, 0, width / 2, 0);
        } else {
            this.kNL.setPadding(0, 0, 0, 0);
        }
    }

    private void baN() {
        if (this.kNT.size() != this.kNs) {
            x.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[]{Integer.valueOf(this.kNT.size()), Integer.valueOf(this.kNs)});
            this.kNT.clear();
            for (int i = 0; i < this.kNs; i++) {
                View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.lucky_money_f2f_packet_card_view, this.kNR, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.kNT.add(inflate);
            }
            this.kNR.setAllShuffleCards(this.kNT);
        }
    }

    protected void onResume() {
        super.onResume();
        b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), true);
        this.eVk.J(60000, 60000);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.kOe, true);
        jr(1642);
        jr(1990);
        jr(1987);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        aw.a(this, this);
        if (this.bgR != null) {
            this.bgR.registerListener(this.kOu, this.bgR.getDefaultSensor(1), 3);
        }
    }

    protected void onStop() {
        super.onStop();
        this.eVk.SO();
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.kOe, true);
        js(1990);
        js(1642);
        js(1987);
        aw.a(this, null);
    }

    protected void onPause() {
        super.onPause();
        if (this.bgR != null) {
            this.bgR.unregisterListener(this.kOu);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(14007, new Object[]{Integer.valueOf(this.eRw[0]), Integer.valueOf(this.eRw[1]), Integer.valueOf(this.eRw[2]), Integer.valueOf(this.eRw[3]), Integer.valueOf(this.eRw[4]), Integer.valueOf(this.eRw[5])});
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.kNX;
        aVar.gYf = true;
        aVar.kMT.release();
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.lucky_money_f2f_qrcode_ui;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        int i3 = 0;
        x.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
                x.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.kLZ);
                if (!(bi.G(new String[]{this.kLZ, ((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kLZ}) || this.kLZ.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kLZ))) {
                    this.kNM.clear();
                    this.kNN.clear();
                    this.kNO.clear();
                    this.kNP.notifyDataSetChanged();
                    this.kNZ = "";
                }
                if (!bi.oW(((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kLZ)) {
                    this.kLZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kLZ;
                }
                this.ixy = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).ixy;
                this.kNs = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kNs;
                this.kNr = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) lVar).kNr;
                baK();
                baN();
                if (this.kNs == 0) {
                    this.eVk.SO();
                }
                if (this.kNM.size() == 0 && !bi.oW(this.kLZ)) {
                    b(new w(this.kLZ, 5, 0, null, "v1.0"), false);
                }
            } else if (lVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.kLZ = "";
                this.ixy = "";
                this.kNs = 0;
                this.kNM.clear();
                this.kNZ = "";
                this.kNP.notifyDataSetChanged();
                baK();
                baN();
                this.eVk.SO();
                if (!bi.oW(this.kNr)) {
                    com.tencent.mm.ui.base.h.bA(this, this.kNr);
                }
            } else if (lVar instanceof w) {
                this.kNY = ((w) lVar).kQP.kPP;
                List list = ((w) lVar).kQP.kQe;
                if (list != null && list.size() > 0) {
                    while (i3 < list.size()) {
                        com.tencent.mm.plugin.luckymoney.b.n nVar = (com.tencent.mm.plugin.luckymoney.b.n) list.get(i3);
                        if (!(bi.oW(nVar.kPS) || this.kNM.contains(nVar.kPS))) {
                            this.kNM.add(nVar.kPS);
                            String jR = q.KJ().jR(nVar.kQD);
                            if (!bi.oW(nVar.kQF)) {
                                this.kNZ = jR;
                            }
                            this.kNN.put(nVar.kPS, jR);
                        }
                        i3++;
                    }
                    baM();
                    this.kNP.notifyDataSetChanged();
                }
            }
        } else if (!bi.oW(str)) {
            com.tencent.mm.ui.base.h.b(this, str, getString(i.app_tip), true);
        }
        return true;
    }

    public final void aou() {
        x.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.kNs > 0) {
            baK();
            int[] iArr = this.eRw;
            iArr[1] = iArr[1] + 1;
            com.tencent.mm.ui.base.h.b(this, getString(i.lucky_money_f2f_screen_shot_tips), null, true);
        }
    }
}
