package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.br.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.widget.textview.a$a;

@a(3)
public class TextPreviewUI extends MMActivity implements e {
    private bd bXQ;
    private int bottom = 0;
    private TextView ih = null;
    private Animation nem;
    private Animation nen;
    private boolean qNz = false;
    private TextView tKB = null;
    private com.tencent.mm.ui.widget.textview.a tNb;
    private com.tencent.mm.ui.widget.b.a tNc;
    private CharSequence tNd;
    private View tNe;
    private View tNf;
    private View tNg;
    private CustomScrollView tNh;
    private final int tNi = 0;
    private final int tNj = 1;
    private final int tNk = 2;
    private boolean tNl = false;
    private ToolsBar tNm;
    private View tNn;
    private CharSequence text = null;
    private int yA;

    static /* synthetic */ void h(TextPreviewUI textPreviewUI) {
        if (textPreviewUI.tNn != null && bi.oW(bf.n(textPreviewUI.bXQ))) {
            textPreviewUI.tNn.setAnimation(textPreviewUI.nen);
            textPreviewUI.tNn.setVisibility(0);
        }
    }

    static /* synthetic */ void j(TextPreviewUI textPreviewUI) {
        if (textPreviewUI.tNn != null) {
            textPreviewUI.tNn.setAnimation(textPreviewUI.nem);
            textPreviewUI.tNn.setVisibility(8);
        }
    }

    static /* synthetic */ void l(TextPreviewUI textPreviewUI) {
        ch chVar = new ch();
        com.tencent.mm.pluginsdk.model.e.a(chVar, textPreviewUI.bXQ);
        chVar.bJF.activity = textPreviewUI;
        chVar.bJF.bJM = 43;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    protected final int getLayoutId() {
        return R.i.chatting_item_full_screen;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        if (d.fR(19)) {
            getWindow().setFlags(67109888, 67109888);
        }
        this.tNe = findViewById(R.h.text_screen);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        long longExtra = getIntent().getLongExtra("Chat_Msg_Id", 0);
        au.HU();
        this.bXQ = c.FT().dW(longExtra);
        this.ih = (TextView) findViewById(R.h.full_screen_text);
        this.tKB = (TextView) findViewById(R.h.full_screen_text_span);
        CharSequence charSequence = this.text;
        TextView textView = this.tKB;
        if (charSequence instanceof SpannableString) {
            textView.setText(((SpannableString) charSequence).toString());
            j.g(textView, 1);
            charSequence = textView.getText();
        }
        this.text = charSequence;
        TextView textView2 = this.ih;
        g cjL = g.cjL();
        ActionBarActivity actionBarActivity = this.mController.tml;
        textView2.setText(cjL.a(this.text, this.ih.getTextSize()));
        this.tNf = findViewById(R.h.know_more_btn_container);
        this.tNg = this.tNf.findViewById(R.h.jump_tip_btn);
        this.tNh = (CustomScrollView) findViewById(R.h.full_screen_scroll_container);
        this.ih.getViewTreeObserver().addOnPreDrawListener(new 1(this));
        this.nen = AnimationUtils.loadAnimation(this.mController.tml, R.a.push_up_in);
        this.nem = AnimationUtils.loadAnimation(this.mController.tml, R.a.push_down_out);
        this.tNc = new com.tencent.mm.ui.widget.b.a(this.mController.tml, this.ih);
        this.tNc.uKX = true;
        this.tNc.uKW = new 8(this);
        this.tNc.ofq = new 9(this);
        if (this.tNb == null && bi.oW(bf.n(this.bXQ))) {
            a$a a_a = new a$a(this.ih, this.tNc);
            a_a.uPh = R.e.selected_blue;
            a_a.uPr = 18;
            a_a.uPi = R.e.cursor_handle_color;
            this.tNb = new com.tencent.mm.ui.widget.textview.a(a_a);
            this.tNb.uPc = new 10(this);
        }
        this.tNe.setOnClickListener(new 11(this));
        this.ih.setOnClickListener(new 12(this));
        if (!bi.oW(bf.n(this.bXQ))) {
            this.tNf.setVisibility(0);
            this.tNg.setOnClickListener(new 13(this));
        } else if (!bf.l(this.bXQ)) {
            ViewStub viewStub = (ViewStub) findViewById(R.h.viewstub_text_more_btn);
            if (viewStub != null) {
                this.tNn = viewStub.inflate();
            }
            this.tNm = (ToolsBar) findViewById(R.h.tools_bar);
            this.tNm.setVisibility(0);
            if (this.tNm != null) {
                this.tNm.c(0, new OnClickListener() {
                    public final void onClick(View view) {
                        if (TextPreviewUI.this.bXQ != null) {
                            TextPreviewUI.b(TextPreviewUI.this.mController.tml, TextPreviewUI.this.text.toString());
                        }
                    }
                });
                this.tNm.c(1, new 6(this));
                this.tNm.c(2, new OnClickListener() {
                    public final void onClick(View view) {
                        TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.this.bXQ);
                    }
                });
            }
        }
        setBackBtn(new 14(this));
        this.tNh.setOnTouchListener(new 15(this));
        this.tNh.setOnScrollChangeListener(new 2(this));
        au.DF().a(525, this);
    }

    protected void onResume() {
        super.onResume();
        if (this.tNb != null && !this.tNb.ccw) {
            this.tNb.cBp();
        }
    }

    public void onBackPressed() {
        finish();
    }

    private void aQ(bd bdVar) {
        b bVar = new b(this.mController.tml);
        bVar.tZc = new 4(this, bVar, bdVar);
        bVar.show();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(525, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 525:
                    x.i("MicroMsg.TextPreviewUI", "set msg remind!");
                    com.tencent.mm.ui.widget.snackbar.b.d(this.mController.tml, this.mController.tml.getResources().getString(R.l.has_remind_tip), "");
                    return;
                default:
                    return;
            }
        } else if (lVar.getType() == 525) {
            x.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(525), Integer.valueOf(i2), Integer.valueOf(i), bi.oV(str)});
            ActionBarActivity actionBarActivity = this.mController.tml;
            if (bi.oW(str)) {
                str = getResources().getString(R.l.remind_err_desc);
            }
            h.b(actionBarActivity, str, this.mController.tml.getResources().getString(R.l.remind_err_title), true);
            com.tencent.mm.plugin.report.service.h.mEJ.a(795, 4, 1, false);
        }
    }
}
