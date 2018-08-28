package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.downloader.b$b;
import com.tencent.mm.plugin.downloader.b$c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class FileDownloadConfirmUI extends MMBaseActivity {
    private c evj = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b$b.empty);
        1 1 = new 1(this, getIntent().getLongExtra("extra_download_id", -1));
        OnClickListener anonymousClass2 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        3 3 = new 3(this);
        a aVar = new a(this);
        aVar.abt("");
        aVar.Gr(b$c.file_downloader_confirm_title);
        aVar.Gt(b$c.app_yes).a(1);
        aVar.Gu(b$c.app_no).b(anonymousClass2);
        aVar.a(3);
        this.evj = aVar.anj();
        this.evj.show();
        x.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    }

    protected void onStop() {
        super.onStop();
        this.evj.dismiss();
    }
}
