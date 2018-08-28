package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.protocal.c.bwz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@a(3)
public class SettingsSearchAuthUI extends MMActivity implements e {
    private ListView CU;
    private ProgressDialog kxR;
    private byte[] mOK;
    private boolean mSv;
    private com.tencent.mm.plugin.fts.ui.widget.a mTD;
    private View mTE;
    private TextView mTF;
    private TextView mTG;
    private List<bwy> mTH = new ArrayList();
    private a mTI;

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.mTE.setVisibility(0);
        settingsSearchAuthUI.mTF.setVisibility(0);
        settingsSearchAuthUI.mTG.setVisibility(8);
        settingsSearchAuthUI.CU.setVisibility(8);
        settingsSearchAuthUI.mTH.clear();
        settingsSearchAuthUI.btI();
    }

    static /* synthetic */ void c(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.mTE.setVisibility(8);
        settingsSearchAuthUI.mTF.setText("");
        settingsSearchAuthUI.mTH.clear();
        settingsSearchAuthUI.CU.setVisibility(8);
        settingsSearchAuthUI.btI();
    }

    static /* synthetic */ String cb(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (bwz bwz : list) {
            stringBuilder.append(bwz.mPl);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.mTD = new com.tencent.mm.plugin.fts.ui.widget.a(this);
        this.CU = (ListView) findViewById(f.auth_list_view);
        this.mTI = new a(this, (byte) 0);
        this.CU.setAdapter(this.mTI);
        this.mTE = findViewById(f.search_result_container);
        this.mTF = (TextView) findViewById(f.search_bg_view);
        this.mTG = (TextView) findViewById(f.search_no_result);
        btI();
        getSupportActionBar().setCustomView(this.mTD);
        this.mTD.setSearchViewListener(new 1(this));
        this.mTD.getFtsEditText().setFtsEditTextListener(new 2(this));
        this.mTF.setOnClickListener(new 3(this));
        this.CU.setOnItemClickListener(new 4(this));
        this.CU.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 == i3) {
                    x.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                    if (SettingsSearchAuthUI.this.mOK != null) {
                        SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.mOK);
                        SettingsSearchAuthUI.this.mOK = null;
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(1169, this);
        g.DF().a(1127, this);
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(1169, this);
        g.DF().b(1127, this);
    }

    private void btI() {
        this.mController.removeAllOptionMenu();
        if (!this.mTH.isEmpty()) {
            if (this.mSv) {
                addTextOptionMenu(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING, getString(i.app_finish), new 6(this));
            } else {
                addTextOptionMenu(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING, getString(i.app_manage), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING) {
                            SettingsSearchAuthUI.this.mSv = true;
                            SettingsSearchAuthUI.this.mTI.notifyDataSetChanged();
                            SettingsSearchAuthUI.this.btI();
                        }
                        return true;
                    }
                });
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.setting.a.a.pop_out, com.tencent.mm.plugin.setting.a.a.anim_not_change);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.setting.a.g.settings_search_auth;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kxR != null) {
            this.kxR.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bA(this, str);
        } else if (lVar.getType() == 1169) {
            int i3;
            com.tencent.mm.plugin.setting.model.i iVar = (com.tencent.mm.plugin.setting.model.i) lVar;
            byte[] toByteArray = (iVar.mON == null || iVar.mON.rLJ != 1) ? null : iVar.mON.rLH.toByteArray();
            this.mOK = toByteArray;
            if (((com.tencent.mm.plugin.setting.model.i) lVar).mOK != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.mTH.clear();
            }
            com.tencent.mm.plugin.setting.model.i iVar2 = (com.tencent.mm.plugin.setting.model.i) lVar;
            this.mTH.addAll(iVar2.mON != null ? iVar2.mON.rLI : Collections.emptyList());
            if (this.mTH.isEmpty()) {
                this.mTE.setVisibility(0);
                this.mTF.setVisibility(8);
                this.mTG.setVisibility(0);
                this.CU.setVisibility(8);
                this.mTH.clear();
                btI();
                return;
            }
            this.mTI.mSx = this.mTH;
            this.mTI.notifyDataSetChanged();
            this.mTE.setVisibility(8);
            this.CU.setVisibility(0);
            btI();
        } else if (lVar.getType() == 1127) {
            String str2 = ((c) lVar).appId;
            if (!bi.oW(str2)) {
                if (!this.mTH.isEmpty()) {
                    Iterator it = this.mTH.iterator();
                    while (it.hasNext()) {
                        if (((bwy) it.next()).bPS.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.mTI.notifyDataSetChanged();
            }
        }
    }
}
