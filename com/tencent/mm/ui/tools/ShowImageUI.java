package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g$a;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery hDd;
    private boolean uCa;
    private a uCb;
    private boolean uCc;

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        au.HU();
        bd dW = c.FT().dW(longExtra);
        g$a gp = g$a.gp(dW.field_content);
        if (o.Wf(stringExtra) || (dW.aQm() && gp != null && gp.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", dW.field_content);
            if (gp != null && gp.type == 2) {
                stringExtra = u.ic("msg_" + dW.field_msgSvrId);
                u.Hx().v(stringExtra, true).p("prePublishId", "msg_" + dW.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.show_image_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!bi.oW(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.uCa = getIntent().getBooleanExtra("key_favorite", false);
        this.uCc = getIntent().getBooleanExtra("show_menu", true);
        this.hDd = (MMGestureGallery) findViewById(R.h.gallery);
        this.hDd.setVerticalFadingEdgeEnabled(false);
        this.hDd.setHorizontalFadingEdgeEnabled(false);
        this.uCb = new a(this, (byte) 0);
        this.uCb.imagePath = getIntent().getStringExtra("key_image_path");
        this.hDd.setAdapter(this.uCb);
        setBackBtn(new 1(this));
        if (this.uCc) {
            addIconOptionMenu(0, R.k.ofm_send_icon, new 2(this));
        }
    }
}
