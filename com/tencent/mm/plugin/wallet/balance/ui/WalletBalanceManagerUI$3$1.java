package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import org.json.JSONArray;
import org.json.JSONObject;

class WalletBalanceManagerUI$3$1 implements c {
    final /* synthetic */ 3 paA;

    WalletBalanceManagerUI$3$1(3 3) {
        this.paA = 3;
    }

    public final void a(l lVar) {
        JSONArray optJSONArray = this.paA.paz.optJSONArray("balance_menu_item");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    WalletBalanceManagerUI$a walletBalanceManagerUI$a = new WalletBalanceManagerUI$a();
                    walletBalanceManagerUI$a.title = optJSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                    walletBalanceManagerUI$a.paB = optJSONObject.optInt("jump_type", 0);
                    walletBalanceManagerUI$a.paC = optJSONObject.optString("jump_h5_url");
                    walletBalanceManagerUI$a.paD = optJSONObject.optString("tinyapp_username");
                    walletBalanceManagerUI$a.paE = optJSONObject.optString("tinyapp_path");
                    lVar.add(0, i, 0, walletBalanceManagerUI$a.title);
                    this.paA.jLK.add(walletBalanceManagerUI$a);
                }
            }
        }
    }
}
