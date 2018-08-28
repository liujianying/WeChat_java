package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int eLd = 0;
    private q kZX = new q();
    private boolean pjc = false;
    private int pka = TbsListener$ErrorCode.INFO_CODE_MINIQB;
    private long pkb = 0;
    private View pkc;
    private View pkd;
    private View pke;
    private TextView pkf;
    private TextView pkg;
    private TextView pkh;
    private TextView pki;
    private TextView pkj;
    private TextView pkk;
    private TextView pkl;
    private String pkm;
    private String pkn;
    private String pko;
    private boolean pkp;
    private boolean pkq = false;

    public void onResume() {
        super.onResume();
        this.kZX.onResume();
    }

    public void onPause() {
        super.onPause();
        this.kZX.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pkq = this.sy.getBoolean("key_from_set_pwd", false);
        initView();
        cDK();
        this.eLd = this.sy.getInt("entry_scene", this.eLd);
        e.a(13, bi.VE(), this.eLd);
        if (this.pkq) {
            setMMTitle(i.wallet_real_name_verify_title_from_pwd);
        }
        this.kZX.pzb = new 1(this);
    }

    protected final void initView() {
        setMMTitle(i.wallet_real_name_verify_title);
        this.pkc = findViewById(f.switch_to_bindcard);
        this.pkd = findViewById(f.switch_to_verify_id);
        this.pke = findViewById(f.switch_to_verifycard);
        this.pkd.setOnClickListener(this);
        this.pkc.setOnClickListener(this);
        this.pke.setOnClickListener(this);
        this.pkf = (TextView) findViewById(f.bind_card_title);
        this.pkg = (TextView) findViewById(f.bind_card_sub_title);
        this.pkh = (TextView) findViewById(f.bind_id_title);
        this.pki = (TextView) findViewById(f.bind_id_sub_title);
        this.pkj = (TextView) findViewById(f.extral_wording);
        this.pkk = (TextView) findViewById(f.verify_card_title);
        this.pkl = (TextView) findViewById(f.verify_card_sub_title);
        if (this.pkq) {
            ((TextView) findViewById(f.switch_real_name_tv)).setText(i.wallet_real_name_verify_title_from_pwd_desc);
        }
        js(false);
        l bVar = new b();
        jr(1666);
        a(bVar, true, true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                c cDK = SwitchRealnameVerifyModeUI.this.cDK();
                if (cDK != null) {
                    e.a(14, bi.VE(), SwitchRealnameVerifyModeUI.this.eLd);
                    cDK.c(SwitchRealnameVerifyModeUI.this, 0);
                    return true;
                }
                SwitchRealnameVerifyModeUI.this.finish();
                return false;
            }
        });
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof a) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.pluginsdk.wallet.f.Ul(((a) lVar).bOj());
                js(580);
                ((a) lVar).blM();
                c cDK = cDK();
                if (cDK != null) {
                    Bundle bundle = cDK.jfZ;
                    bundle.putInt("real_name_verify_mode", 1);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                }
                return true;
            }
        } else if (lVar instanceof b) {
            js(1666);
            js(true);
            this.pjc = ((b) lVar).pjc;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.kZX.bcc();
        } else {
            this.kZX.cancel();
        }
    }

    protected final int getLayoutId() {
        return g.wallet_realname_verify_mode_ui;
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.pkb <= ((long) this.pka)) {
            x.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            return;
        }
        this.pkb = System.currentTimeMillis();
        this.kZX.a(new 3(this, view), this.pjc);
    }

    public void onClickImp(View view) {
        int id = view.getId();
        final c cDK = cDK();
        if (cDK != null) {
            Bundle bundle = cDK.jfZ;
            if (id == f.switch_to_bindcard) {
                e.a(15, bi.VE(), this.eLd);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (bi.oW(str)) {
                        str = getString(i.wallet_unknown_err);
                    }
                    h.a(this, str, null, false, new 5(this));
                    return;
                } else {
                    jr(580);
                    a(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
                    return;
                }
            } else if (id == f.switch_to_verify_id) {
                e.a(17, bi.VE(), this.eLd);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == f.switch_to_verifycard) {
                e.a(16, bi.VE(), this.eLd);
                if (!this.pkp || bi.oW(this.pko)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    h.a(this, this.pko, "", this.pkn, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = cDK.jfZ;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.j(SwitchRealnameVerifyModeUI.this, bundle);
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.j(this, bundle);
        }
    }

    private static JSONObject bOp() {
        com.tencent.mm.kernel.g.Ek();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sTc, "");
        if (obj != null) {
            String str = (String) obj;
            if (!bi.oW(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong("timestamp");
                    long j2 = jSONObject.getLong("cache_time");
                    x.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j <= j2) {
                        return jSONObject;
                    }
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                    return null;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    return null;
                }
            }
        }
        x.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        return null;
    }

    private boolean js(boolean z) {
        JSONObject jSONObject;
        JSONObject bOp = bOp();
        if (z && bOp == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = bOp;
        }
        if (jSONObject == null) {
            return z;
        }
        CharSequence aG = bi.aG(jSONObject.optString("cache_header_titles", getString(i.switch_realname_default_tip)), getString(i.switch_realname_default_tip));
        if (this.pkq) {
            ((TextView) findViewById(f.switch_real_name_tv)).setText(i.wallet_real_name_verify_title_from_pwd_desc);
        } else {
            ((TextView) findViewById(f.switch_real_name_tv)).setText(aG);
        }
        if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
            this.pkk.setText(jSONObject.optString("bindCardVerifyTitle"));
            this.pkl.setText(jSONObject.optString("bindCardVerifySubtitle"));
            this.pke.setVisibility(0);
        } else {
            this.pke.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindCard", false)) {
            this.pkf.setText(jSONObject.optString("bindcardTitle", getString(i.switch_realname_verify_mode_bindcard)));
            this.pkg.setText(jSONObject.optString("bindcardSubTitle", getString(i.switch_realname_verify_mode_bindcard_tip)));
            this.pkc.setVisibility(0);
        } else {
            this.pkc.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindId", false)) {
            this.pkh.setText(jSONObject.optString("bindIdTitle", getString(i.switch_realname_verify_mode_id_verify)));
            this.pki.setText(jSONObject.optString("bindIdSubTitle", getString(i.switch_realname_verify_mode_id_verify_tip)));
            this.pkd.setVisibility(0);
        } else {
            this.pkd.setVisibility(8);
        }
        this.pkn = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.pko = jSONObject.optString("bindCardVerifyAlertViewContent", "");
        this.pkp = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        CharSequence optString = jSONObject.optString("extral_wording", "");
        if (bi.oW(optString)) {
            this.pkj.setVisibility(8);
        } else {
            this.pkj.setText(optString);
            this.pkj.setVisibility(0);
        }
        this.pkn = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.pko = jSONObject.optString("bindCardVerifyAlertViewContent");
        this.pkp = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        boolean optBoolean = jSONObject.optBoolean("question_answer_switch", false);
        this.pkm = jSONObject.optString("question_answer_url", "");
        if (optBoolean && !bi.oW(this.pkm)) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.wallet_qanda_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.a(18, bi.VE(), SwitchRealnameVerifyModeUI.this.eLd);
                    e.l(SwitchRealnameVerifyModeUI.this.mController.tml, SwitchRealnameVerifyModeUI.this.pkm, false);
                    return true;
                }
            });
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c cDK = cDK();
            if (cDK != null) {
                e.a(14, bi.VE(), this.eLd);
                cDK.c((Activity) this, 0);
                return true;
            }
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
