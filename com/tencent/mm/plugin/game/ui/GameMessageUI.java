package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.b.a;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.s.d;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameMessageUI extends GameCenterActivity implements OnItemClickListener, e {
    private int cYQ = 0;
    private TextView eFf;
    private int hop;
    private OnScrollListener jUS = new 4(this);
    private ListView kaT;
    private n kaU;
    private View kaV;
    private int kaW = 1;
    private boolean kaX = false;
    private boolean kaY = false;
    private String kaZ = "";
    private OnClickListener kba;
    private OnClickListener kbb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(573, this);
        this.cYQ = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.kaZ = getIntent().getStringExtra("game_manage_url");
        initView();
        ((b) g.l(b.class)).aSi();
        v.aUc();
    }

    protected void onResume() {
        super.onResume();
        this.kaU.notifyDataSetChanged();
        if (this.kaY && this.kaV != null) {
            this.kaT.removeHeaderView(this.kaV);
        }
    }

    protected final void initView() {
        setMMTitle(i.game_message);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(i.app_clear), new 2(this));
        this.hop = getIntent().getIntExtra("game_report_from_scene", 0);
        this.kaT = (ListView) findViewById(f.e.game_msg_lv);
        this.kaT.setOnItemClickListener(this);
        if (this.cYQ > 20) {
            if (com.tencent.mm.plugin.game.model.f.dw(this)) {
                this.kaV = View.inflate(this, f.f.game_msg_tips, null);
                this.kaV.setOnClickListener(new 5(this));
                this.kaT.addHeaderView(this.kaV);
                this.kaV.setVisibility(0);
                com.tencent.mm.plugin.game.model.f.dx(this);
            } else if (this.kaV != null) {
                this.kaV.setVisibility(8);
            }
        }
        s sVar = new s();
        sVar.jNe = true;
        this.kaU = new n(this, sVar, this.hop);
        this.kaU.lB(true);
        ra(8);
        this.kaU.tlG = new 3(this);
        this.kaT.setOnScrollListener(this.jUS);
        this.kaT.setAdapter(this.kaU);
        an.a(this.mController.tml, 13, 1300, 0, 1, 0, null, this.hop, 0, null, null, null);
    }

    private void ra(int i) {
        if (this.eFf == null) {
            this.eFf = (TextView) findViewById(f.e.game_msg_empty_tv);
        }
        this.eFf.setVisibility(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        ((c) g.l(c.class)).aSj().aUe();
        finish();
    }

    protected final int getLayoutId() {
        return f.f.game_message;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kaU != null) {
            this.kaU.aYc();
        }
        g.DF().b(573, this);
        boolean fV = ((c) g.l(c.class)).aSj().fV("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        x.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[]{Boolean.valueOf(fV), r1});
        ((c) g.l(c.class)).aSj().aUe();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s sVar = (s) adapterView.getAdapter().getItem(i);
        if (sVar == null) {
            x.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[]{Integer.valueOf(i)});
            return;
        }
        sVar.aTW();
        int a;
        Bundle bundle;
        if (sVar.field_msgType == 100) {
            if (!bi.oW(sVar.jMQ)) {
                d dVar = (d) sVar.jMw.get(sVar.jMQ);
                if (dVar != null) {
                    a = t.a(this, sVar, dVar, sVar.field_appId, 1301);
                    if (a != 0) {
                        an.a(this.mController.tml, 13, 1301, 4, a, 0, sVar.field_appId, this.hop, sVar.jNa, sVar.field_gameMsgId, sVar.jNb, null);
                    }
                }
            }
        } else if (sVar.jNc == 0) {
            switch (sVar.field_msgType) {
                case 2:
                case 5:
                    if (!com.tencent.mm.pluginsdk.model.app.g.r(this, sVar.field_appId)) {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", sVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = com.tencent.mm.plugin.game.e.c.b(this, sVar.field_appId, null, bundle);
                        break;
                    }
                    com.tencent.mm.plugin.game.model.f.ah(this, sVar.field_appId);
                    a = 3;
                    break;
                case 6:
                    if (!bi.oW(sVar.jML)) {
                        a = com.tencent.mm.plugin.game.e.c.an(this, sVar.jML);
                        break;
                    }
                    return;
                case 10:
                case 11:
                    if (!bi.oW(sVar.jMj)) {
                        a = com.tencent.mm.plugin.game.e.c.an(this, sVar.jMj);
                        break;
                    }
                    return;
                default:
                    return;
            }
            an.a(this.mController.tml, 13, 1301, 4, a, 0, sVar.field_appId, this.hop, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
        } else {
            switch (sVar.jNc) {
                case 1:
                    if (bi.oW(sVar.field_appId)) {
                        x.e("MicroMsg.GameMessageUI", "appid is null");
                        return;
                    }
                    bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", sVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    an.a(this.mController.tml, 13, 1301, 4, com.tencent.mm.plugin.game.e.c.b(this, sVar.field_appId, null, bundle), 0, sVar.field_appId, this.hop, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                case 2:
                    if (com.tencent.mm.pluginsdk.model.app.g.r(this, sVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.f.ah(this, sVar.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", sVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = com.tencent.mm.plugin.game.e.c.b(this, sVar.field_appId, null, bundle);
                    }
                    an.a(this.mController.tml, 13, 1301, 4, a, 0, sVar.field_appId, this.hop, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                case 3:
                    if (bi.oW(sVar.jNd)) {
                        x.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        return;
                    }
                    an.a(this.mController.tml, 13, 1301, 4, com.tencent.mm.plugin.game.e.c.an(this, sVar.jNd), 0, sVar.field_appId, this.hop, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                default:
                    x.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + sVar.jNc);
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.getType())});
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 573) {
                ra(8);
                this.kaU.a(null, null);
            }
        } else if (this.kaU.getCount() > 0) {
            x.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        } else if (!a.ezo.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(i.game_get_msg_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public final int aUM() {
        return 13;
    }

    public final int aUN() {
        return 1300;
    }

    public final int aUO() {
        return this.hop;
    }
}
