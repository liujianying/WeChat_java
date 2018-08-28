package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int fdx;
    private Map<String, String> pDL = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        this.fdx = getIntent().getIntExtra("key_scene", 0);
        x.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.fdx);
        if (this.fdx == 0) {
            jr(580);
            if (getIntent() == null) {
                x.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(-1000);
                finish();
                return;
            }
            a(new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)), true, false);
        } else if (!PC(null)) {
            x.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        js(580);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        boolean z = false;
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                x.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
                x.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map bRh = bRh();
                if (bRh != null && bRh.containsKey("togroup") && "0".equals(bRh.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                int i3 = z ? 7 : 3;
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i3);
                d.b(this, ".ui.transmit.SelectConversationUI", intent, 1);
                return true;
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_index.c.f) {
                x.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.fdx == 1) {
                    h.bA(this, getString(i.wallet_send_c2c_msg_resent));
                } else {
                    h.bA(this, getString(i.has_send));
                    setResult(-1);
                }
                finish();
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(-1000);
            finish();
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_index.c.f) {
            if (this.fdx == 1) {
                h.bA(this, str);
            } else {
                setResult(-1000);
            }
            finish();
            return true;
        } else {
            setResult(-1000);
            finish();
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 != -1 || intent == null) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            x.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bi.oV(stringExtra));
            if (!PC(stringExtra)) {
                x.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
                setResult(-1000);
                finish();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    private boolean PC(String str) {
        String stringExtra;
        String stringExtra2;
        String encode;
        String stringExtra3;
        String stringExtra4;
        String stringExtra5;
        String str2;
        String str3;
        if (this.fdx == 1) {
            str = getIntent().getStringExtra("key_receiver");
            stringExtra = getIntent().getStringExtra("key_sender_des");
            stringExtra2 = getIntent().getStringExtra("key_receiver_des");
            encode = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            String stringExtra6 = getIntent().getStringExtra("key_templateid");
            stringExtra3 = getIntent().getStringExtra("key_sceneid");
            stringExtra4 = getIntent().getStringExtra("key_receivertitle");
            stringExtra5 = getIntent().getStringExtra("key_sendertitle");
            str2 = stringExtra6;
            str3 = str;
        } else {
            Map bRh = bRh();
            if (bRh == null || bi.oW(str)) {
                stringExtra3 = null;
                str2 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                str3 = str;
            } else {
                stringExtra4 = URLDecoder.decode(bi.oV((String) bRh.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(bi.oV((String) bRh.get("sendertitle")));
                stringExtra = URLDecoder.decode(bi.oV((String) bRh.get("senderdes")));
                stringExtra2 = URLDecoder.decode(bi.oV((String) bRh.get("receiverdes")));
                encode = bi.oV((String) bRh.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                str2 = URLDecoder.decode(bi.oV((String) bRh.get("templateid")));
                stringExtra3 = URLDecoder.decode(bi.oV((String) bRh.get("senceid")));
                str3 = str;
            }
        }
        if (bi.oW(encode) || bi.oW(str2)) {
            x.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bi.oW(encode) + "templateId=" + bi.oW(str2));
            return false;
        }
        x.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to" + str3);
        a(new com.tencent.mm.plugin.wallet_index.c.f(str3, stringExtra4, stringExtra5, str2, stringExtra, stringExtra2, encode, stringExtra3), true, true);
        return true;
    }

    private Map<String, String> bRh() {
        if (this.pDL == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            x.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: " + stringExtra);
            if (!bi.oW(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.pDL = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bi.oW(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bi.oW(split2[0])) {
                                this.pDL.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        return this.pDL;
    }
}
