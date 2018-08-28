package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.protocal.c.bwz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI extends MMActivity implements e {
    private ListView CU;
    private ProgressDialog kxR;
    private byte[] mOK;
    private View mSs;
    private a mSt;
    private List<bwy> mSu = new ArrayList();
    private boolean mSv;

    static /* synthetic */ String ca(List list) {
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
        this.CU = (ListView) findViewById(f.auth_list_view);
        this.mSs = findViewById(f.auth_list_empty_tip);
        this.mSt = new a(this, (byte) 0);
        this.CU.setAdapter(this.mSt);
        this.CU.setOnScrollListener(new 1(this));
        this.CU.setOnItemClickListener(new 2(this));
        btI();
        setMMTitle(i.settings_auth_manage);
        setBackBtn(new 3(this));
    }

    private void btI() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(800, h.actionbar_search_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsManageAuthUI.this.startActivity(new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class));
                b.gD(SettingsManageAuthUI.this);
                return true;
            }
        });
        if (this.mSu.isEmpty()) {
            this.mSs.setVisibility(0);
            return;
        }
        this.mSs.setVisibility(8);
        if (this.mSv) {
            addTextOptionMenu(700, getString(i.app_finish), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == 700) {
                        SettingsManageAuthUI.this.mSv = false;
                        SettingsManageAuthUI.this.mSt.notifyDataSetChanged();
                        SettingsManageAuthUI.this.btI();
                    }
                    return true;
                }
            });
        } else {
            addTextOptionMenu(700, getString(i.app_manage), new 6(this));
        }
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(1146, this);
        g.DF().a(1127, this);
        aI(null);
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(1146, this);
        g.DF().b(1127, this);
    }

    protected final int getLayoutId() {
        return a.g.settings_manage_auth;
    }

    private static void aI(byte[] bArr) {
        g.DF().a(new com.tencent.mm.plugin.setting.model.f(bArr), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kxR != null) {
            this.kxR.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.bA(this, str);
        } else if (lVar.getType() == 1146) {
            int i3;
            com.tencent.mm.plugin.setting.model.f fVar = (com.tencent.mm.plugin.setting.model.f) lVar;
            byte[] toByteArray = (fVar.mOJ == null || fVar.mOJ.rLJ != 1) ? null : fVar.mOJ.rLH.toByteArray();
            this.mOK = toByteArray;
            if (((com.tencent.mm.plugin.setting.model.f) lVar).mOK != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.mSu.clear();
            }
            com.tencent.mm.plugin.setting.model.f fVar2 = (com.tencent.mm.plugin.setting.model.f) lVar;
            this.mSu.addAll(fVar2.mOJ != null ? fVar2.mOJ.rLI : Collections.emptyList());
            this.mSt.mSx = this.mSu;
            this.mSt.notifyDataSetChanged();
            btI();
        } else if (lVar.getType() == 1127) {
            String str2 = ((c) lVar).appId;
            if (!bi.oW(str2)) {
                if (!this.mSu.isEmpty()) {
                    Iterator it = this.mSu.iterator();
                    while (it.hasNext()) {
                        if (((bwy) it.next()).bPS.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.mSt.notifyDataSetChanged();
            }
        }
    }
}
