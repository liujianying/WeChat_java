package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.e.a.c;

class AppChooserUI$b {
    ImageView kbT;
    TextView kbU;
    TextView kbW;
    final /* synthetic */ AppChooserUI qRB;
    TextView qRD;
    RadioButton qRE;

    public AppChooserUI$b(AppChooserUI appChooserUI, View view) {
        this.qRB = appChooserUI;
        this.kbT = (ImageView) view.findViewById(c.app_icon);
        this.kbU = (TextView) view.findViewById(c.app_name);
        this.kbW = (TextView) view.findViewById(c.app_desc);
        this.qRD = (TextView) view.findViewById(c.app_status);
        this.qRE = (RadioButton) view.findViewById(c.app_radio);
    }
}
