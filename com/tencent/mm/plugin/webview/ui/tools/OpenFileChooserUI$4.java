package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class OpenFileChooserUI$4 implements Runnable {
    final /* synthetic */ int fYO;
    final /* synthetic */ Intent heh;
    final /* synthetic */ OpenFileChooserUI pWh;

    OpenFileChooserUI$4(OpenFileChooserUI openFileChooserUI, Intent intent, int i) {
        this.pWh = openFileChooserUI;
        this.heh = intent;
        this.fYO = i;
    }

    public final void run() {
        List<String> stringArrayListExtra = this.heh.getStringArrayListExtra("CropImage_OutputPath_List");
        boolean booleanExtra = this.heh.getBooleanExtra("isTakePhoto", false);
        boolean booleanExtra2 = this.heh.getBooleanExtra("CropImage_Compress_Img", true);
        ArrayList arrayList = new ArrayList();
        for (String Qn : stringArrayListExtra) {
            WebViewJSSDKFileItem Qn2 = WebViewJSSDKFileItem.Qn(Qn);
            String str = Qn2.bNH;
            Qn2.fnQ = booleanExtra2;
            e.bUX().b(Qn2);
            x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[]{Qn, str});
            arrayList.add(str);
        }
        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{aj.U(arrayList)});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_callback_local_ids", Qn);
        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(this.pWh));
        this.pWh.setResult(this.fYO, intent);
        this.pWh.finish();
    }
}
