package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.j;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;

public class SnsTagPartlyUI extends MMActivity implements e {
    private ListView eVT;
    private a obL;
    private OnClickListener obM = new OnClickListener() {
        public final void onClick(View view) {
            if (SnsTagPartlyUI.this.obL == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
            } else if (tag instanceof Integer) {
                t tVar = (t) SnsTagPartlyUI.this.obL.getItem(((Integer) tag).intValue());
                SnsTagPartlyUI.this.tipDialog = h.a(SnsTagPartlyUI.this, null, true, new 1(this));
                g.Ek();
                g.Eh().dpP.a(new com.tencent.mm.plugin.sns.model.x(tVar.field_tagId, tVar.field_tagName), 0);
            } else {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
            }
        }
    };
    protected p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ek();
        g.Eh().dpP.a(j.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.a(290, this);
        initView();
    }

    public void onDestroy() {
        g.Ek();
        g.Eh().dpP.b(j.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.b(290, this);
        if (this.obL != null) {
            this.obL.aYc();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.obL != null) {
            this.obL.a("", null);
        }
    }

    protected final void initView() {
        setMMTitle(i.j.settings_privacy_edit_sns_group);
        setBackBtn(new 1(this));
        this.eVT = (ListView) findViewById(f.sns_tag_list);
        this.eVT.setOnItemClickListener(new 2(this));
        this.obL = new a(this, this);
        this.eVT.addFooterView(View.inflate(this, i.g.sns_tag_partly_footer, null));
        this.eVT.setAdapter(this.obL);
        addTextOptionMenu(0, getString(i.j.sns_tag_partly_edit), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                a a = SnsTagPartlyUI.this.obL;
                if (SnsTagPartlyUI.this.obL.obP) {
                    z = false;
                } else {
                    z = true;
                }
                a.obP = z;
                SnsTagPartlyUI.this.updateOptionMenuText(0, SnsTagPartlyUI.this.obL.obP ? SnsTagPartlyUI.this.getString(i.j.app_finish) : SnsTagPartlyUI.this.getString(i.j.sns_tag_partly_edit));
                SnsTagPartlyUI.this.obL.notifyDataSetChanged();
                return true;
            }
        });
        this.obL.tlG = new a() {
            public final void Xa() {
            }

            public final void Xb() {
                boolean z = true;
                SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
                if (SnsTagPartlyUI.this.obL.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.enableOptionMenu(z);
            }
        };
    }

    protected final int getLayoutId() {
        return i.g.sns_tag_partly_ui2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        String stringExtra2 = intent.getStringExtra("Select_room_name");
                        if (stringExtra != null) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("k_sns_tag_id", 0);
                            intent2.putExtra("k_sns_tag_name", bi.aG(stringExtra2, ""));
                            intent2.putExtra("k_sns_tag_list", stringExtra);
                            intent2.setClass(this, SnsTagDetailUI.class);
                            startActivity(intent2);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.obL != null) {
            this.obL.a("", null);
        }
    }
}
