package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

public class SnsSingleTextViewUI extends MMActivity {
    private String bNH;
    private d hqV = new 5(this);
    private ClipboardManager jdw;
    private n nsz;
    private TextView obl;
    private boolean obm = false;
    private SnsTranslateResultView obn;
    private c obo = new 1(this);
    private c obp = new 2(this);
    private c obq = new 3(this);
    protected int requestType = 0;
    private String text;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jdw = (ClipboardManager) getSystemService("clipboard");
        setMMTitle(j.sns_all_text);
        setBackBtn(new 4(this));
        this.text = getIntent().getStringExtra("sns_text_show");
        this.bNH = bi.aG(getIntent().getStringExtra("sns_local_id"), "");
        this.nsz = af.byo().Nl(this.bNH);
        if (bi.oW(this.text)) {
            this.text = "";
        }
        this.obl = (TextView) findViewById(f.sns_text_tv);
        this.obl.setText(this.text, BufferType.SPANNABLE);
        com.tencent.mm.pluginsdk.ui.d.j.g(this.obl, 2);
        this.obl.setOnTouchListener(new m());
        new k(this).a(this.obl, this, this.hqV);
        this.obn = (SnsTranslateResultView) findViewById(f.sns_translate_result_view);
        this.obn.setResultTextSize(this.obl.getTextSize());
        if (this.nsz != null && ap.cd(this.nsz.bAK(), 8)) {
            b Mq = ap.Mq(this.nsz.bAK());
            if (Mq != null && Mq.dDR) {
                this.obn.setVisibility(0);
                this.obn.a(null, 1, Mq.result, Mq.dMB, false);
                this.obm = true;
            }
        }
        a.sFg.b(this.obo);
        a.sFg.b(this.obp);
        a.sFg.b(this.obq);
    }

    protected void onDestroy() {
        super.onDestroy();
        a.sFg.c(this.obo);
        a.sFg.c(this.obp);
        a.sFg.c(this.obq);
    }

    protected final int getLayoutId() {
        return g.sns_single_textviewui;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(j.app_copy));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(0, 1, 0, getString(j.favorite));
            }
            contextMenu.add(0, 6, 1, getString(j.app_expose));
            if (this.obm) {
                ap.b(contextMenu, true);
            } else {
                ap.a(contextMenu, true);
            }
        }
    }
}
