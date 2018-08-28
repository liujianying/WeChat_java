package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class IPCallMyGiftCardUI extends MMActivity implements e {
    private ListView CU;
    private ProgressDialog eEX;
    private View gQd;
    private a kwE;
    private d kwF;

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(288, this);
        setMMTitle(R.l.ipcall_my_coupon_card_title);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, this.mController.tml.getString(R.l.ipcall_my_coupon_card_exchange), new 2(this));
        this.gQd = findViewById(R.h.ipcall_my_gift_card_empty_view);
        this.CU = (ListView) findViewById(R.h.ipcall_my_gift_card_list);
        this.kwE = new a(this);
        this.CU.setAdapter(this.kwE);
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.eEX = h.a(actionBarActivity, getString(R.l.ip_call_loading_tip), true, new 3(this));
        this.kwF = new d();
        au.DF().a(this.kwF, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(288, this);
    }

    protected final int getLayoutId() {
        return R.i.ipcall_my_gift_card_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (!(lVar instanceof d)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            ajw ajw = ((d) lVar).krm;
            if (this.eEX != null && this.eEX.isShowing()) {
                this.eEX.dismiss();
            }
            this.kwE.jWl = ajw.rMx;
            this.kwE.kwI = ajw;
            this.kwE.notifyDataSetChanged();
            if (ajw.rMx.size() == 0) {
                this.gQd.setVisibility(0);
                return;
            }
            return;
        }
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
        this.gQd.setVisibility(0);
        Toast.makeText(this.mController.tml, getString(R.l.ip_call_load_error_desc), 0).show();
    }
}
