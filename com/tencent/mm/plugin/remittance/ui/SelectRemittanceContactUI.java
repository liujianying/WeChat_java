package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private int fromScene;
    private List<String> gRN;
    private View kXV;
    private List<String> mBM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void Wj() {
        super.Wj();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        x.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + stringExtra);
        this.mBM = new ArrayList();
        if (!bi.oW(stringExtra)) {
            this.mBM = bi.F(stringExtra.split(","));
        }
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cyz());
        hashSet.addAll(s.cyA());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!bi.oW(stringExtra2)) {
            hashSet.addAll(bi.F(stringExtra2.split(",")));
        }
        this.gRN = new ArrayList();
        this.gRN.addAll(hashSet);
    }

    protected final o Wn() {
        return new c(this, this.mBM, this.gRN, this.fromScene);
    }

    protected final m Wo() {
        return new q(this, this.gRN, false, this.scene);
    }

    public final int[] bbG() {
        if (this.fromScene == 1) {
            return new int[]{131072, 131075};
        }
        return new int[]{131072};
    }

    public final void iV(int i) {
        int s;
        if (i < getContentLV().getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", s.s(new int[]{s.ukE, 16384, 64, Downloads.RECV_BUFFER_SIZE, 262144}));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(i.wallet_select_create_chatroom_title));
                intent.putExtra("without_openim", true);
            } else {
                s = s.s(new int[]{16, 1, 2, 4, 16384});
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s);
                intent.putExtra("titile", getString(i.remittance_select_receiver_title));
                intent.putExtra("sub_title", getString(i.wallet_wechat_authenticate_safely));
            }
            d.b(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.push_up_in, com.tencent.mm.plugin.wxpay.a.a.fast_faded_out);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
        if (aVar != null) {
            ab abVar = aVar.guS;
            if (abVar != null) {
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{abVar.field_username});
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", r0);
                setResult(-1, intent2);
                finish();
                YC();
                if (cyp() instanceof c) {
                    boolean z;
                    s = i - getContentLV().getHeaderViewsCount();
                    c cVar = (c) cyp();
                    x.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[]{Integer.valueOf(s)});
                    if (cVar.mBK >= 0) {
                        if (cVar.mBL < 0) {
                            z = true;
                        } else if (s > cVar.mBK && s < cVar.mBL) {
                            z = true;
                        }
                        if (z) {
                            h.mEJ.h(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                        }
                    }
                    z = false;
                    if (z) {
                        h.mEJ.h(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            x.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        if (this.fromScene == 1) {
            return getString(i.wallet_select_conversation_title);
        }
        return getString(i.remittance_title);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.kXV == null) {
            View inflate = View.inflate(this, g.select_conversation_header, null);
            this.kXV = inflate.findViewById(f.content);
            TextView textView = (TextView) inflate.findViewById(f.tip_tv);
            if (this.fromScene == 1) {
                textView.setText(i.wallet_select_conversation_create);
            } else {
                textView.setText(i.remittance_go_select_contact);
            }
            listView.addHeaderView(inflate);
        }
        this.kXV.setVisibility(i);
    }

    protected final void bbH() {
        super.bbH();
        YC();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bbH();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
