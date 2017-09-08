package com.yinhaojun.shortcuts;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.yinhaojun.shortcuts.R.id;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ShortcutUtils shortcutUtils = new ShortcutUtils();

        findViewById(id.addDynamicShortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shortcutUtils.createDynamicShortcuts(view.getContext());
            }
        });

        findViewById(id.setDynamicShortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.setDynamicShortcuts(view.getContext());
            }
        });

        findViewById(R.id.setMultiShortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.setMultiShortcuts(view.getContext());
            }
        });

        findViewById(R.id.addBackStackShortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.addBackStackShortcut(view.getContext());
            }
        });

        findViewById(id.removeAllDynamicShortcuts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.removeAllDynamicShortcuts(view.getContext());
            }
        });

        findViewById(id.removeDynamicShortcuts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.removeDynamicShortcuts(view.getContext());
            }
        });

        findViewById(id.updateDynamicShortcuts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutUtils.updateDynamicShortcuts(view.getContext());
            }
        });
    }

}
