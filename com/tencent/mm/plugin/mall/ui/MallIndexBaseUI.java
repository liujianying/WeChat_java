package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI extends WalletBaseUI implements a, j {
    protected String fMk;
    private String kUp = null;
    private String kXX = null;
    private ArrayList<MallFunction> kXY = null;
    protected int kYc;
    private TextView kZg = null;
    protected ListView kZh = null;
    private b kZi = null;
    protected ImageView kZj = null;
    protected ImageView kZk;
    protected TextView kZl = null;
    protected TextView kZm;
    private int kZn = 0;
    private boolean kZo = true;
    private boolean kZp = false;

    protected abstract void bbO();

    protected abstract void bbP();

    protected abstract void bbQ();

    protected abstract boolean bbS();

    protected abstract void bbW();

    protected abstract void bbX();

    protected abstract void bbZ();

    protected abstract void bca();

    protected abstract void cs(View view);

    protected final int getLayoutId() {
        return g.mall_index_ui;
    }

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            x.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        com.tencent.mm.kernel.g.Ek();
        int intValue = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
        this.kYc = getIntent().getIntExtra("key_wallet_region", intValue);
        this.fMk = getIntent().getStringExtra("key_uuid");
        if (!bi.oW(this.fMk)) {
            this.fMk = UUID.randomUUID().toString();
        }
        jr(495);
        o.bPd();
        com.tencent.mm.plugin.wallet_core.model.aa.a(this);
        this.kXX = getIntent().getStringExtra("key_func_id");
        x.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.kXX + " wallet_region: " + this.kYc + " walletType: " + q.GM() + " default_region: " + intValue);
        this.kUp = getIntent().getStringExtra("key_native_url");
        x.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.kUp);
        if (!bbR()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.mall_index_topbar_color));
            }
            if (d.fR(21)) {
                getWindow().setStatusBarColor(getResources().getColor(c.wallet_mall_index_status_bar_color));
            }
            s.cqp();
            ux(0);
            x.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            bbO();
            initView();
            com.tencent.mm.plugin.wallet_core.model.mall.c.bPN();
            bbP();
            x.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            bbQ();
            if (q.GS()) {
                x.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                k kVar = (k) com.tencent.mm.kernel.g.l(k.class);
                if (kVar != null) {
                    x.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    kVar.dh(this);
                } else {
                    x.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            com.tencent.mm.wallet_core.c.q.fu(1, 0);
            h.mEJ.h(11850, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
            if (VERSION.SDK_INT >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
            lF(this.mController.tml.getResources().getColor(c.transparent));
        }
    }

    public final boolean bbR() {
        if (bi.oW(this.kXX) && bi.oW(this.kUp)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        boolean z = true;
        super.onResume();
        i.Cx(1);
        x.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            x.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (bbR()) {
            this.kXY = com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc);
            if (this.kXY == null || this.kXY.size() <= 0) {
                x.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !bi.oW(this.kUp)) {
                        a(new com.tencent.mm.plugin.mall.a.a(this.kYc, b.bPJ()), true, false);
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    a(new com.tencent.mm.plugin.mall.a.a(this.kYc, b.bPJ(), getIntent().getStringExtra("key_app_id"), this.kXX, stringExtra), true, false);
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    bbV();
                    return;
                }
            }
            MallFunction bx = bx(this.kXY);
            if (bx == null) {
                bx = by(this.kXY);
            }
            a(bx, -1);
            finish();
            return;
        }
        bbS();
        x.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc) == null) {
            a(new com.tencent.mm.plugin.mall.a.a(this.kYc, b.bPJ()), true, false);
            x.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            z = false;
        } else {
            a(new com.tencent.mm.plugin.mall.a.a(this.kYc, b.bPJ()), false, false);
            this.kXY = com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc);
        }
        if (z) {
            x.i("MicroMsg.MallIndexBaseUI", "has data");
            aL();
        }
    }

    private void bbT() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.kZh.getChildCount() != 0) {
            x.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[]{Boolean.valueOf(booleanExtra), Integer.valueOf(this.kZh.getFirstVisiblePosition()), Integer.valueOf(this.kZh.getChildAt(0).getTop())});
            if (this.kZh.getFirstVisiblePosition() == 0 && r2 == 0 && booleanExtra && !this.kZp && this.kXY != null) {
                this.kZp = true;
                int headerViewsCount = this.kZh.getHeaderViewsCount() + this.kZi.getCount();
                List list = this.kZi.kYB;
                if (list != null) {
                    for (int size = list.size() - 1; size > 0; size--) {
                        Iterator it = ((ArrayList) list.get(size)).iterator();
                        while (it.hasNext()) {
                            b.c cVar = (b.c) it.next();
                            if (cVar != null && cVar.kZe != null && b.a(cVar.kZe)) {
                                x.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[]{Integer.valueOf(this.kZh.getFirstVisiblePosition()), Integer.valueOf(this.kZh.getLastVisiblePosition()), Integer.valueOf(headerViewsCount)});
                                if (headerViewsCount < this.kZh.getFirstVisiblePosition() || headerViewsCount > r1) {
                                    size = a.bbM();
                                    int bbL = (a.bbL() + (a.bbK() * (headerViewsCount + 1))) + size;
                                    if (headerViewsCount > 2) {
                                        bbL += size;
                                    }
                                    if (headerViewsCount > 3) {
                                        bbL += size;
                                    }
                                    size = (bbL + (a.bbK() / 3)) - this.kZh.getScrollY();
                                    bbL = ak.gu(this).y;
                                    if (ak.gt(this)) {
                                        bbL -= ak.gs(this);
                                    }
                                    if (getSupportActionBar() != null) {
                                        bbL -= getSupportActionBar().getHeight();
                                    }
                                    this.kZh.smoothScrollBy(size - bbL, 1000);
                                    return;
                                }
                                return;
                            }
                        }
                        headerViewsCount--;
                    }
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i) {
        int i2;
        if (mallFunction != null && i >= 0) {
            String str = "";
            if (!(mallFunction.prU == null || bi.oW(mallFunction.prU.oqH))) {
                str = mallFunction.prU.oqH;
            }
            int size = this.kXY == null ? 0 : this.kXY.size();
            boolean a = b.a(mallFunction);
            h hVar = h.mEJ;
            Object[] objArr = new Object[6];
            objArr[0] = mallFunction.moy;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = str;
            if (a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            hVar.h(10881, objArr);
        }
        if (mallFunction == null || bi.oW(mallFunction.ceR) || !((e) com.tencent.mm.kernel.g.l(e.class)).uo(mallFunction.ceR)) {
            if (mallFunction != null) {
                com.tencent.mm.plugin.wallet_core.model.mall.c.bPK().Pf(mallFunction.moy);
                com.tencent.mm.plugin.wallet_core.model.mall.d.bPO().Pf(mallFunction.moy);
                if (mallFunction.prU != null) {
                    com.tencent.mm.plugin.wallet_core.model.mall.c.bPK();
                    com.tencent.mm.plugin.wallet_core.model.mall.c.c(mallFunction);
                }
                if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.ceR)) {
                    i2 = 0;
                } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.ceR)) {
                    i2 = 4;
                } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.ceR)) {
                    i2 = 8;
                } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.ceR)) {
                    i2 = 5;
                } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.ceR)) {
                    i2 = 6;
                } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.ceR)) {
                    i2 = 7;
                } else if (!bi.oW(mallFunction.kck)) {
                    i2 = 1;
                } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.ceR)) {
                    i2 = 9;
                } else {
                    x.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            x.i("MicroMsg.MallIndexBaseUI", "functionType : " + i2);
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (bbR()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bg.d.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
                    com.tencent.mm.wallet_core.c.q.fu(15, 0);
                    return;
                case 1:
                    com.tencent.mm.kernel.g.Ek();
                    this.kYc = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.kck);
                    intent.putExtra("geta8key_username", q.GF());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    intent.putExtra("key_download_restrict", mallFunction.prW);
                    intent.putExtra("key_wallet_region", this.kYc);
                    intent.putExtra("key_function_id", mallFunction.moy);
                    intent.putExtra("geta8key_scene", 46);
                    com.tencent.mm.bg.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    x.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    x.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    com.tencent.mm.ui.base.s.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bg.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    com.tencent.mm.wallet_core.c.q.fu(13, 0);
                    h.mEJ.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(0)});
                    return;
                case 5:
                    h.mEJ.h(11458, new Object[]{Integer.valueOf(1)});
                    if (q.GS()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(com.tencent.mm.plugin.wxpay.a.i.remittance_title));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(com.tencent.mm.plugin.wxpay.a.i.collect_title));
                        linkedList2.add(Integer.valueOf(1));
                        com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.remittance_collect_title), linkedList, linkedList2, null, true, new 4(this));
                    } else {
                        com.tencent.mm.kernel.g.Ek();
                        if (((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sPD, Boolean.valueOf(false))).booleanValue()) {
                            bbY();
                        } else {
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sPD, Boolean.valueOf(true));
                            com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.wallet_index_ui_ftf_notice), "", new 5(this));
                        }
                    }
                    com.tencent.mm.wallet_core.c.q.fu(14, 0);
                    h.mEJ.h(11850, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.bg.d.b(this.mController.tml, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    com.tencent.mm.wallet_core.c.q.fu(9, 0);
                    h.mEJ.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                    return;
                case 7:
                    intent = new Intent();
                    if (bbR()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bg.d.b(this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.bg.d.b(this.mController.tml, "scanner", ".ui.BaseScanUI", intent);
                    return;
                case 9:
                    com.tencent.mm.bg.d.A(this.mController.tml, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        }
        x.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[]{mallFunction.ceR});
        com.tencent.mm.plugin.wallet_core.model.mall.c.bPK().Pf(mallFunction.moy);
        com.tencent.mm.plugin.wallet_core.model.mall.d.bPO().Pf(mallFunction.moy);
        if (mallFunction.prU != null) {
            com.tencent.mm.plugin.wallet_core.model.mall.c.bPK();
            com.tencent.mm.plugin.wallet_core.model.mall.c.c(mallFunction);
        }
    }

    public void onDestroy() {
        js(495);
        o.bPd();
        com.tencent.mm.plugin.wallet_core.model.aa.b(this);
        super.onDestroy();
    }

    public boolean d(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            x.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.kZo) {
                this.kZo = false;
                if (o.bOS().bPU().bPp()) {
                    com.tencent.mm.wallet_core.a.b(this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (lVar.getType()) {
            case 495:
                com.tencent.mm.plugin.mall.a.a aVar = (com.tencent.mm.plugin.mall.a.a) lVar;
                if (aVar.kYc != this.kYc) {
                    x.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[]{Integer.valueOf(this.kYc), Integer.valueOf(aVar.kYc)});
                }
                if (bbR()) {
                    x.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i != 0 || i2 != 0 || aVar.kXY == null || aVar.kXY.size() <= 0) {
                        bbV();
                        return true;
                    }
                    MallFunction bx;
                    if (getIntent().getIntExtra("key_scene", 0) == 1) {
                        bx = bx(aVar.kXY);
                        if (bx != null) {
                            a(bx, -1);
                        }
                    } else if (!bi.oW(this.kUp)) {
                        x.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[]{this.kUp});
                        bx = by(aVar.kXY);
                        if (bx != null) {
                            a(bx, -1);
                        } else {
                            bbV();
                            return true;
                        }
                    } else if (aVar.kXY != null && aVar.kXY.size() > 0) {
                        x.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                        a(bx(aVar.kXY), -1);
                    } else if (com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc) == null || com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc).size() <= 0) {
                        x.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                    } else {
                        x.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                        a(bx(com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc)), -1);
                    }
                    setResult(-1);
                    finish();
                    return true;
                }
                if (i == 0 && i2 == 0 && com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc) != null && aVar.kXY != null && aVar.kXY.size() > 0) {
                    this.kXY = com.tencent.mm.plugin.mall.a.d.bbJ().sr(this.kYc);
                    x.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.kYc + " " + this.kXY.size());
                    com.tencent.mm.plugin.wallet_core.model.mall.c.bPK().Q(this.kXY);
                }
                aL();
                bbT();
                return true;
            default:
                return false;
        }
    }

    private MallFunction bx(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.kXX)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            MallFunction mallFunction = (MallFunction) list.get(i2);
            if (mallFunction != null && this.kXX.equals(mallFunction.moy)) {
                return mallFunction;
            }
            i = i2 + 1;
        }
    }

    private MallFunction by(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.kUp)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            MallFunction mallFunction = (MallFunction) list.get(i2);
            if (mallFunction != null && this.kUp.equals(mallFunction.ceR)) {
                return mallFunction;
            }
            i = i2 + 1;
        }
    }

    protected final boolean aWj() {
        if (!bbR()) {
            aL();
        }
        return true;
    }

    public final boolean bbU() {
        return false;
    }

    public final void m(String str, Bitmap bitmap) {
    }

    private void bbV() {
        setResult(0);
        finish();
    }

    public final void aL() {
        showOptionMenu(true);
        b bVar = this.kZi;
        ArrayList arrayList = this.kXY;
        bVar.kYB.clear();
        if (arrayList != null) {
            int i;
            int i2;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList2 = new ArrayList();
                i = 0;
                while (i < 3 && i3 + i < arrayList.size()) {
                    int i4 = i3 + i;
                    if (i > 0) {
                        i2 = (i3 + i) - 1;
                        if (i2 >= 0 && ((MallFunction) arrayList.get(i2)).type != ((MallFunction) arrayList.get(i4)).type) {
                            break;
                        }
                    }
                    b.c cVar = new b.c(bVar);
                    cVar.kZf = i3 + i;
                    cVar.kZe = (MallFunction) arrayList.get(i3 + i);
                    arrayList2.add(cVar);
                    i++;
                }
                if (arrayList2.size() > 0) {
                    bVar.kYB.add(arrayList2);
                }
                i3 += i;
            }
            bVar.kYE = 0;
            bVar.kYF = 0;
            i = -1;
            for (ArrayList arrayList3 : bVar.kYB) {
                if (arrayList3.size() > 0) {
                    if (i != -1 && i != ((b.c) arrayList3.get(0)).kZe.type) {
                        break;
                    }
                    bVar.kYE += arrayList3.size();
                    bVar.kYF++;
                    i2 = ((b.c) arrayList3.get(0)).kZe.type;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bVar.kYF--;
        }
        bVar.kYb = com.tencent.mm.plugin.mall.a.d.bbJ().sq(bVar.kYc).kYb;
        bVar.kYG = bVar.bbN();
        x.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[]{Boolean.valueOf(bVar.kYG)});
        bVar.notifyDataSetChanged();
        bbX();
        bbZ();
        if (this.kZg != null) {
            this.kZg.setVisibility(8);
        }
        bca();
    }

    public void onStop() {
        super.onStop();
    }

    public final void initView() {
        x.d("MicroMsg.MallIndexBaseUI", "index initView");
        setBackBtn(new 1(this));
        a.f(this);
        this.kZh = (ListView) findViewById(f.mall_index_function_list);
        View inflate = y.gq(this).inflate(g.mall_index_stub_with_bankcard, null);
        this.kZh.addHeaderView(inflate);
        LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
        }
        layoutParams.height = a.bbL();
        inflate.setLayoutParams(layoutParams);
        this.kZi = new b(this, this.kYc);
        this.kZh.setAdapter(this.kZi);
        this.kZi.kYC = new 2(this);
        cs(inflate);
        this.kZm = (TextView) findViewById(f.banner_tips);
        bbW();
        this.kZh.setOnScrollListener(new 3(this));
    }

    private void bbY() {
        if (q.GS()) {
            com.tencent.mm.wallet_core.a.b(this.mController.tml, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(this.mController.tml, "RemittanceProcess", bundle);
    }

    public void finish() {
        super.finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void ss(int i) {
        if (i == 12 && this.kZl != null) {
            bbX();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            com.tencent.mm.kernel.g.Ek();
            this.kYc = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (q.GT()) {
                finish();
                return;
            }
            finish();
            nn nnVar = new nn();
            nnVar.bYA.context = this.mController.tml;
            com.tencent.mm.sdk.b.a.sFg.m(nnVar);
        }
    }

    protected final void bcb() {
        com.tencent.mm.bg.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
    }

    protected static void u(Activity activity) {
        if (o.bOW().bPw().bPn()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
            com.tencent.mm.bg.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            com.tencent.mm.wallet_core.a.b(activity, "ShowOrdersInfoProcess", null);
        }
        com.tencent.mm.wallet_core.ui.e.He(20);
    }
}
