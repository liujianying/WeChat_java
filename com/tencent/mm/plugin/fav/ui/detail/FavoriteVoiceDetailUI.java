package com.tencent.mm.plugin.fav.ui.detail;

import android.os.Bundle;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.ui.FavDetailFooterView;
import com.tencent.mm.plugin.fav.ui.FavVoiceBaseView;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements a {
    private g iWQ;
    private n iXl;
    private FavDetailTitleView jcK;
    private FavDetailFooterView jcL;
    private FavTagEntrance jcM;
    private FavVoiceBaseView jdR;
    private long jdk;

    protected final int getLayoutId() {
        return f.favorite_voice_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(i.favorite_detail));
        this.jdk = getIntent().getLongExtra("key_detail_info_id", -1);
        this.iWQ = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.jdk);
        if (this.iWQ == null) {
            x.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            F(this.iWQ);
            this.jcK = (FavDetailTitleView) findViewById(e.fav_detail_title);
            this.jcK.D(this.iWQ);
            this.jcL = (FavDetailFooterView) findViewById(e.fav_detail_footer);
            this.jcL.D(this.iWQ);
            this.iXl = new n();
            this.jdR = (FavVoiceBaseView) findViewById(e.voice_player);
            this.jdR.setVoiceHelper(this.iXl);
            vx c = b.c(this.iWQ);
            String b = b.b(c);
            int Be = b.Be(c.rzD);
            if (!com.tencent.mm.a.e.cn(b)) {
                b.m(this.iWQ);
            }
            this.jdR.P(b, Be, c.duration);
            this.jcM = (FavTagEntrance) findViewById(e.fav_tag_entrance);
            this.jcM.setFavItemID(this.iWQ.field_localId);
            this.jcM.setTagContent(this.iWQ.field_tagProto.rBX);
            setBackBtn(new 1(this));
            addIconOptionMenu(0, i.top_item_desc_more, d.mm_title_btn_menu, new 2(this));
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this);
        if (this.jcM != null) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.jcM);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.jdR.stopPlay();
        this.iXl.destroy();
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this);
        if (this.jcM != null) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.jcM);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.jdR.aLs();
        this.iXl.pause();
    }

    public final void a(String str, l lVar) {
        this.iWQ = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.jdk);
        if (this.iWQ == null) {
            x.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
        } else if (this.iWQ.field_itemStatus == 10 && lVar != null && lVar.sKL != null && this.iWQ.field_favProto.rBI.size() > 0) {
            vx c = b.c(this.iWQ);
            String b = b.b(c);
            int Be = b.Be(c.rzD);
            x.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
            this.jdR.P(b, Be, c.duration);
        }
    }
}
