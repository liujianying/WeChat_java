package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends i implements e, a {
    private static int mKB = l.CTRL_BYTE;
    private int mFO;
    private TextView mHt;
    private View mHu;
    private long mKC = 130;
    g mKD;
    private int mKE = 0;
    private int mKF = 1;
    private long mKG;
    private final int mKH = 260;
    private final int mKI = l.CTRL_BYTE;
    private final int mKJ = 390;
    private final int mKK = 450;
    private final int mKL = 220;
    private final int mKM = 240;
    private final int mKN = 330;
    private final int mKO = 360;
    private float mKP;
    private final long mKQ = 30000;
    private long mKR;
    private final int mKS = 50;
    private com.tencent.mm.plugin.scanner.util.e.a mKT = new com.tencent.mm.plugin.scanner.util.e.a() {
        public final void o(int i, Bundle bundle) {
            switch (i) {
                case 3:
                    k.this.mKp.bsA();
                    return;
                default:
                    return;
            }
        }
    };
    private OnTouchListener mKU;

    public k(b bVar, Point point) {
        super(bVar, point);
        if (d.zf()) {
            do(220, 240);
            this.mKP = p.dq(330, this.mKl);
        } else {
            do(260, l.CTRL_BYTE);
            this.mKP = p.dq(390, this.mKl);
        }
        x.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", Integer.valueOf(this.mKl), Integer.valueOf(this.mKm), Float.valueOf(this.mKP));
        if (bi.fQ(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.mKC = 300;
        }
        this.mFO = (int) (System.currentTimeMillis() & -1);
        this.mKR = System.currentTimeMillis();
    }

    protected final void j(Rect rect) {
        this.mHu = this.mKp.findViewById(R.h.scan_no_data_mask);
        this.mHt = (TextView) this.mKp.findViewById(R.h.scan_no_network_tips);
        this.gmo = (TextView) this.mKp.findViewById(R.h.scan_tip_tv);
        this.gmo.setText(p.et(p.mOc, this.mKp.getContext().getString(R.l.scan_img_tips_focus)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.gmo.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.mKp.getContext(), 13.0f);
            this.gmo.setLayoutParams(layoutParams);
        }
        if (d.zf()) {
            this.gmo.setPadding(BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingTop(), BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingBottom());
        }
        if (this.mKj != null) {
            ((j) this.mKj).lhy = this.mKp.bsz();
        }
        bsN();
        hw(true);
    }

    protected final void bsn() {
        j(new Rect(0, 0, 0, 0));
        this.mKp.b(4, null);
        onResume();
    }

    protected final int bsl() {
        return R.i.scan_image_body;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bsk() {
        if (this.mKj == null) {
            int i = 50;
            if (q.deM.ddb > 0) {
                i = q.deM.ddb;
                x.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", Integer.valueOf(q.deM.ddb));
            }
            if (ao.is2G(this.mKp.getContext())) {
                this.mKj = new j(this, i - 10, this.mKP, false, this.mKp.bsz());
            } else {
                this.mKj = new j(this, i, this.mKP, false, this.mKp.bsz());
            }
        }
        return this.mKj;
    }

    protected final void bsj() {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else {
            bsN();
        }
    }

    private void bsN() {
        if (this.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
        } else if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
            this.mKp.ev(0);
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else if (bArr2 == null || bArr2.length <= 0) {
            x.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.mKG <= 1800 + this.mKC || !((j) this.mKj).mNK) {
                this.mKp.eu(this.mKC);
                return;
            }
            this.mKG = System.currentTimeMillis();
            this.mKp.ev(0);
        } else {
            bsO();
            if (this.mKE >= this.mKF) {
                x.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.mKp.eu(this.mKC);
                if (System.currentTimeMillis() - this.mKG <= 1800 + this.mKC || !((j) this.mKj).mNK) {
                    this.mKp.eu(this.mKC);
                    return;
                }
                this.mKG = System.currentTimeMillis();
                this.mKp.ev(0);
                return;
            }
            this.mKD = new g(bArr2, bArr2.length, this.mFO);
            au.DF().a(this.mKD, 0);
            this.mKE++;
            this.mKq += bArr2.length;
            x.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", Integer.valueOf(this.mKq));
            if (System.currentTimeMillis() - this.mKG <= 1800 + this.mKC || !((j) this.mKj).mNK) {
                this.mKp.eu(this.mKC);
                return;
            }
            this.mKG = System.currentTimeMillis();
            this.mKp.ev(0);
        }
    }

    public final void bsf() {
        x.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        bsO();
        if (System.currentTimeMillis() - this.mKG <= 1800 + this.mKC || !((j) this.mKj).mNK) {
            this.mKp.eu(this.mKC);
            return;
        }
        this.mKG = System.currentTimeMillis();
        this.mKp.ev(0);
    }

    private void bsO() {
        ah.A(new 2(this));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        this.mKE = 0;
        if (this.mKp == null || lVar == null) {
            boolean z;
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            if (lVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
        } else if (lVar.getType() == 1062) {
            if (i == 0 && i2 == 0) {
                this.mKE = this.mKF;
                g gVar = (g) lVar;
                im imVar = (gVar.diG == null || gVar.diG.dIE.dIL == null) ? null : (im) gVar.diG.dIE.dIL;
                if (imVar != null) {
                    x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", Integer.valueOf(imVar.rjz), Integer.valueOf(imVar.rjD));
                    switch (n.a(imVar.hcE, imVar.rjF, this, 3, this.mKT, 0, 0, false)) {
                        case 0:
                            this.mKp.bss();
                            if (!(this.mKp == null || this.mKp.getContext() == null)) {
                                this.mKp.bsA();
                                break;
                            }
                        case 1:
                            x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                return;
            }
            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            this.gmo.setText(p.et(p.mOc, this.mKp.getContext().getString(R.l.scan_img_tips_focus)));
            if (this.mKD != null) {
                au.DF().c(this.mKD);
            }
        }
    }

    protected final void onResume() {
        au.DF().a(1062, (e) this);
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        this.mKE = 0;
        bsN();
    }

    protected final void onPause() {
        super.onPause();
        hw(false);
        au.DF().b(1062, (e) this);
    }

    protected final int bsm() {
        return mKB;
    }

    protected final void onDestroy() {
    }

    protected final boolean bso() {
        return true;
    }

    protected final boolean bsp() {
        return true;
    }

    public final void E(Bundle bundle) {
    }
}
