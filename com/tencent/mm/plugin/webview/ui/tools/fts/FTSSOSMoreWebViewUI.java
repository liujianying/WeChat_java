package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.ad;

public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private int qdX;
    private View qeG;

    protected final void ant() {
        super.ant();
        this.qeG = findViewById(R.h.webview_keyboard_ll);
        bXk().czi();
        bXk().aQY();
        this.mPT.setVisibility(0);
        bXk().aQW();
        this.lAV.setVisibility(8);
        this.qdX = a.fromDPToPix(this, 48);
        bXk().setIconRes(com.tencent.mm.au.a.b(getType(), this));
        if (aUM() == 24) {
            this.qeG.setVisibility(4);
        }
        findViewById(R.h.root).setOnTouchListener(new 1(this));
        if (getIntent() != null && getIntent().getBooleanExtra("ftsneedkeyboard", false)) {
            this.mController.contentView.postDelayed(new 2(this), 128);
        }
        Z(getResources().getColor(R.e.white), true);
        ImageButton clearBtn = bXk().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
        }
    }

    protected final int anu() {
        if (!d.fR(23) || com.tencent.mm.ui.statusbar.d.Af()) {
            return super.anu();
        }
        return getResources().getColor(R.e.white);
    }

    public final void fg(boolean z) {
        super.fg(z);
        if (z) {
            this.qdi.setPadding(0, 0, this.qdi.getPaddingRight(), 0);
            this.mPT.setVisibility(8);
            bXk().aQX();
        } else {
            this.qdi.setPadding(this.qdX, 0, this.qdi.getPaddingRight(), 0);
            this.mPT.setVisibility(0);
            bXk().aQW();
        }
        bXk().aQY();
    }

    public boolean anx() {
        bXk().aQY();
        this.qeG.setVisibility(0);
        return super.anx();
    }

    protected final int getLayoutId() {
        return R.i.sos_more_webview_ui;
    }

    protected final void bXg() {
        finish();
    }

    public String getHint() {
        int i = -1;
        if (getType() != 8 || !this.qdz) {
            switch (getType()) {
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
        }
        i = R.l.fts_header_timeline_publisher;
        if (i < 0) {
            return ad.getContext().getResources().getString(R.l.app_search) + AT(getType());
        }
        return ad.getContext().getResources().getString(R.l.search_detail_page_hint, new Object[]{ad.getContext().getResources().getString(i)});
    }

    protected final void bXh() {
        super.bXh();
        this.qeG.setVisibility(0);
    }
}
