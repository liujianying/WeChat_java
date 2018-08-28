package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a;

@a(3)
public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        cqh();
    }

    public String getHint() {
        Object stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        int i = -1;
        switch (this.type) {
            case 1:
                i = R.l.search_education_biz_contact;
                break;
            case 2:
                i = R.l.search_education_article;
                break;
            case 8:
                i = R.l.fts_header_timeline;
                break;
            case 16:
                i = R.l.fts_header_poi;
                break;
            case i$l.AppCompatTheme_imageButtonStyle /*64*/:
                i = R.l.app_brand_entrance;
                break;
            case MapRouteSectionWithName.kMaxRoadNameLength /*128*/:
                i = R.l.fts_header_emoji_product;
                break;
            case 256:
            case 384:
                i = R.l.fts_header_emoji;
                break;
            case 512:
                i = R.l.fts_header_music;
                break;
            case 1024:
                i = R.l.fts_header_novel;
                break;
        }
        if (i < 0) {
            return ad.getContext().getResources().getString(R.l.app_search);
        }
        return ad.getContext().getResources().getString(R.l.search_detail_page_hint, new Object[]{ad.getContext().getResources().getString(i)});
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.websearch.api.ad.bTj();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.websearch.api.ad.bTk();
    }

    public void onClickCancelBtn(View view) {
        super.onClickCancelBtn(view);
        finish();
    }

    protected final boolean anv() {
        return true;
    }
}
