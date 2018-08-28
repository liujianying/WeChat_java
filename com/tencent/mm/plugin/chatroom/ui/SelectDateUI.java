package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private p fUo = null;
    private String gBf;
    private long hMw = -1;
    private DayPickerView hOS;
    private HashMap<String, com.tencent.mm.plugin.chatroom.d.a> hOT;
    private TextView hOU;
    private ag mHandler;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.room_search_chatting_content);
        this.hOS = (DayPickerView) findViewById(R.h.pickerView);
        this.hOU = (TextView) findViewById(R.h.search_nothing_hint);
        this.hOT = new HashMap();
        this.mHandler = new ag(getMainLooper());
        this.gBf = getIntent().getStringExtra("detail_username");
        e.post(new Runnable() {
            public final void run() {
                SelectDateUI.a(SelectDateUI.this);
                SelectDateUI.this.mHandler.post(new 1(this));
            }
        }, "prepare_data");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectDateUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.select_date_ui;
    }

    public final long aAv() {
        return System.currentTimeMillis();
    }

    public final void a(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.SelectDateUI", "null == calendarDay");
            return;
        }
        x.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[]{Long.valueOf(aVar.hKT), Integer.valueOf(aVar.day), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year)});
        x.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(aVar.bJC)});
        com.tencent.mm.plugin.chatroom.a.ezn.e(new Intent().putExtra("Chat_User", this.gBf).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), this);
    }
}
