package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.ui.base.h;
import java.util.List;

class SettingsSearchAuthUI$a extends BaseAdapter {
    List<bwy> mSx;
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    private SettingsSearchAuthUI$a(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    /* synthetic */ SettingsSearchAuthUI$a(SettingsSearchAuthUI settingsSearchAuthUI, byte b) {
        this(settingsSearchAuthUI);
    }

    public final int getCount() {
        if (this.mSx == null || this.mSx.isEmpty()) {
            return 0;
        }
        return this.mSx.size();
    }

    /* renamed from: vN */
    public final bwy getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (bwy) this.mSx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.mTJ.getLayoutInflater().inflate(g.settings_auth_list_item, null);
            a aVar2 = new a(this, (byte) 0);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hJd = (TextView) view.findViewById(f.settings_auth_item_name);
        aVar.mSB = (TextView) view.findViewById(f.settings_auth_item_type);
        aVar.mSC = (TextView) view.findViewById(f.settings_auth_item_auth_list);
        aVar.eOQ = (Button) view.findViewById(f.settings_auth_del_btn);
        aVar.eOQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SettingsSearchAuthUI$a.this.getItem(i) != null) {
                    c cVar = new c(SettingsSearchAuthUI$a.this.getItem(i).bPS, 2);
                    if (SettingsSearchAuthUI.j(SettingsSearchAuthUI$a.this.mTJ) != null) {
                        SettingsSearchAuthUI.j(SettingsSearchAuthUI$a.this.mTJ).dismiss();
                    }
                    com.tencent.mm.kernel.g.DF().a(cVar, 0);
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI$a.this.mTJ, h.a(SettingsSearchAuthUI$a.this.mTJ, SettingsSearchAuthUI$a.this.mTJ.getString(i.app_sending), true, new 1(this, cVar)));
                }
            }
        });
        if (SettingsSearchAuthUI.f(this.mTJ)) {
            aVar.eOQ.setVisibility(0);
        } else {
            aVar.eOQ.setVisibility(8);
        }
        if (getItem(i) != null) {
            aVar.hJd.setText(getItem(i).dxK);
            aVar.mSB.setText(getItem(i).stn);
            aVar.mSC.setText(SettingsSearchAuthUI.cb(getItem(i).stm));
        }
        return view;
    }
}
