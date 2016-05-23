package com.sherazkhilji.videffect.sample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.sherazkhilji.videffect.AutoFixEffect;
import com.sherazkhilji.videffect.BlackAndWhiteEffect;
import com.sherazkhilji.videffect.BrightnessEffect;
import com.sherazkhilji.videffect.ContrastEffect;
import com.sherazkhilji.videffect.CrossProcessEffect;
import com.sherazkhilji.videffect.DocumentaryEffect;
import com.sherazkhilji.videffect.DuotoneEffect;
import com.sherazkhilji.videffect.FillLightEffect;
import com.sherazkhilji.videffect.GrainEffect;
import com.sherazkhilji.videffect.GreyScaleEffect;
import com.sherazkhilji.videffect.InvertColorsEffect;
import com.sherazkhilji.videffect.LamoishEffect;
import com.sherazkhilji.videffect.NoEffect;
import com.sherazkhilji.videffect.PosterizeEffect;
import com.sherazkhilji.videffect.R;
import com.sherazkhilji.videffect.SaturationEffect;
import com.sherazkhilji.videffect.SepiaEffect;
import com.sherazkhilji.videffect.SharpnessEffect;
import com.sherazkhilji.videffect.TemperatureEffect;
import com.sherazkhilji.videffect.TintEffect;
import com.sherazkhilji.videffect.VignetteEffect;
import com.sherazkhilji.videffect.view.VideoSurfaceView;

public class SamplePlayerActivity extends Activity implements View.OnClickListener{

	private static final String TAG = "MediaPlayerSurfaceStubActivity";

	protected Resources mResources;

	private VideoSurfaceView mVideoView = null;
	private MediaPlayer mMediaPlayer = null;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	@SuppressLint("LongLogTag")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mResources = getResources();
		mMediaPlayer = new MediaPlayer();

		try {
			// Load video file from SD Card
			// File dir = Environment
			// .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			// File file = new File(dir,
			// "sample.mp4");
			// mMediaPlayer.setDataSource(file.getAbsolutePath());
			// -----------------------------------------------------------------------
			// Load video file from Assets directory
			AssetFileDescriptor afd = getAssets().openFd("sample.mp4");
			mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
		}
		// Initialize VideoSurfaceView using code
		// mVideoView = new VideoSurfaceView(this);
		// setContentView(mVideoView);
		// or
		setContentView(R.layout.activity_sampleplayer);
		mVideoView = (VideoSurfaceView) findViewById(R.id.mVideoSurfaceView);

		mVideoView.init(mMediaPlayer, new BlackAndWhiteEffect());
		//mVideoView.init(mMediaPlayer, new DuotoneEffect(Color.YELLOW, Color.RED));
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

		findViewById(R.id.AutoFixEffect).setOnClickListener(this);
		findViewById(R.id.BlackAndWhiteEffect).setOnClickListener(this);
		findViewById(R.id.BrightnessEffect).setOnClickListener(this);
		findViewById(R.id.ContrastEffect).setOnClickListener(this);
		findViewById(R.id.CrossProcessEffect).setOnClickListener(this);
		findViewById(R.id.DocumentaryEffect).setOnClickListener(this);
		findViewById(R.id.DuotoneEffect).setOnClickListener(this);
		findViewById(R.id.FillLightEffect).setOnClickListener(this);
		findViewById(R.id.GrainEffect).setOnClickListener(this);
		findViewById(R.id.GreyScaleEffect).setOnClickListener(this);
		findViewById(R.id.InvertColorsEffect).setOnClickListener(this);
		findViewById(R.id.LamoishEffect).setOnClickListener(this);
		findViewById(R.id.NoEffect).setOnClickListener(this);
		findViewById(R.id.PosterizeEffect).setOnClickListener(this);
		findViewById(R.id.SaturationEffect).setOnClickListener(this);
		findViewById(R.id.SepiaEffect).setOnClickListener(this);
		findViewById(R.id.SharpnessEffect).setOnClickListener(this);
		findViewById(R.id.TemperatureEffect).setOnClickListener(this);
		findViewById(R.id.TintEffect).setOnClickListener(this);
		findViewById(R.id.VignetteEffect).setOnClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();
		mVideoView.onResume();
	}

	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"SamplePlayer Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app URL is correct.

				Uri.parse("android-app://com.sherazkhilji.videffect/http/host/path")
		);
		AppIndex.AppIndexApi.start(client, viewAction);
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"SamplePlayer Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app URL is correct.
				Uri.parse("android-app://com.sherazkhilji.videffect.sample/http/host/path")
		);
		AppIndex.AppIndexApi.end(client, viewAction);
		client.disconnect();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case  R.id.AutoFixEffect:
				mVideoView.setEffect(new AutoFixEffect(0.8f));
				break;
			case  R.id.BlackAndWhiteEffect:
				mVideoView.setEffect(new BlackAndWhiteEffect());
				break;
			case  R.id.BrightnessEffect:
				mVideoView.setEffect(new BrightnessEffect(0.8f));
				break;
			case  R.id.ContrastEffect:
				mVideoView.setEffect(new ContrastEffect(0.8f));
				break;
			case  R.id.CrossProcessEffect:
				mVideoView.setEffect(new CrossProcessEffect());
				break;
			case  R.id.DocumentaryEffect:
				mVideoView.setEffect(new DocumentaryEffect());
				break;
			case  R.id.DuotoneEffect:
				mVideoView.setEffect(new DuotoneEffect(Color.GREEN,Color.RED));
				break;
			case  R.id.FillLightEffect:
				mVideoView.setEffect(new FillLightEffect(0.8f));
				break;
			case  R.id.GrainEffect:
				mVideoView.setEffect(new GrainEffect(0.8f));
				break;
			case  R.id.GreyScaleEffect:
				mVideoView.setEffect(new GreyScaleEffect());
				break;
			case  R.id.InvertColorsEffect:
				mVideoView.setEffect(new InvertColorsEffect());
				break;
			case  R.id.LamoishEffect:
				mVideoView.setEffect(new LamoishEffect());
				break;
			case  R.id.NoEffect:
				mVideoView.setEffect(new NoEffect());
				break;
			case  R.id.PosterizeEffect:
				mVideoView.setEffect(new PosterizeEffect());
				break;
			case  R.id.SaturationEffect:
				mVideoView.setEffect(new SaturationEffect(0.8f));
				break;
			case  R.id.SepiaEffect:
				mVideoView.setEffect(new SepiaEffect());
				break;
			case  R.id.SharpnessEffect:
				mVideoView.setEffect(new SharpnessEffect(0.8f));
				break;
			case  R.id.TemperatureEffect:
				mVideoView.setEffect(new TemperatureEffect(0.8f));
				break;
			case  R.id.TintEffect:
				mVideoView.setEffect(new TintEffect(Color.RED));
				break;
			case  R.id.VignetteEffect:
				mVideoView.setEffect(new VignetteEffect(0.8f));
				break;
		}


	}
}
