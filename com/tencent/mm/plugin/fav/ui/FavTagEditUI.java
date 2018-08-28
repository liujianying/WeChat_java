package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavTagEditUI extends MMActivity {
    private g jaq;
    private List<String> jar;
    private FavTagPanel jas;
    private FavTagPanel jat;
    private ListView jau;
    private ListView jav;
    private TextView jaw;
    private c jax;
    private d jay;
    private boolean jaz;

    protected final int getLayoutId() {
        return f.fav_tag_edit_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.jaq = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(longExtra);
        }
        this.jar = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.jat = (FavTagPanel) findViewById(e.fav_tag_input_panel);
        this.jau = (ListView) findViewById(e.tag_panel_list);
        this.jav = (ListView) findViewById(e.search_tag_list);
        this.jaw = (TextView) findViewById(e.max_size_tips_tv);
        this.jat.lL(true);
        this.jat.setTagEditTextBG(m.d.tag_edittext_gb);
        this.jat.setIsAllowEnterCharacter(true);
        this.jat.setCallBack(new 5(this));
        this.jat.postDelayed(new Runnable() {
            public final void run() {
                FavTagEditUI.this.jat.crO();
                FavTagEditUI.this.showVKB();
            }
        }, 100);
        if (this.jaq != null) {
            this.jat.a(this.jaq.field_tagProto.rBX, this.jaq.field_tagProto.rBX);
        } else if (this.jar != null) {
            this.jat.a(this.jar, this.jar);
        }
        this.jax = new 7(this, this.mController.tml);
        this.jax.bf(this.jaq == null ? null : this.jaq.field_tagProto.rBX);
        if (!(this.jaq == null || this.jaq.field_tagProto.rBW.isEmpty())) {
            View inflate = View.inflate(this.mController.tml, f.fav_tag_panel_item, null);
            TextView textView = (TextView) inflate.findViewById(e.fav_panel_catalog);
            textView.setText(getString(i.favorite_recommended_tag));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(m.c.FavTagPadding);
            this.jas = (FavTagPanel) inflate.findViewById(e.fav_tag_panel);
            this.jas.setVisibility(0);
            this.jas.a(this.jaq.field_tagProto.rBX, this.jaq.field_tagProto.rBW);
            this.jas.setBackgroundResource(m.d.list_thicklinecell_bg);
            this.jas.setPadding(0, 0, 0, dimensionPixelSize);
            this.jas.setCallBack(new a() {
                public final void zO(String str) {
                    FavTagEditUI.this.jat.removeTag(str);
                    FavTagEditUI.this.jax.BF(str);
                    FavTagEditUI.this.aMt();
                }

                public final void zP(String str) {
                    FavTagEditUI.this.jat.bu(str, true);
                    FavTagEditUI.this.jax.BE(str);
                    FavTagEditUI.this.aMt();
                }

                public final void zQ(String str) {
                }

                public final void aGt() {
                }

                public final void zR(String str) {
                }

                public final void zS(String str) {
                }

                public final void i(boolean z, int i) {
                }
            });
            this.jau.addHeaderView(inflate);
        }
        if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().aLn() > 0) {
            this.jau.addHeaderView(View.inflate(this.mController.tml, f.fav_tag_panel_headerview, null));
        }
        this.jau.setAdapter(this.jax);
        this.jau.setOnTouchListener(new 9(this));
        this.jay = new 10(this, this.mController.tml);
        this.jav.setAdapter(this.jay);
        this.jav.setOnTouchListener(new 2(this));
        setMMTitle(i.favorite_edit_tag_tips);
        setBackBtn(new 1(this));
        a(0, getString(i.app_finish), new 3(this, longExtra), b.tmX);
        aMt();
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().a(this.jax);
    }

    private void aMt() {
        if (this.jaz) {
            x.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (cqd()) {
                enableOptionMenu(0, false);
            }
        } else if (this.jaq == null) {
            if (this.jat.getTagCount() > 0 || this.jat.getEditText().length() > 0) {
                if (!cqd()) {
                    enableOptionMenu(0, true);
                }
            } else if (cqd()) {
                enableOptionMenu(0, false);
            }
        } else if (this.jaq.field_tagProto.rBX.size() == this.jat.getTagCount() && this.jat.getEditText().length() <= 0) {
            List tagList = this.jat.getTagList();
            int i = 0;
            while (i < tagList.size()) {
                if (((String) tagList.get(i)).equals(this.jaq.field_tagProto.rBX.get(i))) {
                    i++;
                } else if (!cqd()) {
                    enableOptionMenu(0, true);
                    return;
                } else {
                    return;
                }
            }
            if (cqd()) {
                enableOptionMenu(0, false);
            }
        } else if (!cqd()) {
            enableOptionMenu(0, true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        l favTagSetMgr = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr();
        c cVar = this.jax;
        if (cVar != null) {
            favTagSetMgr.dRX.remove(cVar.toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aMu();
        return true;
    }

    private void aMu() {
        h.a(this.mController.tml, getString(i.favorite_quit_edit_tag_tips), "", getString(i.app_alert_exit), getString(i.app_cancel), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                FavTagEditUI.this.finish();
            }
        }, null);
    }

    public static void a(g gVar, Collection<String> collection, int i) {
        if (gVar != null) {
            Set set;
            x.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[]{collection});
            Set hashSet = new HashSet();
            hashSet.addAll(gVar.field_tagProto.rBX);
            gVar.field_tagProto.rBX.clear();
            if (collection == null || collection.isEmpty()) {
                set = hashSet;
            } else {
                gVar.field_tagProto.rBX.addAll(collection);
                hashSet.removeAll(collection);
                set = hashSet;
            }
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
            com.tencent.mm.plugin.fav.a.b.p(gVar);
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavTagSetMgr().f(set);
            com.tencent.mm.plugin.fav.a.b.a(gVar, i);
        }
    }
}
