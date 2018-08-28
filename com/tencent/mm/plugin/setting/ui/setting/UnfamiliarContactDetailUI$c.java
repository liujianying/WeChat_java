package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.MaskLayout;

class UnfamiliarContactDetailUI$c extends t {
    View SU;
    MaskLayout hPe;
    CheckBox jBR;
    final /* synthetic */ UnfamiliarContactDetailUI mUT;
    TextView mVa;
    TextView mVb;
    ImageView mVc;
    ImageView mVd;
    LinearLayout mVe;
    LinearLayout mVf;

    static /* synthetic */ void a(UnfamiliarContactDetailUI$c unfamiliarContactDetailUI$c, b bVar, int i) {
        if (bVar != null) {
            String str;
            if (UnfamiliarContactDetailUI.a(unfamiliarContactDetailUI$c.mUT)) {
                UnfamiliarContactDetailUI$f.mVv++;
            } else {
                UnfamiliarContactDetailUI$f.mVw++;
            }
            String str2 = bVar.daA;
            String str3 = bVar.guS.field_username;
            String str4 = bVar.guS.field_nickname;
            if (bi.oW(str2)) {
                bq Hh = ((i) g.l(i.class)).FS().Hh(str3);
                if (!(Hh == null || bi.oW(Hh.field_encryptUsername))) {
                    str = Hh.field_conRemark;
                    if (!bi.oW(str3)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str3);
                        intent.putExtra("Contact_RemarkName", str);
                        intent.putExtra("Contact_Nick", str4);
                        com.tencent.mm.plugin.setting.b.ezn.d(intent, unfamiliarContactDetailUI$c.mUT);
                        UnfamiliarContactDetailUI.a(unfamiliarContactDetailUI$c.mUT, i);
                    }
                }
            }
            str = str2;
            if (!bi.oW(str3)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str3);
                intent2.putExtra("Contact_RemarkName", str);
                intent2.putExtra("Contact_Nick", str4);
                com.tencent.mm.plugin.setting.b.ezn.d(intent2, unfamiliarContactDetailUI$c.mUT);
                UnfamiliarContactDetailUI.a(unfamiliarContactDetailUI$c.mUT, i);
            }
        }
    }

    public UnfamiliarContactDetailUI$c(UnfamiliarContactDetailUI unfamiliarContactDetailUI, View view) {
        this.mUT = unfamiliarContactDetailUI;
        super(view);
        this.SU = view;
        this.hPe = (MaskLayout) view.findViewById(f.contact_avatar);
        this.mVa = (TextView) view.findViewById(f.contact_nick);
        this.mVb = (TextView) view.findViewById(f.contact_alphabet);
        this.mVc = (ImageView) view.findViewById(f.contact_sns_notreceive_iv);
        this.mVd = (ImageView) view.findViewById(f.contact_sns_notvisible_iv);
        this.mVe = (LinearLayout) view.findViewById(f.checkbox_area);
        this.jBR = (CheckBox) view.findViewById(f.checkbox);
        this.mVf = (LinearLayout) view.findViewById(f.item_content);
        this.mVe.setOnClickListener(new 1(this, unfamiliarContactDetailUI));
        view.setOnClickListener(new 2(this, unfamiliarContactDetailUI));
    }
}
