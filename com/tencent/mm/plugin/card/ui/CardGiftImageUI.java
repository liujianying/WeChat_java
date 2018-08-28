package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.a$a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.k;

@a(3)
public class CardGiftImageUI extends MMActivity implements a$a {
    private String bSw;
    private k gcQ;
    private CardGiftInfo hDa;
    private ImageView hDb;
    private RelativeLayout hDc;
    private MMGestureGallery hDd;
    private ProgressBar hDe;
    private ag hDf = new ag(Looper.getMainLooper());
    private Bundle hDg;
    private boolean hDh = false;
    private f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private a hDn;

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        cardGiftImageUI.gcQ = new k(cardGiftImageUI);
        cardGiftImageUI.gcQ.ofp = new 3(cardGiftImageUI);
        cardGiftImageUI.gcQ.ofq = new 4(cardGiftImageUI);
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.hDg = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.hDa = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        String str = "MicroMsg.CardGiftImageUI";
        String str2 = "cardGiftInfo:%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hDa == null ? "null" : this.hDa.toString();
        x.d(str, str2, objArr);
        x.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[]{this.bSw});
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        if (this.hDa == null || bi.oW(this.hDa.hvo)) {
            x.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.d.a.g(this.hDa.hvo, this.hDa.hvr, this.hDa.hvA, 2);
        }
    }

    protected final void initView() {
        this.hDb = (ImageView) findViewById(d.gallery_bg);
        this.hDb.setLayerType(2, null);
        this.hDe = (ProgressBar) findViewById(d.image_loading);
        this.hDc = (RelativeLayout) findViewById(d.image_root);
        this.hDd = (MMGestureGallery) findViewById(d.gallery);
        this.hDd.setVerticalFadingEdgeEnabled(false);
        this.hDd.setHorizontalFadingEdgeEnabled(false);
        this.hDn = new a(this, (byte) 0);
        this.hDd.setAdapter(this.hDn);
        this.hDd.setSingleClickOverListener(new 1(this));
        this.hDd.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                h.a(CardGiftImageUI.this, CardGiftImageUI.this.gcQ.bEo());
                return true;
            }
        });
        this.hDi = new f(this);
    }

    public void onStart() {
        Bundle bundle = this.hDg;
        if (!this.hDh) {
            this.hDh = true;
            if (VERSION.SDK_INT < 12) {
                x.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.hDj = getIntent().getIntExtra("img_top", 0);
                this.hDk = getIntent().getIntExtra("img_left", 0);
                this.hDl = getIntent().getIntExtra("img_width", 0);
                this.hDm = getIntent().getIntExtra("img_height", 0);
                this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
                if (bundle == null) {
                    this.hDc.getViewTreeObserver().addOnPreDrawListener(new 5(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.hDn != null) {
            this.hDn.notifyDataSetChanged();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.card.d.a.b(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
        ayH();
        return true;
    }

    public final void ayH() {
        this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
        this.hDi.a(this.hDc, this.hDb, new 6(this), null);
    }

    protected final int getLayoutId() {
        return e.card_gift_image_ui;
    }

    public final void aY(String str, int i) {
        this.hDf.post(new 7(this));
    }

    public final void fail(String str) {
    }

    public final void cf(String str, String str2) {
        this.hDf.post(new 8(this, str2));
    }
}
