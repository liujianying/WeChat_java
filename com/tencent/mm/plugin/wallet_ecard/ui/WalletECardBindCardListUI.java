package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class WalletECardBindCardListUI extends WalletECardBaseUI {
    private ListView pCi;
    private TextView pCj;
    private List<ff> pCk = new ArrayList();
    private c pCl;
    private boolean pCm = true;
    private int pmY;

    private class a {
        TextView gFa;

        public a(View view) {
            this.gFa = (TextView) view.findViewById(f.ecard_bind_card_add_main_title_tv);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uYO.jr(1988);
        this.pmY = this.sy.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.pBy, 2);
        x.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[]{Integer.valueOf(this.pmY)});
        setMMTitle(i.ecard_bind_card_title);
        initView();
        this.pCm = true;
        Zy();
    }

    protected final void initView() {
        this.pCi = (ListView) findViewById(f.bcard_bind_card_list);
        View inflate = LayoutInflater.from(this).inflate(g.ecard_bind_card_list_header_layout, this.pCi, false);
        this.pCj = (TextView) inflate.findViewById(f.ecard_bind_list_desc_tv);
        this.pCi.addHeaderView(inflate, null, false);
        this.pCl = new c(this, (byte) 0);
        this.pCi.setAdapter(this.pCl);
        this.pCi.setOnItemClickListener(new 1(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof com.tencent.mm.plugin.wallet_ecard.a.f)) {
            return false;
        }
        com.tencent.mm.plugin.wallet_ecard.a.f fVar = (com.tencent.mm.plugin.wallet_ecard.a.f) lVar;
        if (i == 0 && i2 == 0) {
            if (!bi.oW(fVar.pCd.sfl)) {
                this.pCj.setText(fVar.pCd.sfl);
            }
            if (fVar.pCd.hwV == 0) {
                x.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[]{Integer.valueOf(fVar.pCd.sfm.size())});
                x.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[]{fVar.pCd.plj});
                this.sy.putString(com.tencent.mm.plugin.wallet_ecard.a.a.pBP, fVar.pCd.plj);
                if (fVar.pCd.sfm.size() == 0) {
                    x.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[]{Boolean.valueOf(this.pCm)});
                    if (!this.pCm) {
                        return true;
                    }
                    bRb();
                    return true;
                }
                this.pCk.clear();
                this.pCk.addAll(fVar.pCd.sfm);
                this.pCl.notifyDataSetChanged();
                return true;
            } else if (b.a(this, fVar.pCd.rhe)) {
                return true;
            } else {
                h.b(this.mController.tml, b.d(this.mController.tml, new String[]{fVar.pCd.hwW, str}), "", false);
                return true;
            }
        }
        x.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[]{fVar});
        h.b(this.mController.tml, b.d(this.mController.tml, new String[]{str}), "", false);
        return true;
    }

    private void bRb() {
        Bundle bundle = new Bundle();
        if (this.pmY == 3) {
            bundle.putInt("key_bind_scene", 18);
        } else {
            bundle.putInt("key_bind_scene", 19);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putString("key_pwd1", this.sy.getString("key_pwd1"));
        x.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[]{Integer.valueOf(this.pmY)});
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, bundle, new 2(this));
    }

    protected final int getLayoutId() {
        return g.ecard_bind_card_list;
    }

    public void onDestroy() {
        super.onDestroy();
        this.uYO.js(1988);
    }

    protected final boolean bND() {
        return true;
    }

    private void Zy() {
        x.i("MicroMsg.WalletECardBindCardListUI", "load Data");
        a(new com.tencent.mm.plugin.wallet_ecard.a.f("WEB_DEBIT", this.pmY), true, false);
    }
}
