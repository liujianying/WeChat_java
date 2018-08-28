package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.ax.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a extends i<f> {
    public static final String[] diD = new String[]{i.a(f.dhO, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> jlO = new 1();

    public a(e eVar) {
        super(eVar, f.dhO, "MultiTalkInfo", null);
    }

    public final LinkedList<f> bgR() {
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
        LinkedList<f> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                f fVar = new f();
                fVar.field_wxGroupId = rawQuery.getString(0);
                fVar.field_groupId = rawQuery.getString(1);
                fVar.field_roomId = rawQuery.getInt(2);
                fVar.field_roomKey = rawQuery.getLong(3);
                fVar.field_routeId = rawQuery.getInt(4);
                fVar.field_createTime = rawQuery.getLong(5);
                x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", new Object[]{fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), Long.valueOf(fVar.field_createTime)});
                linkedList.add(fVar);
            } catch (Exception e) {
                x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(f fVar) {
        String str = fVar.field_wxGroupId;
        if (g.isEmpty(str)) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", new Object[]{str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime)});
        try {
            boolean b = b(fVar);
            x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + b + " for id=%s" + str);
            return b;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final boolean b(f fVar) {
        String str = fVar.field_wxGroupId;
        if (g.isEmpty(str)) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", new Object[]{str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state)});
        try {
            boolean c = c(fVar, new String[]{"wxGroupId"});
            x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + c + " for id=%s" + str);
            return c;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final f HO(String str) {
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", new Object[]{str});
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + str + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    f fVar = new f();
                    fVar.field_wxGroupId = rawQuery.getString(0);
                    fVar.field_groupId = rawQuery.getString(1);
                    fVar.field_roomId = rawQuery.getInt(2);
                    fVar.field_roomKey = rawQuery.getLong(3);
                    fVar.field_routeId = rawQuery.getInt(4);
                    fVar.field_inviteUserName = rawQuery.getString(5);
                    fVar.field_memberCount = rawQuery.getInt(6);
                    fVar.field_createTime = rawQuery.getLong(7);
                    fVar.field_state = rawQuery.getInt(8);
                    x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", new Object[]{fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state)});
                    if (rawQuery == null) {
                        return fVar;
                    }
                    rawQuery.close();
                    return fVar;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return null;
    }

    public final boolean jy(String str) {
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", new Object[]{str});
        try {
            super.fV("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = " + str);
            return false;
        }
    }
}
