package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> mtG = new HashMap();
    private OnClickListener iZP = new OnClickListener() {
        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.bjS == 0) {
                if (h.d(bVar.bOz, bVar.bJC)) {
                    x.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar.bJC);
                    intent.putExtra("record_xml", bVar.bXN);
                    intent.putExtra("record_data_id", bVar.bOz.jdM);
                    view.getContext().startActivity(intent);
                    return;
                }
                f Kr = n.getRecordMsgCDNStorage().Kr(h.e(bVar.bOz.jdM, bVar.bJC, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = Kr == null ? "null" : Integer.valueOf(Kr.field_status);
                x.i(str, str2, objArr);
                if (!(Kr == null || 2 == Kr.field_status || 3 == Kr.field_status)) {
                    if (4 == Kr.field_status) {
                        com.tencent.mm.ui.base.h.bA(view.getContext(), view.getResources().getString(R.l.favorite_record_video_error));
                        return;
                    } else if (Kr.field_status == 0 || 1 == Kr.field_status) {
                        return;
                    }
                }
                h.b(bVar.bOz, bVar.bJC, true);
            } else if (bVar.bjS == 1) {
                fz fzVar;
                x.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(bVar.msw.field_id), Long.valueOf(bVar.msw.field_localId), Integer.valueOf(bVar.msw.field_itemStatus)});
                if (bVar.msw.isDone()) {
                    fzVar = new fz();
                    fzVar.bOL.type = 14;
                    fzVar.bOL.bON = bVar.bOz;
                    a.sFg.m(fzVar);
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[]{Integer.valueOf(fzVar.bOM.ret)});
                    if (fzVar.bOM.ret == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bOz.jdM);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        return;
                    } else if (bi.oW(bVar.bOz.rzo)) {
                        x.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        return;
                    } else {
                        x.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar.msw.aLh() || bVar.msw.aLg()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar.msw.isDownloading() || bVar.msw.aLf()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    return;
                } else {
                    x.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                fzVar = new fz();
                fzVar.bOL.bJA = bVar.msw.field_localId;
                if (bVar.msw.aLg()) {
                    x.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    fzVar.bOL.type = 15;
                    a.sFg.m(fzVar);
                    return;
                }
                x.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                fzVar.bOL.type = 16;
                a.sFg.m(fzVar);
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a msR;

    public c(com.tencent.mm.plugin.record.ui.h.a aVar) {
        this.msR = aVar;
    }

    public final View eb(Context context) {
        View inflate = View.inflate(context, R.i.record_listitem_sight, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.h.image)).setDrawableWidth(com.tencent.mm.bp.a.fromDPToPix(context, GameJsApiLaunchApplication.CTRL_BYTE));
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        view.setTag(bVar);
        view.setOnClickListener(this.iZP);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.image);
        ImageView imageView = (ImageView) view.findViewById(R.h.status_btn);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
        aVar.setPosition(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.msR;
        Map map = mtG;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.bOz = cVar.bOz;
        String c;
        if (cVar.bjS == 0) {
            cVar2.msT = cVar.bJC;
            if (h.d(cVar.bOz, cVar.bJC)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = h.c(cVar.bOz, cVar.bJC);
                if (!c.equals(aVar.getVideoPath())) {
                    aVar.setThumbBmp(aVar2.a(cVar2));
                }
                aVar.aO(c, false);
                return;
            }
            f Kr = n.getRecordMsgCDNStorage().Kr(h.e(cVar.bOz.jdM, cVar.bJC, true));
            if (Kr == null || 2 == Kr.field_status) {
                imageView.setImageResource(R.k.shortvideo_play_btn);
            } else if (3 == Kr.field_status || 4 == Kr.field_status) {
                imageView.setImageResource(R.g.sight_chat_error);
            } else if (Kr.field_status == 0 || 1 == Kr.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) Kr.field_offset) / ((float) Math.max(1, Kr.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                return;
            } else {
                imageView.setImageResource(R.k.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
        } else if (cVar.bjS == 1) {
            map.put(cVar.bOz.jdM, view);
            x.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[]{Long.valueOf(cVar.msw.field_localId), Integer.valueOf(cVar.msw.field_itemStatus)});
            cVar2.msT = cVar.msw.field_localId;
            fz fzVar = new fz();
            fzVar.bOL.type = 14;
            fzVar.bOL.bON = cVar.bOz;
            a.sFg.m(fzVar);
            if (cVar.msw.isDone() || fzVar.bOM.ret == 1) {
                if (fzVar.bOM.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    fzVar.bOL.type = 2;
                    a.sFg.m(fzVar);
                    c = fzVar.bOM.path;
                    if (bi.oW(c)) {
                        x.w("MicroMsg.SightRecordData", "videoPath is null!");
                        return;
                    }
                    if (!c.equals(aVar.getVideoPath())) {
                        aVar.setThumbBmp(aVar2.a(cVar2));
                    }
                    aVar.aO(c, false);
                    return;
                } else if (bi.oW(cVar.bOz.rzo)) {
                    imageView.setImageResource(R.g.sight_chat_error);
                } else {
                    x.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.k.shortvideo_play_btn);
                }
            } else if (cVar.msw.aLh() || cVar.msw.aLg()) {
                imageView.setImageResource(R.k.shortvideo_play_btn);
            } else if (cVar.msw.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.cAt();
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                return;
            } else {
                x.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.k.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
        }
    }

    public final void destroy() {
        this.msR = null;
    }

    public final void pause() {
    }
}
