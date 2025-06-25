package com.QuizApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;
import android.graphics.Typeface;
import java.text.DecimalFormat;
import com.facebook.shimmer.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class QuizplayActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String key = "";
	private double question = 0;
	private String ans = "";
	private String selected = "";
	private double points = 0;
	private double played = 0;
	private double tq = 0;
	private String fontName = "";
	private String typeace = "";
	private double min = 0;
	private double s = 0;
	private boolean click = false;
	private double m = 0;
	private double n = 0;
	private double play = 0;
	private double ma = 0;
	private String time = "";
	
	private ArrayList<String> ls = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<String> ss = new ArrayList<>();
	private ArrayList<String> mmmmmmmmmm = new ArrayList<>();
	
	private LinearLayout background_layout;
	private LinearLayout linear18;
	private LinearLayout linear39;
	private LinearLayout linear19;
	private LinearLayout linear17;
	private ImageView imageview3;
	private TextView textview13;
	private LinearLayout linear49;
	private ImageView imageview5;
	private LinearLayout linear50;
	private LinearLayout linear33;
	private Button button2;
	private EditText edittext1;
	private EditText edittext2;
	private LinearLayout ssssssss;
	private LinearLayout linear24;
	private ProgressBar progressbar1;
	private TextView textview3;
	private LinearLayout linear23;
	private TextView textview6;
	private LinearLayout linear45;
	private LinearLayout linear22;
	private ImageView imageview1;
	private TextView textview15;
	private LinearLayout linear46;
	private LinearLayout linear32;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private TextView textview16;
	private TextView textview24;
	private RadioButton radiobutton1;
	private TextView textview17;
	private TextView textview25;
	private RadioButton radiobutton2;
	private TextView textview18;
	private TextView textview26;
	private RadioButton radiobutton3;
	private TextView textview4;
	private TextView textview27;
	private RadioButton radiobutton4;
	private Button buy;
	private TextView A;
	private TextView textview21;
	private TextView textview23;
	private TextView textview22;
	private TextView textview28;
	private TextView textview29;
	
	private DatabaseReference quizqq = _firebase.getReference("quizqq");
	private ChildEventListener _quizqq_child_listener;
	private Intent i = new Intent();
	private TimerTask t;
	private SharedPreferences h;
	private DatabaseReference allquiz = _firebase.getReference("allquiz");
	private ChildEventListener _allquiz_child_listener;
	private MediaPlayer mk;
	private TimerTask timerr;
	private SharedPreferences o;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.quizplay);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		background_layout = (LinearLayout) findViewById(R.id.background_layout);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview13 = (TextView) findViewById(R.id.textview13);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		button2 = (Button) findViewById(R.id.button2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		ssssssss = (LinearLayout) findViewById(R.id.ssssssss);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview15 = (TextView) findViewById(R.id.textview15);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		textview16 = (TextView) findViewById(R.id.textview16);
		textview24 = (TextView) findViewById(R.id.textview24);
		radiobutton1 = (RadioButton) findViewById(R.id.radiobutton1);
		textview17 = (TextView) findViewById(R.id.textview17);
		textview25 = (TextView) findViewById(R.id.textview25);
		radiobutton2 = (RadioButton) findViewById(R.id.radiobutton2);
		textview18 = (TextView) findViewById(R.id.textview18);
		textview26 = (TextView) findViewById(R.id.textview26);
		radiobutton3 = (RadioButton) findViewById(R.id.radiobutton3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview27 = (TextView) findViewById(R.id.textview27);
		radiobutton4 = (RadioButton) findViewById(R.id.radiobutton4);
		buy = (Button) findViewById(R.id.buy);
		A = (TextView) findViewById(R.id.A);
		textview21 = (TextView) findViewById(R.id.textview21);
		textview23 = (TextView) findViewById(R.id.textview23);
		textview22 = (TextView) findViewById(R.id.textview22);
		textview28 = (TextView) findViewById(R.id.textview28);
		textview29 = (TextView) findViewById(R.id.textview29);
		h = getSharedPreferences("h", Activity.MODE_PRIVATE);
		o = getSharedPreferences("o", Activity.MODE_PRIVATE);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(imageview3);
				timerr.cancel();
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				finish();
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(imageview5);
				if (click) {
					click = false;
					imageview5.setImageResource(R.drawable.volume_1);
					h.edit().putString("a", "1").commit();
				}
				else {
					click = true;
					imageview5.setImageResource(R.drawable.volume_2);
					h.edit().putString("a", "0").commit();
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				question = Double.parseDouble(edittext1.getText().toString());
				if (lm.get((int)question).containsKey("key")) {
					if (lm.get((int)question).get("key").toString().equals(key)) {
						tq = lm.size();
						textview6.setText(textview23.getText().toString().concat("/".concat(String.valueOf((long)(tq)))));
						if (lm.get((int)question).containsKey("question")) {
							textview3.setText(" س ".concat("".concat(textview23.getText().toString().concat(". ")).concat(lm.get((int)question).get("question").toString())));
							if (lm.get((int)question).containsKey("a")) {
								textview16.setText(lm.get((int)question).get("a").toString());
							}
							if (lm.get((int)question).containsKey("b")) {
								textview17.setText(lm.get((int)question).get("b").toString());
							}
							if (lm.get((int)question).containsKey("c")) {
								textview18.setText(lm.get((int)question).get("c").toString());
							}
							if (lm.get((int)question).containsKey("d")) {
								textview4.setText(lm.get((int)question).get("d").toString());
							}
							if (lm.get((int)question).containsKey("answer")) {
								ans = lm.get((int)question).get("answer").toString();
							}
						}
						else {
							
						}
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "key is not same");
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "key not found");
				}
				textview22.setText(lm.get((int)question).get("answer").toString());
				textview21.setText(String.valueOf((long)(100 / tq)));
				progressbar1.setProgress((int)Double.parseDouble(A.getText().toString()));
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
			}
		});
		
		textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton1.performClick();
			}
		});
		
		textview24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton1.performClick();
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				selected = "a";
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#45C9A5"), PorterDuff.Mode.SRC_IN);
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.setChecked(true);
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(false);
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton2.performClick();
			}
		});
		
		textview25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton2.performClick();
			}
		});
		
		radiobutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				selected = "b";
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#45C9A5"), PorterDuff.Mode.SRC_IN);
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(true);
				radiobutton3.setChecked(false);
			}
		});
		
		textview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton3.performClick();
			}
		});
		
		textview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton3.performClick();
			}
		});
		
		radiobutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				selected = "c";
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#45C9A5"), PorterDuff.Mode.SRC_IN);
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(true);
				radiobutton4.setChecked(false);
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton4.performClick();
			}
		});
		
		textview27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton4.performClick();
			}
		});
		
		radiobutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				selected = "d";
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#45C9A5"), PorterDuff.Mode.SRC_IN);
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(false);
				radiobutton4.setChecked(true);
			}
		});
		
		buy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (selected.equals("")) {
					_SketchproToast("اختر اجابة");
				}
				else {
					played++;
					if (h.getString("a", "").equals("1")) {
						if (selected.equals(ans)) {
							mk = MediaPlayer.create(getApplicationContext(), R.raw.success);
							mk.start();
							points = points + 1;
						}
						else {
							mk = MediaPlayer.create(getApplicationContext(), R.raw.error);
							mk.start();
						}
					}
					else {
						if (selected.equals(ans)) {
							points = points + 1;
						}
						else {
							
						}
					}
					if (played == tq) {
						i.setClass(getApplicationContext(), ResultsActivity.class);
						i.putExtra("key", key);
						i.putExtra("qna", String.valueOf((long)(points)));
						i.putExtra("rules", String.valueOf((long)(tq)));
						startActivity(i);
						finish();
					}
					else {
						if (selected.equals(ans)) {
							_answer();
						}
						else {
							final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(QuizplayActivity.this);
							
							View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.answer,null );
							bottomSheetDialog.setContentView(bottomSheetView);
							
							bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
							TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
							
							TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
							
							TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
							
							ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
							
							LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
							t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
							t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
							b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
							if (textview22.getText().toString().equals("a")) {
								t2.setText("\"".concat(textview16.getText().toString().concat("\"")));
							}
							if (textview22.getText().toString().equals("b")) {
								t2.setText("\"".concat(textview17.getText().toString().concat("\"")));
							}
							if (textview22.getText().toString().equals("c")) {
								t2.setText("\"".concat(textview18.getText().toString().concat("\"")));
							}
							if (textview22.getText().toString().equals("d")) {
								t2.setText("\"".concat(textview4.getText().toString().concat("\"")));
							}
							_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
							_rippleRoundStroke(b1, "#F5F5F5", "#E0E0E0", 15, 0, "#000000");
							b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									bottomSheetDialog.dismiss();
									_answer();
								}
							});
							bottomSheetDialog.setCanceledOnTouchOutside(false);
							bottomSheetDialog.setCancelable(false);
							bottomSheetDialog.show();
						}
					}
				}
				radiobutton1.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton2.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton3.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				radiobutton4.getButtonDrawable().setColorFilter(Color.parseColor("#EFEFEF"), PorterDuff.Mode.SRC_IN);
				progressbar1.setProgress((int)Double.parseDouble(A.getText().toString()));
			}
		});
		
		_quizqq_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("key")) {
					if (_childValue.get("key").toString().equals(key)) {
						ls.add(_childKey);
						lm.add(_childValue);
						button2.performClick();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		quizqq.addChildEventListener(_quizqq_child_listener);
		
		_allquiz_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("key")) {
					if (_childValue.get("key").toString().equals(getIntent().getStringExtra("key"))) {
						if (_childValue.containsKey("title")) {
							textview13.setText(_childValue.get("title").toString());
						}
						if (_childValue.containsKey("time")) {
							edittext2.setText(_childValue.get("time").toString());
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		allquiz.addChildEventListener(_allquiz_child_listener);
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_timer();
		textview29.setText(String.valueOf((long)(play)));
		key = getIntent().getStringExtra("key");
		points = 0;
		_rippleRoundStroke(linear22, "#FFF8F0", "#FFF8F0", 100, 0, "#FFF8F0");
		_rippleRoundStroke(linear46, "#FFFFFF", "#FFFFFF", 50, 3, "#EFEFEF");
		_Add("#282250", imageview3);
		_Add("#FFFDB257", imageview1);
		_changeActivityFont("bein");
		_Custom_Loading(true);
		background_layout.setVisibility(View.GONE);
		quizqq.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				lm = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						lm.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				m = Double.parseDouble(edittext2.getText().toString());
				_Custom_Loading(false);
				background_layout.setVisibility(View.VISIBLE);
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
		int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
		int clrs [] = {0xFF673AB7,0xFF5C27FE};
		SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, clrs);
		SketchUi.setCornerRadii(new float[]{
			d*100,d*100,d*100 ,d*100,d*100,d*100 ,d*100,d*100});
		android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF6200EA}), SketchUi, null);
		buy.setBackground(SketchUiRD);
		buy.setClickable(true);
		if (h.getString("a", "").equals("1")) {
			click = false;
			imageview5.setImageResource(R.drawable.volume_1);
		}
		else {
			click = true;
			imageview5.setImageResource(R.drawable.volume_2);
		}
	}
	
	@Override
	public void onBackPressed() {
		timerr.cancel();
		i.setClass(getApplicationContext(), HomeActivity.class);
		startActivity(i);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		finish();
	}
	public void _changeActivityFont (final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _UI_GradientLR (final View _view, final String _left, final String _right, final double _lt, final double _rt, final double _lb, final double _rb, final double _str, final String _str_color, final double _ele, final String _ripple) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clrs[] = new int[]{
			Color.parseColor(_left), Color.parseColor(_right)
		};
		gd.setColors(clrs);
		gd.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.TL_BR);
		gd.setStroke((int)_str, Color.parseColor(_str_color));
		gd.setCornerRadii(new float[] {(float)_lt, (float)_lt, (float)_rt, (float)_rt, (float)_rb, (float)_rb, (float)_lb, (float)_lb});
		_view.setElevation((int)_ele);
		android.content.res.ColorStateList clrbs = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_ripple)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrbs , gd, null);
		_view.setBackground(ripdrb);
	}
	
	
	public void _Add (final String _Colour, final ImageView _Imageview) {
		_Imageview.getDrawable().setColorFilter(Color.parseColor(_Colour), PorterDuff.Mode.SRC_IN);
	}
	
	
	public void _clickAnimation (final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _SketchproToast (final String _text) {
		LayoutInflater inflater = getLayoutInflater(); View toastL = inflater.inflate(R.layout.toat, null);
		
		//custom is the name of your custom view
		TextView txt1 = (TextView) toastL.findViewById(R.id.txt1);
		
		LinearLayout lin1 = (LinearLayout) toastL.findViewById(R.id.linear1);
		
		LinearLayout lin2 = (LinearLayout) toastL.findViewById(R.id.linear2);
		
		ImageView imgg1 = (ImageView) toastL.findViewById(R.id.imageview1);
		
		txt1.setText(_text);
		lin1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)22, Color.TRANSPARENT));
		lin2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)22, 0xFF000000));
		txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		Toast toast = new Toast(getApplicationContext()); 
		
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastL);
		toast.show();
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _Custom_Loading (final boolean _ifShow) {
		if (_ifShow) {
				if (coreprog == null){
						coreprog = new ProgressDialog(this);
						coreprog.setCancelable(false);
						coreprog.setCanceledOnTouchOutside(false);
						
						coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
				}
				coreprog.setMessage(null);
				coreprog.show();
				View _view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
				LinearLayout linear_base = (LinearLayout) _view.findViewById(R.id.linear_base);
				android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
				gd.setColor(Color.parseColor("#FFFFFF"));
				gd.setCornerRadius(100);
				linear_base.setBackground(gd);
				coreprog.setContentView(_view);
		}
		else {
				if (coreprog != null){
						coreprog.dismiss();
				}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _answer () {
		if (mmmmmmmmmm.contains(edittext1.getText().toString())) {
			_Random();
		}
		else {
			edittext1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(1), (int)(lm.size() - 1)))));
			mmmmmmmmmm.add(edittext1.getText().toString());
		}
		A.setText(String.valueOf((long)(Double.parseDouble(A.getText().toString()) + Double.parseDouble(textview21.getText().toString()))));
		textview23.setText(String.valueOf((long)(Double.parseDouble(textview23.getText().toString()) + 1)));
		textview28.setText(String.valueOf((long)(Double.parseDouble(textview28.getText().toString()) + 1)));
		question++;
		ans = "";
		selected = "";
		button2.performClick();
		radiobutton1.setChecked(false);
		radiobutton2.setChecked(false);
		radiobutton3.setChecked(false);
		radiobutton4.setChecked(false);
	}
	
	
	public void _Random () {
		edittext1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(1), (int)(lm.size() - 1)))));
		if (mmmmmmmmmm.contains(edittext1.getText().toString())) {
			_Random();
		}
		else {
			mmmmmmmmmm.add(edittext1.getText().toString());
		}
	}
	
	
	public void _timer () {
		timerr = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview15.setText(new DecimalFormat("0").format(m).concat("min").concat(" ".concat(new DecimalFormat("0").format(s).concat("s"))));
						if (s == 0) {
							if ((m == 0) && (s == 0)) {
								timerr.cancel();
								i.setClass(getApplicationContext(), ResultsActivity.class);
								i.putExtra("key", key);
								i.putExtra("qna", String.valueOf((long)(points)));
								i.putExtra("rules", String.valueOf((long)(tq)));
								startActivity(i);
								finish();
							}
							else {
								s = 59;
								m--;
							}
						}
						else {
							s--;
						}
						if (m == 0) {
							textview15.setText(" ".concat(new DecimalFormat("00").format(s).concat("s")));
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timerr, (int)(1000), (int)(1000));
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}