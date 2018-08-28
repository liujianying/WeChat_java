package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public class FTSChattingConvUI extends FTSBaseUI implements OnClickListener {
    private ab guS;
    private String jso;
    private View jwr;
    private f jws;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        c fTSImageLoader = ((n) g.n(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.aPO();
        }
    }

    protected final void initView() {
        super.initView();
        this.jwr = findViewById(d.search_record_layout);
        this.jwr.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(d.gird_title_view);
        ActionBarActivity actionBarActivity = this.mController.tml;
        recyclerView.setLayoutManager(new GridLayoutManager(aQM() ? 2 : 3));
        recyclerView.a(new 1(this));
        recyclerView.setAdapter(new a(this));
    }

    protected final void aQB() {
        this.jso = getIntent().getStringExtra("detail_username");
        this.guS = ((i) g.l(i.class)).FR().Yg(this.jso);
        x.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[]{this.jso});
    }

    private boolean aQM() {
        return this.guS != null && ab.XR(this.guS.field_username);
    }

    protected final d a(e eVar) {
        if (this.jws == null) {
            this.jws = new f(eVar, this.jso);
        }
        return this.jws;
    }

    public final void a(a aVar) {
        if (s.fq(this.jso)) {
            R(this.bWm, 10, aVar.position + 1);
        } else {
            R(this.bWm, 11, aVar.position + 1);
        }
    }

    protected final void aQG() {
        super.aQG();
        this.jwr.setVisibility(0);
    }

    protected final void aQE() {
        super.aQE();
        this.jwr.setVisibility(8);
    }

    protected final void aQF() {
        super.aQF();
        this.jwr.setVisibility(8);
    }

    protected final void aQD() {
        super.aQD();
        this.jwr.setVisibility(8);
    }

    private void kB(int i) {
        if (s.fq(this.jso)) {
            if (((b) g.l(b.class)).Ga().ii(this.jso).Nn() == null) {
                return;
            }
            if (i == 0) {
                h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.Nn().size()), Integer.valueOf(1)});
                return;
            }
            h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.Nn().size()), Integer.valueOf(1)});
        } else if (i == 0) {
            h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else {
            h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    protected final void CO(String str) {
        int i = 1;
        super.CO(str);
        boolean fq = s.fq(this.jso);
        h hVar = h.mEJ;
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        if (!fq) {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        hVar.h(14569, objArr);
    }

    protected final int getLayoutId() {
        return e.fts_detail_ui;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.jws.finish();
        c fTSImageLoader = ((n) g.n(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.aPM();
        }
    }

    public void onClick(View view) {
        Bundle bundle = null;
        if (view instanceof TextView) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (!s.fq(this.jso)) {
                intValue++;
            }
            Intent intent;
            if (intValue == 0) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
                intent = new Intent();
                intent.putExtra("frome_scene", 1);
                intent.putExtra("RoomInfo_Id", this.jso);
                intent.putExtra("title", getResources().getString(n.g.search_by_chatroom_member));
                com.tencent.mm.bg.d.b(this, "chatroom", ".ui.SelectMemberUI", intent);
            } else if (intValue == 1) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
                intent = new Intent();
                intent.putExtra("detail_username", this.jso);
                com.tencent.mm.bg.d.b(this, "chatroom", ".ui.SelectDateUI", intent);
                kB(0);
            } else if (intValue == 2) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.jso);
                intent.putExtra("key_media_type", 1);
                com.tencent.mm.bg.d.e(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
                kB(1);
            } else if (intValue == 3) {
                Bundle toBundle;
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
                Intent intent2 = new Intent();
                intent2.putExtra("kintent_talker", this.jso);
                intent2.putExtra("key_media_type", 2);
                if (VERSION.SDK_INT >= 21) {
                    toBundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                } else {
                    toBundle = null;
                }
                com.tencent.mm.bg.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent2, toBundle);
            } else if (intValue == 4) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.jso);
                intent.putExtra("key_media_type", 3);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                com.tencent.mm.bg.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
            } else if (intValue == 5) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.jso);
                intent.putExtra("key_media_type", 4);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                com.tencent.mm.bg.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
            } else if (intValue == 6) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.jso);
                intent.putExtra("key_media_type", 5);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                com.tencent.mm.bg.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
            }
        }
    }

    private static void R(String str, int i, int i2) {
        x.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[]{String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(0)})});
        h.mEJ.k(13234, r0);
    }
}
