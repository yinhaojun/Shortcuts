package com.yinhaojun.shortcuts;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by victor on 2017/9/8.
 */

public class ShortcutUtils {

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void createDynamicShortcuts(Context context) {

        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        //需要先判断当前有多少个快捷方式
        int size = shortcutManager.getManifestShortcuts().size() + shortcutManager.getDynamicShortcuts().size();
        if (size >= 5) {
            Toast.makeText(context, "超过了限制，不能添加", Toast.LENGTH_SHORT).show();
        } else {
            ShortcutInfo shortCutId1 = new ShortcutInfo.Builder(context, "shortCutId3")
                    .setShortLabel("单个快捷方式")
                    .setLongLabel("单个快捷方式")
                    .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                    .setDisabledMessage("单个快捷方式不可用")
                    .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yinhaojun.com/"), context, MainActivity.class))
                    .build();
            shortcutManager.addDynamicShortcuts(Arrays.asList(shortCutId1));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void setDynamicShortcuts(Context context) {
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        ShortcutInfo shortcut = new ShortcutInfo.Builder(context, "id1")
                .setShortLabel("Web site")
                .setLongLabel("Open the web site")
                .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.yinhaojun.com/")))
                .build();
        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void setMultiShortcuts(Context context) {
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        List<ShortcutInfo> infos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //因为静态快捷方式占用了2个，不能超过5个
            ShortcutInfo shortcut = new ShortcutInfo.Builder(context, "" + i)
                    .setShortLabel("set Short lable:" + i)
                    .setLongLabel("set long lable:" + i)
                    .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.yinhaojun.com/")))
                    .build();
            infos.add(shortcut);
        }
        shortcutManager.setDynamicShortcuts(infos);
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void addBackStackShortcut(Context context) {

        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        //需要先判断当前有多少个快捷方式
        int size = shortcutManager.getManifestShortcuts().size() + shortcutManager.getDynamicShortcuts().size();
        if (size >= 5) {
            Toast.makeText(context, "超过了限制，不能添加", Toast.LENGTH_SHORT).show();
        } else {
            ShortcutInfo shortCutId1 = new ShortcutInfo.Builder(context, "shortCutId4")
                    .setShortLabel("多个intent快捷方式")
                    .setLongLabel("多个intent快捷方式")
                    .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                    .setDisabledMessage("多个intent快捷方式不可用")
                    .setIntents(new Intent[]{
                            new Intent(Intent.ACTION_MAIN, Uri.EMPTY, context, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                            new Intent(context, DynamicShortcutsActivity.class).setAction(Intent.ACTION_VIEW)})
                    .build();
            shortcutManager.addDynamicShortcuts(Arrays.asList(shortCutId1));
        }
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public void removeAllDynamicShortcuts(Context context) {
        //会移除所有的动态快捷方式
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        shortcutManager.removeAllDynamicShortcuts();
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public void removeDynamicShortcuts(Context context) {

        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        shortcutManager.removeDynamicShortcuts(Arrays.asList(new String[]{"shortCutId3" }));
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public void updateDynamicShortcuts(Context context) {

        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        for (ShortcutInfo shortcutInfo : shortcutManager.getDynamicShortcuts()) {
            if (shortcutInfo.getId().equals("shortCutId3"))
            {
                //如果存在就更新
                ShortcutInfo shortCutId1 = new ShortcutInfo.Builder(context, "shortCutId3")
                        .setShortLabel("更新单个快捷方式")
                        .setLongLabel("更新单个快捷方式")
                        .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                        .setDisabledMessage("更新单个快捷方式")
                        .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yinhaojun.com/"), context, MainActivity.class))
                        .build();
                shortcutManager.updateShortcuts(Arrays.asList(shortCutId1));
                break;
            }
        }
    }


}
