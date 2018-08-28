package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.cmd.b.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI extends MMActivity implements OnItemClickListener {
    List<Map<String, String>> idD;
    ListView lPD;
    List<a> qyo;
    SimpleAdapter qyp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.qyo = b.cbo();
        this.idD = new ArrayList(this.qyo.size());
        for (a aVar : this.qyo) {
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, getString(aVar.qyt));
            this.idD.add(hashMap);
        }
        this.qyp = new SimpleAdapter(this, this.idD, f.mm_preference, new String[]{FFmpegMetadataRetriever.METADATA_KEY_TITLE}, new int[]{16908310});
        this.lPD = (ListView) findViewById(16908298);
        this.lPD.setAdapter(this.qyp);
        this.lPD.setOnItemClickListener(this);
    }

    protected final int getLayoutId() {
        return f.mm_preference_list_content;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = (a) this.qyo.get(i);
        if (aVar.qyu != null) {
            aVar.qyu.a(this, aVar.cfF.split(" +"));
        } else {
            b.be(this, aVar.cfF);
        }
    }
}
