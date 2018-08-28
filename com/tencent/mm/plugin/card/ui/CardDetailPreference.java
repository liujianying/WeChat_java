package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f gua;
    private TextView hBA;
    private b htQ;
    private List<com.tencent.mm.plugin.card.model.b> htU = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.htQ = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.htQ == null || this.htQ.awm() == null || this.htQ.awn() == null) {
            x.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        CardTextPreference cardTextPreference;
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.htQ.awm().hwg)) {
            stringBuilder.append(this.htQ.awm().hwg);
        }
        stringBuilder.append(getString(g.card_detail_info));
        setMMTitle(stringBuilder.toString());
        setBackBtn(new 1(this));
        this.gua = this.tCL;
        this.htU.clear();
        if (this.htQ.awn().rmY != null && this.htQ.awn().rmY.size() > 0) {
            this.htU.addAll(l.az(this.htQ.awn().rmY));
        }
        if (this.htQ.awn().rmZ != null && this.htQ.awn().rmZ.size() > 0) {
            Collection az = l.az(this.htQ.awn().rmZ);
            ((com.tencent.mm.plugin.card.model.b) az.get(0)).hvi = true;
            this.htU.addAll(az);
        }
        ayf();
        aye();
        ayd();
        if (!TextUtils.isEmpty(this.htQ.awm().rnI)) {
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(e.mm_preference);
            cardTextPreference.setTitle(getString(g.card_picture_detail));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.azW();
            ayf();
            this.gua.a(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.htQ.awm().rnF)) {
            ayf();
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(e.mm_preference);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle(g.card_mall_product_seller);
            cardTextPreference.setSummary(this.htQ.awm().rnF);
            cardTextPreference.hIZ = getResources().getColor(a.link_color);
            cardTextPreference.azV();
            this.gua.a(cardTextPreference);
            xG("");
        }
        if (this.htQ.awm() != null && !TextUtils.isEmpty(this.htQ.awm().bhd) && this.hBA != null) {
            this.hBA.setText(this.htQ.awm().bhd);
            this.hBA.setVisibility(0);
        }
    }

    private void ayd() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.htU.size()) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.htU.get(i2);
                Preference preference = new Preference(this);
                preference.setLayoutResource(e.mm_preference);
                preference.setKey(bVar.title);
                preference.setTitle(bVar.title);
                if (!TextUtils.isEmpty(bVar.huX)) {
                    preference.setSummary(bVar.huX);
                }
                if (bVar.hvi) {
                    ayf();
                }
                this.gua.a(preference);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void aye() {
        if (this.htQ.awm().rnH != null && this.htQ.awm().rnH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htQ.awm().rnH.size()) {
                    pr prVar = (pr) this.htQ.awm().rnH.get(i2);
                    if (!TextUtils.isEmpty(prVar.huX)) {
                        CardTextPreference cardTextPreference = new CardTextPreference(this);
                        cardTextPreference.setLayoutResource(e.mm_preference);
                        cardTextPreference.setTitle(prVar.huX);
                        cardTextPreference.azW();
                        xG(prVar.title);
                        this.gua.a(cardTextPreference);
                    }
                    i = i2 + 1;
                } else {
                    ayf();
                    return;
                }
            }
        }
    }

    private void ayf() {
        this.gua.a(new PreferenceSmallCategory(this));
    }

    private void xG(String str) {
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle(" ");
        } else {
            preferenceTitleCategory.setTitle(str);
        }
        this.gua.a(preferenceTitleCategory);
    }

    public final int Ys() {
        return h.card_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("card_phone")) {
            String str = this.htQ.awm().rnF;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("tel:" + str));
            startActivity(intent);
        }
        if (preference.mKey.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.d.b.a(this, this.htQ.awm().rnI, 0);
        } else {
            for (int i = 0; i < this.htU.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.htU.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.mKey) || TextUtils.isEmpty(bVar.url))) {
                    if (com.tencent.mm.plugin.card.d.b.e(this.htQ.awq(), bVar.rnv, bVar.rnw, 1028, 0)) {
                        break;
                    }
                    com.tencent.mm.plugin.card.d.b.a(this, bVar.url, 1);
                }
            }
        }
        return false;
    }

    public final View ayg() {
        View inflate = getLayoutInflater().inflate(e.source_layout, null);
        this.hBA = (TextView) inflate.findViewById(d.source);
        this.hBA.setVisibility(8);
        return inflate;
    }
}
