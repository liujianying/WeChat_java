package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private int neX = 1;
    SightDraftContainerView neY;
    private LinkedList<String> neZ = new LinkedList();

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        j lastDrafInfo = sightDraftUI.neY.getLastDrafInfo();
        if (lastDrafInfo != null) {
            String nB = k.nB(lastDrafInfo.field_fileName);
            if (!sightDraftUI.neZ.contains(nB)) {
                sightDraftUI.neZ.add(nB);
                String str = e.dgl + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                x.i("MicroMsg.SightDraftUI", "save src %s dest %s ", new Object[]{nB, str});
                FileOp.y(nB, str);
                r.a(str, sightDraftUI);
                s.makeText(sightDraftUI, sightDraftUI.getString(R.l.sight_old_draft_save, new Object[]{e.dgl}), 1).show();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.sight_old_draft_title);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.black));
        this.neY = new SightDraftContainerView(this);
        setContentView(this.neY);
        this.neY.bwf();
        setBackBtn(new 1(this));
        this.neY.setSightDraftCallback(new 2(this));
    }
}
