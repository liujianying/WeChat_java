package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class NewFileExplorerUI$6 implements a {
    final /* synthetic */ NewFileExplorerUI qTk;

    NewFileExplorerUI$6(NewFileExplorerUI newFileExplorerUI) {
        this.qTk = newFileExplorerUI;
    }

    public final void a(boolean z, String str, int i) {
        this.qTk.YC();
        if (z) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.qTk).cfs());
            intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.qTk).cfu());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.qTk).cft());
            intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.qTk));
            intent.putExtra("with_text_content", str);
            this.qTk.setResult(-1, intent);
            this.qTk.finish();
        }
    }
}
