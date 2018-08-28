package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import com.tencent.mm.ui.y;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, e {
    private ListView CU;
    private View Iq;
    private boolean acT = false;
    private String iil;
    private String iiw;
    private int iki = -1;
    private adj imA;
    private ag ioW = new 1(this);
    private String ipP;
    private String ipQ;
    private ImageView ipR;
    private TextView ipS;
    private TextView ipT;
    private TextView ipU;
    private View ipV;
    private View ipW;
    private a ipX;
    private adf ipY;
    private byte[] ipZ;
    private m iqa;
    private a iqb = new 2(this);

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_reward_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iil = getIntent().getStringExtra("extra_id");
        this.iiw = getIntent().getStringExtra("extra_name");
        this.ipP = getIntent().getStringExtra("extra_iconurl");
        this.ipQ = getIntent().getStringExtra("name");
        initView();
        this.imA = i.aEA().igC.ZF(this.iil);
        aGn();
        o.Pj().a(this.ipP, this.ipR, f.cr(this.iil, this.ipP));
        this.ipS.setText(this.iiw);
        this.ipT.setText(this.ipQ);
        if (this.ipY != null) {
            this.ipX.K(this.ipY.rHz);
            this.ipX.iqe = true;
        }
        if (this.imA != null) {
            this.ipU.setText(getString(R.l.emoji_store_reward_info, new Object[]{Integer.valueOf(this.imA.rHy)}));
        }
        au.DF().a(299, this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(299, this);
        o.Pj().br(0);
    }

    protected final void initView() {
        setMMTitle(R.l.emoji_store_reward_detail);
        setBackBtn(new 3(this));
        this.Iq = y.gq(this.mController.tml).inflate(R.i.emoji_store_v2_reward_header_bar, null);
        this.ipR = (ImageView) this.Iq.findViewById(R.h.designer_icon);
        this.ipS = (TextView) this.Iq.findViewById(R.h.product_name);
        this.ipT = (TextView) this.Iq.findViewById(R.h.designer_name);
        this.ipU = (TextView) this.Iq.findViewById(R.h.reward_count);
        this.ipV = findViewById(R.h.root);
        this.CU = (ListView) findViewById(R.h.header_gridview);
        this.ipW = y.gq(this.mController.tml).inflate(R.i.emoji_store_load_more, null);
        this.ipW.setVisibility(8);
        this.CU.addHeaderView(this.Iq);
        this.CU.addFooterView(this.ipW);
        this.ipX = new a(this, this);
        this.CU.setAdapter(this.ipX);
        this.CU.setOnScrollListener(this);
    }

    private void aGn() {
        this.iqa = new m(this.iil, this.ipZ);
        au.DF().a(this.iqa, 0);
    }

    private void es(boolean z) {
        if (!this.acT && this.iki != 0) {
            aGn();
            this.acT = true;
            if (z) {
                this.ioW.sendEmptyMessageDelayed(1002, 200);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        this.acT = false;
        if (this.ipW != null) {
            this.ipW.setVisibility(8);
            this.ioW.removeMessages(1002);
            this.ioW.sendEmptyMessageDelayed(1001, 200);
        }
        switch (lVar.getType()) {
            case 299:
                m mVar = (m) lVar;
                if (i == 0 || i == 4) {
                    this.ipZ = mVar.iiN;
                    if (i2 == 0) {
                        this.iki = 0;
                        if (mVar.aEP() != null) {
                            this.ipX.K(mVar.aEP().rHz);
                            return;
                        }
                        return;
                    } else if (i2 == 2) {
                        this.iki = 2;
                        if (mVar.aEP() != null) {
                            this.ipX.K(mVar.aEP().rHz);
                        }
                        if (!(this.ipX == null || this.Iq == null)) {
                            a aVar = this.ipX;
                            x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[]{Integer.valueOf(aVar.idV + aVar.ioN), Integer.valueOf(this.Iq.getHeight()), Integer.valueOf(com.tencent.mm.bp.a.fl(this))});
                            if (com.tencent.mm.bp.a.fl(this) > ((aVar.idV + aVar.ioN) * this.ipX.getCount()) + this.Iq.getHeight()) {
                                z = false;
                            }
                        }
                        if (!z) {
                            es(false);
                            return;
                        }
                        return;
                    } else if (i2 == 3) {
                        this.iki = 1;
                        this.ipZ = null;
                        this.ipX.iqe = true;
                        es(false);
                        return;
                    } else {
                        return;
                    }
                }
                x.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[]{Integer.valueOf(i)});
                return;
            default:
                return;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.iki == 0 || this.acT) {
            x.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
            return;
        }
        es(true);
        x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
        o.Pj().br(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
