package com.example.endcallandclearcachedemo;

import com.example.endcallandclearcachedemo.clearcache.ClearCacheActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Intent endCallIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	// 开启拦截电话按键
	public void endcall(View v){
		endCallIntent = new Intent(MainActivity.this, EndCallService.class);
		startService(endCallIntent);
		Toast.makeText(getApplicationContext(), "开启电话拦截", Toast.LENGTH_SHORT).show();
	}
	// 停止拦截电话服务按键
	public void stopendcall(View v) {
		stopService(endCallIntent);
		Toast.makeText(getApplicationContext(), "关闭电话拦截", Toast.LENGTH_SHORT).show();
	}
	
	public void clearcache(View v){
		Intent intent = new Intent(MainActivity.this, ClearCacheActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (endCallIntent != null) {
			stopService(endCallIntent);
		}
		
	}

}
