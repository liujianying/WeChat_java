package com.tencent.mm.plugin.setting.ui.setting;

import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private ag mHandler;
    private int mTA = -1;
    private Ringtone mTB;
    private RingtoneManager mTx;
    LayoutInflater mTy;
    private int mTz = -1;
    private Cursor yV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ag();
        this.mTy = LayoutInflater.from(this);
        this.mTx = new RingtoneManager(this);
        this.mTx.setType(2);
        setVolumeControlStream(5);
        this.mTB = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle(i.settings_notification_ringtone_title);
        setBackBtn(new 1(this));
        a(0, getString(i.settings_language_save), new 2(this), b.tmX);
        ListView listView = (ListView) findViewById(f.settings_ringtone_picker_lv);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.LargePadding);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.yV = this.mTx.getCursor();
        listView.setAdapter(new a(this, this.yV));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String An = com.tencent.mm.k.f.An();
        if (An != com.tencent.mm.k.f.dgL) {
            int ringtonePosition = this.mTx.getRingtonePosition(Uri.parse(An));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.mTz = ringtonePosition;
            if (this.mTz == 1) {
                getSharedPreferences(ad.chY(), 0).edit().putString("settings.ringtone.name", getString(i.settings_notification_ringtone_sys)).commit();
                x.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.mTA = this.mTz - 1;
        } else {
            this.mTz = 1;
        }
        listView.setItemChecked(this.mTz, true);
        listView.setSelection(this.mTz);
    }

    protected final int getLayoutId() {
        return g.settings_ringtone_picker;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mHandler.removeCallbacks(this);
        this.mTA = i - 1;
        this.mHandler.postDelayed(this, 300);
    }

    public void run() {
        if (!isFinishing()) {
            Ringtone ringtone;
            if (this.mTA == 0) {
                ringtone = this.mTB;
            } else {
                ringtone = this.mTx.getRingtone(this.mTA - 1);
            }
            if (ringtone != null) {
                try {
                    ringtone.play();
                } catch (Throwable e) {
                    x.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
                }
            }
        }
    }

    protected void onStop() {
        this.mTx.stopPreviousRingtone();
        super.onStop();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacks(this);
        if (!(this.yV == null || this.yV.isClosed())) {
            this.yV.close();
            this.yV = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
