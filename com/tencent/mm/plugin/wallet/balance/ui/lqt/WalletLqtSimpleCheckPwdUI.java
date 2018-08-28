package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView kkY;
    private r pco;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(q.GS() ? getString(a$i.wallet_check_pwd_title_payu) : getString(a$i.wallet_check_pwd_title));
        setBackBtn(new 1(this));
        ((TextView) findViewById(f.input_tip)).setText(a$i.wallet_check_pwd_tip);
        this.kkY = (EditHintPasswdView) findViewById(f.input_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kkY);
        this.kkY.setOnInputValidListener(new 2(this));
        d(this.kkY, 0, false);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof r) {
            if (i == 0 && i2 == 0) {
                String text = this.kkY.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                return true;
            } else if (this.kkY != null) {
                this.kkY.bqn();
            }
        }
        return false;
    }

    public final void rj(int i) {
        super.rj(i);
        if (this.kkY != null) {
            this.kkY.bqn();
        }
    }

    protected final int getLayoutId() {
        return g.wallet_lqt_simple_check_pwd_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
