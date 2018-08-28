package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private View ilr;
    private TextView ils;
    private ViewGroup imc;
    private ViewGroup imd;
    private ViewGroup ime;
    private ViewGroup imf;
    private TextView imh;

    protected final int getLayoutId() {
        return R.i.emoji_store_mine;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        h.mEJ.k(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        x.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[]{Integer.valueOf(r0)});
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.emoji_sequence), new 2(this));
        au.HU();
        if (!((Boolean) c.DT().get(a.sOU, Boolean.valueOf(false))).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.eh(true);
        }
        h.mEJ.a(406, 3, 1, false);
        h.mEJ.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected final void initView() {
        setMMTitle(R.l.settings_emoji_mine);
        super.initView();
        this.ilr = findViewById(R.h.sync_view);
        this.ils = (TextView) this.ilr.findViewById(R.h.sync_status);
        this.ils.setText(R.l.emoji_sync_syncing_in_wifi);
        if (i.aEx().ije.iju) {
            i.aEx();
            if (BKGLoaderManager.aEY()) {
                this.ilr.setVisibility(0);
                ct(8001, 3000);
                this.CU.setOnScrollListener(null);
            }
        }
        this.ilr.setVisibility(8);
        this.CU.setOnScrollListener(null);
    }

    public void onClick(View view) {
        Intent intent;
        if (view == this.imd) {
            intent = new Intent();
            intent.setClass(this, EmojiCustomUI.class);
            startActivity(intent);
        } else if (view == this.ime) {
            intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
        }
    }

    protected final boolean aFj() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aFf() {
        return new com.tencent.mm.plugin.emoji.a.c(this.mController.tml);
    }

    protected final int aFm() {
        return 8;
    }

    protected final int aFo() {
        return 2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i - 1, j);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aFD();
            ct(131074, 50);
        }
    }

    public final void h(String str, int i, int i2, String str2) {
    }

    protected final boolean aFu() {
        return false;
    }

    protected final void aFg() {
        this.imf = (ViewGroup) View.inflate(this.mController.tml, R.i.emoji_mine_header, null);
        this.imh = (TextView) this.imf.findViewById(16908310);
        this.imh.setText(R.l.settings_emoji_use_tip);
        this.imf.setVisibility(8);
        this.imh.setVisibility(8);
        this.CU.addHeaderView(this.imf, null, false);
        this.imc = (ViewGroup) View.inflate(this.mController.tml, R.i.emoji_mine_footer, null);
        this.imd = (ViewGroup) this.imc.findViewById(R.h.mine_more_custom);
        ((TextView) this.imd.findViewById(16908310)).setText(R.l.emoji_custom);
        this.ime = (ViewGroup) this.imc.findViewById(R.h.mine_more_paid);
        ((TextView) this.ime.findViewById(16908310)).setText(R.l.emoji_paid);
        this.ime.findViewById(R.h.content).setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        this.imd.setOnClickListener(this);
        this.ime.setOnClickListener(this);
        this.CU.addFooterView(this.imc, null, false);
    }

    protected final boolean aFt() {
        return true;
    }

    protected final boolean aFr() {
        boolean z = true;
        if (this.ihz != null) {
            this.ihz.notifyDataSetChanged();
            this.ikC = true;
            this.gQd.setVisibility(8);
        } else {
            z = false;
        }
        aFv();
        return z;
    }

    protected final void c(adh adh) {
        super.c(adh);
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
    }

    protected final boolean aFi() {
        return false;
    }

    public final void l(Message message) {
        if (message.what == 8001 && this.ilr != null) {
            this.ilr.setVisibility(8);
        }
        super.l(message);
    }

    public final void aFv() {
        if (this.imf == null) {
            return;
        }
        if (this.ihz == null || this.ihz.isEmpty()) {
            this.imf.setVisibility(8);
            this.imh.setVisibility(8);
            return;
        }
        this.imf.setVisibility(0);
        this.imh.setVisibility(0);
    }

    protected final int aFd() {
        return 24;
    }

    protected final int aFe() {
        return 7;
    }
}
