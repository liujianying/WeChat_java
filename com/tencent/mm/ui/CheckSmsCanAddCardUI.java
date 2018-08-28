package com.tencent.mm.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class CheckSmsCanAddCardUI extends MMActivity implements e {
    private b diG;
    private String tho;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!au.HW() || au.Dr()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (bi.oW(host) || !host.equals("cardpackage")) {
                x.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[]{host});
            } else {
                this.tho = data.getQueryParameter("encrystr");
                x.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[]{this.tho});
                if (!bi.oW(this.tho)) {
                    i = 1;
                    if (i == 0) {
                        au.DF().a(1038, this);
                        a aVar = new a();
                        aVar.dIG = new om();
                        aVar.dIH = new on();
                        aVar.dIF = 1038;
                        aVar.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.diG = aVar.KT();
                        ((om) this.diG.dID.dIL).rsO = this.tho;
                        x.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.tho});
                        this.diG = v.a(this.diG);
                    }
                    coS();
                    return;
                }
            }
        }
        i = 0;
        if (i == 0) {
            coS();
            return;
        }
        au.DF().a(1038, this);
        a aVar2 = new a();
        aVar2.dIG = new om();
        aVar2.dIH = new on();
        aVar2.dIF = 1038;
        aVar2.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
        this.diG = aVar2.KT();
        ((om) this.diG.dID.dIL).rsO = this.tho;
        x.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.tho});
        this.diG = v.a(this.diG);
    }

    protected final int getLayoutId() {
        return R.i.jump_to_biz_profile_loading;
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(1038, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            on onVar = (on) this.diG.dIE.dIL;
            x.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[]{onVar.cac, onVar.cad});
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            d.c(this, "card", ".ui.CardDetailUI", intent);
            finish();
            return;
        }
        coS();
    }

    private void coS() {
        Toast.makeText(this, getString(R.l.verify_authority_err), 1).show();
        LauncherUI.gm(this);
        finish();
    }
}
