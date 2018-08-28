package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.a.b;
import com.tencent.mm.ui.chatting.d.a.c;
import com.tencent.mm.ui.chatting.g.e;

public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, b {
    private RecyclerView Sa;
    private long dRd = 0;
    private int dYK;
    private long dkA = 0;
    private String gBf;
    private TextView hOU;
    private ProgressDialog kjo;
    private com.tencent.matrix.trace.b.a nYi = new 1(this);
    private long tNE;
    private View tUD;
    private View tUF;
    private View tUG;
    private View tUH;
    private View tUI;
    private boolean tUz = false;
    private boolean tXA;
    private int tXB = -1;
    private boolean tXC;
    private boolean tXD = true;
    private int tXE;
    private com.tencent.mm.ui.chatting.d.a.a tXx;
    private TextView tXy;
    private boolean tXz;

    private static class a {
        public static com.tencent.mm.ui.chatting.d.a.a ar(Context context, int i) {
            switch (7.tXH[i - 1]) {
                case 1:
                    return new e(context);
                default:
                    return null;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        com.tencent.mm.ui.chatting.d.a.a ar;
        super.onCreate(bundle);
        this.tUz = true;
        Intent intent = getIntent();
        if (intent.getIntExtra("kintent_intent_source", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.tXz = z;
        this.gBf = intent.getStringExtra("kintent_talker");
        this.tXB = intent.getIntExtra("kintent_image_index", -1);
        this.tXA = intent.getBooleanExtra("key_is_biz_chat", false);
        this.tNE = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                ar = a.ar(this, c.tTt);
                break;
            default:
                ar = a.ar(this, c.tTt);
                break;
        }
        ar.a(this);
        initView();
        this.tXx.x(true, this.tXB);
    }

    protected void onResume() {
        this.dRd = bi.VE();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.a(this.nYi);
        super.onResume();
        this.tXx.onResume();
        if (this.tUz) {
            if (this.tXx.cwz()) {
                cwx();
            } else {
                cwy();
            }
        }
        this.tUz = false;
    }

    protected void onPause() {
        super.onPause();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, this.dYK);
        this.dYK = 0;
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.b(this.nYi);
        this.dRd = bi.VE() > this.dRd ? bi.VE() - this.dRd : 1;
        HardCoderJNI.reportFPS(703, HardCoderJNI.hcMediaGalleryScrollAction, 1, this.dkA, this.dRd);
        this.dkA = 0;
        this.dRd = 0;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.tXx.onDetach();
    }

    protected final void initView() {
        super.initView();
        this.tUD = findViewById(R.h.more_bottom_root);
        this.tUG = findViewById(R.h.trans_btn);
        this.tUI = findViewById(R.h.del_btn);
        this.tUH = findViewById(R.h.save_btn);
        this.tUF = findViewById(R.h.fav_btn);
        this.tUF.setTag(Integer.valueOf(1));
        this.tUG.setTag(Integer.valueOf(0));
        this.tUH.setTag(Integer.valueOf(3));
        this.tUI.setTag(Integer.valueOf(2));
        this.tUF.setOnClickListener(this);
        this.tUG.setOnClickListener(this);
        this.tUH.setOnClickListener(this);
        this.tUI.setOnClickListener(this);
        this.tXy = (TextView) findViewById(R.h.album_tips_bar);
        this.hOU = (TextView) findViewById(R.h.search_nothing_hint);
        this.Sa = (RecyclerView) findViewById(R.h.history_recycler_view);
        this.Sa.setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
        findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
        this.Sa.setLayoutManager(this.tXx.cwu());
        this.Sa.a(this.tXx.gN(this));
        this.Sa.setAdapter(this.tXx.ay(this.gBf, this.tNE));
        this.Sa.setHasFixedSize(true);
        this.Sa.setOnScrollListener(new 2(this));
        this.Sa.a(new 3(this));
        setMMTitle(this.tXx.Wm());
        setBackBtn(new 4(this));
    }

    protected final int getLayoutId() {
        return R.i.media_history_ui;
    }

    public final void ma(boolean z) {
        if (z) {
            q(true, null);
        } else {
            this.tXE = ((GridLayoutManager) this.Sa.getLayoutManager()).fj();
        }
    }

    public final void y(boolean z, int i) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.tXB)});
        if (z) {
            q(false, null);
            this.Sa.getAdapter().RR.notifyChanged();
            if (this.tXB > 0) {
                if (this.tXB % 4 == 0) {
                    this.tXB++;
                }
                this.Sa.bg(this.tXB);
            } else {
                this.Sa.bg(this.Sa.getAdapter().getItemCount() - 1);
            }
            if (i <= 0) {
                this.hOU.setVisibility(0);
                this.Sa.setVisibility(8);
                this.hOU.setText(getString(R.l.chatting_record_noting_hint));
                return;
            }
            this.hOU.setVisibility(8);
            this.Sa.setVisibility(0);
        } else if (i > 0) {
            this.Sa.getAdapter().Z(0, i);
            this.Sa.getAdapter().X(i, this.tXE + i);
        } else {
            this.Sa.getAdapter().bl(0);
        }
    }

    public final View getChildAt(int i) {
        return this.Sa.getChildAt(i);
    }

    public final void Fj(int i) {
        setMMTitle(getString(R.l.gallery_selected_title, new Object[]{Integer.valueOf(i)}));
        FJ(i);
    }

    public void onClick(View view) {
        this.tXx.Fi(((Integer) view.getTag()).intValue());
    }

    public void onBackPressed() {
        super.onBackPressed();
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.tXC) {
            this.tXx.cwA();
        } else {
            finish();
        }
    }

    public final void cwx() {
        this.tXx.cwx();
        setMMTitle(getString(R.l.gallery_selected_title, new Object[]{Integer.valueOf(this.tXx.cww())}));
        this.tUD.setVisibility(0);
        this.tUD.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_up_in));
        FJ(this.tXx.cww());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.gallery_grid_cancel_selected_option), new 5(this));
    }

    public final void cwy() {
        this.tXx.cwy();
        setMMTitle(this.tXx.Wm());
        this.tUD.setVisibility(8);
        this.tUD.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_down_out));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.gallery_grid_selected_option), new 6(this));
    }

    public final void cwB() {
        this.tXC = true;
        q(true, getString(R.l.image_saving_tip));
    }

    public final void cwA() {
        cwy();
        this.tXC = false;
        q(false, "");
    }

    public final void cwC() {
        cwy();
        this.tXC = false;
        q(false, "");
        String substring = com.tencent.mm.compatible.util.e.dgl.substring(com.tencent.mm.compatible.util.e.dgl.indexOf("tencent/MicroMsg"));
        Toast.makeText(this, getString(R.l.chatting_record_saved, new Object[]{substring}), 1).show();
    }

    public final void Fk(int i) {
        cwy();
        q(false, "");
        if (i == 0) {
            i = R.l.gallery_selected_save_err;
        }
        if (this.tXC) {
            h.a(this, i, R.l.app_tip, true, null);
        }
        this.tXC = false;
    }

    public final boolean cwD() {
        return this.tXC;
    }

    private void FJ(int i) {
        if (!this.tXx.cwz() || i <= 0) {
            this.tUF.setEnabled(false);
            this.tUG.setEnabled(false);
            this.tUH.setEnabled(false);
            this.tUI.setEnabled(false);
            return;
        }
        this.tUF.setEnabled(true);
        this.tUG.setEnabled(true);
        this.tUH.setEnabled(true);
        this.tUI.setEnabled(true);
    }

    private void q(boolean z, String str) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            CharSequence str2;
            if (str2 == null) {
                str2 = getString(R.l.loading_tips);
            }
            this.kjo = p.b(this, str2, true, 0, null);
        } else if (this.kjo != null && this.kjo.isShowing()) {
            this.kjo.dismiss();
            this.kjo = null;
        }
    }
}
