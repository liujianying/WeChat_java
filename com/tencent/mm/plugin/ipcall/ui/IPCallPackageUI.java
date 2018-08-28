package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class IPCallPackageUI extends MMActivity implements e {
    private ListView kwP = null;
    private TextView kwQ = null;
    private ProgressDialog kwR = null;
    private ProgressDialog kwS = null;
    private a kwT = null;
    private com.tencent.mm.plugin.ipcall.a.d.e kwU = null;
    private j kwV = null;
    private f kwW = new f();

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        x.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", new Object[]{str});
        if (iPCallPackageUI.kwS == null) {
            ActionBarActivity actionBarActivity = iPCallPackageUI.mController.tml;
            iPCallPackageUI.getString(R.l.app_tip);
            iPCallPackageUI.kwS = h.a(actionBarActivity, iPCallPackageUI.getString(R.l.ipcall_purchase_processing_tip), false, new 3(iPCallPackageUI));
        } else {
            iPCallPackageUI.kwS.show();
        }
        iPCallPackageUI.kwV = new j(str);
        au.DF().a(iPCallPackageUI.kwV, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(831, this);
        au.DF().a(277, this);
        this.kwW.start();
        f fVar = this.kwW;
        fVar.krR++;
        this.kwW.finish();
        setMMTitle(R.l.ipcall_purchase_package);
        setBackBtn(new 1(this));
        this.kwP = (ListView) findViewById(R.h.package_lv);
        this.kwT = new a(this);
        this.kwP.setAdapter(this.kwT);
        this.kwQ = (TextView) findViewById(R.h.no_package_tv);
        aYn();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(831, this);
        au.DF().b(277, this);
    }

    protected final int getLayoutId() {
        return R.i.ipcall_package_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void aYn() {
        x.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.kwT != null) {
            this.kwT.jWl = null;
            this.kwT.notifyDataSetChanged();
        }
        if (this.kwP != null) {
            this.kwP.setVisibility(8);
        }
        if (this.kwQ != null) {
            this.kwQ.setVisibility(8);
        }
        if (this.kwR == null) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(R.l.app_tip);
            this.kwR = h.a(actionBarActivity, getString(R.l.ip_call_loading_tip), true, new 2(this));
        } else {
            this.kwR.show();
        }
        this.kwU = new com.tencent.mm.plugin.ipcall.a.d.e();
        au.DF().a(this.kwU, 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.kwR != null && this.kwR.isShowing()) {
            this.kwR.dismiss();
        }
        if (this.kwS != null && this.kwS.isShowing()) {
            this.kwS.dismiss();
        }
        if (lVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                ajy ajy = ((com.tencent.mm.plugin.ipcall.a.d.e) lVar).kro;
                if (ajy == null || ajy.rMv == null || ajy.rMv.size() <= 0) {
                    this.kwT.jWl = null;
                    this.kwT.notifyDataSetChanged();
                    this.kwQ.setVisibility(0);
                    return;
                }
                this.kwT.jWl = ajy.rMv;
                this.kwT.notifyDataSetChanged();
                this.kwP.setVisibility(0);
                return;
            }
            Toast.makeText(this.mController.tml, getString(R.l.ip_call_load_error_desc), 0).show();
            finish();
        } else if (lVar instanceof j) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            this.kwW.krV = i2;
            if (i == 0 && i2 == 0) {
                this.kwW.finish();
                Toast.makeText(this.mController.tml, getString(R.l.ipcall_purchase_success), 0).show();
                aYn();
            } else if (i2 == 101) {
                cch cch;
                a aVar = this.kwT;
                j jVar = (j) lVar;
                String str2 = jVar.kry != null ? jVar.kry.rem : "";
                if (!(bi.oW(str2) || aVar.jWl == null)) {
                    for (cch cch2 : aVar.jWl) {
                        if (cch2 != null && cch2.rem.equals(str2)) {
                            cch = cch2;
                            break;
                        }
                    }
                }
                cch = null;
                if (cch == null) {
                    x.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.kwW.finish();
                    Toast.makeText(this.mController.tml, getString(R.l.ipcall_purchase_fail), 0).show();
                    return;
                }
                h.a(this.mController.tml, this.mController.tml.getString(R.l.ipcall_purchase_not_enough_desc, new Object[]{cch.sdK, cch.bHD}), this.mController.tml.getString(R.l.ipcall_purchase_not_enough_title), this.mController.tml.getString(R.l.ip_call_recharge), this.mController.tml.getString(R.l.ipcall_purchase_cancel), false, new 4(this), new 5(this));
            } else {
                this.kwW.finish();
                Toast.makeText(this.mController.tml, getString(R.l.ipcall_purchase_fail), 0).show();
                aYn();
            }
        } else {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        }
    }
}
