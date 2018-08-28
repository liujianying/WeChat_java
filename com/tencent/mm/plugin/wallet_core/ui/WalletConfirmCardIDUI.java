package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button jXG;
    private TenpaySegmentEditText pvn;
    private boolean pvo = true;

    static /* synthetic */ void g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        TenpaySegmentEditText.setSalt(o.cDa());
        walletConfirmCardIDUI.a(new t(walletConfirmCardIDUI.bNs(), walletConfirmCardIDUI.pvn.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.sy.getParcelable("key_pay_info"), walletConfirmCardIDUI.sy.getInt("entry_scene", -1)), true, true);
    }

    protected final int getLayoutId() {
        return g.wallet_confirm_card_id_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Object string = this.sy.getString("key_bankcard_id");
        String string2 = this.sy.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.sy.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
        } else if (bitmap == null) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
        } else {
            setMMTitle(i.wallet_confirm_card_id_ui_title);
            this.jXG = (Button) findViewById(f.next_btn);
            this.pvn = (TenpaySegmentEditText) findViewById(f.edit_card_id);
            this.pvn.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
            this.kMk = findViewById(f.tenpay_keyboard_layout);
            ((ImageView) findViewById(f.card_id_src_bmp)).setImageBitmap(bitmap);
            this.pvn.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.pvn.getWindowToken(), 0);
            this.kMk.setVisibility(8);
            this.pvn.setOnClickListener(new 2(this));
            final String str = this.pvn.get3DesEncrptData();
            this.jXG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String str = WalletConfirmCardIDUI.this.pvn.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        h.mEJ.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
                    } else {
                        h.mEJ.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                    }
                    WalletConfirmCardIDUI.g(WalletConfirmCardIDUI.this);
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
            this.kMk = findViewById(f.tenpay_keyboard_layout);
            View findViewById = findViewById(f.tenpay_push_down);
            if (!(this.mKeyboard == null || this.kMk == null)) {
                findViewById.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        WalletConfirmCardIDUI.this.Wq();
                    }
                });
            }
            this.pvn.setFocusable(false);
            this.pvn.setFocusableInTouchMode(true);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Bundle bundle = new Bundle();
        boolean z = this.sy.getBoolean("key_is_reset_with_new_card", false);
        if (i == 0 && i2 == 0) {
            if (lVar instanceof t) {
                t tVar = (t) lVar;
                bundle.putBoolean("key_need_area", tVar.bOl());
                bundle.putBoolean("key_need_profession", tVar.bOm());
                bundle.putParcelableArray("key_profession_list", tVar.pjD);
                if (tVar.pjz == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.pvn.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                } else if (tVar.pjz.pnr && tVar.pjz.isError()) {
                    com.tencent.mm.ui.base.h.i(this, i.wallet_bank_broken, i.app_tip);
                    return true;
                } else {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", tVar.pjz.knE);
                    bundle.putParcelable("elemt_query", tVar.pjz);
                    bundle.putString("key_card_id", this.pvn.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (lVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.pvn.getEncryptDataWithHash(false));
            a.j(this, bundle);
            return true;
        }
        return false;
    }
}
