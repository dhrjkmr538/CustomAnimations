package com.animationlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.animationlib.searchanim.AnimationUtils;

public class SearchAnimActivity extends AppCompatActivity {

	private EditText mInputSearchEditText;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		initProgress();
		mInputSearchEditText =(EditText)findViewById(R.id.edit_text_search);
		mInputSearchEditText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					// Perform action on key press
					Toast.makeText(SearchAnimActivity.this, mInputSearchEditText.getText(), Toast.LENGTH_SHORT).show();
					AnimationUtils.collapse(mInputSearchEditText, new Animation.AnimationListener() {
						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							mProgressBar.setVisibility(View.VISIBLE);
						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}
					});
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * We can make progress update according to our requirement
	 * Custom progress can be defined here.
	 */
	private void initProgress(){
		mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}

}
