package com.tencent.mm.ui.chatting.b;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.a;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.n.1;

class n$1$1 implements OnDragListener {
    final /* synthetic */ 1 tPB;

    n$1$1(1 1) {
        this.tPB = 1;
    }

    public final boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                x.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
                return true;
            case 2:
                x.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
                return true;
            case 3:
                x.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
                ClipData clipData = dragEvent.getClipData();
                if (clipData == null) {
                    return true;
                }
                int itemCount = clipData.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    Item itemAt = clipData.getItemAt(i);
                    if (itemAt == null) {
                        x.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                    } else if (itemAt.getIntent() != null) {
                        this.tPB.tPA.bAG.tTq.startActivity(itemAt.getIntent());
                    } else if (itemAt.getUri() != null) {
                        m mVar = new m(this.tPB.tPA.bAG.tTq.getContext(), itemAt.getUri());
                        if (mVar.fileType != 0 && mVar.filePath != null) {
                            switch (mVar.fileType) {
                                case 3:
                                    String str = mVar.filePath;
                                    ((com.tencent.mm.ui.chatting.b.b.x) this.tPB.tPA.bAG.O(com.tencent.mm.ui.chatting.b.b.x.class)).t(q.a(str, this.tPB.tPA.bAG.getTalkerUserName(), true) ? 1 : 0, 0, str);
                                    break;
                                case 4:
                                    Intent intent = new Intent();
                                    intent.setData(itemAt.getUri());
                                    ((af) this.tPB.tPA.bAG.O(af.class)).T(intent);
                                    break;
                                default:
                                    ((a) this.tPB.tPA.bAG.O(a.class)).a(mVar);
                                    break;
                            }
                        }
                        x.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                    } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                        ((aa) this.tPB.tPA.bAG.O(aa.class)).aaq(itemAt.getText().toString());
                    }
                }
                return true;
            case 4:
                x.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
                return true;
            case 5:
                x.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
                return true;
            default:
                x.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
                return false;
        }
    }
}
