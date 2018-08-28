package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int eLd = -1;
    private int fdx;
    boolean lMC = true;
    private boolean lMD = false;
    private c<gg> lME = new 1(this);

    protected final int getLayoutId() {
        return g.wallet_offline_entrance_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c.a.cCW();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        this.lME.cht();
        blx();
    }

    private void blx() {
        x.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        i.zk(1);
        e.He(30);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            x.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is " + intExtra);
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.c.a.lMM = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                x.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.c.a.lMN = intExtra;
                com.tencent.mm.plugin.offline.c.a.lMO = longExtra;
                com.tencent.mm.plugin.offline.c.a.lMP = booleanExtra;
                com.tencent.mm.plugin.offline.c.a.htC = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.c.a.lMQ = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.c.a.lMR = getIntent().getStringExtra("key_card_code");
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.c.a.lMM = intExtra;
                com.tencent.mm.plugin.offline.c.a.lMN = 0;
                com.tencent.mm.plugin.offline.c.a.lMO = 0;
                com.tencent.mm.plugin.offline.c.a.lMP = false;
                com.tencent.mm.plugin.offline.c.a.htC = "";
                com.tencent.mm.plugin.offline.c.a.lMQ = "";
                com.tencent.mm.plugin.offline.c.a.lMR = "";
            }
        }
        this.fdx = getIntent().getIntExtra("key_from_scene", 0);
        if (getIntent().getBooleanExtra("is_offline_create", false) || !(this.fdx == 6 || this.fdx == 7)) {
            init();
            this.lMC = false;
            return;
        }
        l aVar;
        x.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[]{Integer.valueOf(this.fdx)});
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("appId");
        String stringExtra2 = intent.getStringExtra("timeStamp");
        String stringExtra3 = intent.getStringExtra("nonceStr");
        String stringExtra4 = intent.getStringExtra("packageExt");
        String stringExtra5 = intent.getStringExtra("signtype");
        String stringExtra6 = intent.getStringExtra("paySignature");
        int intExtra2 = intent.getIntExtra("pay_channel", 0);
        if (this.fdx == 6) {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 16, as.NAME, intExtra2);
        } else {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra("wxapp_username"), intent.getStringExtra("wxapp_path"), as.NAME, intExtra2);
        }
        jr(580);
        a(aVar, true, false);
        this.lMC = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.lME.dead();
    }

    private void init() {
        int i = 3;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_from_scene")) {
            int intExtra = intent.getIntExtra("key_from_scene", 0);
            if (intExtra == 1) {
                this.eLd = 1;
                i = 2;
            } else if (intExtra == 2) {
                this.eLd = 2;
                i = 1;
            } else if (intExtra == 3) {
                this.eLd = 3;
            } else if (intExtra == 4) {
                this.eLd = 4;
                i = 6;
            } else if (intExtra == 5) {
                this.eLd = 8;
                i = 4;
            } else if (intExtra == 6) {
                this.eLd = 10;
                i = 7;
            } else if (intExtra == 7) {
                this.eLd = 11;
                i = 8;
            } else if (intExtra == 8) {
                this.eLd = 12;
                i = 9;
            } else {
                this.eLd = 0;
                x.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[]{Integer.valueOf(intExtra)});
                i = 1;
            }
            h.mEJ.h(14021, new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
        }
        if (o.bOW().bPr()) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            a(new y(null, 8), true, false);
            this.lMC = false;
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("key_entry_scene", this.eLd);
        intent2.putExtra("key_from_scene", this.fdx);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!bi.oW(stringExtra)) {
            intent2.putExtra("key_business_attach", stringExtra);
        }
        intent2.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        intent2.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
        d.b(this.mController.tml, "offline", ".ui.WalletOfflineCoinPurseUI", intent2, 1);
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.lMC) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.c.a.bly()) {
                x.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.eLd);
                intent.putExtra("key_from_scene", 0);
                return;
            }
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            return;
        }
        x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.lMC = true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
        } else {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
                f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
                init();
                if (this.fdx != 6 && this.fdx != 7) {
                    return true;
                }
                Intent intent = new Intent();
                if (this.lMD) {
                    intent.putExtra("key_callback", "return");
                } else {
                    intent.putExtra("key_callback", "ok");
                }
                setResult(-1, intent);
                return true;
            }
            x.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.fdx == 6 || this.fdx == 7) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_callback", "fail");
                setResult(0, intent2);
            }
            finish();
            return true;
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            return true;
        } else {
            x.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            init();
            x.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
            finish();
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
        if (intent == null || !intent.hasExtra("is_offline_create")) {
            this.lMC = false;
            this.lMD = true;
            setIntent(intent);
            blx();
            return;
        }
        this.lMC = true;
        this.lMD = true;
        setIntent(intent);
        blx();
    }
}
