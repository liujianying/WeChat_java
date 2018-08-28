package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.af.a.c.a;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b$a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.plugin.scanner.util.d.AnonymousClass1;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p extends i implements e, a, i.a, b$a {
    int bJM = 0;
    int bufferSize;
    Object dMd = new Object();
    long mKC = 80;
    private com.tencent.mm.plugin.scanner.util.e.a mKT = new 1(this);
    d mLf;
    AtomicBoolean mLg = new AtomicBoolean(false);
    boolean mLh = false;
    boolean mLi = false;
    private Set<Integer> mLj;
    private float mLk = 1.5f;
    byte[] mLl;
    Point mLm;
    int mLn;
    private TextView mLo;
    boolean mLp = false;
    private OnClickListener mLq = new 2(this);
    private int mMode = 0;

    static /* synthetic */ void a(p pVar) {
        pVar.mLi = true;
        pVar.mLh = true;
        pVar.mKp.bsy();
    }

    public p(b bVar, Point point, int i, int i2) {
        super(bVar, point);
        do(244, 244);
        this.bJM = i;
        this.mMode = i2;
        this.mKr = true;
        this.mKh = 1000;
        if (bi.fQ(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.mKC = 280;
        }
    }

    public p(b bVar, Point point, int i, Set<Integer> set) {
        super(bVar, point);
        do(244, 244);
        this.bJM = i;
        this.mLj = set;
        this.mKr = true;
        this.mKh = 1000;
        if (bi.fQ(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.mKC = 280;
        }
    }

    protected final void h(Point point) {
        this.mKi = null;
        super.h(point);
    }

    protected final Rect hx(boolean z) {
        Rect rect = new Rect(B(true, z));
        x.i("MicroMsg.scanner.ScanModeQRCode", "display rect:" + rect);
        int width = rect.width();
        int height = rect.height();
        int i = (int) (((float) width) * this.mLk);
        int i2 = (int) (((float) height) * this.mLk);
        if (i > this.mKk.x) {
            i = this.mKk.x;
        }
        if (i2 > this.mKk.y) {
            i2 = this.mKk.y;
        }
        if (i2 % 2 == 1) {
            i2--;
        }
        if (i % 2 == 1) {
            i--;
        }
        x.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        rect.left -= (i - width) / 2;
        rect.right = ((i - width) / 2) + rect.right;
        rect.top -= (i2 - height) / 2;
        rect.bottom += (i2 - height) / 2;
        x.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:" + rect);
        return rect;
    }

    public final void bsP() {
        this.mKr = false;
    }

    public final boolean bsQ() {
        return this.mKr;
    }

    protected final void j(Rect rect) {
        this.mLo = (TextView) this.mKp.findViewById(R.h.scan_to_my_qrcode);
        this.mLo.setOnClickListener(this.mLq);
        this.gmo = (TextView) this.mKp.findViewById(R.h.scan_tip_tv);
        if (rect.bottom > 0) {
            this.mLo.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.gmo.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.mKp.getContext(), 13.0f);
            this.gmo.setLayoutParams(layoutParams);
        }
        if (this.mLf != null) {
            this.mLf.lhy = this.mKp.bsz();
        }
        bsN();
        if (this.mMode == 2) {
            this.gmo.setText(R.l.qbar_tip_only_zbar);
        } else if (this.mMode == 1) {
            this.gmo.setText(R.l.qbar_tip_only_qrcode);
        } else if (this.bJM == 1) {
            this.gmo.setText(R.l.qrcode_tip_in_discount_from_addmorefriend);
        } else if (this.bJM == 2) {
            this.gmo.setText(R.l.webwx_login_introduction);
        } else {
            this.gmo.setText(R.l.qrcode_tip_in_discount_from_friend);
        }
        hw(true);
    }

    protected final void bsn() {
        j(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.mKp.b(4, null);
        } else {
            this.mKp.b(0, new 3(this));
        }
        this.mKp.a(this);
        onResume();
    }

    protected final int bsl() {
        return R.i.scan_qrcode_body;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bsk() {
        if (this.mLf == null && this.mKp != null) {
            this.mLf = new d(this, this.mMode, this.mKp.bsz());
        }
        return this.mLf;
    }

    protected final void bsj() {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
        } else {
            bsN();
        }
    }

    private void bsN() {
        if (this.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
        } else if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
            this.mKp.ev(0);
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.mLg.set(false);
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (this.mLh) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
        } else {
            this.mLh = true;
            x.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[]{str});
            if (bi.oW(str)) {
                this.mLh = false;
            } else if (au.DF().Lg() == 0) {
                Toast.makeText(this.mKp.getContext(), this.mKp.getContext().getString(R.l.fmt_iap_err), 0).show();
                this.mLh = false;
            } else {
                m.mNW.stop();
                a(i, str, bArr, i2, i3);
            }
        }
    }

    private void a(int i, String str, byte[] bArr, int i2, int i3) {
        int i4 = 1;
        Activity context = this.mKp.getContext();
        mb mbVar = new mb();
        if (i == 1) {
            mbVar.bWC.bWE = 0;
        } else {
            mbVar.bWC.bWE = 1;
        }
        mbVar.bWC.scanResult = str;
        if (this.mLp) {
            x.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            mbVar.bWC.bWA = 1;
            com.tencent.mm.sdk.b.a.sFg.m(mbVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_raw", bArr);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            context.setResult(-1, intent);
            context.finish();
            context.overridePendingTransition(0, 0);
            return;
        }
        mbVar.bWC.bWA = 0;
        com.tencent.mm.sdk.b.a.sFg.m(mbVar);
        if (mbVar.bWD.ret == 1 || mbVar.bWD.ret == 2) {
            context.finish();
            context.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.mKp.bss();
            this.mKp.hu(true);
            this.mLh = false;
            if (mbVar.bWD.ret != 2) {
                if (!this.mLi) {
                    i4 = 0;
                }
                this.mKp.a(str, i4, i2, i3, this.mKT);
            }
        } else if (i != 2) {
        } else {
            if (str == null || str.length() <= 0) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
                this.mLh = false;
                this.mKp.hu(false);
                return;
            }
            String[] split = str.split(",", 2);
            if (split == null || split.length < 2) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
                this.mLh = false;
                this.mKp.hu(false);
                return;
            }
            f fVar = new f(com.tencent.mm.plugin.scanner.util.p.KS(split[0]), split[1], i2, i3);
            fVar.mFP = this.mLi;
            au.DF().a(fVar, 0);
            this.mKp.bss();
            this.mKp.hu(true);
            Context context2 = this.mKp.getContext();
            this.mKp.getContext().getString(R.l.app_tip);
            this.eHw = h.a(context2, this.mKp.getContext().getString(R.l.qrcode_scan_default), true, new 5(this, fVar));
        }
    }

    public final void bsf() {
        x.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail");
        this.mLg.set(false);
        synchronized (this.dMd) {
            bsR();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (this.mKp == null || lVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(lVar == null);
            x.e(str2, str3, objArr);
            this.mLh = false;
        } else if (i == 4 && i2 == -4) {
            h.a(this.mKp.getContext(), R.l.qrcode_no_user_tip, R.l.app_tip, new 4(this));
        } else {
            boolean z;
            switch (i) {
                case 1:
                    if (au.DF().Lh()) {
                        this.mKp.getContext();
                        au.DF().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (ab.bU(this.mKp.getContext())) {
                        j.eY(this.mKp.getContext());
                    } else {
                        Toast.makeText(this.mKp.getContext(), this.mKp.getContext().getString(R.l.fmt_http_err, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    z = true;
                    break;
                case 2:
                    Toast.makeText(this.mKp.getContext(), this.mKp.getContext().getString(R.l.fmt_iap_err, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                hk(true);
            } else if (i == 4 && i2 == -2004) {
                h.i(this.mKp.getContext(), R.l.qrcode_ban_by_expose, R.l.app_tip);
                hk(true);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.mKp.getContext(), this.mKp.getContext().getString(R.l.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                hk(true);
            } else if (lVar.getType() == 1061) {
                ik bsb = ((f) lVar).bsb();
                if (bsb == null) {
                    x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    hk(true);
                    return;
                }
                x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(bsb.hcE)});
                if (bi.oW(bsb.rjl)) {
                    hk(true);
                    return;
                }
                switch (n.a(bsb.hcE, bsb.rjl, this, 4, this.mKT, ((f) lVar).bJr, ((f) lVar).bJs, ((f) lVar).mFP)) {
                    case 0:
                        this.mKp.getContext().finish();
                        this.mKp.getContext().overridePendingTransition(0, 0);
                        return;
                    case 1:
                        x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.mKp.ev(0);
                        break;
                }
                this.mKp.hu(false);
            } else if (lVar.getType() == 666) {
                if (lVar instanceof u) {
                    this.mKp.hu(true);
                    this.mKp.getContext().finish();
                    this.mKp.getContext().overridePendingTransition(0, 0);
                }
            } else if (lVar.getType() == 971) {
                this.mKp.hu(true);
                this.mKp.getContext().finish();
                this.mKp.getContext().overridePendingTransition(0, 0);
            }
        }
    }

    protected final void onResume() {
        au.DF().a(1061, this);
        au.DF().a(666, this);
        au.DF().a(971, this);
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            return;
        }
        if (!this.mLi) {
            this.mLh = false;
        }
        bsN();
    }

    protected final void onPause() {
        super.onPause();
        hw(false);
        au.DF().b(1061, this);
        au.DF().b(666, this);
        au.DF().b(971, this);
    }

    protected final int bsm() {
        return 244;
    }

    public final void b(Activity activity, int i, int i2, Intent intent) {
        if (activity != null) {
            this.mLh = true;
            if (i2 != -1) {
                this.mLh = false;
                this.mLg.set(false);
                this.mLi = false;
                return;
            }
            switch (i) {
                case 1:
                    this.mKp.bsB();
                    return;
                case 4660:
                    if (intent == null) {
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                        this.mLh = false;
                        this.mLg.set(false);
                        this.mLi = false;
                        return;
                    }
                    this.mLg.set(true);
                    au.HU();
                    x.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[]{com.tencent.mm.ui.tools.a.e(activity, intent, c.Gb())});
                    new ag().post(new 6(this, activity));
                    if (this.mLf != null) {
                        this.mLf.ll();
                    }
                    if (this.mKp != null) {
                        this.mKp.hu(true);
                    }
                    com.tencent.mm.plugin.scanner.a.l.mFT.reset();
                    com.tencent.mm.plugin.scanner.c.brY().mFg.a(r0, new 7(this, activity), null);
                    return;
                default:
                    return;
            }
        }
    }

    protected final void onDestroy() {
        this.mLl = null;
    }

    public final Context getContext() {
        if (this.mKp != null) {
            return this.mKp.getContext();
        }
        x.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
        return null;
    }

    public final void hk(boolean z) {
        if (this.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
        } else if (z) {
            this.mKp.hu(false);
        } else {
            this.mKp.getContext().finish();
            this.mKp.getContext().overridePendingTransition(0, 0);
        }
    }

    protected final boolean bso() {
        return true;
    }

    protected final boolean bsp() {
        return true;
    }

    public final void E(Bundle bundle) {
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.mKp != null) {
            this.mKp.V(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
    }

    private void bsR() {
        if (!this.mLg.get() && this.bufferSize > 0) {
            this.mLg.set(true);
            this.bufferSize--;
            if (this.mLj != null && this.mLj.size() > 0) {
                ((d) bsk()).mLj = this.mLj;
            } else if (com.tencent.mm.plugin.scanner.a.l.mFT.mFW % 2 == 0 && (this.mMode == 1 || this.mMode == 0)) {
                ((d) bsk()).mMN = 3;
            } else {
                ((d) bsk()).mMN = this.mMode;
            }
            x.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
            if (com.tencent.mm.plugin.scanner.a.l.mFT.mFW > 0 && this.mKp != null) {
                this.mKp.eu(30);
            }
            if (!(this.mLl == null || this.mLm == null)) {
                d dVar = (d) bsk();
                if (dVar.fOL) {
                    Set set = dVar.mLj;
                    if (set == null || set.isEmpty()) {
                        set = d.vD(dVar.mMN);
                    }
                    dVar.h(set);
                }
                com.tencent.mm.sdk.f.e.b(new AnonymousClass1(this.mLl, this.mLm), "scan_decode", 10);
            }
            if (com.tencent.mm.plugin.scanner.a.l.mFT.mFW == 30 && this.mKp != null) {
                this.mKp.bsD();
            }
        } else if (this.mKp != null) {
            this.mKp.eu(0);
        }
    }

    protected final void a(byte[] bArr, Point point, int i, Rect rect) {
        synchronized (this.dMd) {
            if (this.bufferSize == 1) {
                x.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
                this.bufferSize = 0;
            }
        }
        if (this.mLm == null) {
            this.mLm = new Point();
        }
        com.tencent.mm.sdk.f.e.post(new 8(this, bArr, point, i, rect), "prepare_decode_data");
    }
}
