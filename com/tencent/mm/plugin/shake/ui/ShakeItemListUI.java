package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.ugc.TXRecordCommon;

public class ShakeItemListUI extends MMActivity {
    private a dWD = null;
    private ListView eMX;
    private View gvO;
    private d hlb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            m.buC().vT(ShakeItemListUI.this.id);
        }
    };
    private int id;
    public long mZx = 0;
    private boolean mZy = false;
    private a mZz;
    private int showType;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        m.buC().c(this.mZz);
        this.mZz.WS();
        x.i("MicroMsg.ShakeItemListUI", "onResume");
    }

    protected final void initView() {
        this.dWD = new a((Context) this);
        au.HU();
        int a = bi.a((Integer) c.DT().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!bi.oW(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.mZy = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(R.l.app_clear), new 1(this));
        this.eMX = (ListView) findViewById(R.h.nearby_friend_lv);
        this.gvO = getLayoutInflater().inflate(R.i.shake_friends_views_fooder, null);
        this.gvO.findViewById(R.h.shake_friends_see_olders).setOnClickListener(new 2(this));
        this.eMX.addFooterView(this.gvO);
        if (this.showType == -1) {
            this.gvO.findViewById(R.h.shake_friends_see_olders).setVisibility(0);
        } else {
            this.gvO.findViewById(R.h.shake_friends_see_olders).setVisibility(8);
        }
        this.mZz = new a(this, this);
        this.mZz.wa(this.showType);
        if (this.mZz.getCount() <= 0) {
            this.eMX.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.nearby_friend_not_found);
            textView.setText(wb(this.showType));
            textView.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.eMX.setAdapter(this.mZz);
            this.eMX.setOnItemClickListener(new 3(this, a));
            this.eMX.setOnItemLongClickListener(new 4(this, new k(this)));
        }
        setBackBtn(new 5(this));
        AnonymousClass6 anonymousClass6 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(ShakeItemListUI.this.eMX);
            }
        };
        this.eMX.setOnTouchListener(new 7(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((com.tencent.mm.plugin.shake.b.d) this.mZz.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.app_delete);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        this.mZz.aYc();
        a aVar = this.mZz;
        if (aVar.eKg != null) {
            aVar.eKg.detach();
            aVar.eKg = null;
        }
        m.buC().d(this.mZz);
        x.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.dWD != null) {
            this.dWD.detach();
        }
        super.onDestroy();
    }

    protected final void wa(int i) {
        this.mZz.wa(i);
        switch (i) {
            case -12:
            case -1:
                if (this.gvO != null) {
                    this.gvO.findViewById(R.h.shake_friends_see_olders).setVisibility(0);
                    return;
                }
                return;
            case 0:
            case 11:
                if (this.gvO != null) {
                    this.gvO.findViewById(R.h.shake_friends_see_olders).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.shake_friend;
    }

    public static int wb(int i) {
        switch (i) {
            case -12:
            case 11:
                return R.l.shake_ibeacon_history_empty;
            case -6:
            case 5:
                return R.l.shake_tv_history_empty;
            case TXRecordCommon.START_RECORD_ERR_LICENCE_VERIFICATION_FAILED /*-5*/:
            case 4:
                return R.l.shake_music_history_empty;
            case -1:
            case 0:
                return R.l.shake_friends_history_empty;
            case 100:
                return R.l.shake_history_empty;
            default:
                return R.l.shake_friends_history_empty;
        }
    }
}
