package com.tencent.mm.ui.bizchat;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BizChatSearchUI extends MMActivity implements b.a, BizChatSearchListView.a {
    String hpJ;
    b hpe;
    private OnScrollListener jUS = new 1(this);
    private int scene;
    private String tEJ;
    private c tEK;
    BizChatSearchListView tEL;
    TextView tEM;
    private a tEN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    protected final void initView() {
        if (bi.oW(this.hpJ)) {
            this.hpJ = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.tEJ = getIntent().getStringExtra("biz_chat_search_text");
            if (bi.oW(this.hpJ)) {
                finish();
            }
        }
        this.tEL = (BizChatSearchListView) findViewById(R.h.bizchat_lv);
        this.tEM = (TextView) findViewById(R.h.no_result_tv);
        this.tEN = new a(this.mController.tml, this.hpJ, this.scene);
        if (a.a(this.tEN)) {
            this.tEK = new c((byte) 0);
            BizChatSearchListView bizChatSearchListView = this.tEL;
            c cVar = this.tEK;
            View inflate = View.inflate(this.mController.tml, R.i.loading_footer, null);
            cVar.hoT = inflate.findViewById(R.h.loading_progress);
            cVar.hoU = inflate.findViewById(R.h.loading_end);
            cVar.hoV = inflate.findViewById(R.h.loading_tip);
            cVar.hoT.setVisibility(8);
            cVar.hoU.setVisibility(8);
            cVar.hoV.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            EC(0);
        }
        this.tEL.setAdapter(this.tEN);
        this.tEL.setOnItemClickListener(new 2(this));
        this.tEL.setOnTouchListener(this);
        if (a.a(this.tEN)) {
            this.tEL.setOnScrollListener(this.jUS);
        }
        this.hpe = new b();
        this.hpe.mv(a.b(this.tEN));
        this.hpe.a(this);
        this.hpe.erG = false;
    }

    public final void WX() {
    }

    public final void WW() {
        finish();
    }

    public final void pk(String str) {
        CharSequence charSequence = null;
        if (!bi.oW(str) || this.tEJ == null) {
            a aVar = this.tEN;
            aVar.dBm = str;
            if (bi.oW(str)) {
                aVar.acV();
                aVar.tFd = false;
                aVar.tFh = false;
                aVar.lQ(true);
                return;
            } else if (aVar.csu()) {
                aVar.tFd = true;
                aVar.tFh = false;
                aVar.csw();
                aVar.bx(str, false);
                aVar.aag(str);
                return;
            } else {
                aVar.bx(str, true);
                if (aVar.tER && aVar.tFd) {
                    aVar.aag(str);
                    return;
                }
                return;
            }
        }
        String str2 = this.tEJ;
        this.tEJ = null;
        if (!str2.equals("")) {
            this.hpe.setSearchContent(str2);
        }
        b bVar = this.hpe;
        if (a.b(this.tEN)) {
            charSequence = this.mController.tml.getResources().getString(R.l.bizchat_search_main_hint);
        } else if (a.a(this.tEN)) {
            charSequence = this.mController.tml.getResources().getString(R.l.bizchat_search_user_hint);
        } else if (a.d(this.tEN)) {
            charSequence = this.mController.tml.getResources().getString(R.l.bizchat_search_group_hint);
        }
        bVar.setHint(charSequence);
        this.hpe.clearFocus();
    }

    public final boolean pj(String str) {
        YC();
        return true;
    }

    public final void Uq() {
        YC();
    }

    public final void Ur() {
    }

    protected void onPause() {
        super.onPause();
        this.hpe.cancel();
        this.hpe.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.enterprise_bizchat_search;
    }

    public final boolean auW() {
        YC();
        return false;
    }

    public final void EC(int i) {
        if (this.tEK != null) {
            c cVar = this.tEK;
            switch (i) {
                case 1:
                    cVar.u(true, false);
                    return;
                case 2:
                    cVar.u(false, true);
                    return;
                default:
                    cVar.u(false, false);
                    return;
            }
        }
    }
}
