package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class EmojiStoreV2UI extends MMActivity {
    private int irJ = 0;
    private HashMap<Integer, a> irS = new HashMap();
    EmojiStoreV2TabView irT;
    private EmojiStoreV2ViewPager irU;
    private a irV;
    private boolean irW = true;
    private boolean irX = false;

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        String value = g.AT().getValue("ShowPersonalEmotion");
        x.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[]{value});
        if (bi.oW(value) || bi.WU(value) != 1) {
            this.irW = false;
        } else {
            this.irW = true;
        }
        if (this.irW) {
            this.irJ = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        au.Em().H(new 3(this));
        au.HU();
        boolean booleanValue = ((Boolean) c.DT().get(a.sOX, Boolean.valueOf(false))).booleanValue();
        if (this.irT != null) {
            this.irT.eu(booleanValue);
        }
        h.mEJ.a(406, 0, 1, false);
        h.mEJ.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new 5(this));
    }

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_ui;
    }

    protected final void initView() {
        addIconOptionMenu(0, R.k.actionbar_icon_dark_search, new 1(this));
        addIconOptionMenu(1, R.k.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
                EmojiStoreV2UI.this.startActivity(intent);
                return false;
            }
        });
        this.irT = (EmojiStoreV2TabView) findViewById(R.h.emoji_store_v2_tab);
        this.irU = (EmojiStoreV2ViewPager) findViewById(R.h.emoji_store_v2_pager);
        this.irU.setOffscreenPageLimit(0);
        this.irV = new a(this, this, this.irU, this.irW);
        if (this.irW) {
            this.irT.setVisibility(0);
        } else {
            this.irT.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.irS != null) {
            this.irS.clear();
        }
    }

    public final a oW(int i) {
        a aVar = null;
        if (i < 0) {
            return null;
        }
        if (this.irS.containsKey(Integer.valueOf(i))) {
            return (a) this.irS.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                aVar = (a) Fragment.instantiate(this, b.class.getName(), null);
                break;
            case 1:
                aVar = (a) Fragment.instantiate(this, c.class.getName(), null);
                break;
            default:
                x.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                break;
        }
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[]{Integer.valueOf(i)});
        if (aVar != null) {
            aVar.setParent(this);
        }
        this.irS.put(Integer.valueOf(i), aVar);
        return aVar;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (this.irV != null && this.irV.oX(this.irJ) != null) {
            this.irV.oX(this.irJ).onActivityResult(i, i2, intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
