package com.example.test;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView imageView1, imageView2, imageView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		
		// imageView1.setImageResource(R.drawable.ic_launcher);
		Uri uri = Uri
				.parse("android.resource://com.example.test/drawable/chrome");
		
		Uri uri2 = Uri
				.parse("android.resource://com.example.test/drawable/firefox");
		
		Uri uri3 = Uri
				.parse("android.resource://com.example.test/drawable/java");
		try {
			InputStream stream = getContentResolver().openInputStream(uri);
			BufferedInputStream bis = new BufferedInputStream(stream);
			Bitmap bitmap = BitmapFactory.decodeStream(bis);
			imageView1.setImageBitmap(bitmap);
			
			stream = getContentResolver().openInputStream(uri2);
			bis = new BufferedInputStream(stream);
			bitmap = BitmapFactory.decodeStream(bis);
			imageView2.setImageBitmap(bitmap);
			
			stream = getContentResolver().openInputStream(uri3);
			bis = new BufferedInputStream(stream);
			bitmap = BitmapFactory.decodeStream(bis);
			imageView3.setImageBitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
