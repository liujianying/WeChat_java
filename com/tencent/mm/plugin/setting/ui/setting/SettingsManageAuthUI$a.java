package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.protocal.c.bwy;
import java.util.List;

class SettingsManageAuthUI$a extends BaseAdapter {
    final /* synthetic */ SettingsManageAuthUI mSw;
    List<bwy> mSx;

    private class a {
        Button eOQ;
        TextView hJd;
        TextView mSB;
        TextView mSC;

        private a() {
        }

        /* synthetic */ a(SettingsManageAuthUI$a settingsManageAuthUI$a, byte b) {
            this();
        }
    }

    private SettingsManageAuthUI$a(SettingsManageAuthUI settingsManageAuthUI) {
        this.mSw = settingsManageAuthUI;
    }

    /* synthetic */ SettingsManageAuthUI$a(SettingsManageAuthUI settingsManageAuthUI, byte b) {
        this(settingsManageAuthUI);
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

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.mSw.getLayoutInflater().inflate(g.settings_auth_list_item, null);
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
        aVar.eOQ.setOnClickListener(new 1(this, i));
        if (SettingsManageAuthUI.c(this.mSw)) {
            aVar.eOQ.setVisibility(0);
        } else {
            aVar.eOQ.setVisibility(8);
        }
        if (getItem(i) != null) {
            aVar.hJd.setText(getItem(i).dxK);
            aVar.mSB.setText(getItem(i).stn);
            aVar.mSC.setText(SettingsManageAuthUI.ca(getItem(i).stm));
        }
        return view;
    }
}
