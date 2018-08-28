package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn orG = null;
    private TextView orH = null;
    private MMSwitchBtn orI = null;
    private SparseIntArray orJ = new SparseIntArray();
    private int status;

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        x.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.orJ.put(i2, z ? 1 : 2);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.auto_add_friend_title);
        this.status = q.GJ();
        initView();
    }

    private boolean uL(int i) {
        return (this.status & i) != 0;
    }

    protected final int getLayoutId() {
        return R.i.auto_add_friend;
    }

    protected final void initView() {
        this.orG = (MMSwitchBtn) findViewById(R.h.need_to_verify);
        this.orH = (TextView) findViewById(R.h.auto_add_contact_text);
        this.orI = (MMSwitchBtn) findViewById(R.h.auto_add_contact);
        this.orG.setCheck(uL(32));
        if (bGv() == 1) {
            this.orI.setCheck(uL(2097152));
            this.orI.setSwitchListener(new 1(this));
        } else {
            this.orH.setVisibility(8);
            this.orI.setVisibility(8);
        }
        this.orG.setSwitchListener(new 2(this));
        setBackBtn(new 3(this));
    }

    private static int bGv() {
        int i;
        String value = g.AT().getValue("AutoAddFriendShow");
        if (bi.oW(value)) {
            value = "0";
        }
        try {
            i = bi.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        x.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        au.HU();
        c.DT().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.orJ.size(); i++) {
            int keyAt = this.orJ.keyAt(i);
            int valueAt = this.orJ.valueAt(i);
            xt xtVar = new xt();
            xtVar.rDz = keyAt;
            xtVar.rDA = valueAt;
            au.HU();
            c.FQ().b(new a(23, xtVar));
            x.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.orJ.clear();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
